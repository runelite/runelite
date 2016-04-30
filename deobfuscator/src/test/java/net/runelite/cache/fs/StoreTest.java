package net.runelite.cache.fs;

import java.io.IOException;
import java.util.Random;
import net.runelite.cache.StoreLocation;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class StoreTest
{
	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();
	
	@Test
	public void testOneFile() throws IOException
	{
		try (Store store = new Store(folder.getRoot()))
		{
			Index index = store.addIndex(0);
			Archive archive = index.addArchive(0);
			File file = archive.addFile(0);
			file.setNameHash(7);
			file.setContents("test".getBytes());

			store.save();
		
			try (Store store2 = new Store(folder.getRoot()))
			{
				store2.load();
				
				Assert.assertEquals(store, store2);
			}
		}
	}
	
	private static final int NUMBER_OF_FILES = 1024;
	
	@Test
	public void testManyFiles() throws IOException
	{
		Random random = new Random(42L);

		try (Store store = new Store(folder.getRoot()))
		{
			Index index = store.addIndex(0);
			Archive archive = index.addArchive(0);
			archive.setNameHash(random.nextInt());
			
			for (int i = 0; i < NUMBER_OF_FILES; ++i)
			{
				File file = archive.addFile(i);
				file.setNameHash(random.nextInt());
				byte[] data = new byte[random.nextInt(1024)];
				random.nextBytes(data);
				file.setContents(data);
			}
			
			store.save();
			
			try (Store store2 = new Store(folder.getRoot()))
			{
				store2.load();
				
				Assert.assertEquals(store, store2);
			}
		}
	}
	
	@Test
	public void testMultipleArchives() throws IOException
	{
		Random random = new Random(43L);

		try (Store store = new Store(folder.getRoot()))
		{
			Index index = store.addIndex(0);
			Index index2 = store.addIndex(1);
			
			Archive archive = index.addArchive(0);
			archive.setNameHash(random.nextInt());
			
			Archive archive2 = index.addArchive(1);
			
			Archive archive3 = index2.addArchive(0);
			
			for (int i = 0; i < NUMBER_OF_FILES; ++i)
			{
				File file = archive.addFile(i);
				file.setNameHash(random.nextInt());
				byte[] data = new byte[random.nextInt(1024)];
				random.nextBytes(data);
				file.setContents(data);
			}
			
			for (int i = 0; i < NUMBER_OF_FILES; ++i)
			{
				File file = archive2.addFile(i);
				file.setNameHash(random.nextInt());
				byte[] data = new byte[random.nextInt(1024)];
				random.nextBytes(data);
				file.setContents(data);
			}
			
			for (int i = 0; i < NUMBER_OF_FILES; ++i)
			{
				File file = archive3.addFile(i);
				file.setNameHash(random.nextInt());
				byte[] data = new byte[random.nextInt(1024)];
				random.nextBytes(data);
				file.setContents(data);
			}
			
			store.save();
			
			try (Store store2 = new Store(folder.getRoot()))
			{
				store2.load();
				
				Assert.assertEquals(store, store2);
			}
		}
	}
}
