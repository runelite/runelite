package net.runelite.deob.updater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class GameConfig
{
	private static final String URL = "http://oldschool.runescape.com/jav_config.ws"; // https redirects to rs3

	private final Map<String, String> properties = new HashMap<>(),
		appletProperties = new HashMap<>();

	public void fetch() throws IOException
	{
		URLConnection conn = new URL(URL).openConnection();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream())))
		{
			String str;

			while ((str = in.readLine()) != null)
			{
				int idx = str.indexOf('=');

				if (idx == -1)
					continue;

				String s = str.substring(0, idx);

				if (s.equals("param"))
				{
					str = str.substring(idx + 1);
					idx = str.indexOf('=');
					s = str.substring(0, idx);

					appletProperties.put(s, str.substring(idx + 1));
				}
				else if (s.equals("msg"))
				{
					// ignore
				}
				else
				{
					properties.put(s, str.substring(idx + 1));
				}
			}
		}
	}

	public String getProperty(String name)
	{
		return properties.get(name);
	}

	public Map<String, String> getProperties()
	{
		return properties;
	}

	public String getAppletProperty(String name)
	{
		return appletProperties.get(name);
	}

	public Map<String, String> getAppletProperties()
	{
		return appletProperties;
	}
}
