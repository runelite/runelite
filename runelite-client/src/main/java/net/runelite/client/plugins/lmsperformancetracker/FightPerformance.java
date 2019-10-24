/*
 * Copyright (c) 2019, Matsyir <https://github.com/matsyir>
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

import java.time.Instant;
import lombok.Getter;

// Basic class to hold information about PvP fight performances. A "successful" attack
// is dealt by not attacking with the style of the opponent's overhead. For example,
// attacking with range or melee against someone using protect from magic is a successful
// attack. Using melee against someone using protect from magic is not successful.
@Getter
public class FightPerformance
{
	private Fighter player;

	private Fighter opponent;

	private Instant timeFightEnded; // date/time when the fight ends.

	// proper constructor which initializes a fight using only Player names, starting stats at 0.
	FightPerformance(String playerName, String opponentName)
	{
		player = new Fighter(playerName);
		opponent = new Fighter(opponentName);
	}

	public void addAttack(String playerName, boolean success)
	{
		if (playerName.equals(player.getName()))
		{
			player.addAttack(success);
		}
		else if (playerName.equals(opponent.getName()))
		{
			opponent.addAttack(success);
		}
	}
	public void endFight()
	{
		timeFightEnded = Instant.now();
	}

	// returns true if player success rate > opponent success rate.
	// could be "wrong" in some cases, if someone is eating a lot and not actually attacking much,
	// they could have a higher success rate than the person clearly winning. Although it is hard to
	// judge by comparing attack counts since someone using rune knives/msb against ballista/ags
	// is not uncommon, which could cause a situation opposite of the one described above.
	public boolean playerWinning()
	{
		return player.getSuccessRate() > opponent.getSuccessRate();
	}

	// returns true if opponent success rate > player success rate.
	public boolean opponentWinning()
	{
		return opponent.getSuccessRate() > player.getSuccessRate();
	}

	public boolean fightStarted()
	{
		return player.getAttackCount() > 0;
	}
}
