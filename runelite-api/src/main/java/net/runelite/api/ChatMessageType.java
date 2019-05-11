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

<<<<<<< HEAD
public enum ChatMessageType
{
	SERVER(0),
	PUBLIC(2),
	PRIVATE_MESSAGE_RECEIVED(3),
	TRADE_RECEIVED(4),
	PRIVATE_MESSAGE_INFO(5),
	PRIVATE_MESSAGE_SENT(6),
	PRIVATE_MESSAGE_RECEIVED_MOD(7),
	CLANCHAT(9),
	CLANCHAT_INFO(11),
	TRADE_SENT(12),
	ABUSE_REPORT(26),
	EXAMINE_ITEM(27),
	EXAMINE_NPC(28),
	EXAMINE_OBJECT(29),
	FRIENDS_LIST_ADD(30),
	IGNORE_LIST_ADD(31),
	AUTOCHAT(90),
	GAME(99),
	TRADE(101),
	DUEL(103),
	FILTERED(105),
	ACTION(109),
=======
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
	 * A normal game message.
	 */
	GAMEMESSAGE(0),
	/**
 	* A message in the public chat from a moderator
 	*/
	MODCHAT(1),
	/**
	 * A message in the public chat.
	 */
	PUBLICCHAT(2),
	/**
	 * A private message from another player.
	 */
	PRIVATECHAT(3),
	/**
	 * A message that the game engine sends.
	 */
	ENGINE(4),
	/**
	 * A message received when a friend logs in or out.
	 */
	LOGINLOGOUTNOTIFICATION(5),
	/**
	 * A private message sent to another player.
	 */
	PRIVATECHATOUT(6),
	/**
	 * A private message received from a moderator.
	 */
	MODPRIVATECHAT(7),
	/**
	 * A message received in clan chat.
	 */
	FRIENDSCHAT(9),
	/**
	 * A message received with information about the current clan chat.
	 */
	FRIENDSCHATNOTIFICATION(11),
	/**
	 * A trade request being sent.
	 */
	TRADE_SENT(12),
	/**
	 * A game broadcast.
	 */
	BROADCAST(14),
	/**
	 * An abuse report submitted.
	 */
	SNAPSHOTFEEDBACK(26),
	/**
	 * Examine item description.
	 */
	ITEM_EXAMINE(27),
	/**
	 * Examine NPC description.
	 */
	NPC_EXAMINE(28),
	/**
	 * Examine object description.
	 */
	OBJECT_EXAMINE(29),
	/**
	 * Adding player to friend list.
	 */
	FRIENDNOTIFICATION(30),
	/**
	 * Adding player to ignore list.
	 */
	IGNORENOTIFICATION(31),
	/**
	 * An autotyper message from a player.
	 */
	AUTOTYPER(90),
	/**
	 * An autotyper message from a mod.
	 */
	MODAUTOTYPER(91),
	/**
	 * A game message (ie. when a setting is changed).
	 */
	CONSOLE(99),
	/**
	 * A message received when somebody sends a trade offer.
	 */
	TRADEREQ(101),
	/**
	 * A message received when completing a trade or a duel
	 */
	TRADE(102),
	/**
	 * A message received when somebody sends a duel offer.
	 */
	CHALREQ_TRADE(103),
	/**
	 * A message received when someone sends a clan challenge offer.
	 */
	CHALREQ_FRIENDSCHAT(104),
	/**
	 * A message that was filtered.
	 */
	SPAM(105),
	/**
	 * A message that is relating to the player.
	 */
	PLAYERRELATED(106),
	/**
	 * A message that times out after 10 seconds.
	 */
	TENSECTIMEOUT(107),
	/**
	 * An unknown message type.
	 */
>>>>>>> upstream/master
	UNKNOWN(-1);

	private final int type;

<<<<<<< HEAD
	ChatMessageType(int type)
	{
		this.type = type;
	}

	public static ChatMessageType of(int type)
	{
		for (ChatMessageType ct : ChatMessageType.values())
		{
			if (ct.type == type)
			{
				return ct;
			}
		}
		return UNKNOWN;
	}

	public int getType()
	{
		return type;
=======
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
>>>>>>> upstream/master
	}
}
