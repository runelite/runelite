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

import com.google.common.base.Strings;
import java.awt.FontMetrics;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import java.util.Collection;
import java.util.List;

/**
 * A set of utilities to use when dealing with text.
 */
public class Text
{
	private static final Pattern TAG_REGEXP = Pattern.compile("<[^>]*>");
	private static final Splitter COMMA_SPLITTER = Splitter
			.on(",")
			.omitEmptyStrings()
			.trimResults();

	private static final Joiner COMMA_JOINER = Joiner.on(",").skipNulls();

	/**
	 * Gets the width of the given string ignoring tags.
	 * <p>
	 * Doesn't 'care' if a tag isn't usable, will ignore anything
	 * that matches {@link #TAG_REGEXP}
	 *
	 * @param text    The string to check
	 * @param metrics {@link FontMetrics}
	 * @return Width of given string, in pixels
	 */
	public static int getWidth(@Nonnull FontMetrics metrics, @Nullable String text)
	{
		return metrics.stringWidth(removeTags(Strings.nullToEmpty(text)));
	}

	/**
	 * Get the width of the largest string in the specified array.
	 * The width is returned based on the value recieved from {@link FontMetrics#stringWidth(String)},
	 * the largest returned value from the given array is returned.
	 * <p>
	 * Doesn't 'care' if a tag isn't usable, will ignore anything
	 * that matches {@link #TAG_REGEXP}
	 *
	 * @param metrics {@link FontMetrics}
	 * @param lines   Array of strings to check
	 * @return Maximum width of provided strings, in pixels
	 */
	public static int getMaxWidth(@Nonnull FontMetrics metrics, @Nonnull String... lines)
	{
		return getMaxWidth(metrics, 0, lines);
	}

	/**
	 * Get the width of the largest string in the specified array.
	 * The width is returned based on the value recieved from {@link FontMetrics#stringWidth(String)},
	 * the largest returned value from the given array is returned.
	 *
	 * @param metrics    {@link FontMetrics}
	 * @param startIndex The index to start the check
	 * @param lines      Array of strings to check
	 * @return Maximum width of provided strings, in pixels
	 */
	public static int getMaxWidth(@Nonnull FontMetrics metrics, int startIndex, @Nonnull String... lines)
	{
		return startIndex < lines.length ? Math.max(getWidth(metrics, lines[startIndex]), getMaxWidth(metrics, ++startIndex, lines)) : getWidth(metrics, lines[0]);
	}

	/**
	 * Create an array of width specific lines using the provided maximum width {@link FontMetrics} object and line separator.
	 * <p>
	 * Valid tags will not count towards the maximum width, the formatted string will prefer to wrap on spaces instead of
	 * splitting the middle of a word. If a word has to be split it will split on the last character before maximum width is
	 * achieved. {@code #maxWidth}
	 *
	 * @param text     Text to format
	 * @param maxWidth Maximum width in pixels
	 * @param metrics  {@link FontMetrics}
	 * @return An array containing width formatted strings
	 */
	public static String[] splitToWidth(@Nonnull String text, int maxWidth, @Nonnull FontMetrics metrics)
	{
		return formatToWidth(text, maxWidth, metrics, "\n").split("\n");
	}

	/**
	 * Format a given string to a specified width using the provided {@link FontMetrics} object and line separator.
	 * <p>
	 * This method will return a String which will be separated using a provided line separator and will be within the given
	 * maximum width for a font represented in the FontMetrics object.
	 * <p>
	 * Valid tags will not count towards the maximum width, the formatted string will 'prefer' to wrap on spaces instead of
	 * splitting the middle of a word. If a word has to be split it will split on the last character before maximum width is
	 * achieved.
	 *
	 * @param text          Text to format
	 * @param maxWidth      Maximum width in pixels
	 * @param metrics       {@link FontMetrics}
	 * @param lineSeparator Line separator
	 * @return Formatted string
	 */
	public static String formatToWidth(@Nonnull String text, int maxWidth, @Nonnull FontMetrics metrics, @Nonnull String lineSeparator)
	{
		int maxChars = getMaxWidthIndex(text, maxWidth, metrics);

		if (text.length() <= maxChars)
		{
			return text;
		}
		else
		{
			char charAt = text.charAt(maxChars);
			boolean newLine = charAt == ' ';
			String substring = text.substring(maxChars + (newLine ? 1 : 0));
			return text.substring(0, maxChars) + lineSeparator + formatToWidth(substring, maxWidth, metrics, lineSeparator);
		}
	}

	/**
	 * Get the index of a given string that will comply with the provided maximum width.
	 * This will prefer to split on a space instead in the middle of a word.
	 *
	 * @param text     Text to check
	 * @param maxWidth Maximum width in pixels
	 * @param metrics  The font metrics object
	 * @return Index of maximum achievable width
	 */
	private static int getMaxWidthIndex(@Nonnull String text, int maxWidth, @Nonnull FontMetrics metrics)
	{
		int length = text.length();
		int currentStringWidth = 0;
		int index = 0;
		int spaceIndex = -1;

		boolean insideTag = false;

		for (; index < length; ++index)
		{
			char currentChar = text.charAt(index);

			switch (currentChar)
			{
				case '<':
					insideTag = true;
					continue;
				case '>':
					insideTag = false;
					continue;
				case ' ':
					spaceIndex = index;
					break;
			}

			if (!insideTag)
			{
				currentStringWidth += metrics.charWidth(currentChar);
			}

			if (currentStringWidth > maxWidth)
			{
				break;
			}
		}

		return index != length && spaceIndex != -1 && spaceIndex < index ? spaceIndex : index;
	}

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
}
