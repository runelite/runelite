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
import net.runelite.client.RuneLite;
import net.runelite.client.config.RuneliteConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class PluginWatcher extends Thread
{
	private static final Logger logger = LoggerFactory.getLogger(PluginWatcher.class);
	private static final File BASE = RuneLite.PLUGIN_DIR;

	private final RuneliteConfig runeliteConfig;
	private final PluginManager pluginManager;
	private final WatchService watchService;
	private final WatchKey watchKey;

	@Inject
	public PluginWatcher(RuneliteConfig runeliteConfig, PluginManager pluginManager) throws IOException
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

		for (;;)
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

					logger.debug("Event {} file {}", kind, file);

					if (kind == ENTRY_MODIFY)
					{
						Plugin existing = findPluginForFile(file);
						if (existing != null)
						{
							logger.info("Reloading plugin {}", file);
							unload(existing);
						}
						else
						{
							logger.info("Loading plugin {}", file);
						}

						load(file);
					}
					else if (kind == ENTRY_DELETE)
					{
						Plugin existing = findPluginForFile(file);
						if (existing != null)
						{
							logger.info("Unloading plugin {}", file);

							unload(existing);
						}
					}
				}
				key.reset();

			}
			catch (InterruptedException ex)
			{
				logger.warn("error polling for plugins", ex);
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

			logger.info("Loading plugin from {}", file);
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
			logger.warn("Error loading plugin", ex);
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
			logger.warn("Error loading plugin", ex);
			return;
		}

		if (loadedPlugins.isEmpty())
		{
			close(loader);
			logger.warn("No plugin found in plugin {}", pluginFile);
			return;
		}

		if (loadedPlugins.size() != 1)
		{
			close(loader);
			logger.warn("You can not have more than one plugin per jar");
			return;
		}

		Plugin plugin = loadedPlugins.get(0);
		plugin.file = pluginFile;
		plugin.loader = loader;

		try
		{
			pluginManager.startPlugin(plugin);
		}
		catch (PluginInstantiationException ex)
		{
			close(loader);
			logger.warn("unable to start plugin", ex);
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
			logger.warn("unable to stop plugin", ex);
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
			logger.warn(null, ex1);
		}
	}

}
