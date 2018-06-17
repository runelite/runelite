/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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

import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public enum BankedItemOptions
{
	/**
	 * Herblore Options
 	 */
	ATTACK_POTION(ItemID.ATTACK_POTION4, "Attack Potion", Skill.HERBLORE, 1, 25, BankedItemOptionItems.GUAM_LEAF),
	GUAM_TAR(ItemID.GUAM_TAR, "Guam tar", Skill.HERBLORE, 19, 30, BankedItemOptionItems.GUAM_LEAF),
	// Marrentil
	ANTIPOISON(ItemID.ANTIPOISON4, "Antipoison", Skill.HERBLORE, 5, 37.5, BankedItemOptionItems.MARRENTILL),
	MARRENTILL_TAR(ItemID.MARRENTILL_TAR, "Marrentill tar", Skill.HERBLORE, 31, 42.5, BankedItemOptionItems.MARRENTILL),
	// Tarromin
	STRENGTH_POTION(ItemID.STRENGTH_POTION4, "Strength potion", Skill.HERBLORE, 12, 50, BankedItemOptionItems.TARROMIN),
	SERUM_207(ItemID.SERUM_207_4, "Serum 207", Skill.HERBLORE, 15, 50, BankedItemOptionItems.TARROMIN),
	TARROMIN_TAR(ItemID.TARROMIN_TAR, "Tarromin tar", Skill.HERBLORE, 39, 55, BankedItemOptionItems.TARROMIN),
	// Harralander
	COMPOST_POTION(ItemID.COMPOST_POTION4, "Compost potion", Skill.HERBLORE, 21, 60, BankedItemOptionItems.HARRALANDER),
	RESTORE_POTION(ItemID.RESTORE_POTION4, "Restore potion", Skill.HERBLORE, 22, 62.5, BankedItemOptionItems.HARRALANDER),
	ENERGY_POTION(ItemID.ENERGY_POTION4, "Energy potion", Skill.HERBLORE, 26, 67.5, BankedItemOptionItems.HARRALANDER),
	COMBAT_POTION(ItemID.COMBAT_POTION4, "Combat potion", Skill.HERBLORE, 36, 84, BankedItemOptionItems.HARRALANDER),
	HARRALANDER_TAR(ItemID.HARRALANDER_TAR, "Harralander tar", Skill.HERBLORE, 44, 72.5, BankedItemOptionItems.HARRALANDER),
	// Ranarr Weed
	DEFENCE_POTION(ItemID.DEFENCE_POTION4, "Defence potion", Skill.HERBLORE, 30, 75, BankedItemOptionItems.RANARR_WEED),
	PRAYER_POTION(ItemID.PRAYER_POTION4, "Prayer potion", Skill.HERBLORE, 38, 87.5, BankedItemOptionItems.RANARR_WEED),
	// Toadflax
	AGILITY_POTION(ItemID.AGILITY_POTION4, "Agility potion", Skill.HERBLORE, 34, 80, BankedItemOptionItems.TOADFLAX),
	SARADOMIN_BREW(ItemID.SARADOMIN_BREW4, "Saradomin brew", Skill.HERBLORE, 81, 180, BankedItemOptionItems.TOADFLAX),
	// Irit
	SUPER_ATTACK(ItemID.SUPER_ATTACK4, "Super attack", Skill.HERBLORE, 45, 100, BankedItemOptionItems.IRIT_LEAF),
	SUPERANTIPOISON(ItemID.SUPERANTIPOISON4, "Superantipoison", Skill.HERBLORE, 48, 106.3, BankedItemOptionItems.IRIT_LEAF),
	// Avantoe
	FISHING_POTION(ItemID.FISHING_POTION4, "Fishing potion", Skill.HERBLORE, 50, 112.5, BankedItemOptionItems.AVANTOE),
	SUPER_ENERGY_POTION(ItemID.SUPER_ENERGY3_20549, "Super energy potion", Skill.HERBLORE, 52, 117.5, BankedItemOptionItems.AVANTOE),
	HUNTER_POTION(ItemID.HUNTER_POTION4, "Hunter potion", Skill.HERBLORE, 53, 120, BankedItemOptionItems.AVANTOE),
	// Snapdragon
	SUPER_RESTORE(ItemID.SUPER_RESTORE4, "Super restore", Skill.HERBLORE, 63, 142.5, BankedItemOptionItems.SNAPDRAGON),
	SANFEW_SERUM(ItemID.SANFEW_SERUM4, "Sanfew serum", Skill.HERBLORE, 65, 160, BankedItemOptionItems.SNAPDRAGON),
	// Lantadyme
	ANTIFIRE_POTION(ItemID.ANTIFIRE_POTION4, "Anti-fire potion", Skill.HERBLORE, 69, 157.5, BankedItemOptionItems.LANTADYME),
	MAGIC_POTION(ItemID.MAGIC_POTION4, "Magic potion", Skill.HERBLORE, 76, 172.5, BankedItemOptionItems.LANTADYME),
	// Torstol
	ZAMORAK_BREW(ItemID.ZAMORAK_BREW4, "Zamorak brew", Skill.HERBLORE, 78, 175, BankedItemOptionItems.TORSTOL),
	SUPER_COMBAT_POTION(ItemID.SUPER_COMBAT_POTION4, "Super combat potion", Skill.HERBLORE, 90, 150, BankedItemOptionItems.TORSTOL_HERBS),

	/*
	 *
	 * Removed single item options
		// Kwuarm
		SUPER_STRENGTH(ItemID.SUPER_STRENGTH4, "Super strength", Skill.HERBLORE, 55, 125, BankedItemOptionItems.KWUARM),
		// Cadanite
		SUPER_DEFENCE_POTION(ItemID.SUPER_DEFENCE4, "Super defence potion", Skill.HERBLORE, 66, 150, BankedItemOptionItems.CADANTINE),
		// Dwarf Weed
		RANGING_POTION(ItemID.RANGING_POTION4, "Ranging potion", Skill.HERBLORE, 72, 162.5, BankedItemOptionItems.DWARF_WEED),
	 *
	 *
	*/

	/**
	 * Construction
	 */
	TEAKS(ItemID.TEAK_PLANK, "Regular Teak Products", Skill.CONSTRUCTION, 1, 90, BankedItemOptionItems.TEAKS),
	MYTHCIAL_CAPE(ItemID.MYTHICAL_CAPE, "Mythical Cape Rakes", Skill.CONSTRUCTION, 1, 123.33, BankedItemOptionItems.TEAKS);


	@Getter
	private final int itemID;
	@Getter
	private final String name;
	@Getter
	private final Skill skill;
	@Getter
	private final int level;
	@Getter
	private final double basexp;
	@Getter
	private final int resourceID;
	@Getter
	private final BankedItemOptionItems itemOption;


	BankedItemOptions(int itemID, String name, Skill skill, int level, double xp, BankedItemOptionItems itemOption)
	{
		this.itemID = itemID;
		this.name = name;
		this.level = level;
		this.skill = skill;
		this.basexp = xp;
		this.itemOption = itemOption;
		this.resourceID = itemOption.getMainId();
	}

	// Return the different item categories for this skill
	private static final Map<Skill, ArrayList<BankedItemOptions>> bySkill = buildSkillMap();

	public static ArrayList<BankedItemOptions> getBySkill(Skill skill)
	{
		return bySkill.get(skill);
	}

	private static Map<Skill, ArrayList<BankedItemOptions>> buildSkillMap()
	{
		Map<Skill, ArrayList<BankedItemOptions>> map = new HashMap<>();
		for (BankedItemOptions item : values())
		{
			map.computeIfAbsent(item.getSkill(), e -> new ArrayList<BankedItemOptions>()).add(item);
		}

		return map;
	}


	public static Map<Integer, ArrayList<BankedItemOptions>> resourceSetMap(ArrayList<BankedItemOptions> array)
	{
		Map<Integer, ArrayList<BankedItemOptions>> map = new LinkedHashMap<>();
		array.forEach(e -> map.computeIfAbsent(e.getResourceID(), e2 -> new ArrayList<BankedItemOptions>()).add(e));
		return map;
	}
}
