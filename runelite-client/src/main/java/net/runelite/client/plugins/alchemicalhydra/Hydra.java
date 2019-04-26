/*
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
package net.runelite.client.plugins.alchemicalhydra;

import javax.inject.Singleton;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.NPC;
import net.runelite.api.Prayer;
import net.runelite.api.ProjectileID;

@Singleton
class Hydra
{
	enum AttackStyle
	{
		MAGIC(ProjectileID.HYDRA_MAGIC, Prayer.PROTECT_FROM_MAGIC),
		RANGED(ProjectileID.HYDRA_RANGED, Prayer.PROTECT_FROM_MISSILES);

		@Getter
		private int projId;

		@Getter
		private Prayer prayer;

		AttackStyle(int projId, Prayer prayer)
		{
			this.projId = projId;
			this.prayer = prayer;
		}
	}

	@Getter
	private NPC npc;

	@Getter
	@Setter
	private HydraPhase phase;

	@Getter
	@Setter
	private int attackCount;

	@Getter
	@Setter
	private int nextSwitch;

	@Getter
	@Setter
	private int nextSpecial;

	@Getter
	@Setter
	private AttackStyle nextAttack;

	@Getter
	@Setter
	private AttackStyle lastAttack;

	@Getter
	@Setter
	private boolean weakened;

	Hydra(NPC npc)
	{
		this.npc = npc;
		this.phase = HydraPhase.ONE;
		this.nextAttack = AttackStyle.MAGIC;
		this.lastAttack = AttackStyle.MAGIC; // important, else we wouldn't switch if the first attack is ranged
		this.nextSpecial = 3;
		this.nextSwitch = phase.getAttacksPerSwitch();
		this.attackCount = 0;
		this.weakened = false;
	}
}
