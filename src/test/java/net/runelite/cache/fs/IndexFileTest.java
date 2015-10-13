package net.runelite.cache.fs;

import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class IndexFileTest
{
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	@Test
	public void test1() throws IOException
	{
		File file = folder.newFile();
		Store store = new Store(folder.getRoot());
		IndexFile index = new IndexFile(store, 5, file);
		IndexEntry entry = new IndexEntry(index, 7, 8, 9);
		index.write(entry);
		IndexEntry entry2 = index.read(7);
		Assert.assertEquals(entry, entry2);
	}
}
