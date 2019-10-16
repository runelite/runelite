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
import com.google.gson.GsonBuilder;
import net.runelite.http.api.item.ItemEquipmentStats;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.ItemStats;
import net.runelite.http.api.util.TypeAdapters;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class RuneLiteAPI
{
	private static final Logger logger = LoggerFactory.getLogger(RuneLiteAPI.class);

	public static final String RUNELITE_AUTH = "RUNELITE-AUTH";

	public static final OkHttpClient CLIENT;
	public static final Gson GSON = new GsonBuilder()
		.setPrettyPrinting()
		.registerTypeAdapter(ItemStats.class, TypeAdapters.ITEMSTATS)
		.registerTypeAdapter(ItemEquipmentStats.class, TypeAdapters.EQUIPMENTSTATS)
		.registerTypeAdapter(ItemPrice.class, TypeAdapters.ITEMPRICE)
		.create();

	private static final String BASE = "https://api.runelite.net";
	private static final String WSBASE = "https://api.runelite.net/ws";
	private static final String STATICBASE = "https://static.runelite.net";

	private static final String OPENOSRS_BASE = /*"https://api.openosrs.com*/ "https://api.runelitepl.us";
	private static final String OPENOSRS_SESSION = "https://session.openosrs.com";
	private static final String MAVEN_METADATA = "http://repo.runelite.net/net/runelite/runelite-parent/maven-metadata.xml";

	private static final Properties properties = new Properties();
	private static String userAgent;

	private static String version;
	private static String upstreamVersion;
	private static int rsVersion;

	static
	{
		try (InputStream in = RuneLiteAPI.class.getResourceAsStream("/runelite.properties"))
		{
			properties.load(in);

			version = properties.getProperty("runelite.version");
			String commit = properties.getProperty("runelite.commit");
			boolean dirty = Boolean.parseBoolean(properties.getProperty("runelite.dirty"));

			userAgent = "OpenOSRS/" + version + "-" + commit + (dirty ? "+" : "");

			rsVersion = Integer.parseInt(properties.getProperty("rs.version"));

			parseMavenVersion();
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
			throw new RuntimeException("Version string has not been substituted; Re-run Gradle");
		}
		catch (IOException ex)
		{
			logger.error(null, ex);
		}

		CLIENT = new OkHttpClient.Builder()
			.pingInterval(30, TimeUnit.SECONDS)
			.addNetworkInterceptor(new Interceptor()
			{
				@Override
				public Response intercept(Chain chain) throws IOException
				{
					Request userAgentRequest = chain.request()
						.newBuilder()
						.header("User-Agent", userAgent)
						.build();
					return chain.proceed(userAgentRequest);
				}
			})
			.build();
	}

	public static HttpUrl getSessionBase()
	{
		return HttpUrl.parse(OPENOSRS_SESSION);
	}

	public static HttpUrl getApiBase()
	{
		final String prop = System.getProperty("runelite.http-service.url");

		if (prop != null && !prop.isEmpty())
		{
			return HttpUrl.parse(prop);
		}

		return HttpUrl.parse(BASE + "/runelite-" + getVersion());
	}

	public static HttpUrl getOpenOSRSApiBase()
	{
		return HttpUrl.parse(OPENOSRS_BASE + "/http-service-" + getRlpVersion());
	}

	public static HttpUrl getStaticBase()
	{
		final String prop = System.getProperty("runelite.static.url");

		if (prop != null && !prop.isEmpty())
		{
			return HttpUrl.parse(prop);
		}

		return HttpUrl.parse(STATICBASE);
	}

	public static HttpUrl getWsEndpoint()
	{
		final String prop = System.getProperty("runelite.ws.url");

		if (prop != null && !prop.isEmpty())
		{
			return HttpUrl.parse(prop);
		}

		return HttpUrl.parse(WSBASE);
	}

	public static String getVersion()
	{
		return upstreamVersion;
	}

	public static int getRsVersion()
	{
		return rsVersion;
	}

	public static String getRlpVersion()
	{
		return version;
	}

	private static byte[] downloadUrl(URL toDownload)
	{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		InputStream stream;
		try
		{
			byte[] chunk = new byte[4096];
			int bytesRead;
			URLConnection conn = toDownload.openConnection();
			conn.setRequestProperty("User-Agent", userAgent);
			stream = conn.getInputStream();

			while ((bytesRead = stream.read(chunk)) > 0)
			{
				outputStream.write(chunk, 0, bytesRead);
			}
			stream.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}

		return outputStream.toByteArray();
	}

	private static void parseMavenVersion()
	{
		try (ByteArrayInputStream fis = new ByteArrayInputStream(downloadUrl(new URL(MAVEN_METADATA))))
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(false);
			factory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(fis);
			NodeList versionList = doc.getElementsByTagName("version");
			for (int i = 0; i != versionList.getLength(); i++)
			{
				Node node = versionList.item(i);
				if (node.getTextContent() != null)
				{
					upstreamVersion = node.getTextContent();
				}
			}
		}
		catch (ParserConfigurationException | IOException | SAXException ex)
		{
			logger.error(null, ex);
		}
	}
}
