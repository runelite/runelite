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
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.gameval.VarClientID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

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

	private long lastReset;
	private boolean loggingIn;

	@Provides
	DailyTasksConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DailyTasksConfig.class);
	}

	@Override
	public void startUp()
	{
		loggingIn = true;
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
		boolean dailyReset = !loggingIn && currentTime - lastReset > ONE_DAY;

		if ((dailyReset || loggingIn)
			&& client.getVarcIntValue(VarClientID.PLAYERMEMBER) == 1)
		{
			// Round down to the nearest day
			lastReset = (long) Math.floor(currentTime / ONE_DAY) * ONE_DAY;
			loggingIn = false;

			if (config.showHerbBoxes())
			{
				checkHerbBoxes(dailyReset);
			}

			if (config.showStaves())
			{
				checkStaves(dailyReset);
			}

			if (config.showEssence())
			{
				checkEssence(dailyReset);
			}

			if (config.showRunes())
			{
				checkRunes(dailyReset);
			}

			if (config.showSand())
			{
				checkSand(dailyReset);
			}

			if (config.showFlax())
			{
				checkFlax(dailyReset);
			}

			if (config.showBonemeal())
			{
				checkBonemeal(dailyReset);
			}

			if (config.showDynamite())
			{
				checkDynamite(dailyReset);
			}

			if (config.showArrows())
			{
				checkArrows(dailyReset);
			}
		}
	}

	private void checkHerbBoxes(boolean dailyReset)
	{
		if (client.getVarbitValue(VarbitID.IRONMAN) == 0
			&& client.getVarpValue(VarPlayerID.NZONE_REWARDPOINTS) >= HERB_BOX_COST
			&& (client.getVarbitValue(VarbitID.NZONE_HERBBOXES_PURCHASED) < HERB_BOX_MAX
			|| dailyReset))
		{
			sendChatMessage(HERB_BOX_MESSAGE);
		}
	}

	private void checkStaves(boolean dailyReset)
	{
		if (client.getVarbitValue(VarbitID.VARROCK_DIARY_EASY_COMPLETE) == 1
			&& (client.getVarbitValue(VarbitID.ZAFF_LAST_CLAIMED) == 0
			|| dailyReset))
		{
			sendChatMessage(STAVES_MESSAGE);
		}
	}

	private void checkEssence(boolean dailyReset)
	{
		if (client.getVarbitValue(VarbitID.ARDOUGNE_DIARY_MEDIUM_COMPLETE) == 1
			&& (client.getVarbitValue(VarbitID.ARDOUGNE_FREE_ESSENCE) == 0
			|| dailyReset))
		{
			sendChatMessage(ESSENCE_MESSAGE);
		}
	}

	private void checkRunes(boolean dailyReset)
	{
		if (client.getVarbitValue(VarbitID.WILDERNESS_DIARY_EASY_COMPLETE) == 1
			&& (client.getVarbitValue(VarbitID.LUNDAIL_LAST_CLAIMED) == 0
			|| dailyReset))
		{
			sendChatMessage(RUNES_MESSAGE);
		}
	}

	private void checkSand(boolean dailyReset)
	{
		if (client.getVarbitValue(VarbitID.IRONMAN) != 2 /* UIM */
			&& client.getVarbitValue(VarbitID.HANDSAND_QUEST) >= SAND_QUEST_COMPLETE
			&& (client.getVarbitValue(VarbitID.YANILLE_SAND_CLAIMED) == 0
			|| dailyReset))
		{
			sendChatMessage(SAND_MESSAGE);
		}
	}

	private void checkFlax(boolean dailyReset)
	{
		if (client.getVarbitValue(VarbitID.KANDARIN_DIARY_EASY_COMPLETE) == 1
			&& (client.getVarbitValue(VarbitID.SEERS_FREE_FLAX) == 0
			|| dailyReset))
		{
			sendChatMessage(FLAX_MESSAGE);
		}
	}

	private void checkArrows(boolean dailyReset)
	{
		if (client.getVarbitValue(VarbitID.WESTERN_DIARY_EASY_COMPLETE) == 1
			&& (client.getVarbitValue(VarbitID.WESTERN_RANTZ_ARROWS) == 0
			|| dailyReset))
		{
			sendChatMessage(ARROWS_MESSAGE);
		}
	}

	private void checkBonemeal(boolean dailyReset)
	{
		if (client.getVarbitValue(VarbitID.MORYTANIA_DIARY_MEDIUM_COMPLETE) == 1)
		{
			int collected = client.getVarbitValue(VarbitID.MORYTANIA_SLIME_CLAIMED);
			int max = BONEMEAL_PER_DIARY;
			if (client.getVarbitValue(VarbitID.MORYTANIA_DIARY_HARD_COMPLETE) == 1)
			{
				max += BONEMEAL_PER_DIARY;
				if (client.getVarbitValue(VarbitID.MORYTANIA_DIARY_ELITE_COMPLETE) == 1)
				{
					max += BONEMEAL_PER_DIARY;
				}
			}
			if (collected < max || dailyReset)
			{
				sendChatMessage(BONEMEAL_MESSAGE);
			}
		}
	}

	private void checkDynamite(boolean dailyReset)
	{
		if (client.getVarbitValue(VarbitID.KOUREND_DIARY_MEDIUM_COMPLETE) == 1
			&& (client.getVarbitValue(VarbitID.KOUREND_FREE_DYNAMITE) == 0
			|| dailyReset))
		{
			sendChatMessage(DYNAMITE_MESSAGE);
		}
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
