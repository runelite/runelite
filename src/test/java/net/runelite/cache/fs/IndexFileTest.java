package net.runelite.cache.fs;

import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class IndexFileTest
{
	@Test
	public void test1() throws IOException
	{
		File file = new File("d:/rs/07/test/test.dat");
		IndexFile index = new IndexFile(5, file);
		IndexEntry entry = new IndexEntry(index, 7, 8, 9);
		index.write(entry);
		IndexEntry entry2 = index.read(7);
		Assert.assertEquals(entry, entry2);
	}
}
