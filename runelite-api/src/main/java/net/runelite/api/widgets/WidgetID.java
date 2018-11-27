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
	public static final int LEVEL_UP_GROUP_ID = 233;
	public static final int DIALOG_SPRITE_GROUP_ID = 193;
	public static final int QUEST_COMPLETED_GROUP_ID = 277;
	public static final int CLUE_SCROLL_REWARD_GROUP_ID = 73;
	public static final int BARROWS_REWARD_GROUP_ID = 155;
	public static final int RAIDS_GROUP_ID = 513;
	public static final int MOTHERLODE_MINE_GROUP_ID = 382;
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
	public static final int THEATRE_OF_BLOOD_GROUP_ID = 23;
	public static final int WORLD_SWITCHER_GROUP_ID = 69;
	public static final int DIALOG_OPTION_GROUP_ID = 219;
	public static final int DIALOG_PLAYER_GROUP_ID = 217;
	public static final int FOSSIL_ISLAND_OXYGENBAR_ID = 609;
	public static final int MINIGAME_TAB_ID = 76;
	public static final int SPELLBOOK_GROUP_ID = 218;
	public static final int PVP_GROUP_ID = 90;
	public static final int ZEAH_MESS_HALL_GROUP_ID = 235;
	public static final int KOUREND_FAVOUR_GROUP_ID = 246;
	public static final int LOOTING_BAG_GROUP_ID = 81;
	public static final int SKOTIZO_GROUP_ID = 308;
	public static final int ENTERING_HOUSE_GROUP_ID = 71;
	public static final int FULLSCREEN_MAP_GROUP_ID = 165;
	public static final int QUESTLIST_GROUP_ID = 399;

	static class WorldMap
	{
		static final int MAPVIEW = 6;
		static final int OVERVIEW_MAP = 9;
		static final int SEARCH = 24;
		static final int SURFACE_SELECTOR = 32;
		static final int TOOLTIP = 38;
		static final int OPTION = 42;
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
	}

	static class PestControl
	{
		static final int INFO = 3;

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
		static final int NAME = 3;
		static final int OWNER = 5;
		static final int LIST = 15;
	}

	static class Bank
	{
		static final int BANK_CONTAINER = 1;
		static final int INVENTORY_ITEM_CONTAINER = 3;
		static final int BANK_TITLE_BAR = 4;
		static final int CONTENT_CONTAINER = 10;
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
		static final int WORLDMAP_ORB = 40;
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
	}

	static class ResizableViewport
	{
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
	}

	static class ResizableViewportBottomLine
	{
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
		static final int SPELL_TAB = 56;
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
		static final int LEVEL = 2;
		static final int STYLE_ONE = 3;
		static final int STYLE_TWO = 7;
		static final int STYLE_THREE = 11;
		static final int STYLE_FOUR = 15;
		static final int SPELLS = 19;
		static final int DEFENSIVE_SPELL_BOX = 20;
		static final int DEFENSIVE_SPELL_ICON = 22;
		static final int DEFENSIVE_SPELL_SHIELD = 23;
		static final int DEFENSIVE_SPELL_TEXT = 24;
		static final int SPELL_BOX = 25;
		static final int SPELL_ICON = 27;
		static final int SPELL_TEXT = 28;
		static final int AUTO_RETALIATE = 29;
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
			static final int CALL_TEXT = 8;
			static final int TO_CALL_WIDGET = 9;
			static final int TO_CALL = 10;
			static final int ROLE_SPRITE = 11;
			static final int ROLE = 12;
		}
		static final int CORRECT_STYLE = 3;
		static final int CURRENT_WAVE_WIDGET = 4;
		static final int CURRENT_WAVE = 5;
		static final int CALL_WIDGET = 6;
		static final int CALL_TEXT = 7;
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
		static final int POINTS_INFOBOX = 3;
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
		static final int TELEPORT_BUTTON = 31;
	}

	static class StandardSpellBook
	{
		static final int LUMBRIDGE_HOME_TELEPORT = 4;
	}

	static class AncientSpellBook
	{
		static final int EDGEVILLE_HOME_TELEPORT = 98;
	}

	static class LunarSpellBook
	{
		static final int LUNAR_HOME_TELEPORT = 99;
	}

	static class ArceuusSpellBook
	{
		static final int ARCEUUS_HOME_TELEPORT = 143;
	}

	static class Pvp
	{
		static final int BOUNTY_HUNTER_INFO = 6;
		static final int KILLDEATH_RATIO = 9;
		static final int BOUNTY_HUNTER_STATS = 28;
		static final int PVP_WIDGET_CONTAINER = 54;
		static final int SKULL_CONTAINER = 55;
		static final int SKULL = 56;
		static final int SAFE_ZONE = 57;
		static final int ATTACK_RANGE = 59;
		static final int WILDERNESS_LEVEL = 60; // this can also be the Deadman Mode "Protection" text
		static final int DEADMAN_PROTECTION_TIME = 61;
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
		static final int FREE_CONTAINER = 9;
		static final int MEMBERS_CONTAINER = 10;
		static final int MINIQUEST_CONTAINER = 11;
	}
}
