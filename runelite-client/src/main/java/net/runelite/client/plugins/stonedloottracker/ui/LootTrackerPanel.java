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
package net.runelite.client.plugins.stonedloottracker.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
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
import net.runelite.client.plugins.stonedloottracker.StonedLootTrackerPlugin;
import net.runelite.client.plugins.stonedloottracker.data.LootRecordCustom;
import net.runelite.client.plugins.stonedloottracker.data.UniqueItem;
import net.runelite.client.plugins.stonedloottracker.data.UniqueItemPrepared;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;

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
		BufferedImage i1;
		BufferedImage i2;
		BufferedImage i3;
		BufferedImage i4;
		try
		{
			synchronized (ImageIO.class)
			{
				i1 = ImageIO.read(StonedLootTrackerPlugin.class.getResourceAsStream("delete-white.png"));
				i2 = ImageIO.read(StonedLootTrackerPlugin.class.getResourceAsStream("refresh-white.png"));
				i3 = ImageIO.read(StonedLootTrackerPlugin.class.getResourceAsStream("back-arrow-white.png"));
				i4 = ImageIO.read(StonedLootTrackerPlugin.class.getResourceAsStream("replay-white.png"));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		ICON_DELETE = i1;
		ICON_REFRESH = i2;
		ICON_BACK = i3;
		ICON_REPLAY = i4;
	}

	// NPC name for current view or null if on selection screen
	private String currentView = null;
	private LootPanel lootPanel;

	private final ItemManager itemManager;
	private final StonedLootTrackerPlugin plugin;

	public LootTrackerPanel(final ItemManager itemManager, StonedLootTrackerPlugin plugin)
	{
		super(false);
		this.itemManager = itemManager;
		this.plugin = plugin;

		this.setBackground(ColorScheme.DARK_GRAY_COLOR);
		this.setLayout(new BorderLayout());

		showSelectionView();
	}

	// Loot Selection view
	private void showSelectionView()
	{
		this.removeAll();
		currentView = null;
		lootPanel = null;

		PluginErrorPanel errorPanel = new PluginErrorPanel();
		errorPanel.setBorder(new EmptyBorder(10, 25, 10, 25));
		errorPanel.setContent("Stoned Loot Tracker", "Please select the Activity, Player, or NPC you wish to view loot for");

		SelectionPanel selection = new SelectionPanel(plugin.config.bossButtons(), plugin.getNames(), this, itemManager);

		this.add(errorPanel, BorderLayout.NORTH);
		this.add(wrapContainer(selection), BorderLayout.CENTER);

		this.revalidate();
		this.repaint();
	}

	// Loot breakdown view
	void showLootView(String name)
	{
		this.removeAll();
		currentView = name;

		Collection<LootRecordCustom> data = plugin.getDataByName(name);

		// Grab all Uniques for this NPC/Activity
		Collection<UniqueItemPrepared> uniques = plugin.getUniques(name);
		if (uniques == null)
		{
			uniques = new ArrayList<>();
		}

		JPanel title = createLootViewTitle(name);
		lootPanel = new LootPanel(data, UniqueItem.createPositionSetMap(uniques), plugin.config.hideUniques(), plugin.config.itemSortType(), plugin.config.itemBreakdown(), itemManager);

		this.add(title, BorderLayout.NORTH);
		this.add(wrapContainer(lootPanel), BorderLayout.CENTER);

		this.revalidate();
		this.repaint();
	}

	private LootTrackerBox createLootTrackerBox(LootRecordCustom r)
	{
		final String subTitle = r.getLevel() > -1 ? "(lvl-" + r.getLevel() + ")" : "";
		return new LootTrackerBox(itemManager, r.getName(), subTitle, r);
	}

	// Title element for Loot breakdown view
	private JPanel createLootViewTitle(String name)
	{
		JPanel title = new JPanel();
		title.setBorder(new CompoundBorder(
			new EmptyBorder(10, 8, 8, 8),
			new MatteBorder(0, 0, 1, 0, Color.GRAY)
		));
		title.setLayout(new BorderLayout());
		title.setBackground(BACKGROUND_COLOR);

		JPanel first = new JPanel();
		first.setBackground(BACKGROUND_COLOR);

		// Back Button
		JLabel back = createIconLabel(ICON_BACK);
		back.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				showSelectionView();
			}
		});

		// Plugin Name
		JLabel text = new JLabel(name);
		text.setForeground(Color.WHITE);

		first.add(back);
		first.add(text);

		JPanel second = new JPanel();
		second.setBackground(BACKGROUND_COLOR);

		// Refresh Data button
		JLabel refresh = createIconLabel(ICON_REFRESH);
		refresh.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				refreshLootView(name);
			}
		});
		refresh.setToolTipText("Refresh panel");

		// Clear data button
		JLabel clear = createIconLabel(ICON_DELETE);
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
		JLabel replay = createIconLabel(ICON_REPLAY);
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

	private JLabel createIconLabel(BufferedImage icon)
	{
		JLabel label = new JLabel();
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
	private JScrollPane wrapContainer(JPanel container)
	{
		JPanel wrapped = new JPanel(new BorderLayout());
		wrapped.add(container, BorderLayout.NORTH);
		wrapped.setBackground(BACKGROUND_COLOR);

		JScrollPane scroller = new JScrollPane(wrapped);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
		scroller.setBackground(BACKGROUND_COLOR);

		return scroller;
	}

	// Clear stored data and return to selection screen
	private void clearData(String name)
	{
		// Confirm delete action
		int delete = JOptionPane.showConfirmDialog(this.getRootPane(), "<html>Are you sure you want to clear all data for this tab?<br/>There is no way to undo this action.</html>", "Warning", JOptionPane.YES_NO_OPTION);
		if (delete == JOptionPane.YES_OPTION)
		{
			plugin.clearStoredDataByName(name);

			// Return to selection screen
			showSelectionView();
		}
	}

	public void addLog(LootRecordCustom r)
	{
		if (currentView == null)
		{
			showLootView(r.getName());
		}
		else if (currentView.equals(r.getName()))
		{
			//lootPanel.addedRecord(r);
			lootPanel.addedRecord();
		}
	}

	// Refresh panel when writer playerFolder is updated
	public void updateNames()
	{
		if (currentView == null)
		{
			showSelectionView();
		}
		else
		{
			showLootView(currentView);
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

	private void refreshLootView(String name)
	{
		plugin.refreshDataByName(name);
		showLootView(name); // Recreate the entire panel
	}

	private void playbackLoot()
	{
		if (lootPanel == null)
		{
			return;
		}

		if (lootPanel.isPlaybackPlaying())
		{
			lootPanel.cancelPlayback();
			return;
		}

		ScheduledExecutorService ex = Executors.newSingleThreadScheduledExecutor();
		if (currentView != null)
		{
			ex.schedule(lootPanel::playback, 0, TimeUnit.SECONDS);
		}
	}
}