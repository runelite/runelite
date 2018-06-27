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

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.ItemLayer;
import net.runelite.api.Node;
import net.runelite.api.Player;
import static net.runelite.api.Skill.AGILITY;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;
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
import net.runelite.api.events.ItemLayerChanged;
import net.runelite.api.events.WallObjectChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Agility"
)
@Slf4j
public class AgilityPlugin extends Plugin
{
	private static final int AGILITY_ARENA_REGION_ID = 11157;

	@Getter
	private final Map<TileObject, Tile> obstacles = new HashMap<>();

	@Getter
	private Tile markOfGrace;

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

	@Getter
	private AgilitySession session;

	private int lastAgilityXp;
	private WorldPoint lastArenaTicketPosition;

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
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(agilityOverlay);
		overlayManager.remove(lapCounterOverlay);
		markOfGrace = null;
		obstacles.clear();
		session = null;
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
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
				markOfGrace = null;
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

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!config.showAgilityArenaTimer())
		{
			removeAgilityArenaTimer();
		}
	}

	@Subscribe
	public void onExperienceChanged(ExperienceChanged event)
	{
		if (event.getSkill() != AGILITY || !config.showLapCount())
		{
			return;
		}

		// Determine how much EXP was actually gained
		int agilityXp = client.getSkillExperience(AGILITY);
		int skillGained = agilityXp - lastAgilityXp;
		lastAgilityXp = agilityXp;

		// Get course
		Courses course = Courses.getCourse(client.getLocalPlayer().getWorldLocation().getRegionID());
		if (course == null || Math.abs(course.getLastObstacleXp() - skillGained) > 1)
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

	@Subscribe
	public void onItemLayerChanged(ItemLayerChanged event)
	{
		if (obstacles.isEmpty())
		{
			return;
		}

		final Tile tile = event.getTile();
		final ItemLayer itemLayer = tile.getItemLayer();
		final boolean hasMark = tileHasMark(itemLayer);

		if (markOfGrace != null && tile.getWorldLocation().equals(markOfGrace.getWorldLocation()) && !hasMark)
		{
			markOfGrace = null;
		}
		else if (hasMark)
		{
			markOfGrace = tile;
		}
	}

	private boolean tileHasMark(ItemLayer itemLayer)
	{
		if (itemLayer != null)
		{
			Node currentItem = itemLayer.getBottom();

			while (currentItem instanceof Item)
			{
				final Item item = (Item) currentItem;

				currentItem = currentItem.getNext();

				if (item.getId() == ItemID.MARK_OF_GRACE)
				{
					return true;
				}
			}
		}

		return false;
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		if (isInAgilityArena())
		{
			WorldPoint newTicketPosition = client.getHintArrowPoint();
			if (!Objects.equals(lastArenaTicketPosition, newTicketPosition))
			{
				// We don't want to notify when players first enter the course
				if (lastArenaTicketPosition != null && newTicketPosition != null)
				{
					if (config.notifyAgilityArena())
					{
						notifier.notify("Ticket location changed");
					}

					if (config.showAgilityArenaTimer())
					{
						showNewAgilityArenaTimer();
					}
				}

				lastArenaTicketPosition = newTicketPosition;
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
		infoBoxManager.addInfoBox(new AgilityArenaTimer(this));
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
	public void onGroundObjectSpawned(GroundObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getGroundObject());
	}

	@Subscribe
	public void onGroundObjectChanged(GroundObjectChanged event)
	{
		onTileObject(event.getTile(), event.getPrevious(), event.getGroundObject());
	}

	@Subscribe
	public void onGroundObjectDeSpawned(GroundObjectDespawned event)
	{
		onTileObject(event.getTile(), event.getGroundObject(), null);
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

	@Subscribe
	public void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		onTileObject(event.getTile(), null, event.getDecorativeObject());
	}

	@Subscribe
	public void onDecorativeObjectChanged(DecorativeObjectChanged event)
	{
		onTileObject(event.getTile(), event.getPrevious(), event.getDecorativeObject());
	}

	@Subscribe
	public void onDecorativeObjectDeSpawned(DecorativeObjectDespawned event)
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
				Obstacles.SHORTCUT_OBSTACLE_IDS.contains(newObject.getId()) ||
				(Obstacles.TRAP_OBSTACLE_IDS.contains(newObject.getId())
					&& Obstacles.TRAP_OBSTACLE_REGIONS.contains(newObject.getWorldLocation().getRegionID())))
		{
			obstacles.put(newObject, tile);
		}
	}
}
