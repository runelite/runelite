/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.mixins;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import net.runelite.api.Model;
import net.runelite.api.Perspective;
import static net.runelite.api.Perspective.LOCAL_COORD_BITS;
import net.runelite.api.Point;
import net.runelite.api.TileObject;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Mixins;
import net.runelite.api.mixins.Shadow;
import net.runelite.api.model.Jarvis;
import net.runelite.api.model.Vertex;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSDecorativeObject;
import net.runelite.rs.api.RSGameObject;
import net.runelite.rs.api.RSGroundObject;
import net.runelite.rs.api.RSItemLayer;
import net.runelite.rs.api.RSWallObject;

@Mixins({
	@Mixin(RSDecorativeObject.class),
	@Mixin(RSGameObject.class),
	@Mixin(RSGroundObject.class),
	@Mixin(RSItemLayer.class),
	@Mixin(RSWallObject.class)
})
public abstract class TileObjectMixin implements TileObject
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Override
	@Inject
	public int getId()
	{
		int hash = getHash();
		return hash >> 14 & 32767;
	}

	@Override
	@Inject
	public Point getWorldLocation()
	{
		Point localLocation = getLocalLocation();
		return Perspective.localToWorld(client, localLocation);
	}

	@Override
	@Inject
	public Point getLocalLocation()
	{
		return new Point(getX(), getY());
	}

	@Override
	@Inject
	public Point getRegionLocation()
	{
		Point locaLocation = getLocalLocation();
		return new Point(locaLocation.getX() >>> LOCAL_COORD_BITS, locaLocation.getY() >>> LOCAL_COORD_BITS);
	}

	@Override
	@Inject
	public Point getCanvasLocation()
	{
		Point locaLocation = getLocalLocation();
		return Perspective.worldToCanvas(client, locaLocation.getX(), locaLocation.getY(), 0);
	}

	@Override
	@Inject
	public Polygon getCanvasTilePoly()
	{
		return Perspective.getCanvasTilePoly(client, getLocalLocation());
	}

	@Override
	@Inject
	public Point getCanvasTextLocation(Graphics2D graphics, String text, int zOffset)
	{
		return Perspective.getCanvasTextLocation(client, graphics, getLocalLocation(), text, zOffset);
	}

	@Override
	@Inject
	public Point getMinimapLocation()
	{
		return Perspective.worldToMiniMap(client, getX(), getY());
	}

	@Override
	@Inject
	public Polygon getConvexHull(Model model, int orientation)
	{
		int localX = getX();
		int localY = getY();

		// models are orientated north (1024) and there are 2048 angles total
		orientation = (orientation + 1024) % 2048;

		List<Vertex> vertices = model.getVertices();

		if (orientation != 0)
		{
			// rotate vertices
			for (int i = 0; i < vertices.size(); ++i)
			{
				Vertex v = vertices.get(i);
				vertices.set(i, v.rotate(orientation));
			}
		}

		List<Point> points = new ArrayList<Point>();

		for (Vertex v : vertices)
		{
			// Compute canvas location of vertex
			Point p = Perspective.worldToCanvas(client,
				localX - v.getX(),
				localY - v.getZ(),
				-v.getY());
			if (p != null)
			{
				points.add(p);
			}
		}

		// Run Jarvis march algorithm
		points = Jarvis.convexHull(points);
		if (points == null)
		{
			return null;
		}

		// Convert to a polygon
		Polygon p = new Polygon();
		for (Point point : points)
		{
			p.addPoint(point.getX(), point.getY());
		}

		return p;
	}
}
