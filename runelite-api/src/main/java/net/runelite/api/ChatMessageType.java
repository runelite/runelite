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

public enum ChatMessageType
{
	SERVER(0),
	PUBLIC(2),
	PRIVATE_MESSAGE_RECEIVED(3),
	TRADE_RECEIVED(4),
	PRIVATE_MESSAGE_INFO(5),
	PRIVATE_MESSAGE_SENT(6),
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
	TRADE(101),
	DUEL(103),
	FILTERED(105),
	ACTION(109),
	UNKNOWN(-1);

	private final int type;

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
}
