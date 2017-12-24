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

import com.google.common.collect.ImmutableSet;
import com.google.common.eventbus.EventBus;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import com.google.inject.Binder;
import com.google.inject.CreationException;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.task.Schedule;
import net.runelite.client.task.ScheduledMethod;
import net.runelite.client.task.Scheduler;

@Singleton
@Slf4j
public class PluginManager
{
	/**
	 * Base package where the core plugins are
	 */
	private static final String PLUGIN_PACKAGE = "net.runelite.client.plugins";

	@Inject
	EventBus eventBus;

	@Inject
	Scheduler scheduler;

	@Inject
	PluginWatcher pluginWatcher;

	@Setter
	boolean isOutdated;

	private final List<Plugin> plugins = new CopyOnWriteArrayList<>();

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
				log.warn("Unable to start plugin {}", plugin.getClass().getSimpleName(), ex);
				plugins.remove(plugin);
			}
		}
	}

	public void watch()
	{
		pluginWatcher.start();
	}

	List<Plugin> scanAndInstantiate(ClassLoader classLoader, String packageName) throws IOException
	{
		boolean developerPlugins = RuneLite.getOptions().has("developer-mode");

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

			if (pluginDescriptor.developerPlugin() && !developerPlugins)
			{
				continue;
			}

			Plugin plugin;
			try
			{
				plugin = instantiate(pluginDescriptor, (Class<Plugin>) clazz);
			}
			catch (PluginInstantiationException ex)
			{
				log.warn("error instantiating plugin!", ex);
				continue;
			}

			scannedPlugins.add(plugin);
		}

		return scannedPlugins;
	}

	void startPlugin(Plugin plugin) throws PluginInstantiationException
	{
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
			eventBus.register(plugin);
			eventBus.post(new PluginChanged(plugin, true));
			schedule(plugin);
		}
		catch (InterruptedException | InvocationTargetException ex)
		{
			throw new PluginInstantiationException(ex);
		}
	}

	void stopPlugin(Plugin plugin) throws PluginInstantiationException
	{
		try
		{
			unschedule(plugin);
			eventBus.unregister(plugin);
			eventBus.post(new PluginChanged(plugin, false));

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

		}
		catch (InterruptedException | InvocationTargetException ex)
		{
			throw new PluginInstantiationException(ex);
		}
	}

	Plugin instantiate(PluginDescriptor pluginDescriptor, Class<Plugin> clazz) throws PluginInstantiationException
	{
		Plugin plugin;
		try
		{
			plugin = (Plugin) clazz.newInstance();
		}
		catch (InstantiationException | IllegalAccessException ex)
		{
			throw new PluginInstantiationException(ex);
		}

		try
		{
			Module pluginModule = (Binder binder) ->
			{
				binder.bind((Class<Plugin>) clazz).toInstance(plugin);
				binder.install(plugin);
			};
			Injector pluginInjector = RuneLite.getInjector().createChildInjector(pluginModule);
			pluginInjector.injectMembers(plugin);
			plugin.injector = pluginInjector;
		}
		catch (CreationException ex)
		{
			throw new PluginInstantiationException(ex);
		}

		log.debug("Loaded plugin {}", pluginDescriptor.name());
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
}
