package net.runelite.api.util;

import org.apache.commons.lang3.StringUtils;

public class Text
{
	private static final StringBuilder SB = new StringBuilder(32);
	/**
	 * Removes all tags from the given string.
	 *
	 * @param str The string to remove tags from.
	 * @return The given string with all tags removed from it.
	 *
	 * I know this is a monstrosity, but old frankenstein here
	 * is twice as fast as the old regex method was.
	 * Seems worth it to me
	 */
	public static String removeTags(String str, boolean removeLevel)
	{
		int strLen = str.length();
		if (removeLevel)
		{
			if (str.charAt(strLen - 1) == ')')
			{
				int levelStart = StringUtils.lastIndexOf(str, '(');
				// if it's not in the string the while will act like a if
				while (--levelStart >= 0)
				{
					if (str.charAt(levelStart) != ' ')
					{
						strLen = levelStart;
					}
				}
			}
		}

		int open, close;
		if ((open = StringUtils.indexOf(str, '<')) == -1
			|| (close = StringUtils.indexOf(str, '>', open)) == -1)
		{
			return strLen == str.length() ? str : StringUtils.left(str, strLen);
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

}
