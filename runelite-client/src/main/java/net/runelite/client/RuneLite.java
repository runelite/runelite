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

import net.runelite.client.game.ItemManager;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.gson.Gson;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.account.AccountSession;
import net.runelite.client.events.SessionClose;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.task.Scheduler;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.overlay.OverlayRenderer;
import net.runelite.http.api.account.AccountClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuneLite
{
	private static final Logger logger = LoggerFactory.getLogger(RuneLite.class);

	public static final File RUNELITE_DIR = new File(System.getProperty("user.home"), ".runelite");
	public static final File PROFILES_DIR = new File(RUNELITE_DIR, "profiles");
	public static final File SESSION_FILE = new File(RUNELITE_DIR, "session");

	public static Image ICON;

	private static OptionSet options;
	private static Client client;
	private static RuneLite runelite;
	private static TrayIcon trayIcon;

	private ClientUI gui;
	private PluginManager pluginManager;
	private final MenuManager menuManager = new MenuManager(this);
	private OverlayRenderer renderer;
	private final EventBus eventBus = new EventBus(this::eventExceptionHandler);
	private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	private final Scheduler scheduler = new Scheduler(this);
	private WSClient wsclient;

	private AccountSession accountSession;
	private final ConfigManager configManager = new ConfigManager(eventBus);
	private final ItemManager itemManager = new ItemManager(this);

	static
	{
		try
		{
			ICON = ImageIO.read(ClientUI.class.getResourceAsStream("/runelite.png"));
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
		}
	}

	public static void main(String[] args) throws Exception
	{
		// Do not fill in background on repaint. Reduces flickering when
		// the applet is resized.
		System.setProperty("sun.awt.noerasebackground", "true");

		OptionParser parser = new OptionParser();
		parser.accepts("developer-mode");
		parser.accepts("no-rs");
		options = parser.parse(args);

		PROFILES_DIR.mkdirs();

		runelite = new RuneLite();
		runelite.start();
	}

	public void start() throws Exception
	{
		gui = new ClientUI();

		setupTrayIcon();

		configManager.load();

		eventBus.register(menuManager);

		// Load the plugins, but does not start them yet.
		// This will initialize configuration
		pluginManager = new PluginManager(this);
		pluginManager.loadPlugins();

		// Plugins have registered their config, so set default config
		// to main settings
		configManager.loadDefault();

		// Start plugins
		pluginManager.start();

		renderer = new OverlayRenderer();

		loadSession();
	}

	private void setupTrayIcon()
	{
		if (!SystemTray.isSupported())
		{
			return;
		}

		SystemTray systemTray = SystemTray.getSystemTray();

		trayIcon = new TrayIcon(ICON, "RuneLite");
		trayIcon.setImageAutoSize(true);

		try
		{
			systemTray.add(trayIcon);
		}
		catch (AWTException ex)
		{
			logger.debug("Unable to add system tray icon", ex);
		}
	}

	private void loadSession()
	{
		if (!SESSION_FILE.exists())
		{
			logger.info("No session file exists");
			return;
		}

		AccountSession session;

		try (FileInputStream in = new FileInputStream(SESSION_FILE))
		{
			session = new Gson().fromJson(new InputStreamReader(in), AccountSession.class);

			logger.debug("Loaded session for {}", session.getUsername());
		}
		catch (Exception ex)
		{
			logger.warn("Unable to load session file", ex);
			return;
		}

		// Check if session is still valid
		AccountClient accountClient = new AccountClient(session.getUuid());
		if (!accountClient.sesssionCheck())
		{
			logger.debug("Loaded session {} is invalid", session.getUuid());
			return;
		}

		openSession(session);
	}

	public void saveSession()
	{
		if (accountSession == null)
		{
			return;
		}

		try (FileWriter fw = new FileWriter(SESSION_FILE))
		{
			new Gson().toJson(accountSession, fw);

			logger.debug("Saved session to {}", SESSION_FILE);
		}
		catch (IOException ex)
		{
			logger.warn("Unable to save session file", ex);
		}
	}

	public void deleteSession()
	{
		SESSION_FILE.delete();
	}

	/**
	 * Set the given session as the active session and open a socket to the
	 * server with the given session
	 *
	 * @param session
	 */
	public void openSession(AccountSession session)
	{
		// If the ws session already exists, don't need to do anything
		if (wsclient == null || !wsclient.getSession().equals(session))
		{
			if (wsclient != null)
			{
				wsclient.close();
			}

			wsclient = new WSClient(session);
			wsclient.connect();
		}

		accountSession = session;

		if (session.getUsername() != null)
		{
			// Initialize config for new session
			// If the session isn't logged in yet, don't switch to the new config
			configManager.switchSession(session);
		}

		eventBus.post(new SessionOpen());
	}

	public void closeSession()
	{
		if (wsclient != null)
		{
			wsclient.close();
			wsclient = null;
		}

		if (accountSession == null)
		{
			return;
		}

		logger.debug("Logging out of account {}", accountSession.getUsername());

		accountSession = null; // No more account

		// Restore config
		configManager.switchSession(null);

		eventBus.post(new SessionClose());
	}

	private void eventExceptionHandler(Throwable exception, SubscriberExceptionContext context)
	{
		logger.warn("uncaught exception in event subscriber", exception);
	}

	public static Client getClient()
	{
		return client;
	}

	public static void setClient(Client client)
	{
		RuneLite.client = client;
	}

	public static RuneLite getRunelite()
	{
		return runelite;
	}

	public ClientUI getGui()
	{
		return gui;
	}

	public PluginManager getPluginManager()
	{
		return pluginManager;
	}

	public MenuManager getMenuManager()
	{
		return menuManager;
	}

	public OverlayRenderer getRenderer()
	{
		return renderer;
	}

	public EventBus getEventBus()
	{
		return eventBus;
	}

	public static OptionSet getOptions()
	{
		return options;
	}

	public ScheduledExecutorService getExecutor()
	{
		return executor;
	}

	public Scheduler getScheduler()
	{
		return scheduler;
	}

	public static TrayIcon getTrayIcon()
	{
		return trayIcon;
	}

	public void notify(String message)
	{
		notify(message, TrayIcon.MessageType.NONE);
	}

	public void notify(String message, TrayIcon.MessageType type)
	{
		getTrayIcon().displayMessage("RuneLite", message, type);
		Toolkit.getDefaultToolkit().beep();
	}

	public AccountSession getAccountSession()
	{
		return accountSession;
	}

	public ConfigManager getConfigManager()
	{
		return configManager;
	}

	public ItemManager getItemManager()
	{
		return itemManager;
	}
}
