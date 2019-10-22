/*
 * Copyright (c) 2018, Davis Cook <daviscook447@gmail.com>
 * Copyright (c) 2018, Daddy Dozer <Whitedylan7@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.suppliestracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ItemDefinition;
import static net.runelite.api.ItemID.*;
import net.runelite.api.util.Text;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.util.QuantityFormatter;

@Singleton
class SuppliesBox extends JPanel
{
	private static final int ITEMS_PER_ROW = 5;

	private final JPanel itemContainer = new JPanel();
	private final JLabel priceLabel = new JLabel();
	private final JLabel subTitleLabel = new JLabel();
	private final ItemManager itemManager;
	@Getter(AccessLevel.PACKAGE)
	private final String id;
	private final SuppliesTrackerPlugin plugin;
	private final SuppliesTrackerPanel panel;

	@Getter(AccessLevel.PACKAGE)
	private final List<SuppliesTrackerItem> trackedItems = new ArrayList<>();

	private long totalPrice;

	@Getter(AccessLevel.PACKAGE)
	private final ItemType type;

	SuppliesBox(final ItemManager itemManager, final String id,
				final SuppliesTrackerPlugin plugin, final SuppliesTrackerPanel panel,
				final ItemType type)
	{
		this.id = id;
		this.itemManager = itemManager;
		this.plugin = plugin;
		this.panel = panel;
		this.type = type;

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

		priceLabel.setFont(FontManager.getRunescapeSmallFont());
		priceLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		logTitle.add(priceLabel, BorderLayout.EAST);

		add(logTitle, BorderLayout.NORTH);
		add(itemContainer, BorderLayout.CENTER);

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setComponentPopupMenu(popupMenu);

		// Create reset menu
		final JMenuItem reset = new JMenuItem("Reset Category");
		reset.addActionListener(e ->
		{
			for (SuppliesTrackerItem item : trackedItems)
			{
				plugin.clearItem(item.getId());
			}
			clearAll();
			rebuild();
			panel.updateOverall();
		});

		popupMenu.add(reset);

		setVisible(false);
	}

	void update(SuppliesTrackerItem item)
	{
		trackedItems.removeIf(r -> r.getId() == item.getId());
		trackedItems.add(item);
		setVisible(trackedItems.size() > 0);
	}

	private void remove(SuppliesTrackerItem item)
	{
		trackedItems.removeIf(r -> r.getId() == item.getId());
		plugin.clearItem(item.getId());
		setVisible(trackedItems.size() > 0);
	}

	void clearAll()
	{
		trackedItems.clear();
		setVisible(false);
	}

	long getTotalSupplies()
	{
		long totalSupplies = 0;
		for (SuppliesTrackerItem item : trackedItems)
		{
			totalSupplies += item.getQuantity();
		}
		return totalSupplies;
	}

	long getTotalPrice()
	{
		return totalPrice;
	}

	void rebuild()
	{
		buildItems();

		priceLabel.setText(QuantityFormatter.quantityToStackSize(totalPrice) + " gp");
		priceLabel.setToolTipText(QuantityFormatter.formatNumber(totalPrice) + " gp");

		final long supplies = getTotalSupplies();
		if (supplies > 0)
		{
			subTitleLabel.setText("x " + supplies);
		}
		else
		{
			subTitleLabel.setText("");
		}

		validate();
		repaint();
	}

	private void buildItems()
	{
		final List<SuppliesTrackerItem> items = new ArrayList<>(trackedItems);
		totalPrice = 0;

		for (SuppliesTrackerItem item : items)
		{
			totalPrice += item.getPrice();
		}

		items.sort((i1, i2) -> Long.compare(i2.getPrice(), i1.getPrice()));

		// calculates how many rows need to be displayed to fit all item
		final int rowSize = ((items.size() % ITEMS_PER_ROW == 0) ? 0 : 1) + items.size() / ITEMS_PER_ROW;

		itemContainer.removeAll();
		itemContainer.setLayout(new GridLayout(rowSize, ITEMS_PER_ROW, 1, 1));

		for (int i = 0; i < rowSize * ITEMS_PER_ROW; i++)
		{
			final JPanel slotContainer = new JPanel();
			slotContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

			if (i < items.size())
			{
				final SuppliesTrackerItem item = items.get(i);
				final JLabel imageLabel = new JLabel();
				imageLabel.setToolTipText(buildToolTip(getModifiedItemId(item.getName(), item.getId()), item.getQuantity()));
				imageLabel.setVerticalAlignment(SwingConstants.CENTER);
				imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

				AsyncBufferedImage itemImage = itemManager.getImage(getModifiedItemId(item.getName(), item.getId()), item.getQuantity(), item.getQuantity() > 1);
				itemImage.addTo(imageLabel);
				slotContainer.add(imageLabel);

				// create popup menu
				final JPopupMenu popupMenu = new JPopupMenu();
				popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
				slotContainer.setComponentPopupMenu(popupMenu);

				final JMenuItem reset = new JMenuItem("Reset");
				reset.addActionListener(e ->
				{
					remove(item);
					rebuild();
					panel.updateOverall();
				});

				popupMenu.add(reset);
			}
			itemContainer.add(slotContainer);
		}
		itemContainer.repaint();
	}

	private int getModifiedItemId(String name, int itemId)
	{
		if (SuppliesTrackerPlugin.isPotion(name))
		{
			return getSingleDose(name);
		}
		if (SuppliesTrackerPlugin.isCake(name, itemId))
		{
			return getSlice(itemId);
		}
		if (SuppliesTrackerPlugin.isPizzaPie(name))
		{
			return getHalf(itemId);
		}

		return itemId;
	}

	//Switches full cake ids to get the image for slice
	private int getSlice(int itemId)
	{
		switch (itemId)
		{
			case CAKE:
				itemId = SLICE_OF_CAKE;
				break;
			case CHOCOLATE_CAKE:
				itemId = CHOCOLATE_SLICE;
				break;
		}
		return itemId;
	}

	//Switches full pizza and pie ids to get the image for half
	private int getHalf(int itemId)
	{
		switch (itemId)
		{
			case ANCHOVY_PIZZA:
				itemId = _12_ANCHOVY_PIZZA;
				break;
			case MEAT_PIZZA:
				itemId = _12_MEAT_PIZZA;
				break;
			case PINEAPPLE_PIZZA:
				itemId = _12_PINEAPPLE_PIZZA;
				break;
			case PLAIN_PIZZA:
				itemId = _12_PLAIN_PIZZA;
				break;
			case REDBERRY_PIE:
				itemId = HALF_A_REDBERRY_PIE;
				break;
			case GARDEN_PIE:
				itemId = HALF_A_GARDEN_PIE;
				break;
			case SUMMER_PIE:
				itemId = HALF_A_SUMMER_PIE;
				break;
			case FISH_PIE:
				itemId = HALF_A_FISH_PIE;
				break;
			case BOTANICAL_PIE:
				itemId = HALF_A_BOTANICAL_PIE;
				break;
			case MUSHROOM_PIE:
				itemId = HALF_A_MUSHROOM_PIE;
				break;
			case ADMIRAL_PIE:
				itemId = HALF_AN_ADMIRAL_PIE;
				break;
			case WILD_PIE:
				itemId = HALF_A_WILD_PIE;
				break;
			case APPLE_PIE:
				itemId = HALF_AN_APPLE_PIE;
				break;
			case MEAT_PIE:
				itemId = HALF_A_MEAT_PIE;
				break;

		}
		return itemId;
	}

	private int getSingleDose(String name)
	{
		String nameModified = name.replace("(4)", "(1)");
		int itemId = 0;

		if (itemManager.search(nameModified).size() > 0)
		{
			itemId = itemManager.search(nameModified).get(0).getId();
		}

		return itemId;
	}

	private String buildToolTip(int itemId, int qty)
	{
		ItemDefinition item = this.itemManager.getItemDefinition(itemId);
		final String name = item.getName();
		final long price = item.getPrice();
		return name + " x " + qty + " (" + QuantityFormatter.quantityToStackSize(price * qty) + ") ";
	}

}
