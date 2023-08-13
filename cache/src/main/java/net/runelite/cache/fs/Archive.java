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

import java.io.IOException;
import net.runelite.cache.index.FileData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archive
{
	private static final Logger logger = LoggerFactory.getLogger(Archive.class);

	private final Index index; // member of this index

	private final int archiveId;
	private int nameHash;
	private int crc;
	private int revision;
	private int compression;
	private FileData[] fileData;

	public Archive(Index index, int id)
	{
		this.index = index;
		this.archiveId = id;
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 47 * hash + this.archiveId;
		hash = 47 * hash + this.nameHash;
		hash = 47 * hash + this.revision;
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
		final Archive other = (Archive) obj;
		if (this.archiveId != other.archiveId)
		{
			return false;
		}
		if (this.nameHash != other.nameHash)
		{
			return false;
		}
		if (this.revision != other.revision)
		{
			return false;
		}
		return true;
	}

	public Index getIndex()
	{
		return index;
	}

	public byte[] decompress(byte[] data) throws IOException
	{
		return decompress(data, null);
	}

	public byte[] decompress(byte[] data, int[] keys) throws IOException
	{
		if (data == null)
		{
			return null;
		}

		byte[] encryptedData = data;

		Container container = Container.decompress(encryptedData, keys);
		if (container == null)
		{
			logger.warn("Unable to decrypt archive {}", this);
			return null;
		}

		byte[] decompressedData = container.data;

		if (this.crc != container.crc)
		{
			logger.warn("crc mismatch for archive {}/{}", index.getId(), this.getArchiveId());
			throw new IOException("CRC mismatch for " + index.getId() + "/" + this.getArchiveId());
		}

		if (container.revision != -1 && this.getRevision() != container.revision)
		{
			// compressed data doesn't always include a revision, but check it if it does
			logger.warn("revision mismatch for archive {}/{}, expected {} was {}",
				index.getId(), this.getArchiveId(),
				this.getRevision(), container.revision);
			// I've seen this happen with vanilla caches where the
			// revision in the index data differs from the revision
			// stored for the archive data on disk... I assume this
			// is more correct
			this.setRevision(container.revision);
		}

		setCompression(container.compression);
		return decompressedData;
	}

	public ArchiveFiles getFiles(byte[] data) throws IOException
	{
		return getFiles(data, null);
	}

	public ArchiveFiles getFiles(byte[] data, int[] keys) throws IOException
	{
		byte[] decompressedData = decompress(data, keys);

		ArchiveFiles files = new ArchiveFiles();
		for (FileData fileEntry : fileData)
		{
			FSFile file = new FSFile(fileEntry.getId());
			file.setNameHash(fileEntry.getNameHash());
			files.addFile(file);
		}
		files.loadContents(decompressedData);
		return files;
	}

	public int getArchiveId()
	{
		return archiveId;
	}

	public int getNameHash()
	{
		return nameHash;
	}

	public void setNameHash(int nameHash)
	{
		this.nameHash = nameHash;
	}

	public int getCrc()
	{
		return crc;
	}

	public void setCrc(int crc)
	{
		this.crc = crc;
	}

	public int getRevision()
	{
		return revision;
	}

	public void setRevision(int revision)
	{
		this.revision = revision;
	}

	public int getCompression()
	{
		return compression;
	}

	public void setCompression(int compression)
	{
		this.compression = compression;
	}

	public FileData[] getFileData()
	{
		return fileData;
	}

	public void setFileData(FileData[] fileData)
	{
		this.fileData = fileData;
	}
}
