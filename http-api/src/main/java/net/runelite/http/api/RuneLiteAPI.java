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
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class RuneLiteAPI
{
	public static final String RUNELITE_AUTH = "RUNELITE-AUTH";
	public static final OkHttpClient CLIENT;
	public static final OkHttpClient RLP_CLIENT;
	public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static final Logger logger = LoggerFactory.getLogger(RuneLiteAPI.class);
	private static final String BASE = "https://api.runelite.net";
	private static final String PLUS_BASE = "https://api.runelitepl.us";
	private static final String RLPLUS = "https://session.runelitepl.us";
	private static final String WSBASE = "https://api.runelite.net/ws";
	private static final String STATICBASE = "https://static.runelite.net";
	private static final String MAVEN_METADATA =
		"http://repo.runelite.net/net/runelite/runelite-parent/maven-metadata.xml";
	private static final String GITHUB_API = "https://api.github.com/repos/runelite/runelite/commits/master";
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
	private static final Properties properties = new Properties();
	private static String userAgent;
	private static String rlpUserAgent;
	private static String version;
	private static String rlpVersion;
	private static int rsVersion;

	static
	{
		try
		{
			InputStream in = RuneLiteAPI.class.getResourceAsStream("/runelite.properties");
			properties.load(in);

			parseMavenVersion();
			String commit = parseGithubCommit();

			rlpVersion = properties.getProperty("runelite.version");
			rsVersion = Integer.parseInt(properties.getProperty("rs.version"));
			String rlpCommit = properties.getProperty("runelite.commit");
			boolean dirty = Boolean.parseBoolean(properties.getProperty("runelite.dirty"));

			userAgent = "RuneLite/" + version + "-" + commit + (dirty ? "+" : "");
			rlpUserAgent = "RuneLite/" + rlpVersion + "-" + rlpCommit + (dirty ? "+" : "");
		}
		catch (NumberFormatException e)
		{
			throw new RuntimeException("Version string has not been substituted; Re-run maven");
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

		RLP_CLIENT = new OkHttpClient.Builder()
			.pingInterval(30, TimeUnit.SECONDS)
			.addNetworkInterceptor(new Interceptor()
			{
				@Override
				public Response intercept(Chain chain) throws IOException
				{
					Request userAgentRequest = chain.request()
						.newBuilder()
						.header("User-Agent", rlpUserAgent)
						.build();
					return chain.proceed(userAgentRequest);
				}
			})
			.build();
	}

	public static HttpUrl getSessionBase()
	{
		final String prop = System.getProperty("runelite.session.url");

		if (prop != null && !prop.isEmpty())
		{
			return HttpUrl.parse(prop);
		}

		return HttpUrl.parse(BASE + "/session");
	}

	public static HttpUrl getRuneLitePlusSessionBase()
	{
		return HttpUrl.parse(RLPLUS);
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

	public static HttpUrl getPlusApiBase()
	{
		return HttpUrl.parse(PLUS_BASE + "/runelite-" + getRlpVersion());
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

	public static String getRlpVersion()
	{
		return rlpVersion;
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
			conn.setRequestProperty("User-Agent", toDownload.getHost().contains("runelite") ? randomAlphaNumeric(8) : "runelite-extended");
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
					version = node.getTextContent();
				}
			}
		}
		catch (ParserConfigurationException | IOException | SAXException ex)
		{
			logger.error(null, ex);
		}
	}

	private static String parseGithubCommit()
	{
		try
		{
			String jsonData = new String(downloadUrl(new URL(GITHUB_API)));
			for (String s : jsonData.split("\n"))
			{
				if (s.startsWith("\"sha\":"))
				{
					s = s.replace(",", "");
					s = s.replace(" ", "");
					s = s.replace("\"", "");
					return s.split(":")[1];
				}
			}
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	private static String randomAlphaNumeric(int count)
	{
		StringBuilder builder = new StringBuilder();
		while (count-- != 0)
		{
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
}
