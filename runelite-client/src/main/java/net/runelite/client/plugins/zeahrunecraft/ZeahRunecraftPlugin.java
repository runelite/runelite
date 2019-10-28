/*
 * Copyright (c) 2019, Pinibot <https://github.com/Pinibot>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.zeahrunecraft;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.google.inject.Provides;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Player;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
		name = "Zeah Runecraft",
		description = "Show overlays when Runecrafting in Zeah",
		tags = { "highlight", "overlay" },
		enabledByDefault = true)
public class ZeahRunecraftPlugin extends Plugin
{
	@Getter
	private final List<DenseRunestone> runestones = new ArrayList<>();

	@Getter
	private boolean mining = false;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ZeahRunecraftOverlay piniOverlay;

	@Provides
	ZeahRunecraftConfig getConfig(final ConfigManager configManager)
	{
		return configManager.getConfig(ZeahRunecraftConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(piniOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(piniOverlay);
		runestones.clear();
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case LOGIN_SCREEN:
			case LOADING:
				runestones.clear();
				break;
			default:
				break;
		}
	}

	@Subscribe
	public void onAnimationChanged(final AnimationChanged event)
	{
		Player local = client.getLocalPlayer();

		if (event.getActor() != local)
		{
			return;
		}

		int playerAnimationId = local.getAnimation();

		mining = MiningAnimations.isPlayerMining(playerAnimationId);
	}

	@Subscribe
	public void onGameObjectSpawned(final GameObjectSpawned event)
	{
		GameObject gameObject = event.getGameObject();
		int gameObjectId = gameObject.getId();

		// Check to see if the GameObject is a Dense Runestone
		Optional<DenseRunestoneInfo> optionalDenseRunestoneInfo = DenseRunestoneInfo
				.findDenseRunestoneInfo(gameObjectId);
		if (optionalDenseRunestoneInfo.isPresent())
		{
			// Check to see if we've already handled this Dense Runestone
			Optional<DenseRunestone> optionalRunestone = runestones
					.stream()
					.filter(r -> r.getGameObject().getId() == gameObjectId)
					.findFirst();
			if (!optionalRunestone.isPresent())
			{
				// Add the newly spawned Dense Runestone to the list
				DenseRunestoneInfo denseRunestoneInfo = optionalDenseRunestoneInfo.get();
				DenseRunestone denseRunestone = new DenseRunestone(false, gameObject,
						denseRunestoneInfo.getDepletionVarbit());
				runestones.add(denseRunestone);
			}
		}
	}

	@Subscribe
	public void onGameObjectDespawned(final GameObjectDespawned event)
	{
		GameObject despawnedGameObject = event.getGameObject();
		int despawnedGameObjectId = despawnedGameObject.getId();

		// Check to see if the GameObject is a Dense Runestone
		Optional<DenseRunestoneInfo> optionalDenseRunestoneInfo = DenseRunestoneInfo
				.findDenseRunestoneInfo(despawnedGameObjectId);
		if (optionalDenseRunestoneInfo.isPresent())
		{
			runestones.removeIf(r -> r.getGameObject().getId() == despawnedGameObjectId);
		}
	}

	@Subscribe
	public void onVarbitChanged(final VarbitChanged event)
	{
		runestones.forEach(r -> r.setDepleted(client.getVar(r.getDepletionVarbit()) == 1));
	}

}
