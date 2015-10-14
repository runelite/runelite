package net.runelite.cache.fs;

import java.io.IOException;
import org.junit.Test;

public class StoreLoadTest
{
	@Test
	public void test() throws IOException
	{
		Store store = new Store(new java.io.File("c:/rs/cache"));
		store.load();
	}
}
