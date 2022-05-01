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
import net.runelite.api.ItemID;
import net.runelite.api.NullObjectID;
import net.runelite.api.ObjectID;
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

	static final Set<Integer> TOMB_DOOR_WALL_IDS = ImmutableSet.of(NullObjectID.NULL_26618, NullObjectID.NULL_26619, NullObjectID.NULL_26620, NullObjectID.NULL_26621);
	static final int TOMB_DOOR_CLOSED_ID = ObjectID.TOMB_DOOR_20948;

	static final int SPEARTRAP_ID = ObjectID.SPEARTRAP;

	static final Set<Integer> URN_IDS = ImmutableSet.of(NullObjectID.NULL_26580, NullObjectID.NULL_26600, NullObjectID.NULL_26601, NullObjectID.NULL_26602,
		NullObjectID.NULL_26603, NullObjectID.NULL_26604, NullObjectID.NULL_26605, NullObjectID.NULL_26606, NullObjectID.NULL_26607, NullObjectID.NULL_26608,
		NullObjectID.NULL_26609, NullObjectID.NULL_26610, NullObjectID.NULL_26611, NullObjectID.NULL_26612, NullObjectID.NULL_26613);
	static final Set<Integer> URN_CLOSED_IDS = ImmutableSet.of(ObjectID.URN_21261, ObjectID.URN_21262, ObjectID.URN_21263);

	static final int GRAND_GOLD_CHEST_ID = NullObjectID.NULL_26616;
	static final int GRAND_GOLD_CHEST_CLOSED_ID = ObjectID.GRAND_GOLD_CHEST;

	static final int SARCOPHAGUS_ID = NullObjectID.NULL_26626;
	static final int SARCOPHAGUS_CLOSED_ID = ObjectID.SARCOPHAGUS_21255;

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
				int ppTimer = client.getVarbitValue(Varbits.PYRAMID_PLUNDER_TIMER);
				Duration remaining = PYRAMID_PLUNDER_DURATION.minus(ppTimer, RSTimeUnit.GAME_TICKS);
				timer = new PyramidPlunderTimer(remaining, itemManager.getImage(ItemID.PHARAOHS_SCEPTRE), this,
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
			&& client.getVarbitValue(Varbits.PYRAMID_PLUNDER_TIMER) > 0;
	}
}
