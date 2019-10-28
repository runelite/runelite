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
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Provider;
import javax.inject.Singleton;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.util.EnumConverter;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.account.SessionManager;
import net.runelite.client.callback.Hooks;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.CommandManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.discord.DiscordService;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ClanManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.LootManager;
import net.runelite.client.game.XpDropManager;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.graphics.ModelOutlineRenderer;
import net.runelite.client.menus.MenuManager;
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
import net.runelite.client.util.bootstrap.Bootstrapper;
import org.slf4j.LoggerFactory;

@Singleton
@Slf4j
public class RuneLite
{
	public static final File RUNELITE_DIR = new File(System.getProperty("user.home"), ".runelite");
	public static final File PROFILES_DIR = new File(RUNELITE_DIR, "profiles");
	public static final File PLUGIN_DIR = new File(RUNELITE_DIR, "plugins");
	public static final File SCREENSHOT_DIR = new File(RUNELITE_DIR, "screenshots");
	public static final File LOGS_DIR = new File(RUNELITE_DIR, "logs");
	public static final Locale SYSTEM_LOCALE = Locale.getDefault();
	public static boolean allowPrivateServer = false;

	@Getter
	private static Injector injector;

	@Inject
	private PluginManager pluginManager;

	@Inject
	private ConfigManager configManager;

	@Inject
	private SessionManager sessionManager;

	@Inject
	public DiscordService discordService;

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
	private Provider<ChatboxPanelManager> chatboxPanelManager;

	@Inject
	private Hooks hooks;

	@Inject
	private EventBus eventBus;

	@Inject
	@Nullable
	private Client client;

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
		parser.accepts("bootstrap", "Builds a bootstrap with locally built jars");
		parser.accepts("bootstrap-staging", "Builds a testing bootstrap with locally built jars");
		final ArgumentAcceptingOptionSpec<String> proxyInfo = parser
			.accepts("proxy")
			.withRequiredArg().ofType(String.class);

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
		OptionSet options = parser.parse(args);

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

		if (options.has("bootstrap"))
		{
			Bootstrapper.main(false);
			System.exit(0);
		}

		if (options.has("bootstrap-staging"))
		{
			Bootstrapper.main(true);
			System.exit(0);
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
					private PasswordAuthentication auth = new PasswordAuthentication(user, pass);

					protected PasswordAuthentication getPasswordAuthentication()
					{
						return auth;
					}
				});
			}
		}

		final ClientLoader clientLoader = new ClientLoader(options.valueOf(updateMode));
		Completable.fromAction(clientLoader::get)
			.subscribeOn(Schedulers.single())
			.subscribe();

		Completable.fromAction(ClassPreloader::preload)
			.subscribeOn(Schedulers.computation())
			.subscribe();

		if (!options.has("no-splash"))
		{
			RuneLiteSplashScreen.init();
		}

		final boolean developerMode = options.has("developer-mode");

		if (developerMode)
		{
			boolean assertions = false;
			assert assertions = true;
			if (!assertions)
			{
				log.warn("Developers should enable assertions; Add `-ea` to your JVM arguments`");
			}
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

		RuneLiteSplashScreen.stage(0, "Starting OpenOSRS injector");

		PROFILES_DIR.mkdirs();

		final long start = System.currentTimeMillis();

		injector = Guice.createInjector(new RuneLiteModule(
			clientLoader,
			true));

		injector.getInstance(RuneLite.class).start();

		final long end = System.currentTimeMillis();
		final RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
		final long uptime = rb.getUptime();
		log.info("Client initialization took {}ms. Uptime: {}ms", end - start, uptime);
	}

	public void start() throws Exception
	{
		// Load RuneLite or Vanilla client
		final boolean isOutdated = client == null;

		if (!isOutdated)
		{
			// Inject members into client
			injector.injectMembers(client);
		}

		// Load user configuration
		RuneLiteSplashScreen.stage(.57, "Loading user config");
		configManager.load();

		// Load the session, including saved configuration
		RuneLiteSplashScreen.stage(.58, "Loading session data");
		sessionManager.loadSession();

		// Tell the plugin manager if client is outdated or not
		pluginManager.setOutdated(isOutdated);

		// Load external plugins
		pluginManager.loadExternalPlugins();

		// Load the plugins, but does not start them yet.
		// This will initialize configuration
		pluginManager.loadCorePlugins();
		RuneLiteSplashScreen.stage(.70, "Finalizing configuration");

		// Plugins have provided their config, so set default config
		// to main settings
		pluginManager.loadDefaultPluginConfiguration();

		// Start client session
		RuneLiteSplashScreen.stage(.75, "Starting core interface");
		clientSessionManager.start();

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
			chatboxPanelManager.get();

			eventBus.subscribe(GameStateChanged.class, this, hooks::onGameStateChanged);

			// Add core overlays
			WidgetOverlay.createOverlays(client).forEach(overlayManager::add);
			overlayManager.add(infoBoxOverlay.get());
			overlayManager.add(worldMapOverlay.get());
			overlayManager.add(tooltipOverlay.get());
			overlayManager.add(arrowWorldOverlay.get());
			overlayManager.add(arrowMinimapOverlay.get());
		}

		// Start plugins
		pluginManager.startCorePlugins();

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

	public void shutdown()
	{
		configManager.sendConfig();
		clientSessionManager.shutdown();
		discordService.close();
	}

	@VisibleForTesting
	public static void setInjector(Injector injector)
	{
		RuneLite.injector = injector;
	}
}
