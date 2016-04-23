package net.runelite.cache;

import java.io.File;
import java.io.IOException;
import org.junit.Test;

public class NpcDumperTest
{
	@Test
	public void test() throws IOException
	{
		NpcDumper dumper = new NpcDumper(
			new File("d:/rs/07/cache"),
			new File("d:/rs/07/cache/npcs"),
			new File("d:/rs/07/cache")
		);
		dumper.load();
		dumper.dump();
		dumper.java();
	}

}
