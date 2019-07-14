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
package net.runelite.client.plugins.blackjack;

import com.google.inject.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.util.MenuUtil;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.RandomUtils;

/**
 * Authors gazivodag longstreet
 */
@PluginDescriptor(
		name = "Blackjack",
		description = "Allows for one-click blackjacking, both knocking out and pickpocketing",
		tags = {"blackjack", "thieving"},
		type = PluginType.SKILLING,
		enabledByDefault = false
)
@Singleton
@Slf4j
public class BlackjackPlugin extends Plugin
{
	private static final String SUCCESS_BLACKJACK = "You smack the bandit over the head and render them unconscious.";
	private static final String FAILED_BLACKJACK = "Your blow only glances off the bandit's head.";
	private static final int POLLNIVNEACH_REGION = 13358;
	private long nextKnockOutTick = 0;
	@Inject
	private Client client;
	@Inject
	private BlackjackConfig config;
	@Inject
	private EventBus eventBus;

	private boolean pickpocketOnAggro;

	@Provides
	BlackjackConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BlackjackConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();

		this.pickpocketOnAggro = config.pickpocketOnAggro();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(MenuEntryAdded.class, this, this::onMenuEntryAdded);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("blackjack"))
		{
			this.pickpocketOnAggro = config.pickpocketOnAggro();
		}
	}

	private void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (client.getGameState() != GameState.LOGGED_IN ||
				client.getVar(Varbits.QUEST_THE_FEUD) < 13 ||
				client.getLocalPlayer().getWorldLocation().getRegionID() != POLLNIVNEACH_REGION)
		{
			return;
		}

		String option = Text.removeTags(event.getOption().toLowerCase());
		String target = Text.removeTags(event.getTarget().toLowerCase());
		if (nextKnockOutTick >= client.getTickCount())
		{
			MenuUtil.swap(client, "pickpocket", option, target);
		}
		else
		{
			MenuUtil.swap(client, "knock-out", option, target);
		}
	}

	private void onChatMessage(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.SPAM && event.getMessage().equals(SUCCESS_BLACKJACK) ^ (event.getMessage().equals(FAILED_BLACKJACK) && this.pickpocketOnAggro))
		{
			nextKnockOutTick = client.getTickCount() + RandomUtils.nextInt(3, 4);
		}
	}
}
