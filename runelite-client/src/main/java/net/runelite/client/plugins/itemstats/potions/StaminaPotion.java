/*
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2021, Tanlines <tanlines@outlook.com.au>
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
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.plugins.itemstats.StatBoost;
import static net.runelite.client.plugins.itemstats.stats.Stats.RUN_ENERGY;

public class StaminaPotion extends StatBoost
{
	private final int baseRestore;

	public StaminaPotion(int baseRestore)
	{
		super(RUN_ENERGY, false);
		this.baseRestore = baseRestore;
	}

	@Override
	public int heals(Client client)
	{
		ItemContainer equipContainer = client.getItemContainer(InventoryID.WORN);
		if (equipContainer != null)
		{
			Item ring = equipContainer.getItem(EquipmentInventorySlot.RING.getSlotIdx());
			if (ring != null && ring.getId() == ItemID.RING_OF_ENDURANCE)
			{
				return baseRestore * 2;
			}
		}
		return baseRestore;
	}
}
