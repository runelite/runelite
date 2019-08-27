/*
 * Copyright (c) 2018, Joshua Filby <joshua@filby.me>
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
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
package net.runelite.api.util;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import java.util.Collection;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

public class Text
{
	private static final StringBuilder SB = new StringBuilder(64);

	private static final Splitter COMMA_SPLITTER = Splitter
		.on(",")
		.omitEmptyStrings()
		.trimResults();

	private static final Joiner COMMA_JOINER = Joiner.on(",").skipNulls();

	public static final CharMatcher JAGEX_PRINTABLE_CHAR_MATCHER = new JagexPrintableCharMatcher();

	/**
	 * Splits comma separated values to list of strings
	 *
	 * @param input input
	 * @return list of values
	 */
	public static List<String> fromCSV(final String input)
	{
		return COMMA_SPLITTER.splitToList(input);
	}

	/**
	 * Joins collection of strings as comma separated values
	 *
	 * @param input collection
	 * @return comma separated value string
	 */
	public static String toCSV(final Collection<String> input)
	{
		return COMMA_JOINER.join(input);
	}

	/**
	 * Removes all tags from the given string.
	 *
	 * @param str The string to remove tags from.
	 * @return The given string with all tags removed from it.
	 *
	 * I know this is a monstrosity, but old frankenstein here
	 * is twice as fast as the old regex method was.
	 * Seems worth it to me
	 *
	 * Having removeLevels true removes the "  (level-xxx)" from text
	 * as well. This should obviously only be used for this purpose.
	 */
	public static String removeTags(String str, boolean removeLevels)
	{
		int strLen = str.length();
		if (removeLevels)
		{
			int levelIdx =  StringUtils.lastIndexOf(str, "  (level");
			if (levelIdx >= 0)
			{
				strLen = levelIdx;
			}
		}

		int open, close;
		if ((open = StringUtils.indexOf(str, '<')) == -1
			|| (close = StringUtils.indexOf(str, '>', open)) == -1)
		{
			return strLen == str.length() ? str : str.substring(0, strLen - 1);
		}

		// If the string starts with a < we can maybe take a shortcut if this
		// is the only tag in the string (take the substring after it)
		if (open == 0)
		{
			if ((open = close + 1) >= strLen)
			{
				return "";
			}

			if ((open = StringUtils.indexOf(str, '<', open)) == -1
				|| (StringUtils.indexOf(str, '>', open)) == -1)
			{
				return StringUtils.substring(str, close + 1);
			}

			// Whoops, at least we know the last value so we can go back to where we were
			// before :)
			open = 0;
		}

		SB.setLength(0);
		int i = 0;
		do
		{
			while (open != i)
			{
				SB.append(str.charAt(i++));
			}

			i = close + 1;
		}
		while ((open = StringUtils.indexOf(str, '<', close)) != -1
			&& (close = StringUtils.indexOf(str, '>', open)) != -1
			&& i < strLen);

		while (i < strLen)
		{
			SB.append(str.charAt(i++));
		}

		return SB.toString();
	}

	public static String removeTags(String str)
	{
		return removeTags(str, false);
	}


	/**
	 * In addition to removing all tags, replaces nbsp with space, trims string and lowercases it
	 *
	 * @param str The string to standardize
	 * @return The given `str` that is standardized
	 */
	public static String standardize(String str, boolean removeLevel)
	{
		if (StringUtils.isBlank(str))
		{
			return str;
		}

		return removeTags(str, removeLevel).replace('\u00A0', ' ').trim().toLowerCase();
	}

	public static String standardize(String str)
	{
		return standardize(str, false);
	}

	/**
	 * Convert a string into Jagex username format
	 * Remove all non-ascii characters, replace nbsp with space, replace _- with spaces, and trim
	 *
	 * @param str The string to standardize
	 * @return The given `str` that is in Jagex name format
	 */
	public static String toJagexName(String str)
	{
		char[] chars = str.toCharArray();
		int newIdx = 0;

		for (int oldIdx = 0, strLen = str.length(); oldIdx < strLen; oldIdx++)
		{
			char c = chars[oldIdx];

			// take care of replacing and trimming in 1 go
			if (c == '\u00A0' || c == '-' || c == '_' || c == ' ')
			{
				if (oldIdx == strLen - 1 || newIdx == 0 || chars[newIdx - 1] == ' ')
				{
					continue;
				}

				c = ' ';
			}

			// 0 - 127 is valid ascii
			if (c > 127)
			{
				continue;
			}

			chars[newIdx++] = c;
		}

		return new String(chars, 0, newIdx);
	}

	/**
	 * In addition to removing all tags, replaces all &lt;br&gt; delimited text with spaces and all multiple continuous
	 * spaces with single space
	 *
	 * @param str The string to sanitize
	 * @return sanitized string
	 */
	public static String sanitizeMultilineText(String str)
	{
		return removeTags(str
			.replaceAll("-<br>", "-")
			.replaceAll("<br>", " ")
			.replaceAll("[ ]+", " "));
	}

	/**
	 * Escapes a string for widgets, replacing &lt; and &gt; with their escaped counterparts
	 */
	public static String escapeJagex(String str)
	{
		StringBuilder out = new StringBuilder(str.length());

		for (int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if (c == '<')
			{
				out.append("<lt>");
			}
			else if (c == '>')
			{
				out.append("<gt>");
			}
			else if (c == '\n')
			{
				out.append("<br>");
			}
			else if (c != '\r')
			{
				out.append(c);
			}
		}

		return out.toString();
	}

	/**
	 * Cleans the ironman status icon from playername string if present and
	 * corrects spaces.
	 *
	 * @param name Playername to lookup.
	 * @return Cleaned playername.
	 */
	public static String sanitize(String name)
	{
		String cleaned = name.contains("<img") ? name.substring(name.lastIndexOf('>') + 1) : name;
		return cleaned.replace('\u00A0', ' ');
	}

	/**
	 * If passed in enum doesn't implement its own toString,
	 * converts enum name format from THIS_FORMAT to This Format.
	 *
	 * @param o an enum
	 * @return the enum's name in title case,
	 * or if it overrides toString,
	 * the value returned by toString
	 */
	public static String titleCase(Enum o)
	{
		String toString = o.toString();

		// .toString() returns the value of .name() if not overridden
		if (o.name().equals(toString))
		{
			return WordUtils
				.capitalize(toString.toLowerCase(), '_')
				.replace('_', ' ');
		}

		return toString;
	}
}
