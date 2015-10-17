package net.runelite.cache.fs;

import java.io.IOException;
import org.junit.Test;

public class StoreLoadTest
{
	@Test
	public void test() throws IOException
	{
		Store store = new Store(new java.io.File("d:/rs/07/cache"));//c:/rs/cache"));
		store.load();
		System.out.println(store);
	}
}
