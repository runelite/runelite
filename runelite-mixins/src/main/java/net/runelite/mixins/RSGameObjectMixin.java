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

import java.awt.Polygon;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;
import net.runelite.api.Model;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.Angle;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.api.model.Triangle;
import net.runelite.api.model.Vertex;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSEntity;
import net.runelite.rs.api.RSGameObject;
import net.runelite.rs.api.RSModel;

@Mixin(RSGameObject.class)
public abstract class RSGameObjectMixin implements RSGameObject
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	@Override
	public Point getSceneMinLocation()
	{
		return new Point(getRelativeX(), getRelativeY());
	}

	@Inject
	@Override
	public Point getSceneMaxLocation()
	{
		return new Point(getOffsetX(), getOffsetY());
	}

	@Inject
	@Override
	public RSModel getModel()
	{
		RSEntity renderable = getEntity();
		if (renderable == null)
		{
			return null;
		}

		if (renderable instanceof RSModel)
		{
			return (RSModel) renderable;
		}
		else
		{
			return renderable.getModel();
		}
	}

	@Inject
	@Override
	public Area getClickbox()
	{
		return Perspective.getClickbox(client, getModel(), getRsOrientation(), getLocalLocation());
	}

	@Inject
	@Override
	public Polygon[] getPolygons()
	{
		Model model = getModel();

		if (model == null)
		{
			return null;
		}

		int localX = getX();
		int localY = getY();

		int orientation = getRsOrientation();

		final int tileHeight = Perspective.getTileHeight(client, new LocalPoint(localX, localY), client.getPlane());

		List<Triangle> triangles = model.getTriangles();

		triangles = rotate(triangles, orientation);

		List<Polygon> polys = new ArrayList<Polygon>();
		for (Triangle triangle : triangles)
		{
			Vertex vx = triangle.getA();
			Vertex vy = triangle.getB();
			Vertex vz = triangle.getC();

			Point x = Perspective.localToCanvas(client,
				localX - vx.getX(),
				localY - vx.getZ(),
				tileHeight + vx.getY());

			Point y = Perspective.localToCanvas(client,
				localX - vy.getX(),
				localY - vy.getZ(),
				tileHeight + vy.getY());

			Point z = Perspective.localToCanvas(client,
				localX - vz.getX(),
				localY - vz.getZ(),
				tileHeight + vz.getY());

			if (x == null || y == null || z == null)
			{
				return null;
			}

			int[] xx =
				{
					x.getX(), y.getX(), z.getX()
				};
			int[] yy =
				{
					x.getY(), y.getY(), z.getY()
				};
			polys.add(new Polygon(xx, yy, 3));
		}

		return polys.toArray(new Polygon[0]);
	}

	@Inject
	private List<Triangle> rotate(List<Triangle> triangles, int orientation)
	{
		List<Triangle> rotatedTriangles = new ArrayList<Triangle>();
		for (Triangle triangle : triangles)
		{
			Vertex a = triangle.getA();
			Vertex b = triangle.getB();
			Vertex c = triangle.getC();

			Triangle rotatedTriangle = new Triangle(
				a.rotate(orientation),
				b.rotate(orientation),
				c.rotate(orientation)
			);
			rotatedTriangles.add(rotatedTriangle);
		}
		return rotatedTriangles;
	}

	@Inject
	@Override
	public Polygon getConvexHull()
	{
		RSModel model = getModel();

		if (model == null)
		{
			return null;
		}

		int tileHeight = Perspective.getTileHeight(client, new LocalPoint(getX(), getY()), client.getPlane());
		return model.getConvexHull(getX(), getY(), getRsOrientation(), tileHeight);
	}

	@Override
	@Inject
	public Angle getOrientation()
	{
		int orientation = getRsOrientation();
		int rotation = (getFlags() >> 6) & 3;
		return new Angle(rotation * 512 + orientation);
	}
}
