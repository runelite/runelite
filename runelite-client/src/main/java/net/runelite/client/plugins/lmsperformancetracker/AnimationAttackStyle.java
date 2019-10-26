/*
 * Copyright (c) 2019, Matsyir <https://github.com/Matsyir>
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
package net.runelite.client.plugins.lmsperformancetracker;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.HeadIcon;

import static net.runelite.api.AnimationID.*;

public enum AnimationAttackStyle
{
	// Melee attack animations
	Melee(HeadIcon.MELEE,
		MELEE_DAGGER_SLASH,
		MELEE_SPEAR_STAB,
		MELEE_SWORD_STAB,
		MELEE_SCIM_SLASH,
		MELEE_STAFF_CRUSH,
		MELEE_BATTLEAXE_SLASH,
		MELEE_MACE_STAB,
		MELEE_BATTLEAXE_CRUSH,
		MELEE_2H_CRUSH,
		MELEE_2H_SLASH,
		MELEE_STAFF_CRUSH_2,
		MELEE_STAFF_CRUSH_3,
		MELEE_PUNCH,
		MELEE_KICK,
		MELEE_STAFF_STAB,
		MELEE_SPEAR_CRUSH,
		MELEE_STAFF_SLASH,
		MELEE_SCEPTRE_CRUSH,
		MELEE_DRAGON_MACE_SPEC,
		MELEE_DRAGON_DAGGER_SPEC,
		MELEE_DRAGON_WARHAMMER_SPEC,
		MELEE_ABYSSAL_WHIP,
		MELEE_GRANITE_MAUL,
		MELEE_GRANITE_MAUL_SPEC,
		MELEE_DHAROKS_GREATAXE_CRUSH,
		MELEE_DHAROKS_GREATAXE_SLASH,
		MELEE_AHRIMS_STAFF_CRUSH,
		MELEE_OBBY_MAUL_CRUSH,
		MELEE_ABYSSAL_DAGGER_STAB,
		MELEE_ABYSSAL_BLUDGEON_CRUSH,
		MELEE_LEAF_BLADED_BATTLEAXE_CRUSH,
		MELEE_BARRELCHEST_ANCHOR_CRUSH,
		MELEE_LEAF_BLADED_BATTLEAXE_SLASH,
		MELEE_GODSWORD_SLASH,
		MELEE_GODSWORD_CRUSH,
		MELEE_DRAGON_CLAWS_SPEC,
		MELEE_DRAGON_SWORD_SPEC,
		MELEE_ELDER_MAUL,
		MELEE_ZAMORAK_GODSWORD_SPEC,
		MELEE_SARADOMIN_GODSWORD_SPEC,
		MELEE_BANDOS_GODSWORD_SPEC,
		MELEE_ARMADYL_GODSWORD_SPEC,
		MELEE_SCYTHE,
		MELEE_GHAZI_RAPIER_STAB
	),

	// Magic attack/casting animations
	Magic(HeadIcon.MAGIC,
		MAGIC_STANDARD_BIND,
		MAGIC_STANDARD_STRIKE_BOLT_BLAST,
		MAGIC_STANDARD_BIND_STAFF,
		MAGIC_STANDARD_STRIKE_BOLT_BLAST_STAFF,
		MAGIC_STANDARD_WAVE_STAFF,
		MAGIC_STANDARD_SURGE_STAFF,
		MAGIC_ANCIENT_SINGLE_TARGET,
		MAGIC_ANCIENT_MULTI_TARGET
	),
	// Ranged attack animations
	Ranged(HeadIcon.RANGED,
		RANGED_SHORTBOW,
		RANGED_RUNE_KNIFE_PVP,
		RANGED_MAGIC_SHORTBOW_SPEC,
		RANGED_CROSSBOW_PVP,
		RANGED_BLOWPIPE,
		RANGED_DARTS,
		RANGED_BALLISTA,
		RANGED_DRAGON_THROWNAXE_SPEC,
		RANGED_RUNE_CROSSBOW,
		RANGED_BALLISTA_2,
		RANGED_RUNE_KNIFE,
		RANGED_DRAGON_KNIFE,
		RANGED_DRAGON_KNIFE_POISONED,
		RANGED_DRAGON_KNIFE_SPEC
	);

	// create a static map of all the animation IDs to retrieve a style given an id more efficiently.
	private static final Map<Integer, AnimationAttackStyle> STYLES;

	@Getter
	private final HeadIcon protection;
	private final int[] animationIds;

	static
	{
		ImmutableMap.Builder<Integer, AnimationAttackStyle> builder = new ImmutableMap.Builder<>();

		for (AnimationAttackStyle style : values())
		{
			for (int animationId : style.animationIds)
			{
				builder.put(animationId, style);
			}
		}

		STYLES = builder.build();
	}

	AnimationAttackStyle(HeadIcon protection, int... animationIds)
	{
		this.protection = protection;
		this.animationIds = animationIds;
	}

	// Returns the AnimationAttackStyle for a given animationId. Null if not attacking.
	public static AnimationAttackStyle styleForAnimation(int animationId)
	{
		return STYLES.get(animationId);
	}
}
