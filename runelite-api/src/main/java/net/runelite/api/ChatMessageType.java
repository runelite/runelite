/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumeration of message types that can be received in the chat.
 */
@AllArgsConstructor
@Getter
public enum ChatMessageType
{
	/**
	 * A message received from the server.
	 */
	SERVER(0),
	/**
 	* A message in the public chat from a moderator
 	*/
	PUBLIC_MOD(1),
	/**
	 * A message in the public chat.
	 */
	PUBLIC(2),
	/**
	 * A private message from another player.
	 */
	PRIVATE_MESSAGE_RECEIVED(3),
	/**
	 * A trade request received.
	 */
	TRADE_RECEIVED(4),
	/**
	 * A message received when a friend logs in or out.
	 */
	PRIVATE_MESSAGE_INFO(5),
	/**
	 * A private message sent to another player.
	 */
	PRIVATE_MESSAGE_SENT(6),
	/**
	 * A private message received from a moderator.
	 */
	PRIVATE_MESSAGE_RECEIVED_MOD(7),
	/**
	 * A message received in clan chat.
	 */
	CLANCHAT(9),
	/**
	 * A message received with information about the current clan chat.
	 */
	CLANCHAT_INFO(11),
	/**
	 * A trade request being sent.
	 */
	TRADE_SENT(12),
	/**
	 * An abuse report submitted.
	 */
	ABUSE_REPORT(26),
	/**
	 * Examine item description.
	 */
	EXAMINE_ITEM(27),
	/**
	 * Examine NPC description.
	 */
	EXAMINE_NPC(28),
	/**
	 * Examine object description.
	 */
	EXAMINE_OBJECT(29),
	/**
	 * Adding player to friend list.
	 */
	FRIENDS_LIST_ADD(30),
	/**
	 * Adding player to ignore list.
	 */
	IGNORE_LIST_ADD(31),
	/**
	 * An autochat message from a player.
	 */
	AUTOCHAT(90),
	/**
	 * A game message (ie. when a setting is changed).
	 */
	GAME(99),
	/**
	 * A message received when somebody sends a trade offer.
	 */
	TRADE(101),
	/**
	 * A message received when somebody sends a duel offer.
	 */
	DUEL(103),
	/**
	 * A message that was filtered.
	 */
	FILTERED(105),
	/**
	 * A message about an action.
	 */
	ACTION(109),
	/**
	 * An unknown message type.
	 */
	UNKNOWN(-1);

	private final int type;

	private static final Map<Integer, ChatMessageType> CHAT_MESSAGE_TYPES = new HashMap<>();

	static
	{
		for (ChatMessageType chatMessageType : values())
		{
			CHAT_MESSAGE_TYPES.put(chatMessageType.type, chatMessageType);
		}
	}

	/**
	 * Utility method that maps the type value to its respective
	 * {@link ChatMessageType} value.
	 *
	 * @param type the raw type
	 * @return appropriate message type, or {@link #UNKNOWN}
	 */
	public static ChatMessageType of(int type)
	{
		return CHAT_MESSAGE_TYPES.getOrDefault(type, UNKNOWN);
	}
}
