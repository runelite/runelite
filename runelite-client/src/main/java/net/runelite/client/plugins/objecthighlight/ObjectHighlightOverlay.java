/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Cas <https://github.com/casvandongen>
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
package net.runelite.client.plugins.objecthighlight;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.plugins.agility.AgilityConfig;
import net.runelite.client.plugins.agility.AgilityPlugin;
import net.runelite.client.plugins.agility.Obstacles;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.inject.Inject;
import java.awt.*;
import java.awt.geom.Area;

@Slf4j
public class ObjectHighlightOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2350;

	private final Client client;
	private final ObjectHighlightPlugin plugin;
	private int red;
	private int green;
	private int blue;
	private Color color;

	@Inject
	public ObjectHighlightOverlay(Client client, ObjectHighlightPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		LocalPoint playerLocation = client.getLocalPlayer().getLocalLocation();
		Point mousePosition = client.getMouseCanvasPosition();
		plugin.getObstacles().forEach((object, tile) ->
		{
			if (tile.getPlane() == client.getPlane()
				&& object.getLocalLocation().distanceTo(playerLocation) < MAX_DISTANCE)
			{
				// HIGHLIGHT TRAPS
				Area objectClickbox = object.getClickbox();
				boolean proceed = false;
				if (objectClickbox != null)
				{
					//if (objectClickbox.contains(mousePosition.getX(), mousePosition.getY()))
					//{
					//}

					// Lumby Castle Stairs, Pure red
					if (object.getId() == 16672 || object.getId() == 16673)
					{
						// Do another check for location (only want northern stairs)
						if (object.getY() == 6912 || object.getY() == 6848) {
							color = new Color(255, 0, 0, 255);
							proceed = true;
						}
					}
					// Lumby Castle West Bank Booth, Pure Blue
					else if (object.getId() == 18491)
					{
						color = new Color(0, 0, 255, 255);
						proceed = true;
					}
					// Lumby Castle East Bank Booth, Pure Green
					else if (object.getId() == 27291)
					{
						color = new Color(0, 255, 0, 255);
						proceed = true;
					}
					// Duke's Door Closed, pure green
					else if (object.getId() == 1543 && object.getY() == 5952)
					{
						color = new Color(0, 255, 0, 255);
						proceed = true;
					}

					if (proceed)
					{
						graphics.draw(objectClickbox);
						graphics.setColor(color);
						graphics.fill(objectClickbox);
					}
					// Overlay stuff on object for debugging
					if (false)
					{
						String name = String.valueOf(object.getWorldLocation());
						String x_c = String.valueOf(object.getX());
						String y_c = String.valueOf(object.getY());
						name = name + ", " + x_c + ", " + y_c;
						Point textLocation = object.getCanvasTextLocation(graphics, name, 40);
						OverlayUtil.renderTextLocation(graphics, textLocation, name, Color.GREEN);
					}
				}
			}
		});
		return null;
	}

}
