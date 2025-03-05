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
package net.runelite.api;

/**
 * Server controlled "content-developer" integers.
 *
 * @see VarPlayer
 * <p>
 * These differ from a {@link VarPlayer} in that VarBits can be
 * less than 32 bits. One or more VarBits can be assigned to a
 * backing VarPlayer, each with a static range of bits that it is
 * allowed to access. This allows a more compact representation
 * of small values, like booleans
 */
public final class Varbits
{
	/*
	 * If chatbox is transparent or not
	 */
	public static final int TRANSPARENT_CHATBOX = 4608;

	/*
	 * If the player has an active stamina potion effect or not
	 */
	public static final int RUN_SLOWED_DEPLETION_ACTIVE = 25;

	/**
	 * Stamina effect timer
	 * Number of game ticks remaining on stamina effect in intervals of 10; for a value X there are 10 * X game ticks remaining.
	 * The stamina effect expires once this reaches 0.
	 */
	public static final int STAMINA_EFFECT = 24;

	/**
	 * Antifire timer
	 * Number of game ticks remaining on antifire in intervals of 30; for a value X there are 30 * X game ticks remaining.
	 * The antifire expires once this reaches 0.
	 */
	public static final int ANTIFIRE = 3981;

	/**
	 * Super Antifire timer
	 * Number of game ticks remaining on super antifire in intervals of 20; for a value X there are 20 * X game ticks remaining.
	 * The super antifire expires once this reaches 0.
	 */
	public static final int SUPER_ANTIFIRE = 6101;

	/**
	 * Magic imbue timer
	 * Number of game ticks remaining on magic imbue effect in intervals of 10; for a value X there are 10 * X game ticks remaining.
	 * The magic imbue effect expires once this reaches 0.
	 */
	public static final int MAGIC_IMBUE = 5438;

	/**
	 * Divine effect timers
	 * Number of game ticks remaining on a divine effect.
	 * A potion that combines multiple effects will set the varbits for the individual effects as well as its own effect.
	 */
	public static final int DIVINE_SUPER_ATTACK = 8429;
	public static final int DIVINE_SUPER_STRENGTH = 8430;
	public static final int DIVINE_SUPER_DEFENCE = 8431;
	public static final int DIVINE_RANGING = 8432;
	public static final int DIVINE_MAGIC = 8433;
	public static final int DIVINE_SUPER_COMBAT = 13663;
	public static final int DIVINE_BASTION = 13664;
	public static final int DIVINE_BATTLEMAGE = 13665;

	/**
	 * Moonlight potion timer.
	 * When at least 70 herblore, the moonlight potion's defense effect will be removed when this timer runs out.
	 * If the player drinks a dose of moonlight potion while already under its effects, desync between
	 * Varbits.MOONLIGHT_POTION and Varbits.DIVINE_SUPER_DEFENCE can occur, with the latter being 1 tick greater.
	 * In case of desync, the moonlight defence effect will be removed once Varbits.DIVINE_SUPER_DEFENCE becomes 0.
	 */
	public static final int MOONLIGHT_POTION = 10029;

	/**
	 * Ring of endurance effect timer, stamina duration extended from using the ring of endurance
	 * Number of game ticks remaining on ring of endurance effect in intervals of 10; for a value X there are 10 * X game ticks remaining.
	 * Unequipping the ring of endurance will cause this to change to 0.
	 * When this reaches 0, {@link #STAMINA_EFFECT} will begin counting down.
	 */
	public static final int RING_OF_ENDURANCE_EFFECT = 10385;

	/**
	 * If scrollbar in resizable mode chat is on the left
	 */
	public static final int CHAT_SCROLLBAR_ON_LEFT = 6374;

	/**
	 * Essence pouches
	 */
	public static final int ESSENCE_POUCH_SMALL_AMOUNT = 603;
	public static final int ESSENCE_POUCH_MEDIUM_AMOUNT = 604;
	public static final int ESSENCE_POUCH_LARGE_AMOUNT = 605;
	public static final int ESSENCE_POUCH_GIANT_AMOUNT = 606;
	public static final int ESSENCE_POUCH_COLOSSAL_AMOUNT = 13682;

	public static final int ESSENCE_POUCH_COLOSSAL_DEGRADE = 13683;

	/**
	 * Runepouch
	 */
	public static final int RUNE_POUCH_RUNE1 = 29;
	public static final int RUNE_POUCH_RUNE2 = 1622;
	public static final int RUNE_POUCH_RUNE3 = 1623;
	public static final int RUNE_POUCH_RUNE4 = 14285;
	public static final int RUNE_POUCH_RUNE5 = 15373;
	public static final int RUNE_POUCH_RUNE6 = 15374;
	public static final int RUNE_POUCH_AMOUNT1 = 1624;
	public static final int RUNE_POUCH_AMOUNT2 = 1625;
	public static final int RUNE_POUCH_AMOUNT3 = 1626;
	public static final int RUNE_POUCH_AMOUNT4 = 14286;
	public static final int RUNE_POUCH_AMOUNT5 = 15375;
	public static final int RUNE_POUCH_AMOUNT6 = 15376;

	public static final int PRAYER_DEADEYE_UNLOCKED = 16097;
	public static final int PRAYER_MYSTIC_VIGOUR_UNLOCKED = 16098;

	/**
	 * Prayers
	 */
	public static final int QUICK_PRAYER = 4103;
	public static final int PRAYER_THICK_SKIN = 4104;
	public static final int PRAYER_BURST_OF_STRENGTH = 4105;
	public static final int PRAYER_CLARITY_OF_THOUGHT = 4106;
	public static final int PRAYER_SHARP_EYE = 4122;
	public static final int PRAYER_MYSTIC_WILL = 4123;
	public static final int PRAYER_ROCK_SKIN = 4107;
	public static final int PRAYER_SUPERHUMAN_STRENGTH = 4108;
	public static final int PRAYER_IMPROVED_REFLEXES = 4109;
	public static final int PRAYER_RAPID_RESTORE = 4110;
	public static final int PRAYER_RAPID_HEAL = 4111;
	public static final int PRAYER_PROTECT_ITEM = 4112;
	public static final int PRAYER_HAWK_EYE = 4124;
	public static final int PRAYER_MYSTIC_LORE = 4125;
	public static final int PRAYER_STEEL_SKIN = 4113;
	public static final int PRAYER_ULTIMATE_STRENGTH = 4114;
	public static final int PRAYER_INCREDIBLE_REFLEXES = 4115;
	public static final int PRAYER_PROTECT_FROM_MAGIC = 4116;
	public static final int PRAYER_PROTECT_FROM_MISSILES = 4117;
	public static final int PRAYER_PROTECT_FROM_MELEE = 4118;
	public static final int PRAYER_EAGLE_EYE = 4126;
	public static final int PRAYER_MYSTIC_MIGHT = 4127;
	public static final int PRAYER_RETRIBUTION = 4119;
	public static final int PRAYER_REDEMPTION = 4120;
	public static final int PRAYER_SMITE = 4121;
	public static final int PRAYER_CHIVALRY = 4128;
	public static final int PRAYER_PIETY = 4129;
	public static final int PRAYER_PRESERVE = 5466;
	public static final int PRAYER_RIGOUR = 5464;
	public static final int PRAYER_AUGURY = 5465;
	public static final int PRAYER_DEADEYE = 16090;
	public static final int PRAYER_MYSTIC_VIGOUR = 16091;

	/**
	 * Ruinous Powers
	 */
	public static final int PRAYER_RP_REJUVENATION = 14840;
	public static final int PRAYER_RP_ANCIENT_STRENGTH = 14829;
	public static final int PRAYER_RP_ANCIENT_SIGHT = 14830;
	public static final int PRAYER_RP_ANCIENT_WILL = 14831;
	public static final int PRAYER_RP_PROTECT_ITEM = 14966;
	public static final int PRAYER_RP_RUINOUS_GRACE = 14841;
	public static final int PRAYER_RP_DAMPEN_MAGIC = 14964;
	public static final int PRAYER_RP_DAMPEN_RANGED = 14963;
	public static final int PRAYER_RP_DAMPEN_MELEE = 14962;
	public static final int PRAYER_RP_TRINITAS = 14832;
	public static final int PRAYER_RP_BERSERKER = 14844;
	public static final int PRAYER_RP_PURGE = 14839;
	public static final int PRAYER_RP_METABOLISE = 14843;
	public static final int PRAYER_RP_REBUKE = 14850;
	public static final int PRAYER_RP_VINDICATION = 14851;
	public static final int PRAYER_RP_DECIMATE = 14833;
	public static final int PRAYER_RP_ANNIHILATE = 14834;
	public static final int PRAYER_RP_VAPORISE = 14835;
	public static final int PRAYER_RP_FUMUS_VOW = 14845;
	public static final int PRAYER_RP_UMBRA_VOW = 14847;
	public static final int PRAYER_RP_CRUORS_VOW = 14846;
	public static final int PRAYER_RP_GLACIES_VOW = 14848;
	public static final int PRAYER_RP_WRATH = 14842;
	public static final int PRAYER_RP_INTENSIFY = 14965;

	/**
	 * Diary Entries
	 */
	public static final int DIARY_ARDOUGNE_EASY = 4458;
	public static final int DIARY_ARDOUGNE_MEDIUM = 4459;
	public static final int DIARY_ARDOUGNE_HARD = 4460;
	public static final int DIARY_ARDOUGNE_ELITE = 4461;

	public static final int DIARY_DESERT_EASY = 4483;
	public static final int DIARY_DESERT_MEDIUM = 4484;
	public static final int DIARY_DESERT_HARD = 4485;
	public static final int DIARY_DESERT_ELITE = 4486;

	public static final int DIARY_FALADOR_EASY = 4462;
	public static final int DIARY_FALADOR_MEDIUM = 4463;
	public static final int DIARY_FALADOR_HARD = 4464;
	public static final int DIARY_FALADOR_ELITE = 4465;

	public static final int DIARY_FREMENNIK_EASY = 4491;
	public static final int DIARY_FREMENNIK_MEDIUM = 4492;
	public static final int DIARY_FREMENNIK_HARD = 4493;
	public static final int DIARY_FREMENNIK_ELITE = 4494;

	public static final int DIARY_KANDARIN_EASY = 4475;
	public static final int DIARY_KANDARIN_MEDIUM = 4476;
	public static final int DIARY_KANDARIN_HARD = 4477;
	public static final int DIARY_KANDARIN_ELITE = 4478;

	public static final int DIARY_KARAMJA_EASY = 3578;
	public static final int DIARY_KARAMJA_MEDIUM = 3599;
	public static final int DIARY_KARAMJA_HARD = 3611;
	public static final int DIARY_KARAMJA_ELITE = 4566;

	public static final int DIARY_KOUREND_EASY = 7925;
	public static final int DIARY_KOUREND_MEDIUM = 7926;
	public static final int DIARY_KOUREND_HARD = 7927;
	public static final int DIARY_KOUREND_ELITE = 7928;

	public static final int DIARY_LUMBRIDGE_EASY = 4495;
	public static final int DIARY_LUMBRIDGE_MEDIUM = 4496;
	public static final int DIARY_LUMBRIDGE_HARD = 4497;
	public static final int DIARY_LUMBRIDGE_ELITE = 4498;

	public static final int DIARY_MORYTANIA_EASY = 4487;
	public static final int DIARY_MORYTANIA_MEDIUM = 4488;
	public static final int DIARY_MORYTANIA_HARD = 4489;
	public static final int DIARY_MORYTANIA_ELITE = 4490;

	public static final int DIARY_VARROCK_EASY = 4479;
	public static final int DIARY_VARROCK_MEDIUM = 4480;
	public static final int DIARY_VARROCK_HARD = 4481;
	public static final int DIARY_VARROCK_ELITE = 4482;

	public static final int DIARY_WESTERN_EASY = 4471;
	public static final int DIARY_WESTERN_MEDIUM = 4472;
	public static final int DIARY_WESTERN_HARD = 4473;
	public static final int DIARY_WESTERN_ELITE = 4474;

	public static final int DIARY_WILDERNESS_EASY = 4466;
	public static final int DIARY_WILDERNESS_MEDIUM = 4467;
	public static final int DIARY_WILDERNESS_HARD = 4468;
	public static final int DIARY_WILDERNESS_ELITE = 4469;

	/**
	 * Kourend house favours
	 */
	public static final int KOUREND_FAVOR_ARCEUUS = 4896;
	public static final int KOUREND_FAVOR_HOSIDIUS = 4895;
	public static final int KOUREND_FAVOR_LOVAKENGJ = 4898;
	public static final int KOUREND_FAVOR_PISCARILIUS = 4899;
	public static final int KOUREND_FAVOR_SHAYZIEN = 4894;

	/**
	 * Equipped weapon type
	 */
	public static final int EQUIPPED_WEAPON_TYPE = 357;

	/**
	 * Defensive casting mode
	 */
	public static final int DEFENSIVE_CASTING_MODE = 2668;

	/**
	 * Options
	 */
	public static final int SIDE_PANELS = 4607;

	/**
	 * Herbiboar Trails
	 */
	public static final int HB_TRAIL_31303 = 5737;
	public static final int HB_TRAIL_31306 = 5738;
	public static final int HB_TRAIL_31309 = 5739;
	public static final int HB_TRAIL_31312 = 5740;
	public static final int HB_TRAIL_31315 = 5741;
	public static final int HB_TRAIL_31318 = 5742;
	public static final int HB_TRAIL_31321 = 5743;
	public static final int HB_TRAIL_31324 = 5744;
	public static final int HB_TRAIL_31327 = 5745;
	public static final int HB_TRAIL_31330 = 5746;

	public static final int HB_TRAIL_31333 = 5768;
	public static final int HB_TRAIL_31336 = 5769;
	public static final int HB_TRAIL_31339 = 5770;
	public static final int HB_TRAIL_31342 = 5771;
	public static final int HB_TRAIL_31345 = 5772;
	public static final int HB_TRAIL_31348 = 5773;
	public static final int HB_TRAIL_31351 = 5774;
	public static final int HB_TRAIL_31354 = 5775;
	public static final int HB_TRAIL_31357 = 5776;
	public static final int HB_TRAIL_31360 = 5777;

	public static final int HB_TRAIL_31363 = 5747;
	public static final int HB_TRAIL_31366 = 5748;
	public static final int HB_TRAIL_31369 = 5749;
	public static final int HB_TRAIL_31372 = 5750;

	public static final int HB_FINISH = 5766;

	/**
	 * Started hunting Herbiboar.
	 * <br>
	 * NOTE: This value remains at 0 even after starting a Herbiboar trail up until searching the first object along the
	 * hunting path.
	 */
	public static final int HB_STARTED = 5767;

	/**
	 * Barbarian Assault
	 */
	public static final int IN_GAME_BA = 3923;
	public static final int BA_GC = 4768;

	/**
	 * 0 = Outside wilderness
	 * 1 = In wilderness
	 */
	public static final int IN_WILDERNESS = 5963;

	/**
	 * Fishing Trawler
	 * FISHING_TRAWLER_ACTIVITY Expected values: 0-255
	 */
	public static final int FISHING_TRAWLER_ACTIVITY = 3377;

	/**
	 * Blast Furnace Bar Dispenser
	 * <p>
	 * These are the expected values:
	 * 0 = No bars being processed
	 * 1 = Ores are being processed on the conveyor belt, bar dispenser cannot be checked
	 * 2 = Bars are cooling down
	 * 3 = Bars can be collected
	 */
	public static final int BAR_DISPENSER = 936;

	/**
	 * Motherlode mine sack
	 */
	public static final int SACK_NUMBER = 5558;
	public static final int SACK_UPGRADED = 5556;

	/**
	 * Experience tracker
	 * <p>
	 * EXPERIENCE_TRACKER_POSITION expected values:
	 * 0 = Right
	 * 1 = Middle
	 * 2 = Left
	 */
	public static final int EXPERIENCE_TRACKER_POSITION = 4692;
	public static final int EXPERIENCE_TRACKER_COUNTER = 4697;
	public static final int EXPERIENCE_TRACKER_PROGRESS_BAR = 4698;

	/**
	 * Experience drop color
	 */
	public static final int EXPERIENCE_DROP_COLOR = 4695;

	/**
	 * Tithe Farm
	 */
	public static final int TITHE_FARM_SACK_AMOUNT = 4900;
	public static final int TITHE_FARM_SACK_ICON = 5370;
	public static final int TITHE_FARM_POINTS = 4893;

	/**
	 * Blast Mine
	 */
	public static final int BLAST_MINE_COAL = 10698;
	public static final int BLAST_MINE_GOLD = 10699;
	public static final int BLAST_MINE_MITHRIL = 10700;
	public static final int BLAST_MINE_ADAMANTITE = 10701;
	public static final int BLAST_MINE_RUNITE = 10702;

	/**
	 * Raids
	 */
	public static final int IN_RAID = 5432;
	public static final int TOTAL_POINTS = 5431;

	// 0 = raid not started, >0 = raid started
	public static final int RAID_STATE = 5425;

	/**
	 * Making Friends with My Arm fire pits
	 * <p>
	 * Expected values:
	 * 0 = Not built
	 * 1 = Built
	 */
	public static final int FIRE_PIT_GIANT_MOLE = 6532;
	public static final int FIRE_PIT_LUMBRIDGE_SWAMP = 6533;
	public static final int FIRE_PIT_MOS_LE_HARMLESS = 6534;

	/**
	 * Theatre of Blood 1=In Party, 2=Inside/Spectator, 3=Dead Spectating
	 */
	public static final int THEATRE_OF_BLOOD = 6440;
	/**
	 * Theatre of Blood orb healths
	 * 0=hide 1-27=% of health - 27 is 100% health and 1 is 0% health, 30=dead
	 */
	public static final int THEATRE_OF_BLOOD_ORB1 = 6442;
	public static final int THEATRE_OF_BLOOD_ORB2 = 6443;
	public static final int THEATRE_OF_BLOOD_ORB3 = 6444;
	public static final int THEATRE_OF_BLOOD_ORB4 = 6445;
	public static final int THEATRE_OF_BLOOD_ORB5 = 6446;

	/**
	 * Nightmare Zone
	 */
	public static final int NMZ_ABSORPTION = 3956;
	public static final int NMZ_POINTS = 3949;

	/**
	 * Blast Furnace
	 */
	public static final int BLAST_FURNACE_COPPER_ORE = 959;
	public static final int BLAST_FURNACE_TIN_ORE = 950;
	public static final int BLAST_FURNACE_IRON_ORE = 951;
	public static final int BLAST_FURNACE_COAL = 949;
	public static final int BLAST_FURNACE_MITHRIL_ORE = 952;
	public static final int BLAST_FURNACE_ADAMANTITE_ORE = 953;
	public static final int BLAST_FURNACE_RUNITE_ORE = 954;
	public static final int BLAST_FURNACE_SILVER_ORE = 956;
	public static final int BLAST_FURNACE_GOLD_ORE = 955;

	public static final int BLAST_FURNACE_BRONZE_BAR = 941;
	public static final int BLAST_FURNACE_IRON_BAR = 942;
	public static final int BLAST_FURNACE_STEEL_BAR = 943;
	public static final int BLAST_FURNACE_MITHRIL_BAR = 944;
	public static final int BLAST_FURNACE_ADAMANTITE_BAR = 945;
	public static final int BLAST_FURNACE_RUNITE_BAR = 946;
	public static final int BLAST_FURNACE_SILVER_BAR = 948;
	public static final int BLAST_FURNACE_GOLD_BAR = 947;

	public static final int BLAST_FURNACE_COFFER = 5357;

	/**
	 * Pyramid plunder
	 */
	public static final int PYRAMID_PLUNDER_ROOM_LOCATION = 2365;
	public static final int PYRAMID_PLUNDER_TIMER = 2375;
	public static final int PYRAMID_PLUNDER_THIEVING_LEVEL = 2376;
	public static final int PYRAMID_PLUNDER_ROOM = 2377;

	/**
	 * Barrows
	 */
	public static final int BARROWS_KILLED_AHRIM = 457;
	public static final int BARROWS_KILLED_DHAROK = 458;
	public static final int BARROWS_KILLED_GUTHAN = 459;
	public static final int BARROWS_KILLED_KARIL = 460;
	public static final int BARROWS_KILLED_TORAG = 461;
	public static final int BARROWS_KILLED_VERAC = 462;
	public static final int BARROWS_REWARD_POTENTIAL = 463;
	public static final int BARROWS_NPCS_SLAIN = 464;

	/**
	 * Spicy stew ingredients
	 */
	public static final int SPICY_STEW_RED_SPICES = 1879;
	public static final int SPICY_STEW_YELLOW_SPICES = 1880;
	public static final int SPICY_STEW_BROWN_SPICES = 1881;
	public static final int SPICY_STEW_ORANGE_SPICES = 1882;

	/**
	 * Multicombat area
	 */
	public static final int MULTICOMBAT_AREA = 4605;

	/**
	 * Kingdom of Miscellania Management
	 * Kingdom Approval is represented as a 7-bit unsigned integer; 127 corresponds to 100% approval
	 */
	public static final int KINGDOM_APPROVAL = 72;
	public static final int KINGDOM_COFFER = 74;

	/**
	 * The Hand in the Sand quest status
	 */
	public static final int QUEST_THE_HAND_IN_THE_SAND = 1527;

	/**
	 * Dragon slayer 2 quest status
	 */
	public static final int QUEST_DS2 = 6104;

	/**
	 * Daily Tasks =Collection availability)
	 */
	public static final int DAILY_HERB_BOXES_COLLECTED = 3961;
	public static final int DAILY_STAVES_COLLECTED = 4539;
	public static final int DAILY_ESSENCE_COLLECTED = 4547;
	public static final int DAILY_RUNES_COLLECTED = 4540;
	public static final int DAILY_SAND_COLLECTED = 4549;
	public static final int DAILY_FLAX_STATE = 4559;
	public static final int DAILY_ARROWS_STATE = 4563;
	/**
	 * This varbit tracks how much bonemeal has been redeemed from Robin
	 * The player gets 13 for each diary completed above and including Medium, for a maxiumum of 39
	 */
	public static final int DAILY_BONEMEAL_STATE = 4543;

	public static final int DAILY_DYNAMITE_COLLECTED = 7939;

	/**
	 * Fairy Ring
	 */
	public static final int FAIR_RING_LAST_DESTINATION = 5374;
	public static final int FAIRY_RING_DIAL_ADCB = 3985; //Left dial
	public static final int FAIRY_RIGH_DIAL_ILJK = 3986; //Middle dial
	public static final int FAIRY_RING_DIAL_PSRQ = 3987; //Right dial

	/**
	 * Transmog controllers for farming
	 */
	public static final int FARMING_4771 = 4771;
	public static final int FARMING_4772 = 4772;
	public static final int FARMING_4773 = 4773;
	public static final int FARMING_4774 = 4774;
	public static final int FARMING_4775 = 4775;
	public static final int FARMING_7904 = 7904;
	public static final int FARMING_7905 = 7905;
	public static final int FARMING_7906 = 7906;
	public static final int FARMING_7907 = 7907;
	public static final int FARMING_7908 = 7908;
	public static final int FARMING_7909 = 7909;
	public static final int FARMING_7910 = 7910;
	public static final int FARMING_7911 = 7911;
	public static final int FARMING_7912 = 7912;

	/**
	 * Transmog controllers for grapes
	 */
	public static final int GRAPES_4953 = 4953;
	public static final int GRAPES_4954 = 4954;
	public static final int GRAPES_4955 = 4955;
	public static final int GRAPES_4956 = 4956;
	public static final int GRAPES_4957 = 4957;
	public static final int GRAPES_4958 = 4958;
	public static final int GRAPES_4959 = 4959;
	public static final int GRAPES_4960 = 4960;
	public static final int GRAPES_4961 = 4961;
	public static final int GRAPES_4962 = 4962;
	public static final int GRAPES_4963 = 4963;
	public static final int GRAPES_4964 = 4964;

	/**
	 * Automatically weed farming patches
	 */
	public static final int AUTOWEED = 5557;

	/**
	 * The player's account type.
	 * <p>
	 * 0 = normal
	 * 1 = ironman
	 * 2 = ultimate ironman
	 * 3 = hardcore ironman
	 * 4 = group ironman
	 * 5 = hardcore group ironman
	 * 6 = unranked group ironman
	 */
	public static final int ACCOUNT_TYPE = 1777;

	/**
	 * The varbit that stores the oxygen percentage for player
	 */
	public static final int OXYGEN_LEVEL = 5811;

	/**
	 * Drift net status
	 * <p>
	 * Expected values
	 * 0 = Unset
	 * 1 = Set up
	 * 2 = Caught some fish
	 * 3 = Full
	 */
	public static final int NORTH_NET_STATUS = 5812;
	public static final int SOUTH_NET_STATUS = 5814;

	/**
	 * Drift net catch count
	 */
	public static final int NORTH_NET_CATCH_COUNT = 5813;
	public static final int SOUTH_NET_CATCH_COUNT = 5815;

	/**
	 * Drift net collect interface
	 * <p>
	 * Expected values:
	 * 0 = Not open
	 * 1 = North interface open
	 * 2 = South interface open
	 */
	public static final int DRIFT_NET_COLLECT = 5933;

	/**
	 * Corp beast damage
	 */
	public static final int CORP_DAMAGE = 999;

	/**
	 * Toggleable slayer unlocks
	 */
	public static final int SUPERIOR_ENABLED = 5362;
	public static final int FOSSIL_ISLAND_WYVERN_DISABLE = 6251;

	public static final int BANK_REARRANGE_MODE = 3959;
	public static final int CURRENT_BANK_TAB = 4150;
	public static final int BANK_QUANTITY_TYPE = 6590;
	public static final int BANK_REQUESTEDQUANTITY = 3960;
	public static final int BANK_LEAVEPLACEHOLDERS = 3755;
	public static final int BANK_ITEM_OPTIONS = 16125;

	public static final int WORLDHOPPER_FAVORITE_1 = 4597;
	public static final int WORLDHOPPER_FAVORITE_2 = 4598;

	/**
	 * Spell activeness
	 */
	public static final int VENGEANCE_ACTIVE = 2450;
	public static final int DEATH_CHARGE = 12411;
	public static final int RESURRECT_THRALL = 12413;
	public static final int SHADOW_VEIL = 12414;

	/**
	 * Spell cooldowns
	 */
	public static final int HEAL_GROUP_COOLDOWN = 925;
	public static final int VENGEANCE_COOLDOWN = 2451;
	public static final int DEATH_CHARGE_COOLDOWN = 12138;
	public static final int CORRUPTION_COOLDOWN = 12288;
	public static final int RESURRECT_THRALL_COOLDOWN = 12290;
	public static final int SHADOW_VEIL_COOLDOWN = 12291;
	public static final int WARD_OF_ARCEUUS_COOLDOWN = 12293;

	/**
	 * Imbued Heart cooldown
	 * Number of game tick remaining on cooldown in intervals of 10; for a value X there are 10 * X game ticks remaining.
	 * The heart regains its power once this reaches 0.
	 */
	public static final int IMBUED_HEART_COOLDOWN = 5361;

	/**
	 * Dragonfire shield cooldown
	 * <p>
	 * Number of game ticks remaining on cooldown in intervals of 8; for a value X there are 8 * X game ticks remaining.
	 */
	public static final int DRAGONFIRE_SHIELD_COOLDOWN = 6539;

	/**
	 * Amount of items in each bank tab
	 */
	public static final int BANK_TAB_ONE_COUNT = 4171;
	public static final int BANK_TAB_TWO_COUNT = 4172;
	public static final int BANK_TAB_THREE_COUNT = 4173;
	public static final int BANK_TAB_FOUR_COUNT = 4174;
	public static final int BANK_TAB_FIVE_COUNT = 4175;
	public static final int BANK_TAB_SIX_COUNT = 4176;
	public static final int BANK_TAB_SEVEN_COUNT = 4177;
	public static final int BANK_TAB_EIGHT_COUNT = 4178;
	public static final int BANK_TAB_NINE_COUNT = 4179;

	/**
	 * Type of GE offer currently being created
	 * 0 = buy
	 * 1 = sell
	 */
	public static final int GE_OFFER_CREATION_TYPE = 4397;

	/**
	 * The active tab within the quest interface
	 */
	public static final int QUEST_TAB = 8168;

	/**
	 * Explorer ring
	 */
	public static final int EXPLORER_RING_ALCHTYPE = 5398;
	public static final int EXPLORER_RING_TELEPORTS = 4552;
	public static final int EXPLORER_RING_ALCHS = 4554;
	public static final int EXPLORER_RING_RUNENERGY = 4553;

	public static final int WINTERTODT_TIMER = 7980;

	/**
	 * League relics
	 */
	public static final int LEAGUE_RELIC_1 = 10049;
	public static final int LEAGUE_RELIC_2 = 10050;
	public static final int LEAGUE_RELIC_3 = 10051;
	public static final int LEAGUE_RELIC_4 = 10052;
	public static final int LEAGUE_RELIC_5 = 10053;
	public static final int LEAGUE_RELIC_6 = 11696;
	public static final int LEAGUE_RELIC_7 = 17301;
	public static final int LEAGUE_RELIC_8 = 17302;

	/**
	 * Muted volume restore values
	 */
	public static final int MUTED_MUSIC_VOLUME = 12426;
	public static final int MUTED_SOUND_EFFECT_VOLUME = 12427;
	public static final int MUTED_AREA_EFFECT_VOLUME = 12428;

	/**
	 * Parasite infection status during nightmare of ashihama bossfight
	 * <p>
	 * 0 = not infected
	 * 1 = infected
	 */
	public static final int PARASITE = 10151;

	/**
	 * Whether the vanilla wiki entity lookup is displayed under the minimap
	 * <p>
	 * 0 = Enabled
	 * 1 = Disabled
	 */
	public static final int WIKI_ENTITY_LOOKUP = 10113;

	/**
	 * Whether the player is in a PvP area
	 * <p>
	 * 0 = Player is not in PvP area
	 * 1 = Player is in PvP area
	 * <p>
	 * Note: The name of this varbit comes from historical behavior where
	 * the special attack orb would be disabled in PvP, but this was changed
	 * on 2023-03-09 due to Poll 78. Yet, the varbit still updates as before.
	 */
	public static final int PVP_SPEC_ORB = 8121;

	/**
	 * Collection Log notification settings whenever a new item is added
	 * <p>
	 * 0 = no notification
	 * 1 = chat notification only
	 * 2 = popup notification only
	 * 3 = chat and popup
	 */
	public static final int COLLECTION_LOG_NOTIFICATION = 11959;

	/**
	 * Combat Achievements popup settings whenever a new task is completed
	 * <p>
	 * 0 = popup notification enabled
	 * 1 = popup notification disabled
	 */
	public static final int COMBAT_ACHIEVEMENTS_POPUP = 12455;

	/**
	 * Combat Achievement tier completion variables
	 *
	 * 2 = completed
	 */
	public static final int COMBAT_ACHIEVEMENT_TIER_EASY = 12863;
	public static final int COMBAT_ACHIEVEMENT_TIER_MEDIUM = 12864;
	public static final int COMBAT_ACHIEVEMENT_TIER_HARD = 12865;
	public static final int COMBAT_ACHIEVEMENT_TIER_ELITE = 12866;
	public static final int COMBAT_ACHIEVEMENT_TIER_MASTER = 12867;
	public static final int COMBAT_ACHIEVEMENT_TIER_GRANDMASTER = 12868;

	/**
	 * Show boss health overlay setting
	 * 0 = on
	 * 1 = off
	 */
	public static final int BOSS_HEALTH_OVERLAY = 12389;

	/**
	 * Boss health bar info
	 */
	public static final int BOSS_HEALTH_CURRENT = 6099;
	public static final int BOSS_HEALTH_MAXIMUM = 6100;

	/**
	 * Whether the PVP kill-death stats widget should be drawn while in the wilderness or in PVP worlds.
	 * <p>
	 * 0 = Disabled
	 * 1 = Enabled
	 */
	public static final int SHOW_PVP_KDR_STATS = 4143;

	/**
	 * State of Teleblock spell effects on the player
	 * <p>
	 * 0 = Teleblock inactive, no immunity
	 * 1 &lt;= X &lt;= 100 = Teleblock inactive, remaining ticks of immunity from reapplication of spell effect
	 * 101 &lt;= Teleblock active, remaining ticks of blocking effect
	 */
	public static final int TELEBLOCK = 4163;

	/**
	 * Cooldown timer remaining before eligible to restore at a god wars dungeon altar.
	 * Number of game ticks remaining is in intervals of 100; for a value X there are 100 * X game ticks remaining.
	 * A player can pray at a god wars altar once this reaches 0.
	 */
	public static final int GOD_WARS_ALTAR_COOLDOWN = 4099;

	/**
	 * Cooldown timer remaining before being able to eat from the piles of food in Scurrius's lair.
	 * Number of game ticks remaining is in intervals of 100; for a value X there are 100 * X game ticks remaining.
	 * A player can eat from the food piles once this reaches 0.
	 */
	public static final int SCURRIUS_FOOD_PILE_COOLDOWN = 9581;

	/**
	 * Farmer's Affinity effect timer
	 * Number of game ticks remaining on Farmer's Affinity effect in intervals of 20; for a value X there are 20 * X game ticks remaining.
	 * The Farmer's Affinity expires once this reaches 0.
	 */
	public static final int FARMERS_AFFINITY = 11765;

	/**
	 * If the player has Menaphite remedy effect active.
	 * This will go down by 1 every 25 ticks (15 seconds) and the player's combat stats will be restored by 6 + 16%.
	 * Set to 20 upon consuming potion.
	 */
	public static final int MENAPHITE_REMEDY = 14448;

	/**
	 * How many salt stat boost refreshes the player has remaining.
	 * This will go down by 1 every 25 ticks (15 seconds) and the player's stats will be restored.
	 * Set to 32 upon crushing salts.
	 */
	public static final int BUFF_STAT_BOOST = 14344;

	/**
	 * If the player has liquid adrenaline buff active
	 * <p>
	 * 0 = inactive
	 * 1 = active
	 */
	public static final int LIQUID_ADERNALINE_ACTIVE = 14361;

	public static final int TOA_RAID_LEVEL = 14380;
	public static final int TOA_RAID_DAMAGE = 14325;

	/**
	 * Tombs of Amascut orb healths
	 * 0=hide 1-27=% of health - 27 is 100% health and 1 is 0% health, 30=dead
	 */
	public static final int TOA_MEMBER_0_HEALTH = 14346;
	public static final int TOA_MEMBER_1_HEALTH = 14347;
	public static final int TOA_MEMBER_2_HEALTH = 14348;
	public static final int TOA_MEMBER_3_HEALTH = 14349;
	public static final int TOA_MEMBER_4_HEALTH = 14350;
	public static final int TOA_MEMBER_5_HEALTH = 14351;
	public static final int TOA_MEMBER_6_HEALTH = 14352;
	public static final int TOA_MEMBER_7_HEALTH = 14353;

	/**
	 * How many NMZ overload refreshes the player has remaining.
	 * <p>
	 * This will go down by 1 every 25 ticks (15 seconds) and the player's stats will be restored.
	 * Set to 20 upon drinking an overload.
	 */
	public static final int NMZ_OVERLOAD_REFRESHES_REMAINING = 3955;

	/**
	 * How many Chambers of Xeric overload refreshes the player has remaining.
	 * <p>
	 * This will go down by 1 every 25 ticks (15 seconds) and the player's stats will be restored.
	 * Set to 20 upon drinking an overload.
	 */
	public static final int COX_OVERLOAD_REFRESHES_REMAINING = 5418;

	public static final int SLAYER_POINTS = 4068;
	public static final int SLAYER_TASK_STREAK = 4069;

	/**
	 * The assigned boss for boss slayer.
	 */
	public static final int SLAYER_TASK_BOSS = 4723;

	/**
	 * Whether the level up interface is disabled
	 */
	public static final int DISABLE_LEVEL_UP_INTERFACE = 9452;

	public static final int PRAYERBOOK = 14826;

	/**
	 * During and after Curse of the Empty Lord, Viggora can be located in one of three locations,
	 * which is uniquely and permanently set for each player.
	 * This varbit determines which location he will appear in, which is useful for a master clue step.
	 */
	public static final int VIGGORA_LOCATION = 815;

	/**
	 * If the player has a spellbook swap active
	 * <p>
	 * 0 = inactive
	 * 1 = active
	 */
	public static final int SPELLBOOK_SWAP = 3617;

	public static final int SPELLBOOK = 4070;
	public static final int SPELLBOOK_SUBMENU = 9730;

	/**
	 * The amount of Curse of the Moons stacks received when fighting the Blue Moon or Eclipse Moon.
	 * The varbit value remains 0 when fighting the Blood Moon.
	 * When fighting the Blue Moon, the player's joints will lock up at 18 stacks, which causes their next attack to be
	 * canceled and 18 stacks to be removed.
	 * When fighting the Eclipse Moon, the stacks increase the chance of a player's attack glancing off the shield of
	 * the Eclipse Moon. Glancing attacks reduce the player's max hit by two times the flat armour of the Eclipse Moon.
	 */
	public static final int CURSE_OF_THE_MOONS = 9853;

	/**
	 * The amount of Doom stacks received in the Fortis Colosseum.
	 */
	public static final int COLOSSEUM_DOOM = 9801;

	public static final int BUFF_GOADING_POTION = 11294;

	public static final int BUFF_PRAYER_REGENERATION = 11361;

	/**
	 * The player's progress value for the colossal wyrm advanced basic course.
	 * <p>
	 * Max value = 6;
	 * </p>
	 */
	public static final int COLOSSAL_WYRM_COURSE_BASIC = 11292;

	/**
	 * The player's progress value for the colossal wyrm advanced agility course.
	 * <p>
	 * Max value = 6;
	 * </p>
	 */
	public static final int COLOSSAL_WYRM_COURSE_ADVANCED = 11293;

	public static final int WINTERTODT_WARMTH = 11434;

	public static final int COMBAT_TASK_EASY = 12885;
	public static final int COMBAT_TASK_MEDIUM = 12886;
	public static final int COMBAT_TASK_HARD = 12887;
	public static final int COMBAT_TASK_ELITE = 12888;
	public static final int COMBAT_TASK_MASTER = 12889;
	public static final int COMBAT_TASK_GRANDMASTER = 12890;

	public static final int LEPRECHAUNS_LUCK = 15344;

	public static final int LEAGUES_MELEE_COMBAT_MASTERY_LEVEL = 11580;
	public static final int LEAGUES_RANGED_COMBAT_MASTERY_LEVEL = 11581;
	public static final int LEAGUES_MAGIC_COMBAT_MASTERY_LEVEL = 11582;

	/**
	 * The slayer master which is present at Burthorpe.
	 * <p>
	 * 0 = Turael
	 * 1, 2 = Aya
	 * 3 = Null
	 */
	public static final int BURTHORPE_SLAYER_MASTER = 10782;

	/**
	 * The state of Jarvis' gravestone.
	 * <p>
	 * 0, 2, 3 = Bush (eg. saved Jarvis, or did not partake in the 2017 Halloween event)
	 * 1 = Gravestone
	 *
	 * @see <a href="https://oldschool.runescape.wiki/w/Gravestone_(Jarvis)">Gravestone (Jarvis) - OSRS Wiki</a>
	 */
	public static final int JARVIS_GRAVESTONE = 6008;

	public static final int IN_LMS = 5314;
}
