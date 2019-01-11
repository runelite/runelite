/*
 * Copyright (c) 2018, Craftiii4 <Craftiii4@gmail.com>
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
package net.runelite.client.plugins.mining;

import net.runelite.api.Client;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Displays respawn timers on a per-world base for any rock recently mined by the player as they're hopping worlds
 */
public class MiningWorldHopperOverlay extends Overlay
{

	private final MiningConfig config;
	private final Client client;
	private final MiningPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	MiningWorldHopperOverlay(Client client, MiningPlugin plugin, MiningConfig config, SkillIconManager iconManager)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.trackWorldRock() == MiningRockType.WorldRock.None)
		{
			return null;
		}

		MiningWorldTracker tracker = plugin.getMiningTracker();
		for (int worldID : new ArrayList<>(tracker.getTrackedWorlds().keySet()))
		{
			MiningWorld world = tracker.getTrackedWorlds().get(worldID);
			for (MinedRock rock : new ArrayList<>(world.getRocks().values()))
			{
				// If this rock has respawned & we've passed the config defined timeout, then remove this rock
				if (rock.getMinSecondsUntilRespawn(true) < 0 - config.trackTimeout())
				{
					world.getRocks().inverse().remove(rock);
				}
			}
			if (world.getRocks().size() == 0)
			{
				tracker.getTrackedWorlds().remove(worldID);
			}
		}
		if (tracker.getTrackedWorlds().size() == 0)
		{
			return null;
		}

		panelComponent.getChildren().clear();
		panelComponent.getChildren().add(TitleComponent.builder()
				.text("Respawn Tracker")
				.build());

		List<MiningWorld> worlds = tracker.getTrackedWorlds().values()
				.stream()
				.sorted(Comparator.comparing(MiningWorld::getFirstSecondsUntilRespawn))
				.collect(Collectors.toList());
		for (MiningWorld world : worlds)
		{
			// Go through every remaining world, if they're here it means they have a rock that has not yet respawned (or timeout not yet passed)
			int id = world.getWorld();
			int seconds = world.getFirstSecondsUntilRespawn();
			if (seconds < 0)
			{
				// If the time left until the rock respawns is less than zero, then it means it has respawned.
				// However if it's not yet been cleared, it means the timeout has not yet passed so we still need to display this world to the user
				seconds = 0;
			}
			panelComponent.getChildren().add(LineComponent.builder()
				.left("World " + id)
				.right(Integer.toString(seconds))
				.rightColor(seconds == 0 ? Color.GREEN : Color.ORANGE)
				.build());
		}
		return panelComponent.render(graphics);
	}

}
