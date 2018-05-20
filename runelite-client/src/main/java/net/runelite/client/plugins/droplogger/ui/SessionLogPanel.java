/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.droplogger.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import net.runelite.api.ItemComposition;
import net.runelite.client.plugins.droplogger.DropLoggerConfig;
import net.runelite.client.plugins.droplogger.DropLoggerPlugin;
import net.runelite.client.plugins.droplogger.NpcCategorization;
import net.runelite.client.plugins.droplogger.data.EventOccurrenceCollection;
import net.runelite.client.plugins.droplogger.data.LoggedItem;
import net.runelite.client.plugins.droplogger.data.SessionLogData;
import net.runelite.client.plugins.droplogger.data.SessionNpcLog;
import net.runelite.client.plugins.droplogger.filter.DropCollectFilter;
import net.runelite.client.plugins.droplogger.filter.DropTypeFilter;
import net.runelite.client.plugins.droplogger.filter.GroupFilter;
import net.runelite.client.plugins.droplogger.filter.SessionLogsFilter;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.components.ComboBoxListRenderer;
import net.runelite.client.ui.components.RuneliteList;
import net.runelite.client.ui.components.RuneliteListItemRenderer;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class SessionLogPanel extends TabPanel
{
	private SessionLogData logData;
	private SessionLogsFilter filter;
	private DropLoggerConfig config;

	private JPanel sessionDropsPanel;
	private JList npcList;
	private DefaultListModel npcListModel;

	SessionLogPanel(DropLoggerPanel parent, SessionLogData logData,
		Map<Integer, Integer> itemPriceMap, DropLoggerPlugin plugin, DropLoggerConfig config)
	{
		super(parent, itemPriceMap);
		this.logData = logData;
		this.config = config;
		this.filter = new SessionLogsFilter();

		this.setLayout(new BorderLayout());

		JPanel dropsPanelContainer = new JPanel(new BorderLayout());
		dropsPanelContainer.setBackground(ColorScheme.DARK_GRAY_COLOR);
		JPanel dropsPanel = new JPanel(new GridBagLayout());
		dropsPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		dropsPanelContainer.add(dropsPanel, BorderLayout.NORTH);
		JScrollPane dropsScrollPane = new JScrollPane(dropsPanelContainer);
		dropsScrollPane.getVerticalScrollBar().setUnitIncrement(16);
		this.sessionDropsPanel = dropsPanel;

		updateLogIconTable(sessionDropsPanel, null, null);
		this.add(dropsScrollPane, BorderLayout.CENTER);

		JPanel filterContainer = new JPanel(new GridBagLayout());
		filterContainer.setBackground(ColorScheme.DARK_GRAY_COLOR);
		filterContainer.setVisible(false);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(4, 0, 0, 0);
		c.gridwidth = 1;

		JComboBox<String> typeComboBox = new JComboBox<>(new String[]
			{
				"PvM",
				"PvP",
				"PvM and PvP"
			});
		typeComboBox.setRenderer(new ComboBoxListRenderer());
		typeComboBox.setFocusable(false);
		typeComboBox.setPreferredSize(new Dimension(this.getWidth(), 25));
		typeComboBox.addActionListener(e ->
		{
			int index = typeComboBox.getSelectedIndex();
			filter.setDropTypeFilter(DropTypeFilter.fromIndex(index));
			parent.onLogUpdated();
		});
		filterContainer.add(typeComboBox, c);
		c.gridy++;

		JComboBox<String> collectComboBox = new JComboBox<>(new String[]
			{
				"All drops",
				"Only picked drops",
				"Drops left on ground"
			});
		collectComboBox.setRenderer(new ComboBoxListRenderer());
		collectComboBox.setFocusable(false);
		collectComboBox.setPreferredSize(new Dimension(this.getWidth(), 25));
		collectComboBox.addActionListener(e ->
		{
			int index = collectComboBox.getSelectedIndex();
			filter.setDropCollectFilter(DropCollectFilter.fromIndex(index));
			parent.onLogUpdated();
		});
		filterContainer.add(collectComboBox, c);
		c.gridy++;

		JComboBox<String> areaComboBox = new JComboBox<>(new String[]
			{
				"Id, name, level",
				"Name",
				"Name, level",
			});
		areaComboBox.setRenderer(new ComboBoxListRenderer());
		areaComboBox.setFocusable(false);
		areaComboBox.setPreferredSize(new Dimension(this.getWidth(), 25));
		areaComboBox.addActionListener(e ->
		{
			int index = areaComboBox.getSelectedIndex();
			filter.setGroupFilter(GroupFilter.fromIndex(index));
			npcListModel.clear();
			filter.getEnabledEvents().clear();
			parent.onLogUpdated();
		});
		filterContainer.add(areaComboBox, c);
		c.gridy++;

		RuneliteList eventList = new RuneliteList();
		eventList.setCellRenderer(new RuneliteListItemRenderer());
		eventList.setBackground(ColorScheme.DARK_GRAY_COLOR);
		DefaultListModel listModel = new DefaultListModel<>();
		eventList.setModel(listModel);
		this.npcList = eventList;
		this.npcListModel = listModel;
		eventList.setSelectionModel(new DefaultListSelectionModel()
		{
			@Override
			public void setSelectionInterval(int index0, int index1)
			{
				boolean shouldAdd = !this.isSelectedIndex(index1);
				int start = Math.min(index0, index1);
				int end = Math.max(index0, index1);
				for (int i = start; i <= end; i++)
				{
					if (shouldAdd)
					{
						super.addSelectionInterval(i, i);
						filter.getEnabledEvents().add((String)listModel.getElementAt(i));
						parent.onLogUpdated();
					}
					else
					{
						super.removeSelectionInterval(i, i);
						filter.getEnabledEvents().remove(listModel.getElementAt(i));
						parent.onLogUpdated();
					}
				}
			}
		});
		JScrollPane eventListScrollPane = new JScrollPane(eventList);
		eventListScrollPane.setPreferredSize(new Dimension(0, 100));
		filterContainer.add(eventListScrollPane, c);

		JPanel buttonContainer = new JPanel(new GridBagLayout());
		buttonContainer.setBackground(ColorScheme.DARK_GRAY_COLOR);
		GridBagConstraints buttonConstraints = new GridBagConstraints();
		buttonConstraints.fill = GridBagConstraints.HORIZONTAL;
		buttonConstraints.weightx = 1;
		buttonConstraints.gridx = 0;
		buttonConstraints.gridy = 0;
		buttonConstraints.anchor = GridBagConstraints.SOUTH;
		buttonConstraints.insets = new Insets(8, 0, 0, 0);
		buttonConstraints.gridwidth = 1;

		JButton filterButton = new JButton("Filter");
		filterButton.setFocusable(false);
		filterButton.addActionListener(e ->
			filterContainer.setVisible(!filterContainer.isVisible()));
		buttonContainer.add(filterButton, buttonConstraints);
		buttonConstraints.gridx++;

		buttonConstraints.insets = new Insets(0, 8, 0, 0);
		JButton resetButton = new JButton("Reset session");
		resetButton.setFocusable(false);
		resetButton.addActionListener(x ->
		{
			npcListModel.clear();
			filter.getEnabledEvents().clear();
			logData.getSessionLogs().clear();
			plugin.clearSessionDrops();
			parent.onLogUpdated();
		});
		buttonContainer.add(resetButton, buttonConstraints);

		JPanel configPanel = new JPanel(new GridBagLayout());
		configPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		GridBagConstraints configConstraints = new GridBagConstraints();
		configConstraints.fill = GridBagConstraints.HORIZONTAL;
		configConstraints.weightx = 1;
		configConstraints.gridx = 0;
		configConstraints.gridy = 0;
		configConstraints.insets = new Insets(0, 0, 0, 0);
		configPanel.add(filterContainer, configConstraints);
		configConstraints.gridy++;
		configPanel.add(buttonContainer, configConstraints);

		typeComboBox.setSelectedIndex(2);
		areaComboBox.setSelectedIndex(2);

		this.add(configPanel, BorderLayout.SOUTH);
	}

	@Override
	public void onLogShouldUpdate()
	{
		reloadDetailedLogs();
	}

	private void reloadDetailedLogs()
	{
		Map<Integer, Integer> drops = new HashMap<>();
		Map<String, EventOccurrenceCollection> events = new TreeMap<>();
		logData.getSessionLogs().forEach(x ->
		{
			String eventName = this.filter.getEventName(x);
			if (x instanceof SessionNpcLog)
			{
				int npcId = ((SessionNpcLog) x).getNpcComposition().getId();
				if ((config.hideBarbarianAssault() && NpcCategorization.isNpcInBarbarianAssault(npcId)) ||
					(config.hideChambersOfXeric() && NpcCategorization.isNpcInChambersOfXeric(npcId)))
				{
					return;
				}
			}

			EventOccurrenceCollection event = events.get(eventName);
			if (event == null)
			{
				event = new EventOccurrenceCollection(eventName);
				events.put(eventName, event);
			}

			if (this.filter.getEnabledEvents().size() > 0 &&
				!this.filter.getEnabledEvents().contains(eventName))
			{
				return;
			}

			event.addOccurrence(x.getInstant());

			Map<Integer, Integer> itemQuantityMap = filter.getFilteredItems(x);
			if (itemQuantityMap != null)
			{
				for (Map.Entry<Integer, Integer> entry : itemQuantityMap.entrySet())
				{
					int count = drops.getOrDefault(entry.getKey(), 0);
					drops.put(entry.getKey(), count + entry.getValue());
					event.setValue(event.getValue() + entry.getValue() *
						itemPriceMap.getOrDefault(entry.getKey(), 0));
				}
			}
		});

		Iterator<String> it = events.keySet().iterator();
		for (int i = 0; i < events.size(); i++)
		{
			String eventName = it.next();
			if (npcListModel.size() <= i || !eventName.equals(npcListModel.get(i)))
			{
				npcListModel.add(i, eventName);
				npcList.removeSelectionInterval(i, i);
			}
		}

		List<LoggedItem> itemList = drops.entrySet().stream()
			.collect(Collectors.groupingBy(x ->
			{
				ItemComposition unnotedItem = parent.getItemManager().getUnnotedItemComposition(x.getKey());
				return unnotedItem.getId();
			}, Collectors.summingInt(Map.Entry::getValue)))
			.entrySet().stream().map(x ->
			{
				ItemComposition item = parent.getItemManager().getItemComposition(x.getKey());
				return new LoggedItem(x.getKey(), x.getValue(), item, itemPriceMap.get(x.getKey()));
			})
			.sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
			.collect(Collectors.toList());
		List<EventOccurrenceCollection> eventList = events.entrySet().stream()
			.filter(x -> x.getValue().getCount() > 0)
			.sorted((a, b) -> (int)(b.getValue().getValue() - a.getValue().getValue()))
			.map(Map.Entry::getValue).collect(Collectors.toList());

		parent.getClientThread().invokeLater(() ->
		{
			for (LoggedItem item : itemList)
			{
				item.setImage(parent.getItemManager().getImage(item.getItemId(),
					item.getQuantity(), item.getQuantity() != 1 || item.getComposition().isStackable()));
			}

			SwingUtilities.invokeLater(() ->
			{
				// Useful code for testing the panel with many items, uncomment if you want to test it
				/*List<LoggedItem> l = new ArrayList<>();
				for (int i = 0; i < 100; i++)
				{
					int itemId = 995;
					LoggedItem item = new LoggedItem(itemId, 10000, parent.getItemManager().getItemComposition(itemId), 1);
					item.setImage(parent.getItemManager().getImage(itemId, 10000, true));
					l.add(item);
				}
				updateLogIconTable(sessionDropsPanel, eventList, l);*/

				updateLogIconTable(sessionDropsPanel, eventList, itemList);
				this.parent.repaint();
			});
		});
	}
}