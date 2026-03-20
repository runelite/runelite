/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2019 Abex
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
import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.RuntimeConfig;
import net.runelite.client.RuntimeConfigLoader;
import net.runelite.client.ui.FatalErrorDialog;
import net.runelite.client.ui.SplashScreen;
import net.runelite.http.api.worlds.World;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

@Slf4j
@SuppressWarnings({"deprecation"})
public class ClientLoader implements Supplier<Client>
{
	private static final int NUM_ATTEMPTS = 6;

	private final ClientConfigLoader clientConfigLoader;
	private final WorldSupplier worldSupplier;
	private final RuntimeConfigLoader runtimeConfigLoader;
	private final String javConfigUrl;

	private Object client;

	public ClientLoader(OkHttpClient okHttpClient, RuntimeConfigLoader runtimeConfigLoader, String javConfigUrl)
	{
		this.clientConfigLoader = new ClientConfigLoader(okHttpClient);
		this.worldSupplier = new WorldSupplier(okHttpClient);
		this.runtimeConfigLoader = runtimeConfigLoader;
		this.javConfigUrl = javConfigUrl;
	}

	@Override
	public synchronized Client get()
	{
		if (client == null)
		{
			client = doLoad();
		}

		if (client instanceof Throwable)
		{
			throw new RuntimeException((Throwable) client);
		}
		return (Client) client;
	}

	private Object doLoad()
	{
		try
		{
			SplashScreen.stage(0, null, "Fetching applet viewer config");
			RSConfig config = downloadConfig();

			SplashScreen.stage(.3, "Starting", "Starting Old School RuneScape");

			Client rs = loadClient(config);

			SplashScreen.stage(.4, null, "Starting core classes");

			return rs;
		}
		catch (OutageException e)
		{
			return e;
		}
		catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException | SecurityException e)
		{
			log.error("Error loading RS!", e);

			if (!checkOutages())
			{
				SwingUtilities.invokeLater(() -> FatalErrorDialog.showNetErrorWindow("loading the client", e));
			}
			return e;
		}
	}

	private RSConfig downloadConfig() throws IOException
	{
		HttpUrl url = HttpUrl.get(javConfigUrl);
		IOException err = null;
		for (int attempt = 0; attempt < NUM_ATTEMPTS; attempt++)
		{
			try
			{
				RSConfig config = clientConfigLoader.fetch(url);

				if (Strings.isNullOrEmpty(config.getCodeBase()) || Strings.isNullOrEmpty(config.getInitialJar()) || Strings.isNullOrEmpty(config.getInitialClass()))
				{
					throw new IOException("Invalid or missing jav_config");
				}

				return config;
			}
			catch (IOException e)
			{
				log.info("Failed to get jav_config from host \"{}\" ({})", url.host(), e.getMessage());
				if (checkOutages())
				{
					throw new OutageException(e);
				}

				if (!javConfigUrl.equals(RuneLiteProperties.getJavConfig()))
				{
					throw e;
				}

				String host = worldSupplier.get().getAddress();
				url = url.newBuilder().host(host).build();
				err = e;
			}
		}

		log.info("Falling back to backup client config");

		try
		{
			return downloadFallbackConfig();
		}
		catch (IOException ex)
		{
			log.debug("error downloading backup config", ex);
			throw err; // NOPMD: PreserveStackTrace - use error from Jagex's servers
		}
	}

	@Nonnull
	private RSConfig downloadFallbackConfig() throws IOException
	{
		RSConfig backupConfig = clientConfigLoader.fetch(HttpUrl.get(RuneLiteProperties.getJavConfigBackup()));

		if (Strings.isNullOrEmpty(backupConfig.getCodeBase()) || Strings.isNullOrEmpty(backupConfig.getInitialJar()) || Strings.isNullOrEmpty(backupConfig.getInitialClass()))
		{
			throw new IOException("Invalid or missing jav_config");
		}

		if (Strings.isNullOrEmpty(backupConfig.getRuneLiteWorldParam()))
		{
			throw new IOException("Backup config does not have RuneLite gamepack url");
		}

		// Randomize the codebase
		World world = worldSupplier.get();
		backupConfig.setCodebase("http://" + world.getAddress() + "/");

		// Update the world applet parameter
		Map<String, String> appletProperties = backupConfig.getAppletProperties();
		appletProperties.put(backupConfig.getRuneLiteWorldParam(), Integer.toString(world.getId()));

		return backupConfig;
	}

	private Client loadClient(RSConfig config) throws ClassNotFoundException, IllegalAccessException, InstantiationException
	{
		String initialClass = config.getInitialClass();
		Class<?> clientClass = ClientLoader.class.getClassLoader()
			.loadClass(initialClass);

		Client rs = (Client) clientClass.newInstance();
		rs.setConfiguration(new RSAppletStub(config, runtimeConfigLoader));

		log.info("injected-client {}", rs.getBuildID());

		return rs;
	}

	private static class OutageException extends RuntimeException
	{
		private OutageException(Throwable cause)
		{
			super(cause);
		}
	}

	private boolean checkOutages()
	{
		RuntimeConfig rtc = runtimeConfigLoader.tryGet();
		if (rtc != null)
		{
			return rtc.showOutageMessage();
		}
		return false;
	}
}
