/*
 * Copyright (c) 2018, Mantautas Jurksa <https://github.com/Juzzed>
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
package net.runelite.client.plugins.woodcutting;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import lombok.Getter;

import static net.runelite.api.AnimationID.*;
import static net.runelite.api.ItemID.ADAMANT_AXE;
import static net.runelite.api.ItemID.BLACK_AXE;
import static net.runelite.api.ItemID.BRONZE_AXE;
import static net.runelite.api.ItemID.CRYSTAL_AXE;
import static net.runelite.api.ItemID.DRAGON_AXE;
import static net.runelite.api.ItemID.GILDED_AXE;
import static net.runelite.api.ItemID.INFERNAL_AXE;
import static net.runelite.api.ItemID.IRON_AXE;
import static net.runelite.api.ItemID.MITHRIL_AXE;
import static net.runelite.api.ItemID.RUNE_AXE;
import static net.runelite.api.ItemID.STEEL_AXE;
import static net.runelite.api.ItemID.TRAILBLAZER_AXE;
import static net.runelite.api.ItemID._3RD_AGE_AXE;
import net.runelite.api.Player;


@Getter
enum Axe
{
	BRONZE(BRONZE_AXE, WOODCUTTING_BRONZE, WOODCUTTING_ENT_BRONZE),
	IRON(IRON_AXE, WOODCUTTING_IRON, WOODCUTTING_ENT_IRON),
	STEEL(STEEL_AXE, WOODCUTTING_STEEL, WOODCUTTING_ENT_STEEL),
	BLACK(BLACK_AXE, WOODCUTTING_BLACK, WOODCUTTING_ENT_BLACK),
	MITHRIL(MITHRIL_AXE, WOODCUTTING_MITHRIL, WOODCUTTING_ENT_MITHRIL),
	ADAMANT(ADAMANT_AXE, WOODCUTTING_ADAMANT, WOODCUTTING_ENT_ADAMANT),
	RUNE(RUNE_AXE, WOODCUTTING_RUNE, WOODCUTTING_ENT_RUNE),
	GILDED(GILDED_AXE, WOODCUTTING_GILDED, WOODCUTTING_ENT_GILDED),
	DRAGON(DRAGON_AXE, WOODCUTTING_DRAGON, WOODCUTTING_ENT_DRAGON),
	INFERNAL(INFERNAL_AXE, WOODCUTTING_INFERNAL, WOODCUTTING_ENT_INFERNAL),
	THIRDAGE(_3RD_AGE_AXE, WOODCUTTING_3A_AXE, WOODCUTTING_ENT_3A_AXE),
	CRYSTAL(CRYSTAL_AXE, WOODCUTTING_CRYSTAL, WOODCUTTING_ENT_CRYSTAL),
	TRAILBLAZER(TRAILBLAZER_AXE, WOODCUTTING_TRAILBLAZER); //Ent interaction should be verified.


	private final Integer itemId;
	private final int[] animIds;

	Axe(int itemId, int ... animIds)
	{
		this.itemId = itemId;
		this.animIds = animIds;
	}

	private static final Map<Integer, Axe> AXE_ANIM_IDS;

	static
	{
		ImmutableMap.Builder<Integer, Axe> builder = new ImmutableMap.Builder<>();

		for (Axe axe : values())
		{
			for (int animId : axe.animIds)
			{
				builder.put(animId, axe);
			}
		}

		AXE_ANIM_IDS = builder.build();
	}

	boolean matchesChoppingAnimation(final Player player)
	{
		return player != null && findAxeByAnimId(player.getAnimation()) == this;
	}

	static Axe findAxeByAnimId(int animId)
	{
		return AXE_ANIM_IDS.get(animId);
	}
}
