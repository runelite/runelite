package net.runelite.client.plugins.menuentryswapper;

import com.google.common.base.Splitter;

public class Parse
{
	public static boolean parse(String value)
	{
		try
		{
			Splitter NEWLINE_SPLITTER = Splitter
				.on("\n")
				.omitEmptyStrings()
				.trimResults();

			NEWLINE_SPLITTER.withKeyValueSeparator(':').split(value);
			return true;
		}
		catch (IllegalArgumentException ex)
		{
			return false;
		}
	}
}
