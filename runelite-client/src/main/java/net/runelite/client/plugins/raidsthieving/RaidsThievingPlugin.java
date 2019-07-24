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
import java.text.MessageFormat;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GraphicsObject;
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

@Slf4j
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

	private boolean inRaidChambers;

	@Getter(AccessLevel.PACKAGE)
	private boolean batsFound;

	@Getter(AccessLevel.PACKAGE)
	private BatSolver solver;

	@Getter(AccessLevel.PACKAGE)
	private ChestIdentifier mapper;

	@Getter(AccessLevel.PACKAGE)
	private Color getPotentialBatColor;
	@Getter(AccessLevel.PACKAGE)
	private Color getPoisonTrapColor;
	private boolean batFoundNotify;


	@Provides
	RaidsThievingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RaidsThievingConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(overlay);
		overlay.updateConfig();
		reset();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		lastActionTime = Instant.ofEpochMilli(0);
		chests.clear();
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
		WorldPoint loc = obj.getWorldLocation();
		InstancePoint absLoc = InstancePoint.buildFromPoint(loc, client);

		if (obj.getId() == RaidsThievingConstants.EMPTY_TROUGH)
		{
			ThievingRoomType type = ThievingRoomType.identifyByInstancePoint(absLoc);

			if (type != null)
			{
				solver = new BatSolver(type);
				mapper = new ChestIdentifier(type);
				for (ThievingChest chest : chests.values())
				{
					mapper.indentifyChest(chest);
				}
			}
			else
			{
				log.error(MessageFormat.format("Unable to identify room type with: {0} {1} {2} {3} {4}.",
					loc.getX(), loc.getY(), absLoc.getX(), absLoc.getY(), absLoc.getRot()));
				log.error("Please report this @https://github.com/runelite/runelite/pull/4914!");
			}
		}
		if (obj.getId() == RaidsThievingConstants.CLOSED_CHEST_ID)
		{
			if (!chests.containsKey(loc))
			{
				ThievingChest chest = new ThievingChest(obj, absLoc);

				if (mapper != null)
				{
					mapper.indentifyChest(chest);
				}

				chests.put(loc, chest);
			}
			else
			{
				checkForBats();
			}
		}

		if (obj.getId() == RaidsThievingConstants.OPEN_FULL_CHEST_1 ||
			obj.getId() == RaidsThievingConstants.OPEN_FULL_CHEST_2)
		{
			ThievingChest chest = chests.get(obj.getWorldLocation());
			// We found a chest that has grubs
			log.info(MessageFormat.format("Found grubs at {0}, {1} chestId: {2}", loc.getX(), loc.getY(), chest.getChestId()));
			if (solver != null && chest.getChestId() != -1)
			{
				chest.setEverOpened(true);
				solver.addGrubsChest(chest.getChestId());
			}
			checkForBats();
		}

		if (obj.getId() == RaidsThievingConstants.OPEN_EMPTY_CHEST)
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
		if (obj.getId() == 184)
		{
			log.debug("Found poison splat");
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
			overlay.updateConfig();
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

	private boolean checkForBats()
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
				return true;
			}
		}
		return false;
	}

	int getChestId(WorldPoint worldPoint)
	{
		return chests.get(worldPoint).getChestId();
	}

	private void updateConfig()
	{
		this.getPotentialBatColor = config.getPotentialBatColor();
		this.getPoisonTrapColor = config.getPoisonTrapColor();
		this.batFoundNotify = config.batFoundNotify();
	}
}

