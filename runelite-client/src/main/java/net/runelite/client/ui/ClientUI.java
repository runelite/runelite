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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.RuneLite;
import org.pushingpixels.substance.internal.ui.SubstanceRootPaneUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ClientUI extends JFrame
{
	private static final Logger logger = LoggerFactory.getLogger(ClientUI.class);

	private static final int PANEL_WIDTH = 805;
	private static final int PANEL_HEIGHT = 541;
	private static final int EXPANDED_WIDTH = PANEL_WIDTH + PluginPanel.PANEL_WIDTH;

	private JPanel container;
	private JPanel navContainer;
	private ClientPanel panel;
	private PluginToolbar pluginToolbar;
	private PluginPanel pluginPanel;

	public ClientUI()
	{
		init();
		pack();
		TitleBarPane titleBarPane = new TitleBarPane(this.getRootPane(), (SubstanceRootPaneUI)this.getRootPane().getUI());
		titleBarPane.editTitleBar(this);
		setTitle("RuneLite");
		setIconImage(RuneLite.ICON);
		setLocationRelativeTo(getOwner());
		setResizable(true);
		setVisible(true);
	}

	private void init()
	{
		assert SwingUtilities.isEventDispatchThread();

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

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

		panel = new ClientPanel();
		if (!RuneLite.getOptions().has("no-rs"))
		{
			try
			{
				panel.loadRs();
			}
			catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException ex)
			{
				logger.warn("Error loading RS!", ex);
			}
		}
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
		navContainer.add(pluginPanel, BorderLayout.WEST);
		container.validate();
		this.setMinimumSize(new Dimension(EXPANDED_WIDTH, PANEL_HEIGHT));
	}

	void contract()
	{
		navContainer.remove(1);
		container.validate();
		this.setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		if (this.getWidth() == EXPANDED_WIDTH)
		{
			this.setSize(PANEL_WIDTH, PANEL_HEIGHT);
		}
		pluginPanel = null;
	}

	private void checkExit()
	{
		Client client = RuneLite.getClient();
		int result = JOptionPane.OK_OPTION;

		// only ask if not logged out
		if (client != null && client.getGameState() != GameState.LOGIN_SCREEN)
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
