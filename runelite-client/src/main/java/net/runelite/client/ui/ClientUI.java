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
package net.runelite.client.ui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.ui.FlatNativeWindowBorder;
import com.formdev.flatlaf.util.SystemInfo;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.applet.Applet;
import java.awt.AWTException;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.LayoutManager2;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.SystemTray;
import java.awt.Taskbar;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.desktop.QuitStrategy;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRootPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.ToolTipManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.HyperlinkEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.ExpandResizeType;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.config.WarningOnExit;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ClientShutdown;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.MouseAdapter;
import net.runelite.client.input.MouseListener;
import net.runelite.client.input.MouseManager;
import net.runelite.client.ui.laf.RuneLiteLAF;
import net.runelite.client.ui.laf.RuneLiteRootPaneUI;
import net.runelite.client.util.HotkeyListener;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.OSType;
import net.runelite.client.util.OSXUtil;
import net.runelite.client.util.SwingUtil;
import net.runelite.client.util.WinUtil;

@Slf4j
@Singleton
public class ClientUI
{
	private static final String CONFIG_GROUP = "runelite";
	private static final String CONFIG_CLIENT_BOUNDS = "clientBounds";
	private static final String CONFIG_CLIENT_MAXIMIZED = "clientMaximized";
	private static final String CONFIG_CLIENT_SIDEBAR_CLOSED = "clientSidebarClosed";
	public static final BufferedImage ICON_128 = ImageUtil.loadImageResource(ClientUI.class, "runelite_128.png");
	public static final BufferedImage ICON_16 = ImageUtil.loadImageResource(ClientUI.class, "runelite_16.png");

	@Getter
	private TrayIcon trayIcon;

	private final RuneLiteConfig config;
	private final MouseManager mouseManager;
	private final Applet client;
	private final ConfigManager configManager;
	private final Provider<ClientThread> clientThreadProvider;
	private final EventBus eventBus;
	private final boolean safeMode;
	private final String title;

	private final Rectangle sidebarButtonPosition = new Rectangle();
	private BufferedImage sidebarOpenIcon;
	private BufferedImage sidebarCloseIcon;

	private JTabbedPane sidebar;
	private final TreeSet<NavigationButton> sidebarEntries = new TreeSet<>(NavigationButton.COMPARATOR);
	private final Deque<HistoryEntry> selectedTabHistory = new ArrayDeque<>();
	private NavigationButton selectedTab;

	private ClientToolbarPanel toolbarPanel;
	private boolean withTitleBar;

	private ContainableFrame frame;
	private JPanel content;
	private ClientPanel clientPanel;
	private JButton sidebarNavBtn;
	private Dimension lastClientSize;
	private Cursor defaultCursor;

	private String lastNormalBounds;
	private final Timer normalBoundsTimer;

	@Inject(optional = true)
	@Named("minMemoryLimit")
	private int minMemoryLimit = 400;

	@Inject(optional = true)
	@Named("recommendedMemoryLimit")
	private int recommendedMemoryLimit = 512;

	private List<KeyListener> keyListeners;

	@RequiredArgsConstructor
	private static class HistoryEntry
	{
		private final boolean sidebarOpen;
		private final NavigationButton navBtn;
	}

	@Inject
	private ClientUI(
		RuneLiteConfig config,
		MouseManager mouseManager,
		@Nullable Applet client,
		ConfigManager configManager,
		Provider<ClientThread> clientThreadProvider,
		EventBus eventBus,
		@Named("safeMode") boolean safeMode,
		@Named("runelite.title") String title
	)
	{
		this.config = config;
		this.mouseManager = mouseManager;
		this.client = client;
		this.configManager = configManager;
		this.clientThreadProvider = clientThreadProvider;
		this.eventBus = eventBus;
		this.safeMode = safeMode;
		this.title = title + (safeMode ? " (safe mode)" : "");

		normalBoundsTimer = new Timer(250, _ev -> setLastNormalBounds());
		normalBoundsTimer.setRepeats(false);
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(CONFIG_GROUP) ||
			event.getKey().equals(CONFIG_CLIENT_MAXIMIZED) ||
			event.getKey().equals(CONFIG_CLIENT_BOUNDS))
		{
			return;
		}

		SwingUtilities.invokeLater(() -> updateFrameConfig(event.getKey().equals("lockWindowSize")));
	}

	void addNavigation(NavigationButton navBtn)
	{
		if (navBtn.getPanel() == null)
		{
			toolbarPanel.add(navBtn, true);
			return;
		}

		if (!sidebarEntries.add(navBtn))
		{
			return;
		}

		final int TAB_SIZE = 16;
		Icon icon = new ImageIcon(ImageUtil.resizeImage(navBtn.getIcon(), TAB_SIZE, TAB_SIZE));

		sidebar.insertTab(null, icon, navBtn.getPanel().getWrappedPanel(), navBtn.getTooltip(),
			sidebarEntries.headSet(navBtn).size());
		// insertTab changes the selected index when the first tab is inserted, avoid this
		if (sidebar.getTabCount() == 1)
		{
			sidebar.setSelectedIndex(-1);
		}
	}

	void removeNavigation(NavigationButton navBtn)
	{
		if (navBtn.getPanel() == null)
		{
			toolbarPanel.remove(navBtn);
		}
		else
		{
			boolean closingOpenTab = !selectedTabHistory.isEmpty() && selectedTabHistory.getLast().navBtn == navBtn;
			selectedTabHistory.removeIf(it -> it.navBtn == navBtn);
			sidebar.remove(navBtn.getPanel().getWrappedPanel());
			if (closingOpenTab)
			{
				HistoryEntry entry = selectedTabHistory.isEmpty()
					? new HistoryEntry(true, null)
					: selectedTabHistory.removeLast();

				openPanel(entry.navBtn, entry.sidebarOpen);
			}
		}

		sidebarEntries.remove(navBtn);
	}

	@Subscribe
	private void onGameStateChanged(final GameStateChanged event)
	{
		if (event.getGameState() != GameState.LOGGED_IN || !(client instanceof Client) || !config.usernameInTitle())
		{
			return;
		}

		final Client client = (Client) this.client;
		final ClientThread clientThread = clientThreadProvider.get();

		// Keep scheduling event until we get our name
		clientThread.invokeLater(() ->
		{
			if (client.getGameState() != GameState.LOGGED_IN)
			{
				return true;
			}

			final Player player = client.getLocalPlayer();

			if (player == null)
			{
				return false;
			}

			final String name = player.getName();

			if (Strings.isNullOrEmpty(name))
			{
				return false;
			}

			frame.setTitle(title + " - " + name);
			return true;
		});
	}

	/**
	 * Initialize UI.
	 */
	public void init() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			// Set some sensible swing defaults
			setupDefaults();

			RuneLiteLAF.setup();

			// Create main window
			frame = new ContainableFrame();

			// Try to enable fullscreen on OSX
			OSXUtil.tryEnableFullscreen(frame);

			frame.setTitle(title);
			frame.setIconImages(Arrays.asList(ICON_128, ICON_16));
			frame.setLocationRelativeTo(frame.getOwner());
			frame.setResizable(true);

			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			if (OSType.getOSType() == OSType.MacOS)
			{
				// Change the default quit strategy to CLOSE_ALL_WINDOWS so that ctrl+q
				// triggers the listener below instead of exiting.
				Desktop.getDesktop()
					.setQuitStrategy(QuitStrategy.CLOSE_ALL_WINDOWS);
			}
			frame.addWindowListener(new WindowAdapter()
			{
				@Override
				public void windowClosing(WindowEvent event)
				{
					int result = JOptionPane.OK_OPTION;

					if (showWarningOnExit())
					{
						try
						{
							result = JOptionPane.showConfirmDialog(
								frame,
								"Are you sure you want to exit?", "Exit",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE);
						}
						catch (Exception e)
						{
							log.warn("Unexpected exception occurred while check for confirm required", e);
						}
					}

					if (result == JOptionPane.OK_OPTION)
					{
						shutdownClient();
					}
				}
			});
			frame.addComponentListener(new ComponentAdapter()
			{
				@Override
				public void componentResized(ComponentEvent e)
				{
					windowBoundsChanged();
				}

				@Override
				public void componentMoved(ComponentEvent e)
				{
					windowBoundsChanged();
				}
			});

			content = new JPanel();
			content.setLayout(new Layout());

			clientPanel = new ClientPanel(client);
			content.add(clientPanel);

			sidebar = new JTabbedPane(JTabbedPane.RIGHT);
			sidebar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
			sidebar.setOpaque(true);
			sidebar.putClientProperty(FlatClientProperties.STYLE, "tabInsets: 2,5,2,5; variableSize: true; deselectable: true; tabHeight: 26");
			sidebar.setSelectedIndex(-1);
			sidebar.addChangeListener(ev ->
			{
				NavigationButton oldSelectedTab = selectedTab;
				NavigationButton newSelectedTab;

				int index = sidebar.getSelectedIndex();
				if (index < 0)
				{
					newSelectedTab = null;
				}
				else
				{
					// maybe just include a map component -> navbtn?
					newSelectedTab = Iterables.get(sidebarEntries, index);
				}

				if (oldSelectedTab == newSelectedTab)
				{
					return;
				}

				selectedTab = newSelectedTab;

				if (sidebar.isVisible())
				{
					pushHistory();

					if (oldSelectedTab != null)
					{
						SwingUtil.deactivate(oldSelectedTab.getPanel());
					}
					if (newSelectedTab != null)
					{
						SwingUtil.activate(newSelectedTab.getPanel());
					}

					if (newSelectedTab == null)
					{
						giveClientFocus();
					}
				}
			});
			sidebar.addMouseListener(new java.awt.event.MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					if (e.getButton() == MouseEvent.BUTTON3)
					{
						int index = 0;
						for (var navBtn : sidebarEntries)
						{
							Rectangle bounds = sidebar.getBoundsAt(index++);
							if (bounds != null && bounds.contains(e.getX(), e.getY()))
							{
								if (navBtn.getPopup() != null)
								{
									var menu = new JPopupMenu();
									navBtn.getPopup().forEach((name, cb) ->
									{
										var menuItem = new JMenuItem(name);
										menuItem.addActionListener(ev -> cb.run());
										menu.add(menuItem);
									});
									menu.show(sidebar, e.getX(), e.getY());
								}
								return;
							}
						}
					}
				}
			});

			content.add(sidebar);

			frame.setContentPane(content);

			// Add key listener
			keyListeners = List.of(
				new HotkeyListener(config::sidebarToggleKey)
				{
					@Override
					public void hotkeyPressed()
					{
						toggleSidebar();
					}
				},
				new HotkeyListener(config::panelToggleKey)
				{
					@Override
					public void hotkeyPressed()
					{
						togglePluginPanel();
					}
				});
			KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this::dispatchWindowKeyEvent);

			// Add mouse listener
			final MouseListener mouseListener = new MouseAdapter()
			{
				@Override
				public MouseEvent mousePressed(MouseEvent mouseEvent)
				{
					if (SwingUtilities.isLeftMouseButton(mouseEvent) && sidebarButtonPosition.contains(mouseEvent.getPoint()))
					{
						SwingUtilities.invokeLater(ClientUI.this::toggleSidebar);
						mouseEvent.consume();
					}

					return mouseEvent;
				}
			};
			mouseManager.registerMouseListener(mouseListener);

			// Decorate window with custom chrome and titlebar if needed
			withTitleBar = config.enableCustomChrome();
			toolbarPanel = new ClientToolbarPanel(!withTitleBar);

			sidebarOpenIcon = ImageUtil.loadImageResource(ClientUI.class, withTitleBar ? "open.png" : "open_rs.png");
			sidebarCloseIcon = ImageUtil.flipImage(sidebarOpenIcon, true, false);

			if (withTitleBar)
			{
				JMenuBar menuBar = new JMenuBar();
				menuBar.add(Box.createGlue());
				menuBar.add(toolbarPanel);
				frame.setJMenuBar(menuBar);

				JRootPane rp = frame.getRootPane();
				if (FlatNativeWindowBorder.isSupported())
				{
					rp.putClientProperty(FlatClientProperties.USE_WINDOW_DECORATIONS, true);
				}
				else if (OSType.getOSType() == OSType.MacOS && SystemInfo.isMacFullWindowContentSupported)
				{
					rp.putClientProperty("apple.awt.fullWindowContent", true);
					rp.putClientProperty("apple.awt.transparentTitleBar", true);

					// use our own title if supported.
					// the native title color is determined by the application appearance,
					// which will lead to grey text on a black background if the appearance
					// is light mode.
					if (Runtime.version().feature() >= 17)
					{
						rp.putClientProperty("apple.awt.windowTitleVisible", false);
						rp.putClientProperty(RuneLiteRootPaneUI.PROP_RUNELITE_TITLEBAR, true); // enable titlebar before adjusting visibility props
						rp.putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_CLOSE, false);
						rp.putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE, false);
						rp.putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY, false);
						rp.putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICON, false);
					}

					menuBar.setBorder(new EmptyBorder(3, 70, 3, 10));
				}
				else
				{
					if (OSType.getOSType() == OSType.Linux)
					{
						// FlatLaf explicitly checks this property when checking for custom window decorations on Linux
						JDialog.setDefaultLookAndFeelDecorated(true);
						JFrame.setDefaultLookAndFeelDecorated(true);
					}

					frame.setUndecorated(true);
					rp.setWindowDecorationStyle(JRootPane.FRAME);
				}

				frame.addWindowStateListener(_ev -> applyCustomChromeBorder());
				applyCustomChromeBorder();

				sidebarNavBtn = toolbarPanel.add(NavigationButton
					.builder()
					.priority(100)
					.icon(sidebarCloseIcon)
					.tooltip("Close sidebar")
					.onClick(this::toggleSidebar)
					.build(), false);
			}
			else
			{
				sidebar.putClientProperty(
					FlatClientProperties.TABBED_PANE_TRAILING_COMPONENT,
					toolbarPanel.createSidebarPanel());
			}

			// Update config
			updateFrameConfig(false);

			// Close sidebar if the config closed state is set
			if (configManager.getConfiguration(CONFIG_GROUP, CONFIG_CLIENT_SIDEBAR_CLOSED, Boolean.class) == Boolean.TRUE)
			{
				toggleSidebar(false, true);
			}
		});
	}

	private void applyCustomChromeBorder()
	{
		content.setBorder((frame.getExtendedState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH
			? null
			: new MatteBorder(4, 4, 4, 4, ColorScheme.DARKER_GRAY_COLOR));
	}

	public void show()
	{
		logGraphicsEnvironment();

		SwingUtilities.invokeLater(() ->
		{
			// Layout frame
			frame.pack();

			// Create tray icon (needs to be created after frame is packed)
			if (config.enableTrayIcon())
			{
				trayIcon = createTrayIcon(ICON_16, title, frame);
			}

			// Move frame around (needs to be done after frame is packed)
			boolean appliedSize = false;
			if (config.rememberScreenBounds() && !safeMode)
			{
				appliedSize = restoreClientBoundsConfig();
				if (appliedSize)
				{
					// Adjust for insets before performing display test
					Insets insets = frame.getInsets();
					Rectangle clientBounds = frame.getBounds();

					clientBounds = new Rectangle(
						clientBounds.x + insets.left,
						clientBounds.y + insets.top,
						clientBounds.width - (insets.left + insets.right),
						clientBounds.height - (insets.top + insets.bottom)
					);

					// Check that the bounds are contained inside a valid display
					GraphicsConfiguration gc = findDisplayFromBounds(clientBounds);
					if (gc == null)
					{
						log.info("Reset client position. Client bounds: {}x{}x{}x{}",
							clientBounds.x, clientBounds.y, clientBounds.width, clientBounds.height);
						// Reset the position, but not the size
						frame.setLocationRelativeTo(frame.getOwner());
					}
				}

				if (configManager.getConfiguration(CONFIG_GROUP, CONFIG_CLIENT_MAXIMIZED) != null)
				{
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					// According to the documentation of JFrame#setExtendedState, if the frame isn't visible, a window
					// state change event isn't guaranteed to be fired. Since RuneLite's custom chrome borders rely on a
					// state change listener, borders need to be applied manually when maximizing prior to setVisible
					applyCustomChromeBorder();
				}
			}

			if (!appliedSize)
			{
				applyGameSize(true);
				frame.setLocationRelativeTo(frame.getOwner());
			}

			// Show frame
			frame.setVisible(true);
			// On macos setResizable needs to be called after setVisible
			frame.setResizable(!config.lockWindowSize());
			frame.toFront();
			requestFocus();
			log.debug("Showing frame {}", frame);
			frame.revalidateMinimumSize();
			// this must run after the native window border is installed on the window
			frame.updateContainsInScreen();
		});

		// Show out of date dialog if needed
		if (client != null && !(client instanceof Client))
		{
			if (!Strings.isNullOrEmpty(RuneLiteProperties.getLauncherVersion()))
			{
				SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(frame,
					"RuneLite has not yet been updated to work with the latest\n"
						+ "game update, it will work with reduced functionality until then.",
					"RuneLite is outdated", INFORMATION_MESSAGE));
			}
			else
			{
				SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(frame,
					"RuneLite is outdated and is not compatible with the latest game update.\n"
						+ "If you are doing pluginhub development, update the runeliteVersion property in build.gradle."
						+ " Otherwise, git pull and rebuild.",
					"RuneLite is outdated", ERROR_MESSAGE));
			}
		}

		final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024L / 1024L);
		if (maxMemory < minMemoryLimit)
		{
			SwingUtilities.invokeLater(() ->
			{
				JEditorPane ep = new JEditorPane("text/html",
					"Your Java memory limit is " + maxMemory + "mb, which is lower than the recommended " + recommendedMemoryLimit + "mb.<br>" +
						"This can cause instability, and it is recommended you remove or increase this limit.<br>" +
						"Join <a href=\"" + RuneLiteProperties.getDiscordInvite() + "\">Discord</a> for assistance."
				);
				ep.addHyperlinkListener(e ->
				{
					if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED))
					{
						LinkBrowser.browse(e.getURL().toString());
					}
				});
				ep.setEditable(false);
				ep.setOpaque(false);
				JOptionPane.showMessageDialog(frame,
					ep, "Max memory limit low", JOptionPane.WARNING_MESSAGE);
			});
		}
	}

	private boolean dispatchWindowKeyEvent(KeyEvent ev)
	{
		if (!frame.isFocused())
		{
			return false;
		}

		for (var listener : keyListeners)
		{
			switch (ev.getID())
			{
				case KeyEvent.KEY_TYPED:
					listener.keyTyped(ev);
					break;
				case KeyEvent.KEY_PRESSED:
					listener.keyPressed(ev);
					break;
				case KeyEvent.KEY_RELEASED:
					listener.keyReleased(ev);
					break;
			}

			if (ev.isConsumed())
			{
				return true;
			}
		}

		return false;
	}

	private void logGraphicsEnvironment()
	{
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		for (GraphicsDevice graphicsDevice : graphicsEnvironment.getScreenDevices())
		{
			GraphicsConfiguration configuration = graphicsDevice.getDefaultConfiguration();
			log.debug("Graphics device {}: bounds {} transform: {}", graphicsDevice, configuration.getBounds(), configuration.getDefaultTransform());
		}
	}

	private GraphicsConfiguration findDisplayFromBounds(final Rectangle bounds)
	{
		GraphicsDevice[] gds = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();

		for (GraphicsDevice gd : gds)
		{
			GraphicsConfiguration gc = gd.getDefaultConfiguration();

			final Rectangle displayBounds = gc.getBounds();
			if (displayBounds.contains(bounds))
			{
				return gc;
			}
		}

		return null;
	}

	private boolean showWarningOnExit()
	{
		if (config.warningOnExit() == WarningOnExit.ALWAYS)
		{
			return true;
		}

		if (config.warningOnExit() == WarningOnExit.LOGGED_IN && client instanceof Client)
		{
			return ((Client) client).getGameState() != GameState.LOGIN_SCREEN;
		}

		return false;
	}

	private void shutdownClient()
	{
		saveClientBoundsConfig();
		ClientShutdown csev = new ClientShutdown();
		eventBus.post(csev);
		new Thread(() ->
		{
			csev.waitForAllConsumers(Duration.ofSeconds(10));

			if (client != null)
			{
				// The client can call System.exit when it's done shutting down
				// if it doesn't though, we want to exit anyway, so race it
				int clientShutdownWaitMS;
				if (client instanceof Client)
				{
					((Client) client).stopNow();
					clientShutdownWaitMS = 1000;
				}
				else
				{
					// it will continue rendering for about 4 seconds before attempting shutdown if its vanilla
					client.stop();
					frame.setVisible(false);
					clientShutdownWaitMS = 6000;
				}

				try
				{
					Thread.sleep(clientShutdownWaitMS);
				}
				catch (InterruptedException ignored)
				{
				}
			}
			System.exit(0);
		}, "RuneLite Shutdown").start();
	}

	/**
	 * Paint this component to target graphics
	 *
	 * @param graphics the graphics
	 */
	public void paint(final Graphics graphics)
	{
		assert SwingUtilities.isEventDispatchThread() : "paint must be called on EDT";
		frame.paint(graphics);
	}

	/**
	 * Gets component width.
	 *
	 * @return the width
	 */
	public int getWidth()
	{
		return frame.getWidth();
	}

	/**
	 * Gets component height.
	 *
	 * @return the height
	 */
	public int getHeight()
	{
		return frame.getHeight();
	}

	/**
	 * Returns true if this component has focus.
	 *
	 * @return true if component has focus
	 */
	public boolean isFocused()
	{
		return frame.isFocused();
	}

	/**
	 * Request focus on this component and then on client component
	 */
	public void requestFocus()
	{
		switch (OSType.getOSType())
		{
			case MacOS:
				// On OSX Component::requestFocus has no visible effect, so we use our OSX-specific
				// requestUserAttention()
				OSXUtil.requestUserAttention();
				break;
			default:
				frame.requestFocus();
		}

		giveClientFocus();
	}

	/**
	 * Attempt to forcibly bring the client frame to front
	 */
	public void forceFocus()
	{
		switch (OSType.getOSType())
		{
			case MacOS:
				OSXUtil.requestForeground();
				break;
			case Windows:
				WinUtil.requestForeground(frame);
				break;
			default:
				frame.requestFocus();
				break;
		}

		giveClientFocus();
	}

	/**
	 * Request user attention to the window (flash the taskbar)
	 */
	public void flashTaskbar()
	{
		Taskbar.getTaskbar().requestWindowUserAttention(frame);
	}

	/**
	 * Returns current cursor set on game container
	 * @return awt cursor
	 */
	public Cursor getCurrentCursor()
	{
		return content.getCursor();
	}

	/**
	 * Returns current custom cursor or default system cursor if cursor is not set
	 * @return awt cursor
	 */
	public Cursor getDefaultCursor()
	{
		return defaultCursor != null ? defaultCursor : Cursor.getDefaultCursor();
	}

	/**
	 * Changes cursor for client window. Requires ${@link ClientUI#init()} to be called first.
	 * FIXME: This is working properly only on Windows, Linux and Mac are displaying cursor incorrectly
	 * @param image cursor image
	 * @param name  cursor name
	 */
	public void setCursor(final BufferedImage image, final String name)
	{
		if (content == null)
		{
			return;
		}

		final Point hotspot = new Point(0, 0);
		final Cursor cursorAwt = Toolkit.getDefaultToolkit().createCustomCursor(image, hotspot, name);
		defaultCursor = cursorAwt;
		setCursor(cursorAwt);
	}

	/**
	 * Changes cursor for client window. Requires ${@link ClientUI#init()} to be called first.
	 * @param cursor awt cursor
	 */
	public void setCursor(final Cursor cursor)
	{
		content.setCursor(cursor);
	}

	/**
	 * Resets client window cursor to default one.
	 * @see ClientUI#setCursor(BufferedImage, String)
	 */
	public void resetCursor()
	{
		if (content == null)
		{
			return;
		}

		defaultCursor = null;
		content.setCursor(Cursor.getDefaultCursor());
	}

	/**
	 * Get offset of game canvas in game window
	 *
	 * @return game canvas offset
	 */
	public Point getCanvasOffset()
	{
		if (client instanceof Client)
		{
			final Canvas canvas = ((Client) client).getCanvas();
			if (canvas != null)
			{
				return SwingUtilities.convertPoint(canvas, 0, 0, frame);
			}
		}

		return new Point(0, 0);
	}

	public Insets getInsets()
	{
		return frame.getInsets();
	}

	/**
	 * Paint UI related overlays to target graphics
	 * @param graphics target graphics
	 */
	public void paintOverlays(final Graphics2D graphics)
	{
		if (!(client instanceof Client) || withTitleBar)
		{
			return;
		}

		final Client client = (Client) this.client;
		final int x = client.getRealDimensions().width - sidebarOpenIcon.getWidth() - 5;

		// Offset sidebar button if resizable mode logout is visible
		final Widget logoutButton = client.getWidget(ComponentID.RESIZABLE_VIEWPORT_BOTTOM_LINE_LOGOUT_BUTTON_OVERLAY);
		final int y = logoutButton != null && !logoutButton.isHidden() && logoutButton.getParent() != null
			? logoutButton.getHeight() + logoutButton.getRelativeY()
			: 5;

		final BufferedImage image = sidebar.isVisible() ? sidebarCloseIcon : sidebarOpenIcon;

		final Rectangle sidebarButtonRange = new Rectangle(x - 15, 0, image.getWidth() + 25, client.getRealDimensions().height);
		final Point mousePosition = new Point(
			client.getMouseCanvasPosition().getX() + client.getViewportXOffset(),
			client.getMouseCanvasPosition().getY() + client.getViewportYOffset());

		if (sidebarButtonRange.contains(mousePosition.getX(), mousePosition.getY()))
		{
			graphics.drawImage(image, x, y, null);
		}

		// Update button dimensions
		sidebarButtonPosition.setBounds(x, y, image.getWidth(), image.getHeight());
	}

	public GraphicsConfiguration getGraphicsConfiguration()
	{
		return frame.getGraphicsConfiguration();
	}

	void openPanel(NavigationButton navBtn, boolean showSidebar)
	{
		if (navBtn != null && !sidebarEntries.contains(navBtn))
		{
			return;
		}

		int index = navBtn == null ? -1 : sidebarEntries.headSet(navBtn).size();
		sidebar.setSelectedIndex(index);

		toggleSidebar(showSidebar, false);

		pushHistory();
	}

	private void toggleSidebar()
	{
		toggleSidebar(!sidebar.isVisible(), true);
	}

	private void toggleSidebar(boolean open, boolean pushHistory)
	{
		if (sidebar.isVisible() == open)
		{
			return;
		}

		if (open)
		{
			configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_CLIENT_SIDEBAR_CLOSED);
		}
		else
		{
			configManager.setConfiguration(CONFIG_GROUP, CONFIG_CLIENT_SIDEBAR_CLOSED, true);
		}

		sidebar.setVisible(open);
		content.revalidate();

		if (pushHistory)
		{
			pushHistory();
		}

		if (selectedTab != null)
		{
			if (open)
			{
				SwingUtil.activate(selectedTab.getPanel());
			}
			else
			{
				SwingUtil.deactivate(selectedTab.getPanel());
			}
		}

		if (!open)
		{
			giveClientFocus();
		}

		if (sidebarNavBtn != null)
		{
			sidebarNavBtn.setIcon(new ImageIcon(open ? sidebarCloseIcon : sidebarOpenIcon));
			sidebarNavBtn.setToolTipText(open ? "Close sidebar" : "Open sidebar");
		}
	}

	private void togglePluginPanel()
	{
		if (!sidebar.isVisible() || sidebar.getSelectedIndex() < 0)
		{
			toggleSidebar(true, false);

			NavigationButton open = null;
			while (!selectedTabHistory.isEmpty())
			{
				HistoryEntry historyEntry = selectedTabHistory.removeLast();
				if (historyEntry.navBtn != null)
				{
					open = historyEntry.navBtn;
					break;
				}
			}

			if (open == null)
			{
				open = sidebarEntries.first();
			}

			openPanel(open, true);
		}
		else
		{
			sidebar.setSelectedIndex(-1);
		}
	}

	private void pushHistory()
	{
		selectedTabHistory.addLast(new HistoryEntry(sidebar.isVisible(), selectedTab));

		// we keep multiple history entries so you can open a panel, close it, open another, *remove* it, then resume the first open panel
		if (selectedTabHistory.size() > 4)
		{
			HistoryEntry ent = selectedTabHistory.removeFirst();
			// Try to always keep a panel in the history
			if (ent.navBtn != null && selectedTabHistory.stream().noneMatch(it -> it.navBtn != null))
			{
				selectedTabHistory.removeFirst();
				selectedTabHistory.addFirst(ent);
			}
		}
	}

	private void giveClientFocus()
	{
		if (client instanceof Client)
		{
			final Canvas c = ((Client) client).getCanvas();
			if (c != null)
			{
				c.requestFocusInWindow();
			}
		}
		else if (client != null)
		{
			client.requestFocusInWindow();
		}
	}

	private void updateFrameConfig(boolean updateResizable)
	{
		if (frame == null)
		{
			return;
		}

		if (frame.getGraphicsConfiguration().getDevice().getFullScreenWindow() == null
			&& !safeMode)
		{
			frame.setOpacity(config.windowOpacity() / 100.0f);
		}

		if (config.usernameInTitle() && (client instanceof Client))
		{
			final Player player = ((Client) client).getLocalPlayer();

			if (player != null && player.getName() != null)
			{
				frame.setTitle(title + " - " + player.getName());
			}
		}
		else
		{
			frame.setTitle(title);
		}

		if (frame.isAlwaysOnTopSupported())
		{
			frame.setAlwaysOnTop(config.gameAlwaysOnTop());
		}

		if (updateResizable)
		{
			frame.setResizable(!config.lockWindowSize());
		}

		frame.setContainedInScreen(config.containInScreen());
		frame.updateContainsInScreen();

		if (!config.rememberScreenBounds())
		{
			configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_CLIENT_MAXIMIZED);
			configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_CLIENT_BOUNDS);
		}

		applyGameSize(false);
	}

	private void applyGameSize(boolean force)
	{
		if (client == null)
		{
			return;
		}

		// The upper bounds are defined by the applet's max size
		// The lower bounds are defined by the client's fixed size
		int width = Math.max(Math.min(config.gameSize().width, 7680), Constants.GAME_FIXED_WIDTH);
		int height = Math.max(Math.min(config.gameSize().height, 2160), Constants.GAME_FIXED_HEIGHT);
		final Dimension size = new Dimension(width, height);

		if (force || !size.equals(lastClientSize))
		{
			lastClientSize = size;
			((Layout) content.getLayout()).forceClientSize(width, height);
		}
	}

	private void windowBoundsChanged()
	{
		// Sometimes when maximizing windowMoved can be delivered before extendedState is updated, so defer
		// actually saving for some ms to reduce the likelyhood of this
		normalBoundsTimer.stop();
		if ((frame.getExtendedState() & JFrame.MAXIMIZED_BOTH) == 0)
		{
			normalBoundsTimer.start();
		}
	}

	private void setLastNormalBounds()
	{
		if ((frame.getExtendedState() & JFrame.MAXIMIZED_BOTH) == 0)
		{
			Insets insets = frame.getInsets();
			char mode;
			Dimension size;
			if (config.automaticResizeType() == ExpandResizeType.KEEP_GAME_SIZE)
			{
				mode = 'g';
				size = clientPanel.getSize();
			}
			else
			{
				mode = 'c';
				size = frame.getSize();
				size.width -= insets.left + insets.right;
				size.height -= insets.top + insets.bottom;
			}
			Point point = frame.getLocation();
			point.x += insets.left;
			point.y += insets.top;
			lastNormalBounds = point.x + ":" + point.y + ":" + size.width + ":" + size.height + ":" + mode;
		}
	}

	private void saveClientBoundsConfig()
	{
		if (lastNormalBounds != null)
		{
			configManager.setConfiguration(CONFIG_GROUP, CONFIG_CLIENT_BOUNDS, lastNormalBounds);
		}

		if ((frame.getExtendedState() & JFrame.MAXIMIZED_BOTH) != 0)
		{
			// leave the previous bounds there, so when the client starts maximized it
			// can restore to the restored size from the previous run
			configManager.setConfiguration(CONFIG_GROUP, CONFIG_CLIENT_MAXIMIZED, true);
		}
		else
		{
			configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_CLIENT_MAXIMIZED);
		}
	}

	private boolean restoreClientBoundsConfig()
	{
		String str = configManager.getConfiguration(CONFIG_GROUP, CONFIG_CLIENT_BOUNDS);
		if (str == null)
		{
			return false;
		}

		try
		{
			String[] splitStr = str.split(":");
			int x = Integer.parseInt(splitStr[0]);
			int y = Integer.parseInt(splitStr[1]);
			int width = Integer.parseInt(splitStr[2]);
			int height = Integer.parseInt(splitStr[3]);
			String mode = null;
			if (splitStr.length > 4)
			{
				mode = splitStr[4];
			}

			Insets insets = frame.getInsets();

			if (mode != null)
			{
				// null mode means legacy exact frame bounds
				x -= insets.left;
				y -= insets.top;
			}

			frame.setLocation(x, y);

			if ("g".equals(mode))
			{
				((Layout) content.getLayout()).forceClientSize(width, height);
			}
			else
			{
				frame.setSize(width + insets.left + insets.right, height + insets.top + insets.bottom);
			}

			return true;
		}
		catch (RuntimeException ignored)
		{
			return false;
		}
	}

	private static void setupDefaults()
	{
		// Force heavy-weight popups/tooltips.
		// Prevents them from being obscured by the game applet.
		var tooltipManager = ToolTipManager.sharedInstance();
		tooltipManager.setLightWeightPopupEnabled(false);
		tooltipManager.setInitialDelay(300);
		tooltipManager.setDismissDelay(10_000);
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);

		// Do not fill in background on repaint. Reduces flickering when
		// the applet is resized.
		System.setProperty("sun.awt.noerasebackground", "true");
	}

	@Nullable
	private static TrayIcon createTrayIcon(@Nonnull final Image icon, @Nonnull final String title, @Nonnull final Frame frame)
	{
		if (!SystemTray.isSupported())
		{
			return null;
		}

		final SystemTray systemTray = SystemTray.getSystemTray();
		final TrayIcon trayIcon = new TrayIcon(icon, title);
		trayIcon.setImageAutoSize(true);

		try
		{
			systemTray.add(trayIcon);
		}
		catch (AWTException ex)
		{
			log.debug("Unable to add system tray icon", ex);
			return trayIcon;
		}

		// Bring to front when tray icon is clicked
		trayIcon.addMouseListener(new java.awt.event.MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (OSType.getOSType() == OSType.MacOS && !frame.isFocused())
				{
					// On macOS, frame.setVisible(true) only restores focus when the visibility was previously false.
					// The frame's visibility is not set to false when the window loses focus, so we set it manually.
					// Additionally, in order to bring the window to the foreground,
					// frame.setVisible(true) calls CPlatformWindow::nativePushNSWindowToFront.
					// However, this native method is not called with activateIgnoringOtherApps:YES,
					// so any other active window will prevent our window from being brought to the front.
					// To work around this, we use our macOS-specific requestForeground().
					frame.setVisible(false);
					OSXUtil.requestForeground();
				}
				frame.setVisible(true);
				frame.setState(Frame.NORMAL); // Restore
			}
		});

		return trayIcon;
	}

	private class Layout implements LayoutManager2
	{
		private int prevState;
		private int previousContentWidth;
		private boolean doingLayout;

		@Override
		public void addLayoutComponent(String name, Component comp)
		{
		}

		@Override
		public void removeLayoutComponent(Component comp)
		{
		}

		@Override
		public void addLayoutComponent(Component comp, Object constraints)
		{
		}

		@Override
		public Dimension preferredLayoutSize(Container content)
		{
			synchronized (content.getTreeLock())
			{
				return size(content, Component::getPreferredSize);
			}
		}

		@Override
		public Dimension minimumLayoutSize(Container content)
		{
			synchronized (content.getTreeLock())
			{
				return size(content, c ->
				{
					if (c == content.getComponent(1))
					{
						// the sidebar always is given it's pref width exactly
						return new Dimension(c.getPreferredSize().width, c.getMinimumSize().height);
					}

					return c.getMinimumSize();
				});
			}
		}

		void forceClientSize(int width, int height)
		{
			Component client = content.getComponent(0);
			client.setSize(width, height);
			// must adjust content height since the client height is derived from the content height
			Insets insets = content.getInsets();
			content.setSize(content.getWidth(), height + insets.top + insets.bottom);
			layout(content, true);
		}

		@Override
		public void layoutContainer(Container content)
		{
			layout(content, false);
		}

		private void layout(Container content, boolean forceSizingClient)
		{
			int changed = prevState ^ frame.getExtendedState();
			prevState = frame.getExtendedState();

			Insets insets = content.getInsets();
			int insetWidth = insets.left + insets.right;
			int insetHeight = insets.top + insets.bottom;

			Component client = content.getComponent(0);
			Component sidebar = content.getComponent(1);

			log.trace("starting layout  - content={} client={} sidebar={} frame={} prevContent={}", content.getWidth(), client.getWidth(), sidebar.getWidth(), frame.getWidth(), previousContentWidth);

			// adjust sidebar height first, as changing it's height can make it's min width change too
			int innerHeight = Math.max(content.getHeight() - insetHeight, Math.max(
				client.getMinimumSize().height,
				sidebar.getMinimumSize().height));
			{
				sidebar.setSize(sidebar.getWidth(), innerHeight);
			}

			Dimension minimumSize = minimumLayoutSize(content);

			int contentWidth = Math.max(minimumSize.width, content.getWidth()) - insetWidth;
			if (previousContentWidth <= 0)
			{
				previousContentWidth = contentWidth;
			}

			final int clientMinWidth = client.getMinimumSize().width;
			int clientWidth = Math.max(client.getWidth(), clientMinWidth);
			int sidebarWidth = sidebar.isVisible()
				? sidebar.getPreferredSize().width
				: 0;

			boolean keepGameSize = (frame.getExtendedState() & Frame.MAXIMIZED_HORIZ) == 0
				&& (config.automaticResizeType() == ExpandResizeType.KEEP_GAME_SIZE || forceSizingClient);

			if (keepGameSize)
			{
				// adjust client for window resizes
				clientWidth = Math.max(clientMinWidth, clientWidth + content.getWidth() - insetWidth - previousContentWidth);
			}
			else
			{
				// fit client to window
				clientWidth = Math.max(clientMinWidth, contentWidth - sidebarWidth);
			}

			// fit window to client
			int width = clientWidth + sidebarWidth;

			content.setSize(width + insetWidth, innerHeight + insetHeight);
			content.setPreferredSize(content.getSize());
			previousContentWidth = width;

			client.setBounds(insets.left, insets.top, clientWidth, innerHeight);
			sidebar.setBounds(insets.left + clientWidth, insets.top, sidebarWidth, innerHeight);

			Rectangle oldBounds = frame.getBounds();
			frame.revalidateMinimumSize();
			if ((OSType.getOSType() != OSType.Windows || (changed & Frame.MAXIMIZED_BOTH) == 0)
				&& !frame.getPreferredSize().equals(oldBounds.getSize()))
			{
				frame.containedSetSize(frame.getPreferredSize(), oldBounds);
				if (!doingLayout)
				{
					try
					{
						// synchronously layout the frame and it's root pane so we don't get re-layouted
						// with the root pane's old size before it gets layouted automatically. This can
						// call us recursively if we calculate size wrong, so don't do that.
						doingLayout = true;
						frame.validate();
					}
					finally
					{
						doingLayout = false;
					}
				}
			}

			log.trace("finishing layout - content={} client={} sidebar={} frame={}", content.getWidth(), client.getWidth(), sidebar.getWidth(), frame.getWidth());
		}

		private Dimension size(Container content, Function<Component, Dimension> sizer)
		{
			Dimension out = new Dimension(0, 0);
			for (int i = 0; i < content.getComponentCount(); i++)
			{
				Component child = content.getComponent(i);
				if (child.isVisible())
				{
					Dimension dim = sizer.apply(child);
					out.width += dim.width;
					out.height = Math.max(out.height, dim.height);
				}
			}

			Insets is = content.getInsets();
			out.width += is.left + is.right;
			out.height += is.top + is.bottom;

			return out;
		}

		@Override
		public Dimension maximumLayoutSize(Container content)
		{
			return size(content, Component::getMaximumSize);
		}

		@Override
		public float getLayoutAlignmentX(Container target)
		{
			return 0;
		}

		@Override
		public float getLayoutAlignmentY(Container target)
		{
			return 0;
		}

		@Override
		public void invalidateLayout(Container target)
		{
		}
	}
}
