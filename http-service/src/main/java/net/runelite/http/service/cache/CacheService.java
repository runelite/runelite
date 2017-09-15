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
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.cache.ConfigType;
import net.runelite.cache.IndexType;
import net.runelite.cache.definitions.ItemDefinition;
import net.runelite.cache.definitions.NpcDefinition;
import net.runelite.cache.definitions.ObjectDefinition;
import net.runelite.cache.definitions.loaders.ItemLoader;
import net.runelite.cache.definitions.loaders.NpcLoader;
import net.runelite.cache.definitions.loaders.ObjectLoader;
import net.runelite.cache.fs.ArchiveFiles;
import net.runelite.cache.fs.FSFile;
import net.runelite.cache.fs.jagex.DataFile;
import net.runelite.cache.fs.jagex.DataFileReadResult;
import net.runelite.http.api.cache.Cache;
import net.runelite.http.api.cache.CacheArchive;
import net.runelite.http.api.cache.CacheIndex;
import net.runelite.http.service.util.exception.NotFoundException;
import net.runelite.http.service.cache.beans.ArchiveEntry;
import net.runelite.http.service.cache.beans.CacheEntry;
import net.runelite.http.service.cache.beans.FileEntry;
import net.runelite.http.service.cache.beans.IndexEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.xmlpull.v1.XmlPullParserException;

@RestController
@RequestMapping("/cache")
public class CacheService
{
	private static final Logger logger = LoggerFactory.getLogger(CacheService.class);

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
	 * @param indexId
	 * @param archiveId
	 * @param revision
	 * @return
	 */
	private byte[] getArchive(int indexId, int archiveId, int revision)
	{
		String path = new StringBuilder()
			.append(indexId)
			.append('/')
			.append(archiveId)
			.append('/')
			.append(revision)
			.toString();

		try (InputStream in = minioClient.getObject(minioBucket, path))
		{
			return ByteStreams.toByteArray(in);
		}
		catch (InvalidBucketNameException | NoSuchAlgorithmException | InsufficientDataException | IOException | InvalidKeyException | NoResponseException | XmlPullParserException | ErrorResponseException | InternalException | InvalidArgumentException ex)
		{
			logger.warn(null, ex);
			return null;
		}
	}

	private ArchiveFiles getArchiveFiles(IndexType index, ConfigType config,
		ArchiveEntry archiveEntry) throws IOException
	{
		List<FileEntry> files;

		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			files = cacheDao.findFilesForArchive(con, archiveEntry);
		}

		byte[] archiveData = getArchive(index.getNumber(), config.getId(), archiveEntry.getRevision());

		if (archiveData == null)
		{
			return null;
		}

		DataFileReadResult result = DataFile.decompress(archiveData, null);
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

	@RequestMapping("/")
	public List<Cache> listCaches()
	{
		List<CacheEntry> caches;
		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			caches = cacheDao.listCaches(con);
		}
		return caches.stream()
			.map(entry -> new Cache(entry.getId(), entry.getRevision(), entry.getDate()))
			.collect(Collectors.toList());
	}

	@RequestMapping("{cacheId}")
	public List<CacheIndex> listIndexes(@PathVariable int cacheId)
	{
		List<IndexEntry> indexes;

		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			CacheEntry cacheEntry = cacheDao.findCache(con, cacheId);
			if (cacheEntry == null)
			{
				throw new NotFoundException();
			}

			indexes = cacheDao.findIndexesForCache(con, cacheEntry);
		}

		return indexes.stream()
			.map(entry -> new CacheIndex(entry.getIndexId(), entry.getRevision()))
			.collect(Collectors.toList());
	}

	@RequestMapping("{cacheId}/{indexId}")
	public List<CacheArchive> listArchives(@PathVariable int cacheId,
		@PathVariable int indexId)
	{
		List<ArchiveEntry> archives;

		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			CacheEntry cacheEntry = cacheDao.findCache(con, cacheId);
			if (cacheEntry == null)
			{
				throw new NotFoundException();
			}

			IndexEntry indexEntry = cacheDao.findIndexForCache(con, cacheEntry, indexId);
			if (indexEntry == null)
			{
				throw new NotFoundException();
			}

			archives = cacheDao.findArchivesForIndex(con, indexEntry);
		}

		return archives.stream()
			.map(archive -> new CacheArchive(archive.getArchiveId(), archive.getNameHash(), archive.getRevision()))
			.collect(Collectors.toList());
	}

	@RequestMapping("{cacheId}/{indexId}/{archiveId}")
	public CacheArchive getCacheArchive(@PathVariable int cacheId,
		@PathVariable int indexId,
		@PathVariable int archiveId)
	{
		ArchiveEntry archiveEntry;
		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			CacheEntry cacheEntry = cacheDao.findCache(con, cacheId);
			if (cacheEntry == null)
			{
				throw new NotFoundException();
			}

			IndexEntry indexEntry = cacheDao.findIndexForCache(con, cacheEntry, indexId);
			if (indexEntry == null)
			{
				throw new NotFoundException();
			}

			archiveEntry = cacheDao.findArchiveForIndex(con, indexEntry, archiveId);
		}

		return new CacheArchive(archiveEntry.getArchiveId(),
			archiveEntry.getNameHash(), archiveEntry.getRevision());
	}

	@RequestMapping("{cacheId}/{indexId}/{archiveId}/data")
	public byte[] getArchiveData(
		@PathVariable int cacheId,
		@PathVariable int indexId,
		@PathVariable int archiveId
	)
	{
		ArchiveEntry archiveEntry;
		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			CacheEntry cacheEntry = cacheDao.findCache(con, cacheId);
			if (cacheEntry == null)
			{
				throw new NotFoundException();
			}

			IndexEntry indexEntry = cacheDao.findIndexForCache(con, cacheEntry, indexId);
			if (indexEntry == null)
			{
				throw new NotFoundException();
			}

			archiveEntry = cacheDao.findArchiveForIndex(con, indexEntry, archiveId);
		}

		return getArchive(indexId, archiveId, archiveEntry.getRevision());
	}

	@RequestMapping("item/{itemId}")
	public ItemDefinition getItem(@PathVariable int itemId) throws IOException
	{
		ArchiveEntry archiveEntry;
		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			archiveEntry = cacheDao.findMostRecentArchive(con, IndexType.CONFIGS.getNumber(), ConfigType.ITEM.getId());
			if (archiveEntry == null)
			{
				throw new NotFoundException();
			}
		}

		ArchiveFiles archiveFiles = getArchiveFiles(IndexType.CONFIGS, ConfigType.ITEM, archiveEntry);
		if (archiveFiles == null)
		{
			throw new NotFoundException();
		}

		FSFile file = archiveFiles.findFile(itemId);
		if (file == null)
		{
			throw new NotFoundException();
		}

		ItemDefinition itemdef = new ItemLoader().load(itemId, file.getContents());
		return itemdef;
	}

	@RequestMapping("object/{objectId}")
	public ObjectDefinition getObject(
		@PathVariable int objectId
	) throws IOException
	{
		ArchiveEntry archiveEntry;
		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			archiveEntry = cacheDao.findMostRecentArchive(con, IndexType.CONFIGS.getNumber(), ConfigType.OBJECT.getId());
			if (archiveEntry == null)
			{
				throw new NotFoundException();
			}
		}

		ArchiveFiles archiveFiles = getArchiveFiles(IndexType.CONFIGS, ConfigType.OBJECT, archiveEntry);
		if (archiveFiles == null)
		{
			throw new NotFoundException();
		}

		FSFile file = archiveFiles.findFile(objectId);
		if (file == null)
		{
			throw new NotFoundException();
		}

		ObjectDefinition objectdef = new ObjectLoader().load(objectId, file.getContents());
		return objectdef;
	}

	@RequestMapping("npc/{npcId}")
	public NpcDefinition getNpc(
		@PathVariable int npcId
	) throws IOException
	{
		ArchiveEntry archiveEntry;
		try (Connection con = sql2o.open())
		{
			CacheDAO cacheDao = new CacheDAO();
			archiveEntry = cacheDao.findMostRecentArchive(con, IndexType.CONFIGS.getNumber(), ConfigType.NPC.getId());
			if (archiveEntry == null)
			{
				throw new NotFoundException();
			}
		}

		ArchiveFiles archiveFiles = getArchiveFiles(IndexType.CONFIGS, ConfigType.NPC, archiveEntry);
		if (archiveFiles == null)
		{
			throw new NotFoundException();
		}

		FSFile file = archiveFiles.findFile(npcId);
		if (file == null)
		{
			throw new NotFoundException();
		}

		NpcDefinition npcdef = new NpcLoader().load(npcId, file.getContents());
		return npcdef;
	}
}
