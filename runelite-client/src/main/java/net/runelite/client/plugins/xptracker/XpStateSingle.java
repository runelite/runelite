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

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Experience;
import net.runelite.api.Skill;

@Slf4j
@RequiredArgsConstructor
class XpStateSingle
{
	private final Skill skill;
	private final Map<XpActionType, XpAction> actions = new HashMap<>();

	@Getter
	private final int startXp;

	@Getter
	private int xpGained = 0;

	@Setter
	private XpActionType actionType = XpActionType.EXPERIENCE;

	private long skillTime = 0;
	private int startLevelExp = 0;
	private int endLevelExp = 0;

	XpAction getXpAction(final XpActionType type)
	{
		actions.putIfAbsent(type, new XpAction());
		return actions.get(type);
	}

	private int getCurrentXp()
	{
		return startXp + xpGained;
	}

	private int getActionsHr()
	{
		return toHourly(getXpAction(actionType).getActions());
	}

	private int toHourly(int value)
	{
		return (int) ((1.0 / (getTimeElapsedInSeconds() / 3600.0)) * value);
	}

	private long getTimeElapsedInSeconds()
	{
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
		final XpAction action = getXpAction(actionType);

		if (action.isActionsHistoryInitialized())
		{
			long xpRemaining = getXpRemaining() * action.getActionExps().length;
			long totalActionXp = 0;

			for (int actionXp : action.getActionExps())
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

	private double getSkillProgress()
	{
		double xpGained = getCurrentXp() - startLevelExp;
		double xpGoal = endLevelExp - startLevelExp;
		return (xpGained / xpGoal) * 100;
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

		// Update EXPERIENCE action
		final XpAction action = getXpAction(XpActionType.EXPERIENCE);

		if (action.isActionsHistoryInitialized())
		{
			action.getActionExps()[action.getActionExpIndex()] = actionExp;
		}
		else
		{
			// populate all values in our action history array with this first value that we see
			// so the average value of our action history starts out as this first value we see
			for (int i = 0; i < action.getActionExps().length; i++)
			{
				action.getActionExps()[i] = actionExp;
			}

			action.setActionsHistoryInitialized(true);
		}

		action.setActionExpIndex((action.getActionExpIndex() + 1) % action.getActionExps().length);
		action.setActions(action.getActions() + 1);

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

	XpSnapshotSingle snapshot()
	{
		return XpSnapshotSingle.builder()
			.startLevel(Experience.getLevelForXp(startLevelExp))
			.endLevel(Experience.getLevelForXp(endLevelExp))
			.xpGainedInSession(xpGained)
			.xpRemainingToGoal(getXpRemaining())
			.xpPerHour(getXpHr())
			.skillProgressToGoal(getSkillProgress())
			.actionType(actionType)
			.actionsInSession(getXpAction(actionType).getActions())
			.actionsRemainingToGoal(getActionsRemaining())
			.actionsPerHour(getActionsHr())
			.timeTillGoal(getTimeTillLevel())
			.startGoalXp(startLevelExp)
			.endGoalXp(endLevelExp)
			.build();
	}
}
