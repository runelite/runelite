/*
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
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

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.chat.ChatColor;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Daily Task Indicators",
	enabledByDefault = false
)
@Slf4j
public class DailyTasksPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private DailyTasksConfig config;

	@Inject
	private ChatMessageManager chatMessageManager;

	private boolean hasSentHerbMsg, hasSentStavesMsg, hasSentEssenceMsg, hasSentSandMsg, hasSentEctoMsg;
	private int prevHerbVarbVal, prevStavesVarbVal, prevEssVarbVal, prevSandVarbVal, prevEctoVarbVal;

	@Provides
	DailyTasksConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DailyTasksConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		hasSentHerbMsg = hasSentStavesMsg = hasSentEssenceMsg = hasSentSandMsg = hasSentEctoMsg = false;
		prevHerbVarbVal = prevStavesVarbVal = prevEssVarbVal = prevSandVarbVal = prevEctoVarbVal = 0;
		cacheColors();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("dailytaskindicators"))
		{
			if (event.getKey().equals("showHerbBoxes"))
			{
				hasSentHerbMsg = false;
			}
			else if (event.getKey().equals("showStaves"))
			{
				hasSentStavesMsg = false;
			}
			else if (event.getKey().equals("showEssence"))
			{
				hasSentEssenceMsg = false;
			}
			else if (event.getKey().equals("showSand"))
			{
				hasSentSandMsg = false;
			}
			else if (event.getKey().equals("showEcto"))
			{
				hasSentEctoMsg = false;
			}
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (client.isMember())
		{
			if (config.showHerbBoxes() && !hasSentHerbMsg && checkCanCollectHerbBox())
			{
				sendChatMessage("You have herb boxes waiting to be collected at NMZ.");
				hasSentHerbMsg = true;
			}

			if (config.showStaves() && !hasSentStavesMsg && checkCanCollectStaves())
			{
				sendChatMessage("You have staves waiting to be collected from Zaff.");
				hasSentStavesMsg = true;
			}

			if (config.showEssence() && !hasSentEssenceMsg && checkCanCollectEssence())
			{
				sendChatMessage("You have pure essence waiting to be collected from Wizard Cromperty.");
				hasSentEssenceMsg = true;
			}

			if (config.showSand() && !hasSentSandMsg && checkCanCollectSand())
			{
				sendChatMessage("You have buckets of sand waiting to be collected from Bert.");
				hasSentSandMsg = true;
			}

			if (config.showEcto() && !hasSentEctoMsg && checkCanCollectEcto())
			{
				sendChatMessage("You have bonemeal and buckets of slime waiting to be collected from Robin.");
				hasSentEctoMsg = true;
			}
		}
	}

	private boolean checkCanCollectHerbBox()
	{
		int value = client.getVar(Varbits.DAILY_HERB_BOX);
		return prevHerbVarbVal == value ? (prevHerbVarbVal = value) < 15 : false;
	}

	private boolean checkCanCollectStaves()
	{
		if (didCompleteDiaries(Varbits.DIARY_VARROCK_EASY, Varbits.DIARY_VARROCK_MEDIUM, Varbits.DIARY_VARROCK_HARD, Varbits.DIARY_VARROCK_ELITE))
		{
			int value = client.getVar(Varbits.DAILY_STAVES);
			return prevStavesVarbVal == value ? (prevStavesVarbVal = value) == 0 : false;
		}
		return false;
	}

	private boolean checkCanCollectEssence()
	{
		if (didCompleteDiaries(Varbits.DIARY_ARDOUGNE_EASY, Varbits.DIARY_ARDOUGNE_MEDIUM, Varbits.DIARY_ARDOUGNE_HARD, Varbits.DIARY_ARDOUGNE_ELITE))
		{
			int value = client.getVar(Varbits.DAILY_ESSENCE);
			return prevEssVarbVal == value ? (prevEssVarbVal = value) == 0 : false;
		}
		return false;
	}

	private boolean checkCanCollectSand()
	{
		if (client.getVar(Varbits.QUEST_A_HAND_IN_THE_SAND) == 160 && !didCompleteDiaries(Varbits.DIARY_ARDOUGNE_ELITE))
		{
			int value = client.getVar(Varbits.DAILY_SAND);
			return prevSandVarbVal == value ? (prevSandVarbVal = value) == 0 : false;
		}
		return false;
	}

	private boolean checkCanCollectEcto()
	{
		if (didCompleteDiaries(Varbits.DIARY_MORYTANIA_EASY, Varbits.DIARY_MORYTANIA_MEDIUM, Varbits.DIARY_MORYTANIA_HARD, Varbits.DIARY_MORYTANIA_ELITE))
		{
			int value = client.getVar(Varbits.DAILY_ECTO);
			if (prevEctoVarbVal == value ? (prevEctoVarbVal = value) == 0 : false)
			{
				if ((client.getVar(Varbits.DIARY_MORYTANIA_ELITE) == 1 && value < 39)
					|| (client.getVar(Varbits.DIARY_MORYTANIA_HARD) == 1 && value < 26)
					|| (client.getVar(Varbits.DIARY_MORYTANIA_MEDIUM) == 1 && value < 13))
				{
					return true;
				}
			}
		}

		return false;
	}

	private boolean didCompleteDiaries(Varbits... dairyVarbits)
	{
		boolean completedDiaries = false;
		for (Varbits varbit : dairyVarbits)
		{
			if (client.getVar(varbit) == 1)
			{
				completedDiaries = true;
				break;
			}
		}
		return completedDiaries;
	}

	private void cacheColors()
	{
		chatMessageManager.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, Color.RED, false), ChatMessageType.GAME).refreshAll();
	}

	private void sendChatMessage(String chatMessage)
	{
		final String message = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append(chatMessage)
			.build();

		chatMessageManager.queue(
			QueuedMessage.builder()
				.type(ChatMessageType.GAME)
				.runeLiteFormattedMessage(message)
				.build());
	}
}