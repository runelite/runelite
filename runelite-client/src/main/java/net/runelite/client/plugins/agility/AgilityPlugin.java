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

import com.google.common.primitives.Ints;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import static net.runelite.api.ItemID.AGILITY_ARENA_TICKET;
import net.runelite.api.MenuEntry;
import net.runelite.api.MenuOpcode;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import static net.runelite.api.Skill.AGILITY;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.BoostedLevelChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.DecorativeObjectChanged;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GroundObjectChanged;
import net.runelite.api.events.GroundObjectDespawned;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.WallObjectChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.AgilityShortcut;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.ColorUtil;

@PluginDescriptor(
	name = "Agility",
	description = "Show helpful information about agility courses and obstacles",
	tags = {"grace", "marks", "overlay", "shortcuts", "skilling", "traps"}
)
@Slf4j
@Singleton
public class AgilityPlugin extends Plugin
{
	private static final int AGILITY_ARENA_REGION_ID = 11157;
	private static final Object MENU_SUBS = new Object();

	@Getter(AccessLevel.PACKAGE)
	private final Map<TileObject, Obstacle> obstacles = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private final List<Tile> marksOfGrace = new ArrayList<>();

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
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private AgilitySession session;

	private int lastAgilityXp;
	private WorldPoint lastArenaTicketPosition;

	@Getter(AccessLevel.PACKAGE)
	private int agilityLevel;

	@Provides
	AgilityConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AgilityConfig.class);
	}

	// Config values
	@Getter(AccessLevel.PACKAGE)
	private boolean removeDistanceCap;
	@Getter(AccessLevel.PACKAGE)
	private boolean showLapCount;
	@Getter(AccessLevel.PACKAGE)
	private int lapTimeout;
	@Getter(AccessLevel.PACKAGE)
	private boolean lapsToLevel;
	@Getter(AccessLevel.PACKAGE)
	private boolean lapsToGoal;
	@Getter(AccessLevel.PACKAGE)
	private Color overlayColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean highlightMarks;
	@Getter(AccessLevel.PACKAGE)
	private Color markColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean highlightShortcuts;
	@Getter(AccessLevel.PACKAGE)
	private boolean showTrapOverlay;
	@Getter(AccessLevel.PACKAGE)
	private Color trapColor;
	private boolean notifyAgilityArena;
	private boolean showAgilityArenaTimer;

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		if (config.showShortcutLevel())
		{
			addMenuSubscriptions();
		}

		overlayManager.add(agilityOverlay);
		overlayManager.add(lapCounterOverlay);
		agilityLevel = client.getBoostedSkillLevel(Skill.AGILITY);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
		eventBus.unregister(MENU_SUBS);

		overlayManager.remove(agilityOverlay);
		overlayManager.remove(lapCounterOverlay);
		marksOfGrace.clear();
		obstacles.clear();
		session = null;
		agilityLevel = 0;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(ExperienceChanged.class, this, this::onExperienceChanged);
		eventBus.subscribe(BoostedLevelChanged.class, this, this::onBoostedLevelChanged);
		eventBus.subscribe(ItemSpawned.class, this, this::onItemSpawned);
		eventBus.subscribe(ItemDespawned.class, this, this::onItemDespawned);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(GameObjectSpawned.class, this, this::onGameObjectSpawned);
		eventBus.subscribe(GameObjectChanged.class, this, this::onGameObjectChanged);
		eventBus.subscribe(GameObjectDespawned.class, this, this::onGameObjectDespawned);
		eventBus.subscribe(GroundObjectSpawned.class, this, this::onGroundObjectSpawned);
		eventBus.subscribe(GroundObjectChanged.class, this, this::onGroundObjectChanged);
		eventBus.subscribe(GroundObjectDespawned.class, this, this::onGroundObjectDespawned);
		eventBus.subscribe(WallObjectSpawned.class, this, this::onWallObjectSpawned);
		eventBus.subscribe(WallObjectChanged.class, this, this::onWallObjectChanged);
		eventBus.subscribe(WallObjectDespawned.class, this, this::onWallObjectDespawned);
		eventBus.subscribe(DecorativeObjectSpawned.class, this, this::onDecorativeObjectSpawned);
		eventBus.subscribe(DecorativeObjectChanged.class, this, this::onDecorativeObjectChanged);
		eventBus.subscribe(DecorativeObjectDespawned.class, this, this::onDecorativeObjectDespawned);
	}

	private void addMenuSubscriptions()
	{
		eventBus.subscribe(BeforeRender.class, MENU_SUBS, this::onBeforeRender);
		eventBus.subscribe(MenuOpened.class, MENU_SUBS, this::onMenuOpened);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case LOGIN_SCREEN:
				session = null;
				lastArenaTicketPosition = null;
				removeAgilityArenaTimer();
				break;
			case LOADING:
				marksOfGrace.clear();
				obstacles.clear();
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

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("agility"))
		{
			return;
		}

		if ("addLevelsToShortcutOptions".equals(event.getKey()))
		{
			if (config.showShortcutLevel())
			{
				addMenuSubscriptions();
			}
			else
			{
				eventBus.unregister(MENU_SUBS);
			}
			return;
		}

		updateConfig();

		if (!this.showAgilityArenaTimer)
		{
			removeAgilityArenaTimer();
		}
	}

	public void updateConfig()
	{
		this.removeDistanceCap = config.removeDistanceCap();
		this.showLapCount = config.showLapCount();
		this.lapTimeout = config.lapTimeout();
		this.lapsToLevel = config.lapsToLevel();
		this.lapsToGoal = config.lapsToGoal();
		this.overlayColor = config.getOverlayColor();
		this.highlightMarks = config.highlightMarks();
		this.markColor = config.getMarkColor();
		this.highlightShortcuts = config.highlightShortcuts();
		this.showTrapOverlay = config.showTrapOverlay();
		this.trapColor = config.getTrapColor();
		this.notifyAgilityArena = config.notifyAgilityArena();
		this.showAgilityArenaTimer = config.showAgilityArenaTimer();
	}

	private void onExperienceChanged(ExperienceChanged event)
	{
		if (event.getSkill() != AGILITY || !this.showLapCount)
		{
			return;
		}

		// Determine how much EXP was actually gained
		int agilityXp = client.getSkillExperience(AGILITY);
		int skillGained = agilityXp - lastAgilityXp;
		lastAgilityXp = agilityXp;

		// Get course
		Courses course = Courses.getCourse(client.getLocalPlayer().getWorldLocation().getRegionID());
		if (course == null
			|| (course.getCourseEndWorldPoints().length == 0
			? Math.abs(course.getLastObstacleXp() - skillGained) > 1
			: Arrays.stream(course.getCourseEndWorldPoints()).noneMatch(wp -> wp.equals(client.getLocalPlayer().getWorldLocation()))))
		{
			return;
		}

		if (session != null && session.getCourse() == course)
		{
			session.incrementLapCount(client);
		}
		else
		{
			session = new AgilitySession(course);
			// New course found, reset lap count and set new course
			session.resetLapCount();
			session.incrementLapCount(client);
		}
	}

	private void onBoostedLevelChanged(BoostedLevelChanged boostedLevelChanged)
	{
		Skill skill = boostedLevelChanged.getSkill();
		if (skill == AGILITY)
		{
			agilityLevel = client.getBoostedSkillLevel(skill);
		}
	}

	private void onItemSpawned(ItemSpawned itemSpawned)
	{
		if (obstacles.isEmpty())
		{
			return;
		}

		final TileItem item = itemSpawned.getItem();
		final Tile tile = itemSpawned.getTile();

		if (item.getId() == ItemID.MARK_OF_GRACE)
		{
			marksOfGrace.add(tile);
		}
	}

	private void onItemDespawned(ItemDespawned itemDespawned)
	{
		final Tile tile = itemDespawned.getTile();
		marksOfGrace.remove(tile);
	}

	private void onGameTick(GameTick tick)
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

				if (this.notifyAgilityArena)
				{
					notifier.notify("Ticket location changed");
				}

				if (this.showAgilityArenaTimer)
				{
					showNewAgilityArenaTimer();
				}
			}
		}
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
		infoBoxManager.addInfoBox(new AgilityArenaTimer(this, itemManager.getImage(AGILITY_ARENA_TICKET)));
	}

	private void onGameObjectSpawned(GameObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getGameObject());
	}

	private void onGameObjectChanged(GameObjectChanged event)
	{
		onTileObject(event.getTile(), event.getPrevious(), event.getGameObject());
	}

	private void onGameObjectDespawned(GameObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getGameObject(), null);
	}

	private void onGroundObjectSpawned(GroundObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getGroundObject());
	}

	private void onGroundObjectChanged(GroundObjectChanged event)
	{
		onTileObject(event.getTile(), event.getPrevious(), event.getGroundObject());
	}

	private void onGroundObjectDespawned(GroundObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getGroundObject(), null);
	}

	private void onWallObjectSpawned(WallObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getWallObject());
	}

	private void onWallObjectChanged(WallObjectChanged event)
	{
		onTileObject(event.getTile(), event.getPrevious(), event.getWallObject());
	}

	private void onWallObjectDespawned(WallObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getWallObject(), null);
	}

	private void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getDecorativeObject());
	}

	private void onDecorativeObjectChanged(DecorativeObjectChanged event)
	{
		onTileObject(event.getTile(), event.getPrevious(), event.getDecorativeObject());
	}

	private void onDecorativeObjectDespawned(DecorativeObjectDespawned event)
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

		if (Obstacles.COURSE_OBSTACLE_IDS.contains(newObject.getId()) ||
			(Obstacles.TRAP_OBSTACLE_IDS.contains(newObject.getId())
				&& Obstacles.TRAP_OBSTACLE_REGIONS.contains(newObject.getWorldLocation().getRegionID())))
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

	private void onBeforeRender(BeforeRender event)
	{
		if (client.isMenuOpen() || client.getMenuOptionCount() <= 0)
		{
			return;
		}

		final MenuEntry entry = client.getLeftClickMenuEntry();
		if (checkAndModify(entry))
		{
			client.setLeftClickMenuEntry(entry);
		}
	}

	private void onMenuOpened(MenuOpened event)
	{
		boolean changed = false;
		for (MenuEntry entry : event.getMenuEntries())
		{
			changed |= checkAndModify(entry);
		}

		if (changed)
		{
			event.setModified();
		}
	}

	private boolean checkAndModify(MenuEntry old)
	{
		//Guarding against non-first option because agility shortcuts are always that type of event.
		if (old.getOpcode() != MenuOpcode.GAME_OBJECT_FIRST_OPTION.getId())
		{
			return false;
		}

		for (Obstacle nearbyObstacle : getObstacles().values())
		{
			AgilityShortcut shortcut = nearbyObstacle.getShortcut();
			if (shortcut != null && Ints.contains(shortcut.getObstacleIds(), old.getIdentifier()))
			{
				final int reqLevel = shortcut.getLevel();
				final String requirementText = ColorUtil.getLevelColorString(reqLevel, getAgilityLevel()) + "  (level-" + reqLevel + ")";

				old.setTarget(old.getTarget() + requirementText);
				return true;
			}
		}

		return false;
	}
}
