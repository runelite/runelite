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

import com.google.common.base.Strings;
import com.google.common.io.ByteStreams;
import java.applet.Applet;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.RuneLiteSplashScreen;
import net.runelite.http.api.worlds.World;
import okhttp3.HttpUrl;

@Slf4j
public class ClientLoader implements Supplier<Applet>
{
	private static final String CONFIG_URL = "http://oldschool.runescape.com/jav_config.ws";
	private static final String BACKUP_CONFIG_URL = "https://raw.githubusercontent.com/open-osrs/hosting/master/jav_config.ws";

	private static final int NUM_ATTEMPTS = 10;
	private final ClientUpdateCheckMode updateCheckMode;
	private Object client = null;

	private WorldSupplier worldSupplier = new WorldSupplier();
	private RSConfig config;

	public ClientLoader(ClientUpdateCheckMode updateCheckMode)
	{
		this.updateCheckMode = updateCheckMode;
	}

	private static Applet loadRLPlus(final RSConfig config)
		throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		RuneLiteSplashScreen.stage(.465, "Starting Open Old School RuneScape");

		ClassLoader rsClassLoader = new ClassLoader(ClientLoader.class.getClassLoader())
		{
			@Override
			protected Class<?> findClass(String name) throws ClassNotFoundException
			{
				String path = name.replace('.', '/').concat(".class");
				InputStream inputStream = ClientLoader.class.getResourceAsStream(path);
				if (inputStream == null)
				{
					throw new ClassNotFoundException(name + " " + path);
				}
				byte[] data;
				try
				{
					data = ByteStreams.toByteArray(inputStream);
				}
				catch (IOException e)
				{
					e.printStackTrace();
					RuneLiteSplashScreen.setError("Failed to load!", "Failed to load class: " + name + " " + path);
					throw new RuntimeException("Failed to load class: " + name + " " + path);
				}
				return defineClass(name, data, 0, data.length);
			}
		};
		Class<?> clientClass = rsClassLoader.loadClass("client");
		return loadFromClass(config, clientClass);
	}

	private static Applet loadVanilla(final RSConfig config)
		throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		RuneLiteSplashScreen.stage(.465, "Starting Vanilla Old School RuneScape");

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

	private static Applet loadFromClass(final RSConfig config, final Class<?> clientClass)
		throws IllegalAccessException, InstantiationException
	{
		final Applet rs = (Applet) clientClass.newInstance();
		rs.setStub(new RSAppletStub(config));
		return rs;
	}

	@Override
	public synchronized Applet get()
	{
		if (client == null)
		{
			client = doLoad();
		}

		if (client instanceof Throwable)
		{
			throw new RuntimeException((Throwable) client);
		}
		return (Applet) client;
	}

	private Object doLoad()
	{
		try
		{
			downloadConfig();

			switch (updateCheckMode)
			{
				case AUTO:
				default:
					return loadRLPlus(config);
				case VANILLA:
					return loadVanilla(config);
				case NONE:
					return null;
				case RSPS:
					RuneLite.allowPrivateServer = true;
					return loadRLPlus(config);
			}
		}
		catch (IOException | InstantiationException | IllegalAccessException e)
		{
			log.error("Error loading RS!", e);
			return null;
		}
		catch (ClassNotFoundException e)
		{
			RuneLiteSplashScreen.setError("Unable to load client", "Class not found. This means you"
				+ " are not running OpenOSRS with Gradle as the injected client"
				+ " is not in your classpath.");

			log.error("Error loading RS!", e);
			return null;
		}
	}

	private void downloadConfig() throws IOException
	{
		HttpUrl url = HttpUrl.parse(CONFIG_URL);
		IOException err = null;
		for (int attempt = 0; attempt < NUM_ATTEMPTS; attempt++)
		{
			RuneLiteSplashScreen.stage(.0, "Connecting with gameserver (try " + (attempt + 1) + "/" + NUM_ATTEMPTS + ")");
			try
			{
				config = ClientConfigLoader.fetch(url);

				if (Strings.isNullOrEmpty(config.getCodeBase()) || Strings.isNullOrEmpty(config.getInitialJar()) || Strings.isNullOrEmpty(config.getInitialClass()))
				{
					throw new IOException("Invalid or missing jav_config");
				}

				return;
			}
			catch (IOException e)
			{
				log.info("Failed to get jav_config from host \"{}\" ({})", url.host(), e.getMessage());
				String host = worldSupplier.get().getAddress();
				url = url.newBuilder().host(host).build();
				err = e;
			}
		}

		log.info("Falling back to backup client config");

		try
		{
			RSConfig backupConfig = ClientConfigLoader.fetch(HttpUrl.parse(BACKUP_CONFIG_URL));

			if (Strings.isNullOrEmpty(backupConfig.getCodeBase()) || Strings.isNullOrEmpty(backupConfig.getInitialJar())
				|| Strings.isNullOrEmpty(backupConfig.getInitialClass()) || Strings.isNullOrEmpty(backupConfig.getRuneLiteWorldParam()))
			{
				throw new IOException("Invalid or missing jav_config");
			}

			// Randomize the codebase
			World world = worldSupplier.get();
			backupConfig.setCodebase("http://" + world.getAddress() + "/");

			// Update the world applet parameter
			Map<String, String> appletProperties = backupConfig.getAppletProperties();
			appletProperties.put(backupConfig.getRuneLiteWorldParam(), Integer.toString(world.getId()));
			config = backupConfig;
		}
		catch (IOException ex)
		{
			throw err; // use error from Jagex's servers
		}
	}
}
