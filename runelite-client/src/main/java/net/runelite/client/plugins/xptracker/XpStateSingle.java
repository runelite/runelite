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

<<<<<<< HEAD
import java.time.Duration;
import java.time.Instant;
<<<<<<< HEAD
import java.time.LocalTime;
import lombok.Data;
=======
import lombok.Getter;
import lombok.RequiredArgsConstructor;
>>>>>>> upstream/master
=======
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
>>>>>>> upstream/master
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Experience;
import net.runelite.api.Skill;

<<<<<<< HEAD
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
=======
@Slf4j
@RequiredArgsConstructor
class XpStateSingle
{
	private final Skill skill;
	private final Map<XpActionType, XpAction> actions = new HashMap<>();

	@Getter
	private final long startXp;

	@Getter
	private int xpGained = 0;

	@Setter
	private XpActionType actionType = XpActionType.EXPERIENCE;

	private long skillTime = 0;
	private int startLevelExp = 0;
	private int endLevelExp = 0;
<<<<<<< HEAD
>>>>>>> upstream/master
	private boolean actionsHistoryInitialized = false;
	private int[] actionExps = new int[10];
	private int actionExpIndex = 0;

<<<<<<< HEAD
	int getXpHr()
	{
		return toHourly(xpGained);
	}

	int getXpSec()
	{
		return getXpHr() / 3600;
	}

	int getActionsHr()
	{
		return toHourly(actions);
	}

	private int toHourly(int value)
=======
	private int getCurrentXp()
=======

	XpAction getXpAction(final XpActionType type)
	{
		actions.putIfAbsent(type, new XpAction());
		return actions.get(type);
	}

	private long getCurrentXp()
>>>>>>> upstream/master
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
>>>>>>> upstream/master
	{
		// If the skill started just now, we can divide by near zero, this results in odd behavior.
		// To prevent that, pretend the skill has been active for a minute (60 seconds)
		// This will create a lower estimate for the first minute,
		// but it isn't ridiculous like saying 2 billion XP per hour.
<<<<<<< HEAD
<<<<<<< HEAD
		long timeElapsedInSeconds = Math.max(60, Duration.between(skillTimeStart, Instant.now()).getSeconds());
		return (int) ((1.0 / (timeElapsedInSeconds / 3600.0)) * value);
	}

	int getXpRemaining()
	{
		return nextLevelExp - (startXp + xpGained);
	}

	int getActionsRemaining()
=======
		return Math.max(60, Duration.between(skillTimeStart, Instant.now()).getSeconds());
=======
		return Math.max(60, skillTime / 1000);
>>>>>>> upstream/master
	}

	private int getXpRemaining()
	{
		return endLevelExp - (int) getCurrentXp();
	}

	private int getActionsRemaining()
>>>>>>> upstream/master
	{
		final XpAction action = getXpAction(actionType);

		if (action.isActionsHistoryInitialized())
		{
<<<<<<< HEAD
			long xpRemaining = getXpRemaining() * actionExps.length;
<<<<<<< HEAD
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
=======
=======
			long xpRemaining = getXpRemaining() * action.getActionExps().length;
>>>>>>> upstream/master
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
>>>>>>> upstream/master
				return Math.toIntExact(quotient + (remainder > 0 ? 1 : 0));
			}
		}

		return Integer.MAX_VALUE;
	}

<<<<<<< HEAD
<<<<<<< HEAD
	int getSkillProgress()
	{
		int currentXp = startXp + xpGained;

		double xpGained = currentXp - startLevelExp;
		double xpGoal = nextLevelExp - startLevelExp;
		return (int) ((xpGained / xpGoal) * 100);
	}

	String getTimeTillLevel()
	{
		if (getXpSec() > 0)
		{
			return LocalTime.MIN.plusSeconds( getXpRemaining() / getXpSec() ).toString();
		}
		return "\u221e";
	}


	boolean update(int currentXp)
=======
	private int getSkillProgress()
=======
	private double getSkillProgress()
>>>>>>> upstream/master
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

<<<<<<< HEAD
	boolean update(int currentXp, int goalStartXp, int goalEndXp)
>>>>>>> upstream/master
=======
	boolean update(long currentXp, int goalStartXp, int goalEndXp)
>>>>>>> upstream/master
	{
		if (startXp == -1)
		{
			log.warn("Attempted to update skill state " + skill + " but was not initialized with current xp");
			return false;
		}

		long originalXp = xpGained + startXp;
		int actionExp = (int) (currentXp - originalXp);

<<<<<<< HEAD
=======
		// No experience gained
>>>>>>> upstream/master
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

<<<<<<< HEAD
		actionExpIndex = (actionExpIndex + 1) % actionExps.length;
<<<<<<< HEAD

		actions++;
		xpGained = currentXp - startXp;
		startLevelExp = Experience.getXpForLevel(Experience.getLevelForXp(currentXp));

		int currentLevel = Experience.getLevelForXp(currentXp);

		level = currentLevel;

		nextLevelExp = currentLevel + 1 <= Experience.MAX_VIRT_LEVEL ? Experience.getXpForLevel(currentLevel + 1) : -1;

=======
		actions++;
=======
		action.setActionExpIndex((action.getActionExpIndex() + 1) % action.getActionExps().length);
		action.setActions(action.getActions() + 1);
>>>>>>> upstream/master

		// Calculate experience gained
		xpGained = (int) (currentXp - startXp);

		// Determine XP goals, overall has no goals
		if (skill != Skill.OVERALL)
		{
			if (goalStartXp <= 0 || currentXp > goalEndXp)
			{
				startLevelExp = Experience.getXpForLevel(Experience.getLevelForXp((int) currentXp));
			}
			else
			{
				startLevelExp = goalStartXp;
			}

			if (goalEndXp <= 0 || currentXp > goalEndXp)
			{
				int currentLevel = Experience.getLevelForXp((int) currentXp);
				endLevelExp = currentLevel + 1 <= Experience.MAX_VIRT_LEVEL
					? Experience.getXpForLevel(currentLevel + 1)
					: Experience.MAX_SKILL_XP;
			}
			else
			{
				endLevelExp = goalEndXp;
			}
		}

<<<<<<< HEAD
		// If this is first time we are updating, we just started tracking
>>>>>>> upstream/master
		if (skillTimeStart == null)
=======
		return true;
	}

	public void tick(long delta)
	{
		// Don't tick skills that have not gained XP or have been reset.
		if (xpGained <= 0)
>>>>>>> upstream/master
		{
			return;
		}
		skillTime += delta;
	}

	XpSnapshotSingle snapshot()
	{
		return XpSnapshotSingle.builder()
<<<<<<< HEAD
			.currentLevel(getLevel())
			.xpGainedInSession(getXpGained())
			.xpRemainingToGoal(getXpRemaining())
			.xpPerHour(getXpHr())
			.skillProgressToGoal(getSkillProgress())
			.actionsInSession(getActions())
=======
			.startLevel(Experience.getLevelForXp(startLevelExp))
			.endLevel(Experience.getLevelForXp(endLevelExp))
			.xpGainedInSession(xpGained)
			.xpRemainingToGoal(getXpRemaining())
			.xpPerHour(getXpHr())
			.skillProgressToGoal(getSkillProgress())
<<<<<<< HEAD
			.actionsInSession(actions)
>>>>>>> upstream/master
=======
			.actionType(actionType)
			.actionsInSession(getXpAction(actionType).getActions())
>>>>>>> upstream/master
			.actionsRemainingToGoal(getActionsRemaining())
			.actionsPerHour(getActionsHr())
			.timeTillGoal(getTimeTillLevel())
			.startGoalXp(startLevelExp)
			.endGoalXp(endLevelExp)
			.build();
	}
}
