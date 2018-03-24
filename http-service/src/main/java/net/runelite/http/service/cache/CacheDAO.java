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

import java.util.List;
import net.runelite.cache.IndexType;
import net.runelite.http.service.cache.beans.ArchiveEntry;
import net.runelite.http.service.cache.beans.CacheEntry;
import net.runelite.http.service.cache.beans.FileEntry;
import net.runelite.http.service.cache.beans.IndexEntry;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.ResultSetIterable;

class CacheDAO
{
	public List<CacheEntry> listCaches(Connection con)
	{
		return con.createQuery("select id, revision, date from cache")
			.executeAndFetch(CacheEntry.class);
	}

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

	public IndexEntry findIndexForCache(Connection con, CacheEntry cache, int indexId)
	{
		return con.createQuery("select id, indexId, crc, revision from `index` "
			+ "where cache = :id "
			+ "and indexId = :indexId")
			.addParameter("id", cache.getId())
			.addParameter("indexId", indexId)
			.executeAndFetchFirst(IndexEntry.class);
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

	public ArchiveEntry findArchiveForIndex(Connection con, IndexEntry indexEntry, int archiveId)
	{
		return con.createQuery("select archive.id, archive.archiveId, archive.nameHash,"
			+ " archive.crc, archive.revision, archive.hash from index_archive "
			+ "join archive on index_archive.archive = archive.id "
			+ "where index_archive.index = :id "
			+ "and archive.archiveId = :archiveId")
			.addParameter("id", indexEntry.getId())
			.addParameter("archiveId", archiveId)
			.executeAndFetchFirst(ArchiveEntry.class);
	}

	public ArchiveEntry findArchiveByName(Connection con, CacheEntry cache, IndexType index, int nameHash)
	{
		return con.createQuery("select archive.id, archive.archiveId, archive.nameHash,"
			+ " archive.crc, archive.revision, archive.hash from archive "
			+ "join index_archive on index_archive.archive = archive.id "
			+ "join `index` on index.id = index_archive.index "
			+ "where index.cache = :cacheId "
			+ "and index.indexId = :indexId "
			+ "and archive.nameHash = :nameHash "
			+ "limit 1")
			.addParameter("cacheId", cache.getId())
			.addParameter("indexId", index.getNumber())
			.addParameter("nameHash", nameHash)
			.executeAndFetchFirst(ArchiveEntry.class);
	}

	public ResultSetIterable<FileEntry> findFilesForArchive(Connection con, ArchiveEntry archiveEntry)
	{
		Query findFilesForArchive = con.createQuery("select id, fileId, nameHash from file "
			+ "where archive = :archive");

		return findFilesForArchive
			.addParameter("archive", archiveEntry.getId())
			.executeAndFetchLazy(FileEntry.class);
	}

	public CacheEntry findCache(Connection con, int cacheId)
	{
		return con.createQuery("select id, revision, date from cache "
			+ "where id = :cacheId")
			.addParameter("cacheId", cacheId)
			.executeAndFetchFirst(CacheEntry.class);
	}
}
