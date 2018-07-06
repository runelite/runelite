/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.updatecheck.UpdateCheckClient;

@Slf4j
@Singleton
public class ClientLoader
{
	private final UpdateCheckClient updateCheckClient = new UpdateCheckClient();
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

	private static Applet loadRuneLite(final RSConfig config) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		// the injected client is a runtime scoped dependency
		final Class<?> clientClass = ClientLoader.class.getClassLoader().loadClass(config.getInitialClass());
		return loadFromClass(config, clientClass);
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

	public Applet load()
	{
		try
		{
			final RSConfig config = clientConfigLoader.fetch();
			final ClientUpdateCheckMode updateMode = updateCheckMode == ClientUpdateCheckMode.AUTO
				? updateCheckClient.isOutdated() ? ClientUpdateCheckMode.VANILLA : ClientUpdateCheckMode.RUNELITE
				: updateCheckMode;

			switch (updateMode)
			{
				case RUNELITE:
					return loadRuneLite(config);
				default:
				case VANILLA:
					return loadVanilla(config);
				case NONE:
					return null;
			}
		}
		catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
		{
			if (e instanceof ClassNotFoundException)
			{
				log.error("Unable to load client - class not found. This means you"
					+ " are not running RuneLite with Maven as the injected client"
					+ " is not in your classpath.");
			}

			log.error("Error loading RS!", e);
			System.exit(-1);
			return null;
		}
	}
}
