/*
 * Copyright (c) 2017, Steve <steve.rs.dev@gmail.com>
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
package net.runelite.client.plugins.xpglobes;

import java.awt.image.BufferedImage;
import java.time.Instant;

import lombok.Setter;
import lombok.Getter;
import net.runelite.api.Skill;

public class XpGlobe
{
	@Setter
	@Getter
	private Skill skill;

	@Setter
	@Getter
	private int currentXp;

	@Setter
	@Getter
	private int currentLevel;

	@Setter
	@Getter
	private int goalXp;

	@Setter
	@Getter
	private Instant time;

	@Setter
	@Getter
	private BufferedImage skillIcon;

	@Setter
	@Getter
	private int globeSize;

	@Getter
	private double skillProgressRadius;

	public XpGlobe(Skill skill, int currentXp, int currentLevel, int goalXp)
	{
		this.skill = skill;
		this.currentXp = currentXp;
		this.currentLevel = currentLevel;
		this.goalXp = goalXp;
	}

	public int getGoalLevel()
	{
		return this.currentLevel++;
	}

	public String getSkillName()
	{
		return skill.getName();
	}

	public void setSkillProgressRadius(int startXp, int currentXp, int goalXp)
	{
		this.skillProgressRadius = -(3.6 * getSkillProgress(startXp, currentXp, goalXp)); //arc goes backwards
	}

	public double getSkillProgress(int startXp, int currentXp, int goalXp)
	{
		double xpGained = currentXp - startXp;
		double xpGoal = goalXp - startXp;

		return ((xpGained / xpGoal) * 100);
	}
}
