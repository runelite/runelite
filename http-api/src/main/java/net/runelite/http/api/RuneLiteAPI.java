/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.http.api;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuneLiteAPI
{
	private static final Logger logger = LoggerFactory.getLogger(RuneLiteAPI.class);

	public static final String RUNELITE_AUTH = "RUNELITE-AUTH";

	public static final OkHttpClient CLIENT = new OkHttpClient();
	public static final Gson GSON = new Gson();

	private static final String BASE = "https://api.runelite.net/runelite-";
	private static final String WSBASE = "wss://api.runelite.net/runelite-";
	private static final String STATICBASE = "https://static.runelite.net";
	private static final Properties properties = new Properties();
	private static String version;
	private static int rsVersion;

	static
	{
		try
		{
			InputStream in = RuneLiteAPI.class.getResourceAsStream("/runelite.properties");
			properties.load(in);

			version = properties.getProperty("runelite.version");
			rsVersion = Integer.parseInt(properties.getProperty("rs.version"));
		}
		catch (NumberFormatException e)
		{
			throw new RuntimeException("Version string has not been substituted; Re-run maven");
		}
		catch (IOException ex)
		{
			logger.error(null, ex);
		}
	}

	public static HttpUrl getApiBase()
	{
		return HttpUrl.parse(BASE + getVersion());
	}

	public static HttpUrl getStaticBase()
	{
		return HttpUrl.parse(STATICBASE);
	}

	public static String getWsEndpoint()
	{
		return WSBASE + getVersion() + "/ws";
	}

	public static String getVersion()
	{
		return version;
	}

	public static void setVersion(String version)
	{
		RuneLiteAPI.version = version;
	}

	public static int getRsVersion()
	{
		return rsVersion;
	}

}
