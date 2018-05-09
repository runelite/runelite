/*
 * Copyright (c) 2018, Keano Porcaro <keano.porcaro@gmail.com>
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

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.inject.Inject;
import java.awt.*;

@Slf4j
public class PyramidPlunderOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2350;

	private final Client client;
	private final PyramidPlunderPlugin plugin;


	@Inject
	public PyramidPlunderOverlay(Client client, PyramidPlunderPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics) {

		LocalPoint playerLocation = client.getLocalPlayer().getLocalLocation();
		WorldPoint playerWorldLocation = client.getLocalPlayer().getWorldLocation();



		// ROOM 1
		if (playerWorldLocation.distanceTo(new WorldPoint(1931, 4471, 0)) <= 10) {
			Polygon door1 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1931, 4471, 0)));
			Polygon door2 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1931, 4466, 0)));
			Polygon door3 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1924, 4466, 0)));
			Polygon door4 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1924, 4471, 0)));
			if (door1 != null && door2 != null && door3 != null && door4 != null)
			{
				OverlayUtil.renderPolygon(graphics, door1, Color.RED);
				OverlayUtil.renderPolygon(graphics, door2, Color.RED);
				OverlayUtil.renderPolygon(graphics, door3, Color.GREEN);
				OverlayUtil.renderPolygon(graphics, door4, Color.RED);
			}
		}

		// ROOM 2
		if (playerWorldLocation.distanceTo(new WorldPoint(1957, 4471, 0)) <= 10) {
			Polygon door1 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1957, 4471, 0)));
			Polygon door2 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1959, 4468, 0)));
			Polygon door3 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1958, 4465, 0)));
			Polygon door4 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1950, 4465, 0)));
			if (door1 != null && door2 != null && door3 != null && door4 != null)
			{
				OverlayUtil.renderPolygon(graphics, door1, Color.RED);
				OverlayUtil.renderPolygon(graphics, door2, Color.RED);
				OverlayUtil.renderPolygon(graphics, door3, Color.GREEN);
				OverlayUtil.renderPolygon(graphics, door4, Color.RED);
			}
		}

		// ROOM 3
		if (playerWorldLocation.distanceTo(new WorldPoint(1979, 4458, 0)) <= 10) {
			Polygon door1 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1979, 4458, 0)));
			Polygon door2 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1976, 4454, 0)));
			Polygon door3 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1974, 4454, 0)));
			Polygon door4 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1970, 4460, 0)));
			if (door1 != null && door2 != null && door3 != null && door4 != null)
			{
				OverlayUtil.renderPolygon(graphics, door1, Color.RED);
				OverlayUtil.renderPolygon(graphics, door2, Color.RED);
				OverlayUtil.renderPolygon(graphics, door3, Color.GREEN);
				OverlayUtil.renderPolygon(graphics, door4, Color.RED);
			}
		}

		// ROOM 4
		if (playerWorldLocation.distanceTo(new WorldPoint(1933, 4450, 0)) <= 10) {
			Polygon door1 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1933, 4450, 0)));
			Polygon door2 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1937, 4458, 0)));
			Polygon door3 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1940, 4456, 0)));
			Polygon door4 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1937, 4449, 0)));
			if (door1 != null && door2 != null && door3 != null && door4 != null)
			{
				OverlayUtil.renderPolygon(graphics, door1, Color.RED);
				OverlayUtil.renderPolygon(graphics, door2, Color.RED);
				OverlayUtil.renderPolygon(graphics, door3, Color.GREEN);
				OverlayUtil.renderPolygon(graphics, door4, Color.RED);
			}
		}

		// ROOM 5
		if (playerWorldLocation.distanceTo(new WorldPoint(1957, 4445, 0)) <= 10) {
			Polygon door1 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1957, 4445, 0)));
			Polygon door2 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1954, 4445, 0)));
			Polygon door3 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1953, 4447, 0)));
			Polygon door4 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1961, 4448, 0)));
			if (door1 != null && door2 != null && door3 != null && door4 != null)
			{
				OverlayUtil.renderPolygon(graphics, door1, Color.RED);
				OverlayUtil.renderPolygon(graphics, door2, Color.RED);
				OverlayUtil.renderPolygon(graphics, door3, Color.GREEN);
				OverlayUtil.renderPolygon(graphics, door4, Color.RED);
			}
		}

		// ROOM 6
		if (playerWorldLocation.distanceTo(new WorldPoint(1924, 4432, 0)) <= 10) {
			Polygon door1 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1924, 4432, 0)));
			Polygon door2 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1925, 4439, 0)));
			Polygon door3 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1929, 4439, 0)));
			Polygon door4 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1930, 4432, 0)));
			if (door1 != null && door2 != null && door3 != null && door4 != null)
			{
				OverlayUtil.renderPolygon(graphics, door1, Color.RED);
				OverlayUtil.renderPolygon(graphics, door2, Color.RED);
				OverlayUtil.renderPolygon(graphics, door3, Color.GREEN);
				OverlayUtil.renderPolygon(graphics, door4, Color.RED);
			}
		}

		// ROOM 7
		if (playerWorldLocation.distanceTo(new WorldPoint(1946, 4432, 0)) <= 10) {
			Polygon door1 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1946, 4432, 0)));
			Polygon door2 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1954, 4430, 0)));
			Polygon door3 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1953, 4424, 0)));
			Polygon door4 = Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, new WorldPoint(1949, 4423, 0)));
			if (door1 != null && door2 != null && door3 != null && door4 != null)
			{
				OverlayUtil.renderPolygon(graphics, door1, Color.RED);
				OverlayUtil.renderPolygon(graphics, door2, Color.RED);
				OverlayUtil.renderPolygon(graphics, door3, Color.GREEN);
				OverlayUtil.renderPolygon(graphics, door4, Color.RED);
			}
		}

		plugin.getObstaclesHull().forEach((obstacle, tile) ->
		{
			if (tile.getPlane() == client.getPlane() && obstacle.getLocalLocation().distanceTo(playerLocation) < MAX_DISTANCE)
			{
				Polygon p = tile.getGameObjects()[0].getConvexHull();
				if (p != null)
				{
					graphics.setColor(Color.CYAN);
					graphics.drawPolygon(p);
				}
			}
		});


		/*plugin.getObstaclesHull().forEach((obstacle, tile) ->
		{
			if (tile.getPlane() == client.getPlane() && obstacle.getLocalLocation().distanceTo(playerLocation) < MAX_DISTANCE)
			{

				Polygon p = tile.getGameObjects()[0].getConvexHull();
				if (p != null)
				{
					graphics.setColor(Color.CYAN);
					graphics.drawPolygon(p);
				}
			}
		});

		plugin.getObstaclesTile().forEach((obstacle, tile) ->
		{
			if (tile.getPlane() == client.getPlane() && obstacle.getLocalLocation().distanceTo(playerLocation) < MAX_DISTANCE)
			{
				Polygon p = obstacle.getCanvasTilePoly();
				if (p != null)
				{
					graphics.setColor(Color.CYAN);
					graphics.drawPolygon(p);
				}
			}
		});*/


		return null;
	}
}
