package net.runelite.client;

import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author Adam
 */
public class ConfigLoaderTest
{
	@Test
	public void test() throws IOException
	{
		ConfigLoader loader = new ConfigLoader();
		loader.fetch();

		for (String key : loader.getProperties().keySet())
			System.out.println(key + ": " + loader.getProperty(key));

		System.out.println("Applet properties:");

		for (String key : loader.getAppletProperties().keySet())
			System.out.println(key + ": " + loader.getAppletProperty(key));
	}

}
