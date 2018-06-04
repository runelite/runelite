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
import com.google.common.eventbus.EventBus;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import java.applet.Applet;
import java.io.File;
import java.util.Locale;
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
import net.runelite.client.chat.CommandManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.discord.DiscordService;
import net.runelite.client.game.ClanManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.DrawManager;
import net.runelite.client.ui.TitleToolbar;
import net.runelite.client.ui.overlay.OverlayRenderer;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@Singleton
@Slf4j
public class RuneLite
{
	public static final File RUNELITE_DIR = new File(System.getProperty("user.home"), ".runelite");
	public static final File PROFILES_DIR = new File(RUNELITE_DIR, "profiles");
	public static final File SCREENSHOT_DIR = new File(RUNELITE_DIR, "screenshots");
	private static final File LOGS_DIR = new File(RUNELITE_DIR, "logs");
	private static final File LOGS_FILE_NAME = new File(LOGS_DIR, "application");

	@Getter
	private static Injector injector;

	@Getter
	private static OptionSet options;

	@Inject
	private PluginManager pluginManager;

	@Inject
	private MenuManager menuManager;

	@Inject
	private EventBus eventBus;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private CommandManager commandManager;

	@Inject
	private OverlayRenderer overlayRenderer;

	@Inject
	private DrawManager drawManager;

	@Inject
	private SessionManager sessionManager;

	@Inject
	private DiscordService discordService;

	@Inject
	private ClientSessionManager clientSessionManager;

	@Inject
	private ClientUI clientUI;

	@Inject
	private TitleToolbar titleToolbar;

	@Inject
	private Provider<ItemManager> itemManager;

	@Inject
	private ClanManager clanManager;

	Client client;

	public static void main(String[] args) throws Exception
	{
		Locale.setDefault(Locale.ENGLISH);

		final OptionParser parser = new OptionParser();
		parser.accepts("developer-mode", "Enable developer tools");
		parser.accepts("debug", "Show extra debugging output");

		final ArgumentAcceptingOptionSpec<UpdateCheckMode> updateMode = parser
			.accepts("rs", "Select client type")
			.withRequiredArg()
			.ofType(UpdateCheckMode.class)
			.defaultsTo(UpdateCheckMode.AUTO)
			.withValuesConvertedBy(new EnumConverter<UpdateCheckMode>(UpdateCheckMode.class)
			{
				@Override
				public UpdateCheckMode convert(String v)
				{
					return super.convert(v.toUpperCase());
				}
			});

		parser.accepts("help", "Show this text").forHelp();
		options = parser.parse(args);

		if (getOptions().has("help"))
		{
			parser.printHelpOn(System.out);
			System.exit(0);
		}

		if (RuneLite.getOptions().has("developer-mode") && RuneLiteProperties.getLauncherVersion() == null)
		{
			boolean assertions = false;
			assert assertions = true;
			if (!assertions)
			{
				throw new RuntimeException("Developers should enable assertions; Add `-ea` to your JVM arguments`");
			}
		}

		PROFILES_DIR.mkdirs();

		// Setup logger
		MDC.put("logFileName", LOGS_FILE_NAME.getAbsolutePath());

		if (options.has("debug"))
		{
			final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
			logger.setLevel(Level.DEBUG);
		}

		Thread.setDefaultUncaughtExceptionHandler((thread, throwable) ->
		{
			log.error("Uncaught exception:", throwable);
			if (throwable instanceof AbstractMethodError)
			{
				log.error("Classes are out of date; Build with maven again.");
			}
		});

		injector = Guice.createInjector(new RuneLiteModule());
		injector.getInstance(RuneLite.class).start(getOptions().valueOf(updateMode));
	}

	public void start(UpdateCheckMode updateMode) throws Exception
	{
		// Load RuneLite or Vanilla client
		final Applet client = new ClientLoader().loadRs(updateMode);

		final boolean isOutdated = !(client instanceof Client);

		if (!isOutdated)
		{
			this.client = (Client) client;
		}

		// Initialize UI
		clientUI.init(client);

		// Initialize Discord service
		discordService.init();

		// Register event listeners
		eventBus.register(clientUI);
		eventBus.register(overlayRenderer);
		eventBus.register(drawManager);
		eventBus.register(menuManager);
		eventBus.register(chatMessageManager);
		eventBus.register(commandManager);
		eventBus.register(pluginManager);
		eventBus.register(clanManager);

		if (this.client != null)
		{
			eventBus.register(itemManager.get());
		}

		// Load user configuration
		configManager.load();

		// Tell the plugin manager if client is outdated or not
		pluginManager.setOutdated(isOutdated);

		// Load the plugins, but does not start them yet.
		// This will initialize configuration
		pluginManager.loadCorePlugins();

		// Plugins have provided their config, so set default config
		// to main settings
		pluginManager.loadDefaultPluginConfiguration();

		// Start client session
		clientSessionManager.start();

		// Load the session, including saved configuration
		sessionManager.loadSession();

		// Start plugins
		pluginManager.startCorePlugins();

		// Refresh title toolbar
		titleToolbar.refresh();

		// Show UI after all plugins are loaded
		clientUI.show();
	}

	public void shutdown()
	{
		clientSessionManager.shutdown();
		discordService.close();
	}

	@VisibleForTesting
	public static void setInjector(Injector injector)
	{
		RuneLite.injector = injector;
	}

	@VisibleForTesting
	public static void setOptions(OptionSet options)
	{
		RuneLite.options = options;
	}

	@VisibleForTesting
	public void setClient(Client client)
	{
		this.client = client;
	}
}
