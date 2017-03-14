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

import com.google.common.io.Files;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import net.runelite.cache.io.InputStream;
import net.runelite.cache.io.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archive
{
	private static final Logger logger = LoggerFactory.getLogger(Archive.class);

	private Index index; // member of this index

	private byte[] data; // raw data from the datafile, compressed/encrypted

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

	public byte[] getData()
	{
		return data;
	}

	public void setData(byte[] data)
	{
		this.data = data;
	}

	public File addFile(int id)
	{
		File file = new File(this, id);
		this.files.add(file);
		return file;
	}

	public void loadFiles(InputStream stream, int numberOfFiles, int protocol)
	{
		int archive = 0;

		for (int i = 0; i < numberOfFiles; ++i)
		{
			int fileId = archive += protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();

			File file = new File(this, fileId);
			this.files.add(file);
		}
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
			logger.warn("crc mismatch for archive {}", this);
		}

		if (this.getWhirlpool() != null && !Arrays.equals(this.getWhirlpool(), res.whirlpool))
		{
			logger.warn("whirlpool mismatch for archive {}", this);
		}

		if (res.revision != -1 && this.getRevision() != res.revision)
		{
			// compressed data doesn't always include a revision, but check it if it does
			logger.warn("revision mismatch for archive {}", this);
		}

		setCompression(res.compression);

		loadContents(decompressedData);
		this.setData(null); // now that we've loaded it, clean it so it doesn't get written back
	}

	public void loadContents(byte[] data)
	{
		logger.trace("Loading contents of archive {} ({} files)", archiveId, files.size());

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
		if (data != null)
		{
			logger.trace("Saving contents of archive {}/{} using cached data", index.getId(), archiveId);
			return data;
		}

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
				byte[] contents = file.getContents();
				stream.writeBytes(contents);
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

		logger.trace("Saved contents of archive {}/{} ({} files), {} bytes", index.getId(), archiveId, files.size(), fileData.length);

		return fileData;
	}

	public void saveTree(java.io.File to) throws IOException
	{
		if (data != null)
		{
			assert files.size() == 1; // this is the maps

			File file = files.get(0);

			java.io.File archiveFile = new java.io.File(to, this.getArchiveId() + "-" + file.getFileId() + "-" + file.getNameHash() + ".datc");
			Files.write(data, archiveFile);

			archiveFile = new java.io.File(to, this.getArchiveId() + ".rev");
			Files.write("" + this.getRevision(), archiveFile, Charset.defaultCharset());

			archiveFile = new java.io.File(to, this.getArchiveId() + ".name");
			Files.write("" + this.getNameHash(), archiveFile, Charset.defaultCharset());
			return;
		}

		if (files.size() == 1)
		{
			File file = this.getFiles().get(0);

			java.io.File archiveFile = new java.io.File(to, this.getArchiveId() + "-" + file.getFileId() + "-" + file.getNameHash() + ".dat");
			byte[] contents = file.getContents();

			Files.write(contents, archiveFile);

			archiveFile = new java.io.File(to, this.getArchiveId() + ".rev");
			Files.write("" + this.getRevision(), archiveFile, Charset.defaultCharset());

			archiveFile = new java.io.File(to, this.getArchiveId() + ".name");
			Files.write("" + this.getNameHash(), archiveFile, Charset.defaultCharset());
			return;
		}

		java.io.File archiveFile = new java.io.File(to, this.getArchiveId() + ".rev");
		Files.write("" + this.getRevision(), archiveFile, Charset.defaultCharset());

		archiveFile = new java.io.File(to, this.getArchiveId() + ".name");
		Files.write("" + this.getNameHash(), archiveFile, Charset.defaultCharset());

		java.io.File archiveFolder = new java.io.File(to, "" + this.getArchiveId());
		archiveFolder.mkdirs();

		for (File file : files)
		{
			archiveFile = new java.io.File(archiveFolder, file.getFileId() + "-" + file.getNameHash() + ".dat");
			byte[] contents = file.getContents();
			Files.write(contents, archiveFile);
		}
	}

	public void loadTreeData(java.io.File parent, java.io.File from) throws IOException
	{
		//archiveId-fileId-fileName - assumes name isn't negative
		String[] parts = Files.getNameWithoutExtension(from.getName()).split("-");
		int archiveId = Integer.parseInt(parts[0]);
		int fileId = Integer.parseInt(parts[1]);
		int nameHash = Integer.parseInt(parts[2]);

		assert archiveId == this.getArchiveId();

		data = Files.toByteArray(from);

		File file = new File(this, fileId);
		file.setNameHash(nameHash);

		files.add(file);

		java.io.File archiveFile = new java.io.File(parent, this.getArchiveId() + ".rev");
		int rev = Integer.parseInt(Files.readFirstLine(archiveFile, Charset.defaultCharset()));
		this.setRevision(rev);

		archiveFile = new java.io.File(parent, this.getArchiveId() + ".name");
		int name = Integer.parseInt(Files.readFirstLine(archiveFile, Charset.defaultCharset()));
		this.setNameHash(name);
	}

	public void loadTreeSingleFile(java.io.File parent, java.io.File from) throws IOException
	{
		//archiveId-fileId-fileName
		String[] parts = Files.getNameWithoutExtension(from.getName()).split("-");
		int archiveId = Integer.parseInt(parts[0]);
		int fileId = Integer.parseInt(parts[1]);
		int nameHash = Integer.parseInt(parts[2]);

		assert archiveId == this.getArchiveId();

		File file = new File(this, fileId);
		file.setNameHash(nameHash);

		byte[] contents = Files.toByteArray(from);
		file.setContents(contents);

		files.add(file);

		java.io.File archiveFile = new java.io.File(parent, this.getArchiveId() + ".rev");
		int rev = Integer.parseInt(Files.readFirstLine(archiveFile, Charset.defaultCharset()));
		this.setRevision(rev);

		archiveFile = new java.io.File(parent, this.getArchiveId() + ".name");
		int name = Integer.parseInt(Files.readFirstLine(archiveFile, Charset.defaultCharset()));
		this.setNameHash(name);
	}

	public void loadTree(java.io.File parent, java.io.File from) throws IOException
	{
		for (java.io.File file : from.listFiles())
		{
			//fileId-fileName.dat
			String[] split = Files.getNameWithoutExtension(file.getName()).split("-");
			int fileId = Integer.parseInt(split[0]);
			int fileName = Integer.parseInt(split[1]);

			File f = new File(this, fileId);
			f.setNameHash(fileName);

			byte[] contents = Files.toByteArray(file);
			f.setContents(contents);

			files.add(f);
		}

		java.io.File archiveFile = new java.io.File(parent, this.getArchiveId() + ".rev");
		int rev = Integer.parseInt(Files.readFirstLine(archiveFile, Charset.defaultCharset()));
		this.setRevision(rev);

		archiveFile = new java.io.File(parent, this.getArchiveId() + ".name");
		int name = Integer.parseInt(Files.readFirstLine(archiveFile, Charset.defaultCharset()));
		this.setNameHash(name);

		// the filesystem may order these differently (eg, 1, 10, 2)
		Collections.sort(files, (f1, f2) -> Integer.compare(f1.getFileId(), f2.getFileId()));
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
