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

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import net.runelite.cache.StoreLocation;
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
		Store store = new Store(folder.getRoot());
		DataFile df = new DataFile(store, file);
		DataFileWriteResult res = df.write(42, 3, ByteBuffer.wrap("test".getBytes()), CompressionType.NONE, 0);
		DataFileReadResult res2 = df.read(42, 3, res.sector, res.compressedLength);
		byte[] buf = res2.data;
		String str = new String(buf);
		Assert.assertEquals("test", str);
		file.delete();
	}
	
	@Test
	public void test2() throws IOException
	{
		byte[] b = new byte[1024];
		for (int i = 0; i < 1024; ++i)
			b[i] = (byte) i;
		
		File file = folder.newFile();
		Store store = new Store(folder.getRoot());
		DataFile df = new DataFile(store, file);
		DataFileWriteResult res = df.write(42, 0x1FFFF, ByteBuffer.wrap(b), CompressionType.BZ2, 42);
		DataFileReadResult res2 = df.read(42, 0x1FFFF, res.sector, res.compressedLength);
		byte[] buf = res2.data;
		Assert.assertArrayEquals(b, buf);
		file.delete();
	}
	
	@Test
	public void testGZipCompression() throws IOException
	{
		try (Store store = new Store(folder.getRoot()))
		{
			DataFile df = new DataFile(store, folder.newFile());
			DataFileWriteResult res = df.write(41, 4, ByteBuffer.wrap("test".getBytes()), CompressionType.GZ, 0);
			DataFileReadResult res2 = df.read(41, 4, res.sector, res.compressedLength);
			byte[] buf = res2.data;
			String str = new String(buf);
			Assert.assertEquals("test", str);
		}
	}
	
	@Test
	public void testBZip2Compression() throws IOException
	{
		try (Store store = new Store(folder.getRoot()))
		{
			DataFile df = new DataFile(store, folder.newFile());
			DataFileWriteResult res = df.write(41, 4, ByteBuffer.wrap("test".getBytes()), CompressionType.BZ2, 5);
			DataFileReadResult res2 = df.read(41, 4, res.sector, res.compressedLength);
			byte[] buf = res2.data;
			String str = new String(buf);
			Assert.assertEquals("test", str);
		}
	}

	@Test
	public void testCrc() throws IOException
	{
		File file = folder.newFile();
		Store store = new Store(folder.getRoot());
		DataFile df = new DataFile(store, file);
		DataFileWriteResult res = df.write(42, 3, ByteBuffer.wrap("test".getBytes()), CompressionType.NONE, 42);
		DataFileReadResult res2 = df.read(42, 3, res.sector, res.compressedLength);
		byte[] buf = res2.data;
		String str = new String(buf);
		Assert.assertEquals("test", str);
		Assert.assertEquals(res.crc, res2.crc);
		Assert.assertEquals(42, res2.revision);
		file.delete();
	}
}
