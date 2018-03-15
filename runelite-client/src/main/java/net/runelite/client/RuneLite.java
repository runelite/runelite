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
import java.applet.Applet;
import java.io.File;
import java.util.Optional;
import javax.inject.Singleton;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.account.SessionManager;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.discord.DiscordService;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.ClientUI;
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

	private static Injector injector;
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
	private OverlayRenderer overlayRenderer;

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

	Client client;

	public static void main(String[] args) throws Exception
	{
		OptionParser parser = new OptionParser();
		parser.accepts("developer-mode");
		parser.accepts("no-rs");
		parser.accepts("debug");
		setOptions(parser.parse(args));

		PROFILES_DIR.mkdirs();

		// Setup logger
		MDC.put("logFileName", LOGS_FILE_NAME.getAbsolutePath());

		if (options.has("debug"))
		{
			final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
			logger.setLevel(Level.DEBUG);
		}

		setInjector(Guice.createInjector(new RuneLiteModule()));
		injector.getInstance(RuneLite.class).start();
	}

	public void start() throws Exception
	{
		// Load RuneLite or Vanilla client
		final boolean hasRs = !getOptions().has("no-rs");
		final Optional<Applet> optionalClient = hasRs
			? new ClientLoader().loadRs()
			: Optional.empty();

		if (!optionalClient.isPresent() && hasRs)
		{
			System.exit(-1);
			return;
		}

		final Applet client = optionalClient.orElse(null);
		final boolean isOutdated = client == null || !(client instanceof Client);

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
		eventBus.register(menuManager);
		eventBus.register(chatMessageManager);
		eventBus.register(pluginManager);

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

		// Start plugins
		pluginManager.startCorePlugins();
		
		// Start client session
		clientSessionManager.start();

		// Load the session, including saved configuration
		sessionManager.loadSession();

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
	public void setClient(Client client)
	{
		this.client = client;
	}

	public static Injector getInjector()
	{
		return injector;
	}

	public static void setInjector(Injector injector)
	{
		RuneLite.injector = injector;
	}

	public static OptionSet getOptions()
	{
		return options;
	}

	public static void setOptions(OptionSet options)
	{
		RuneLite.options = options;
	}
}
