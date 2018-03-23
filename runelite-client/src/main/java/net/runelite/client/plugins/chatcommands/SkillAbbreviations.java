/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.chatcommands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.api.Skill;

class SkillAbbreviations
{
	private static final Map<String, String> ALT_NAMES = new HashMap<>();

	static
	{
		ALT_NAMES.put("ATK", Skill.ATTACK.getName());
		ALT_NAMES.put("HEALTH", Skill.HITPOINTS.getName());
		ALT_NAMES.put("HP", Skill.HITPOINTS.getName());
		ALT_NAMES.put("RANGING", Skill.RANGED.getName());
		ALT_NAMES.put("RNG", Skill.RANGED.getName());
		ALT_NAMES.put("MAGE", Skill.MAGIC.getName());
		ALT_NAMES.put("WC", Skill.WOODCUTTING.getName());
		ALT_NAMES.put("FM", Skill.FIREMAKING.getName());
		ALT_NAMES.put("MINE", Skill.MINING.getName());
		ALT_NAMES.put("HL", Skill.HERBLORE.getName());
		ALT_NAMES.put("THIEF", Skill.THIEVING.getName());
		ALT_NAMES.put("THIEVE", Skill.THIEVING.getName());
		ALT_NAMES.put("RC", Skill.RUNECRAFT.getName());
		ALT_NAMES.put("RUNECRAFTING", Skill.RUNECRAFT.getName());
		ALT_NAMES.put("ALL", Skill.OVERALL.getName());
		ALT_NAMES.put("TOTAL", Skill.OVERALL.getName());
	}

	/**
	 * Takes a string representing the name of a skill, and if abbreviated,
	 * expands it into its full canonical name. Case-insensitive.
	 *
	 * @param abbrev Skill name that may be abbreviated.
	 * @return Full skill name if recognized, else the original string.
	 */
	static String getFullName(String abbrev)
	{
		if (ALT_NAMES.containsKey(abbrev.toUpperCase()))
		{
			return ALT_NAMES.getOrDefault(abbrev.toUpperCase(), abbrev);
		}
		else
		{
			return getFullNameStartingWith(abbrev);
		}
	}

	/**
	 * Takes the first few letters of a skill, and if exactly one skill starts
	 * with them, expands it into its full canonical name. Case-insensitive.
	 *
	 * @param abbrev First few letters of a skill.
	 * @return Full skill name if recognized, else the original string.
	 */
	private static String getFullNameStartingWith(String abbrev)
	{
		List<Skill> matches = new ArrayList<>();
		for (Skill skill : Skill.class.getEnumConstants())
		{
			if (skill.getName().toUpperCase().startsWith(abbrev.toUpperCase()))
			{
				matches.add(skill);
			}
		}

		if (matches.size() == 1)
		{
			return matches.get(0).getName();
		}
		else
		{
			return abbrev;
		}
	}
}
