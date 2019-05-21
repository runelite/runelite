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
package net.runelite.client.plugins.stonedloottracker.ui;

import com.google.common.base.Strings;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.stonedloottracker.data.LootRecordCustom;
import net.runelite.client.plugins.stonedloottracker.data.LootTrackerItemEntry;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.StackFormatter;
import net.runelite.client.util.Text;

@Getter
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
	private final List<LootRecordCustom> records = new ArrayList<>();

	private long totalPrice;
	private long totalHaPrice;

	LootTrackerBox(final ItemManager itemManager, final String id, @Nullable final String subtitle, LootRecordCustom record)
	{
		this.id = id;
		this.itemManager = itemManager;
		this.records.add(record);

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

		buildItems();
	}

	/**
	 * This method creates stacked items from the item list, calculates total price and then
	 * displays all the items in the UI.
	 */
	private void buildItems()
	{
		final List<LootTrackerItemEntry> allItems = new ArrayList<>();
		final List<LootTrackerItemEntry> items = new ArrayList<>();
		totalPrice = 0;
		totalHaPrice = 0;

		for (LootRecordCustom record : records)
		{
			allItems.addAll(record.getDrops());
		}

		for (final LootTrackerItemEntry entry : dedupeClues(allItems))
		{
			totalPrice += (entry.getPrice() * entry.getQuantity());
			totalHaPrice += (entry.getHaPrice() * entry.getQuantity());

			int quantity = 0;
			for (final LootTrackerItemEntry i : items)
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
				long pricePerItem = entry.getPrice();
				long haPricePerItem = entry.getHaPrice();

				items.add(new LootTrackerItemEntry(entry.getName(), entry.getId(), newQuantity, pricePerItem, haPricePerItem, false));
			}
			else
			{
				items.add(entry);
			}
		}

		items.sort((i1, i2) -> Long.compare(i2.getPrice(), i1.getPrice()));

		// Calculates how many rows need to be display to fit all items
		final int rowSize = rowSize(items.size());

		resetContainer(itemContainer, rowSize);

		for (int i = 0; i < rowSize * ITEMS_PER_ROW; i++)
		{
			final JPanel slotContainer = new JPanel();
			slotContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

			if (i < items.size())
			{
				final LootTrackerItemEntry item = items.get(i);
				final JLabel imageLabel = buildimageLabel(itemManager, item);
				slotContainer.add(imageLabel);
			}

			itemContainer.add(slotContainer);
		}

		itemContainer.repaint();

		priceLabel.setText(StackFormatter.quantityToStackSize(totalPrice) + " gp (HA: " + StackFormatter.quantityToStackSize(totalHaPrice) + ")");
		priceLabel.setToolTipText(StackFormatter.formatNumber(totalPrice) + " gp (HA: " + StackFormatter.formatNumber(totalHaPrice) + ")");
		if (records.size() > 1)
		{
			subTitleLabel.setText("x " + records.size());
		}

		repaint();
	}

	static ArrayList<LootTrackerItemEntry> dedupeClues(List<LootTrackerItemEntry> items)
	{
		final ArrayList<LootTrackerItemEntry> newItems = new ArrayList<>();

		int eliteClues = 0;
		int hardClues = 0;
		int mediumClues = 0;
		int easyClues = 0;
		int beginnerClues = 0;

		LootTrackerItemEntry eliteClue = null;
		LootTrackerItemEntry hardClue = null;
		LootTrackerItemEntry mediumClue = null;
		LootTrackerItemEntry easyClue = null;
		LootTrackerItemEntry beginnerClue = null;

		for (LootTrackerItemEntry lootEntry : items)
		{
			if (lootEntry == null)
			{
				continue;
			}

			String name = lootEntry.getName();

			if (lootEntry.getName().contains("Clue scroll ("))
			{
				if (name.contains("elite"))
				{
					eliteClues += lootEntry.getQuantity();
					eliteClue = lootEntry;
				}
				else if (name.contains("hard"))
				{
					hardClues += lootEntry.getQuantity();
					hardClue = lootEntry;
				}
				else if (name.contains("medium"))
				{
					mediumClues += lootEntry.getQuantity();
					mediumClue = lootEntry;
				}
				else if (name.contains("easy"))
				{
					easyClues += lootEntry.getQuantity();
					easyClue = lootEntry;
				}
				else if (name.contains("beginner"))
				{
					beginnerClues += lootEntry.getQuantity();
					beginnerClue = lootEntry;
				}

				continue;
			}

			newItems.add(lootEntry);
		}

		LootTrackerItemEntry[] clueArray = {beginnerClue, easyClue, mediumClue, hardClue, eliteClue};
		int[] clueAmountArray = {beginnerClues, easyClues, mediumClues, hardClues, eliteClues};

		for (int i = 0; i < 4; i++)
		{
			if (clueAmountArray[i] > 0)
			{
				newItems.add(createNewLootEntry(Objects.requireNonNull(clueArray[i]), clueAmountArray[i]));
			}
		}

		return newItems;
	}

	private static LootTrackerItemEntry createNewLootEntry(LootTrackerItemEntry item, int amount)
	{
		return new LootTrackerItemEntry(
			item.getName(),
			item.getId(),
			amount,
			item.getPrice(),
			item.getHaPrice(),
			item.isStackable()
		);
	}

	static int rowSize(int items)
	{
		return ((items % ITEMS_PER_ROW == 0) ? 0 : 1) + items / ITEMS_PER_ROW;
	}

	private static void resetContainer(JPanel itemContainer, int rowSize)
	{
		itemContainer.removeAll();
		itemContainer.setLayout(new GridLayout(rowSize, ITEMS_PER_ROW, 1, 1));
	}

	private static JLabel buildimageLabel(ItemManager itemManager, LootTrackerItemEntry item)
	{
		final JLabel imageLabel = new JLabel();
		imageLabel.setToolTipText(UniqueItemPanel.tooltipText(item.getPrice(), item.getHaPrice(), item.getQuantity(), item.getName()));
		imageLabel.setVerticalAlignment(SwingConstants.CENTER);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemManager.getImage(item.getId(), item.getQuantity(), item.getQuantity() > 1).addTo(imageLabel);

		return imageLabel;
	}
}