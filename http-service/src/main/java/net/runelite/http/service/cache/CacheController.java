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

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
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
import net.runelite.http.api.cache.Cache;
import net.runelite.http.api.cache.CacheArchive;
import net.runelite.http.api.cache.CacheIndex;
import net.runelite.http.service.util.exception.NotFoundException;
import net.runelite.http.service.cache.beans.ArchiveEntry;
import net.runelite.http.service.cache.beans.CacheEntry;
import net.runelite.http.service.cache.beans.IndexEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
@Slf4j
public class CacheController
{
	@Autowired
	private CacheService cacheService;

	@RequestMapping("/")
	public List<Cache> listCaches()
	{
		return cacheService.listCaches().stream()
			.map(entry -> new Cache(entry.getId(), entry.getRevision(), entry.getDate()))
			.collect(Collectors.toList());
	}

	@RequestMapping("{cacheId}")
	public List<CacheIndex> listIndexes(@PathVariable int cacheId)
	{
		CacheEntry cache = cacheService.findCache(cacheId);
		if (cache == null)
		{
			throw new NotFoundException();
		}

		List<IndexEntry> indexes = cacheService.findIndexesForCache(cache);

		return indexes.stream()
			.map(entry -> new CacheIndex(entry.getIndexId(), entry.getRevision()))
			.collect(Collectors.toList());
	}

	@RequestMapping("{cacheId}/{indexId}")
	public List<CacheArchive> listArchives(@PathVariable int cacheId,
		@PathVariable int indexId)
	{
		CacheEntry cache = cacheService.findCache(cacheId);
		if (cache == null)
		{
			throw new NotFoundException();
		}

		IndexEntry indexEntry = cacheService.findIndexForCache(cache, indexId);
		if (indexEntry == null)
		{
			throw new NotFoundException();
		}

		List<ArchiveEntry> archives = cacheService.findArchivesForIndex(indexEntry);

		return archives.stream()
			.map(archive -> new CacheArchive(archive.getArchiveId(), archive.getNameHash(), archive.getRevision()))
			.collect(Collectors.toList());
	}

	@RequestMapping("{cacheId}/{indexId}/{archiveId}")
	public CacheArchive getCacheArchive(@PathVariable int cacheId,
		@PathVariable int indexId,
		@PathVariable int archiveId)
	{
		CacheEntry cache = cacheService.findCache(cacheId);
		if (cache == null)
		{
			throw new NotFoundException();
		}

		IndexEntry indexEntry = cacheService.findIndexForCache(cache, indexId);
		if (indexEntry == null)
		{
			throw new NotFoundException();
		}

		ArchiveEntry archiveEntry = cacheService.findArchiveForIndex(indexEntry, archiveId);
		if (archiveEntry == null)
		{
			throw new NotFoundException();
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
		CacheEntry cache = cacheService.findCache(cacheId);
		if (cache == null)
		{
			throw new NotFoundException();
		}

		IndexEntry indexEntry = cacheService.findIndexForCache(cache, indexId);
		if (indexEntry == null)
		{
			throw new NotFoundException();
		}

		ArchiveEntry archiveEntry = cacheService.findArchiveForIndex(indexEntry, archiveId);
		if (archiveEntry == null)
		{
			throw new NotFoundException();
		}

		return cacheService.getArchive(archiveEntry);
	}

	private ArchiveEntry findConfig(ConfigType config)
	{
		CacheEntry cache = cacheService.findMostRecent();
		if (cache == null)
		{
			throw new NotFoundException();
		}

		IndexEntry indexEntry = cacheService.findIndexForCache(cache, IndexType.CONFIGS.getNumber());
		if (indexEntry == null)
		{
			throw new NotFoundException();
		}

		ArchiveEntry archiveEntry = cacheService.findArchiveForIndex(indexEntry, config.getId());
		if (archiveEntry == null)
		{
			throw new NotFoundException();
		}

		return archiveEntry;
	}

	@RequestMapping("item/{itemId}")
	public ItemDefinition getItem(@PathVariable int itemId) throws IOException
	{
		ArchiveEntry archiveEntry = findConfig(ConfigType.ITEM);

		ArchiveFiles archiveFiles = cacheService.getArchiveFiles(archiveEntry);
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
		ArchiveEntry archiveEntry = findConfig(ConfigType.OBJECT);

		ArchiveFiles archiveFiles = cacheService.getArchiveFiles(archiveEntry);
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
		ArchiveEntry archiveEntry = findConfig(ConfigType.NPC);

		ArchiveFiles archiveFiles = cacheService.getArchiveFiles(archiveEntry);
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
