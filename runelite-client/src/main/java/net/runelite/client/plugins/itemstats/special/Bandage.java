/*
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.itemstats.special;

import lombok.RequiredArgsConstructor;
import net.runelite.api.*;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.SimpleStatBoost;
import net.runelite.client.plugins.itemstats.StatsChanges;
import net.runelite.client.plugins.itemstats.stats.Stat;
import org.apache.commons.lang3.ArrayUtils;

import static net.runelite.client.plugins.itemstats.Builders.perc;
import static net.runelite.client.plugins.itemstats.stats.Stats.HITPOINTS;
import static net.runelite.client.plugins.itemstats.stats.Stats.RUN_ENERGY;

@RequiredArgsConstructor
public class Bandage implements Effect
{
	// Stats
	private final Stat[] bandageStats = new Stat[]
			{
					RUN_ENERGY, HITPOINTS
			};

	// ID's
	private final int[] braceletIDs =
			{
					ItemID.CASTLE_WARS_BRACELET3,
					ItemID.CASTLE_WARS_BRACELET2,
					ItemID.CASTLE_WARS_BRACELET1
			};
	private final int glovesSlotID = EquipmentInventorySlot.GLOVES.getSlotIdx();

	// Percentages
	private final double percH = 0.1; // Default healing percentage
	private final double percHB = 0.5; // Bracelet healing percentage
	private final double percR = 0.3; // Default run energy percentage
	private final int delta; // ask what delta does

	@Override
	public StatsChanges calculate(Client client)
	{
		StatsChanges changes = new StatsChanges(2);
		SimpleStatBoost hitpoints = new SimpleStatBoost(HITPOINTS, true, perc(percH, delta));
		SimpleStatBoost runEnergy = new SimpleStatBoost(RUN_ENERGY, false, perc(percR, delta));
		ItemContainer equipmentContainer = client.getItemContainer(InventoryID.EQUIPMENT);

		if (equipmentContainer != null)
		{
			if (hasBracelet(equipmentContainer))
			{
				hitpoints = new SimpleStatBoost(HITPOINTS, true, perc(percHB, delta));
			}
		}

		return changes;
	}

	private boolean hasBracelet(ItemContainer equipmentContainer)
	{
		boolean hasBracelet = false;

		if (equipmentContainer != null)
		{
			Item[] equipment = equipmentContainer.getItems();
			if (contains(braceletIDs, equipment[glovesSlotID].getId()))
			{
				return hasBracelet = true;
			}
		}
		return hasBracelet;
	}

	private boolean contains(final int[] array, final int key)
	{
		return ArrayUtils.contains(array, key);
	}
}