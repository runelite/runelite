package net.runelite.cache.fs;

import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class StoreTest
{
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	@BeforeClass
	public static void before()
	{
		System.setProperty("java.io.tmpdir", "c:/rs/temp");
	}
	
	@Test
	public void test() throws IOException
	{
		Store store = new Store(folder.getRoot());
		Index index = store.addIndex(0);
		Archive archive = index.addArchive(0);
		File file = archive.addFile(0);
		file.setContents("test".getBytes());
		
		store.save();
		
		store.close();
		
		store = new Store(folder.getRoot());
		store.load();
		
		List<Index> indexes = store.getIndexes();
		Assert.assertEquals(1, indexes.size());
		
		index = indexes.get(0);
		List<Archive> archives = index.getArchives();
		Assert.assertEquals(1, archives.size());
		
		archive = archives.get(0);
		List<File> files = archive.getFiles();
		// XXX just use equals methods on store duh
		//archive.
		
		File file2 = files.get(0);
		
		Assert.assertArrayEquals(file.getContents(), file2.getContents());
		
		System.out.println(store);
	}
}
