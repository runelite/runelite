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
public class WidgetID
{
	public static final int FAIRY_RING_PANEL_GROUP_ID = 381;
	public static final int FAIRY_RING_GROUP_ID = 398;
	public static final int LOGOUT_PANEL_ID = 182;
	public static final int BANK_GROUP_ID = 12;
	public static final int BANK_INVENTORY_GROUP_ID = 15;
	public static final int BANK_PIN_GROUP_ID = 213;
	public static final int GRAND_EXCHANGE_INVENTORY_GROUP_ID = 467;
	public static final int GRAND_EXCHANGE_GROUP_ID = 465;
	public static final int DEPOSIT_BOX_GROUP_ID = 192;
	public static final int INVENTORY_GROUP_ID = 149;
	public static final int FRIENDS_LIST_GROUP_ID = 429;
	public static final int IGNORE_LIST_GROUP_ID = 432;
	public static final int RAIDING_PARTY_GROUP_ID = 500;
	public static final int EQUIPMENT_GROUP_ID = 387;
	public static final int EQUIPMENT_INVENTORY_GROUP_ID = 85;
	public static final int EMOTES_GROUP_ID = 216;
	public static final int RUNE_POUCH_GROUP_ID = 190;
	public static final int DIARY_GROUP_ID = 259;
	public static final int PEST_CONTROL_BOAT_GROUP_ID = 407;
	public static final int PEST_CONTROL_GROUP_ID = 408;
	public static final int PEST_CONTROL_EXCHANGE_WINDOW_GROUP_ID = 243;
	public static final int DIALOG_MINIGAME_GROUP_ID = 229;
	public static final int CLAN_CHAT_GROUP_ID = 7;
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
	public static final int WORLD_MAP_MENU_GROUP_ID = 160;
	public static final int VOLCANIC_MINE_GROUP_ID = 611;
	public static final int BA_ATTACKER_GROUP_ID = 485;
	public static final int BA_COLLECTOR_GROUP_ID = 486;
	public static final int BA_DEFENDER_GROUP_ID = 487;
	public static final int BA_HEALER_GROUP_ID = 488;
	public static final int BA_REWARD_GROUP_ID = 497;
	public static final int BA_HORN_OF_GLORY = 484;
	public static final int LEVEL_UP_GROUP_ID = 233;
	public static final int DIALOG_SPRITE_GROUP_ID = 193;
	public static final int QUEST_COMPLETED_GROUP_ID = 277;
	public static final int CLUE_SCROLL_REWARD_GROUP_ID = 73;
	public static final int BARROWS_REWARD_GROUP_ID = 155;
	public static final int RAIDS_GROUP_ID = 513;
	public static final int MOTHERLODE_MINE_GROUP_ID = 382;
	public static final int MOTHERLODE_MINE_FULL_INVENTORY_GROUP_ID = 229;
	public static final int EXPERIENCE_DROP_GROUP_ID = 122;
	public static final int PUZZLE_BOX_GROUP_ID = 306;
	public static final int LIGHT_BOX_GROUP_ID = 322;
	public static final int NIGHTMARE_ZONE_GROUP_ID = 202;
	public static final int BLAST_FURNACE_GROUP_ID = 474;
	public static final int WORLD_MAP_GROUP_ID = 595;
	public static final int PYRAMID_PLUNDER_GROUP_ID = 428;
	public static final int CHAMBERS_OF_XERIC_REWARD_GROUP_ID = 539;
	public static final int THEATRE_OF_BLOOD_REWARD_GROUP_ID = 23;
	public static final int EXPERIENCE_TRACKER_GROUP_ID = 122;
	public static final int TITHE_FARM_GROUP_ID = 241;
	public static final int KINGDOM_GROUP_ID = 392;
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
	public static final int THEATRE_OF_BLOOD_GROUP_ID = 28;
	public static final int WORLD_SWITCHER_GROUP_ID = 69;
	public static final int DIALOG_OPTION_GROUP_ID = 219;
	public static final int DIALOG_PLAYER_GROUP_ID = 217;
	public static final int FOSSIL_ISLAND_OXYGENBAR_ID = 609;
	public static final int MINIGAME_TAB_ID = 76;
	public static final int SPELLBOOK_GROUP_ID = 218;
	public static final int PVP_GROUP_ID = 90;
	public static final int PERFORMERS_FOR_THE_THEATRE_GROUPS_GROUP_ID = 364;
	public static final int PERFORMERS_FOR_THE_THEATRE_PLAYERS_GROUP_ID = 50;
	public static final int FISHING_TRAWLER_GROUP_ID = 366;
	public static final int ZEAH_MESS_HALL_GROUP_ID = 235;
	public static final int KOUREND_FAVOUR_GROUP_ID = 246;
	public static final int LOOTING_BAG_GROUP_ID = 81;
	public static final int SKOTIZO_GROUP_ID = 308;
	public static final int ENTERING_HOUSE_GROUP_ID = 71;
	public static final int FULLSCREEN_MAP_GROUP_ID = 165;
	public static final int QUESTLIST_GROUP_ID = 399;
	public static final int SKILLS_GROUP_ID = 320;
	public static final int DIALOG_SPRITE2_ID = 11;
	public static final int EQUIPMENT_PAGE_GROUP_ID = 84;
	public static final int QUESTTAB_GROUP_ID = 629;
	public static final int MUSIC_GROUP_ID = 239;
	public static final int MUSICTAB_GROUP_ID = 239;
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
	public static final int ITEMS_KEPT_ON_DEATH_GROUP_ID = 4;
	public static final int TRADING_SCREEN = 335;
	public static final int SEED_VAULT_GROUP_ID = 631;
	public static final int EXPLORERS_RING_ALCH_GROUP_ID = 483;
	public static final int LMS_GROUP_ID = 333;
	public static final int LMS_INGAME_GROUP_ID = 328;
	public static final int JEWELLERY_BOX_GROUP_ID = 590;

	static class WorldMap
	{
		static final int MAPVIEW = 6;
		static final int OVERVIEW_MAP = 9;
		static final int SEARCH = 24;
		static final int SURFACE_SELECTOR = 32;
		static final int TOOLTIP = 38;
		static final int OPTION = 43;
	}

	static class SlayerRewards
	{
		static final int TOP_BAR = 12;
	}

	static class DialogNPC
	{
		static final int HEAD_MODEL = 1;
		static final int NAME = 2;
		static final int CONTINUE = 3;
		static final int TEXT = 4;
	}

	static class LogoutPanel
	{
		static final int WORLD_SWITCHER_BUTTON = 3;
		static final int LOGOUT_BUTTON = 6;
	}

	static class PestControlBoat
	{
		static final int INFO = 3;

		static final int NEXT_DEPARTURE = 4;
		static final int PLAYERS_READY = 5;
		static final int POINTS = 6;
	}

	static class PestControlExchangeWindow
	{
		static final int ITEM_LIST = 2;
		static final int BOTTOM = 5;
		static final int POINTS = 8;
		static final int CONFIRM_BUTTON = 6;
	}

	static class MinigameDialog
	{
		static final int TEXT = 1;
		static final int CONTINUE = 2;
	}

	static class PestControl
	{
		static final int INFO = 3;

		static final int TIME = 6;

		static final int ACTIVITY_BAR = 12;
		static final int ACTIVITY_PROGRESS = 14;

		static final int PURPLE_SHIELD = 15;
		static final int BLUE_SHIELD = 16;
		static final int YELLOW_SHIELD = 17;
		static final int RED_SHIELD = 18;

		static final int PURPLE_ICON = 19;
		static final int BLUE_ICON = 20;
		static final int YELLOW_ICON = 21;
		static final int RED_ICON = 22;

		static final int PURPLE_HEALTH = 23;
		static final int BLUE_HEALTH = 24;
		static final int YELLOW_HEALTH = 25;
		static final int RED_HEALTH = 26;
	}

	static class FriendList
	{
		static final int TITLE = 3;
	}

	static class IgnoreList
	{
		static final int TITLE = 3;
	}

	static class ClanChat
	{
		static final int TITLE = 1;
		static final int NAME = 4;
		static final int OWNER = 6;
		static final int LIST = 16;
	}

	static class Bank
	{
		static final int BANK_CONTAINER = 1;
		static final int INVENTORY_ITEM_CONTAINER = 3;
		static final int BANK_TITLE_BAR = 4;
		static final int CONTENT_CONTAINER = 10;
		static final int TAB_CONTAINER = 11;
		static final int ITEM_CONTAINER = 13;
		static final int SEARCH_BUTTON_BACKGROUND = 40;
		static final int DEPOSIT_INVENTORY = 42;
		static final int DEPOSIT_EQUIPMENT = 44;
		static final int INCINERATOR = 46;
		static final int INCINERATOR_CONFIRM = 47;
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
		static final int ITEMS_CONTAINER = 2;
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
		static final int HELMET = 6;
		static final int CAPE = 7;
		static final int AMULET = 8;
		static final int WEAPON = 9;
		static final int BODY = 10;
		static final int SHIELD = 11;
		static final int LEGS = 12;
		static final int GLOVES = 13;
		static final int BOOTS = 14;
		static final int RING = 15;
		static final int AMMO = 16;
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
		static final int PRAYER_ORB = 12;
		static final int QUICK_PRAYER_ORB = 14; // Has the "Quick-prayers" name
		static final int RUN_ORB = 20;
		static final int TOGGLE_RUN_ORB = 22; // Has the "Toggle run" name
		static final int RUN_ORB_TEXT = 23;
		static final int SPEC_ORB = 28;
		static final int WORLDMAP_ORB = 41;
	}

	static class LoginClickToPlayScreen
	{
		static final int MESSAGE_OF_THE_DAY = 7;
	}

	static class Viewport
	{
		static final int MINIMAP_RESIZABLE_WIDGET = 17;
		static final int MINIMAP_RESIZABLE_CLICKBOX = 18;
		static final int MINIMAP_RESIZABLE_DRAW_AREA = 25;
		static final int MINIMAP_RESIZABLE_DECORATIONS = 27;
		static final int MINIMAP_RESIZABLE_ORB_HOLDER = 28;
		static final int MINIMAP_RESIZABLE_LOGOUT_BUTTON = 30;
		static final int FIXED_VIEWPORT = 17;
		static final int RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX = 12;
		static final int RESIZABLE_VIEWPORT_BOTTOM_LINE = 12;
	}

	static class FixedViewport
	{
		static final int MINIMAP = 3;
		static final int MINIMAP_DRAW_AREA = 8;
		static final int MULTICOMBAT_INDICATOR = 20;
		static final int BANK_PIN = 21;
		static final int CLAN_CHAT_TAB = 31;
		static final int FRIENDS_TAB = 33;
		static final int IGNORES_TAB = 32;
		static final int LOGOUT_TAB = 34;
		static final int OPTIONS_TAB = 35;
		static final int EMOTES_TAB = 36;
		static final int MUSIC_TAB = 37;
		static final int CLAN_CHAT_ICON = 38;
		static final int FRIENDS_ICON = 40;
		static final int IGNORES_ICON = 39;
		static final int LOGOUT_ICON = 41;
		static final int OPTIONS_ICON = 42;
		static final int EMOTES_ICON = 43;
		static final int MUSIC_ICON = 44;
		static final int COMBAT_TAB = 48;
		static final int STATS_TAB = 49;
		static final int QUESTS_TAB = 50;
		static final int INVENTORY_TAB = 51;
		static final int EQUIPMENT_TAB = 52;
		static final int PRAYER_TAB = 53;
		static final int MAGIC_TAB = 54;
		static final int COMBAT_ICON = 55;
		static final int STATS_ICON = 56;
		static final int QUESTS_ICON = 57;
		static final int INVENTORY_ICON = 58;
		static final int EQUIPMENT_ICON = 59;
		static final int PRAYER_ICON = 60;
		static final int MAGIC_ICON = 61;
		static final int ROOT_INTERFACE_CONTAINER = 62;
		static final int BANK_CONTAINER = 64;
		static final int INTERFACE_CONTAINER = 65;
		static final int INVENTORY_CONTAINER = 69;
	}

	static class ResizableViewport
	{
		static final int ITEMS_KEPT_ON_DEATH = 13;
		static final int BANK_PIN = 13;
		static final int MULTICOMBAT_INDICATOR = 16;
		static final int CLAN_CHAT_TAB = 35;
		static final int FRIENDS_TAB = 37;
		static final int IGNORES_TAB = 36;
		static final int LOGOUT_TAB = 38;
		static final int OPTIONS_TAB = 39;
		static final int EMOTES_TAB = 40;
		static final int MUSIC_TAB = 41;
		static final int CLAN_CHAT_ICON = 42;
		static final int FRIENDS_ICON = 44;
		static final int IGNORES_ICON = 43;
		static final int LOGOUT_ICON = 45;
		static final int OPTIONS_ICON = 46;
		static final int EMOTES_ICON = 47;
		static final int MUSIC_ICON = 48;
		static final int COMBAT_TAB = 51;
		static final int STATS_TAB = 52;
		static final int QUESTS_TAB = 53;
		static final int INVENTORY_TAB = 54;
		static final int EQUIPMENT_TAB = 55;
		static final int PRAYER_TAB = 56;
		static final int MAGIC_TAB = 57;
		static final int COMBAT_ICON = 58;
		static final int STATS_ICON = 59;
		static final int QUESTS_ICON = 60;
		static final int INVENTORY_ICON = 61;
		static final int EQUIPMENT_ICON = 62;
		static final int PRAYER_ICON = 63;
		static final int MAGIC_ICON = 64;
		static final int INTERFACE_CONTAINER = 65;
		static final int INVENTORY_CONTAINER = 71;
	}

	static class ResizableViewportBottomLine
	{
		static final int BANK_PIN = 13;
		static final int LOGOUT_BUTTON_OVERLAY = 29;
		static final int CMB_TAB = 50;
		static final int CMB_ICON = 57;
		static final int SKILLS_TAB = 51;
		static final int SKILLS_ICON = 58;
		static final int QUESTS_TAB = 52;
		static final int QUESTS_ICON = 59;
		static final int INVENTORY_TAB = 53;
		static final int INVENTORY_ICON = 60;
		static final int EQUIP_TAB = 54;
		static final int EQUIP_ICON = 61;
		static final int PRAYER_TAB = 55;
		static final int PRAYER_ICON = 62;
		static final int MAGIC_TAB = 56;
		static final int SPELL_ICON = 53;
		static final int FC_TAB = 35;
		static final int FC_ICON = 41;
		static final int IGNORE_TAB = 36;
		static final int IGNORE_ICON = 42;
		static final int FRIEND_TAB = 37;
		static final int FRIEND_ICON = 43;
		static final int SETTINGS_TAB = 38;
		static final int SETTINGS_ICON = 44;
		static final int EMOTE_TAB = 39;
		static final int EMOTE_ICON = 45;
		static final int MUSIC_TAB = 40;
		static final int MUSIC_ICON = 46;
		static final int MAGIC_ICON = 63;
		static final int INVENTORY_CONTAINER = 71;
	}

	static class Chatbox
	{
		static final int PARENT = 0;
		static final int BUTTONS = 1;
		static final int REPORT_TEXT = 36;
		static final int FRAME = 37;
		static final int TRANSPARENT_BACKGROUND = 38;
		static final int CONTAINER = 40;
		static final int TITLE = 44;
		static final int FULL_INPUT = 45;
		static final int MESSAGES = 55;
		static final int TRANSPARENT_BACKGROUND_LINES = 56;
		static final int INPUT = 57;
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
		static final int SPECIAL_ATTACK_BAR = 34;
		static final int TOOLTIP = 41;
	}

	static class VolcanicMine
	{
		static final int GENERAL_INFOBOX_GROUP_ID = 4;
		static final int TIME_LEFT = 8;
		static final int POINTS = 10;
		static final int STABILITY = 12;
		static final int PLAYER_COUNT = 14;
		static final int VENTS_INFOBOX_GROUP_ID = 15;
		static final int VENT_A_PERCENTAGE = 19;
		static final int VENT_B_PERCENTAGE = 20;
		static final int VENT_C_PERCENTAGE = 21;
		static final int VENT_A_STATUS = 23;
		static final int VENT_B_STATUS = 24;
		static final int VENT_C_STATUS = 25;
	}

	static class BarbarianAssault
	{
		static class ATK
		{
			static final int LISTEN_TOP = 7;
			static final int LISTEN_BOTTOM = 8;
			static final int TO_CALL_WIDGET = 9;
			static final int TO_CALL = 10;
			static final int ROLE_SPRITE = 11;
			static final int ROLE = 12;
		}
		static class HLR
		{
			static final int TEAMMATE1 = 18;
			static final int TEAMMATE2 = 22;
			static final int TEAMMATE3 = 26;
			static final int TEAMMATE4 = 30;
		}
		static class HORN_GLORY
		{
			static final int ATTACKER = 5;
			static final int DEFENDER = 6;
			static final int COLLECTOR = 7;
			static final int HEALER = 8;
		}
		static class REWARD_VALUES
		{
			static final int RUNNERS_PASSED = 14;
			static final int HITPOINTS_REPLENISHED = 19;
			static final int WRONG_POISON_PACKS_USED = 20;
			static final int EGGS_COLLECTED = 21;
			static final int FAILED_ATTACKER_ATTACKS = 22;
			static final int RUNNERS_PASSED_POINTS = 24;
			static final int RANGERS_KILLED = 25;
			static final int FIGHTERS_KILLED = 26;
			static final int HEALERS_KILLED = 27;
			static final int RUNNERS_KILLED = 28;
			static final int HITPOINTS_REPLENISHED_POINTS = 29;
			static final int WRONG_POISON_PACKS_USED_POINTS = 30;
			static final int EGGS_COLLECTED_POINTS = 31;
			static final int FAILED_ATTACKER_ATTACKS_POINTS = 32;
			static final int BASE_POINTS = 33;
			static final int HONOUR_POINTS_REWARD = 49;
		}
		static final int GAME_WIDGET = 3;
		static final int CURRENT_WAVE_WIDGET = 4;
		static final int CURRENT_WAVE = 5;
		static final int LISTEN_WIDGET = 6;
		static final int LISTEN = 7;
		static final int TO_CALL_WIDGET = 8;
		static final int TO_CALL = 9;
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
		static final int NAME_TEXT = 2;
	}

	static class Raids
	{
		static final int POINTS_INFOBOX = 6;
	}

	static class TheatreOfBlood
	{
		static final int RAIDING_PARTY = 9;
		static final int ORB_BOX = 10;
		static final int BOSS_HEALTH_BAR = 35;
	}

	static class ExperienceDrop
	{
		static final int DROP_1 = 15;
		static final int DROP_2 = 16;
		static final int DROP_3 = 17;
		static final int DROP_4 = 18;
		static final int DROP_5 = 19;
		static final int DROP_6 = 20;
		static final int DROP_7 = 21;
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
		static final int WIDGET = 3;
		static final int BOTTOM_BAR = 15;
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
		static final int BARROWS_BROTHERS = 9;
		static final int BARROWS_POTENTIAL = 10;
		static final int BARROWS_REWARD_INVENTORY = 3;
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

	static class EquipmentWidgetIdentifiers
	{
		static final int EQUIP_YOUR_CHARACTER = 3;
		static final int STAB_ATTACK_BONUS = 23;
		static final int SLASH_ATTACK_BONUS = 24;
		static final int CRUSH_ATTACK_BONUS = 25;
		static final int MAGIC_ATTACK_BONUS = 26;
		static final int RANGED_ATTACK_BONUS = 27;
		static final int STAB_DEFENCE_BONUS = 29;
		static final int SLASH_DEFENCE_BONUS = 30;
		static final int CRUSH_DEFENCE_BONUS = 31;
		static final int MAGIC_DEFENCE_BONUS = 32;
		static final int RANGED_DEFENCE_BONUS = 33;
		static final int MELEE_STRENGTH = 35;
		static final int RANGED_STRENGTH = 36;
		static final int MAGIC_DAMAGE = 37;
		static final int PRAYER_BONUS = 38;
		static final int UNDEAD_DAMAGE_BONUS = 40;
		static final int SLAYER_DAMAGE_BONUS = 41;
		static final int WEIGHT = 43;
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

	static class FossilOxygen
	{
		static final int FOSSIL_ISLAND_OXYGEN_BAR = 4;
	}

	static class Minigames
	{
		static final int TELEPORT_BUTTON = 26;
	}

	static class SpellBook
	{
		static final int FILTERED_SPELLS_PARENT = 1;
		static final int FILTERED_SPELLS_BOUNDS = 3;

		// NORMAL SPELLS
		static final int LUMBRIDGE_HOME_TELEPORT = 4;
		static final int WIND_STRIKE = 5;
		static final int CONFUSE = 6;
		static final int ENCHANT_CROSSBOW_BOLT = 7;
		static final int WATER_STRIKE = 8;
		static final int LVL_1_ENCHANT = 9;
		static final int EARTH_STRIKE = 10;
		static final int WEAKEN = 11;
		static final int FIRE_STRIKE = 12;
		static final int BONES_TO_BANANAS = 13;
		static final int WIND_BOLT = 14;
		static final int CURSE = 15;
		static final int BIND = 16;
		static final int LOW_LEVEL_ALCHEMY = 17;
		static final int WATER_BOLT = 18;
		static final int VARROCK_TELEPORT = 19;
		static final int LVL_2_ENCHANT = 20;
		static final int EARTH_BOLT = 21;
		static final int LUMBRIDGE_TELEPORT = 22;
		static final int TELEKINETIC_GRAB = 23;
		static final int FIRE_BOLT = 24;
		static final int FALADOR_TELEPORT = 25;
		static final int CRUMBLE_UNDEAD = 26;
		static final int TELEPORT_TO_HOUSE = 27;
		static final int WIND_BLAST = 28;
		static final int SUPERHEAT_ITEM = 29;
		static final int CAMELOT_TELEPORT = 30;
		static final int WATER_BLAST = 31;
		static final int LVL_3_ENCHANT = 32;
		static final int IBAN_BLAST = 33;
		static final int SNARE = 34;
		static final int MAGIC_DART = 35;
		static final int ARDOUGNE_TELEPORT = 36;
		static final int EARTH_BLAST = 37;
		static final int HIGH_LEVEL_ALCHEMY = 38;
		static final int CHARGE_WATER_ORB = 39;
		static final int LVL_4_ENCHANT = 40;
		static final int WATCHTOWER_TELEPORT = 41;
		static final int FIRE_BLAST = 42;
		static final int CHARGE_EARTH_ORB = 43;
		static final int BONES_TO_PEACHES = 44;
		static final int SARADOMIN_STRIKE = 45;
		static final int CLAWS_OF_GUTHIX = 46;
		static final int FLAMES_OF_ZAMORAK = 47;
		static final int TROLLHEIM_TELEPORT = 48;
		static final int WIND_WAVE = 49;
		static final int CHARGE_FIRE_ORB = 50;
		static final int TELEPORT_TO_APE_ATOLL = 51;
		static final int WATER_WAVE = 52;
		static final int CHARGE_AIR_ORB = 53;
		static final int VULNERABILITY = 54;
		static final int LVL_5_ENCHANT = 55;
		static final int TELEPORT_TO_KOUREND = 56;
		static final int EARTH_WAVE = 57;
		static final int ENFEEBLE = 58;
		static final int TELEOTHER_LUMBRIDGE = 59;
		static final int FIRE_WAVE = 60;
		static final int ENTANGLE = 61;
		static final int STUN = 62;
		static final int CHARGE = 63;
		static final int WIND_SURGE = 64;
		static final int TELEOTHER_FALADOR = 65;
		static final int WATER_SURGE = 66;
		static final int TELE_BLOCK = 67;
		static final int BOUNTY_TARGET_TELEPORT = 68;
		static final int LVL_6_ENCHANT = 69;
		static final int TELEOTHER_CAMELOT = 70;
		static final int EARTH_SURGE = 71;
		static final int LVL_7_ENCHANT = 72;
		static final int FIRE_SURGE = 73;

		// ANCIENT SPELLS
		static final int ICE_RUSH = 74;
		static final int ICE_BLITZ = 75;
		static final int ICE_BURST = 76;
		static final int ICE_BARRAGE = 77;
		static final int BLOOD_RUSH = 78;
		static final int BLOOD_BLITZ = 79;
		static final int BLOOD_BURST = 80;
		static final int BLOOD_BARRAGE = 81;
		static final int SMOKE_RUSH = 82;
		static final int SMOKE_BLITZ = 83;
		static final int SMOKE_BURST = 84;
		static final int SMOKE_BARRAGE = 85;
		static final int SHADOW_RUSH = 86;
		static final int SHADOW_BLITZ = 87;
		static final int SHADOW_BURST = 88;
		static final int SHADOW_BARRAGE = 89;
		static final int PADDEWWA_TELEPORT = 90;
		static final int SENNTISTEN_TELEPORT = 91;
		static final int KHARYRLL_TELEPORT = 92;
		static final int LASSAR_TELEPORT = 93;
		static final int DAREEYAK_TELEPORT = 94;
		static final int CARRALLANGER_TELEPORT = 95;
		static final int ANNAKARL_TELEPORT = 96;
		static final int GHORROCK_TELEPORT = 97;
		static final int EDGEVILLE_HOME_TELEPORT = 98;
		static final int TOOLTIP = 188;


		// LUNAR SPELLS
		static final int LUNAR_HOME_TELEPORT = 99;
		static final int BAKE_PIE = 100;
		static final int CURE_PLANT = 101;
		static final int MONSTER_EXAMINE = 102;
		static final int NPC_CONTACT = 103;
		static final int CURE_OTHER = 104;
		static final int HUMIDIFY = 105;
		static final int MOONCLAN_TELEPORT = 106;
		static final int TELE_GROUP_MOONCLAN = 107;
		static final int CURE_ME = 108;
		static final int HUNTER_KIT = 109;
		static final int WATERBIRTH_TELEPORT = 110;
		static final int TELE_GROUP_WATERBIRTH = 111;
		static final int CURE_GROUP = 112;
		static final int STAT_SPY = 113;
		static final int BARBARIAN_TELEPORT = 114;
		static final int TELE_GROUP_BARBARIAN = 115;
		static final int SUPERGLASS_MAKE = 116;
		static final int TAN_LEATHER = 117;
		static final int KHAZARD_TELEPORT = 118;
		static final int TELE_GROUP_KHAZARD = 119;
		static final int DREAM = 120;
		static final int STRING_JEWELLERY = 121;
		static final int STAT_RESTORE_POT_SHARE = 122;
		static final int MAGIC_IMBUE = 123;
		static final int FERTILE_SOIL = 124;
		static final int BOOST_POTION_SHARE = 125;
		static final int FISHING_GUILD_TELEPORT = 126;
		static final int TELE_GROUP_FISHING_GUILD = 127;
		static final int PLANK_MAKE = 128;
		static final int CATHERBY_TELEPORT = 129;
		static final int TELE_GROUP_CATHERBY = 130;
		static final int RECHARGE_DRAGONSTONE = 131;
		static final int ICE_PLATEAU_TELEPORT = 132;
		static final int TELE_GROUP_ICE_PLATEAU = 133;
		static final int ENERGY_TRANSFER = 134;
		static final int HEAL_OTHER = 135;
		static final int VENGEANCE_OTHER = 136;
		static final int VENGEANCE = 137;
		static final int HEAL_GROUP = 138;
		static final int SPELLBOOK_SWAP = 139;
		static final int GEOMANCY = 140;
		static final int SPIN_FLAX = 141;
		static final int OURANIA_TELEPORT = 142;

		// ARCEUUS SPELLS
		static final int ARCEUUS_HOME_TELEPORT = 143;
		static final int BATTLEFRONT_TELEPORT = 178;

		static final int FILTER_SECTION_PARENT = 181;
		static final int FILTER_BUTTONS_PARENT = 184;
		static final int FILTER_BUTTON_PARENT = 185;
		static final int FILTER_BUTTON = 187;
	}

	static class Pvp
	{
		static final int FOG_OVERLAY = 1;
		static final int PVP_WIDGET_CONTAINER = 54;  // OUTDATED?
		static final int SKULL = 56;  // OUTDATED?
		static final int ATTACK_RANGE = 59;  // OUTDATED?
		static final int BOUNTY_HUNTER_INFO = 6;
		static final int KILLDEATH_RATIO = 33;
		static final int SKULL_CONTAINER = 53;
		static final int SAFE_ZONE = 55;
		static final int WILDERNESS_LEVEL = 57; // this can also be the Deadman Mode "Protection" text
	}

	static class KourendFavour
	{
		static final int KOUREND_FAVOUR_OVERLAY = 1;
	}

	static class Zeah
	{
		static final int MESS_HALL_COOKING_DISPLAY = 3;
	}

	static class LootingBag
	{
		static final int LOOTING_BAG_INVENTORY = 5;
	}

	static class Skotizo
	{
		static final int CONTAINER = 3;
	}

	static class FullScreenMap
	{
		static final int ROOT = 25;
	}

	static class QuestList
	{
		static final int BOX = 0;
		static final int SCROLLBAR = 3;
		static final int CONTAINER = 5;
		static final int FREE_CONTAINER = 6;
		static final int MEMBERS_CONTAINER = 7;
		static final int MINIQUEST_CONTAINER = 8;
	}

	static class DialogSprite2
	{
		static final int SPRITE1 = 1;
		static final int TEXT = 2;
		static final int SPRITE2 = 3;
		static final int CONTINUE = 4;
	}

	static class QuestTab
	{
		static final int QUEST_TAB = 3;
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
		static final int CONTAINER = 1;
		static final int TOP_ROW_PUZZLE = 2;
		static final int SEQUENCE_1 = 3;
		static final int SEQUENCE_1_TEXT = 4;
		static final int SEQUENCE_2 = 5;
		static final int SEQUENCE_2_TEXT = 6;
		static final int SEQUENCE_3 = 7;
		static final int SEQUENCE_3_TEXT = 8;
		static final int SEQUENCE_4 = 9;
		static final int SEQUENCE_4_TEXT = 10;
		static final int NEXT_SHAPE_TEXT = 11;
		static final int ANSWER1_CONTAINER = 12;
		static final int ANSWER1 = 13;
		static final int ANSWER2_CONTAINER = 14;
		static final int ANSWER2 = 15;
		static final int ANSWER3_CONTAINER = 16;
		static final int ANSWER3 = 17;
	}

	static class KeptOnDeath
	{
		static final int KEPT_ITEMS_CONTAINER = 18;
		static final int KEPT_ITEMS_TEXT = 17;
		static final int LOST_ITEMS_TEXT = 20;
		static final int LOST_ITEMS_CONTAINER = 21;
		static final int LOST_ITEMS_VALUE = 23;
		static final int INFORMATION_CONTAINER = 29;
		static final int MAX_ITEMS_KEPT_ON_DEATH = 30;
		static final int SAFE_ZONE_CONTAINER = 31;
		static final int CUSTOM_TEXT_CONTAINER = 33;
	}

	public static class TradeScreen
	{
		public static final int SECOND_GROUP_ID = 334;
		public static final int SECOND_TRADING_WITH = 30;
		public static final int SECOND_MY_OFFER = 23;
		public static final int SECOND_THEIR_OFFER = 24;
		public static final int SECOND_ACCEPT_FUNC = 13;
		public static final int SECOND_ACCEPT_TEXT = 25;
	}

	public static class DuelConfig
	{
		public static final int CONFIG_GROUP_IP = 482;
		public static final int TITLE = 35;
		public static final int OPPONENT_ATT = 9;
		public static final int OPPONENT_STR = 13;
		public static final int OPPONENT_DEF = 17;
		public static final int OPPONENT_HP = 21;
	}

	public static class DuelResult
	{
		public static final int RESULT_GROUP_ID = 372;
		public static final int TITLE = 16;
		public static final int TOTAL_STAKED = 32;
		public static final int TOTAL_TAX = 39;
		public static final int WINNINGS = 40;
	}

	// Also used for many other interfaces!
	static class BankPin
	{
		static final int TOP_LEFT_TEXT = 2;
		static final int FIRST_ENTERED = 3;
		static final int SECOND_ENTERED = 4;
		static final int THIRD_ENTERED = 5;
		static final int FOURTH_ENTERED = 6;
		static final int INSTRUCTION_TEXT = 10;
		static final int EXIT_BUTTON = 13;
		static final int FORGOT_BUTTON = 15;
		static final int BUTTON_1 = 16;
		static final int BUTTON_2 = 18;
		static final int BUTTON_3 = 20;
		static final int BUTTON_4 = 22;
		static final int BUTTON_5 = 24;
		static final int BUTTON_6 = 26;
		static final int BUTTON_7 = 28;
		static final int BUTTON_8 = 30;
		static final int BUTTON_9 = 32;
		static final int BUTTON_10 = 34;
	}

	static class SeedVault
	{
		static final int TITLE_CONTAINER = 2;
		static final int ITEM_CONTAINER = 15;
		static final int ITEM_TEXT = 16;
	}

	static class ExplorersRing
	{
		static final int INVENTORY = 7;
	}

	static class Lms
	{
		static final int INFO = 2;
	}
	static class LmsKDA
	{
		static final int INFO = 4;
	}

	static class JewelBox
	{
		static final int DUEL_RING = 2;
		static final int GAME_NECK = 3;
		static final int COMB_BRAC = 4;
		static final int SKIL_NECK = 5;
		static final int RING_OFGP = 6;
		static final int AMUL_GLOR = 7; // yes
	}
}
