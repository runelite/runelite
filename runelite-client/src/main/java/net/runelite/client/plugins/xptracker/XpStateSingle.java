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

import java.time.Duration;
import java.time.Instant;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Experience;
import net.runelite.api.Skill;

@Data
@Slf4j
class XpStateSingle
{
	private final Skill skill;
	private final int startXp;
	private Instant skillTimeStart = null;
	private int xpGained = 0;
	private int actions = 0;
	private int nextLevelExp = 0;
	private int startLevelExp = 0;
	private int level = 0;
	private boolean actionsHistoryInitialized = false;
	private int[] actionExps = new int[10];
	private int actionExpIndex = 0;

	int getXpHr()
	{
		return toHourly(xpGained);
	}

	int getActionsHr()
	{
		return toHourly(actions);
	}

	private int toHourly(int value)
	{
		if (skillTimeStart == null)
		{
			return 0;
		}

		return (int) ((1.0 / (getTimeElapsedInSeconds() / 3600.0)) * value);
	}

	private long getTimeElapsedInSeconds()
	{
		if (skillTimeStart == null)
		{
			return 0;
		}

		// If the skill started just now, we can divide by near zero, this results in odd behavior.
		// To prevent that, pretend the skill has been active for a minute (60 seconds)
		// This will create a lower estimate for the first minute,
		// but it isn't ridiculous like saying 2 billion XP per hour.
		return Math.max(60, Duration.between(skillTimeStart, Instant.now()).getSeconds());
	}

	int getXpRemaining()
	{
		return nextLevelExp - (startXp + xpGained);
	}

	int getActionsRemaining()
	{
		if (actionsHistoryInitialized)
		{
			long xpRemaining = getXpRemaining() * actionExps.length;
			long actionExp = 0;

			for (int i = 0; i < actionExps.length; i++)
			{
				actionExp += actionExps[i];
			}

			// Let's not divide by zero (or negative)
			if (actionExp > 0)
			{
				// Make sure to account for the very last action at the end
				long remainder = xpRemaining % actionExp;
				long quotient = xpRemaining / actionExp;
				return Math.toIntExact(quotient + (remainder > 0 ? 1 : 0));
			}
		}

		return Integer.MAX_VALUE;
	}

	int getSkillProgress()
	{
		int currentXp = startXp + xpGained;

		double xpGained = currentXp - startLevelExp;
		double xpGoal = nextLevelExp - startLevelExp;
		return (int) ((xpGained / xpGoal) * 100);
	}

	String getTimeTillLevel()
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


	boolean update(int currentXp)
	{
		if (startXp == -1)
		{
			log.warn("Attempted to update skill state " + skill + " but was not initialized with current xp");
			return false;
		}

		int originalXp = xpGained + startXp;
		int actionExp = currentXp - originalXp;

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
		xpGained = currentXp - startXp;
		startLevelExp = Experience.getXpForLevel(Experience.getLevelForXp(currentXp));

		int currentLevel = Experience.getLevelForXp(currentXp);

		level = currentLevel;

		nextLevelExp = currentLevel + 1 <= Experience.MAX_VIRT_LEVEL ? Experience.getXpForLevel(currentLevel + 1) : -1;

		if (skillTimeStart == null)
		{
			skillTimeStart = Instant.now();
		}

		return true;
	}

	XpSnapshotSingle snapshot()
	{
		return XpSnapshotSingle.builder()
			.currentLevel(getLevel())
			.xpGainedInSession(getXpGained())
			.xpRemainingToGoal(getXpRemaining())
			.xpPerHour(getXpHr())
			.skillProgressToGoal(getSkillProgress())
			.actionsInSession(getActions())
			.actionsRemainingToGoal(getActionsRemaining())
			.actionsPerHour(getActionsHr())
			.timeTillGoal(getTimeTillLevel())
			.build();
	}
}