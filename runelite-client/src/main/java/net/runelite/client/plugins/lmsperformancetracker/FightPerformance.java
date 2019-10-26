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

import java.time.Duration;
import java.time.Instant;
import lombok.Getter;
import net.runelite.api.AnimationID;
import net.runelite.api.Player;

// Basic class to hold information about PvP fight performances. A "successful" attack
// is dealt by not attacking with the style of the opponent's overhead. For example,
// attacking with range or melee against someone using protect from magic is a successful
// attack. Using melee against someone using protect from melee is not successful.
// This is not a guaranteed way of determining the better player, since someone casting
// barrage in full tank gear can count as a successful attack. It's a good general idea, though.
@Getter
public class FightPerformance
{
	// Delay to assume a fight is over. May seem long, but sometimes people barrage &
	// stand under for a while to eat. Fights will automatically end when either player dies.
	private static final Duration NEW_FIGHT_DELAY = Duration.ofSeconds(21);

	private Fighter player;
	private Fighter opponent;
	private Instant lastFightTime; // Instant of the last fight time & when the fight ends

	// constructor which initializes a fight from the 2 Players, starting stats at 0.
	FightPerformance(Player player, Player opponent)
	{
		this.player = new Fighter(player);
		this.opponent = new Fighter(opponent);
		lastFightTime = Instant.now().minusSeconds(NEW_FIGHT_DELAY.getSeconds() - 3);
	}

	public void checkForAttackAnimations()
	{
		// use single | so it doesn't short circuit and check both Fighters regardless.
		if (player.checkForAttackAnimation(opponent.getPlayer()) |
			opponent.checkForAttackAnimation(player.getPlayer()))
		{
			lastFightTime = Instant.now();
		}
	}

	// returns true if player success rate > opponent success rate.
	// could be "wrong" about winning in some cases, if someone is eating a lot and not actually attacking
	// much, they could have a higher success rate than the person clearly winning. Although it is hard to
	// judge by comparing attack counts since someone using fast weapons against slow weapons
	// could cause a situation opposite of the one described above.
	public boolean playerWinning()
	{
		return player.getSuccessRate() > opponent.getSuccessRate();
	}

	// returns true if opponent success rate > player success rate.
	public boolean opponentWinning()
	{
		return opponent.getSuccessRate() > player.getSuccessRate();
	}

	// Will return true and stop the fight if the fight should be over.
	// if either player hasn't fought in NEW_FIGHT_DELAY, or either player died.
	// Will also add the currentFight to fightHistory if the fight ended.
	public boolean isFightOver()
	{
		boolean isOver = false;
		// if either player died, end the fight.
		if (opponent.getPlayer().getAnimation() == AnimationID.DEATH)
		{
			opponent.died();
			isOver = true;
		}
		if (player.getPlayer().getAnimation() == AnimationID.DEATH)
		{
			player.died();
			isOver = true;
		}
		// If there was no fight actions in the last (NEW_FIGHT_DELAY) seconds, set opponent to
		// null, which will get set next time the player targets a Player.
		if (Duration.between(lastFightTime, Instant.now()).compareTo(NEW_FIGHT_DELAY) > 0)
		{
			isOver = true;
		}

		if (isOver)
		{
			lastFightTime = Instant.now();
		}

		return isOver;
	}

	// only count the fight as started if the player attacked, not the enemy because
	// the person the player clicked on might be attacking someone else
	public boolean fightStarted()
	{
		return player.getAttackCount() > 0;
	}
}
