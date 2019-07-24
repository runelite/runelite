/*
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.skillcalculator.banked.beans;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Skill;

@AllArgsConstructor
@Getter
public enum XpModifiers
{
	LIT_GILDER_ALTAR(Skill.PRAYER, "Lit Gilded Altar (350%)", 3.5f),
	ECTOFUNTUS(Skill.PRAYER, "Ectofuntus (400%)", 4),
	WILDY_ALTAR(Skill.PRAYER, "Wildy Altar (700%)", 7),

	FARMERS_OUTFIT(Skill.FARMING, "Farmer's Outfit (+2.5%)", 1.025f);

	private final Skill skill;
	private final String name;
	private final float modifier;

	private final static Multimap<Skill, XpModifiers> MODIFIERS_MAP;

	static
	{
		final ImmutableMultimap.Builder<Skill, XpModifiers> map = ImmutableMultimap.builder();
		for (final XpModifiers m : values())
		{
			map.put(m.skill, m);
		}
		MODIFIERS_MAP = map.build();
	}

	public static Collection<XpModifiers> getModifiersBySkill(final Skill skill)
	{
		return MODIFIERS_MAP.get(skill);
	}
}