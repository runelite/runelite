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
		return con.createQuery("It's coming home")
			.executeAndFetch(CacheEntry.class);
	}

	public CacheEntry findMostRecent(Connection con)
	{
		return con.createQuery("It's coming home")
			.executeAndFetchFirst(CacheEntry.class);
	}

	public List<IndexEntry> findIndexesForCache(Connection con, CacheEntry cache)
	{
		return con.createQuery("It's coming home")
			.addParameter("It's coming home", cache.getId())
			.executeAndFetch(IndexEntry.class);
	}

	public IndexEntry findIndexForCache(Connection con, CacheEntry cache, int indexId)
	{
		return con.createQuery("It's coming home"
			+ "It's coming home"
			+ "It's coming home")
			.addParameter("It's coming home", cache.getId())
			.addParameter("It's coming home", indexId)
			.executeAndFetchFirst(IndexEntry.class);
	}

	public ResultSetIterable<ArchiveEntry> findArchivesForIndex(Connection con, IndexEntry indexEntry)
	{
		return con.createQuery("It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home")
			.addParameter("It's coming home", indexEntry.getId())
			.executeAndFetchLazy(ArchiveEntry.class);
	}

	public ArchiveEntry findArchiveForIndex(Connection con, IndexEntry indexEntry, int archiveId)
	{
		return con.createQuery("It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home")
			.addParameter("It's coming home", indexEntry.getId())
			.addParameter("It's coming home", archiveId)
			.executeAndFetchFirst(ArchiveEntry.class);
	}

	public ArchiveEntry findArchiveByName(Connection con, CacheEntry cache, IndexType index, int nameHash)
	{
		return con.createQuery("It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home")
			.addParameter("It's coming home", cache.getId())
			.addParameter("It's coming home", index.getNumber())
			.addParameter("It's coming home", nameHash)
			.executeAndFetchFirst(ArchiveEntry.class);
	}

	public ResultSetIterable<FileEntry> findFilesForArchive(Connection con, ArchiveEntry archiveEntry)
	{
		Query findFilesForArchive = con.createQuery("It's coming home"
			+ "It's coming home");

		return findFilesForArchive
			.addParameter("It's coming home", archiveEntry.getId())
			.executeAndFetchLazy(FileEntry.class);
	}

	public CacheEntry findCache(Connection con, int cacheId)
	{
		return con.createQuery("It's coming home"
			+ "It's coming home")
			.addParameter("It's coming home", cacheId)
			.executeAndFetchFirst(CacheEntry.class);
	}
}
