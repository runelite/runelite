/*
 * Copyright (c) 2018, TheStonedTurtle <www.github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.lootrecorder;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.PluginPanel;



@Slf4j
class LootRecorderPanel extends PluginPanel
{
	private final Client client;
	private final ItemManager itemManager;
	private final LootRecorderPlugin lootRecorderPlugin;

	@Inject
	LootRecorderPanel(Client client, ItemManager itemManager, LootRecorderPlugin lootRecorderPlugin)
	{
		this.client = client;
		this.itemManager = itemManager;
		this.lootRecorderPlugin = lootRecorderPlugin;

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);

		JTabbedPane tabsPanel = new JTabbedPane();


		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;

		// Create each Tab of the Panel
		log.info(String.valueOf(Tab.values()));
		for (Tab tab : Tab.values())
		{
			JPanel subPanel = new JPanel(new GridBagLayout())
			{
				@Override
				public Dimension getPreferredSize()
				{
					return new Dimension(PluginPanel.PANEL_WIDTH, super.getPreferredSize().height);
				}
			};
			subPanel.setBorder(new EmptyBorder(2, 6, 6, 6));

			// Add the necessary items to the sub panel
			GridBagConstraints c2 = new GridBagConstraints();
			c2.fill = GridBagConstraints.HORIZONTAL;
			c2.weightx = 1;
			c2.gridx = 0;
			c2.gridy = 10;

			// Create the Entries for this tab
			ArrayList<LootEntry> data = this.lootRecorderPlugin.getData(tab.getName());
			log.info(String.valueOf(data));
			log.info("Got Barrows");
			LootRecorderSubPanel itemsPanel = new LootRecorderSubPanel(data, itemManager);

			subPanel.add(itemsPanel);

			AsyncBufferedImage icon = itemManager.getImage(tab.getItemID());
			tabsPanel.addTab(null, null, null, tab.getName());
			int idx = tabsPanel.getTabCount() - 1;
			Runnable resize = () ->
			{
				tabsPanel.setIconAt(idx, new ImageIcon(icon.getScaledInstance(24, 21, Image.SCALE_SMOOTH)));
			};
			icon.onChanged(resize);
			resize.run();
			log.info("Created " + String.valueOf(tab) + " tab");
		}

		JButton refresh = new JButton("Refresh Data");
		refresh.addActionListener(e ->
		{
			lootRecorderPlugin.refreshPanel();
		});

		layout.setHorizontalGroup(layout.createParallelGroup()
				.addComponent(tabsPanel)
				.addComponent(refresh)
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(tabsPanel)
				.addComponent(refresh)
		);
		log.info("subpanel");
		System.out.print(this);
	}
}