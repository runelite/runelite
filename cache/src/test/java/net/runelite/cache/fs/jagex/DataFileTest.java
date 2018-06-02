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

import java.io.File;
import java.io.IOException;
import net.runelite.cache.StoreLocation;
import net.runelite.cache.fs.Container;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class DataFileTest
{
	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	@Test
	public void test1() throws IOException
	{
		File file = folder.newFile();
		DataFile df = new DataFile(file);

		Container container = new Container(CompressionType.NONE, 0);
		container.compress("test".getBytes(), null);
		byte[] compressedData = container.data;
		DataFileWriteResult res = df.write(42, 3, compressedData);

		compressedData = df.read(42, 3, res.sector, res.compressedLength);
		Container res2 = Container.decompress(compressedData, null);

		byte[] buf = res2.data;
		String str = new String(buf);
		Assert.assertEquals("test", str);
	}

	@Test
	public void test2() throws IOException
	{
		byte[] b = new byte[1024];
		for (int i = 0; i < 1024; ++i)
		{
			b[i] = (byte) i;
		}

		File file = folder.newFile();

		DataFile df = new DataFile(file);

		Container container = new Container(CompressionType.BZ2, 42);
		container.compress(b, null);
		byte[] compressedData = container.data;
		DataFileWriteResult res = df.write(42, 0x1FFFF, compressedData);

		compressedData = df.read(42, 0x1FFFF, res.sector, res.compressedLength);
		Container res2 = Container.decompress(compressedData, null);

		byte[] buf = res2.data;
		Assert.assertArrayEquals(b, buf);
	}

	@Test
	public void testGZipCompression() throws IOException
	{
		DataFile df = new DataFile(folder.newFile());

		Container container = new Container(CompressionType.GZ, 0);
		container.compress("test".getBytes(), null);
		byte[] compressedData = container.data;
		DataFileWriteResult res = df.write(41, 4, compressedData);

		compressedData = df.read(41, 4, res.sector, res.compressedLength);
		Container res2 = Container.decompress(compressedData, null);

		byte[] buf = res2.data;
		String str = new String(buf);
		Assert.assertEquals("test", str);
	}

	@Test
	public void testBZip2Compression() throws IOException
	{
		DataFile df = new DataFile(folder.newFile());

		Container container = new Container(CompressionType.BZ2, 5);
		container.compress("test".getBytes(), null);
		byte[] compressedData = container.data;
		DataFileWriteResult res = df.write(41, 4, compressedData);

		compressedData = df.read(41, 4, res.sector, res.compressedLength);
		Container res2 = Container.decompress(compressedData, null);

		byte[] buf = res2.data;
		String str = new String(buf);
		Assert.assertEquals("test", str);
	}

	@Test
	public void testEnc() throws IOException
	{
		File file = folder.newFile();
		int[] keys = new int[]
		{
			4, 8, 15, 16
		};

		DataFile df = new DataFile(file);

		Container container = new Container(CompressionType.NONE, 42);
		container.compress("testtesttesttest1".getBytes(), keys);
		byte[] compressedData = container.data;
		DataFileWriteResult res = df.write(42, 3, compressedData);

		compressedData = df.read(42, 3, res.sector, res.compressedLength);
		Container res2 = Container.decompress(compressedData, keys);

		byte[] buf = res2.data;
		String str = new String(buf);
		Assert.assertEquals("testtesttesttest1", str);
		Assert.assertEquals(42, res2.revision);
	}

	@Test
	public void testEncGz() throws IOException
	{
		File file = folder.newFile();
		int[] keys = new int[]
		{
			4, 8, 15, 16
		};

		DataFile df = new DataFile(file);

		Container container = new Container(CompressionType.GZ, 42);
		container.compress("testtesttesttest1".getBytes(), keys);
		byte[] compressedData = container.data;
		DataFileWriteResult res = df.write(42, 3, compressedData);

		compressedData = df.read(42, 3, res.sector, res.compressedLength);
		Container res2 = Container.decompress(compressedData, keys);

		byte[] buf = res2.data;
		String str = new String(buf);
		Assert.assertEquals("testtesttesttest1", str);
		Assert.assertEquals(42, res2.revision);
	}
}
