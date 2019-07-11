/*
 * Copyright (c) 2018 raiyni <https://github.com/raiyni>
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
package net.runelite.client.util;

import com.google.common.collect.ImmutableSet;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import static net.runelite.api.ItemID.*;

public enum Graceful
{
	// TODO: It would be nice if we have the IDs for just the equipped variants of the Graceful set items.
	HOOD(
		GRACEFUL_HOOD_11851, GRACEFUL_HOOD_13579, GRACEFUL_HOOD_13580, GRACEFUL_HOOD_13591, GRACEFUL_HOOD_13592,
		GRACEFUL_HOOD_13603, GRACEFUL_HOOD_13604, GRACEFUL_HOOD_13615, GRACEFUL_HOOD_13616, GRACEFUL_HOOD_13627,
		GRACEFUL_HOOD_13628, GRACEFUL_HOOD_13667, GRACEFUL_HOOD_13668, GRACEFUL_HOOD_21061, GRACEFUL_HOOD_21063
	),

	TOP(
		GRACEFUL_TOP_11855, GRACEFUL_TOP_13583, GRACEFUL_TOP_13584, GRACEFUL_TOP_13595, GRACEFUL_TOP_13596,
		GRACEFUL_TOP_13607, GRACEFUL_TOP_13608, GRACEFUL_TOP_13619, GRACEFUL_TOP_13620, GRACEFUL_TOP_13631,
		GRACEFUL_TOP_13632, GRACEFUL_TOP_13671, GRACEFUL_TOP_13672, GRACEFUL_TOP_21067, GRACEFUL_TOP_21069
	),

	LEGS(
		GRACEFUL_LEGS_11857, GRACEFUL_LEGS_13585, GRACEFUL_LEGS_13586, GRACEFUL_LEGS_13597, GRACEFUL_LEGS_13598,
		GRACEFUL_LEGS_13609, GRACEFUL_LEGS_13610, GRACEFUL_LEGS_13621, GRACEFUL_LEGS_13622, GRACEFUL_LEGS_13633,
		GRACEFUL_LEGS_13634, GRACEFUL_LEGS_13673, GRACEFUL_LEGS_13674, GRACEFUL_LEGS_21070, GRACEFUL_LEGS_21072
	),

	GLOVES(
		GRACEFUL_GLOVES_11859, GRACEFUL_GLOVES_13587, GRACEFUL_GLOVES_13588, GRACEFUL_GLOVES_13599, GRACEFUL_GLOVES_13600,
		GRACEFUL_GLOVES_13611, GRACEFUL_GLOVES_13612, GRACEFUL_GLOVES_13623, GRACEFUL_GLOVES_13624, GRACEFUL_GLOVES_13635,
		GRACEFUL_GLOVES_13636, GRACEFUL_GLOVES_13675, GRACEFUL_GLOVES_13676, GRACEFUL_GLOVES_21073, GRACEFUL_GLOVES_21075
	),

	BOOTS(
		GRACEFUL_BOOTS_11861, GRACEFUL_BOOTS_13589, GRACEFUL_BOOTS_13590, GRACEFUL_BOOTS_13601, GRACEFUL_BOOTS_13602,
		GRACEFUL_BOOTS_13613, GRACEFUL_BOOTS_13614, GRACEFUL_BOOTS_13625, GRACEFUL_BOOTS_13626, GRACEFUL_BOOTS_13637,
		GRACEFUL_BOOTS_13638, GRACEFUL_BOOTS_13677, GRACEFUL_BOOTS_13678, GRACEFUL_BOOTS_21076, GRACEFUL_BOOTS_21078
	),

	// Agility skill capes and the non-cosmetic Max capes also count for the Graceful set effect
	CAPE(
		GRACEFUL_CAPE_11853, GRACEFUL_CAPE_13581, GRACEFUL_CAPE_13582, GRACEFUL_CAPE_13593, GRACEFUL_CAPE_13594,
		GRACEFUL_CAPE_13605, GRACEFUL_CAPE_13606, GRACEFUL_CAPE_13617, GRACEFUL_CAPE_13618, GRACEFUL_CAPE_13629,
		GRACEFUL_CAPE_13630, GRACEFUL_CAPE_13669, GRACEFUL_CAPE_13670, GRACEFUL_CAPE_21064, GRACEFUL_CAPE_21066,
		AGILITY_CAPE, AGILITY_CAPET, MAX_CAPE
	);

	private final ImmutableSet<Integer> ids;

	Graceful(Integer... ids)
	{
		this.ids = ImmutableSet.copyOf(ids);
	}

	public static boolean hasFullSet(final ItemContainer equipment)
	{
		if (equipment == null)
		{
			return false;
		}

		final Item[] items = equipment.getItems();

		if (equipment == null || items.length <= EquipmentInventorySlot.BOOTS.getSlotIdx())
		{
			return false;
		}

		return HOOD.ids.contains(items[EquipmentInventorySlot.HEAD.getSlotIdx()].getId())
			&& TOP.ids.contains(items[EquipmentInventorySlot.BODY.getSlotIdx()].getId())
			&& LEGS.ids.contains(items[EquipmentInventorySlot.LEGS.getSlotIdx()].getId())
			&& GLOVES.ids.contains(items[EquipmentInventorySlot.GLOVES.getSlotIdx()].getId())
			&& BOOTS.ids.contains(items[EquipmentInventorySlot.BOOTS.getSlotIdx()].getId())
			&& CAPE.ids.contains(items[EquipmentInventorySlot.CAPE.getSlotIdx()].getId());
	}
}