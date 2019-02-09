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
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.StackFormatter;
import net.runelite.client.util.Text;

class LootTrackerBox extends JPanel
{
	private static final int ITEMS_PER_ROW = 5;

	private final JPanel itemContainer = new JPanel();
	private final JLabel priceLabel = new JLabel();
	private final JLabel subTitleLabel = new JLabel();
	private final ItemManager itemManager;
	@Getter(AccessLevel.PACKAGE)
	private final String id;

	@Getter
	private final List<LootTrackerRecord> records = new ArrayList<>();

	private long totalPrice;
	private boolean hideIgnoredItems;
	private BiConsumer<String, Boolean> onItemToggle;

	LootTrackerBox(
		final ItemManager itemManager,
		final String id,
		@Nullable final String subtitle,
		final boolean hideIgnoredItems,
		final BiConsumer<String, Boolean> onItemToggle)
	{
		this.id = id;
		this.itemManager = itemManager;
		this.onItemToggle = onItemToggle;
		this.hideIgnoredItems = hideIgnoredItems;

		setLayout(new BorderLayout(0, 1));
		setBorder(new EmptyBorder(5, 0, 0, 0));

		final JPanel logTitle = new JPanel(new BorderLayout(5, 0));
		logTitle.setBorder(new EmptyBorder(7, 7, 7, 7));
		logTitle.setBackground(ColorScheme.DARKER_GRAY_COLOR.darker());

		final JLabel titleLabel = new JLabel(Text.removeTags(id));
		titleLabel.setFont(FontManager.getRunescapeSmallFont());
		titleLabel.setForeground(Color.WHITE);

		logTitle.add(titleLabel, BorderLayout.WEST);

		subTitleLabel.setFont(FontManager.getRunescapeSmallFont());
		subTitleLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		logTitle.add(subTitleLabel, BorderLayout.CENTER);

		if (!Strings.isNullOrEmpty(subtitle))
		{
			subTitleLabel.setText(subtitle);
		}

		priceLabel.setFont(FontManager.getRunescapeSmallFont());
		priceLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		logTitle.add(priceLabel, BorderLayout.EAST);

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
			? records.stream().filter(r -> !Arrays.stream(r.getItems()).allMatch(LootTrackerItem::isIgnored)).count()
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

		priceLabel.setText(StackFormatter.quantityToStackSize(totalPrice) + " gp");
		priceLabel.setToolTipText(StackFormatter.formatNumber(totalPrice) + " gp");

		final long kills = getTotalKills();
		if (kills > 1)
		{
			subTitleLabel.setText("x " + kills);
		}

		validate();
		repaint();
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

			totalPrice += entry.getPrice();

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

			if (quantity > 0)
			{
				int newQuantity = entry.getQuantity() + quantity;
				long pricePerItem = entry.getPrice() == 0 ? 0 : (entry.getPrice() / entry.getQuantity());

				items.add(new LootTrackerItem(entry.getId(), entry.getName(), newQuantity, pricePerItem * newQuantity, entry.isIgnored()));
			}
			else
			{
				items.add(entry);
			}
		}

		items.sort((i1, i2) -> Long.compare(i2.getPrice(), i1.getPrice()));

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
					itemImage.onChanged(addTransparency);
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
		final long price = item.getPrice();
		final String ignoredLabel = item.isIgnored() ? " - Ignored" : "";
		return name + " x " + quantity + " (" + StackFormatter.quantityToStackSize(price) + ") " + ignoredLabel;
	}
}
