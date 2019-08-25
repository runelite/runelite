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
	 * Handles zoom input
	 *
	 * Updates the VarClientInts (73, 74) to this same value
	 * <ul>
	 * <li> int  Reset zoom position </li>
	 * <li> int  Reset zoom position </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 2)
	public static final int CAMERA_DO_ZOOM = 42;

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
	 * Rebuilds the chatbox
	 */
	@ScriptArguments()
	public static final int BUILD_CHATBOX = 216;

	/**
	 * Rebuilds the text input widget inside the chat interface
	 * <ul>
	 * <li> String Message Prefix. Only used inside the GE search interfaces
	 * </ul>
	 */
	@ScriptArguments(string = 1)
	public static final int CHAT_TEXT_INPUT_REBUILD = 222;

	/**
	 * Builds the chatbox input widget
	 */
	@ScriptArguments()
	public static final int CHAT_PROMPT_INIT = 223;

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
	 * Readies the chatbox panel for things like the chatbox input
	 * Inverse of MESSAGE_LAYER_CLOSE
	 * <ul>
	 * <li> int (InputType) message layer type we are changing to </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 1)
	public static final int MESSAGE_LAYER_OPEN = 677;

	/**
	 * Clicking bank pin buttons runs this
	 */
	@ScriptArguments(integer = 20)
	public static final int BANK_PIN_OP = 685;

	/**
	 * Checks the state of the given stash unit.
	 * <ul>
	 * <li>int (loc) The stash unit object id</li>
	 * <li>int Bitpacked stash unit states</li>
	 * <li>int Bitpacked stash unit states 2</li>
	 * <li>int Bitpacked stash unit states 3</li>
	 * </ul>
	 * <p>
	 * Returns a pair of booleans indicating if the stash unit is built and if it is filled
	 */
	@ScriptArguments(integer = 4)
	public static final int WATSON_STASH_UNIT_CHECK = 1479;
	/**
	 * Displays the game messages when clicking on an item inside the Items Kept on Death interface
	 * <ul>
	 * <li> int (boolean) Item kept on death </li>
	 * <li> int Item Quantity </li>
	 * <li> String Item Name </li>
	 * </ul>
	 */
	@ScriptArguments(integer = 2, string = 1)
	public static final int DEATH_KEEP_ITEM_EXAMINE = 1603;

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
	 * <ul>
	 * Queries the completion state of a quest by its struct id
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
	 * Rebuilds the Spellbook
	 */
	@ScriptArguments(integer = 10, string = 2)
	public static final int MAGIC_SPELLBOOK_REDRAW = 2611;

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
	 * Join a clan, duh
	 */
	@ScriptArguments(string = 1)
	public static final int CUSTOM_JOIN_CLAN = 10690;

	/**
	 * Send a public message
	 */
	@ScriptArguments(string = 1)
	public static final int PUBLICMSG = 13337;
}

