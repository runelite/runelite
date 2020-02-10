/*
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
package net.runelite.client.externalplugins;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.hash.Hashing;
import com.google.common.hash.HashingInputStream;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ExternalPluginsChanged;
import net.runelite.client.events.SessionClose;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.SplashScreen;
import net.runelite.client.util.CountingInputStream;
import net.runelite.client.util.Text;
import net.runelite.client.util.VerificationException;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
@Slf4j
public class ExternalPluginManager
{
	private static final String PLUGIN_LIST_KEY = "externalPlugins";
	private static Class<? extends Plugin>[] builtinExternals = null;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ExternalPluginClient externalPluginClient;

	@Inject
	private PluginManager pluginManager;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private EventBus eventBus;

	public void loadExternalPlugins() throws PluginInstantiationException
	{
		refreshPlugins();

		if (builtinExternals != null)
		{
			// builtin external's don't actually have a manifest or a separate classloader...
			pluginManager.loadPlugins(Lists.newArrayList(builtinExternals), null);
		}
	}

	@Subscribe
	public void onSessionOpen(SessionOpen event)
	{
		executor.submit(this::refreshPlugins);
	}

	@Subscribe
	public void onSessionClose(SessionClose event)
	{
		executor.submit(this::refreshPlugins);
	}

	private void refreshPlugins()
	{
		Multimap<ExternalPluginManifest, Plugin> loadedExternalPlugins = HashMultimap.create();
		for (Plugin p : pluginManager.getPlugins())
		{
			ExternalPluginManifest m = getExternalPluginManifest(p.getClass());
			if (m != null)
			{
				loadedExternalPlugins.put(m, p);
			}
		}

		List<String> installedIDs = getInstalledExternalPlugins();
		if (installedIDs.isEmpty() && loadedExternalPlugins.isEmpty())
		{
			return;
		}

		boolean startup = SplashScreen.isOpen();
		try
		{
			double splashStart = startup ? .60 : 0;
			double splashLength = startup ? .10 : 1;
			if (!startup)
			{
				SplashScreen.init();
			}

			SplashScreen.stage(splashStart, null, "Downloading external plugins");
			Set<ExternalPluginManifest> externalPlugins = new HashSet<>();

			RuneLite.PLUGINS_DIR.mkdirs();

			List<ExternalPluginManifest> manifestList;
			try
			{
				manifestList = externalPluginClient.downloadManifest();
				Map<String, ExternalPluginManifest> manifests = manifestList
					.stream().collect(ImmutableMap.toImmutableMap(ExternalPluginManifest::getInternalName, Function.identity()));

				Set<ExternalPluginManifest> needsDownload = new HashSet<>();
				Set<File> keep = new HashSet<>();

				for (String name : installedIDs)
				{
					ExternalPluginManifest manifest = manifests.get(name);
					if (manifest != null)
					{
						externalPlugins.add(manifest);

						if (!manifest.isValid())
						{
							needsDownload.add(manifest);
						}
						else
						{
							keep.add(manifest.getJarFile());
						}
					}
				}

				// delete old plugins
				File[] files = RuneLite.PLUGINS_DIR.listFiles();
				if (files != null)
				{
					for (File fi : files)
					{
						if (!keep.contains(fi))
						{
							fi.delete();
						}
					}
				}

				int toDownload = needsDownload.stream().mapToInt(ExternalPluginManifest::getSize).sum();
				int downloaded = 0;

				for (ExternalPluginManifest manifest : needsDownload)
				{
					HttpUrl url = RuneLiteProperties.getPluginHubBase().newBuilder()
						.addPathSegment(manifest.getInternalName())
						.addPathSegment(manifest.getCommit() + ".jar")
						.build();

					try (Response res = RuneLiteAPI.CLIENT.newCall(new Request.Builder().url(url).build()).execute())
					{
						int fdownloaded = downloaded;
						downloaded += manifest.getSize();
						HashingInputStream his = new HashingInputStream(Hashing.sha256(),
							new CountingInputStream(res.body().byteStream(), i ->
								SplashScreen.stage(splashStart + (splashLength * .2), splashStart + (splashLength * .8),
									null, "Downloading " + manifest.getDisplayName(),
									i + fdownloaded, toDownload, true)));
						Files.asByteSink(manifest.getJarFile()).writeFrom(his);
						if (!his.hash().toString().equals(manifest.getHash()))
						{
							throw new VerificationException("Plugin " + manifest.getInternalName() + " didn't match its hash");
						}
					}
					catch (IOException | VerificationException e)
					{
						externalPlugins.remove(manifest);
						log.error("Unable to download external plugin \"{}\"", manifest.getInternalName(), e);
					}
				}
			}
			catch (IOException | VerificationException e)
			{
				log.error("Unable to download external plugins", e);
				return;
			}

			SplashScreen.stage(splashStart + (splashLength * .8), null, "Starting external plugins");

			// TODO(abex): make sure the plugins get fully removed from the scheduler/eventbus/other managers (iterate and check classloader)
			Set<ExternalPluginManifest> add = new HashSet<>();
			for (ExternalPluginManifest ex : externalPlugins)
			{
				if (loadedExternalPlugins.removeAll(ex).size() <= 0)
				{
					add.add(ex);
				}
			}
			// list of loaded external plugins that aren't in the manifest
			Collection<Plugin> remove = loadedExternalPlugins.values();

			for (Plugin p : remove)
			{
				log.info("Stopping external plugin \"{}\"", p.getClass());
				try
				{
					SwingUtilities.invokeAndWait(() ->
					{
						try
						{
							pluginManager.stopPlugin(p);
						}
						catch (Exception e)
						{
							throw new RuntimeException(e);
						}
					});
				}
				catch (InterruptedException | InvocationTargetException e)
				{
					log.warn("Unable to stop external plugin \"{}\"", p.getClass().getName(), e);
				}
				pluginManager.remove(p);
			}

			for (ExternalPluginManifest manifest : add)
			{
				// I think this can't happen, but just in case
				if (!manifest.isValid())
				{
					log.warn("Invalid plugin for validated manifest: {}", manifest);
					continue;
				}

				log.info("Loading external plugin \"{}\" version \"{}\" commit \"{}\"", manifest.getInternalName(), manifest.getVersion(), manifest.getCommit());

				List<Plugin> newPlugins = null;
				try
				{
					ClassLoader cl = new ExternalPluginClassLoader(manifest, new URL[]{manifest.getJarFile().toURI().toURL()});
					List<Class<?>> clazzes = new ArrayList<>();
					for (String className : manifest.getPlugins())
					{
						clazzes.add(cl.loadClass(className));
					}

					List<Plugin> newPlugins2 = newPlugins = pluginManager.loadPlugins(clazzes, null);
					if (!startup)
					{
						pluginManager.loadDefaultPluginConfiguration(newPlugins);

						SwingUtilities.invokeAndWait(() ->
						{
							try
							{
								for (Plugin p : newPlugins2)
								{
									pluginManager.startPlugin(p);
								}
							}
							catch (PluginInstantiationException e)
							{
								throw new RuntimeException(e);
							}
						});
					}
				}
				catch (Exception e)
				{
					log.warn("Unable to start or load external plugin \"{}\"", manifest.getInternalName(), e);
					if (newPlugins != null)
					{
						for (Plugin p : newPlugins)
						{
							try
							{
								SwingUtilities.invokeAndWait(() ->
								{
									try
									{
										pluginManager.stopPlugin(p);
									}
									catch (Exception e2)
									{
										throw new RuntimeException(e2);
									}
								});
							}
							catch (InterruptedException | InvocationTargetException e2)
							{
								log.info("Unable to fully stop plugin \"{}\"", manifest.getInternalName(), e2);
							}
							pluginManager.remove(p);
						}
					}
				}
			}

			if (!startup)
			{
				eventBus.post(new ExternalPluginsChanged(manifestList));
			}
		}
		finally
		{
			if (!startup)
			{
				SplashScreen.stop();
			}
		}
	}

	public List<String> getInstalledExternalPlugins()
	{
		String externalPluginsStr = configManager.getConfiguration(RuneLiteConfig.GROUP_NAME, PLUGIN_LIST_KEY);
		return Text.fromCSV(externalPluginsStr == null ? "" : externalPluginsStr);
	}

	public void install(String key)
	{
		Set<String> plugins = new HashSet<>(getInstalledExternalPlugins());
		if (plugins.add(key))
		{
			configManager.setConfiguration(RuneLiteConfig.GROUP_NAME, PLUGIN_LIST_KEY, Text.toCSV(plugins));
			executor.submit(this::refreshPlugins);
		}
	}

	public void remove(String key)
	{
		Set<String> plugins = new HashSet<>(getInstalledExternalPlugins());
		if (plugins.remove(key))
		{
			configManager.setConfiguration(RuneLiteConfig.GROUP_NAME, PLUGIN_LIST_KEY, Text.toCSV(plugins));
			executor.submit(this::refreshPlugins);
		}
	}

	public void update()
	{
		executor.submit(this::refreshPlugins);
	}

	public static ExternalPluginManifest getExternalPluginManifest(Class<? extends Plugin> plugin)
	{
		ClassLoader cl = plugin.getClassLoader();
		if (cl instanceof ExternalPluginClassLoader)
		{
			ExternalPluginClassLoader ecl = (ExternalPluginClassLoader) cl;
			return ecl.getManifest();
		}
		return null;
	}

	public static void loadBuiltin(Class<? extends Plugin>... plugins)
	{
		builtinExternals = plugins;
	}
}
