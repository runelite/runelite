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
package net.runelite.client.plugins.skillcalculator.banked.components;

import java.awt.GridLayout;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;
import javax.swing.JPanel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.skillcalculator.banked.BankedCalculator;
import net.runelite.client.plugins.skillcalculator.banked.beans.BankedItem;
import net.runelite.client.util.AsyncBufferedImage;

/**
 * A grid that supports mouse events
 */
public class SelectionGrid extends JPanel
{
	private static final int ITEMS_PER_ROW = 5;

	@Getter(AccessLevel.PUBLIC)
	private final Map<BankedItem, GridItem> panelMap = new LinkedHashMap<>();

	@Getter(AccessLevel.PUBLIC)
	private BankedItem selectedItem;

	@Getter(AccessLevel.PUBLIC)
	private BankedItem lastIgnoredItem;

	/* To be executed when this element is clicked */
	@Setter(AccessLevel.PUBLIC)
	private BooleanSupplier onSelectEvent;

	/* To be executed when this element is ignored */
	@Setter(AccessLevel.PUBLIC)
	private BooleanSupplier onIgnoreEvent;

	@Getter(AccessLevel.PUBLIC)
	private final BankedCalculator calc;

	public SelectionGrid(final BankedCalculator calc, final Collection<BankedItem> items, final ItemManager itemManager)
	{
		this.calc = calc;
		// Create a panel for every item
		for (final BankedItem item : items)
		{
			final int qty = calc.getItemQty(item);
			final boolean stackable = item.getItem().getItemInfo().isStackable() || qty > 1;
			final AsyncBufferedImage img = itemManager.getImage(item.getItem().getItemID(), qty, stackable);

			final GridItem gridItem = new GridItem(this, item, img, qty);

			gridItem.setOnSelectEvent(() -> selected(item));
			gridItem.setOnIgnoreEvent(() -> ignore(item));
			panelMap.put(item, gridItem);
		}

		refreshGridDisplay();
	}

	public void refreshGridDisplay()
	{
		this.removeAll();

		final List<GridItem> items = panelMap.values().stream().filter(gi -> gi.getAmount() > 0).collect(Collectors.toList());

		// Calculates how many rows need to be display to fit all items
		final int rowSize = ((items.size() % ITEMS_PER_ROW == 0) ? 0 : 1) + items.size() / ITEMS_PER_ROW;
		setLayout(new GridLayout(rowSize, ITEMS_PER_ROW, 1, 1));

		for (final GridItem gridItem : items)
		{
			// Select the first option
			if (selectedItem == null)
			{
				gridItem.select();
			}

			this.add(gridItem);
		}
	}

	private boolean selected(final BankedItem item)
	{
		final BankedItem old = this.selectedItem;
		if (item.equals(old))
		{
			return false;
		}

		// Set selected item now so the boolean can see what was just clicked
		this.selectedItem = item;
		if (onSelectEvent != null && !onSelectEvent.getAsBoolean())
		{
			this.selectedItem = old;
			return false;
		}

		final GridItem gridItem = panelMap.get(old);
		if (gridItem != null)
		{
			gridItem.unselect();
		}

		return true;
	}

	private boolean ignore(final BankedItem item)
	{
		this.lastIgnoredItem = item;
		return onIgnoreEvent.getAsBoolean();
	}
}