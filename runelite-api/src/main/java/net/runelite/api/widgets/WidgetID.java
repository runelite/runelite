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
package net.runelite.api.widgets;

/**
 * Utility class mapping widget IDs to global constants.
 * <p>
 * The constants defined directly under the {@link WidgetID} class are
 * Widget group IDs. All child IDs are defined in sub-classes relating
 * to their group.
 * <p>
 * For a more direct group-child widget mapping, use the
 * {@link WidgetInfo} enum class.
 */
public final class WidgetID
{
	public static final int FAIRY_RING_PANEL_GROUP_ID = 381;
	public static final int FAIRY_RING_GROUP_ID = 398;
	public static final int LOGOUT_PANEL_ID = 182;
	public static final int BANK_GROUP_ID = 12;
	public static final int BANK_INVENTORY_GROUP_ID = 15;
	public static final int GRAND_EXCHANGE_INVENTORY_GROUP_ID = 467;
	public static final int GRAND_EXCHANGE_GROUP_ID = 465;
	public static final int DEPOSIT_BOX_GROUP_ID = 192;
	public static final int INVENTORY_GROUP_ID = 149;
	public static final int PLAYER_TRADE_SCREEN_GROUP_ID = 335;
	public static final int PLAYER_TRADE_INVENTORY_GROUP_ID = 336;
	public static final int FRIENDS_LIST_GROUP_ID = 429;
	public static final int IGNORE_LIST_GROUP_ID = 432;
	public static final int RAIDING_PARTY_GROUP_ID = 500;
	public static final int EQUIPMENT_GROUP_ID = 387;
	public static final int EQUIPMENT_INVENTORY_GROUP_ID = 85;
	public static final int EMOTES_GROUP_ID = 216;
	public static final int RUNE_POUCH_GROUP_ID = 190;
	public static final int ACHIEVEMENT_DIARY_GROUP_ID = 259;
	public static final int PEST_CONTROL_BOAT_GROUP_ID = 407;
	public static final int PEST_CONTROL_GROUP_ID = 408;
	public static final int FRIENDS_CHAT_GROUP_ID = 7;
	public static final int MINIMAP_GROUP_ID = 160;
	public static final int LOGIN_CLICK_TO_PLAY_GROUP_ID = 378;
	public static final int CLUE_SCROLL_GROUP_ID = 203;
	public static final int FIXED_VIEWPORT_GROUP_ID = 548;
	public static final int RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX_GROUP_ID = 161;
	public static final int RESIZABLE_VIEWPORT_BOTTOM_LINE_GROUP_ID = 164;
	public static final int PRAYER_GROUP_ID = 541;
	public static final int QUICK_PRAYERS_GROUP_ID = 77;
	public static final int SHOP_GROUP_ID = 300;
	public static final int SHOP_INVENTORY_GROUP_ID = 301;
	public static final int SMITHING_GROUP_ID = 312;
	public static final int GUIDE_PRICES_GROUP_ID = 464;
	public static final int GUIDE_PRICES_INVENTORY_GROUP_ID = 238;
	public static final int COMBAT_GROUP_ID = 593;
	public static final int DIALOG_NPC_GROUP_ID = 231;
	public static final int SLAYER_REWARDS_GROUP_ID = 426;
	public static final int PRIVATE_CHAT = 163;
	public static final int CHATBOX_GROUP_ID = 162;
	public static final int VOLCANIC_MINE_GROUP_ID = 611;
	public static final int BA_ATTACKER_GROUP_ID = 485;
	public static final int BA_COLLECTOR_GROUP_ID = 486;
	public static final int BA_DEFENDER_GROUP_ID = 487;
	public static final int BA_HEALER_GROUP_ID = 488;
	public static final int BA_REWARD_GROUP_ID = 497;
	public static final int BA_TEAM_GROUP_ID = 256;
	public static final int LEVEL_UP_GROUP_ID = 233;
	public static final int DIALOG_SPRITE_GROUP_ID = 193;
	public static final int QUEST_COMPLETED_GROUP_ID = 153;
	public static final int CLUE_SCROLL_REWARD_GROUP_ID = 73;
	public static final int BARROWS_REWARD_GROUP_ID = 155;
	public static final int RAIDS_GROUP_ID = 513;
	public static final int TOB_GROUP_ID = 28;
	public static final int MOTHERLODE_MINE_GROUP_ID = 382;
	public static final int EXPERIENCE_DROP_GROUP_ID = 122;
	public static final int PUZZLE_BOX_GROUP_ID = 306;
	public static final int LIGHT_BOX_GROUP_ID = 322;
	public static final int NIGHTMARE_ZONE_GROUP_ID = 202;
	public static final int NIGHTMARE_PILLAR_HEALTH_GROUP_ID = 413;
	public static final int BLAST_FURNACE_GROUP_ID = 474;
	public static final int WORLD_MAP_GROUP_ID = 595;
	public static final int PYRAMID_PLUNDER_GROUP_ID = 428;
	public static final int CHAMBERS_OF_XERIC_REWARD_GROUP_ID = 539;
	public static final int THEATRE_OF_BLOOD_REWARD_GROUP_ID = 23;
	public static final int EXPERIENCE_TRACKER_GROUP_ID = 122;
	public static final int TITHE_FARM_GROUP_ID = 241;
	public static final int KINGDOM_GROUP_ID = 616;
	public static final int BARROWS_GROUP_ID = 24;
	public static final int BLAST_MINE_GROUP_ID = 598;
	public static final int MTA_ALCHEMY_GROUP_ID = 194;
	public static final int MTA_ENCHANTMENT_GROUP_ID = 195;
	public static final int MTA_GRAVEYARD_GROUP_ID = 196;
	public static final int MTA_TELEKINETIC_GROUP_ID = 198;
	public static final int CORP_DAMAGE = 13;
	public static final int DESTROY_ITEM_GROUP_ID = 584;
	public static final int VARROCK_MUSEUM_QUIZ_GROUP_ID = 533;
	public static final int KILL_LOGS_GROUP_ID = 549;
	public static final int DIARY_QUEST_GROUP_ID = 119;
	public static final int THEATRE_OF_BLOOD_GROUP_ID = 23;
	public static final int WORLD_SWITCHER_GROUP_ID = 69;
	public static final int DIALOG_OPTION_GROUP_ID = 219;
	public static final int DIALOG_PLAYER_GROUP_ID = 217;
	public static final int DRIFT_NET_FISHING_REWARD_GROUP_ID = 607;
	public static final int FOSSIL_ISLAND_OXYGENBAR_ID = 609;
	public static final int MINIGAME_TAB_ID = 76;
	public static final int SPELLBOOK_GROUP_ID = 218;
	public static final int PVP_GROUP_ID = 90;
	public static final int FISHING_TRAWLER_GROUP_ID = 366;
	public static final int FISHING_TRAWLER_REWARD_GROUP_ID = 367;
	public static final int ZEAH_MESS_HALL_GROUP_ID = 235;
	public static final int KOUREND_FAVOUR_GROUP_ID = 246;
	public static final int LOOTING_BAG_GROUP_ID = 81;
	public static final int SKOTIZO_GROUP_ID = 308;
	public static final int ENTERING_HOUSE_GROUP_ID = 71;
	public static final int FULLSCREEN_CONTAINER_TLI = 165;
	public static final int QUESTLIST_GROUP_ID = 399;
	public static final int SKILLS_GROUP_ID = 320;
	public static final int MUSIC_GROUP_ID = 239;
	public static final int BARROWS_PUZZLE_GROUP_ID = 25;
	public static final int KEPT_ON_DEATH_GROUP_ID = 4;
	public static final int GUIDE_PRICE_GROUP_ID = 464;
	public static final int SEED_VAULT_INVENTORY_GROUP_ID = 630;
	public static final int BEGINNER_CLUE_MAP_CHAMPIONS_GUILD = 346;
	public static final int BEGINNER_CLUE_MAP_VARROCK_EAST_MINE = 347;
	public static final int BEGINNER_CLUE_MAP_DRAYNOR = 348;
	public static final int BEGINNER_CLUE_MAP_NORTH_OF_FALADOR = 351;
	public static final int BEGINNER_CLUE_MAP_WIZARDS_TOWER = 356;
	public static final int SEED_BOX_GROUP_ID = 128;
	public static final int SEED_VAULT_GROUP_ID = 631;
	public static final int EXPLORERS_RING_ALCH_GROUP_ID = 483;
	public static final int SETTINGS_SIDE_GROUP_ID = 116;
	public static final int SETTINGS_GROUP_ID = 134;
	public static final int GWD_KC_GROUP_ID = 406;
	public static final int LMS_GROUP_ID = 333;
	public static final int LMS_INGAME_GROUP_ID = 328;
	public static final int ADVENTURE_LOG_ID = 187;
	public static final int COLLECTION_LOG_ID = 621;
	public static final int GENERIC_SCROLL_GROUP_ID = 625;
	public static final int GAUNTLET_TIMER_GROUP_ID = 637;
	public static final int HALLOWED_SEPULCHRE_TIMER_GROUP_ID = 668;
	public static final int BANK_PIN_GROUP_ID = 213;
	public static final int HEALTH_OVERLAY_BAR_GROUP_ID = 303;
	public static final int CHAMBERS_OF_XERIC_STORAGE_UNIT_PRIVATE_GROUP_ID = 271;
	public static final int CHAMBERS_OF_XERIC_STORAGE_UNIT_SHARED_GROUP_ID = 550;
	public static final int CHAMBERS_OF_XERIC_STORAGE_UNIT_INVENTORY_GROUP_ID = 551;
	public static final int DUEL_INVENTORY_GROUP_ID = 421;
	public static final int DUEL_INVENTORY_OTHER_GROUP_ID = 481;
	public static final int TRAILBLAZER_AREAS_GROUP_ID = 512;
	public static final int TEMPOROSS_GROUP_ID = 437;
	public static final int CLAN_GROUP_ID = 701;
	public static final int CLAN_GUEST_GROUP_ID = 702;
	public static final int GRAVESTONE_GROUP_ID = 672;
	public static final int POH_TREASURE_CHEST_INVENTORY_GROUP_ID = 674;
	public static final int GROUP_IRON_GROUP_ID = 726;

	static class WorldMap
	{
		static final int MAPVIEW = 7;
		static final int OVERVIEW_MAP = 10;
		static final int BOTTOM_BAR = 23;
		static final int SEARCH = 26;
		static final int SURFACE_SELECTOR = 34;
		static final int TOOLTIP = 41;
	}

	static class SlayerRewards
	{
		static final int TOP_BAR = 12;
	}

	static class DialogOption
	{
		static final int OPTIONS = 1;
	}

	static class DialogNPC
	{
		static final int HEAD_MODEL = 6;
		static final int NAME = 3;
		static final int TEXT = 5;
	}

	static class DialogPlayer
	{
		static final int NAME = 3;
		static final int TEXT = 5;
		static final int HEAD_MODEL = 6;
	}

	static class LogoutPanel
	{
		static final int WORLD_SWITCHER_BUTTON = 3;
		static final int LOGOUT_BUTTON = 6;
	}

	static class PestControl
	{
		static final int KNIGHT_INFO_CONTAINER = 2;

		static final int ACTIVITY_SHIELD_CONTAINER = 9;
		static final int ACTIVITY_BAR = 10;
		static final int ACTIVITY_PROGRESS = 12;

		static final int PURPLE_SHIELD = 13;
		static final int BLUE_SHIELD = 14;
		static final int YELLOW_SHIELD = 15;
		static final int RED_SHIELD = 16;

		static final int PURPLE_ICON = 17;
		static final int BLUE_ICON = 18;
		static final int YELLOW_ICON = 19;
		static final int RED_ICON = 20;

		static final int PURPLE_HEALTH = 21;
		static final int BLUE_HEALTH = 22;
		static final int YELLOW_HEALTH = 23;
		static final int RED_HEALTH = 24;
	}

	static class FriendList
	{
		static final int TITLE = 3;
		static final int FULL_CONTAINER = 5;
		static final int SORT_BY_NAME_BUTTON = 7;
		static final int SORT_BY_LAST_WORLD_CHANGE_BUTTON = 8;
		static final int SORT_BY_WORLD_BUTTON = 9;
		static final int LEGACY_SORT_BUTTON = 10;
		static final int NAMES_CONTAINER = 11;
		static final int SCROLL_BAR = 12;
		static final int LOADING_TEXT = 13;
		static final int PREVIOUS_NAME_HOLDER = 18;
	}

	static class IgnoreList
	{
		static final int TITLE = 3;
		static final int FULL_CONTAINER = 5;
		static final int SORT_BY_NAME_BUTTON = 7;
		static final int LEGACY_SORT_BUTTON = 8;
		static final int NAMES_CONTAINER = 9;
		static final int SCROLL_BAR = 10;
		static final int LOADING_TEXT = 11;
		static final int PREVIOUS_NAME_HOLDER = 16;
	}

	static class FriendsChat
	{
		static final int ROOT = 0;
		static final int TITLE = 1;
		static final int OWNER = 2;
		static final int LIST = 12;
	}

	static class Bank
	{
		static final int BANK_CONTAINER = 1;
		static final int INVENTORY_ITEM_CONTAINER = 3;
		static final int BANK_TITLE_BAR = 3;
		static final int TUTORIAL_BUTTON = 4;
		static final int ITEM_COUNT_TOP = 5;
		static final int ITEM_COUNT_BAR = 6;
		static final int ITEM_COUNT_BOTTOM = 7;
		static final int GROUP_STORAGE_BUTTON = 8;
		static final int CONTENT_CONTAINER = 10;
		static final int TAB_CONTAINER = 11;
		static final int ITEM_CONTAINER = 13;
		static final int SCROLLBAR = 14;
		static final int SEARCH_BUTTON_BACKGROUND = 40;
		static final int DEPOSIT_INVENTORY = 42;
		static final int DEPOSIT_EQUIPMENT = 44;
		static final int INCINERATOR = 46;
		static final int INCINERATOR_CONFIRM = 47;
		static final int EQUIPMENT_CONTENT_CONTAINER = 69;
		static final int SETTINGS_BUTTON = 112;
		static final int EQUIPMENT_BUTTON = 113;
	}

	static class GrandExchange
	{
		static final int WINDOW_CONTAINER = 0;
		static final int WINDOW_BORDERS = 2;
		static final int HISTORY_BUTTON = 3;
		static final int BACK_BUTTON = 4;
		static final int OFFER_CONTAINER = 24;
		static final int OFFER_DESCRIPTION = 25;
		static final int OFFER_PRICE = 26;
		static final int OFFER_CONFIRM_BUTTON = 27;
	}

	static class GrandExchangeInventory
	{
		static final int INVENTORY_ITEM_CONTAINER = 0;
	}

	static class DepositBox
	{
		static final int INVENTORY_ITEM_CONTAINER = 2;
	}

	static class Shop
	{
		static final int INVENTORY_ITEM_CONTAINER = 0;
	}

	static class Smithing
	{
		static final int INVENTORY_ITEM_CONTAINER = 0;
	}

	static class GuidePrices
	{
		static final int ITEM_CONTAINER = 2;
		static final int INVENTORY_ITEM_CONTAINER = 0;
	}

	static class Equipment
	{
		static final int INVENTORY_ITEM_CONTAINER = 0;
	}

	static class Emotes
	{
		static final int EMOTE_WINDOW = 0;
		static final int EMOTE_CONTAINER = 1;
		static final int EMOTE_SCROLLBAR = 2;
	}

	static class Cluescroll
	{
		static final int CLUE_TEXT = 2;
		static final int CLUE_SCROLL_ITEM_CONTAINER = 3;
	}

	static class Minimap
	{
		static final int XP_ORB = 1;
		static final int HEALTH_ORB = 2;
		static final int PRAYER_ORB = 13;
		static final int QUICK_PRAYER_ORB = 15; // Has the "Quick-prayers" name
		static final int PRAYER_ORB_TEXT = 16;
		static final int RUN_ORB = 21;
		static final int TOGGLE_RUN_ORB = 23; // Has the "Toggle run" name
		static final int RUN_ORB_TEXT = 24;
		static final int SPEC_ORB = 29;
		static final int WORLDMAP_ORB = 43;
		static final int WIKI_BANNER_PARENT = 44;
		static final int WIKI_BANNER = 45;
		static final int WORLDMAP_OPTIONS = 48;
	}

	static class LoginClickToPlayScreen
	{
		static final int MESSAGE_OF_THE_DAY = 7;
	}

	static class FixedViewport
	{
		static final int MINIMAP = 8;
		static final int MINIMAP_DRAW_AREA = 21;
		static final int FIXED_VIEWPORT = 32;
		static final int MULTICOMBAT_INDICATOR = 36;
		static final int FRIENDS_CHAT_TAB = 46;
		static final int FRIENDS_TAB = 48;
		static final int IGNORES_TAB = 47;
		static final int LOGOUT_TAB = 49;
		static final int OPTIONS_TAB = 50;
		static final int EMOTES_TAB = 51;
		static final int MUSIC_TAB = 52;
		static final int FRIENDS_CHAT_ICON = 53;
		static final int FRIENDS_ICON = 55;
		static final int IGNORES_ICON = 54;
		static final int LOGOUT_ICON = 56;
		static final int OPTIONS_ICON = 57;
		static final int EMOTES_ICON = 58;
		static final int MUSIC_ICON = 59;
		static final int COMBAT_TAB = 62;
		static final int STATS_TAB = 63;
		static final int QUESTS_TAB = 64;
		static final int INVENTORY_TAB = 65;
		static final int EQUIPMENT_TAB = 66;
		static final int PRAYER_TAB = 67;
		static final int MAGIC_TAB = 68;
		static final int COMBAT_ICON = 69;
		static final int STATS_ICON = 70;
		static final int QUESTS_ICON = 71;
		static final int INVENTORY_ICON = 72;
		static final int EQUIPMENT_ICON = 73;
		static final int PRAYER_ICON = 74;
		static final int MAGIC_ICON = 75;
		static final int ROOT_INTERFACE_CONTAINER = 16;
		static final int BANK_CONTAINER = 77;
		static final int INTERFACE_CONTAINER = 78;
		static final int INVENTORY_CONTAINER = 82;
	}

	static class ResizableViewport
	{
		static final int RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX = 15;
		static final int MULTICOMBAT_INDICATOR = 19;
		static final int MINIMAP = 93;
		static final int MINIMAP_DRAW_AREA = 29;
		static final int MINIMAP_ORB_HOLDER = 32;
		static final int FRIENDS_CHAT_TAB = 42;
		static final int IGNORES_TAB = 43;
		static final int FRIENDS_TAB = 44;
		static final int LOGOUT_TAB = 45;
		static final int OPTIONS_TAB = 46;
		static final int EMOTES_TAB = 47;
		static final int MUSIC_TAB = 48;
		static final int FRIENDS_CHAT_ICON = 49;
		static final int FRIENDS_ICON = 51;
		static final int IGNORES_ICON = 50;
		static final int LOGOUT_ICON = 52;
		static final int OPTIONS_ICON = 53;
		static final int EMOTES_ICON = 54;
		static final int MUSIC_ICON = 55;
		static final int COMBAT_TAB = 58;
		static final int STATS_TAB = 59;
		static final int QUESTS_TAB = 60;
		static final int INVENTORY_TAB = 61;
		static final int EQUIPMENT_TAB = 62;
		static final int PRAYER_TAB = 63;
		static final int MAGIC_TAB = 64;
		static final int COMBAT_ICON = 65;
		static final int STATS_ICON = 66;
		static final int QUESTS_ICON = 67;
		static final int INVENTORY_ICON = 68;
		static final int EQUIPMENT_ICON = 69;
		static final int PRAYER_ICON = 70;
		static final int MAGIC_ICON = 71;
		static final int INTERFACE_CONTAINER = 72;
		static final int INVENTORY_CONTAINER = 78;
	}

	static class ResizableViewportBottomLine
	{
		static final int RESIZABLE_VIEWPORT_BOTTOM_LINE = 15;
		static final int MINIMAP = 90;
		static final int MINIMAP_DRAW_AREA = 29;
		static final int MINIMAP_ORB_HOLDER = 32;
		static final int LOGOUT_BUTTON_OVERLAY = 33;
		static final int MINIMAP_LOGOUT_BUTTON = 34;
		static final int FC_ICON = 43;
		static final int FRIEND_ICON = 45;
		static final int SETTINGS_ICON = 46;
		static final int EMOTE_ICON = 47;
		static final int MUSIC_ICON = 48;
		static final int INVENTORY_TAB = 54;
		static final int PRAYER_TAB = 56;
		static final int CMB_ICON = 58;
		static final int SKILLS_ICON = 59;
		static final int QUESTS_ICON = 60;
		static final int INVENTORY_ICON = 61;
		static final int EQUIP_ICON = 62;
		static final int PRAYER_ICON = 63;
		static final int MAGIC_ICON = 64;
		static final int INTERFACE_CONTAINER = 69;
		static final int INVENTORY_CONTAINER = 75;
	}

	static class Chatbox
	{
		static final int PARENT = 0;
		static final int BUTTONS = 1;
		static final int TAB_ALL = 4;
		static final int TAB_GAME = 7;
		static final int TAB_PUBLIC = 11;
		static final int TAB_PRIVATE = 15;
		static final int TAB_CHANNEL = 19;
		static final int TAB_CLAN = 23;
		static final int TAB_TRADE = 27;
		static final int REPORT_TEXT = 33;
		static final int FRAME = 34;
		static final int TRANSPARENT_BACKGROUND = 35;
		static final int CONTAINER = 37;
		static final int TITLE = 41;
		static final int FULL_INPUT = 42;
		static final int GE_SEARCH_RESULTS = 50;
		static final int MESSAGES = 53;
		static final int TRANSPARENT_BACKGROUND_LINES = 54;
		static final int INPUT = 55;
		static final int MESSAGE_LINES = 56;
		static final int FIRST_MESSAGE = 57;
	}

	static class Prayer
	{
		static final int THICK_SKIN = 5;
		static final int BURST_OF_STRENGTH = 6;
		static final int CLARITY_OF_THOUGHT = 7;
		static final int SHARP_EYE = 23;
		static final int MYSTIC_WILL = 24;
		static final int ROCK_SKIN = 8;
		static final int SUPERHUMAN_STRENGTH = 9;
		static final int IMPROVED_REFLEXES = 10;
		static final int RAPID_RESTORE = 11;
		static final int RAPID_HEAL = 12;
		static final int PROTECT_ITEM = 13;
		static final int HAWK_EYE = 25;
		static final int MYSTIC_LORE = 26;
		static final int STEEL_SKIN = 14;
		static final int ULTIMATE_STRENGTH = 15;
		static final int INCREDIBLE_REFLEXES = 16;
		static final int PROTECT_FROM_MAGIC = 17;
		static final int PROTECT_FROM_MISSILES = 18;
		static final int PROTECT_FROM_MELEE = 19;
		static final int EAGLE_EYE = 27;
		static final int MYSTIC_MIGHT = 28;
		static final int RETRIBUTION = 20;
		static final int REDEMPTION = 21;
		static final int SMITE = 22;
		static final int PRESERVE = 33;
		static final int CHIVALRY = 29;
		static final int PIETY = 30;
		static final int RIGOUR = 31;
		static final int AUGURY = 32;
	}

	public static class QuickPrayer
	{
		static final int PRAYERS = 4;

		public static final int THICK_SKIN_CHILD_ID = 0;
		public static final int BURST_OF_STRENGTH_CHILD_ID = 1;
		public static final int CLARITY_OF_THOUGHT_CHILD_ID = 2;
		public static final int SHARP_EYE_CHILD_ID = 18;
		public static final int MYSTIC_WILL_CHILD_ID = 19;
		public static final int ROCK_SKIN_CHILD_ID = 3;
		public static final int SUPERHUMAN_STRENGTH_CHILD_ID = 4;
		public static final int IMPROVED_REFLEXES_CHILD_ID = 5;
		public static final int RAPID_RESTORE_CHILD_ID = 6;
		public static final int RAPID_HEAL_CHILD_ID = 7;
		public static final int PROTECT_ITEM_CHILD_ID = 8;
		public static final int HAWK_EYE_CHILD_ID = 20;
		public static final int MYSTIC_LORE_CHILD_ID = 21;
		public static final int STEEL_SKIN_CHILD_ID = 9;
		public static final int ULTIMATE_STRENGTH_CHILD_ID = 10;
		public static final int INCREDIBLE_REFLEXES_CHILD_ID = 11;
		public static final int PROTECT_FROM_MAGIC_CHILD_ID = 12;
		public static final int PROTECT_FROM_MISSILES_CHILD_ID = 13;
		public static final int PROTECT_FROM_MELEE_CHILD_ID = 14;
		public static final int EAGLE_EYE_CHILD_ID = 22;
		public static final int MYSTIC_MIGHT_CHILD_ID = 23;
		public static final int RETRIBUTION_CHILD_ID = 15;
		public static final int REDEMPTION_CHILD_ID = 16;
		public static final int SMITE_CHILD_ID = 17;
		public static final int PRESERVE_CHILD_ID = 28;
		public static final int CHIVALRY_CHILD_ID = 25;
		public static final int PIETY_CHILD_ID = 26;
		public static final int RIGOUR_CHILD_ID = 24;
		public static final int AUGURY_CHILD_ID = 27;
	}

	static class Combat
	{
		static final int WEAPON_NAME = 1;
		static final int LEVEL = 3;
		static final int STYLE_ONE = 4;
		static final int STYLE_TWO = 8;
		static final int STYLE_THREE = 12;
		static final int STYLE_FOUR = 16;
		static final int SPELLS = 20;
		static final int DEFENSIVE_SPELL_BOX = 21;
		static final int DEFENSIVE_SPELL_ICON = 23;
		static final int DEFENSIVE_SPELL_SHIELD = 24;
		static final int DEFENSIVE_SPELL_TEXT = 25;
		static final int SPELL_BOX = 26;
		static final int SPELL_ICON = 28;
		static final int SPELL_TEXT = 29;
		static final int AUTO_RETALIATE = 30;
	}

	static class VolcanicMine
	{
		static final int STABILITY_INFOBOX_CONTAINER = 2;
		static final int TIME_LEFT = 6;
		static final int POINTS = 8;
		static final int STABILITY = 10;
		static final int PLAYER_COUNT = 12;
		static final int VENT_A_PERCENTAGE = 16;
		static final int VENT_B_PERCENTAGE = 17;
		static final int VENT_C_PERCENTAGE = 18;
		static final int VENT_A_STATUS = 20;
		static final int VENT_B_STATUS = 21;
		static final int VENT_C_STATUS = 22;
		static final int VENTS_INFOBOX_CONTAINER = 26;
	}

	static class BarbarianAssault
	{
		static class ATK
		{
			static final int ROLE_SPRITE = 11;
			static final int ROLE = 12;
		}

		static class HLR
		{
			static final int TEAMMATES = 13;
			static final int TEAMMATE1 = 18;
			static final int TEAMMATE2 = 22;
			static final int TEAMMATE3 = 26;
			static final int TEAMMATE4 = 30;
		}

		static final int TEAM = 2;

		static final int ROLE_SPRITE = 10;
		static final int ROLE = 11;

		static final int REWARD_TEXT = 57;
	}

	static class LevelUp
	{
		static final int SKILL = 1;
		static final int LEVEL = 2;
	}

	static class QuestCompleted
	{
		static final int NAME_TEXT = 4;
	}

	static class Raids
	{
		static final int POINTS_INFOBOX = 3;
	}

	static class Tob
	{
		static final int PARTY_INTERFACE = 5;
		static final int PARTY_STATS = 7;
		static final int HEALTHBAR_CONTAINER = 9;
	}

	static class PuzzleBox
	{
		static final int VISIBLE_BOX = 4;
	}

	static class LightBox
	{
		static final int LIGHT_BOX = 1;
		static final int LIGHT_BOX_WINDOW = 2;
		static final int LIGHT_BULB_CONTAINER = 3;
		static final int BUTTON_A = 8;
		static final int BUTTON_B = 9;
		static final int BUTTON_C = 10;
		static final int BUTTON_D = 11;
		static final int BUTTON_E = 12;
		static final int BUTTON_F = 13;
		static final int BUTTON_G = 14;
		static final int BUTTON_H = 15;
	}

	static class DialogSprite
	{
		static final int SPRITE = 1;
		static final int TEXT = 2;
	}

	static class ExperienceTracker
	{
		static final int WIDGET = 4;
		static final int BOTTOM_BAR = 16;
	}

	static class FairyRingPanel
	{
		static final int HEADER = 2;
		static final int LIST = 7;
		static final int FAVORITES = 8;
		static final int SEPARATOR = 9;
		static final int SCROLLBAR = 152;
	}

	static class FairyRing
	{
		static final int LEFT_ORB_CLOCKWISE = 19;
		static final int LEFT_ORB_COUNTER_CLOCKWISE = 20;
		static final int MIDDLE_ORB_CLOCKWISE = 21;
		static final int MIDDLE_ORB_COUNTER_CLOCKWISE = 22;
		static final int RIGHT_ORB_CLOCKWISE = 23;
		static final int RIGHT_ORB_COUNTER_CLOCKWISE = 24;
		static final int TELEPORT_BUTTON = 26;
	}

	static class FairyRingCode
	{
		static final int FAIRY_QUEEN_HIDEOUT = 139;
	}

	static class Barrows
	{
		static final int BARROWS_BROTHERS = 4;
		static final int BARROWS_POTENTIAL = 5;
	}

	static class Diary
	{
		static final int DIARY_TITLE = 2;
		static final int DIARY_TEXT = 3;
	}

	static class DestroyItem
	{
		static final int DESTROY_ITEM_NAME = 6;
		static final int DESTROY_ITEM_YES = 1;
		static final int DESTROY_ITEM_NO = 3;
	}

	static class VarrockMuseum
	{
		static final int VARROCK_MUSEUM_QUESTION = 28;
		static final int VARROCK_MUSEUM_FIRST_ANSWER = 29;
		static final int VARROCK_MUSEUM_SECOND_ANSWER = 30;
		static final int VARROCK_MUSEUM_THIRD_ANSWER = 31;
	}

	static class KillLog
	{
		static final int TITLE = 3;
		static final int MONSTER = 13;
		static final int KILLS = 14;
		static final int STREAK = 15;
	}

	static class WorldSwitcher
	{
		static final int WORLD_LIST = 16;
	}

	static class Minigames
	{
		static final int TELEPORT_BUTTON = 26;
	}

	static class StandardSpellBook
	{
		static final int LUMBRIDGE_HOME_TELEPORT = 5;
		static final int KOUREND_HOME_TELEPORT = 4;
	}

	static class AncientSpellBook
	{
		static final int EDGEVILLE_HOME_TELEPORT = 99;
	}

	static class LunarSpellBook
	{
		static final int LUNAR_HOME_TELEPORT = 100;
	}

	static class ArceuusSpellBook
	{
		static final int ARCEUUS_HOME_TELEPORT = 144;
	}

	static class Pvp
	{
		static final int KILLDEATH_RATIO = 26;
		static final int WILDERNESS_SKULL_CONTAINER = 44;
		static final int SKULL_CONTAINER = 45;
		static final int SAFE_ZONE = 47;
		static final int WILDERNESS_LEVEL = 50; // this can also be the Deadman Mode "Protection" text
	}

	static class KourendFavour
	{
		static final int KOUREND_FAVOUR_OVERLAY = 1;
	}

	static class Zeah
	{
		static final int MESS_HALL_COOKING_DISPLAY = 2;
	}

	static class LootingBag
	{
		static final int LOOTING_BAG_INVENTORY = 5;
	}

	static class Skotizo
	{
		static final int CONTAINER = 2;
	}

	static class QuestList
	{
		static final int BOX = 0;
		static final int SCROLLBAR = 4;
		static final int CONTAINER = 5;
		static final int FREE_CONTAINER = 6;
		static final int MEMBERS_CONTAINER = 7;
		static final int MINIQUEST_CONTAINER = 8;
	}

	static class Music
	{
		static final int CONTAINER = 0;
		static final int LIST = 3;
		static final int SCROLLBAR = 4;
	}

	static class Barrows_Puzzle
	{
		static final int PARENT = 0;
		static final int SEQUENCE_1 = 3;
		static final int ANSWER1_CONTAINER = 12;
		static final int ANSWER1 = 13;
		static final int ANSWER2_CONTAINER = 14;
		static final int ANSWER2 = 15;
		static final int ANSWER3_CONTAINER = 16;
		static final int ANSWER3 = 17;
	}

	static class SeedVault
	{
		static final int INVENTORY_ITEM_CONTAINER = 1;
		static final int TITLE_CONTAINER = 2;
		static final int ITEM_CONTAINER = 15;
		static final int ITEM_TEXT = 16;
	}

	static class ExplorersRing
	{
		static final int INVENTORY = 7;
	}

	static class SettingsSide
	{
		static final int CAMERA_ZOOM_SLIDER_TRACK = 98;
		static final int MUSIC_SLIDER = 27;
		static final int SOUND_EFFECT_SLIDER = 41;
		static final int AREA_SOUND_SLIDER = 55;
	}

	static class Settings
	{
		static final int INIT = 1;
	}

	static class AchievementDiary
	{
		static final int CONTAINER = 2;
	}

	static class Skills
	{
		static final int CONTAINER = 0;
	}

	static class Lms
	{
		static final int INFO = 2;
	}

	static class LmsKDA
	{
		static final int INFO = 4;
	}

	static class AdventureLog
	{
		static final int CONTAINER = 0;
	}

	static class CollectionLog
	{
		static final int CONTAINER = 0;
		static final int TABS = 3;
		static final int ENTRY = 17;
		static final int ENTRY_HEADER = 19;
		static final int ENTRY_ITEMS = 36;
	}

	static class GenericScroll
	{
		static final int TEXT = 7;
	}

	static class GauntletTimer
	{
		static final int CONTAINER = 2;
	}

	static class HallowedSepulchreTimer
	{
		static final int CONTAINER = 2;
	}

	static class BankPin
	{
		static final int CONTAINER = 0;
	}

	static class TrailblazerAreas
	{
		static final int TELEPORT = 59;
	}

	static class TemporossStatus
	{
		static final int STATUS_INDICATOR = 2;
	}

	static class Clan
	{
		static final int MEMBERS = 8;
	}

	static class ClanGuest
	{
		static final int MEMBERS = 8;
	}
}
