/*
 * Copyright (c) 2017. l2-
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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
package net.runelite.http.api.hiscore;

import java.util.Objects;

public class SingleHiscoreSkillResult
{
	private String player;
	private String skillName;
	private Skill skill;

	public String getPlayer()
	{
		return player;
	}

	public void setPlayer(String player)
	{
		this.player = player;
	}

	public String getSkillName()
	{
		return skillName;
	}

	public void setSkillName(String skillName)
	{
		this.skillName = skillName;
	}

	public Skill getSkill()
	{
		return skill;
	}

	public void setSkill(Skill skill)
	{
		this.skill = skill;
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 37 * hash + Objects.hashCode(this.player);
		hash = 37 * hash + Objects.hashCode(this.skillName);
		hash = 37 * hash + Objects.hashCode(this.skill);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final SingleHiscoreSkillResult other = (SingleHiscoreSkillResult) obj;
		if (!Objects.equals(this.player, other.player))
		{
			return false;
		}
		if (!Objects.equals(this.skillName, other.skillName))
		{
			return false;
		}
		if (!Objects.equals(this.skill, other.skill))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "SingleHiscoreSkillResult{" + "player=" + player + ", skillName=" + skillName + ", skill=" + skill + '}';
	}
}
