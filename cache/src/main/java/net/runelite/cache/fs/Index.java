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

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import net.runelite.cache.fs.util.Djb2;
import net.runelite.cache.io.InputStream;
import net.runelite.cache.io.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Index implements Closeable
{
	private static final Logger logger = LoggerFactory.getLogger(Index.class);
	
	private final Store store;
	private final IndexFile index;
	private final int id;
	private int protocol = 7;
	private boolean named = true, usesWhirpool;
	private int revision;
	private int crc;
	private byte[] whirlpool;
	private int compression; // compression method of this index's data in 255
	private final List<Archive> archives = new ArrayList<>();
	
	public Index(Store store, IndexFile index, int id)
	{
		this.store = store;
		this.index = index;
		this.id = id;
	}
	
	@Override
	public void close() throws IOException
	{
		index.close();
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

	public int getRevision()
	{
		return revision;
	}

	public int getCrc()
	{
		return crc;
	}

	public byte[] getWhirlpool()
	{
		return whirlpool;
	}

	public IndexFile getIndex()
	{
		return index;
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
			if (a.getArchiveId() == id)
				return a;
		return null;
	}

	public Archive findArchiveByName(String name)
	{
		int hash = Djb2.hash(name);
		for (Archive a : archives)
			if (a.getNameHash() == hash)
				return a;
		return null;
	}
	
	public void load() throws IOException
	{	
		DataFile dataFile = store.getData();
		IndexFile index255 = store.getIndex255();
		
		IndexEntry entry = index255.read(id);
		DataFileReadResult res = dataFile.read(index255.getIndexFileId(), entry.getId(), entry.getSector(), entry.getLength());
		byte[] data = res.data;

		archives.clear();
		
		readIndexData(data);

		this.crc = res.crc;
		this.whirlpool = res.whirlpool;
		this.compression = res.compression;
		assert res.revision == -1;
		
		this.loadFiles();
	}
	
	public void save() throws IOException
	{
		saveFiles();
		
		byte[] data = this.writeIndexData();

		DataFile dataFile = store.getData();
		IndexFile index255 = store.getIndex255();
		
		DataFileWriteResult res = dataFile.write(index255.getIndexFileId(), this.id, ByteBuffer.wrap(data), this.compression, -1); // index data revision is always -1
		index255.write(new IndexEntry(index255, id, res.sector, res.compressedLength));

		this.crc = res.crc;
		this.whirlpool = res.whirlpool;
	}
	
	public void readIndexData(byte[] data)
	{
		InputStream stream = new InputStream(data);
		protocol = stream.readUnsignedByte();
		if (protocol >= 5 && protocol <= 7)
		{
			if (protocol >= 6)
			{
				this.revision = stream.readInt();
			}

			int hash = stream.readUnsignedByte();
			named = (1 & hash) != 0;
			usesWhirpool = (2 & hash) != 0;
			assert (hash & ~3) == 0;
			int validArchivesCount = protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
			int lastArchiveId = 0;

			int index;
			int archive;
			for (index = 0; index < validArchivesCount; ++index)
			{
				archive = lastArchiveId += protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
				Archive a = new Archive(this, archive);
				this.archives.add(a);
			}

			if (named)
			{
				for (index = 0; index < validArchivesCount; ++index)
				{
					int nameHash = stream.readInt();
					Archive a = this.archives.get(index);
					a.setNameHash(nameHash);
				}
			}

			if (usesWhirpool)
			{
				for (index = 0; index < validArchivesCount; ++index)
				{
					byte[] var13 = new byte[64];
					stream.readBytes(var13);

					Archive a = this.archives.get(index);
					a.setWhirlpool(var13);
				}
			}

			for (index = 0; index < validArchivesCount; ++index)
			{
				int crc = stream.readInt();

				Archive a = this.archives.get(index);
				a.setCrc(crc);
			}

			for (index = 0; index < validArchivesCount; ++index)
			{
				int revision = stream.readInt();

				Archive a = this.archives.get(index);
				a.setRevision(revision);
			}

			int[] numberOfFiles = new int[validArchivesCount];
			for (index = 0; index < validArchivesCount; ++index)
			{
				int num = protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
				numberOfFiles[index] = num;
			}

			for (index = 0; index < validArchivesCount; ++index)
			{
				archive = 0;

				Archive a = this.archives.get(index);
				a.load(stream, numberOfFiles[index], protocol);
			}

			if (named)
			{
				for (index = 0; index < validArchivesCount; ++index)
				{
					Archive a = this.archives.get(index);
					a.loadNames(stream, numberOfFiles[index]);
				}
			}
		}
	}
	
	private void loadFiles() throws IOException
	{
		// get data from index file
		for (Archive a : archives)
		{
			IndexEntry entry = this.index.read(a.getArchiveId());
			if (entry == null)
			{
				logger.debug("can't read archive " + a.getArchiveId() + " from index " + this.id);
				continue;
			}
			
			assert this.index.getIndexFileId() == this.id;
			assert entry.getId() == a.getArchiveId();
			DataFileReadResult res = store.getData().read(this.id, entry.getId(), entry.getSector(), entry.getLength());
			byte[] data = res.data;
			
			if (a.getCrc() != res.crc)
			{
				logger.warn("crc mismatch for archive {}", a);
			}
			
			if (a.getWhirlpool() != null && !Arrays.equals(a.getWhirlpool(), res.whirlpool))
			{
				logger.warn("whirlpool mismatch for archive {}", a);
			}

			if (a.getRevision() != res.revision)
			{
				logger.warn("revision mismatch for archive {}", a);
			}

			a.setCompression(res.compression);
			
			a.loadContents(data);
		}
	}
	
	public void saveFiles() throws IOException
	{
		for (Archive a : archives)
		{
			byte[] fileData = a.saveContents();
			
			assert this.index.getIndexFileId() == this.id;
			DataFile data = store.getData();
			
			DataFileWriteResult res = data.write(this.id, a.getArchiveId(), ByteBuffer.wrap(fileData), a.getCompression(), a.getRevision());
			this.index.write(new IndexEntry(this.index, a.getArchiveId(), res.sector, res.compressedLength));
			
			a.setCrc(res.crc);
			a.setWhirlpool(res.whirlpool);
		}
	}
	
	public byte[] writeIndexData()
	{
		OutputStream stream = new OutputStream();
		stream.writeByte(protocol);
		if (protocol >= 6)
		{
			stream.writeInt(this.revision);
		}

		stream.writeByte((named ? 1 : 0) | (usesWhirpool ? 2 : 0));
		if (protocol >= 7)
		{
			stream.writeBigSmart(this.archives.size());
		}
		else
		{
			stream.writeShort(this.archives.size());
		}

		int data;
		for (data = 0; data < this.archives.size(); ++data)
		{
			Archive a = this.archives.get(data);
			int archive = a.getArchiveId();

			if (data != 0)
			{
				Archive prev = this.archives.get(data - 1);
				archive -= prev.getArchiveId();
			}

			if (protocol >= 7)
			{
				stream.writeBigSmart(archive);
			}
			else
			{
				stream.writeShort(archive);
			}
		}

		if (named)
		{
			for (data = 0; data < this.archives.size(); ++data)
			{
				Archive a = this.archives.get(data);
				stream.writeInt(a.getNameHash());
			}
		}

		if (usesWhirpool)
		{
			for (data = 0; data < this.archives.size(); ++data)
			{
				Archive a = this.archives.get(data);
				stream.writeBytes(a.getWhirlpool());
			}
		}

		for (data = 0; data < this.archives.size(); ++data)
		{
			Archive a = this.archives.get(data);
			stream.writeInt(a.getCrc());
		}

		for (data = 0; data < this.archives.size(); ++data)
		{
			Archive a = this.archives.get(data);
			stream.writeInt(a.getRevision());
		}

		for (data = 0; data < this.archives.size(); ++data)
		{
			Archive a = this.archives.get(data);
			
			int len = a.getFiles().size();

			if (protocol >= 7)
			{
				stream.writeBigSmart(len);
			}
			else
			{
				stream.writeShort(len);
			}
		}

		int index2;
		for (data = 0; data < this.archives.size(); ++data)
		{
			Archive a = this.archives.get(data);

			for (index2 = 0; index2 < a.getFiles().size(); ++index2)
			{
				File file = a.getFiles().get(index2);
				int offset = file.getFileId();

				if (index2 != 0)
				{
					File prev = a.getFiles().get(index2 - 1);
					offset -= prev.getFileId();
				}

				if (protocol >= 7)
				{
					stream.writeBigSmart(offset);
				}
				else
				{
					stream.writeShort(offset);
				}
			}
		}

		if (named)
		{
			for (data = 0; data < this.archives.size(); ++data)
			{
				Archive a = this.archives.get(data);

				for (index2 = 0; index2 < a.getFiles().size(); ++index2)
				{
					File file = a.getFiles().get(index2);
					stream.writeInt(file.getNameHash());
				}
			}
		}

		return stream.flip();
	}
}
