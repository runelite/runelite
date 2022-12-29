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
package net.runelite.client.plugins.itemstats.potions;

import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.plugins.itemstats.StatBoost;
import static net.runelite.client.plugins.itemstats.stats.Stats.PRAYER;

public class PrayerPotion extends StatBoost
{
	private static final double BASE_PERC = .25;
	private final int delta;
	private final double perc;

	public PrayerPotion(int delta)
	{
		this(delta, BASE_PERC);
	}

	PrayerPotion(int delta, double perc)
	{
		super(PRAYER, false);
		this.delta = delta;
		this.perc = perc;
	}

	private static final int RING_SLOT = EquipmentInventorySlot.RING.getSlotIdx();
	private static final int CAPE_SLOT = EquipmentInventorySlot.CAPE.getSlotIdx();

	@Override
	public int heals(Client client)
	{
		boolean hasHolyWrench = false;

		ItemContainer equipContainer = client.getItemContainer(InventoryID.EQUIPMENT);
		if (equipContainer != null)
		{
			Item cape = equipContainer.getItem(CAPE_SLOT);
			Item ring = equipContainer.getItem(RING_SLOT);

			hasHolyWrench = ring != null && ItemVariationMapping.getVariations(ItemID.RING_OF_THE_GODS)
				.stream()
				.filter(itemId -> itemId != ItemID.RING_OF_THE_GODS) // remove non-imbued rotg; it does not have the wrench effect
				.anyMatch(itemId -> itemId == ring.getId());
			if (cape != null)
			{
				int capeId = cape.getId();
				hasHolyWrench |= ItemVariationMapping.getVariations(ItemID.PRAYER_CAPE).contains(capeId);
				hasHolyWrench |= ItemVariationMapping.getVariations(ItemID.MAX_CAPE).contains(capeId);
			}
		}
		if (!hasHolyWrench)
		{
			ItemContainer invContainer = client.getItemContainer(InventoryID.INVENTORY);
			if (invContainer != null)
			{
				for (Item itemStack : invContainer.getItems())
				{
					int item = itemStack.getId();
					hasHolyWrench = item == ItemID.HOLY_WRENCH;
					hasHolyWrench |= ItemVariationMapping.getVariations(ItemID.PRAYER_CAPE).contains(item);
					hasHolyWrench |= ItemVariationMapping.getVariations(ItemID.MAX_CAPE).contains(item);

					if (hasHolyWrench)
					{
						break;
					}
				}
			}
		}

		double percent = hasHolyWrench ? perc + .02 : perc;
		int max = getStat().getMaximum(client);
		return (((int) (max * percent)) * (delta >= 0 ? 1 : -1)) + delta;
	}

}
