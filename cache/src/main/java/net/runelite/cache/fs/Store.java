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
import java.util.List;
import java.util.Objects;
import net.runelite.cache.IndexType;
import net.runelite.cache.fs.jagex.DiskStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Store implements Closeable
{
	private static final Logger logger = LoggerFactory.getLogger(Store.class);

	private final Storage storage;
	private final List<Index> indexes = new ArrayList<>();

	public Store(File folder) throws IOException
	{
		storage = new DiskStorage(folder);
		storage.init(this);
	}

	public Store(Storage storage) throws IOException
	{
		this.storage = storage;

		storage.init(this);
	}

	public Storage getStorage()
	{
		return storage;
	}

	@Override
	public void close() throws IOException
	{
		storage.close();
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
			if (i.getId() == id)
			{
				throw new IllegalArgumentException("index " + id + " already exists");
			}
		}

		Index index = new Index(id);
		this.indexes.add(index);

		return index;
	}

	public void removeIndex(Index index)
	{
		assert indexes.contains(index);
		indexes.remove(index);
	}

	public void load() throws IOException
	{
		storage.load(this);
	}

	public void save() throws IOException
	{
		storage.save(this);
	}

	public List<Index> getIndexes()
	{
		return indexes;
	}

	public Index getIndex(IndexType type)
	{
		return findIndex(type.getNumber());
	}

	public Index findIndex(int id)
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
