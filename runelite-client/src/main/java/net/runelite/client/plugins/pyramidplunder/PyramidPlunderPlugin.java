/*
 * Copyright (c) 2020 Mitchell <https://github.com/Mitchell-Kovacs>
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
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import static net.runelite.api.ItemID.PHARAOHS_SCEPTRE;
import static net.runelite.api.NullObjectID.*;
import static net.runelite.api.ObjectID.GRAND_GOLD_CHEST;
import static net.runelite.api.ObjectID.SARCOPHAGUS_21255;
import static net.runelite.api.ObjectID.SPEARTRAP_21280;
import static net.runelite.api.ObjectID.TOMB_DOOR_20948;
import static net.runelite.api.ObjectID.URN_21261;
import static net.runelite.api.ObjectID.URN_21262;
import static net.runelite.api.ObjectID.URN_21263;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.Varbits;
import net.runelite.api.WallObject;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.RSTimeUnit;

@PluginDescriptor(
	name = "Pyramid Plunder",
	description = "Show custom overlay for Pyramid Plunder",
	tags = {"minigame", "thieving", "pp"},
	enabledByDefault = false
)
public class PyramidPlunderPlugin extends Plugin
{
	// Total time of a pyramid plunder game (5 minutes)
	private static final Duration PYRAMID_PLUNDER_DURATION = Duration.of(501, RSTimeUnit.GAME_TICKS);
	private static final int PYRAMID_PLUNDER_REGION = 7749;

	static final Set<Integer> TOMB_DOOR_WALL_IDS = ImmutableSet.of(NULL_26618, NULL_26619, NULL_26620, NULL_26621);
	static final int TOMB_DOOR_CLOSED_ID = TOMB_DOOR_20948;

	static final int SPEARTRAP_ID = SPEARTRAP_21280;

	static final Set<Integer> URN_IDS = ImmutableSet.of(NULL_26580, NULL_26600, NULL_26601, NULL_26602,
		NULL_26603, NULL_26604, NULL_26605, NULL_26606, NULL_26607, NULL_26608, NULL_26609, NULL_26610, NULL_26611,
		NULL_26612, NULL_26613);
	static final Set<Integer> URN_CLOSED_IDS = ImmutableSet.of(URN_21261, URN_21262, URN_21263);

	static final int GRAND_GOLD_CHEST_ID = NULL_26616;
	static final int GRAND_GOLD_CHEST_CLOSED_ID = GRAND_GOLD_CHEST;

	static final int SARCOPHAGUS_ID = NULL_26626;
	static final int SARCOPHAGUS_CLOSED_ID = SARCOPHAGUS_21255;

	@Inject
	private Client client;

	@Inject
	private PyramidPlunderConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PyramidPlunderOverlay overlay;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ClientThread clientThread;

	@Getter
	private final Map<TileObject, Tile> tilesToHighlight = new HashMap<>();

	@Getter
	private final List<GameObject> objectsToHighlight = new ArrayList<>();

	private PyramidPlunderTimer timer;

	@Provides
	PyramidPlunderConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PyramidPlunderConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		tilesToHighlight.clear();
		objectsToHighlight.clear();
		overlayManager.remove(overlay);
		timer = null;
		infoBoxManager.removeIf(PyramidPlunderTimer.class::isInstance);

		clientThread.invoke(() ->
		{
			Widget ppWidget = client.getWidget(WidgetInfo.PYRAMID_PLUNDER_DATA);
			if (ppWidget != null)
			{
				ppWidget.setHidden(false);
			}
		});
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			tilesToHighlight.clear();
			objectsToHighlight.clear();
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		if (isInPyramidPlunder())
		{
			if (timer == null)
			{
				int ppTimer = client.getVar(Varbits.PYRAMID_PLUNDER_TIMER);
				Duration remaining = PYRAMID_PLUNDER_DURATION.minus(ppTimer, RSTimeUnit.GAME_TICKS);
				timer = new PyramidPlunderTimer(remaining, itemManager.getImage(PHARAOHS_SCEPTRE), this,
					config, client);
				infoBoxManager.addInfoBox(timer);
			}
		}
		else if (timer != null)
		{
			infoBoxManager.removeInfoBox(timer);
			timer = null;
		}
	}

	@Subscribe
	public void onWallObjectSpawned(WallObjectSpawned event)
	{
		WallObject object = event.getWallObject();

		if (TOMB_DOOR_WALL_IDS.contains(object.getId()))
		{
			tilesToHighlight.put(object, event.getTile());
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject object = event.getGameObject();

		if (SPEARTRAP_ID == object.getId())
		{
			tilesToHighlight.put(object, event.getTile());
		}
		else if (URN_IDS.contains(object.getId())
			|| GRAND_GOLD_CHEST_ID == object.getId()
			|| SARCOPHAGUS_ID == object.getId())
		{
			objectsToHighlight.add(object);
		}
	}

	public boolean isInPyramidPlunder()
	{
		return client.getLocalPlayer() != null
			&& PYRAMID_PLUNDER_REGION == client.getLocalPlayer().getWorldLocation().getRegionID()
			&& client.getVar(Varbits.PYRAMID_PLUNDER_TIMER) > 0;
	}
}
