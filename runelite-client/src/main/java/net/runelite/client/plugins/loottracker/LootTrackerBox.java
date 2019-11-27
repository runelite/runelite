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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
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
import net.runelite.api.util.Text;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.QuantityFormatter;

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
	private final LootTrackerPriceType priceType;
	private final boolean showPriceType;

	@Getter(AccessLevel.PACKAGE)
	private final List<LootTrackerRecord> records = new ArrayList<>();

	private long totalPrice;
	private final boolean hideIgnoredItems;
	private final BiConsumer<String, Boolean> onItemToggle;

	LootTrackerBox(
		final long timeStamp,
		final ItemManager itemManager,
		final String id,
		@Nullable final String subtitle,
		final boolean hideIgnoredItems,
		final LootTrackerPriceType priceType,
		final boolean showPriceType,
		@Nullable final Boolean showDate,
		final BiConsumer<String, Boolean> onItemToggle)
	{
		this.id = id;
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

		JLabel dateLabel = new JLabel();
		dateLabel.setFont(FontManager.getRunescapeSmallFont().deriveFont(Font.PLAIN, FontManager.getRunescapeSmallFont().getSize() - 2));
		dateLabel.setForeground(Color.LIGHT_GRAY);
		dateLabel.setText(DateFormat.getDateInstance().format(new Date(timeStamp)));

		if (showDate)
		{
			logTitle.add(dateLabel, BorderLayout.SOUTH);
		}


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
	 * Returns total amount of kills, removing ignored kills when necessary
	 *
	 * @return total amount of kills
	 */
	private long getTotalKills()
	{
		return hideIgnoredItems
			? records.stream().filter(
			r -> !Arrays.stream(r.getItems()).allMatch(LootTrackerItem::isIgnored)).count()
			: records.size();
	}

	/**
	 * Checks if this box matches specified record
	 *
	 * @param record loot record
	 * @return true if match is made
	 */
	boolean matches(final LootTrackerRecord record)
	{
		return record.getTitle().equals(id);
	}

	/**
	 * Checks if this box matches specified id
	 *
	 * @param id other record id
	 * @return true if match is made
	 */
	boolean matches(final String id)
	{
		if (id == null)
		{
			return true;
		}

		return this.id.equals(id);
	}

	/**
	 * Adds an record's data into a loot box.
	 * This will add new items to the list, re-calculating price and kill count.
	 */
	void combine(final LootTrackerRecord record)
	{
		if (!matches(record))
		{
			throw new IllegalArgumentException(record.toString());
		}

		records.add(record);
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
		final List<LootTrackerItem> allItems = new ArrayList<>();
		final List<LootTrackerItem> items = new ArrayList<>();
		totalPrice = 0;

		for (LootTrackerRecord record : records)
		{
			allItems.addAll(Arrays.asList(record.getItems()));
		}

		if (hideIgnoredItems)
		{
			/* If all the items in this box are ignored */
			boolean hideBox = allItems.stream().allMatch(LootTrackerItem::isIgnored);
			setVisible(!hideBox);

			if (hideBox)
			{
				return;
			}
		}

		for (final LootTrackerItem entry : allItems)
		{
			if (entry.isIgnored() && hideIgnoredItems)
			{
				continue;
			}

			totalPrice += priceType == LootTrackerPriceType.HIGH_ALCHEMY ? entry.getHaPrice() : entry.getGePrice();

			int quantity = 0;
			for (final LootTrackerItem i : items)
			{
				if (i.getId() == entry.getId())
				{
					quantity = i.getQuantity();
					items.remove(i);
					break;
				}
			}

			if (quantity != 0)
			{
				int newQuantity = entry.getQuantity() + quantity;
				long gePricePerItem = entry.getGePrice() == 0 ? 0 : (entry.getGePrice() / entry.getQuantity());
				long haPricePerItem = entry.getHaPrice() == 0 ? 0 : (entry.getHaPrice() / entry.getQuantity());

				items.add(new LootTrackerItem(entry.getId(), entry.getName(), newQuantity, gePricePerItem * newQuantity, haPricePerItem * newQuantity, entry.isIgnored()));
			}
			else
			{
				items.add(entry);
			}
		}

		if (priceType == LootTrackerPriceType.HIGH_ALCHEMY)
		{
			items.sort((i1, i2) -> Long.compare(i2.getHaPrice(), i1.getHaPrice()));
		}
		else
		{
			items.sort((i1, i2) -> Long.compare(i2.getGePrice(), i1.getGePrice()));
		}

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

				AsyncBufferedImage itemImage = itemManager.getImage(item.getId(), Math.abs(item.getQuantity()), Math.abs(item.getQuantity()) > 1);

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
		final long gePrice = item.getGePrice();
		final long haPrice = item.getHaPrice();
		final String ignoredLabel = item.isIgnored() ? " - Ignored" : "";
		return "<html>" + name + " x " + quantity + ignoredLabel
			+ "<br>GE: " + QuantityFormatter.quantityToStackSize(gePrice)
			+ "<br>HA: " + QuantityFormatter.quantityToStackSize(haPrice) + "</html>";
	}
}
