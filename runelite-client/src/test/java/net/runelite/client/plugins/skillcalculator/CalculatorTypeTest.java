/*
 * Copyright (c) 2021, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.skillcalculator;

import net.runelite.client.plugins.skillcalculator.skills.SkillAction;
import net.runelite.client.plugins.skillcalculator.skills.SkillBonus;
import static org.junit.Assert.fail;
import org.junit.Test;

public class CalculatorTypeTest
{

	@Test
	public void skillActionsInOrder()
	{
		for (final CalculatorType calculatorType : CalculatorType.values())
		{
			final String skillName = calculatorType.getSkill().getName();
			int prevLevel = 0;
			float prevXP = 0.0f;
			String prevName = "";

			for (final SkillAction skillAction : calculatorType.getSkillActions())
			{
				int currentLevel = skillAction.getLevel();
				float currentXP = skillAction.getXp();
				String currentName = skillAction.toString();

				if (currentLevel < prevLevel)
				{
					fail(skillName + " skill action " + skillAction + " is not ordered by level.");
				}
				else if (currentLevel == prevLevel)
				{
					if (currentXP < prevXP)
					{
						fail(skillName + " skill action " + skillAction + " is not ordered by xp among level " + currentLevel + " actions.");
					}
					else if (currentXP == prevXP && currentName.compareTo(prevName) < 0)
					{
						fail(skillName + " skill action " + skillAction + " is not ordered alphabetically among " + currentXP + "xp skills at level " + currentLevel + '.');
					}
				}

				prevLevel = currentLevel;
				prevXP = currentXP;
				prevName = currentName;
			}
		}
	}

	@Test
	public void testSkillBonusesMutuallyStack()
	{
		for (final CalculatorType calculatorType : CalculatorType.values())
		{
			final SkillBonus[] skillBonuses = calculatorType.getSkillBonuses();
			if (skillBonuses == null)
			{
				continue;
			}

			final String skillName = calculatorType.getSkill().getName();

			for (final SkillBonus skillBonus : skillBonuses)
			{
				for (final SkillBonus stackedSkillBonus : skillBonus.getCanBeStackedWith())
				{
					if (!stackedSkillBonus.getCanBeStackedWith().contains(skillBonus))
					{
						fail(skillName + " skill bonus " + skillBonus + " is not mutually stacked with skill bonus " + stackedSkillBonus);
					}
				}
			}
		}
	}
}
