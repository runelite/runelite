/*
 * Copyright (c) 2018, Mattias Cederlund <https://github.com/mattec92>
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
package net.runelite.client.plugins.multilines;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import static net.runelite.api.Perspective.LOCAL_TILE_SIZE;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class MultiCombatBordersOverlay extends Overlay
{

	private final Client client;
	private final MultiCombatBordersConfig config;
	private final MultiCombatBordersPlugin plugin;

	@Inject
	MultiCombatBordersOverlay(Client client, MultiCombatBordersConfig config, MultiCombatBordersPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.MED);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();

		for (MultiCombatBorder border : plugin.multiCombatBorders)
		{
			if (playerLocation.distanceTo(border.getMulti()) > 18)
			{
				continue;
			}

			WorldPoint start;
			WorldPoint end;
			int sign = 1;

			switch (border.getEdge())
			{
				case MultiCombatBorder.NORTH:
					start = border.getMulti();
					end = new WorldPoint(start.getX() + 1, start.getY(), start.getPlane());
					break;
				case MultiCombatBorder.SOUTH:
					start = border.getSingle();
					end = new WorldPoint(start.getX() + 1, start.getY(), start.getPlane());
					sign = -1;
					break;
				case MultiCombatBorder.EAST:
					start = border.getSingle();
					end = new WorldPoint(start.getX(), start.getY() - 1, start.getPlane());
					break;
				case MultiCombatBorder.WEST:
					start = border.getMulti();
					end = new WorldPoint(start.getX(), start.getY() - 1, start.getPlane());
					sign = -1;
					break;
				default:
					throw new IllegalStateException("Unknown edge type.");
			}

			LocalPoint localPointStart = LocalPoint.fromWorld(client, start);
			LocalPoint localPointEnd = LocalPoint.fromWorld(client, end);

			if (localPointStart != null && localPointEnd != null)
			{
				Polygon multiLine = linePoly(client, localPointStart, localPointEnd, 0, 0);
				Polygon singleLine = linePoly(client, localPointStart, localPointEnd, 2 * sign, 2 * sign);
				if (multiLine != null && singleLine != null)
				{
					OverlayUtil.renderPolygon(graphics, multiLine, config.multiColor());
					OverlayUtil.renderPolygon(graphics, singleLine, config.singleColor());
				}
			}
		}

		return null;
	}

	/**
	 * Returns a polygon representing a line between two points. Top left corners.
	 */
	private Polygon linePoly(@Nonnull Client client, @Nonnull LocalPoint startLocation, @Nonnull LocalPoint endLocation, int adjustX, int adjustY)
	{
		int adjustedPointsX = adjustX * (LOCAL_TILE_SIZE / 8);
		int adjustedPointsY = adjustY * (LOCAL_TILE_SIZE / 8);

		Point startPoint = new Point(
			startLocation.getX() - (LOCAL_TILE_SIZE / 2) + adjustedPointsX,
			startLocation.getY() + (LOCAL_TILE_SIZE / 2) + adjustedPointsY);
		Point endPoint = new Point(
			endLocation.getX() - (LOCAL_TILE_SIZE / 2) + adjustedPointsX,
			endLocation.getY() + (LOCAL_TILE_SIZE / 2) + adjustedPointsY);

		int plane = client.getPlane();

		Point p1 = Perspective.worldToCanvas(client, startPoint.getX(), startPoint.getY(), plane);
		Point p2 = Perspective.worldToCanvas(client, endPoint.getX(), endPoint.getY(), plane);

		if (p1 != null && p2 != null)
		{
			Polygon polygon = new Polygon();
			polygon.addPoint(p1.getX(), p1.getY());
			polygon.addPoint(p2.getX(), p2.getY());
			return polygon;
		}

		return null;
	}

}
