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
 * An enumeration of possible inventory types.
 */
@Deprecated
public enum InventoryID
{
	/**
	 * Reward from fishing trawler
	 */
	FISHING_TRAWLER_REWARD(0),
	/**
	 * The trade inventory.
	 */
	TRADE(90),
	/**
	 * The other trade inventory.
	 */
	TRADEOTHER(90 | 0x8000),
	/**
	 * Standard player inventory.
	 */
	INVENTORY(93),
	/**
	 * Equipment inventory.
	 */
	EQUIPMENT(94),
	/**
	 * Bank inventory.
	 */
	BANK(95),
	/**
	 * A puzzle box inventory.
	 */
	PUZZLE_BOX(140),
	/**
	 * Barrows reward chest inventory.
	 */
	BARROWS_REWARD(141),
	/**
	 * Monkey madness puzzle box inventory.
	 */
	MONKEY_MADNESS_PUZZLE_BOX(221),
	/**
	 * Drift net fishing reward
	 */
	DRIFT_NET_FISHING_REWARD(307),
	/**
	 * Kingdom Of Miscellania reward inventory.
	 */
	KINGDOM_OF_MISCELLANIA(390),
	/**
	 * Chambers of Xeric chest inventory.
	 */
	CHAMBERS_OF_XERIC_CHEST(581),
	/**
	 * Theater of Blood reward chest inventory (Raids 2)
	 */
	THEATRE_OF_BLOOD_CHEST(612),
	/**
	 * Seed vault located inside the Farming Guild
	 */
	SEED_VAULT(626),
	/**
	 * Group ironman shared storage
	 */
	GROUP_STORAGE(659),
	/**
	 * Player inventory when accessing group ironman shared storage
	 */
	GROUP_STORAGE_INV(660),
	/**
	 * Wilderness loot chest
	 */
	WILDERNESS_LOOT_CHEST(797),
	/**
	 * TOA reward chest
	 */
	TOA_REWARD_CHEST(811),
	/**
	 * Reward chest for Moons of Peril
	 */
	LUNAR_CHEST(847),
	/**
	 * Reward chest for the Fortis Colosseum
	 */
	FORTIS_COLOSSEUM_REWARD_CHEST(843);

	private final int id;

	InventoryID(int id)
	{
		this.id = id;
	}

	/**
	 * Gets the raw inventory type ID.
	 *
	 * @return inventory type
	 */
	public int getId()
	{
		return id;
	}
}
