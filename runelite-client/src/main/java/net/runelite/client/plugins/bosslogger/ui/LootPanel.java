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
package net.runelite.client.plugins.bosslogger.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Comparator;
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
import net.runelite.client.plugins.bosslogger.UniqueItem;
import net.runelite.client.plugins.bosslogger.data.DropEntry;
import net.runelite.client.plugins.bosslogger.data.LootEntry;
import net.runelite.client.plugins.bosslogger.data.LootRecord;
import net.runelite.client.ui.ColorScheme;
import net.runelite.http.api.item.ItemPrice;

@Getter
public class LootPanel extends JPanel
{
	private ArrayList<LootEntry> records;
	private Map<Integer, ArrayList<UniqueItem>> uniqueMap;
	private Map<Integer, LootRecord> consolidated;
	private ItemManager itemManager;

	public LootPanel(ArrayList<LootEntry> records, Map<Integer, ArrayList<UniqueItem>> uniqueMap, ItemManager itemManager)
	{
		this.records = records;
		this.consolidated = new HashMap<>();
		this.uniqueMap = uniqueMap;
		this.itemManager = itemManager;

		setLayout(new GridBagLayout());
		setBorder(new EmptyBorder(0, 10, 0, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

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
				ItemComposition item = itemManager.getUnnotedItemComposition(de.getItemId());
				LootRecord uniq = this.consolidated.get(de.getItemId());
				if (uniq == null)
				{
					// Create new entry
					boolean shouldStack = item.isStackable() || de.getItemAmount() > 1;
					AsyncBufferedImage icon = itemManager.getImage(de.getItemId(), de.getItemAmount(), shouldStack);
					int price;
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
					catch (Exception e)
					{
						// Fallback price = General Store Buy Price (You selling it to the store)
						price = item.getPrice();
					}

					// Create the new LootRecord
					LootRecord entry = new LootRecord(item.getName(), de.getItemId(), de.getItemAmount(), price, icon, item);
					this.consolidated.put(de.getItemId(), entry);
				}
				else
				{
					// Update Entry
					uniq.incrementAmount(uniq, de.getItemAmount());
					uniq.updateIconAmount(uniq, itemManager);
				}
			});
		});

		// Sort consolidated entries by Name
		this.consolidated = this.consolidated.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(new Comparator<LootRecord>()
				{
					@Override
					public int compare(LootRecord o1, LootRecord o2)
					{
						return o1.getItemName().compareTo(o2.getItemName());
					}
				}))
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
			LootRecordPanel p = new LootRecordPanel("Current Killcount:", entry.getKillCount());
			panel.add(p, c);
			c.gridy++;
			LootRecordPanel p2 = new LootRecordPanel("Kills Logged:", amount);
			panel.add(p2, c);
			c.gridy++;
		}

		// Track total price of all tracked items for this panel
		long totalValue = 0;
		// Ensure it is placed on top of all other panels
		int totalValueIndex = c.gridy;
		c.gridy++;
		// Loop over each unique item and create a LootRecordPanel
		for ( Map.Entry<Integer, LootRecord> entry : this.consolidated.entrySet())
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