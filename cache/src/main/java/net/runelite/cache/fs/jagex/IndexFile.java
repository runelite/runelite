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
package net.runelite.cache.fs.jagex;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EqualsAndHashCode(of = "file")
public class IndexFile implements Closeable
{
	private static final Logger logger = LoggerFactory.getLogger(IndexFile.class);

	private static final int INDEX_ENTRY_LEN = 6;

	@Getter
	private final int indexFileId;
	private final File file;
	private final RandomAccessFile idx;
	private final byte[] buffer = new byte[INDEX_ENTRY_LEN];

	public IndexFile(int indexFileId, File file) throws FileNotFoundException
	{
		this.indexFileId = indexFileId;
		this.file = file;
		this.idx = new RandomAccessFile(file, "rw");
	}

	@Override
	public void close() throws IOException
	{
		idx.close();
	}

	public void clear() throws IOException
	{
		idx.setLength(0L);
	}

	public synchronized void write(IndexEntry entry) throws IOException
	{
		idx.seek(entry.getId() * INDEX_ENTRY_LEN);

		buffer[0] = (byte) (entry.getLength() >> 16);
		buffer[1] = (byte) (entry.getLength() >> 8);
		buffer[2] = (byte) entry.getLength();

		buffer[3] = (byte) (entry.getSector() >> 16);
		buffer[4] = (byte) (entry.getSector() >> 8);
		buffer[5] = (byte) entry.getSector();

		idx.write(buffer);
	}

	public synchronized IndexEntry read(int id) throws IOException
	{
		idx.seek(id * INDEX_ENTRY_LEN);
		int i = idx.read(buffer);
		if (i != INDEX_ENTRY_LEN)
		{
			logger.debug("short read for id {} on index {}: {}", id, indexFileId, i);
			return null;
		}

		int length = ((buffer[0] & 0xFF) << 16) | ((buffer[1] & 0xFF) << 8) | (buffer[2] & 0xFF);
		int sector = ((buffer[3] & 0xFF) << 16) | ((buffer[4] & 0xFF) << 8) | (buffer[5] & 0xFF);

		if (length <= 0 || sector <= 0)
		{
			logger.debug("invalid length or sector {}/{}", length, sector);
			return null;
		}

		return new IndexEntry(this, id, sector, length);
	}

	public synchronized int getIndexCount() throws IOException
	{
		return (int) (idx.length() / INDEX_ENTRY_LEN);
	}
}
