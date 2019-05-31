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
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.TileObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.client.ui.overlay.OverlayPosition;

/**
 * Displays respawn timers over rocks
 */
public class MiningRockOverlay extends Overlay
{

	private static final int MAX_DISTANCE = 2350;

	private final MiningConfig config;
	private final Client client;
	private final MiningPlugin plugin;

	@Inject
	MiningRockOverlay(Client client, MiningPlugin plugin, MiningConfig config, SkillIconManager iconManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Player local = client.getLocalPlayer();
		if (config.showRespawnTimer())
		{
			renderRespawnTimers(graphics, local);
		}
		return null;
	}

	private void renderRespawnTimers(Graphics2D graphics, Player local)
	{
		LocalPoint localLocation = local.getLocalLocation();
		for (TileObject ore : plugin.getOres().keySet())
		{
			MinedRock rock = plugin.getOres().get(ore);
			if ((config.showAllRespawnTimers() || plugin.getSession().showRockRespawnTimes(rock.getType())) && localLocation.distanceTo(ore.getLocalLocation()) <= MAX_DISTANCE)
			{
				// Check if we should display this rock to the user. Checks if the user has mined the rock within this session (or has all on within config) & is within range
				renderRespawnTimerRock(graphics, ore, rock.getMinSecondsUntilRespawn(false), rock.getMaxSecondsUntilRespawn(), rock.getType().isGroundObject());
			}
		}
	}

	/**
	 * Renders a rocks respawn time
	 * @param rock		The rock
	 * @param time		Time until the rock respawns (minimum)
	 * @param max		Maximum time until the rock respawns (-1 = no range)
	 * @param ground	If the rock is on the ground (true = ground, false = wall) - used to offset the respawn time text
	 */
	private void renderRespawnTimerRock(Graphics2D graphics, TileObject rock, int time, int max, boolean ground)
	{
		Point canvasLoc = Perspective.getCanvasTextLocation(client, graphics, rock.getLocalLocation(), "" + time, ground ? 0 : 150);
		if (canvasLoc != null)
		{
			String timeMessage = "" + time;
			// Check if this rock has a respawn time range
			if (max != -1)
			{
				// Check if the rock has reached the minimum respawn time
				if (time <= 0)
				{
					// Display the maximum possible time remaining
					timeMessage = "~" + max;
					graphics.setColor(Color.CYAN);
				}
				else
				{
					// Rock has not yet reached the minimum respawn time of the range
					timeMessage += "~";
				}

			}
			graphics.drawString(timeMessage, canvasLoc.getX(), canvasLoc.getY());
			graphics.setColor(Color.WHITE);
		}
	}

}
