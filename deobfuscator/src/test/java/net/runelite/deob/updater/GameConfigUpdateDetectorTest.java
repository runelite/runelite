package net.runelite.deob.updater;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class GameConfigUpdateDetectorTest
{
	@Test
	public void testHasUpdated() throws IOException
	{
		GameConfig c1 = new GameConfig(), c2 = new GameConfig();
		c1.fetch();
		c2.fetch();

		GameConfigUpdateDetector gcu = new GameConfigUpdateDetector(c1, c2);
		Assert.assertFalse(gcu.hasUpdated());
	}

}
