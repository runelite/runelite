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
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.client.RuneLite;
import net.runelite.client.task.Schedule;
import net.runelite.client.task.ScheduledMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PluginManager
{
	private static final Logger logger = LoggerFactory.getLogger(PluginManager.class);

	private static final String PLUGIN_PACKAGE = "net.runelite.client.plugins";

	private final RuneLite runelite;
	private ServiceManager manager;
	private final List<Plugin> plugins = new ArrayList<>();

	public PluginManager(RuneLite runelite)
	{
		this.runelite = runelite;
	}

	public void loadPlugins() throws IOException
	{
		boolean developerPlugins = false;
		if (RuneLite.getOptions().has("developer-mode"))
		{
			logger.info("Loading developer plugins");
			developerPlugins = true;
		}

		ClassPath classPath = ClassPath.from(getClass().getClassLoader());

		ImmutableSet<ClassInfo> classes = classPath.getTopLevelClassesRecursive(PLUGIN_PACKAGE);
		for (ClassInfo classInfo : classes)
		{
			Class<?> clazz = classInfo.load();
			PluginDescriptor pluginDescriptor = clazz.getAnnotation(PluginDescriptor.class);

			if (pluginDescriptor == null)
			{
				if (clazz.getSuperclass() == Plugin.class)
				{
					logger.warn("Class {} is a plugin, but has no plugin descriptor",
						clazz);
				}
				continue;
			}

			if (clazz.getSuperclass() != Plugin.class)
			{
				logger.warn("Class {} has plugin descriptor, but is not a plugin",
					clazz);
				continue;
			}

			if (pluginDescriptor.developerPlugin() && !developerPlugins)
			{
				continue;
			}

			Plugin plugin;
			try
			{
				plugin = (Plugin) clazz.newInstance();
			}
			catch (InstantiationException | IllegalAccessException ex)
			{
				logger.warn("error initializing plugin", ex);
				continue;
			}

			plugins.add(plugin);
			logger.debug("Loaded plugin {}", pluginDescriptor.name());
		}
	}

	public void start()
	{
		// Add plugin listeners
		for (Plugin plugin : plugins)
		{
			Service.Listener listener = new Service.Listener()
			{
				@Override
				public void running()
				{
					logger.debug("Plugin {} is now running", plugin);
					runelite.getEventBus().register(plugin);

					schedule(plugin);
				}

				@Override
				public void stopping(Service.State from)
				{
					logger.debug("Plugin {} is stopping", plugin);
					runelite.getEventBus().unregister(plugin);
					unschedule(plugin);
				}

				@Override
				public void failed(Service.State from, Throwable failure)
				{
					logger.warn("Plugin {} has failed", plugin, failure);

					if (from == Service.State.RUNNING)
					{
						runelite.getEventBus().unregister(plugin);
						unschedule(plugin);
					}
				}
			};

			plugin.addListener(listener, MoreExecutors.directExecutor());
		}

		manager = new ServiceManager(plugins);

		logger.debug("Starting plugins...");
		manager.startAsync();
	}

	public Collection<Plugin> getPlugins()
	{
		return manager.servicesByState().get(Service.State.RUNNING)
			.stream()
			.map(s -> (Plugin) s)
			.collect(Collectors.toList());
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
			logger.debug("Scheduled task {}", scheduledMethod);

			runelite.getScheduler().addScheduledMethod(scheduledMethod);
		}
	}

	private void unschedule(Plugin plugin)
	{
		List<ScheduledMethod> methods = new ArrayList<>(runelite.getScheduler().getScheduledMethods());

		for (ScheduledMethod method : methods)
		{
			if (method.getObject() != plugin)
			{
				continue;
			}

			logger.debug("Removing scheduled task {}", method);
			runelite.getScheduler().removeScheduledMethod(method);
		}
	}
}
