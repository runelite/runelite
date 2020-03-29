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
package net.runelite.client;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import javax.inject.Provider;
import javax.inject.Singleton;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.ValueConversionException;
import joptsimple.ValueConverter;
import joptsimple.util.EnumConverter;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.account.SessionManager;
import net.runelite.client.callback.Hooks;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.CommandManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.OpenOSRSConfig;
import net.runelite.client.discord.DiscordService;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ExternalPluginsLoaded;
import net.runelite.client.game.ClanManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.LootManager;
import net.runelite.client.game.PlayerManager;
import net.runelite.client.game.WorldService;
import net.runelite.client.game.XpDropManager;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.graphics.ModelOutlineRenderer;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.ExternalPluginManager;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.rs.ClientLoader;
import net.runelite.client.rs.ClientUpdateCheckMode;
import net.runelite.client.task.Scheduler;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.RuneLiteSplashScreen;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.OverlayRenderer;
import net.runelite.client.ui.overlay.WidgetOverlay;
import net.runelite.client.ui.overlay.arrow.ArrowMinimapOverlay;
import net.runelite.client.ui.overlay.arrow.ArrowWorldOverlay;
import net.runelite.client.ui.overlay.infobox.InfoBoxOverlay;
import net.runelite.client.ui.overlay.tooltip.TooltipOverlay;
import net.runelite.client.ui.overlay.worldmap.WorldMapOverlay;
import net.runelite.client.util.Groups;
import net.runelite.client.util.WorldUtil;
import net.runelite.client.ws.PartyService;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldResult;
import org.slf4j.LoggerFactory;

@Singleton
@Slf4j
public class RuneLite
{
	public static final String SYSTEM_VERSION = "0.0.1";

	public static final File RUNELITE_DIR = new File(System.getProperty("user.home"), ".runelite");
	public static final File CACHE_DIR = new File(RUNELITE_DIR, "cache");
	public static final File PROFILES_DIR = new File(RUNELITE_DIR, "profiles");
	public static final File PLUGIN_DIR = new File(RUNELITE_DIR, "plugins");
	public static final File EXTERNALPLUGIN_DIR = new File(RUNELITE_DIR, "externalmanager");
	public static final File SCREENSHOT_DIR = new File(RUNELITE_DIR, "screenshots");
	public static final File LOGS_DIR = new File(RUNELITE_DIR, "logs");
	public static final File PLUGINS_DIR = new File(RUNELITE_DIR, "plugins");
	public static final File DEFAULT_CONFIG_FILE = new File(RUNELITE_DIR, "runeliteplus.properties");
	public static final Locale SYSTEM_LOCALE = Locale.getDefault();
	public static boolean allowPrivateServer = false;
	public static String uuid = UUID.randomUUID().toString();

	@Getter
	private static Injector injector;

	@Inject
	public DiscordService discordService;

	@Inject
	private WorldService worldService;

	@Inject
	private PluginManager pluginManager;

	@Inject
	private ExternalPluginManager externalPluginManager;

	@Inject
	private ConfigManager configManager;

	@Inject
	private SessionManager sessionManager;

	@Inject
	private ClientSessionManager clientSessionManager;

	@Inject
	private ClientUI clientUI;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private Provider<ItemManager> itemManager;

	@Inject
	private Provider<OverlayRenderer> overlayRenderer;

	@Inject
	private Provider<ClanManager> clanManager;

	@Inject
	private Provider<ChatMessageManager> chatMessageManager;

	@Inject
	private Provider<MenuManager> menuManager;

	@Inject
	private Provider<CommandManager> commandManager;

	@Inject
	private Provider<InfoBoxOverlay> infoBoxOverlay;

	@Inject
	private Provider<TooltipOverlay> tooltipOverlay;

	@Inject
	private Provider<WorldMapOverlay> worldMapOverlay;

	@Inject
	private Provider<ArrowWorldOverlay> arrowWorldOverlay;

	@Inject
	private Provider<ArrowMinimapOverlay> arrowMinimapOverlay;

	@Inject
	private Provider<LootManager> lootManager;

	@Inject
	private Provider<XpDropManager> xpDropManager;

	@Inject
	private Provider<PlayerManager> playerManager;

	@Inject
	private Provider<ChatboxPanelManager> chatboxPanelManager;

	@Inject
	private Provider<PartyService> partyService;

	@Inject
	private Groups groups;

	@Inject
	private Hooks hooks;

	@Inject
	private EventBus eventBus;

	@Inject
	@Nullable
	private Client client;

	@Inject
	private OpenOSRSConfig openOSRSConfig;

	@Inject
	private Provider<ModelOutlineRenderer> modelOutlineRenderer;

	@Inject
	private Scheduler scheduler;

	public static void main(String[] args) throws Exception
	{
		Locale.setDefault(Locale.ENGLISH);

		final OptionParser parser = new OptionParser();
		parser.accepts("developer-mode", "Enable developer tools");
		parser.accepts("debug", "Show extra debugging output");
		parser.accepts("no-splash", "Do not show the splash screen");
		final ArgumentAcceptingOptionSpec<String> proxyInfo = parser
			.accepts("proxy")
			.withRequiredArg().ofType(String.class);
		final ArgumentAcceptingOptionSpec<Integer> worldInfo = parser
			.accepts("world")
			.withRequiredArg().ofType(Integer.class);
		final ArgumentAcceptingOptionSpec<File> configfile = parser.accepts("config", "Use a specified config file")
			.withRequiredArg()
			.withValuesConvertedBy(new ConfigFileConverter())
			.defaultsTo(DEFAULT_CONFIG_FILE);

		final ArgumentAcceptingOptionSpec<ClientUpdateCheckMode> updateMode = parser
			.accepts("rs", "Select client type")
			.withRequiredArg()
			.ofType(ClientUpdateCheckMode.class)
			.defaultsTo(ClientUpdateCheckMode.AUTO)
			.withValuesConvertedBy(new EnumConverter<ClientUpdateCheckMode>(ClientUpdateCheckMode.class)
			{
				@Override
				public ClientUpdateCheckMode convert(String v)
				{
					return super.convert(v.toUpperCase());
				}
			});

		parser.accepts("help", "Show this text").forHelp();

		OptionSet options = parser.parse("");

		try
		{
			options = parser.parse(args);
		}
		catch (OptionException e)
		{
			log.warn("Error parsing launch args: {}", e.getMessage());
			log.warn("Proceeding with no arguments.");
		}

		if (options.has("help"))
		{
			parser.printHelpOn(System.out);
			System.exit(0);
		}

		if (options.has("debug"))
		{
			final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
			logger.setLevel(Level.DEBUG);
		}

		if (options.has("proxy"))
		{
			String[] proxy = options.valueOf(proxyInfo).split(":");

			if (proxy.length >= 2)
			{
				System.setProperty("socksProxyHost", proxy[0]);
				System.setProperty("socksProxyPort", proxy[1]);
			}

			if (proxy.length >= 4)
			{
				System.setProperty("java.net.socks.username", proxy[2]);
				System.setProperty("java.net.socks.password", proxy[3]);

				final String user = proxy[2];
				final char[] pass = proxy[3].toCharArray();

				Authenticator.setDefault(new Authenticator()
				{
					private final PasswordAuthentication auth = new PasswordAuthentication(user, pass);

					protected PasswordAuthentication getPasswordAuthentication()
					{
						return auth;
					}
				});
			}
		}

		if (options.has("world"))
		{
			int world = options.valueOf(worldInfo);
			System.setProperty("cli.world", String.valueOf(world));
		}

		final ClientLoader clientLoader = new ClientLoader(options.valueOf(updateMode));
		Completable.fromAction(clientLoader::get)
			.subscribeOn(Schedulers.computation())
			.subscribe();

		Completable.fromAction(ClassPreloader::preload)
			.subscribeOn(Schedulers.computation())
			.subscribe();

		if (!options.has("no-splash"))
		{
			RuneLiteSplashScreen.init();
		}

		Thread.setDefaultUncaughtExceptionHandler((thread, throwable) ->
		{
			log.error("Uncaught exception:", throwable);
			if (throwable instanceof AbstractMethodError)
			{
				RuneLiteSplashScreen.setError("Out of date!", "Classes are out of date; Build with Gradle again.");
				return;
			}

			RuneLiteSplashScreen.setError("Error while loading!", "Please check your internet connection and your DNS settings.");
		});

		PROFILES_DIR.mkdirs();

		final long start = System.currentTimeMillis();

		injector = Guice.createInjector(new RuneLiteModule(
			clientLoader,
			options.valueOf(configfile)));

		injector.getInstance(RuneLite.class).start();
		final long end = System.currentTimeMillis();
		final RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
		final long uptime = rb.getUptime();
		log.info("Client initialization took {}ms. Uptime: {}ms", end - start, uptime);
	}

	@VisibleForTesting
	public static void setInjector(Injector injector)
	{
		RuneLite.injector = injector;
	}

	private void start() throws Exception
	{
		// Load RuneLite or Vanilla client
		final boolean isOutdated = client == null;

		if (!isOutdated)
		{
			// Inject members into client
			injector.injectMembers(client);
		}

		if (RuneLiteProperties.getLauncherVersion() == null || !openOSRSConfig.shareLogs())
		{
			final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
			logger.detachAppender("Sentry");
		}

		// Load user configuration
		RuneLiteSplashScreen.stage(.57, "Loading user config");
		configManager.load();

		// Load the session, including saved configuration
		RuneLiteSplashScreen.stage(.58, "Loading session data");
		sessionManager.loadSession();

		// Tell the plugin manager if client is outdated or not
		pluginManager.setOutdated(isOutdated);

		// Load external plugin manager
		externalPluginManager.startExternalUpdateManager();
		externalPluginManager.startExternalPluginManager();

		// Update external plugins
		externalPluginManager.update();

		// Load the plugins, but does not start them yet.
		// This will initialize configuration
		pluginManager.loadCorePlugins();
		externalPluginManager.loadPlugins();

		// Load external plugins
		pluginManager.loadExternalPlugins();

		RuneLiteSplashScreen.stage(.76, "Finalizing configuration");

		// Plugins have provided their config, so set default config
		// to main settings
		pluginManager.loadDefaultPluginConfiguration();

		// Start client session
		RuneLiteSplashScreen.stage(.77, "Starting core interface");
		clientSessionManager.start();

		//Set the world if specified via CLI args - will not work until clientUI.init is called
		Optional<Integer> worldArg = Optional.ofNullable(System.getProperty("cli.world")).map(Integer::parseInt);
		worldArg.ifPresent(this::setWorld);

		// Initialize UI
		RuneLiteSplashScreen.stage(.80, "Initialize UI");
		clientUI.init(this);

		// Initialize Discord service
		discordService.init();

		if (!isOutdated)
		{
			// Initialize chat colors
			chatMessageManager.get().loadColors();

			overlayRenderer.get();
			clanManager.get();
			itemManager.get();
			menuManager.get();
			chatMessageManager.get();
			commandManager.get();
			lootManager.get();
			xpDropManager.get();
			playerManager.get();
			chatboxPanelManager.get();
			partyService.get();

			eventBus.subscribe(GameStateChanged.class, this, hooks::onGameStateChanged);
			eventBus.subscribe(ScriptCallbackEvent.class, this, hooks::onScriptCallbackEvent);

			// Add core overlays
			WidgetOverlay.createOverlays(client).forEach(overlayManager::add);
			overlayManager.add(infoBoxOverlay.get());
			overlayManager.add(worldMapOverlay.get());
			overlayManager.add(tooltipOverlay.get());
			overlayManager.add(arrowWorldOverlay.get());
			overlayManager.add(arrowMinimapOverlay.get());
		}

		// Start plugins
		pluginManager.startPlugins();
		eventBus.post(ExternalPluginsLoaded.class, new ExternalPluginsLoaded());

		// Register additional schedulers
		if (this.client != null)
		{
			scheduler.registerObject(modelOutlineRenderer.get());
			scheduler.registerObject(clientSessionManager);
		}

		// Close the splash screen
		RuneLiteSplashScreen.close();

		clientUI.show();
	}

	private void setWorld(int cliWorld)
	{
		int correctedWorld = cliWorld < 300 ? cliWorld + 300 : cliWorld;

		if (correctedWorld <= 300 || client.getWorld() == correctedWorld)
		{
			return;
		}

		final WorldResult worldResult = worldService.getWorlds();

		if (worldResult == null)
		{
			log.warn("Failed to lookup worlds.");
			return;
		}

		final World world = worldResult.findWorld(correctedWorld);

		if (world != null)
		{
			final net.runelite.api.World rsWorld = client.createWorld();
			rsWorld.setActivity(world.getActivity());
			rsWorld.setAddress(world.getAddress());
			rsWorld.setId(world.getId());
			rsWorld.setPlayerCount(world.getPlayers());
			rsWorld.setLocation(world.getLocation());
			rsWorld.setTypes(WorldUtil.toWorldTypes(world.getTypes()));

			client.changeWorld(rsWorld);
			log.debug("Applied new world {}", correctedWorld);
		}
		else
		{
			log.warn("World {} not found.", correctedWorld);
		}
	}

	public void shutdown()
	{
		clientSessionManager.shutdown();
		discordService.close();
		groups.close();
	}

	private static class ConfigFileConverter implements ValueConverter<File>
	{
		@Override
		public File convert(String fileName)
		{
			final File file;

			if (Paths.get(fileName).isAbsolute()
				|| fileName.startsWith("./")
				|| fileName.startsWith(".\\"))
			{
				file = new File(fileName);
			}
			else
			{
				file = new File(RuneLite.RUNELITE_DIR, fileName);
			}

			if (file.exists() && (!file.isFile() || !file.canWrite()))
			{
				throw new ValueConversionException(String.format("File %s is not accessible", file.getAbsolutePath()));
			}

			return file;
		}

		@Override
		public Class<? extends File> valueType()
		{
			return File.class;
		}

		@Override
		public String valuePattern()
		{
			return null;
		}
	}
}
