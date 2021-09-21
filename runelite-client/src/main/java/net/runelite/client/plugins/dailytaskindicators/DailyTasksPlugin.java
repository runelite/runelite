/*
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
 * Copyright (c) 2018-2019, Shaun Dreclin <https://github.com/ShaunDreclin>
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

package net.runelite.client.plugins.dailytaskindicators;

import com.google.inject.Provides;
import javax.inject.Inject;

import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.vars.AccountType;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.dailytaskindicators.infoboxes.*;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Daily Task Indicator",
	description = "Show chat notifications for daily tasks upon login"
)
public class DailyTasksPlugin extends Plugin
{
	private static final int ONE_DAY = 86400000;

	private static final String HERB_BOX_MESSAGE = "You have herb boxes waiting to be collected at NMZ.";
	private static final int HERB_BOX_MAX = 15;
	private static final int HERB_BOX_COST = 9500;
	private static final String STAVES_MESSAGE = "You have battlestaves waiting to be collected from Zaff.";
	private static final String ESSENCE_MESSAGE = "You have essence waiting to be collected from Wizard Cromperty.";
	private static final String RUNES_MESSAGE = "You have random runes waiting to be collected from Lundail.";
	private static final String SAND_MESSAGE = "You have sand waiting to be collected from Bert.";
	private static final int SAND_QUEST_COMPLETE = 160;
	private static final String FLAX_MESSAGE = "You have bowstrings waiting to be converted from flax from the Flax keeper.";
	private static final String ARROWS_MESSAGE = "You have ogre arrows waiting to be collected from Rantz.";
	private static final String BONEMEAL_MESSAGE = "You have bonemeal and slime waiting to be collected from Robin.";
	private static final int BONEMEAL_PER_DIARY = 13;
	private static final String DYNAMITE_MESSAGE = "You have dynamite waiting to be collected from Thirus.";

	@Inject
	private Client client;

	@Inject
	private DailyTasksConfig config;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	private long lastReset;
	private boolean loggingIn, dailyReset;

	@Provides
	DailyTasksConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DailyTasksConfig.class);
	}

	@Override
	public void startUp()
	{
		loggingIn = true;
		infoBoxManager.addInfoBox(new HerbBoxes(ItemID.HERB_BOX, HERB_BOX_MESSAGE, itemManager, config, this));
		infoBoxManager.addInfoBox(new Battlestaves(ItemID.BATTLESTAFF, STAVES_MESSAGE, itemManager, config, this));
		infoBoxManager.addInfoBox(new Essence(ItemID.RUNE_ESSENCE, ESSENCE_MESSAGE, itemManager, config, this));
		infoBoxManager.addInfoBox(new Runes(ItemID.FIRE_RUNE, RUNES_MESSAGE, itemManager, config, this));
		infoBoxManager.addInfoBox(new Sand(ItemID.BUCKET_OF_SAND, SAND_MESSAGE, itemManager, config, this));
		infoBoxManager.addInfoBox(new Flax(ItemID.BOW_STRING, FLAX_MESSAGE, itemManager, config, this));
		infoBoxManager.addInfoBox(new Arrows(ItemID.OGRE_ARROW, ARROWS_MESSAGE, itemManager, config, this));
		infoBoxManager.addInfoBox(new Bonemeal(ItemID.BONEMEAL, BONEMEAL_MESSAGE, itemManager, config, this));
		infoBoxManager.addInfoBox(new Dynamite(ItemID.DYNAMITE, DYNAMITE_MESSAGE, itemManager, config, this));
	}

	@Override
	public void shutDown()
	{
		lastReset = 0L;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGING_IN)
		{
			loggingIn = true;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		long currentTime = System.currentTimeMillis();
		dailyReset = !loggingIn && currentTime - lastReset > ONE_DAY;

		if ((dailyReset || loggingIn)
			&& client.getVar(VarClientInt.MEMBERSHIP_STATUS) == 1)
		{
			// Round down to the nearest day
			lastReset = (long) Math.floor(currentTime / ONE_DAY) * ONE_DAY;
			loggingIn = false;

			if (herbBoxesAvailable())
			{
				sendChatMessage(HERB_BOX_MESSAGE);
			}

			if (stavesAvailable())
			{
				sendChatMessage(STAVES_MESSAGE);
			}

			if (essenceAvailable())
			{
				sendChatMessage(ESSENCE_MESSAGE);
			}

			if (runesAvailable())
			{
				sendChatMessage(RUNES_MESSAGE);
			}

			if (sandAvailable())
			{
				sendChatMessage(SAND_MESSAGE);
			}

			if (flaxAvailable())
			{
				sendChatMessage(FLAX_MESSAGE);
			}

			if (arrowsAvailable())
			{
				sendChatMessage(ARROWS_MESSAGE);
			}

			if (bonemealAvailable())
			{
				sendChatMessage(BONEMEAL_MESSAGE);
			}

			if (dynamiteAvailable())
			{
				sendChatMessage(DYNAMITE_MESSAGE);
			}
		}
	}

	public boolean herbBoxesAvailable()
	{
		return config.showHerbBoxes()
			&& client.getAccountType() == AccountType.NORMAL
			&& client.getVar(VarPlayer.NMZ_REWARD_POINTS) >= HERB_BOX_COST
			&& (client.getVar(Varbits.DAILY_HERB_BOXES_COLLECTED) < HERB_BOX_MAX
			|| dailyReset);
	}

	public boolean stavesAvailable()
	{
		return config.showStaves()
			&& client.getVar(Varbits.DIARY_VARROCK_EASY) == 1
			&& (client.getVar(Varbits.DAILY_STAVES_COLLECTED) == 0
			|| dailyReset);
	}

	public boolean essenceAvailable()
	{
		return config.showEssence()
			&& client.getVar(Varbits.DIARY_ARDOUGNE_MEDIUM) == 1
			&& (client.getVar(Varbits.DAILY_ESSENCE_COLLECTED) == 0
			|| dailyReset);
	}

	public boolean runesAvailable()
	{
		return config.showRunes()
			&& client.getVar(Varbits.DIARY_WILDERNESS_EASY) == 1
			&& (client.getVar(Varbits.DAILY_RUNES_COLLECTED) == 0
			|| dailyReset);
	}

	public boolean sandAvailable()
	{
		return config.showSand()
			&& client.getVar(Varbits.QUEST_THE_HAND_IN_THE_SAND) >= SAND_QUEST_COMPLETE
			&& (client.getVar(Varbits.DAILY_SAND_COLLECTED) == 0
			|| dailyReset);
	}

	public boolean flaxAvailable()
	{
		return config.showFlax()
			&& client.getVar(Varbits.DIARY_KANDARIN_EASY) == 1
			&& (client.getVar(Varbits.DAILY_FLAX_STATE) == 0
			|| dailyReset);
	}

	public boolean arrowsAvailable()
	{
		return config.showArrows()
			&& client.getVar(Varbits.DIARY_WESTERN_EASY) == 1
			&& (client.getVar(Varbits.DAILY_ARROWS_STATE) == 0
			|| dailyReset);
	}

	public boolean bonemealAvailable()
	{
		if (config.showBonemeal() && client.getVar(Varbits.DIARY_MORYTANIA_MEDIUM) == 1)
		{
			int collected = client.getVar(Varbits.DAILY_BONEMEAL_STATE);
			int max = BONEMEAL_PER_DIARY;
			if (client.getVar(Varbits.DIARY_MORYTANIA_HARD) == 1)
			{
				max += BONEMEAL_PER_DIARY;
				if (client.getVar(Varbits.DIARY_MORYTANIA_ELITE) == 1)
				{
					max += BONEMEAL_PER_DIARY;
				}
			}
			return collected < max || dailyReset;
		}

		return false;
	}

	public boolean dynamiteAvailable()
	{
		return config.showDynamite()
			&& client.getVar(Varbits.DIARY_KOUREND_MEDIUM) == 1
			&& (client.getVar(Varbits.DAILY_DYNAMITE_COLLECTED) == 0
			|| dailyReset);
	}

	private void sendChatMessage(String chatMessage)
	{
		final String message = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append(chatMessage)
			.build();

		chatMessageManager.queue(
			QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(message)
				.build());
	}
}
