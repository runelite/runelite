/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.stonedtracker.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.loottracker.localstorage.LTRecord;
import net.runelite.client.plugins.stonedtracker.StonedTrackerPlugin;
import net.runelite.client.plugins.stonedtracker.data.UniqueItem;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.ImageUtil;

@Slf4j
public class LootTrackerPanel extends PluginPanel
{
	private static final BufferedImage ICON_DELETE;
	private static final BufferedImage ICON_REFRESH;
	private static final BufferedImage ICON_BACK;
	private static final BufferedImage ICON_REPLAY;

	private final static Color BACKGROUND_COLOR = ColorScheme.DARK_GRAY_COLOR;
	private final static Color BUTTON_HOVER_COLOR = ColorScheme.DARKER_GRAY_HOVER_COLOR;

	static
	{
		ICON_DELETE = ImageUtil.getResourceStreamFromClass(StonedTrackerPlugin.class, "delete-white.png");
		ICON_REFRESH = ImageUtil.getResourceStreamFromClass(StonedTrackerPlugin.class, "refresh-white.png");
		ICON_BACK = ImageUtil.getResourceStreamFromClass(StonedTrackerPlugin.class, "back-arrow-white.png");
		ICON_REPLAY = ImageUtil.getResourceStreamFromClass(StonedTrackerPlugin.class, "replay-white.png");
	}

	private final ItemManager itemManager;
	private final StonedTrackerPlugin plugin;

	// NPC name for current view or null if on selection screen
	private String currentView = null;
	private LootPanel lootPanel;

	public LootTrackerPanel(final ItemManager itemManager, final StonedTrackerPlugin plugin)
	{
		super(false);
		this.itemManager = itemManager;
		this.plugin = plugin;

		this.setBackground(ColorScheme.DARK_GRAY_COLOR);
		this.setLayout(new BorderLayout());

		showSelectionView();
	}

	// Loot Selection view
	public void showSelectionView()
	{
		this.removeAll();
		currentView = null;
		lootPanel = null;

		final PluginErrorPanel errorPanel = new PluginErrorPanel();
		errorPanel.setBorder(new EmptyBorder(10, 25, 10, 25));
		errorPanel.setContent("Loot Tracker", "Please select the Activity, Player, or NPC you wish to view loot for");

		final SelectionPanel selection = new SelectionPanel(plugin.config.bossButtons(), plugin.getLootNames(), this, itemManager);

		this.add(errorPanel, BorderLayout.NORTH);
		this.add(wrapContainer(selection), BorderLayout.CENTER);

		this.revalidate();
		this.repaint();
	}

	// Loot breakdown view
	public void showLootView(final String name)
	{
		this.removeAll();
		currentView = name;

		final Collection<LTRecord> data = plugin.getDataByName(name);

		// Grab all Uniques for this NPC/Activity
		Collection<UniqueItem> uniques = UniqueItem.getUniquesForBoss(name);
		if (uniques == null)
		{
			uniques = new ArrayList<>();
		}

		uniques = uniques.stream().sorted(Comparator.comparingInt(UniqueItem::getPosition)).collect(Collectors.toList());

		final JPanel title = createLootViewTitle(name);
		lootPanel = new LootPanel(name, data, uniques, plugin.config.hideUniques(), plugin.config.itemSortType(), plugin.config.itemBreakdown(), itemManager);

		this.add(title, BorderLayout.NORTH);
		this.add(wrapContainer(lootPanel), BorderLayout.CENTER);

		this.revalidate();
		this.repaint();
	}

	// Title element for Loot breakdown view
	private JPanel createLootViewTitle(final String name)
	{
		final JPanel title = new JPanel();
		title.setBorder(new CompoundBorder(
			new EmptyBorder(10, 8, 8, 8),
			new MatteBorder(0, 0, 1, 0, Color.GRAY)
		));
		title.setLayout(new BorderLayout());
		title.setBackground(BACKGROUND_COLOR);

		final JPanel first = new JPanel();
		first.setBackground(BACKGROUND_COLOR);

		// Back Button
		final JLabel back = createIconLabel(ICON_BACK);
		back.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				showSelectionView();
			}
		});
		back.setToolTipText("Back to selection screen");

		final JLabel text = new JLabel(name);
		text.setForeground(Color.WHITE);

		first.add(back);
		first.add(text);

		final JPanel second = new JPanel();
		second.setBackground(BACKGROUND_COLOR);

		// Refresh Data button
		final JLabel refresh = createIconLabel(ICON_REFRESH);
		refresh.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				showLootView(name);
			}
		});
		refresh.setToolTipText("Refresh panel");

		// Clear data button
		final JLabel clear = createIconLabel(ICON_DELETE);
		clear.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				clearData(name);
			}
		});
		clear.setToolTipText("Clear stored data");

		// Clear data button
		final JLabel replay = createIconLabel(ICON_REPLAY);
		replay.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				playbackLoot();
			}
		});
		replay.setToolTipText("Replay Loot");

		second.add(refresh);
		second.add(clear);
		second.add(replay);

		title.add(first, BorderLayout.WEST);
		title.add(second, BorderLayout.EAST);

		return title;
	}

	private JLabel createIconLabel(final BufferedImage icon)
	{
		final JLabel label = new JLabel();
		label.setIcon(new ImageIcon(icon));
		label.setOpaque(true);
		label.setBackground(BACKGROUND_COLOR);

		label.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				label.setBackground(BUTTON_HOVER_COLOR);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				label.setBackground(BACKGROUND_COLOR);
			}
		});

		return label;
	}

	// Wrap the panel inside a scroll pane
	private JScrollPane wrapContainer(final JPanel container)
	{
		final JPanel wrapped = new JPanel(new BorderLayout());
		wrapped.add(container, BorderLayout.NORTH);
		wrapped.setBackground(BACKGROUND_COLOR);

		final JScrollPane scroller = new JScrollPane(wrapped);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
		scroller.setBackground(BACKGROUND_COLOR);

		return scroller;
	}

	// Clear stored data and return to selection screen
	private void clearData(final String name)
	{
		// Confirm delete action
		final int delete = JOptionPane.showConfirmDialog(this.getRootPane(), "<html>Are you sure you want to clear all data for this tab?<br/>There is no way to undo this action.</html>", "Warning", JOptionPane.YES_NO_OPTION);
		if (delete == JOptionPane.YES_OPTION)
		{
			boolean deleted = plugin.clearStoredDataByName(name);
			if (!deleted)
			{
				JOptionPane.showMessageDialog(this.getRootPane(), "Unable to clear stored data, please try again.");
				return;
			}

			// Return to selection screen
			showSelectionView();
		}
	}

	public void addLog(final LTRecord r)
	{
		if (currentView == null)
		{
			showLootView(r.getName());
		}
		else if (currentView.equalsIgnoreCase(r.getName()))
		{
			lootPanel.addedRecord(r);
		}
	}

	// Refresh panel when config options are changed
	public void refreshUI()
	{
		log.debug("Refreshing UI");
		if (currentView == null)
		{
			showSelectionView();
		}
		else
		{
			showLootView(currentView);
		}
	}

	private void playbackLoot()
	{
		if (lootPanel == null)
		{
			return;
		}

		// Create a new thread for this so it doesn't cause swing freezes
		final ScheduledExecutorService ex = Executors.newSingleThreadScheduledExecutor();
		if (currentView != null)
		{
			ex.schedule(lootPanel::playback, 0, TimeUnit.SECONDS);
		}
	}
}