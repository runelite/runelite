/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.http.service.cache;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import java.io.IOException;
import java.time.Instant;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.cache.client.CacheClient;
import net.runelite.cache.client.DownloadWatcher;
import net.runelite.cache.client.IndexInfo;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Store;
import net.runelite.cache.index.FileData;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.service.cache.beans.ArchiveEntry;
import net.runelite.http.service.cache.beans.CacheEntry;
import net.runelite.http.service.cache.beans.IndexEntry;
import net.runelite.protocol.api.login.HandshakeResponseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@RestController
@RequestMapping("/cache/admin")
public class CacheUpdater
{
	private static final Logger logger = LoggerFactory.getLogger(CacheUpdater.class);

	private final Sql2o sql2o;
	private final MinioClient minioClient;

	@Value("${minio.bucket}")
	private String minioBucket;

	@Autowired
	public CacheUpdater(
		@Qualifier("Runelite Cache SQL2O") Sql2o sql2o,
		MinioClient minioClient
	)
	{
		this.sql2o = sql2o;
		this.minioClient = minioClient;
	}

	@RequestMapping("/update")
	public void check() throws IOException, InvalidEndpointException, InvalidPortException, InterruptedException
	{
		int rsVersion = RuneLiteAPI.getRsVersion();

		try (Connection con = sql2o.beginTransaction())
		{
			CacheDAO cacheDao = new CacheDAO();
			CacheEntry cache = cacheDao.findMostRecent(con);
			boolean created = false;
			if (cache == null)
			{
				created = true;
				cache = cacheDao.createCache(con, rsVersion, Instant.now());
			}

			CacheStorage storage = new CacheStorage(cache, cacheDao, con);
			Store store = new Store(storage);
			store.load();

			ExecutorService executor = Executors.newSingleThreadExecutor();

			CacheEntry newCache = created ? cache : cacheDao.createCache(con, rsVersion, Instant.now());

			CacheClient client = new CacheClient(store, rsVersion, new DownloadWatcher()
			{
				private final Map<Index, IndexEntry> indexEntryMap = new IdentityHashMap<>();

				@Override
				public void indexComplete(Index index)
				{
					IndexEntry entry = cacheDao.findOrCreateIndex(con, newCache, index.getId(), index.getCrc(), index.getRevision());
					// this assumes nothing is associated to the cache yet
					cacheDao.associateIndexToCache(con, newCache, entry);
					indexEntryMap.put(index, entry);
				}

				@Override
				public void alreadyUpToDate(Archive archive)
				{
					updateArchive(archive);
				}

				@Override
				public void downloadComplete(Archive archive, byte[] data)
				{
					executor.submit(new CacheUploader(minioClient, minioBucket, archive, data));
					updateArchive(archive);
				}

				private void updateArchive(Archive archive)
				{
					IndexEntry entry = indexEntryMap.get(archive.getIndex());
					ArchiveEntry archiveEntry = cacheDao.findArchive(con, entry, archive.getArchiveId(),
						archive.getNameHash(), archive.getCrc(), archive.getRevision());
					if (archiveEntry == null)
					{
						byte[] hash = archive.getHash();
						archiveEntry = cacheDao.createArchive(con, entry, archive.getArchiveId(),
							archive.getNameHash(), archive.getCrc(), archive.getRevision(), hash);

						for (FileData file : archive.getFileData())
						{
							cacheDao.associateFileToArchive(con, archiveEntry, file.getId(), file.getNameHash());
						}
					}
					cacheDao.associateArchiveToIndex(con, archiveEntry, entry);

					archive.setFileData(null); // don't need this anymore
				}
			});

			client.connect();
			HandshakeResponseType result = client.handshake().join();

			if (result != HandshakeResponseType.RESPONSE_OK)
			{
				throw new OutOfDateException();
			}

			List<IndexInfo> indexes = client.requestIndexes();
			List<IndexEntry> entries = cacheDao.findIndexesForCache(con, cache);

			if (!checkOutOfDate(indexes, entries))
			{
				logger.info("All up to date.");
				return;
			}

			client.download();

			// ensure objects are added to the store before they become
			// visible in the database
			executor.shutdown();
			while (!executor.awaitTermination(1, TimeUnit.SECONDS))
			{
				logger.debug("Waiting for termination of executor...");
			}

			// commit database
			con.commit();
		}
	}

	private boolean checkOutOfDate(List<IndexInfo> indexes, List<IndexEntry> dbIndexes)
	{
		if (indexes.size() != dbIndexes.size())
		{
			return true;
		}

		for (int i = 0; i < indexes.size(); ++i)
		{
			IndexInfo ii = indexes.get(i);
			IndexEntry ie = dbIndexes.get(i);

			if (ii.getId() != ie.getIndexId()
				|| ii.getRevision() != ie.getRevision()
				|| ii.getCrc() != ie.getCrc())
			{
				return true;
			}
		}

		return false;
	}

}
