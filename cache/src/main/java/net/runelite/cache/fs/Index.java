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
import java.util.Collections;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.runelite.cache.index.ArchiveData;
import net.runelite.cache.index.FileData;
import net.runelite.cache.index.IndexData;
import net.runelite.cache.util.Djb2;

@EqualsAndHashCode(of = {"id", "revision", "archives"})
public class Index
{
	@Getter
	private final int id;

	@Setter
	@Getter
	private int protocol = 6;
	@Setter
	@Getter
	private boolean named = true;
	@Setter
	@Getter
	private boolean sized = false;
	@Setter
	@Getter
	private int revision;
	@Setter
	@Getter
	private int crc;
	@Setter
	@Getter
	private int compression; // compression method of this index's data in 255

	private final List<Archive> archives = new ArrayList<>();

	public Index(int id)
	{
		this.id = id;
	}

	public List<Archive> getArchives()
	{
		return Collections.unmodifiableList(archives);
	}

	public Archive addArchive(int id)
	{
		int idx = findArchiveIndex(id);
		if (idx >= 0)
		{
			throw new IllegalArgumentException("archive " + id + " already exists");
		}

		idx = -idx - 1;
		Archive archive = new Archive(this, id);
		this.archives.add(idx, archive);
		return archive;
	}

	public Archive getArchive(int id)
	{
		int idx = findArchiveIndex(id);
		if (idx < 0)
		{
			return null;
		}

		return archives.get(idx);
	}

	private int findArchiveIndex(int id)
	{
		int low = 0;
		int high = archives.size() - 1;

		while (low <= high)
		{
			int mid = (low + high) >>> 1;

			Archive a = archives.get(mid);
			int cmp = Integer.compare(a.getArchiveId(), id);
			if (cmp < 0)
			{
				low = mid + 1;
			}
			else if (cmp > 0)
			{
				high = mid - 1;
			}
			else
			{
				return mid;
			}
		}

		return -(low + 1);
	}

	public boolean removeArchive(Archive archive)
	{
		return archives.remove(archive);
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
		data.setSized(sized);

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
			ad.setCompressedSize(archive.getCompressedSize());
			ad.setDecompressedSize(archive.getDecompressedSize());

			FileData[] files = archive.getFileData();
			ad.setFiles(files);
		}
		return data;
	}
}
