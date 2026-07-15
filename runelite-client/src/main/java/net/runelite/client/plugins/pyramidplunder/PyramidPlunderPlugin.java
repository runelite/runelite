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
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.WallObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;
import net.runelite.api.gameval.ObjectID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.RSTimeUnit;
import net.runelite.client.util.Text;

@Slf4j
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
	private static final int MAX_PENDING_DOOR_TICKS = 30;

	static final Set<Integer> PYRAMID_ENTRANCE_IDS = ImmutableSet.of(
		ObjectID.NTK_PYRAMID_DOOR_NORTH_ANIM, ObjectID.NTK_PYRAMID_DOOR_NORTH_NOANIM, ObjectID.NTK_PYRAMID_DOOR_NORTH_OPEN_NOANIM,
		ObjectID.NTK_PYRAMID_DOOR_EAST_ANIM, ObjectID.NTK_PYRAMID_DOOR_EAST_NOANIM, ObjectID.NTK_PYRAMID_DOOR_EAST_OPEN_NOANIM,
		ObjectID.NTK_PYRAMID_DOOR_SOUTH_ANIM, ObjectID.NTK_PYRAMID_DOOR_SOUTH_NOANIM, ObjectID.NTK_PYRAMID_DOOR_SOUTH_OPEN_NOANIM,
		ObjectID.NTK_PYRAMID_DOOR_WEST_ANIM, ObjectID.NTK_PYRAMID_DOOR_WEST_NOANIM, ObjectID.NTK_PYRAMID_DOOR_WEST_OPEN_NOANIM,
		ObjectID.NTK_PYRAMID_DOOR_NORTH_MULTI, ObjectID.NTK_PYRAMID_DOOR_EAST_MULTI,
		ObjectID.NTK_PYRAMID_DOOR_SOUTH_MULTI, ObjectID.NTK_PYRAMID_DOOR_WEST_MULTI);

	static final Set<Integer> TOMB_DOOR_WALL_IDS = ImmutableSet.of(ObjectID.NTK_TOMB_DOOR1, ObjectID.NTK_TOMB_DOOR2, ObjectID.NTK_TOMB_DOOR3, ObjectID.NTK_TOMB_DOOR4);
	static final int TOMB_DOOR_CLOSED_ID = ObjectID.NTK_TOMB_DOOR_NOANIM;

	static final int SPEARTRAP_ID = ObjectID.NTK_SPEARTRAP_INMOTION;

	static final Set<Integer> URN_IDS = ImmutableSet.of(ObjectID.NTK_URN_TYPE1_MULTI_1, ObjectID.NTK_URN_TYPE1_MULTI_2, ObjectID.NTK_URN_TYPE1_MULTI_3, ObjectID.NTK_URN_TYPE1_MULTI_4,
		ObjectID.NTK_URN_TYPE1_MULTI_5, ObjectID.NTK_URN_TYPE2_MULTI_6, ObjectID.NTK_URN_TYPE2_MULTI_7, ObjectID.NTK_URN_TYPE2_MULTI_8, ObjectID.NTK_URN_TYPE2_MULTI_9, ObjectID.NTK_URN_TYPE2_MULTI_10,
		ObjectID.NTK_URN_TYPE3_MULTI_11, ObjectID.NTK_URN_TYPE3_MULTI_12, ObjectID.NTK_URN_TYPE3_MULTI_13, ObjectID.NTK_URN_TYPE3_MULTI_14, ObjectID.NTK_URN_TYPE3_MULTI_15);
	static final Set<Integer> URN_CLOSED_IDS = ImmutableSet.of(ObjectID.NTK_URN1_CLOSED, ObjectID.NTK_URN2_CLOSED, ObjectID.NTK_URN3_CLOSED);

	static final int GRAND_GOLD_CHEST_ID = ObjectID.NTK_GOLDEN_CHEST_MULTI;
	static final int GRAND_GOLD_CHEST_CLOSED_ID = ObjectID.NTK_GOLDEN_CHEST_CLOSED;

	static final int SARCOPHAGUS_ID = ObjectID.NTK_SARCOPHAGUS_MULTI;
	static final int SARCOPHAGUS_CLOSED_ID = ObjectID.NTK_SARCOPHAGUS;

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

	@Getter
	private TileObject highlightedEntrance;

	private WorldPoint lastGoodEntrance;
	private WorldPoint pendingEntrance;
	private int pendingEntranceTicks;
	private int timerAtEntranceAttempt;
	private boolean entranceLookupMissLogged;
	private PyramidPlunderTimer timer;

	@Provides
	PyramidPlunderConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PyramidPlunderConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		lastGoodEntrance = null;
		pendingEntrance = null;
		highlightedEntrance = null;
		entranceLookupMissLogged = false;
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		tilesToHighlight.clear();
		objectsToHighlight.clear();
		lastGoodEntrance = null;
		pendingEntrance = null;
		highlightedEntrance = null;
		overlayManager.remove(overlay);
		timer = null;
		infoBoxManager.removeIf(PyramidPlunderTimer.class::isInstance);

		clientThread.invoke(() ->
		{
			Widget ppWidget = client.getWidget(InterfaceID.NtkOverlay.CONTENT);
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
			highlightedEntrance = null;
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		updateLastGoodEntrance();

		if (isInPyramidPlunder())
		{
			if (timer == null)
			{
				int ppTimer = client.getVarbitValue(VarbitID.NTK_PLAYER_TIMER_COUNT);
				Duration remaining = PYRAMID_PLUNDER_DURATION.minus(ppTimer, RSTimeUnit.GAME_TICKS);
				timer = new PyramidPlunderTimer(remaining, itemManager.getImage(ItemID.NTK_JEWELLED_SCEPTRE_3), this,
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
		considerForEntranceHighlight(object);
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
		considerForEntranceHighlight(object);
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (!"Search".equalsIgnoreCase(event.getMenuOption()))
		{
			return;
		}

		String target = Text.removeTags(event.getMenuTarget());
		log.debug("Search clicked: target='{}', id={}, scene=({}, {}), plane={}",
			target, event.getId(), event.getParam0(), event.getParam1(), client.getPlane());

		if (!PYRAMID_ENTRANCE_IDS.contains(event.getId())
			&& !"An anonymous looking door".equalsIgnoreCase(target))
		{
			log.debug("Ignoring Search because it did not match a Pyramid Plunder entrance");
			return;
		}

		WorldPoint clickedPoint = WorldPoint.fromScene(client, event.getParam0(), event.getParam1(), client.getPlane());
		TileObject clickedEntrance = findEntranceAt(clickedPoint);
		pendingEntrance = clickedEntrance == null ? clickedPoint : clickedEntrance.getWorldLocation();
		pendingEntranceTicks = 0;
		timerAtEntranceAttempt = client.getVarbitValue(VarbitID.NTK_PLAYER_TIMER_COUNT);
		entranceLookupMissLogged = false;
		log.debug("Entrance attempt recorded: clickedPoint={}, resolvedObjectId={}, pendingEntrance={}, timer={}",
			clickedPoint, clickedEntrance == null ? null : clickedEntrance.getId(), pendingEntrance, timerAtEntranceAttempt);
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		if (pendingEntrance != null && isGuardianMummy(event.getNpc()))
		{
			log.debug("Guardian mummy spawned while entrance {} is pending: id={}, name='{}'",
				pendingEntrance, event.getNpc().getId(), event.getNpc().getName());
			confirmPendingEntrance("guardian mummy spawned");
		}
	}

	@Subscribe
	public void onWallObjectDespawned(WallObjectDespawned event)
	{
		clearIfHighlighted(event.getWallObject());
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		clearIfHighlighted(event.getGameObject());
	}

	private void updateLastGoodEntrance()
	{
		// TODO(maeve): only run in sophanem
		if (pendingEntrance != null)
		{
			for (NPC npc : client.getNpcs())
			{
				if (isGuardianMummy(npc))
				{
					log.debug("Guardian mummy already present while entrance {} is pending: id={}, name='{}'",
						pendingEntrance, npc.getId(), npc.getName());
					confirmPendingEntrance("guardian mummy present");
					break;
				}
			}

			if (pendingEntrance != null && timerAtEntranceAttempt <= 0
				&& client.getVarbitValue(VarbitID.NTK_PLAYER_TIMER_COUNT) > 0)
			{
				log.debug("Pyramid Plunder timer activated for pending entrance {}: before={}, now={}",
					pendingEntrance, timerAtEntranceAttempt, client.getVarbitValue(VarbitID.NTK_PLAYER_TIMER_COUNT));
				confirmPendingEntrance("Pyramid Plunder timer activated");
			}

			if (pendingEntrance != null && ++pendingEntranceTicks > MAX_PENDING_DOOR_TICKS)
			{
				log.debug("Entrance attempt expired without finding the Guardian mummy: {}", pendingEntrance);
				if (pendingEntrance.equals(lastGoodEntrance))
				{
					log.debug("Clearing stale last good entrance: {}", lastGoodEntrance);
					lastGoodEntrance = null;
					highlightedEntrance = null;
				}
				pendingEntrance = null;
			}
		}

		if (config.highlightLastGoodEntrance() && lastGoodEntrance != null && highlightedEntrance == null)
		{
			highlightedEntrance = findEntranceAt(lastGoodEntrance);
			if (highlightedEntrance != null)
			{
				log.debug("Resolved highlighted entrance object: id={}, type={}, location={}",
					highlightedEntrance.getId(), highlightedEntrance.getClass().getSimpleName(),
					highlightedEntrance.getWorldLocation());
				entranceLookupMissLogged = false;
			}
			else if (!entranceLookupMissLogged)
			{
				log.debug("No loaded entrance object found near last good entrance {}", lastGoodEntrance);
				entranceLookupMissLogged = true;
			}
		}
		else if (!config.highlightLastGoodEntrance())
		{
			highlightedEntrance = null;
		}
	}

	private static boolean isGuardianMummy(NPC npc)
	{
		return npc.getId() == NpcID.NTK_MUMMY_GUARDIAN
			|| npc.getId() == NpcID.NTK_MUMMY_GUARDIAN_DUMMY
			|| "Guardian mummy".equalsIgnoreCase(npc.getName())
			|| "Annoyed guardian mummy".equalsIgnoreCase(npc.getName());
	}

	private void confirmPendingEntrance(String reason)
	{
		lastGoodEntrance = pendingEntrance;
		pendingEntrance = null;
		entranceLookupMissLogged = false;
		log.debug("Confirmed last good Pyramid Plunder entrance {} ({})", lastGoodEntrance, reason);
	}

	private void considerForEntranceHighlight(TileObject object)
	{
		if (config.highlightLastGoodEntrance() && lastGoodEntrance != null
			&& matchesEntrance(object, lastGoodEntrance))
		{
			highlightedEntrance = object;
			log.debug("Entrance spawn matched last good entrance: id={}, type={}, location={}",
				object.getId(), object.getClass().getSimpleName(), object.getWorldLocation());
		}
	}

	private void clearIfHighlighted(TileObject object)
	{
		if (object == highlightedEntrance)
		{
			highlightedEntrance = null;
		}
	}

	private TileObject findEntranceAt(WorldPoint point)
	{
		for (Tile[][] plane : client.getScene().getTiles())
		{
			for (Tile[] row : plane)
			{
				for (Tile tile : row)
				{
					if (tile == null)
					{
						continue;
					}

					WallObject wall = tile.getWallObject();
					if (matchesEntrance(wall, point))
					{
						return wall;
					}

					DecorativeObject decorative = tile.getDecorativeObject();
					if (matchesEntrance(decorative, point))
					{
						return decorative;
					}

					for (GameObject gameObject : tile.getGameObjects())
					{
						if (matchesEntrance(gameObject, point))
						{
							return gameObject;
						}
					}
				}
			}
		}
		return null;
	}

	private boolean matchesEntrance(TileObject object, WorldPoint point)
	{
		return object != null && isPyramidEntrance(object)
			&& point.distanceTo(object.getWorldLocation()) <= 1;
	}

	private static boolean isPyramidEntrance(TileObject object)
	{
		return PYRAMID_ENTRANCE_IDS.contains(object.getId());
	}

	public boolean isInPyramidPlunder()
	{
		return client.getLocalPlayer() != null
			&& PYRAMID_PLUNDER_REGION == client.getLocalPlayer().getWorldLocation().getRegionID()
			&& client.getVarbitValue(VarbitID.NTK_PLAYER_TIMER_COUNT) > 0;
	}
}
