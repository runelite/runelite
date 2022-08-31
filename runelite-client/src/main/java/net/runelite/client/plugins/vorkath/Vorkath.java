/*
 * Copyright (c) 2018, https://openosrs.com
 * Copyright (c) 2019, Infinitay <https://github.com/Infinitay>
 *
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
package net.runelite.client.plugins.vorkath;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.NPC;

@Data
@Slf4j
public class Vorkath
{
	static final int ATTACKS_PER_SWITCH = 6;
	static final int FIRE_BALL_ATTACKS = 25;

	private NPC vorkath;
	private VorkathAttack lastAttack;
	private Phase currentPhase;
	private Phase nextPhase;
	private Phase lastPhase;
	private int attacksLeft;

	public Vorkath(NPC vorkath)
	{
		this.vorkath = vorkath;
		this.attacksLeft = ATTACKS_PER_SWITCH;
		this.currentPhase = Phase.UNKNOWN;
		this.nextPhase = Phase.UNKNOWN;
		this.lastPhase = Phase.UNKNOWN;
		log.debug("[Vorkath] Created Vorkath: {}", this);
	}

	/**
	 * Updates the existing Vorkath object depending on the new phase it is currently on
	 *
	 * @param newPhase the new phase Vorkath is current on
	 */
	void updatePhase(Phase newPhase)
	{
		Phase oldLastPhase = this.lastPhase;
		Phase oldCurrentPhase = this.currentPhase;
		Phase oldNextPhase = this.currentPhase;
		int oldAttacksLeft = this.attacksLeft;

		this.lastPhase = this.currentPhase;
		this.currentPhase = newPhase;
		switch (newPhase)
		{
			case ACID:
				this.nextPhase = Phase.FIRE_BALL;
				break;
			case FIRE_BALL:
				this.nextPhase = Phase.SPAWN;
				break;
			case SPAWN:
				this.nextPhase = Phase.ACID;
				break;
			default:
				this.nextPhase = Phase.UNKNOWN;
				break;
		}

		if (this.currentPhase == Phase.FIRE_BALL)
		{
			this.attacksLeft = FIRE_BALL_ATTACKS;
		}
		else
		{
			this.attacksLeft = ATTACKS_PER_SWITCH;
		}

		log.debug("[Vorkath] Update! Last Phase: {}->{}, Current Phase: {}->{}, Next Phase: {}->{}, Attacks: {}->{}",
			oldLastPhase, this.lastPhase, oldCurrentPhase, this.currentPhase, oldNextPhase, this.nextPhase, oldAttacksLeft, this.attacksLeft);
	}

	enum Phase
	{
		UNKNOWN,
		ACID,
		FIRE_BALL,
		SPAWN
	}
}