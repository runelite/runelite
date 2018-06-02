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
package net.runelite.cache.client;

import java.io.IOException;
import net.runelite.cache.fs.Container;

public class FileResult
{
	private final int index;
	private final int fileId;
	private final byte[] compressedData;

	private byte[] contents;
	private int revision;
	private int crc;
	private int compression; // compression method used by archive data

	public FileResult(int index, int fileId, byte[] compressedData)
	{
		this.index = index;
		this.fileId = fileId;
		this.compressedData = compressedData;
	}

	public int getIndex()
	{
		return index;
	}

	public int getFileId()
	{
		return fileId;
	}

	public byte[] getCompressedData()
	{
		return compressedData;
	}

	public void decompress(int[] keys) throws IOException
	{
		Container res = Container.decompress(compressedData, keys);

		contents = res.data;
		revision = res.revision;
		crc = res.crc;
		compression = res.compression;
	}

	public byte[] getContents()
	{
		return contents;
	}

	public int getRevision()
	{
		return revision;
	}

	public int getCrc()
	{
		return crc;
	}

	public int getCompression()
	{
		return compression;
	}
}
