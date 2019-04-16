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

import com.google.common.base.Strings;
import java.applet.Applet;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.client.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.RuneLite;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.ExpandResizeType;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.config.WarningOnExit;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.NavigationButtonAdded;
import net.runelite.client.events.NavigationButtonRemoved;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseAdapter;
import net.runelite.client.input.MouseListener;
import net.runelite.client.input.MouseManager;
import net.runelite.client.ui.skin.SubstanceRuneLiteLookAndFeel;
import net.runelite.client.util.HotkeyListener;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.OSType;
import net.runelite.client.util.OSXUtil;
import net.runelite.client.util.SwingUtil;
import org.pushingpixels.substance.internal.SubstanceSynapse;
import org.pushingpixels.substance.internal.utils.SubstanceCoreUtilities;
import org.pushingpixels.substance.internal.utils.SubstanceTitlePaneUtilities;

/**
 * Client UI.
 */
@Slf4j
@Singleton
public class ClientUI
{
	private static final String CONFIG_GROUP = "runelite";
	private static final String CONFIG_CLIENT_BOUNDS = "clientBounds";
	private static final String CONFIG_CLIENT_MAXIMIZED = "clientMaximized";
	private static final int CLIENT_WELL_HIDDEN_MARGIN = 160;
	private static final int CLIENT_WELL_HIDDEN_MARGIN_TOP = 10;
	public static final BufferedImage ICON = ImageUtil.getResourceStreamFromClass(ClientUI.class, "/runelite.png");

	@Getter
	private TrayIcon trayIcon;

	private final RuneLiteConfig config;
	private final KeyManager keyManager;
	private final MouseManager mouseManager;
	private final Applet client;
	private final ConfigManager configManager;
	private final Provider<ClientThread> clientThreadProvider;
	private final CardLayout cardLayout = new CardLayout();
	private final Rectangle sidebarButtonPosition = new Rectangle();
	private boolean withTitleBar;
	private BufferedImage sidebarOpenIcon;
	private BufferedImage sidebarClosedIcon;
	private ContainableFrame frame;
	private JPanel navContainer;
	private PluginPanel pluginPanel;
	private ClientPluginToolbar pluginToolbar;
	private ClientTitleToolbar titleToolbar;
	private JButton currentButton;
	private NavigationButton currentNavButton;
	private boolean sidebarOpen;
	private JPanel container;
	private NavigationButton sidebarNavigationButton;
	private JButton sidebarNavigationJButton;
	private Dimension lastClientSize;

	@Inject
	private ClientUI(
		RuneLiteConfig config,
		KeyManager keyManager,
		MouseManager mouseManager,
		@Nullable Applet client,
		ConfigManager configManager,
		Provider<ClientThread> clientThreadProvider)
	{
		this.config = config;
		this.keyManager = keyManager;
		this.mouseManager = mouseManager;
		this.client = client;
		this.configManager = configManager;
		this.clientThreadProvider = clientThreadProvider;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("runelite") ||
			event.getKey().equals(CONFIG_CLIENT_MAXIMIZED) ||
			event.getKey().equals(CONFIG_CLIENT_BOUNDS))
		{
			return;
		}

		SwingUtilities.invokeLater(() -> updateFrameConfig(event.getKey().equals("lockWindowSize")));
	}

	@Subscribe
	public void onNavigationButtonAdded(final NavigationButtonAdded event)
	{
		SwingUtilities.invokeLater(() ->
		{
			final NavigationButton navigationButton = event.getButton();
			final PluginPanel pluginPanel = navigationButton.getPanel();
			final boolean inTitle = !event.getButton().isTab() && withTitleBar;
			final int iconSize = 16;

			if (pluginPanel != null)
			{
				navContainer.add(pluginPanel.getWrappedPanel(), navigationButton.getTooltip());
			}

			final JButton button = SwingUtil.createSwingButton(navigationButton, iconSize, (navButton, jButton) ->
			{
				final PluginPanel panel = navButton.getPanel();

				if (panel == null)
				{
					return;
				}

				boolean doClose = currentButton != null && currentButton == jButton && currentButton.isSelected();

				if (doClose)
				{
					contract();
					currentButton.setSelected(false);
					currentNavButton.setSelected(false);
					currentButton = null;
					currentNavButton = null;
				}
				else
				{
					if (currentButton != null)
					{
						currentButton.setSelected(false);
					}

					if (currentNavButton != null)
					{
						currentNavButton.setSelected(false);
					}

					currentButton = jButton;
					currentNavButton = navButton;
					currentButton.setSelected(true);
					currentNavButton.setSelected(true);
					expand(navButton);
				}
			});

			if (inTitle)
			{
				titleToolbar.addComponent(event.getButton(), button);
				titleToolbar.revalidate();
			}
			else
			{
				pluginToolbar.addComponent(event.getButton(), button);
				pluginToolbar.revalidate();
			}
		});
	}

	@Subscribe
	public void onNavigationButtonRemoved(final NavigationButtonRemoved event)
	{
		SwingUtilities.invokeLater(() ->
		{
			pluginToolbar.removeComponent(event.getButton());
			pluginToolbar.revalidate();
			titleToolbar.removeComponent(event.getButton());
			titleToolbar.revalidate();
			final PluginPanel pluginPanel = event.getButton().getPanel();

			if (pluginPanel != null)
			{
				navContainer.remove(pluginPanel.getWrappedPanel());
			}
		});
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged event)
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

			frame.setTitle(RuneLiteProperties.getTitle() + " - " + name);
			return true;
		});
	}

	/**
	 * Initialize UI.
	 * @param runelite runelite instance that will be shut down on exit
	 * @throws Exception exception that can occur during creation of the UI
	 */
	public void init(final RuneLite runelite) throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			// Set some sensible swing defaults
			SwingUtil.setupDefaults();

			// Use substance look and feel
			SwingUtil.setTheme(new SubstanceRuneLiteLookAndFeel());

			// Use custom UI font
			SwingUtil.setFont(FontManager.getRunescapeFont());

			// Create main window
			frame = new ContainableFrame();

			// Try to enable fullscreen on OSX
			OSXUtil.tryEnableFullscreen(frame);

			frame.setTitle(RuneLiteProperties.getTitle());
			frame.setIconImage(ICON);
			frame.getLayeredPane().setCursor(Cursor.getDefaultCursor()); // Prevent substance from using a resize cursor for pointing
			frame.setLocationRelativeTo(frame.getOwner());
			frame.setResizable(true);

			SwingUtil.addGracefulExitCallback(frame,
				() ->
				{
					saveClientBoundsConfig();
					runelite.shutdown();
				},
				this::showWarningOnExit
			);

			container = new JPanel();
			container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
			container.add(new ClientPanel(client));

			navContainer = new JPanel();
			navContainer.setLayout(cardLayout);
			navContainer.setMinimumSize(new Dimension(0, 0));
			navContainer.setMaximumSize(new Dimension(0, 0));
			navContainer.setPreferredSize(new Dimension(0, 0));

			// To reduce substance's colorization (tinting)
			navContainer.putClientProperty(SubstanceSynapse.COLORIZATION_FACTOR, 1.0);
			container.add(navContainer);

			pluginToolbar = new ClientPluginToolbar();
			titleToolbar = new ClientTitleToolbar();
			frame.add(container);

			// Add key listener
			final HotkeyListener sidebarListener = new HotkeyListener(() ->
				new Keybind(KeyEvent.VK_F11, InputEvent.CTRL_DOWN_MASK))
			{
				@Override
				public void hotkeyPressed()
				{
					toggleSidebar();
				}
			};

			keyManager.registerKeyListener(sidebarListener);

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
			frame.setUndecorated(withTitleBar);

			if (withTitleBar)
			{
				frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

				final JComponent titleBar = SubstanceCoreUtilities.getTitlePaneComponent(frame);
				titleToolbar.putClientProperty(SubstanceTitlePaneUtilities.EXTRA_COMPONENT_KIND, SubstanceTitlePaneUtilities.ExtraComponentKind.TRAILING);
				titleBar.add(titleToolbar);

				// Substance's default layout manager for the title bar only lays out substance's components
				// This wraps the default manager and lays out the TitleToolbar as well.
				LayoutManager delegate = titleBar.getLayout();
				titleBar.setLayout(new LayoutManager()
				{
					@Override
					public void addLayoutComponent(String name, Component comp)
					{
						delegate.addLayoutComponent(name, comp);
					}

					@Override
					public void removeLayoutComponent(Component comp)
					{
						delegate.removeLayoutComponent(comp);
					}

					@Override
					public Dimension preferredLayoutSize(Container parent)
					{
						return delegate.preferredLayoutSize(parent);
					}

					@Override
					public Dimension minimumLayoutSize(Container parent)
					{
						return delegate.minimumLayoutSize(parent);
					}

					@Override
					public void layoutContainer(Container parent)
					{
						delegate.layoutContainer(parent);
						final int width = titleToolbar.getPreferredSize().width;
						titleToolbar.setBounds(titleBar.getWidth() - 75 - width, 0, width, titleBar.getHeight());
					}
				});
			}

			// Update config
			updateFrameConfig(true);

			// Create hide sidebar button

			sidebarOpenIcon = ImageUtil.getResourceStreamFromClass(ClientUI.class, withTitleBar ? "open.png" : "open_rs.png");
			sidebarClosedIcon = ImageUtil.flipImage(sidebarOpenIcon, true, false);

			sidebarNavigationButton = NavigationButton
				.builder()
				.priority(100)
				.icon(sidebarClosedIcon)
				.onClick(this::toggleSidebar)
				.build();

			sidebarNavigationJButton = SwingUtil.createSwingButton(
				sidebarNavigationButton,
				0,
				null);

			titleToolbar.addComponent(sidebarNavigationButton, sidebarNavigationJButton);
			toggleSidebar();
		});
	}

	public void show()
	{
		SwingUtilities.invokeLater(() ->
		{
			// Layout frame
			frame.pack();
			frame.revalidateMinimumSize();

			// Create tray icon (needs to be created after frame is packed)
			trayIcon = SwingUtil.createTrayIcon(ICON, RuneLiteProperties.getTitle(), frame);

			// Move frame around (needs to be done after frame is packed)
			if (config.rememberScreenBounds())
			{
				try
				{
					Rectangle clientBounds = configManager.getConfiguration(
						CONFIG_GROUP, CONFIG_CLIENT_BOUNDS, Rectangle.class);
					if (clientBounds != null)
					{
						frame.setBounds(clientBounds);
						frame.revalidateMinimumSize();
					}
					else
					{
						frame.setLocationRelativeTo(frame.getOwner());
					}

					if (configManager.getConfiguration(CONFIG_GROUP, CONFIG_CLIENT_MAXIMIZED) != null)
					{
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					}
				}
				catch (Exception ex)
				{
					log.warn("Failed to set window bounds", ex);
					frame.setLocationRelativeTo(frame.getOwner());
				}
			}
			else
			{
				frame.setLocationRelativeTo(frame.getOwner());
			}

			// If the frame is well hidden (e.g. unplugged 2nd screen),
			// we want to move it back to default position as it can be
			// hard for the user to reposition it themselves otherwise.
			Rectangle clientBounds = frame.getBounds();
			Rectangle screenBounds = frame.getGraphicsConfiguration().getBounds();
			if (clientBounds.x + clientBounds.width - CLIENT_WELL_HIDDEN_MARGIN < screenBounds.getX() ||
				clientBounds.x + CLIENT_WELL_HIDDEN_MARGIN > screenBounds.getX() + screenBounds.getWidth() ||
				clientBounds.y + CLIENT_WELL_HIDDEN_MARGIN_TOP < screenBounds.getY() ||
				clientBounds.y + CLIENT_WELL_HIDDEN_MARGIN > screenBounds.getY() + screenBounds.getHeight())
			{
				frame.setLocationRelativeTo(frame.getOwner());
			}

			// Show frame
			frame.setVisible(true);
			frame.toFront();
			requestFocus();
			giveClientFocus();
			log.info("Showing frame {}", frame);
		});

		// Show out of date dialog if needed
		if (client != null && !(client instanceof Client))
		{
			SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(frame,
				"RuneLite has not yet been updated to work with the latest\n"
					+ "game update, it will work with reduced functionality until then.",
				"RuneLite is outdated", INFORMATION_MESSAGE));
		}
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
		if (OSType.getOSType() == OSType.MacOS)
		{
			OSXUtil.requestFocus();
		}
		// The workaround for Windows is to minimise and then un-minimise the client to bring
		// it to the front because java.awt.Window#toFront doesn't work reliably.
		// See https://stackoverflow.com/questions/309023/how-to-bring-a-window-to-the-front/7435722#7435722
		else if (OSType.getOSType() == OSType.Windows && !frame.isFocused())
		{
			SwingUtilities.invokeLater(() ->
			{
				if ((frame.getExtendedState() & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH)
				{
					frame.setExtendedState(JFrame.ICONIFIED);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}
				else
				{
					// If the client is snapped to the top and bottom edges of the screen, setExtendedState will
					// will reset it so setSize and setLocation ensure that the client doesn't move or resize.
					// It is done this way because Windows does not support JFrame.MAXIMIZED_VERT
					int x = frame.getLocation().x;
					int y = frame.getLocation().y;
					int width = frame.getWidth();
					int height = frame.getHeight();
					frame.setExtendedState(JFrame.ICONIFIED);
					frame.setExtendedState(JFrame.NORMAL);
					frame.setLocation(x, y);
					frame.setSize(width, height);
				}
			});
		}

		frame.requestFocus();
		giveClientFocus();
	}

	/**
	 * Changes cursor for client window. Requires ${@link ClientUI#init(RuneLite)} to be called first.
	 * FIXME: This is working properly only on Windows, Linux and Mac are displaying cursor incorrectly
	 * @param image cursor image
	 * @param name  cursor name
	 */
	public void setCursor(final BufferedImage image, final String name)
	{
		if (container == null)
		{
			return;
		}

		final java.awt.Point hotspot = new java.awt.Point(container.getX(), container.getY());
		final Cursor cursorAwt = Toolkit.getDefaultToolkit().createCustomCursor(image, hotspot, name);
		container.setCursor(cursorAwt);
	}

	/**
	 * Resets client window cursor to default one.
	 * @see ClientUI#setCursor(BufferedImage, String)
	 */
	public void resetCursor()
	{
		if (container == null)
		{
			return;
		}

		container.setCursor(Cursor.getDefaultCursor());
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
				final java.awt.Point point = SwingUtilities.convertPoint(canvas, 0, 0, frame);
				return new Point(point.x, point.y);
			}
		}

		return new Point(0, 0);
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
		final Widget logoutButton = client.getWidget(WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_LOGOUT_BUTTON);
		final int y = logoutButton != null && !logoutButton.isHidden() && logoutButton.getParent() != null
			? logoutButton.getHeight() + logoutButton.getRelativeY()
			: 5;

		final BufferedImage image = sidebarOpen ? sidebarClosedIcon : sidebarOpenIcon;

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

	private void toggleSidebar()
	{
		// Toggle sidebar open
		boolean isSidebarOpen = sidebarOpen;
		sidebarOpen = !sidebarOpen;

		// Select/deselect buttons
		if (currentButton != null)
		{
			currentButton.setSelected(sidebarOpen);
		}

		if (currentNavButton != null)
		{
			currentNavButton.setSelected(sidebarOpen);
		}

		if (isSidebarOpen)
		{
			sidebarNavigationJButton.setIcon(new ImageIcon(sidebarOpenIcon));
			sidebarNavigationJButton.setToolTipText("Open SideBar");

			contract();

			// Remove plugin toolbar
			container.remove(pluginToolbar);
		}
		else
		{
			sidebarNavigationJButton.setIcon(new ImageIcon(sidebarClosedIcon));
			sidebarNavigationJButton.setToolTipText("Close SideBar");

			// Try to restore last panel
			expand(currentNavButton);

			// Add plugin toolbar back
			container.add(pluginToolbar);
		}

		// Revalidate sizes of affected Swing components
		container.revalidate();
		giveClientFocus();

		if (sidebarOpen)
		{
			frame.expandBy(pluginToolbar.getWidth());
		}
		else
		{
			frame.contractBy(pluginToolbar.getWidth());
		}
	}

	private void expand(@Nullable NavigationButton button)
	{
		if (button == null)
		{
			return;
		}

		final PluginPanel panel = button.getPanel();

		if (panel == null)
		{
			return;
		}

		if (!sidebarOpen)
		{
			toggleSidebar();
		}

		int width = panel.getWrappedPanel().getPreferredSize().width;
		int expandBy = pluginPanel != null ? pluginPanel.getWrappedPanel().getPreferredSize().width - width : width;
		pluginPanel = panel;

		// Expand sidebar
		navContainer.setMinimumSize(new Dimension(width, 0));
		navContainer.setMaximumSize(new Dimension(width, Integer.MAX_VALUE));
		navContainer.setPreferredSize(new Dimension(width, 0));
		navContainer.revalidate();
		cardLayout.show(navContainer, button.getTooltip());

		// panel.onActivate has to go after giveClientFocus so it can get focus if it needs.
		giveClientFocus();
		panel.onActivate();

		// Check if frame was really expanded or contracted
		if (expandBy > 0)
		{
			frame.expandBy(expandBy);
		}
		else if (expandBy < 0)
		{
			frame.contractBy(expandBy);
		}
	}

	private void contract()
	{
		if (pluginPanel == null)
		{
			return;
		}

		pluginPanel.onDeactivate();
		navContainer.setMinimumSize(new Dimension(0, 0));
		navContainer.setMaximumSize(new Dimension(0, 0));
		navContainer.setPreferredSize(new Dimension(0, 0));
		navContainer.revalidate();
		giveClientFocus();
		frame.contractBy(pluginPanel.getWrappedPanel().getPreferredSize().width);
		pluginPanel = null;
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

		if (config.usernameInTitle() && (client instanceof Client))
		{
			final Player player = ((Client)client).getLocalPlayer();

			if (player != null && player.getName() != null)
			{
				frame.setTitle(RuneLiteProperties.getTitle() + " - " + player.getName());
			}
		}
		else
		{
			frame.setTitle(RuneLiteProperties.getTitle());
		}

		if (frame.isAlwaysOnTopSupported())
		{
			frame.setAlwaysOnTop(config.gameAlwaysOnTop());
		}

		if (updateResizable)
		{
			frame.setResizable(!config.lockWindowSize());
		}

		frame.setExpandResizeType(config.automaticResizeType());

		ContainableFrame.Mode containMode = config.containInScreen();
		if (containMode == ContainableFrame.Mode.ALWAYS && !withTitleBar)
		{
			// When native window decorations are enabled we don't have a way to receive window move events
			// so we can't contain to screen always.
			containMode = ContainableFrame.Mode.RESIZING;
		}
		frame.setContainedInScreen(containMode);

		if (!config.rememberScreenBounds())
		{
			configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_CLIENT_MAXIMIZED);
			configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_CLIENT_BOUNDS);
		}

		if (client == null)
		{
			return;
		}

		// The upper bounds are defined by the applet's max size
		// The lower bounds are defined by the client's fixed size
		int width = Math.max(Math.min(config.gameSize().width, 7680), Constants.GAME_FIXED_WIDTH);
		int height = Math.max(Math.min(config.gameSize().height, 2160), Constants.GAME_FIXED_HEIGHT);
		final Dimension size = new Dimension(width, height);

		if (!size.equals(lastClientSize))
		{
			lastClientSize = size;
			client.setSize(size);
			client.setPreferredSize(size);
			client.getParent().setPreferredSize(size);
			client.getParent().setSize(size);

			if (frame.isVisible())
			{
				frame.pack();
			}
		}
	}

	private void saveClientBoundsConfig()
	{
		if ((frame.getExtendedState() & JFrame.MAXIMIZED_BOTH) != 0)
		{
			configManager.setConfiguration(CONFIG_GROUP, CONFIG_CLIENT_MAXIMIZED, true);
		}
		else
		{
			final Rectangle bounds = frame.getBounds();

			// Try to expand sidebar
			if (!sidebarOpen)
			{
				bounds.width += pluginToolbar.getWidth();
			}

			if (config.automaticResizeType() == ExpandResizeType.KEEP_GAME_SIZE)
			{

				// Try to contract plugin panel
				if (pluginPanel != null)
				{
					bounds.width -= pluginPanel.getWrappedPanel().getPreferredSize().width;
				}
			}

			configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_CLIENT_MAXIMIZED);
			configManager.setConfiguration(CONFIG_GROUP, CONFIG_CLIENT_BOUNDS, bounds);
		}
	}
}
