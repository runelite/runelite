/*
 * Copyright (c) 2018, cw-dev
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
package net.runelite.client.plugins.castlewars;

import java.time.Instant;
import lombok.Data;
import net.runelite.client.plugins.castlewars.data.CWTeam;

@Data
class GameRecord
{
	private final Instant created = Instant.now();
	private final int world;
	private final int teamSize;
	private final CWTeam team;

	private int zamScore;
	private int saraScore;

	private int flagsSafed;
	private int flagsScored;

	// Positive/damage dealt
	private double damageDealt;
	private double highestHitDealt;

	// Negative/damage taken
	private int damageTaken;
	private int highestHitTaken;
	private int deaths;
	private int freezesOnMe;
	private int timesSpeared;

	void recordDamageDealt(double approxDmg)
	{
		damageDealt += approxDmg;
		if (approxDmg > highestHitDealt)
		{
			highestHitDealt = approxDmg;
		}
	}

	void recordDamageTaken(int dmg)
	{
		damageTaken += dmg;
		if (dmg > highestHitTaken)
		{
			highestHitTaken = dmg;
		}
	}
}
