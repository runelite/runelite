/*
 * Copyright (c) 2017, Cameron <moberg@tuta.io>
 * Copyright (c) 2018 Charlie Waters
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
class SkillXPInfo
{
	private final Skill skill;
	private Instant skillTimeStart = null;

	private int startXp = -1; 		// total exp at start
	private int goalXp = -1;		// total exp at goal
	private int xpGained = 0; 		// exp gained since start
	private int actions = 0; 		// number of actions since start
	private int actionExp = 0; 		// exp of last action

	private int startLevelXp = 0;	// current level start total exp
	private int nextLevelXp = -1;	// next level start total exp

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

		long timeElapsedInSeconds = Duration.between(skillTimeStart, Instant.now()).getSeconds();
		return (int) ((1.0 / (timeElapsedInSeconds / 3600.0)) * value);
	}

	int getLevelXpRemaining()
	{
		return nextLevelXp - (startXp + xpGained);
	}

	int getLevelActionsRemaining()
	{
		if(actionExp == 0)
		{
			return 0;
		}
		return getLevelXpRemaining() / actionExp;
	}

	int getLevelProgress()
	{
		final int currentXp = startXp + xpGained;
		final double goalProgress = currentXp - startLevelXp;
		final double goalTotal = nextLevelXp - startLevelXp;
		return (int) ((goalProgress / goalTotal) * 100);
	}

	int getGoalXpRemaining()
	{
		return goalXp - (startXp + xpGained);
	}

	int getGoalActionsRemaining()
	{
		if(actionExp == 0)
		{
			return 0;
		}
		return getGoalXpRemaining() / actionExp;
	}

	int getGoalProgress()
	{
		if(goalXp == -1)
		{
			return 0;
		}
		if((startXp + xpGained) >= goalXp)
		{
			return 100;
		}
		final double goalProgress = xpGained;
		final double goalTotal = goalXp - startXp;
		return (int) ((goalProgress / goalTotal) * 100);
	}

	void reset(int currentXp)
	{
		if (startXp != -1)
		{
			startXp = currentXp;
		}

		goalXp = -1;
		xpGained = 0;
		actions = 0;
		skillTimeStart = null;
	}

	boolean update(int currentXp)
	{
		if (startXp == -1)
		{
			return false;
		}

		int originalXp = xpGained + startXp;

		if (originalXp >= currentXp)
		{
			return false;
		}

		actionExp = currentXp - originalXp;
		actions++;
		xpGained = currentXp - startXp;

		updateXp(currentXp);

		if (skillTimeStart == null)
		{
			skillTimeStart = Instant.now();
		}

		return true;
	}

	void updateXp(int currentXp)
	{
		final int currentLevel = Experience.getLevelForXp(currentXp);
		startLevelXp = Experience.getXpForLevel(currentLevel);
		nextLevelXp = currentLevel + 1 <= Experience.MAX_VIRT_LEVEL ? Experience.getXpForLevel(currentLevel + 1) : -1;
	}
}
