package net.runelite.client.plugins.tmorph;

import com.google.common.base.Splitter;
import java.util.Arrays;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
public class Parse
{
	public static boolean parse(String value)
	{
		try
		{
			final StringBuilder sb = new StringBuilder();

			for (String str : value.split("\n"))
			{
				if (!str.startsWith("//"))
				{
					sb.append(str).append("\n");
				}
			}

			final Splitter NEWLINE_SPLITTER = Splitter
				.on("\n")
				.omitEmptyStrings()
				.trimResults();

			final Map<String, String> tmp = NEWLINE_SPLITTER.withKeyValueSeparator(':').split(sb);

			for (Map.Entry<String, String> entry : tmp.entrySet())
			{
				if (!TMorph.getKit().containsKey(entry.getValue()))
				{
					return false;
				}

				int[] ints = Arrays.stream(entry.getKey().split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();

				if (ints.length <= 1)
				{
					return false;
				}
			}

			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
}
