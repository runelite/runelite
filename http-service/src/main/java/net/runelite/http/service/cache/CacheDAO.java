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

import java.time.Instant;
import java.util.List;
import net.runelite.http.service.cache.beans.ArchiveEntry;
import net.runelite.http.service.cache.beans.CacheEntry;
import net.runelite.http.service.cache.beans.FileEntry;
import net.runelite.http.service.cache.beans.IndexEntry;
import org.sql2o.Connection;
import org.sql2o.Query;

public class CacheDAO
{
	// cache prepared statements for high volume queries
	private Query associateArchive;
	private Query findArchive, insertArchive;
	private Query associateFile;
	private Query findFilesForArchive;

	public List<CacheEntry> listCaches(Connection con)
	{
		return con.createQuery("select id, revision, date from cache")
			.executeAndFetch(CacheEntry.class);
	}

	public CacheEntry findMostRecent(Connection con)
	{
		return con.createQuery("select id from cache order by revision,date desc limit 1")
			.executeAndFetchFirst(CacheEntry.class);
	}

	public List<IndexEntry> findIndexesForCache(Connection con, CacheEntry cache)
	{
		return con.createQuery("select index.id, index.indexId, index.crc, index.revision from cache "
			+ "join cache_index on cache_index.cache = cache.id "
			+ "join `index` on cache_index.index = index.id "
			+ "where cache.id = :id "
			+ "order by index.indexId asc")
			.addParameter("id", cache.getId())
			.executeAndFetch(IndexEntry.class);
	}

	public IndexEntry findIndexForCache(Connection con, CacheEntry cache, int indexId)
	{
		return con.createQuery("select index.id, index.indexId, index.crc, index.revision from cache "
			+ "join cache_index on cache_index.cache = cache.id "
			+ "join `index` on cache_index.index = index.id "
			+ "where cache.id = :id "
			+ "and index.indexId = :indexId")
			.addParameter("id", cache.getId())
			.addParameter("indexId", indexId)
			.executeAndFetchFirst(IndexEntry.class);
	}

	public List<ArchiveEntry> findArchivesForIndex(Connection con, IndexEntry indexEntry)
	{
		return con.createQuery("select archive.id, archive.archiveId, archive.nameHash," +
			" archive.crc, archive.revision, archive.hash from index_archive "
			+ "join archive on index_archive.archive = archive.id "
			+ "where index_archive.index = :id")
			.addParameter("id", indexEntry.getId())
			.executeAndFetch(ArchiveEntry.class);
	}
	
	public ArchiveEntry findArchiveForIndex(Connection con, IndexEntry indexEntry, int archiveId)
	{
		return con.createQuery("select archive.id, archive.archiveId, archive.nameHash," +
			" archive.crc, archive.revision, archive.hash from index_archive "
			+ "join archive on index_archive.archive = archive.id "
			+ "where index_archive.index = :id "
			+ "and archive.archiveId = :archiveId")
			.addParameter("id", indexEntry.getId())
			.addParameter("archiveId", archiveId)
			.executeAndFetchFirst(ArchiveEntry.class);
	}

	/**
	 * Finds the most recent archive for the given indexId/archiveId
	 * @param con
	 * @param indexId
	 * @param archiveId
	 * @return 
	 */
	public ArchiveEntry findMostRecentArchive(Connection con, int indexId, int archiveId)
	{
		return con.createQuery("select archive.id, archive.archiveId, archive.nameHash," +
			" archive.crc, archive.revision, archive.hash from archive "
			+ "join index_archive on index_archive.archive = archive.id "
			+ "join `index` on index.id = index_archive.index "
			+ "where index.indexId = :indexId and archive.archiveId = :archiveId "
			+ "group by archive.id "
			+ "order by archive.revision desc "
			+ "limit 1")
			.addParameter("indexId", indexId)
			.addParameter("archiveId", archiveId)
			.executeAndFetchFirst(ArchiveEntry.class);
	}

	public List<FileEntry> findFilesForArchive(Connection con, ArchiveEntry archiveEntry)
	{
		if (findFilesForArchive == null)
		{
			findFilesForArchive = con.createQuery("select id, fileId, nameHash from file "
				+ "where archive = :archive");
		}

		return findFilesForArchive
			.addParameter("archive", archiveEntry.getId())
			.executeAndFetch(FileEntry.class);
	}

	public CacheEntry createCache(Connection con, int revision, Instant date)
	{
		int cacheId = con.createQuery("insert into cache (revision, date) values (:revision, :date)")
			.addParameter("revision", revision)
			.addParameter("date", date)
			.executeUpdate()
			.getKey(int.class);

		CacheEntry entry = new CacheEntry();
		entry.setId(cacheId);
		entry.setRevision(revision);
		entry.setDate(date);
		return entry;
	}
	
	public CacheEntry findCache(Connection con, int cacheId)
	{
		return con.createQuery("select id, revision, date from cache "
			+ "where id = :cacheId")
			.addParameter("cacheId", cacheId)
			.executeAndFetchFirst(CacheEntry.class);
	}

	public IndexEntry findIndex(Connection con, int indexId, int crc, int revision)
	{
		return con.createQuery("select id, indexId, crc, revision from `index` "
			+ "where indexId = :indexId "
			+ "and crc = :crc "
			+ "and revision = :revision")
			.addParameter("indexId", indexId)
			.addParameter("crc", crc)
			.addParameter("revision", revision)
			.executeAndFetchFirst(IndexEntry.class);
	}

	public void associateIndexToCache(Connection con, CacheEntry cache, IndexEntry index)
	{
		con.createQuery("insert into cache_index (cache, `index`) values (:cache, :index)")
			.addParameter("cache", cache.getId())
			.addParameter("index", index.getId())
			.executeUpdate();
	}

	public IndexEntry findOrCreateIndex(Connection con, CacheEntry cache, int indexId, int crc, int revision)
	{
		IndexEntry entry = con.createQuery("select id, indexId, crc, revision from `index`"
			+ "where indexId = :indexId "
			+ "and crc = :crc "
			+ "and revision = :revision")
			.addParameter("indexId", indexId)
			.addParameter("crc", crc)
			.addParameter("revision", revision)
			.executeAndFetchFirst(IndexEntry.class);

		if (entry != null)
		{
			return entry;
		}

		int id = con.createQuery("insert into `index` (indexId, crc, revision) values (:indexId, :crc, :revision)")
			.addParameter("indexId", indexId)
			.addParameter("crc", crc)
			.addParameter("revision", revision)
			.executeUpdate()
			.getKey(int.class);

		entry = new IndexEntry();
		entry.setId(id);
		entry.setIndexId(indexId);
		entry.setCrc(crc);
		entry.setRevision(revision);
		return entry;
	}

	public void associateArchiveToIndex(Connection con, ArchiveEntry archive, IndexEntry index)
	{
		if (associateArchive == null)
		{
			associateArchive = con.createQuery("insert into index_archive (`index`, archive) values (:index, :archive)");
		}
		associateArchive
			.addParameter("index", index.getId())
			.addParameter("archive", archive.getId())
			.executeUpdate();
	}

	public ArchiveEntry findArchive(Connection con, IndexEntry index,
		int archiveId, int nameHash, int crc, int revision)
	{
		if (findArchive == null)
		{
			findArchive = con.createQuery("select archive.id, archive.archiveId, archive.nameHash,"
				+ " archive.crc, archive.revision, archive.hash from archive "
				+ " join index_archive on index_archive.archive = archive.id"
				+ " join `index` on index.id = index_archive.index"
				+ " where archive.archiveId = :archiveId"
				+ " and archive.nameHash = :nameHash"
				+ " and archive.crc = :crc"
				+ " and archive.revision = :revision"
				+ " and index.indexId = :indexId");
		}

		ArchiveEntry entry = findArchive
			.addParameter("archiveId", archiveId)
			.addParameter("nameHash", nameHash)
			.addParameter("crc", crc)
			.addParameter("revision", revision)
			.addParameter("indexId", index.getIndexId())
			.executeAndFetchFirst(ArchiveEntry.class);
		return entry;
	}

	public ArchiveEntry createArchive(Connection con, IndexEntry index,
		int archiveId, int nameHash, int crc, int revision, byte[] hash)
	{
		if (insertArchive == null)
		{
			insertArchive = con.createQuery("insert into archive (archiveId, nameHash, crc, revision, hash) values "
				+ "(:archiveId, :nameHash, :crc, :revision, :hash)");
		}

		int id = insertArchive
			.addParameter("archiveId", archiveId)
			.addParameter("nameHash", nameHash)
			.addParameter("crc", crc)
			.addParameter("revision", revision)
			.addParameter("hash", hash)
			.executeUpdate()
			.getKey(int.class);

		ArchiveEntry entry = new ArchiveEntry();
		entry.setId(id);
		entry.setArchiveId(archiveId);
		entry.setNameHash(nameHash);
		entry.setCrc(crc);
		entry.setRevision(revision);
		entry.setHash(hash);
		return entry;
	}

	public void associateFileToArchive(Connection con, ArchiveEntry archive, int fileId, int nameHash)
	{
		if (associateFile == null)
		{
			associateFile = con.createQuery("insert into file (archive, fileId, nameHash) values (:archive, :fileId, :nameHash)");
		}
		associateFile
			.addParameter("archive", archive.getId())
			.addParameter("fileId", fileId)
			.addParameter("nameHash", nameHash)
			.executeUpdate();
	}
}
