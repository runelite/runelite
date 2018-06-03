package net.runelite.client.plugins.performance.ping;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MacPinger extends RuntimeCommandPinger
{
	private Pattern pattern = Pattern.compile("time=([0-9.]+) (m?s)");

	@Override
	String[] formatCommand(String address)
	{
		// No need for string interpolation if you do it as an array
		return new String[]{
			"ping",
			"-c",
			"1", // only one count
			"-W",
			"5000", // max timeout 5 seconds
			address
		};
	}

	@Override
	int parsePingFromLine(String line)
	{
		Matcher lineMatch = pattern.matcher(line);

		if (lineMatch.find())
		{
			float value = Float.parseFloat(lineMatch.group(1));
			TimeUnit unit = "ms".equalsIgnoreCase(lineMatch.group(2))
				? TimeUnit.MILLISECONDS
				: TimeUnit.SECONDS;
			return Math.toIntExact(unit.convert((long)value, TimeUnit.MILLISECONDS));
		}

		return -1;
	}
}
