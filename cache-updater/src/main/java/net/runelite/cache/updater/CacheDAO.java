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
package net.runelite.cache.updater;

import java.time.Instant;
import java.util.List;
import net.runelite.cache.updater.beans.ArchiveEntry;
import net.runelite.cache.updater.beans.CacheEntry;
import net.runelite.cache.updater.beans.IndexEntry;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.ResultSetIterable;

class CacheDAO
{
	// cache prepared statements for high volume queries
	private Query associateArchive;
	private Query findArchive, insertArchive;
	private Query associateFile;

	public CacheEntry findMostRecent(Connection con)
	{
		return con.createQuery("select id, revision, date from cache order by revision desc, date desc limit 1")
			.executeAndFetchFirst(CacheEntry.class);
	}

	public List<IndexEntry> findIndexesForCache(Connection con, CacheEntry cache)
	{
		return con.createQuery("select id, indexId, crc, revision from `index` where cache = :cache")
			.addParameter("cache", cache.getId())
			.executeAndFetch(IndexEntry.class);
	}

	public ResultSetIterable<ArchiveEntry> findArchivesForIndex(Connection con, IndexEntry indexEntry)
	{
		return con.createQuery("select archive.id, archive.archiveId, archive.nameHash,"
			+ " archive.crc, archive.revision, archive.hash from index_archive "
			+ "join archive on index_archive.archive = archive.id "
			+ "where index_archive.index = :id")
			.addParameter("id", indexEntry.getId())
			.executeAndFetchLazy(ArchiveEntry.class);
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

	public IndexEntry createIndex(Connection con, CacheEntry cache, int indexId, int crc, int revision)
	{
		int id = con.createQuery("insert into `index` (cache, indexId, crc, revision) values (:cache, :indexId, :crc, :revision)")
			.addParameter("cache", cache.getId())
			.addParameter("indexId", indexId)
			.addParameter("crc", crc)
			.addParameter("revision", revision)
			.executeUpdate()
			.getKey(int.class);

		IndexEntry entry = new IndexEntry();
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
			findArchive = con.createQuery("select distinct archive.id, archive.archiveId, archive.nameHash,"
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
