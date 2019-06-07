/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.blackjack;

import com.google.inject.Binder;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import api.ChatMessageType;
import api.Client;
import static api.Varbits.QUEST_THE_FEUD;
import api.events.ChatMessage;
import api.events.GameTick;
import api.events.MenuEntryAdded;
import api.events.VarbitChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import static net.runelite.client.util.MenuUtil.swap;

/**
 * Authors gazivodag longstreet
 */
@PluginDescriptor(
	name = "Blackjack",
	description = "Uses chat messages and tick timers instead of animations to read",
	tags = {"blackjack", "thieving"},
	type = PluginType.SKILLING
)
@Singleton
@Slf4j
public class BlackjackPlugin extends Plugin
{
	private static final String PICKPOCKET = "Pickpocket";
	private static final String KNOCK_OUT = "Knock-out";
	private static final String LURE = "Lure";
	private static final String BANDIT = "Bandit";
	private static final String MENAPHITE = "Menaphite Thug";

	@Inject
	private Client client;

	@Inject
	private MenuManager menuManager;

	private int lastKnockout;
	private boolean pickpocketing;
	private boolean ableToBlackJack;

	@Override
	public void configure(Binder binder)
	{
	}

	@Override
	protected void startUp() throws Exception
	{
		menuManager.addPriorityEntry(LURE, BANDIT);
		menuManager.addPriorityEntry(LURE, MENAPHITE);

		menuManager.addPriorityEntry(KNOCK_OUT, BANDIT);
		menuManager.addPriorityEntry(KNOCK_OUT, MENAPHITE);
	}

	@Override
	protected void shutDown() throws Exception
	{
		menuManager.removePriorityEntry(LURE, BANDIT);
		menuManager.removePriorityEntry(LURE, MENAPHITE);

		menuManager.removePriorityEntry(PICKPOCKET, BANDIT);
		menuManager.removePriorityEntry(PICKPOCKET, MENAPHITE);

		menuManager.removePriorityEntry(KNOCK_OUT, BANDIT);
		menuManager.removePriorityEntry(KNOCK_OUT, MENAPHITE);
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (ableToBlackJack && pickpocketing && client.getTickCount() >= lastKnockout + 4)
		{
			pickpocketing = false;

			menuManager.removePriorityEntry(PICKPOCKET, BANDIT);
			menuManager.removePriorityEntry(PICKPOCKET, MENAPHITE);

			menuManager.addPriorityEntry(KNOCK_OUT, BANDIT);
			menuManager.addPriorityEntry(KNOCK_OUT, MENAPHITE);
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		// Lure has higher priority than knock-out
		if (event.getTarget().contains(MENAPHITE) || event.getTarget().contains(BANDIT)
			&& event.getOption().equals(LURE))
		{
			swap(client, KNOCK_OUT, LURE, event.getTarget(), false);
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (chatMessage.getType() == ChatMessageType.SPAM)
		{
			if (chatMessage.getMessage().equals("You smack the bandit over the head and render them unconscious.")
				|| chatMessage.getMessage().equals("Your blow only glances off the bandit's head."))
			{
				menuManager.removePriorityEntry(KNOCK_OUT, BANDIT);
				menuManager.removePriorityEntry(KNOCK_OUT, MENAPHITE);

				menuManager.addPriorityEntry(PICKPOCKET, BANDIT);
				menuManager.addPriorityEntry(PICKPOCKET, MENAPHITE);

				lastKnockout = client.getTickCount();
				pickpocketing = true;
			}
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		ableToBlackJack = client.getVar(QUEST_THE_FEUD) >= 13;

		if (!ableToBlackJack)
		{
			menuManager.removePriorityEntry(LURE, BANDIT);
			menuManager.removePriorityEntry(LURE, MENAPHITE);

			menuManager.removePriorityEntry(KNOCK_OUT, BANDIT);
			menuManager.removePriorityEntry(KNOCK_OUT, MENAPHITE);

			menuManager.removePriorityEntry(PICKPOCKET, BANDIT);
			menuManager.removePriorityEntry(PICKPOCKET, MENAPHITE);
		}
	}
}