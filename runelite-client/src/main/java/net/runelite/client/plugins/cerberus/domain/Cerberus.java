/*
 * Copyright (c) 2019 Im2be <https://github.com/Im2be>
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

package net.runelite.client.plugins.cerberus.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.runelite.api.NPC;
import net.runelite.api.Prayer;
import net.runelite.client.plugins.cerberus.util.Utility;

@Getter
public class Cerberus
{
	private static final int TOTAL_HP = 600;
	private static final int GHOST_HP = 400;
	private static final int LAVA_HP = 200;

	private final List<Phase> attacksDone;

	private final NPC npc;

	private int phaseCount;

	private int lastAttackTick;

	private Phase lastAttackPhase;

	private Attack lastAttack;

	@Setter
	private int lastGhostYellTick;

	@Setter
	private long lastGhostYellTime;

	@Setter
	private Attack lastTripleAttack;

	private int hp;

	public Cerberus(@NonNull final NPC npc)
	{
		this.npc = npc;

		attacksDone = new ArrayList<>();
		lastAttackPhase = Phase.SPAWNING;
		hp = TOTAL_HP;
	}

	public void nextPhase(final Phase lastAttackPhase)
	{
		phaseCount++;
		this.lastAttackPhase = lastAttackPhase;
	}

	public void doProjectileOrAnimation(final int gameTick, final Attack attack)
	{
		lastAttackTick = gameTick;
		lastAttack = attack;
	}

	public int getHp()
	{
		final int calcualtedHp = Utility.calculateNpcHp(npc.getHealthRatio(), npc.getHealthScale(), TOTAL_HP);

		if (calcualtedHp != -1)
		{
			hp = calcualtedHp;
		}

		return hp;
	}

	//https://pastebin.com/hWCvantS
	public Phase getNextAttackPhase(final int i, final int hp)
	{
		final int nextAttack = this.phaseCount + i;

		if (nextAttack == 0)
		{
			return Phase.SPAWNING;
		}

		if ((nextAttack - 1) % 10 == 0)
		{
			return Phase.TRIPLE;
		}

		if (nextAttack % 7 == 0 && hp <= GHOST_HP)
		{
			return Phase.GHOSTS;
		}

		if (nextAttack % 5 == 0 && hp <= LAVA_HP)
		{
			return Phase.LAVA;
		}

		return Phase.AUTO;
	}

	@Getter
	@RequiredArgsConstructor
	public enum Attack
	{
		SPAWN(null, 0),
		AUTO(null, 1),
		MELEE(Prayer.PROTECT_FROM_MELEE, 1),
		RANGED(Prayer.PROTECT_FROM_MISSILES, 1),
		MAGIC(Prayer.PROTECT_FROM_MAGIC, 1),
		LAVA(null, 0),
		GHOSTS(null, 0),
		GHOST_MELEE(Prayer.PROTECT_FROM_MELEE, 2),
		GHOST_RANGED(Prayer.PROTECT_FROM_MISSILES, 2),
		GHOST_MAGIC(Prayer.PROTECT_FROM_MAGIC, 2);

		private final Prayer prayer;

		private final int priority;
	}
}
