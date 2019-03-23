/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.groundmarkers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Collection;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

public class GroundMarkerMinimapOverlay extends Overlay
{
	private static final int MAX_DRAW_DISTANCE = 32;

	private final Client client;
	private final GroundMarkerConfig config;
	private final GroundMarkerPlugin plugin;

	@Inject
	private GroundMarkerMinimapOverlay(Client client, GroundMarkerConfig config, GroundMarkerPlugin plugin)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.LOW);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showMinimap())
		{
			return null;
		}

		// clientYaw is in JAU, convert to radians to use for rendering
		int clientYaw = client.getCameraYaw();
		double angle = (clientYaw / 1024.0f) * Math.PI;

		final Collection<ColorTileMarker> points = plugin.getPoints();
		for (final ColorTileMarker point : points)
		{
			WorldPoint worldPoint = point.getWorldPoint();
			if (worldPoint.getPlane() != client.getPlane())
			{
				continue;
			}

			Color tileColor = point.getColor();
			if (tileColor == null || !config.rememberTileColors())
			{
				// If this is an old tile which has no color, or rememberTileColors is off, use marker color
				tileColor = config.markerColor();
			}

			drawMinimapTile(graphics, worldPoint, tileColor, angle);
		}

		return null;
	}

	private void drawMinimapTile(Graphics2D graphics, WorldPoint point, Color color, double angle)
	{
		WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();

		if (point.distanceTo(playerLocation) >= MAX_DRAW_DISTANCE)
		{
			return;
		}

		LocalPoint lp = LocalPoint.fromWorld(client, point);
		if (lp == null)
		{
			return;
		}

		Point minimapPoint = Perspective.localToMinimap(client, lp);
		if (minimapPoint == null)
		{
			return;
		}

		Point centerPoint = new Point(minimapPoint.getX() + 1, minimapPoint.getY() + 1);

		int opacity = config.minimapOverlayOpacity();
		if (opacity < 0)
		{
			opacity = 0;
		}
		if (opacity > 255)
		{
			opacity = 255;
		}

		Color tileColor;
		if (client.getMouseCanvasPosition().distanceTo(centerPoint) < 2)
		{
			tileColor = new Color(255, 255, 255, opacity);
		}
		else
		{
			tileColor = new Color(color.getRed(), color.getGreen(), color.getBlue(), opacity);
		}

		graphics.setColor(tileColor);
		graphics.rotate(angle, centerPoint.getX(), centerPoint.getY());
		graphics.fillRect(centerPoint.getX() - 1, centerPoint.getY() - 3, 4, 4);
		graphics.rotate(-angle, centerPoint.getX(), centerPoint.getY());
	}
}
