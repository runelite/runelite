/*
 * Copyright (c) 2018, Lyzrds
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
package net.runelite.client.plugins.raids;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.lang.reflect.Method;
import javax.inject.Inject;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

class RaidsPanel extends PluginPanel
{
	@Inject
	private Client client;
	@Inject
	private RaidsPlugin raidsPlugin;

	@Inject
	private ClientThread clientThread;
	private JButton reloadButton = new JButton("Reload Instance");
	private JButton reloadScouter = new JButton("Reload Raid Overlay");
	private JLabel reloadMessage = new JLabel("<html><center><h3>Instance Reload Helper </h3>Reloading an instance will cause your client to disconnect temporarily.<br></center></html>");

	void init(RaidsConfig config)
	{

		// this may or may not qualify as a hack
		// but this lets the editor pane expand to fill the whole parent panel
		getParent().setLayout(new FlowLayout());
		getParent().add(this, BorderLayout.CENTER);

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		JPanel reloadContainer = new JPanel();
		JPanel scouterContainer = new JPanel();
		JPanel buttons = new JPanel();
		reloadContainer.setLayout(new BorderLayout());
		buttons.setLayout(new BorderLayout());
		buttons.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		reloadContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		scouterContainer.setLayout(new BorderLayout());
		scouterContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JPanel reloadFrame = new JPanel();
		JPanel scoutFrame = new JPanel();
		reloadButton.addActionListener((ActionEvent e) ->
		{


			if ((client.getGameState() == GameState.LOGGED_IN))
			{
				try
				{
					//look for client.gameStateChanged(-1); in src files to find
					Method m = client.getClass().getClassLoader().loadClass("ba").getDeclaredMethod("ec", int.class, byte.class);
					m.setAccessible(true);
					m.invoke(null, 40, (byte) 3);

				}
				catch (ReflectiveOperationException f)
				{
					throw new RuntimeException(f);
				}
			}
		});
		reloadScouter.addActionListener((ActionEvent e) ->
		{
			if ((client.getGameState() == GameState.LOGGED_IN))
			{
				raidsPlugin.checkRaidPresence(true);
			}
		});

		reloadFrame.add(reloadButton);
		scoutFrame.add(reloadScouter);
		reloadContainer.add(reloadFrame, BorderLayout.NORTH);
		reloadContainer.add(scoutFrame, BorderLayout.SOUTH);
		add(reloadMessage, BorderLayout.PAGE_START);
		add(reloadContainer, BorderLayout.CENTER);
	}
}
