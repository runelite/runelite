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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.runelite.client.RuneLite;

public final class ClientUI extends JFrame
{
	private static final int PANEL_WIDTH = 805;
	private static final int PANEL_HEIGHT = 541;
	private static final int EXPANDED_WIDTH = PANEL_WIDTH + PluginPanel.PANEL_WIDTH;

	private JPanel container;
	private JPanel navContainer;
	private ClientPanel panel;
	private NavigationPanel navigationPanel;
	private PluginPanel pluginPanel;
	private boolean expanded;

	public ClientUI() throws Exception
	{
		init();
		pack();
		setTitle("RuneLite");
		setIconImage(RuneLite.ICON);
		setLocationRelativeTo(getOwner());
		setResizable(true);
		setVisible(true);
	}

	private void init() throws Exception
	{
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				checkExit();
			}
		});

		JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored)
		{
		}

		container = new JPanel();
		container.setLayout(new BorderLayout(0, 0));

		panel = new ClientPanel();
		container.add(panel, BorderLayout.CENTER);

		navContainer = new JPanel();
		navContainer.setLayout(new BorderLayout(0, 0));
		container.add(navContainer, BorderLayout.EAST);

		navigationPanel = new NavigationPanel();
		navContainer.add(navigationPanel, BorderLayout.EAST);

		add(container);
	}

	public void expand()
	{
		if (!expanded)
		{
			navContainer.add(pluginPanel, BorderLayout.WEST);
			navContainer.revalidate();
			this.setMinimumSize(new Dimension(EXPANDED_WIDTH, PANEL_HEIGHT));
			expanded = true;
		}
		else
		{
			navContainer.remove(1);
			navContainer.revalidate();
			this.setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
			if (this.getWidth() == EXPANDED_WIDTH)
			{
				this.setSize(PANEL_WIDTH, PANEL_HEIGHT);
			}
			expanded = false;
		}
	}

	private void checkExit()
	{
		int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (result == JOptionPane.OK_OPTION)
		{
			System.exit(0);
		}
	}

	public NavigationPanel getNavigationPanel()
	{
		return navigationPanel;
	}

	public PluginPanel getPluginPanel()
	{
		return pluginPanel;
	}

	public void setPluginPanel(PluginPanel pluginPanel)
	{
		this.pluginPanel = pluginPanel;
	}
}
