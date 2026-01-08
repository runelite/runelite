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

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import lombok.EqualsAndHashCode;
import net.runelite.cache.io.InputStream;
import net.runelite.cache.io.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EqualsAndHashCode(of = "files")
public class ArchiveFiles
{
	private static final Logger logger = LoggerFactory.getLogger(ArchiveFiles.class);

	private final LinkedHashMap<Integer, FSFile> files = new LinkedHashMap<Integer, FSFile>();

	public void addFile(FSFile file)
	{
		Preconditions.checkArgument(file.getFileId() != -1);

		if (files.containsKey(file.getFileId()))
		{
			throw new IllegalStateException("duplicate file ids");
		}

		files.put(file.getFileId(), file);
	}

	public Collection<FSFile> getFiles()
	{
		return Collections.unmodifiableCollection(files.values());
	}

	public FSFile findFile(int fileId)
	{
		return files.get(fileId);
	}

	public void clear()
	{
		files.clear();
	}

	public void loadContents(byte[] data)
	{
		logger.trace("Loading contents of archive ({} files)", files.size());

		assert !this.getFiles().isEmpty();

		if (files.size() == 1)
		{
			FSFile f = files.values().iterator().next();
			f.setContents(data);
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

		Iterator<FSFile> iter = files.values().iterator();
		for (int i = 0; i < filesCount; ++i)
		{
			FSFile f = iter.next();
			f.setContents(fileContents[i]);
		}
	}

	public byte[] saveContents()
	{
		OutputStream stream = new OutputStream();

		int filesCount = this.getFiles().size();

		if (filesCount == 1)
		{
			FSFile file = files.values().iterator().next();
			stream.writeBytes(file.getContents());
		}
		else
		{
			for (FSFile file : this.getFiles())
			{
				byte[] contents = file.getContents();
				stream.writeBytes(contents);
			}

			int offset = 0;

			for (FSFile file : this.getFiles())
			{
				int chunkSize = file.getSize();

				int sz = chunkSize - offset;
				offset = chunkSize;
				stream.writeInt(sz);
			}

			stream.writeByte(1); // chunks
		}

		byte[] fileData = stream.flip();

		logger.trace("Saved contents of archive ({} files), {} bytes", files.size(), fileData.length);
		return fileData;
	}
}
