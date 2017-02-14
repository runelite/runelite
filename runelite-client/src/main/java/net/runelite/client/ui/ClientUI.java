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

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class ClientUI extends JFrame
{
	private JPanel container;
	private ClientPanel panel;
	private NavigationPanel navigationPanel;
	private PluginPanel pluginPanel;
	private boolean expanded;

	public ClientUI() throws Exception
	{
		init();
		pack();
		setTitle("RuneLite");
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
		container.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		panel = new ClientPanel();
		container.add(panel);

		navigationPanel = new NavigationPanel();
		container.add(navigationPanel);

		add(container);
	}

	public void expand()
	{
		if (!expanded)
		{
			container.add(pluginPanel, null, 1);

			container.revalidate();

			this.setSize(this.getWidth() + PluginPanel.PANEL_WIDTH, this.getHeight());
			expanded = true;
		}
		else
		{
			container.remove(1);
			container.revalidate();
			this.setSize(this.getWidth() - PluginPanel.PANEL_WIDTH, this.getHeight());
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
