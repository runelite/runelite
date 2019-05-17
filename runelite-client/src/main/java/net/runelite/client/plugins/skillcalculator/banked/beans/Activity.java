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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import net.runelite.client.plugins.skillcalculator.banked.CriticalItem;

@Getter
public enum Activity
{
	/**
	 * Herblore Activities
	 */
	// Creating Potions
	// Guam
	GUAM_POTION_UNF(ItemID.GUAM_POTION_UNF, "Unfinished Potion", Skill.HERBLORE, 1, 0, CriticalItem.GUAM_LEAF, ActivitySecondaries.UNFINISHED_POTION),
	GUAM_TAR(ItemID.GUAM_TAR, "Guam tar", Skill.HERBLORE, 19, 30, CriticalItem.GUAM_LEAF, ActivitySecondaries.SWAMP_TAR, true),

	ATTACK_POTION(ItemID.ATTACK_POTION4, "Attack Potion", Skill.HERBLORE, 3, 25, CriticalItem.GUAM_LEAF_POTION_UNF, ActivitySecondaries.ATTACK_POTION),
	// Marrentil
	MARRENTILL_POTION_UNF(ItemID.MARRENTILL_POTION_UNF, "Unfinished Potion", Skill.HERBLORE, 1, 0, CriticalItem.MARRENTILL, ActivitySecondaries.UNFINISHED_POTION),
	MARRENTILL_TAR(ItemID.MARRENTILL_TAR, "Marrentill tar", Skill.HERBLORE, 31, 42.5, CriticalItem.MARRENTILL, ActivitySecondaries.SWAMP_TAR, true),

	ANTIPOISON(ItemID.ANTIPOISON4, "Antipoison", Skill.HERBLORE, 5, 37.5, CriticalItem.MARRENTILL_POTION_UNF, ActivitySecondaries.ANTIPOISON),
	// Tarromin
	TARROMIN_POTION_UNF(ItemID.TARROMIN_POTION_UNF, "Unfinished Potion", Skill.HERBLORE, 1, 0, CriticalItem.TARROMIN, ActivitySecondaries.UNFINISHED_POTION),
	TARROMIN_TAR(ItemID.TARROMIN_TAR, "Tarromin tar", Skill.HERBLORE, 39, 55, CriticalItem.TARROMIN, ActivitySecondaries.SWAMP_TAR, true),

	STRENGTH_POTION(ItemID.STRENGTH_POTION4, "Strength potion", Skill.HERBLORE, 12, 50, CriticalItem.TARROMIN_POTION_UNF, ActivitySecondaries.STRENGTH_POTION),
	SERUM_207(ItemID.SERUM_207_4, "Serum 207", Skill.HERBLORE, 15, 50, CriticalItem.TARROMIN_POTION_UNF, ActivitySecondaries.SERUM_207),
	// Harralander
	HARRALANDER_POTION_UNF(ItemID.HARRALANDER_POTION_UNF, "Unfinished Potion", Skill.HERBLORE, 1, 0, CriticalItem.HARRALANDER, ActivitySecondaries.UNFINISHED_POTION),
	HARRALANDER_TAR(ItemID.HARRALANDER_TAR, "Harralander tar", Skill.HERBLORE, 44, 72.5, CriticalItem.HARRALANDER, ActivitySecondaries.SWAMP_TAR, true),

	COMPOST_POTION(ItemID.COMPOST_POTION4, "Compost potion", Skill.HERBLORE, 21, 60, CriticalItem.HARRALANDER_POTION_UNF, ActivitySecondaries.COMPOST_POTION),
	RESTORE_POTION(ItemID.RESTORE_POTION4, "Restore potion", Skill.HERBLORE, 22, 62.5, CriticalItem.HARRALANDER_POTION_UNF, ActivitySecondaries.RESTORE_POTION),
	ENERGY_POTION(ItemID.ENERGY_POTION4, "Energy potion", Skill.HERBLORE, 26, 67.5, CriticalItem.HARRALANDER_POTION_UNF, ActivitySecondaries.ENERGY_POTION),
	COMBAT_POTION(ItemID.COMBAT_POTION4, "Combat potion", Skill.HERBLORE, 36, 84, CriticalItem.HARRALANDER_POTION_UNF, ActivitySecondaries.COMBAT_POTION),
	// Ranarr Weed
	DEFENCE_POTION(ItemID.DEFENCE_POTION4, "Defence potion", Skill.HERBLORE, 30, 75, CriticalItem.RANARR_POTION_UNF, ActivitySecondaries.DEFENCE_POTION),
	PRAYER_POTION(ItemID.PRAYER_POTION4, "Prayer potion", Skill.HERBLORE, 38, 87.5, CriticalItem.RANARR_POTION_UNF, ActivitySecondaries.PRAYER_POTION),
	// Toadflax
	AGILITY_POTION(ItemID.AGILITY_POTION4, "Agility potion", Skill.HERBLORE, 34, 80, CriticalItem.TOADFLAX_POTION_UNF, ActivitySecondaries.AGILITY_POTION),
	SARADOMIN_BREW(ItemID.SARADOMIN_BREW4, "Saradomin brew", Skill.HERBLORE, 81, 180, CriticalItem.TOADFLAX_POTION_UNF, ActivitySecondaries.SARADOMIN_BREW),
	// Irit
	SUPER_ATTACK(ItemID.SUPER_ATTACK4, "Super attack", Skill.HERBLORE, 45, 100, CriticalItem.IRIT_POTION_UNF, ActivitySecondaries.SUPER_ATTACK),
	SUPERANTIPOISON(ItemID.SUPERANTIPOISON4, "Superantipoison", Skill.HERBLORE, 48, 106.3, CriticalItem.IRIT_POTION_UNF, ActivitySecondaries.SUPERANTIPOISON),
	// Avantoe
	FISHING_POTION(ItemID.FISHING_POTION4, "Fishing potion", Skill.HERBLORE, 50, 112.5, CriticalItem.AVANTOE_POTION_UNF, ActivitySecondaries.FISHING_POTION),
	SUPER_ENERGY_POTION(ItemID.SUPER_ENERGY3_20549, "Super energy potion", Skill.HERBLORE, 52, 117.5, CriticalItem.AVANTOE_POTION_UNF, ActivitySecondaries.SUPER_ENERGY_POTION),
	HUNTER_POTION(ItemID.HUNTER_POTION4, "Hunter potion", Skill.HERBLORE, 53, 120, CriticalItem.AVANTOE_POTION_UNF, ActivitySecondaries.HUNTER_POTION),
	// Kwuarm
	SUPER_STRENGTH(ItemID.SUPER_STRENGTH4, "Super strength", Skill.HERBLORE, 55, 125, CriticalItem.KWUARM_POTION_UNF, ActivitySecondaries.SUPER_STRENGTH),
	// Snapdragon
	SUPER_RESTORE(ItemID.SUPER_RESTORE4, "Super restore", Skill.HERBLORE, 63, 142.5, CriticalItem.SNAPDRAGON_POTION_UNF, ActivitySecondaries.SUPER_RESTORE),
	SANFEW_SERUM(ItemID.SANFEW_SERUM4, "Sanfew serum", Skill.HERBLORE, 65, 160, CriticalItem.SNAPDRAGON_POTION_UNF, ActivitySecondaries.SANFEW_SERUM),
	// Cadantine
	SUPER_DEFENCE_POTION(ItemID.SUPER_DEFENCE4, "Super defence", Skill.HERBLORE, 66, 150, CriticalItem.CADANTINE_POTION_UNF, ActivitySecondaries.SUPER_DEFENCE_POTION),
	// Lantadyme
	ANTIFIRE_POTION(ItemID.ANTIFIRE_POTION4, "Anti-fire potion", Skill.HERBLORE, 69, 157.5, CriticalItem.LANTADYME_POTION_UNF, ActivitySecondaries.ANTIFIRE_POTION),
	MAGIC_POTION(ItemID.MAGIC_POTION4, "Magic potion", Skill.HERBLORE, 76, 172.5, CriticalItem.LANTADYME_POTION_UNF, ActivitySecondaries.MAGIC_POTION),
	// Dwarf Weed
	RANGING_POTION(ItemID.RANGING_POTION4, "Ranging potion", Skill.HERBLORE, 72, 162.5, CriticalItem.DWARF_WEED_POTION_UNF, ActivitySecondaries.RANGING_POTION),
	// Torstol
	TORSTOL_POTION_UNF(ItemID.TORSTOL_POTION_UNF, "Unfinished Potion", Skill.HERBLORE, 78, 0, CriticalItem.TORSTOL, ActivitySecondaries.UNFINISHED_POTION),
	SUPER_COMBAT_POTION(ItemID.SUPER_COMBAT_POTION4, "Super combat", Skill.HERBLORE, 90, 150, CriticalItem.TORSTOL, ActivitySecondaries.SUPER_COMBAT_POTION, true),
	ANTIVENOM_PLUS(ItemID.ANTIVENOM4_12913, "Anti-venom+", Skill.HERBLORE, 94, 125, CriticalItem.TORSTOL, ActivitySecondaries.ANTIVENOM_PLUS, true),

	ZAMORAK_BREW(ItemID.ZAMORAK_BREW4, "Zamorak brew", Skill.HERBLORE, 78, 175, CriticalItem.TORSTOL_POTION_UNF, ActivitySecondaries.ZAMORAK_BREW),

	// Cleaning Grimy Herbs
	CLEAN_GUAM(ItemID.GUAM_LEAF, "Clean guam", Skill.HERBLORE, 3, 2.5, CriticalItem.GRIMY_GUAM_LEAF),
	CLEAN_MARRENTILL(ItemID.MARRENTILL, "Clean marrentill", Skill.HERBLORE, 5, 3.8, CriticalItem.GRIMY_MARRENTILL),
	CLEAN_TARROMIN(ItemID.TARROMIN, "Clean tarromin", Skill.HERBLORE, 11, 5, CriticalItem.GRIMY_TARROMIN),
	CLEAN_HARRALANDER(ItemID.HARRALANDER, "Clean harralander", Skill.HERBLORE, 20, 6.3, CriticalItem.GRIMY_HARRALANDER),
	CLEAN_RANARR_WEED(ItemID.RANARR_WEED, "Clean ranarr weed", Skill.HERBLORE, 25, 7.5, CriticalItem.GRIMY_RANARR_WEED),
	CLEAN_TOADFLAX(ItemID.TOADFLAX, "Clean toadflax", Skill.HERBLORE, 30, 8, CriticalItem.GRIMY_TOADFLAX),
	CLEAN_IRIT_LEAF(ItemID.IRIT_LEAF, "Clean irit leaf", Skill.HERBLORE, 40, 8.8, CriticalItem.GRIMY_IRIT_LEAF),
	CLEAN_AVANTOE(ItemID.AVANTOE, "Clean avantoe", Skill.HERBLORE, 48, 10, CriticalItem.GRIMY_AVANTOE),
	CLEAN_KWUARM(ItemID.KWUARM, "Clean kwuarm", Skill.HERBLORE, 54, 11.3, CriticalItem.GRIMY_KWUARM),
	CLEAN_SNAPDRAGON(ItemID.SNAPDRAGON, "Clean snapdragon", Skill.HERBLORE, 59, 11.8, CriticalItem.GRIMY_SNAPDRAGON),
	CLEAN_CADANTINE(ItemID.CADANTINE, "Clean cadantine", Skill.HERBLORE, 65, 12.5, CriticalItem.GRIMY_CADANTINE),
	CLEAN_LANTADYME(ItemID.LANTADYME, "Clean lantadyme", Skill.HERBLORE, 67, 13.1, CriticalItem.GRIMY_LANTADYME),
	CLEAN_DWARF_WEED(ItemID.DWARF_WEED, "Clean dwarf weed", Skill.HERBLORE, 70, 13.8, CriticalItem.GRIMY_DWARF_WEED),
	CLEAN_TORSTOL(ItemID.TORSTOL, "Clean torstol", Skill.HERBLORE, 75, 15, CriticalItem.GRIMY_TORSTOL),

	/**
	 * Construction Options
	 */
	PLANKS(ItemID.PLANK, "Normal Plank Products", Skill.CONSTRUCTION, 1, 29, CriticalItem.PLANK),
	OAK_PLANKS(ItemID.OAK_PLANK, "Normal Oak Products", Skill.CONSTRUCTION, 1, 60, CriticalItem.OAK_PLANK),
	TEAK_PLANKS(ItemID.TEAK_PLANK, "Normal Teak Products", Skill.CONSTRUCTION, 1, 90, CriticalItem.TEAK_PLANK),
	MYTHICAL_CAPE(ItemID.MYTHICAL_CAPE, "Mythical Cape Rakes", Skill.CONSTRUCTION, 1, 123.33, CriticalItem.TEAK_PLANK),
	MAHOGANY_PLANKS(ItemID.MAHOGANY_PLANK, "Normal Mahogany Products", Skill.CONSTRUCTION, 1, 140, CriticalItem.MAHOGANY_PLANK),

	/**
	 * Prayer Options
	 */
	BONES(ItemID.BONES, "Bones", Skill.PRAYER, 1, 4.5, CriticalItem.BONES),
	WOLF_BONES(ItemID.WOLF_BONES, "Bones", Skill.PRAYER, 1, 4.5, CriticalItem.WOLF_BONES),
	BURNT_BONES(ItemID.BURNT_BONES, "Bones", Skill.PRAYER, 1, 4.5, CriticalItem.BURNT_BONES),
	MONKEY_BONES(ItemID.MONKEY_BONES, "Bones", Skill.PRAYER, 1, 5.0, CriticalItem.MONKEY_BONES),
	BAT_BONES(ItemID.BAT_BONES, "Bones", Skill.PRAYER, 1, 5.3, CriticalItem.BAT_BONES),
	JOGRE_BONES(ItemID.JOGRE_BONES, "Bones", Skill.PRAYER, 1, 15.0, CriticalItem.JOGRE_BONES),
	BIG_BONES(ItemID.BIG_BONES, "Bones", Skill.PRAYER, 1, 15.0, CriticalItem.BIG_BONES),
	ZOGRE_BONES(ItemID.ZOGRE_BONES, "Bones", Skill.PRAYER, 1, 22.5, CriticalItem.ZOGRE_BONES),
	SHAIKAHAN_BONES(ItemID.SHAIKAHAN_BONES, "Bones", Skill.PRAYER, 1, 25.0, CriticalItem.SHAIKAHAN_BONES),
	BABYDRAGON_BONES(ItemID.BABYDRAGON_BONES, "Bones", Skill.PRAYER, 1, 30.0, CriticalItem.BABYDRAGON_BONES),
	WYVERN_BONES(ItemID.WYVERN_BONES, "Bones", Skill.PRAYER, 1, 72.0, CriticalItem.WYVERN_BONES),
	DRAGON_BONES(ItemID.DRAGON_BONES, "Bones", Skill.PRAYER, 1, 72.0, CriticalItem.DRAGON_BONES),
	FAYRG_BONES(ItemID.FAYRG_BONES, "Bones", Skill.PRAYER, 1, 84.0, CriticalItem.FAYRG_BONES),
	LAVA_DRAGON_BONES(ItemID.LAVA_DRAGON_BONES, "Bones", Skill.PRAYER, 1, 85.0, CriticalItem.LAVA_DRAGON_BONES),
	RAURG_BONES(ItemID.RAURG_BONES, "Bones", Skill.PRAYER, 1, 96.0, CriticalItem.RAURG_BONES),
	DAGANNOTH_BONES(ItemID.DAGANNOTH_BONES, "Bones", Skill.PRAYER, 1, 125.0, CriticalItem.DAGANNOTH_BONES),
	OURG_BONES(ItemID.OURG_BONES, "Bones", Skill.PRAYER, 1, 140.0, CriticalItem.OURG_BONES),
	SUPERIOR_DRAGON_BONES(ItemID.SUPERIOR_DRAGON_BONES, "Bones", Skill.PRAYER, 1, 150.0, CriticalItem.SUPERIOR_DRAGON_BONES),
	// Shade Remains (Pyre Logs)
	LOAR_REMAINS(ItemID.LOAR_REMAINS, "Shades", Skill.PRAYER, 1, 33.0, CriticalItem.LOAR_REMAINS),
	PHRIN_REMAINS(ItemID.PHRIN_REMAINS, "Shades", Skill.PRAYER, 1, 46.5, CriticalItem.PHRIN_REMAINS),
	RIYL_REMAINS(ItemID.RIYL_REMAINS, "Shades", Skill.PRAYER, 1, 59.5, CriticalItem.RIYL_REMAINS),
	ASYN_REMAINS(ItemID.ASYN_REMAINS, "Shades", Skill.PRAYER, 1, 82.5, CriticalItem.ASYN_REMAINS),
	FIYR_REMAINS(ItemID.FIYR_REMAINS, "Shades", Skill.PRAYER, 1, 84.0, CriticalItem.FIYR_REMAINS),
	// Ensouled Heads
	ENSOULED_GOBLIN_HEAD(ItemID.ENSOULED_GOBLIN_HEAD_13448, "Ensouled Heads", Skill.PRAYER, 1, 130.0, CriticalItem.ENSOULED_GOBLIN_HEAD),
	ENSOULED_MONKEY_HEAD(ItemID.ENSOULED_MONKEY_HEAD_13451, "Ensouled Heads", Skill.PRAYER, 1, 182.0, CriticalItem.ENSOULED_MONKEY_HEAD),
	ENSOULED_IMP_HEAD(ItemID.ENSOULED_IMP_HEAD_13454, "Ensouled Heads", Skill.PRAYER, 1, 286.0, CriticalItem.ENSOULED_IMP_HEAD),
	ENSOULED_MINOTAUR_HEAD(ItemID.ENSOULED_MINOTAUR_HEAD_13457, "Ensouled Heads", Skill.PRAYER, 1, 364.0, CriticalItem.ENSOULED_MINOTAUR_HEAD),
	ENSOULED_SCORPION_HEAD(ItemID.ENSOULED_SCORPION_HEAD_13460, "Ensouled Heads", Skill.PRAYER, 1, 454.0, CriticalItem.ENSOULED_SCORPION_HEAD),
	ENSOULED_BEAR_HEAD(ItemID.ENSOULED_BEAR_HEAD_13463, "Ensouled Heads", Skill.PRAYER, 1, 480.0, CriticalItem.ENSOULED_BEAR_HEAD),
	ENSOULED_UNICORN_HEAD(ItemID.ENSOULED_UNICORN_HEAD_13466, "Ensouled Heads", Skill.PRAYER, 1, 494.0, CriticalItem.ENSOULED_UNICORN_HEAD),
	ENSOULED_DOG_HEAD(ItemID.ENSOULED_DOG_HEAD_13469, "Ensouled Heads", Skill.PRAYER, 1, 520.0, CriticalItem.ENSOULED_DOG_HEAD),
	ENSOULED_CHAOS_DRUID_HEAD(ItemID.ENSOULED_CHAOS_DRUID_HEAD_13472, "Ensouled Heads", Skill.PRAYER, 1, 584.0, CriticalItem.ENSOULED_CHAOS_DRUID_HEAD),
	ENSOULED_GIANT_HEAD(ItemID.ENSOULED_GIANT_HEAD_13475, "Ensouled Heads", Skill.PRAYER, 1, 650.0, CriticalItem.ENSOULED_GIANT_HEAD),
	ENSOULED_OGRE_HEAD(ItemID.ENSOULED_OGRE_HEAD_13478, "Ensouled Heads", Skill.PRAYER, 1, 716.0, CriticalItem.ENSOULED_OGRE_HEAD),
	ENSOULED_ELF_HEAD(ItemID.ENSOULED_ELF_HEAD_13481, "Ensouled Heads", Skill.PRAYER, 1, 754.0, CriticalItem.ENSOULED_ELF_HEAD),
	ENSOULED_TROLL_HEAD(ItemID.ENSOULED_TROLL_HEAD_13484, "Ensouled Heads", Skill.PRAYER, 1, 780.0, CriticalItem.ENSOULED_TROLL_HEAD),
	ENSOULED_HORROR_HEAD(ItemID.ENSOULED_HORROR_HEAD_13487, "Ensouled Heads", Skill.PRAYER, 1, 832.0, CriticalItem.ENSOULED_HORROR_HEAD),
	ENSOULED_KALPHITE_HEAD(ItemID.ENSOULED_KALPHITE_HEAD_13490, "Ensouled Heads", Skill.PRAYER, 1, 884.0, CriticalItem.ENSOULED_KALPHITE_HEAD),
	ENSOULED_DAGANNOTH_HEAD(ItemID.ENSOULED_DAGANNOTH_HEAD_13493, "Ensouled Heads", Skill.PRAYER, 1, 936.0, CriticalItem.ENSOULED_DAGANNOTH_HEAD),
	ENSOULED_BLOODVELD_HEAD(ItemID.ENSOULED_BLOODVELD_HEAD_13496, "Ensouled Heads", Skill.PRAYER, 1, 1040.0, CriticalItem.ENSOULED_BLOODVELD_HEAD),
	ENSOULED_TZHAAR_HEAD(ItemID.ENSOULED_TZHAAR_HEAD_13499, "Ensouled Heads", Skill.PRAYER, 1, 1104.0, CriticalItem.ENSOULED_TZHAAR_HEAD),
	ENSOULED_DEMON_HEAD(ItemID.ENSOULED_DEMON_HEAD_13502, "Ensouled Heads", Skill.PRAYER, 1, 1170.0, CriticalItem.ENSOULED_DEMON_HEAD),
	ENSOULED_AVIANSIE_HEAD(ItemID.ENSOULED_AVIANSIE_HEAD_13505, "Ensouled Heads", Skill.PRAYER, 1, 1234.0, CriticalItem.ENSOULED_AVIANSIE_HEAD),
	ENSOULED_ABYSSAL_HEAD(ItemID.ENSOULED_ABYSSAL_HEAD_13508, "Ensouled Heads", Skill.PRAYER, 1, 1300.0, CriticalItem.ENSOULED_ABYSSAL_HEAD),
	ENSOULED_DRAGON_HEAD(ItemID.ENSOULED_DRAGON_HEAD_13511, "Ensouled Heads", Skill.PRAYER, 1, 1560.0, CriticalItem.ENSOULED_DRAGON_HEAD),

	/*
	 * Cooking Items
	 */
	RAW_HERRING(ItemID.RAW_HERRING, "Fish", Skill.COOKING, 5, 50.0, CriticalItem.RAW_HERRING),
	RAW_MACKEREL(ItemID.RAW_MACKEREL, "Fish", Skill.COOKING, 10, 60.0, CriticalItem.RAW_MACKEREL),
	RAW_TROUT(ItemID.RAW_TROUT, "Fish", Skill.COOKING, 15, 70.0, CriticalItem.RAW_TROUT),
	RAW_COD(ItemID.RAW_COD, "Fish", Skill.COOKING, 18, 75.0, CriticalItem.RAW_COD),
	RAW_PIKE(ItemID.RAW_PIKE, "Fish", Skill.COOKING, 20, 80.0, CriticalItem.RAW_PIKE),
	RAW_SALMON(ItemID.RAW_SALMON, "Fish", Skill.COOKING, 25, 90.0, CriticalItem.RAW_SALMON),
	RAW_TUNA(ItemID.RAW_TUNA, "Fish", Skill.COOKING, 30, 100.0, CriticalItem.RAW_TUNA),
	RAW_KARAMBWAN(ItemID.RAW_KARAMBWAN, "Fish", Skill.COOKING, 30, 190.0, CriticalItem.RAW_KARAMBWAN),
	RAW_LOBSTER(ItemID.RAW_LOBSTER, "Fish", Skill.COOKING, 40, 120.0, CriticalItem.RAW_LOBSTER),
	RAW_BASS(ItemID.RAW_BASS, "Fish", Skill.COOKING, 43, 130.0, CriticalItem.RAW_BASS),
	RAW_SWORDFISH(ItemID.RAW_SWORDFISH, "Fish", Skill.COOKING, 45, 140.0, CriticalItem.RAW_SWORDFISH),
	RAW_MONKFISH(ItemID.RAW_MONKFISH, "Fish", Skill.COOKING, 62, 150.0, CriticalItem.RAW_MONKFISH),
	RAW_SHARK(ItemID.RAW_SHARK, "Fish", Skill.COOKING, 80, 210.0, CriticalItem.RAW_SHARK),
	RAW_SEA_TURTLE(ItemID.RAW_SEA_TURTLE, "Fish", Skill.COOKING, 82, 211.3, CriticalItem.RAW_SEA_TURTLE),
	RAW_ANGLERFISH(ItemID.RAW_ANGLERFISH, "Fish", Skill.COOKING, 84, 230.0, CriticalItem.RAW_ANGLERFISH),
	RAW_DARK_CRAB(ItemID.RAW_DARK_CRAB, "Fish", Skill.COOKING, 90, 215.0, CriticalItem.RAW_DARK_CRAB),
	RAW_MANTA_RAY(ItemID.RAW_MANTA_RAY, "Fish", Skill.COOKING, 91, 216.2, CriticalItem.RAW_MANTA_RAY),

	WINE(ItemID.JUG_OF_WINE, "Other", Skill.COOKING, 35, 200, CriticalItem.GRAPES, ActivitySecondaries.JUG_OF_WATER),

	/*
	 * Crafting Items
	 */
	// Spinning
	BALL_OF_WOOL(ItemID.WOOL, "Misc", Skill.CRAFTING, 1, 2.5, CriticalItem.WOOL),
	BOW_STRING(ItemID.BOW_STRING, "Misc", Skill.CRAFTING, 1, 15, CriticalItem.FLAX),
	// Glass Blowing
	BEER_GLASS(ItemID.BEER_GLASS, "Beer Glass", Skill.CRAFTING, 1, 17.5, CriticalItem.MOLTEN_GLASS),
	CANDLE_LANTERN(ItemID.CANDLE_LANTERN, "Candle Lantern", Skill.CRAFTING, 4, 19, CriticalItem.MOLTEN_GLASS),
	OIL_LAMP(ItemID.OIL_LAMP, "Oil Lamp", Skill.CRAFTING, 12, 25, CriticalItem.MOLTEN_GLASS),
	VIAL(ItemID.VIAL, "Vial", Skill.CRAFTING, 33, 35, CriticalItem.MOLTEN_GLASS),
	EMPTY_FISHBOWL(ItemID.EMPTY_FISHBOWL, "Empty fishbowl", Skill.CRAFTING, 42, 42.5, CriticalItem.MOLTEN_GLASS),
	UNPOWERED_ORB(ItemID.UNPOWERED_ORB, "Unpowered orb", Skill.CRAFTING, 46, 52.5, CriticalItem.MOLTEN_GLASS),
	LANTERN_LENS(ItemID.LANTERN_LENS, "Lantern lens", Skill.CRAFTING, 49, 55, CriticalItem.MOLTEN_GLASS),
	LIGHT_ORB(ItemID.LIGHT_ORB, "Light orb", Skill.CRAFTING, 87, 70, CriticalItem.MOLTEN_GLASS),
	// D'hide/Dragon Leather
	GREEN_DRAGON_LEATHER(ItemID.GREEN_DRAGON_LEATHER, "D'hide", Skill.CRAFTING, 57, 62.0, CriticalItem.GREEN_DRAGON_LEATHER),
	BLUE_DRAGON_LEATHER(ItemID.BLUE_DRAGON_LEATHER, "D'hide", Skill.CRAFTING, 66, 70.0, CriticalItem.BLUE_DRAGON_LEATHER),
	RED_DRAGON_LEATHER(ItemID.RED_DRAGON_LEATHER, "D'hide", Skill.CRAFTING, 73, 78.0, CriticalItem.RED_DRAGON_LEATHER),
	BLACK_DRAGON_LEATHER(ItemID.BLACK_DRAGON_LEATHER, "D'hide", Skill.CRAFTING, 79, 86.0, CriticalItem.BLACK_DRAGON_LEATHER),
	// Uncut Gems
	UNCUT_OPAL(ItemID.UNCUT_OPAL, "Gems", Skill.CRAFTING, 1, 15.0, CriticalItem.UNCUT_OPAL),
	UNCUT_JADE(ItemID.UNCUT_JADE, "Gems", Skill.CRAFTING, 13, 20.0, CriticalItem.UNCUT_JADE),
	UNCUT_RED_TOPAZ(ItemID.UNCUT_RED_TOPAZ, "Gems", Skill.CRAFTING, 16, 25.0, CriticalItem.UNCUT_RED_TOPAZ),
	UNCUT_SAPPHIRE(ItemID.UNCUT_SAPPHIRE, "Gems", Skill.CRAFTING, 20, 50.0, CriticalItem.UNCUT_SAPPHIRE),
	UNCUT_EMERALD(ItemID.UNCUT_EMERALD, "Gems", Skill.CRAFTING, 27, 67.5, CriticalItem.UNCUT_EMERALD),
	UNCUT_RUBY(ItemID.UNCUT_RUBY, "Gems", Skill.CRAFTING, 34, 85, CriticalItem.UNCUT_RUBY),
	UNCUT_DIAMOND(ItemID.UNCUT_DIAMOND, "Gems", Skill.CRAFTING, 43, 107.5, CriticalItem.UNCUT_DIAMOND),
	UNCUT_DRAGONSTONE(ItemID.UNCUT_DRAGONSTONE, "Gems", Skill.CRAFTING, 55, 137.5, CriticalItem.UNCUT_DRAGONSTONE),
	UNCUT_ONYX(ItemID.UNCUT_ONYX, "Gems", Skill.CRAFTING, 67, 167.5, CriticalItem.UNCUT_ONYX),
	UNCUT_ZENYTE(ItemID.UNCUT_ZENYTE, "Gems", Skill.CRAFTING, 89, 200.0, CriticalItem.UNCUT_ZENYTE),
	// Silver Jewelery
	OPAL_RING(ItemID.OPAL_RING, "Opal ring", Skill.CRAFTING, 1, 10, CriticalItem.OPAL, ActivitySecondaries.SILVER_BAR),
	OPAL_NECKLACE(ItemID.OPAL_NECKLACE, "Opal necklace", Skill.CRAFTING, 16, 35, CriticalItem.OPAL, ActivitySecondaries.SILVER_BAR),
	OPAL_BRACELET(ItemID.OPAL_BRACELET, "Opal bracelet", Skill.CRAFTING, 22, 45, CriticalItem.OPAL, ActivitySecondaries.SILVER_BAR),
	OPAL_AMULET(ItemID.OPAL_AMULET, "Opal amulet", Skill.CRAFTING, 27, 55, CriticalItem.OPAL, ActivitySecondaries.SILVER_BAR),
	JADE_RING(ItemID.JADE_RING, "Jade ring", Skill.CRAFTING, 13, 32, CriticalItem.JADE, ActivitySecondaries.SILVER_BAR),
	JADE_NECKLACE(ItemID.JADE_NECKLACE, "Jade necklace", Skill.CRAFTING, 25, 54, CriticalItem.JADE, ActivitySecondaries.SILVER_BAR),
	JADE_BRACELET(ItemID.JADE_BRACELET, "Jade bracelet", Skill.CRAFTING, 29, 60, CriticalItem.JADE, ActivitySecondaries.SILVER_BAR),
	JADE_AMULET(ItemID.JADE_AMULET, "Jade amulet", Skill.CRAFTING, 34, 70, CriticalItem.JADE, ActivitySecondaries.SILVER_BAR),
	TOPAZ_RING(ItemID.TOPAZ_RING, "Topaz ring", Skill.CRAFTING, 16, 35, CriticalItem.RED_TOPAZ, ActivitySecondaries.SILVER_BAR),
	TOPAZ_NECKLACE(ItemID.TOPAZ_NECKLACE, "Topaz necklace", Skill.CRAFTING, 32, 70, CriticalItem.RED_TOPAZ, ActivitySecondaries.SILVER_BAR),
	TOPAZ_BRACELET(ItemID.TOPAZ_BRACELET, "Topaz bracelet", Skill.CRAFTING, 38, 75, CriticalItem.RED_TOPAZ, ActivitySecondaries.SILVER_BAR),
	TOPAZ_AMULET(ItemID.TOPAZ_AMULET, "Topaz amulet", Skill.CRAFTING, 45, 80, CriticalItem.RED_TOPAZ, ActivitySecondaries.SILVER_BAR),
	// Gold Jewelery
	SAPPHIRE_RING(ItemID.SAPPHIRE_RING, "Sapphire ring", Skill.CRAFTING, 20, 40, CriticalItem.SAPPHIRE, ActivitySecondaries.GOLD_BAR),
	SAPPHIRE_NECKLACE(ItemID.SAPPHIRE_NECKLACE, "Sapphire necklace", Skill.CRAFTING, 22, 55, CriticalItem.SAPPHIRE, ActivitySecondaries.GOLD_BAR),
	SAPPHIRE_BRACELET(ItemID.SAPPHIRE_BRACELET, "Sapphire bracelet", Skill.CRAFTING, 23, 60, CriticalItem.SAPPHIRE, ActivitySecondaries.GOLD_BAR),
	SAPPHIRE_AMULET(ItemID.SAPPHIRE_AMULET, "Sapphire amulet", Skill.CRAFTING, 24, 65, CriticalItem.SAPPHIRE, ActivitySecondaries.GOLD_BAR),
	EMERALD_RING(ItemID.EMERALD_RING, "Emerald ring", Skill.CRAFTING, 27, 55, CriticalItem.EMERALD, ActivitySecondaries.GOLD_BAR),
	EMERALD_NECKLACE(ItemID.EMERALD_NECKLACE, "Emerald necklace", Skill.CRAFTING, 29, 60, CriticalItem.EMERALD, ActivitySecondaries.GOLD_BAR),
	EMERALD_BRACELET(ItemID.EMERALD_BRACELET, "Emerald bracelet", Skill.CRAFTING, 30, 65, CriticalItem.EMERALD, ActivitySecondaries.GOLD_BAR),
	EMERALD_AMULET(ItemID.EMERALD_AMULET, "Emerald amulet", Skill.CRAFTING, 31, 70, CriticalItem.EMERALD, ActivitySecondaries.GOLD_BAR),
	RUBY_RING(ItemID.RUBY_RING, "Ruby ring", Skill.CRAFTING, 34, 70, CriticalItem.RUBY, ActivitySecondaries.GOLD_BAR),
	RUBY_NECKLACE(ItemID.RUBY_NECKLACE, "Ruby necklace", Skill.CRAFTING, 40, 75, CriticalItem.RUBY, ActivitySecondaries.GOLD_BAR),
	RUBY_BRACELET(ItemID.RUBY_BRACELET, "Ruby bracelet", Skill.CRAFTING, 42, 80, CriticalItem.RUBY, ActivitySecondaries.GOLD_BAR),
	RUBY_AMULET(ItemID.RUBY_AMULET, "Ruby amulet", Skill.CRAFTING, 50, 85, CriticalItem.RUBY, ActivitySecondaries.GOLD_BAR),
	DIAMOND_RING(ItemID.DIAMOND_RING, "Diamond ring", Skill.CRAFTING, 43, 85, CriticalItem.DIAMOND, ActivitySecondaries.GOLD_BAR),
	DIAMOND_NECKLACE(ItemID.DIAMOND_NECKLACE, "Diamond necklace", Skill.CRAFTING, 56, 90, CriticalItem.DIAMOND, ActivitySecondaries.GOLD_BAR),
	DIAMOND_BRACELET(ItemID.DIAMOND_BRACELET, "Diamond bracelet", Skill.CRAFTING, 58, 95, CriticalItem.DIAMOND, ActivitySecondaries.GOLD_BAR),
	DIAMOND_AMULET(ItemID.DIAMOND_AMULET, "Diamond amulet", Skill.CRAFTING, 70, 100, CriticalItem.DIAMOND, ActivitySecondaries.GOLD_BAR),
	DRAGONSTONE_RING(ItemID.DRAGONSTONE_RING, "Dragonstone ring", Skill.CRAFTING, 55, 100, CriticalItem.DRAGONSTONE, ActivitySecondaries.GOLD_BAR),
	DRAGON_NECKLACE(ItemID.DRAGON_NECKLACE, "Dragon necklace", Skill.CRAFTING, 72, 105, CriticalItem.DRAGONSTONE, ActivitySecondaries.GOLD_BAR),
	DRAGONSTONE_BRACELET(ItemID.DRAGONSTONE_BRACELET, "Dragonstone bracelet", Skill.CRAFTING, 74, 110, CriticalItem.DRAGONSTONE, ActivitySecondaries.GOLD_BAR),
	DRAGONSTONE_AMULET(ItemID.DRAGONSTONE_AMULET, "Dragonstone amulet", Skill.CRAFTING, 80, 150, CriticalItem.DRAGONSTONE, ActivitySecondaries.GOLD_BAR),
	ONYX_RING(ItemID.ONYX_RING, "Onyx ring", Skill.CRAFTING, 67, 115, CriticalItem.ONYX, ActivitySecondaries.GOLD_BAR),
	ONYX_NECKLACE(ItemID.ONYX_NECKLACE, "Onyx necklace", Skill.CRAFTING, 82, 120, CriticalItem.ONYX, ActivitySecondaries.GOLD_BAR),
	REGEN_BRACELET(ItemID.REGEN_BRACELET, "Regen bracelet", Skill.CRAFTING, 84, 125, CriticalItem.ONYX, ActivitySecondaries.GOLD_BAR),
	ONYX_AMULET(ItemID.ONYX_AMULET, "Onyx amulet", Skill.CRAFTING, 90, 165, CriticalItem.ONYX, ActivitySecondaries.GOLD_BAR),
	ZENYTE_RING(ItemID.ZENYTE_RING, "Zenyte ring", Skill.CRAFTING, 89, 150, CriticalItem.ZENYTE, ActivitySecondaries.GOLD_BAR),
	ZENYTE_NECKLACE(ItemID.ZENYTE_NECKLACE, "Zenyte necklace", Skill.CRAFTING, 92, 165, CriticalItem.ZENYTE, ActivitySecondaries.GOLD_BAR),
	ZENYTE_BRACELET(ItemID.ZENYTE_BRACELET, "Zenyte bracelet", Skill.CRAFTING, 95, 180, CriticalItem.ZENYTE, ActivitySecondaries.GOLD_BAR),
	ZENYTE_AMULET(ItemID.ZENYTE_AMULET, "Zenyte amulet", Skill.CRAFTING, 98, 200, CriticalItem.ZENYTE, ActivitySecondaries.GOLD_BAR),
	// Battle Staves
	WATER_BATTLESTAFF(ItemID.WATER_BATTLESTAFF, "Water battlestaff", Skill.CRAFTING, 54, 100, CriticalItem.BATTLESTAFF, ActivitySecondaries.WATER_ORB),
	EARTH_BATTLESTAFF(ItemID.EARTH_BATTLESTAFF, "Earth battlestaff", Skill.CRAFTING, 58, 112.5, CriticalItem.BATTLESTAFF, ActivitySecondaries.EARTH_ORB),
	FIRE_BATTLESTAFF(ItemID.FIRE_BATTLESTAFF, "Fire battlestaff", Skill.CRAFTING, 62, 125, CriticalItem.BATTLESTAFF, ActivitySecondaries.FIRE_ORB),
	AIR_BATTLESTAFF(ItemID.AIR_BATTLESTAFF, "Air battlestaff", Skill.CRAFTING, 66, 137.5, CriticalItem.BATTLESTAFF, ActivitySecondaries.AIR_ORB),

	/*
	 * Smithing Items
	 */

	// Smelting ores (Furnace)
	IRON_ORE(ItemID.IRON_BAR, "Iron Bars", Skill.SMITHING, 15, 12.5, CriticalItem.IRON_ORE, ActivitySecondaries.COAL_ORE),
	STEEL_ORE(ItemID.STEEL_BAR, "Steel Bars", Skill.SMITHING, 30, 17.5, CriticalItem.IRON_ORE, ActivitySecondaries.COAL_ORE_2),
	SILVER_ORE(ItemID.SILVER_ORE, "Bar", Skill.SMITHING, 20, 13.67, CriticalItem.SILVER_ORE),
	GOLD_ORE(ItemID.GOLD_BAR, "Regular exp", Skill.SMITHING, 40, 22.5, CriticalItem.GOLD_ORE),
	GOLD_ORE_GAUNTLETS(ItemID.GOLDSMITH_GAUNTLETS, "Goldsmith Gauntlets", Skill.SMITHING, 40, 56.2, CriticalItem.GOLD_ORE),
	MITHRIL_ORE(ItemID.MITHRIL_ORE, "Bar", Skill.SMITHING, 50, 30, CriticalItem.MITHRIL_ORE, ActivitySecondaries.COAL_ORE_4),
	ADAMANTITE_ORE(ItemID.ADAMANTITE_ORE, "Bar", Skill.SMITHING, 70, 37.5, CriticalItem.ADAMANTITE_ORE, ActivitySecondaries.COAL_ORE_6),
	RUNITE_ORE(ItemID.RUNITE_ORE, "Bar", Skill.SMITHING, 85, 50, CriticalItem.RUNITE_ORE, ActivitySecondaries.COAL_ORE_8),

	// Smelting bars (Anvil)
	BRONZE_BAR(ItemID.BRONZE_BAR, "Bars", Skill.SMITHING, 1, 12.5, CriticalItem.BRONZE_BAR),
	IRON_BAR(ItemID.IRON_BAR, "Bars", Skill.SMITHING, 15, 25.0, CriticalItem.IRON_BAR),
	STEEL_BAR(ItemID.STEEL_BAR, "Steel Products", Skill.SMITHING, 30, 37.5, CriticalItem.STEEL_BAR),
	CANNONBALLS(ItemID.CANNONBALL, "Cannonballs", Skill.SMITHING, 35, 25.5, CriticalItem.STEEL_BAR),
	MITHRIL_BAR(ItemID.MITHRIL_BAR, "Bars", Skill.SMITHING, 50, 50.0, CriticalItem.MITHRIL_BAR),
	ADAMANTITE_BAR(ItemID.ADAMANTITE_BAR, "Bars", Skill.SMITHING, 70, 62.5, CriticalItem.ADAMANTITE_BAR),
	RUNITE_BAR(ItemID.RUNITE_BAR, "Bars", Skill.SMITHING, 85, 75.0, CriticalItem.RUNITE_BAR),

	/**
	 * Farming Items
	 */
	ACORN(ItemID.ACORN, "Seeds", Skill.FARMING, 15, 481.3, CriticalItem.ACORN),
	WILLOW_SEED(ItemID.WILLOW_SEED, "Seeds", Skill.FARMING, 30, 1481.5, CriticalItem.WILLOW_SEED),
	MAPLE_SEED(ItemID.MAPLE_SEED, "Seeds", Skill.FARMING, 45, 3448.4, CriticalItem.MAPLE_SEED),
	YEW_SEED(ItemID.YEW_SEED, "Seeds", Skill.FARMING, 60, 7150.9, CriticalItem.YEW_SEED),
	MAGIC_SEED(ItemID.MAGIC_SEED, "Seeds", Skill.FARMING, 75, 13913.8, CriticalItem.MAGIC_SEED),
	APPLE_TREE_SEED(ItemID.APPLE_TREE_SEED, "Seeds", Skill.FARMING, 27, 1272.5, CriticalItem.APPLE_TREE_SEED),
	BANANA_TREE_SEED(ItemID.BANANA_TREE_SEED, "Seeds", Skill.FARMING, 33, 1841.5, CriticalItem.BANANA_TREE_SEED),
	ORANGE_TREE_SEED(ItemID.ORANGE_TREE_SEED, "Seeds", Skill.FARMING, 39, 2586.7, CriticalItem.ORANGE_TREE_SEED),
	CURRY_TREE_SEED(ItemID.CURRY_TREE_SEED, "Seeds", Skill.FARMING, 42, 3036.9, CriticalItem.CURRY_TREE_SEED),
	PINEAPPLE_SEED(ItemID.PINEAPPLE_SEED, "Seeds", Skill.FARMING, 51, 4791.7, CriticalItem.PINEAPPLE_SEED),
	PAPAYA_TREE_SEED(ItemID.PAPAYA_TREE_SEED, "Seeds", Skill.FARMING, 57, 6380.4, CriticalItem.PAPAYA_TREE_SEED),
	PALM_TREE_SEED(ItemID.PALM_TREE_SEED, "Seeds", Skill.FARMING, 68, 10509.6, CriticalItem.PALM_TREE_SEED),
	CALQUAT_TREE_SEED(ItemID.CALQUAT_TREE_SEED, "Seeds", Skill.FARMING, 72, 12516.5, CriticalItem.CALQUAT_TREE_SEED),
	TEAK_SEED(ItemID.TEAK_SEED, "Seeds", Skill.FARMING, 35, 7325, CriticalItem.TEAK_SEED),
	MAHOGANY_SEED(ItemID.MAHOGANY_SEED, "Seeds", Skill.FARMING, 55, 15783, CriticalItem.MAHOGANY_SEED),
	SPIRIT_SEED(ItemID.SPIRIT_SEED, "Seeds", Skill.FARMING, 83, 19500, CriticalItem.SPIRIT_SEED),
	;

	private final int icon;
	private final String name;
	private final Skill skill;
	private final int level;
	private final double xp;
	private final SecondaryItem[] secondaries;
	private final CriticalItem criticalItem;
	private final boolean preventLinked;

	Activity(int Icon, String name, Skill skill, int level, double xp, CriticalItem criticalItem)
	{
		this.icon = Icon;
		this.name = name;
		this.skill = skill;
		this.level = level;
		this.xp = xp;
		this.criticalItem = criticalItem;
		this.secondaries = new SecondaryItem[0];
		this.preventLinked = false;
	}

	Activity(int Icon, String name, Skill skill, int level, double xp, CriticalItem criticalItem, ActivitySecondaries secondaries)
	{
		this.icon = Icon;
		this.name = name;
		this.skill = skill;
		this.level = level;
		this.xp = xp;
		this.criticalItem = criticalItem;
		this.secondaries = secondaries == null ? new SecondaryItem[0] : secondaries.getItems();
		this.preventLinked = false;
	}

	Activity(int Icon, String name, Skill skill, int level, double xp, CriticalItem criticalItem, ActivitySecondaries secondaries, boolean preventLinked)
	{
		this.icon = Icon;
		this.name = name;
		this.skill = skill;
		this.level = level;
		this.xp = xp;
		this.criticalItem = criticalItem;
		this.secondaries = secondaries == null ? new SecondaryItem[0] : secondaries.getItems();
		this.preventLinked = preventLinked;
	}

	// Builds a Map to reduce looping frequency
	private static Map<CriticalItem, ArrayList<Activity>> buildItemMap()
	{
		Map<CriticalItem, ArrayList<Activity>> map = new HashMap<>();
		for (Activity item : values())
		{
			map.computeIfAbsent(item.getCriticalItem(), e -> new ArrayList<Activity>()).add(item);
		}

		return map;
	}

	private static final Map<CriticalItem, ArrayList<Activity>> byCriticalItem = buildItemMap();

	public static ArrayList<Activity> getByCriticalItem(CriticalItem item)
	{

		return byCriticalItem.getOrDefault(item, new ArrayList<>());
	}

	/**
	 * Get all Activities for this CriticalItem
	 *
	 * @param item       CriticalItem to check for
	 * @param limitLevel Level to check Activitiy requirements against. -1 or 0 value disables limits
	 * @return an empty list if no activities
	 */
	public static ArrayList<Activity> getByCriticalItem(CriticalItem item, int limitLevel)
	{
		ArrayList<Activity> activities = getByCriticalItem(item);
		ArrayList<Activity> l = new ArrayList<>();
		if (limitLevel <= 0)
		{
			return l;
		}

		for (Activity a : activities)
		{
			if (!(a.getLevel() > limitLevel))
			{
				l.add(a);
			}
		}

		return l;
	}
}
