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
public class Fighter
{
	private Player player;
	private String name; // username
	private int attackCount; // total number of attacks
	private int successCount; // total number of successful attacks
	private double successRate; // success rate in percentage (0-100)
	private boolean dead; // will be true if the fighter died in the fight
	private boolean currentlyAttacking; // will be true if the player is currently doing an attack animation

	// fighter that is bound to a player and gets updated during a fight
	public Fighter(Player player)
	{
		this.player = player;
		name = player.getName();
		attackCount = 0;
		successCount = 0;
		successRate = 0;
		dead = false;
		currentlyAttacking = false;
	}

	// create a basic Fighter to only hold stats, for the TotalStatsPanel,
	// but not actually updated during a fight.
	public Fighter(String name)
	{
		player = null;
		this.name = name;
		attackCount = 0;
		successCount = 0;
		successRate = 0;
		dead = false;
		currentlyAttacking = false;
	}

	// add an attack to the counters depending if it is successful or not.
	// also update the success rate with the new counts.
	public void addAttack(boolean success)
	{
		attackCount++;
		if (success)
		{
			successCount++;
		}

		updateSuccessRate();
	}

	// this is to be used from the TotalStatsPanel which saves a total of multiple fights.
	public void addAttacks(int success, int total)
	{
		successCount += success;
		attackCount += total;

		updateSuccessRate();
	}

	public void died()
	{
		dead = true;
	}

	// check the Fighter's current animation, add an attack if applicable, and
	// compare attack style used with an opponent's overhead style to determine 'success'
	// returns true if the player started attacking on this check.
	public boolean checkForAttackAnimation(Player opponent)
	{
		AnimationAttackStyle animationStyle = AnimationAttackStyle.styleForAnimation(player.getAnimation());
		if (animationStyle == null) // if the animationStyle is null, set attacking bool to false.
		{
			currentlyAttacking = false;
			return false;
		}

		// Only apply new attack if not currently attacking (to avoid duplicate attacks with 1 long animation)
		if (!currentlyAttacking)
		{
			addAttack(opponent.getOverheadIcon() != animationStyle.getProtection());
			currentlyAttacking = true;
			return true;
		}

		return false;
	}

	// Return a simple string to display the current player's success rate.
	// ex. "42/59 (71%)". The name is not included as it will be in a separate view.
	public String getStatsString()
	{
		return successCount + "/" + attackCount + " (" + Math.round(successRate) + "%)";
	}

	private void updateSuccessRate()
	{
		successRate = (double) successCount / (double) attackCount * 100.0;
	}
}
