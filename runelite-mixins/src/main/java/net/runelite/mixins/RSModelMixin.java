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
import net.runelite.rs.api.RSFrame;
import net.runelite.rs.api.RSFrameMap;
import net.runelite.rs.api.RSFrames;
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

	@Inject
	public void interpolateFrames(RSFrames frames, int frameId, RSFrames nextFrames, int nextFrameId, int interval,
										int intervalCount)
	{
		if (getVertexGroups() != null)
		{
			if (frameId != -1)
			{
				RSFrame frame = frames.getFrames()[frameId];
				RSFrameMap skin = frame.getSkin();
				RSFrame nextFrame = null;
				if (nextFrames != null)
				{
					nextFrame = nextFrames.getFrames()[nextFrameId];
					if (nextFrame.getSkin() != skin)
					{
						nextFrame = null;
					}
				}

				client.setAnimOffsetX(0);
				client.setAnimOffsetY(0);
				client.setAnimOffsetZ(0);

				interpolateFrames(skin, frame, nextFrame, interval, intervalCount);
				resetBounds();
			}
		}
	}

	@Inject
	public void interpolateFrames(RSFrameMap skin, RSFrame frame, RSFrame nextFrame, int interval, int intervalCount)
	{
		if (nextFrame == null || interval == 0)
		{
			// if there is no next frame or interval then animate the model as we normally would
			for (int i = 0; i < frame.getTransformCount(); i++)
			{
				int type = frame.getTransformTypes()[i];
				this.animate(skin.getTypes()[type], skin.getList()[type], frame.getTranslatorX()[i],
						frame.getTranslatorY()[i], frame.getTranslatorZ()[i]);
			}
		}
		else
		{
			int transformIndex = 0;
			int nextTransformIndex = 0;
			for (int i = 0; i < skin.getCount(); i++)
			{
				boolean frameValid = false;
				if (transformIndex < frame.getTransformCount()
						&& frame.getTransformTypes()[transformIndex] == i)
				{
					frameValid = true;
				}
				boolean nextFrameValid = false;
				if (nextTransformIndex < nextFrame.getTransformCount()
						&& nextFrame.getTransformTypes()[nextTransformIndex] == i)
				{
					nextFrameValid = true;
				}
				if (frameValid || nextFrameValid)
				{
					int staticFrame = 0;
					int type = skin.getTypes()[i];
					if (type == 3 || type == 10)
					{
						staticFrame = 128;
					}
					int currentTranslateX = staticFrame;
					int currentTranslateY = staticFrame;
					int currentTranslateZ = staticFrame;
					if (frameValid)
					{
						currentTranslateX = frame.getTranslatorX()[transformIndex];
						currentTranslateY = frame.getTranslatorY()[transformIndex];
						currentTranslateZ = frame.getTranslatorZ()[transformIndex];
						transformIndex++;
					}
					int nextTranslateX = staticFrame;
					int nextTranslateY = staticFrame;
					int nextTranslateZ = staticFrame;
					if (nextFrameValid)
					{
						nextTranslateX = nextFrame.getTranslatorX()[nextTransformIndex];
						nextTranslateY = nextFrame.getTranslatorY()[nextTransformIndex];
						nextTranslateZ = nextFrame.getTranslatorZ()[nextTransformIndex];
						nextTransformIndex++;
					}
					int translateX;
					int translateY;
					int translateZ;
					if (type == 2)
					{
						int deltaX = nextTranslateX - currentTranslateX & 0x3fff;
						int deltaY = nextTranslateY - currentTranslateY & 0x3fff;
						int deltaZ = nextTranslateZ - currentTranslateZ & 0x3fff;
						if (deltaX >= 8192)
						{
							deltaX -= 16384;
						}
						if (deltaY >= 8192)
						{
							deltaY -= 16384;
						}
						if (deltaZ >= 8192)
						{
							deltaZ -= 16384;
						}
						translateX = currentTranslateX + deltaX * interval / intervalCount & 0x3fff;
						translateY = currentTranslateY + deltaY * interval / intervalCount & 0x3fff;
						translateZ = currentTranslateZ + deltaZ * interval / intervalCount & 0x3fff;
					}
					else if (type == 5)
					{
						// don't interpolate alpha transformations
						// alpha
						translateX = currentTranslateX;
						translateY = 0;
						translateZ = 0;
					}
					else
					{
						translateX = currentTranslateX + (nextTranslateX - currentTranslateX) * interval / intervalCount;
						translateY = currentTranslateY + (nextTranslateY - currentTranslateY) * interval / intervalCount;
						translateZ = currentTranslateZ + (nextTranslateZ - currentTranslateZ) * interval / intervalCount;
					}
					// use interpolated translations to animate
					animate(type, skin.getList()[i], translateX, translateY, translateZ);
				}
			}
		}
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
