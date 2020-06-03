/*
 * Copyright (c) 2020, Anthony <https://github.com/while-loop>
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
package net.runelite.client.plugins.chathistory;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.widgets.WidgetInfo;

@Getter
enum ChatboxTab
{

	ALL("All", "Switch tab", WidgetInfo.CHATBOX_TAB_ALL,
		ChatMessageType.values()),

	// null 'after' var since we're not adding to menu
	PRIVATE("Private", null, WidgetInfo.CHATBOX_TAB_PRIVATE,
		ChatMessageType.PRIVATECHAT, ChatMessageType.PRIVATECHATOUT, ChatMessageType.MODPRIVATECHAT,
		ChatMessageType.LOGINLOGOUTNOTIFICATION),

	// null 'after' var since we're not adding to menu
	PUBLIC("Public", null, WidgetInfo.CHATBOX_TAB_PUBLIC,
		ChatMessageType.PUBLICCHAT, ChatMessageType.AUTOTYPER, ChatMessageType.MODCHAT, ChatMessageType.MODAUTOTYPER),

	GAME("Game", "Game: Filter", WidgetInfo.CHATBOX_TAB_GAME,
		ChatMessageType.GAMEMESSAGE, ChatMessageType.ENGINE, ChatMessageType.BROADCAST,
		ChatMessageType.SNAPSHOTFEEDBACK, ChatMessageType.ITEM_EXAMINE, ChatMessageType.NPC_EXAMINE,
		ChatMessageType.OBJECT_EXAMINE, ChatMessageType.FRIENDNOTIFICATION, ChatMessageType.IGNORENOTIFICATION,
		ChatMessageType.CONSOLE, ChatMessageType.SPAM, ChatMessageType.PLAYERRELATED, ChatMessageType.TENSECTIMEOUT,
		ChatMessageType.WELCOME, ChatMessageType.UNKNOWN),

	CLAN("Clan", "Clan: Off", WidgetInfo.CHATBOX_TAB_CLAN,
		ChatMessageType.FRIENDSCHATNOTIFICATION, ChatMessageType.FRIENDSCHAT, ChatMessageType.CHALREQ_FRIENDSCHAT),

	TRADE("Trade", "Trade: Off", WidgetInfo.CHATBOX_TAB_TRADE,
		ChatMessageType.TRADE_SENT, ChatMessageType.TRADEREQ, ChatMessageType.TRADE, ChatMessageType.CHALREQ_TRADE),
	;

	private static final Map<Integer, ChatboxTab> TAB_MESSAGE_TYPES;

	private final String name;
	@Nullable
	private final String after;
	private final int widgetId;
	private final ChatMessageType[] messageTypes;

	ChatboxTab(String name, String after, WidgetInfo widgetId, ChatMessageType... messageTypes)
	{
		this.name = name;
		this.after = after;
		this.widgetId = widgetId.getId();
		this.messageTypes = messageTypes;
	}

	static
	{
		ImmutableMap.Builder<Integer, ChatboxTab> builder = ImmutableMap.builder();
		for (ChatboxTab t : values())
		{
			builder.put(t.widgetId, t);
		}
		TAB_MESSAGE_TYPES = builder.build();
	}

	static ChatboxTab of(int widgetId)
	{
		return TAB_MESSAGE_TYPES.get(widgetId);
	}
}
