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
package net.runelite.api.kit;

import net.runelite.api.PlayerComposition;

/**
 * Represents an equipment slot in a players composition.
 * <p>
 * These values are intended for use with {@link PlayerComposition} equipment
 * slots. For obtaining information about equipment in the local players
 * equipment {@link net.runelite.api.ItemContainer}, use
 * {@link net.runelite.api.EquipmentInventorySlot}.
 */
public enum KitType
{
	HEAD,
	CAPE,
	AMULET,
	WEAPON,
	TORSO,
	SHIELD,
	ARMS,
	LEGS,
	HAIR,
	HANDS,
	BOOTS,
	JAW;

	/**
	 * Gets the raw equipment index for use in {@link PlayerComposition#getEquipmentIds()}.
	 *
	 * @return raw equipment index
	 */
	public int getIndex()
	{
		return ordinal();
	}
}
