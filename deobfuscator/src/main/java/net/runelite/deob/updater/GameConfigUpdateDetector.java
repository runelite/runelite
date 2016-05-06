package net.runelite.deob.updater;

import com.google.common.base.Strings;

public class GameConfigUpdateDetector
{
	private final GameConfig g1, g2;

	public GameConfigUpdateDetector(GameConfig g1, GameConfig g2)
	{
		this.g1 = g1;
		this.g2 = g2;
	}

	public boolean hasUpdated()
	{
		// between game updatesthe parameters are scrambled, so detect when that happens.
		// normally only one parameter changes, which is some integer value (+ the world)
		//
		// N.B. my other idea is to compare content-length in HEAD requests for the gamepack.
		// the httpd doesn't support if-match and does not etag anything, and the last-modified time
		// appears to be constant NOW-1 week (it moves per request)
		
		int differences = 0;

		for (String key : g1.getAppletProperties().keySet())
		{
			String value = g1.getAppletProperty(key), otherValue = g2.getAppletProperty(key);

			if (!Strings.nullToEmpty(value).equals(Strings.nullToEmpty(otherValue)))
				++differences;
		}

		return differences > 2; // random number, world
	}
}
