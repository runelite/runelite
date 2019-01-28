/*
 * Copyright (c) 2019, RyBo <https://github.com/RyBo>
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
package net.runelite.client.plugins.kingdomofmiscellania;

import lombok.Getter;
import lombok.AllArgsConstructor;
import net.runelite.api.ItemID;

@Getter
@AllArgsConstructor
enum Reward
{
	COAL("Coal", ResourceType.MINING, 545.85, 91.6, ItemID.COAL),
	FLAX("Flax", ResourceType.FLAX, 1250, 40, ItemID.FLAX),
	RAW_TUNA("Raw Tuna", ResourceType.RAW_FISH, 440, 56.3, ItemID.RAW_TUNA),
	RAW_SWORDFISH("Raw Swordfish", ResourceType.RAW_FISH, 131, 189.4, ItemID.RAW_SWORDFISH),
	COOKED_TUNA("Tuna", ResourceType.COOKED_FISH, 440, 56.3, ItemID.TUNA),
	COOKED_SWORDFISH("Swordfish", ResourceType.COOKED_FISH, 131, 189.4, ItemID.SWORDFISH),
	MAPLE("Maple", ResourceType.WOOD, 892, 56.1, ItemID.MAPLE_LOGS),
	BIRD_NEST("Bird nests", ResourceType.WOOD, 8, 0, ItemID.CRUSHED_NEST),
	TEAK("Teak", ResourceType.HARDWOOD_TEAK, 301, 166.1, ItemID.TEAK_LOGS),
	MAHOGANY("Mahogany", ResourceType.HARDWOOD_MAHOGANY, 204, 224.6, ItemID.MAHOGANY_LOGS),
	TEAK_BOTH("Teak", ResourceType.HARDWOOD_BOTH, 121, 95.65, ItemID.TEAK_LOGS),
	MAHOGANY_BOTH("Mahogany", ResourceType.HARDWOOD_BOTH, 121, 95.65, ItemID.MAHOGANY_LOGS),
	TARROMIN("Tarromin", ResourceType.HERBS, 13.2, 826.4, ItemID.GRIMY_TARROMIN),
	HARRALANDER("Harralander", ResourceType.HERBS, 11.9, 826.4, ItemID.GRIMY_HARRALANDER),
	RANARR("Ranarr", ResourceType.HERBS, 3.6, 826.4, ItemID.GRIMY_RANARR_WEED),
	IRIT("Irit", ResourceType.HERBS, 8, 826.4, ItemID.GRIMY_IRIT_LEAF),
	AVANTOE("Avantoe", ResourceType.HERBS, 8.3, 826.4, ItemID.GRIMY_AVANTOE),
	KWUARM("Kwuarm", ResourceType.HERBS, 3.9, 826.4, ItemID.GRIMY_KWUARM),
	CADANTINE("Cadantine", ResourceType.HERBS, 4, 826.4, ItemID.GRIMY_CADANTINE),
	LANTADYME("Lantadyme", ResourceType.HERBS, 3.9, 826.4, ItemID.GRIMY_LANTADYME),
	DWARF_WEED("Dwarf weed", ResourceType.HERBS, 4.1, 826.4, ItemID.GRIMY_DWARF_WEED);

	private final String name;
	private final ResourceType type;
	private final double maxQuantity;
	private final double cost;
	private final int rewardId;

}