/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins;

import com.google.inject.Injector;
import com.google.inject.Key;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.OpenOSRSConfig;

@Singleton
@Slf4j
public class ExternalPluginLoader
{
	private static final File BASE = RuneLite.PLUGIN_DIR;

	private final OpenOSRSConfig OpenOSRSConfig;
	private final PluginManager pluginManager;

	@Inject
	private ConfigManager configManager;

	@Inject
	public ExternalPluginLoader(OpenOSRSConfig OpenOSRSConfig, PluginManager pluginManager)
	{
		this.OpenOSRSConfig = OpenOSRSConfig;
		this.pluginManager = pluginManager;

		BASE.mkdirs();
	}

	public void scanAndLoad()
	{
		if (!OpenOSRSConfig.enablePlugins())
		{
			return;
		}

		for (File file : Objects.requireNonNull(BASE.listFiles()))
		{
			if (!file.getName().endsWith(".jar"))
			{
				continue;
			}
			log.info("Loading plugin from {}", file);
			load(file);
		}
	}

	private void load(File pluginFile)
	{
		PluginClassLoader loader;
		try
		{
			loader = new PluginClassLoader(pluginFile, getClass().getClassLoader());
		}
		catch (MalformedURLException ex)
		{
			log.warn("Error loading plugin", ex);
			return;
		}

		List<Plugin> loadedPlugins;
		try
		{
			loadedPlugins = pluginManager.scanAndInstantiate(loader, null);
		}
		catch (IOException ex)
		{
			close(loader);
			log.warn("Error loading plugin", ex);
			return;
		}

		if (loadedPlugins.isEmpty())
		{
			close(loader);
			log.warn("No plugin found in plugin {}", pluginFile);
			return;
		}

		if (loadedPlugins.size() != 1)
		{
			close(loader);
			log.warn("You can not have more than one plugin per jar");
			return;
		}

		Plugin plugin = loadedPlugins.get(0);
		plugin.file = pluginFile;
		plugin.loader = loader;

		// Initialize default configuration
		Injector injector = plugin.getInjector();
		for (Key<?> key : injector.getAllBindings().keySet())
		{
			Class<?> type = key.getTypeLiteral().getRawType();
			if (Config.class.isAssignableFrom(type))
			{
				Config config = (Config) injector.getInstance(key);
				configManager.setDefaultConfiguration(config, false);
			}
		}

		try
		{
			pluginManager.startPlugin(plugin);
		}
		catch (PluginInstantiationException ex)
		{
			close(loader);
			log.warn("unable to start plugin", ex);
			return;
		}

		// Plugin is now running
		pluginManager.add(plugin);
	}

	private void close(URLClassLoader classLoader)
	{
		try
		{
			classLoader.close();
		}
		catch (IOException ex1)
		{
			log.warn(null, ex1);
		}
	}

}
