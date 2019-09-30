package net.runelite.gamepack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Checker
{
	private static final String GAME_URL = "http://oldschool1.runescape.com/";
	private static final Split[] splits = {
		new Split("document.write('archive=", 1),
		new Split(" ');", 0)
	};

	static String getGamePack()
	{
		URL url;
		try
		{
			url = new URL(GAME_URL);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
			return null;
		}

		String content;
		try
		{
			content = getContent(url);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}

		for (Split split : splits)
		{
			String[] str = splitAtFirst(content, split.splitAt);
			content = str[split.index];
		}

		return content;
	}

	private static String[] splitAtFirst(String subject, String splitAt)
	{
		if (subject == null || subject.length() == 0)
		{
			return new String[]{"", ""};
		}

		if (splitAt == null || splitAt.length() == 0)
		{
			return new String[]{subject, ""};
		}

		char[] subjectArray = subject.toCharArray();
		char[] split = splitAt.toCharArray();

		StringBuilder builder = null;
		for (int i = 0; i < subjectArray.length; i++)
		{
			char c = subjectArray[i];

			if (builder == null && c == split[0])
			{
				builder = new StringBuilder();
			}

			if (builder != null)
			{
				builder.append(c);

				if (startsWith(splitAt, builder.toString()))
				{
					if (builder.length() == splitAt.length())
					{
						return new String[]{subject.substring(0, i - builder.length() + 1), subject.substring(i + 1)};
					}
				}
				else
				{
					builder = null;
				}
			}
		}

		return new String[]{subject, ""};
	}

	private static boolean startsWith(String subject, String start)
	{
		if (subject == null || subject.length() == 0 || start == null || start.length() == 0 || start.length() > subject.length())
		{
			return false;
		}

		char[] c1 = subject.toCharArray();
		char[] c2 = start.toCharArray();
		for (int i = 0; i < c2.length; i++)
		{
			if (c1[i] != c2[i])
			{
				return false;
			}
		}

		return true;
	}

	private static String getContent(URL url) throws IOException
	{
		BufferedReader rd = null;

		try
		{
			URLConnection conn = url.openConnection();

			if (conn instanceof HttpURLConnection)
			{
				((HttpURLConnection) conn).setInstanceFollowRedirects(false);
			}

			HttpURLConnection.setFollowRedirects(false);

			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();

			String line;
			while ((line = rd.readLine()) != null)
			{
				sb.append(line);
				sb.append('\n');
			}

			return sb.toString();

		}
		finally
		{
			if (rd != null)
			{
				rd.close();
			}
		}
	}

	public static class Split
	{
		public int index;
		String splitAt;

		Split(String splitAt, int index)
		{
			this.splitAt = splitAt;
			this.index = index;
		}
	}
}