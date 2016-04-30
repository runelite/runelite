package net.runelite.cache;

import java.io.File;
import java.net.URISyntaxException;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoreLocation
{
	private static final Logger logger = LoggerFactory.getLogger(StoreLocation.class);

	public static File LOCATION;

	static
	{
		try
		{
			LOCATION = new File(StoreLocation.class.getResource("/cache").toURI());
		}
		catch (URISyntaxException ex)
		{
			logger.error(null, ex);
		}

		File tmp = new File("d:/temp");
		if (tmp.exists() || tmp.mkdir())
			System.setProperty("java.io.tmpdir", "d:/temp");
	}

	public static TemporaryFolder getTemporaryFolder()
	{
		return new TemporaryFolder();
	}
}