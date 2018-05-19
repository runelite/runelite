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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.PluginPanel;



@Slf4j
public class LRP extends PluginPanel
{
	@Inject
	@Nullable
	private Client client;

	private final ItemManager itemManager;
	private final LootRecorderPlugin lootRecorderPlugin;
	private final LootRecorderConfig lootRecorderConfig;

	private JTabbedPane tabsPanel = new JTabbedPane();
	private ButtonGroup actionButtonGroup = new ButtonGroup();

	private List<JToggleButton> actionButtons;

	@Inject
	LRP(ItemManager itemManager, LootRecorderPlugin lootRecorderPlugin, LootRecorderConfig lootRecorderConfig)
	{
		super(false);
		this.itemManager = itemManager;
		this.lootRecorderPlugin = lootRecorderPlugin;
		this.lootRecorderConfig = lootRecorderConfig;


		// Set Frame Layout
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);


		createPanel(this);
	}

	void createPanel(LRP panel)
	{
		// Create each Tab of the Panel
		for (Tab tab : Tab.values())
		{
			// Create a Container Panel for this tab
			JPanel tabPanel = new JPanel();
			tabPanel.setLayout(new BoxLayout(tabPanel, BoxLayout.Y_AXIS));
			tabPanel.setBorder(new EmptyBorder(2, 2, 2, 2));

			// Create a Container to hold all Buttons
			JPanel buttons = new JPanel();
			buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
			buttons.setBorder(new EmptyBorder(0, 0, 4, 0));

			// Create a Container to hold all Loot Data
			JPanel lootPanel = new JPanel();
			lootPanel.setLayout(new BoxLayout(lootPanel, BoxLayout.Y_AXIS));
			lootPanel.setBorder(new MatteBorder(0, 2, 0, 2, Color.GRAY));

			// Refresh Button
			JButton refresh = new JButton("Refresh Data");
			refresh.addActionListener(e ->
			{
				refreshLootPanel(lootPanel, tab);
			});
			buttons.add(refresh);

			// Add buttons to tabPanel
			tabPanel.add(buttons);

			// create Loot Panel for this tab
			createLootPanel(lootPanel, tab);

			// Scrolling Ability for lootPanel
			JPanel wrapped = new JPanel(new BorderLayout());
			wrapped.add(lootPanel, BorderLayout.NORTH);
			JScrollPane scroller = new JScrollPane(lootPanel);
			scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scroller.getVerticalScrollBar().setUnitIncrement(16);

			// Add loot panel with scroller to the panel
			tabPanel.add(scroller);

			// Add new tab to panel
			tabsPanel.addTab(null, null, tabPanel, tab.getName());
			// Add Tab Icon
			AsyncBufferedImage icon = itemManager.getImage(tab.getItemID());
			int idx = tabsPanel.getTabCount() - 1;
			Runnable resize = () ->
			{
				tabsPanel.setIconAt(idx, new ImageIcon(icon.getScaledInstance(24, 21, Image.SCALE_SMOOTH)));
			};
			icon.onChanged(resize);
			resize.run();
			log.info("Created " + String.valueOf(tab) + " tab");
		}

		// Refresh Button
		JButton refresh = new JButton("Refresh Panel");
		refresh.addActionListener(e ->
		{
			refreshPanel(panel);
		});

		// Add to Panel
		panel.add(tabsPanel);
		panel.add(refresh);
		log.info("Panel Created");
	}

	void createLootPanel(JPanel lootPanel, Tab tab)
	{
		// Creates and Appends necessary data to tabPanel
		ArrayList<LootEntry> data = lootRecorderPlugin.getData(tab.getName());
		log.info("Got drops for: ");
		log.info(tab.getName());
		log.info(String.valueOf(data));

		// Loop over each LootEntry
		data.forEach(d ->
				{
					ArrayList<DropEntry> drops = d.getDrops();
					drops.forEach(dr ->
					{
						ItemComposition item = itemManager.getItemComposition(dr.getItem_id());
						JLabel label = new JLabel(item.getName());
						lootPanel.add(label);
					});
				}
		);
	}

	void refreshPanel(LRP panel)
	{
		// Refresh Log Data
		lootRecorderPlugin.loadAllData();
		// Remove All Panel Components
		panel.removeAll();
		tabsPanel.removeAll();
		// Recreate Panel Components
		createPanel(panel);
		// Ensure panel updates are applied
		panel.revalidate();
		panel.repaint();
		log.info("Refreshed Panel");
	}

	void refreshLootPanel(JPanel lootPanel, Tab tab)
	{
		// Refresh data for necessary tab
		lootRecorderPlugin.loadTabData(tab.getName());
		// Recreate the loot panel
		lootPanel.removeAll();
		createLootPanel(lootPanel, tab);
		// Ensure changes are applied
		this.revalidate();
		this.repaint();
	}
}