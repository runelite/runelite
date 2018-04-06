/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.devtools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class BorderOverlay extends Overlay
{
	private static final Color MAP_SQUARE_COLOR = Color.GREEN;
	private static final Color CHUNK_BORDER_COLOR = Color.BLUE;

	private static final int LOCAL_TILE_SIZE = Perspective.LOCAL_TILE_SIZE;
	private static final int CHUNK_SIZE = 8;
	private static final int MAP_SQUARE_SIZE = CHUNK_SIZE * CHUNK_SIZE; // 64
	private static final int CULL_RANGE = 16;
	private static final int STROKE_WIDTH = 4;

	private final Client client;
	private final DevToolsPlugin plugin;

	@Inject
	public BorderOverlay(Client client, DevToolsPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isToggleChunkBorders())
		{
			renderChunkBorders(graphics);
		}

		if (plugin.isToggleMapSquares())
		{
			renderMapSquares(graphics);
		}

		return null;
	}

	private void renderChunkBorders(Graphics2D graphics)
	{
		WorldPoint wp = client.getLocalPlayer().getWorldLocation();
		int startX = (wp.getX() - CULL_RANGE + CHUNK_SIZE - 1) / CHUNK_SIZE * CHUNK_SIZE;
		int startY = (wp.getY() - CULL_RANGE + CHUNK_SIZE - 1) / CHUNK_SIZE * CHUNK_SIZE;
		int endX = (wp.getX() + CULL_RANGE) / CHUNK_SIZE * CHUNK_SIZE;
		int endY = (wp.getY() + CULL_RANGE) / CHUNK_SIZE * CHUNK_SIZE;

		graphics.setStroke(new BasicStroke(STROKE_WIDTH));
		graphics.setColor(CHUNK_BORDER_COLOR);

		GeneralPath path = new GeneralPath();
		for (int x = startX; x <= endX; x += CHUNK_SIZE)
		{
			LocalPoint lp1 = LocalPoint.fromWorld(client, x, wp.getY() - CULL_RANGE);
			LocalPoint lp2 = LocalPoint.fromWorld(client, x, wp.getY() + CULL_RANGE);

			boolean first = true;
			for (int y = lp1.getY(); y <= lp2.getY(); y += LOCAL_TILE_SIZE)
			{
				Point p = Perspective.worldToCanvas(client,
					lp1.getX() - LOCAL_TILE_SIZE / 2,
					y - LOCAL_TILE_SIZE / 2,
					client.getPlane());
				if (p != null)
				{
					if (first)
					{
						path.moveTo(p.getX(), p.getY());
						first = false;
					}
					else
					{
						path.lineTo(p.getX(), p.getY());
					}
				}
			}
		}
		for (int y = startY; y <= endY; y += CHUNK_SIZE)
		{
			LocalPoint lp1 = LocalPoint.fromWorld(client, wp.getX() - CULL_RANGE, y);
			LocalPoint lp2 = LocalPoint.fromWorld(client, wp.getX() + CULL_RANGE, y);

			boolean first = true;
			for (int x = lp1.getX(); x <= lp2.getX(); x += LOCAL_TILE_SIZE)
			{
				Point p = Perspective.worldToCanvas(client,
					x - LOCAL_TILE_SIZE / 2,
					lp1.getY() - LOCAL_TILE_SIZE / 2,
					client.getPlane());
				if (p != null)
				{
					if (first)
					{
						path.moveTo(p.getX(), p.getY());
						first = false;
					}
					else
					{
						path.lineTo(p.getX(), p.getY());
					}
				}
			}
		}
		graphics.draw(path);
	}

	private void renderMapSquares(Graphics2D graphics)
	{
		WorldPoint wp = client.getLocalPlayer().getWorldLocation();
		int startX = (wp.getX() - CULL_RANGE + MAP_SQUARE_SIZE - 1) / MAP_SQUARE_SIZE * MAP_SQUARE_SIZE;
		int startY = (wp.getY() - CULL_RANGE + MAP_SQUARE_SIZE - 1) / MAP_SQUARE_SIZE * MAP_SQUARE_SIZE;
		int endX = (wp.getX() + CULL_RANGE) / MAP_SQUARE_SIZE * MAP_SQUARE_SIZE;
		int endY = (wp.getY() + CULL_RANGE) / MAP_SQUARE_SIZE * MAP_SQUARE_SIZE;

		graphics.setStroke(new BasicStroke(STROKE_WIDTH));
		graphics.setColor(MAP_SQUARE_COLOR);

		GeneralPath path = new GeneralPath();
		for (int x = startX; x <= endX; x += MAP_SQUARE_SIZE)
		{
			LocalPoint lp1 = LocalPoint.fromWorld(client, x, wp.getY() - CULL_RANGE);
			LocalPoint lp2 = LocalPoint.fromWorld(client, x, wp.getY() + CULL_RANGE);

			boolean first = true;
			for (int y = lp1.getY(); y <= lp2.getY(); y += LOCAL_TILE_SIZE)
			{
				Point p = Perspective.worldToCanvas(client,
					lp1.getX() - LOCAL_TILE_SIZE / 2,
					y - LOCAL_TILE_SIZE / 2,
					client.getPlane());
				if (p != null)
				{
					if (first)
					{
						path.moveTo(p.getX(), p.getY());
						first = false;
					}
					else
					{
						path.lineTo(p.getX(), p.getY());
					}
				}
			}
		}
		for (int y = startY; y <= endY; y += MAP_SQUARE_SIZE)
		{
			LocalPoint lp1 = LocalPoint.fromWorld(client, wp.getX() - CULL_RANGE, y);
			LocalPoint lp2 = LocalPoint.fromWorld(client, wp.getX() + CULL_RANGE, y);

			boolean first = true;
			for (int x = lp1.getX(); x <= lp2.getX(); x += LOCAL_TILE_SIZE)
			{
				Point p = Perspective.worldToCanvas(client,
					x - LOCAL_TILE_SIZE / 2,
					lp1.getY() - LOCAL_TILE_SIZE / 2,
					client.getPlane());
				if (p != null)
				{
					if (first)
					{
						path.moveTo(p.getX(), p.getY());
						first = false;
					}
					else
					{
						path.lineTo(p.getX(), p.getY());
					}
				}
			}
		}
		graphics.draw(path);
	}

}
