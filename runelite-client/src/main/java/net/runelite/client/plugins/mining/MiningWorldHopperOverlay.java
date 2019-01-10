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
import net.runelite.api.TileObject;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;
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
			// Check if user is tracking a rock across worlds, if none selected then exit here
			return null;
		}
		MiningWorldTracker tracker = plugin.getMiningTracker();
		for (int worldID : new ArrayList<>(tracker.getTrackedWorlds().keySet()))
		{
			// Go through every world stored in the tracker
			MiningWorld world = tracker.getTrackedWorlds().get(worldID);
			for (TileObject o : new ArrayList<>(world.getRocks().keySet()))
			{
				// Go through every rock stored in this specific world
				MinedRock rock = world.getRocks().get(o);
				if (rock.asSecondsNegative() < 0 - config.trackTimeout())
				{
					// If this rock has respawned & we've passed the config defined timeout, then remove this rock
					world.getRocks().remove(o);
				}
			}
			if (world.getRocks().size() == 0)
			{
				// If every rock mined has respawned & the timeout passed, remove this world from the overlay
				tracker.getTrackedWorlds().remove(worldID);
			}
		}

		if (tracker.getTrackedWorlds().size() == 0)
		{
			// Exit here if there are no worlds left to display
			return null;
		}

		panelComponent.getChildren().clear();

		panelComponent.getChildren().add(TitleComponent.builder()
				.text("Respawn Tracker")
				.build());

		for (MiningWorld world : tracker.getTrackedWorlds().values().stream().sorted(Comparator.comparing(MiningWorld::asSeconds)).collect(Collectors.toList()))
		{
			// Go through every remaining world, if they're here it means they have a rock that has not yet respawned (or timeout not yet passed)
			int id = world.getWorld();
			// Gets the time left until the *first* tracked rock respawns in this world
			int seconds = world.asSeconds();
			if (seconds < 0)
			{
				// If it's less than zero, but not been cleared yet, we'll display 0. Default Clear time(timeout) is at -60
				seconds = 0;
			}
			// Display the world & the time left until the *first* rock respawns
			panelComponent.getChildren().add(LineComponent.builder()
				.left("World " + id)
				.right(Integer.toString(seconds))
				.rightColor(seconds == 0 ? Color.GREEN : Color.ORANGE)
				.build());
		}

		return panelComponent.render(graphics);
	}

}
