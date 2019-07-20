/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018 Abex
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
package net.runelite.client.rs;

import java.applet.Applet;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.http.api.RuneLiteAPI;

@Slf4j
@Singleton
public class ClientLoader
{
	public static boolean useLocalInjected = false;
	public static boolean usePrivateServer = false;
	private final ClientConfigLoader clientConfigLoader;
	private final ClientUpdateCheckMode updateCheckMode;

	@Inject
	private ClientLoader(
		@Named("updateCheckMode") final ClientUpdateCheckMode updateCheckMode,
		final ClientConfigLoader clientConfigLoader)
	{
		this.updateCheckMode = updateCheckMode;
		this.clientConfigLoader = clientConfigLoader;
	}

	private static Applet loadRLPlus(final RSConfig config) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		if (useLocalInjected)
		{
			try
			{
				URL localInjected = new File("./injected-client/target/injected-client-" + RuneLiteAPI.getVersion() + ".jar").toURI().toURL();
				log.info("Using local injected-client");
				URLClassLoader classLoader = new URLClassLoader(new URL[]{localInjected});
				Class<?> clientClass = classLoader.loadClass("client");
				return loadFromClass(config, clientClass);
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
		}

		try
		{
			File cachedInjected = new File(RuneLite.RUNELITE_DIR + "/injected-client-" + RuneLiteAPI.getVersion() + ".jar");
			URL remoteInjected = new URL("https://github.com/runelite-extended/maven-repo/raw/master/live/injected-client-" + RuneLiteAPI.getVersion() + ".jar");
			int remoteSize = getFileSize(remoteInjected);
			URL cachedInjectedURL = cachedInjected.toURI().toURL();
			int cachedSize = 0;
			if (cachedInjected.exists())
			{
				cachedSize = getFileSize(cachedInjectedURL);
			}

			if (remoteSize != cachedSize)
			{
				log.info("Injected-client size mismatch, updating.");
				try (BufferedInputStream in = new BufferedInputStream(remoteInjected.openStream()))
				{
					FileOutputStream fileOutputStream = new FileOutputStream(cachedInjected);
					byte[] dataBuffer = new byte[1024];
					int bytesRead;
					while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1)
					{
						fileOutputStream.write(dataBuffer, 0, bytesRead);
					}
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}

			}
			URLClassLoader classLoader = new URLClassLoader(new URL[]{cachedInjectedURL}, RuneLite.class.getClassLoader());
			Class<?> clientClass = classLoader.loadClass("client");
			return loadFromClass(config, clientClass);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		log.error("Failed to load injected-client!");
		return null;
	}

	private static Applet loadVanilla(final RSConfig config) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		final String codebase = config.getCodeBase();
		final String initialJar = config.getInitialJar();
		final String initialClass = config.getInitialClass();
		final URL url = new URL(codebase + initialJar);

		// Must set parent classloader to null, or it will pull from
		// this class's classloader first
		final URLClassLoader classloader = new URLClassLoader(new URL[]{url}, null);
		final Class<?> clientClass = classloader.loadClass(initialClass);
		return loadFromClass(config, clientClass);
	}

	private static Applet loadFromClass(final RSConfig config, final Class<?> clientClass) throws IllegalAccessException, InstantiationException
	{
		final Applet rs = (Applet) clientClass.newInstance();
		rs.setStub(new RSAppletStub(config));
		return rs;
	}

	private static int getFileSize(URL url)
	{
		URLConnection conn = null;
		try
		{
			conn = url.openConnection();
			if (conn instanceof HttpURLConnection)
			{
				((HttpURLConnection) conn).setRequestMethod("HEAD");
			}
			conn.getInputStream();
			return conn.getContentLength();
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			if (conn instanceof HttpURLConnection)
			{
				((HttpURLConnection) conn).disconnect();
			}
		}
	}

	public Applet load()
	{
		try
		{
			final RSConfig config = clientConfigLoader.fetch();

			switch (updateCheckMode)
			{
				case AUTO:
				default:
					return loadRLPlus(config);
				case VANILLA:
					return loadVanilla(config);
				case NONE:
					return null;
			}
		}
		catch (IOException | InstantiationException | IllegalAccessException e)
		{
			log.error("Error loading RS!", e);
			return null;
		}
		catch (ClassNotFoundException e)
		{
			log.error("Unable to load client - class not found. This means you"
				+ " are not running RuneLite with Maven as the injected client"
				+ " is not in your classpath.");

			log.error("Error loading RS!", e);
			return null;
		}
	}
}
