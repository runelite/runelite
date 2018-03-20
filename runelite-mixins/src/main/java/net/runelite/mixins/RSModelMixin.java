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
import java.util.ArrayList;
import java.util.List;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.api.model.Jarvis;
import net.runelite.api.model.Triangle;
import net.runelite.api.model.Vertex;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSModel;

@Mixin(RSModel.class)
public abstract class RSModelMixin implements RSModel
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Override
	@Inject
	public List<Vertex> getVertices()
	{
		int[] verticesX = getVerticesX();
		int[] verticesY = getVerticesY();
		int[] verticesZ = getVerticesZ();

		List<Vertex> vertices = new ArrayList<Vertex>();

		for (int i = 0; i < getVerticesCount(); ++i)
		{
			Vertex v = new Vertex(
				verticesX[i],
				verticesY[i],
				verticesZ[i]
			);
			vertices.add(v);
		}

		return vertices;
	}

	@Override
	@Inject
	public List<Triangle> getTriangles()
	{
		int[] trianglesX = getTrianglesX();
		int[] trianglesY = getTrianglesY();
		int[] trianglesZ = getTrianglesZ();

		List<Vertex> vertices = getVertices();
		List<Triangle> triangles = new ArrayList<Triangle>(getTrianglesCount());

		for (int i = 0; i < getTrianglesCount(); ++i)
		{
			int triangleX = trianglesX[i];
			int triangleY = trianglesY[i];
			int triangleZ = trianglesZ[i];

			Triangle triangle = new Triangle(
				vertices.get(triangleX),
				vertices.get(triangleY),
				vertices.get(triangleZ)
			);
			triangles.add(triangle);
		}

		return triangles;
	}

	@Override
	@Inject
	public Polygon getConvexHull(int localX, int localY, int orientation)
	{
		List<Vertex> vertices = getVertices();

		// rotate vertices
		for (int i = 0; i < vertices.size(); ++i)
		{
			Vertex v = vertices.get(i);
			vertices.set(i, v.rotate(orientation));
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
