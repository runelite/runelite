/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.loottracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.GameState;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.loottracker.LootTrackerClient;

@Slf4j
@Singleton
class LootTrackerPanel extends PluginPanel
{
	private static final int MAX_LOOT_BOXES = 500;

	private static final ImageIcon SINGLE_LOOT_VIEW;
	private static final ImageIcon SINGLE_LOOT_VIEW_FADED;
	private static final ImageIcon SINGLE_LOOT_VIEW_HOVER;
	private static final ImageIcon GROUPED_LOOT_VIEW;
	private static final ImageIcon GROUPED_LOOT_VIEW_FADED;
	private static final ImageIcon GROUPED_LOOT_VIEW_HOVER;
	private static final ImageIcon BACK_ARROW_ICON;
	private static final ImageIcon BACK_ARROW_ICON_HOVER;
	private static final ImageIcon VISIBLE_ICON;
	private static final ImageIcon VISIBLE_ICON_HOVER;
	private static final ImageIcon INVISIBLE_ICON;
	private static final ImageIcon INVISIBLE_ICON_HOVER;
	private static final ImageIcon RESET_ICON;
	private static final ImageIcon RESET_ICON_FADED;
	private static final ImageIcon RESET_ICON_HOVER;


	private static final String HTML_LABEL_TEMPLATE =
		"<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>";

	// When there is no loot, display this
	private final PluginErrorPanel errorPanel = new PluginErrorPanel();

	// Handle loot boxes
	private final JPanel logsContainer = new JPanel();

	// Handle overall session data
	private final JPanel overallPanel = new JPanel();
	private final JLabel overallKillsLabel = new JLabel();
	private final JLabel overallGpLabel = new JLabel();
	private final JLabel overallIcon = new JLabel();

	// Details and navigation
	private final JPanel actionsContainer = new JPanel();
	private final JLabel detailsTitle = new JLabel();
	private final JLabel backBtn = new JLabel();
	private final JLabel viewHiddenBtn = new JLabel();
	private final JLabel singleLootBtn = new JLabel();
	private final JLabel groupedLootBtn = new JLabel();
	private final JLabel resetIcon = new JLabel();
	private JComboBox dateFilterComboBox = new JComboBox<>(new Vector<LootRecordDateFilter>(Arrays.asList(LootRecordDateFilter.values())));

	// Log collection
	private final List<LootTrackerRecord> records = new ArrayList<>();
	private final List<LootTrackerBox> boxes = new ArrayList<>();

	private final ItemManager itemManager;
	private final LootTrackerPlugin plugin;
	private final LootTrackerConfig config;

	private boolean groupLoot;
	private LootRecordDateFilter dateFilter = LootRecordDateFilter.ALL;
	private boolean hideIgnoredItems;
	private String currentView;

	static
	{
		final BufferedImage singleLootImg = ImageUtil.getResourceStreamFromClass(LootTrackerPlugin.class, "single_loot_icon.png");
		final BufferedImage groupedLootImg = ImageUtil.getResourceStreamFromClass(LootTrackerPlugin.class, "grouped_loot_icon.png");
		final BufferedImage backArrowImg = ImageUtil.getResourceStreamFromClass(LootTrackerPlugin.class, "back_icon.png");
		final BufferedImage visibleImg = ImageUtil.getResourceStreamFromClass(LootTrackerPlugin.class, "visible_icon.png");
		final BufferedImage invisibleImg = ImageUtil.getResourceStreamFromClass(LootTrackerPlugin.class, "invisible_icon.png");
		final BufferedImage resetImg = ImageUtil.getResourceStreamFromClass(LootTrackerPlugin.class, "reset.png");

		SINGLE_LOOT_VIEW = new ImageIcon(singleLootImg);
		SINGLE_LOOT_VIEW_FADED = new ImageIcon(ImageUtil.alphaOffset(singleLootImg, -180));
		SINGLE_LOOT_VIEW_HOVER = new ImageIcon(ImageUtil.alphaOffset(singleLootImg, -220));

		RESET_ICON = new ImageIcon(resetImg);
		RESET_ICON_FADED = new ImageIcon(ImageUtil.alphaOffset(resetImg, -180));
		RESET_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(resetImg, -220));


		GROUPED_LOOT_VIEW = new ImageIcon(groupedLootImg);
		GROUPED_LOOT_VIEW_FADED = new ImageIcon(ImageUtil.alphaOffset(groupedLootImg, -180));
		GROUPED_LOOT_VIEW_HOVER = new ImageIcon(ImageUtil.alphaOffset(groupedLootImg, -220));

		BACK_ARROW_ICON = new ImageIcon(backArrowImg);
		BACK_ARROW_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(backArrowImg, -180));

		VISIBLE_ICON = new ImageIcon(visibleImg);
		VISIBLE_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(visibleImg, -220));

		INVISIBLE_ICON = new ImageIcon(invisibleImg);
		INVISIBLE_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(invisibleImg, -220));
	}

	@Getter @Setter
	private LootRecordSortType lootRecordSortType = LootRecordSortType.TIMESTAMP;

	LootTrackerPanel(final LootTrackerPlugin plugin, final ItemManager itemManager, final LootTrackerConfig config)
	{
		this.itemManager = itemManager;
		this.plugin = plugin;
		this.config = config;
		this.hideIgnoredItems = true;

		setBorder(new EmptyBorder(6, 6, 6, 6));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new BorderLayout());

		// Create layout panel for wrapping
		final JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new BoxLayout(layoutPanel, BoxLayout.Y_AXIS));
		add(layoutPanel, BorderLayout.NORTH);

		actionsContainer.setLayout(new BorderLayout());
		actionsContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		actionsContainer.setPreferredSize(new Dimension(0, 30));
		actionsContainer.setBorder(new EmptyBorder(5, 5, 5, 10));
		actionsContainer.setVisible(false);

		final JPanel viewControls = new JPanel(new GridLayout(1, 5, 5, 0));
		viewControls.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		singleLootBtn.setIcon(SINGLE_LOOT_VIEW);
		singleLootBtn.setToolTipText("Show each kill separately");
		singleLootBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				changeGrouping(false);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				singleLootBtn.setIcon(groupLoot ? SINGLE_LOOT_VIEW_FADED : SINGLE_LOOT_VIEW);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				singleLootBtn.setIcon(groupLoot ? SINGLE_LOOT_VIEW_HOVER : SINGLE_LOOT_VIEW);
			}
		});

		groupedLootBtn.setIcon(GROUPED_LOOT_VIEW);
		groupedLootBtn.setToolTipText("Group loot by source");
		groupedLootBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				changeGrouping(true);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				groupedLootBtn.setIcon(groupLoot ? GROUPED_LOOT_VIEW : GROUPED_LOOT_VIEW_FADED);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				groupedLootBtn.setIcon(groupLoot ? GROUPED_LOOT_VIEW : GROUPED_LOOT_VIEW_HOVER);
			}
		});

		viewHiddenBtn.setIcon(VISIBLE_ICON);
		viewHiddenBtn.setToolTipText("Show ignored items");
		viewHiddenBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				changeItemHiding(!hideIgnoredItems);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				viewHiddenBtn.setIcon(hideIgnoredItems ? INVISIBLE_ICON : VISIBLE_ICON);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				viewHiddenBtn.setIcon(hideIgnoredItems ? INVISIBLE_ICON_HOVER : VISIBLE_ICON_HOVER);
			}
		});

		resetIcon.setIcon(RESET_ICON);
		resetIcon.setToolTipText("Resets all locally saved data (cannot be undone)");
		resetIcon.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				resetRecords();
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				resetIcon.setIcon(RESET_ICON_HOVER);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				resetIcon.setIcon(records.isEmpty() ? RESET_ICON_FADED : RESET_ICON);
			}
		});

		dateFilterComboBox.setSelectedItem(LootRecordDateFilter.ALL);
		dateFilterComboBox.setToolTipText("Filter the displayed loot records by date");
		dateFilterComboBox.setMaximumSize(new Dimension(15, 0));
		dateFilterComboBox.setMaximumRowCount(3);
		dateFilterComboBox.addItemListener(e ->
		{
			final LootRecordDateFilter dateFilterSelected = (LootRecordDateFilter) e.getItem();
			dateFilter = dateFilterSelected;
			rebuild();
		}
		);

		//viewControls.add(dateFilterComboBox);
		viewControls.add(resetIcon);
		viewControls.add(groupedLootBtn);
		viewControls.add(singleLootBtn);
		viewControls.add(viewHiddenBtn);
		changeGrouping(true);
		changeItemHiding(true);

		final JPanel leftTitleContainer = new JPanel(new BorderLayout(5, 0));
		leftTitleContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		detailsTitle.setForeground(Color.WHITE);

		backBtn.setIcon(BACK_ARROW_ICON);
		backBtn.setVisible(false);
		backBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				currentView = null;
				backBtn.setVisible(false);
				detailsTitle.setText("");
				rebuild();
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				backBtn.setIcon(BACK_ARROW_ICON);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				backBtn.setIcon(BACK_ARROW_ICON_HOVER);
			}
		});

		leftTitleContainer.add(backBtn, BorderLayout.WEST);
		leftTitleContainer.add(detailsTitle, BorderLayout.CENTER);

		actionsContainer.add(dateFilterComboBox);
		actionsContainer.add(leftTitleContainer, BorderLayout.WEST);
		actionsContainer.add(viewControls, BorderLayout.EAST);

		// Create panel that will contain overall data
		overallPanel.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createMatteBorder(5, 0, 0, 0, ColorScheme.DARK_GRAY_COLOR),
			BorderFactory.createEmptyBorder(8, 10, 8, 10)
		));
		overallPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		overallPanel.setLayout(new BorderLayout());
		overallPanel.setVisible(false);

		// Add icon and contents
		final JPanel overallInfo = new JPanel();
		overallInfo.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		overallInfo.setLayout(new GridLayout(2, 1));
		overallInfo.setBorder(new EmptyBorder(2, 10, 2, 0));
		overallKillsLabel.setFont(FontManager.getSmallFont(getFont()));
		overallGpLabel.setFont(FontManager.getSmallFont(getFont()));
		overallInfo.add(overallKillsLabel);
		overallInfo.add(overallGpLabel);
		overallPanel.add(overallIcon, BorderLayout.WEST);
		overallPanel.add(overallInfo, BorderLayout.CENTER);

		JPanel displaySelector = new JPanel();
		displaySelector.setLayout(new GridLayout(1, 1));
		displaySelector.setBorder(new EmptyBorder(2, 10, 10, 10));
		displaySelector.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		// Create reset all menu
		final JMenuItem reset = new JMenuItem("Reset All");
		reset.addActionListener(e ->
		{
			// If not in detailed view, remove all, otherwise only remove for the currently detailed title
			records.removeIf(r -> r.matches(currentView));
			boxes.removeIf(b -> b.matches(currentView));
			updateOverall();
			logsContainer.removeAll();
			logsContainer.repaint();

			// Delete all loot, or loot matching the current view
			LootTrackerClient client = plugin.getLootTrackerClient();
			if (client != null && config.syncPanel())
			{
				client.delete(currentView);
			}
		});

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(reset);
		overallPanel.setComponentPopupMenu(popupMenu);

		// Create loot boxes wrapper
		logsContainer.setLayout(new BoxLayout(logsContainer, BoxLayout.Y_AXIS));
		layoutPanel.add(actionsContainer);
		layoutPanel.add(overallPanel);
		layoutPanel.add(displaySelector);
		layoutPanel.add(logsContainer);

		// Add error pane
		errorPanel.setContent("Loot tracker", "You have not received any loot yet.");
		add(errorPanel);
	}

	void loadHeaderIcon(BufferedImage img)
	{
		overallIcon.setIcon(new ImageIcon(img));
	}

	/**
	 * Adds a new entry to the plugin.
	 * Creates a subtitle, adds a new entry and then passes off to the render methods, that will decide
	 * how to display this new data.
	 */
	void add(final String eventName, final String localUsername, final int actorLevel, LootTrackerItem[] items)
	{
		final String subTitle = actorLevel > -1 ? "(lvl-" + actorLevel + ")" : "";
		final LootTrackerRecord record = new LootTrackerRecord( eventName, localUsername, subTitle, items, Instant.now());
		records.add(record);
		LootTrackerBox box = buildBox(record);
		if (box != null)
		{
			box.rebuild();
			updateOverall();
		}
	}

	/**
	 * Adds a Collection of records to the panel
	 */
	void addRecords(Collection<LootTrackerRecord> recs)
	{
		records.addAll(recs);
		rebuild();
	}

	/**
	 * Changes grouping mode of panel
	 *
	 * @param group if loot should be grouped or not
	 */
	private void changeGrouping(boolean group)
	{
		groupLoot = group;
		rebuild();
		groupedLootBtn.setIcon(group ? GROUPED_LOOT_VIEW : GROUPED_LOOT_VIEW_FADED);
		singleLootBtn.setIcon(group ? SINGLE_LOOT_VIEW_FADED : SINGLE_LOOT_VIEW);
	}

	/**
	 * Changes item hiding mode of panel
	 *
	 * @param hide if ignored items should be hidden or not
	 */
	private void changeItemHiding(boolean hide)
	{
		hideIgnoredItems = hide;
		rebuild();
		viewHiddenBtn.setIcon(hideIgnoredItems ? VISIBLE_ICON : INVISIBLE_ICON);
	}

	/**
	 * Clears all loaded records. This will also attempt to delete the local storage file
	 */
	private void resetRecords()
	{
		records.clear();
		boxes.clear();
		logsContainer.removeAll();
		logsContainer.repaint();
		if (config.localPersistence())
		{
			plugin.deleteLocalRecords();
		}
	}

	/**
	 * After an item changed it's ignored state, iterate all the records and make
	 * sure all items of the same name also get updated
	 */
	void updateIgnoredRecords()
	{
		for (LootTrackerRecord r : records)
		{
			if (plugin.isIgnoredNPC(r.getTitle()))
			for (LootTrackerItem item : r.getItems())
			{
				if (plugin.isIgnored(item.getName()) != item.isIgnored())
				{
					item.setIgnored(plugin.isIgnored(item.getName()));
				}
			}
		}

		rebuild();
	}

	/**
	 * Rebuilds all the boxes from scratch using existing listed records, depending on the grouping mode.
	 */
	public void rebuild()
	{

		logsContainer.removeAll();
		boxes.clear();
		int start = 0;
		records.sort(lootRecordSortType);
		if (!groupLoot && records.size() > MAX_LOOT_BOXES)
		{
			start = records.size() - MAX_LOOT_BOXES;
		}
		for (int i = start; i < records.size(); i++)
		{

			// Check to see if we should even show this record
			if (this.hideIgnoredItems)
			{
				if (this.plugin.isIgnoredNPC(records.get(i).getTitle()))
				{
					continue;
				}
			}

			if (this.plugin.client.getGameState().equals(GameState.LOGGED_IN))
			{
				if (!(this.plugin.client.getLocalPlayer().getName().equals(records.get(i).getLocalUsername())))
				{
					continue;
				}
			}
			if (this.dateFilter.equals(LootRecordDateFilter.ALL))
			{
				buildBox(records.get(i));
				continue;
			}
			if (Instant.now().toEpochMilli() - records.get(i).getTimestamp().toEpochMilli() <= this.dateFilter.getDuration().toMillis())
			{
				buildBox(records.get(i));
			}

		}
		boxes.forEach(LootTrackerBox::rebuild);
		updateOverall();
		logsContainer.revalidate();
		logsContainer.repaint();


	}

	/**
	 * This method decides what to do with a new record, if a similar log exists, it will
	 * add its items to it, updating the log's overall price and kills. If not, a new log will be created
	 * to hold this entry's information.
	 */
	private LootTrackerBox buildBox(LootTrackerRecord record)
	{

		// If this record is not part of current view, return
		if (!record.matches(currentView))
		{
			return null;
		}

		if (this.plugin.client.getGameState().equals(GameState.LOGGED_IN))
		{
			if (!(this.plugin.client.getLocalPlayer().getName().equals(record.getLocalUsername())))
			{
				return null;
			}
		}

		// Check to see if we should even show this record
		if (this.hideIgnoredItems)
		{
			if (this.plugin.isIgnoredNPC(record.getTitle()))
			{
				return null;
			}
		}


		// Group all similar loot together
		if (groupLoot)
		{
			for (LootTrackerBox box : boxes)
			{
				if (box.matches(record))
				{
					box.combine(record);
					return box;
				}
			}
		}

		// Show main view
		remove(errorPanel);
		actionsContainer.setVisible(true);
		overallPanel.setVisible(true);

		// Create box
		final LootTrackerBox box = new LootTrackerBox(record.getTimestamp().toEpochMilli(), itemManager, record.getTitle(),  record.getSubTitle(),
			hideIgnoredItems, config.displayDate(), plugin::toggleItem);
		box.combine(record);

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		box.setComponentPopupMenu(popupMenu);

		// Create Hide Menu item

		final JMenuItem hide;
		if (this.hideIgnoredItems)
		{
			hide = new JMenuItem("Hide " + box.getId());
		}
		else
		{
			hide = new JMenuItem("Unhide " + box.getId());
		}

		hide.addActionListener(e ->
		{
			this.plugin.toggleNPC(box.getId(), this.hideIgnoredItems);
			rebuild();
		});

		popupMenu.add(hide);

		// Create reset menu
		final JMenuItem reset = new JMenuItem("Reset");
		reset.addActionListener(e ->
		{
			records.removeAll(box.getRecords());
			boxes.remove(box);
			updateOverall();
			logsContainer.remove(box);
			logsContainer.repaint();

			LootTrackerClient client = plugin.getLootTrackerClient();
			// Without loot being grouped we have no way to identify single kills to be deleted
			if (client != null && groupLoot && config.syncPanel())
			{
				client.delete(box.getId());
			}
		});

		popupMenu.add(reset);

		// Create details menu
		final JMenuItem details = new JMenuItem("View details");
		details.addActionListener(e ->
		{
			currentView = record.getTitle();
			detailsTitle.setText(currentView);
			backBtn.setVisible(true);
			rebuild();
		});

		popupMenu.add(details);

		// Add box to panel
		boxes.add(box);
		logsContainer.add(box, 0);

		if (!groupLoot && boxes.size() > MAX_LOOT_BOXES)
		{
			logsContainer.remove(boxes.remove(0));
		}

		return box;
	}

	private void updateOverall()
	{
		long overallKills = 0;
		long overallGp = 0;

		for (LootTrackerRecord record : records)
		{
			if (!record.matches(currentView))
			{
				continue;
			}
			if (Objects.nonNull(record.getLocalUsername()) && Objects.nonNull(plugin.client.getLocalPlayer()))
			{
				if (!record.getLocalUsername().equals(plugin.client.getLocalPlayer().getName()))
				{
					continue;
				}
			}
			if (!dateFilter.equals(LootRecordDateFilter.ALL))
			{
				if (Instant.now().toEpochMilli() - record.getTimestamp().toEpochMilli()
					> this.dateFilter.getDuration().toMillis())
				{
					continue;
				}
			}

			int present = record.getItems().length;

			for (LootTrackerItem item : record.getItems())
			{
				if (hideIgnoredItems && item.isIgnored())
				{
					present--;
					continue;
				}

				overallGp += item.getPrice();
			}

			if (present > 0)
			{
				overallKills++;
			}
		}

		overallKillsLabel.setText(htmlLabel("Total count: ", overallKills));
		overallGpLabel.setText(htmlLabel("Total value: ", overallGp));
	}
	private static String htmlLabel(String key, long value)
	{
		final String valueStr = StackFormatter.quantityToStackSize(value);
		return String.format(HTML_LABEL_TEMPLATE, ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR), key, valueStr);
	}
}
