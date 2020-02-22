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

	private final JPanel itemContainer = new JPanel();
	private final JLabel priceLabel = new JLabel();
	private final JLabel subTitleLabel = new JLabel();
	private final JPanel logTitle = new JPanel();
	private final ItemManager itemManager;
	@Getter(AccessLevel.PACKAGE)
	private final String id;
	private final LootRecordType lootRecordType;
	private final LootTrackerPriceType priceType;
	private final boolean showPriceType;

	private int kills;
	@Getter
	private final List<LootTrackerItem> items = new ArrayList<>();

	private long totalPrice;
	private boolean hideIgnoredItems;
	private BiConsumer<String, Boolean> onItemToggle;

	LootTrackerBox(
		final ItemManager itemManager,
		final String id,
		final LootRecordType lootRecordType,
		@Nullable final String subtitle,
		final boolean hideIgnoredItems,
		final LootTrackerPriceType priceType,
		final boolean showPriceType,
		final BiConsumer<String, Boolean> onItemToggle)
	{
		this.id = id;
		this.lootRecordType = lootRecordType;
		this.itemManager = itemManager;
		this.onItemToggle = onItemToggle;
		this.hideIgnoredItems = hideIgnoredItems;
		this.priceType = priceType;
		this.showPriceType = showPriceType;

		setLayout(new BorderLayout(0, 1));
		setBorder(new EmptyBorder(5, 0, 0, 0));

		logTitle.setLayout(new BoxLayout(logTitle, BoxLayout.X_AXIS));
		logTitle.setBorder(new EmptyBorder(7, 7, 7, 7));
		logTitle.setBackground(ColorScheme.DARKER_GRAY_COLOR.darker());

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

		add(logTitle, BorderLayout.NORTH);
		add(itemContainer, BorderLayout.CENTER);
	}

	/**
	 * Returns total amount of kills
	 *
	 * @return total amount of kills
	 */
	private int getTotalKills()
	{
		return kills;
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
	void addKill(final LootTrackerRecord record)
	{
		if (!matches(record))
		{
			throw new IllegalArgumentException(record.toString());
		}

		kills += record.getKills();

		outer:
		for (LootTrackerItem item : record.getItems())
		{
			// Combine it into an existing item if one already exists
			for (int idx = 0; idx < items.size(); ++idx)
			{
				LootTrackerItem i = items.get(idx);
				if (item.getId() == i.getId())
				{
					items.set(idx, new LootTrackerItem(i.getId(), i.getName(), i.getQuantity() + item.getQuantity(), i.getGePrice(), i.getHaPrice(), i.isIgnored()));
					continue outer;
				}
			}

			items.add(item);
		}
	}

	void rebuild()
	{
		buildItems();

		String priceTypeString = " ";
		if (showPriceType)
		{
			priceTypeString = priceType == LootTrackerPriceType.HIGH_ALCHEMY ? "HA: " : "GE: ";
		}

		priceLabel.setText(priceTypeString + QuantityFormatter.quantityToStackSize(totalPrice) + " gp");
		priceLabel.setToolTipText(QuantityFormatter.formatNumber(totalPrice) + " gp");

		final long kills = getTotalKills();
		if (kills > 1)
		{
			subTitleLabel.setText("x " + kills);
		}

		validate();
		repaint();
	}

	void collapse()
	{
		if (!isCollapsed())
		{
			itemContainer.setVisible(false);
			applyDimmer(false, logTitle);
		}
	}

	void expand()
	{
		if (isCollapsed())
		{
			itemContainer.setVisible(true);
			applyDimmer(true, logTitle);
		}
	}

	boolean isCollapsed()
	{
		return !itemContainer.isVisible();
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
		totalPrice = 0;

		List<LootTrackerItem> items = this.items;
		if (hideIgnoredItems)
		{
			items = items.stream().filter(item -> !item.isIgnored()).collect(Collectors.toList());
		}

		boolean isHidden = items.isEmpty();
		setVisible(!isHidden);

		if (isHidden)
		{
			return;
		}

		ToLongFunction<LootTrackerItem> getPrice = priceType == LootTrackerPriceType.HIGH_ALCHEMY
			? LootTrackerItem::getTotalHaPrice
			: LootTrackerItem::getTotalGePrice;

		totalPrice = items.stream()
			.mapToLong(getPrice)
			.sum();

		items.sort(Comparator.comparingLong(getPrice).reversed());

		// Calculates how many rows need to be display to fit all items
		final int rowSize = ((items.size() % ITEMS_PER_ROW == 0) ? 0 : 1) + items.size() / ITEMS_PER_ROW;

		itemContainer.removeAll();
		itemContainer.setLayout(new GridLayout(rowSize, ITEMS_PER_ROW, 1, 1));

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

			itemContainer.add(slotContainer);
		}

		itemContainer.repaint();
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
}
