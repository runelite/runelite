/*
 * Copyright (c) 2016-2017, Abel Briggs
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
package net.runelite.api;

/**
 * Utility class used for mapping animation IDs.
 * <p>
 * Note: This class is not complete and may not contain a specific animation
 * required.
 */
public final class AnimationID
{
	public static final int IDLE = -1;
	public static final int HERBLORE_PESTLE_AND_MORTAR = 364;
	public static final int WOODCUTTING_BRONZE = 879;
	public static final int WOODCUTTING_IRON = 877;
	public static final int WOODCUTTING_STEEL = 875;
	public static final int WOODCUTTING_BLACK = 873;
	public static final int WOODCUTTING_MITHRIL = 871;
	public static final int WOODCUTTING_ADAMANT = 869;
	public static final int WOODCUTTING_RUNE = 867;
	public static final int WOODCUTTING_DRAGON = 2846;
	public static final int WOODCUTTING_INFERNAL = 2117;
	public static final int WOODCUTTING_3A_AXE = 7264;
	public static final int WOODCUTTING_CRYSTAL = 8324;
	public static final int CONSUMING = 829; // consuming consumables
	public static final int FIREMAKING = 733;
	public static final int DEATH = 836;
	public static final int COOKING_FIRE = 897;
	public static final int COOKING_RANGE = 896;
	public static final int COOKING_WINE = 7529;
	public static final int FLETCHING_BOW_CUTTING = 1248;
	public static final int HUNTER_LAY_BOXTRAP_BIRDSNARE = 5208; //same for laying bird snares and box traps
	public static final int HUNTER_LAY_DEADFALLTRAP = 5212; //setting up deadfall trap
	public static final int HUNTER_LAY_NETTRAP = 5215; //setting up net trap
	public static final int HUNTER_LAY_MANIACAL_MONKEY_BOULDER_TRAP = 7259; // setting up maniacal monkey boulder trap
	public static final int HUNTER_CHECK_BIRD_SNARE = 5207;
	public static final int HUNTER_CHECK_BOX_TRAP = 5212;
	public static final int HERBLORE_MAKE_TAR = 5249;
	public static final int FLETCHING_STRING_NORMAL_SHORTBOW = 6678;
	public static final int FLETCHING_STRING_NORMAL_LONGBOW = 6684;
	public static final int FLETCHING_STRING_OAK_SHORTBOW = 6679;
	public static final int FLETCHING_STRING_OAK_LONGBOW = 6685;
	public static final int FLETCHING_STRING_WILLOW_SHORTBOW = 6680;
	public static final int FLETCHING_STRING_WILLOW_LONGBOW = 6686;
	public static final int FLETCHING_STRING_MAPLE_SHORTBOW = 6681;
	public static final int FLETCHING_STRING_MAPLE_LONGBOW = 6687;
	public static final int FLETCHING_STRING_YEW_SHORTBOW = 6682;
	public static final int FLETCHING_STRING_YEW_LONGBOW = 6688;
	public static final int FLETCHING_STRING_MAGIC_SHORTBOW = 6683;
	public static final int FLETCHING_STRING_MAGIC_LONGBOW = 6689;
	public static final int FLETCHING_ATTACH_FEATHERS_TO_ARROWSHAFT = 8481;
	public static final int FLETCHING_ATTACH_HEADS = 8480;
	public static final int GEM_CUTTING_OPAL = 890;
	public static final int GEM_CUTTING_JADE = 891;
	public static final int GEM_CUTTING_REDTOPAZ = 892;
	public static final int GEM_CUTTING_SAPPHIRE = 888;
	public static final int GEM_CUTTING_EMERALD = 889;
	public static final int GEM_CUTTING_RUBY = 887;
	public static final int GEM_CUTTING_DIAMOND = 886;
	public static final int GEM_CUTTING_AMETHYST = 6295;
	public static final int CRAFTING_LEATHER = 1249;
	public static final int CRAFTING_GLASSBLOWING = 884;
	public static final int CRAFTING_SPINNING = 894;
	public static final int CRAFTING_POTTERS_WHEEL = 883;
	public static final int CRAFTING_POTTERY_OVEN = 24975;
	public static final int SMITHING_SMELTING = 899;
	public static final int SMITHING_CANNONBALL = 827; //cball smithing uses this and SMITHING_SMELTING
	public static final int SMITHING_ANVIL = 898;
	public static final int FISHING_BIG_NET = 620;
	public static final int FISHING_NET = 621;
	public static final int FISHING_POLE_CAST = 623; // pole is in the water
	public static final int FISHING_CAGE = 619;
	public static final int FISHING_HARPOON = 618;
	public static final int FISHING_BARBTAIL_HARPOON = 5108;
	public static final int FISHING_DRAGON_HARPOON = 7401;
	public static final int FISHING_INFERNAL_HARPOON = 7402;
	public static final int FISHING_CRYSTAL_HARPOON = 8336;
	public static final int FISHING_OILY_ROD = 622;
	public static final int FISHING_KARAMBWAN = 1193;
	public static final int FISHING_CRUSHING_INFERNAL_EELS = 7553;
	public static final int FISHING_CUTTING_SACRED_EELS = 7151;
	public static final int FISHING_BAREHAND = 6709;
	public static final int MINING_BRONZE_PICKAXE = 625;
	public static final int MINING_IRON_PICKAXE = 626;
	public static final int MINING_STEEL_PICKAXE = 627;
	public static final int MINING_BLACK_PICKAXE = 3873;
	public static final int MINING_MITHRIL_PICKAXE = 629;
	public static final int MINING_ADAMANT_PICKAXE = 628;
	public static final int MINING_RUNE_PICKAXE = 624;
	public static final int MINING_DRAGON_PICKAXE = 7139;
	public static final int MINING_DRAGON_PICKAXE_UPGRADED = 642;
	public static final int MINING_DRAGON_PICKAXE_OR = 8346;
	public static final int MINING_INFERNAL_PICKAXE = 4482;
	public static final int MINING_3A_PICKAXE = 7283;
	public static final int MINING_CRYSTAL_PICKAXE = 8347;
	public static final int MINING_MOTHERLODE_BRONZE = 6753;
	public static final int MINING_MOTHERLODE_IRON = 6754;
	public static final int MINING_MOTHERLODE_STEEL = 6755;
	public static final int MINING_MOTHERLODE_BLACK = 3866;
	public static final int MINING_MOTHERLODE_MITHRIL = 6757;
	public static final int MINING_MOTHERLODE_ADAMANT = 6756;
	public static final int MINING_MOTHERLODE_RUNE = 6752;
	public static final int MINING_MOTHERLODE_DRAGON = 6758;
	public static final int MINING_MOTHERLODE_DRAGON_UPGRADED = 335;
	public static final int MINING_MOTHERLODE_DRAGON_OR = 8344;
	public static final int MINING_MOTHERLODE_INFERNAL = 4481;
	public static final int MINING_MOTHERLODE_3A = 7282;
	public static final int MINING_MOTHERLODE_CRYSTAL = 8345;
	public static final int DENSE_ESSENCE_CHIPPING = 7201;
	public static final int DENSE_ESSENCE_CHISELING = 7202;
	public static final int HERBLORE_POTIONMAKING = 363; //used for both herb and secondary
	public static final int MAGIC_CHARGING_ORBS = 726;
	public static final int MAGIC_MAKE_TABLET = 4068;
	public static final int MAGIC_ENCHANTING_JEWELRY = 931;
	public static final int MAGIC_ENCHANTING_AMULET_1 = 719; // sapphire, opal, diamond
	public static final int MAGIC_ENCHANTING_AMULET_2 = 720; // emerald, jade, dragonstone
	public static final int MAGIC_ENCHANTING_AMULET_3 = 721; // ruby, topaz, onyx, zenyte
	public static final int BURYING_BONES = 827;
	public static final int USING_GILDED_ALTAR = 3705;
	public static final int LOOKING_INTO = 832;
	public static final int DIG = 830;
	public static final int DEMONIC_GORILLA_MAGIC_ATTACK = 7225;
	public static final int DEMONIC_GORILLA_MELEE_ATTACK = 7226;
	public static final int DEMONIC_GORILLA_RANGED_ATTACK = 7227;
	public static final int DEMONIC_GORILLA_AOE_ATTACK = 7228;
	public static final int DEMONIC_GORILLA_PRAYER_SWITCH = 7228;
	public static final int DEMONIC_GORILLA_DEFEND = 7224;
	public static final int BOOK_HOME_TELEPORT_1 = 4847;
	public static final int BOOK_HOME_TELEPORT_2 = 4850;
	public static final int BOOK_HOME_TELEPORT_3 = 4853;
	public static final int BOOK_HOME_TELEPORT_4 = 4855;
	public static final int BOOK_HOME_TELEPORT_5 = 4857;
	public static final int COW_HOME_TELEPORT_1 = 1696;
	public static final int COW_HOME_TELEPORT_2 = 1697;
	public static final int COW_HOME_TELEPORT_3 = 1698;
	public static final int COW_HOME_TELEPORT_4 = 1699;
	public static final int COW_HOME_TELEPORT_5 = 1700;
	public static final int COW_HOME_TELEPORT_6 = 1701;
	public static final int CONSTRUCTION = 3676;
	public static final int SAND_COLLECTION = 895;
	public static final int PISCARILIUS_CRANE_REPAIR = 7199;
	public static final int HOME_MAKE_TABLET = 4067;
	public static final int THIEVING_STALL = 832;
	public static final int PICKPOCKET_SUCCESS = 881;

	//block animations for players and perhaps npcs as well?
	public static final int BLOCK_DEFENDER = 4177;
	public static final int BLOCK_NO_SHIELD = 420;
	public static final int BLOCK_SHIELD = 1156;
	public static final int BLOCK_SWORD = 388;
	public static final int BLOCK_UNARMED = 424; // Same Animation as failed pickpocked
	public static final int DRAGONFIRE_SHIELD_SPECIAL = 6696;

	// NPC animations
	public static final int TZTOK_JAD_RANGE_ATTACK = 2652;
	public static final int TZTOK_JAD_MELEE_ATTACK = 2655;
	public static final int TZTOK_JAD_MAGIC_ATTACK = 2656;
	public static final int TOK_XIL_RANGE_ATTACK = 2633;
	public static final int TOK_XIL_MELEE_ATTACK = 2628;
	public static final int KET_ZEK_MELEE_ATTACK = 2644;
	public static final int KET_ZEK_MAGE_ATTACK = 2647;
	public static final int MEJ_KOT_MELEE_ATTACK = 2637;
	public static final int MEJ_KOT_HEAL_ATTACK = 2639;
	public static final int HELLHOUND_DEFENCE = 6566;
	public static final int VORKATH_WAKE_UP = 7950;
	public static final int VORKATH_DEATH = 7949;
	public static final int VORKATH_SLASH_ATTACK = 7951;
	public static final int VORKATH_ATTACK = 7952;
	public static final int VORKATH_FIRE_BOMB_OR_SPAWN_ATTACK = 7960;
	public static final int VORKATH_ACID_ATTACK = 7957;
	public static final int BLACKJACK_KO = 838;
	public static final int VETION_EARTHQUAKE = 5507;
	public static final int ZULRAH_DEATH = 5804;
	public static final int ZULRAH_PHASE = 5072;

	// Farming
	public static final int FARMING_HARVEST_FRUIT_TREE = 2280;
	public static final int FARMING_HARVEST_BUSH = 2281;
	public static final int FARMING_HARVEST_HERB = 2282;
	public static final int FARMING_USE_COMPOST = 2283;
	public static final int FARMING_CURE_WITH_POTION = 2288;
	public static final int FARMING_PLANT_SEED = 2291;
	public static final int FARMING_HARVEST_FLOWER = 2292;
	public static final int FARMING_MIX_ULTRACOMPOST = 7699;
	public static final int FARMING_HARVEST_ALLOTMENT = 830;

	// Lunar spellbook
	public static final int ENERGY_TRANSFER_VENGEANCE_OTHER = 4411;
	public static final int MAGIC_LUNAR_SHARED = 4413; // Utilized by Fertile Soil, Boost/Stat Potion Share, NPC Contact, Bake Pie
	public static final int MAGIC_LUNAR_CURE_PLANT = 4432;
	public static final int MAGIC_LUNAR_GEOMANCY = 7118;
	public static final int MAGIC_LUNAR_PLANK_MAKE = 6298;
	public static final int MAGIC_LUNAR_STRING_JEWELRY = 4412;

	// Arceuus spellbook
	public static final int MAGIC_ARCEUUS_RESURRECT_CROPS = 7118;

	// Battlestaff Crafting
	public static final int CRAFTING_BATTLESTAVES = 7531;

	// Death Animations
	public static final int CAVE_KRAKEN_DEATH = 3993;
	public static final int WIZARD_DEATH = 2553;
	public static final int GARGOYLE_DEATH = 1520;
	public static final int MARBLE_GARGOYLE_DEATH = 7813;
	public static final int LIZARD_DEATH = 2778;
	public static final int ROCKSLUG_DEATH = 1568;
	public static final int ZYGOMITE_DEATH = 3327;
	public static final int IMP_DEATH = 172;

	// POH Animations
	public static final int INCENSE_BURNER = 3687;
	public static final int LOW_LEVEL_MAGIC_ATTACK = 1162;
	public static final int HIGH_LEVEL_MAGIC_ATTACK = 1167;
	public static final int BLOWPIPE_ATTACK = 5061;

	// Tekton
	public static final int TEKTON_ANVIL = 7475;
	public static final int TEKTON_AUTO1 = 7482;
	public static final int TEKTON_AUTO2 = 7483;
	public static final int TEKTON_AUTO3 = 7484;
	public static final int TEKTON_FAST_AUTO1 = 7478;
	public static final int TEKTON_FAST_AUTO2 = 7488;
	public static final int TEKTON_ENRAGE_AUTO1 = 7492;
	public static final int TEKTON_ENRAGE_AUTO2 = 7493;
	public static final int TEKTON_ENRAGE_AUTO3 = 7494;

	// Hydra
	public static final int HYDRA_POISON_1 = 8234;
	public static final int HYDRA_RANGED_1 = 8235;
	public static final int HYDRA_MAGIC_1 = 8236;
	public static final int HYDRA_1_1 = 8237;
	public static final int HYDRA_1_2 = 8238;
	public static final int HYDRA_LIGHTNING = 8241;
	public static final int HYDRA_RANGED_2 = 8242;
	public static final int HYDRA_MAGIC_2 = 8243;
	public static final int HYDRA_2_1 = 8244;
	public static final int HYDRA_2_2 = 8245;
	public static final int HYDRA_FIRE = 8248;
	public static final int HYDRA_RANGED_3 = 8249;
	public static final int HYDRA_MAGIC_3 = 8250;
	public static final int HYDRA_3_1 = 8251;
	public static final int HYDRA_3_2 = 8252;
	public static final int HYDRA_MAGIC_4 = 8254;
	public static final int HYDRA_POISON_4 = 8254;
	public static final int HYDRA_RANGED_4 = 8255;
	public static final int HYDRA_4_1 = 8257;
	public static final int HYDRA_4_2 = 8258;

	// INFERNO animations
	public static final int JAL_NIB = 7574;
	public static final int JAL_MEJRAH = 7578;
	public static final int JAL_MEJRAH_STAND = 7577;
	public static final int JAL_AK_RANGE_ATTACK = 7581;
	public static final int JAL_AK_MELEE_ATTACK = 7582;
	public static final int JAL_AK_MAGIC_ATTACK = 7583;
	public static final int JAL_IMKOT = 7597;
	public static final int JAL_XIL_MELEE_ATTACK = 7604;
	public static final int JAL_XIL_RANGE_ATTACK = 7605;
	public static final int JAL_ZEK_MAGE_ATTACK = 7610;
	public static final int JAL_ZEK_MELEE_ATTACK = 7612;
	public static final int JALTOK_JAD_MELEE_ATTACK = 7590;
	public static final int JALTOK_JAD_MAGE_ATTACK = 7592;
	public static final int JALTOK_JAD_RANGE_ATTACK = 7593;
	public static final int TZKAL_ZUK = 7566;
	public static final int JAL_MEJJAK = 2858;

	//General Graardor
	public static final int MINION_AUTO1 = 6154;
	public static final int MINION_AUTO2 = 6156;
	public static final int MINION_AUTO3 = 7071;
	public static final int MINION_AUTO4 = 7073;
	public static final int GENERAL_AUTO1 = 7018;
	public static final int GENERAL_AUTO2 = 7020;
	public static final int GENERAL_AUTO3 = 7021;

	//Zammy-poo
	public static final int ZAMMY_GENERIC_AUTO = 64;
	public static final int KRIL_AUTO = 6948;
	public static final int KRIL_SPEC = 6950;
	public static final int ZAKL_AUTO = 7077;
	public static final int BALFRUG_AUTO = 4630;

	//Sara-Poo
	public static final int ZILYANA_MELEE_AUTO = 6964;
	public static final int ZILYANA_AUTO = 6967;
	public static final int ZILYANA_SPEC = 6970;
	public static final int STARLIGHT_AUTO = 6376;
	public static final int BREE_AUTO = 7026;
	public static final int GROWLER_AUTO = 7037;

	//Arma-Poo
	public static final int KREE_RANGED = 6978;
	public static final int SKREE_AUTO = 6955;
	public static final int GEERIN_AUTO = 6956;
	public static final int GEERIN_FLINCH = 6958;
	public static final int KILISA_AUTO = 6957;

	//Dag Kings
	public static final int DAG_REX = 2853;
	public static final int DAG_PRIME = 2854;
	public static final int DAG_SUPREME = 2855;

	// Lizardman shaman
	public static final int LIZARDMAN_SHAMAN_SPAWN = 7157;

	// Combat counter
	public static final int BARRAGE_ANIMATION = 1979;
	public static final int CHIN_ANIMATION = 7618;

	// Gauntlet Hunleff
	public static final int HUNLEFF_TRAMPLE = 8420;
	public static final int HUNLEFF_ATTACK = 8419;
	public static final int HUNLEFF_TORNADO = 8418;

	//Zalcano
	public static final int ZALCANO_KNOCKED_DOWN = 8437;
	public static final int ZALCANO_WAKEUP = 8439;
	public static final int ZALCANO_ROCK_GLOWING = 8448;
}