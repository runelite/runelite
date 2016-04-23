package net.runelite.cache;

import java.io.File;
import java.io.IOException;
import org.junit.Test;

public class ItemDumperTest
{
	@Test
	public void test() throws IOException
	{
		ItemDumper dumper = new ItemDumper(
			new File("d:/rs/07/cache"),
			new File("d:/rs/07/cache/items"),
			new File("d:/rs/07/cache")
		);
		dumper.load();
		dumper.dump();
		dumper.java();
	}

}
