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
package net.runelite.client.plugins.keptondeath;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import net.runelite.api.ItemID;

/**
 * Certain Items receive a white outline by Jagex as they are always lost on death. This is sometimes incorrectly
 * added to Items by Jagex as the item is actually kept in non-pvp areas of the game, such as the Rune Pouch.
 * <p>
 * The white outline will be added to these items when they are lost on death.
 */
public enum AlwaysLostItem
{
	RUNE_POUCH(ItemID.RUNE_POUCH, true),
	LOOTING_BAG(ItemID.LOOTING_BAG, false),
	LOOTING_BAG_22586(ItemID.LOOTING_BAG_22586, false),
	CLUE_BOX(ItemID.CLUE_BOX, false);

	private final int itemID;
	@Getter
	private final boolean kept;

	private static final ImmutableMap<Integer, AlwaysLostItem> ID_MAP;

	static
	{
		ImmutableMap.Builder<Integer, AlwaysLostItem> map = ImmutableMap.builder();
		for (AlwaysLostItem p : values())
		{
			map.put(p.itemID, p);
		}
		ID_MAP = map.build();
	}

	AlwaysLostItem(int itemID, boolean kept)
	{
		this.itemID = itemID;
		this.kept = kept;
	}

	public static AlwaysLostItem getByItemID(int itemID)
	{
		return ID_MAP.get(itemID);
	}
}
