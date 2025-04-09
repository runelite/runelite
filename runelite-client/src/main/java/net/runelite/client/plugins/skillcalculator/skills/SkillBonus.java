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
package net.runelite.client.plugins.skillcalculator.skills;

import java.util.Collections;
import java.util.Set;

/**
 * An object representing a skill bonus, such as from a skilling outfit or activity granting boosted xp.
 */
public interface SkillBonus
{
	/**
	 * Gets the name of this skill bonus.
	 *
	 * @return The name of this skill bonus.
	 */
	String getName();

	/**
	 * Gets the multiplier for this skill bonus. When multiplied with the skill action XP value, it yields the total
	 * amount of xp granted for that action. (eg. {@code {@link SkillAction#getXp()} * {@link #getValue()}} yields the
	 * full amount of xp gained)
	 *
	 * @return The skill bonus multiplier.
	 */
	float getValue();


	/**
	 * Gets the list of skill bonuses this skill bonus can be stacked with.
	 *
	 * @return List of stackable skill bonuses
	 */
	default Set<? extends SkillBonus> getCanBeStackedWith()
	{
		return Collections.emptySet();
	}
}
