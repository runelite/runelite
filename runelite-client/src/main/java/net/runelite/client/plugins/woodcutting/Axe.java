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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import static net.runelite.api.AnimationID.WOODCUTTING_3A_AXE;
import static net.runelite.api.AnimationID.WOODCUTTING_ADAMANT;
import static net.runelite.api.AnimationID.WOODCUTTING_BLACK;
import static net.runelite.api.AnimationID.WOODCUTTING_BRONZE;
import static net.runelite.api.AnimationID.WOODCUTTING_CRYSTAL;
import static net.runelite.api.AnimationID.WOODCUTTING_DRAGON;
import static net.runelite.api.AnimationID.WOODCUTTING_INFERNAL;
import static net.runelite.api.AnimationID.WOODCUTTING_IRON;
import static net.runelite.api.AnimationID.WOODCUTTING_MITHRIL;
import static net.runelite.api.AnimationID.WOODCUTTING_RUNE;
import static net.runelite.api.AnimationID.WOODCUTTING_STEEL;
import static net.runelite.api.ItemID.ADAMANT_AXE;
import static net.runelite.api.ItemID.BLACK_AXE;
import static net.runelite.api.ItemID.BRONZE_AXE;
import static net.runelite.api.ItemID.CRYSTAL_AXE;
import static net.runelite.api.ItemID.DRAGON_AXE;
import static net.runelite.api.ItemID.INFERNAL_AXE;
import static net.runelite.api.ItemID.IRON_AXE;
import static net.runelite.api.ItemID.MITHRIL_AXE;
import static net.runelite.api.ItemID.RUNE_AXE;
import static net.runelite.api.ItemID.STEEL_AXE;
import static net.runelite.api.ItemID._3RD_AGE_AXE;

@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
enum Axe
{
	BRONZE(WOODCUTTING_BRONZE, BRONZE_AXE),
	IRON(WOODCUTTING_IRON, IRON_AXE),
	STEEL(WOODCUTTING_STEEL, STEEL_AXE),
	BLACK(WOODCUTTING_BLACK, BLACK_AXE),
	MITHRIL(WOODCUTTING_MITHRIL, MITHRIL_AXE),
	ADAMANT(WOODCUTTING_ADAMANT, ADAMANT_AXE),
	RUNE(WOODCUTTING_RUNE, RUNE_AXE),
	DRAGON(WOODCUTTING_DRAGON, DRAGON_AXE),
	INFERNAL(WOODCUTTING_INFERNAL, INFERNAL_AXE),
	THIRDAGE(WOODCUTTING_3A_AXE, _3RD_AGE_AXE),
	CRYSTAL(WOODCUTTING_CRYSTAL, CRYSTAL_AXE);

	private final Integer animId;
	private final Integer itemId;

	private static final Map<Integer, Axe> AXE_ANIM_IDS;

	static
	{
		ImmutableMap.Builder<Integer, Axe> builder = new ImmutableMap.Builder<>();

		for (Axe axe : values())
		{
			builder.put(axe.animId, axe);
		}

		AXE_ANIM_IDS = builder.build();
	}

	static Axe findAxeByAnimId(int animId)
	{
		return AXE_ANIM_IDS.get(animId);
	}
}
