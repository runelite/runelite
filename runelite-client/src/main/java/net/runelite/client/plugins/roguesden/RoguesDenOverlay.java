/*
 * Copyright (c) 2018, Shaun Dreclin <shaundreclin@gmail.com>
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
package net.runelite.client.plugins.roguesden;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

@Singleton
public class RoguesDenOverlay extends Overlay
{
	private static final Color OBJECT_BORDER_COLOR = Color.RED;
	private static final Color OBJECT_COLOR = new Color(OBJECT_BORDER_COLOR.getRed(), OBJECT_BORDER_COLOR.getGreen(), OBJECT_BORDER_COLOR.getBlue(), 50);
	private static final Color OBJECT_BORDER_HOVER_COLOR = OBJECT_BORDER_COLOR.darker();

	private final Client client;
	private final RoguesDenPlugin plugin;

	@Inject
	public RoguesDenOverlay(final Client client, final RoguesDenPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isHasGem())
		{
			return null;
		}

		plugin.getObstaclesHull().forEach((obstacle, tile) ->
		{
			if (tile.getPlane() == client.getPlane())
			{
				final Shape clickBox = obstacle.getClickbox();
				if (clickBox != null)
				{
					final Point mouse = client.getMouseCanvasPosition();
					if (clickBox.contains(mouse.getX(), mouse.getY()))
					{
						graphics.setColor(OBJECT_BORDER_HOVER_COLOR);
					}
					else
					{
						graphics.setColor(OBJECT_BORDER_COLOR);
					}

					graphics.draw(clickBox);
					graphics.setColor(OBJECT_COLOR);
					graphics.fill(clickBox);
				}
				else
				{
					Shape p;
					if (obstacle instanceof GameObject)
					{
						p = ((GameObject) obstacle).getConvexHull();
					}
					else
					{
						p = obstacle.getCanvasTilePoly();
					}

					if (p != null)
					{
						graphics.setColor(OBJECT_COLOR);
						graphics.draw(p);
					}
				}
			}
		});

		for (Obstacles.Obstacle obstacle : Obstacles.OBSTACLES)
		{
			final LocalPoint localPoint = LocalPoint.fromWorld(client, obstacle.getTile());

			if (localPoint == null || obstacle.getTile().getPlane() != client.getPlane())
			{
				continue;
			}

			if (!obstacle.getHint().isEmpty())
			{
				final Polygon polygon = Perspective.getCanvasTilePoly(client, localPoint);
				if (polygon != null)
				{
					graphics.setColor(obstacle.getTileColor());
					graphics.drawPolygon(polygon);
				}
			}

			final Point textLocation = Perspective.getCanvasTextLocation(client, graphics, localPoint, obstacle.getHint(), 0);
			if (textLocation != null)
			{
				graphics.setColor(Color.LIGHT_GRAY);
				graphics.drawString(obstacle.getHint(), textLocation.getX(), textLocation.getY());
			}
		}

		return null;
	}
}
