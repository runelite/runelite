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

import java.applet.Applet;
import com.google.common.base.Strings;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.RuneLite;
import net.runelite.client.RuneliteProperties;
import org.pushingpixels.substance.internal.ui.SubstanceRootPaneUI;

@Slf4j
public class ClientUI extends JFrame
{
	private static final int CLIENT_WIDTH = 809;
	private static final int SCROLLBAR_WIDTH = 17;
	private static final int EXPANDED_WIDTH = CLIENT_WIDTH + PluginPanel.PANEL_WIDTH + SCROLLBAR_WIDTH;

	private final Applet client;
	private final RuneliteProperties properties;
	private JPanel container;
	private JPanel navContainer;
	private ClientPanel panel;
	private PluginToolbar pluginToolbar;
	private PluginPanel pluginPanel;

	public ClientUI(RuneliteProperties properties, Applet client)
	{
		this.properties = properties;
		this.client = client;
		setUIFont(new FontUIResource(FontManager.getRunescapeFont()));
		init();
		pack();
		TitleBarPane titleBarPane = new TitleBarPane(this.getRootPane(), (SubstanceRootPaneUI)this.getRootPane().getUI());
		titleBarPane.editTitleBar(this);
		setTitle(null);
		setIconImage(RuneLite.ICON);
		setLocationRelativeTo(getOwner());
		setResizable(true);
		setVisible(true);
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


	@Override
	public void setTitle(String extra)
	{
		if (!Strings.isNullOrEmpty(extra))
		{
			super.setTitle(properties.getTitle() + " " + properties.getVersion() + " " + extra);
		}
		else
		{
			super.setTitle(properties.getTitle() + " " + properties.getVersion());
		}
	}

	private void init()
	{
		assert SwingUtilities.isEventDispatchThread();

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(CLIENT_WIDTH, 0));
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				checkExit();
			}
		});

		container = new JPanel();
		container.setLayout(new BorderLayout(0, 0));

		panel = new ClientPanel(client);
		container.add(panel, BorderLayout.CENTER);

		navContainer = new JPanel();
		navContainer.setLayout(new BorderLayout(0, 0));
		container.add(navContainer, BorderLayout.EAST);

		pluginToolbar = new PluginToolbar(this);
		navContainer.add(pluginToolbar, BorderLayout.EAST);

		add(container);
	}

	void expand(PluginPanel panel)
	{
		if (pluginPanel != null)
		{
			navContainer.remove(1);
			container.validate();
		}

		pluginPanel = panel;
		navContainer.add(wrapPanel(pluginPanel), BorderLayout.WEST);
		container.validate();
		this.setMinimumSize(new Dimension(EXPANDED_WIDTH, 0));
	}

	void contract()
	{
		navContainer.remove(1);
		container.validate();
		this.setMinimumSize(new Dimension(CLIENT_WIDTH, 0));
		if (this.getWidth() == EXPANDED_WIDTH)
		{
			this.setSize(CLIENT_WIDTH, getHeight());
		}
		pluginPanel = null;
	}

	private JPanel wrapPanel(PluginPanel panel)
	{
		final JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		northPanel.add(panel, BorderLayout.NORTH);

		final JScrollPane scrollPane = new JScrollPane(northPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); //Otherwise scrollspeed is really slow
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		final JPanel panelWrap = new JPanel();

		// Adjust the preferred size to expand to width of scrollbar to
		// to preven scrollbar overlapping over contents
		panelWrap.setPreferredSize(new Dimension(
					PluginPanel.PANEL_WIDTH + SCROLLBAR_WIDTH,
					0));

		panelWrap.setLayout(new BorderLayout());
		panelWrap.add(scrollPane, BorderLayout.CENTER);
		return panelWrap;
	}

	private void checkExit()
	{
		int result = JOptionPane.OK_OPTION;

		// only ask if not logged out
		if (client != null && client instanceof Client && ((Client)client).getGameState() != GameState.LOGIN_SCREEN)
		{
			result = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		}

		if (result == JOptionPane.OK_OPTION)
		{
			System.exit(0);
		}
	}

	public PluginToolbar getPluginToolbar()
	{
		return pluginToolbar;
	}

	public PluginPanel getPluginPanel()
	{
		return pluginPanel;
	}
}
