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

import net.runelite.cache.fs.jagex.DataFile;
import net.runelite.cache.fs.jagex.DataFileReadResult;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archive
{
	private static final Logger logger = LoggerFactory.getLogger(Archive.class);

	private final Index index; // member of this index

	private byte[] data; // raw data from the datafile, compressed/encrypted

	private final int archiveId;
	private int nameHash;
	private byte[] whirlpool;
	private int crc;
	private int revision;
	private int compression;

	private final ArchiveFiles files = new ArchiveFiles();

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
		hash = 47 * hash + Objects.hashCode(this.files);
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
		if (!Objects.equals(this.files, other.files))
		{
			return false;
		}
		return true;
	}

	public Index getIndex()
	{
		return index;
	}

	public byte[] getData()
	{
		return data;
	}

	public void setData(byte[] data)
	{
		this.data = data;
	}

	public FSFile addFile(FSFile file)
	{
		this.files.addFile(file);
		return file;
	}

	public FSFile findFile(int id)
	{
		return this.files.findFile(id);
	}

	public void decompressAndLoad(int[] keys) throws IOException
	{
		byte[] encryptedData = this.getData();

		DataFileReadResult res = DataFile.decompress(encryptedData, keys);
		if (res == null)
		{
			logger.warn("Unable to decrypt archive {}", this);
			return;
		}

		byte[] decompressedData = res.data;

		if (this.crc != res.crc)
		{
			logger.warn("crc mismatch for archive {}/{}", index.getId(), this.getArchiveId());
			this.setCrc(res.crc);
		}

		if (this.getWhirlpool() != null && !Arrays.equals(this.getWhirlpool(), res.whirlpool))
		{
			logger.warn("whirlpool mismatch for archive {}", this.getArchiveId());
			this.setWhirlpool(res.whirlpool);
		}

		if (res.revision != -1 && this.getRevision() != res.revision)
		{
			// compressed data doesn't always include a revision, but check it if it does
			logger.warn("revision mismatch for archive {}/{}, expected {} was {}",
				index.getId(), this.getArchiveId(),
				this.getRevision(), res.revision);
			// I've seen this happen with vanilla caches where the
			// revision in the index data differs from the revision
			// stored for the archive data on disk... I assume this
			// is more correct
			this.setRevision(res.revision);
		}

		setCompression(res.compression);

		files.loadContents(decompressedData);
		this.setData(null); // now that we've loaded it, clean it so it doesn't get written back
	}

	public byte[] saveContents()
	{
		return files.saveContents();
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

	public byte[] getWhirlpool()
	{
		return whirlpool;
	}

	public void setWhirlpool(byte[] whirlpool)
	{
		this.whirlpool = whirlpool;
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

	public List<FSFile> getFiles()
	{
		return files.getFiles();
	}

	public void clearFiles()
	{
		files.clear();
	}
}
