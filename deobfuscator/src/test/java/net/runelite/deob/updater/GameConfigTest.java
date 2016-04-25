package net.runelite.deob.updater;

import java.io.IOException;
import org.junit.Test;

public class GameConfigTest
{
	@Test
	public void testGetAppletProperties() throws IOException
	{
		GameConfig config = new GameConfig();
		config.fetch();
		System.out.println(config.getProperties());
		System.out.println(config.getAppletProperties());
	}

}
