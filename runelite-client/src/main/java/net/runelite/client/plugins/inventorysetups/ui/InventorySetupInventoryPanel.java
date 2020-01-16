/*
 * Copyright (c) 2019, dillydill123 <https://github.com/dillydill123>
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
package net.runelite.client.plugins.inventorysetups.ui;

import net.runelite.client.plugins.inventorysetups.InventorySetupSlotID;
import net.runelite.client.plugins.inventorysetups.InventorySetupPlugin;
import net.runelite.api.ItemID;
import org.apache.commons.lang3.tuple.ImmutablePair;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.inventorysetups.InventorySetup;
import net.runelite.client.plugins.inventorysetups.InventorySetupItem;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.ui.ColorScheme;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

public class InventorySetupInventoryPanel extends InventorySetupContainerPanel
{

	private static final int ITEMS_PER_ROW = 4;
	private static final int NUM_INVENTORY_ITEMS = 28;

	private ArrayList<InventorySetupSlot> inventorySlots;
	private InventorySetupRunePouchPanel rpPanel;

	InventorySetupInventoryPanel(final ItemManager itemManager, final InventorySetupPlugin plugin, final InventorySetupRunePouchPanel rpPanel)
	{
		super(itemManager, plugin, "Inventory");
		this.rpPanel = rpPanel;
	}

	@Override
	public void setupContainerPanel(final JPanel containerSlotsPanel)
	{
		this.inventorySlots = new ArrayList<>();
		for (int i = 0; i < NUM_INVENTORY_ITEMS; i++)
		{
			inventorySlots.add(new InventorySetupSlot(ColorScheme.DARKER_GRAY_COLOR, InventorySetupSlotID.INVENTORY, i));
		}

		int numRows = (NUM_INVENTORY_ITEMS + ITEMS_PER_ROW - 1) / ITEMS_PER_ROW;
		containerSlotsPanel.setLayout(new GridLayout(numRows, ITEMS_PER_ROW, 1, 1));
		for (int i = 0; i < NUM_INVENTORY_ITEMS; i++)
		{
			containerSlotsPanel.add(inventorySlots.get(i));
			super.addMouseListenerToSlot(inventorySlots.get(i));
		}
	}

	@Override
	public void highlightSlotDifferences(final ArrayList<InventorySetupItem> currInventory, final InventorySetup inventorySetup)
	{
		final ArrayList<InventorySetupItem> inventoryToCheck = inventorySetup.getInventory();

		assert currInventory.size() == inventoryToCheck.size() : "size mismatch";

		isHighlighted = true;

		if (inventorySetup.isUnorderedHighlight())
		{
			doUnorderedHighlighting(currInventory, inventorySetup);
			return;
		}

		boolean currInvHasRunePouch = false;
		for (int i = 0; i < NUM_INVENTORY_ITEMS; i++)
		{
			InventorySetupItem currInvItem = currInventory.get(i);
			if (!currInvHasRunePouch && ItemVariationMapping.map(currInvItem.getId()) == ItemID.RUNE_POUCH)
			{
				currInvHasRunePouch = true;
			}
			super.highlightDifferentSlotColor(inventorySetup, inventoryToCheck.get(i), currInventory.get(i), inventorySlots.get(i));
		}

		handleRunePouchHighlighting(inventorySetup, currInvHasRunePouch);

	}

	@Override
	public void setSlots(final InventorySetup setup)
	{
		for (int i = 0; i < NUM_INVENTORY_ITEMS; i++)
		{
			super.setContainerSlot(i, inventorySlots.get(i), setup);
		}

		validate();
		repaint();
	}

	@Override
	public void resetSlotColors()
	{
		// Don't waste time resetting if we were never highlighted to begin with
		if (!isHighlighted)
		{
			return;
		}

		for (InventorySetupSlot inventorySlot : inventorySlots)
		{
			inventorySlot.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		}

		rpPanel.resetSlotColors();

		isHighlighted = false;
	}

	private void doUnorderedHighlighting(final ArrayList<InventorySetupItem> currInventory, final InventorySetup inventorySetup)
	{
		HashMap<ImmutablePair<Integer, Integer>, Integer> currInvMap = new HashMap<>();

		boolean currInvHasRunePouch = false;
		for (final InventorySetupItem item : currInventory)
		{
			// Use variation mapping if necessary and set the quantity to 1 if ignoring stacks
			int itemId = inventorySetup.isVariationDifference() ? item.getId() : ItemVariationMapping.map(item.getId());
			int quantity = inventorySetup.isStackDifference() ? item.getQuantity() : 1;

			if (ItemVariationMapping.map(item.getId()) == ItemID.RUNE_POUCH)
			{
				currInvHasRunePouch = true;
			}

			ImmutablePair<Integer, Integer> key = new ImmutablePair<>(itemId, quantity);
			int count = currInvMap.get(key) == null ? 0 : currInvMap.get(key);
			currInvMap.put(key, count + 1);
		}

		final ArrayList<InventorySetupItem> setupInv = inventorySetup.getInventory();
		for (int i = 0; i < setupInv.size(); i++)
		{
			final InventorySetupItem item = setupInv.get(i);

			/*
			 don't count empty spaces. We only want to show items that are missing, not "extra items"
			 that would be indicated by highlighting empty slots.
			*/
			if (item.getId() == -1)
			{
				inventorySlots.get(i).setBackground(ColorScheme.DARKER_GRAY_COLOR);
				continue;
			}

			// Use variation mapping if necessary and set the quantity to 1 if ignoring stacks
			int itemId = inventorySetup.isVariationDifference() ? item.getId() : ItemVariationMapping.map(item.getId());
			int quantity = inventorySetup.isStackDifference() ? item.getQuantity() : 1;

			ImmutablePair<Integer, Integer> key = new ImmutablePair<>(itemId, quantity);
			Integer currentCount = currInvMap.get(key);

			// current inventory doesn't have this item, highlight
			if (currentCount == null)
			{
				inventorySlots.get(i).setBackground(inventorySetup.getHighlightColor());
				continue;
			}

			if (currentCount == 1)
			{
				currInvMap.remove(key);
			}
			else
			{
				currInvMap.put(key, currentCount - 1);
			}

			inventorySlots.get(i).setBackground(ColorScheme.DARKER_GRAY_COLOR);

		}

		handleRunePouchHighlighting(inventorySetup, currInvHasRunePouch);

	}

	private void handleRunePouchHighlighting(final InventorySetup inventorySetup, boolean currInvHasRunePouch)
	{
		if (inventorySetup.getRune_pouch() != null)
		{

			// attempt to highlight if rune pouch is available
			if (currInvHasRunePouch)
			{
				ArrayList<InventorySetupItem> runePouchToCheck = plugin.getRunePouchData();
				rpPanel.highlightSlotDifferences(runePouchToCheck, inventorySetup);
			}
			else // if the current inventory doesn't have a rune pouch but the setup does, highlight the RP pouch
			{
				rpPanel.highlightAllSlots(inventorySetup);
			}
		}
		else
		{
			rpPanel.resetSlotColors();
		}
	}
}
