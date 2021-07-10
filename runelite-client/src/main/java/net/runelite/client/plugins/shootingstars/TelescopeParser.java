/*
 * Copyright (c) 2021, Hexagon <hexagon@fking.work>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.shootingstars;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TelescopeParser
{
	private static final Pattern TIME_PATTERN = Pattern.compile("(\\d+) ?(hours?|minutes?)?");

	private static final String START_OF_TIME = "in the next ";
	private static final String TIME_SEPARATOR = " to ";

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
		int start = text.indexOf(START_OF_TIME) + START_OF_TIME.length();
		int separator = text.lastIndexOf(TIME_SEPARATOR);

		String earliest = text.substring(start, separator).trim();
		String latest = text.substring(separator + TIME_SEPARATOR.length()).trim();

		Duration earliestDuration = parseDuration(earliest);
		Duration latestDuration = parseDuration(latest);

		Duration delta = latestDuration.minus(earliestDuration);

		return earliestDuration.plus(delta.dividedBy(2));
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
