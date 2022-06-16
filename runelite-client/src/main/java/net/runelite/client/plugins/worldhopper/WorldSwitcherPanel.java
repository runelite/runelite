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

import com.google.common.collect.Ordering;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldType;

class WorldSwitcherPanel extends PluginPanel
{
	private static final Color ODD_ROW = new Color(44, 44, 44);

	private static final int WORLD_COLUMN_WIDTH = 60;
	private static final int PLAYERS_COLUMN_WIDTH = 40;
	private static final int PING_COLUMN_WIDTH = 47;

	private final JPanel favoriteWorldsContainer = new JPanel(new BorderLayout());
	private final JPanel favoriteWorldsList = new JPanel();
	private final JPanel worldsList = new JPanel();

	private final List<WorldTableHeader> worldHeaders = new ArrayList<>();
	private final List<WorldTableHeader> playersHeaders = new ArrayList<>();
	private final List<WorldTableHeader> activityHeaders = new ArrayList<>();
	private final List<WorldTableHeader> pingHeaders = new ArrayList<>();

	private WorldOrder orderIndex = WorldOrder.WORLD;
	private boolean ascendingOrder = true;

	private final ArrayList<WorldTableRow> rows = new ArrayList<>();
	private final transient WorldHopperPlugin plugin;
	@Setter(AccessLevel.PACKAGE)
	private SubscriptionFilterMode subscriptionFilterMode;
	@Setter(AccessLevel.PACKAGE)
	private Set<RegionFilterMode> regionFilterMode;

	WorldSwitcherPanel(WorldHopperPlugin plugin)
	{
		super(false);

		this.plugin = plugin;

		setBorder(null);
		setLayout(new BorderLayout());

		favoriteWorldsList.setLayout(new GridLayout(0, 1));
		worldsList.setLayout(new GridLayout(0, 1));

		JPanel wrappedFavoriteWorldsList = new FixedWidthPanel();
		wrappedFavoriteWorldsList.setLayout(new BorderLayout());
		wrappedFavoriteWorldsList.add(favoriteWorldsList, BorderLayout.NORTH);

		JScrollPane favoriteWorldsScrollPane = new JScrollPane(wrappedFavoriteWorldsList);
		favoriteWorldsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JPanel wrappedWorldsList = new FixedWidthPanel();
		wrappedWorldsList.setLayout(new BorderLayout());
		wrappedWorldsList.add(worldsList, BorderLayout.NORTH);

		JScrollPane worldsScrollPane = new JScrollPane(wrappedWorldsList);
		worldsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		favoriteWorldsContainer.setBorder(new EmptyBorder(0, 0, 12, 0));
		favoriteWorldsContainer.add(buildHeader(), BorderLayout.NORTH);
		favoriteWorldsContainer.add(favoriteWorldsScrollPane, BorderLayout.CENTER);

		JPanel worldsContainer = new JPanel(new BorderLayout());
		worldsContainer.add(buildHeader(), BorderLayout.NORTH);
		worldsContainer.add(worldsScrollPane, BorderLayout.CENTER);

		add(favoriteWorldsContainer, BorderLayout.NORTH);
		add(worldsContainer, BorderLayout.CENTER);
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
	}

	void hidePing()
	{
		for (WorldTableRow worldTableRow : rows)
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
	}

	void updateList()
	{
		rows.sort((r1, r2) ->
		{
			switch (orderIndex)
			{
				case PING:
					// Leave worlds with unknown ping at the bottom
					return getCompareValue(r1, r2, row ->
					{
						int ping = row.getPing();
						return ping > 0 ? ping : null;
					});
				case WORLD:
					return getCompareValue(r1, r2, row -> row.getWorld().getId());
				case PLAYERS:
					return getCompareValue(r1, r2, WorldTableRow::getUpdatedPlayerCount);
				case ACTIVITY:
					// Leave empty activity worlds on the bottom of the list
					return getCompareValue(r1, r2, row ->
					{
						String activity = row.getWorld().getActivity();
						return !activity.equals("-") ? activity : null;
					});
				default:
					return 0;
			}
		});

		favoriteWorldsList.removeAll();
		worldsList.removeAll();

		int worldIndex = 0;
		int favoriteWorldIndex = 0;
		for (WorldTableRow row : rows)
		{
			if (plugin.isFavorite(row.getWorld()))
			{
				row.setBackground(favoriteWorldIndex % 2 == 0 ? ODD_ROW : ColorScheme.DARK_GRAY_COLOR);
				favoriteWorldsList.add(row);
				favoriteWorldIndex++;
			}
			else
			{
				row.setBackground(worldIndex % 2 == 0 ? ODD_ROW : ColorScheme.DARK_GRAY_COLOR);
				worldsList.add(row);
				worldIndex++;
			}
		}

		if (favoriteWorldIndex == 0)
		{
			favoriteWorldsContainer.setVisible(false);
		}
		else
		{
			favoriteWorldsContainer.setVisible(true);
			favoriteWorldsContainer.setPreferredSize(new Dimension(0, Math.min(30 + favoriteWorldIndex * 26, 290)));
		}

		revalidate();
	}

	private int getCompareValue(WorldTableRow row1, WorldTableRow row2, Function<WorldTableRow, Comparable> compareByFn)
	{
		Ordering<Comparable> ordering = Ordering.natural();
		if (!ascendingOrder)
		{
			ordering = ordering.reverse();
		}
		ordering = ordering.nullsLast();
		return ordering.compare(compareByFn.apply(row1), compareByFn.apply(row2));
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
	}

	void populate(List<World> worlds)
	{
		rows.clear();

		for (int i = 0; i < worlds.size(); i++)
		{
			World world = worlds.get(i);

			switch (subscriptionFilterMode)
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

			if (!regionFilterMode.isEmpty() && !regionFilterMode.contains(RegionFilterMode.of(world.getRegion())))
			{
				continue;
			}

			rows.add(buildRow(world, i % 2 == 0, world.getId() == plugin.getCurrentWorld() && plugin.getLastWorld() != 0, plugin.isFavorite(world)));
		}

		updateList();
	}

	private void orderBy(WorldOrder order)
	{
		pingHeaders.forEach(header -> header.highlight(order == WorldOrder.PING, ascendingOrder));
		worldHeaders.forEach(header -> header.highlight(order == WorldOrder.WORLD, ascendingOrder));
		playersHeaders.forEach(header -> header.highlight(order == WorldOrder.PLAYERS, ascendingOrder));
		activityHeaders.forEach(header -> header.highlight(order == WorldOrder.ACTIVITY, ascendingOrder));

		orderIndex = order;
		updateList();
	}

	/**
	 * Builds the entire table header.
	 */
	private JPanel buildHeader()
	{
		JPanel header = new JPanel(new BorderLayout());
		JPanel leftSide = new JPanel(new BorderLayout());
		JPanel rightSide = new JPanel(new BorderLayout());

		WorldTableHeader pingHeader = new WorldTableHeader("Ping", orderIndex == WorldOrder.PING, ascendingOrder, plugin::refresh);
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
		pingHeaders.add(pingHeader);

		WorldTableHeader worldHeader = new WorldTableHeader("World", orderIndex == WorldOrder.WORLD, ascendingOrder, plugin::refresh);
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
		worldHeaders.add(worldHeader);

		WorldTableHeader playersHeader = new WorldTableHeader("#", orderIndex == WorldOrder.PLAYERS, ascendingOrder, plugin::refresh);
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
		playersHeaders.add(playersHeader);

		WorldTableHeader activityHeader = new WorldTableHeader("Activity", orderIndex == WorldOrder.ACTIVITY, ascendingOrder, plugin::refresh);
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
		activityHeaders.add(activityHeader);

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
		WorldTableRow row = new WorldTableRow(world, current, favorite, plugin.getStoredPing(world),
			plugin::hopTo,
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
