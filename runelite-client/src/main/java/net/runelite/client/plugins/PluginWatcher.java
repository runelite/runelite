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
import java.nio.file.FileSystems;
import java.nio.file.Path;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;

@Singleton
@Slf4j
public class PluginWatcher extends Thread
{
	private static final File BASE = RuneLite.PLUGIN_DIR;

	private final RuneLiteConfig runeliteConfig;
	private final PluginManager pluginManager;
	private final WatchService watchService;
	private final WatchKey watchKey;

	@Inject
	private ConfigManager configManager;

	@Inject
	public PluginWatcher(RuneLiteConfig runeliteConfig, PluginManager pluginManager) throws IOException
	{
		this.runeliteConfig = runeliteConfig;
		this.pluginManager = pluginManager;

		setName("Plugin Watcher");
		setDaemon(true);

		watchService = FileSystems.getDefault().newWatchService();
		BASE.mkdirs();
		Path dir = BASE.toPath();
		watchKey = dir.register(watchService, ENTRY_MODIFY, ENTRY_DELETE);
	}

	public void cancel()
	{
		watchKey.cancel();
	}

	@Override
	public void run()
	{
		if (runeliteConfig.enablePlugins())
		{
			scan();
		}

		for (; ; )
		{
			try
			{
				WatchKey key = watchService.take();
				Thread.sleep(50);

				if (!runeliteConfig.enablePlugins())
				{
					key.reset();
					continue;
				}

				for (WatchEvent<?> event : key.pollEvents())
				{
					Kind<?> kind = event.kind();
					Path path = (Path) event.context();
					File file = new File(BASE, path.toFile().getName());

					log.debug("Event {} file {}", kind, file);

					if (kind == ENTRY_MODIFY)
					{
						Plugin existing = findPluginForFile(file);
						if (existing != null)
						{
							log.info("Reloading plugin {}", file);
							unload(existing);
						}
						else
						{
							log.info("Loading plugin {}", file);
						}

						load(file);
					}
					else if (kind == ENTRY_DELETE)
					{
						Plugin existing = findPluginForFile(file);
						if (existing != null)
						{
							log.info("Unloading plugin {}", file);

							unload(existing);
						}
					}
				}
				key.reset();

			}
			catch (InterruptedException ex)
			{
				log.warn("error polling for plugins", ex);
			}
		}
	}

	private void scan()
	{
		for (File file : BASE.listFiles())
		{
			if (!file.getName().endsWith(".jar"))
			{
				continue;
			}

			log.info("Loading plugin from {}", file);
			load(file);
		}
	}

	private Plugin findPluginForFile(File file)
	{
		for (Plugin plugin : pluginManager.getPlugins())
		{
			if (plugin.file != null && plugin.file.equals(file))
			{
				return plugin;
			}
		}
		return null;
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

	private void unload(Plugin plugin)
	{
		try
		{
			pluginManager.stopPlugin(plugin);
		}
		catch (PluginInstantiationException ex)
		{
			log.warn("unable to stop plugin", ex);
		}

		pluginManager.remove(plugin); // remove it regardless

		close(plugin.loader);
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
