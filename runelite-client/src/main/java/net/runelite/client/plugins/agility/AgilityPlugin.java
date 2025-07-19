/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.agility;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import static net.runelite.api.Skill.AGILITY;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GroundObjectDespawned;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.StatChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.AgilityShortcut;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Agility",
	description = "Show helpful information about agility courses and obstacles",
	tags = {"grace", "marks", "overlay", "shortcuts", "skilling", "traps", "sepulchre"}
)
@PluginDependency(XpTrackerPlugin.class)
@Slf4j
public class AgilityPlugin extends Plugin
{
	private static final int AGILITY_ARENA_REGION_ID = 11157;
	private static final Set<Integer> SEPULCHRE_NPCS = ImmutableSet.of(
		NpcID.HALLOWED_PROJECTILE_NPC, NpcID.HALLOWED_PROJECTILE_NPC_T2, NpcID.HALLOWED_PROJECTILE_NPC_T3,  // arrows
		NpcID.HALLOWED_SWORD_NPC, NpcID.HALLOWED_SWORD_NPC_T2, NpcID.HALLOWED_SWORD_NPC_T3   // swords
	);

	@Getter
	private final Map<TileObject, Obstacle> obstacles = new HashMap<>();

	@Getter
	private final List<Tile> marksOfGrace = new ArrayList<>();

	@Getter
	private final Set<NPC> npcs = new HashSet<>();

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private AgilityOverlay agilityOverlay;

	@Inject
	private LapCounterOverlay lapCounterOverlay;

	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private AgilityConfig config;

	@Inject
	private ItemManager itemManager;

	@Inject
	private XpTrackerService xpTrackerService;

	@Getter
	@Setter(AccessLevel.PACKAGE)
	private AgilitySession session;

	private int lastAgilityXp;
	private WorldPoint lastArenaTicketPosition;

	@Getter
	private int agilityLevel;

	@Getter(AccessLevel.PACKAGE)
	private Tile stickTile;

	@Provides
	AgilityConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AgilityConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(agilityOverlay);
		overlayManager.add(lapCounterOverlay);
		agilityLevel = client.getBoostedSkillLevel(AGILITY);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(agilityOverlay);
		overlayManager.remove(lapCounterOverlay);
		marksOfGrace.clear();
		obstacles.clear();
		session = null;
		agilityLevel = 0;
		stickTile = null;
		npcs.clear();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case LOGIN_SCREEN:
				session = null;
				lastArenaTicketPosition = null;
				removeAgilityArenaTimer();
				npcs.clear();
				break;
			case LOADING:
				marksOfGrace.clear();
				obstacles.clear();
				stickTile = null;
				break;
			case LOGGED_IN:
				if (!isInAgilityArena())
				{
					lastArenaTicketPosition = null;
					removeAgilityArenaTimer();
				}
				break;
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!config.showAgilityArenaTimer())
		{
			removeAgilityArenaTimer();
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (event.getVarbitId() == VarbitID.VARLAMORE_WYRM_AGILITY_ADVANCED_PROGRESS && event.getValue() == 6)
		{
			trackSession(Courses.COLOSSAL_WYRM_ADVANCED);
		}
		else if (event.getVarbitId() == VarbitID.VARLAMORE_WYRM_AGILITY_BASIC_PROGRESS && event.getValue() == 6)
		{
			trackSession(Courses.COLOSSAL_WYRM_BASIC);
		}
	}

	@Subscribe
	public void onStatChanged(StatChanged statChanged)
	{
		if (statChanged.getSkill() != AGILITY)
		{
			return;
		}

		agilityLevel = statChanged.getBoostedLevel();

		// Determine how much EXP was actually gained
		int agilityXp = statChanged.getXp();
		int skillGained = agilityXp - lastAgilityXp;
		lastAgilityXp = agilityXp;

		log.debug("Gained {} xp at {}", skillGained, client.getLocalPlayer().getWorldLocation());

		// Get course
		Courses course = Courses.getCourse(client.getLocalPlayer().getWorldLocation().getRegionID());
		if (course == null
			|| !config.showLapCount()
			|| Arrays.stream(course.getCourseEndWorldPoints()).noneMatch(wp -> wp.equals(client.getLocalPlayer().getWorldLocation())))
		{
			return;
		}

		trackSession(course);
	}

	@Subscribe
	public void onItemSpawned(ItemSpawned itemSpawned)
	{
		if (obstacles.isEmpty())
		{
			return;
		}

		final TileItem item = itemSpawned.getItem();
		final Tile tile = itemSpawned.getTile();

		if (item.getId() == ItemID.GRACE)
		{
			marksOfGrace.add(tile);
		}

		if (item.getId() == ItemID.WAA_STICK)
		{
			stickTile = tile;
		}
	}

	@Subscribe
	public void onItemDespawned(ItemDespawned itemDespawned)
	{
		final TileItem item = itemDespawned.getItem();
		final Tile tile = itemDespawned.getTile();

		marksOfGrace.remove(tile);

		if (item.getId() == ItemID.WAA_STICK && stickTile == tile)
		{
			stickTile = null;
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		if (isInAgilityArena())
		{
			// Hint arrow has no plane, and always returns the current plane
			WorldPoint newTicketPosition = client.getHintArrowPoint();
			WorldPoint oldTickPosition = lastArenaTicketPosition;

			lastArenaTicketPosition = newTicketPosition;

			if (oldTickPosition != null && newTicketPosition != null
				&& (oldTickPosition.getX() != newTicketPosition.getX() || oldTickPosition.getY() != newTicketPosition.getY()))
			{
				log.debug("Ticked position moved from {} to {}", oldTickPosition, newTicketPosition);

				notifier.notify(config.notifyAgilityArena(), "Ticket location changed");

				if (config.showAgilityArenaTimer())
				{
					showNewAgilityArenaTimer();
				}
			}
		}
	}

	private void trackSession(Courses course)
	{
		if (session == null || session.getCourse() != course)
		{
			session = new AgilitySession(course);
			log.debug("Started new agility session for course: {}", course);
		}

		session.incrementLapCount(client, xpTrackerService);
	}

	private boolean isInAgilityArena()
	{
		Player local = client.getLocalPlayer();
		if (local == null)
		{
			return false;
		}

		WorldPoint location = local.getWorldLocation();
		return location.getRegionID() == AGILITY_ARENA_REGION_ID;
	}

	private void removeAgilityArenaTimer()
	{
		infoBoxManager.removeIf(infoBox -> infoBox instanceof AgilityArenaTimer);
	}

	private void showNewAgilityArenaTimer()
	{
		removeAgilityArenaTimer();
		infoBoxManager.addInfoBox(new AgilityArenaTimer(this, itemManager.getImage(ItemID.AGILITYARENA_TICKET)));
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getGameObject());
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getGameObject(), null);
	}

	@Subscribe
	public void onGroundObjectSpawned(GroundObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getGroundObject());
	}

	@Subscribe
	public void onGroundObjectDespawned(GroundObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getGroundObject(), null);
	}

	@Subscribe
	public void onWallObjectSpawned(WallObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getWallObject());
	}

	@Subscribe
	public void onWallObjectDespawned(WallObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getWallObject(), null);
	}

	@Subscribe
	public void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getDecorativeObject());
	}

	@Subscribe
	public void onDecorativeObjectDespawned(DecorativeObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getDecorativeObject(), null);
	}

	private void onTileObject(Tile tile, TileObject oldObject, TileObject newObject)
	{
		obstacles.remove(oldObject);

		if (newObject == null)
		{
			return;
		}

		if (Obstacles.OBSTACLE_IDS.contains(newObject.getId()) ||
			Obstacles.PORTAL_OBSTACLE_IDS.contains(newObject.getId()) ||
			(Obstacles.TRAP_OBSTACLE_IDS.contains(newObject.getId())
				&& Obstacles.TRAP_OBSTACLE_REGIONS.contains(newObject.getWorldLocation().getRegionID())) ||
			Obstacles.SEPULCHRE_OBSTACLE_IDS.contains(newObject.getId()) ||
			Obstacles.SEPULCHRE_SKILL_OBSTACLE_IDS.contains(newObject.getId()))
		{
			obstacles.put(newObject, new Obstacle(tile, null));
		}

		if (Obstacles.SHORTCUT_OBSTACLE_IDS.containsKey(newObject.getId()))
		{
			AgilityShortcut closestShortcut = null;
			int distance = -1;

			// Find the closest shortcut to this object
			for (AgilityShortcut shortcut : Obstacles.SHORTCUT_OBSTACLE_IDS.get(newObject.getId()))
			{
				if (!shortcut.matches(client, newObject))
				{
					continue;
				}

				if (shortcut.getWorldLocation() == null)
				{
					closestShortcut = shortcut;
					break;
				}
				else
				{
					int newDistance = shortcut.getWorldLocation().distanceTo2D(newObject.getWorldLocation());
					if (closestShortcut == null || newDistance < distance)
					{
						closestShortcut = shortcut;
						distance = newDistance;
					}
				}
			}

			if (closestShortcut != null)
			{
				obstacles.put(newObject, new Obstacle(tile, closestShortcut));
			}
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		NPC npc = npcSpawned.getNpc();

		if (SEPULCHRE_NPCS.contains(npc.getId()))
		{
			npcs.add(npc);
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC npc = npcDespawned.getNpc();
		npcs.remove(npc);
	}
}
