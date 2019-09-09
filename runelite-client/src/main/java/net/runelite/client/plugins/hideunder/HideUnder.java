/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.hideunder;

import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;

@PluginDescriptor(
	name = "Hide Under",
	description = "Hide local player when under targeted players",
	tags = {"hide", "local", "player", "under"},
	type = PluginType.PVP,
	enabledByDefault = false
)
@Slf4j
public class HideUnder extends Plugin
{
	@Inject
	private Client client;
	@Inject
	private EventBus eventBus;
	private Set<PlayerContainer> playerContainer = new HashSet<>();

	@Override
	protected void startUp()
	{
		addSubscriptions();
		playerContainer.clear();
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(PlayerSpawned.class, this, this::onPlayerSpawned);
		eventBus.subscribe(PlayerDespawned.class, this, this::onPlayerDespawned);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(InteractingChanged.class, this, this::onInteractingChanged);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			client.setIsHidingEntities(isPlayerRegionAllowed());
		}
	}

	private void onInteractingChanged(InteractingChanged event)
	{
		if ((event.getSource() instanceof Player) && (event.getTarget() instanceof Player))
		{
			final Player source = (Player) event.getSource();
			final Player target = (Player) event.getTarget();

			if (source == client.getLocalPlayer())
			{
				for (PlayerContainer player : playerContainer)
				{
					if (player.getPlayer() == target)
					{
						player.setTimer(16);
						player.setTarget(true);
					}
				}
			}
			else if (target == client.getLocalPlayer())
			{
				for (PlayerContainer player : playerContainer)
				{
					if (player.getPlayer() == source)
					{
						player.setTimer(16);
						player.setTarget(true);
					}
				}
			}
		}
	}

	private void onAnimationChanged(AnimationChanged event)
	{
		final Actor actor = event.getActor();

		if (actor.getInteracting() != client.getLocalPlayer() || !(actor instanceof Player))
		{
			return;
		}

		if (actor.getAnimation() != -1 && actor.getInteracting() != null && actor.getInteracting() == client.getLocalPlayer())
		{
			for (PlayerContainer player : playerContainer)
			{
				if (player.getPlayer() == actor)
				{
					player.setTimer(16);
					player.setTarget(true);
				}
			}
		}
	}

	private void onPlayerSpawned(PlayerSpawned event)
	{
		final Player player = event.getPlayer();

		if (player == client.getLocalPlayer())
		{
			return;
		}

		playerContainer.add(new PlayerContainer(player));
	}

	private void onPlayerDespawned(PlayerDespawned event)
	{
		final Player player = event.getPlayer();
		playerContainer.removeIf(playa -> playa.getPlayer() == player);
	}

	private void onGameTick(GameTick event)
	{
		if (playerContainer.isEmpty() || client.getLocalPlayer() == null)
		{
			return;
		}

		final WorldPoint lp = client.getLocalPlayer().getWorldLocation();
		final WorldPoint localPlayerWp = WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation());

		client.setLocalPlayerHidden(false);

		for (PlayerContainer player : playerContainer)
		{
			if (player.getTimer() > 0)
			{
				player.setTimer(player.getTimer() - 1);
			}
			else
			{
				player.setTarget(false);
			}

			if (!player.isTarget())
			{
				continue;
			}

			if (client.getVar(Varbits.LMS_IN_GAME) == 1)
			{
				final WorldPoint playerWp = WorldPoint.fromLocalInstance(client, player.getPlayer().getLocalLocation());
				if (localPlayerWp.distanceTo(playerWp) == 0)
				{
					client.setLocalPlayerHidden(true);
				}
				continue;
			}

			if (player.getPlayer().getWorldLocation().distanceTo(lp) == 0)
			{
				client.setLocalPlayerHidden(true);
			}
		}
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