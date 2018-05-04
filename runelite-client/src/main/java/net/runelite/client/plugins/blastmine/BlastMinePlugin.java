/*
 * Copyright (c) 2018, Unmoon <https://github.com/Unmoon>
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
package net.runelite.client.plugins.blastmine;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@PluginDescriptor(
	name = "Blast Mine"
)
public class BlastMinePlugin extends Plugin
{
	@Inject
	private BlastMineRockOverlay blastMineRockOverlay;

	@Inject
	private BlastMineOreCountOverlay blastMineOreCountOverlay;

	@Inject
	private BlastMineOreDetailsOverlay blastMineOreDetailsOverlay;

	@Getter
	private final Set<BlastMineRock> rocks = new HashSet<>();



	@Provides
	BlastMinePluginConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BlastMinePluginConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		blastMineRockOverlay.updateColors();
		blastMineOreDetailsOverlay.setBounds(blastMineOreCountOverlay.getBounds());
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(blastMineRockOverlay, blastMineOreCountOverlay, blastMineOreDetailsOverlay);
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject gameObject = event.getGameObject();

		BlastMineRock newRock = new BlastMineRock(gameObject);
		BlastMineRock oldRock = getRockFromCollection(gameObject);

		if (newRock.getType() == null)
		{
			return;
		}
		else if (oldRock == null)
		{
			log.debug("Added rock, {}", newRock.getType());
			rocks.add(newRock);
		}
		else if (oldRock.getType() != newRock.getType())
		{
			log.debug("Updated rock, {} -> {}", oldRock.getType(), newRock.getType());
			rocks.remove(oldRock);
			rocks.add(newRock);
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			rocks.clear();
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("blastmineplugin"))
		{
			blastMineRockOverlay.updateColors();
		}
	}

	private BlastMineRock getRockFromCollection(GameObject gameObject)
	{
		WorldPoint gameObjectLocation = gameObject.getWorldLocation();
		for (BlastMineRock rock : rocks)
		{
			if (gameObjectLocation.equals(rock.getGameObject().getWorldLocation()))
			{
				return rock;
			}
		}
		return null;
	}
}
