/*
 * Copyright (c) 2017, Tim Lehner <Timothy.Lehner.2011@live.rhul.ac.uk>
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
package net.runelite.client.plugins.raidsthieving;

import com.google.inject.Provides;
import java.awt.Color;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import static net.runelite.api.Constants.CHUNK_SIZE;
import net.runelite.api.GameObject;
import net.runelite.api.GraphicID;
import net.runelite.api.GraphicsObject;
import net.runelite.api.ObjectID;
import net.runelite.api.Point;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GraphicsObjectCreated;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.raidsthieving.BatSolver.BatSolver;
import net.runelite.client.plugins.raidsthieving.BatSolver.ChestIdentifier;
import net.runelite.client.plugins.raidsthieving.BatSolver.ThievingRoomType;
import net.runelite.client.ui.overlay.OverlayManager;
import javax.inject.Inject;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@PluginDescriptor(
	name = "Raids Bat Finder",
	description = "Tracks which chests need to be searched for bats and which poison",
	tags = {"overlay", "skilling", "raid"},
	type = PluginType.PVM,
	enabledByDefault = false
)
@Singleton
public class RaidsThievingPlugin extends Plugin
{
	private static final double CHUNK_OFFSET = 3.5;

	@Inject
	private Client client;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private ChestOverlay overlay;
	@Inject
	private Notifier notifier;
	@Inject
	private RaidsThievingConfig config;
	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private final Map<WorldPoint, ThievingChest> chests = new HashMap<>();
	@Getter(AccessLevel.PACKAGE)
	private Instant lastActionTime = Instant.ofEpochMilli(0);
	@Getter(AccessLevel.PACKAGE)
	private boolean batsFound;
	@Getter(AccessLevel.PACKAGE)
	private BatSolver solver;
	@Getter(AccessLevel.PACKAGE)
	private ChestIdentifier mapper;
	@Getter(AccessLevel.PACKAGE)
	private Color potentialBatColor;
	@Getter(AccessLevel.PACKAGE)
	private Color poisonTrapColor;
	private boolean batFoundNotify;
	private boolean inRaidChambers;

	@Provides
	RaidsThievingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RaidsThievingConfig.class);
	}

	@Override
	protected void startUp()
	{
		reset();
		updateConfig();
		addSubscriptions();

		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		lastActionTime = Instant.ofEpochMilli(0);
		chests.clear();

		eventBus.unregister(this);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameObjectSpawned.class, this, this::onGameObjectSpawned);
		eventBus.subscribe(GraphicsObjectCreated.class, this, this::onGraphicsObjectCreated);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
	}

	private void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject obj = event.getGameObject();
		WorldPoint worldLoc = obj.getWorldLocation();
		Point instanceLoc = buildFromPoint(worldLoc, client);

		if (obj.getId() == ObjectID.TROUGH_29746)
		{
			ThievingRoomType type = ThievingRoomType.identifyByInstancePoint(instanceLoc);

			if (type != null)
			{
				solver = new BatSolver(type);
				mapper = new ChestIdentifier(type);
				for (ThievingChest chest : chests.values())
				{
					mapper.indentifyChest(chest);
				}
			}
		}

		if (obj.getId() == ObjectID.CHEST_29742)
		{
			if (!chests.containsKey(worldLoc))
			{
				ThievingChest chest = new ThievingChest(worldLoc, instanceLoc);

				if (mapper != null)
				{
					mapper.indentifyChest(chest);
				}

				chests.put(worldLoc, chest);
			}
			else
			{
				checkForBats();
			}
		}

		if (obj.getId() == ObjectID.CHEST_29744 || obj.getId() == ObjectID.CHEST_29745)
		{
			ThievingChest chest = chests.get(obj.getWorldLocation());
			if (solver != null && chest.getChestId() != -1)
			{
				chest.setEverOpened(true);
				solver.addGrubsChest(chest.getChestId());
			}
			checkForBats();
		}

		if (obj.getId() == ObjectID.CHEST_29743)
		{
			ThievingChest chest = chests.get(obj.getWorldLocation());
			// We found a chest that could have poison
			if (solver != null && chest.getChestId() != -1)
			{
				chest.setEmpty(true);
				chest.setEverOpened(true);
				solver.addEmptyChest(chest.getChestId());
			}
		}
	}

	private void onGraphicsObjectCreated(GraphicsObjectCreated event)
	{
		GraphicsObject obj = event.getGraphicsObject();
		if (obj.getId() == GraphicID.POISON_SPLAT)
		{
			WorldPoint loc = WorldPoint.fromLocal(client, obj.getLocation());

			if (chests.get(loc) == null)
			{
				return;
			}

			chests.get(loc).setPoison(true);
		}
	}

	private void onVarbitChanged(VarbitChanged event)
	{
		boolean setting = client.getVar(Varbits.IN_RAID) == 1;

		if (inRaidChambers != setting)
		{
			inRaidChambers = setting;
			reset();
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("raidsthievingplugin"))
		{
			updateConfig();
		}
	}

	private void reset()
	{
		chests.clear();
		batsFound = false;
		solver = null;
		mapper = null;
	}

	int numberOfEmptyChestsFound()
	{
		int total = 0;
		for (ThievingChest chest : chests.values())
		{
			if (chest.isEmpty())
			{
				total++;
			}
		}
		return total;
	}

	private void checkForBats()
	{
		for (ThievingChest chest : chests.values())
		{
			if (chest.isEmpty() && !chest.isPoison())
			{
				batsFound = true;
				if (this.batFoundNotify)
				{
					notifier.notify("Bats have been found!");
				}
				return;
			}
		}
	}

	int getChestId(WorldPoint worldPoint)
	{
		return chests.get(worldPoint).getChestId();
	}

	private static Point buildFromPoint(WorldPoint worldPoint, Client client)
	{
		Point point = new Point(worldPoint.getX(), worldPoint.getY());
		Point base = new Point(client.getBaseX(), client.getBaseY());
		int plane = worldPoint.getPlane();

		int deltaX = point.getX() - base.getX();
		int deltaY = point.getY() - base.getY();
		int chunkIndexX = deltaX / CHUNK_SIZE;
		int chunkIndexY = deltaY / CHUNK_SIZE;

		int chunkData = client.getInstanceTemplateChunks()[plane][chunkIndexX][chunkIndexY];
		int rotation = chunkData >> 1 & 0x3;
		int y = (chunkData >> 3 & 0x7FF) * 8;
		int x = (chunkData >> 14 & 0x3FF) * 8;

		return buildFromTile(base, point, rotation, new Point(x, y));
	}

	private static Point buildFromTile(Point base, Point tile, int rot, Point chunkOrigin)
	{
		int deltaX = tile.getX() - base.getX();
		int deltaY = tile.getY() - base.getY();

		double chunkOffsetX = (deltaX % CHUNK_SIZE) - CHUNK_OFFSET;
		double chunkOffsetY = (deltaY % CHUNK_SIZE) - CHUNK_OFFSET;

		for (int i = 0; i < rot; i++)
		{
			double temp = chunkOffsetX;
			chunkOffsetX = -chunkOffsetY;
			chunkOffsetY = temp;
		}

		chunkOffsetX += CHUNK_OFFSET;
		chunkOffsetY += CHUNK_OFFSET;

		int invariantChunkOffsetX = (int) chunkOffsetX;
		int invariantChunkOffsetY = (int) chunkOffsetY;

		return new Point(
			chunkOrigin.getX() + invariantChunkOffsetX,
			chunkOrigin.getY() + invariantChunkOffsetY);
	}

	private void updateConfig()
	{
		this.potentialBatColor = config.getPotentialBatColor();
		this.poisonTrapColor = config.getPoisonTrapColor();
		this.batFoundNotify = config.batFoundNotify();
	}
}
