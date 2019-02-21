/*
 * Copyright (c) 2017-2018, Adam <Adam@sigterm.info>
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

import com.google.common.collect.Iterables;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteStreams;
import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidArgumentException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import io.minio.errors.NoResponseException;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.runelite.cache.ConfigType;
import net.runelite.cache.IndexType;
import net.runelite.cache.definitions.ItemDefinition;
import net.runelite.cache.definitions.loaders.ItemLoader;
import net.runelite.cache.fs.ArchiveFiles;
import net.runelite.cache.fs.Container;
import net.runelite.cache.fs.FSFile;
import net.runelite.http.service.cache.beans.ArchiveEntry;
import net.runelite.http.service.cache.beans.CacheEntry;
import net.runelite.http.service.cache.beans.FileEntry;
import net.runelite.http.service.cache.beans.IndexEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.ResultSetIterable;
import org.sql2o.Sql2o;
import org.xmlpull.v1.XmlPullParserException;

@Service
@Slf4j
public class CacheService
{
	@Autowired
	@Qualifier("Runelite Cache SQL2O")
	private Sql2o sql2o;

	@Value("${minio.bucket}")
	private String minioBucket;

	private final MinioClient minioClient;

	@Autowired
	public CacheService(
		@Value("${minio.endpoint}") String minioEndpoint,
		@Value("${minio.accesskey}") String accessKey,
		@Value("${minio.secretkey}") String secretKey
	) throws InvalidEndpointException, InvalidPortException
	{
		this.minioClient = new MinioClient(minioEndpoint, accessKey, secretKey);
	}

	@Bean
	public MinioClient minioClient()
	{
		return minioClient;
	}

	/**
	 * retrieve archive from storage
	 *
	 * @param archiveEntry
	 * @return
	 */
	public byte[] getArchive(ArchiveEntry archiveEntry)
	{
		String hashStr = BaseEncoding.base16().encode(archiveEntry.getHash());
		String path = new StringBuilder()
			.append(hashStr.substring(0, 2))
			.append('/')
			.append(hashStr.substring(2))
			.toString();

		try (InputStream in = minioClient.getObject(minioBucket, path))
		{
			return ByteStreams.toByteArray(in);
		}
		catch (InvalidBucketNameException | NoSuchAlgorithmException | InsufficientDataException
			| IOException | InvalidKeyException | NoResponseException | XmlPullParserException
			| ErrorResponseException | InternalException | InvalidArgumentException ex)
		{
			log.warn(null, ex);
			return null;
		}
	}

	public ArchiveFiles getArchiveFiles(ArchiveEntry archiveEntry) throws IOException
	{
		CacheDAO cacheDao = new CacheDAO();

		try (Connection con = sql2o.open();
			ResultSetIterable<FileEntry> files = cacheDao.findFilesForArchive(con, archiveEntry))
		{
			byte[] archiveData = getArchive(archiveEntry);

			if (archiveData == null)
			{
				return null;
			}

			Container result = Container.decompress(archiveData, null);
			if (result == null)
			{
				return null;
			}

			byte[] decompressedData = result.data;

			ArchiveFiles archiveFiles = new ArchiveFiles();
			for (FileEntry fileEntry : files)
			{
				FSFile file = new FSFile(fileEntry.getFileId());
				archiveFiles.addFile(file);
				file.setNameHash(fileEntry.getNameHash());
			}
			archiveFiles.loadContents(decompressedData);
			return archiveFiles;
		}
	}

	public List<CacheEntry> listCaches()
	{
		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			return cacheDao.listCaches(con);
		}
	}

	public CacheEntry findCache(int cacheId)
	{
		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			return cacheDao.findCache(con, cacheId);
		}
	}

	public CacheEntry findMostRecent()
	{
		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			return cacheDao.findMostRecent(con);
		}
	}

	public List<IndexEntry> findIndexesForCache(CacheEntry cacheEntry)
	{
		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			return cacheDao.findIndexesForCache(con, cacheEntry);
		}
	}

	public IndexEntry findIndexForCache(CacheEntry cahceEntry, int indexId)
	{
		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			return cacheDao.findIndexForCache(con, cahceEntry, indexId);
		}
	}

	public List<ArchiveEntry> findArchivesForIndex(IndexEntry indexEntry)
	{
		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			ResultSetIterable<ArchiveEntry> archiveEntries = cacheDao.findArchivesForIndex(con, indexEntry);
			List<ArchiveEntry> archives = new ArrayList<>();
			Iterables.addAll(archives, archiveEntries);
			return archives;
		}
	}

	public ArchiveEntry findArchiveForIndex(IndexEntry indexEntry, int archiveId)
	{
		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			return cacheDao.findArchiveForIndex(con, indexEntry, archiveId);
		}
	}

	public ArchiveEntry findArchiveForTypeAndName(CacheEntry cache, IndexType index, int nameHash)
	{
		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			return cacheDao.findArchiveByName(con, cache, index, nameHash);
		}
	}

	public List<ItemDefinition> getItems() throws IOException
	{
		CacheEntry cache = findMostRecent();
		if (cache == null)
		{
			return Collections.emptyList();
		}

		IndexEntry indexEntry = findIndexForCache(cache, IndexType.CONFIGS.getNumber());
		ArchiveEntry archiveEntry = findArchiveForIndex(indexEntry, ConfigType.ITEM.getId());
		ArchiveFiles archiveFiles = getArchiveFiles(archiveEntry);
		final ItemLoader itemLoader = new ItemLoader();
		final List<ItemDefinition> result = new ArrayList<>(archiveFiles.getFiles().size());
		for (FSFile file : archiveFiles.getFiles())
		{
			ItemDefinition itemDef = itemLoader.load(file.getFileId(), file.getContents());
			result.add(itemDef);
		}
		return result;
	}
}
