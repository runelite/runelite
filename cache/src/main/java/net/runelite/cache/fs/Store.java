/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.cache.fs;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import net.runelite.cache.IndexType;
import net.runelite.cache.util.XteaKeyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Store implements Closeable
{
	private static final Logger logger = LoggerFactory.getLogger(Store.class);

	private static final String MAIN_FILE_CACHE_DAT = "main_file_cache.dat2";
	private static final String MAIN_FILE_CACHE_IDX = "main_file_cache.idx";

	private final File folder;
	private final DataFile data;
	private final IndexFile index255;
	private final List<Index> indexes = new ArrayList<>();

	public Store(File folder) throws IOException
	{
		this.folder = folder;

		data = new DataFile(this, new File(folder, MAIN_FILE_CACHE_DAT));
		index255 = new IndexFile(this, 255, new File(folder, MAIN_FILE_CACHE_IDX + "255"));

		for (int i = 0; i < index255.getIndexCount(); ++i)
		{
			this.addIndex(i);
		}

		Index maps = this.findIndex(IndexType.MAPS.getNumber());
		if (maps != null)
		{
			XteaKeyManager mapKeys = new XteaKeyManager();
			mapKeys.loadKeys();
			maps.setXteaManager(mapKeys);
		}
	}

	@Override
	public void close() throws IOException
	{
		data.close();
		index255.close();
		for (Index i : indexes)
		{
			i.close();
		}
	}

	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 79 * hash + Objects.hashCode(this.indexes);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final Store other = (Store) obj;
		if (!Objects.equals(this.indexes, other.indexes))
		{
			return false;
		}
		return true;
	}

	public final Index addIndex(int id) throws FileNotFoundException
	{
		for (Index i : indexes)
		{
			if (i.getIndex().getIndexFileId() == id)
			{
				throw new IllegalArgumentException("index " + id + " already exists");
			}
		}

		IndexFile indexFile = new IndexFile(this, id, new File(folder, MAIN_FILE_CACHE_IDX + id));
		Index index = new Index(this, indexFile, id);

		this.indexes.add(index);

		return index;
	}

	public void removeIndex(Index index)
	{
		assert indexes.contains(index);
		indexes.remove(index);
	}

	/*
	 * we rebuild data differently, so the CRCs aren't right.
	 * rebuild them.
	 */
	public void rebuildCrc() throws IOException
	{
		for (Index i : indexes)
			i.rebuildCrc();
	}

	public void load() throws IOException
	{
		for (Index i : indexes)
		{
			i.load();
		}
	}

	public void save() throws IOException
	{
		logger.debug("Clearing data and indexes in preparation for store save");

		data.clear();

		for (Index i : indexes)
		{
			i.clear();
		}

		for (Index i : indexes)
		{
			i.save();
		}
	}

	public void saveTree(java.io.File to) throws IOException
	{
		for (Index i : indexes)
		{
			i.saveTree(to);
		}
	}

	public void loadTree(java.io.File from) throws IOException
	{
		for (java.io.File idx : from.listFiles())
		{
			if (!idx.isDirectory())
			{
				continue;
			}

			int id = Integer.parseInt(idx.getName());
			IndexFile indexFile = new IndexFile(this, id, new File(folder, MAIN_FILE_CACHE_IDX + id));
			Index index = new Index(this, indexFile, id);
			index.loadTree(from, idx);
			indexes.add(index);
		}

		Collections.sort(indexes, (idx1, idx2) -> Integer.compare(idx1.getId(), idx2.getId()));
	}

	public DataFile getData()
	{
		return data;
	}

	public IndexFile getIndex255()
	{
		return index255;
	}

	public List<Index> getIndexes()
	{
		return indexes;
	}

	public Index getIndex(IndexType type)
	{
		return indexes.get(type.getNumber());
	}

	public final Index findIndex(int id)
	{
		for (Index i : indexes)
		{
			if (i.getId() == id)
			{
				return i;
			}
		}
		return null;
	}
}
