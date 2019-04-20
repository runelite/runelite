/*
 * Copyright (c) 2018, Steffen Hauge <steffen.oerum.hauge@hotmail.com>
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
package net.runelite.client.plugins.pyramidplunder;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import static net.runelite.api.ItemID.PHARAOHS_SCEPTRE;
import net.runelite.api.Player;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WallObjectChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "PyramidPlunder",
	description = "Highlights doors and spear traps in pyramid plunder and adds a numerical timer",
	tags = {"pyramidplunder", "pyramid", "plunder", "overlay", "skilling", "thieving"},
	enabledByDefault = false
)

public class PyramidPlunderPlugin extends Plugin
{
	private static final int PYRAMIND_PLUNDER_REGION_ID = 7749;
	private static final int PYRAMIND_PLUNDER_TIMER_MAX = 500;
	private static final double GAMETICK_SECOND = 0.6;

	@Getter
	private final Map<TileObject, Tile> obstacles = new HashMap<>();

	@Inject
	private Client client;

	@Inject
	private PyramidPlunderConfig config;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PyramidPlunderOverlay pyramidPlunderOverlay;

	@Getter
	private boolean isInGame;

	private int pyramidTimer = 0;

	@Provides
	PyramidPlunderConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PyramidPlunderConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(pyramidPlunderOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(pyramidPlunderOverlay);
		obstacles.clear();
		reset();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!config.showTimer())
		{
			removeTimer();
		}

		if (config.showTimer() && isInGame)
		{
			int remainingTime = PYRAMIND_PLUNDER_TIMER_MAX - pyramidTimer;

			if (remainingTime >= 2)
			{
				double timeInSeconds = remainingTime * GAMETICK_SECOND;
				showTimer((int)timeInSeconds, ChronoUnit.SECONDS);
			}
		}
	}

	private void removeTimer()
	{
		infoBoxManager.removeIf(infoBox -> infoBox instanceof PyramidPlunderTimer);
	}

	private void showTimer()
	{
		showTimer(5, ChronoUnit.MINUTES);
	}

	private void showTimer(int period, ChronoUnit chronoUnit)
	{
		removeTimer();
		infoBoxManager.addInfoBox(new PyramidPlunderTimer(this, itemManager.getImage(PHARAOHS_SCEPTRE), period, chronoUnit));
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case LOGIN_SCREEN:
				reset();
				break;
			case LOADING:
				obstacles.clear();
			case LOGGED_IN:
				if (!isInRegion())
				{
					reset();
				}
				break;
		}
	}

	private boolean isInRegion()
	{
		Player local = client.getLocalPlayer();
		if (local == null)
		{
			return false;
		}

		WorldPoint location = local.getWorldLocation();
		if (location.getRegionID() != PYRAMIND_PLUNDER_REGION_ID)
		{
			return false;
		}

		return true;
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		int lastValue = pyramidTimer;
		pyramidTimer = client.getVar(Varbits.PYRAMID_PLUNDER_TIMER);

		if (lastValue == pyramidTimer)
		{
			return;
		}

		if (pyramidTimer == 0)
		{
			reset();
		}
		if (pyramidTimer == 1)
		{
			isInGame = true;
			if (config.showTimer())
			{
				showTimer();
			}
		}
	}

	private void reset()
	{
		isInGame = false;
		removeTimer();
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getGameObject());
	}

	@Subscribe
	public void onGameObjectChanged(GameObjectChanged event)
	{
		onTileObject(event.getTile(), event.getPrevious(), event.getGameObject());
	}

	@Subscribe
	public void onGameObjectDeSpawned(GameObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getGameObject(), null);
	}

	@Subscribe
	public void onWallObjectSpawned(WallObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getWallObject());
	}

	@Subscribe
	public void onWallObjectChanged(WallObjectChanged event)
	{
		onTileObject(event.getTile(), event.getPrevious(), event.getWallObject());
	}

	@Subscribe
	public void onWallObjectDeSpawned(WallObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getWallObject(), null);
	}

	private void onTileObject(Tile tile, TileObject oldObject, TileObject newObject)
	{
		obstacles.remove(oldObject);

		if (newObject == null)
		{
			return;
		}

		if (Obstacles.WALL_OBSTACLE_IDS.contains(newObject.getId()) ||
			Obstacles.TRAP_OBSTACLE_IDS.contains(newObject.getId()))
		{
			obstacles.put(newObject, tile);
		}
	}
}
