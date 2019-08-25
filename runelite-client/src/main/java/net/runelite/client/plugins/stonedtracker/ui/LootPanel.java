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
package net.runelite.client.plugins.stonedtracker.ui;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multimap;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.loottracker.localstorage.LTItemEntry;
import net.runelite.client.plugins.loottracker.localstorage.LTRecord;
import net.runelite.client.plugins.stonedtracker.ItemSortTypes;
import net.runelite.client.plugins.stonedtracker.data.UniqueItem;
import net.runelite.client.ui.ColorScheme;

@Slf4j
class LootPanel extends JPanel
{
	private final String name;
	private final Collection<LTRecord> records;
	private final Collection<UniqueItem> uniques;
	private final boolean hideUniques;
	private final ItemSortTypes sortType;
	private final boolean itemBreakdown;
	private final ItemManager itemManager;
	// Consolidate LTItemEntries stored by ItemID
	private final Map<Integer, LTItemEntry> consolidated = new HashMap<>();

	private boolean playbackPlaying = false;
	private boolean cancelPlayback = false;

	LootPanel(
		final String name,
		final Collection<LTRecord> records,
		final Collection<UniqueItem> uniques,
		final boolean hideUnqiues,
		final ItemSortTypes sort,
		final boolean itemBreakdown,
		final ItemManager itemManager)
	{
		this.name = name;
		this.records = records;
		this.uniques = uniques;
		this.hideUniques = hideUnqiues;
		this.sortType = sort;
		this.itemBreakdown = itemBreakdown;
		this.itemManager = itemManager;

		setLayout(new GridBagLayout());
		setBorder(new EmptyBorder(0, 10, 0, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		createPanel(this.records, true);
	}

	/**
	 * Sorts the collection of LTItemEntry based on the selected {@link ItemSortTypes}
	 *
	 * @param sortType The {@link ItemSortTypes} describing how these entries should be sorted
	 * @return returns the sorted list
	 */
	private static Comparator<LTItemEntry> createLTItemEntryComparator(final ItemSortTypes sortType)
	{
		return (o1, o2) ->
		{
			switch (sortType)
			{
				case ITEM_ID:
					return o1.getId() - o2.getId();
				case PRICE:
					if (o1.getPrice() != o2.getPrice())
					{
						return o1.getPrice() > o2.getPrice() ? -1 : 1;
					}
					break;
				case VALUE:
					if (o1.getTotal() != o2.getTotal())
					{
						return o1.getTotal() > o2.getTotal() ? -1 : 1;
					}
					break;
				case ALPHABETICAL:
					// Handled below
					break;
				default:
					log.warn("Sort Type not being handled correctly, defaulting to alphabetical.");
					break;
			}

			// Default to alphabetical
			return o1.getName().compareTo(o2.getName());
		};
	}

	private void createPanel(final Collection<LTRecord> records, final boolean reconsolidate)
	{
		final GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;

		if (reconsolidate)
		{
			this.consolidated.clear();
			final Collection<LTItemEntry> consolidatedLTItemEntries = LTRecord.consolidateLTItemEntries(records);
			final Map<Integer, LTItemEntry> itemMap = LTItemEntry.consolidateItemEntires(consolidatedLTItemEntries);
			this.consolidated.putAll(itemMap);
		}

		// Create necessary helpers for the unique toggles
		final Multimap<Integer, UniqueItem> positionMap = ArrayListMultimap.create();
		final Set<Integer> uniqueIds = new HashSet<>();

		// Loop over all UniqueItems and check how many the player has received as a drop for each
		// Also add all Item IDs for uniques to a Set for easy hiding later on.
		for (final UniqueItem item : this.uniques)
		{
			final int id = item.getItemID();
			final int linkedId = item.getLinkedID();
			uniqueIds.add(id);
			uniqueIds.add(linkedId);

			final LTItemEntry entry = this.consolidated.get(id);
			final LTItemEntry notedEntry = this.consolidated.get(linkedId);
			final int qty = (entry == null ? 0 : entry.getQuantity()) + (notedEntry == null ? 0 : notedEntry.getQuantity());
			item.setQty(qty);
			positionMap.put(item.getPosition(), item);
		}

		for (final int position : positionMap.keySet())
		{
			final Collection<UniqueItem> uniques = positionMap.get(position);

			final UniqueItemPanel p = new UniqueItemPanel(uniques, this.itemManager);
			this.add(p, c);
			c.gridy++;
		}

		// Attach Kill Count Panel(s)
		final int amount = records.size();
		String currentText;
		String loggedText;

		log.debug(name);

		switch (name)
		{
			case "Wintertodt":
				currentText = "Current Killcount:";
				loggedText = "Crates logged:";
				break;
			case "Herbiboar":
				currentText = "Herbiboars looted:";
				loggedText = "Loots logged:";
				break;
			case "Brimstone Chest":
			case "Crystal Chest":
			case "Larran's big chest":
			case "Larran's small chest":
			case "Elven Crystal Chest":
				currentText = "Chests opened:";
				loggedText = "Chests logged:";
				break;
			case  "Clue Scroll (Beginner)":
			case  "Clue Scroll (Easy)":
			case  "Clue Scroll (Medium)":
			case  "Clue Scroll (Hard)":
			case  "Clue Scroll (Elite)":
			case  "Clue Scroll (Master)":
				currentText = "Clues completed:";
				loggedText = "Clues logged:";
				break;
			default:
				currentText = "Current Killcount:";
				loggedText = "Kills logged:";
				break;
		}

		if (amount > 0)
		{
			final LTRecord entry = Iterators.get(records.iterator(), (amount - 1));
			if (entry.getKillCount() != -1)
			{
				final TextPanel p = new TextPanel(currentText, entry.getKillCount());
				this.add(p, c);
				c.gridy++;
			}
		}

		final TextPanel p2 = new TextPanel(loggedText, amount);
		this.add(p2, c);
		c.gridy++;

		// Track total price of all tracked items for this panel
		// Also ensure it is placed in correct location by preserving its gridy value
		long totalValue = consolidated.values().stream().mapToLong(e -> e.getPrice() * e.getQuantity()).sum();
		final int totalValueIndex = c.gridy;
		c.gridy++;


		final Collection<LTItemEntry> itemsToDisplay = consolidated.values().stream()
			.filter(e -> !(hideUniques && uniqueIds.contains(e.getId())))
			.sorted(createLTItemEntryComparator(sortType))
			.collect(Collectors.toList());

		if (itemsToDisplay.size() > 0)
		{
			if (itemBreakdown)
			{
				for (final LTItemEntry e : itemsToDisplay)
				{
					final ItemPanel p = new ItemPanel(e, itemManager);
					this.add(p, c);
					c.gridy++;
				}
			}
			else
			{
				final LootGrid grid = new LootGrid(itemsToDisplay.toArray(new LTItemEntry[0]), itemManager);
				this.add(grid, c);
				c.gridy++;
			}
		}

		// Only add the total value element if it has something useful to display
		if (totalValue > 0)
		{
			c.gridy = totalValueIndex;
			final TextPanel totalPanel = new TextPanel("Total Value:", totalValue);
			this.add(totalPanel, c);
		}
	}

	void addedRecord(final LTRecord record)
	{
		records.add(record);
		for (final LTItemEntry entry : record.getDrops())
		{
			final LTItemEntry current = consolidated.get(entry.getId());
			if (current != null)
			{
				entry.setQuantity(entry.getQuantity() + current.getQuantity());
			}
			consolidated.put(entry.getId(), entry);

		}
		// TODO: Smarter update system so it only repaints necessary Item and Text Panels
		this.removeAll();

		this.createPanel(this.records, false);

		this.revalidate();
		this.repaint();
	}

	void playback()
	{
		if (playbackPlaying)
		{
			cancelPlayback = true;
			return;
		}

		playbackPlaying = true;

		if (this.records.size() > 0)
		{
			final Collection<LTRecord> recs = new ArrayList<>();
			for (final LTRecord r : this.records)
			{
				recs.add(r);

				SwingUtilities.invokeLater(() -> refreshPlayback(recs));

				try
				{
					if (cancelPlayback)
					{
						playbackPlaying = false;
						cancelPlayback = false;
						SwingUtilities.invokeLater(() -> refreshPlayback(this.records));
						break;
					}
					// TODO: Allow this rate to be configurable?
					Thread.sleep(250);
				}
				catch (InterruptedException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}

		playbackPlaying = false;
	}

	private void refreshPlayback(final Collection<LTRecord> recs)
	{
		this.removeAll();

		this.createPanel(recs, true);

		this.revalidate();
		this.repaint();
	}
}
