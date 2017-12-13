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

import com.google.common.base.Strings;
import com.google.common.eventbus.EventBus;
import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.inject.Singleton;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Query;
import net.runelite.client.account.AccountSession;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.SessionClose;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.overlay.OverlayRenderer;
import net.runelite.http.api.account.AccountClient;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel;

@Singleton
@Slf4j
public class RuneLite
{
	public static final File RUNELITE_DIR = new File(System.getProperty("user.home"), ".runelite");
	public static final File PROFILES_DIR = new File(RUNELITE_DIR, "profiles");
	public static final File SESSION_FILE = new File(RUNELITE_DIR, "session");
	public static final File PLUGIN_DIR = new File(RUNELITE_DIR, "plugins");
	public static final String APP_NAME = "RuneLite";

	public static Image ICON;

	private static Injector injector;

	private static OptionSet options;
	private static RuneLite runelite;
	private static TrayIcon trayIcon;

	private final RuneliteProperties properties = new RuneliteProperties();
	private Client client;
	private ClientUI gui;

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
	private ScheduledExecutorService executor;

	@Inject
	private OverlayRenderer overlayRenderer;

	private WSClient wsclient;

	private AccountSession accountSession;

	private Notifier notifier;

	static
	{
		try
		{
			final URL icon = ClientUI.class.getResource("/runelite.png");
			ICON = ImageIO.read(icon.openStream());
		}
		catch (IOException ex)
		{
			log.warn(null, ex);
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

		injector = Guice.createInjector(new RuneliteModule());
		runelite = injector.getInstance(RuneLite.class);
		runelite.start();
	}

	public void start() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			JFrame.setDefaultLookAndFeelDecorated(true);
			JPopupMenu.setDefaultLightWeightPopupEnabled(false);

			try
			{
				UIManager.setLookAndFeel(new SubstanceGraphiteLookAndFeel());
			}
			catch (UnsupportedLookAndFeelException ex)
			{
				log.warn("unable to set look and feel", ex);
			}

			gui = new ClientUI(this);
			setTitle(null);

			setupTrayIcon();
		});

		configManager.load();

		eventBus.register(overlayRenderer);
		eventBus.register(menuManager);
		eventBus.register(chatMessageManager);

		// Setup the notifier
		notifier = new Notifier(trayIcon);

		// Load the plugins, but does not start them yet.
		// This will initialize configuration
		pluginManager.loadCorePlugins();

		// Plugins have provided their config, so set default config
		// to main settings
		configManager.loadDefault();

		// Start plugins
		pluginManager.startCorePlugins();

		// Load the session, including saved configuration
		loadSession();

		// Begin watching for new plugins
		pluginManager.watch();
	}

	public void setTitle(String extra)
	{
		if (!Strings.isNullOrEmpty(extra))
		{
			gui.setTitle(APP_NAME + " " + properties.getVersion() + " " + extra);
		}
		else
		{
			gui.setTitle(APP_NAME + " " + properties.getVersion());
		}
	}

	private void setupTrayIcon()
	{
		if (!SystemTray.isSupported())
		{
			return;
		}

		SystemTray systemTray = SystemTray.getSystemTray();

		trayIcon = new TrayIcon(ICON, APP_NAME);
		trayIcon.setImageAutoSize(true);

		try
		{
			systemTray.add(trayIcon);
		}
		catch (AWTException ex)
		{
			log.debug("Unable to add system tray icon", ex);
			return;
		}

		// bring to front when tray icon is clicked
		trayIcon.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				gui.setVisible(true);
				gui.setState(Frame.NORMAL); // unminimize
			}
		});
	}

	private void loadSession()
	{
		if (!SESSION_FILE.exists())
		{
			log.info("No session file exists");
			return;
		}

		AccountSession session;

		try (FileInputStream in = new FileInputStream(SESSION_FILE))
		{
			session = new Gson().fromJson(new InputStreamReader(in), AccountSession.class);

			log.debug("Loaded session for {}", session.getUsername());
		}
		catch (Exception ex)
		{
			log.warn("Unable to load session file", ex);
			return;
		}

		// Check if session is still valid
		AccountClient accountClient = new AccountClient(session.getUuid());
		if (!accountClient.sesssionCheck())
		{
			log.debug("Loaded session {} is invalid", session.getUuid());
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

			log.debug("Saved session to {}", SESSION_FILE);
		}
		catch (IOException ex)
		{
			log.warn("Unable to save session file", ex);
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

			wsclient = new WSClient(eventBus, executor, session);
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

		log.debug("Logging out of account {}", accountSession.getUsername());

		accountSession = null; // No more account

		// Restore config
		configManager.switchSession(null);

		eventBus.post(new SessionClose());
	}

	public Client getClient()
	{
		return client;
	}

	public void setClient(Client client)
	{
		this.client = client;
	}

	public ClientUI getGui()
	{
		return gui;
	}

	public void setGui(ClientUI gui)
	{
		this.gui = gui;
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
		notifier.sendNotification(APP_NAME, message, type, null);
		Toolkit.getDefaultToolkit().beep();
	}

	public AccountSession getAccountSession()
	{
		return accountSession;
	}

	public <T> T[] runQuery(Query query)
	{
		return (T[]) query.result(client);
	}
}
