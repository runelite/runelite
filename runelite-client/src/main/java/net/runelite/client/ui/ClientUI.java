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

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.RuneLite;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.events.ClientUILoaded;
import net.runelite.client.events.PluginToolbarButtonAdded;
import net.runelite.client.events.PluginToolbarButtonRemoved;
import net.runelite.client.events.TitleToolbarButtonAdded;
import net.runelite.client.events.TitleToolbarButtonRemoved;
import net.runelite.client.util.OSType;
import net.runelite.client.util.OSXUtil;
import net.runelite.client.util.SwingUtil;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel;
import org.pushingpixels.substance.internal.utils.SubstanceCoreUtilities;
import org.pushingpixels.substance.internal.utils.SubstanceTitlePaneUtilities;

/**
 * Client UI.
 */
@Slf4j
@Singleton
public class ClientUI
{
	private static final int PANEL_EXPANDED_WIDTH = PluginPanel.PANEL_WIDTH + PluginPanel.SCROLLBAR_WIDTH;
	public static final BufferedImage ICON;

	static
	{
		BufferedImage icon = null;

		try
		{
			synchronized (ImageIO.class)
			{
				icon = ImageIO.read(ClientUI.class.getResourceAsStream("/runelite.png"));
			}
		}
		catch (IOException e)
		{
			log.warn("Client icon failed to load", e);
		}

		ICON = icon;
	}

	@Getter
	private TrayIcon trayIcon;

	private final RuneLite runelite;
	private final RuneLiteProperties properties;
	private final RuneLiteConfig config;
	private final EventBus eventBus;
	private Applet client;
	private JFrame frame;
	private JPanel navContainer;
	private PluginPanel pluginPanel;
	private ClientPluginToolbar pluginToolbar;
	private ClientTitleToolbar titleToolbar;
	private JButton currentButton;

	@Inject
	private ClientUI(
		RuneLite runelite,
		RuneLiteProperties properties,
		RuneLiteConfig config,
		EventBus eventBus)
	{
		this.runelite = runelite;
		this.properties = properties;
		this.config = config;
		this.eventBus = eventBus;
	}

	/**
	 * On config changed.
	 *
	 * @param event the event
	 */
	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("runelite"))
		{
			return;
		}

		SwingUtilities.invokeLater(() ->
		{
			if (event.getKey().equals("gameAlwaysOnTop"))
			{
				if (frame.isAlwaysOnTopSupported())
				{
					frame.setAlwaysOnTop(config.gameAlwaysOnTop());
				}
			}

			if (event.getKey().equals("lockWindowSize"))
			{
				frame.setResizable(!config.lockWindowSize());
			}

			if (!event.getKey().equals("gameSize"))
			{
				return;
			}

			if (client == null)
			{
				return;
			}

			int width = config.gameSize().width;
			int height = config.gameSize().height;

			// The upper bounds are defined by the applet's max size
			// The lower bounds are taken care of by ClientPanel's setMinimumSize

			if (width > 7680)
			{
				width = 7680;
			}

			if (height > 2160)
			{
				height = 2160;
			}

			final Dimension size = new Dimension(width, height);

			client.setSize(size);
			client.setPreferredSize(size);
			client.getParent().setPreferredSize(size);
			client.getParent().setSize(size);

			if (frame.isVisible())
			{
				frame.pack();
			}
		});
	}

	@Subscribe
	public void onPluginToolbarButtonAdded(final PluginToolbarButtonAdded event)
	{
		SwingUtilities.invokeLater(() ->
		{
			final JButton button = SwingUtil.createSwingButton(event.getButton(), 0, (jButton) ->
			{
				final PluginPanel panel = event.getButton().getPanel();

				if (panel == null)
				{
					return;
				}

				if (currentButton != null)
				{
					currentButton.setSelected(false);
				}

				if (currentButton == jButton)
				{
					contract();
					currentButton = null;
				}
				else
				{
					currentButton = jButton;
					currentButton.setSelected(true);
					expand(panel);
				}
			});

			pluginToolbar.addComponent(event.getIndex(), event.getButton(), button);
		});
	}

	@Subscribe
	public void onPluginToolbarButtonRemoved(final PluginToolbarButtonRemoved event)
	{
		SwingUtilities.invokeLater(() -> pluginToolbar.removeComponent(event.getButton()));
	}

	@Subscribe
	public void onTitleToolbarButtonAdded(final TitleToolbarButtonAdded event)
	{
		if (!config.enableCustomChrome() && !SwingUtil.isCustomTitlePanePresent(frame))
		{
			return;
		}

		SwingUtilities.invokeLater(() ->
		{
			final int iconSize = ClientTitleToolbar.TITLEBAR_SIZE - 6;
			final JButton button = SwingUtil.createSwingButton(event.getButton(), iconSize, null);
			titleToolbar.addComponent(event.getButton(), button);
		});
	}

	@Subscribe
	public void onTitleToolbarButtonRemoved(final TitleToolbarButtonRemoved event)
	{
		if (!config.enableCustomChrome() && !SwingUtil.isCustomTitlePanePresent(frame))
		{
			return;
		}

		SwingUtilities.invokeLater(() -> titleToolbar.removeComponent(event.getButton()));
	}

	/**
	 * Initialize UI.
	 *
	 * @param client the client
	 * @throws Exception exception that can occur during creation of the UI
	 */
	public void init(@Nullable final Applet client) throws Exception
	{
		this.client = client;

		SwingUtilities.invokeAndWait(() ->
		{
			// Set some sensible swing defaults
			SwingUtil.setupDefaults();

			// Use substance look and feel
			SwingUtil.setTheme(new SubstanceGraphiteLookAndFeel());

			// Use custom UI font
			SwingUtil.setFont(FontManager.getRunescapeFont());

			// Create main window
			frame = new JFrame();

			// Try to enable fullscreen on OSX
			OSXUtil.tryEnableFullscreen(frame);

			trayIcon = SwingUtil.createTrayIcon(ICON, properties.getTitle(), frame);

			frame.setTitle(properties.getTitle());
			frame.setIconImage(ICON);
			frame.getLayeredPane().setCursor(Cursor.getDefaultCursor()); // Prevent substance from using a resize cursor for pointing
			frame.setLocationRelativeTo(frame.getOwner());
			frame.setResizable(true);

			SwingUtil.addGracefulExitCallback(frame, runelite::shutdown,
				() -> client != null
					&& client instanceof Client
					&& ((Client) client).getGameState() != GameState.LOGIN_SCREEN);

			final JPanel container = new JPanel();
			container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
			container.add(new ClientPanel(client));

			navContainer = new JPanel();
			navContainer.setLayout(new BorderLayout(0, 0));
			navContainer.setMinimumSize(new Dimension(0, 0));
			navContainer.setMaximumSize(new Dimension(0, Integer.MAX_VALUE));
			container.add(navContainer);

			pluginToolbar = new ClientPluginToolbar();
			container.add(pluginToolbar);

			titleToolbar = new ClientTitleToolbar();
			frame.add(container);
		});
	}

	/**
	 * Show client UI after everything else is done.
	 *
	 * @throws Exception exception that can occur during modification of the UI
	 */
	public void show() throws Exception
	{
		final boolean withTitleBar = config.enableCustomChrome();

		SwingUtilities.invokeAndWait(() ->
		{
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

			frame.pack();
			SwingUtil.revalidateMinimumSize(frame);
			frame.setLocationRelativeTo(frame.getOwner());
			frame.setVisible(true);
			frame.toFront();
			requestFocus();
			giveClientFocus();
		});

		eventBus.post(new ClientUILoaded());
	}

	/**
	 * Paint this component to target graphics
	 *
	 * @param graphics the graphics
	 */
	public void paint(final Graphics graphics)
	{
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

		frame.requestFocus();
		giveClientFocus();
	}

	private void expand(PluginPanel panel)
	{
		if (pluginPanel != null)
		{
			navContainer.remove(0);
		}
		else
		{
			if (SwingUtil.isInScreenBounds(
				frame.getLocationOnScreen().y + frame.getWidth() + PANEL_EXPANDED_WIDTH,
				frame.getLocationOnScreen().y))
			{
				frame.setSize(frame.getWidth() + PANEL_EXPANDED_WIDTH, frame.getHeight());
			}
		}

		pluginPanel = panel;
		navContainer.setMinimumSize(new Dimension(PANEL_EXPANDED_WIDTH, 0));
		navContainer.setMaximumSize(new Dimension(PANEL_EXPANDED_WIDTH, Integer.MAX_VALUE));

		final JPanel wrappedPanel = panel.getWrappedPanel();
		navContainer.add(wrappedPanel);
		navContainer.revalidate();

		// panel.onActivate has to go after giveClientFocus so it can get focus if it needs.
		giveClientFocus();
		panel.onActivate();

		wrappedPanel.repaint();
		SwingUtil.revalidateMinimumSize(frame);
	}

	private void contract()
	{
		boolean wasMinimumWidth = frame.getWidth() == frame.getMinimumSize().width;
		pluginPanel.onDeactivate();
		navContainer.remove(0);
		navContainer.setMinimumSize(new Dimension(0, 0));
		navContainer.setMaximumSize(new Dimension(0, 0));
		navContainer.revalidate();
		giveClientFocus();
		SwingUtil.revalidateMinimumSize(frame);

		if (wasMinimumWidth)
		{
			frame.setSize(frame.getMinimumSize().width, frame.getHeight());
		}
		else if (frame.getWidth() < Toolkit.getDefaultToolkit().getScreenSize().getWidth())
		{
			frame.setSize(frame.getWidth() - PANEL_EXPANDED_WIDTH, frame.getHeight());
		}

		pluginPanel = null;
	}

	private void giveClientFocus()
	{
		if (client instanceof Client)
		{
			final Canvas c = ((Client) client).getCanvas();
			c.requestFocusInWindow();
		}
		else if (client != null)
		{
			client.requestFocusInWindow();
		}
	}
}
