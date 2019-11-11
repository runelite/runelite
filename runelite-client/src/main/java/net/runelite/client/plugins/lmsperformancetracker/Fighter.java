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

import lombok.Getter;
import net.runelite.api.Player;

@Getter
class Fighter
{
	private Player player;
	private String name; // username
	private int attackCount; // total number of attacks
	private int successCount; // total number of successful attacks
	private boolean dead; // will be true if the fighter died in the fight

	// fighter that is bound to a player and gets updated during a fight
	Fighter(Player player)
	{
		this.player = player;
		name = player.getName();
		attackCount = 0;
		successCount = 0;
		dead = false;
	}

	// create a basic Fighter to only hold stats, for the TotalStatsPanel,
	// but not actually updated during a fight.
	Fighter(String name)
	{
		player = null;
		this.name = name;
		attackCount = 0;
		successCount = 0;
		dead = false;
	}

	// add an attack to the counters depending if it is successful or not.
	// also update the success rate with the new counts.
	void addAttack(boolean successful)
	{
		attackCount++;
		if (successful)
		{
			successCount++;
		}
	}

	// this is to be used from the TotalStatsPanel which saves a total of multiple fights.
	void addAttacks(int success, int total)
	{
		successCount += success;
		attackCount += total;
	}

	void died()
	{
		dead = true;
	}

	AnimationAttackStyle getAnimationAttackStyle()
	{
		return AnimationAttackStyle.styleForAnimation(player.getAnimation());
	}

	// Return a simple string to display the current player's success rate.
	// ex. "42/59 (71%)". The name is not included as it will be in a separate view.
	String getStats()
	{
		return successCount + "/" + attackCount + " (" + Math.round(calculateSuccessPercentage()) + "%)";
	}

	double calculateSuccessPercentage()
	{
		return (double) successCount / attackCount * 100.0;
	}
}
