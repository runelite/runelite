/*
 * Copyright (c) 2019, Benjamin <https://github.com/genetic-soybean>
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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Stroke;
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
import net.runelite.client.ui.overlay.OverlayUtil;

class GroundMarkerMinimapOverlay extends Overlay
{
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
		if (!config.drawTileOnMinimmap())
		{
			return null;
		}

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

			drawOnMinimap(graphics, worldPoint, tileColor);
		}

		return null;
	}

	private void drawOnMinimap(Graphics2D graphics, WorldPoint point, Color color)
	{
		if (!point.isInScene(client))
		{
			return;
		}

		int x = point.getX() - client.getBaseX();
		int y = point.getY() - client.getBaseY();

		x <<= Perspective.LOCAL_COORD_BITS;
		y <<= Perspective.LOCAL_COORD_BITS;

		Point mp1 = Perspective.localToMinimap(client, new LocalPoint(x, y));
		Point mp2 = Perspective.localToMinimap(client, new LocalPoint(x, y + Perspective.LOCAL_TILE_SIZE));
		Point mp3 = Perspective.localToMinimap(client, new LocalPoint(x + Perspective.LOCAL_TILE_SIZE, y + Perspective.LOCAL_TILE_SIZE));
		Point mp4 = Perspective.localToMinimap(client, new LocalPoint(x + Perspective.LOCAL_TILE_SIZE, y));

		if (mp1 == null || mp2 == null || mp3 == null || mp4 == null)
		{
			return;
		}

		Polygon poly = new Polygon();
		poly.addPoint(mp1.getX(), mp1.getY());
		poly.addPoint(mp2.getX(), mp2.getY());
		poly.addPoint(mp3.getX(), mp3.getY());
		poly.addPoint(mp4.getX(), mp4.getY());

		Stroke stroke = new BasicStroke(1f);
		graphics.setStroke(stroke);
		graphics.drawPolygon(poly);
		OverlayUtil.renderPolygon(graphics, poly, color);
	}
}
