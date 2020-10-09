/*
 * Copyright (c) 2018, Joshua Filby <joshua@filby.me>
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.util;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.text.WordUtils;
import org.apache.commons.text.similarity.JaroWinklerDistance;

/**
 * A set of utilities to use when dealing with text.
 */
public class Text
{
	private static final JaroWinklerDistance DISTANCE = new JaroWinklerDistance();
	private static final Pattern TAG_REGEXP = Pattern.compile("<[^>]*>");
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
	 */
	public static String removeTags(String str)
	{
		return TAG_REGEXP.matcher(str).replaceAll("");
	}

	/**
	 * Remove tags from the given string, except for &lt;lt&gt; and &lt;gt&gt;
	 *
	 * @param str The string to remove formatting tags from.
	 * @return The given string with all formatting tags removed from it.
	 */
	public static String removeFormattingTags(String str)
	{
		StringBuffer stringBuffer = new StringBuffer();
		Matcher matcher = TAG_REGEXP.matcher(str);
		while (matcher.find())
		{
			matcher.appendReplacement(stringBuffer, "");
			String match = matcher.group(0);
			switch (match)
			{
				case "<lt>":
				case "<gt>":
					stringBuffer.append(match);
					break;
			}
		}
		matcher.appendTail(stringBuffer);
		return stringBuffer.toString();
	}

	/**
	 * In addition to removing all tags, replaces nbsp with space, trims string and lowercases it
	 * @param str The string to standardize
	 *
	 * @return The given `str` that is standardized
	 */
	public static String standardize(String str)
	{
		return removeTags(str).replace('\u00A0', ' ').trim().toLowerCase();
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
		return CharMatcher.ascii().retainFrom(str.replace('\u00A0', ' ')).replaceAll("[_-]+", " ").trim();
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
	 * @return  the enum's name in title case,
	 *          or if it overrides toString,
	 *          the value returned by toString
	 */
	public static String titleCase(Enum o)
	{
		String toString = o.toString();

		// .toString() returns the value of .name() if not overridden
		if (o.name().equals(toString))
		{
			return WordUtils
				.capitalize(toString.toLowerCase(), '_')
				.replace("_", " ");
		}

		return toString;
	}

	/**
	 * Checks if all the search terms in the given list matches at least one keyword.
	 *
	 * @return true if all search terms matches at least one keyword, or false if otherwise.
	 */
	public static boolean matchesSearchTerms(Iterable<String> searchTerms, final Collection<String> keywords)
	{
		for (String term : searchTerms)
		{
			if (keywords.stream().noneMatch((t) -> t.contains(term) ||
				DISTANCE.apply(t, term) > 0.9))
			{
				return false;
			}
		}
		return true;
	}
}
