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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.Graphs;
import com.google.common.graph.MutableGraph;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import com.google.inject.Binder;
import com.google.inject.CreationException;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.SessionClose;
import net.runelite.api.events.SessionOpen;
import net.runelite.client.RuneLite;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.task.Schedule;
import net.runelite.client.task.ScheduledMethod;
import net.runelite.client.task.Scheduler;
import net.runelite.client.util.GameEventManager;

@Singleton
@Slf4j
public class PluginManager
{
	/**
	 * Base package where the core plugins are
	 */
	private static final String PLUGIN_PACKAGE = "net.runelite.client.plugins";

	private final boolean developerMode;
	private final EventBus eventBus;
	private final Scheduler scheduler;
	private final ConfigManager configManager;
	private final ScheduledExecutorService executor;
	private final Provider<GameEventManager> sceneTileManager;
	private final List<Plugin> plugins = new CopyOnWriteArrayList<>();
	private final List<Plugin> activePlugins = new CopyOnWriteArrayList<>();
	private final String runeliteGroupName = RuneLiteConfig.class
			.getAnnotation(ConfigGroup.class).value();

	@Setter
	boolean isOutdated;

	@Inject
	@VisibleForTesting
	PluginManager(
		@Named("developerMode") final boolean developerMode,
		final EventBus eventBus,
		final Scheduler scheduler,
		final ConfigManager configManager,
		final ScheduledExecutorService executor,
		final Provider<GameEventManager> sceneTileManager)
	{
		this.developerMode = developerMode;
		this.eventBus = eventBus;
		this.scheduler = scheduler;
		this.configManager = configManager;
		this.executor = executor;
		this.sceneTileManager = sceneTileManager;
	}

	@Subscribe
	public void onSessionOpen(SessionOpen event)
	{
		refreshPlugins();
	}

	@Subscribe
	public void onSessionClose(SessionClose event)
	{
		refreshPlugins();
	}

	private void refreshPlugins()
	{
		loadDefaultPluginConfiguration();
		getPlugins()
			.forEach(plugin -> executor.submit(() ->
			{
				try
				{
					if (!startPlugin(plugin))
					{
						stopPlugin(plugin);
					}
				}
				catch (PluginInstantiationException e)
				{
					log.warn("Error during starting/stopping plugin {}. {}", plugin.getClass().getSimpleName(), e);
				}
			}));
	}

	public Config getPluginConfigProxy(Plugin plugin)
	{
		final Injector injector = plugin.getInjector();

		for (Key<?> key : injector.getAllBindings().keySet())
		{
			Class<?> type = key.getTypeLiteral().getRawType();
			if (Config.class.isAssignableFrom(type))
			{
				return (Config) injector.getInstance(key);
			}
		}

		return null;
	}

	public List<Config> getPluginConfigProxies()
	{
		List<Injector> injectors = new ArrayList<>();
		injectors.add(RuneLite.getInjector());
		getPlugins().forEach(pl -> injectors.add(pl.getInjector()));

		List<Config> list = new ArrayList<>();
		for (Injector injector : injectors)
		{
			for (Key<?> key : injector.getAllBindings().keySet())
			{
				Class<?> type = key.getTypeLiteral().getRawType();
				if (Config.class.isAssignableFrom(type))
				{
					Config config = (Config) injector.getInstance(key);
					list.add(config);
				}
			}
		}

		return list;
	}

	public void loadDefaultPluginConfiguration()
	{
		for (Object config : getPluginConfigProxies())
		{
			configManager.setDefaultConfiguration(config, false);
		}
	}

	public void loadCorePlugins() throws IOException
	{
		plugins.addAll(scanAndInstantiate(getClass().getClassLoader(), PLUGIN_PACKAGE));
	}

	public void startCorePlugins()
	{
		List<Plugin> scannedPlugins = new ArrayList<>(plugins);
		for (Plugin plugin : scannedPlugins)
		{
			try
			{
				startPlugin(plugin);
			}
			catch (PluginInstantiationException ex)
			{
				log.warn("Unable to start plugin {}. {}", plugin.getClass().getSimpleName(), ex);
				plugins.remove(plugin);
			}
		}
	}

	List<Plugin> scanAndInstantiate(ClassLoader classLoader, String packageName) throws IOException
	{
		MutableGraph<Class<? extends Plugin>> graph = GraphBuilder
			.directed()
			.build();

		List<Plugin> scannedPlugins = new ArrayList<>();
		ClassPath classPath = ClassPath.from(classLoader);

		ImmutableSet<ClassInfo> classes = packageName == null ? classPath.getAllClasses()
			: classPath.getTopLevelClassesRecursive(packageName);
		for (ClassInfo classInfo : classes)
		{
			Class<?> clazz = classInfo.load();
			PluginDescriptor pluginDescriptor = clazz.getAnnotation(PluginDescriptor.class);

			if (pluginDescriptor == null)
			{
				if (clazz.getSuperclass() == Plugin.class)
				{
					log.warn("Class {} is a plugin, but has no plugin descriptor",
							clazz);
				}
				continue;
			}

			if (clazz.getSuperclass() != Plugin.class)
			{
				log.warn("Class {} has plugin descriptor, but is not a plugin",
						clazz);
				continue;
			}

			if (!pluginDescriptor.loadWhenOutdated() && isOutdated)
			{
				continue;
			}

			if (pluginDescriptor.developerPlugin() && !developerMode)
			{
				continue;
			}

			Class<Plugin> pluginClass = (Class<Plugin>) clazz;
			graph.addNode(pluginClass);
		}

		// Build plugin graph
		for (Class<? extends Plugin> pluginClazz : graph.nodes())
		{
			PluginDependency[] pluginDependencies = pluginClazz.getAnnotationsByType(PluginDependency.class);

			for (PluginDependency pluginDependency : pluginDependencies)
			{
				graph.putEdge(pluginClazz, pluginDependency.value());
			}
		}

		if (Graphs.hasCycle(graph))
		{
			throw new RuntimeException("Plugin dependency graph contains a cycle!");
		}

		List<Class<? extends Plugin>> sortedPlugins = topologicalSort(graph);
		sortedPlugins = Lists.reverse(sortedPlugins);

		for (Class<? extends Plugin> pluginClazz : sortedPlugins)
		{
			Plugin plugin;
			try
			{
				plugin = instantiate(scannedPlugins, (Class<Plugin>) pluginClazz);
			}
			catch (PluginInstantiationException ex)
			{
				log.warn("Error instantiating plugin!", ex);
				continue;
			}

			scannedPlugins.add(plugin);
		}

		return scannedPlugins;
	}

	public synchronized boolean startPlugin(Plugin plugin) throws PluginInstantiationException
	{
		if (activePlugins.contains(plugin) || !isPluginEnabled(plugin))
		{
			return false;
		}

		activePlugins.add(plugin);

		try
		{
			// plugins always start in the event thread
			SwingUtilities.invokeAndWait(() ->
			{
				try
				{
					plugin.startUp();
				}
				catch (Exception ex)
				{
					throw new RuntimeException(ex);
				}
			});

			log.debug("Plugin {} is now running", plugin.getClass().getSimpleName());
			if (!isOutdated && sceneTileManager != null)
			{
				final GameEventManager gameEventManager = this.sceneTileManager.get();
				if (gameEventManager != null)
				{
					gameEventManager.simulateGameEvents(plugin);
				}
			}

			eventBus.register(plugin);
			schedule(plugin);
			eventBus.post(new PluginChanged(plugin, true));
		}
		catch (InterruptedException | InvocationTargetException | IllegalArgumentException ex)
		{
			throw new PluginInstantiationException(ex);
		}

		return true;
	}

	public synchronized boolean stopPlugin(Plugin plugin) throws PluginInstantiationException
	{
		if (!activePlugins.contains(plugin) || isPluginEnabled(plugin))
		{
			return false;
		}

		activePlugins.remove(plugin);

		try
		{
			unschedule(plugin);
			eventBus.unregister(plugin);

			// plugins always stop in the event thread
			SwingUtilities.invokeAndWait(() ->
			{
				try
				{
					plugin.shutDown();
				}
				catch (Exception ex)
				{
					throw new RuntimeException(ex);
				}
			});

			log.debug("Plugin {} is now stopped", plugin.getClass().getSimpleName());
			eventBus.post(new PluginChanged(plugin, false));

		}
		catch (InterruptedException | InvocationTargetException ex)
		{
			throw new PluginInstantiationException(ex);
		}

		return true;
	}

	public void setPluginEnabled(Plugin plugin, boolean enabled)
	{
		final String keyName = plugin.getClass().getSimpleName().toLowerCase();
		configManager.setConfiguration(runeliteGroupName, keyName, String.valueOf(enabled));
	}

	public boolean isPluginEnabled(Plugin plugin)
	{
		final String keyName = plugin.getClass().getSimpleName().toLowerCase();
		final String value = configManager.getConfiguration(runeliteGroupName, keyName);

		if (value != null)
		{
			return Boolean.valueOf(value);
		}

		final PluginDescriptor pluginDescriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);
		return pluginDescriptor == null || pluginDescriptor.enabledByDefault();
	}

	private Plugin instantiate(List<Plugin> scannedPlugins, Class<Plugin> clazz) throws PluginInstantiationException
	{
		PluginDependency[] pluginDependencies = clazz.getAnnotationsByType(PluginDependency.class);
		List<Plugin> deps = new ArrayList<>();
		for (PluginDependency pluginDependency : pluginDependencies)
		{
			Optional<Plugin> dependency = scannedPlugins.stream().filter(p -> p.getClass() == pluginDependency.value()).findFirst();
			if (!dependency.isPresent())
			{
				throw new PluginInstantiationException("Unmet dependency for " + clazz.getSimpleName() + ": " + pluginDependency.value().getSimpleName());
			}
			deps.add(dependency.get());
		}

		Plugin plugin;
		try
		{
			plugin = clazz.newInstance();
		}
		catch (InstantiationException | IllegalAccessException ex)
		{
			throw new PluginInstantiationException(ex);
		}

		try
		{
			Module pluginModule = (Binder binder) ->
			{
				binder.bind(clazz).toInstance(plugin);
				binder.install(plugin);
				for (Plugin p : deps)
				{
					Module p2 = (Binder binder2) ->
					{
						binder2.bind((Class<Plugin>) p.getClass()).toInstance(p);
						binder2.install(p);
					};
					binder.install(p2);
				}
			};
			Injector pluginInjector = RuneLite.getInjector().createChildInjector(pluginModule);
			pluginInjector.injectMembers(plugin);
			plugin.injector = pluginInjector;
		}
		catch (CreationException ex)
		{
			throw new PluginInstantiationException(ex);
		}

		log.debug("Loaded plugin {}", clazz.getSimpleName());
		return plugin;
	}

	void add(Plugin plugin)
	{
		plugins.add(plugin);
	}

	void remove(Plugin plugin)
	{
		plugins.remove(plugin);
	}

	public Collection<Plugin> getPlugins()
	{
		return plugins;
	}

	private void schedule(Plugin plugin)
	{
		for (Method method : plugin.getClass().getMethods())
		{
			Schedule schedule = method.getAnnotation(Schedule.class);

			if (schedule == null)
			{
				continue;
			}

			ScheduledMethod scheduledMethod = new ScheduledMethod(schedule, method, plugin);
			log.debug("Scheduled task {}", scheduledMethod);

			scheduler.addScheduledMethod(scheduledMethod);
		}
	}

	private void unschedule(Plugin plugin)
	{
		List<ScheduledMethod> methods = new ArrayList<>(scheduler.getScheduledMethods());

		for (ScheduledMethod method : methods)
		{
			if (method.getObject() != plugin)
			{
				continue;
			}

			log.debug("Removing scheduled task {}", method);
			scheduler.removeScheduledMethod(method);
		}
	}

	/**
	 * Topologically sort a graph. Uses Kahn's algorithm.
	 * @param graph
	 * @param <T>
	 * @return
	 */
	private <T> List<T> topologicalSort(Graph<T> graph)
	{
		MutableGraph<T> graphCopy = Graphs.copyOf(graph);
		List<T> l = new ArrayList<>();
		Set<T> s = graphCopy.nodes().stream()
			.filter(node -> graphCopy.inDegree(node) == 0)
			.collect(Collectors.toSet());
		while (!s.isEmpty())
		{
			Iterator<T> it = s.iterator();
			T n = it.next();
			it.remove();

			l.add(n);

			for (T m : graphCopy.successors(n))
			{
				graphCopy.removeEdge(n, m);
				if (graphCopy.inDegree(m) == 0)
				{
					s.add(m);
				}
			}
		}
		if (!graphCopy.edges().isEmpty())
		{
			throw new RuntimeException("Graph has at least one cycle");
		}
		return l;
	}
}
