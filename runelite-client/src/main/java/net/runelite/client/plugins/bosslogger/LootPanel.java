/*
 * Copyright (c) 2018, TheStonedTurtle <www.github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.bosslogger;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lombok.Getter;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.http.api.item.ItemPrice;

@Getter
class LootPanel extends JPanel
{
	private ArrayList<LootEntry> records;
	private Map<Integer, ArrayList<UniqueItem>> uniqueMap;
	private Map<String, LootRecord> consolidated;
	private ItemManager itemManager;

	LootPanel(ArrayList<LootEntry> records, Map<Integer, ArrayList<UniqueItem>> uniqueMap, ItemManager itemManager)
	{
		this.records = records;
		this.consolidated = new HashMap<>();
		this.uniqueMap = uniqueMap;
		this.itemManager = itemManager;

		setLayout(new GridBagLayout());
		setBorder(new EmptyBorder(0, 2, 0, 2));

		createConsolidatedArray();
		sortUniqueMap();
		createPanel(this);
	}

	private void createConsolidatedArray()
	{
		// Clear consolidated array
		this.consolidated.clear();

		// Compile the DropEntries for unique consolidated totals
		this.records.forEach(rec ->
		{
			// Convert DropEntries records into consolidated entries
			ArrayList<DropEntry> drops = rec.getDrops();
			drops.forEach(de ->
			{
				ItemComposition item = itemManager.getItemComposition(de.getItem_id());
				LootRecord uniq = this.consolidated.get(item.getName());
				if (uniq == null)
				{
					// Create new entry
					boolean shouldStack = item.isStackable() || de.getItem_amount() > 1;
					AsyncBufferedImage icon = itemManager.getImage(de.getItem_id(), de.getItem_amount(), shouldStack);
					Integer price;
					try
					{
						// Get item price
						ItemPrice IM = itemManager.getItemPrice(item.getId());
						if (item.getId() == ItemID.COINS_995)
						{
							price = 1;
						}
						else if (IM == null)
						{
							price = 0;
						}
						else
						{
							price = IM.getPrice();
						}
					}
					catch (IOException e)
					{
						// Fallback price = General Store Buy Price (You selling it to the store)
						price = item.getPrice();
					}

					// Create the new LootRecord
					LootRecord entry = new LootRecord(item.getName(), item.getId(), de.getItem_amount(), price, icon, item);
					this.consolidated.put(item.getName(), entry);
				}
				else
				{
					// Update Entry
					uniq.incrementAmount(uniq, de.getItem_amount());
					uniq.updateIconAmount(uniq, itemManager);
				}
			});
		});

		// Sort consolidated entries by Name
		this.consolidated = this.consolidated.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	// Sort UniqueItems Map by Key
	private void sortUniqueMap()
	{
		this.uniqueMap = this.uniqueMap.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	private void createPanel(LootPanel panel)
	{
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;


		// Attach all the Unique Items first
		this.uniqueMap.forEach((setPosition, set) ->
		{
			UniqueItemPanel p = new UniqueItemPanel(set, this.consolidated, panel.itemManager);
			panel.add(p, c);
			c.gridy++;
		});

		// Attach Kill Count Panel
		if (this.records.size() > 0)
		{
			int amount = this.records.size();
			LootEntry entry = this.records.get(amount - 1);
			LootRecordPanel p = new LootRecordPanel(amount, entry.getKill_count());
			panel.add(p, c);
			c.gridy++;
		}

		// Track total price of all tracked items for this panel
		long totalValue = 0;
		// Ensure it is placed on top of all other panels
		int totalValueIndex = c.gridy;
		c.gridy++;
		// Loop over each unique item and create a LootRecordPanel
		for ( Map.Entry<String, LootRecord> entry : this.consolidated.entrySet())
		{
			LootRecord item = entry.getValue();
			LootRecordPanel p = new LootRecordPanel(item);
			panel.add(p, c);
			c.gridy++;
			totalValue = totalValue + item.getTotal();
		}

		// Only add the total value element if it has something useful to display
		if (totalValue > 0)
		{
			c.gridy = totalValueIndex;
			LootRecordPanel totalPanel = new LootRecordPanel(totalValue);
			panel.add(totalPanel, c);
		}
	}

	// Update Loot Panel with Updated Records
	void updateRecords(ArrayList<LootEntry> records)
	{
		this.records = records;
		refreshPanel();
		this.repaint();
		this.revalidate();
	}

	// Refresh the Panel without updating any data
	private void refreshPanel()
	{
		this.removeAll();
		createConsolidatedArray();
		createPanel(this);
	}
}