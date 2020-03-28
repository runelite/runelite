/*
 * Copyright (c) 2020, Travis Earley <travis.earley96@gmail.com>
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
package net.runelite.client.plugins.naturerunechest;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.time.Instant;
import java.util.Set;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
		name = "Nature Rune Chest",
		description = "Show when nature rune chest is ready to be looted again",
		tags = {"overlay", "skilling", "timers"},
		enabledByDefault = false
)

public class NatureRuneChestPlugin extends Plugin
{
	private static final Set<Integer> NRC_REGIONS = ImmutableSet.of(10547, 10291, 10553, 12093);

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private NatureRuneChestOverlay overlay;

	@Inject
	private NatureRuneChestConfig config;

	@Getter(AccessLevel.PACKAGE)
	private GameObject chest;

	@Getter(AccessLevel.PACKAGE)
	private Instant start;

	@Getter(AccessLevel.PACKAGE)
	private int state;

	@Provides
	NatureRuneChestConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(NatureRuneChestConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		overlay.updateConfig();
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGIN_SCREEN:
			case HOPPING:
			case LOADING:
				chest = null;
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		GameObject object = event.getGameObject();

		// Chest has been looted and is waiting to restock
		if (object.getId() == 11740)
		{
			if (NRC_REGIONS.contains(client.getLocalPlayer().getWorldLocation().getRegionID()))
			{
				chest = object;
				state = 2;
				start = Instant.now();
			}
		}

		//chest is being opened
		if (object.getId() == 11743)
		{
			if (NRC_REGIONS.contains(client.getLocalPlayer().getWorldLocation().getRegionID()))
			{
				chest = object;
				state = 1;
			}
		}

		//chest is ready to steal from
		if (object.getId() == 11736)
		{
			if (NRC_REGIONS.contains(client.getLocalPlayer().getWorldLocation().getRegionID()))
			{
				chest = object;
				state = 0;
			}
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("naturerunechestplugin"))
		{
			overlay.updateConfig();
		}
	}
}
