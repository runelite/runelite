/*
 * Copyright (c) 2020, Jordan Zomerlei <https://github.com/JZomerlei>
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
package net.runelite.client.plugins.mining;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import static net.runelite.api.AnimationID.MINING_3A_PICKAXE;
import static net.runelite.api.AnimationID.MINING_ADAMANT_PICKAXE;
import static net.runelite.api.AnimationID.MINING_BLACK_PICKAXE;
import static net.runelite.api.AnimationID.MINING_BRONZE_PICKAXE;
import static net.runelite.api.AnimationID.MINING_CRYSTAL_PICKAXE;
import static net.runelite.api.AnimationID.MINING_DRAGON_PICKAXE;
import static net.runelite.api.AnimationID.MINING_DRAGON_PICKAXE_OR;
import static net.runelite.api.AnimationID.MINING_DRAGON_PICKAXE_UPGRADED;
import static net.runelite.api.AnimationID.MINING_GILDED_PICKAXE;
import static net.runelite.api.AnimationID.MINING_INFERNAL_PICKAXE;
import static net.runelite.api.AnimationID.MINING_IRON_PICKAXE;
import static net.runelite.api.AnimationID.MINING_MITHRIL_PICKAXE;
import static net.runelite.api.AnimationID.MINING_RUNE_PICKAXE;
import static net.runelite.api.AnimationID.MINING_STEEL_PICKAXE;
import static net.runelite.api.ItemID.ADAMANT_PICKAXE;
import static net.runelite.api.ItemID.BLACK_PICKAXE;
import static net.runelite.api.ItemID.BRONZE_PICKAXE;
import static net.runelite.api.ItemID.CRYSTAL_PICKAXE;
import static net.runelite.api.ItemID.DRAGON_PICKAXE;
import static net.runelite.api.ItemID.DRAGON_PICKAXEOR;
import static net.runelite.api.ItemID.DRAGON_PICKAXE_12797;
import static net.runelite.api.ItemID.GILDED_PICKAXE;
import static net.runelite.api.ItemID.INFERNAL_PICKAXE;
import static net.runelite.api.ItemID.IRON_PICKAXE;
import static net.runelite.api.ItemID.MITHRIL_PICKAXE;
import static net.runelite.api.ItemID.RUNE_PICKAXE;
import static net.runelite.api.ItemID.STEEL_PICKAXE;
import static net.runelite.api.ItemID._3RD_AGE_PICKAXE;
import net.runelite.api.Player;

@AllArgsConstructor
@Getter
enum Pickaxe
{
	BRONZE(MINING_BRONZE_PICKAXE, BRONZE_PICKAXE),
	IRON(MINING_IRON_PICKAXE, IRON_PICKAXE),
	STEEL(MINING_STEEL_PICKAXE, STEEL_PICKAXE),
	BLACK(MINING_BLACK_PICKAXE, BLACK_PICKAXE),
	MITHRIL(MINING_MITHRIL_PICKAXE, MITHRIL_PICKAXE),
	ADAMANT(MINING_ADAMANT_PICKAXE, ADAMANT_PICKAXE),
	RUNE(MINING_RUNE_PICKAXE, RUNE_PICKAXE),
	GILDED(MINING_GILDED_PICKAXE, GILDED_PICKAXE),
	DRAGON(MINING_DRAGON_PICKAXE, DRAGON_PICKAXE),
	DRAGON_OR(MINING_DRAGON_PICKAXE_OR, DRAGON_PICKAXEOR),
	DRAGON_UPGRADED(MINING_DRAGON_PICKAXE_UPGRADED, DRAGON_PICKAXE_12797),
	INFERNAL(MINING_INFERNAL_PICKAXE, INFERNAL_PICKAXE),
	THIRDAGE(MINING_3A_PICKAXE, _3RD_AGE_PICKAXE),
	CRYSTAL(MINING_CRYSTAL_PICKAXE, CRYSTAL_PICKAXE);

	private final int animId;
	private final int itemId;

	private static final Map<Integer, Pickaxe> PICKAXE_ANIM_IDS;

	static
	{
		ImmutableMap.Builder<Integer, Pickaxe> builder = new ImmutableMap.Builder<>();

		for (Pickaxe pickaxe : values())
		{
			builder.put(pickaxe.animId, pickaxe);
		}

		PICKAXE_ANIM_IDS = builder.build();
	}

	boolean matchesMiningAnimation(final Player player)
	{
		return player != null && animId == player.getAnimation();
	}

	static Pickaxe fromAnimation(int animId)
	{
		return PICKAXE_ANIM_IDS.get(animId);
	}
}
