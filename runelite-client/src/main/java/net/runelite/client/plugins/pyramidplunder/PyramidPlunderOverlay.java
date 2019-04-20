/*
 * Copyright (c) 2018, Steffen Hauge <steffen.oerum.hauge@hotmail.com>
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
package net.runelite.client.plugins.pyramidplunder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ObjectComposition;
import static net.runelite.api.ObjectID.SPEARTRAP_21280;
import static net.runelite.api.ObjectID.TOMB_DOOR_20948;
import static net.runelite.api.ObjectID.TOMB_DOOR_20949;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class PyramidPlunderOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2400;
	private static final Color COLOR_DOOR = Color.GREEN;
	private static final Color COLOR_SPEAR_TRAP = Color.ORANGE;

	private final Client client;
	private final PyramidPlunderPlugin plugin;
	private final PyramidPlunderConfig config;

	@Inject
	private PyramidPlunderOverlay(Client client, PyramidPlunderPlugin plugin, PyramidPlunderConfig config)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}
	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInGame())
		{
			return null;
		}

		LocalPoint playerLocation = client.getLocalPlayer().getLocalLocation();
		Point mousePosition = client.getMouseCanvasPosition();

		plugin.getObstacles().forEach((object, tile) ->
		{
			if (Obstacles.WALL_OBSTACLE_IDS.contains(object.getId()) && !config.highlightDoors() ||
				Obstacles.TRAP_OBSTACLE_IDS.contains(object.getId()) && !config.highlightSpearTrap())
			{
				return;
			}

			if (tile.getPlane() == client.getPlane() &&
				object.getLocalLocation().distanceTo(playerLocation) < MAX_DISTANCE)
			{
				int objectID = object.getId();
				if (Obstacles.WALL_OBSTACLE_IDS.contains(object.getId()))
				{
					//Impostor
					ObjectComposition comp = client.getObjectDefinition(objectID);
					ObjectComposition impostor = comp.getImpostor();

					if (impostor == null)
					{
						return;
					}
					objectID = impostor.getId();
				}

				Area objectClickbox = object.getClickbox();
				if (objectClickbox != null)
				{
					Color configColor = Color.GREEN;
					switch (objectID)
					{
						case SPEARTRAP_21280:
							configColor = COLOR_SPEAR_TRAP;
							break;
						case TOMB_DOOR_20948:
						case TOMB_DOOR_20949:
							configColor = COLOR_DOOR;
							break;
					}

					if (objectClickbox.contains(mousePosition.getX(), mousePosition.getY()))
					{
						graphics.setColor(configColor.darker());
					}
					else
					{
						graphics.setColor(configColor);
					}

					graphics.draw(objectClickbox);
					graphics.setColor(new Color(configColor.getRed(), configColor.getGreen(), configColor.getBlue(), 50));
					graphics.fill(objectClickbox);
				}
			}
		});

		return null;
	}
}
