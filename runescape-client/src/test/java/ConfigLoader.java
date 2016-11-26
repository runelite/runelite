/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigLoader
{
	private static final Logger logger = LoggerFactory.getLogger(ConfigLoader.class);

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
			configURL = new URL("http://oldschool1.runescape.com/jav_config.ws"); // https redirects us to rs3
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

					String value = str.substring(idx + 1);

					appletProperties.put(s, value);

					logger.info("Param: {} -> {}", s, value);
				}
				else if (s.equals("msg"))
				{
					// ignore
				}
				else
				{
					String value = str.substring(idx + 1);

					properties.put(s, value);

					logger.info("Property: {} -> {}", s, value);
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
