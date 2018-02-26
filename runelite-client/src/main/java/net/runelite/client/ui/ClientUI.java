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

import com.google.common.eventbus.Subscribe;
import java.applet.Applet;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Enumeration;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRootPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.RuneLite;
import net.runelite.client.RuneLiteProperties;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel;
import org.pushingpixels.substance.internal.utils.SubstanceCoreUtilities;
import org.pushingpixels.substance.internal.utils.SubstanceTitlePaneUtilities;

@Slf4j
public class ClientUI extends JFrame
{
	private static final int PANEL_EXPANDED_WIDTH = PluginPanel.PANEL_WIDTH + PluginPanel.SCROLLBAR_WIDTH;
	private static final BufferedImage ICON;

	@Getter
	private TrayIcon trayIcon;

	@Getter
	private final PluginToolbar pluginToolbar = new PluginToolbar(this);

	@Getter
	private TitleToolbar titleToolbar;

	private final RuneLite runelite;
	private final Applet client;
	private final RuneLiteProperties properties;
	private final JSplitPane main = new JSplitPane();
	private boolean panelOpen = false;

	static
	{
		BufferedImage icon = null;

		try
		{
			icon = ImageIO.read(ClientUI.class.getResourceAsStream("/runelite.png"));
		}
		catch (IOException e)
		{
			log.warn("Client icon failed to load", e);
		}

		ICON = icon;
	}

	public static ClientUI create(RuneLite runelite, RuneLiteProperties properties, Applet client)
	{
		// Force heavy-weight popups/tooltips.
		// Prevents them from being obscured by the game applet.
		ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);

		// Do not render shadows under popups/tooltips.
		// Fixes black boxes under popups that are above the game applet.
		System.setProperty("jgoodies.popupDropShadowEnabled", "false");

		// Do not fill in background on repaint. Reduces flickering when
		// the applet is resized.
		System.setProperty("sun.awt.noerasebackground", "true");

		// Use substance look and feel
		try
		{
			UIManager.setLookAndFeel(new SubstanceGraphiteLookAndFeel());
		}
		catch (UnsupportedLookAndFeelException ex)
		{
			log.warn("unable to set look and feel", ex);
		}

		// Use custom UI font
		setUIFont(new FontUIResource(FontManager.getRunescapeFont()));

		return new ClientUI(runelite, properties, client);
	}

	private ClientUI(RuneLite runelite, RuneLiteProperties properties, Applet client)
	{
		this.runelite = runelite;
		this.properties = properties;
		this.client = client;
		this.trayIcon = setupTrayIcon();
		this.titleToolbar = new TitleToolbar(properties);

		init();
		setTitle(properties.getTitle());
		setIconImage(ICON);
		// Prevent substance from using a resize cursor for pointing
		getLayeredPane().setCursor(Cursor.getDefaultCursor());
		setLocationRelativeTo(getOwner());
		setResizable(true);
	}

	public void showWithChrome(boolean customChrome)
	{
		setUndecorated(customChrome);

		if (customChrome)
		{
			getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

			final JComponent titleBar = SubstanceCoreUtilities.getTitlePaneComponent(this);
			titleToolbar.putClientProperty(SubstanceTitlePaneUtilities.EXTRA_COMPONENT_KIND, SubstanceTitlePaneUtilities.ExtraComponentKind.TRAILING);
			titleBar.add(titleToolbar);

			// Substance's default layout manager for the title bar only lays out substance's components
			// This wraps the default manager and lays out the TitleToolbar as well.
			final LayoutManager delegate = titleBar.getLayout();
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

		pack();
		resizeSplit();
		setLocationRelativeTo(getOwner());
		setVisible(true);
		toFront();
		requestFocus();
		giveClientFocus();
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

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("runelite"))
		{
			return;
		}

		if (event.getKey().equals("gameAlwaysOnTop"))
		{
			if (this.isAlwaysOnTopSupported())
			{
				this.setAlwaysOnTop(Boolean.valueOf(event.getNewValue()));
			}
		}

		if (!event.getKey().equals("gameSize"))
		{
			return;
		}

		if (client == null)
		{
			return;
		}

		final String[] splitStr = event.getNewValue().split("x");
		int width = Integer.parseInt(splitStr[0]);
		int height = Integer.parseInt(splitStr[1]);

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

		SwingUtilities.invokeLater(() ->
		{
			client.setSize(size);
			client.setPreferredSize(size);

			client.getParent().setPreferredSize(size);
			client.getParent().setSize(size);

			if (isVisible())
			{
				pack();
			}
		});
	}

	private static void setUIFont(FontUIResource f)
	{
		final Enumeration keys = UIManager.getDefaults().keys();

		while (keys.hasMoreElements())
		{
			final Object key = keys.nextElement();
			final Object value = UIManager.get(key);

			if (value instanceof FontUIResource)
			{
				UIManager.put(key, f);
			}
		}
	}

	private TrayIcon setupTrayIcon()
	{
		if (!SystemTray.isSupported())
		{
			return null;
		}

		SystemTray systemTray = SystemTray.getSystemTray();
		TrayIcon trayIcon = new TrayIcon(ICON, properties.getTitle());
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

		// bring to front when tray icon is clicked
		trayIcon.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				setVisible(true);
				setState(Frame.NORMAL); // unminimize
			}
		});

		return trayIcon;
	}

	private void init()
	{
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				int result = JOptionPane.OK_OPTION;

				// only ask if not logged out
				if (client != null && client instanceof Client && ((Client) client).getGameState() != GameState.LOGIN_SCREEN)
				{
					result = JOptionPane.showConfirmDialog(ClientUI.this,
						"Are you sure you want to exit?", "Exit",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				}

				if (result == JOptionPane.OK_OPTION)
				{
					runelite.shutdown();
					System.exit(0);
				}
			}
		});

		addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent e)
			{
				super.componentResized(e);
				resizeSplit();
			}
		});

		main.setDividerSize(0);
		main.setLeftComponent(new ClientPanel(client));

		final JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		container.add(main, BorderLayout.CENTER);
		container.add(pluginToolbar, BorderLayout.EAST);
		add(container);
	}

	void expand(PluginPanel panel)
	{
		final JPanel wrappedPanel = panel.getWrappedPanel();
		main.setRightComponent(wrappedPanel);
		panelOpen = true;
		resizeSplit();
		giveClientFocus();
		panel.onActivate();
	}

	void contract(PluginPanel pluginPanel)
	{
		panelOpen = false;
		resizeSplit();
		pluginPanel.onDeactivate();
		giveClientFocus();
	}

	private void resizeSplit()
	{
		main.setDividerLocation(main.getLocation().x + main.getSize().width - (panelOpen ? PANEL_EXPANDED_WIDTH : 0));
	}
}
