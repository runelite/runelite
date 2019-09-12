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
import net.runelite.api.Model;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.api.model.Jarvis;
import net.runelite.api.model.Triangle;
import net.runelite.api.model.Vertex;
import net.runelite.rs.api.RSAnimation;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSFrames;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSSkeleton;

@Mixin(RSModel.class)
public abstract class RSModelMixin implements RSModel
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private int rl$sceneId;

	@Inject
	private int rl$bufferOffset;

	@Inject
	private int rl$uvBufferOffset;

	@Inject
	private float[][] rl$faceTextureUCoordinates;

	@Inject
	private float[][] rl$faceTextureVCoordinates;

	@MethodHook(value = "<init>", end = true)
	@Inject
	public void rl$init(RSModel[] models, int length)
	{
		int count = 0;
		for (int i = 0; i < length; ++i)
		{
			RSModel model = models[i];
			if (model != null)
			{
				count += model.getTrianglesCount();
			}
		}

		float[][] u = new float[count][];
		float[][] v = new float[count][];
		int idx = 0;

		for (int i = 0; i < length; ++i)
		{
			RSModel model = models[i];
			if (model != null)
			{
				float[][] modelU = model.getFaceTextureUCoordinates();
				float[][] modelV = model.getFaceTextureVCoordinates();

				for (int j = 0; j < model.getTrianglesCount(); ++j)
				{
					if (modelU != null && modelV != null)
					{
						u[idx] = modelU[j];
						v[idx] = modelV[j];
					}
					++idx;
				}
			}
		}

		setFaceTextureUCoordinates(u);
		setFaceTextureVCoordinates(v);
	}

	@Override
	@Inject
	public List<Vertex> getVertices()
	{
		int[] verticesX = getVerticesX();
		int[] verticesY = getVerticesY();
		int[] verticesZ = getVerticesZ();

		List<Vertex> vertices = new ArrayList<Vertex>(getVerticesCount());

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

	@Copy("contourGround")
	public abstract Model rs$contourGround(int[][] tileHeights, int packedX, int height, int packedY, boolean copy, int contouredGround);

	@Replace("contourGround")
	public Model rl$contourGround(int[][] tileHeights, int packedX, int height, int packedY, boolean copy, int contouredGround)
	{
		// With contouredGround >= 0 lighted models are countoured, so we need to copy uvs
		Model model = rs$contourGround(tileHeights, packedX, height, packedY, copy, contouredGround);
		if (model != null && model != this)
		{
			RSModel rsModel = (RSModel) model;
			rsModel.setFaceTextureUCoordinates(rl$faceTextureUCoordinates);
			rsModel.setFaceTextureVCoordinates(rl$faceTextureVCoordinates);
		}
		return model;
	}

	@MethodHook("buildSharedModel")
	@Inject
	public void rl$buildSharedModel(boolean refTransparencies, Model sharedModel, byte[] transparencyBuffer)
	{
		// Animated models are usually a shared Model instance that is global
		RSModel rsModel = (RSModel) sharedModel;
		rsModel.setFaceTextureUCoordinates(rl$faceTextureUCoordinates);
		rsModel.setFaceTextureVCoordinates(rl$faceTextureVCoordinates);
	}

	@Inject
	public void interpolateFrames(RSFrames frames, int frameId, RSFrames nextFrames, int nextFrameId, int interval, int intervalCount)
	{
		if (getVertexGroups() != null)
		{
			if (frameId != -1)
			{
				RSAnimation frame = frames.getFrames()[frameId];
				RSSkeleton skin = frame.getSkin();
				RSAnimation nextFrame = null;
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
	public void interpolateFrames(RSSkeleton skin, RSAnimation frame, RSAnimation nextFrame, int interval, int intervalCount)
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
						int deltaX = nextTranslateX - currentTranslateX & 0xFF;
						int deltaY = nextTranslateY - currentTranslateY & 0xFF;
						int deltaZ = nextTranslateZ - currentTranslateZ & 0xFF;
						if (deltaX >= 128)
						{
							deltaX -= 256;
						}
						if (deltaY >= 128)
						{
							deltaY -= 256;
						}
						if (deltaZ >= 128)
						{
							deltaZ -= 256;
						}
						translateX = currentTranslateX + deltaX * interval / intervalCount & 0xFF;
						translateY = currentTranslateY + deltaY * interval / intervalCount & 0xFF;
						translateZ = currentTranslateZ + deltaZ * interval / intervalCount & 0xFF;
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
	public Polygon getConvexHull(int localX, int localY, int orientation, int tileHeight)
	{
		assert client.isClientThread();

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
			Point p = Perspective.localToCanvas(client,
				localX - v.getX(),
				localY - v.getZ(),
				tileHeight + v.getY());
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

	@Inject
	@Override
	public int getSceneId()
	{
		return rl$sceneId;
	}

	@Inject
	@Override
	public void setSceneId(int sceneId)
	{
		this.rl$sceneId = sceneId;
	}

	@Inject
	@Override
	public int getBufferOffset()
	{
		return rl$bufferOffset;
	}

	@Inject
	@Override
	public void setBufferOffset(int bufferOffset)
	{
		rl$bufferOffset = bufferOffset;
	}

	@Inject
	@Override
	public int getUvBufferOffset()
	{
		return rl$uvBufferOffset;
	}

	@Inject
	@Override
	public void setUvBufferOffset(int bufferOffset)
	{
		rl$uvBufferOffset = bufferOffset;
	}

	@Inject
	@Override
	public float[][] getFaceTextureUCoordinates()
	{
		return rl$faceTextureUCoordinates;
	}

	@Inject
	@Override
	public void setFaceTextureUCoordinates(float[][] faceTextureUCoordinates)
	{
		this.rl$faceTextureUCoordinates = faceTextureUCoordinates;
	}

	@Inject
	@Override
	public float[][] getFaceTextureVCoordinates()
	{
		return rl$faceTextureVCoordinates;
	}

	@Inject
	@Override
	public void setFaceTextureVCoordinates(float[][] faceTextureVCoordinates)
	{
		this.rl$faceTextureVCoordinates = faceTextureVCoordinates;
	}
}
