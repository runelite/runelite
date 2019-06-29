/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.api;

/**
 * An enumeration of equipment slots in the inventory {@link ItemContainer}.
 * <p>
 * These values are intended for use with the local players equipment
 * {@link ItemContainer} corresponding. For obtaining information about equipment
 * in the {@link PlayerAppearance}, use {@link net.runelite.api.kit.KitType}.
 *
 * @see Client#getItemContainer(InventoryID)
 * @see InventoryID#EQUIPMENT
 */
public enum EquipmentInventorySlot
{
	HEAD(0),
	CAPE(1),
	AMULET(2),
	WEAPON(3),
	BODY(4),
	SHIELD(5),
	LEGS(7),
	GLOVES(9),
	BOOTS(10),
	RING(12),
	AMMO(13);

	private final int slotIdx;

	EquipmentInventorySlot(int slotIdx)
	{
		this.slotIdx = slotIdx;
	}

	/**
	 * Gets the index into the item array obtained from
	 * {@link ItemContainer#getItems()}.
	 *
	 * @return the raw index
	 */
	public int getSlotIdx()
	{
		return slotIdx;
	}

}
