/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.plugins.skillcalculator;

import lombok.Getter;
import net.runelite.api.ItemID;

@Getter
public enum BankedItemOptionItems
{
	GUAM_LEAF("Guam leaf", ItemID.GUAM_LEAF, ItemID.GRIMY_GUAM_LEAF, ItemID.GUAM_POTION_UNF),
	MARRENTILL("Marrentill", ItemID.MARRENTILL, ItemID.GRIMY_MARRENTILL, ItemID.MARRENTILL_POTION_UNF),
	TARROMIN("Tarromin", ItemID.TARROMIN, ItemID.GRIMY_TARROMIN, ItemID.TARROMIN_POTION_UNF),
	HARRALANDER("Harralander", ItemID.HARRALANDER, ItemID.GRIMY_HARRALANDER, ItemID.HARRALANDER_POTION_UNF),
	RANARR_WEED("Ranarr weed", ItemID.RANARR_WEED, ItemID.GRIMY_RANARR_WEED, ItemID.RANARR_POTION_UNF),
	TOADFLAX("Toadflax", ItemID.TOADFLAX, ItemID.GRIMY_TOADFLAX, ItemID.TOADFLAX_POTION_UNF),
	IRIT_LEAF("Irit leaf", ItemID.IRIT_LEAF, ItemID.GRIMY_IRIT_LEAF, ItemID.IRIT_POTION_UNF),
	AVANTOE("Avantoe", ItemID.AVANTOE, ItemID.GRIMY_AVANTOE, ItemID.AVANTOE_POTION_UNF),
	KWUARM("Kwuarm", ItemID.KWUARM, ItemID.GRIMY_KWUARM, ItemID.KWUARM_POTION_UNF),
	SNAPDRAGON("Snapdragon", ItemID.SNAPDRAGON, ItemID.GRIMY_SNAPDRAGON, ItemID.SNAPDRAGON_POTION_UNF),
	CADANTINE("Cadantine", ItemID.CADANTINE, ItemID.GRIMY_CADANTINE, ItemID.CADANTINE_POTION_UNF),
	LANTADYME("Lantadyme", ItemID.LANTADYME, ItemID.GRIMY_LANTADYME, ItemID.LANTADYME_POTION_UNF),
	DWARF_WEED("Dwarf weed", ItemID.DWARF_WEED, ItemID.GRIMY_DWARF_WEED, ItemID.DWARF_WEED_POTION_UNF),
	TORSTOL("Torstol", ItemID.TORSTOL, ItemID.GRIMY_TORSTOL, ItemID.TORSTOL_POTION_UNF),
	TORSTOL_HERBS("Torstol (Herbs)", ItemID.TORSTOL, ItemID.GRIMY_TORSTOL),

	/**
	 * Construction
	 */
	TEAKS("Teaks", ItemID.TEAK_LOGS, ItemID.TEAK_PLANK);

	private final String name;
	private final int mainId;
	private final int[] items;

	BankedItemOptionItems(String name, int...items)
	{
		this.name = name;
		this.mainId = items[0];
		this.items = items;
	}
}
