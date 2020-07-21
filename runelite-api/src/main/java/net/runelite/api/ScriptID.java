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
	 * <li> int (byte) Flags </li>
	 * <li> String Message to send </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 1, string = 1)
	public static final int CHATBOX_INPUT = 96;

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
	 * </ul>
	 */
	@ScriptArguments(integer = 2)
	public static final int MESSAGE_LAYER_CLOSE = 299;

	/**
	 * Sets the background for sound option bars
	 * <ul>
	 * <li> int  Value of the slider (0-4) </li>
	 * <li> int (WidgetID) * 5, segments of the slider </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 6)
	public static final int OPTIONS_ALLSOUNDS = 358;

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
	public static final int QUESTLIST_PROGRESS = 2267;

	/**
	 * Updates the Diary/Quest interface's scrollbar
	 * <ul>
	 * <li> int (boolean) Reset scroll position </li>
	 * <li> int Number of lines </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 2)
	public static final int DIARY_QUEST_UPDATE_LINECOUNT = 2523;

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
	public static final int FRIENDS_CHAT_SEND_KICK = 215;

	/**
	 * Builds the widget that holds all of the players inside a friends chat
	 */
	@ScriptArguments(integer = 15)
	public static final int FRIENDS_CHAT_CHANNEL_REBUILD = 1658;

	/**
	 * Builds the widget for making an offer in Grand Exchange
	 */
	@ScriptArguments(integer = 15)
	public static final int GE_OFFERS_SETUP_BUILD = 779;

	/**
	 * Builds the grand exchange item search widget
	 */
	@ScriptArguments(integer = 3)
	public static final int GE_ITEM_SEARCH = 752;

	/**
	 * Builds the quest list inside the quest tab that shows each quest's progress
	 */
	@ScriptArguments(integer = 3)
	public static final int QUESTLIST_PROGRESS_LIST_SHOW = 1354;

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

	/**
	 * Main layout script for the bank
	 * <ul>
	 * <li>int (WidgetID) * 17, various widgets making up the bank interface</li>
	 * </ul>
	 */
	@ScriptArguments(integer = 17)
	public static final int BANKMAIN_BUILD = 277;
}
