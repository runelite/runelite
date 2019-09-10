/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * Copyright (c) 2019, ThatGamerBlue <thatgamerblue@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.entityhider;

import com.google.inject.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.util.Text;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@PluginDescriptor(
	name = "Entity Hider",
	description = "Hide players, NPCs, and/or projectiles",
	tags = {"npcs", "players", "projectiles"},
	enabledByDefault = false
)
@Singleton
public class EntityHiderPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private EntityHiderConfig config;

	@Inject
	private EventBus eventBus;

	@Provides
	EntityHiderConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(EntityHiderConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		addSubscriptions();

		Text.fromCSV(config.hideNPCsNames()).forEach(client::addHiddenNpcName);
		Text.fromCSV(config.hideNPCsOnDeath()).forEach(client::addHiddenNpcDeath);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
	}

	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("entityhider"))
		{
			updateConfig();

			if (event.getKey().equals("hideNPCsNames"))
			{
				List<String> oldList = Text.fromCSV(event.getOldValue());
				List<String> newList = Text.fromCSV(event.getNewValue());

				ArrayList<String> removed = oldList.stream().filter(s -> !newList.contains(s)).collect(Collectors.toCollection(ArrayList::new));
				ArrayList<String> added = newList.stream().filter(s -> !oldList.contains(s)).collect(Collectors.toCollection(ArrayList::new));

				removed.forEach(client::removeHiddenNpcName);
				added.forEach(client::addHiddenNpcName);
			}

			if (event.getKey().equals("hideNPCsOnDeath"))
			{
				List<String> oldList = Text.fromCSV(event.getOldValue());
				List<String> newList = Text.fromCSV(event.getNewValue());

				ArrayList<String> removed = oldList.stream().filter(s -> !newList.contains(s)).collect(Collectors.toCollection(ArrayList::new));
				ArrayList<String> added = newList.stream().filter(s -> !oldList.contains(s)).collect(Collectors.toCollection(ArrayList::new));

				removed.forEach(client::removeHiddenNpcDeath);
				added.forEach(client::addHiddenNpcDeath);
			}
		}
	}

	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			client.setIsHidingEntities(isPlayerRegionAllowed());
		}
	}

	private void updateConfig()
	{
		client.setIsHidingEntities(isPlayerRegionAllowed());

		client.setPlayersHidden(config.hidePlayers());
		client.setPlayersHidden2D(config.hidePlayers2D());
		client.setHideSpecificPlayers(Text.fromCSV(config.hideSpecificPlayers()));

		client.setFriendsHidden(config.hideFriends());
		client.setClanMatesHidden(config.hideClanMates());

		client.setLocalPlayerHidden(config.hideLocalPlayer());
		client.setLocalPlayerHidden2D(config.hideLocalPlayer2D());

		client.setNPCsHidden(config.hideNPCs());
		client.setNPCsHidden2D(config.hideNPCs2D());
		//client.setNPCsNames(Text.fromCSV(config.hideNPCsNames()));
		//client.setNPCsHiddenOnDeath(Text.fromCSV(config.hideNPCsOnDeath()));

		client.setAttackersHidden(config.hideAttackers());

		client.setProjectilesHidden(config.hideProjectiles());

		client.setDeadNPCsHidden(config.hideDeadNPCs());
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		client.setIsHidingEntities(false);

		client.setPlayersHidden(false);
		client.setPlayersHidden2D(false);

		client.setFriendsHidden(false);
		client.setClanMatesHidden(false);

		client.setLocalPlayerHidden(false);
		client.setLocalPlayerHidden2D(false);

		client.setNPCsHidden(false);
		client.setNPCsHidden2D(false);

		client.setAttackersHidden(false);

		client.setProjectilesHidden(false);

		client.setDeadNPCsHidden(false);

		Text.fromCSV(config.hideNPCsNames()).forEach(client::removeHiddenNpcName);
		Text.fromCSV(config.hideNPCsOnDeath()).forEach(client::removeHiddenNpcDeath);
	}

	private boolean isPlayerRegionAllowed()
	{
		final Player localPlayer = client.getLocalPlayer();

		if (localPlayer == null)
		{
			return true;
		}

		final int playerRegionID = WorldPoint.fromLocalInstance(client, localPlayer.getLocalLocation()).getRegionID();

		// 9520 = Castle Wars
		return playerRegionID != 9520;
	}
}
