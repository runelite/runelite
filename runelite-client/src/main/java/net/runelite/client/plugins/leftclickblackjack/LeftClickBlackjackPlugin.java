/*
 * Copyright (c) 2018 gazivodag <https://github.com/gazivodag>
 * Copyright (c) 2019 lucwousin <https://github.com/lucwousin>
 * Copyright (c) 2019 infinitay <https://github.com/Infinitay>
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
package net.runelite.client.plugins.leftclickblackjack;

import com.google.inject.Provides;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomUtils;
import javax.inject.Inject;

@PluginDescriptor(
	name = "Left Click Blackjack",
	enabledByDefault = false,
	description = "Allows for one-click blackjacking, both knocking out and pickpocketing",
	tags = {"blackjack", "thieving"}
)
public class LeftClickBlackjackPlugin extends Plugin
{
	private static final int POLLNIVNEACH_REGION = 13358;

	private static final String SUCCESS_BLACKJACK = "You smack the bandit over the head and render them unconscious.";
	private static final String FAILED_BLACKJACK = "Your blow only glances off the bandit's head.";

	private static final String PICKPOCKET = "Pickpocket";
	private static final String KNOCK_OUT = "Knock-Out";
	private static final String BANDIT = "Bandit";
	private static final String MENAPHITE = "Menaphite Thug";

	@Inject
	private Client client;

	@Inject
	private LeftClickBlackjackConfig config;

	@Inject
	private EventBus eventBus;

	@Inject
	private MenuManager menuManager;

	private long nextKnockOutTick = 0;
	private boolean knockout = true;

	@Provides
	LeftClickBlackjackConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LeftClickBlackjackConfig.class);
	}

	@Subscribe
	private void onClientTick(ClientTick event)
	{
		if (client.getGameState() != GameState.LOGGED_IN ||
				client.getMapRegions() == null ||
				!ArrayUtils.contains(client.getMapRegions(), POLLNIVNEACH_REGION))
		{
			return;
		}

		MenuEntry[] entries = client.getMenuEntries();
		int putAtTopId = -1;
		for (int i = 0; i < entries.length; i++)
		{
			MenuEntry entry = entries[i];
			if (entry.getTarget().contains(BANDIT) || entry.getTarget().contains(MENAPHITE))
			{
				if ((entry.getOption().equals(KNOCK_OUT) && knockout) ||
						(entry.getOption().equals(PICKPOCKET) && !knockout))
				{
					putAtTopId = i;
					break;
				}
			}
		}

		if (putAtTopId != -1)
		{
			MenuEntry temp = entries[entries.length - 1];
			entries[entries.length - 1] = entries[putAtTopId];
			entries[putAtTopId] = temp;
			client.setMenuEntries(entries);
		}
	}

	@Subscribe
	private void onGameTick(GameTick event)
	{
		if (client.getTickCount() >= nextKnockOutTick)
		{
			knockout = true;
		}
	}

	@Subscribe
	private void onChatMessage(ChatMessage event)
	{
		final String msg = event.getMessage();

		if (event.getType() == ChatMessageType.SPAM && (msg.equals(SUCCESS_BLACKJACK) || (msg.equals(FAILED_BLACKJACK) && config.pickpocketOnAggro())))
		{
			knockout = false;
			final int ticks = config.random() ? RandomUtils.nextInt(3, 4) : 4;
			nextKnockOutTick = client.getTickCount() + ticks;
		}
	}
}