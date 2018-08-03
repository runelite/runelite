/*
 * Copyright (c) 2017, Cameron <moberg@tuta.io>
 * Copyright (c) 2018, Levi <me@levischuck.com>
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
package net.runelite.client.plugins.xptracker;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.client.plugins.attackstyles.AttackStyle;
import net.runelite.client.plugins.attackstyles.WeaponType;

@Slf4j
@RequiredArgsConstructor
class XpStateSingle
{
	private final Skill skill;

	private final Map<String, Integer> oppInfoHealth = loadNpcHealth();

	@Getter
	private final int startXp;

	@Getter
	private int xpGained = 0;

	private long skillTime = 0;
	private int actions = 0;
	private int startLevelExp = 0;
	private int endLevelExp = 0;
	private boolean actionsHistoryInitialized = false;
	private int[] actionExps = new int[10];
	private int actionExpIndex = 0;
	private Actor lastOpponent;
	private int avgHealth = 0;
	private static final double LONG_RANGE_XP_MODIFIER = 2.0;
	private static final double DEFAULT_XP_MODIFIER = 4.0;
	private static final double SHARED_XP_MODIFIER = DEFAULT_XP_MODIFIER / 3.0;

	private int getCurrentXp()
	{
		return startXp + xpGained;
	}

	private int getActionsHr()
	{
		return toHourly(actions);
	}

	private int toHourly(int value)
	{
		if (skillTime == 0)
		{
			return 0;
		}

		return (int) ((1.0 / (getTimeElapsedInSeconds() / 3600.0)) * value);
	}

	private long getTimeElapsedInSeconds()
	{
		if (skillTime == 0)
		{
			return 0;
		}

		// If the skill started just now, we can divide by near zero, this results in odd behavior.
		// To prevent that, pretend the skill has been active for a minute (60 seconds)
		// This will create a lower estimate for the first minute,
		// but it isn't ridiculous like saying 2 billion XP per hour.
		return Math.max(60, skillTime / 1000);
	}

	private int getXpRemaining()
	{
		return endLevelExp - getCurrentXp();
	}

	private int getActionsRemaining()
	{
		if (actionsHistoryInitialized)
		{
			long xpRemaining = getXpRemaining() * actionExps.length;
			long totalActionXp = 0;

			for (int actionXp : actionExps)
			{
				totalActionXp += actionXp;
			}

			// Let's not divide by zero (or negative)
			if (totalActionXp > 0)
			{
				// Make sure to account for the very last action at the end
				long remainder = xpRemaining % totalActionXp;
				long quotient = xpRemaining / totalActionXp;
				return Math.toIntExact(quotient + (remainder > 0 ? 1 : 0));
			}
		}

		return Integer.MAX_VALUE;
	}

	private int getKillsRemaining(Client client)
	{
		int killsRemaining = Integer.MAX_VALUE;
		Player local = client.getLocalPlayer();
		if (local == null)
		{
			return Integer.MAX_VALUE;
		}
		Actor opponent = local.getInteracting();
		if (opponent == null)
			return killsRemaining;

		if (opponent instanceof Player)
		{
			return killsRemaining;
		}
		if (XpTrackerPlugin.COMBAT.contains(skill) && opponent.getCombatLevel() > 0)
		{
			int opponentHealth = oppInfoHealth.get(opponent.getName() + '_' + opponent.getCombatLevel());
			if (opponentHealth > 0)
			{
				if (lastOpponent == null || opponent != lastOpponent)
				{
					// New opponent, need to reset avgHealth
					avgHealth = opponentHealth;
					lastOpponent = opponent;
				}
				else if (avgHealth != 0)
				{
					avgHealth = (int) Math.floor((avgHealth + opponentHealth) / 2);
				}
				else
				{
					avgHealth = opponentHealth;
				}

				double modifier = getCombatXPModifier(client);
				double actionExp = (avgHealth * modifier);
				killsRemaining = (int) Math.ceil(getXpRemaining() / actionExp);
			}
		}

		return killsRemaining;
	}

	private double getCombatXPModifier(Client client)
	{
		if (skill.equals(Skill.HITPOINTS))
		{
			return SHARED_XP_MODIFIER;
		}

		int styleIndex = client.getVar(VarPlayer.ATTACK_STYLE);
		WeaponType weaponType = WeaponType.getWeaponType(client.getVar(Varbits.EQUIPPED_WEAPON_TYPE));
		if (weaponType.getAttackStyles()[styleIndex].equals(AttackStyle.CONTROLLED))
		{
			return SHARED_XP_MODIFIER;
		}
		else if (weaponType.getAttackStyles()[styleIndex].equals(AttackStyle.LONGRANGE))
		{
			return LONG_RANGE_XP_MODIFIER;
		}
		else
		{
			return DEFAULT_XP_MODIFIER;
		}
	}

	private int getSkillProgress()
	{
		double xpGained = getCurrentXp() - startLevelExp;
		double xpGoal = endLevelExp - startLevelExp;
		return (int) ((xpGained / xpGoal) * 100);
	}

	private String getTimeTillLevel()
	{
		long seconds = getTimeElapsedInSeconds();

		if (seconds <= 0 || xpGained <= 0)
		{
			// Infinity symbol
			return "\u221e";
		}

		// formula is xpRemaining / xpPerSecond
		// xpPerSecond being xpGained / seconds
		// This can be simplified so division is only done once and we can work in whole numbers!
		long remainingSeconds = (getXpRemaining() * seconds) / xpGained;

		// Java 8 doesn't have good duration / period objects to represent spans of time that can be formatted
		// Rather than importing another dependency like joda time (which is practically built into java 10)
		// below will be a custom formatter that handles spans larger than 1 day

		long durationDays = remainingSeconds / (24 * 60 * 60);
		long durationHours = (remainingSeconds % (24 * 60 * 60)) / (60 * 60);
		long durationMinutes = (remainingSeconds % (60 * 60)) / 60;
		long durationSeconds = remainingSeconds % 60;

		if (durationDays > 1)
		{
			return String.format("%d days %02d:%02d:%02d", durationDays, durationHours, durationMinutes, durationSeconds);
		}
		else if (durationDays == 1)
		{
			return String.format("1 day %02d:%02d:%02d", durationHours, durationMinutes, durationSeconds);
		}
		else if (durationHours > 0)
		{
			return String.format("%02d:%02d:%02d", durationHours, durationMinutes, durationSeconds);
		}

		// Minutes and seconds will always be present
		return String.format("%02d:%02d", durationMinutes, durationSeconds);
	}

	private static Map<String, Integer> loadNpcHealth()
	{
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, Integer>>()
		{
		}.getType();

		InputStream healthFile = XpStateSingle.class.getResourceAsStream("/npc_health.json");
		return gson.fromJson(new InputStreamReader(healthFile), type);
	}


	int getXpHr()
	{
		return toHourly(xpGained);
	}

	boolean update(int currentXp, int goalStartXp, int goalEndXp)
	{
		if (startXp == -1)
		{
			log.warn("Attempted to update skill state " + skill + " but was not initialized with current xp");
			return false;
		}

		int originalXp = xpGained + startXp;
		int actionExp = currentXp - originalXp;

		// No experience gained
		if (actionExp == 0)
		{
			return false;
		}

		if (actionsHistoryInitialized)
		{
			actionExps[actionExpIndex] = actionExp;
		}
		else
		{
			// So we have a decent average off the bat, lets populate all values with what we see.
			for (int i = 0; i < actionExps.length; i++)
			{
				actionExps[i] = actionExp;
			}

			actionsHistoryInitialized = true;
		}

		actionExpIndex = (actionExpIndex + 1) % actionExps.length;
		actions++;

		// Calculate experience gained
		xpGained = currentXp - startXp;

		// Determine XP goals
		if (goalStartXp <= 0 || currentXp > goalEndXp)
		{
			startLevelExp = Experience.getXpForLevel(Experience.getLevelForXp(currentXp));
		}
		else
		{
			startLevelExp = goalStartXp;
		}

		if (goalEndXp <= 0 || currentXp > goalEndXp)
		{
			int currentLevel = Experience.getLevelForXp(currentXp);
			endLevelExp = currentLevel + 1 <= Experience.MAX_VIRT_LEVEL
				? Experience.getXpForLevel(currentLevel + 1)
				: Experience.MAX_SKILL_XP;
		}
		else
		{
			endLevelExp = goalEndXp;
		}

		return true;
	}

	public void tick(long delta)
	{
		// Don't tick skills that have not gained XP or have been reset.
		if (xpGained <= 0)
		{
			return;
		}
		skillTime += delta;
	}

	XpSnapshotSingle snapshot(Client client)
	{
		return XpSnapshotSingle.builder()
			.startLevel(Experience.getLevelForXp(startLevelExp))
			.endLevel(Experience.getLevelForXp(endLevelExp))
			.xpGainedInSession(xpGained)
			.xpRemainingToGoal(getXpRemaining())
			.xpPerHour(getXpHr())
			.skillProgressToGoal(getSkillProgress())
			.actionsInSession(actions)
			.actionsRemainingToGoal(getActionsRemaining())
			.actionsPerHour(getActionsHr())
			.killsRemainingToGoal(getKillsRemaining(client))
			.timeTillGoal(getTimeTillLevel())
			.startGoalXp(startLevelExp)
			.endGoalXp(endLevelExp)
			.build();
	}
}
