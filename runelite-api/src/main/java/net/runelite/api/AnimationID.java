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
	public static final int GEM_CUTTING_OPAL = 890;
	public static final int GEM_CUTTING_JADE = 891;
	public static final int GEM_CUTTING_REDTOPAZ = 892;
	public static final int GEM_CUTTING_SAPPHIRE = 888;
	public static final int GEM_CUTTING_EMERALD = 889;
	public static final int GEM_CUTTING_RUBY = 887;
	public static final int GEM_CUTTING_DIAMOND = 886;
	public static final int CRAFTING_LEATHER = 1249;
	public static final int CRAFTING_GLASSBLOWING = 884;
	public static final int CRAFTING_SPINNING = 894;
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
	public static final int MINING_DRAGON_PICKAXE_ORN = 642;
	public static final int MINING_INFERNAL_PICKAXE = 4482;
	public static final int MINING_3A_PICKAXE = 7283;
	public static final int MINING_MOTHERLODE_BRONZE = 6753;
	public static final int MINING_MOTHERLODE_IRON = 6754;
	public static final int MINING_MOTHERLODE_STEEL = 6755;
	public static final int MINING_MOTHERLODE_BLACK = 3866;
	public static final int MINING_MOTHERLODE_MITHRIL = 6757;
	public static final int MINING_MOTHERLODE_ADAMANT = 6756;
	public static final int MINING_MOTHERLODE_RUNE = 6752;
	public static final int MINING_MOTHERLODE_DRAGON = 6758;
	public static final int MINING_MOTHERLODE_DRAGON_ORN = 335;
	public static final int MINING_MOTHERLODE_INFERNAL = 4481;
	public static final int MINING_MOTHERLODE_3A = 7282;
	public static final int DENSE_ESSENCE_CHIPPING = 7201;
	public static final int DENSE_ESSENCE_CHISELING = 7202;
	public static final int HERBLORE_POTIONMAKING = 363; //used for both herb and secondary
	public static final int MAGIC_CHARGING_ORBS = 726;
	public static final int MAGIC_MAKE_TABLET = 4068;
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

	// NPC animations
	public static final int TZTOK_JAD_MAGIC_ATTACK = 2656;
	public static final int TZTOK_JAD_RANGE_ATTACK = 2652;
	public static final int HELLHOUND_DEFENCE = 6566;

	// Farming
	public static final int FARMING_HARVEST_FRUIT_TREE = 2280;
	public static final int FARMING_HARVEST_BUSH = 2281;
	public static final int FARMING_HARVEST_HERB = 2282;
	public static final int FARMING_USE_COMPOST = 2283;
	public static final int FARMING_CURE_WITH_POTION = 2288;
	public static final int FARMING_PLANT_SEED = 2291;
	public static final int FARMING_HARVEST_FLOWER = 2292;
	public static final int FARMING_MIX_ULTRACOMPOST = 7699;

	// Lunar spellbook
	public static final int ENERGY_TRANSFER_VENGEANCE_OTHER = 4411;
	public static final int MAGIC_LUNAR_SHARED = 4413; // Utilized by Fertile Soil, Boost/Stat Potion Share, NPC Contact, Bake Pie
	public static final int MAGIC_LUNAR_CURE_PLANT = 4432;
	public static final int MAGIC_LUNAR_GEOMANCY = 7118;
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
}
