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
import java.awt.image.BufferedImage;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.discord.DiscordService;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.TitleToolbar;
import net.runelite.client.util.LinkBrowser;

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

	@Inject
	private TitleToolbar titleToolbar;

	@Inject
	private RuneLiteProperties properties;

	private final DiscordState discordState = new DiscordState();
	private Map<Skill, Integer> skillExp = new HashMap<>();
	private boolean loggedIn = false;
	private NavigationButton discordButton;

	@Provides
	private DiscordConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DiscordConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(getClass().getResourceAsStream("discord.png"));
		}

		discordButton = NavigationButton.builder()
			.tooltip("Join Discord")
			.icon(icon)
			.onClick(() -> LinkBrowser.browse(properties.getDiscordInvite()))
			.build();

		titleToolbar.addNavigation(discordButton);
		updateGameStatus(client.getGameState(), true);
	}

	@Override
	protected void shutDown() throws Exception
	{
		titleToolbar.removeNavigation(discordButton);
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
			discordState.triggerEvent(discordGameEventType, config.actionDelay());
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
			discordState.triggerEvent(DiscordGameEventType.IN_MENU, config.actionDelay());
		}
		else if (client.getGameState() == GameState.LOGGED_IN && (force || !loggedIn))
		{
			loggedIn = true;
			discordState.triggerEvent(DiscordGameEventType.IN_GAME, config.actionDelay());
		}
	}
}
