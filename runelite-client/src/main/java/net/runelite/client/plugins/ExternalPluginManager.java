package net.runelite.client.plugins;

import com.google.common.collect.ImmutableList;
import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JOptionPane;
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
import net.runelite.client.events.ExternalPluginsLoaded;
import net.runelite.client.ui.RuneLiteSplashScreen;
import net.runelite.client.util.SwingUtil;
import org.pf4j.DefaultPluginManager;
import org.pf4j.DependencyResolver;
import org.pf4j.JarPluginLoader;
import org.pf4j.JarPluginRepository;
import org.pf4j.ManifestPluginDescriptorFinder;
import org.pf4j.PluginDependency;
import org.pf4j.PluginDescriptorFinder;
import org.pf4j.PluginLoader;
import org.pf4j.PluginRepository;
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
	private final PluginManager runelitePluginManager;
	private final org.pf4j.PluginManager externalPluginManager;

	@Getter(AccessLevel.PUBLIC)
	private final List<UpdateRepository> repositories = new ArrayList<>();
	private final OpenOSRSConfig openOSRSConfig;
	private final ConfigManager configManager;
	private final EventBus eventBus;

	@Getter(AccessLevel.PUBLIC)
	private UpdateManager updateManager;

	@Inject
	public ExternalPluginManager(
		PluginManager pluginManager,
		OpenOSRSConfig openOSRSConfig,
		ConfigManager configManager,
		EventBus eventBus)
	{
		this.runelitePluginManager = pluginManager;
		this.openOSRSConfig = openOSRSConfig;
		this.configManager = configManager;
		this.eventBus = eventBus;

		//noinspection ResultOfMethodCallIgnored
		EXTERNALPLUGIN_DIR.mkdirs();

		boolean debug = RuneLiteProperties.getLauncherVersion() == null && RuneLiteProperties.getPluginPath() != null;

		this.externalPluginManager = new DefaultPluginManager(debug ? Paths.get(RuneLiteProperties.getPluginPath() + File.separator + "release") : EXTERNALPLUGIN_DIR.toPath())
		{
			@Override
			protected PluginDescriptorFinder createPluginDescriptorFinder()
			{
				return new ManifestPluginDescriptorFinder();
			}

			@Override
			protected PluginRepository createPluginRepository()
			{
				return new JarPluginRepository(getPluginsRoot());
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
		};
		this.externalPluginManager.setSystemVersion(SYSTEM_VERSION);
	}

	private static URL toRepositoryUrl(String owner, String name) throws MalformedURLException
	{
		return new URL("https://raw.githubusercontent.com/" + owner + "/" + name + "/master/");
	}

	public static boolean testRepository(String owner, String name)
	{
		final List<UpdateRepository> repositories = new ArrayList<>();
		try
		{
			repositories.add(new DefaultUpdateRepository("github", new URL("https://raw.githubusercontent.com/" + owner + "/" + name + "/master/")));
		}
		catch (MalformedURLException e)
		{
			return true;
		}
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
		this.externalPluginManager.loadPlugins();
	}

	public void startExternalUpdateManager()
	{
		try
		{
			for (String keyval : openOSRSConfig.getExternalRepositories().split(";"))
			{
				String[] repository = keyval.split(":", 2);
				repositories.add(new DefaultUpdateRepository(repository[0], new URL(repository[1])));
			}
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}

		this.updateManager = new UpdateManager(this.externalPluginManager, repositories);
	}

	public void addRepository(String owner, String name)
	{
		try
		{
			DefaultUpdateRepository respository = new DefaultUpdateRepository(owner, toRepositoryUrl(owner, name));
			updateManager.addRepository(respository);
			saveConfig();
		}
		catch (MalformedURLException e)
		{
			log.error("Repostitory could not be added");
		}
	}

	public void removeRepository(String owner)
	{
		updateManager.removeRepository(owner);
		saveConfig();
	}

	private void saveConfig()
	{
		StringBuilder config = new StringBuilder();

		for (UpdateRepository repository : updateManager.getRepositories())
		{
			config.append(repository.getId());
			config.append(":");
			config.append(repository.getUrl().toString());
			config.append(";");
		}
		config.deleteCharAt(config.lastIndexOf(";"));

		openOSRSConfig.setExternalRepositories(config.toString());
	}

	private void instantiatePlugin(String pluginId, Plugin plugin) throws PluginInstantiationException
	{
		List<Plugin> scannedPlugins = new ArrayList<>(runelitePluginManager.getPlugins());
		Class<? extends Plugin> clazz = plugin.getClass();

		PluginDescriptor[] pluginDescriptors = clazz.getAnnotationsByType(PluginDescriptor.class);

		for (PluginDescriptor pluginDescriptor : pluginDescriptors)
		{
			if (pluginDescriptor.type() == PluginType.EXTERNAL)
			{
				log.error("Class {} is using the the new external plugin loader, it should not use PluginType.EXTERNAL", clazz);
				return;
			}
		}

		net.runelite.client.plugins.PluginDependency[] pluginDependencies = clazz.getAnnotationsByType(net.runelite.client.plugins.PluginDependency.class);
		List<Plugin> deps = new ArrayList<>();
		for (net.runelite.client.plugins.PluginDependency pluginDependency : pluginDependencies)
		{
			Optional<Plugin> dependency = scannedPlugins.stream().filter(p -> p.getClass() == pluginDependency.value()).findFirst();
			if (dependency.isEmpty())
			{
				throw new PluginInstantiationException("Unmet dependency for " + clazz.getSimpleName() + ": " + pluginDependency.value().getSimpleName());
			}
			deps.add(dependency.get());
		}

		Module pluginModule = (Binder binder) ->
		{
			//noinspection unchecked
			binder.bind((Class<Plugin>) plugin.getClass()).toInstance(plugin);
			binder.install(plugin);

			for (Plugin p : deps)
			{
				Module p2 = (Binder binder2) ->
				{
					//noinspection unchecked
					binder2.bind((Class<Plugin>) p.getClass()).toInstance(p);
					binder2.install(p);
				};
				binder.install(p2);
			}
		};
		Injector pluginInjector = RuneLite.getInjector().createChildInjector(pluginModule);
		pluginInjector.injectMembers(plugin);
		plugin.injector = pluginInjector;

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
			runelitePluginManager.startPlugin(plugin);
		}
		catch (PluginInstantiationException ex)
		{
			log.warn("unable to start plugin", ex);
			return;
		}

		runelitePluginManager.add(plugin);
		eventBus.post(ExternalPluginChanged.class, new ExternalPluginChanged(pluginId, plugin, true));
	}

	public void loadPlugins()
	{
		this.externalPluginManager.startPlugins();
		List<PluginWrapper> startedPlugins = getStartedPlugins();
		int index = 1;

		for (PluginWrapper plugin : startedPlugins)
		{
			RuneLiteSplashScreen.stage(.90, 1, "Starting external plugins", index++, startedPlugins.size());
			loadPlugin(plugin.getPluginId());
		}

		eventBus.post(ExternalPluginsLoaded.class, new ExternalPluginsLoaded());
	}

	private void loadPlugin(String pluginId)
	{
		try
		{
			List<Plugin> extensions = externalPluginManager.getExtensions(Plugin.class, pluginId);
			for (Plugin plugin : extensions)
			{
				try
				{
					instantiatePlugin(pluginId, plugin);
				}
				catch (PluginInstantiationException e)
				{
					log.warn("Error instantiating plugin!", e);
					return;
				}
			}
		}
		catch (NoClassDefFoundError ex)
		{
			try
			{
				SwingUtil.syncExec(() ->
					JOptionPane.showMessageDialog(null,
						pluginId + " could not be loaded due to the following error: " + ex.getMessage(),
						"External plugin error",
						JOptionPane.ERROR_MESSAGE));
			}
			catch (InvocationTargetException | InterruptedException ignored)
			{
			}
		}
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
					runelitePluginManager.stopPlugin(plugin);
					runelitePluginManager.remove(plugin);

					eventBus.post(ExternalPluginChanged.class, new ExternalPluginChanged(pluginId, plugin, false));
				}
				catch (PluginInstantiationException ex)
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
					runelitePluginManager.stopPlugin(plugin);
					runelitePluginManager.remove(plugin);

					eventBus.post(ExternalPluginChanged.class, new ExternalPluginChanged(pluginId, plugin, false));

					return pluginWrapper.getPluginPath();
				}
				catch (PluginInstantiationException ex)
				{
					log.warn("unable to stop plugin", ex);
					return null;
				}
			}
		}

		return null;
	}

	public void install(String pluginId) throws VerifyException
	{

		if (getDisabledPlugins().contains(pluginId))
		{
			this.externalPluginManager.enablePlugin(pluginId);
			this.externalPluginManager.startPlugin(pluginId);

			loadPlugin(pluginId);

			return;
		}

		if (getStartedPlugins().stream().anyMatch(ev -> ev.getPluginId().equals(pluginId)))
		{
			return;
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
						JOptionPane.showMessageDialog(null,
							pluginId + " is outdated and cannot be installed",
							"Installation error",
							JOptionPane.ERROR_MESSAGE));
				}
				catch (InvocationTargetException | InterruptedException ignored)
				{
				}

				return;
			}

			updateManager.installPlugin(pluginId, null);

			loadPlugin(pluginId);
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

	}

	public void uninstall(String pluginId)
	{
		Path pluginPath = stopPlugin(pluginId);

		if (pluginPath == null)
		{
			return;
		}

		externalPluginManager.stopPlugin(pluginId);
		externalPluginManager.disablePlugin(pluginId);
	}

	public void update()
	{
		if (updateManager.hasUpdates())
		{
			List<PluginInfo> updates = updateManager.getUpdates();
			for (PluginInfo plugin : updates)
			{
				PluginInfo.PluginRelease lastRelease = updateManager.getLastPluginRelease(plugin.id);
				String lastVersion = lastRelease.version;
				boolean updated = updateManager.updatePlugin(plugin.id, lastVersion);

				if (!updated)
				{
					log.warn("Cannot update plugin '{}'", plugin.id);
				}
			}
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
