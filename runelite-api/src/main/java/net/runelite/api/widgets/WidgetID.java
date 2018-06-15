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
	public static final int FAIRY_RING_CODE_GROUP_ID = 381;
	public static final int FAIRY_RING_GROUP_ID = 398;
	public static final int LOGOUT_PANEL_ID = 182;
	public static final int BANK_GROUP_ID = 12;
	public static final int BANK_INVENTORY_GROUP_ID = 15;
	public static final int GRAND_EXCHANGE_INVENTORY_GROUP_ID = 467;
	public static final int DEPOSIT_BOX_GROUP_ID = 192;
	public static final int INVENTORY_GROUP_ID = 149;
	public static final int FRIENDS_LIST_GROUP_ID = 429;
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
	public static final int NIGHTMARE_ZONE_GROUP_ID = 202;
	public static final int BLAST_FURNACE_GROUP_ID = 474;
	public static final int WORLD_MAP_GROUP_ID = 595;
	public static final int PYRAMID_PLUNDER_GROUP_ID = 428;
	public static final int RAIDS_REWARD_GROUP_ID = 539;
	public static final int EXPERIENCE_TRACKER_GROUP_ID = 122;
	public static final int TITHE_FARM_GROUP_ID = 241;
	public static final int KINGDOM_GROUP_ID = 392;
	public static final int BARROWS_GROUP_ID = 24;
	public static final int BLAST_MINE_GROUP_ID = 598;

	static class WorldMap
	{
		static final int OPTION = 36;
		static final int TOOLTIP = 35;
		static final int MAPVIEW = 3;
	}

	static class SlayerRewards
	{
		static final int TOP_BAR = 12;
	}

	static class DialogNPC
	{
		static final int HEAD_MODEL = 0;
		static final int NAME = 1;
		static final int CONTINUE = 2;
		static final int TEXT = 3;
	}

	static class LogoutPanel
	{
		static final int LOGOUT_BUTTON = 6;
	}

	static class PestControl
	{
		static final int PURPLE_SHIELD = 21;
		static final int BLUE_SHIELD = 23;
		static final int YELLOW_SHIELD = 25;
		static final int RED_SHIELD = 27;

		static final int PURPLE_HEALTH = 17;
		static final int BLUE_HEALTH = 18;
		static final int YELLOW_HEALTH = 19;
		static final int RED_HEALTH = 20;

		static final int PURPLE_ICON = 13;
		static final int BLUE_ICON = 14;
		static final int YELLOW_ICON = 15;
		static final int RED_ICON = 16;

		static final int ACTIVITY_BAR = 6;
		static final int ACTIVITY_PROGRESS = 8;
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
		static final int SPEC_ORB = 28;
	}

	static class Viewport
	{
		static final int MINIMAP_WIDGET = 17;
		static final int FIXED_VIEWPORT = 17;
		static final int RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX = 12;
		static final int RESIZABLE_VIEWPORT_BOTTOM_LINE = 12;
	}

	static class FixedViewport
	{
		static final int CLAN_CHAT_TAB = 31;
		static final int FRIENDS_TAB = 32;
		static final int IGNORES_TAB = 33;
		static final int LOGOUT_TAB = 34;
		static final int OPTIONS_TAB = 35;
		static final int EMOTES_TAB = 36;
		static final int MUSIC_TAB = 37;
		static final int CLAN_CHAT_ICON = 38;
		static final int FRIENDS_ICON = 39;
		static final int IGNORES_ICON = 40;
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
		static final int FRIENDS_TAB = 36;
		static final int IGNORES_TAB = 37;
		static final int LOGOUT_TAB = 38;
		static final int OPTIONS_TAB = 39;
		static final int EMOTES_TAB = 40;
		static final int MUSIC_TAB = 41;
		static final int CLAN_CHAT_ICON = 42;
		static final int FRIENDS_ICON = 43;
		static final int IGNORES_ICON = 44;
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
		static final int INVENTORY_TAB = 51;
		static final int PRAYER_TAB = 53;
		static final int QUESTS_ICON = 57;
		static final int INVENTORY_ICON = 58;
		static final int PRAYER_ICON = 60;
	}

	static class Chatbox
	{
		static final int CHATBOX_MESSAGES = 30;
		static final int CHATBOX_REPORT_TEXT = 29;
		static final int CHATBOX_FRAME = 1;
		static final int CHATBOX_BUTTONS = 2;
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
		static final int SKILL = 0;
		static final int LEVEL = 1;
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

	static class DialogSprite
	{
		static final int SPRITE = 0;
		static final int TEXT = 1;
	}

	static class ExperienceTracker
	{
		static final int WIDGET = 1;
		static final int BOTTOM_BAR = 14;
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
		static final int BARROWS_BROTHERS = 8;
		static final int BARROWS_POTENTIAL = 9;
		static final int BARROWS_REWARD_INVENTORY = 3;
	}
}
