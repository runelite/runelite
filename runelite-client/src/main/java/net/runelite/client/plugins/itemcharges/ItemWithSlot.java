/*
 * Copyright (c) 2019, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2019, Aleios <https://github.com/aleios>
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
package net.runelite.client.plugins.itemcharges;

import com.google.common.collect.Sets;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.EquipmentInventorySlot;

@Getter(AccessLevel.PACKAGE)
enum ItemWithSlot
{
	ABYSSAL_BRACELET(ItemChargeType.ABYSSAL_BRACELET, EquipmentInventorySlot.GLOVES),
	BRACELET_OF_SLAUGHTER(ItemChargeType.BRACELET_OF_SLAUGHTER, EquipmentInventorySlot.GLOVES),
	EXPEDITIOUS_BRACELET(ItemChargeType.EXPEDITIOUS_BRACELET, EquipmentInventorySlot.GLOVES),
	DODGY_NECKLACE(ItemChargeType.DODGY_NECKLACE, EquipmentInventorySlot.AMULET),
	BINDING_NECKLACE(ItemChargeType.BINDING_NECKLACE, EquipmentInventorySlot.AMULET),
	EXPLORER_RING(ItemChargeType.EXPLORER_RING, EquipmentInventorySlot.RING),
	RING_OF_FORGING(ItemChargeType.RING_OF_FORGING, EquipmentInventorySlot.RING),
	TELEPORT(ItemChargeType.TELEPORT, EquipmentInventorySlot.WEAPON, EquipmentInventorySlot.AMULET, EquipmentInventorySlot.GLOVES, EquipmentInventorySlot.RING);

	private final ItemChargeType type;
	private final Set<EquipmentInventorySlot> slots;

	ItemWithSlot(final ItemChargeType type, final EquipmentInventorySlot... slots)
	{
		this.type = type;
		this.slots = Sets.newHashSet(slots);
	}
}
