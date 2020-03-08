package net.runelite.client.plugins;

import com.google.common.collect.ImmutableList;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.google.inject.Binder;
import com.google.inject.CreationException;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import static net.runelite.client.RuneLite.EXTERNALPLUGIN_DIR;
import static net.runelite.client.RuneLite.SYSTEM_VERSION;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.OpenOSRSConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ExternalPluginChanged;
import net.runelite.client.events.ExternalRepositoryChanged;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.RuneLiteSplashScreen;
import net.runelite.client.util.MiscUtils;
import net.runelite.client.util.SwingUtil;
import org.pf4j.DefaultPluginManager;
import org.pf4j.DependencyResolver;
import org.pf4j.JarPluginLoader;
import org.pf4j.JarPluginRepository;
import org.pf4j.ManifestPluginDescriptorFinder;
import org.pf4j.PluginAlreadyLoadedException;
import org.pf4j.PluginDependency;
import org.pf4j.PluginDescriptorFinder;
import org.pf4j.PluginLoader;
import org.pf4j.PluginRepository;
import org.pf4j.PluginRuntimeException;
import org.pf4j.PluginWrapper;
import org.pf4j.RuntimeMode;
import org.pf4j.update.DefaultUpdateRepository;
import org.pf4j.update.PluginInfo;
import org.pf4j.update.UpdateManager;
import org.pf4j.update.UpdateRepository;
import org.pf4j.update.VerifyException;

@Slf4j
@Singleton
public
class ExternalPluginManager
{
	public static ArrayList<ClassLoader> pluginClassLoaders = new ArrayList<>();
	private final PluginManager runelitePluginManager;
	private org.pf4j.PluginManager externalPluginManager;
	@Getter(AccessLevel.PUBLIC)
	private final List<UpdateRepository> repositories = new ArrayList<>();
	private final OpenOSRSConfig openOSRSConfig;
	private final EventBus eventBus;
	private final ConfigManager configManager;
	private final List<Plugin> plugins = new CopyOnWriteArrayList<>();
	private final Map<String, String> pluginsMap = new HashMap<>();
	@Getter(AccessLevel.PUBLIC)
	private UpdateManager updateManager;

	@Inject
	public ExternalPluginManager(
		PluginManager pluginManager,
		OpenOSRSConfig openOSRSConfig,
		EventBus eventBus,
		ConfigManager configManager)
	{
		this.runelitePluginManager = pluginManager;
		this.openOSRSConfig = openOSRSConfig;
		this.eventBus = eventBus;
		this.configManager = configManager;

		//noinspection ResultOfMethodCallIgnored
		EXTERNALPLUGIN_DIR.mkdirs();

		initPluginManager();
	}

	private void initPluginManager()
	{
		boolean debug = RuneLiteProperties.getLauncherVersion() == null && RuneLiteProperties.getPluginPath() != null;

		this.externalPluginManager = new DefaultPluginManager(
			debug ? Paths.get(RuneLiteProperties.getPluginPath() + File.separator + "release")
				: EXTERNALPLUGIN_DIR.toPath())
		{
			@Override
			protected PluginDescriptorFinder createPluginDescriptorFinder()
			{
				return new ManifestPluginDescriptorFinder();
			}

			@Override
			protected PluginRepository createPluginRepository()
			{
				return new JarPluginRepository(getPluginsRoot())
				{
					@Override
					public List<Path> getPluginPaths()
					{
						File[] files = pluginsRoot.toFile().listFiles(filter);

						if ((files == null) || files.length == 0)
						{
							return Collections.emptyList();
						}

						List<Path> paths = new ArrayList<>(files.length);
						for (File file : files)
						{
							paths.add(file.toPath());
						}

						return paths;
					}
				};
			}

			@Override
			protected PluginLoader createPluginLoader()
			{
				return new JarPluginLoader(this);
			}

			@Override
			public RuntimeMode getRuntimeMode()
			{
				return debug ? RuntimeMode.DEVELOPMENT : RuntimeMode.DEPLOYMENT;
			}

			@Override
			public void loadPlugins()
			{
				if (Files.notExists(pluginsRoot) || !Files.isDirectory(pluginsRoot))
				{
					log.warn("No '{}' root", pluginsRoot);
					return;
				}

				List<Path> pluginPaths = pluginRepository.getPluginPaths();

				if (pluginPaths.isEmpty())
				{
					log.warn("No plugins");
					return;
				}

				log.debug("Found {} possible plugins: {}", pluginPaths.size(), pluginPaths);

				for (Path pluginPath : pluginPaths)
				{
					try
					{
						loadPluginFromPath(pluginPath);
					}
					catch (PluginRuntimeException e)
					{
						if (!(e instanceof PluginAlreadyLoadedException))
						{
							log.error(e.getMessage(), e);
						}
					}
				}

				try
				{
					resolvePlugins();
				}
				catch (PluginRuntimeException e)
				{
					if (e instanceof DependencyResolver.DependenciesNotFoundException)
					{
						throw e;
					}

					log.error(e.getMessage(), e);
				}
			}
		};
		this.externalPluginManager.setSystemVersion(SYSTEM_VERSION);
	}

	public boolean doesGhRepoExist(String owner, String name)
	{
		return doesRepoExist("gh:" + owner + "/" + name);
	}

	/**
	 * Note that {@link org.pf4j.update.UpdateManager#addRepository} checks if the repo exists, however it throws an exception which is bad
	 */
	public boolean doesRepoExist(String id)
	{
		return repositories.stream().anyMatch((repo) -> repo.getId().equals(id));
	}

	private static URL toRepositoryUrl(String owner, String name) throws MalformedURLException
	{
		return new URL("https://raw.githubusercontent.com/" + owner + "/" + name + "/master/");
	}

	public static boolean testGHRepository(String owner, String name)
	{
		try
		{
			return testRepository(toRepositoryUrl(owner, name));
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static boolean testRepository(URL url)
	{
		final List<UpdateRepository> repositories = new ArrayList<>();
		repositories.add(new DefaultUpdateRepository("repository-testing", url));
		DefaultPluginManager testPluginManager = new DefaultPluginManager(EXTERNALPLUGIN_DIR.toPath());
		UpdateManager updateManager = new UpdateManager(testPluginManager, repositories);

		return updateManager.getPlugins().size() <= 0;
	}

	public static <T> Predicate<T> not(Predicate<T> t)
	{
		return t.negate();
	}

	public void startExternalPluginManager()
	{
		try
		{
			this.externalPluginManager.loadPlugins();
		}
		catch (Exception ex)
		{
			if (ex instanceof DependencyResolver.DependenciesNotFoundException)
			{
				List<String> deps = ((DependencyResolver.DependenciesNotFoundException) ex).getDependencies();

				log.error("The following dependencies are missing: {}", deps);

				for (String dep : deps)
				{
					install(dep);
				}

				startExternalPluginManager();
			}

			log.error("{}", ex.getMessage());
		}
	}

	public void startExternalUpdateManager()
	{
		if (!tryLoadNewFormat())
		{
			loadOldFormat();
		}

		this.updateManager = new UpdateManager(this.externalPluginManager, repositories);
		saveConfig();
	}

	public boolean tryLoadNewFormat()
	{
		try
		{
			for (String keyval : openOSRSConfig.getExternalRepositories().split(";"))
			{
				String[] split = keyval.split("\\|");
				if (split.length != 2)
				{
					repositories.clear();
					return false;
				}
				String id = split[0];
				String url = split[1];
				if (!url.endsWith("/"))
				{
					url = url.concat("/");
				}

				if (id.contains("https://raw.githubusercontent.com/"))
				{
					id = "gh:" + id.substring(id.indexOf("https://raw.githubusercontent.com/")).replace("/master", "")
						.replace("https://raw.githubusercontent.com/", "");

					if (id.endsWith("/"))
					{
						id = id.substring(0, id.lastIndexOf("/"));
					}
				}

				repositories.add(new DefaultUpdateRepository(id, new URL(url)));
			}
		}
		catch (ArrayIndexOutOfBoundsException | MalformedURLException e)
		{
			repositories.clear();
			return false;
		}
		return true;
	}

	public void loadOldFormat()
	{
		try
		{
			repositories.clear();

			for (String keyval : openOSRSConfig.getExternalRepositories().split(";"))
			{
				String id = keyval.substring(0, keyval.lastIndexOf(":https"));
				String url = keyval.substring(keyval.lastIndexOf("https"));

				repositories.add(new DefaultUpdateRepository(id, new URL(url)));
			}
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
	}

	public void addGHRepository(String owner, String name)
	{
		try
		{
			addRepository("gh:" + owner + "/" + name, toRepositoryUrl(owner, name));
		}
		catch (MalformedURLException e)
		{
			log.error("Repostitory could not be added");
		}
	}

	public void addRepository(String key, URL url)
	{
		DefaultUpdateRepository respository = new DefaultUpdateRepository(key, url);
		updateManager.addRepository(respository);
		eventBus.post(ExternalRepositoryChanged.class, new ExternalRepositoryChanged(key, true));
		saveConfig();
	}

	public void removeRepository(String owner)
	{
		updateManager.removeRepository(owner);
		eventBus.post(ExternalRepositoryChanged.class, new ExternalRepositoryChanged(owner, false));
		saveConfig();
	}

	private void saveConfig()
	{
		StringBuilder config = new StringBuilder();

		for (UpdateRepository repository : updateManager.getRepositories())
		{
			config.append(repository.getId());
			config.append("|");
			config.append(MiscUtils.urlToStringEncoded(repository.getUrl()));
			config.append(";");
		}
		config.deleteCharAt(config.lastIndexOf(";"));

		openOSRSConfig.setExternalRepositories(config.toString());
	}

	private List<Plugin> scanAndInstantiate(List<Plugin> plugins, boolean init, boolean initConfig) throws IOException
	{
		RuneLiteSplashScreen.stage(.66, "Loading external plugins");
		MutableGraph<Class<? extends Plugin>> graph = GraphBuilder
			.directed()
			.build();

		AtomicInteger loaded = new AtomicInteger();
		List<Plugin> scannedPlugins = new CopyOnWriteArrayList<>();

		// some plugins get stuck on IO, so add some extra threads
		ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

		for (Plugin plugin : plugins)
		{
			Class<? extends Plugin> clazz = plugin.getClass();
			PluginDescriptor pluginDescriptor = clazz.getAnnotation(PluginDescriptor.class);

			if (pluginDescriptor == null)
			{
				if (clazz.getSuperclass() == Plugin.class)
				{
					log.warn("Class {} is a plugin, but has no plugin descriptor", clazz);
					continue;
				}
			}
			else if (clazz.getSuperclass() != Plugin.class)
			{
				log.warn("Class {} has plugin descriptor, but is not a plugin", clazz);
				continue;
			}
			else if (pluginDescriptor.type() == PluginType.EXTERNAL)
			{
				log.error("Class {} is using the the new external plugin loader, it should not use PluginType.EXTERNAL",
					clazz);
				continue;
			}

			List<Future<?>> curGroup = new ArrayList<>();
			curGroup.add(exec.submit(() ->
			{
				Plugin plugininst;
				try
				{
					plugininst = instantiate(scannedPlugins, (Class<Plugin>) plugin.getClass(), init, initConfig);
					scannedPlugins.add(plugininst);
				}
				catch (PluginInstantiationException e)
				{
					log.warn("Error instantiating plugin!", e);
					return;
				}

				loaded.getAndIncrement();

				RuneLiteSplashScreen.stage(.67, .75, "Loading external plugins", loaded.get(), scannedPlugins.size());
			}));
			curGroup.forEach(future ->
			{
				try
				{
					future.get();
				}
				catch (InterruptedException | ExecutionException e)
				{
					e.printStackTrace();
				}
			});
		}

		return scannedPlugins;
	}

	@SuppressWarnings("unchecked")
	private Plugin instantiate(List<Plugin> scannedPlugins, Class<Plugin> clazz, boolean init, boolean initConfig)
		throws PluginInstantiationException
	{
		net.runelite.client.plugins.PluginDependency[] pluginDependencies =
			clazz.getAnnotationsByType(net.runelite.client.plugins.PluginDependency.class);
		List<Plugin> deps = new ArrayList<>();
		for (net.runelite.client.plugins.PluginDependency pluginDependency : pluginDependencies)
		{
			Optional<Plugin> dependency =
				Stream.concat(runelitePluginManager.getPlugins().stream(), scannedPlugins.stream())
					.filter(p -> p.getClass() == pluginDependency.value()).findFirst();
			if (!dependency.isPresent())
			{
				throw new PluginInstantiationException(
					"Unmet dependency for " + clazz.getSimpleName() + ": " + pluginDependency.value().getSimpleName());
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

			if (initConfig)
			{
				for (Key<?> key : pluginInjector.getAllBindings().keySet())
				{
					Class<?> type = key.getTypeLiteral().getRawType();
					if (Config.class.isAssignableFrom(type))
					{
						Config config = (Config) pluginInjector.getInstance(key);
						configManager.setDefaultConfiguration(config, false);
					}
				}
			}

			if (init)
			{
				try
				{
					SwingUtilities.invokeAndWait(() ->
					{
						try
						{
							runelitePluginManager.startPlugin(plugin);
							runelitePluginManager.add(plugin);
							eventBus.post(ExternalPluginChanged.class,
								new ExternalPluginChanged(pluginsMap.get(plugin.getClass().getSimpleName()), plugin,
									true));
						}
						catch (PluginInstantiationException e)
						{
							throw new RuntimeException(e);
						}
					});
				}
				catch (Exception ex)
				{
					log.warn("unable to start plugin", ex);
				}
			}
			else
			{
				runelitePluginManager.add(plugin);
			}
		}
		catch (CreationException ex)
		{
			throw new PluginInstantiationException(ex);
		}

		log.debug("Loaded plugin {}", clazz.getSimpleName());
		return plugin;
	}

	public void loadPlugins()
	{
		this.externalPluginManager.startPlugins();
		List<PluginWrapper> startedPlugins = getStartedPlugins();
		List<Plugin> scannedPlugins = new ArrayList<>();

		for (PluginWrapper plugin : startedPlugins)
		{
			boolean depsLoaded = true;
			for (PluginDependency dependency : plugin.getDescriptor().getDependencies())
			{
				if (startedPlugins.stream().noneMatch(pl -> pl.getPluginId().equals(dependency.getPluginId())))
				{
					depsLoaded = false;
				}
			}

			if (!depsLoaded)
			{
				// This should never happen but can crash the client
				continue;
			}

			scannedPlugins.addAll(loadPlugin(plugin.getPluginId()));
		}

		startPlugins(scannedPlugins, false, false);
	}

	private void startPlugins(List<Plugin> scannedPlugins, boolean init, boolean initConfig)
	{
		try
		{
			plugins.addAll(scanAndInstantiate(scannedPlugins, init, initConfig));
		}
		catch (IOException ignored)
		{
		}
	}

	private List<Plugin> loadPlugin(String pluginId)
	{
		List<Plugin> scannedPlugins = new ArrayList<>();
		List<Plugin> extensions = externalPluginManager.getExtensions(Plugin.class, pluginId);
		for (Plugin plugin : extensions)
		{
			pluginClassLoaders.add(plugin.getClass().getClassLoader());
			pluginsMap.put(plugin.getClass().getSimpleName(), pluginId);
			scannedPlugins.add(plugin);
		}

		return scannedPlugins;
	}

	private void stopPlugins()
	{
		List<PluginWrapper> startedPlugins = ImmutableList.copyOf(getStartedPlugins());

		for (PluginWrapper pluginWrapper : startedPlugins)
		{
			String pluginId = pluginWrapper.getDescriptor().getPluginId();
			List<Plugin> extensions = externalPluginManager.getExtensions(Plugin.class, pluginId);

			for (Plugin plugin : runelitePluginManager.getPlugins())
			{
				if (!extensions.get(0).getClass().getName().equals(plugin.getClass().getName()))
				{
					continue;
				}

				try
				{
					SwingUtilities.invokeAndWait(() ->
					{
						try
						{
							runelitePluginManager.stopPlugin(plugin);
						}
						catch (Exception e2)
						{
							throw new RuntimeException(e2);
						}
					});
					runelitePluginManager.remove(plugin);

					eventBus.post(ExternalPluginChanged.class, new ExternalPluginChanged(pluginId, plugin, false));
				}
				catch (Exception ex)
				{
					log.warn("unable to stop plugin", ex);
					return;
				}
			}
		}
	}

	private Path stopPlugin(String pluginId)
	{
		List<PluginWrapper> startedPlugins = ImmutableList.copyOf(getStartedPlugins());

		for (PluginWrapper pluginWrapper : startedPlugins)
		{
			if (!pluginId.equals(pluginWrapper.getDescriptor().getPluginId()))
			{
				continue;
			}

			List<Plugin> extensions = externalPluginManager.getExtensions(Plugin.class, pluginId);

			for (Plugin plugin : runelitePluginManager.getPlugins())
			{
				if (!extensions.get(0).getClass().getName().equals(plugin.getClass().getName()))
				{
					continue;
				}

				try
				{
					SwingUtilities.invokeAndWait(() ->
					{
						try
						{
							runelitePluginManager.stopPlugin(plugin);
						}
						catch (Exception e2)
						{
							throw new RuntimeException(e2);
						}
					});
					runelitePluginManager.remove(plugin);

					eventBus.post(ExternalPluginChanged.class, new ExternalPluginChanged(pluginId, plugin, false));

					return pluginWrapper.getPluginPath();
				}
				catch (Exception ex)
				{
					log.warn("unable to stop plugin", ex);
					return null;
				}
			}
		}

		return null;
	}

	public boolean install(String pluginId) throws VerifyException
	{

		if (getDisabledPlugins().contains(pluginId))
		{
			this.externalPluginManager.enablePlugin(pluginId);
			this.externalPluginManager.startPlugin(pluginId);

			startPlugins(loadPlugin(pluginId), true, false);

			return true;
		}

		if (getStartedPlugins().stream().anyMatch(ev -> ev.getPluginId().equals(pluginId)))
		{
			return true;
		}

		// Null version returns the last release version of this plugin for given system version
		try
		{
			PluginInfo.PluginRelease latest = updateManager.getLastPluginRelease(pluginId);

			if (latest == null)
			{
				try
				{
					SwingUtil.syncExec(() ->
						JOptionPane.showMessageDialog(ClientUI.getFrame(),
							pluginId + " is outdated and cannot be installed",
							"Installation error",
							JOptionPane.ERROR_MESSAGE));
				}
				catch (InvocationTargetException | InterruptedException ignored)
				{
					return false;
				}

				return true;
			}

			updateManager.installPlugin(pluginId, null);

			startPlugins(loadPlugin(pluginId), true, true);
		}
		catch (DependencyResolver.DependenciesNotFoundException ex)
		{
			uninstall(pluginId);

			for (String dep : ex.getDependencies())
			{
				install(dep);
			}

			install(pluginId);
		}
		return false;
	}

	public boolean uninstall(String pluginId)
	{
		Path pluginPath = stopPlugin(pluginId);

		if (pluginPath == null)
		{
			return false;
		}

		externalPluginManager.stopPlugin(pluginId);
		externalPluginManager.disablePlugin(pluginId);

		return true;
	}

	public void update()
	{
		boolean error = false;
		if (updateManager.hasUpdates())
		{
			List<PluginInfo> updates = updateManager.getUpdates();
			for (PluginInfo plugin : updates)
			{
				PluginInfo.PluginRelease lastRelease = updateManager.getLastPluginRelease(plugin.id);
				String lastVersion = lastRelease.version;
				try
				{
					boolean updated = updateManager.updatePlugin(plugin.id, lastVersion);

					if (!updated)
					{
						log.warn("Cannot update plugin '{}'", plugin.id);
						error = true;
					}
				}
				catch (PluginRuntimeException ex)
				{
					log.warn("Cannot update plugin '{}', the user probably has another client open", plugin.id);
					error = true;
					break;
				}
			}
		}

		if (error)
		{
			initPluginManager();
			startExternalUpdateManager();
			startExternalPluginManager();
		}
	}

	public Set<String> getDependencies()
	{
		Set<String> deps = new HashSet<>();
		List<PluginWrapper> startedPlugins = getStartedPlugins();

		for (PluginWrapper pluginWrapper : startedPlugins)
		{
			for (PluginDependency pluginDependency : pluginWrapper.getDescriptor().getDependencies())
			{
				deps.add(pluginDependency.getPluginId());
			}
		}

		return deps;
	}

	public List<String> getDisabledPlugins()
	{
		return this.externalPluginManager.getResolvedPlugins()
			.stream()
			.filter(not(this.externalPluginManager.getStartedPlugins()::contains))
			.map(PluginWrapper::getPluginId)
			.collect(Collectors.toList());
	}

	public List<PluginWrapper> getStartedPlugins()
	{
		return this.externalPluginManager.getStartedPlugins();
	}
}
