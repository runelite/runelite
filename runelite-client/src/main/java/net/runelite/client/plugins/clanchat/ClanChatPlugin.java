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

import com.google.common.collect.Sets;
import com.google.common.eventbus.Subscribe;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.SetMessage;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ClanManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;

@PluginDescriptor(
	name = "Clan Chat"
)
@Slf4j
public class ClanChatPlugin extends Plugin
{
	private final String joinClanChatMessage = "%s has joined.";
	private final String leftClanChatMessage = "%s has left.";
	private final String joinedClanChat = "Now talking in clan channel ";

	@Inject
	private Client client;

	@Inject
	private ClanManager clanManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private ClanChatConfig config;

	private HashSet<ClanMember> previousMembersInClan;

	private String clanChannelName;

	@Provides
	ClanChatConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ClanChatConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		previousMembersInClan = null;
	}

	@Schedule(
		period = 600,
		unit = ChronoUnit.MILLIS
	)
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

	@Subscribe
	public void onSetMessage(SetMessage setMessage)
	{
		if (setMessage.getValue().contains(joinedClanChat))
		{
			clanChannelName = setMessage.getValue().replace(joinedClanChat, "");
		}

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

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		boolean isInClan = client.getLocalPlayer().isClanMember();

		if (isInClan)
		{
			HashSet<ClanMember> currentMembers = new HashSet<>(Arrays.asList(client.getClanMembers()));
			if (previousMembersInClan != null && config.showEnterAndLeaveMessages())
			{
				Sets.SetView<ClanMember> clanMembersThatJoined = Sets.difference(currentMembers, previousMembersInClan);
				Sets.SetView<ClanMember> clanMembersThatLeft = Sets.difference(previousMembersInClan, currentMembers);

				sendChatMessage(clanMembersThatJoined, true);
				sendChatMessage(clanMembersThatLeft, false);
			}
			previousMembersInClan = currentMembers;
			return;
		}
		previousMembersInClan = null;
	}

	private void sendChatMessage(Set<ClanMember> members, boolean newMembers)
	{
		members.forEach(member ->
		{
			String chatMessage = newMembers ? String.format(joinClanChatMessage, member.getUsername())
				: String.format(leftClanChatMessage, member.getUsername());

			ClanMemberRank rank = clanManager.getRank(member.getUsername());
			int iconNumber = clanManager.getIconNumber(rank);
			String sender;

			if (rank == ClanMemberRank.UNRANKED)
			{
				sender = clanChannelName;
			}
			else
			{
				sender = clanChannelName + " <img=" + iconNumber + ">";
			}

			final String message = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append(chatMessage)
				.build();

			chatMessageManager.queue(
				QueuedMessage.builder()
					.type(ChatMessageType.CLANCHAT)
					.sender(sender)
					.runeLiteFormattedMessage(message)
					.build());
		});
	}

}
