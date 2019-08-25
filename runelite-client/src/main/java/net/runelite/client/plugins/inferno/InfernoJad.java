/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.inferno;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.AnimationID;
import net.runelite.api.NPC;
import net.runelite.api.Prayer;

@Getter(AccessLevel.PACKAGE)
public class InfernoJad
{
	private static final int TICKS_AFTER_ANIMATION = 4;

	private NPC npc;
	private Attack nextAttack;
	private int ticksTillNextAttack;

	InfernoJad(NPC npc)
	{
		this.npc = npc;
		nextAttack = null;
		ticksTillNextAttack = -1;
	}

	void updateNextAttack(Attack nextAttack)
	{
		this.nextAttack = nextAttack;
		this.ticksTillNextAttack = TICKS_AFTER_ANIMATION;
	}

	void gameTick()
	{
		if (ticksTillNextAttack < 0)
		{
			return;
		}

		this.ticksTillNextAttack--;

		if (ticksTillNextAttack < 0)
		{
			nextAttack = null;
		}
	}

	@Getter(AccessLevel.PACKAGE)
	enum Attack
	{
		MAGIC(AnimationID.JALTOK_JAD_MAGE_ATTACK, Prayer.PROTECT_FROM_MAGIC),
		RANGE(AnimationID.JALTOK_JAD_RANGE_ATTACK, Prayer.PROTECT_FROM_MISSILES);

		private final int animation;
		private final Prayer prayer;

		Attack(final int animation, final Prayer prayer)
		{
			this.animation = animation;
			this.prayer = prayer;
		}
	}
}

