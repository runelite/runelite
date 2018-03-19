/*
 * Copyright (c) 2017, Cameron <moberg@tuta.io>
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
import java.time.LocalTime;
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
	private int startXp = -1;
	private int xpGained = 0;
	private int actions = 0;
	private int actionExp = 0;
	private int nextLevelExp = 0;
	private int startLevelExp = 0;
	private int level = 0;

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
	{
		if (skillTimeStart == null)
		{
			return 0;
		}

		long timeElapsedInSeconds = Duration.between(skillTimeStart, Instant.now()).getSeconds();
		return (int) ((1.0 / (timeElapsedInSeconds / 3600.0)) * value);
	}

	int getXpRemaining()
	{
		return nextLevelExp - (startXp + xpGained);
	}

	int getActionsRemaining()
	{
		return (int) Math.ceil(getXpRemaining() / (float) actionExp);
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
		if (getXpSec() > 0)
		{
			return LocalTime.MIN.plusSeconds( getXpRemaining() / getXpSec() ).toString();
		}
		return "\u221e";
	}

	void reset(int currentXp)
	{
		if (startXp != -1)
		{
			startXp = currentXp;
		}

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
}