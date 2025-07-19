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

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.grapher.graphviz.GraphvizGrapher;
import com.google.inject.grapher.graphviz.GraphvizModule;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import com.google.inject.util.Modules;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import net.runelite.api.Client;
import net.runelite.client.RuneLite;
import net.runelite.client.RuneLiteModule;
import net.runelite.client.RuntimeConfig;
import net.runelite.client.RuntimeConfigLoader;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import okhttp3.OkHttpClient;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PluginManagerTest
{
	private static final String PLUGIN_PACKAGE = "net.runelite.client.plugins";

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Bind
	public Client client = (Client) mock(Component.class, Mockito.withSettings().extraInterfaces(Client.class));

	@Mock
	@Bind
	private ConfigManager configManager;

	private Set<Class<?>> pluginClasses;
	private Set<Class<?>> configClasses;

	@Before
	public void before() throws IOException
	{
		OkHttpClient okHttpClient = new OkHttpClient.Builder()
			.addInterceptor(chain ->
			{
				throw new RuntimeException("in plugin manager test");
			})
			.build();

		when(configManager.getConfig(any(Class.class)))
			.thenAnswer(a ->
			{
				Class<?> c = a.getArgument(0);
				return mock(c);
			});

		RuntimeConfigLoader configLoader = mock(RuntimeConfigLoader.class);
		when(configLoader.get()).thenReturn(mock(RuntimeConfig.class));

		Injector injector = Guice.createInjector(Modules
			.override(new RuneLiteModule(okHttpClient, () -> null, configLoader, true, false, false,
				RuneLite.DEFAULT_SESSION_FILE,
				null, false, false
			))
			.with(BoundFieldModule.of(this)));

		RuneLite.setInjector(injector);

		// Find plugins and configs we expect to have
		pluginClasses = new HashSet<>();
		configClasses = new HashSet<>();
		Set<ClassInfo> classes = ClassPath.from(getClass().getClassLoader()).getTopLevelClassesRecursive(PLUGIN_PACKAGE);
		for (ClassInfo classInfo : classes)
		{
			Class<?> clazz = classInfo.load();
			PluginDescriptor pluginDescriptor = clazz.getAnnotation(PluginDescriptor.class);
			if (pluginDescriptor != null)
			{
				pluginClasses.add(clazz);
				continue;
			}

			if (Config.class.isAssignableFrom(clazz))
			{
				configClasses.add(clazz);
			}
		}
	}

	@Test
	public void testLoadPlugins() throws Exception
	{
		var pluginManager = new PluginManager(false, false, null, null, null, null);
		pluginManager.loadCorePlugins();
		var plugins = pluginManager.getPlugins();

		// Check that the plugins register with the eventbus without errors
		EventBus eventBus = new EventBus();
		plugins.forEach(eventBus::register);

		var expected = pluginClasses.stream()
			.map(cl -> cl.getAnnotation(PluginDescriptor.class))
			.filter(Objects::nonNull)
			.filter(pd -> !pd.developerPlugin())
			.count();
		assertEquals(expected, plugins.size());
	}

	@Test
	public void dumpGraph() throws Exception
	{
		PluginManager pluginManager = new PluginManager(true, false, null, null, null, null);
		pluginManager.loadCorePlugins();

		Injector graphvizInjector = Guice.createInjector(new GraphvizModule());
		GraphvizGrapher graphvizGrapher = graphvizInjector.getInstance(GraphvizGrapher.class);

		File dotFolder = folder.newFolder();
		try (PrintWriter out = new PrintWriter(new File(dotFolder, "runelite.dot"), "UTF-8"))
		{
			graphvizGrapher.setOut(out);
			graphvizGrapher.setRankdir("TB");
			graphvizGrapher.graph(RuneLite.getInjector());
		}

		for (Plugin p : pluginManager.getPlugins())
		{
			try (PrintWriter out = new PrintWriter(new File(dotFolder, p.getName() + ".dot"), "UTF-8"))
			{
				graphvizGrapher.setOut(out);
				graphvizGrapher.setRankdir("TB");
				graphvizGrapher.graph(p.getInjector());
			}
		}
	}

	@Test
	public void ensureNoDuplicateConfigKeyNames()
	{
		for (final Class<?> clazz : configClasses)
		{
			final Set<String> configKeyNames = new HashSet<>();

			for (final Method method : clazz.getMethods())
			{
				if (!method.isDefault())
				{
					continue;
				}

				final ConfigItem annotation = method.getAnnotation(ConfigItem.class);

				if (annotation == null)
				{
					continue;
				}

				final String configKeyName = annotation.keyName();

				if (configKeyNames.contains(configKeyName))
				{
					throw new IllegalArgumentException("keyName " + configKeyName + " is duplicated in " + clazz);
				}

				configKeyNames.add(configKeyName);
			}
		}
	}

	@Test
	public void testTopologicalSort()
	{
		MutableGraph<Integer> graph = GraphBuilder
			.directed()
			.build();

		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);

		graph.putEdge(1, 2);
		graph.putEdge(1, 3);

		List<Integer> sorted = PluginManager.topologicalSort(graph);

		assertTrue(sorted.indexOf(1) < sorted.indexOf(2));
		assertTrue(sorted.indexOf(1) < sorted.indexOf(3));
	}
}
