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

import net.runelite.api.Skill;
import java.time.Duration;
import java.time.Instant;

public class SkillXPInfo
{
	private Skill skill;
	private Instant skillTimeStart = null;
	private int xpGained = 0;
	private int loginXp = 0;

	public SkillXPInfo(int loginXp, Skill skill)
	{
		this.skill = skill;
		this.loginXp = loginXp;
	}

	public int getXpHr()
	{
		long timeElapsedInSeconds = Duration.between(
				skillTimeStart, Instant.now()).getSeconds();
		return (int) ((1.0 / (timeElapsedInSeconds / 3600.0)) * xpGained);

	}

	public void reset(int loginXp)
	{
		xpGained = 0;
		this.loginXp = loginXp;
		skillTimeStart = null;
	}

	public void update(int currentXp)
	{
		xpGained = currentXp - loginXp;
		if (skillTimeStart == null)
			skillTimeStart = Instant.now();
	}

	public Instant getSkillTimeStart()
	{
		return skillTimeStart;
	}

	public int getXpGained()
	{
		return xpGained;
	}

	public int getLoginXp()
	{
		return loginXp;
	}

	public Skill getSkill()
	{
		return this.skill;
	}
}
