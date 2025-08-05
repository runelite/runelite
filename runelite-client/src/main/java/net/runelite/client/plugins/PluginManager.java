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
import com.google.common.base.Strings;
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
import java.io.File;
import java.io.IOException;
import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.events.ProfileChanged;
import net.runelite.client.task.Schedule;
import net.runelite.client.task.ScheduledMethod;
import net.runelite.client.task.Scheduler;
import net.runelite.client.ui.SplashScreen;
import net.runelite.client.util.GameEventManager;
import net.runelite.client.util.ReflectUtil;

@Singleton
@Slf4j
public class PluginManager
{
	/**
	 * Base package where the core plugins are
	 */
	private static final String PLUGIN_PACKAGE = "net.runelite.client.plugins";
	private static final File SIDELOADED_PLUGINS = new File(RuneLite.RUNELITE_DIR, "sideloaded-plugins");

	private final boolean developerMode;
	private final boolean safeMode;
	private final EventBus eventBus;
	private final Scheduler scheduler;
	private final ConfigManager configManager;
	private final Provider<GameEventManager> sceneTileManager;
	private final List<Plugin> plugins = new CopyOnWriteArrayList<>();
	private final List<Plugin> activePlugins = new CopyOnWriteArrayList<>();

	@Inject
	@VisibleForTesting
	PluginManager(
		@Named("developerMode") final boolean developerMode,
		@Named("safeMode") final boolean safeMode,
		final EventBus eventBus,
		final Scheduler scheduler,
		final ConfigManager configManager,
		final Provider<GameEventManager> sceneTileManager)
	{
		this.developerMode = developerMode;
		this.safeMode = safeMode;
		this.eventBus = eventBus;
		this.scheduler = scheduler;
		this.configManager = configManager;
		this.sceneTileManager = sceneTileManager;
	}

	@Subscribe
	public void onProfileChanged(ProfileChanged profileChanged)
	{
		refreshPlugins();
	}

	private void refreshPlugins()
	{
		loadDefaultPluginConfiguration(null);
		SwingUtilities.invokeLater(() ->
		{
			for (Plugin plugin : getPlugins())
			{
				try
				{
					if (isPluginEnabled(plugin) != activePlugins.contains(plugin))
					{
						if (activePlugins.contains(plugin))
						{
							stopPlugin(plugin);
						}
						else
						{
							startPlugin(plugin);
						}
					}
				}
				catch (PluginInstantiationException e)
				{
					log.error("Error during starting/stopping plugin {}", plugin.getClass().getSimpleName(), e);
				}
			}
		});
	}

	public Config getPluginConfigProxy(Plugin plugin)
	{
		try
		{
			final Injector injector = plugin.getInjector();

			for (Key<?> key : injector.getBindings().keySet())
			{
				Class<?> type = key.getTypeLiteral().getRawType();
				if (Config.class.isAssignableFrom(type))
				{
					return (Config) injector.getInstance(key);
				}
			}
		}
		catch (ThreadDeath e)
		{
			throw e;
		}
		catch (Throwable e)
		{
			log.error("Unable to get plugin config", e);
		}
		return null;
	}

	public List<Config> getPluginConfigProxies(Collection<Plugin> plugins)
	{
		List<Injector> injectors = new ArrayList<>();
		if (plugins == null)
		{
			injectors.add(RuneLite.getInjector());
			plugins = getPlugins();
		}
		plugins.forEach(pl -> injectors.add(pl.getInjector()));

		List<Config> list = new ArrayList<>();
		for (Injector injector : injectors)
		{
			for (Key<?> key : injector.getBindings().keySet())
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

	public void loadDefaultPluginConfiguration(Collection<Plugin> plugins)
	{
		try
		{
			for (Config config : getPluginConfigProxies(plugins))
			{
				configManager.setDefaultConfiguration(config, false);
			}
		}
		catch (ThreadDeath e)
		{
			throw e;
		}
		catch (Throwable ex)
		{
			log.error("Unable to reset plugin configuration", ex);
		}
	}

	public void startPlugins()
	{
		List<Plugin> scannedPlugins = new ArrayList<>(plugins);
		int loaded = 0;
		for (Plugin plugin : scannedPlugins)
		{
			try
			{
				SwingUtilities.invokeAndWait(() ->
				{
					try
					{
						startPlugin(plugin);
					}
					catch (PluginInstantiationException ex)
					{
						log.error("Unable to start plugin {}", plugin.getClass().getSimpleName(), ex);
					}
				});
			}
			catch (InterruptedException | InvocationTargetException e)
			{
				throw new RuntimeException(e);
			}

			loaded++;
			SplashScreen.stage(.80, 1, null, "Starting plugins", loaded, scannedPlugins.size(), false);
		}

		for (Plugin plugin : plugins)
		{
			ReflectUtil.queueInjectorAnnotationCacheInvalidation(plugin.injector);
		}
	}

	public void loadCorePlugins() throws IOException, PluginInstantiationException
	{
		SplashScreen.stage(.59, null, "Loading plugins");
		ClassPath classPath = ClassPath.from(getClass().getClassLoader());

		List<Class<?>> plugins = classPath.getTopLevelClassesRecursive(PLUGIN_PACKAGE).stream()
			.map(ClassInfo::load)
			.collect(Collectors.toList());

		loadPlugins(plugins, (loaded, total) ->
			SplashScreen.stage(.60, .70, null, "Loading plugins", loaded, total, false));
	}

	public void loadSideLoadPlugins()
	{
		if (!developerMode)
		{
			return;
		}

		File[] files = SIDELOADED_PLUGINS.listFiles();
		if (files == null)
		{
			return;
		}

		for (File f : files)
		{
			if (f.getName().endsWith(".jar"))
			{
				log.info("Side-loading plugin {}", f);

				try
				{
					ClassLoader classLoader = new PluginClassLoader(f, getClass().getClassLoader());

					List<Class<?>> plugins = ClassPath.from(classLoader)
						.getAllClasses()
						.stream()
						.map(ClassInfo::load)
						.collect(Collectors.toList());

					loadPlugins(plugins, null);
				}
				catch (PluginInstantiationException | IOException ex)
				{
					log.error("error sideloading plugin", ex);
				}
			}
		}
	}

	public List<Plugin> loadPlugins(List<Class<?>> plugins, BiConsumer<Integer, Integer> onPluginLoaded) throws PluginInstantiationException
	{
		MutableGraph<Class<? extends Plugin>> graph = GraphBuilder
			.directed()
			.build();

		for (Class<?> clazz : plugins)
		{
			PluginDescriptor pluginDescriptor = clazz.getAnnotation(PluginDescriptor.class);

			if (pluginDescriptor == null)
			{
				if (clazz.getSuperclass() == Plugin.class)
				{
					log.error("Class {} is a plugin, but has no plugin descriptor", clazz);
				}
				continue;
			}

			if (clazz.getSuperclass() != Plugin.class)
			{
				log.error("Class {} has plugin descriptor, but is not a plugin", clazz);
				continue;
			}

			if (pluginDescriptor.developerPlugin() && !developerMode)
			{
				continue;
			}

			if (safeMode && !pluginDescriptor.loadInSafeMode())
			{
				log.debug("Disabling {} due to safe mode", clazz);
				// also disable the plugin from autostarting later
				configManager.unsetConfiguration(RuneLiteConfig.GROUP_NAME,
					(Strings.isNullOrEmpty(pluginDescriptor.configName()) ? clazz.getSimpleName() : pluginDescriptor.configName()).toLowerCase());
				continue;
			}

			graph.addNode((Class<Plugin>) clazz);
		}

		// Build plugin graph
		for (Class<? extends Plugin> pluginClazz : graph.nodes())
		{
			PluginDependency[] pluginDependencies = pluginClazz.getAnnotationsByType(PluginDependency.class);

			for (PluginDependency pluginDependency : pluginDependencies)
			{
				if (graph.nodes().contains(pluginDependency.value()))
				{
					graph.putEdge(pluginDependency.value(), pluginClazz);
				}
			}
		}

		if (Graphs.hasCycle(graph))
		{
			throw new PluginInstantiationException("Plugin dependency graph contains a cycle!");
		}

		List<Class<? extends Plugin>> sortedPlugins = topologicalSort(graph);

		int loaded = 0;
		List<Plugin> newPlugins = new ArrayList<>();
		for (Class<? extends Plugin> pluginClazz : sortedPlugins)
		{
			Plugin plugin;
			try
			{
				plugin = instantiate(this.plugins, (Class<Plugin>) pluginClazz);
				newPlugins.add(plugin);
				this.plugins.add(plugin);
			}
			catch (PluginInstantiationException ex)
			{
				log.error("Error instantiating plugin!", ex);
			}

			loaded++;
			if (onPluginLoaded != null)
			{
				onPluginLoaded.accept(loaded, sortedPlugins.size());
			}
		}

		return newPlugins;
	}

	public boolean startPlugin(Plugin plugin) throws PluginInstantiationException
	{
		// plugins always start in the EDT
		assert SwingUtilities.isEventDispatchThread();

		if (activePlugins.contains(plugin) || !isPluginEnabled(plugin))
		{
			return false;
		}

		List<Plugin> conflicts = conflictsForPlugin(plugin);
		for (Plugin conflict : conflicts)
		{
			if (isPluginEnabled(conflict))
			{
				setPluginEnabled(conflict, false);
			}
			if (activePlugins.contains(conflict))
			{
				stopPlugin(conflict);
			}
		}

		activePlugins.add(plugin);

		try
		{
			plugin.startUp();

			log.debug("Plugin {} is now running", plugin.getClass().getSimpleName());
			if (sceneTileManager != null)
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
		catch (ThreadDeath e)
		{
			throw e;
		}
		catch (Throwable ex)
		{
			// stop the plugin and fire the change event to update the plugin list panel
			try
			{
				stopPlugin(plugin);
			}
			catch (Throwable ex2)
			{
				log.error("unable to stop plugin", ex2);
			}
			throw new PluginInstantiationException(ex);
		}

		return true;
	}

	public boolean stopPlugin(Plugin plugin) throws PluginInstantiationException
	{
		// plugins always stop in the EDT
		assert SwingUtilities.isEventDispatchThread();

		if (!activePlugins.remove(plugin))
		{
			return false;
		}

		unschedule(plugin);
		eventBus.unregister(plugin);

		try
		{
			plugin.shutDown();

			log.debug("Plugin {} is now stopped", plugin.getClass().getSimpleName());
			eventBus.post(new PluginChanged(plugin, false));
		}
		catch (Exception ex)
		{
			throw new PluginInstantiationException(ex);
		}

		return true;
	}

	public void setPluginEnabled(Plugin plugin, boolean enabled)
	{
		final PluginDescriptor pluginDescriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);
		final String keyName = Strings.isNullOrEmpty(pluginDescriptor.configName()) ? plugin.getClass().getSimpleName() : pluginDescriptor.configName();
		configManager.setConfiguration(RuneLiteConfig.GROUP_NAME, keyName.toLowerCase(), String.valueOf(enabled));

		if (enabled)
		{
			List<Plugin> conflicts = conflictsForPlugin(plugin);
			for (Plugin conflict : conflicts)
			{
				if (isPluginEnabled(conflict))
				{
					setPluginEnabled(conflict, false);
				}
			}
		}
	}

	/**
	 * Test if a plugin is enabled, which causes the client to attempt to start it on boot
	 * @param plugin
	 * @return
	 */
	public boolean isPluginEnabled(Plugin plugin)
	{
		final PluginDescriptor pluginDescriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);
		final String keyName = Strings.isNullOrEmpty(pluginDescriptor.configName()) ? plugin.getClass().getSimpleName() : pluginDescriptor.configName();
		final String value = configManager.getConfiguration(RuneLiteConfig.GROUP_NAME, keyName.toLowerCase());
		return value != null ? Boolean.parseBoolean(value) : pluginDescriptor.enabledByDefault();
	}

	/**
	 * Test if a plugin is on, eg. enabled and also was started successfully
	 * @param plugin
	 * @return
	 */
	public boolean isPluginActive(Plugin plugin)
	{
		return activePlugins.contains(plugin);
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
			plugin = clazz.getDeclaredConstructor().newInstance();
		}
		catch (ThreadDeath e)
		{
			throw e;
		}
		catch (Throwable ex)
		{
			throw new PluginInstantiationException(ex);
		}

		try
		{
			Injector parent = RuneLite.getInjector();

			if (deps.size() > 1)
			{
				List<Module> modules = new ArrayList<>(deps.size());
				for (Plugin p : deps)
				{
					// Create a module for each dependency
					Module module = (Binder binder) ->
					{
						binder.bind((Class<Plugin>) p.getClass()).toInstance(p);
						binder.install(p);
					};
					modules.add(module);
				}

				// Create a parent injector containing all of the dependencies
				parent = parent.createChildInjector(modules);
			}
			else if (!deps.isEmpty())
			{
				// With only one dependency we can simply use its injector
				parent = deps.get(0).injector;
			}

			// Create injector for the module
			Module pluginModule = (Binder binder) ->
			{
				// Since the plugin itself is a module, it won't bind itself, so we'll bind it here
				binder.bind(clazz).toInstance(plugin);
				binder.install(plugin);
			};
			Injector pluginInjector = parent.createChildInjector(pluginModule);
			plugin.injector = pluginInjector;
		}
		catch (CreationException ex)
		{
			throw new PluginInstantiationException(ex);
		}

		log.debug("Loaded plugin {}", clazz.getSimpleName());
		return plugin;
	}

	public void add(Plugin plugin)
	{
		plugins.add(plugin);
	}

	public void remove(Plugin plugin)
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

			Runnable runnable = null;
			try
			{
				final Class<?> clazz = method.getDeclaringClass();
				final MethodHandles.Lookup caller = ReflectUtil.privateLookupIn(clazz);
				final MethodType subscription = MethodType.methodType(method.getReturnType(), method.getParameterTypes());
				final MethodHandle target = caller.findVirtual(clazz, method.getName(), subscription);
				final CallSite site = LambdaMetafactory.metafactory(
					caller,
					"run",
					MethodType.methodType(Runnable.class, clazz),
					subscription,
					target,
					subscription);

				final MethodHandle factory = site.getTarget();
				runnable = (Runnable) factory.bindTo(plugin).invokeExact();
			}
			catch (Throwable e)
			{
				log.warn("Unable to create lambda for method {}", method, e);
			}

			ScheduledMethod scheduledMethod = new ScheduledMethod(schedule, method, plugin, runnable);
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
	 *
	 * @param graph - A directed graph
	 * @param <T>   - The type of the item contained in the nodes of the graph
	 * @return - A topologically sorted list corresponding to graph.
	 * <p>
	 * Multiple invocations with the same arguments may return lists that are not equal.
	 */
	@VisibleForTesting
	static <T> List<T> topologicalSort(Graph<T> graph)
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

			for (T m : new HashSet<>(graphCopy.successors(n)))
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

	public List<Plugin> conflictsForPlugin(Plugin plugin)
	{
		Set<String> conflicts;
		{
			PluginDescriptor desc = plugin.getClass().getAnnotation(PluginDescriptor.class);
			conflicts = new HashSet<>(Arrays.asList(desc.conflicts()));
			conflicts.add(desc.name());
		}

		return plugins.stream()
			.filter(p ->
			{
				if (p == plugin)
				{
					return false;
				}

				PluginDescriptor desc = p.getClass().getAnnotation(PluginDescriptor.class);
				if (conflicts.contains(desc.name()))
				{
					return true;
				}

				for (String conflict : desc.conflicts())
				{
					if (conflicts.contains(conflict))
					{
						return true;
					}
				}

				return false;
			})
			.collect(Collectors.toList());
	}
}
