package net.runelite.client.plugins.shootingstars;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TelescopeParser
{
	private static final Pattern TIME_PATTERN = Pattern.compile("(\\d+) ?(hours?|minutes?)?");

	private static final String START_OF_TIME = "in the next";
	private static final String TIME_SEPARATOR = "to";

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
		int start = text.lastIndexOf(START_OF_TIME);
		int separator = text.lastIndexOf("to");

		return parseDuration(text.substring(start, separator).trim());
	}

	private static Duration parseDuration(String text)
	{
		Matcher matcher = TIME_PATTERN.matcher(text);
		Duration duration = Duration.ZERO;

		while (matcher.find())
		{
			String valueString = matcher.group(1);
			String unit = matcher.group(2);

			if (unit == null)
			{
				unit = "minutes";
			}
			long value = Long.parseLong(valueString);
			Duration parsedDuration = unit.startsWith("minute") ? Duration.ofMinutes(value) : Duration.ofHours(value);
			duration = duration.plus(parsedDuration);
		}
		return duration;
	}
}
