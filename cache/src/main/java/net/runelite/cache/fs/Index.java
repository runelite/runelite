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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.runelite.cache.index.ArchiveData;
import net.runelite.cache.index.FileData;
import net.runelite.cache.index.IndexData;
import net.runelite.cache.util.Djb2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Index
{
	private static final Logger logger = LoggerFactory.getLogger(Index.class);

	private final int id;

	private int protocol = 6;
	private boolean named = true;
	private int revision;
	private int crc;
	private int compression; // compression method of this index's data in 255

	private final List<Archive> archives = new ArrayList<>();

	public Index(int id)
	{
		this.id = id;
	}

	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 97 * hash + this.id;
		hash = 97 * hash + this.revision;
		hash = 97 * hash + Objects.hashCode(this.archives);
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
		final Index other = (Index) obj;
		if (this.id != other.id)
		{
			return false;
		}
		if (this.revision != other.revision)
		{
			return false;
		}
		if (!Objects.equals(this.archives, other.archives))
		{
			return false;
		}
		return true;
	}

	public int getId()
	{
		return id;
	}

	public int getProtocol()
	{
		return protocol;
	}

	public void setProtocol(int protocol)
	{
		this.protocol = protocol;
	}

	public boolean isNamed()
	{
		return named;
	}

	public void setNamed(boolean named)
	{
		this.named = named;
	}

	public int getRevision()
	{
		return revision;
	}

	public void setRevision(int revision)
	{
		this.revision = revision;
	}

	public int getCrc()
	{
		return crc;
	}

	public void setCrc(int crc)
	{
		this.crc = crc;
	}

	public int getCompression()
	{
		return compression;
	}

	public void setCompression(int compression)
	{
		this.compression = compression;
	}

	public List<Archive> getArchives()
	{
		return archives;
	}

	public Archive addArchive(int id)
	{
		Archive archive = new Archive(this, id);
		this.archives.add(archive);
		return archive;
	}

	public Archive getArchive(int id)
	{
		for (Archive a : archives)
		{
			if (a.getArchiveId() == id)
			{
				return a;
			}
		}
		return null;
	}

	public Archive findArchiveByName(String name)
	{
		int hash = Djb2.hash(name);
		for (Archive a : archives)
		{
			if (a.getNameHash() == hash)
			{
				return a;
			}
		}
		return null;
	}

	public IndexData toIndexData()
	{
		IndexData data = new IndexData();
		data.setProtocol(protocol);
		data.setRevision(revision);
		data.setNamed(named);

		ArchiveData[] archiveDatas = new ArchiveData[archives.size()];
		data.setArchives(archiveDatas);

		int idx = 0;
		for (Archive archive : archives)
		{
			ArchiveData ad = archiveDatas[idx++] = new ArchiveData();
			ad.setId(archive.getArchiveId());
			ad.setNameHash(archive.getNameHash());
			ad.setCrc(archive.getCrc());
			ad.setRevision(archive.getRevision());

			FileData[] files = archive.getFileData();
			ad.setFiles(files);
		}
		return data;
	}
}
