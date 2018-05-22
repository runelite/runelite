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
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.PluginPanel;


@Slf4j
class LootRecorderPanel extends PluginPanel
{
	private final ItemManager itemManager;
	private final LootRecorderPlugin lootRecorderPlugin;

	private JTabbedPane tabsPanel = new JTabbedPane();

	private Map<String, JPanel> tabsMap = new HashMap<>();
	private Map<String, LootPanel> lootMap = new HashMap<>();

	@Inject
	LootRecorderPanel(ItemManager itemManager, LootRecorderPlugin lootRecorderPlugin)
	{
		super(false);
		this.itemManager = itemManager;
		this.lootRecorderPlugin = lootRecorderPlugin;

		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);

		createPanel(this);
		tabsPanel.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	private void createPanel(LootRecorderPanel panel)
	{
		// Create each Tab of the Panel
		for (Tab tab : Tab.values())
		{
			// Only create tabs for enabled recording options
			if (lootRecorderPlugin.isBeingRecorded(tab.getName()))
			{
				createTab(tab);
			}
		}

		// Refresh Panel Button
		JButton refresh = new JButton("Refresh All Panels");
		refresh.addActionListener(e ->
				refreshPanel(panel));

		// Add to Panel
		panel.add(tabsPanel);
		panel.add(refresh);
	}

	private LootPanel createLootPanel(Tab tab)
	{
		// Grab Tab Data
		ArrayList<LootEntry> data = lootRecorderPlugin.getData(tab.getName());
		// Unique Items Info
		ArrayList<UniqueItem> list = UniqueItem.getByActivityName(tab.getName());
		Map<Integer, ArrayList<UniqueItem>> sets = UniqueItem.createPositionSetMap(list);
		// Create & Return Loot Panel
		return new LootPanel(data, sets, itemManager);
	}

	private void refreshPanel(LootRecorderPanel panel)
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
	}

	private void refreshLootPanel(LootPanel lootPanel, Tab tab)
	{
		// Refresh data for necessary tab
		lootRecorderPlugin.loadTabData(tab.getName());
		// Recreate the loot panel
		lootPanel.refreshPanel();
		// Ensure changes are applied
		this.revalidate();
		this.repaint();
	}

	private void createTab(Tab tab)
	{
		// Container Panel for this tab
		JPanel tabPanel = new JPanel();
		tabPanel.setLayout(new BoxLayout(tabPanel, BoxLayout.Y_AXIS));
		tabPanel.setBorder(new EmptyBorder(2, 2, 2, 2));

		// Button Container
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		buttons.setBorder(new EmptyBorder(0, 0, 4, 0));

		// Loot Panel
		LootPanel lootPanel = createLootPanel(tab);

		// Scrolling Ability for lootPanel
		JPanel wrapped = new JPanel(new BorderLayout());
		wrapped.add(lootPanel, BorderLayout.NORTH);
		JScrollPane scroller = new JScrollPane(wrapped);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.getVerticalScrollBar().setUnitIncrement(16);


		// Refresh Button
		JButton refresh = new JButton("Refresh Data");
		refresh.addActionListener(e ->
				refreshLootPanel(lootPanel, tab));
		buttons.add(refresh);

		// Add components to Tab Panel
		tabPanel.add(buttons);
		tabPanel.add(scroller);

		// Add new tab to panel
		int tabIndex = adjustTabIndex(tabsPanel.getTabCount(), tab.getIndex());
		tabsPanel.insertTab(null, null, tabPanel, tab.getName(), tabIndex);

		// Add Tab Icon
		AsyncBufferedImage icon = itemManager.getImage(tab.getItemID());
		Runnable resize = () ->
				tabsPanel.setIconAt(tabIndex, new ImageIcon(icon.getScaledInstance(24, 21, Image.SCALE_SMOOTH)));
		icon.onChanged(resize);
		resize.run();

		tabsMap.put(tab.getName().toUpperCase(), tabPanel);
		lootMap.put(tab.getName().toUpperCase(), lootPanel);
	}

	private int adjustTabIndex(int total, int tabIndex)
	{
		if (total < tabIndex)
		{
			return total;
		}
		return tabIndex;
	}

	private void removeTab(Tab tab)
	{
		JPanel panel = tabsMap.get(tab.getName().toUpperCase());

		panel.getParent().remove(panel);
	}

	void updateTab(String tabName)
	{
		// Reload data from file to ensure data and UI match
		lootRecorderPlugin.loadTabData(tabName);
		// Grab LootPanel that needs to be updated
		LootPanel p = lootMap.get(tabName.toUpperCase());
		// Invoke Later to ensure EDT thread
		SwingUtilities.invokeLater(() -> p.updateRecords(lootRecorderPlugin.getData(tabName)));
	}

	void toggleTab(String tabName, Boolean status)
	{
		Tab tab = Tab.getByName(tabName);
		if (status)
		{
			createTab(tab);
		}
		else
		{
			removeTab(tab);
		}
	}
}