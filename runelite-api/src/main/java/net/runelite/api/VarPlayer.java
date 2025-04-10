/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
 * VarPlayers are stored per RuneScape player save, and synchronized
 * from the server to the client. The client can change them preemptively
 * if it thinks they will change the next tick as a lag-hiding measure.
 * The client CANNOT directly make the server change a varp.
 */
@Deprecated
public final class VarPlayer
{
	public static final int CANNON_STATE = 2;
	public static final int CANNON_AMMO = 3;
	public static final int CANNON_COORD = 4;
	public static final int ATTACK_STYLE = 43;
	public static final int QUEST_POINTS = 101;
	/**
	 * Seems to start at 50(10 splash) and goes down by 1 every 30 seconds
	 */
	public static final int DISEASE_VALUE = 456;

	public static final int BANK_TAB = 115;

	public static final int MEMBERSHIP_DAYS = 1780;

	public static final int SPECIAL_ATTACK_PERCENT = 300;
	public static final int SPECIAL_ATTACK_ENABLED = 301;

	/**
	 * The ID of the party. This Var is only set in the raid bank area and the raid lobby
	 *
	 * This gets set to -1 when the raid starts. This is first set when the first player of the friends chat forms a party
	 * on the recruiting board and it changes again when the first person actually enters the raid.
	 *
	 * -1 : Not in a party or in the middle of an ongoing raid
	 * Anything else : This means that your friends chat has a raid party being formed and has not started yet
	 */
	public static final int IN_RAID_PARTY = 1427;

	public static final int NMZ_REWARD_POINTS = 1060;

	/**
	 * The poisoned status of the player, with negative values indicating the duration of poison or venom protection and
	 * positive values representing the amount of poison or venom damage the player will be taking.
	 *
	 * <ul>
	 *     <li>
	 *         (-inf, -38): Venom immune for a duration of {@code (abs(val) - 38) * 30} game ticks (18 seconds per
	 *         poison tick), after which point the value will have increased to {@code -38} and be representing poison
	 *         immunity rather than venom immunity
	 *     </li>
	 *     <li>
	 *         [-38, 0): Poison immune for a duration of {@code abs(val) * 30} game ticks (18 seconds per poison tick)
	 *     </li>
	 *     <li>0: Not poisoned or immune to poison</li>
	 *     <li>[1, 100]: Poisoned for an amount of {@code ceil(val / 5.0f)}</li>
	 *     <li>
	 *         [1000000, inf): Venomed for an amount of {@code min(20, (val - 999997) * 2)}, that is, an amount starting
	 *         at 6 damage, increasing by 2 each time the value increases by one, and capped at 20
	 *     </li>
	 * </ul>
	 */
	public static final int POISON = 102;

	/**
	 * 0 : not started
	 * greater than 0 : in progress
	 * greater than 99 : completed
	 */
	public static final int THRONE_OF_MISCELLANIA = 359;

	/**
	 * Item currently active in the creation of a buy or sell offer
	 */
	public static final int CURRENT_GE_ITEM = 1151;

	/**
	 * Experience tracker goal start.
	 */
	public static final int ATTACK_GOAL_START = 1229;
	public static final int STRENGTH_GOAL_START = 1230;
	public static final int RANGED_GOAL_START = 1231;
	public static final int MAGIC_GOAL_START = 1232;
	public static final int DEFENCE_GOAL_START = 1233;
	public static final int HITPOINTS_GOAL_START = 1234;
	public static final int PRAYER_GOAL_START = 1235;
	public static final int AGILITY_GOAL_START = 1236;
	public static final int HERBLORE_GOAL_START = 1237;
	public static final int THIEVING_GOAL_START = 1238;
	public static final int CRAFTING_GOAL_START = 1239;
	public static final int RUNECRAFT_GOAL_START = 1240;
	public static final int MINING_GOAL_START = 1241;
	public static final int SMITHING_GOAL_START = 1242;
	public static final int FISHING_GOAL_START = 1243;
	public static final int COOKING_GOAL_START = 1244;
	public static final int FIREMAKING_GOAL_START = 1245;
	public static final int WOODCUTTING_GOAL_START = 1246;
	public static final int FLETCHING_GOAL_START = 1247;
	public static final int SLAYER_GOAL_START = 1248;
	public static final int FARMING_GOAL_START = 1249;
	public static final int CONSTRUCTION_GOAL_START = 1250;
	public static final int HUNTER_GOAL_START = 1251;

	/**
	 * Experience tracker goal end.
	 */
	public static final int ATTACK_GOAL_END = 1253;
	public static final int STRENGTH_GOAL_END = 1254;
	public static final int RANGED_GOAL_END = 1255;
	public static final int MAGIC_GOAL_END = 1256;
	public static final int DEFENCE_GOAL_END = 1257;
	public static final int HITPOINTS_GOAL_END = 1258;
	public static final int PRAYER_GOAL_END = 1259;
	public static final int AGILITY_GOAL_END = 1260;
	public static final int HERBLORE_GOAL_END = 1261;
	public static final int THIEVING_GOAL_END = 1262;
	public static final int CRAFTING_GOAL_END = 1263;
	public static final int RUNECRAFT_GOAL_END = 1264;
	public static final int MINING_GOAL_END = 1265;
	public static final int SMITHING_GOAL_END = 1266;
	public static final int FISHING_GOAL_END = 1267;
	public static final int COOKING_GOAL_END = 1268;
	public static final int FIREMAKING_GOAL_END = 1269;
	public static final int WOODCUTTING_GOAL_END = 1270;
	public static final int FLETCHING_GOAL_END = 1271;
	public static final int SLAYER_GOAL_END = 1272;
	public static final int FARMING_GOAL_END = 1273;
	public static final int CONSTRUCTION_GOAL_END = 1274;
	public static final int HUNTER_GOAL_END = 1275;

	/**
	 * Bird house states
	 */
	public static final int BIRD_HOUSE_MEADOW_NORTH = 1626;
	public static final int BIRD_HOUSE_MEADOW_SOUTH = 1627;
	public static final int BIRD_HOUSE_VALLEY_NORTH = 1628;
	public static final int BIRD_HOUSE_VALLEY_SOUTH = 1629;

	/**
	 * Slayer unlock bitfields
	 */
	public static final int SLAYER_UNLOCK_1 = 1076;
	public static final int SLAYER_UNLOCK_2 = 1344;

	public static final int MUSIC_VOLUME = 168;
	public static final int SOUND_EFFECT_VOLUME = 169;
	public static final int AREA_EFFECT_VOLUME = 872;

	/**
	 * 0 = 2 buttons, 1 = 1 button
	 */
	public static final int MOUSE_BUTTONS = 170;

	/**
	 * {@link net.runelite.api.gameval.NpcID} for the HP HUD
	 */
	public static final int HP_HUD_NPC_ID = 1683;

	public static final int CLOG_LOGGED = 2943;
	public static final int CLOG_TOTAL = 2944;

	/**
	 * Colors for chat messages
	 */
	public static final int SETTINGS_OPAQUE_CHAT_PUBLIC = 2992;
	public static final int SETTINGS_OPAQUE_CHAT_PRIVATE = 2993;
	public static final int SETTINGS_OPAQUE_CHAT_AUTO = 2994;
	public static final int SETTINGS_OPAQUE_CHAT_BROADCAST = 2995;
	public static final int SETTINGS_OPAQUE_CHAT_FRIEND = 2996;
	public static final int SETTINGS_OPAQUE_CHAT_CLAN = 2997;
	public static final int SETTINGS_OPAQUE_CHAT_GUEST_CLAN = 3060;
	public static final int SETTINGS_OPAQUE_CHAT_CLAN_BROADCAST = 3192;
	public static final int SETTINGS_OPAQUE_CHAT_IRON_GROUP_CHAT = 3191;
	public static final int SETTINGS_OPAQUE_CHAT_IRON_GROUP_BROADCAST = 3193;
	public static final int SETTINGS_OPAQUE_CHAT_TRADE_REQUEST = 2998;
	public static final int SETTINGS_OPAQUE_CHAT_CHALLENGE_REQUEST = 2999;

	public static final int SETTINGS_TRANSPARENT_CHAT_PUBLIC = 3000;
	public static final int SETTINGS_TRANSPARENT_CHAT_PRIVATE = 3001;
	public static final int SETTINGS_TRANSPARENT_CHAT_AUTO = 3002;
	public static final int SETTINGS_TRANSPARENT_CHAT_BROADCAST = 3003;
	public static final int SETTINGS_TRANSPARENT_CHAT_FRIEND = 3004;
	public static final int SETTINGS_TRANSPARENT_CHAT_CLAN = 3005;
	public static final int SETTINGS_TRANSPARENT_CHAT_GUEST_CLAN = 3061;
	public static final int SETTINGS_TRANSPARENT_CHAT_CLAN_BROADCAST = 3195;
	public static final int SETTINGS_TRANSPARENT_CHAT_IRON_GROUP_CHAT = 3194;
	public static final int SETTINGS_TRANSPARENT_CHAT_IRON_GROUP_BROADCAST = 3196;
	public static final int SETTINGS_TRANSPARENT_CHAT_TRADE_REQUEST = 3006;
	public static final int SETTINGS_TRANSPARENT_CHAT_CHALLENGE_REQUEST = 3007;

	/**
	 * The difference, measured in minutes, between the time home teleport spell was last used and midnight, January 1, 1970 UTC.
	 */
	public static final int LAST_HOME_TELEPORT = 892;

	/**
	 * Charge spell duration
	 * Value * 2 = Remaining game ticks on buff
	 * E.g. value of 50 means buff will expire in 100 ticks.
	 */
	public static final int CHARGE_GOD_SPELL = 272;

	/**
	 * The difference, measured in minutes, between the time minigame teleport was last used and midnight, January 1, 1970 UTC.
	 */
	public static final int LAST_MINIGAME_TELEPORT = 888;

	/**
	 * Number of slayer creatures remaining on the assigned task
	 */
	public static final int SLAYER_TASK_SIZE = 394;

	/**
	 * Currently assigned slayer task if SLAYER_TASK_SIZE is greater than 0.
	 * Mapping of value to name can be found in {@link EnumID#SLAYER_TASK_CREATURE}.
	 */
	public static final int SLAYER_TASK_CREATURE = 395;

	/**
	 * Assigned slayer task location. The mapping of value to name can be found in {@link EnumID#SLAYER_TASK_LOCATION}
	 */
	public static final int SLAYER_TASK_LOCATION = 2096;

	/**
	 * Determines whether the woodcutting group bonus should be displayed on the buff bar or not.
	 * 96 = displayed (including the woodcutting guild).
	 * 0 = not displayed (after login until cutting a tree except normal trees or trees grown through farming).
	 * -1 = not displayed (including normal trees or trees grown through farming).
	 */
	public static final int BUFF_BAR_WC_GROUP_BONUS = 4007;

	/**
	 * The amount of ammo in Dizana's quiver's inventory slot.
	 * 0 means the quiver is empty.
	 * @see #DIZANAS_QUIVER_ITEM_ID
	 */
	public static final int DIZANAS_QUIVER_ITEM_COUNT = 4141;

	/**
	 * The item ID of the ammo in Dizana's quiver inventory slot.
	 * -1 means the quiver is empty.
	 * @see #DIZANAS_QUIVER_ITEM_COUNT
	 */
	public static final int DIZANAS_QUIVER_ITEM_ID = 4142;

	/**
	 * Runecraft Essence Pouch degrade states
	 */
	public static final int ESSENCE_POUCH_MEDIUM_DEGRADE = 488;
	public static final int ESSENCE_POUCH_LARGE_DEGRADE = 489;
	public static final int ESSENCE_POUCH_GIANT_DEGRADE = 490;

	public static final int RAIDS_PERSONAL_POINTS = 4609;
}
