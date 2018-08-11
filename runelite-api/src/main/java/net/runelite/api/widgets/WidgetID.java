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
	public static final int DIARY_QUEST_GROUP_ID = 275;
	public static final int THEATRE_OF_BLOOD_GROUP_ID = 23;
	public static final int WORLD_SWITCHER_GROUP_ID = 69;
	public static final int DIALOG_OPTION_GROUP_ID = 219;
	public static final int DIALOG_PLAYER_GROUP_ID = 217;
	public static final int FOSSIL_ISLAND_OXYGENBAR_ID = 609;
	public static final int SPELLBOOK_GROUP_ID = 218;

	static class WorldMap
	{
		static final int OPTION = 42;
		static final int TOOLTIP = 35;
		static final int MAPVIEW = 3;
		static final int SEARCH = 21;
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

	static class PestControl
	{
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
	}

	static class Bank
	{
		static final int ITEM_CONTAINER = 23;
		static final int INVENTORY_ITEM_CONTAINER = 3;
		static final int BANK_TITLE_BAR = 15;
		static final int BANK_ITEM_COUNT = 16;
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
	}

	static class LoginClickToPlayScreen
	{
		static final int MESSAGE_OF_THE_DAY = 3;
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
	}

	static class Chatbox
	{
		static final int CHATBOX_PARENT = 0;
		static final int CHATBOX_BUTTONS = 1;
		static final int CHATBOX_REPORT_TEXT = 29;
		static final int CHATBOX_FRAME = 30;
		static final int CHATBOX_MESSAGES = 48;
		static final int CHATBOX_INPUT = 50;
	}

	static class Prayer
	{
		static final int THICK_SKIN = 4;
		static final int BURST_OF_STRENGTH = 5;
		static final int CLARITY_OF_THOUGHT = 6;
		static final int SHARP_EYE = 22;
		static final int MYSTIC_WILL = 23;
		static final int ROCK_SKIN = 7;
		static final int SUPERHUMAN_STRENGTH = 8;
		static final int IMPROVED_REFLEXES = 9;
		static final int RAPID_RESTORE = 10;
		static final int RAPID_HEAL = 11;
		static final int PROTECT_ITEM = 12;
		static final int HAWK_EYE = 24;
		static final int MYSTIC_LORE = 25;
		static final int STEEL_SKIN = 13;
		static final int ULTIMATE_STRENGTH = 14;
		static final int INCREDIBLE_REFLEXES = 15;
		static final int PROTECT_FROM_MAGIC = 16;
		static final int PROTECT_FROM_MISSILES = 17;
		static final int PROTECT_FROM_MELEE = 18;
		static final int EAGLE_EYE = 26;
		static final int MYSTIC_MIGHT = 27;
		static final int RETRIBUTION = 19;
		static final int REDEMPTION = 20;
		static final int SMITE = 21;
		static final int PRESERVE = 32;
		static final int CHIVALRY = 28;
		static final int PIETY = 29;
		static final int RIGOUR = 30;
		static final int AUGURY = 31;
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
		static final int DEFENSIVE_SPELL_ICON = 21;
		static final int DEFENSIVE_SPELL_SHIELD = 22;
		static final int DEFENSIVE_SPELL_TEXT = 23;
		static final int SPELL_BOX = 24;
		static final int SPELL_ICON = 25;
		static final int SPELL_TEXT = 26;
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
			static final int CORRECT_STYLE2 = 4;
			static final int TO_CALL = 6;
			static final int ROLE = 8;
			static final int ROLE_SPRITE = 7;
		}

		static final int CURRENT_WAVE = 1;
		static final int CORRECT_STYLE = 3;
		static final int TO_CALL = 5;
		static final int ROLE_SPRITE = 6;
		static final int ROLE = 7;
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
		static final int DIARY_TEXT = 1;
	}

	static class MTA
	{
		static final int BONUS_COMPONENT = 7;
		static final int BONUS_TEXT_COMPONENT = 12;
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
		static final int WORLD_LIST = 14;
	}

	static class FossilOxygen
	{
		static final int FOSSIL_ISLAND_OXYGEN_BAR = 4;
	}

	static class StandardSpellBook
	{
		static final int STANDARD_SPELLBOOK_CONTAINER = 0;
		static final int LUMBRIDGE_HOME_TELEPORT = 1;
		static final int WIND_STRIKE = 2;
		static final int CONFUSE = 3;
		static final int ENCHANT_CROSSBOW_BOLT = 4;
		static final int WATER_STRIKE = 5;
		static final int LVL_1_ENCHANT = 6;
		static final int EARTH_STRIKE = 7;
		static final int WEAKEN = 8;
		static final int FIRE_STRIKE = 9;
		static final int BONES_TO_BANANAS = 10;
		static final int WIND_BOLT = 11;
		static final int CURSE = 12;
		static final int BIND = 13;
		static final int LOW_LEVEL_ALCHEMY = 14;
		static final int WATER_BOLT = 15;
		static final int VARROCK_TELEPORT = 16;
		static final int LVL_2_ENCHANT = 17;
		static final int EARTH_BOLT = 18;
		static final int LUMBRIDGE_TELEPORT = 19;
		static final int TELEKENETIC_GRAB = 20;
		static final int FIRE_BOLT = 21;
		static final int FALADOR_TELEPORT = 22;
		static final int CRUMBLE_UNDEAD = 23;
		static final int TELEPORT_TO_HOUSE = 24;
		static final int WIND_BLAST = 25;
		static final int SUPERHEAT_ITEM = 26;
		static final int CAMELOT_TELEPORT = 27;
		static final int WATER_BLAST = 28;
		static final int LVL_3_ENCHANT = 29;
		static final int IBAN_BLAST = 30;
		static final int SNARE = 31;
		static final int MAGIC_DART = 32;
		static final int ARDOUGNE_TELEPORT = 33;
		static final int EARTH_BLAST = 34;
		static final int HIGH_LEVEL_ALCHEMY = 35;
		static final int CHARGE_WATER_ORB = 36;
		static final int LVL_4_ENCHANT = 37;
		static final int WATCHTOWER_TELEPORT = 38;
		static final int FIRE_BLAST = 39;
		static final int CHARGE_EARTH_ORB = 40;
		static final int BONES_TO_PEACHES = 41;
		static final int SARADOMIN_STRIKE = 42;
		static final int CLAWS_OF_GUTHIX = 43;
		static final int FLAMES_OF_ZAMORAK = 44;
		static final int TROLLHEIM_TELEPORT = 45;
		static final int WIND_WAVE = 46;
		static final int CHARGE_FIRE_ORB = 47;
		static final int TELEPORT_TO_APE_ATOLL = 48;
		static final int WATER_WAVE = 49;
		static final int CHARGE_AIR_ORB = 50;
		static final int VULNERABILITY = 51;
		static final int LVL_5_ENCHANT = 52;
		static final int TELEPORT_TO_KOUREND = 53;
		static final int EARTH_WAVE = 54;
		static final int ENFEEBLE = 55;
		static final int TELEOTHER_LUMBRIDGE = 56;
		static final int FIRE_WAVE = 57;
		static final int ENTANGLE = 58;
		static final int STUN = 59;
		static final int CHARGE = 60;
		static final int WIND_SURGE = 61;
		static final int TELEOTHER_FALADOR = 62;
		static final int WATER_SURGE = 63;
		static final int TELE_BLOCK = 64;
		static final int TELEPORT_TO_BOUNTY_TARGET = 65;
		static final int LVL_6_ENCHANT = 66;
		static final int TELEOTHER_CAMELOT = 67;
		static final int EARTH_SURGE = 68;
		static final int LVL_7_ENCHANT = 69;
		static final int FIRE_SURGE = 70;
	}

	static class AncientSpellBook
	{
		static final int ANCIENT_SPELLBOOK_CONTAINER = 71;
		static final int ICE_RUSH = 72;
		static final int ICE_BLITZ = 73;
		static final int ICE_BURST = 74;
		static final int ICE_BARRAGE = 75;
		static final int BLOOD_RUSH = 76;
		static final int BLOOD_BLITZ = 77;
		static final int BLOOD_BURST = 78;
		static final int BLOOD_BARRAGE = 79;
		static final int SMOKE_RUSH = 80;
		static final int SMOKE_BLITZ = 81;
		static final int SMOKE_BURST = 82;
		static final int SMOKE_BARRAGE = 83;
		static final int SHADOW_RUSH = 84;
		static final int SHADOW_BLITZ = 85;
		static final int SHADOW_BURST = 86;
		static final int SHADOW_BARRAGE = 87;
		static final int PADDEWWA_TELEPORT = 88;
		static final int SENNTISTEN_TELEPORT = 89;
		static final int KHARYLL_TELEPORT = 90;
		static final int LASSAR_TELEPORT = 91;
		static final int DAREEYAK_TELEPORT = 92;
		static final int CARRALLANGAR_TELEPORT = 93;
		static final int ANNAKARL_TELEPORT = 94;
		static final int GHORROCK_TELEPORT = 95;
		static final int TELEPORT_TO_BOUNTY_TARGET = 96;
		static final int EDGEVILLE_HOME_TELEPORT = 97;
	}

	static class LunarSpellBook
	{
		static final int LUNAR_SPELLBOOK_CONTAINER = 98;
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
		static final int TELEPORT_TO_BOUNTY_TARGET = 127;
		static final int TELE_GROUP_FISHING_GUILD = 128;
		static final int PLANK_MAKE = 129;
		static final int CATHERBY_TELEPORT = 130;
		static final int TELE_GROUP_CATHERBY = 131;
		static final int RECHARGE_DRAGONSTONE = 132;
		static final int ICE_PLATEAU_TELEPORT = 133;
		static final int TELE_GROUP_ICE_PLATEAU = 134;
		static final int ENERGY_TRANSFER = 135;
		static final int HEAL_OTHER = 136;
		static final int VENGEANCE_OTHER = 137;
		static final int VENGEANCE = 138;
		static final int HEAL_GROUP = 139;
		static final int SPELLBOOK_SWAP = 140;
		static final int GEOMANCY = 141;
		static final int SPIN_FLAX = 142;
		static final int OURANIA_TELEPORT = 143;
	}

	static class ArceuusSpellBook
	{
		static final int ARCEUUS_SPELL_BOOK_CONTAINER = 144;
		static final int ARCEUUS_HOME_TELEPORT = 145;
		static final int REANIMATE_GOBLIN = 146;
		static final int LUMBRIDGE_GRAVEYARD_TELEPORT = 147;
		static final int REANIMATE_MONKEY = 148;
		static final int REANIMATE_IMP = 149;
		static final int REANIMATE_MINOTAUR = 150;
		static final int DRAYNOR_MANOR_TELEPORT = 151;
		static final int REANIMATE_SCORPION = 152;
		static final int REANIMATE_BEAR = 153;
		static final int REANIMATE_UNICORN = 154;
		static final int REANIMATE_DOG = 155;
		static final int MIND_ALTAR_TELEPORT = 156;
		static final int REANIMATE_CHAOS_DRUID = 157;
		static final int RESPAWN_TELEPORT = 158;
		static final int REANIMATE_GIANT = 159;
		static final int SALVE_GRAVEYARD_TELEPORT = 160;
		static final int REANIMATE_OGRE = 161;
		static final int REANIMATE_ELF = 162;
		static final int REANIMATE_TROLL = 163;
		static final int FRANKENSTRAINS_CASTLE_TELEPORT = 164;
		static final int REANIMATE_HORROR = 165;
		static final int REANIMATE_KALPHITE = 166;
		static final int WEST_ARDOUGNE_TELEPORT = 167;
		static final int REANIMATE_DAGANNOTH = 168;
		static final int REANIMATE_BLOODVELD = 169;
		static final int HARMONY_ISLAND_TELEPORT = 170;
		static final int REANIMATE_TZHAAR = 171;
		static final int CEMETERY_TELEPORT = 172;
		static final int REANIMATE_DEMON = 173;
		static final int REANIMATE_AVIANSIE = 174;
		static final int RESURRECT_CROPS = 175;
		static final int BARROWS_TELEPORT = 176;
		static final int REANIMATE_ABYSSAL_CREATURE = 177;
		static final int APE_ATOLL_TELEPORT = 178;
		static final int REANIMATE_DRAGON = 179;
	}
}