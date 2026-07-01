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

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.gameval.SpriteID;
import net.runelite.client.game.ItemManager;

@AllArgsConstructor
@Getter
public enum MagicAction implements SkillAction
{
	WIND_STRIKE("Wind Strike", 1, 5.5f, SpriteID.Magicon.WIND_STRIKE, false),
	CONFUSE("Confuse", 3, 13, SpriteID.Magicon.CONFUSE, false),
	ENCHANT_OPAL_BOLT("Enchant Opal Bolt", 4, 9, SpriteID.Magicon2.ENCHANT_CROSSBOW_BOLT, true),
	WATER_STRIKE("Water Strike", 5, 7.5f, SpriteID.Magicon.WATER_STRIKE, false),
	ARCEUUS_LIBRARY_TELEPORT("Arceuus Library Teleport", 6, 10, SpriteID.MagicNecroOn.ARCEUUS_LIBRARY_TELEPORT, true),
	ENCHANT_SAPPHIRE_BOLT("Enchant Sapphire Bolt", 7, 17.5f, SpriteID.Magicon2.ENCHANT_CROSSBOW_BOLT, true),
	ENCHANT_SAPPHIRE_JEWELLERY("Enchant Sapphire Jewellery", 7, 17.5f, SpriteID.Magicon.LVL_1_ENCHANT, false),
	EARTH_STRIKE("Earth Strike", 9, 9.5f, SpriteID.Magicon.EARTH_STRIKE, false),
	WEAKEN("Weaken", 11, 21, SpriteID.Magicon.WEAKEN, false),
	FIRE_STRIKE("Fire Strike", 13, 11.5f, SpriteID.Magicon.FIRE_STRIKE, false),
	ENCHANT_JADE_BOLT("Enchant Jade Bolt", 14, 19, SpriteID.Magicon2.ENCHANT_CROSSBOW_BOLT, true),
	BONES_TO_BANANAS("Bones To Bananas", 15, 25, SpriteID.Magicon.BONES_TO_BANANAS, false),
	BASIC_REANIMATION("Basic Reanimation", 16, 32, SpriteID.MagicNecroOn.BASIC_REANIMATION, true),
	WIND_BOLT("Wind Bolt", 17, 13.5f, SpriteID.Magicon.WIND_BOLT, false),
	DRAYNOR_MANOR_TELEPORT("Draynor Manor Teleport", 17, 16, SpriteID.MagicNecroOn.DRAYNOR_MANOR_TELEPORT, true),
	CURSE("Curse", 19, 29, SpriteID.Magicon.CURSE, false),
	BIND("Bind", 20, 30, SpriteID.Magicon2.BIND, false),
	LOW_LEVEL_ALCHEMY("Low Level Alchemy", 21, 31, SpriteID.Magicon.LOW_LEVEL_ALCHEMY, false),
	WATER_BOLT("Water Bolt", 23, 16.5f, SpriteID.Magicon.WATER_BOLT, false),
	ENCHANT_PEARL_BOLT("Enchant Pearl Bolt", 24, 29, SpriteID.Magicon2.ENCHANT_CROSSBOW_BOLT, true),
	VARROCK_TELEPORT("Varrock Teleport", 25, 35, SpriteID.Magicon.VARROCK_TELEPORT, false),
	ENCHANT_EMERALD_BOLT("Enchant Emerald Bolt", 27, 37, SpriteID.Magicon2.ENCHANT_CROSSBOW_BOLT, true),
	ENCHANT_EMERALD_JEWELLERY("Enchant Emerald Jewellery", 27, 37, SpriteID.Magicon.LVL_2_ENCHANT, false),
	MIND_ALTAR_TELEPORT("Mind Altar Teleport", 28, 22, SpriteID.MagicNecroOn.MIND_ALTAR_TELEPORT, true),
	EARTH_BOLT("Earth Bolt", 29, 19.5f, SpriteID.Magicon.EARTH_BOLT, false),
	ENCHANT_TOPAZ_BOLT("Enchant Topaz Bolt", 29, 33, SpriteID.Magicon2.ENCHANT_CROSSBOW_BOLT, true),
	LUMBRIDGE_TELEPORT("Lumbridge Teleport", 31, 41, SpriteID.Magicon.LUMBRIDGE_TELEPORT, false),
	TELEKINETIC_GRAB("Telekinetic Grab", 33, 43, SpriteID.Magicon.TELEKINETIC_GRAB, false),
	RESPAWN_TELEPORT("Respawn Teleport", 34, 27, SpriteID.MagicNecroOn.RESPAWN_TELEPORT, true),
	FIRE_BOLT("Fire Bolt", 35, 22.5f, SpriteID.Magicon.FIRE_BOLT, false),
	GHOSTLY_GRASP("Ghostly Grasp", 35, 22.5f, SpriteID.MagicNecroOn.GHOSTLY_GRASP, true),
	FALADOR_TELEPORT("Falador Teleport", 37, 48, SpriteID.Magicon.FALADOR_TELEPORT, false),
	RESURRECT_LESSER_THRALL("Resurrect Lesser Thrall", 38, 55, SpriteID.MagicNecroOn.RESURRECT_LESSER_GHOST, true),
	CRUMBLE_UNDEAD("Crumble Undead", 39, 24.5f, SpriteID.Magicon.CRUMBLE_UNDEAD, false),
	SALVE_GRAVEYARD_TELEPORT("Salve Graveyard Teleport", 40, 30, SpriteID.MagicNecroOn.SALVE_GRAVEYARD_TELEPORT, true),
	TELEPORT_TO_HOUSE("Teleport To House", 40, 30, SpriteID.Magicon2.TELEPORT_TO_HOUSE, true),
	WIND_BLAST("Wind Blast", 41, 25.5f, SpriteID.Magicon.WIND_BLAST, false),
	ADEPT_REANIMATION("Adept Reanimation", 41, 80, SpriteID.MagicNecroOn.ADEPT_REANIMATION, true),
	SUPERHEAT_ITEM("Superheat Item", 43, 53, SpriteID.Magicon.SUPERHEAT_ITEM, false),
	INFERIOR_DEMONBANE("Inferior Demonbane", 44, 27, SpriteID.MagicNecroOn.INFERIOR_DEMONBANE, true),
	CAMELOT_TELEPORT("Camelot Teleport", 45, 55.5f, SpriteID.Magicon.CAMELOT_TELEPORT, true),
	WATER_BLAST("Water Blast", 47, 28.5f, SpriteID.Magicon.WATER_BLAST, false),
	SHADOW_VEIL("Shadow Veil", 47, 58, SpriteID.MagicNecroOn.SHADOW_VEIL, true),
	FENKENSTRAINS_CASTLE_TELEPORT("Fenkenstrain's Castle Teleport", 48, 50, SpriteID.MagicNecroOn.FENKENSTRAINS_CASTLE_TELEPORT, true),
	KOUREND_CASTLE_TELEPORT("Kourend Castle Teleport", 48, 58, SpriteID.Magicon2.TELEPORT_TO_KOUREND, true),
	ENCHANT_RUBY_BOLT("Enchant Ruby Bolt", 49, 59, SpriteID.Magicon2.ENCHANT_CROSSBOW_BOLT, true),
	ENCHANT_RUBY_JEWELLERY("Enchant Ruby Jewellery", 49, 59, SpriteID.Magicon.LVL_3_ENCHANT, false),
	IBAN_BLAST("Iban Blast", 50, 30, SpriteID.Magicon.IBAN_BLAST, true),
	MAGIC_DART("Magic Dart", 50, 30, SpriteID.Magicon2.MAGIC_DART, true),
	SMOKE_RUSH("Smoke Rush", 50, 30, SpriteID.Magicon2.SMOKE_RUSH, true),
	DARK_LURE("Dark Lure", 50, 60, SpriteID.MagicNecroOn.DARK_LURE, true),
	SNARE("Snare", 50, 60, SpriteID.Magicon2.SNARE, false),
	ARDOUGNE_TELEPORT("Ardougne Teleport", 51, 61, SpriteID.Magicon.ARDOUGNE_TELEPORT, true),
	SHADOW_RUSH("Shadow Rush", 52, 31, SpriteID.Magicon2.SHADOW_RUSH, true),
	EARTH_BLAST("Earth Blast", 53, 31.5f, SpriteID.Magicon.EARTH_BLAST, false),
	CIVITAS_ILLA_FORTIS_TELEPORT("Civitas illa Fortis Teleport", 54, 64, SpriteID.Magicon2.CIVITAS_ILLA_FORTIS_TELEPORT, true),
	PADDEWWA_TELEPORT("Paddewwa Teleport", 54, 64, SpriteID.Magicon2.PADDEWWA_TELEPORT, true),
	HIGH_LEVEL_ALCHEMY("High Level Alchemy", 55, 65, SpriteID.Magicon.HIGH_LEVEL_ALCHEMY, false),
	BLOOD_RUSH("Blood Rush", 56, 33, SpriteID.Magicon2.BLOOD_RUSH, true),
	SKELETAL_GRASP("Skeletal Grasp", 56, 33, SpriteID.MagicNecroOn.SKELETAL_GRASP, true),
	CHARGE_WATER_ORB("Charge Water Orb", 56, 66, SpriteID.Magicon.CHARGE_WATER_ORB, true),
	ENCHANT_DIAMOND_BOLT("Enchant Diamond Bolt", 57, 67, SpriteID.Magicon2.ENCHANT_CROSSBOW_BOLT, true),
	ENCHANT_DIAMOND_JEWELLERY("Enchant Diamond Jewellery", 57, 67, SpriteID.Magicon.LVL_4_ENCHANT, false),
	RESURRECT_SUPERIOR_THRALL("Resurrect Superior Thrall", 57, 70, SpriteID.MagicNecroOn.RESURRECT_SUPERIOR_SKELETON, true),
	ICE_RUSH("Ice Rush", 58, 34, SpriteID.Magicon2.ICE_RUSH, true),
	WATCHTOWER_TELEPORT("Watchtower Teleport", 58, 68, SpriteID.Magicon.WATCHTOWER_TELEPORT, true),
	FIRE_BLAST("Fire Blast", 59, 34.5f, SpriteID.Magicon.FIRE_BLAST, false),
	MARK_OF_DARKNESS("Mark of Darkness", 59, 70, SpriteID.MagicNecroOn.MARK_OF_DARKNESS, true),
	CLAWS_OF_GUTHIX("Claws Of Guthix", 60, 35, SpriteID.Magicon.CLAWS_OF_GUTHIX, true),
	FLAMES_OF_ZAMORAK("Flames Of Zamorak", 60, 35, SpriteID.Magicon.FLAMES_OF_ZAMORAK, true),
	SARADOMIN_STRIKE("Saradomin Strike", 60, 35, SpriteID.Magicon.SARADOMIN_STRIKE, true),
	BONES_TO_PEACHES("Bones To Peaches", 60, 35.5f, SpriteID.Magicon2.BONES_TO_PEACHES, true),
	CHARGE_EARTH_ORB("Charge Earth Orb", 60, 70, SpriteID.Magicon.CHARGE_EARTH_ORB, true),
	SENNTISTEN_TELEPORT("Senntisten Teleport", 60, 70, SpriteID.Magicon2.SENNTISTEN_TELEPORT, true),
	TROLLHEIM_TELEPORT("Trollheim Teleport", 61, 68, SpriteID.Magicon2.TROLLHEIM_TELEPORT, true),
	WEST_ARDOUGNE_TELEPORT("West Ardougne Teleport", 61, 68, SpriteID.MagicNecroOn.WEST_ARDOUGNE_TELEPORT, true),
	SMOKE_BURST("Smoke Burst", 62, 36, SpriteID.Magicon2.SMOKE_BURST, true),
	SUPERIOR_DEMONBANE("Superior Demonbane", 62, 36, SpriteID.MagicNecroOn.SUPERIOR_DEMONBANE, true),
	WIND_WAVE("Wind Wave", 62, 36, SpriteID.Magicon.WIND_WAVE, true),
	CHARGE_FIRE_ORB("Charge Fire Orb", 63, 73, SpriteID.Magicon.CHARGE_FIRE_ORB, true),
	SHADOW_BURST("Shadow Burst", 64, 37, SpriteID.Magicon2.SHADOW_BURST, true),
	TELEPORT_APE_ATOLL("Teleport Ape Atoll", 64, 74, SpriteID.Magicon2.TELEPORT_TO_APE_ATOLL, true),
	LESSER_CORRUPTION("Lesser Corruption", 64, 75, SpriteID.MagicNecroOn.LESSER_CORRUPTION, true),
	WATER_WAVE("Water Wave", 65, 37.5f, SpriteID.Magicon.WATER_WAVE, true),
	BAKE_PIE("Bake Pie", 65, 60, SpriteID.LunarMagicOn.BAKE_PIE, true),
	GEOMANCY("Geomancy", 65, 60, SpriteID.LunarMagicOn.GEOMANCY, true),
	HARMONY_ISLAND_TELEPORT("Harmony Island Teleport", 65, 74, SpriteID.MagicNecroOn.HARMONY_ISLAND_TELEPORT, true),
	CURE_PLANT("Cure Plant", 66, 60, SpriteID.LunarMagicOn.CURE_PLANT, true),
	MONSTER_EXAMINE("Monster Examine", 66, 61, SpriteID.LunarMagicOn.MONSTER_EXAMINE, true),
	CHARGE_AIR_ORB("Charge Air Orb", 66, 76, SpriteID.Magicon.CHARGE_AIR_ORB, true),
	KHARYRLL_TELEPORT("Kharyrll Teleport", 66, 76, SpriteID.Magicon2.KHARYRLL_TELEPORT, true),
	VILE_VIGOUR("Vile Vigour", 66, 76, SpriteID.MagicNecroOn.VILE_VIGOUR, true),
	VULNERABILITY("Vulnerability", 66, 76, SpriteID.Magicon.VULNERABILITY, true),
	NPC_CONTACT("Npc Contact", 67, 63, SpriteID.LunarMagicOn.NPC_CONTACT, true),
	BLOOD_BURST("Blood Burst", 68, 39, SpriteID.Magicon2.BLOOD_BURST, true),
	CURE_OTHER("Cure Other", 68, 65, SpriteID.LunarMagicOn.CURE_OTHER, true),
	HUMIDIFY("Humidify", 68, 65, SpriteID.LunarMagicOn.HUMIDIFY, true),
	ENCHANT_DRAGONSTONE_BOLT("Enchant Dragonstone Bolt", 68, 78, SpriteID.Magicon2.ENCHANT_CROSSBOW_BOLT, true),
	ENCHANT_DRAGONSTONE_JEWELLERY("Enchant Dragonstone Jewellery", 68, 78, SpriteID.Magicon.LVL_5_ENCHANT, true),
	MOONCLAN_TELEPORT("Moonclan Teleport", 69, 66, SpriteID.LunarMagicOn.MOONCLAN_TELEPORT, true),
	EARTH_WAVE("Earth Wave", 70, 40, SpriteID.Magicon.EARTH_WAVE, true),
	ICE_BURST("Ice Burst", 70, 40, SpriteID.Magicon2.ICE_BURST, true),
	TELE_GROUP_MOONCLAN("Tele Group Moonclan", 70, 67, SpriteID.LunarMagicOn.TELE_GROUP_MOONCLAN, true),
	DEGRIME("Degrime", 70, 83, SpriteID.MagicNecroOn.DEGRIME, true),
	CURE_ME("Cure Me", 71, 69, SpriteID.LunarMagicOn.CURE_ME, true),
	OURANIA_TELEPORT("Ourania Teleport", 71, 69, SpriteID.LunarMagicOn.OURANIA_TELEPORT, true),
	HUNTER_KIT("Hunter Kit", 71, 70, SpriteID.LunarMagicOn.HUNTER_KIT, true),
	CEMETERY_TELEPORT("Cemetery Teleport", 71, 82, SpriteID.MagicNecroOn.CEMETERY_TELEPORT, true),
	WATERBIRTH_TELEPORT("Waterbirth Teleport", 72, 71, SpriteID.LunarMagicOn.WATERBIRTH_TELEPORT, true),
	LASSAR_TELEPORT("Lassar Teleport", 72, 82, SpriteID.Magicon2.LASSAR_TELEPORT, true),
	EXPERT_REANIMATION("Expert Reanimation", 72, 138, SpriteID.MagicNecroOn.EXPERT_REANIMATION, true),
	TELE_GROUP_WATERBIRTH("Tele Group Waterbirth", 73, 72, SpriteID.LunarMagicOn.TELE_GROUP_WATERBIRTH, true),
	ENFEEBLE("Enfeeble", 73, 83, SpriteID.Magicon.ENFEEBLE, true),
	WARD_OF_ARCEUUS("Ward of Arceuus", 73, 83, SpriteID.MagicNecroOn.WARD_OF_ARCEUUS, true),
	SMOKE_BLITZ("Smoke Blitz", 74, 42, SpriteID.Magicon2.SMOKE_BLITZ, true),
	CURE_GROUP("Cure Group", 74, 74, SpriteID.LunarMagicOn.CURE_GROUP, true),
	TELEOTHER_LUMBRIDGE("Teleother Lumbridge", 74, 84, SpriteID.Magicon2.TELEOTHER_LUMBRIDGE, true),
	FIRE_WAVE("Fire Wave", 75, 42.5f, SpriteID.Magicon.FIRE_WAVE, true),
	BARBARIAN_TELEPORT("Barbarian Teleport", 75, 76, SpriteID.LunarMagicOn.BARBARIAN_TELEPORT, true),
	STAT_SPY("Stat Spy", 75, 76, SpriteID.LunarMagicOn.STAT_SPY, true),
	SHADOW_BLITZ("Shadow Blitz", 76, 43, SpriteID.Magicon2.SHADOW_BLITZ, true),
	SPIN_FLAX("Spin Flax", 76, 75, SpriteID.LunarMagicOn.SPIN_FLAX, true),
	TELE_GROUP_BARBARIAN("Tele Group Barbarian", 76, 77, SpriteID.LunarMagicOn.TELE_GROUP_ICE_PLATEAU, true),
	RESURRECT_GREATER_THRALL("Resurrect Greater Thrall", 76, 88, SpriteID.MagicNecroOn.RESURRECT_GREATER_ZOMBIE, true),
	SUPERGLASS_MAKE("Superglass Make", 77, 78, SpriteID.LunarMagicOn.SUPERGLASS_MAKE, true),
	KHAZARD_TELEPORT("Khazard Teleport", 78, 80, SpriteID.LunarMagicOn.KHAZARD_TELEPORT, true),
	TAN_LEATHER("Tan Leather", 78, 81, SpriteID.LunarMagicOn.TAN_LEATHER, true),
	DAREEYAK_TELEPORT("Dareeyak Teleport", 78, 88, SpriteID.Magicon2.DAREEYAK_TELEPORT, true),
	RESURRECT_CROPS("Resurrect Crops", 78, 90, SpriteID.MagicNecroOn.RESURRECT_CROPS, true),
	UNDEAD_GRASP("Undead Grasp", 79, 46.5f, SpriteID.MagicNecroOn.UNDEAD_GRASP, true),
	TELE_GROUP_KHAZARD("Tele Group Khazard", 79, 81, SpriteID.LunarMagicOn.TELE_GROUP_KHAZARD, true),
	DREAM("Dream", 79, 82, SpriteID.LunarMagicOn.DREAM, true),
	ENTANGLE("Entangle", 79, 89, SpriteID.Magicon2.ENTANGLE, true),
	BLOOD_BLITZ("Blood Blitz", 80, 45, SpriteID.Magicon2.BLOOD_BLITZ, true),
	STRING_JEWELLERY("String Jewellery", 80, 83, SpriteID.LunarMagicOn.STRING_JEWELLERY, true),
	DEATH_CHARGE("Death Charge", 80, 90, SpriteID.MagicNecroOn.DEATH_CHARGE, true),
	STUN("Stun", 80, 90, SpriteID.Magicon.STUN, true),
	CHARGE("Charge", 80, 180, SpriteID.Magicon2.CHARGE, true),
	WIND_SURGE("Wind Surge", 81, 44.5f, SpriteID.Magicon2.WIND_SURGE, true),
	STAT_RESTORE_POT_SHARE("Stat Restore Pot Share", 81, 84, SpriteID.LunarMagicOn.STAT_RESTORE_POT_SHARE, true),
	DARK_DEMONBANE("Dark Demonbane", 82, 43.5f, SpriteID.MagicNecroOn.DARK_DEMONBANE, true),
	ICE_BLITZ("Ice Blitz", 82, 46, SpriteID.Magicon2.ICE_BLITZ, true),
	MAGIC_IMBUE("Magic Imbue", 82, 86, SpriteID.LunarMagicOn.MAGIC_IMBUE, true),
	TELEOTHER_FALADOR("Teleother Falador", 82, 92, SpriteID.Magicon2.TELEOTHER_FALADOR, true),
	FERTILE_SOIL("Fertile Soil", 83, 87, SpriteID.LunarMagicOn.FERTILE_SOIL, true),
	BARROWS_TELEPORT("Barrows Teleport", 83, 90, SpriteID.MagicNecroOn.BARROWS_TELEPORT, true),
	CARRALLANGER_TELEPORT("Carrallanger Teleport", 84, 82, SpriteID.Magicon2.CARRALLANGAR_TELEPORT, true),
	BOOST_POTION_SHARE("Boost Potion Share", 84, 88, SpriteID.LunarMagicOn.BOOST_POTION_SHARE, true),
	DEMONIC_OFFERING("Demonic Offering", 84, 175, SpriteID.MagicNecroOn.DEMONIC_OFFERING, true),
	TELEPORT_TO_TARGET("Teleport To Target", 85, 45, SpriteID.Magicon2.TELEPORT_TO_BOUNTY_TARGET, true),
	WATER_SURGE("Water Surge", 85, 46.5f, SpriteID.Magicon2.WATER_SURGE, true),
	TELE_BLOCK("Tele Block", 85, 80, SpriteID.Magicon2.TELE_BLOCK, false),
	FISHING_GUILD_TELEPORT("Fishing Guild Teleport", 85, 89, SpriteID.LunarMagicOn.FISHING_GUILD_TELEPORT, true),
	GREATER_CORRUPTION("Greater Corruption", 85, 95, SpriteID.MagicNecroOn.GREATER_CORRUPTION, true),
	SMOKE_BARRAGE("Smoke Barrage", 86, 48, SpriteID.Magicon2.SMOKE_BARRAGE, true),
	PLANK_MAKE("Plank Make", 86, 90, SpriteID.LunarMagicOn.PLANK_MAKE, true),
	TELE_GROUP_FISHING_GUILD("Tele Group Fishing Guild", 86, 90, SpriteID.LunarMagicOn.TELE_GROUP_FISHING_GUILD, true),
	CATHERBY_TELEPORT("Catherby Teleport", 87, 92, SpriteID.LunarMagicOn.CATHERBY_TELEPORT, true),
	ENCHANT_ONYX_BOLT("Enchant Onyx Bolt", 87, 97, SpriteID.Magicon2.ENCHANT_CROSSBOW_BOLT, true),
	ENCHANT_ONYX_JEWELLERY("Enchant Onyx Jewellery", 87, 97, SpriteID.Magicon2.LVL_6_ENCHANT, true),
	SHADOW_BARRAGE("Shadow Barrage", 88, 48, SpriteID.Magicon2.SHADOW_BARRAGE, true),
	TELE_GROUP_CATHERBY("Tele Group Catherby", 88, 93, SpriteID.LunarMagicOn.TELE_GROUP_CATHERBY, true),
	ICE_PLATEAU_TELEPORT("Ice Plateau Teleport", 89, 96, SpriteID.LunarMagicOn.ICE_PLATEAU_TELEPORT, true),
	RECHARGE_DRAGONSTONE("Recharge Dragonstone", 89, 97.5f, SpriteID.LunarMagicOn.RECHARGE_DRAGONSTONE, true),
	EARTH_SURGE("Earth Surge", 90, 48.5f, SpriteID.Magicon2.EARTH_SURGE, true),
	TELE_GROUP_ICE_PLATEAU("Tele Group Ice Plateau", 90, 99, SpriteID.LunarMagicOn.TELE_GROUP_ICE_PLATEAU, true),
	ANNAKARL_TELEPORT("Annakarl Teleport", 90, 100, SpriteID.Magicon2.ANNAKARL_TELEPORT, true),
	APE_ATOLL_TELEPORT("Ape Atoll Teleport", 90, 100, SpriteID.MagicNecroOn.APE_ATOLL_TELEPORT, true),
	TELEOTHER_CAMELOT("Teleother Camelot", 90, 100, SpriteID.Magicon2.TELEOTHER_CAMELOT, true),
	MASTER_REANIMATION("Master Reanimation", 90, 170, SpriteID.MagicNecroOn.MASTER_REANIMATION, true),
	ENERGY_TRANSFER("Energy Transfer", 91, 100, SpriteID.LunarMagicOn.ENERGY_TRANSFER, true),
	BLOOD_BARRAGE("Blood Barrage", 92, 51, SpriteID.Magicon2.BLOOD_BARRAGE, true),
	HEAL_OTHER("Heal Other", 92, 101, SpriteID.LunarMagicOn.HEAL_OTHER, true),
	SINISTER_OFFERING("Sinister Offering", 92, 180, SpriteID.MagicNecroOn.SINISTER_OFFERING, true),
	VENGEANCE_OTHER("Vengeance Other", 93, 108, SpriteID.LunarMagicOn.VENGEANCE_OTHER, true),
	ENCHANT_ZENYTE_JEWELLERY("Enchant Zenyte Jewellery", 93, 110, SpriteID.Magicon2.LVL_7_ENCHANT, true),
	ICE_BARRAGE("Ice Barrage", 94, 52, SpriteID.Magicon2.ICE_BARRAGE, true),
	VENGEANCE("Vengeance", 94, 112, SpriteID.LunarMagicOn.VENGEANCE, true),
	FIRE_SURGE("Fire Surge", 95, 50.5f, SpriteID.Magicon2.FIRE_SURGE, true),
	HEAL_GROUP("Heal Group", 95, 124, SpriteID.LunarMagicOn.HEAL_GROUP, true),
	GHORROCK_TELEPORT("Ghorrock Teleport", 96, 106, SpriteID.Magicon2.GHORROCK_TELEPORT, true),
	SPELLBOOK_SWAP("Spellbook Swap", 96, 130, SpriteID.LunarMagicOn.SPELLBOOK_SWAP, true),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final int sprite;
	private final boolean isMembers;

	@Override
	public String getName(final ItemManager itemManager)
	{
		return getName();
	}

	@Override
	public boolean isMembers(final ItemManager itemManager)
	{
		return isMembers();
	}
}
