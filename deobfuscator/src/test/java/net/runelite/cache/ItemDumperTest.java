package net.runelite.cache;

import java.io.File;
import java.io.IOException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemDumperTest
{
	private static final Logger logger = LoggerFactory.getLogger(ItemDumperTest.class);

	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	@Test
	public void test() throws IOException
	{
		File dumpDir = folder.newFolder(),
			javaDir = folder.newFolder();

		ItemDumper dumper = new ItemDumper(
			StoreLocation.LOCATION,
			dumpDir,
			javaDir
		);
		dumper.load();
		dumper.dump();
		dumper.java();

		logger.info("Dumped to {}, java {}", dumpDir, javaDir);
	}

}
