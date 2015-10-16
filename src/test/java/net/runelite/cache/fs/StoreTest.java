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
	public void testOneFile() throws IOException
	{
		try (Store store = new Store(folder.getRoot()))
		{
			Index index = store.addIndex(0);
			Archive archive = index.addArchive(0);
			File file = archive.addFile(0);
			file.setContents("test".getBytes());

			store.save();
		
			try (Store store2 = new Store(folder.getRoot()))
			{
				store2.load();
				
				Assert.assertEquals(store, store2);
			}
		}
	}
}
