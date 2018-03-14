/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.discord;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.discord.DiscordService;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.util.StackFormatter;

@PluginDescriptor(
	name = "Discord"
)
public class DiscordPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private DiscordConfig config;

	@Inject
	private DiscordService discordService;

	private final DiscordState discordState = new DiscordState();
	private Map<Skill, Integer> skillExp = new HashMap<>();
	private boolean loggedIn = false;

	private boolean raidInProgress = false;
	private boolean inRaidChambers = false;

	@Provides
	private DiscordConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DiscordConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateGameStatus(client.getGameState(), true);
	}

	@Override
	protected void shutDown() throws Exception
	{
		discordService.clearPresence();
		discordState.reset();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		updateGameStatus(event.getGameState(), false);
	}

	@Subscribe
	public void onXpChanged(ExperienceChanged event)
	{
		final int exp = client.getSkillExperience(event.getSkill());
		final Integer previous = skillExp.put(event.getSkill(), exp);

		if (previous == null || previous >= exp)
		{
			return;
		}

		final DiscordGameEventType discordGameEventType = DiscordGameEventType.fromSkill(event.getSkill());

		if (discordGameEventType != null)
		{
			int level = client.getRealSkillLevel(event.getSkill());
			int xpToLevel = Experience.getXpForLevel(level + 1) - client.getSkillExperience(event.getSkill());

			triggerEvent(discordGameEventType, config.actionDelay(), "Level: " + level + " (" + StackFormatter.quantityToStackSize(xpToLevel) + " till " + (level + 1) + ")");
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		// Raid
		if (inRaidChambers && event.getType() == ChatMessageType.CLANCHAT_INFO)
		{
			String message = event.getMessage().replaceAll("<[^>]*>", "");

			if (message.startsWith("The raid has begun!"))
			{
				raidInProgress = true;
			}
		}
	}

	@Subscribe
	public void onVarbitChange(VarbitChanged event)
	{
		// Raid
		boolean setting = client.getSetting(Varbits.IN_RAID) == 1;

		if (inRaidChambers != setting)
		{
			inRaidChambers = setting;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		// Raid
		if (raidInProgress)
		{
			checkIfInRaid();
		}
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.MINUTES
	)
	public void checkForValidStatus()
	{
		if (discordState.checkForTimeout(config.actionTimeout()))
		{
			updateGameStatus(client.getGameState(), true);
		}
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
	public void flushDiscordStatus()
	{
		discordState.flushEvent(discordService);
	}

	private void updateGameStatus(GameState gameState, boolean force)
	{
		if (gameState == GameState.LOGIN_SCREEN)
		{
			skillExp.clear();
			loggedIn = false;
			triggerEvent(DiscordGameEventType.IN_MENU, config.actionDelay());
		}
		else if (client.getGameState() == GameState.LOGGED_IN && (force || !loggedIn))
		{
			loggedIn = true;
			triggerEvent(DiscordGameEventType.IN_GAME, config.actionDelay());
		}
	}

	private void triggerEvent(DiscordGameEventType type, int delay)
	{
		triggerEvent(type, delay, "");
	}

	private void triggerEvent(DiscordGameEventType type, int delay, String state)
	{
		discordState.triggerEvent(type, delay, state);
	}

	private void checkIfInRaid()
	{
		if (inRaidChambers)
		{
			// Raid has started, triggering raid event
			int totalPoints = client.getSetting(Varbits.TOTAL_POINTS);
			int personalPoints = client.getSetting(Varbits.PERSONAL_POINTS);

			triggerEvent(DiscordGameEventType.RAID, config.actionDelay(), "Points: " + totalPoints + " (" + personalPoints + ")");
		}
		else
		{
			// No longer in raid
			raidInProgress = false;
			updateGameStatus(client.getGameState(), true);
		}
	}
}
