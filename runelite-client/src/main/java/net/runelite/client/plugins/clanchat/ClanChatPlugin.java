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

import com.google.common.base.Strings;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.lang.String;
import java.util.Set;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ClanMemberRank;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.SetMessage;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ClanManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.http.api.hiscore.*;

@PluginDescriptor(
	name = "Clan Chat"
)
@Slf4j
public class ClanChatPlugin extends Plugin
{
	private Set<String> filteredAccounts = new HashSet<>();
	private HiscoreClient hiscoreClient = new HiscoreClient();
	private HiscoreResult result;
	private Integer currentSetFilter = 0;

    @Inject
	private Client client;

	@Inject
	private ClanManager clanManager;

	@Inject
	private ClanChatConfig config;

	@Inject
	private ScheduledExecutorService executor;

	@Provides
	ClanChatConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ClanChatConfig.class);
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

	/**
	 * Takes incoming cc messages, checks for rank, adds rank imgage,
	 * and filters Total Levels below if active. Stores previously filtered
	 * accounts in a hashSet to avoid making redudant hiscore lookups.
	 *
	 * @param setMessage message to be altered
	 */
	@Subscribe
	public void onSetMessage(SetMessage setMessage)
	{

	    boolean ranked;
	    //If filter minimum has changed, flush the stored accounts
	    if (currentSetFilter != config.getTotalLevelFilter())
		{
			filteredAccounts.clear();
			currentSetFilter = config.getTotalLevelFilter();
		}

		if (client.getGameState() != GameState.LOADING && client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (setMessage.getType() == ChatMessageType.CLANCHAT && client.getClanChatCount() > 0)
		{
			//Look through hash for acct if already to be filtered
			if (isPlayerFiltered(setMessage.getName()))
			{
				log.debug("player: " +setMessage.getName() + " is already filtered");
				filterMessage(setMessage);
			}
			//lookup rank and hiscore lookup if TL filter is active and account is not ranked in cc
			else
			{
				ranked = insertClanRankIcon(setMessage);	//Check for ranked
				if (config.getTotalLevelFilter() != 0 && !ranked)
				{
					executor.submit(() -> lookupPlayer(setMessage));
					return;
				}
			}
			client.refreshChat();
		}
	}

	/**
	 * Looks up player on hiscores and alters the message if it is to be filtered.
	 * @param message account name pulled from message and altered if neede
	 */
	private void lookupPlayer(final SetMessage message)
	{
		String account = message.getMessageNode().getName();

		account = sanitize(account);

		HiscoreSkill skill;
		skill =  HiscoreSkill.valueOf(net.runelite.api.Skill.OVERALL.getName().toUpperCase());

		if (Strings.isNullOrEmpty(account))
		{
			return;
		}
		try
		{
			SingleHiscoreSkillResult result = hiscoreClient.lookup(account, skill);
			Skill hiscoreSkill = result.getSkill();

			if (config.getTotalLevelFilter() > hiscoreSkill.getLevel())
			{
				//Add account to "blacklist" hashSet
				filteredAccounts.add(message.getMessageNode().getName());
				filterMessage(message);
			}
		}
		catch (IOException ex)
		{
			log.warn("Error fetching Hiscore data " + ex.getMessage());
		}
		//If player is not on hiscores this will throw a nullpointer exception, therefore we filter the message
		catch (NullPointerException n)
		{
			log.debug("Null pointer");
			filterMessage(message);
		}
		client.refreshChat();
	}

	/**
	 * Alters the message to state that it has been filtered. Looking for way to just delete the message
	 * instead of altering the contents.
	 * @param message message to be altered
	 */
	private void filterMessage(SetMessage message)
	{
		message.getMessageNode().setName("FILTERED");
		message.getMessageNode().setValue("");
	}

	/**
	 * Looks through hashSet to see if the account has already been filtered.
	 * @param name name of account to search
	 * @return true if account has previously been filtered.
	 */
	private boolean isPlayerFiltered(String name)
	{
		log.debug("Looking for account: " + name);
		for (String filtered: filteredAccounts)
		{
			log.debug(filtered);
			if (name.contains(filtered))
			{
				return true;
			}
		}
		return false;
	}


	private String sanitize(String lookup)
	{
		String cleaned = lookup.contains("<img") ? lookup.substring(lookup.lastIndexOf('>') + 1) : lookup;
		return cleaned.replace('\u00A0', ' ');
	}

	private boolean insertClanRankIcon(final SetMessage message)
	{
		final ClanMemberRank rank = clanManager.getRank(message.getName());

		if (rank != null && rank != ClanMemberRank.UNRANKED)
		{
			int iconNumber = clanManager.getIconNumber(rank);
			message.getMessageNode()
				.setSender(message.getMessageNode().getSender() + " <img=" + iconNumber + ">");
			return true;
		}
		return false;
	}

}
