/*
 * Copyright (c) 2021, Tal <https://github.com/talsk>
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
package net.runelite.client.plugins.woodcutting.config;

import com.google.common.collect.ImmutableMap;
import net.runelite.api.ItemID;

public enum ClueNestTier
{
	BEGINNER,
	EASY,
	MEDIUM,
	HARD,
	ELITE,
	DISABLED;


	private static final ImmutableMap<Integer, ClueNestTier> CLUE_NEST_ID_TO_TIER = new ImmutableMap.Builder<Integer, ClueNestTier>()
		.put(ItemID.CLUE_NEST_ELITE, ClueNestTier.ELITE)
		.put(ItemID.CLUE_NEST_HARD, ClueNestTier.HARD)
		.put(ItemID.CLUE_NEST_MEDIUM, ClueNestTier.MEDIUM)
		.put(ItemID.CLUE_NEST_EASY, ClueNestTier.EASY)
		.put(ItemID.CLUE_NEST_BEGINNER, ClueNestTier.BEGINNER)
		.build();

	static public ClueNestTier getTierFromItem(int itemId)
	{
		return CLUE_NEST_ID_TO_TIER.get(itemId);
	}
}
