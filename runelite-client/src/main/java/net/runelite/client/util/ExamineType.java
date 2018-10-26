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
package net.runelite.client.util;

import javax.annotation.Nullable;
import net.runelite.api.ChatMessageType;
import net.runelite.api.MenuAction;

public enum ExamineType
{
	GROUND_ITEM,

	/**
	 * Inventory item
	 */
	ITEM,

	/**
	 * Item found in some other interface, such as bank, equipment, alternate inventory (like when using the Grand
	 * Exchange or bank deposit box), shop, or items found when opening clue scrolls, barrows chests, etc.
	 * <p>
	 * Note: This qualification can often be incorrect, as all chat messages for these types of examine messages are
	 *       of {@link ChatMessageType#SERVER}, thus any SERVER-type messages provided to
	 *       {@link ExamineType#of(ChatMessageType)} will yield this type.
	 */
	ITEM_BANK_EQ,

	NPC,
	OBJECT;

	/**
	 * Gets the {@link ExamineType} corresponding to the given {@link ChatMessageType}.
	 *
	 * @param chatMessageType The chat message type to get an appropriate examine type from
	 * @return A corresponding ExamineType object, or null if no corresponding object could be
	 *         created.
	 */
	@Nullable
	public static ExamineType of(ChatMessageType chatMessageType)
	{
		switch (chatMessageType)
		{
			case EXAMINE_ITEM:
				return ITEM;
			case EXAMINE_OBJECT:
				return OBJECT;
			case EXAMINE_NPC:
				return NPC;
			case SERVER:
				return ITEM_BANK_EQ;
			default:
				return null;
		}
	}

	/**
	 * Gets the {@link ExamineType} corresponding to the given {@link MenuAction}.
	 *
	 * @param menuAction The menu action type to get an appropriate examine type from
	 * @return A corresponding ExamineType object, or null if no corresponding object could be
	 *         created.
	 */
	@Nullable
	public static ExamineType of(MenuAction menuAction)
	{
		switch (menuAction)
		{
			case EXAMINE_ITEM:
				return ITEM;
			case EXAMINE_ITEM_GROUND:
				return GROUND_ITEM;
			case EXAMINE_ITEM_BANK_EQ:
				return ITEM_BANK_EQ;
			case EXAMINE_OBJECT:
				return OBJECT;
			case EXAMINE_NPC:
				return NPC;
			default:
				return null;
		}
	}
}
