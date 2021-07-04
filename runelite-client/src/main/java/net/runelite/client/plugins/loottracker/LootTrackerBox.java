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

import com.google.common.base.Strings;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.QuantityFormatter;
import net.runelite.client.util.Text;
import net.runelite.http.api.loottracker.LootRecordType;

class LootTrackerBox extends JPanel
{
	private static final int ITEMS_PER_ROW = 5;
	private static final int TITLE_PADDING = 5;

	private static final String SESSION_TITLE_TEXT = "Session";
	private static final String AGGREGATE_TITLE_TEXT = "Aggregate";

	private final JPanel lootPanel = new JPanel();
	private final JPanel itemContainer = new JPanel();
	private final JLabel priceLabel = new JLabel();
	private final JLabel subTitleLabel = new JLabel();
	private final JPanel logTitle = new JPanel();
	private final JPanel sessionTitle = new JPanel();
	private final JPanel aggregateTitle = new JPanel();
	private final JLabel sessionPriceLabel = new JLabel();
	private final JLabel aggregatePriceLabel = new JLabel();
	private final JLabel sessionSubTitleLabel = new JLabel();
	private final JLabel aggregateSubTitleLabel = new JLabel();
	private final JPanel sessionItemContainer = new JPanel();
	private final ItemManager itemManager;
	@Getter(AccessLevel.PACKAGE)
	private final String id;
	private final LootRecordType lootRecordType;
	private final LootTrackerPriceType priceType;
	private final boolean showPriceType;
	private final boolean groupLoot;
	private final boolean splitGroupLoot;

	private int sessionKills;
	private int aggregateKills;
	@Getter
	private final List<LootTrackerItem> sessionItems = new ArrayList<>();
	@Getter
	private final List<LootTrackerItem> aggregateItems = new ArrayList<>();

	private long sessionPrice;
	private long aggregatePrice;
	private final boolean hideIgnoredItems;
	private final BiConsumer<String, Boolean> onItemToggle;

	LootTrackerBox(
		final ItemManager itemManager,
		final String id,
		final LootRecordType lootRecordType,
		@Nullable final String subtitle,
		final boolean hideIgnoredItems,
		final LootTrackerPriceType priceType,
		final boolean showPriceType,
		final BiConsumer<String, Boolean> onItemToggle,
		final BiConsumer<String, Boolean> onEventToggle,
		final boolean eventIgnored,
		final boolean groupLoot,
		final boolean splitGroupLoot)
	{
		this.id = id;
		this.lootRecordType = lootRecordType;
		this.itemManager = itemManager;
		this.onItemToggle = onItemToggle;
		this.hideIgnoredItems = hideIgnoredItems;
		this.priceType = priceType;
		this.showPriceType = showPriceType;
		this.groupLoot = groupLoot;
		this.splitGroupLoot = splitGroupLoot;

		setLayout(new BorderLayout(0, 1));
		setBorder(new EmptyBorder(5, 0, 0, 0));

		logTitle.setLayout(new BoxLayout(logTitle, BoxLayout.X_AXIS));
		logTitle.setBorder(new EmptyBorder(7, 7, 7, 7));
		logTitle.setBackground(eventIgnored ? ColorScheme.DARKER_GRAY_HOVER_COLOR : ColorScheme.DARKER_GRAY_COLOR.darker());

		JLabel titleLabel = new JLabel();
		titleLabel.setText(Text.removeTags(id));
		titleLabel.setFont(FontManager.getRunescapeSmallFont());
		titleLabel.setForeground(Color.WHITE);
		// Set a size to make BoxLayout truncate the name
		titleLabel.setMinimumSize(new Dimension(1, titleLabel.getPreferredSize().height));
		logTitle.add(titleLabel);

		subTitleLabel.setFont(FontManager.getRunescapeSmallFont());
		subTitleLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);

		if (!Strings.isNullOrEmpty(subtitle))
		{
			subTitleLabel.setText(subtitle);
		}

		logTitle.add(Box.createRigidArea(new Dimension(TITLE_PADDING, 0)));
		logTitle.add(subTitleLabel);
		logTitle.add(Box.createHorizontalGlue());
		logTitle.add(Box.createRigidArea(new Dimension(TITLE_PADDING, 0)));

		priceLabel.setFont(FontManager.getRunescapeSmallFont());
		priceLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		logTitle.add(priceLabel);

		lootPanel.setLayout(new BoxLayout(lootPanel, BoxLayout.Y_AXIS));

		buildSubsectionPanel(sessionTitle, SESSION_TITLE_TEXT, sessionPriceLabel, sessionSubTitleLabel);
		buildSubsectionPanel(aggregateTitle, AGGREGATE_TITLE_TEXT, aggregatePriceLabel, aggregateSubTitleLabel);

		lootPanel.add(sessionTitle);
		lootPanel.add(sessionItemContainer);
		lootPanel.add(aggregateTitle);
		lootPanel.add(itemContainer);

		add(logTitle, BorderLayout.NORTH);
		add(lootPanel, BorderLayout.CENTER);

		// Create popup menu for ignoring the loot event
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setComponentPopupMenu(popupMenu);

		final JMenuItem toggle = new JMenuItem(eventIgnored ? "Include loot" : "Hide loot");
		toggle.addActionListener(e -> onEventToggle.accept(id, !eventIgnored));
		popupMenu.add(toggle);
	}

	/**
	 * Returns total amount of kills
	 *
	 * @return total amount of kills
	 */
	private int getTotalKills()
	{
		return sessionKills + aggregateKills;
	}

	/**
	 * Checks if this box matches specified record
	 *
	 * @param record loot record
	 * @return true if match is made
	 */
	boolean matches(final LootTrackerRecord record)
	{
		return record.getTitle().equals(id) && record.getType() == lootRecordType;
	}

	/**
	 * Checks if this box matches specified id and type
	 *
	 * @param id other record id
	 * @param type other record type
	 * @return true if match is made
	 */
	boolean matches(final String id, final LootRecordType type)
	{
		if (id == null)
		{
			return true;
		}

		return this.id.equals(id) && lootRecordType == type;
	}

	/**
	 * Adds an record's data into a loot box.
	 */
	void addKill(final LootTrackerRecord record, final Boolean currentSession)
	{
		if (!matches(record))
		{
			throw new IllegalArgumentException(record.toString());
		}

		if (currentSession)
		{
			sessionKills += record.getKills();
			sessionItemContainer.setVisible(true);
			if (groupLoot && splitGroupLoot)
			{
				sessionTitle.setVisible(true);
			}
		}
		else
		{
			aggregateKills += record.getKills();
		}

		List<LootTrackerItem> items = currentSession ? sessionItems : aggregateItems;
		mergeLootTrackerItems(items, Arrays.asList(record.getItems()));
	}

	void rebuild()
	{
		buildItems();

		String priceTypeString = " ";
		if (showPriceType)
		{
			priceTypeString = priceType == LootTrackerPriceType.HIGH_ALCHEMY ? "HA: " : "GE: ";
		}

		long totalPrice = sessionPrice + aggregatePrice;
		priceLabel.setText(priceTypeString + QuantityFormatter.quantityToStackSize(totalPrice) + " gp");
		priceLabel.setToolTipText(QuantityFormatter.formatNumber(totalPrice) + " gp");

		final long kills = getTotalKills();
		if (kills > 1)
		{
			subTitleLabel.setText("x " + kills);
			subTitleLabel.setToolTipText(QuantityFormatter.formatNumber(totalPrice / kills) + " gp (average)");
		}

		if (splitGroupLoot)
		{
			if (sessionKills > 1)
			{
				sessionSubTitleLabel.setText("x " + sessionKills);
				sessionSubTitleLabel.setToolTipText(QuantityFormatter.formatNumber(sessionPrice / sessionKills) + " gp (average)");
			}

			if (aggregateKills > 1)
			{
				aggregateSubTitleLabel.setText("x " + aggregateKills);
				aggregateSubTitleLabel.setToolTipText(QuantityFormatter.formatNumber(aggregatePrice / aggregateKills) + " gp (average)");
			}

			sessionPriceLabel.setText(priceTypeString + QuantityFormatter.quantityToStackSize(sessionPrice) + " gp");
			sessionPriceLabel.setToolTipText(QuantityFormatter.formatNumber(sessionPrice) + " gp");
			aggregatePriceLabel.setText(priceTypeString + QuantityFormatter.quantityToStackSize(aggregatePrice) + " gp");
			aggregatePriceLabel.setToolTipText(QuantityFormatter.formatNumber(aggregatePrice) + " gp");
		}

		validate();
		repaint();
	}

	void collapse()
	{
		if (!isCollapsed())
		{
			lootPanel.setVisible(false);
			applyDimmer(false, logTitle);
		}
	}

	void expand()
	{
		if (isCollapsed())
		{
			lootPanel.setVisible(true);
			applyDimmer(true, logTitle);
		}
	}

	boolean isCollapsed()
	{
		return !lootPanel.isVisible();
	}

	private void applyDimmer(boolean brighten, JPanel panel)
	{
		for (Component component : panel.getComponents())
		{
			Color color = component.getForeground();

			component.setForeground(brighten ? color.brighter() : color.darker());
		}
	}

	/**
	 * This method creates stacked items from the item list, calculates total price and then
	 * displays all the items in the UI.
	 */
	private void buildItems()
	{
		aggregatePrice = 0;
		sessionPrice = 0;

		List<LootTrackerItem> sessionItems = this.sessionItems;
		List<LootTrackerItem> previousItems = this.aggregateItems;
		if (hideIgnoredItems)
		{
			sessionItems = sessionItems.stream().filter(item -> !item.isIgnored()).collect(Collectors.toList());
			previousItems = previousItems.stream().filter(item -> !item.isIgnored()).collect(Collectors.toList());
		}

		boolean isHidden = sessionItems.isEmpty() && previousItems.isEmpty();
		setVisible(!isHidden);

		if (isHidden)
		{
			return;
		}

		if (splitGroupLoot)
		{
			if (sessionItems.isEmpty())
			{
				sessionTitle.setVisible(false);
				sessionItemContainer.setVisible(false);
			}
			else if (!groupLoot)
			{
				sessionTitle.setVisible(false);
			}

			if (previousItems.isEmpty())
			{
				aggregateTitle.setVisible(false);
				itemContainer.setVisible(false);
			}
		}
		else
		{
			sessionTitle.setVisible(false);
			sessionItemContainer.setVisible(false);
			aggregateTitle.setVisible(false);
			itemContainer.setVisible(true);
		}

		ToLongFunction<LootTrackerItem> getPrice = priceType == LootTrackerPriceType.HIGH_ALCHEMY
			? LootTrackerItem::getTotalHaPrice
			: LootTrackerItem::getTotalGePrice;

		sessionPrice = sessionItems.stream().mapToLong(getPrice).sum();
		aggregatePrice = previousItems.stream().mapToLong(getPrice).sum();

		if (splitGroupLoot)
		{
			buildItemContainer(sessionItems, sessionItemContainer, getPrice);
			buildItemContainer(previousItems, itemContainer, getPrice);
		}
		else
		{
			List<LootTrackerItem> items = new ArrayList<>(previousItems);
			mergeLootTrackerItems(items, sessionItems);
			buildItemContainer(items, itemContainer, getPrice);
		}
	}

	private static String buildToolTip(LootTrackerItem item)
	{
		final String name = item.getName();
		final int quantity = item.getQuantity();
		final long gePrice = item.getTotalGePrice();
		final long haPrice = item.getTotalHaPrice();
		final String ignoredLabel = item.isIgnored() ? " - Ignored" : "";
		return "<html>" + name + " x " + quantity + ignoredLabel
			+ "<br>GE: " + QuantityFormatter.quantityToStackSize(gePrice)
			+ "<br>HA: " + QuantityFormatter.quantityToStackSize(haPrice) + "</html>";
	}

	private void buildSubsectionPanel(JPanel title, String titleText, JLabel sectionPriceLabel, JLabel killTotalLabel)
	{
		title.setLayout(new BoxLayout(title, BoxLayout.X_AXIS));
		title.setBorder(new EmptyBorder(5, 7, 5, 7));
		title.setBackground(ColorScheme.DARKER_GRAY_COLOR.darker());

		JLabel titleLabel = new JLabel();
		titleLabel.setText(titleText);
		titleLabel.setFont(FontManager.getRunescapeSmallFont());
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setMinimumSize(new Dimension(1, titleLabel.getPreferredSize().height));
		title.add(titleLabel);

		killTotalLabel.setFont(FontManager.getRunescapeSmallFont());
		killTotalLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);

		title.add(Box.createRigidArea(new Dimension(TITLE_PADDING, 0)));
		title.add(killTotalLabel);
		title.add(Box.createHorizontalGlue());
		title.add(Box.createRigidArea(new Dimension(TITLE_PADDING, 0)));

		sectionPriceLabel.setFont(FontManager.getRunescapeSmallFont());
		sectionPriceLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		title.add(sectionPriceLabel);
	}

	private void buildItemContainer(List<LootTrackerItem> items, JPanel container,
									ToLongFunction<LootTrackerItem> getPrice)
	{
		items.sort(Comparator.comparingLong(getPrice).reversed());

		// Calculates how many rows need to be display to fit all items
		final int rowSize = ((items.size() % ITEMS_PER_ROW == 0) ? 0 : 1) + items.size() / ITEMS_PER_ROW;

		container.removeAll();
		container.setLayout(new GridLayout(rowSize, ITEMS_PER_ROW, 1, 1));

		for (int i = 0; i < rowSize * ITEMS_PER_ROW; i++)
		{
			final JPanel slotContainer = new JPanel();
			slotContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

			if (i < items.size())
			{
				final LootTrackerItem item = items.get(i);
				final JLabel imageLabel = new JLabel();
				imageLabel.setToolTipText(buildToolTip(item));
				imageLabel.setVerticalAlignment(SwingConstants.CENTER);
				imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

				AsyncBufferedImage itemImage = itemManager.getImage(item.getId(), item.getQuantity(), item.getQuantity() > 1);

				if (item.isIgnored())
				{
					Runnable addTransparency = () ->
					{
						BufferedImage transparentImage = ImageUtil.alphaOffset(itemImage, .3f);
						imageLabel.setIcon(new ImageIcon(transparentImage));
					};
					itemImage.onLoaded(addTransparency);
					addTransparency.run();
				}
				else
				{
					itemImage.addTo(imageLabel);
				}

				slotContainer.add(imageLabel);

				// Create popup menu
				final JPopupMenu popupMenu = new JPopupMenu();
				popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
				slotContainer.setComponentPopupMenu(popupMenu);

				final JMenuItem toggle = new JMenuItem("Toggle item");
				toggle.addActionListener(e ->
				{
					item.setIgnored(!item.isIgnored());
					onItemToggle.accept(item.getName(), item.isIgnored());
				});

				popupMenu.add(toggle);
			}

			container.add(slotContainer);
		}

		container.repaint();
	}

	private void mergeLootTrackerItems(final List<LootTrackerItem> currentItems, final List<LootTrackerItem> addedItems)
	{
		outer:
		for (LootTrackerItem item : addedItems)
		{
			final int mappedItemId = LootTrackerMapping.map(item.getId(), item.getName());
			// Combine it into an existing item if one already exists
			for (int idx = 0; idx < currentItems.size(); ++idx)
			{
				LootTrackerItem i = currentItems.get(idx);
				if (mappedItemId == i.getId())
				{
					currentItems.set(idx, new LootTrackerItem(i.getId(), i.getName(), i.getQuantity() + item.getQuantity(), i.getGePrice(), i.getHaPrice(), i.isIgnored()));
					continue outer;
				}
			}

			final LootTrackerItem mappedItem = mappedItemId == item.getId()
				? item // reuse existing item
				: new LootTrackerItem(mappedItemId, item.getName(), item.getQuantity(), item.getGePrice(), item.getHaPrice(), item.isIgnored());
			currentItems.add(mappedItem);
		}
	}
}
