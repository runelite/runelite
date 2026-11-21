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

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotSame;
import org.junit.Test;

public class ArchiveFilesTest
{
	@Test
	public void testSingleFileIsCopiedWhenSaved()
	{
		byte[] contents = {1, 2, 3};
		ArchiveFiles files = new ArchiveFiles();
		addFile(files, 10, contents);
		byte[] saved = files.saveContents();
		assertArrayEquals(contents, saved);
		assertNotSame(contents, saved);
		saved[0] = 9;
		assertArrayEquals(new byte[]{1, 2, 3}, contents);
	}

	@Test
	public void testEmptyArchiveAndEmptyFile()
	{
		ArchiveFiles files = new ArchiveFiles();
		assertArrayEquals(new byte[]{1}, files.saveContents());
		addFile(files, 10, new byte[0]);
		assertArrayEquals(new byte[0], files.saveContents());
	}

	@Test
	public void testSavePreservesInsertionOrderAndNegativeDeltas() throws IOException
	{
		byte[][][] chunks = {{{1, 2, 3}, {}, {4}, {5, 6}}};
		ArchiveFiles files = new ArchiveFiles();
		addFile(files, 20, chunks[0][0]);
		addFile(files, 5, chunks[0][1]);
		addFile(files, 12, chunks[0][2]);
		addFile(files, 100, chunks[0][3]);
		assertArrayEquals(encodeChunks(chunks), files.saveContents());
		files.loadContents(files.saveContents());
		assertArrayEquals(chunks[0][0], files.findFile(20).getContents());
		assertArrayEquals(chunks[0][1], files.findFile(5).getContents());
		assertArrayEquals(chunks[0][2], files.findFile(12).getContents());
		assertArrayEquals(chunks[0][3], files.findFile(100).getContents());
	}

	@Test
	public void testMultipleChunks() throws IOException
	{
		byte[][][] chunks =
		{
			{{1, 2}, {9}, {}},
			{{3}, {8, 7, 6}, {5}}
		};
		ArchiveFiles files = new ArchiveFiles();
		addFile(files, 20, new byte[0]);
		addFile(files, 5, new byte[0]);
		addFile(files, 100, new byte[0]);
		files.loadContents(encodeChunks(chunks));
		assertArrayEquals(new byte[]{1, 2, 3}, files.findFile(20).getContents());
		assertArrayEquals(new byte[]{9, 8, 7, 6}, files.findFile(5).getContents());
		assertArrayEquals(new byte[]{5}, files.findFile(100).getContents());
	}

	@Test
	public void testMaximumChunkCount() throws IOException
	{
		int fileCount = 20;
		byte[][][] chunks = new byte[255][fileCount][];
		ByteArrayOutputStream[] expected = new ByteArrayOutputStream[fileCount];
		ArchiveFiles files = new ArchiveFiles();
		for (int file = 0; file < fileCount; ++file)
		{
			expected[file] = new ByteArrayOutputStream();
			addFile(files, file * 3, new byte[0]);
		}

		Random random = new Random(0);
		for (byte[][] chunk : chunks)
		{
			for (int file = 0; file < fileCount; ++file)
			{
				byte[] contents = new byte[random.nextInt(50)];
				random.nextBytes(contents);
				chunk[file] = contents;
				expected[file].write(contents);
			}
		}

		byte[] encoded = encodeChunks(chunks);
		byte[] original = encoded.clone();
		files.loadContents(encoded);
		assertArrayEquals(original, encoded);
		for (int file = 0; file < fileCount; ++file)
		{
			assertArrayEquals(expected[file].toByteArray(), files.findFile(file * 3).getContents());
		}
	}

	private static void addFile(ArchiveFiles files, int id, byte[] contents)
	{
		FSFile file = new FSFile(id);
		file.setContents(contents);
		files.addFile(file);
	}

	private static byte[] encodeChunks(byte[][][] chunks) throws IOException
	{
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream output = new DataOutputStream(bytes);
		for (byte[][] chunk : chunks)
		{
			for (byte[] file : chunk)
			{
				output.write(file);
			}
		}
		for (byte[][] chunk : chunks)
		{
			int previousSize = 0;
			for (byte[] file : chunk)
			{
				output.writeInt(file.length - previousSize);
				previousSize = file.length;
			}
		}
		output.writeByte(chunks.length);
		return bytes.toByteArray();
	}
}
