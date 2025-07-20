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
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ExternalPluginsChanged;
import net.runelite.client.events.ProfileChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.SplashScreen;
import net.runelite.client.util.CountingInputStream;
import net.runelite.client.util.Text;
import net.runelite.client.util.VerificationException;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
@Slf4j
public class ExternalPluginManager
{
	private static final String PLUGIN_LIST_KEY = "externalPlugins";
	private static Class<? extends Plugin>[] builtinExternals = null;

	@Inject
	@Named("safeMode")
	private boolean safeMode;

	private final ConfigManager configManager;
	private final ExternalPluginClient externalPluginClient;
	private final ScheduledExecutorService executor;
	private final PluginManager pluginManager;
	private final EventBus eventBus;
	private final OkHttpClient okHttpClient;
	private final Gson gson;

	@Inject
	private ExternalPluginManager(
		ConfigManager configManager,
		ExternalPluginClient externalPluginClient,
		ScheduledExecutorService executor,
		PluginManager pluginManager,
		EventBus eventBus,
		OkHttpClient okHttpClient,
		Gson gson
	)
	{
		this.configManager = configManager;
		this.externalPluginClient = externalPluginClient;
		this.executor = executor;
		this.pluginManager = pluginManager;
		this.eventBus = eventBus;
		this.okHttpClient = okHttpClient;
		this.gson = gson;

		executor.scheduleWithFixedDelay(() -> externalPluginClient.submitPlugins(getInstalledExternalPlugins()),
			new Random().nextInt(60), 180, TimeUnit.MINUTES);
	}

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
	public void onProfileChanged(ProfileChanged profileChanged)
	{
		executor.submit(this::refreshPlugins);
	}

	private void refreshPlugins()
	{
		if (safeMode)
		{
			log.debug("External plugins are disabled in safe mode!");
			return;
		}

		Set<String> builtinExternalClasses = new HashSet<>();
		if (builtinExternals != null)
		{
			for (Class<? extends Plugin> pluginClass : builtinExternals)
			{
				builtinExternalClasses.add(pluginClass.getName());
			}
		}

		Multimap<PluginHubManifest.JarData, Plugin> loadedExternalPlugins = HashMultimap.create();
		for (Plugin p : pluginManager.getPlugins())
		{
			PluginHubManifest.JarData m = getJarData(p.getClass());
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

			Instant now = Instant.now();
			Instant keepAfter = now.minus(3, ChronoUnit.DAYS);

			SplashScreen.stage(splashStart, null, "Downloading external plugins");
			Set<PluginHubManifest.JarData> externalPlugins = new HashSet<>();

			RuneLite.PLUGINS_DIR.mkdirs();

			try
			{
				PluginHubManifest.ManifestLite manifest = externalPluginClient.downloadManifestLite();
				Map<String, PluginHubManifest.JarData> manifests = manifest.getJars()
					.stream().collect(ImmutableMap.toImmutableMap(PluginHubManifest.JarData::getInternalName, Function.identity()));

				Set<PluginHubManifest.JarData> needsDownload = new HashSet<>();
				Set<File> keep = new HashSet<>();

				for (String name : installedIDs)
				{
					PluginHubManifest.JarData jarData = manifests.get(name);
					if (jarData != null)
					{
						externalPlugins.add(jarData);

						jarData.getJarFile().setLastModified(now.toEpochMilli());
						if (!jarData.isValid())
						{
							needsDownload.add(jarData);
						}
						else
						{
							keep.add(jarData.getJarFile());
						}
					}
				}

				// delete old plugins
				File[] files = RuneLite.PLUGINS_DIR.listFiles();
				if (files != null)
				{
					for (File fi : files)
					{
						if (!keep.contains(fi) && fi.lastModified() < keepAfter.toEpochMilli())
						{
							fi.delete();
						}
					}
				}

				int toDownload = needsDownload.stream().mapToInt(PluginHubManifest.JarData::getJarSize).sum();
				int downloaded = 0;

				for (PluginHubManifest.JarData jarData : needsDownload)
				{
					HttpUrl url = externalPluginClient.getJarURL(jarData);

					try (Response res = okHttpClient.newCall(new Request.Builder().url(url).build()).execute())
					{
						int fdownloaded = downloaded;
						downloaded += jarData.getJarSize();
						HashingInputStream his = new HashingInputStream(Hashing.sha256(),
							new CountingInputStream(res.body().byteStream(), i ->
								SplashScreen.stage(splashStart + (splashLength * .2), splashStart + (splashLength * .8),
									null, "Downloading " + jarData.getDisplayName(),
									i + fdownloaded, toDownload, true)));
						Files.asByteSink(jarData.getJarFile()).writeFrom(his);
						if (!PluginHubManifest.HASH_ENCODER.encodeToString(his.hash().asBytes()).equals(jarData.getJarHash()))
						{
							throw new VerificationException("Plugin " + jarData.getInternalName() + " didn't match its hash");
						}
					}
					catch (IOException | VerificationException e)
					{
						externalPlugins.remove(jarData);
						log.error("Unable to download external plugin \"{}\"", jarData.getInternalName(), e);
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
			Set<PluginHubManifest.JarData> add = new HashSet<>();
			for (PluginHubManifest.JarData jarData : externalPlugins)
			{
				if (loadedExternalPlugins.removeAll(jarData).size() <= 0)
				{
					add.add(jarData);
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

			for (PluginHubManifest.JarData jarData : add)
			{
				// I think this can't happen, but just in case
				if (!jarData.isValid())
				{
					log.warn("Invalid plugin for validated manifest: {}", jarData);
					continue;
				}

				log.info("Loading external plugin \"{}\" jar \"{}\"", jarData.getInternalName(), jarData.getJarHash());

				List<Plugin> newPlugins = null;
				try
				{
					PluginHubClassLoader cl = new PluginHubClassLoader(jarData, new URL[]{jarData.getJarFile().toURI().toURL()}, gson);
					if (Arrays.stream(cl.getStub().getPlugins()).anyMatch(builtinExternalClasses::contains))
					{
						log.debug("Skipping loading \"{}\" from hub as a conflicting builtin external is present", jarData.getInternalName());
						continue;
					}

					List<Class<?>> clazzes = new ArrayList<>();
					for (String className : cl.getStub().getPlugins())
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
				catch (ThreadDeath e)
				{
					throw e;
				}
				catch (Throwable e)
				{
					log.warn("Unable to start or load external plugin \"{}\"", jarData.getInternalName(), e);
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
								log.info("Unable to fully stop plugin \"{}\"", jarData.getInternalName(), e2);
							}
							pluginManager.remove(p);
						}
					}
				}
			}

			if (!startup)
			{
				eventBus.post(new ExternalPluginsChanged());
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

	@Nullable
	public static PluginHubManifest.JarData getJarData(Class<? extends Plugin> plugin)
	{
		ClassLoader cl = plugin.getClassLoader();
		if (cl instanceof PluginHubClassLoader)
		{
			PluginHubClassLoader ecl = (PluginHubClassLoader) cl;
			return ecl.getJarData();
		}
		return null;
	}

	@Nullable
	public static PluginHubManifest.DisplayData getDisplayData(Class<? extends Plugin> plugin)
	{
		ClassLoader cl = plugin.getClassLoader();
		if (cl instanceof PluginHubClassLoader)
		{
			PluginHubClassLoader ecl = (PluginHubClassLoader) cl;
			return ecl.getStub();
		}
		return null;
	}

	@Nullable
	public static String getInternalName(Class<? extends Plugin> plugin)
	{
		PluginHubManifest.JarData jd = getJarData(plugin);
		return jd == null ? null : jd.getInternalName();
	}

	public static void loadBuiltin(Class<? extends Plugin>... plugins)
	{
		boolean assertsEnabled = false;
		assert (assertsEnabled = true);
		if (!assertsEnabled)
		{
			throw new RuntimeException("Assertions are not enabled, add '-ea' to your VM options. Enabling assertions during development catches undefined behavior and incorrect API usage.");
		}

		builtinExternals = plugins;
	}
}
