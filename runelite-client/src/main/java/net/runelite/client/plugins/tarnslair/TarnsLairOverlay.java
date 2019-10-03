/*
 * Copyright (c) 2018, Shaun Dreclin <https://github.com/ShaunDreclin>
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
package net.runelite.client.plugins.tarnslair;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

@Singleton
@Slf4j
public class TarnsLairOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2350;

	private final Client client;
	private final TarnsLairPlugin plugin;

	@Inject
	public TarnsLairOverlay(final Client client, final TarnsLairPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInLair())
		{
			return null;
		}

		LocalPoint playerLocation = client.getLocalPlayer().getLocalLocation();

		plugin.getStaircases().forEach((obstacle, tile) ->
		{
			if (tile.getPlane() == client.getPlane() && obstacle.getLocalLocation().distanceTo(playerLocation) < MAX_DISTANCE)
			{
				Shape p = tile.getGameObjects()[0].getConvexHull();
				if (p != null)
				{
					graphics.setColor(Color.GREEN);
					graphics.draw(p);
				}
			}
		});

		plugin.getWallTraps().forEach((obstacle, tile) ->
		{
			if (tile.getPlane() == client.getPlane() && obstacle.getLocalLocation().distanceTo(playerLocation) < MAX_DISTANCE)
			{
				Shape p = tile.getGameObjects()[0].getConvexHull();
				if (p != null)
				{
					graphics.setColor(Color.CYAN);
					graphics.draw(p);
				}
			}
		});

		plugin.getFloorTraps().forEach((obstacle, tile) ->
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
		});

		return null;
	}
}
