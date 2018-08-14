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
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ClanMemberRank;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.SetMessage;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatboxInputListener;
import net.runelite.client.chat.CommandManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.ChatboxInput;
import net.runelite.client.events.PrivateMessageInput;
import net.runelite.client.game.ClanManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;

@PluginDescriptor(
	name = "Clan Chat",
	description = "Add rank icons to users talking in clan chat",
	tags = {"icons", "rank"}
)
public class ClanChatPlugin extends Plugin implements ChatboxInputListener
{
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

	@Schedule(
		period = 600,
		unit = ChronoUnit.MILLIS
	)

	@Provides
	ClanChatConfig getConfig(ConfigManager configManager)
	{

		return configManager.getConfig(ClanChatConfig.class);
	}

	@Override
	public void startUp()
	{
		commandManager.register(this);
	}

	@Override
	public void shutDown()
	{
		commandManager.unregister(this);
	}

	public void updateClanChatTitle()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		Widget clanChatTitleWidget = client.getWidget(WidgetInfo.CLAN_CHAT_TITLE);
		if (clanChatTitleWidget != null)
		{
			clanChatTitleWidget.setText("Clan Chat (" + client.getClanChatCount() + "/100)");
		}
	}

	private boolean isClanChatClosed()
	{
		Widget widget = client.getWidget(WidgetInfo.CLAN_CHAT);

		return widget == null || widget.isHidden();
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
			chatboxInput.setChatType(ChatMessageType.PUBLIC_MODE.getType());
		}
		else
		{
			msg = "/" + msg;
			chatboxInput.setChatType(ChatMessageType.CLANCHAT_MODE.getType());
		}

		chatboxInput.setValue(msg);

		executor.execute(() ->
		{
			chatboxInput.resume();
		});

		return true;
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


}
