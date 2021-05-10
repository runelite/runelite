package net.runelite.client.plugins.shootingstars;

import java.time.Duration;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TelescopeParser
{
	private static final Pattern TIME_PATTERN = Pattern.compile("\\d+ ?(hours?|minutes?)?");

	public static StarRegion extractStarRegion(String text)
	{
		text = text.replace("<br>", " ");
		for (StarRegion region : StarRegion.values())
		{
			if (text.contains(region.getName()))
			{
				return region;
			}
		}
		return null;
	}

	public static Duration extractDuration(String text)
	{
		text = text.replace("<br>", " ");
		return null;
	}
}
