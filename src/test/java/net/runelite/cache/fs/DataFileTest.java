package net.runelite.cache.fs;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class DataFileTest
{
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
  
	@Test
	public void test1() throws IOException
	{
		File file = folder.newFile();
		Store store = new Store(folder.getRoot());
		DataFile df = new DataFile(store, 42, file);
		int sector = df.write(3, ByteBuffer.wrap("test".getBytes()));
		ByteBuffer buf = df.read(3, sector, 4);
		String str = new String(buf.array());
		Assert.assertEquals("test", str);
		file.delete();
	}
	
	@Test
	public void test2() throws IOException
	{
		byte[] b = new byte[1024];
		for (int i = 0; i < 1024; ++i) b[i] = (byte) i;
		
		File file = folder.newFile();
		Store store = new Store(folder.getRoot());
		DataFile df = new DataFile(store, 42, file);
		int sector = df.write(0x1FFFF, ByteBuffer.wrap(b));
		ByteBuffer buf = df.read(0x1FFFF, sector, b.length);
		Assert.assertArrayEquals(b, buf.array());
		file.delete();
	}
}
