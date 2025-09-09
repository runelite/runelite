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

import net.runelite.api.gameval.InterfaceID;

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
@Deprecated
public final class WidgetID
{
	public static final int FAIRY_RING_PANEL_GROUP_ID = InterfaceID.FAIRYRINGS_LOG;
	public static final int FAIRY_RING_GROUP_ID = InterfaceID.FAIRYRINGS;
	public static final int LOGOUT_PANEL_ID = InterfaceID.LOGOUT;
	public static final int BANK_GROUP_ID = InterfaceID.BANKMAIN;
	public static final int BANK_INVENTORY_GROUP_ID = InterfaceID.BANKSIDE;
	public static final int GRAND_EXCHANGE_INVENTORY_GROUP_ID = InterfaceID.GE_OFFERS_SIDE;
	public static final int GRAND_EXCHANGE_GROUP_ID = InterfaceID.GE_OFFERS;
	public static final int DEPOSIT_BOX_GROUP_ID = InterfaceID.BANK_DEPOSITBOX;
	public static final int INVENTORY_GROUP_ID = InterfaceID.INVENTORY;
	public static final int PLAYER_TRADE_SCREEN_GROUP_ID = InterfaceID.TRADEMAIN;
	public static final int PLAYER_TRADE_INVENTORY_GROUP_ID = InterfaceID.TRADESIDE;
	public static final int FRIENDS_LIST_GROUP_ID = InterfaceID.FRIENDS;
	public static final int IGNORE_LIST_GROUP_ID = InterfaceID.IGNORE;
	public static final int RAIDING_PARTY_GROUP_ID = InterfaceID.RAIDS_SIDEPANEL;
	public static final int EQUIPMENT_GROUP_ID = InterfaceID.WORNITEMS;
	public static final int EQUIPMENT_INVENTORY_GROUP_ID = InterfaceID.EQUIPMENT_SIDE;
	public static final int EMOTES_GROUP_ID = InterfaceID.EMOTE;
	public static final int RUNE_POUCH_GROUP_ID = InterfaceID.RUNE_POUCH;
	public static final int ACHIEVEMENT_DIARY_GROUP_ID = InterfaceID.AREA_TASK;
	public static final int PEST_CONTROL_BOAT_GROUP_ID = InterfaceID.PEST_LANDER_OVERLAY;
	public static final int PEST_CONTROL_GROUP_ID = InterfaceID.PEST_STATUS_OVERLAY;
	public static final int FRIENDS_CHAT_GROUP_ID = InterfaceID.CHATCHANNEL_CURRENT;
	public static final int MINIMAP_GROUP_ID = InterfaceID.ORBS;
	public static final int LOGIN_CLICK_TO_PLAY_GROUP_ID = InterfaceID.WELCOME_SCREEN;
	public static final int CLUE_SCROLL_GROUP_ID = InterfaceID.TRAIL_CLUETEXT;
	public static final int FIXED_VIEWPORT_GROUP_ID = InterfaceID.TOPLEVEL;
	public static final int RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX_GROUP_ID = InterfaceID.TOPLEVEL_OSRS_STRETCH;
	public static final int RESIZABLE_VIEWPORT_BOTTOM_LINE_GROUP_ID = InterfaceID.TOPLEVEL_PRE_EOC;
	public static final int SHOP_GROUP_ID = InterfaceID.SHOPMAIN;
	public static final int SHOP_INVENTORY_GROUP_ID = InterfaceID.SHOPSIDE;
	public static final int SMITHING_GROUP_ID = InterfaceID.SMITHING;
	public static final int GUIDE_PRICES_GROUP_ID = InterfaceID.GE_PRICECHECKER;
	public static final int GUIDE_PRICES_INVENTORY_GROUP_ID = InterfaceID.GE_PRICECHECKER_SIDE;
	public static final int COMBAT_GROUP_ID = InterfaceID.COMBAT_INTERFACE;
	public static final int DIALOG_NPC_GROUP_ID = InterfaceID.CHAT_LEFT;
	public static final int SLAYER_REWARDS_GROUP_ID = InterfaceID.SLAYER_REWARDS;
	public static final int PRIVATE_CHAT = InterfaceID.PM_CHAT;
	public static final int CHATBOX_GROUP_ID = InterfaceID.CHATBOX;
	public static final int VOLCANIC_MINE_GROUP_ID = InterfaceID.FOSSIL_VOLCANIC_MINE;
	public static final int BA_ATTACKER_GROUP_ID = InterfaceID.BARBASSAULT_OVER_ATT;
	public static final int BA_COLLECTOR_GROUP_ID = InterfaceID.BARBASSAULT_OVER_COL;
	public static final int BA_DEFENDER_GROUP_ID = InterfaceID.BARBASSAULT_OVER_DEF;
	public static final int BA_HEALER_GROUP_ID = InterfaceID.BARBASSAULT_OVER_HEAL;
	public static final int BA_REWARD_GROUP_ID = InterfaceID.BARBASSAULT_WAVECOMPLETE;
	public static final int BA_TEAM_GROUP_ID = InterfaceID.BARBASSAULT_OVER_RECRUIT_PLAYER_NAMES;
	public static final int LEVEL_UP_GROUP_ID = InterfaceID.LEVELUP_DISPLAY;
	public static final int DIALOG_SPRITE_GROUP_ID = InterfaceID.OBJECTBOX;
	public static final int DIALOG_DOUBLE_SPRITE_GROUP_ID = InterfaceID.OBJECTBOX_DOUBLE;
	public static final int QUEST_COMPLETED_GROUP_ID = InterfaceID.QUESTSCROLL;
	public static final int CLUE_SCROLL_REWARD_GROUP_ID = InterfaceID.TRAIL_REWARDSCREEN;
	public static final int BARROWS_REWARD_GROUP_ID = InterfaceID.BARROWS_REWARD;
	public static final int RAIDS_GROUP_ID = InterfaceID.RAIDS_OVERLAY;
	public static final int TOB_GROUP_ID = InterfaceID.TOB_HUD;
	public static final int MOTHERLODE_MINE_GROUP_ID = InterfaceID.MOTHERLODE_HUD;
	public static final int EXPERIENCE_DROP_GROUP_ID = InterfaceID.XP_DROPS;
	public static final int PUZZLE_BOX_GROUP_ID = InterfaceID.TRAIL_SLIDEPUZZLE;
	public static final int LIGHT_BOX_GROUP_ID = InterfaceID.LIGHT_PUZZLE;
	public static final int NIGHTMARE_ZONE_GROUP_ID = InterfaceID.NZONE_GAME;
	public static final int NIGHTMARE_PILLAR_HEALTH_GROUP_ID = InterfaceID.NIGHTMARE_TOTEMS;
	public static final int BLAST_FURNACE_GROUP_ID = InterfaceID.BLAST_FURNACE_HUD;
	public static final int WORLD_MAP_GROUP_ID = InterfaceID.WORLDMAP;
	public static final int PYRAMID_PLUNDER_GROUP_ID = InterfaceID.NTK_OVERLAY;
	public static final int CHAMBERS_OF_XERIC_REWARD_GROUP_ID = InterfaceID.RAIDS_REWARDS;
	public static final int THEATRE_OF_BLOOD_REWARD_GROUP_ID = InterfaceID.TOB_CHESTS;
	public static final int EXPERIENCE_TRACKER_GROUP_ID = InterfaceID.XP_DROPS;
	public static final int TITHE_FARM_GROUP_ID = InterfaceID.HOSIDIUS_STRIP_FARMING;
	public static final int KINGDOM_GROUP_ID = InterfaceID.MISC_COLLECTION;
	public static final int BARROWS_GROUP_ID = InterfaceID.BARROWS_OVERLAY;
	public static final int BLAST_MINE_GROUP_ID = InterfaceID.LOVAKENGJ_BLAST_MINING_HUD;
	public static final int MTA_ALCHEMY_GROUP_ID = InterfaceID.MAGICTRAINING_ALCHEM;
	public static final int MTA_ENCHANT_GROUP_ID = InterfaceID.MAGICTRAINING_ENCHA;
	public static final int MTA_GRAVEYARD_GROUP_ID = InterfaceID.MAGICTRAINING_GRAVE;
	public static final int MTA_TELEKINETIC_GROUP_ID = InterfaceID.MAGICTRAINING_TELE;
	public static final int CORP_DAMAGE = InterfaceID.CORP_BEAST;
	public static final int DESTROY_ITEM_GROUP_ID = InterfaceID.CONFIRMDESTROY;
	public static final int VARROCK_MUSEUM_QUIZ_GROUP_ID = InterfaceID.VM_NATURAL_HISTORY;
	public static final int KILL_LOGS_GROUP_ID = InterfaceID.KILL_LOG;
	public static final int DIARY_QUEST_GROUP_ID = InterfaceID.QUESTJOURNAL;
	public static final int THEATRE_OF_BLOOD_GROUP_ID = InterfaceID.TOB_HUD;
	public static final int WORLD_SWITCHER_GROUP_ID = InterfaceID.WORLDSWITCHER;
	public static final int DIALOG_OPTION_GROUP_ID = InterfaceID.CHATMENU;
	public static final int DIALOG_PLAYER_GROUP_ID = InterfaceID.CHAT_RIGHT;
	public static final int DRIFT_NET_FISHING_REWARD_GROUP_ID = InterfaceID.FOSSIL_DRIFTNET;
	public static final int FOSSIL_ISLAND_OXYGENBAR_ID = InterfaceID.FOSSIL_UNDERWATER;
	public static final int SPELLBOOK_GROUP_ID = InterfaceID.MAGIC_SPELLBOOK;
	public static final int PVP_GROUP_ID = InterfaceID.PVP_ICONS;
	public static final int FISHING_TRAWLER_GROUP_ID = InterfaceID.TRAWLER_OVERLAY;
	public static final int FISHING_TRAWLER_REWARD_GROUP_ID = InterfaceID.TRAWLER_REWARD;
	public static final int ZEAH_MESS_HALL_GROUP_ID = InterfaceID.HOSIDIUS_SERVERY_HUD;
	public static final int LOOTING_BAG_GROUP_ID = InterfaceID.WILDERNESS_LOOTINGBAG;
	public static final int SKOTIZO_GROUP_ID = InterfaceID.CATA_BOSS;
	public static final int FULLSCREEN_CONTAINER_TLI = InterfaceID.TOPLEVEL_DISPLAY;
	public static final int CHARACTER_SUMMARY_GROUP_ID = InterfaceID.ACCOUNT_SUMMARY_SIDEPANEL;
	public static final int QUESTLIST_GROUP_ID = InterfaceID.QUESTLIST;
	public static final int SKILLS_GROUP_ID = InterfaceID.STATS;
	public static final int MUSIC_GROUP_ID = InterfaceID.MUSIC;
	public static final int BARROWS_PUZZLE_GROUP_ID = InterfaceID.BARROWS_PUZZLE;
	public static final int KEPT_ON_DEATH_GROUP_ID = InterfaceID.DEATHKEEP;
	public static final int GUIDE_PRICE_GROUP_ID = InterfaceID.GE_PRICECHECKER;
	public static final int SEED_VAULT_INVENTORY_GROUP_ID = InterfaceID.SEED_VAULT_DEPOSIT;
	public static final int BEGINNER_CLUE_MAP_CHAMPIONS_GUILD = InterfaceID.TRAIL_MAP01;
	public static final int BEGINNER_CLUE_MAP_VARROCK_EAST_MINE = InterfaceID.TRAIL_MAP02;
	public static final int BEGINNER_CLUE_MAP_DRAYNOR = InterfaceID.TRAIL_MAP03;
	public static final int BEGINNER_CLUE_MAP_NORTH_OF_FALADOR = InterfaceID.TRAIL_MAP06;
	public static final int BEGINNER_CLUE_MAP_WIZARDS_TOWER = InterfaceID.TRAIL_MAP11;
	public static final int SEED_BOX_GROUP_ID = InterfaceID.HOSIDIUS_SEEDBOX;
	public static final int SEED_VAULT_GROUP_ID = InterfaceID.SEED_VAULT;
	public static final int EXPLORERS_RING_ALCH_GROUP_ID = InterfaceID.LUMBRIDGE_ALCHEMY;
	public static final int SETTINGS_SIDE_GROUP_ID = InterfaceID.SETTINGS_SIDE;
	public static final int SETTINGS_GROUP_ID = InterfaceID.SETTINGS;
	public static final int GWD_KC_GROUP_ID = InterfaceID.GODWARS_OVERLAY;
	public static final int LMS_GROUP_ID = InterfaceID.BR_LOBBYOVERLAY;
	public static final int LMS_INGAME_GROUP_ID = InterfaceID.BR_OVERLAY;
	public static final int ADVENTURE_LOG_ID = InterfaceID.MENU;
	public static final int COLLECTION_LOG_ID = InterfaceID.COLLECTION;
	public static final int GENERIC_SCROLL_GROUP_ID = InterfaceID.LONGSCROLL;
	public static final int GAUNTLET_TIMER_GROUP_ID = InterfaceID.GAUNTLET_OVERLAY;
	public static final int HALLOWED_SEPULCHRE_TIMER_GROUP_ID = InterfaceID.HALLOWED_OVERLAY;
	public static final int BANK_PIN_GROUP_ID = InterfaceID.BANKPIN_KEYPAD;
	public static final int HEALTH_OVERLAY_BAR_GROUP_ID = InterfaceID.HPBAR_HUD;
	public static final int CHAMBERS_OF_XERIC_STORAGE_UNIT_PRIVATE_GROUP_ID = InterfaceID.RAIDS_STORAGE_PRIVATE;
	public static final int CHAMBERS_OF_XERIC_STORAGE_UNIT_SHARED_GROUP_ID = InterfaceID.RAIDS_STORAGE_SHARED;
	public static final int CHAMBERS_OF_XERIC_STORAGE_UNIT_INVENTORY_GROUP_ID = InterfaceID.RAIDS_STORAGE_SIDE;
	public static final int DUEL_INVENTORY_GROUP_ID = InterfaceID.PVP_ARENA_STAGINGAREA_SHARELOADOUT;
	public static final int TRAILBLAZER_AREAS_GROUP_ID = InterfaceID.TRAILBLAZER_AREAS;
	public static final int TEMPOROSS_GROUP_ID = InterfaceID.TEMPOROSS_HUD;
	public static final int TEMPOROSS_LOBBY_GROUP_ID = InterfaceID.TEMPOROSS_LOBBY_HUD;
	public static final int CLAN_GROUP_ID = InterfaceID.CLANS_SIDEPANEL;
	public static final int CLAN_GUEST_GROUP_ID = InterfaceID.CLANS_GUEST_SIDEPANEL;
	public static final int GRAVESTONE_GROUP_ID = InterfaceID.GRAVESTONE_GENERIC;
	public static final int POH_TREASURE_CHEST_INVENTORY_GROUP_ID = InterfaceID.POH_COSTUMES_SIDE;
	public static final int GROUP_IRON_GROUP_ID = InterfaceID.GIM_SIDEPANEL;
	public static final int GROUP_STORAGE_INVENTORY_GROUP_ID = InterfaceID.SHARED_BANK_SIDE;
	public static final int GROUP_STORAGE_GROUP_ID = InterfaceID.SHARED_BANK;
	public static final int WILDERNESS_LOOT_CHEST = InterfaceID.WILDY_LOOT_CHEST;
	public static final int TRADE_WINDOW_GROUP_ID = InterfaceID.TRADEMAIN;
	public static final int TOA_REWARD_GROUP_ID = InterfaceID.TOA_CHESTS;
	/**
	 * toa party interface in the raid lobby
	 */
	public static final int TOA_PARTY_GROUP_ID = InterfaceID.TOA_LOBBY;
	/**
	 * toa raid interface in the raid
	 */
	public static final int TOA_RAID_GROUP_ID = InterfaceID.TOA_HUD;
	public static final int ACHIEVEMENT_DIARY_SCROLL_GROUP_ID = InterfaceID.JOURNALSCROLL;
	public static final int PRAYER_GROUP_ID = InterfaceID.PRAYERBOOK;
	public static final int QUICK_PRAYERS_GROUP_ID = InterfaceID.QUICKPRAYER;
	public static final int GOTR_GROUP_ID = InterfaceID.GOTR_HUD;
	public static final int TROUBLE_BREWING_GROUP_ID = InterfaceID.BREW_OVERLAY;
	public static final int TROUBLE_BREWING_LOBBY_GROUP_ID = InterfaceID.BREW_WAITING_ROOM_OVERLAY;
	public static final int MORTTON_TEMPLE_GROUP_ID = InterfaceID.FLAMTAER_STATUS;
	public static final int BGR_RANK_DRAUGHTS_GROUP_ID = InterfaceID.BOARDGAMES_DRAUGHTS_OVERLAY;
	public static final int BGR_RANK_RUNELINK_GROUP_ID = InterfaceID.BOARDGAMES_RUNELINK_OVERLAY;
	public static final int BGR_RANK_RUNESQUARES_GROUP_ID = InterfaceID.BOARDGAMES_RUNESQUARES_OVERLAY;
	public static final int BGR_RANK_RUNEVERSI_GROUP_ID = InterfaceID.BOARDGAMES_RUNEVERSI_OVERLAY;
	public static final int AGILITY_ARENA_HUD_GROUP_ID = InterfaceID.AGILITYARENA_OVERLAY;
	public static final int GNOMEBALL_SCORE_GROUP_ID = InterfaceID.GNOMEBALL;
	public static final int SANITY_GROUP_ID = InterfaceID.SANITY;
	public static final int THE_STRANGLER_INFECTION_GROUP_ID = InterfaceID.DT2_INFECTION;
}
