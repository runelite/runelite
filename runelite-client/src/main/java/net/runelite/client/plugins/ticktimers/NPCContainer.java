/*
 * Copyright (c) 2019, Ganom <https://github.com/Ganom>
 * Copyright (c) 2019, Lucas <https://github.com/lucwousin>
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
package net.runelite.client.plugins.ticktimers;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.awt.Color;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import net.runelite.api.NPC;
import net.runelite.api.NPCDefinition;
import net.runelite.api.NpcID;
import net.runelite.api.Prayer;

@Getter(AccessLevel.PACKAGE)
class NPCContainer
{
	private NPC npc;
	private int npcIndex;
	private String npcName;
	private int npcSize;
	private ImmutableSet<Integer> animations;
	private int attackSpeed;
	@Setter(AccessLevel.PACKAGE)
	private int ticksUntilAttack;
	@Setter(AccessLevel.PACKAGE)
	private Actor npcInteracting;
	@Setter(AccessLevel.PACKAGE)
	private AttackStyle attackStyle;

	NPCContainer(final NPC npc, final int attackSpeed)
	{
		this.npc = npc;
		this.npcName = npc.getName();
		this.npcIndex = npc.getIndex();
		this.npcInteracting = npc.getInteracting();
		this.attackStyle = AttackStyle.UNKNOWN;
		this.attackSpeed = attackSpeed;
		this.ticksUntilAttack = -1;
		final NPCDefinition composition = npc.getTransformedDefinition();

		BossMonsters monster = BossMonsters.of(npc.getId());

		if (monster == null)
		{
			throw new IllegalStateException();
		}

		this.animations = monster.animations;
		this.attackStyle = monster.attackStyle;

		if (composition != null)
		{
			this.npcSize = composition.getSize();
		}
	}

	@RequiredArgsConstructor
	enum BossMonsters
	{
		SERGEANT_STRONGSTACK(NpcID.SERGEANT_STRONGSTACK, AttackStyle.MELEE, ImmutableSet.of(AnimationID.MINION_AUTO1, AnimationID.MINION_AUTO2, AnimationID.MINION_AUTO3)),
		SERGEANT_STEELWILL(NpcID.SERGEANT_STEELWILL, AttackStyle.MAGE, ImmutableSet.of(AnimationID.MINION_AUTO1, AnimationID.MINION_AUTO2, AnimationID.MINION_AUTO3)),
		SERGEANT_GRIMSPIKE(NpcID.SERGEANT_GRIMSPIKE, AttackStyle.RANGE, ImmutableSet.of(AnimationID.MINION_AUTO1, AnimationID.MINION_AUTO2, AnimationID.MINION_AUTO4)),
		GENERAL_GRAARDOR(NpcID.GENERAL_GRAARDOR, AttackStyle.MELEE, ImmutableSet.of(AnimationID.GENERAL_AUTO1, AnimationID.GENERAL_AUTO2, AnimationID.GENERAL_AUTO3)),

		TSTANON_KARLAK(NpcID.TSTANON_KARLAK, AttackStyle.MELEE, ImmutableSet.of(AnimationID.ZAMMY_GENERIC_AUTO)),
		BALFRUG_KREEYATH(NpcID.BALFRUG_KREEYATH, AttackStyle.MAGE, ImmutableSet.of(AnimationID.ZAMMY_GENERIC_AUTO, AnimationID.BALFRUG_AUTO)),
		ZAKLN_GRITCH(NpcID.ZAKLN_GRITCH, AttackStyle.RANGE, ImmutableSet.of(AnimationID.ZAMMY_GENERIC_AUTO, AnimationID.ZAKL_AUTO)),
		KRIL_TSUTSAROTH(NpcID.KRIL_TSUTSAROTH, AttackStyle.UNKNOWN, ImmutableSet.of(AnimationID.KRIL_SPEC, AnimationID.KRIL_AUTO)),

		STARLIGHT(NpcID.STARLIGHT, AttackStyle.MELEE, ImmutableSet.of(AnimationID.STARLIGHT_AUTO)),
		GROWLER(NpcID.GROWLER, AttackStyle.MAGE, ImmutableSet.of(AnimationID.GROWLER_AUTO)),
		BREE(NpcID.BREE, AttackStyle.RANGE, ImmutableSet.of(AnimationID.BREE_AUTO)),
		COMMANDER_ZILYANA(NpcID.COMMANDER_ZILYANA, AttackStyle.UNKNOWN, ImmutableSet.of(AnimationID.ZILYANA_AUTO, AnimationID.ZILYANA_MELEE_AUTO, AnimationID.ZILYANA_SPEC)),

		FLIGHT_KILISA(NpcID.FLIGHT_KILISA, AttackStyle.MELEE, ImmutableSet.of(AnimationID.KILISA_AUTO)),
		FLOCKLEADER_GEERIN(NpcID.FLOCKLEADER_GEERIN, AttackStyle.RANGE, ImmutableSet.of(AnimationID.GEERIN_AUTO, AnimationID.GEERIN_FLINCH)),
		WINGMAN_SKREE(NpcID.WINGMAN_SKREE, AttackStyle.MAGE, ImmutableSet.of(AnimationID.SKREE_AUTO)),
		KREEARRA(NpcID.KREEARRA, AttackStyle.RANGE, ImmutableSet.of(AnimationID.KREE_RANGED)),

		DAGANNOTH_REX(NpcID.DAGANNOTH_REX, AttackStyle.MELEE, ImmutableSet.of(AnimationID.DAG_REX)),
		DAGANNOTH_SUPREME(NpcID.DAGANNOTH_SUPREME, AttackStyle.RANGE, ImmutableSet.of(AnimationID.DAG_SUPREME)),
		DAGANNOTH_PRIME(NpcID.DAGANNOTH_PRIME, AttackStyle.MAGE, ImmutableSet.of(AnimationID.DAG_PRIME));

		private static final ImmutableMap<Integer, BossMonsters> idMap;

		static
		{
			ImmutableMap.Builder<Integer, BossMonsters> builder = ImmutableMap.builder();

			for (BossMonsters monster : values())
			{
				builder.put(monster.npcID, monster);
			}

			idMap = builder.build();
		}

		private final int npcID;
		private final AttackStyle attackStyle;
		private final ImmutableSet<Integer> animations;

		static BossMonsters of(int npcID)
		{
			return idMap.get(npcID);
		}
	}

	@AllArgsConstructor
	@Getter
	public enum AttackStyle
	{
		MAGE("Mage", Color.CYAN, Prayer.PROTECT_FROM_MAGIC),
		RANGE("Range", Color.GREEN, Prayer.PROTECT_FROM_MISSILES),
		MELEE("Melee", Color.RED, Prayer.PROTECT_FROM_MELEE),
		UNKNOWN("Unknown", Color.WHITE, null);

		private String name;
		private Color color;
		private Prayer prayer;
	}
}
