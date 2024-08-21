/*
 * Copyright (c) 2018 Abex
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

public final class ScriptID
{
	/**
	 * Updates the scrollbar handle and container to the new height of the content container
	 * <ul>
	 * <li> int (WidgetID) Scrollbar's widget ID </li>
	 * <li> int (WidgetID) Container widget ID </li>
	 * <li> int how far down to scroll </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 3)
	public static final int UPDATE_SCROLLBAR = 72;

	/**
	 * Sends a chat message
	 * <ul>
	 * <li> String Message to send </li>
	 * <li> int modes </li>
	 * <li> int (clan type) </li>
	 * <li> int (boolean) use target</li>
	 * <li> int set target </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 4, string = 1)
	public static final int CHAT_SEND = 5517;

	/**
	 * Rebuilds the chatbox and the pmbox
	 */
	@ScriptArguments()
	public static final int SPLITPM_CHANGED = 83;

	/**
	 * Rebuilds the chatbox
	 */
	@ScriptArguments()
	public static final int BUILD_CHATBOX = 216;

	/**
	 * Opens the Private Message chat interface
	 *
	 * Jagex refers to this script as {@code meslayer_mode6}
	 * <ul>
	 * <li> String Player to send private message to</li>
	 * </ul>
	 */
	@ScriptArguments(string = 1)
	public static final int OPEN_PRIVATE_MESSAGE_INTERFACE = 107;

	/**
	 * Rebuilds the text input widget inside the chat interface
	 * <ul>
	 * <li> String Message Prefix. Only used inside the GE search interfaces
	 * </ul>
	 */
	@ScriptArguments(string = 1)
	public static final int CHAT_TEXT_INPUT_REBUILD = 222;

	/**
	 * Closes the chatbox input
	 * <ul>
	 * <li> int (boolean) Clear the current text </li>
	 * <li> int (boolean) Restore to chat view </li>
	 * <li> int (boolean) Submit close to server </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 3)
	public static final int MESSAGE_LAYER_CLOSE = 299;

	/**
	 * Readies the chatbox panel for things like the chatbox input
	 * Inverse of MESSAGE_LAYER_CLOSE
	 * <ul>
	 * <li> int (InputType) message layer type we are changing to </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 1)
	public static final int MESSAGE_LAYER_OPEN = 677;

	/**
	 * Builds the chatbox input widget
	 */
	@ScriptArguments()
	public static final int CHAT_PROMPT_INIT = 223;

	/**
	 * Checks the state of the given stash unit.
	 * <ul>
	 * <li>int (loc) The stash unit object id</li>
	 * <li>int Bitpacked stash unit states</li>
	 * <li>int Bitpacked stash unit states 2</li>
	 * <li>int Bitpacked stash unit states 3</li>
	 * </ul>
	 *
	 * Returns a pair of booleans indicating if the stash unit is built and if it is filled
	 */
	@ScriptArguments(integer = 4)
	public static final int WATSON_STASH_UNIT_CHECK = 1479;

	/**
	 * Queries the completion state of a quest by its struct id
	 * <ul>
	 * <li> int (struct) The id of the quest
	 * </ul>
	 * Returns
	 * <ul>
	 * <li> int (QuestState) the normalized state of the quest
	 * </ul>
	 */
	@ScriptArguments(integer = 1)
	public static final int QUEST_STATUS_GET = 4029;

	/**
	 * Updates the Quest interface's scrollbar
	 * <ul>
	 * <li> int (boolean) Reset scroll position </li>
	 * <li> int Number of lines </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 2)
	public static final int QUEST_UPDATE_LINECOUNT = 2523;

	/**
	 * Updates the Diary interface's scrollbar
	 * <ul>
	 * <li> int (boolean) Reset scroll position </li>
	 * <li> int Number of lines </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 2)
	public static final int DIARY_UPDATE_LINECOUNT = 6845;

	/**
	 * Handles zoom input
	 *
	 * Updates the VarClientInts (73, 74) to this same value
	 * <ul>
	 * <li> int  Reset zoom position for fixed viewport mode</li>
	 * <li> int  Reset zoom position for resizable viewport mode</li>
	 * </ul>
	 */
	@ScriptArguments(integer = 2)
	public static final int CAMERA_DO_ZOOM = 42;

	/**
	 * Does nothing
	 *
	 * This is used to eat events when you want a menu action attached to it
	 * because you need an op listener attached to it for it to work
	 */
	@ScriptArguments()
	@Deprecated
	public static final int NULL = 10003;

	/**
	 * Send a private message.
	 */
	@ScriptArguments(string = 2)
	public static final int PRIVMSG = 10004;

	/**
	 * Creates a disabled experience drop
	 *
	 * <ul>
	 * <li>int (Skill ordinal) Sets what icon to use</li>
	 * <li>int Amount of exp to drop</li>
	 * </ul>
	 */
	@ScriptArguments(integer = 2)
	public static final int XPDROP_DISABLED = 2091;

	/**
	 * Attempts to kick the specified player from the friends chat
	 * <ul>
	 * <li>String Players in-game name</li>
	 * </ul>
	 */
	@ScriptArguments(string = 1)
	public static final int FRIENDS_CHAT_SEND_KICK = 3764;

	/**
	 * Builds the widget that holds all of the players inside a friends chat
	 */
	@ScriptArguments(integer = 15)
	public static final int FRIENDS_CHAT_CHANNEL_REBUILD = 1658;

	/**
	 * Builds the widget that holds all of the players inside a clan chat
	 */
	@ScriptArguments(integer = 7)
	public static final int CLAN_SIDEPANEL_DRAW = 4396;

	/**
	 * Builds the widget for making an offer in Grand Exchange
	 */
	@ScriptArguments(integer = 17)
	public static final int GE_OFFERS_SETUP_BUILD = 779;

	/**
	 * Builds the grand exchange item search widget
	 */
	@ScriptArguments(integer = 3)
	public static final int GE_ITEM_SEARCH = 752;

	/**
	 * On load listener for building the quest list interface
	 */
	@ScriptArguments(integer = 8)
	public static final int QUESTLIST_INIT = 1350;

	/**
	 * Called when the friends list is updated
	 * <ul>
	 * <li> int (WidgetID) Friends list "full container" </li>
	 * <li> int (WidgetID) Friends list sort by name button </li>
	 * <li> int (WidgetID) Friends list sort by last world change button </li>
	 * <li> int (WidgetID) Friends list sort by world button </li>
	 * <li> int (WidgetID) Friends list legacy sort button </li>
	 * <li> int (WidgetID) Friends list names container </li>
	 * <li> int (WidgetID) Friends list scroll bar </li>
	 * <li> int (WidgetID) Friends list "loading please wait" text </li>
	 * <li> int (WidgetID) Friends list player previous name holder </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 9)
	public static final int FRIENDS_UPDATE = 631;

	/**
	 * Called when the ignore list is updated
	 * <ul>
	 * <li> int (WidgetID) Ignore list "full container" </li>
	 * <li> int (WidgetID) Ignore list sort by name button </li>
	 * <li> int (WidgetID) Ignore list legacy sort button </li>
	 * <li> int (WidgetID) Ignore list names container </li>
	 * <li> int (WidgetID) Ignore list scroll bar </li>
	 * <li> int (WidgetID) Ignore list "loading please wait" text </li>
	 * <li> int (WidgetID) Ignore list player previous name holder </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 7)
	public static final int IGNORE_UPDATE = 630;

	/**
	 * Called in an onTimer, determines whether to layout the bank during a search
	 * <ul>
	 * <li> int (WidgetID) * 16, various widgets making up the bank interface </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 17)
	public static final int BANKMAIN_SEARCH_REFRESH = 283;

	@ScriptArguments(integer = 6)
	public static final int BANKMAIN_DRAGSCROLL = 284;

	/**
	 * Called to update the PVP widget (wilderness level/protection)
	 */
	@ScriptArguments(integer = 1)
	public static final int PVP_WIDGET_BUILDER = 388;

	/**
	 * Called to build the combat interface
	 */
	@ScriptArguments()
	public static final int COMBAT_INTERFACE_SETUP = 420;

	/**
	 * Called to build the toplevel interface
	 */
	@ScriptArguments(integer = 2)
	public static final int TOPLEVEL_REDRAW = 907;

	/**
	 * Called to set position of an xpdrop text and sprite(s)
	 * <ul>
	 * <li> XP drop parent component </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 4, string = 1)
	public static final int XPDROPS_SETDROPSIZE = 996;

	@ScriptArguments(integer = 34)
	public static final int BANKMAIN_INIT = 274;

	/**
	 * Main layout script for the bank
	 * <ul>
	 * <li>int (WidgetID) * 17, various widgets making up the bank interface</li>
	 * </ul>
	 */
	@ScriptArguments(integer = 17)
	public static final int BANKMAIN_BUILD = 277;

	@ScriptArguments(integer = 19)
	public static final int BANKMAIN_FINISHBUILDING = 505;

	@ScriptArguments()
	public static final int BANKMAIN_SEARCHING = 514;

	/**
	 * Toggles the bank search
	 *
	 * <ul>
	 * <li>int 1 (must be 1 or script immediately returns)</li>
	 * </ul>
	 *
	 * Also takes 17 widget IDs corresponding to various bank widgets.
	 * These can be retrieved from the onInvTransmitListener of BANK_ITEM_CONTAINER. Note that this array also
	 * contains the script ID for the bank layout script in the first index
	 */
	@ScriptArguments(integer = 18)
	public static final int BANKMAIN_SEARCH_TOGGLE = 281;

	@ScriptArguments(integer = 6)
	public static final int BANKMAIN_SIZE_CHECK = 840;

	/**
	 * Chooses the click handler for a {@link ParamID#SETTING_SLIDER_CUSTOM_ONOP} = 1 settings slider
	 *
	 * The active widget is set to the track created by {@link ParamID#SETTING_FOREGROUND_CLICKZONE}
	 * <ul>
	 * <li>int {@link ParamID#SETTING_ID}</li>
	 * <li>int (WidgetID) Slider handle ID</li>
	 * <li>int (widget index) Slider handle index</li>
	 * <li>int track width</li>
	 * <li>int y offset</li>
	 * <li>int x offset</li>
	 * <li>int (WidgetID) drag parent</li>
	 * </ul>
	 */
	@ScriptArguments(integer = 11, string = 1)
	public static final int SETTINGS_SLIDER_CHOOSE_ONOP = 3885;

	/**
	 * Position and size the wiki button, as well as hide/unhide it
	 */
	@ScriptArguments(integer = 4)
	public static final int WIKI_ICON_UPDATE = 3306;

	/**
	 * Drag callback for the camera zoom slider in the options side panel.
	 */
	@ScriptArguments(integer = 3)
	public static final int ZOOM_SLIDER_ONDRAG = 833;

	/**
	 * Drag callback for the camera zoom slider in the settings.
	 */
	@ScriptArguments(integer = 6)
	public static final int SETTINGS_ZOOM_SLIDER_ONDRAG = 3896;

	@ScriptArguments(integer = 6)
	public static final int COLLECTION_DRAW_LIST = 2730;

	/**
	 * Draws the active notification in increasing sizes (increasing horizontally first, then vertically) to show a
	 * starting animation.
	 */
	@ScriptArguments(integer = 3)
	public static final int NOTIFICATION_START = 3346;

	/**
	 * Draws the active notification in full size for a specified number of client ticks. In essence, delayed between
	 * the open and close animations.
	 */
	@ScriptArguments(integer = 1)
	public static final int NOTIFICATION_DELAY = 3347;

	@ScriptArguments(integer = 7)
	public static final int GROUP_IRONMAN_STORAGE_BUILD = 5269;

	@ScriptArguments(integer = 6)
	public static final int INVENTORY_DRAWITEM = 6011;

	/**
	 * Initializes the trade interface
	 */
	@ScriptArguments(integer = 6)
	public static final int TRADE_MAIN_INIT = 755;

	/**
	 * Transitions the tob hud into the white flash that happens when sotetseg teleports the players to the maze.
	 */
	@ScriptArguments(string = 1)
	public static final int TOB_HUD_SOTETSEG_FADE = 2308;

	@ScriptArguments(integer = 3)
	public static final int RAIDS_STORAGE_PRIVATE_ITEMS = 1607;

	@ScriptArguments(integer = 12)
	public static final int HP_HUD_UPDATE = 2103;

	@ScriptArguments(integer = 7)
	public static final int ORBS_UPDATE_RUNENERGY = 447;

	@ScriptArguments(integer = 9)
	public static final int WORLDMAP_LOADMAP = 1712;

	@ScriptArguments(integer = 5)
	public static final int PRAYER_UPDATEBUTTON = 463;

	@ScriptArguments(integer = 9, string = 2)
	public static final int PRAYER_REDRAW = 547;

	@ScriptArguments(integer = 3)
	public static final int QUICKPRAYER_INIT = 466;

	/**
	 * Called to add a loc overlay timer
	 * <ul>
	 * <li> loc coord </li>
	 * <li> loc id </li>
	 * <li> loc type </li>
	 * <li> overlay type </li>
	 * <li> overlay ticks </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 7)
	public static final int ADD_OVERLAYTIMER_LOC = 5474;

	@ScriptArguments(integer = 7, string = 1)
	public static final int ACCOUNT_SUMMARY_TEXT_FORMAT = 3948;

	@ScriptArguments(integer = 10, string = 3)
	public static final int ACCOUNT_SUMMARY_SECTION_FORMAT = 3950;

	@ScriptArguments(integer = 6, string = 2)
	public static final int CHATBOX_KEYINPUT_MATCHED = 2153;

	@ScriptArguments(integer = 6)
	public static final int EQUIPMENT_SET_STAT_BONUS_SETUP = 3517;

	@ScriptArguments(integer = 12, string = 2)
	public static final int MAGIC_SPELLBOOK_INITIALISESPELLS = 2616;

	@ScriptArguments(integer = 2)
	public static final int MOTHERLODE_HUD_UPDATE = 1634;
}
