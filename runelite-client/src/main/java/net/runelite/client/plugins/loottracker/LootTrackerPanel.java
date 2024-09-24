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

import static com.google.common.collect.Iterables.concat;
import com.google.common.collect.Lists;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicToggleButtonUI;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.QuantityFormatter;
import net.runelite.client.util.SwingUtil;
import net.runelite.http.api.loottracker.LootRecordType;

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
	private static final ImageIcon COLLAPSE_ICON;
	private static final ImageIcon EXPAND_ICON;

	private static final String HTML_LABEL_TEMPLATE =
		"<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>";
	private static final String RESET_ALL_WARNING_TEXT =
		"<html>This will permanently delete <b>all</b> loot.</html>";
	private static final String RESET_CURRENT_WARNING_TEXT =
		"This will permanently delete \"%s\" loot.";
	private static final String RESET_ONE_WARNING_TEXT =
		"This will delete one kill.";

	// When there is no loot, display this
	private final PluginErrorPanel errorPanel = new PluginErrorPanel();

	// Handle loot boxes
	private final JPanel logsContainer = new JPanel();

	// Handle overall session data
	private final JPanel overallPanel;
	private final JLabel overallKillsLabel = new JLabel();
	private final JLabel overallGpLabel = new JLabel();
	private final JLabel overallIcon = new JLabel();

	// Details and navigation
	private final JPanel actionsPanel;
	private final JLabel detailsTitle = new JLabel();
	private final JButton backBtn = new JButton();
	private final JToggleButton viewHiddenBtn = new JToggleButton();
	private final JRadioButton singleLootBtn = new JRadioButton();
	private final JRadioButton groupedLootBtn = new JRadioButton();
	private final JButton collapseBtn = new JButton();

	// Aggregate of all kills
	private final List<LootTrackerRecord> aggregateRecords = new ArrayList<>();
	// Individual records for the individual kills this session
	private final List<LootTrackerRecord> sessionRecords = new ArrayList<>();
	private final List<LootTrackerBox> boxes = new ArrayList<>();

	private final ItemManager itemManager;
	private final LootTrackerPlugin plugin;
	private final LootTrackerConfig config;

	private boolean groupLoot;
	private boolean hideIgnoredItems;
	private String currentView;
	private LootRecordType currentType;

	static
	{
		final BufferedImage singleLootImg = ImageUtil.loadImageResource(LootTrackerPlugin.class, "single_loot_icon.png");
		final BufferedImage groupedLootImg = ImageUtil.loadImageResource(LootTrackerPlugin.class, "grouped_loot_icon.png");
		final BufferedImage backArrowImg = ImageUtil.loadImageResource(LootTrackerPlugin.class, "back_icon.png");
		final BufferedImage visibleImg = ImageUtil.loadImageResource(LootTrackerPlugin.class, "visible_icon.png");
		final BufferedImage invisibleImg = ImageUtil.loadImageResource(LootTrackerPlugin.class, "invisible_icon.png");
		final BufferedImage collapseImg = ImageUtil.loadImageResource(LootTrackerPlugin.class, "collapsed.png");
		final BufferedImage expandedImg = ImageUtil.loadImageResource(LootTrackerPlugin.class, "expanded.png");

		SINGLE_LOOT_VIEW = new ImageIcon(singleLootImg);
		SINGLE_LOOT_VIEW_FADED = new ImageIcon(ImageUtil.alphaOffset(singleLootImg, -180));
		SINGLE_LOOT_VIEW_HOVER = new ImageIcon(ImageUtil.alphaOffset(singleLootImg, -220));

		GROUPED_LOOT_VIEW = new ImageIcon(groupedLootImg);
		GROUPED_LOOT_VIEW_FADED = new ImageIcon(ImageUtil.alphaOffset(groupedLootImg, -180));
		GROUPED_LOOT_VIEW_HOVER = new ImageIcon(ImageUtil.alphaOffset(groupedLootImg, -220));

		BACK_ARROW_ICON = new ImageIcon(backArrowImg);
		BACK_ARROW_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(backArrowImg, -180));

		VISIBLE_ICON = new ImageIcon(visibleImg);
		VISIBLE_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(visibleImg, -220));

		INVISIBLE_ICON = new ImageIcon(invisibleImg);
		INVISIBLE_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(invisibleImg, -220));

		COLLAPSE_ICON = new ImageIcon(collapseImg);
		EXPAND_ICON = new ImageIcon(expandedImg);
	}

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

		actionsPanel = buildActionsPanel();
		overallPanel = buildOverallPanel();

		// Create loot boxes wrapper
		logsContainer.setLayout(new BoxLayout(logsContainer, BoxLayout.Y_AXIS));
		layoutPanel.add(actionsPanel);
		layoutPanel.add(overallPanel);
		layoutPanel.add(logsContainer);

		// Add error pane
		errorPanel.setContent("Loot tracker", "You have not received any loot yet.");
		add(errorPanel);
	}

	/**
	 * The actions panel includes the back/title label for the current view,
	 * as well as the view controls panel which includes hidden, single/grouped, and
	 * collapse buttons.
	 */
	private JPanel buildActionsPanel()
	{
		final JPanel actionsContainer = new JPanel();
		actionsContainer.setLayout(new BorderLayout());
		actionsContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		actionsContainer.setPreferredSize(new Dimension(0, 30));
		actionsContainer.setBorder(new EmptyBorder(5, 5, 5, 10));
		actionsContainer.setVisible(false);

		final JPanel viewControls = new JPanel(new GridLayout(1, 3, 10, 0));
		viewControls.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		SwingUtil.removeButtonDecorations(collapseBtn);
		collapseBtn.setIcon(EXPAND_ICON);
		collapseBtn.setSelectedIcon(COLLAPSE_ICON);
		SwingUtil.addModalTooltip(collapseBtn, "Expand All", "Collapse All");
		collapseBtn.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		collapseBtn.setUI(new BasicButtonUI()); // substance breaks the layout
		collapseBtn.addActionListener(ev -> changeCollapse());
		viewControls.add(collapseBtn);

		SwingUtil.removeButtonDecorations(singleLootBtn);
		singleLootBtn.setIcon(SINGLE_LOOT_VIEW_FADED);
		singleLootBtn.setRolloverIcon(SINGLE_LOOT_VIEW_HOVER);
		singleLootBtn.setSelectedIcon(SINGLE_LOOT_VIEW);
		singleLootBtn.setToolTipText("Show each kill separately");
		singleLootBtn.addActionListener(e -> changeGrouping(false));

		SwingUtil.removeButtonDecorations(groupedLootBtn);
		groupedLootBtn.setIcon(GROUPED_LOOT_VIEW_FADED);
		groupedLootBtn.setRolloverIcon(GROUPED_LOOT_VIEW_HOVER);
		groupedLootBtn.setSelectedIcon(GROUPED_LOOT_VIEW);
		groupedLootBtn.setToolTipText("Group loot by source");
		groupedLootBtn.addActionListener(e -> changeGrouping(true));

		ButtonGroup groupSingleGroup = new ButtonGroup();
		groupSingleGroup.add(singleLootBtn);
		groupSingleGroup.add(groupedLootBtn);

		viewControls.add(groupedLootBtn);
		viewControls.add(singleLootBtn);
		changeGrouping(true);

		SwingUtil.removeButtonDecorations(viewHiddenBtn);
		viewHiddenBtn.setIconTextGap(0);
		viewHiddenBtn.setIcon(VISIBLE_ICON);
		viewHiddenBtn.setRolloverIcon(INVISIBLE_ICON_HOVER);
		viewHiddenBtn.setSelectedIcon(INVISIBLE_ICON);
		viewHiddenBtn.setRolloverSelectedIcon(VISIBLE_ICON_HOVER);
		viewHiddenBtn.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		viewHiddenBtn.setUI(new BasicToggleButtonUI()); // substance breaks the layout and the pressed icon
		viewHiddenBtn.addActionListener(e -> changeItemHiding(viewHiddenBtn.isSelected()));
		SwingUtil.addModalTooltip(viewHiddenBtn, "Show ignored items", "Hide ignored items");
		changeItemHiding(true);
		viewControls.add(viewHiddenBtn);

		final JPanel leftTitleContainer = new JPanel(new BorderLayout(5, 0));
		leftTitleContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		detailsTitle.setForeground(Color.WHITE);

		SwingUtil.removeButtonDecorations(backBtn);
		backBtn.setIcon(BACK_ARROW_ICON);
		backBtn.setRolloverIcon(BACK_ARROW_ICON_HOVER);
		backBtn.setVisible(false);
		backBtn.addActionListener(ev ->
		{
			currentView = null;
			currentType = null;
			backBtn.setVisible(false);
			detailsTitle.setText("");
			rebuild();
		});

		leftTitleContainer.add(backBtn, BorderLayout.WEST);
		leftTitleContainer.add(detailsTitle, BorderLayout.CENTER);

		actionsContainer.add(viewControls, BorderLayout.EAST);
		actionsContainer.add(leftTitleContainer, BorderLayout.WEST);

		return actionsContainer;
	}

	private JPanel buildOverallPanel()
	{
		// Create panel that will contain overall data
		final JPanel overallPanel = new JPanel();
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
		overallKillsLabel.setFont(FontManager.getRunescapeSmallFont());
		overallGpLabel.setFont(FontManager.getRunescapeSmallFont());
		overallInfo.add(overallKillsLabel);
		overallInfo.add(overallGpLabel);
		overallPanel.add(overallIcon, BorderLayout.WEST);
		overallPanel.add(overallInfo, BorderLayout.CENTER);

		// Create reset all menu
		final JMenuItem reset = new JMenuItem("Reset All");
		reset.addActionListener(e ->
		{
			final int result = JOptionPane.showOptionDialog(overallPanel,
				currentView == null ? RESET_ALL_WARNING_TEXT : String.format(RESET_CURRENT_WARNING_TEXT, currentView),
				"Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
				null, new String[]{"Yes", "No"}, "No");

			if (result != JOptionPane.YES_OPTION)
			{
				return;
			}

			// If not in detailed view, remove all, otherwise only remove for the currently detailed title
			sessionRecords.removeIf(r -> r.matches(currentView, currentType));
			aggregateRecords.removeIf(r -> r.matches(currentView, currentType));
			boxes.removeIf(b -> b.matches(currentView, currentType));
			updateOverall();
			logsContainer.removeAll();
			logsContainer.revalidate();

			// Delete all loot, or loot matching the current view
			if (currentView != null)
			{
				assert currentType != null;
				plugin.removeLootConfig(currentType, currentView);
			}
			else
			{
				plugin.removeAllLoot();
			}
		});

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(reset);
		overallPanel.setComponentPopupMenu(popupMenu);

		return overallPanel;
	}

	void updateCollapseText()
	{
		collapseBtn.setSelected(isAllCollapsed());
	}

	private boolean isAllCollapsed()
	{
		return boxes.stream()
			.filter(LootTrackerBox::isCollapsed)
			.count() == boxes.size();
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
	void add(final String eventName, final LootRecordType type, final int actorLevel, LootTrackerItem[] items, int kills)
	{
		final String subTitle;
		if (type == LootRecordType.PICKPOCKET)
		{
			subTitle = "(pickpocket)";
		}
		else
		{
			subTitle = actorLevel > -1 ? "(lvl-" + actorLevel + ")" : "";
		}
		final LootTrackerRecord record = new LootTrackerRecord(eventName, subTitle, type, items, kills);
		sessionRecords.add(record);

		if (hideIgnoredItems && plugin.isEventIgnored(eventName))
		{
			return;
		}

		LootTrackerBox box = buildBox(record);
		if (box != null)
		{
			box.rebuild();
			updateOverall();
		}
	}

	/**
	 * Clear all records in the panel
	 */
	void clearRecords()
	{
		aggregateRecords.clear();
		sessionRecords.clear();
	}

	/**
	 * Adds a Collection of records to the panel
	 */
	void addRecords(Collection<LootTrackerRecord> recs)
	{
		aggregateRecords.addAll(recs);
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
		(group ? groupedLootBtn : singleLootBtn).setSelected(true);
		rebuild();
	}

	/**
	 * Changes item hiding mode of panel
	 *
	 * @param hide if ignored items should be hidden or not
	 */
	private void changeItemHiding(boolean hide)
	{
		hideIgnoredItems = hide;
		viewHiddenBtn.setSelected(hide);
		rebuild();
	}

	/**
	 * Changes the collapse status of loot entries
	 */
	private void changeCollapse()
	{
		boolean isAllCollapsed = isAllCollapsed();

		for (LootTrackerBox box : boxes)
		{
			if (isAllCollapsed)
			{
				box.expand();
			}
			else if (!box.isCollapsed())
			{
				box.collapse();
			}
		}

		updateCollapseText();
	}

	/**
	 * After an item changed it's ignored state, iterate all the records and make
	 * sure all items of the same name also get updated
	 */
	void updateIgnoredRecords()
	{
		for (LootTrackerRecord record : concat(aggregateRecords, sessionRecords))
		{
			for (LootTrackerItem item : record.getItems())
			{
				item.setIgnored(plugin.isIgnored(item.getName()));
			}
		}

		rebuild();
	}

	/**
	 * Rebuilds loot entries when one of the price type config options is changed
	 */
	void updatePriceTypeDisplay()
	{
		rebuild();
	}

	/**
	 * Rebuilds all the boxes from scratch using existing listed records, depending on the grouping mode.
	 */
	private void rebuild()
	{
		SwingUtil.fastRemoveAll(logsContainer);
		boxes.clear();

		if (groupLoot)
		{
			aggregateRecords.forEach(this::buildBox);
			sessionRecords.forEach(this::buildBox);
		}
		else
		{
			// Loop in reverse insertion order so limiting includes most recent data
			Lists.reverse(sessionRecords).stream()
				// filter records prior to limiting so that it is limited to the correct amount
				.filter(r -> !hideIgnoredItems || !plugin.isEventIgnored(r.getTitle()))
				.limit(MAX_LOOT_BOXES)
				// The box that is built last is first inside the UI.
				// since we are looping in reverse order we need to use a data type that support reverse iterating
				.collect(Collectors.toCollection(ArrayDeque::new))
				.descendingIterator()
				.forEachRemaining(this::buildBox);
		}

		boxes.forEach(LootTrackerBox::rebuild);
		updateOverall();
		logsContainer.revalidate();
	}

	/**
	 * This method decides what to do with a new record, if a similar log exists, it will
	 * add its items to it, updating the log's overall price and kills. If not, a new log will be created
	 * to hold this entry's information.
	 */
	private LootTrackerBox buildBox(LootTrackerRecord record)
	{
		// If this record is not part of current view, return
		if (!record.matches(currentView, currentType))
		{
			return null;
		}

		final boolean isIgnored = plugin.isEventIgnored(record.getTitle());
		if (hideIgnoredItems && isIgnored)
		{
			return null;
		}

		// Group all similar loot together
		if (groupLoot)
		{
			for (LootTrackerBox box : boxes)
			{
				if (box.matches(record))
				{
					// float the matched box to the top of the UI list if it's not already first
					logsContainer.setComponentZOrder(box, 0);
					box.addKill(record);
					return box;
				}
			}
		}

		// Show main view
		remove(errorPanel);
		actionsPanel.setVisible(true);
		overallPanel.setVisible(true);

		// Create box
		final LootTrackerBox box = new LootTrackerBox(itemManager, record.getTitle(), record.getType(), record.getSubTitle(),
			hideIgnoredItems, config.priceType(), config.showPriceType(), plugin::toggleItem, plugin::toggleEvent, isIgnored);
		box.addKill(record);

		// Use the existing popup menu or create a new one
		JPopupMenu popupMenu = box.getComponentPopupMenu();
		if (popupMenu == null)
		{
			popupMenu = new JPopupMenu();
			popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
			box.setComponentPopupMenu(popupMenu);
		}

		// Create collapse event
		box.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					if (box.isCollapsed())
					{
						box.expand();
					}
					else
					{
						box.collapse();
					}
					updateCollapseText();
				}
			}
		});

		// Create reset menu
		final JMenuItem reset = new JMenuItem("Reset");
		reset.addActionListener(e ->
		{
			final int result = JOptionPane.showOptionDialog(box,
				groupLoot ? String.format(RESET_CURRENT_WARNING_TEXT, box.getId()) : RESET_ONE_WARNING_TEXT,
				"Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
				null, new String[]{"Yes", "No"}, "No");

			if (result != JOptionPane.YES_OPTION)
			{
				return;
			}

			Predicate<LootTrackerRecord> match = groupLoot
				// With grouped loot, remove any record with this title
				? r -> r.matches(record.getTitle(), record.getType())
				// Otherwise remove specifically this entry
				: r -> r.equals(record);
			sessionRecords.removeIf(match);
			aggregateRecords.removeIf(match);
			boxes.remove(box);
			updateOverall();
			logsContainer.remove(box);
			logsContainer.revalidate();

			// Without loot being grouped we have no way to identify single kills to be deleted
			if (groupLoot)
			{
				plugin.removeLootConfig(box.getLootRecordType(), box.getId());
			}
		});

		popupMenu.add(reset);

		// Create details menu
		final JMenuItem details = new JMenuItem("View details");
		details.addActionListener(e ->
		{
			currentView = record.getTitle();
			currentType = record.getType();
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
		long overallGe = 0;
		long overallHa = 0;

		Iterable<LootTrackerRecord> records = sessionRecords;
		if (groupLoot)
		{
			records = concat(aggregateRecords, sessionRecords);
		}

		for (LootTrackerRecord record : records)
		{
			if (!record.matches(currentView, currentType))
			{
				continue;
			}

			if (hideIgnoredItems && plugin.isEventIgnored(record.getTitle()))
			{
				continue;
			}

			int present = record.getItems().length;

			for (LootTrackerItem item : record.getItems())
			{
				if (hideIgnoredItems && item.isIgnored())
				{
					present--;
					continue;
				}

				overallGe += item.getTotalGePrice();
				overallHa += item.getTotalHaPrice();
			}

			if (present > 0)
			{
				overallKills += record.getKills();
			}
		}

		String priceType = "";
		if (config.showPriceType())
		{
			priceType = config.priceType() == LootTrackerPriceType.HIGH_ALCHEMY ? "HA " : "GE ";
		}

		overallKillsLabel.setText(htmlLabel("Total count: ", overallKills));
		overallGpLabel.setText(htmlLabel("Total " + priceType + "value: ", config.priceType() == LootTrackerPriceType.HIGH_ALCHEMY ? overallHa : overallGe));
		overallGpLabel.setToolTipText("<html>Total GE price: " + QuantityFormatter.formatNumber(overallGe)
			+ "<br>Total HA price: " + QuantityFormatter.formatNumber(overallHa) + "</html>");
		updateCollapseText();
	}

	private static String htmlLabel(String key, long value)
	{
		final String valueStr = QuantityFormatter.quantityToStackSize(value);
		return String.format(HTML_LABEL_TEMPLATE, ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR), key, valueStr);
	}
}
