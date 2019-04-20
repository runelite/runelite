/*
 * Copyright (c) 2018, Psikoi <https://github.com/Psikoi>
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
package net.runelite.client.plugins.worldhopper;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.stream.Collectors;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Setter;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.PluginPanel;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldType;

@Slf4j
class WorldSwitcherPanel extends PluginPanel
{
	private static final Color ODD_ROW = new Color(44, 44, 44);

	private static final int WORLD_COLUMN_WIDTH = 60;
	private static final int PLAYERS_COLUMN_WIDTH = 40;
	private static final int PING_COLUMN_WIDTH = 47;

	private final JPanel headerContainer;
	private final JPanel headerHistContainer;
	private final JPanel listContainer = new JPanel();
	private final JPanel histContainer = new JPanel();

	private WorldTableHeader worldHeader;
	private WorldTableHeader playersHeader;
	private WorldTableHeader activityHeader;
	private WorldTableHeader pingHeader;

	private WorldOrder orderIndex = WorldOrder.WORLD;
	private boolean ascendingOrder = true;

	private ArrayList<WorldTableRow> rows = new ArrayList<>();
	private ArrayList<WorldTableRow> histRows = new ArrayList<>();
	private WorldHopperPlugin plugin;
	@Setter(AccessLevel.PACKAGE)
	private SubscriptionFilterMode filterMode;

	WorldSwitcherPanel(WorldHopperPlugin plugin)
	{
		this.plugin = plugin;

		setBorder(null);
		setLayout(new DynamicGridLayout(0, 1));

		headerContainer = buildHeader();
		headerHistContainer = buildHistoryHeader();

		listContainer.setLayout(new GridLayout(0, 1));
		histContainer.setLayout(new GridLayout(0, 1));

		updateLayout();
	}

	void updateLayout()
	{
		if (this.getComponentCount() > 0)
		{
			for (Component c : this.getComponents())
			{
				this.remove(c);
			}
		}

		if (plugin.showHistory())
		{
			Component tabs = createTabs();
			add(tabs);
		}
		else
		{
			add(headerContainer);
			add(listContainer);
		}
	}

	void switchCurrentHighlight(int newWorld, int lastWorld)
	{
		for (WorldTableRow row : rows)
		{
			if (row.getWorld().getId() == newWorld)
			{
				row.recolour(true);
			}
			else if (row.getWorld().getId() == lastWorld)
			{
				row.recolour(false);
			}
		}

		for (WorldTableRow row : histRows)
		{
			if (row.getWorld().getId() == newWorld)
			{
				row.recolour(true);
			}
			else if (row.getWorld().getId() == lastWorld)
			{
				row.recolour(false);
			}
		}
	}

	void updateListData(Map<Integer, Integer> worldData)
	{
		for (WorldTableRow worldTableRow : rows)
		{
			World world = worldTableRow.getWorld();
			Integer playerCount = worldData.get(world.getId());
			if (playerCount != null)
			{
				worldTableRow.updatePlayerCount(playerCount);
			}
		}

		for (WorldTableRow worldTableRow : histRows)
		{
			World world = worldTableRow.getWorld();
			Integer playerCount = worldData.get(world.getId());
			if (playerCount != null)
			{
				worldTableRow.updatePlayerCount(playerCount);
			}
		}

		// If the list is being ordered by player count, then it has to be re-painted
		// to properly display the new data
		if (orderIndex == WorldOrder.PLAYERS)
		{
			updateList();
		}
	}

	void updatePing(int world, int ping)
	{
		for (WorldTableRow worldTableRow : rows)
		{
			if (worldTableRow.getWorld().getId() == world)
			{
				worldTableRow.setPing(ping);

				// If the panel is sorted by ping, re-sort it
				if (orderIndex == WorldOrder.PING)
				{
					updateList();
				}
				break;
			}
		}

		for (WorldTableRow worldTableRow : histRows)
		{
			if (worldTableRow.getWorld().getId() == world)
			{
				worldTableRow.setPing(ping);

				// If the panel is sorted by ping, re-sort it
				if (orderIndex == WorldOrder.PING)
				{
					updateList();
				}
				break;
			}
		}
	}

	void hidePing()
	{
		for (WorldTableRow worldTableRow : rows)
		{
			worldTableRow.hidePing();
		}

		for (WorldTableRow worldTableRow : histRows)
		{
			worldTableRow.hidePing();
		}
	}

	void showPing()
	{
		for (WorldTableRow worldTableRow : rows)
		{
			worldTableRow.showPing();
		}

		for (WorldTableRow worldTableRow : histRows)
		{
			worldTableRow.showPing();
		}
	}

	void updateList()
	{
		rows.sort((r1, r2) ->
		{
			switch (orderIndex)
			{
				case PING:
					return Integer.compare(r1.getPing(), r2.getPing()) * (ascendingOrder ? 1 : -1);
				case WORLD:
					return Integer.compare(r1.getWorld().getId(), r2.getWorld().getId()) * (ascendingOrder ? 1 : -1);
				case PLAYERS:
					return Integer.compare(r1.getUpdatedPlayerCount(), r2.getUpdatedPlayerCount()) * (ascendingOrder ? 1 : -1);
				case ACTIVITY:
					return r1.getWorld().getActivity().compareTo(r2.getWorld().getActivity()) * -1 * (ascendingOrder ? 1 : -1);
				default:
					return 0;
			}
		});

		// Leave empty activity worlds on the bottom of the list
		if (orderIndex == WorldOrder.ACTIVITY)
		{
			rows.sort((r1, r2) -> r1.getWorld().getActivity().equals("-") ? 1 : -1);
		}

		rows.sort((r1, r2) ->
		{
			boolean b1 = plugin.isFavorite(r1.getWorld());
			boolean b2 = plugin.isFavorite(r2.getWorld());
			return Boolean.compare(b2, b1);
		});

		listContainer.removeAll();
		histContainer.removeAll();

		Map<String, String> history = plugin.getHistory();
		Map<String, String> matchedHist = new HashMap<>();
		for (int i = 0; i < rows.size(); i++)
		{
			WorldTableRow row = rows.get(i);
			row.setBackground(i % 2 == 0 ? ODD_ROW : ColorScheme.DARK_GRAY_COLOR);
			listContainer.add(row);

			String worldNum = String.valueOf(row.getWorld().getId());
			if (history.containsKey(worldNum))
			{
				// Add toa  list that we can sort later
				matchedHist.put(worldNum, history.get(worldNum));
			}
		}

		// Sort by ascending
		matchedHist = matchedHist.entrySet().stream()
				.sorted(Map.Entry.<String, String>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		// Add matched rows to history list
		Iterator it = matchedHist.entrySet().iterator();
		int histRowCount = 0;
		while (it.hasNext())
		{
			Map.Entry pair = (Map.Entry)it.next();
			for (WorldTableRow r : rows)
			{
				WorldTableRow histRow = r;
				histRow.setBackground(histRowCount % 2 == 0 ? ODD_ROW : ColorScheme.DARK_GRAY_COLOR);
				if (String.valueOf(r.getWorld().getId()).equals(pair.getKey()))
				{
					histContainer.add(r);
					histRowCount++;
					break;
				}
			}
			it.remove();
		}

		listContainer.revalidate();
		listContainer.repaint();
		histContainer.revalidate();
		histContainer.repaint();
	}

	Component createTabs()
	{
		// Constraints for GB Layout
		GridBagConstraints listConst = new GridBagConstraints();
		listConst.gridx = 0;
		listConst.gridy = 1;
		listConst.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints headConst = new GridBagConstraints();
		headConst.gridx = 0;
		headConst.gridy = 0;
		headConst.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints resetConst = new GridBagConstraints();
		resetConst.gridx = 0;
		resetConst.gridy = 2;
		resetConst.fill = GridBagConstraints.HORIZONTAL;

		// Border so that the scrollbar doesn't go over ping
		Border paddingBorder = BorderFactory.createEmptyBorder(0, 0, 0, 5);

		// Clear history button
		JButton resetBtn = new JButton("Clear History");
		resetBtn.addActionListener(e ->
		{
			plugin.clearHistory();
			plugin.addToHistory();
			updateList();
		});

		// World Selector page
		JPanel worldPanel = new JPanel();
		worldPanel.setBorder(paddingBorder);
		worldPanel.setLayout(new GridBagLayout());
		worldPanel.add(headerContainer, headConst);
		worldPanel.add(listContainer, listConst);

		// History page
		JPanel histPanel = new JPanel();
		histPanel.setBorder(paddingBorder);
		histPanel.setLayout(new GridBagLayout());
		histPanel.add(headerHistContainer, headConst);
		histPanel.add(histContainer, listConst);
		histPanel.add(resetBtn, resetConst);

		JTabbedPane worldTabs = new JTabbedPane();
		worldTabs.setName("tabs");
		worldTabs.addTab("Worlds", worldPanel);
		worldTabs.addTab("History", histPanel);

		// This is a fix for preventing stretching of WorldTableRows
		worldTabs.addChangeListener(e ->
		{
			switch (worldTabs.getSelectedIndex())
			{
				case 0:
					histPanel.remove(histContainer);
					if (worldPanel.getComponentCount() < 2)
					{
						worldPanel.add(listContainer, listConst);
					}
					break;
				case 1:
					worldPanel.remove(listContainer);
					if (histPanel.getComponentCount() < 3)
					{
						histPanel.add(histContainer, listConst);
					}
					break;
			}
		});

		return worldTabs;
	}

	void updateFavoriteMenu(int world, boolean favorite)
	{
		for (WorldTableRow row : rows)
		{
			if (row.getWorld().getId() == world)
			{
				row.setFavoriteMenu(favorite);
			}
		}

		for (WorldTableRow row : histRows)
		{
			if (row.getWorld().getId() == world)
			{
				row.setFavoriteMenu(favorite);
			}
		}
	}

	void resetAllFavoriteMenus()
	{
		for (WorldTableRow row : rows)
		{
			row.setFavoriteMenu(false);
		}

		for (WorldTableRow row : histRows)
		{
			row.setFavoriteMenu(false);
		}
	}

	void populate(List<World> worlds)
	{
		rows.clear();

		for (int i = 0; i < worlds.size(); i++)
		{
			World world = worlds.get(i);

			switch (filterMode)
			{
				case FREE:
					if (world.getTypes().contains(WorldType.MEMBERS))
					{
						continue;
					}
					break;
				case MEMBERS:
					if (!world.getTypes().contains(WorldType.MEMBERS))
					{
						continue;
					}
					break;
			}

			rows.add(buildRow(world, i % 2 == 0, world.getId() == plugin.getCurrentWorld() && plugin.getLastWorld() != 0, plugin.isFavorite(world)));
		}

		updateList();
	}

	private void orderBy(WorldOrder order)
	{
		pingHeader.highlight(false, ascendingOrder);
		worldHeader.highlight(false, ascendingOrder);
		playersHeader.highlight(false, ascendingOrder);
		activityHeader.highlight(false, ascendingOrder);

		switch (order)
		{
			case PING:
				pingHeader.highlight(true, ascendingOrder);
				break;
			case WORLD:
				worldHeader.highlight(true, ascendingOrder);
				break;
			case PLAYERS:
				playersHeader.highlight(true, ascendingOrder);
				break;
			case ACTIVITY:
				activityHeader.highlight(true, ascendingOrder);
				break;
		}

		orderIndex = order;
		updateList();
	}

	/**
	 * Builds the entire table header.
	 */
	private JPanel buildHistoryHeader()
	{
		JPanel header = new JPanel(new BorderLayout());
		JPanel leftSide = new JPanel(new BorderLayout());
		JPanel rightSide = new JPanel(new BorderLayout());

		WorldTableHeader pingHeader = new WorldTableHeader("Ping", false, ascendingOrder, plugin::refresh);
		pingHeader.setPreferredSize(new Dimension(PING_COLUMN_WIDTH, 0));

		WorldTableHeader worldHeader = new WorldTableHeader("World", false, ascendingOrder, plugin::refresh);
		worldHeader.setPreferredSize(new Dimension(WORLD_COLUMN_WIDTH, 0));

		WorldTableHeader playersHeader = new WorldTableHeader("#", false, ascendingOrder, plugin::refresh);
		playersHeader.setPreferredSize(new Dimension(PLAYERS_COLUMN_WIDTH, 0));

		WorldTableHeader activityHeader = new WorldTableHeader("Activity", false, ascendingOrder, plugin::refresh);

		leftSide.add(worldHeader, BorderLayout.WEST);
		leftSide.add(playersHeader, BorderLayout.CENTER);

		rightSide.add(activityHeader, BorderLayout.CENTER);
		rightSide.add(pingHeader, BorderLayout.EAST);

		header.add(leftSide, BorderLayout.WEST);
		header.add(rightSide, BorderLayout.CENTER);

		return header;
	}

	private JPanel buildHeader()
	{
		JPanel header = new JPanel(new BorderLayout());
		JPanel leftSide = new JPanel(new BorderLayout());
		JPanel rightSide = new JPanel(new BorderLayout());

		pingHeader = new WorldTableHeader("Ping", orderIndex == WorldOrder.PING, ascendingOrder, plugin::refresh);
		pingHeader.setPreferredSize(new Dimension(PING_COLUMN_WIDTH, 0));
		pingHeader.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				if (SwingUtilities.isRightMouseButton(mouseEvent))
				{
					return;
				}
				ascendingOrder = orderIndex != WorldOrder.PING || !ascendingOrder;
				orderBy(WorldOrder.PING);
			}
		});

		worldHeader = new WorldTableHeader("World", orderIndex == WorldOrder.WORLD, ascendingOrder, plugin::refresh);
		worldHeader.setPreferredSize(new Dimension(WORLD_COLUMN_WIDTH, 0));
		worldHeader.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				if (SwingUtilities.isRightMouseButton(mouseEvent))
				{
					return;
				}
				ascendingOrder = orderIndex != WorldOrder.WORLD || !ascendingOrder;
				orderBy(WorldOrder.WORLD);
			}
		});

		playersHeader = new WorldTableHeader("#", orderIndex == WorldOrder.PLAYERS, ascendingOrder, plugin::refresh);
		playersHeader.setPreferredSize(new Dimension(PLAYERS_COLUMN_WIDTH, 0));
		playersHeader.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				if (SwingUtilities.isRightMouseButton(mouseEvent))
				{
					return;
				}
				ascendingOrder = orderIndex != WorldOrder.PLAYERS || !ascendingOrder;
				orderBy(WorldOrder.PLAYERS);
			}
		});

		activityHeader = new WorldTableHeader("Activity", orderIndex == WorldOrder.ACTIVITY, ascendingOrder, plugin::refresh);
		activityHeader.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				if (SwingUtilities.isRightMouseButton(mouseEvent))
				{
					return;
				}
				ascendingOrder = orderIndex != WorldOrder.ACTIVITY || !ascendingOrder;
				orderBy(WorldOrder.ACTIVITY);
			}
		});

		leftSide.add(worldHeader, BorderLayout.WEST);
		leftSide.add(playersHeader, BorderLayout.CENTER);

		rightSide.add(activityHeader, BorderLayout.CENTER);
		rightSide.add(pingHeader, BorderLayout.EAST);

		header.add(leftSide, BorderLayout.WEST);
		header.add(rightSide, BorderLayout.CENTER);

		return header;
	}

	/**
	 * Builds a table row, that displays the world's information.
	 */
	private WorldTableRow buildRow(World world, boolean stripe, boolean current, boolean favorite)
	{
		WorldTableRow row = new WorldTableRow(world, current, favorite,
				world1 ->
				{
					plugin.hopTo(world1);
				},
				(world12, add) ->
				{
					if (add)
					{
						plugin.addToFavorites(world12);
					}
					else
					{
						plugin.removeFromFavorites(world12);
					}

					updateList();
				}
		);
		row.setBackground(stripe ? ODD_ROW : ColorScheme.DARK_GRAY_COLOR);
		return row;
	}

	/**
	 * Enumerates the multiple ordering options for the world list.
	 */
	private enum WorldOrder
	{
		WORLD,
		PLAYERS,
		ACTIVITY,
		PING
	}
}
