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
import net.runelite.client.account.SessionManager;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.discord.DiscordService;
import net.runelite.client.graphics.ModelOutlineRenderer;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.rs.ClientLoader;
import net.runelite.client.rs.ClientUpdateCheckMode;
import net.runelite.client.task.Scheduler;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.RuneLiteSplashScreen;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.WidgetOverlay;
import net.runelite.client.ui.overlay.arrow.ArrowMinimapOverlay;
import net.runelite.client.ui.overlay.arrow.ArrowWorldOverlay;
import net.runelite.client.ui.overlay.infobox.InfoBoxOverlay;
import net.runelite.client.ui.overlay.tooltip.TooltipOverlay;
import net.runelite.client.ui.overlay.worldmap.WorldMapOverlay;
import org.slf4j.LoggerFactory;

@Singleton
@Slf4j
public class RuneLite
{
	public static final String RUNELIT_VERSION = "2.0.3";
	public static final File RUNELITE_DIR = new File(System.getProperty("user.home"), ".runelite");
	public static final File PROFILES_DIR = new File(RUNELITE_DIR, "profiles");
	public static final File PLUGIN_DIR = new File(RUNELITE_DIR, "plugins");
	public static final File SCREENSHOT_DIR = new File(RUNELITE_DIR, "screenshots");
	public static final File LOGS_DIR = new File(RUNELITE_DIR, "logs");
	private static final RuneLiteSplashScreen splashScreen = new RuneLiteSplashScreen();

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
	private Provider<ChatMessageManager> chatMessageManager;

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
		parser.accepts("local-injected", "Use local injected-client");

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

		if (options.has("help"))
		{
			parser.printHelpOn(System.out);
			System.exit(0);
		}

		final boolean developerMode = options.has("developer-mode");

		if (developerMode)
		{
			boolean assertions = false;
			assert assertions = true;
			if (!assertions)
			{
				java.util.logging.Logger.getAnonymousLogger().warning("Developers should enable assertions; Add `-ea` to your JVM arguments`");
			}
		}

		PROFILES_DIR.mkdirs();

		if (options.has("debug"))
		{
			final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
			logger.setLevel(Level.DEBUG);
		}

		if (options.has("local-injected"))
		{
			ClientLoader.useLocalInjected = true;
		}

		Thread.setDefaultUncaughtExceptionHandler((thread, throwable) ->
		{
			log.error("Uncaught exception:", throwable);
			if (throwable instanceof AbstractMethodError)
			{
				log.error("Classes are out of date; Build with maven again.");
			}
		});

		if (!options.has("no-splash"))
		{
			splashScreen.open(4);
		}

		// The submessage is shown in case the connection is slow
		splashScreen.setMessage("Starting RuneLite Injector");
		splashScreen.setSubMessage(" ");

		final long start = System.currentTimeMillis();

		injector = Guice.createInjector(new RuneLiteModule(
			options.valueOf(updateMode),
			true));

		injector.getInstance(RuneLite.class).start();
		splashScreen.setProgress(1, 5);
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
		splashScreen.setMessage("Loading configuration");
		configManager.load();

		// Load the session, including saved configuration
		sessionManager.loadSession();
		splashScreen.setProgress(2, 5);

		splashScreen.setMessage("Loading plugins");

		// Begin watching for new plugins
		pluginManager.watch();

		// Tell the plugin manager if client is outdated or not
		pluginManager.setOutdated(isOutdated);

		// Load the plugins, but does not start them yet.
		// This will initialize configuration
		pluginManager.loadCorePlugins();

		// Plugins have provided their config, so set default config
		// to main settings
		pluginManager.loadDefaultPluginConfiguration();
		splashScreen.setProgress(3, 5);

		splashScreen.setMessage("Starting Session");
		// Start client session
		clientSessionManager.start();
		splashScreen.setProgress(4, 5);

		// Load the session, including saved configuration
		splashScreen.setMessage("Loading interface");
		splashScreen.setProgress(5, 5);

		// Initialize UI
		clientUI.open(this);

		// Close the splash screen
		splashScreen.close();

		if (!isOutdated)
		{
			// Initialize chat colors
			chatMessageManager.get().loadColors();

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
		}
	}

	public void shutdown()
	{
		configManager.sendConfig();
		clientSessionManager.shutdown();
		discordService.close();

		for (final Plugin plugin : pluginManager.getPlugins())
		{
			try
			{
				pluginManager.stopPlugin(plugin);
			}
			catch (PluginInstantiationException e)
			{
				log.warn("Failed to gracefully close plugin", e);
			}
		}
	}

	@VisibleForTesting
	public static void setInjector(Injector injector)
	{
		RuneLite.injector = injector;
	}
}
