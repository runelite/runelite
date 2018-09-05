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

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import joptsimple.internal.Strings;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ChatModeType;
import net.runelite.api.ClanMemberRank;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarClientStr;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.SetMessage;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatboxInputListener;
import net.runelite.client.chat.CommandManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.ChatboxInput;
import net.runelite.client.events.PrivateMessageInput;
import net.runelite.client.game.ClanManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Clan Chat",
	description = "Configuration for Clan Chat plugin.",
	tags = {"icons", "rank", "chat", "history"}
)
public class ClanChatPlugin extends Plugin implements ChatboxInputListener
{
	private static final int MAX_RECENT_CHATS = 10;

	@Inject
	private Client client;

	@Inject
	private ClanManager clanManager;

	@Inject
	private CommandManager commandManager;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private ClanChatConfig config;

	@Inject
	private OverlayManager overlayManager;

	private List<String> chats = new ArrayList<>();

	@Provides
	ClanChatConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ClanChatConfig.class);
	}

	@Override
	public void startUp()
	{
		commandManager.register(this);
		if (!config.chatsData().isEmpty())
		{
			chats = new ArrayList<>(Arrays.asList(config.chatsData().split(",")));
		}
	}

	@Override
	public void shutDown()
	{
		commandManager.unregister(this);
		cleanupRecent();
	}

	@Override
	public boolean onChatboxInput(ChatboxInput chatboxInput)
	{
		if (!config.swapChat() && (!config.mobileChat() || isClanChatClosed()))
		{
			return false;
		}

		String msg = chatboxInput.getValue();

		if (msg.startsWith("/"))
		{
			msg = msg.substring(1);
			chatboxInput.setChatType(ChatModeType.PUBLIC.getType());
		}
		else
		{
			msg = "/" + msg;
			chatboxInput.setChatType(ChatModeType.CLAN.getType());
		}

		chatboxInput.setValue(msg);

		executor.execute(chatboxInput::resume);

		return true;
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
			Widget widget = client.getWidget(WidgetID.CLAN_CHAT_GROUP_ID, 15);

			if (config.recentChats() && (widget.getChildren() == null || )
			{
				clanChatTitleWidget.setText("Clan Chat - Last Joined");

				for (int i = 0; i < chats.size(); i++)
				{
					Widget name = widget.createChild(-1, 4);
					name.setFontId(494);
					name.setText(chats.get(i));
					name.setTextColor(0xffffff);
					name.setOriginalWidth(142);
					name.setOriginalHeight(15);
					name.setOriginalY(1 + i * 14);
					name.setOriginalX(11);
					name.revalidate();
				}
			}
			else if (client.getClanChatCount() != 0)
			{
				clanChatTitleWidget.setText("Clan Chat (" + client.getClanChatCount() + "/100)");
			}
		}
	}

	@Override
	public boolean onPrivateMessageInput(PrivateMessageInput privateMessageInput)
	{
		return false;
	}

	@Subscribe
	public void onSetMessage(SetMessage setMessage)
	{
		if (client.getGameState() != GameState.LOADING && client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (config.rankIcons() && setMessage.getType() == ChatMessageType.CLANCHAT && client.getClanChatCount() > 0)
		{
			insertClanRankIcon(setMessage);
		}
	}

	@Subscribe
	public void onVarClientstrChanged(VarClientStrChanged strChanged)
	{
		if (strChanged.getIndex() == VarClientStr.MOST_RECENT_CLAN_CHAT.getIndex() && config.recentChats())
		{
			fixedAdd(client.getStrVarcs()[VarClientStr.MOST_RECENT_CLAN_CHAT.getIndex()]);
		}
	}

	private void cleanupRecent()
	{
		Widget widget = client.getWidget(WidgetID.CLAN_CHAT_GROUP_ID, 15);
		if (widget != null && widget.getDynamicChildren().length > 0)
		{
			for (Widget child : widget.getDynamicChildren())
			{
				child.setHidden(true);
			}
		}
	}

	private void fixedAdd(String s)
	{
		if (Strings.isNullOrEmpty(s))
		{
			return;
		}

		chats.removeIf(s::equalsIgnoreCase);
		chats.add(s);

		while (chats.size() > MAX_RECENT_CHATS)
		{
			chats.remove(0);
		}

		config.chatsData(String.join(",", chats));
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

	private boolean isClanChatClosed()
	{
		Widget widget = client.getWidget(WidgetInfo.CLAN_CHAT);

		return widget == null || widget.isHidden();
	}
}
