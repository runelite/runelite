package net.runelite.client.rs;

import java.applet.AppletContext;
import java.applet.AppletStub;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class PrivateRSAppletStub implements AppletStub
{

	public static final Logger logger = Logger.getLogger(RSAppletStub.class.getSimpleName());

	private static final HashMap<String, String> params = new HashMap<String, String>();
	private static final HashMap<String, String> cfg = new HashMap<String, String>();
	private static URL codebase;

	public PrivateRSAppletStub()
	{
		try
		{
			parseParams(new FileInputStream(new File("./params.txt")));
			String worldListKey = null;
			for (Map.Entry<String, String> paramEntry : params.entrySet())
			{
				String key = paramEntry.getKey();
				String value = paramEntry.getValue();
				if (value.contains("slr.ws"))
				{
					worldListKey = key;
					break;
				}
			}
			codebase = new URL("http://runeliteplus-ps.ddns.net"); //host
			params.put(worldListKey, "http://" + codebase.getHost());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static void parseParams(InputStream stream) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
		String line;
		while ((line = br.readLine()) != null)
		{
			int idx = line.indexOf('=');
			if (idx != -1)
			{
				String key = line.substring(0, idx);
				String val = line.substring(idx + 1);
				if (key.equals("param"))
				{
					idx = val.indexOf('=');
					key = val.substring(0, idx);
					val = val.substring(idx + 1);
					params.put(key, val);
				}
				else
				{
					cfg.put(key, val);
				}
			}
		}
	}

	public static void log(String format, Object... params)
	{
		System.out.printf(format + "\n", params);
	}

	@Override
	public boolean isActive()
	{
		return false;
	}

	@Override
	public URL getDocumentBase()
	{
		return codebase;
	}

	@Override
	public URL getCodeBase()
	{
		return codebase;
	}

	@Override
	public String getParameter(String name)
	{
		return params.get(name);
	}

	@Override
	public AppletContext getAppletContext()
	{
		return null;
	}

	@Override
	public void appletResize(int width, int height)
	{
	}
}