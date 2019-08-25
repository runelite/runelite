/*
 * Copyright (c) 2019, Giovds <https://github.com/Giovds>
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

import com.google.common.collect.ImmutableSet;
import java.util.Comparator;
import java.util.stream.Stream;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import static net.runelite.client.plugins.itemstats.Builders.heal;
import static net.runelite.client.plugins.itemstats.Builders.perc;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.StatChange;
import net.runelite.client.plugins.itemstats.StatsChanges;
import static net.runelite.client.plugins.itemstats.stats.Stats.HITPOINTS;
import static net.runelite.client.plugins.itemstats.stats.Stats.RUN_ENERGY;

public class CastleWarsBandage implements Effect
{
	private static final ImmutableSet<Integer> BRACELETS = ImmutableSet.of(
		ItemID.CASTLE_WARS_BRACELET1, ItemID.CASTLE_WARS_BRACELET2, ItemID.CASTLE_WARS_BRACELET3
	);

	private static final double BASE_HP_PERC = .10;
	private static final double BRACELET_HP_PERC = .50;

	@Override
	public StatsChanges calculate(Client client)
	{
		final ItemContainer equipmentContainer = client.getItemContainer(InventoryID.EQUIPMENT);
		final double percH = hasBracelet(equipmentContainer) ? BRACELET_HP_PERC : BASE_HP_PERC;
		final StatChange hitPoints = heal(HITPOINTS, perc(percH, 0)).effect(client);
		final StatChange runEnergy = heal(RUN_ENERGY, 30).effect(client);
		final StatsChanges changes = new StatsChanges(2);
		changes.setStatChanges(new StatChange[]{hitPoints, runEnergy});
		changes.setPositivity(Stream.of(changes.getStatChanges())
			.map(StatChange::getPositivity)
			.max(Comparator.comparing(Enum::ordinal)).get());

		return changes;
	}

	private boolean hasBracelet(ItemContainer equipmentContainer)
	{
		if (equipmentContainer == null)
		{
			return false;
		}

		final Item[] equipment = equipmentContainer.getItems();

		if (equipment.length > EquipmentInventorySlot.GLOVES.getSlotIdx())
		{
			return BRACELETS.contains(equipment[EquipmentInventorySlot.GLOVES.getSlotIdx()].getId());
		}

		return false;
	}
}