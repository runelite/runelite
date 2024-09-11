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
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.util.List;
import java.util.stream.Stream;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class SceneOverlay extends Overlay
{
	private static final Color MAP_SQUARE_COLOR = Color.GREEN;
	private static final Color CHUNK_BORDER_COLOR = Color.BLUE;
	private static final Color LOCAL_VALID_MOVEMENT_COLOR = new Color(141, 220, 26);
	private static final Color VALID_MOVEMENT_COLOR = new Color(73, 122, 18);
	private static final Color LINE_OF_SIGHT_COLOR = new Color(204, 42, 219);
	private static final Color INTERACTING_COLOR = Color.CYAN;

	private static final int LOCAL_TILE_SIZE = Perspective.LOCAL_TILE_SIZE;
	private static final int CHUNK_SIZE = 8;
	private static final int MAP_SQUARE_SIZE = CHUNK_SIZE * CHUNK_SIZE; // 64
	private static final int CULL_CHUNK_BORDERS_RANGE = 16;
	private static final int STROKE_WIDTH = 4;
	private static final int CULL_LINE_OF_SIGHT_RANGE = 10;
	private static final int INTERACTING_SHIFT = -16;

	private static final Polygon ARROW_HEAD = new Polygon(
		new int[]{0, -3, 3},
		new int[]{0, -5, -5},
		3
	);


	private final Client client;
	private final DevToolsPlugin plugin;

	@Inject
	public SceneOverlay(Client client, DevToolsPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getChunkBorders().isActive())
		{
			renderChunkBorders(graphics);
		}

		if (plugin.getMapSquares().isActive())
		{
			renderMapSquares(graphics);
		}

		if (plugin.getLoadingLines().isActive())
		{
			renderLoadingLines(graphics);
		}

		if (plugin.getLineOfSight().isActive())
		{
			renderLineOfSight(graphics);
		}

		if (plugin.getValidMovement().isActive())
		{
			renderValidMovement(graphics);
		}

		if (plugin.getInteracting().isActive())
		{
			renderInteracting(graphics);
		}

		return null;
	}

	private void renderChunkBorders(Graphics2D graphics)
	{
		WorldPoint wp = client.getLocalPlayer().getWorldLocation();
		int startX = (wp.getX() - CULL_CHUNK_BORDERS_RANGE + CHUNK_SIZE - 1) / CHUNK_SIZE * CHUNK_SIZE;
		int startY = (wp.getY() - CULL_CHUNK_BORDERS_RANGE + CHUNK_SIZE - 1) / CHUNK_SIZE * CHUNK_SIZE;
		int endX = (wp.getX() + CULL_CHUNK_BORDERS_RANGE) / CHUNK_SIZE * CHUNK_SIZE;
		int endY = (wp.getY() + CULL_CHUNK_BORDERS_RANGE) / CHUNK_SIZE * CHUNK_SIZE;

		graphics.setStroke(new BasicStroke(STROKE_WIDTH));
		graphics.setColor(CHUNK_BORDER_COLOR);

		GeneralPath path = new GeneralPath();
		for (int x = startX; x <= endX; x += CHUNK_SIZE)
		{
			LocalPoint lp1 = LocalPoint.fromWorld(client, x, wp.getY() - CULL_CHUNK_BORDERS_RANGE);
			LocalPoint lp2 = LocalPoint.fromWorld(client, x, wp.getY() + CULL_CHUNK_BORDERS_RANGE);

			boolean first = true;
			for (int y = lp1.getY(); y <= lp2.getY(); y += LOCAL_TILE_SIZE)
			{
				Point p = Perspective.localToCanvas(client,
					new LocalPoint(lp1.getX() - LOCAL_TILE_SIZE / 2, y - LOCAL_TILE_SIZE / 2),
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
			LocalPoint lp1 = LocalPoint.fromWorld(client, wp.getX() - CULL_CHUNK_BORDERS_RANGE, y);
			LocalPoint lp2 = LocalPoint.fromWorld(client, wp.getX() + CULL_CHUNK_BORDERS_RANGE, y);

			boolean first = true;
			for (int x = lp1.getX(); x <= lp2.getX(); x += LOCAL_TILE_SIZE)
			{
				Point p = Perspective.localToCanvas(client,
					new LocalPoint(x - LOCAL_TILE_SIZE / 2, lp1.getY() - LOCAL_TILE_SIZE / 2),
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

	private void renderLoadingLines(Graphics2D graphics)
	{
		graphics.setStroke(new BasicStroke(STROKE_WIDTH));
		graphics.setColor(CHUNK_BORDER_COLOR);

		int off = 16 * Perspective.LOCAL_TILE_SIZE;
		int max = Perspective.SCENE_SIZE * Perspective.LOCAL_TILE_SIZE;
		LocalPoint[] points =
		{
			new LocalPoint(off, off),
			new LocalPoint(off, max - off),
			new LocalPoint(max - off, max - off),
			new LocalPoint(max - off, off),
		};

		for (int i = 0; i < 4; ++i)
		{
			LocalPoint lp0 = points[i];
			LocalPoint lp1 = points[(i + 1) % 4];

			Point p0 = Perspective.localToCanvas(client, lp0, client.getPlane());
			Point p1 = Perspective.localToCanvas(client, lp1, client.getPlane());
			if (p0 != null && p1 != null)
			{
				graphics.drawLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
			}
		}
	}

	private void renderMapSquares(Graphics2D graphics)
	{
		WorldPoint wp = client.getLocalPlayer().getWorldLocation();
		int startX = (wp.getX() - CULL_CHUNK_BORDERS_RANGE + MAP_SQUARE_SIZE - 1) / MAP_SQUARE_SIZE * MAP_SQUARE_SIZE;
		int startY = (wp.getY() - CULL_CHUNK_BORDERS_RANGE + MAP_SQUARE_SIZE - 1) / MAP_SQUARE_SIZE * MAP_SQUARE_SIZE;
		int endX = (wp.getX() + CULL_CHUNK_BORDERS_RANGE) / MAP_SQUARE_SIZE * MAP_SQUARE_SIZE;
		int endY = (wp.getY() + CULL_CHUNK_BORDERS_RANGE) / MAP_SQUARE_SIZE * MAP_SQUARE_SIZE;

		graphics.setStroke(new BasicStroke(STROKE_WIDTH));
		graphics.setColor(MAP_SQUARE_COLOR);

		GeneralPath path = new GeneralPath();
		for (int x = startX; x <= endX; x += MAP_SQUARE_SIZE)
		{
			LocalPoint lp1 = LocalPoint.fromWorld(client, x, wp.getY() - CULL_CHUNK_BORDERS_RANGE);
			LocalPoint lp2 = LocalPoint.fromWorld(client, x, wp.getY() + CULL_CHUNK_BORDERS_RANGE);

			boolean first = true;
			for (int y = lp1.getY(); y <= lp2.getY(); y += LOCAL_TILE_SIZE)
			{
				Point p = Perspective.localToCanvas(client,
					new LocalPoint(lp1.getX() - LOCAL_TILE_SIZE / 2, y - LOCAL_TILE_SIZE / 2),
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
			LocalPoint lp1 = LocalPoint.fromWorld(client, wp.getX() - CULL_CHUNK_BORDERS_RANGE, y);
			LocalPoint lp2 = LocalPoint.fromWorld(client, wp.getX() + CULL_CHUNK_BORDERS_RANGE, y);

			boolean first = true;
			for (int x = lp1.getX(); x <= lp2.getX(); x += LOCAL_TILE_SIZE)
			{
				Point p = Perspective.localToCanvas(client,
					new LocalPoint(x - LOCAL_TILE_SIZE / 2, lp1.getY() - LOCAL_TILE_SIZE / 2),
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

	private void renderTileIfValidForMovement(Graphics2D graphics, Actor actor, int dx, int dy)
	{
		WorldArea area = actor.getWorldArea();
		if (area == null)
		{
			return;
		}

		if (area.canTravelInDirection(client.getTopLevelWorldView(), dx, dy))
		{
			LocalPoint lp = actor.getLocalLocation();
			if (lp == null)
			{
				return;
			}

			lp = new LocalPoint(
				lp.getX() + dx * Perspective.LOCAL_TILE_SIZE + dx * Perspective.LOCAL_TILE_SIZE * (area.getWidth() - 1) / 2,
				lp.getY() + dy * Perspective.LOCAL_TILE_SIZE + dy * Perspective.LOCAL_TILE_SIZE * (area.getHeight() - 1) / 2);

			Polygon poly = Perspective.getCanvasTilePoly(client, lp);
			if (poly == null)
			{
				return;
			}

			if (actor == client.getLocalPlayer())
			{
				OverlayUtil.renderPolygon(graphics, poly, LOCAL_VALID_MOVEMENT_COLOR);
			}
			else
			{
				OverlayUtil.renderPolygon(graphics, poly, VALID_MOVEMENT_COLOR);
			}
		}
	}

	private void renderValidMovement(Graphics2D graphics)
	{
		Player player = client.getLocalPlayer();
		List<NPC> npcs = client.getNpcs();
		for (NPC npc : npcs)
		{
			if (player.getInteracting() != npc && npc.getInteracting() != player)
			{
				continue;
			}
			for (int dx = -1; dx <= 1; dx++)
			{
				for (int dy = -1; dy <= 1; dy++)
				{
					if (dx == 0 && dy == 0)
					{
						continue;
					}
					renderTileIfValidForMovement(graphics, npc, dx, dy);
				}
			}
		}

		for (int dx = -1; dx <= 1; dx++)
		{
			for (int dy = -1; dy <= 1; dy++)
			{
				if (dx == 0 && dy == 0)
				{
					continue;
				}
				renderTileIfValidForMovement(graphics, player, dx, dy);
			}
		}
	}

	private void renderTileIfHasLineOfSight(Graphics2D graphics, WorldArea start, int targetX, int targetY)
	{
		WorldPoint targetLocation = new WorldPoint(targetX, targetY, start.getPlane());

		// Running the line of sight algorithm 100 times per frame doesn't
		// seem to use much CPU time, however rendering 100 tiles does
		if (start.hasLineOfSightTo(client.getTopLevelWorldView(), targetLocation))
		{
			LocalPoint lp = LocalPoint.fromWorld(client, targetLocation);
			if (lp == null)
			{
				return;
			}

			Polygon poly = Perspective.getCanvasTilePoly(client, lp);
			if (poly == null)
			{
				return;
			}

			OverlayUtil.renderPolygon(graphics, poly, LINE_OF_SIGHT_COLOR);
		}
	}

	private void renderLineOfSight(Graphics2D graphics)
	{
		WorldArea area = client.getLocalPlayer().getWorldArea();
		for (int x = area.getX() - CULL_LINE_OF_SIGHT_RANGE; x <= area.getX() + CULL_LINE_OF_SIGHT_RANGE; x++)
		{
			for (int y = area.getY() - CULL_LINE_OF_SIGHT_RANGE; y <= area.getY() + CULL_LINE_OF_SIGHT_RANGE; y++)
			{
				if (x == area.getX() && y == area.getY())
				{
					continue;
				}
				renderTileIfHasLineOfSight(graphics, area, x, y);
			}
		}
	}

	private void renderInteracting(Graphics2D graphics)
	{
		Stream.concat(
			client.getPlayers().stream(),
			client.getNpcs().stream()
		).forEach(fa ->
		{
			Actor ta = fa.getInteracting();
			if (ta == null)
			{
				return;
			}

			LocalPoint fl = fa.getLocalLocation();
			Point fs = Perspective.localToCanvas(client, fl, client.getPlane(), fa.getLogicalHeight() / 2);
			if (fs == null)
			{
				return;
			}
			int fsx = fs.getX();
			int fsy = fs.getY() - INTERACTING_SHIFT;

			LocalPoint tl = ta.getLocalLocation();
			Point ts = Perspective.localToCanvas(client, tl, client.getPlane(), ta.getLogicalHeight() / 2);
			if (ts == null)
			{
				return;
			}
			int tsx = ts.getX();
			int tsy = ts.getY() - INTERACTING_SHIFT;

			graphics.setColor(INTERACTING_COLOR);
			graphics.drawLine(fsx, fsy, tsx, tsy);

			AffineTransform t = new AffineTransform();
			t.translate(tsx, tsy);
			t.rotate(tsx - fsx, tsy - fsy);
			t.rotate(Math.PI / -2);
			AffineTransform ot = graphics.getTransform();
			graphics.setTransform(t);
			graphics.fill(ARROW_HEAD);
			graphics.setTransform(ot);

		});
	}
}
