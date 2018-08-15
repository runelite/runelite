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

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
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
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
@PluginDescriptor(
	name = "Raids Bat Finder",
	description = "Tracks which chests need to be searched for bats and which poison",
	tags = {"overlay", "skilling", "raid"}
)
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

	@Getter
	private final Map<WorldPoint, ThievingChest> chests = new HashMap<>();

	@Getter
	private Instant lastActionTime = Instant.ofEpochMilli(0);

	private WorldPoint lastTickLocalPlayerLocation;

	private boolean inRaidChambers;

	@Getter
	private boolean batsFound;

	@Provides
	RaidsThievingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RaidsThievingConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		overlay.updateConfig();
		reset();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		lastActionTime = Instant.ofEpochMilli(0);
		chests.clear();
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject obj = event.getGameObject();
		WorldPoint loc = obj.getWorldLocation();
		switch (obj.getId())
		{
			case RaidsThievingConstants.CLOSED_CHEST_ID:
				// Found an empty chest
				if (!chests.containsKey(loc))
				{
					log.debug(MessageFormat.format("Found a new chest at {0}, {1}",
						event.getTile().getLocalLocation().getX(), event.getTile().getLocalLocation().getY()));
					chests.put(loc, new ThievingChest(obj));
				}
				break;

			case RaidsThievingConstants.OPEN_EMPTY_CHEST:
				log.debug(MessageFormat.format("Found empty chest with Bats or Poison at {0}, {1}",
					event.getTile().getLocalLocation().getX(), event.getTile().getLocalLocation().getY()));
				chests.get(loc).setEverOpened(true);

				for (Iterator<Map.Entry<WorldPoint, ThievingChest>> it = getChests().entrySet().iterator(); it.hasNext(); )
				{
					Map.Entry<WorldPoint, ThievingChest> entry = it.next();
					ThievingChest chest = entry.getValue();
					if (chest != null)
					{
						if (chest.isEmpty() && !chest.isPoison())
						{
							log.debug("Found bats!");
							batsFound = true;
						}
					}
				}
				break;
			case RaidsThievingConstants.OPEN_FULL_CHEST_1:
			case RaidsThievingConstants.OPEN_FULL_CHEST_2:
				log.debug(MessageFormat.format("Found full chest at {0}, {1}",
					event.getTile().getLocalLocation().getX(), event.getTile().getLocalLocation().getY()));
				chests.get(loc).setEverOpened(true);
				break;
		}
	}

	@Subscribe
	public void onGraphicObjectCreated(GraphicsObjectCreated event)
	{
		GraphicsObject obj = event.getGraphicsObject();
		if (obj.getId() == 184)
		{
			log.debug("Found poison splat");
			WorldPoint loc = WorldPoint.fromLocal(client, obj.getLocation());
			chests.get(loc).setPoison(true);
		}
	}

	@Subscribe
	public void onVarbitChange(VarbitChanged event)
	{
		boolean setting = client.getVar(Varbits.IN_RAID) == 1;

		if (inRaidChambers != setting)
		{
			inRaidChambers = setting;
			reset();
		}

	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("raidsthievingplugin"))
		{
			overlay.updateConfig();
		}
	}

	private void reset()
	{
		chests.clear();
		batsFound = false;
	}
}
