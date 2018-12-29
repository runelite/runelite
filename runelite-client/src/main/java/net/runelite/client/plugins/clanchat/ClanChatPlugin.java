/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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
package net.runelite.client.plugins.clanchat;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ClanMemberRank;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarClientStr;
import net.runelite.api.widgets.WidgetType;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.SetMessage;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ClanManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Clan Chat",
	description = "Add rank icons to users talking in clan chat",
	tags = {"icons", "rank", "recent"}
)
public class ClanChatPlugin extends Plugin
{
	private static final int MAX_CHATS = 10;
	private static final String CLAN_CHAT_TITLE = "Clan Chat";
	private static final String RECENT_TITLE = "Recent Clan Chats";
	private static final Joiner JOINER = Joiner.on(',').skipNulls();
	private static final Splitter SPLITTER = Splitter.on(',').trimResults().omitEmptyStrings();

	@Inject
	private Client client;

	@Inject
	private ClanManager clanManager;

	@Inject
	private ClanChatConfig config;

	private List<String> chats = new ArrayList<>();

	@Provides
	ClanChatConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ClanChatConfig.class);
	}

	@Override
	public void startUp()
	{
		chats = new ArrayList<>(SPLITTER.splitToList(config.chatsData()));
	}

	@Override
	public void shutDown()
	{
		resetClanChats();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals("clanchat") && !config.recentChats())
		{
			resetClanChats();
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		Widget clanChatTitleWidget = client.getWidget(WidgetInfo.CLAN_CHAT_TITLE);
		if (clanChatTitleWidget != null)
		{
			Widget clanChatList = client.getWidget(WidgetInfo.CLAN_CHAT_LIST);
			Widget owner = client.getWidget(WidgetInfo.CLAN_CHAT_OWNER);
			if (client.getClanChatCount() > 0)
			{
				clanChatTitleWidget.setText(CLAN_CHAT_TITLE + " (" + client.getClanChatCount() + "/100)");
			}
			else if (config.recentChats() && clanChatList.getChildren() == null && !Strings.isNullOrEmpty(owner.getText()))
			{
				clanChatTitleWidget.setText(RECENT_TITLE);

				loadClanChats();
			}
		}
	}

	@Subscribe
	public void onVarClientStrChanged(VarClientStrChanged strChanged)
	{
		if (strChanged.getIndex() == VarClientStr.RECENT_CLAN_CHAT.getIndex() && config.recentChats())
		{
			updateRecentChat(client.getVar(VarClientStr.RECENT_CLAN_CHAT));
		}
	}

	@Subscribe
	public void onSetMessage(SetMessage setMessage)
	{
		if (client.getGameState() != GameState.LOADING && client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (setMessage.getType() == ChatMessageType.CLANCHAT && client.getClanChatCount() > 0)
		{
			insertClanRankIcon(setMessage);
		}
	}

	private void insertClanRankIcon(final SetMessage message)
	{
		final ClanMemberRank rank = clanManager.getRank(message.getName());

		if (rank != null && rank != ClanMemberRank.UNRANKED)
		{
			int iconNumber = clanManager.getIconNumber(rank);
			message.getMessageNode()
				.setSender(message.getMessageNode().getSender() + " <img=" + iconNumber + ">");
			client.refreshChat();
		}
	}

	private void resetClanChats()
	{
		Widget clanChatList = client.getWidget(WidgetInfo.CLAN_CHAT_LIST);
		Widget clanChatTitleWidget = client.getWidget(WidgetInfo.CLAN_CHAT_TITLE);

		if (clanChatList == null)
		{
			return;
		}

		if (client.getClanChatCount() == 0)
		{
			clanChatList.setChildren(null);
		}

		clanChatTitleWidget.setText(CLAN_CHAT_TITLE);
	}

	private void loadClanChats()
	{
		Widget clanChatList = client.getWidget(WidgetInfo.CLAN_CHAT_LIST);
		if (clanChatList == null)
		{
			return;
		}

		int y = 2;
		clanChatList.setChildren(null);
		for (String chat : Lists.reverse(chats))
		{
			Widget widget = clanChatList.createChild(-1, WidgetType.TEXT);
			widget.setFontId(494);
			widget.setTextColor(0xffffff);
			widget.setText(chat);
			widget.setOriginalHeight(14);
			widget.setOriginalWidth(142);
			widget.setOriginalY(y);
			widget.setOriginalX(20);
			widget.revalidate();

			y += 14;
		}
	}

	private void updateRecentChat(String s)
	{
		if (Strings.isNullOrEmpty(s))
		{
			return;
		}

		s = Text.toJagexName(s);

		chats.removeIf(s::equalsIgnoreCase);
		chats.add(s);

		while (chats.size() > MAX_CHATS)
		{
			chats.remove(0);
		}

		config.chatsData(JOINER.join(chats));
	}
}
