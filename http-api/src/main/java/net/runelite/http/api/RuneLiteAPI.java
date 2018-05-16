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
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

@Slf4j
public class RuneLiteAPI
{
	public static final String RUNELITE_AUTH = "RUNELITE-AUTH";
	public static final OkHttpClient CLIENT = new OkHttpClient();
	public static final Gson GSON = new Gson();

	private static String VERSION;
	private static int RS_VERSION;
	private static String HTTP_URL;
	private static String WS_URL;

	static
	{
		try
		{
			final Properties properties = new Properties();
			final InputStream in = RuneLiteAPI.class.getResourceAsStream("/runelite.properties");
			properties.load(in);

			VERSION = properties.getProperty("runelite.version");
			RS_VERSION = Integer.parseInt(properties.getProperty("rs.version"));
			HTTP_URL = properties.getProperty("url.http");
			WS_URL = properties.getProperty("url.ws");
		}
		catch (NumberFormatException e)
		{
			throw new RuntimeException("Version string has not been substituted; Re-run maven");
		}
		catch (IOException ex)
		{
			log.error(null, ex);
		}
	}

	public static HttpUrl getApiBase()
	{
		return HttpUrl.parse(HTTP_URL);
	}

	public static HttpUrl getWsEndpoint()
	{
		return HttpUrl.parse(WS_URL + "/ws");
	}

	public static String getVersion()
	{
		return VERSION;
	}

	public static int getRsVersion()
	{
		return RS_VERSION;
	}
}