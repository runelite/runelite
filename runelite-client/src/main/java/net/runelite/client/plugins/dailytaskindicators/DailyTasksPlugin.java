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

	private boolean hasSentHerbMsg, hasSentStavesMsg, hasSentEssenceMsg, hasSentSandMsg, hasSentEctoMsg, hasSentBowstringMsg, hasSentRunesMsg;
	private int prevHerbVarbVal, prevStavesVarbVal, prevEssVarbVal, prevSandVarbVal, prevEctoVarbVal, prevBowstringVarbVal, prevRunesVarbVal;

	@Provides
	DailyTasksConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DailyTasksConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		hasSentHerbMsg = hasSentStavesMsg = hasSentEssenceMsg = hasSentSandMsg = hasSentEctoMsg = hasSentBowstringMsg = hasSentRunesMsg = false;
		prevHerbVarbVal = prevStavesVarbVal = prevEssVarbVal = prevSandVarbVal = prevEctoVarbVal = prevBowstringVarbVal = prevRunesVarbVal = 0;
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
			resetSentMessages();
			sendNotification();
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		resetSentMessages();
		sendNotification();
	}

	private void sendNotification()
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
				sendChatMessage("You can exchange bones for bonemeal and buckets of slime from Robin.");
				hasSentEctoMsg = true;
			}

			if (config.showBowstring() && !hasSentBowstringMsg && checkCanExchangeFlax())
			{
				sendChatMessage("You can exchange flax for bowstring from the Flax keeper.");
				hasSentBowstringMsg = true;
			}

			if (config.showRunes() && !hasSentRunesMsg && checkCanCollectRunes())
			{
				sendChatMessage("You have runes waiting to be collected from Lundail.");
				hasSentRunesMsg = true;
			}
		}
	}

	/**
	 * when Varbits.DAILY_HERB_BOX is 15, there is no
	 * more herb boxes available to be collected
	 *
	 * @return can collect herb box
	 */
	private boolean checkCanCollectHerbBox()
	{
		int value = client.getVar(Varbits.DAILY_HERB_BOX);
		return prevHerbVarbVal == value ? (prevHerbVarbVal = value) < 15 : false;
	}

	/**
	 * Varbits.DAILY_STAVES turns to 1
	 * when staves are collected
	 *
	 * @return can collect battlestaves
	 */
	private boolean checkCanCollectStaves()
	{
		if (didCompleteDiaries(Varbits.DIARY_VARROCK_EASY, Varbits.DIARY_VARROCK_MEDIUM, Varbits.DIARY_VARROCK_HARD, Varbits.DIARY_VARROCK_ELITE))
		{
			int value = client.getVar(Varbits.DAILY_STAVES);
			return prevStavesVarbVal == value ? (prevStavesVarbVal = value) == 0 : false;
		}
		return false;
	}

	/**
	 * Varbits.DAILY_ESSENCE turns to 1
	 * when pure essence are collected
	 *
	 * @return can collect pure essence
	 */
	private boolean checkCanCollectEssence()
	{
		if (didCompleteDiaries(Varbits.DIARY_ARDOUGNE_EASY, Varbits.DIARY_ARDOUGNE_MEDIUM, Varbits.DIARY_ARDOUGNE_HARD, Varbits.DIARY_ARDOUGNE_ELITE))
		{
			int value = client.getVar(Varbits.DAILY_ESSENCE);
			return prevEssVarbVal == value ? (prevEssVarbVal = value) == 0 : false;
		}
		return false;
	}

	/**
	 * Varbits.DAILY_SAND turns to 1
	 * when buckets of sand are collected
	 *
	 * @return can collect buckets of sand
	 */
	private boolean checkCanCollectSand()
	{
		if (client.getVar(Varbits.QUEST_A_HAND_IN_THE_SAND) == 160 && !didCompleteDiaries(Varbits.DIARY_ARDOUGNE_ELITE))
		{
			int value = client.getVar(Varbits.DAILY_SAND);
			return prevSandVarbVal == value ? (prevSandVarbVal = value) == 0 : false;
		}
		return false;
	}

	/**
	 * Varbits.DAILY_ECTO is incremented for every exchange, until
	 * the maximum exchanges amount is reached.
	 * The amount available to be exchanged depends on the player's
	 * diary progression, so the value of Varbits.DAILY_ECTO
	 * has to be checked in accordance to diary progress.
	 *
	 * @return can exchange bones for bonemeal and buckets of slime
	 */
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

	/**
	 * Varbits.DAILY_BOWSTRING turns to 1
	 * when flax is exchanged for bowstring
	 *
	 * @return can exchange noted flax for noted bowstring
	 */
	private boolean checkCanExchangeFlax()
	{
		if (didCompleteDiaries(Varbits.DIARY_KANDARIN_EASY, Varbits.DIARY_KANDARIN_MEDIUM, Varbits.DIARY_KANDARIN_HARD, Varbits.DIARY_KANDARIN_ELITE))
		{
			int value = client.getVar(Varbits.DAILY_BOWSTRING);
			return prevBowstringVarbVal == value ? (prevBowstringVarbVal = value) == 0 : false;
		}
		return false;
	}

	/**
	 * Varbits.DAILY_RUNES turns to 1
	 * when the runes are collected
	 *
	 * @return can collect runes
	 */
	private boolean checkCanCollectRunes()
	{
		if (didCompleteDiaries(Varbits.DIARY_WILDERNESS_EASY, Varbits.DIARY_WILDERNESS_MEDIUM, Varbits.DIARY_WILDERNESS_HARD, Varbits.DIARY_WILDERNESS_ELITE))
		{
			int value = client.getVar(Varbits.DAILY_RUNES);
			return prevRunesVarbVal == value ? (prevRunesVarbVal = value) == 0 : false;
		}
		return false;
	}

	private void resetSentMessages()
	{
		hasSentHerbMsg = client.getVar(Varbits.DAILY_HERB_BOX) != prevHerbVarbVal ? false : hasSentHerbMsg;
		hasSentStavesMsg = client.getVar(Varbits.DAILY_STAVES) != prevStavesVarbVal ? false : hasSentStavesMsg;
		hasSentEssenceMsg = client.getVar(Varbits.DAILY_ESSENCE) != prevEssVarbVal ? false : hasSentEssenceMsg;
		hasSentSandMsg = client.getVar(Varbits.DAILY_SAND) != prevSandVarbVal ? false : hasSentSandMsg;
		hasSentEctoMsg = client.getVar(Varbits.DAILY_ECTO) != prevEctoVarbVal ? false : hasSentEctoMsg;
		hasSentBowstringMsg = client.getVar(Varbits.DAILY_BOWSTRING) != prevBowstringVarbVal ? false : hasSentBowstringMsg;
		hasSentRunesMsg = client.getVar(Varbits.DAILY_RUNES) != prevRunesVarbVal ? false : hasSentRunesMsg;
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