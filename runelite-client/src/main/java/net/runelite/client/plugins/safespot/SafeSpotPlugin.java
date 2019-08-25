/*
 *  Copyright (c) 2019. PKLite
 *   Redistributions and modifications of this software are permitted as long as this notice remains in its original unmodified state at the top of this file. If there are any questions, comments, or feedback about this software, please direct all inquiries directly to the following authors.
 *   PKLite discord: https://discord.gg/Dp3HuFM
 *  Written by PKLite(ST0NEWALL, others) <stonewall@stonewall@pklite.xyz>, 2019
 *
 */

package net.runelite.client.plugins.safespot;

import com.google.inject.Provides;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.CollisionDataFlag;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.NPCManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "1 Way Safe Spots",
	description = "Renders tile overlays for one way safe spots",
	tags = {"safe spot", "pvp", "safespots", "pklite"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
public class SafeSpotPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	OverlayManager overlayManager;

	@Inject
	private SafeSpotConfig config;

	@Inject
	private EventBus eventBus;

	@Inject
	private NPCManager npcManager;

	@Getter(AccessLevel.PACKAGE)
	private List<Tile> safeSpotList;

	@Getter(AccessLevel.PACKAGE)
	private boolean safeSpotsRenderable = false;

	private SafeSpotOverlay safeSpotOverlay;
	private int tickCount = 0;

	private boolean playerSafeSpots;
	private boolean npcSafeSpots;
	@Getter(AccessLevel.PACKAGE)
	private Color tileColor;

	@Provides
	SafeSpotConfig config(ConfigManager configManager)
	{
		return configManager.getConfig(SafeSpotConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		safeSpotOverlay = new SafeSpotOverlay(client, this);
		overlayManager.add(safeSpotOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(safeSpotOverlay);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(InteractingChanged.class, this, this::onInteractingChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
	}

	private void onInteractingChanged(InteractingChanged event)
	{
		if (event.getSource() != client.getLocalPlayer())
		{
			return;
		}
		if (event.getTarget() == null && (this.npcSafeSpots || this.playerSafeSpots))
		{
			tickCount = 10;
		}
	}

	private void onGameTick(GameTick event)
	{
		if (client.getLocalPlayer().getInteracting() != null)
		{
			if (client.getLocalPlayer().getInteracting() instanceof Player && this.playerSafeSpots)
			{
				safeSpotsRenderable = true;
				updateSafeSpots();
			}
			if (client.getLocalPlayer().getInteracting() instanceof NPC && this.npcSafeSpots)
			{
				if (npcManager.getStats(((NPC) client.getLocalPlayer().getInteracting()).getId()) != null)
				{
					safeSpotsRenderable = true;
					updateSafeSpots();
				}
			}
		}
		else if (tickCount > 0)
		{
			tickCount--;
		}
		else
		{
			safeSpotsRenderable = false;
		}
	}

	/**
	 * Call this method to update the ArrayList of safespot tiles
	 */
	private void updateSafeSpots()
	{
		if (client.getLocalPlayer().getInteracting() != null)
		{
			Actor enemy = client.getLocalPlayer().getInteracting();
			WorldArea worldArea = new WorldArea(enemy.getWorldLocation().getX() - 12,
				enemy.getWorldLocation().getY() - 12, 24, 24, client.getPlane());
			List<WorldPoint> worldPoints = worldArea.toWorldPointList();
			safeSpotList = getSafeSpotList(enemy, worldPoints);
		}
	}

	/**
	 * The ArrayList of 1-way safe spots
	 *
	 * @param actor       - The Actor that the tiles are a safe spot against
	 * @param worldPoints - Worldpoints in the current scene
	 * @return an ArrayList of Tiles where current player can attack actor but actor cannot attack local player
	 */
	private List<Tile> getSafeSpotList(Actor actor, List<WorldPoint> worldPoints)
	{
		List<Tile> safeSpotList = new ArrayList<>();
		Tile[][][] tiles = client.getScene().getTiles();
		for (WorldPoint w : worldPoints)
		{
			LocalPoint toPoint = LocalPoint.fromWorld(client, w);
			Tile fromTile = tiles[client.getPlane()][actor.getLocalLocation().getSceneX()]
				[actor.getLocalLocation().getSceneY()];
			Tile toTile = null;
			if (toPoint != null)
			{
				toTile = tiles[client.getPlane()][toPoint.getSceneX()]
					[toPoint.getSceneY()];
			}
			final int plane = client.getLocalPlayer().getWorldArea().getPlane();
			int bit = 0;
			if (toPoint != null)
			{
				bit = Objects.requireNonNull(client.getCollisionMaps())[plane].getFlags()[toPoint.getSceneX()][toPoint.getSceneY()];
			}
			if (toTile != null && toTile.hasLineOfSightTo(fromTile) && !fromTile.hasLineOfSightTo(toTile) &&
				(!((bit & CollisionDataFlag.BLOCK_MOVEMENT_OBJECT) == CollisionDataFlag.BLOCK_MOVEMENT_OBJECT ||
					(bit & CollisionDataFlag.BLOCK_MOVEMENT_FLOOR_DECORATION)
						== CollisionDataFlag.BLOCK_MOVEMENT_FLOOR_DECORATION ||
					(bit & CollisionDataFlag.BLOCK_MOVEMENT_FLOOR) == CollisionDataFlag.BLOCK_MOVEMENT_FLOOR ||
					(bit & CollisionDataFlag.BLOCK_MOVEMENT_FULL) == CollisionDataFlag.BLOCK_MOVEMENT_FULL)))
			{
				safeSpotList.add(toTile);
			}
		}
		return safeSpotList;
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("safespot"))
		{
			return;
		}

		updateConfig();
	}

	private void updateConfig()
	{
		this.playerSafeSpots = config.playerSafeSpots();
		this.npcSafeSpots = config.npcSafeSpots();
		this.tileColor = config.tileColor();
	}
}