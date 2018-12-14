/*
 * Copyright (c) 2018, Marshall <https://github.com/marshdevs>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.achievementdiary;

import java.awt.Color;
import java.util.List;
import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.client.util.ColorUtil;

class RequirementStringBuilder
{
	private final Requirement requirement;
	@Getter
	private String requirementString;

	RequirementStringBuilder(Requirement requirement)
	{
		this.requirement = requirement;

		int levelRequirement = requirement.getLevelRequirement();
		Skill skill = requirement.getSkill();
		Requirement[] altRequirements = requirement.getAltRequirements();

		StringBuilder requirementStringBuilder = new StringBuilder()
			.append(levelRequirement)
			.append(" ")
			.append(skill != null ? skill.getName() : requirement.getCustomRequirement());
		for (Requirement i : altRequirements)
		{
			requirementStringBuilder.append(" or ")
				.append(i.getLevelRequirement())
				.append(" ")
				.append(i.getSkill().getName());
		}
		this.requirementString = requirementStringBuilder.toString();
	}

	void strikeThroughRequirement()
	{
		this.requirementString = "<str>" + this.requirementString + "</str>";
	}

	void colorRedRequirement()
	{
		this.requirementString = ColorUtil.wrapWithColorTag(this.requirementString, new Color(0x800000));
	}

	boolean hasLevelRequirement(int realSkillLevel, List<Integer> altRealSkillLevels)
	{
		return hasLevelRequirement(requirement, realSkillLevel, altRealSkillLevels);
	}

	private static boolean hasLevelRequirement(Requirement requirement, int realSkillLevel, List<Integer> altRealSkillLevels)
	{
		int levelRequirement = requirement.getLevelRequirement();
		Requirement[] altRequirements = requirement.getAltRequirements();

		boolean hasReq = (realSkillLevel >= levelRequirement);
		if (altRequirements != null && altRealSkillLevels != null)
		{
			int reqCounter = 0;
			for (Requirement i : altRequirements)
			{
				hasReq = (hasReq || hasLevelRequirement(i, altRealSkillLevels.get(reqCounter), null));
				reqCounter++;
			}
		}
		return hasReq;
	}
}
