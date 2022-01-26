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

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import net.runelite.api.Skill;

class SkillAbbreviations
{
	private static final Map<String, String> MAP;

	static
	{
		ImmutableMap.Builder<String, String> builder = new ImmutableMap.Builder<>();
		builder.put("ATK", Skill.ATTACK.getName());
		builder.put("ATT", Skill.ATTACK.getName());
		builder.put("DEF", Skill.DEFENCE.getName());
		builder.put("STR", Skill.STRENGTH.getName());
		builder.put("HEALTH", Skill.HITPOINTS.getName());
		builder.put("HIT", Skill.HITPOINTS.getName());
		builder.put("HITPOINT", Skill.HITPOINTS.getName());
		builder.put("HP", Skill.HITPOINTS.getName());
		builder.put("RANGE", Skill.RANGED.getName());
		builder.put("RANGING", Skill.RANGED.getName());
		builder.put("RNG", Skill.RANGED.getName());
		builder.put("PRAY", Skill.PRAYER.getName());
		builder.put("MAG", Skill.MAGIC.getName());
		builder.put("MAGE", Skill.MAGIC.getName());
		builder.put("COOK", Skill.COOKING.getName());
		builder.put("WC", Skill.WOODCUTTING.getName());
		builder.put("WOOD", Skill.WOODCUTTING.getName());
		builder.put("WOODCUT", Skill.WOODCUTTING.getName());
		builder.put("FLETCH", Skill.FLETCHING.getName());
		builder.put("FISH", Skill.FISHING.getName());
		builder.put("FM", Skill.FIREMAKING.getName());
		builder.put("FIRE", Skill.FIREMAKING.getName());
		builder.put("CRAFT", Skill.CRAFTING.getName());
		builder.put("SMITH", Skill.SMITHING.getName());
		builder.put("MINE", Skill.MINING.getName());
		builder.put("HL", Skill.HERBLORE.getName());
		builder.put("HERB", Skill.HERBLORE.getName());
		builder.put("AGI", Skill.AGILITY.getName());
		builder.put("AGIL", Skill.AGILITY.getName());
		builder.put("THIEF", Skill.THIEVING.getName());
		builder.put("SLAY", Skill.SLAYER.getName());
		builder.put("FARM", Skill.FARMING.getName());
		builder.put("RC", Skill.RUNECRAFT.getName());
		builder.put("RUNE", Skill.RUNECRAFT.getName());
		builder.put("RUNECRAFTING", Skill.RUNECRAFT.getName());
		builder.put("HUNT", Skill.HUNTER.getName());
		builder.put("CON", Skill.CONSTRUCTION.getName());
		builder.put("CONSTRUCT", Skill.CONSTRUCTION.getName());
		builder.put("ALL", Skill.OVERALL.getName());
		builder.put("TOTAL", Skill.OVERALL.getName());
		MAP = builder.build();
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
