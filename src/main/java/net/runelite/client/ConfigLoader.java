package net.runelite.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class ConfigLoader
{
	private static URL configURL;
	
	public static final String CODEBASE = "codebase";
	public static final String INITIAL_JAR = "initial_jar";
	public static final String INITIAL_CLASS = "initial_class";
	public static final String APP_MINWIDTH = "applet_minwidth";
	public static final String APP_MINHEIGHT = "applet_minheight";
	
	private final Map<String, String> properties = new HashMap<>(),
		appletProperties = new HashMap<>();
	
	static
	{
		try
		{
			configURL = new URL("http://192.168.1.2/rs/jav_config.ws");
			//configURL = new URL("http://oldschool1.runescape.com/jav_config.ws"); // https redirects us to rs3
		}
		catch (MalformedURLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void fetch() throws IOException
	{
		URLConnection conn = configURL.openConnection();
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
