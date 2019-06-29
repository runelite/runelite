/*
 * Copyright (c) 2018, Steffen Hauge <steffen.oerum.hauge@hotmail.com>
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
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

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import static net.runelite.api.Constants.GAME_TICK_LENGTH;
import static net.runelite.api.ItemID.PHARAOHS_SCEPTRE;
import static net.runelite.api.ObjectID.GRAND_GOLD_CHEST;
import static net.runelite.api.ObjectID.OPENED_GOLD_CHEST;
import static net.runelite.api.ObjectID.SARCOPHAGUS_21255;
import static net.runelite.api.ObjectID.SARCOPHAGUS_21256;
import static net.runelite.api.ObjectID.SPEARTRAP_21280;
import static net.runelite.api.ObjectID.TOMB_DOOR_20948;
import static net.runelite.api.ObjectID.TOMB_DOOR_20949;
import static net.runelite.api.ObjectID.URN_21261;
import static net.runelite.api.ObjectID.URN_21262;
import static net.runelite.api.ObjectID.URN_21263;
import static net.runelite.api.ObjectID.URN_21265;
import static net.runelite.api.ObjectID.URN_21266;
import static net.runelite.api.ObjectID.URN_21267;
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
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "PyramidPlunder",
	description = "Highlights doors and spear traps in pyramid plunder and adds a numerical timer",
	tags = {"pyramidplunder", "pyramid", "plunder", "overlay", "skilling", "thieving"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)

public class PyramidPlunderPlugin extends Plugin
{
	private static final int PYRAMID_PLUNDER_REGION_ID = 7749;
	private static final int PYRAMID_PLUNDER_TIMER_MAX = 500;
	static final int TRAP = SPEARTRAP_21280;
	static final int CLOSED_DOOR = TOMB_DOOR_20948;
	static final int OPENED_DOOR = TOMB_DOOR_20949;

	// Next 2 are in here for anyone who wants to spend more time on this
	private static final Set<Integer> LOOTABLE = ImmutableSet.of(
		GRAND_GOLD_CHEST,
		SARCOPHAGUS_21255,
		URN_21261,
		URN_21262,
		URN_21263
	);
	private static final Set<Integer> LOOTED = ImmutableSet.of(
		OPENED_GOLD_CHEST,
		SARCOPHAGUS_21256,
		URN_21265,
		URN_21266,
		URN_21267
	);
	private static final Set<Integer> DOOR_WALL_IDS = ImmutableSet.of(
		26618, 26619, 26620, 26621
	);

	@Getter
	private final Map<TileObject, Tile> highlighted = new HashMap<>();

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

	private int pyramidTimer;

	@Provides
	PyramidPlunderConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PyramidPlunderConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(pyramidPlunderOverlay);
		highlighted.clear();
		reset();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!"pyramidplunder".equals(event.getGroup()))
		{
			return;
		}

		if (!config.showTimer())
		{
			removeTimer();
		}

		if (config.showTimer() && isInGame)
		{
			int remainingTime = GAME_TICK_LENGTH * (PYRAMID_PLUNDER_TIMER_MAX - pyramidTimer);

			if (remainingTime >= 2)
			{
				showTimer(remainingTime, ChronoUnit.MILLIS);
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

		infoBoxManager.addInfoBox(
			new PyramidPlunderTimer(
				this,
				itemManager.getImage(PHARAOHS_SCEPTRE),
				period,
				chronoUnit
			)
		);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case LOGIN_SCREEN:
				reset();
				break;
			case LOADING:
				highlighted.clear();
				break;
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
		return location.getRegionID() == PYRAMID_PLUNDER_REGION_ID;

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
			return;
		}

		if (pyramidTimer == 1)
		{
			overlayManager.add(pyramidPlunderOverlay);
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
		overlayManager.remove(pyramidPlunderOverlay);
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
	public void onGameObjectDespawned(GameObjectDespawned event)
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
	public void onWallObjectDespawned(WallObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getWallObject(), null);
	}

	private void onTileObject(Tile tile, TileObject oldObject, TileObject newObject)
	{
		highlighted.remove(oldObject);

		if (newObject == null)
		{
			return;
		}

		int id = newObject.getId();
		if (id == TRAP && config.highlightSpearTrap() ||
			(DOOR_WALL_IDS.contains(id) || id == OPENED_DOOR || id == CLOSED_DOOR) && config.highlightDoors())
		{
			highlighted.put(newObject, tile);
		}
	}
}
