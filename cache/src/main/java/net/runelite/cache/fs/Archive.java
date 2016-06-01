/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
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
import net.runelite.cache.io.InputStream;
import net.runelite.cache.io.OutputStream;

public class Archive
{
	private Index index; // member of this index
	private int archiveId;
	private int nameHash;
	private byte[] whirlpool;
	private int crc;
	private int revision;
	private int compression;
	private List<File> files = new ArrayList<>();
	
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
	
	public File addFile(int id)
	{
		File file = new File(this, id);
		this.files.add(file);
		return file;
	}
	
	public void load(InputStream stream, int numberOfFiles, int protocol)
	{
		int archive = 0;
		
		for (int i = 0; i < numberOfFiles; ++i)
		{
			int fileId = archive += protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();

			File file = new File(this, fileId);
			this.files.add(file);
		}
	}
	
	public void loadContents(byte[] data)
	{
		if (this.getFiles().size() == 1)
		{
			this.getFiles().get(0).setContents(data);
			return;
		}

		int filesCount = this.getFiles().size();

		InputStream stream = new InputStream(data);
		stream.setOffset(stream.getLength() - 1);
		int chunks = stream.readUnsignedByte();

		// -1 for chunks count + one int per file slot per chunk
		stream.setOffset(stream.getLength() - 1 - chunks * filesCount * 4);
		int[][] chunkSizes = new int[filesCount][chunks];
		int[] filesSize = new int[filesCount];

		for (int chunk = 0; chunk < chunks; ++chunk)
		{
			int chunkSize = 0;

			for (int id = 0; id < filesCount; ++id)
			{
				int delta = stream.readInt();
				chunkSize += delta; // size of this chunk

				chunkSizes[id][chunk] = chunkSize; // store size of chunk

				filesSize[id] += chunkSize; // add chunk size to file size
			}
		}

		byte[][] fileContents = new byte[filesCount][];
		int[] fileOffsets = new int[filesCount];

		for (int i = 0; i < filesCount; ++i)
		{
			fileContents[i] = new byte[filesSize[i]];
		}

		// the file data is at the beginning of the stream
		stream.setOffset(0);

		for (int chunk = 0; chunk < chunks; ++chunk)
		{
			for (int id = 0; id < filesCount; ++id)
			{
				int chunkSize = chunkSizes[id][chunk];
				
				stream.readBytes(fileContents[id], fileOffsets[id], chunkSize);
				
				fileOffsets[id] += chunkSize;
			}
		}

		for (int i = 0; i < filesCount; ++i)
		{
			File f = this.getFiles().get(i);
			f.setContents(fileContents[i]);
		}
	}

	public byte[] saveContents()
	{
		OutputStream stream = new OutputStream();

		int filesCount = this.getFiles().size();

		if (filesCount == 1)
		{
			File file = this.getFiles().get(0);
			stream.writeBytes(file.getContents());
		}
		else
		{
			for (File file : this.getFiles())
			{
				stream.writeBytes(file.getContents());
			}

			int offset = 0;

			for (File file : this.getFiles())
			{
				int chunkSize = file.getSize();

				int sz = chunkSize - offset;
				offset = chunkSize;
				stream.writeInt(sz);
			}

			stream.writeByte(1); // chunks
		}

		byte[] fileData = stream.flip();
		return fileData;
	}
	
	public void loadNames(InputStream stream, int numberOfFiles)
	{
		for (int i = 0; i < numberOfFiles; ++i)
		{
			File file = this.files.get(i);
			int name = stream.readInt();
			file.setNameHash(name);
		}
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

	public List<File> getFiles()
	{
		return files;
	}
}
