package net.runelite.cache.fs;

import java.io.IOException;
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
		System.setProperty("java.io.tmpdir", "d:/temp");
	}
	
	@Test
	public void testCreate() throws IOException
	{
		Store store = new Store(folder.getRoot());
	}
}
