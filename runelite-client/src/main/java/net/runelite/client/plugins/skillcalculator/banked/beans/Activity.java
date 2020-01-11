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
package net.runelite.client.plugins.skillcalculator.banked.beans;

import com.google.common.collect.ImmutableMultimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import net.runelite.client.game.ItemManager;

@Getter(AccessLevel.PUBLIC)
public enum Activity
{
	/**
	 * Herblore Activities
	 */
	// Creating Potions
	// Guam
	GUAM_POTION_UNF(ItemID.GUAM_POTION_UNF, "Unfinished Potion", Skill.HERBLORE, 1, 0,
		CriticalItem.GUAM_LEAF, Secondaries.UNFINISHED_POTION, new ItemStack(ItemID.GUAM_POTION_UNF, 1)),
	GUAM_TAR(ItemID.GUAM_TAR, "Guam tar", Skill.HERBLORE, 19, 30,
		CriticalItem.GUAM_LEAF, Secondaries.SWAMP_TAR, new ItemStack(ItemID.GUAM_TAR, 15)),

	ATTACK_POTION(ItemID.ATTACK_POTION3, "Attack potion", Skill.HERBLORE, 3, 25,
		CriticalItem.GUAM_LEAF_POTION_UNF, Secondaries.ATTACK_POTION, new ItemStack(ItemID.ATTACK_POTION3, 1)),
	// Marrentil
	MARRENTILL_POTION_UNF(ItemID.MARRENTILL_POTION_UNF, "Unfinished potion", Skill.HERBLORE, 1, 0,
		CriticalItem.MARRENTILL, Secondaries.UNFINISHED_POTION, new ItemStack(ItemID.MARRENTILL_POTION_UNF, 1)),
	MARRENTILL_TAR(ItemID.MARRENTILL_TAR, "Marrentill tar", Skill.HERBLORE, 31, 42.5,
		CriticalItem.MARRENTILL, Secondaries.SWAMP_TAR, new ItemStack(ItemID.MARRENTILL_TAR, 15)),

	ANTIPOISON(ItemID.ANTIPOISON3, "Antipoison", Skill.HERBLORE, 5, 37.5,
		CriticalItem.MARRENTILL_POTION_UNF, Secondaries.ANTIPOISON, new ItemStack(ItemID.ANTIPOISON3, 1)),
	// Tarromin
	TARROMIN_POTION_UNF(ItemID.TARROMIN_POTION_UNF, "Unfinished potion", Skill.HERBLORE, 1, 0,
		CriticalItem.TARROMIN, Secondaries.UNFINISHED_POTION, new ItemStack(ItemID.TARROMIN_POTION_UNF, 1)),
	TARROMIN_TAR(ItemID.TARROMIN_TAR, "Tarromin tar", Skill.HERBLORE, 39, 55,
		CriticalItem.TARROMIN, Secondaries.SWAMP_TAR, new ItemStack(ItemID.TARROMIN_TAR, 15)),

	STRENGTH_POTION(ItemID.STRENGTH_POTION3, "Strength potion", Skill.HERBLORE, 12, 50,
		CriticalItem.TARROMIN_POTION_UNF, Secondaries.STRENGTH_POTION, new ItemStack(ItemID.STRENGTH_POTION3, 1)),
	SERUM_207(ItemID.SERUM_207_3, "Serum 207", Skill.HERBLORE, 15, 50,
		CriticalItem.TARROMIN_POTION_UNF, Secondaries.SERUM_207, new ItemStack(ItemID.SERUM_207_3, 1)),
	// Harralander
	HARRALANDER_POTION_UNF(ItemID.HARRALANDER_POTION_UNF, "Unfinished potion", Skill.HERBLORE, 1, 0,
		CriticalItem.HARRALANDER, Secondaries.UNFINISHED_POTION, new ItemStack(ItemID.HARRALANDER_POTION_UNF, 1)),
	HARRALANDER_TAR(ItemID.HARRALANDER_TAR, "Harralander tar", Skill.HERBLORE, 44, 72.5,
		CriticalItem.HARRALANDER, Secondaries.SWAMP_TAR, new ItemStack(ItemID.HARRALANDER_TAR, 15)),

	COMPOST_POTION(ItemID.COMPOST_POTION3, "Compost potion", Skill.HERBLORE, 21, 60,
		CriticalItem.HARRALANDER_POTION_UNF, Secondaries.COMPOST_POTION, new ItemStack(ItemID.COMPOST_POTION3, 1)),
	RESTORE_POTION(ItemID.RESTORE_POTION3, "Restore potion", Skill.HERBLORE, 22, 62.5,
		CriticalItem.HARRALANDER_POTION_UNF, Secondaries.RESTORE_POTION, new ItemStack(ItemID.RESTORE_POTION3, 1)),
	ENERGY_POTION(ItemID.ENERGY_POTION3, "Energy potion", Skill.HERBLORE, 26, 67.5,
		CriticalItem.HARRALANDER_POTION_UNF, Secondaries.ENERGY_POTION, new ItemStack(ItemID.ENERGY_POTION3, 1)),
	COMBAT_POTION(ItemID.COMBAT_POTION3, "Combat potion", Skill.HERBLORE, 36, 84,
		CriticalItem.HARRALANDER_POTION_UNF, Secondaries.COMBAT_POTION, new ItemStack(ItemID.COMBAT_POTION3, 1)),
	// Ranarr Weed
	RANARR_POTION_UNF(ItemID.RANARR_POTION_UNF, "Unfinished potion", Skill.HERBLORE, 30, 0,
		CriticalItem.RANARR_WEED, Secondaries.UNFINISHED_POTION, new ItemStack(ItemID.RANARR_POTION_UNF, 1)),
	DEFENCE_POTION(ItemID.DEFENCE_POTION3, "Defence potion", Skill.HERBLORE, 30, 75,
		CriticalItem.RANARR_POTION_UNF, Secondaries.DEFENCE_POTION, new ItemStack(ItemID.DEFENCE_POTION3, 1)),
	PRAYER_POTION(ItemID.PRAYER_POTION3, "Prayer potion", Skill.HERBLORE, 38, 87.5,
		CriticalItem.RANARR_POTION_UNF, Secondaries.PRAYER_POTION, new ItemStack(ItemID.PRAYER_POTION3, 1)),
	// Toadflax
	TOADFLAX_POTION_UNF(ItemID.TOADFLAX_POTION_UNF, "Unfinished potion", Skill.HERBLORE, 34, 0,
		CriticalItem.TOADFLAX, Secondaries.UNFINISHED_POTION, new ItemStack(ItemID.TOADFLAX_POTION_UNF, 1)),
	AGILITY_POTION(ItemID.AGILITY_POTION3, "Agility potion", Skill.HERBLORE, 34, 80,
		CriticalItem.TOADFLAX_POTION_UNF, Secondaries.AGILITY_POTION, new ItemStack(ItemID.AGILITY_POTION3, 1)),
	SARADOMIN_BREW(ItemID.SARADOMIN_BREW3, "Saradomin brew", Skill.HERBLORE, 81, 180,
		CriticalItem.TOADFLAX_POTION_UNF, Secondaries.SARADOMIN_BREW, new ItemStack(ItemID.SARADOMIN_BREW3, 1)),
	// Irit
	IRIT_POTION_UNF(ItemID.IRIT_POTION_UNF, "Unfinished potion", Skill.HERBLORE, 45, 0,
		CriticalItem.IRIT_LEAF, Secondaries.UNFINISHED_POTION, new ItemStack(ItemID.IRIT_POTION_UNF, 1)),
	SUPER_ATTACK(ItemID.SUPER_ATTACK3, "Super attack", Skill.HERBLORE, 45, 100,
		CriticalItem.IRIT_POTION_UNF, Secondaries.SUPER_ATTACK, new ItemStack(ItemID.SUPER_ATTACK3, 1)),
	SUPERANTIPOISON(ItemID.SUPERANTIPOISON3, "Superantipoison", Skill.HERBLORE, 48, 106.3,
		CriticalItem.IRIT_POTION_UNF, Secondaries.SUPERANTIPOISON, new ItemStack(ItemID.SUPERANTIPOISON3, 1)),
	// Avantoe
	AVANTOE_POTION_UNF(ItemID.AVANTOE_POTION_UNF, "Unfinished potion", Skill.HERBLORE, 50, 0,
		CriticalItem.AVANTOE, Secondaries.UNFINISHED_POTION, new ItemStack(ItemID.AVANTOE_POTION_UNF, 1)),
	FISHING_POTION(ItemID.FISHING_POTION3, "Fishing potion", Skill.HERBLORE, 50, 112.5,
		CriticalItem.AVANTOE_POTION_UNF, Secondaries.FISHING_POTION, new ItemStack(ItemID.FISHING_POTION3, 1)),
	SUPER_ENERGY_POTION(ItemID.SUPER_ENERGY3_20549, "Super energy potion", Skill.HERBLORE, 52, 117.5,
		CriticalItem.AVANTOE_POTION_UNF, Secondaries.SUPER_ENERGY_POTION, new ItemStack(ItemID.SUPER_ENERGY3_20549, 1)),
	HUNTER_POTION(ItemID.HUNTER_POTION3, "Hunter potion", Skill.HERBLORE, 53, 120,
		CriticalItem.AVANTOE_POTION_UNF, Secondaries.HUNTER_POTION, new ItemStack(ItemID.HUNTER_POTION3, 1)),
	// Kwuarm
	KWUARM_POTION_UNF(ItemID.KWUARM_POTION_UNF, "Unfinished potion", Skill.HERBLORE, 55, 0,
		CriticalItem.KWUARM, Secondaries.UNFINISHED_POTION, new ItemStack(ItemID.KWUARM_POTION_UNF, 1)),
	SUPER_STRENGTH(ItemID.SUPER_STRENGTH3, "Super strength", Skill.HERBLORE, 55, 125,
		CriticalItem.KWUARM_POTION_UNF, Secondaries.SUPER_STRENGTH, new ItemStack(ItemID.SUPER_STRENGTH3, 1)),
	// Snapdragon
	SNAPDRAGON_POTION_UNF(ItemID.SNAPDRAGON_POTION_UNF, "Unfinished potion", Skill.HERBLORE, 63, 0,
		CriticalItem.SNAPDRAGON, Secondaries.UNFINISHED_POTION, new ItemStack(ItemID.SNAPDRAGON_POTION_UNF, 1)),
	SUPER_RESTORE(ItemID.SUPER_RESTORE3, "Super restore", Skill.HERBLORE, 63, 142.5,
		CriticalItem.SNAPDRAGON_POTION_UNF, Secondaries.SUPER_RESTORE, new ItemStack(ItemID.SUPER_RESTORE3, 1)),
	SANFEW_SERUM(ItemID.SANFEW_SERUM3, "Sanfew serum", Skill.HERBLORE, 65, 160,
		CriticalItem.SNAPDRAGON_POTION_UNF, Secondaries.SANFEW_SERUM, new ItemStack(ItemID.SANFEW_SERUM3, 1)),
	// Cadantine
	CADANTINE_POTION_UNF(ItemID.CADANTINE_POTION_UNF, "Unfinished potion", Skill.HERBLORE, 66, 0,
		CriticalItem.CADANTINE, Secondaries.UNFINISHED_POTION, new ItemStack(ItemID.CADANTINE_POTION_UNF, 1)),
	SUPER_DEFENCE_POTION(ItemID.SUPER_DEFENCE3, "Super defence", Skill.HERBLORE, 66, 150,
		CriticalItem.CADANTINE_POTION_UNF, Secondaries.SUPER_DEFENCE_POTION, new ItemStack(ItemID.SUPER_DEFENCE3, 1)),
	// Lantadyme
	LANTADYME_POTION_UNF(ItemID.LANTADYME_POTION_UNF, "Unfinished potion", Skill.HERBLORE, 69, 0,
		CriticalItem.LANTADYME, Secondaries.UNFINISHED_POTION, new ItemStack(ItemID.LANTADYME_POTION_UNF, 1)),
	ANTIFIRE_POTION(ItemID.ANTIFIRE_POTION3, "Anti-fire potion", Skill.HERBLORE, 69, 157.5,
		CriticalItem.LANTADYME_POTION_UNF, Secondaries.ANTIFIRE_POTION, new ItemStack(ItemID.ANTIFIRE_POTION3, 1)),
	MAGIC_POTION(ItemID.MAGIC_POTION3, "Magic potion", Skill.HERBLORE, 76, 172.5,
		CriticalItem.LANTADYME_POTION_UNF, Secondaries.MAGIC_POTION, new ItemStack(ItemID.MAGIC_POTION3, 1)),
	// Dwarf Weed
	DWARF_WEED_POTION_UNF(ItemID.DWARF_WEED_POTION_UNF, "Unfinished potion", Skill.HERBLORE, 72, 0,
		CriticalItem.DWARF_WEED, Secondaries.UNFINISHED_POTION, new ItemStack(ItemID.DWARF_WEED_POTION_UNF, 1)),
	RANGING_POTION(ItemID.RANGING_POTION3, "Ranging potion", Skill.HERBLORE, 72, 162.5,
		CriticalItem.DWARF_WEED_POTION_UNF, Secondaries.RANGING_POTION, new ItemStack(ItemID.RANGING_POTION3, 1)),
	// Torstol
	TORSTOL_POTION_UNF(ItemID.TORSTOL_POTION_UNF, "Unfinished potion", Skill.HERBLORE, 78, 0,
		CriticalItem.TORSTOL, Secondaries.UNFINISHED_POTION, new ItemStack(ItemID.TORSTOL_POTION_UNF, 1)),
	SUPER_COMBAT_POTION(ItemID.SUPER_COMBAT_POTION4, "Super combat", Skill.HERBLORE, 90, 150,
		CriticalItem.TORSTOL, Secondaries.SUPER_COMBAT_POTION, new ItemStack(ItemID.SUPER_COMBAT_POTION4, 1)),
	ANTIVENOM_PLUS(ItemID.ANTIVENOM3_12915, "Anti-venom+", Skill.HERBLORE, 94, 125,
		CriticalItem.TORSTOL, Secondaries.ANTIVENOM_PLUS, new ItemStack(ItemID.ANTIVENOM3_12915, 1)),

	ZAMORAK_BREW(ItemID.ZAMORAK_BREW3, "Zamorak brew", Skill.HERBLORE, 78, 175,
		CriticalItem.TORSTOL_POTION_UNF, Secondaries.ZAMORAK_BREW, new ItemStack(ItemID.ZAMORAK_BREW3, 1)),

	// Cleaning Grimy Herbs
	CLEAN_GUAM(ItemID.GUAM_LEAF, "Clean guam", Skill.HERBLORE, 3, 2.5,
		CriticalItem.GRIMY_GUAM_LEAF, null, new ItemStack(ItemID.GUAM_LEAF, 1)),
	CLEAN_MARRENTILL(ItemID.MARRENTILL, "Clean marrentill", Skill.HERBLORE, 5, 3.8,
		CriticalItem.GRIMY_MARRENTILL, null, new ItemStack(ItemID.MARRENTILL, 1)),
	CLEAN_TARROMIN(ItemID.TARROMIN, "Clean tarromin", Skill.HERBLORE, 11, 5,
		CriticalItem.GRIMY_TARROMIN, null, new ItemStack(ItemID.TARROMIN, 1)),
	CLEAN_HARRALANDER(ItemID.HARRALANDER, "Clean harralander", Skill.HERBLORE, 20, 6.3,
		CriticalItem.GRIMY_HARRALANDER, null, new ItemStack(ItemID.HARRALANDER, 1)),
	CLEAN_RANARR_WEED(ItemID.RANARR_WEED, "Clean ranarr weed", Skill.HERBLORE, 25, 7.5,
		CriticalItem.GRIMY_RANARR_WEED, null, new ItemStack(ItemID.RANARR_WEED, 1)),
	CLEAN_TOADFLAX(ItemID.TOADFLAX, "Clean toadflax", Skill.HERBLORE, 30, 8,
		CriticalItem.GRIMY_TOADFLAX, null, new ItemStack(ItemID.TOADFLAX, 1)),
	CLEAN_IRIT_LEAF(ItemID.IRIT_LEAF, "Clean irit leaf", Skill.HERBLORE, 40, 8.8,
		CriticalItem.GRIMY_IRIT_LEAF, null, new ItemStack(ItemID.IRIT_LEAF, 1)),
	CLEAN_AVANTOE(ItemID.AVANTOE, "Clean avantoe", Skill.HERBLORE, 48, 10,
		CriticalItem.GRIMY_AVANTOE, null, new ItemStack(ItemID.AVANTOE, 1)),
	CLEAN_KWUARM(ItemID.KWUARM, "Clean kwuarm", Skill.HERBLORE, 54, 11.3,
		CriticalItem.GRIMY_KWUARM, null, new ItemStack(ItemID.KWUARM, 1)),
	CLEAN_SNAPDRAGON(ItemID.SNAPDRAGON, "Clean snapdragon", Skill.HERBLORE, 59, 11.8,
		CriticalItem.GRIMY_SNAPDRAGON, null, new ItemStack(ItemID.SNAPDRAGON, 1)),
	CLEAN_CADANTINE(ItemID.CADANTINE, "Clean cadantine", Skill.HERBLORE, 65, 12.5,
		CriticalItem.GRIMY_CADANTINE, null, new ItemStack(ItemID.CADANTINE, 1)),
	CLEAN_LANTADYME(ItemID.LANTADYME, "Clean lantadyme", Skill.HERBLORE, 67, 13.1,
		CriticalItem.GRIMY_LANTADYME, null, new ItemStack(ItemID.LANTADYME, 1)),
	CLEAN_DWARF_WEED(ItemID.DWARF_WEED, "Clean dwarf weed", Skill.HERBLORE, 70, 13.8,
		CriticalItem.GRIMY_DWARF_WEED, null, new ItemStack(ItemID.DWARF_WEED, 1)),
	CLEAN_TORSTOL(ItemID.TORSTOL, "Clean torstol", Skill.HERBLORE, 75, 15,
		CriticalItem.GRIMY_TORSTOL, null, new ItemStack(ItemID.TORSTOL, 1)),

	/**
	 * Construction Options
	 */
	PLANK(ItemID.PLANK, "Regular Plank", Skill.CONSTRUCTION, 1, 0,
		CriticalItem.CON_LOGS, Secondaries.COINS_100, new ItemStack(ItemID.PLANK, 1)),
	PLANKS(ItemID.PLANK, "Regular plank products", Skill.CONSTRUCTION, 1, 29,
		CriticalItem.PLANK, null, null),
	OAK_PLANK(ItemID.OAK_PLANK, "Oak Plank", Skill.CONSTRUCTION, 1, 0,
		CriticalItem.CON_OAK_LOGS, Secondaries.COINS_250, new ItemStack(ItemID.OAK_PLANK, 1)),
	OAK_PLANKS(ItemID.OAK_PLANK, "Oak products", Skill.CONSTRUCTION, 1, 60,
		CriticalItem.OAK_PLANK, null, null),
	TEAK_PLANK(ItemID.TEAK_PLANK, "Teak Plank", Skill.CONSTRUCTION, 1, 0,
		CriticalItem.CON_TEAK_LOGS, Secondaries.COINS_500, new ItemStack(ItemID.TEAK_PLANK, 1)),
	TEAK_PLANKS(ItemID.TEAK_PLANK, "Teak products", Skill.CONSTRUCTION, 1, 90,
		CriticalItem.TEAK_PLANK, null, null),
	MYTHICAL_CAPE(ItemID.MYTHICAL_CAPE, "Mythical cape rakes", Skill.CONSTRUCTION, 1, 123.33,
		CriticalItem.TEAK_PLANK, null, null),
	MAHOGANY_PLANK(ItemID.MAHOGANY_PLANK, "Mahogany Plank", Skill.CONSTRUCTION, 1, 0,
		CriticalItem.CON_MAHOGANY_LOGS, Secondaries.COINS_1500, new ItemStack(ItemID.MAHOGANY_PLANK, 1)),
	MAHOGANY_PLANKS(ItemID.MAHOGANY_PLANK, "Mahogany products", Skill.CONSTRUCTION, 1, 140,
		CriticalItem.MAHOGANY_PLANK, null, null),

	/**
	 * Prayer Options
	 */
	BONES(ItemID.BONES, "Bones", Skill.PRAYER, 1, 4.5,
		CriticalItem.BONES, null, null),
	WOLF_BONES(ItemID.WOLF_BONES, "Wolf bones", Skill.PRAYER, 1, 4.5,
		CriticalItem.WOLF_BONES, null, null),
	BURNT_BONES(ItemID.BURNT_BONES, "Burnt bones", Skill.PRAYER, 1, 4.5,
		CriticalItem.BURNT_BONES, null, null),
	MONKEY_BONES(ItemID.MONKEY_BONES, "Monkey bones", Skill.PRAYER, 1, 5.0,
		CriticalItem.MONKEY_BONES, null, null),
	BAT_BONES(ItemID.BAT_BONES, "Bat bones", Skill.PRAYER, 1, 5.3,
		CriticalItem.BAT_BONES, null, null),
	JOGRE_BONES(ItemID.JOGRE_BONES, "Jogre bones", Skill.PRAYER, 1, 15.0,
		CriticalItem.JOGRE_BONES, null, null),
	BIG_BONES(ItemID.BIG_BONES, "Big bones", Skill.PRAYER, 1, 15.0,
		CriticalItem.BIG_BONES, null, null),
	ZOGRE_BONES(ItemID.ZOGRE_BONES, "Zogre bones", Skill.PRAYER, 1, 22.5,
		CriticalItem.ZOGRE_BONES, null, null),
	SHAIKAHAN_BONES(ItemID.SHAIKAHAN_BONES, "Shaikahan bones", Skill.PRAYER, 1, 25.0,
		CriticalItem.SHAIKAHAN_BONES, null, null),
	BABYDRAGON_BONES(ItemID.BABYDRAGON_BONES, "Babydragon bones", Skill.PRAYER, 1, 30.0,
		CriticalItem.BABYDRAGON_BONES, null, null),
	WYRM_BONES(ItemID.WYRM_BONES, "Wyrm bones", Skill.PRAYER, 1, 50,
		CriticalItem.WYRM_BONES, null, null),
	WYVERN_BONES(ItemID.WYVERN_BONES, "Wyvern bones", Skill.PRAYER, 1, 72.0,
		CriticalItem.WYVERN_BONES, null, null),
	DRAGON_BONES(ItemID.DRAGON_BONES, "Dragon bones", Skill.PRAYER, 1, 72.0,
		CriticalItem.DRAGON_BONES, null, null),
	DRAKE_BONES(ItemID.DRAKE_BONES, "Drake bones", Skill.PRAYER, 1, 80,
		CriticalItem.DRAKE_BONES, null, null),
	FAYRG_BONES(ItemID.FAYRG_BONES, "Fayrg bones", Skill.PRAYER, 1, 84.0,
		CriticalItem.FAYRG_BONES, null, null),
	LAVA_DRAGON_BONES(ItemID.LAVA_DRAGON_BONES, "Lava dragon bones", Skill.PRAYER, 1, 85.0,
		CriticalItem.LAVA_DRAGON_BONES, null, null),
	RAURG_BONES(ItemID.RAURG_BONES, "Raurg bones", Skill.PRAYER, 1, 96.0,
		CriticalItem.RAURG_BONES, null, null),
	HYDRA_BONES(ItemID.HYDRA_BONES, "Hydra bones", Skill.PRAYER, 1, 110,
		CriticalItem.HYDRA_BONES, null, null),
	DAGANNOTH_BONES(ItemID.DAGANNOTH_BONES, "Dagannoth bones", Skill.PRAYER, 1, 125.0,
		CriticalItem.DAGANNOTH_BONES, null, null),
	OURG_BONES(ItemID.OURG_BONES, "Ourg bones", Skill.PRAYER, 1, 140.0,
		CriticalItem.OURG_BONES, null, null),
	SUPERIOR_DRAGON_BONES(ItemID.SUPERIOR_DRAGON_BONES, "Superior dragon bones", Skill.PRAYER, 1, 150.0,
		CriticalItem.SUPERIOR_DRAGON_BONES, null, null),
	// Shade Remains (Pyre Logs)
	LOAR_REMAINS(ItemID.LOAR_REMAINS, "Loar remains", Skill.PRAYER, 1, 33.0,
		CriticalItem.LOAR_REMAINS, null, null),
	PHRIN_REMAINS(ItemID.PHRIN_REMAINS, "Phrin remains", Skill.PRAYER, 1, 46.5,
		CriticalItem.PHRIN_REMAINS, null, null),
	RIYL_REMAINS(ItemID.RIYL_REMAINS, "Riyl remains", Skill.PRAYER, 1, 59.5,
		CriticalItem.RIYL_REMAINS, null, null),
	ASYN_REMAINS(ItemID.ASYN_REMAINS, "Asyn remains", Skill.PRAYER, 1, 82.5,
		CriticalItem.ASYN_REMAINS, null, null),
	FIYR_REMAINS(ItemID.FIYR_REMAINS, "Fiyre remains", Skill.PRAYER, 1, 84.0,
		CriticalItem.FIYR_REMAINS, null, null),
	// Ensouled Heads
	ENSOULED_GOBLIN_HEAD(ItemID.ENSOULED_GOBLIN_HEAD_13448, "Ensouled goblin head", Skill.PRAYER, 1, 130.0,
		CriticalItem.ENSOULED_GOBLIN_HEAD, null, null),
	ENSOULED_MONKEY_HEAD(ItemID.ENSOULED_MONKEY_HEAD_13451, "Ensouled monkey head", Skill.PRAYER, 1, 182.0,
		CriticalItem.ENSOULED_MONKEY_HEAD, null, null),
	ENSOULED_IMP_HEAD(ItemID.ENSOULED_IMP_HEAD_13454, "Ensouled imp head", Skill.PRAYER, 1, 286.0,
		CriticalItem.ENSOULED_IMP_HEAD, null, null),
	ENSOULED_MINOTAUR_HEAD(ItemID.ENSOULED_MINOTAUR_HEAD_13457, "Ensouled minotaur head", Skill.PRAYER, 1, 364.0,
		CriticalItem.ENSOULED_MINOTAUR_HEAD, null, null),
	ENSOULED_SCORPION_HEAD(ItemID.ENSOULED_SCORPION_HEAD_13460, "Ensouled scorpion head", Skill.PRAYER, 1, 454.0,
		CriticalItem.ENSOULED_SCORPION_HEAD, null, null),
	ENSOULED_BEAR_HEAD(ItemID.ENSOULED_BEAR_HEAD_13463, "Ensouled bear head", Skill.PRAYER, 1, 480.0,
		CriticalItem.ENSOULED_BEAR_HEAD, null, null),
	ENSOULED_UNICORN_HEAD(ItemID.ENSOULED_UNICORN_HEAD_13466, "Ensouled unicorn head", Skill.PRAYER, 1, 494.0,
		CriticalItem.ENSOULED_UNICORN_HEAD, null, null),
	ENSOULED_DOG_HEAD(ItemID.ENSOULED_DOG_HEAD_13469, "Ensouled dog head", Skill.PRAYER, 1, 520.0,
		CriticalItem.ENSOULED_DOG_HEAD, null, null),
	ENSOULED_CHAOS_DRUID_HEAD(ItemID.ENSOULED_CHAOS_DRUID_HEAD_13472, "Ensouled druid head", Skill.PRAYER, 1, 584.0,
		CriticalItem.ENSOULED_CHAOS_DRUID_HEAD, null, null),
	ENSOULED_GIANT_HEAD(ItemID.ENSOULED_GIANT_HEAD_13475, "Ensouled giant head", Skill.PRAYER, 1, 650.0,
		CriticalItem.ENSOULED_GIANT_HEAD, null, null),
	ENSOULED_OGRE_HEAD(ItemID.ENSOULED_OGRE_HEAD_13478, "Ensouled ogre head", Skill.PRAYER, 1, 716.0,
		CriticalItem.ENSOULED_OGRE_HEAD, null, null),
	ENSOULED_ELF_HEAD(ItemID.ENSOULED_ELF_HEAD_13481, "Ensouled elf head", Skill.PRAYER, 1, 754.0,
		CriticalItem.ENSOULED_ELF_HEAD, null, null),
	ENSOULED_TROLL_HEAD(ItemID.ENSOULED_TROLL_HEAD_13484, "Ensouled troll head", Skill.PRAYER, 1, 780.0,
		CriticalItem.ENSOULED_TROLL_HEAD, null, null),
	ENSOULED_HORROR_HEAD(ItemID.ENSOULED_HORROR_HEAD_13487, "Ensouled horror head", Skill.PRAYER, 1, 832.0,
		CriticalItem.ENSOULED_HORROR_HEAD, null, null),
	ENSOULED_KALPHITE_HEAD(ItemID.ENSOULED_KALPHITE_HEAD_13490, "Ensouled kalphite head", Skill.PRAYER, 1, 884.0,
		CriticalItem.ENSOULED_KALPHITE_HEAD, null, null),
	ENSOULED_DAGANNOTH_HEAD(ItemID.ENSOULED_DAGANNOTH_HEAD_13493, "Ensouled dagannoth head", Skill.PRAYER, 1, 936.0,
		CriticalItem.ENSOULED_DAGANNOTH_HEAD, null, null),
	ENSOULED_BLOODVELD_HEAD(ItemID.ENSOULED_BLOODVELD_HEAD_13496, "Ensouled bloodveld head", Skill.PRAYER, 1, 1040.0,
		CriticalItem.ENSOULED_BLOODVELD_HEAD, null, null),
	ENSOULED_TZHAAR_HEAD(ItemID.ENSOULED_TZHAAR_HEAD_13499, "Ensouled tzhaar head", Skill.PRAYER, 1, 1104.0,
		CriticalItem.ENSOULED_TZHAAR_HEAD, null, null),
	ENSOULED_DEMON_HEAD(ItemID.ENSOULED_DEMON_HEAD_13502, "Ensouled demon head", Skill.PRAYER, 1, 1170.0,
		CriticalItem.ENSOULED_DEMON_HEAD, null, null),
	ENSOULED_AVIANSIE_HEAD(ItemID.ENSOULED_AVIANSIE_HEAD_13505, "Ensouled aviansie head", Skill.PRAYER, 1, 1234.0,
		CriticalItem.ENSOULED_AVIANSIE_HEAD, null, null),
	ENSOULED_ABYSSAL_HEAD(ItemID.ENSOULED_ABYSSAL_HEAD_13508, "Ensouled abyssal head", Skill.PRAYER, 1, 1300.0,
		CriticalItem.ENSOULED_ABYSSAL_HEAD, null, null),
	ENSOULED_DRAGON_HEAD(ItemID.ENSOULED_DRAGON_HEAD_13511, "Ensouled dragon head", Skill.PRAYER, 1, 1560.0,
		CriticalItem.ENSOULED_DRAGON_HEAD, null, null),

	/*
	 * Cooking Items
	 */
	COOK_HERRING(ItemID.HERRING, "Herring", Skill.COOKING, 5, 50.0,
		CriticalItem.RAW_HERRING, null, new ItemStack(ItemID.HERRING, 1)),
	COOK_MACKEREL(ItemID.MACKEREL, "Mackerel", Skill.COOKING, 10, 60.0,
		CriticalItem.RAW_MACKEREL, null, new ItemStack(ItemID.MACKEREL, 1)),
	COOK_TROUT(ItemID.TROUT, "Trout", Skill.COOKING, 15, 70.0,
		CriticalItem.RAW_TROUT, null, new ItemStack(ItemID.TROUT, 1)),
	COOK_COD(ItemID.COD, "Cod", Skill.COOKING, 18, 75.0,
		CriticalItem.RAW_COD, null, new ItemStack(ItemID.COD, 1)),
	COOK_PIKE(ItemID.PIKE, "Pike", Skill.COOKING, 20, 80.0,
		CriticalItem.RAW_PIKE, null, new ItemStack(ItemID.PIKE, 1)),
	COOK_SALMON(ItemID.SALMON, "Salmon", Skill.COOKING, 25, 90.0,
		CriticalItem.RAW_SALMON, null, new ItemStack(ItemID.SALMON, 1)),
	COOK_TUNA(ItemID.TUNA, "Tuna", Skill.COOKING, 30, 100.0,
		CriticalItem.RAW_TUNA, null, new ItemStack(ItemID.TUNA, 1)),
	COOK_KARAMBWAN(ItemID.COOKED_KARAMBWAN, "Cooked Karambwan", Skill.COOKING, 30, 190.0,
		CriticalItem.RAW_KARAMBWAN, null, new ItemStack(ItemID.COOKED_KARAMBWAN, 1)),
	COOK_LOBSTER(ItemID.LOBSTER, "Lobster", Skill.COOKING, 40, 120.0,
		CriticalItem.RAW_LOBSTER, null, new ItemStack(ItemID.LOBSTER, 1)),
	COOK_BASS(ItemID.BASS, "Bass", Skill.COOKING, 43, 130.0,
		CriticalItem.RAW_BASS, null, new ItemStack(ItemID.BASS, 1)),
	COOK_SWORDFISH(ItemID.SWORDFISH, "Swordfish", Skill.COOKING, 45, 140.0,
		CriticalItem.RAW_SWORDFISH, null, new ItemStack(ItemID.SWORDFISH, 1)),
	COOK_MONKFISH(ItemID.MONKFISH, "Monkfish", Skill.COOKING, 62, 150.0,
		CriticalItem.RAW_MONKFISH, null, new ItemStack(ItemID.MONKFISH, 1)),
	COOK_SHARK(ItemID.SHARK, "Shark", Skill.COOKING, 80, 210.0,
		CriticalItem.RAW_SHARK, null, new ItemStack(ItemID.SHARK, 1)),
	COOK_SEA_TURTLE(ItemID.SEA_TURTLE, "Sea turtle", Skill.COOKING, 82, 211.3,
		CriticalItem.RAW_SEA_TURTLE, null, new ItemStack(ItemID.SEA_TURTLE, 1)),
	COOK_ANGLERFISH(ItemID.ANGLERFISH, "Anglerfish", Skill.COOKING, 84, 230.0,
		CriticalItem.RAW_ANGLERFISH, null, new ItemStack(ItemID.ANGLERFISH, 1)),
	COOK_DARK_CRAB(ItemID.DARK_CRAB, "Dark crab", Skill.COOKING, 90, 215.0,
		CriticalItem.RAW_DARK_CRAB, null, new ItemStack(ItemID.DARK_CRAB, 1)),
	COOK_MANTA_RAY(ItemID.MANTA_RAY, "Manta ray", Skill.COOKING, 91, 216.2,
		CriticalItem.RAW_MANTA_RAY, null, new ItemStack(ItemID.MANTA_RAY, 1)),
	WINE(ItemID.JUG_OF_WINE, "Jug of wine", Skill.COOKING, 35, 200,
		CriticalItem.GRAPES, Secondaries.JUG_OF_WATER, new ItemStack(ItemID.JUG_OF_WINE, 1)),

	/*
	 * Crafting Items
	 */
	// Spinning
	BALL_OF_WOOL(ItemID.BALL_OF_WOOL, "Ball of wool", Skill.CRAFTING, 1, 2.5,
		CriticalItem.WOOL, null, new ItemStack(ItemID.BALL_OF_WOOL, 1)),
	BOW_STRING(ItemID.BOW_STRING, "Bow string", Skill.CRAFTING, 1, 15,
		CriticalItem.FLAX, null, new ItemStack(ItemID.BOW_STRING, 1)),
	// Glass Blowing
	BEER_GLASS(ItemID.BEER_GLASS, "Beer glass", Skill.CRAFTING, 1, 17.5,
		CriticalItem.MOLTEN_GLASS, null, new ItemStack(ItemID.BEER_GLASS, 1)),
	CANDLE_LANTERN(ItemID.CANDLE_LANTERN, "Candle lantern", Skill.CRAFTING, 4, 19,
		CriticalItem.MOLTEN_GLASS, null, new ItemStack(ItemID.CANDLE_LANTERN, 1)),
	OIL_LAMP(ItemID.OIL_LAMP, "Oil lamp", Skill.CRAFTING, 12, 25,
		CriticalItem.MOLTEN_GLASS, null, new ItemStack(ItemID.OIL_LAMP, 1)),
	VIAL(ItemID.VIAL, "Vial", Skill.CRAFTING, 33, 35,
		CriticalItem.MOLTEN_GLASS, null, new ItemStack(ItemID.VIAL, 1)),
	EMPTY_FISHBOWL(ItemID.EMPTY_FISHBOWL, "Empty fishbowl", Skill.CRAFTING, 42, 42.5,
		CriticalItem.MOLTEN_GLASS, null, new ItemStack(ItemID.EMPTY_FISHBOWL, 1)),
	UNPOWERED_ORB(ItemID.UNPOWERED_ORB, "Unpowered orb", Skill.CRAFTING, 46, 52.5,
		CriticalItem.MOLTEN_GLASS, null, new ItemStack(ItemID.UNPOWERED_ORB, 1)),
	LANTERN_LENS(ItemID.LANTERN_LENS, "Lantern lens", Skill.CRAFTING, 49, 55,
		CriticalItem.MOLTEN_GLASS, null, new ItemStack(ItemID.LANTERN_LENS, 1)),
	LIGHT_ORB(ItemID.LIGHT_ORB, "Light orb", Skill.CRAFTING, 87, 70,
		CriticalItem.MOLTEN_GLASS, null, new ItemStack(ItemID.LIGHT_ORB, 1)),

	// D'hide/Dragon Leather
	GREEN_DRAGONHIDE(ItemID.GREEN_DRAGON_LEATHER, "Tan Green D'hide", Skill.CRAFTING, 57, 0,
		CriticalItem.GREEN_DRAGONHIDE, null, new ItemStack(ItemID.GREEN_DRAGON_LEATHER, 1)),
	BLUE_DRAGONHIDE(ItemID.BLUE_DRAGON_LEATHER, "Tan Blue D'hide", Skill.CRAFTING, 66, 0,
		CriticalItem.BLUE_DRAGONHIDE, null, new ItemStack(ItemID.BLUE_DRAGON_LEATHER, 1)),
	RED_DRAGONHIDE(ItemID.RED_DRAGON_LEATHER, "Tan Red D'hide", Skill.CRAFTING, 73, 0,
		CriticalItem.RED_DRAGONHIDE, null, new ItemStack(ItemID.RED_DRAGON_LEATHER, 1)),
	BLACK_DRAGONHIDE(ItemID.BLACK_DRAGON_LEATHER, "Tan Black D'hide", Skill.CRAFTING, 79, 0,
		CriticalItem.BLACK_DRAGONHIDE, null, new ItemStack(ItemID.BLACK_DRAGON_LEATHER, 1)),

	GREEN_DRAGON_LEATHER(ItemID.GREEN_DHIDE_VAMB, "Green D'hide product", Skill.CRAFTING, 57, 62.0,
		CriticalItem.GREEN_DRAGON_LEATHER, null, null),
	BLUE_DRAGON_LEATHER(ItemID.BLUE_DHIDE_VAMB, "Blue D'hide product", Skill.CRAFTING, 66, 70.0,
		CriticalItem.BLUE_DRAGON_LEATHER, null, null),
	RED_DRAGON_LEATHER(ItemID.RED_DHIDE_VAMB, "Red D'hide product", Skill.CRAFTING, 73, 78.0,
		CriticalItem.RED_DRAGON_LEATHER, null, null),
	BLACK_DRAGON_LEATHER(ItemID.BLACK_DHIDE_VAMB, "Black D'hide product", Skill.CRAFTING, 79, 86.0,
		CriticalItem.BLACK_DRAGON_LEATHER, null, null),

	// Uncut Gems
	UNCUT_OPAL(ItemID.OPAL, "Cut opal", Skill.CRAFTING, 1, 15.0,
		CriticalItem.UNCUT_OPAL, null, new ItemStack(ItemID.OPAL, 1)),
	UNCUT_JADE(ItemID.JADE, "Cut jade", Skill.CRAFTING, 13, 20.0,
		CriticalItem.UNCUT_JADE, null, new ItemStack(ItemID.JADE, 1)),
	UNCUT_RED_TOPAZ(ItemID.RED_TOPAZ, "Cut red topaz", Skill.CRAFTING, 16, 25.0,
		CriticalItem.UNCUT_RED_TOPAZ, null, new ItemStack(ItemID.RED_TOPAZ, 1)),
	UNCUT_SAPPHIRE(ItemID.SAPPHIRE, "Cut sapphire", Skill.CRAFTING, 20, 50.0,
		CriticalItem.UNCUT_SAPPHIRE, null, new ItemStack(ItemID.SAPPHIRE, 1)),
	UNCUT_EMERALD(ItemID.EMERALD, "Cut emerald", Skill.CRAFTING, 27, 67.5,
		CriticalItem.UNCUT_EMERALD, null, new ItemStack(ItemID.EMERALD, 1)),
	UNCUT_RUBY(ItemID.RUBY, "Cut ruby", Skill.CRAFTING, 34, 85,
		CriticalItem.UNCUT_RUBY, null, new ItemStack(ItemID.RUBY, 1)),
	UNCUT_DIAMOND(ItemID.DIAMOND, "Cut diamond", Skill.CRAFTING, 43, 107.5,
		CriticalItem.UNCUT_DIAMOND, null, new ItemStack(ItemID.DIAMOND, 1)),
	UNCUT_DRAGONSTONE(ItemID.DRAGONSTONE, "Cut dragonstone", Skill.CRAFTING, 55, 137.5,
		CriticalItem.UNCUT_DRAGONSTONE, null, new ItemStack(ItemID.DRAGONSTONE, 1)),
	UNCUT_ONYX(ItemID.ONYX, "Cut onyx", Skill.CRAFTING, 67, 167.5,
		CriticalItem.UNCUT_ONYX, null, new ItemStack(ItemID.ONYX, 1)),
	UNCUT_ZENYTE(ItemID.ZENYTE, "Cut zenyte", Skill.CRAFTING, 89, 200.0,
		CriticalItem.UNCUT_ZENYTE, null, new ItemStack(ItemID.ZENYTE, 1)),
	// Silver Jewelery
	OPAL_RING(ItemID.OPAL_RING, "Opal ring", Skill.CRAFTING, 1, 10,
		CriticalItem.OPAL, Secondaries.SILVER_BAR, new ItemStack(ItemID.OPAL_RING, 1)),
	OPAL_NECKLACE(ItemID.OPAL_NECKLACE, "Opal necklace", Skill.CRAFTING, 16, 35,
		CriticalItem.OPAL, Secondaries.SILVER_BAR, new ItemStack(ItemID.OPAL_NECKLACE, 1)),
	OPAL_BRACELET(ItemID.OPAL_BRACELET, "Opal bracelet", Skill.CRAFTING, 22, 45,
		CriticalItem.OPAL, Secondaries.SILVER_BAR, new ItemStack(ItemID.OPAL_BRACELET, 1)),
	OPAL_AMULET(ItemID.OPAL_AMULET, "Opal amulet", Skill.CRAFTING, 27, 55,
		CriticalItem.OPAL, Secondaries.SILVER_BAR, new ItemStack(ItemID.OPAL_AMULET, 1)),
	JADE_RING(ItemID.JADE_RING, "Jade ring", Skill.CRAFTING, 13, 32,
		CriticalItem.JADE, Secondaries.SILVER_BAR, new ItemStack(ItemID.JADE_RING, 1)),
	JADE_NECKLACE(ItemID.JADE_NECKLACE, "Jade necklace", Skill.CRAFTING, 25, 54,
		CriticalItem.JADE, Secondaries.SILVER_BAR, new ItemStack(ItemID.JADE_NECKLACE, 1)),
	JADE_BRACELET(ItemID.JADE_BRACELET, "Jade bracelet", Skill.CRAFTING, 29, 60,
		CriticalItem.JADE, Secondaries.SILVER_BAR, new ItemStack(ItemID.JADE_BRACELET, 1)),
	JADE_AMULET(ItemID.JADE_AMULET, "Jade amulet", Skill.CRAFTING, 34, 70,
		CriticalItem.JADE, Secondaries.SILVER_BAR, new ItemStack(ItemID.JADE_AMULET, 1)),
	TOPAZ_RING(ItemID.TOPAZ_RING, "Topaz ring", Skill.CRAFTING, 16, 35,
		CriticalItem.RED_TOPAZ, Secondaries.SILVER_BAR, new ItemStack(ItemID.TOPAZ_RING, 1)),
	TOPAZ_NECKLACE(ItemID.TOPAZ_NECKLACE, "Topaz necklace", Skill.CRAFTING, 32, 70,
		CriticalItem.RED_TOPAZ, Secondaries.SILVER_BAR, new ItemStack(ItemID.TOPAZ_NECKLACE, 1)),
	TOPAZ_BRACELET(ItemID.TOPAZ_BRACELET, "Topaz bracelet", Skill.CRAFTING, 38, 75,
		CriticalItem.RED_TOPAZ, Secondaries.SILVER_BAR, new ItemStack(ItemID.TOPAZ_BRACELET, 1)),
	TOPAZ_AMULET(ItemID.TOPAZ_AMULET, "Topaz amulet", Skill.CRAFTING, 45, 80,
		CriticalItem.RED_TOPAZ, Secondaries.SILVER_BAR, new ItemStack(ItemID.TOPAZ_AMULET, 1)),
	// Gold Jewelery
	SAPPHIRE_RING(ItemID.SAPPHIRE_RING, "Sapphire ring", Skill.CRAFTING, 20, 40,
		CriticalItem.SAPPHIRE, Secondaries.GOLD_BAR, new ItemStack(ItemID.SAPPHIRE_RING, 1)),
	SAPPHIRE_NECKLACE(ItemID.SAPPHIRE_NECKLACE, "Sapphire necklace", Skill.CRAFTING, 22, 55,
		CriticalItem.SAPPHIRE, Secondaries.GOLD_BAR, new ItemStack(ItemID.SAPPHIRE_NECKLACE, 1)),
	SAPPHIRE_BRACELET(ItemID.SAPPHIRE_BRACELET, "Sapphire bracelet", Skill.CRAFTING, 23, 60,
		CriticalItem.SAPPHIRE, Secondaries.GOLD_BAR, new ItemStack(ItemID.SAPPHIRE_BRACELET, 1)),
	SAPPHIRE_AMULET(ItemID.SAPPHIRE_AMULET, "Sapphire amulet", Skill.CRAFTING, 24, 65,
		CriticalItem.SAPPHIRE, Secondaries.GOLD_BAR, new ItemStack(ItemID.SAPPHIRE_AMULET, 1)),
	EMERALD_RING(ItemID.EMERALD_RING, "Emerald ring", Skill.CRAFTING, 27, 55,
		CriticalItem.EMERALD, Secondaries.GOLD_BAR, new ItemStack(ItemID.EMERALD_RING, 1)),
	EMERALD_NECKLACE(ItemID.EMERALD_NECKLACE, "Emerald necklace", Skill.CRAFTING, 29, 60,
		CriticalItem.EMERALD, Secondaries.GOLD_BAR, new ItemStack(ItemID.EMERALD_NECKLACE, 1)),
	EMERALD_BRACELET(ItemID.EMERALD_BRACELET, "Emerald bracelet", Skill.CRAFTING, 30, 65,
		CriticalItem.EMERALD, Secondaries.GOLD_BAR, new ItemStack(ItemID.EMERALD_BRACELET, 1)),
	EMERALD_AMULET(ItemID.EMERALD_AMULET, "Emerald amulet", Skill.CRAFTING, 31, 70,
		CriticalItem.EMERALD, Secondaries.GOLD_BAR, new ItemStack(ItemID.EMERALD_AMULET, 1)),
	RUBY_RING(ItemID.RUBY_RING, "Ruby ring", Skill.CRAFTING, 34, 70,
		CriticalItem.RUBY, Secondaries.GOLD_BAR, new ItemStack(ItemID.RUBY_RING, 1)),
	RUBY_NECKLACE(ItemID.RUBY_NECKLACE, "Ruby necklace", Skill.CRAFTING, 40, 75,
		CriticalItem.RUBY, Secondaries.GOLD_BAR, new ItemStack(ItemID.RUBY_NECKLACE, 1)),
	RUBY_BRACELET(ItemID.RUBY_BRACELET, "Ruby bracelet", Skill.CRAFTING, 42, 80,
		CriticalItem.RUBY, Secondaries.GOLD_BAR, new ItemStack(ItemID.RUBY_BRACELET, 1)),
	RUBY_AMULET(ItemID.RUBY_AMULET, "Ruby amulet", Skill.CRAFTING, 50, 85,
		CriticalItem.RUBY, Secondaries.GOLD_BAR, new ItemStack(ItemID.RUBY_AMULET, 1)),
	DIAMOND_RING(ItemID.DIAMOND_RING, "Diamond ring", Skill.CRAFTING, 43, 85,
		CriticalItem.DIAMOND, Secondaries.GOLD_BAR, new ItemStack(ItemID.DIAMOND_RING, 1)),
	DIAMOND_NECKLACE(ItemID.DIAMOND_NECKLACE, "Diamond necklace", Skill.CRAFTING, 56, 90,
		CriticalItem.DIAMOND, Secondaries.GOLD_BAR, new ItemStack(ItemID.DIAMOND_NECKLACE, 1)),
	DIAMOND_BRACELET(ItemID.DIAMOND_BRACELET, "Diamond bracelet", Skill.CRAFTING, 58, 95,
		CriticalItem.DIAMOND, Secondaries.GOLD_BAR, new ItemStack(ItemID.DIAMOND_BRACELET, 1)),
	DIAMOND_AMULET(ItemID.DIAMOND_AMULET, "Diamond amulet", Skill.CRAFTING, 70, 100,
		CriticalItem.DIAMOND, Secondaries.GOLD_BAR, new ItemStack(ItemID.DIAMOND_AMULET, 1)),
	DRAGONSTONE_RING(ItemID.DRAGONSTONE_RING, "Dragonstone ring", Skill.CRAFTING, 55, 100,
		CriticalItem.DRAGONSTONE, Secondaries.GOLD_BAR, new ItemStack(ItemID.DRAGONSTONE_RING, 1)),
	DRAGON_NECKLACE(ItemID.DRAGON_NECKLACE, "Dragon necklace", Skill.CRAFTING, 72, 105,
		CriticalItem.DRAGONSTONE, Secondaries.GOLD_BAR, new ItemStack(ItemID.DRAGON_NECKLACE, 1)),
	DRAGONSTONE_BRACELET(ItemID.DRAGONSTONE_BRACELET, "Dragonstone bracelet", Skill.CRAFTING, 74, 110,
		CriticalItem.DRAGONSTONE, Secondaries.GOLD_BAR, new ItemStack(ItemID.DRAGONSTONE_BRACELET, 1)),
	DRAGONSTONE_AMULET(ItemID.DRAGONSTONE_AMULET, "Dragonstone amulet", Skill.CRAFTING, 80, 150,
		CriticalItem.DRAGONSTONE, Secondaries.GOLD_BAR, new ItemStack(ItemID.DRAGONSTONE_AMULET, 1)),
	ONYX_RING(ItemID.ONYX_RING, "Onyx ring", Skill.CRAFTING, 67, 115,
		CriticalItem.ONYX, Secondaries.GOLD_BAR, new ItemStack(ItemID.ONYX_RING, 1)),
	ONYX_NECKLACE(ItemID.ONYX_NECKLACE, "Onyx necklace", Skill.CRAFTING, 82, 120,
		CriticalItem.ONYX, Secondaries.GOLD_BAR, new ItemStack(ItemID.ONYX_NECKLACE, 1)),
	REGEN_BRACELET(ItemID.REGEN_BRACELET, "Regen bracelet", Skill.CRAFTING, 84, 125,
		CriticalItem.ONYX, Secondaries.GOLD_BAR, new ItemStack(ItemID.REGEN_BRACELET, 1)),
	ONYX_AMULET(ItemID.ONYX_AMULET, "Onyx amulet", Skill.CRAFTING, 90, 165,
		CriticalItem.ONYX, Secondaries.GOLD_BAR, new ItemStack(ItemID.ONYX_AMULET, 1)),
	ZENYTE_RING(ItemID.ZENYTE_RING, "Zenyte ring", Skill.CRAFTING, 89, 150,
		CriticalItem.ZENYTE, Secondaries.GOLD_BAR, new ItemStack(ItemID.ZENYTE_RING, 1)),
	ZENYTE_NECKLACE(ItemID.ZENYTE_NECKLACE, "Zenyte necklace", Skill.CRAFTING, 92, 165,
		CriticalItem.ZENYTE, Secondaries.GOLD_BAR, new ItemStack(ItemID.ZENYTE_NECKLACE, 1)),
	ZENYTE_BRACELET(ItemID.ZENYTE_BRACELET, "Zenyte bracelet", Skill.CRAFTING, 95, 180,
		CriticalItem.ZENYTE, Secondaries.GOLD_BAR, new ItemStack(ItemID.ZENYTE_BRACELET, 1)),
	ZENYTE_AMULET(ItemID.ZENYTE_AMULET, "Zenyte amulet", Skill.CRAFTING, 98, 200,
		CriticalItem.ZENYTE, Secondaries.GOLD_BAR, new ItemStack(ItemID.ZENYTE_AMULET, 1)),
	// Battle Staves
	WATER_BATTLESTAFF(ItemID.WATER_BATTLESTAFF, "Water battlestaff", Skill.CRAFTING, 54, 100,
		CriticalItem.BATTLESTAFF, Secondaries.WATER_ORB, new ItemStack(ItemID.WATER_BATTLESTAFF, 1)),
	EARTH_BATTLESTAFF(ItemID.EARTH_BATTLESTAFF, "Earth battlestaff", Skill.CRAFTING, 58, 112.5,
		CriticalItem.BATTLESTAFF, Secondaries.EARTH_ORB, new ItemStack(ItemID.EARTH_BATTLESTAFF, 1)),
	FIRE_BATTLESTAFF(ItemID.FIRE_BATTLESTAFF, "Fire battlestaff", Skill.CRAFTING, 62, 125,
		CriticalItem.BATTLESTAFF, Secondaries.FIRE_ORB, new ItemStack(ItemID.FIRE_BATTLESTAFF, 1)),
	AIR_BATTLESTAFF(ItemID.AIR_BATTLESTAFF, "Air battlestaff", Skill.CRAFTING, 66, 137.5,
		CriticalItem.BATTLESTAFF, Secondaries.AIR_ORB, new ItemStack(ItemID.AIR_BATTLESTAFF, 1)),

	/*
	 * Smithing Items
	 */

	// Smelting ores (Furnace)
	IRON_ORE(ItemID.IRON_BAR, "Iron bar", Skill.SMITHING, 15, 12.5,
		CriticalItem.IRON_ORE, Secondaries.COAL_ORE, new ItemStack(ItemID.IRON_BAR, 1)),
	STEEL_ORE(ItemID.STEEL_BAR, "Steel bar", Skill.SMITHING, 30, 17.5,
		CriticalItem.IRON_ORE, Secondaries.COAL_ORE_2, new ItemStack(ItemID.STEEL_BAR, 1)),
	SILVER_ORE(ItemID.SILVER_BAR, "Silver Bar", Skill.SMITHING, 20, 13.67,
		CriticalItem.SILVER_ORE, null, new ItemStack(ItemID.SILVER_BAR, 1)),
	GOLD_ORE(ItemID.GOLD_BAR, "Gold bar", Skill.SMITHING, 40, 22.5,
		CriticalItem.GOLD_ORE, null, new ItemStack(ItemID.GOLD_BAR, 1)),
	GOLD_ORE_GAUNTLETS(ItemID.GOLDSMITH_GAUNTLETS, "Goldsmith gauntlets", Skill.SMITHING, 40, 56.2,
		CriticalItem.GOLD_ORE, null, new ItemStack(ItemID.GOLD_BAR, 1)),
	MITHRIL_ORE(ItemID.MITHRIL_BAR, "Mithril bar", Skill.SMITHING, 50, 30,
		CriticalItem.MITHRIL_ORE, Secondaries.COAL_ORE_4, new ItemStack(ItemID.MITHRIL_BAR, 1)),
	ADAMANTITE_ORE(ItemID.ADAMANTITE_BAR, "Adamantite bar", Skill.SMITHING, 70, 37.5,
		CriticalItem.ADAMANTITE_ORE, Secondaries.COAL_ORE_6, new ItemStack(ItemID.ADAMANTITE_BAR, 1)),
	RUNITE_ORE(ItemID.RUNITE_BAR, "Runite bar", Skill.SMITHING, 85, 50,
		CriticalItem.RUNITE_ORE, Secondaries.COAL_ORE_8, new ItemStack(ItemID.RUNITE_BAR, 1)),

	// Smelting bars (Anvil)
	BRONZE_BAR(ItemID.BRONZE_BAR, "Bronze products", Skill.SMITHING, 1, 12.5,
		CriticalItem.BRONZE_BAR, null, null),
	IRON_BAR(ItemID.IRON_BAR, "Iron products", Skill.SMITHING, 15, 25.0,
		CriticalItem.IRON_BAR, null, null),
	STEEL_BAR(ItemID.STEEL_BAR, "Steel products", Skill.SMITHING, 30, 37.5,
		CriticalItem.STEEL_BAR, null, null),
	CANNONBALLS(ItemID.CANNONBALL, "Cannonballs", Skill.SMITHING, 35, 25.5,
		CriticalItem.STEEL_BAR, null, new ItemStack(ItemID.CANNONBALL, 4)),
	MITHRIL_BAR(ItemID.MITHRIL_BAR, "Mithril products", Skill.SMITHING, 50, 50.0,
		CriticalItem.MITHRIL_BAR, null, null),
	ADAMANTITE_BAR(ItemID.ADAMANTITE_BAR, "Adamantite products", Skill.SMITHING, 70, 62.5,
		CriticalItem.ADAMANTITE_BAR, null, null),
	RUNITE_BAR(ItemID.RUNITE_BAR, "Runite products", Skill.SMITHING, 85, 75.0,
		CriticalItem.RUNITE_BAR, null, null),

	/**
	 * Farming Items
	 */
	ACORN(ItemID.OAK_SAPLING, "Oak sapling", Skill.FARMING, 15, 0,
		CriticalItem.ACORN, null, new ItemStack(ItemID.OAK_SAPLING, 1)),
	WILLOW_SEED(ItemID.WILLOW_SAPLING, "Willow sapling", Skill.FARMING, 30, 0,
		CriticalItem.WILLOW_SEED, null, new ItemStack(ItemID.WILLOW_SAPLING, 1)),
	MAPLE_SEED(ItemID.MAPLE_SAPLING, "Maple sapling", Skill.FARMING, 45, 0,
		CriticalItem.MAPLE_SEED, null, new ItemStack(ItemID.MAPLE_SAPLING, 1)),
	YEW_SEED(ItemID.YEW_SAPLING, "Yew sapling", Skill.FARMING, 60, 0,
		CriticalItem.YEW_SEED, null, new ItemStack(ItemID.YEW_SAPLING, 1)),
	MAGIC_SEED(ItemID.MAGIC_SAPLING, "Magic sapling", Skill.FARMING, 75, 0,
		CriticalItem.MAGIC_SEED, null, new ItemStack(ItemID.MAGIC_SAPLING, 1)),
	APPLE_TREE_SEED(ItemID.APPLE_SAPLING, "Apple sapling", Skill.FARMING, 27, 0,
		CriticalItem.APPLE_TREE_SEED, null, new ItemStack(ItemID.APPLE_SAPLING, 1)),
	BANANA_TREE_SEED(ItemID.BANANA_SAPLING, "Banana sapling", Skill.FARMING, 33, 0,
		CriticalItem.BANANA_TREE_SEED, null, new ItemStack(ItemID.BANANA_SAPLING, 1)),
	ORANGE_TREE_SEED(ItemID.ORANGE_SAPLING, "Orange sapling", Skill.FARMING, 39, 0,
		CriticalItem.ORANGE_TREE_SEED, null, new ItemStack(ItemID.ORANGE_SAPLING, 1)),
	CURRY_TREE_SEED(ItemID.CURRY_SAPLING, "Curry sapling", Skill.FARMING, 42, 0,
		CriticalItem.CURRY_TREE_SEED, null, new ItemStack(ItemID.CURRY_SAPLING, 1)),
	PINEAPPLE_SEED(ItemID.PINEAPPLE_SAPLING, "Pineapple sapling", Skill.FARMING, 51, 0,
		CriticalItem.PINEAPPLE_SEED, null, new ItemStack(ItemID.PINEAPPLE_SAPLING, 1)),
	PAPAYA_TREE_SEED(ItemID.PAPAYA_SAPLING, "Papaya sapling", Skill.FARMING, 57, 0,
		CriticalItem.PAPAYA_TREE_SEED, null, new ItemStack(ItemID.PAPAYA_SAPLING, 1)),
	PALM_TREE_SEED(ItemID.PALM_SAPLING, "Palm sapling", Skill.FARMING, 68, 0,
		CriticalItem.PALM_TREE_SEED, null, new ItemStack(ItemID.PALM_SAPLING, 1)),
	CALQUAT_TREE_SEED(ItemID.CALQUAT_SAPLING, "Calquat sapling", Skill.FARMING, 72, 0,
		CriticalItem.CALQUAT_TREE_SEED, null, new ItemStack(ItemID.CALQUAT_SAPLING, 1)),
	TEAK_SEED(ItemID.TEAK_SAPLING, "Teak sapling", Skill.FARMING, 35, 0,
		CriticalItem.TEAK_SEED, null, new ItemStack(ItemID.TEAK_SAPLING, 1)),
	MAHOGANY_SEED(ItemID.MAHOGANY_SAPLING, "Mahogany sapling", Skill.FARMING, 55, 0,
		CriticalItem.MAHOGANY_SEED, null, new ItemStack(ItemID.MAHOGANY_SAPLING, 1)),
	SPIRIT_SEED(ItemID.SPIRIT_SAPLING, "Spirit sapling", Skill.FARMING, 83, 0,
		CriticalItem.SPIRIT_SEED, null, new ItemStack(ItemID.SPIRIT_SAPLING, 1)),

	OAK_SAPPLING(ItemID.OAK_SAPLING, "Oak tree", Skill.FARMING, 15, 481.3,
		CriticalItem.OAK_SAPLING, null, null),
	WILLOW_SAPLING(ItemID.WILLOW_SAPLING, "Willow tree", Skill.FARMING, 30, 1481.5,
		CriticalItem.WILLOW_SAPLING, null, null),
	MAPLE_SAPLING(ItemID.MAPLE_SAPLING, "Maple tree", Skill.FARMING, 45, 3448.4,
		CriticalItem.MAPLE_SAPLING, null, null),
	YEW_SAPLING(ItemID.YEW_SAPLING, "Yew tree", Skill.FARMING, 60, 7150.9,
		CriticalItem.YEW_SAPLING, null, null),
	MAGIC_SAPLING(ItemID.MAGIC_SAPLING, "Magic tree", Skill.FARMING, 75, 13913.8,
		CriticalItem.MAGIC_SAPLING, null, null),
	APPLE_TREE_SAPLING(ItemID.APPLE_SAPLING, "Apple tree", Skill.FARMING, 27, 1272.5,
		CriticalItem.APPLE_TREE_SAPLING, null, null),
	BANANA_TREE_SAPLING(ItemID.BANANA_SAPLING, "Banana tree", Skill.FARMING, 33, 1841.5,
		CriticalItem.BANANA_TREE_SAPLING, null, null),
	ORANGE_TREE_SAPLING(ItemID.ORANGE_SAPLING, "Orange tree", Skill.FARMING, 39, 2586.7,
		CriticalItem.ORANGE_TREE_SAPLING, null, null),
	CURRY_TREE_SAPLING(ItemID.CURRY_SAPLING, "Curry tree", Skill.FARMING, 42, 3036.9,
		CriticalItem.CURRY_TREE_SAPLING, null, null),
	PINEAPPLE_SAPLING(ItemID.PINEAPPLE_SAPLING, "Pineapple tree", Skill.FARMING, 51, 4791.7,
		CriticalItem.PINEAPPLE_SAPLING, null, null),
	PAPAYA_TREE_SAPLING(ItemID.PAPAYA_SAPLING, "Papaya tree", Skill.FARMING, 57, 6380.4,
		CriticalItem.PAPAYA_TREE_SAPLING, null, null),
	PALM_TREE_SAPLING(ItemID.PALM_SAPLING, "Palm tree", Skill.FARMING, 68, 10509.6,
		CriticalItem.PALM_TREE_SAPLING, null, null),
	CALQUAT_TREE_SAPLING(ItemID.CALQUAT_SAPLING, "Calquat tree", Skill.FARMING, 72, 12516.5,
		CriticalItem.CALQUAT_TREE_SAPLING, null, null),
	TEAK_SAPLING(ItemID.TEAK_SAPLING, "Teak tree", Skill.FARMING, 35, 7325,
		CriticalItem.TEAK_SAPLING, null, null),
	MAHOGANY_SAPLING(ItemID.MAHOGANY_SAPLING, "Mahogany tree", Skill.FARMING, 55, 15783,
		CriticalItem.MAHOGANY_SAPLING, null, null),
	SPIRIT_SAPLING(ItemID.SPIRIT_SAPLING, "Spirit tree", Skill.FARMING, 83, 19500,
		CriticalItem.SPIRIT_SAPLING, null, null),

	/**
	 * Fletching
	 */
	// Logs
	FLETCH_HEADLESS_ARROWS(ItemID.ARROW_SHAFT, "Arrow shaft", Skill.FLETCHING, 1, 5,
		CriticalItem.FLETCH_LOGS, null, new ItemStack(ItemID.ARROW_SHAFT, 15)),
	FLETCH_SHORTBOW_U(ItemID.SHORTBOW_U, "Shortbow (u)", Skill.FLETCHING, 5, 5,
		CriticalItem.FLETCH_LOGS, null, new ItemStack(ItemID.SHORTBOW_U, 1)),
	FLETCH_LONGBOW_U(ItemID.LONGBOW_U, "Longbow (u)", Skill.FLETCHING, 10, 10,
		CriticalItem.FLETCH_LOGS, null, new ItemStack(ItemID.LONGBOW_U, 1)),
	// Oak Logs
	FLETCH_OAK_HEADLESS_ARROWS(ItemID.ARROW_SHAFT, "Arrow shaft", Skill.FLETCHING, 15, 10,
		CriticalItem.FLETCH_OAK_LOGS, null, new ItemStack(ItemID.ARROW_SHAFT, 30)),
	FLETCH_OAK_SHORTBOW_U(ItemID.OAK_SHORTBOW_U, "Oak shortbow (u)", Skill.FLETCHING, 25, 16.5,
		CriticalItem.FLETCH_OAK_LOGS, null, new ItemStack(ItemID.OAK_SHORTBOW_U, 1)),
	FLETCH_OAK_LONGBOW_U(ItemID.OAK_LONGBOW_U, "Oak longbow (u)", Skill.FLETCHING, 25, 25,
		CriticalItem.FLETCH_OAK_LOGS, null, new ItemStack(ItemID.OAK_LONGBOW_U, 1)),
	// Willow Logs
	FLETCH_WILLOW_HEADLESS_ARROWS(ItemID.ARROW_SHAFT, "Arrow shaft", Skill.FLETCHING, 30, 15,
		CriticalItem.FLETCH_WILLOW_LOGS, null, new ItemStack(ItemID.ARROW_SHAFT, 45)),
	FLETCH_WILLOW_SHORTBOW_U(ItemID.WILLOW_SHORTBOW_U, "Willow shortbow (u)", Skill.FLETCHING, 35, 33.3,
		CriticalItem.FLETCH_WILLOW_LOGS, null, new ItemStack(ItemID.WILLOW_SHORTBOW_U, 1)),
	FLETCH_WILLOW_LONGBOW_U(ItemID.WILLOW_LONGBOW_U, "Willow longbow (u)", Skill.FLETCHING, 40, 41.5,
		CriticalItem.FLETCH_WILLOW_LOGS, null, new ItemStack(ItemID.WILLOW_LONGBOW_U, 1)),
	// Maple Logs
	FLETCH_MAPLE_HEADLESS_ARROWS(ItemID.ARROW_SHAFT, "Arrow shaft", Skill.FLETCHING, 45, 20,
		CriticalItem.FLETCH_MAPLE_LOGS, null, new ItemStack(ItemID.ARROW_SHAFT, 60)),
	FLETCH_MAPLE_SHORTBOW_U(ItemID.MAPLE_SHORTBOW_U, "Maple shortbow (u)", Skill.FLETCHING, 50, 50,
		CriticalItem.FLETCH_MAPLE_LOGS, null, new ItemStack(ItemID.MAPLE_SHORTBOW_U, 1)),
	FLETCH_MAPLE_LONGBOW_U(ItemID.MAPLE_LONGBOW_U, "Maple longbow (u)", Skill.FLETCHING, 55, 58.3,
		CriticalItem.FLETCH_MAPLE_LOGS, null, new ItemStack(ItemID.MAPLE_LONGBOW_U, 1)),
	// Yew Logs
	FLETCH_YEW_HEADLESS_ARROWS(ItemID.ARROW_SHAFT, "Arrow shaft", Skill.FLETCHING, 60, 25,
		CriticalItem.FLETCH_YEW_LOGS, null, new ItemStack(ItemID.ARROW_SHAFT, 75)),
	FLETCH_YEW_SHORTBOW_U(ItemID.YEW_SHORTBOW_U, "Yew shortbow (u)", Skill.FLETCHING, 65, 67.5,
		CriticalItem.FLETCH_YEW_LOGS, null, new ItemStack(ItemID.YEW_SHORTBOW_U, 1)),
	FLETCH_YEW_LONGBOW_U(ItemID.YEW_LONGBOW_U, "Yew longbow (u)", Skill.FLETCHING, 70, 75,
		CriticalItem.FLETCH_YEW_LOGS, null, new ItemStack(ItemID.YEW_LONGBOW_U, 1)),
	// Magic Logs
	FLETCH_MAGIC_HEADLESS_ARROWS(ItemID.ARROW_SHAFT, "Arrow shaft", Skill.FLETCHING, 75, 30,
		CriticalItem.FLETCH_MAGIC_LOGS, null, new ItemStack(ItemID.ARROW_SHAFT, 90)),
	FLETCH_MAGIC_SHORTBOW_U(ItemID.MAGIC_SHORTBOW_U, "Magic shortbow (u)", Skill.FLETCHING, 80, 83.3,
		CriticalItem.FLETCH_MAGIC_LOGS, null, new ItemStack(ItemID.MAGIC_SHORTBOW_U, 1)),
	FLETCH_MAGIC_LONGBOW_U(ItemID.MAGIC_LONGBOW_U, "Magic longbow (u)", Skill.FLETCHING, 85, 91.5,
		CriticalItem.FLETCH_MAGIC_LOGS, null, new ItemStack(ItemID.MAGIC_LONGBOW_U, 1)),
	// Strung Bows
	FLETCH_SHORTBOW(ItemID.SHORTBOW, "Shortbow", Skill.FLETCHING, 5, 5,
		CriticalItem.FLETCH_SHORTBOW_U, Secondaries.BOW_STRING, new ItemStack(ItemID.SHORTBOW, 1)),
	FLETCH_LONGBOW(ItemID.LONGBOW, "Longbow", Skill.FLETCHING, 10, 10,
		CriticalItem.FLETCH_LONGBOW_U, Secondaries.BOW_STRING, new ItemStack(ItemID.LONGBOW, 1)),
	FLETCH_OAK_SHORTBOW(ItemID.OAK_SHORTBOW, "Oak shortbow", Skill.FLETCHING, 20, 16.5,
		CriticalItem.FLETCH_OAK_SHORTBOW_U, Secondaries.BOW_STRING, new ItemStack(ItemID.OAK_SHORTBOW, 1)),
	FLETCH_OAK_LONGBOW(ItemID.OAK_LONGBOW, "Oak longbow", Skill.FLETCHING, 25, 25,
		CriticalItem.FLETCH_OAK_LONGBOW_U, Secondaries.BOW_STRING, new ItemStack(ItemID.OAK_LONGBOW, 1)),
	FLETCH_WILLOW_SHORTBOW(ItemID.WILLOW_SHORTBOW, "Willow shortbow", Skill.FLETCHING, 35, 33.2,
		CriticalItem.FLETCH_WILLOW_SHORTBOW_U, Secondaries.BOW_STRING, new ItemStack(ItemID.WILLOW_SHORTBOW, 1)),
	FLETCH_WILLOW_LONGBOW(ItemID.WILLOW_LONGBOW, "Willow longbow", Skill.FLETCHING, 40, 41.5,
		CriticalItem.FLETCH_WILLOW_LONGBOW_U, Secondaries.BOW_STRING, new ItemStack(ItemID.WILLOW_LONGBOW, 1)),
	FLETCH_MAPLE_SHORTBOW(ItemID.MAPLE_SHORTBOW, "Maple shortbow", Skill.FLETCHING, 50, 50,
		CriticalItem.FLETCH_MAPLE_SHORTBOW_U, Secondaries.BOW_STRING, new ItemStack(ItemID.MAPLE_SHORTBOW, 1)),
	FLETCH_MAPLE_LONGBOW(ItemID.MAPLE_LONGBOW, "Maple longbow", Skill.FLETCHING, 55, 58.2,
		CriticalItem.FLETCH_MAPLE_LONGBOW_U, Secondaries.BOW_STRING, new ItemStack(ItemID.MAPLE_LONGBOW, 1)),
	FLETCH_YEW_SHORTBOW(ItemID.YEW_SHORTBOW, "Yew shortbow", Skill.FLETCHING, 65, 67.5,
		CriticalItem.FLETCH_YEW_SHORTBOW_U, Secondaries.BOW_STRING, new ItemStack(ItemID.YEW_SHORTBOW, 1)),
	FLETCH_YEW_LONGBOW(ItemID.YEW_LONGBOW, "Yew longbow", Skill.FLETCHING, 70, 75,
		CriticalItem.FLETCH_YEW_LONGBOW_U, Secondaries.BOW_STRING, new ItemStack(ItemID.YEW_LONGBOW, 1)),
	FLETCH_MAGIC_SHORTBOW(ItemID.MAGIC_SHORTBOW, "Magic shortbow", Skill.FLETCHING, 80, 83.2,
		CriticalItem.FLETCH_MAGIC_SHORTBOW_U, Secondaries.BOW_STRING, new ItemStack(ItemID.MAGIC_SHORTBOW, 1)),
	FLETCH_MAGIC_LONGBOW(ItemID.MAGIC_LONGBOW, "Magic longbow", Skill.FLETCHING, 85, 91.5,
		CriticalItem.FLETCH_MAGIC_LONGBOW_U, Secondaries.BOW_STRING, new ItemStack(ItemID.MAGIC_LONGBOW, 1)),
	// Darts
	FLETCH_BRONZE_DARTS(ItemID.BRONZE_DART, "Bronze dart", Skill.FLETCHING, 10, 1.8,
		CriticalItem.FLETCH_BRONZE_DART_TIP, Secondaries.FEATHER, new ItemStack(ItemID.BRONZE_DART, 1)),
	FLETCH_IRON_DARTS(ItemID.IRON_DART, "Iron dart", Skill.FLETCHING, 22, 3.8,
		CriticalItem.FLETCH_IRON_DART_TIP, Secondaries.FEATHER, new ItemStack(ItemID.IRON_DART, 1)),
	FLETCH_STEEL_DARTS(ItemID.STEEL_DART, "Steel dart", Skill.FLETCHING, 37, 7.5,
		CriticalItem.FLETCH_STEEL_DART_TIP, Secondaries.FEATHER, new ItemStack(ItemID.STEEL_DART, 1)),
	FLETCH_MITHRIL_DARTS(ItemID.MITHRIL_DART, "Mithril dart", Skill.FLETCHING, 52, 11.2,
		CriticalItem.FLETCH_MITHRIL_DART_TIP, Secondaries.FEATHER, new ItemStack(ItemID.MITHRIL_DART, 1)),
	FLETCH_ADAMANT_DARTS(ItemID.ADAMANT_DART, "Adamant dart", Skill.FLETCHING, 67, 15,
		CriticalItem.FLETCH_ADAMANT_DART_TIP, Secondaries.FEATHER, new ItemStack(ItemID.ADAMANT_DART, 1)),
	FLETCH_RUNE_DARTS(ItemID.RUNE_DART, "Rune dart", Skill.FLETCHING, 81, 18.8,
		CriticalItem.FLETCH_RUNE_DART_TIP, Secondaries.FEATHER, new ItemStack(ItemID.RUNE_DART, 1)),
	FLETCH_DRAGON_DARTS(ItemID.DRAGON_DART, "Dragon dart", Skill.FLETCHING, 95, 25,
		CriticalItem.FLETCH_DRAGON_DART_TIP, Secondaries.FEATHER, new ItemStack(ItemID.DRAGON_DART, 1)),
	// Arrows
	FLETCH_BRONZE_ARROW(ItemID.BRONZE_ARROW, "Bronze arrow", Skill.FLETCHING, 1, 1,
		CriticalItem.FLETCH_BRONZE_ARROWTIPS, Secondaries.HEADLESS_ARROW, new ItemStack(ItemID.BRONZE_ARROW, 1)),
	FLETCH_IRON_ARROW(ItemID.IRON_ARROW, "Iron arrow", Skill.FLETCHING, 1, 1.3,
		CriticalItem.FLETCH_IRON_ARROWTIPS, Secondaries.HEADLESS_ARROW, new ItemStack(ItemID.IRON_ARROW, 1)),
	FLETCH_STEEL_ARROW(ItemID.STEEL_ARROW, "Steel arrow", Skill.FLETCHING, 30, 2.5,
		CriticalItem.FLETCH_STEEL_ARROWTIPS, Secondaries.HEADLESS_ARROW, new ItemStack(ItemID.STEEL_ARROW, 1)),
	FLETCH_MITHRIL_ARROW(ItemID.MITHRIL_ARROW, "Mithril arrow", Skill.FLETCHING, 45, 5,
		CriticalItem.FLETCH_MITHRIL_ARROWTIPS, Secondaries.HEADLESS_ARROW, new ItemStack(ItemID.MITHRIL_ARROW, 1)),
	FLETCH_BROAD_ARROW(ItemID.BROAD_ARROWS, "Broad arrow", Skill.FLETCHING, 52, 7.5,
		CriticalItem.FLETCH_BROAD_ARROWHEADS, Secondaries.HEADLESS_ARROW, new ItemStack(ItemID.BROAD_ARROWS, 1)),
	FLETCH_ADAMANT_ARROW(ItemID.ADAMANT_ARROW, "Adamant arrow", Skill.FLETCHING, 60, 10,
		CriticalItem.FLETCH_ADAMANT_ARROWTIPS, Secondaries.HEADLESS_ARROW, new ItemStack(ItemID.ADAMANT_ARROW, 1)),
	FLETCH_RUNE_ARROW(ItemID.RUNE_ARROW, "Rune arrow", Skill.FLETCHING, 75, 12.5,
		CriticalItem.FLETCH_RUNE_ARROWTIPS, Secondaries.HEADLESS_ARROW, new ItemStack(ItemID.RUNE_ARROW, 1)),
	FLETCH_AMETHYST_ARROW(ItemID.AMETHYST_ARROW, "Amethyst arrow", Skill.FLETCHING, 82, 13.5,
		CriticalItem.FLETCH_AMETHYST_ARROWTIPS, Secondaries.HEADLESS_ARROW, new ItemStack(ItemID.AMETHYST_ARROW, 1)),
	FLETCH_DRAGON_ARROW(ItemID.DRAGON_ARROW, "Dragon arrow", Skill.FLETCHING, 90, 15,
		CriticalItem.FLETCH_DRAGON_ARROWTIPS, Secondaries.HEADLESS_ARROW, new ItemStack(ItemID.DRAGON_ARROW, 1)),
	//Javelin
	FLETCH_BRONZE_JAVELIN(ItemID.BRONZE_JAVELIN, "Bronze javelin", Skill.FLETCHING, 3, 1,
		CriticalItem.FLETCH_BRONZE_JAVELINHEAD, Secondaries.JAVELIN_SHAFT, new ItemStack(ItemID.BRONZE_JAVELIN, 1)),
	FLETCH_IRON_JAVELIN(ItemID.IRON_JAVELIN, "Iron javelin", Skill.FLETCHING, 17, 2,
		CriticalItem.FLETCH_IRON_JAVELINHEAD, Secondaries.JAVELIN_SHAFT, new ItemStack(ItemID.IRON_JAVELIN, 1)),
	FLETCH_STEEL_JAVELIN(ItemID.STEEL_JAVELIN, "Steel javelin", Skill.FLETCHING, 32, 5,
		CriticalItem.FLETCH_STEEL_JAVELINHEAD, Secondaries.JAVELIN_SHAFT, new ItemStack(ItemID.STEEL_JAVELIN, 1)),
	FLETCH_MITHRIL_JAVELIN(ItemID.MITHRIL_JAVELIN, "Mithril javelin", Skill.FLETCHING, 47, 8,
		CriticalItem.FLETCH_MITHRIL_JAVELINHEAD, Secondaries.JAVELIN_SHAFT, new ItemStack(ItemID.MITHRIL_JAVELIN, 1)),
	FLETCH_ADAMANT_JAVELIN(ItemID.ADAMANT_JAVELIN, "Adamant javelin", Skill.FLETCHING, 62, 10,
		CriticalItem.FLETCH_ADAMANT_JAVELINHEAD, Secondaries.JAVELIN_SHAFT, new ItemStack(ItemID.ADAMANT_JAVELIN, 1)),
	FLETCH_RUNE_JAVELIN(ItemID.RUNE_JAVELIN, "Rune javelin", Skill.FLETCHING, 77, 12.4,
		CriticalItem.FLETCH_RUNE_JAVELINHEAD, Secondaries.JAVELIN_SHAFT, new ItemStack(ItemID.RUNE_JAVELIN, 1)),
	FLETCH_AMETHYST_JAVELIN(ItemID.AMETHYST_JAVELIN, "Amethyst javelin", Skill.FLETCHING, 84, 13.5,
		CriticalItem.FLETCH_AMETHYST_JAVELINHEAD, Secondaries.JAVELIN_SHAFT, new ItemStack(ItemID.AMETHYST_JAVELIN, 1)),
	FLETCH_DRAGON_JAVELIN(ItemID.DRAGON_JAVELIN, "Dragon javelin", Skill.FLETCHING, 92, 15,
		CriticalItem.FLETCH_DRAGON_JAVELINHEAD, Secondaries.JAVELIN_SHAFT, new ItemStack(ItemID.DRAGON_JAVELIN, 1)),
	//Bolts
	FLETCH_BRONZE_BOLT(ItemID.BRONZE_BOLTS, "Bronze bolt", Skill.FLETCHING, 9, 0.5,
		CriticalItem.FLETCH_BRONZE_BOLT, Secondaries.FEATHER, new ItemStack(ItemID.BRONZE_BOLTS, 1)),
	FLETCH_BLURITE_BOLT(ItemID.BLURITE_BOLTS_UNF, "Blurite bolt", Skill.FLETCHING, 24, 1,
		CriticalItem.FLETCH_BLURITE_BOLT, Secondaries.FEATHER, new ItemStack(ItemID.BLURITE_BOLTS, 1)),
	FLETCH_IRON_BOLT(ItemID.IRON_BOLTS, "Iron bolt", Skill.FLETCHING, 39, 1.5,
		CriticalItem.FLETCH_IRON_BOLT, Secondaries.FEATHER, new ItemStack(ItemID.IRON_BOLTS, 1)),
	FLETCH_SILVER_BOLT(ItemID.SILVER_BOLTS, "Silver bolt", Skill.FLETCHING, 43, 2.5,
		CriticalItem.FLETCH_SILVER_BOLT, Secondaries.FEATHER, new ItemStack(ItemID.SILVER_BOLTS, 1)),
	FLETCH_STEEL_BOLT(ItemID.STEEL_BOLTS, "Steel bolt", Skill.FLETCHING, 46, 3.5,
		CriticalItem.FLETCH_STEEL_BOLT, Secondaries.FEATHER, new ItemStack(ItemID.STEEL_BOLTS, 1)),
	FLETCH_MITHRIL_BOLT(ItemID.MITHRIL_BOLTS, "Mithril bolt", Skill.FLETCHING, 54, 5,
		CriticalItem.FLETCH_MITHRIL_BOLT, Secondaries.FEATHER, new ItemStack(ItemID.MITHRIL_BOLTS, 1)),
	FLETCH_BROAD_BOLT(ItemID.BROAD_BOLTS, "Broad bolt", Skill.FLETCHING, 55, 3,
		CriticalItem.FLETCH_BROAD_BOLT, Secondaries.FEATHER, new ItemStack(ItemID.BROAD_BOLTS, 1)),
	FLETCH_ADAMANT_BOLT(ItemID.ADAMANT_BOLTS, "Adamant bolt", Skill.FLETCHING, 61, 7,
		CriticalItem.FLETCH_ADAMANT_BOLT, Secondaries.FEATHER, new ItemStack(ItemID.ADAMANT_BOLTS, 1)),
	FLETCH_RUNE_BOLT(ItemID.RUNITE_BOLTS, "Rune bolt", Skill.FLETCHING, 69, 10,
		CriticalItem.FLETCH_RUNE_BOLT, Secondaries.FEATHER, new ItemStack(ItemID.RUNITE_BOLTS, 1)),
	FLETCH_DRAGON_BOLT(ItemID.DRAGON_BOLTS, "Dragon bolt", Skill.FLETCHING, 84, 12,
		CriticalItem.FLETCH_DRAGON_BOLT, Secondaries.FEATHER, new ItemStack(ItemID.DRAGON_BOLTS, 1)),
	//Bolt tips
	FLETCH_OPAL_TIPS(ItemID.OPAL_BOLT_TIPS, "Opal bolt tips", Skill.FLETCHING, 11, 1.6,
		CriticalItem.FLETCH_OPAL_TIPS, null, new ItemStack(ItemID.OPAL_BOLT_TIPS, 1)),
	FLETCH_JADE_TIPS(ItemID.JADE_BOLT_TIPS, "Jade bolt tips", Skill.FLETCHING, 26, 2.4,
		CriticalItem.FLETCH_JADE_TIPS, null, new ItemStack(ItemID.JADE_BOLT_TIPS, 1)),
	FLETCH_RED_TOPAZ_TIPS(ItemID.TOPAZ_BOLT_TIPS, "Topaz bolt tips", Skill.FLETCHING, 48, 3.9,
		CriticalItem.FLETCH_RED_TOPAZ_TIPS, null, new ItemStack(ItemID.TOPAZ_BOLT_TIPS, 1)),
	FLETCH_SAPPHIRE_TIPS(ItemID.SAPPHIRE_BOLT_TIPS, "Sapphire bolt tips", Skill.FLETCHING, 56, 4.7,
		CriticalItem.FLETCH_SAPPHIRE_TIPS, null, new ItemStack(ItemID.SAPPHIRE_BOLT_TIPS, 1)),
	FLETCH_EMERALD_TIPS(ItemID.EMERALD_BOLT_TIPS, "Emerald bolt tips", Skill.FLETCHING, 58, 5.5,
		CriticalItem.FLETCH_EMERALD_TIPS, null, new ItemStack(ItemID.EMERALD_BOLT_TIPS, 1)),
	FLETCH_RUBY_TIPS(ItemID.RUBY_BOLT_TIPS, "Ruby bolt tips", Skill.FLETCHING, 63, 6.3,
		CriticalItem.FLETCH_RUBY_TIPS, null, new ItemStack(ItemID.RUBY_BOLT_TIPS, 1)),
	FLETCH_DIAMOND_TIPS(ItemID.DIAMOND_BOLT_TIPS, "Diamond bolt tips", Skill.FLETCHING, 65, 7,
		CriticalItem.FLETCH_DIAMOND_TIPS, null, new ItemStack(ItemID.DIAMOND_BOLT_TIPS, 1)),
	FLETCH_DRAGONSTONE_TIPS(ItemID.DRAGONSTONE_BOLT_TIPS, "Dragonstone bolt tips", Skill.FLETCHING, 71, 8.2,
		CriticalItem.FLETCH_DRAGONSTONE_TIPS, null, new ItemStack(ItemID.DRAGONSTONE_BOLT_TIPS, 1)),
	FLETCH_ONYX_TIPS(ItemID.ONYX_BOLT_TIPS, "Onyx bolt tips", Skill.FLETCHING, 73, 9.4,
		CriticalItem.FLETCH_ONYX_TIPS, null, new ItemStack(ItemID.ONYX_BOLT_TIPS, 1)),
	//Tipped bolts
	FLETCH_TIPPED_OPAL_BOLT(ItemID.OPAL_BOLT_TIPS, "Opal bolt", Skill.FLETCHING, 11, 1.6,
		CriticalItem.FLETCH_TIPPED_OPAL_BOLT, Secondaries.BRONZE_BOLT, new ItemStack(ItemID.OPAL_BOLTS, 1)),
	FLETCH_TIPPED_JADE_BOLT(ItemID.JADE_BOLT_TIPS, "Jade bolt", Skill.FLETCHING, 26, 2.4,
		CriticalItem.FLETCH_TIPPED_JADE_BOLT, Secondaries.BLURITE_BOLT, new ItemStack(ItemID.JADE_BOLTS, 1)),
	FLETCH_TIPPED_PEARL_BOLT(ItemID.PEARL_BOLT_TIPS, "Pearl bolt", Skill.FLETCHING, 41, 3.2,
		CriticalItem.FLETCH_TIPPED_PEARL_BOLT, Secondaries.IRON_BOLT, new ItemStack(ItemID.PEARL_BOLTS, 1)),
	FLETCH_TIPPED_TOPAZ_BOLT(ItemID.TOPAZ_BOLT_TIPS, "Red topaz bolt", Skill.FLETCHING, 48, 4,
		CriticalItem.FLETCH_TIPPED_TOPAZ_BOLT, Secondaries.STEEL_BOLT, new ItemStack(ItemID.TOPAZ_BOLTS, 1)),
	FLETCH_TIPPED_SAPPHIRE_BOLT(ItemID.SAPPHIRE_BOLT_TIPS, "Sapphire bolt", Skill.FLETCHING, 56, 4.7,
		CriticalItem.FLETCH_TIPPED_SAPPHIRE_BOLT, Secondaries.MITHRIL_BOLT, new ItemStack(ItemID.SAPPHIRE_BOLTS, 1)),
	FLETCH_TIPPED_EMERALD_BOLT(ItemID.EMERALD_BOLT_TIPS, "Emerald bolt", Skill.FLETCHING, 58, 5.5,
		CriticalItem.FLETCH_TIPPED_EMERALD_BOLT, Secondaries.MITHRIL_BOLT, new ItemStack(ItemID.EMERALD_BOLTS, 1)),
	FLETCH_TIPPED_RUBY_BOLT(ItemID.RUBY_BOLT_TIPS, "Ruby bolt", Skill.FLETCHING, 63, 6.3,
		CriticalItem.FLETCH_TIPPED_RUBY_BOLT, Secondaries.ADAMANT_BOLT, new ItemStack(ItemID.RUBY_BOLTS, 1)),
	FLETCH_TIPPED_DIAMOND_BOLT(ItemID.DIAMOND_BOLT_TIPS, "Diamond bolt", Skill.FLETCHING, 65, 7,
		CriticalItem.FLETCH_TIPPED_DIAMOND_BOLT, Secondaries.ADAMANT_BOLT, new ItemStack(ItemID.DIAMOND_BOLTS, 1)),
	FLETCH_TIPPED_DRAGONSTONE_BOLT(ItemID.DRAGONSTONE_BOLT_TIPS, "Dragonstone bolt", Skill.FLETCHING, 71, 8.2,
		CriticalItem.FLETCH_TIPPED_DRAGONSTONE_BOLT, Secondaries.RUNE_BOLT, new ItemStack(ItemID.DRAGONSTONE_BOLTS, 1)),
	FLETCH_TIPPED_ONYX_BOLT(ItemID.ONYX_BOLT_TIPS, "Onyx bolt", Skill.FLETCHING, 73, 9.4,
		CriticalItem.FLETCH_TIPPED_ONYX_BOLT, Secondaries.RUNE_BOLT, new ItemStack(ItemID.ONYX_BOLTS, 1)),
	FLETCH_TIPPED_AMETHYST_BOLT(ItemID.AMETHYST_BOLT_TIPS, "Amethyst broad bolt", Skill.FLETCHING, 76, 10.6,
		CriticalItem.FLETCH_TIPPED_AMETHYST_BOLT, Secondaries.BROAD_BOLT, new ItemStack(ItemID.AMETHYST_BROAD_BOLTS, 1)),
	FLETCH_TIPPED_DRAGON_OPAL_BOLT(ItemID.OPAL_BOLT_TIPS, "Dragon opal bolt", Skill.FLETCHING, 84, 1.6,
		CriticalItem.OPAL, Secondaries.DRAGON_BOLT, new ItemStack(ItemID.OPAL_DRAGON_BOLTS, 1)),
	FLETCH_TIPPED_DRAGON_JADE_BOLT(ItemID.JADE_BOLT_TIPS, "Dragon jade bolt", Skill.FLETCHING, 84, 2.4,
		CriticalItem.FLETCH_TIPPED_JADE_BOLT, Secondaries.DRAGON_BOLT, new ItemStack(ItemID.JADE_DRAGON_BOLTS, 1)),
	FLETCH_TIPPED_DRAGON_PEARL_BOLT(ItemID.PEARL_BOLT_TIPS, "Dragon pearl bolt", Skill.FLETCHING, 84, 3.2,
		CriticalItem.FLETCH_TIPPED_PEARL_BOLT, Secondaries.DRAGON_BOLT, new ItemStack(ItemID.PEARL_DRAGON_BOLTS, 1)),
	FLETCH_TIPPED_DRAGON_TOPAZ_BOLT(ItemID.TOPAZ_BOLT_TIPS, "Dragon topaz bolt", Skill.FLETCHING, 84, 4,
		CriticalItem.FLETCH_TIPPED_TOPAZ_BOLT, Secondaries.DRAGON_BOLT, new ItemStack(ItemID.TOPAZ_DRAGON_BOLTS, 1)),
	FLETCH_TIPPED_DRAGON_SAPPHIRE_BOLT(ItemID.SAPPHIRE_BOLT_TIPS, "Dragon sapphire bolt", Skill.FLETCHING, 84, 4.7,
		CriticalItem.FLETCH_TIPPED_SAPPHIRE_BOLT, Secondaries.DRAGON_BOLT, new ItemStack(ItemID.SAPPHIRE_DRAGON_BOLTS, 1)),
	FLETCH_TIPPED_DRAGON_EMERALD_BOLT(ItemID.EMERALD_BOLT_TIPS, "Dragon emerald bolt", Skill.FLETCHING, 84, 5.5,
		CriticalItem.FLETCH_TIPPED_EMERALD_BOLT, Secondaries.DRAGON_BOLT, new ItemStack(ItemID.EMERALD_DRAGON_BOLTS, 1)),
	FLETCH_TIPPED_DRAGON_RUBY_BOLT(ItemID.RUBY_BOLT_TIPS, "Dragon ruby bolt", Skill.FLETCHING, 84, 6.3,
		CriticalItem.FLETCH_TIPPED_RUBY_BOLT, Secondaries.DRAGON_BOLT, new ItemStack(ItemID.RUBY_DRAGON_BOLTS, 1)),
	FLETCH_TIPPED_DRAGON_DIAMOND_BOLT(ItemID.DIAMOND_BOLT_TIPS, "Dragon diamond bolt", Skill.FLETCHING, 84, 7,
		CriticalItem.FLETCH_TIPPED_DIAMOND_BOLT, Secondaries.DRAGON_BOLT, new ItemStack(ItemID.DIAMOND_DRAGON_BOLTS, 1)),
	FLETCH_TIPPED_DRAGON_DRAGONSTONE_BOLT(ItemID.DRAGONSTONE_BOLT_TIPS, "Dragon dragonstone bolt", Skill.FLETCHING, 84, 8.2,
		CriticalItem.FLETCH_TIPPED_DRAGONSTONE_BOLT, Secondaries.DRAGON_BOLT, new ItemStack(ItemID.DRAGONSTONE_DRAGON_BOLTS, 1)),
	FLETCH_TIPPED_DRAGON_ONYX_BOLT(ItemID.ONYX_BOLT_TIPS, "Dragon onyx bolt", Skill.FLETCHING, 84, 9.4,
		CriticalItem.FLETCH_TIPPED_ONYX_BOLT, Secondaries.DRAGON_BOLT, new ItemStack(ItemID.ONYX_DRAGON_BOLTS, 1)),

	/**
	 * Firemaking
	 */
	FM_LOGS(ItemID.LOGS, "Logs", Skill.FIREMAKING, 1, 40,
		CriticalItem.FM_LOGS, null, null),
	FM_ACHEY_LOGS(ItemID.ACHEY_TREE_LOGS, "Logs", Skill.FIREMAKING, 1, 40,
		CriticalItem.FM_ACHEY_LOGS, null, null),
	FM_OAK_LOGS(ItemID.OAK_LOGS, "Logs", Skill.FIREMAKING, 15, 60,
		CriticalItem.FM_OAK_LOGS, null, null),
	FM_WILLOW_LOGS(ItemID.WILLOW_LOGS, "Logs", Skill.FIREMAKING, 30, 90,
		CriticalItem.FM_WILLOW_LOGS, null, null),
	FM_TEAK_LOGS(ItemID.TEAK_LOGS, "Logs", Skill.FIREMAKING, 35, 105,
		CriticalItem.FM_TEAK_LOGS, null, null),
	FM_ARTIC_PINE_LOGS(ItemID.ARCTIC_PINE_LOGS, "Logs", Skill.FIREMAKING, 1, 40,
		CriticalItem.FM_ARTIC_PINE_LOGS, null, null),
	FM_MAPLE_LOGS(ItemID.MAPLE_LOGS, "Logs", Skill.FIREMAKING, 45, 135,
		CriticalItem.FM_MAPLE_LOGS, null, null),
	FM_MAHOGANY_LOGS(ItemID.MAHOGANY_LOGS, "Logs", Skill.FIREMAKING, 50, 157.5,
		CriticalItem.FM_MAHOGANY_LOGS, null, null),
	FM_YEW_LOGS(ItemID.YEW_LOGS, "Logs", Skill.FIREMAKING, 60, 202.5,
		CriticalItem.FM_YEW_LOGS, null, null),
	FM_MAGIC_LOGS(ItemID.MAGIC_LOGS, "Logs", Skill.FIREMAKING, 75, 303.8,
		CriticalItem.FM_MAGIC_LOGS, null, null),
	FM_REDWOOD_LOGS(ItemID.REDWOOD_LOGS, "Logs", Skill.FIREMAKING, 90, 350,
		CriticalItem.FM_REDWOOD_LOGS, null, null),
	;

	// Store activity by CriticalItem
	private static final ImmutableMultimap<CriticalItem, Activity> CRITICAL_MAP;

	static
	{
		final ImmutableMultimap.Builder<CriticalItem, Activity> map = ImmutableMultimap.builder();
		for (final Activity item : values())
		{
			map.put(item.getCriticalItem(), item);
		}
		CRITICAL_MAP = map.build();
	}

	private final int icon;
	private final String name;
	private final CriticalItem criticalItem;
	private final Skill skill;
	private final int level;
	private final double xp;
	private final ItemStack[] secondaries;
	@Nullable
	private final ItemStack output;
	@Nullable
	private final CriticalItem linkedItem;
	private ItemInfo outputItemInfo = null;

	Activity(
		final int icon,
		final String name,
		final Skill skill,
		final int level,
		final double xp,
		final CriticalItem criticalItem,
		@Nullable final Secondaries secondaries,
		@Nullable final ItemStack output)
	{
		this.icon = icon;
		this.name = name;
		this.skill = skill;
		this.level = level;
		this.xp = xp;
		this.criticalItem = criticalItem;
		this.secondaries = secondaries == null ? new ItemStack[0] : secondaries.getItems();
		this.output = output;
		this.linkedItem = output == null ? null : CriticalItem.getByItemId(output.getId());
	}

	/**
	 * Get all Activities for this CriticalItem
	 *
	 * @param item CriticalItem to check for
	 * @return an empty Collection if no activities
	 */
	public static List<Activity> getByCriticalItem(CriticalItem item)
	{
		final Collection<Activity> activities = CRITICAL_MAP.get(item);
		if (activities == null)
		{
			return new ArrayList<>();
		}

		return new ArrayList<>(activities);
	}

	/**
	 * Get all Activities for this CriticalItem limited to level
	 *
	 * @param item       CriticalItem to check for
	 * @param limitLevel Level to check Activitiy requirements against. -1/0 value disables limits
	 * @return an empty Collection if no activities
	 */
	public static List<Activity> getByCriticalItem(final CriticalItem item, final int limitLevel)
	{
		// Return as list to allow getting by index
		final List<Activity> l = getByCriticalItem(item);
		if (limitLevel <= 0)
		{
			return l;
		}

		return l.stream().filter(a -> a.getLevel() <= limitLevel).collect(Collectors.toList());
	}

	/**
	 * Attaches the Item Composition to each CriticalItem on client initial load
	 *
	 * @param m ItemManager
	 */
	public static void prepareItemDefinitions(ItemManager m)
	{
		for (Activity a : values())
		{
			final ItemStack output = a.getOutput();
			if (output == null)
			{
				continue;
			}

			if (a.getOutputItemInfo() != null)
			{
				return;
			}

			final ItemDefinition c = m.getItemDefinition(output.getId());
			a.outputItemInfo = new ItemInfo(c.getName(), c.isStackable());
		}
	}
}
