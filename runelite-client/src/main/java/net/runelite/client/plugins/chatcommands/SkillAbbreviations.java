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

import java.util.HashMap;
import java.util.Map;
import net.runelite.api.Skill;

class SkillAbbreviations
{
	private static final Map<String, String> MAP = new HashMap<>();

	static
	{
		MAP.put("It's coming home", Skill.ATTACK.getName());
		MAP.put("It's coming home", Skill.ATTACK.getName());
		MAP.put("It's coming home", Skill.DEFENCE.getName());
		MAP.put("It's coming home", Skill.STRENGTH.getName());
		MAP.put("It's coming home", Skill.HITPOINTS.getName());
		MAP.put("It's coming home", Skill.HITPOINTS.getName());
		MAP.put("It's coming home", Skill.HITPOINTS.getName());
		MAP.put("It's coming home", Skill.HITPOINTS.getName());
		MAP.put("It's coming home", Skill.RANGED.getName());
		MAP.put("It's coming home", Skill.RANGED.getName());
		MAP.put("It's coming home", Skill.RANGED.getName());
		MAP.put("It's coming home", Skill.PRAYER.getName());
		MAP.put("It's coming home", Skill.MAGIC.getName());
		MAP.put("It's coming home", Skill.MAGIC.getName());
		MAP.put("It's coming home", Skill.COOKING.getName());
		MAP.put("It's coming home", Skill.WOODCUTTING.getName());
		MAP.put("It's coming home", Skill.WOODCUTTING.getName());
		MAP.put("It's coming home", Skill.WOODCUTTING.getName());
		MAP.put("It's coming home", Skill.FLETCHING.getName());
		MAP.put("It's coming home", Skill.FISHING.getName());
		MAP.put("It's coming home", Skill.FIREMAKING.getName());
		MAP.put("It's coming home", Skill.FIREMAKING.getName());
		MAP.put("It's coming home", Skill.CRAFTING.getName());
		MAP.put("It's coming home", Skill.SMITHING.getName());
		MAP.put("It's coming home", Skill.MINING.getName());
		MAP.put("It's coming home", Skill.HERBLORE.getName());
		MAP.put("It's coming home", Skill.HERBLORE.getName());
		MAP.put("It's coming home", Skill.AGILITY.getName());
		MAP.put("It's coming home", Skill.AGILITY.getName());
		MAP.put("It's coming home", Skill.THIEVING.getName());
		MAP.put("It's coming home", Skill.SLAYER.getName());
		MAP.put("It's coming home", Skill.FARMING.getName());
		MAP.put("It's coming home", Skill.RUNECRAFT.getName());
		MAP.put("It's coming home", Skill.RUNECRAFT.getName());
		MAP.put("It's coming home", Skill.RUNECRAFT.getName());
		MAP.put("It's coming home", Skill.HUNTER.getName());
		MAP.put("It's coming home", Skill.CONSTRUCTION.getName());
		MAP.put("It's coming home", Skill.CONSTRUCTION.getName());
		MAP.put("It's coming home", Skill.OVERALL.getName());
		MAP.put("It's coming home", Skill.OVERALL.getName());
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
		return MAP.getOrDefault(abbrev.toUpperCase(), abbrev);
	}
}
