/*
 * Copyright (c) 2020, Anthony <https://github.com/while-loop>
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
package net.runelite.client.plugins.loottracker;

import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import net.runelite.api.gameval.ItemID;

@AllArgsConstructor
enum LootTrackerMapping
{
	CLUE_SCROLL_BEGINNER("Clue scroll (beginner)", ItemID.TRAIL_CLUE_BEGINNER),
	CLUE_SCROLL_EASY("Clue scroll (easy)", ItemID.TRAIL_CLUE_EASY_SIMPLE001),
	CLUE_SCROLL_MEDIUM("Clue scroll (medium)", ItemID.TRAIL_CLUE_MEDIUM_SEXTANT001),
	CLUE_SCROLL_HARD("Clue scroll (hard)", ItemID.TRAIL_CLUE_HARD_MAP001),
	CLUE_SCROLL_ELITE("Clue scroll (elite)", ItemID.TRAIL_ELITE_EMOTE_EXP1),
	CLUE_SCROLL_MASTER("Clue scroll (master)", ItemID.TRAIL_CLUE_MASTER);

	private final String name;
	private final int baseId;

	private static final ImmutableMap<String, Integer> MAPPINGS;

	static
	{
		ImmutableMap.Builder<String, Integer> map = ImmutableMap.builder();
		for (LootTrackerMapping mapping : values())
		{
			map.put(mapping.name, mapping.baseId);
		}
		MAPPINGS = map.build();
	}

	static int map(int itemId, String name)
	{
		return MAPPINGS.getOrDefault(name, itemId);
	}
}
