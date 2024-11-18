/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.gpu;

import com.google.common.base.Stopwatch;
import java.io.IOException;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GroundObject;
import net.runelite.api.Model;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Projection;
import net.runelite.api.Renderable;
import net.runelite.api.Scene;
import net.runelite.api.SceneTileModel;
import net.runelite.api.SceneTilePaint;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.client.plugins.gpu.regions.Regions;

@Singleton
@Slf4j
class SceneUploader
{
	private final Client client;
	private final GpuPluginConfig gpuConfig;

	private final Regions regions;

	int sceneId = (int) System.nanoTime();
	private int offset;
	private int uvoffset;
	private int uniqueModels;

	@Inject
	SceneUploader(
		Client client,
		GpuPluginConfig config
	)
	{
		this.client = client;
		this.gpuConfig = config;

		try (var in = SceneUploader.class.getResourceAsStream("regions/regions.txt"))
		{
			regions = new Regions(in, "regions.txt");
		}
		catch (IOException ex)
		{
			throw new RuntimeException(ex);
		}
	}

	void upload(Scene scene, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer)
	{
		++sceneId;
		offset = 0;
		uvoffset = 0;
		uniqueModels = 0;
		vertexBuffer.clear();
		uvBuffer.clear();

		Stopwatch stopwatch = Stopwatch.createStarted();
		prepare(scene);
		stopwatch.stop();
		log.debug("Scene preparation time: {}", stopwatch);

		stopwatch = Stopwatch.createStarted();
		for (int z = 0; z < Constants.MAX_Z; ++z)
		{
			for (int x = 0; x < Constants.EXTENDED_SCENE_SIZE; ++x)
			{
				for (int y = 0; y < Constants.EXTENDED_SCENE_SIZE; ++y)
				{
					Tile tile = scene.getExtendedTiles()[z][x][y];
					if (tile != null)
					{
						upload(scene, tile, vertexBuffer, uvBuffer);
					}
				}
			}
		}

		stopwatch.stop();
		log.debug("Scene upload time: {} unique models: {} length: {}KB", stopwatch, uniqueModels, (offset * 16) / 1024);
	}

	private void upload(Scene scene, Tile tile, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer)
	{
		Tile bridge = tile.getBridge();
		if (bridge != null)
		{
			upload(scene, bridge, vertexBuffer, uvBuffer);
		}

		SceneTilePaint sceneTilePaint = tile.getSceneTilePaint();
		if (sceneTilePaint != null)
		{
			sceneTilePaint.setBufferOffset(offset);
			if (sceneTilePaint.getTexture() != -1)
			{
				sceneTilePaint.setUvBufferOffset(uvoffset);
			}
			else
			{
				sceneTilePaint.setUvBufferOffset(-1);
			}
			Point tilePoint = tile.getSceneLocation();
			int len = upload(scene, sceneTilePaint,
				tile.getRenderLevel(), tilePoint.getX(), tilePoint.getY(),
				vertexBuffer, uvBuffer,
				0, 0, false);
			sceneTilePaint.setBufferLen(len);
			offset += len;
			if (sceneTilePaint.getTexture() != -1)
			{
				uvoffset += len;
			}
		}

		SceneTileModel sceneTileModel = tile.getSceneTileModel();
		if (sceneTileModel != null)
		{
			sceneTileModel.setBufferOffset(offset);
			if (sceneTileModel.getTriangleTextureId() != null)
			{
				sceneTileModel.setUvBufferOffset(uvoffset);
			}
			else
			{
				sceneTileModel.setUvBufferOffset(-1);
			}
			Point tilePoint = tile.getSceneLocation();
			int len = upload(sceneTileModel,
				tilePoint.getX() << Perspective.LOCAL_COORD_BITS, tilePoint.getY() << Perspective.LOCAL_COORD_BITS,
				vertexBuffer, uvBuffer, false);
			sceneTileModel.setBufferLen(len);
			offset += len;
			if (sceneTileModel.getTriangleTextureId() != null)
			{
				uvoffset += len;
			}
		}

		WallObject wallObject = tile.getWallObject();
		if (wallObject != null)
		{
			Renderable renderable1 = wallObject.getRenderable1();
			if (renderable1 instanceof Model)
			{
				uploadSceneModel((Model) renderable1, vertexBuffer, uvBuffer);
			}

			Renderable renderable2 = wallObject.getRenderable2();
			if (renderable2 instanceof Model)
			{
				uploadSceneModel((Model) renderable2, vertexBuffer, uvBuffer);
			}
		}

		GroundObject groundObject = tile.getGroundObject();
		if (groundObject != null)
		{
			Renderable renderable = groundObject.getRenderable();
			if (renderable instanceof Model)
			{
				uploadSceneModel((Model) renderable, vertexBuffer, uvBuffer);
			}
		}

		DecorativeObject decorativeObject = tile.getDecorativeObject();
		if (decorativeObject != null)
		{
			Renderable renderable = decorativeObject.getRenderable();
			if (renderable instanceof Model)
			{
				uploadSceneModel((Model) renderable, vertexBuffer, uvBuffer);
			}

			Renderable renderable2 = decorativeObject.getRenderable2();
			if (renderable2 instanceof Model)
			{
				uploadSceneModel((Model) renderable2, vertexBuffer, uvBuffer);
			}
		}

		GameObject[] gameObjects = tile.getGameObjects();
		for (GameObject gameObject : gameObjects)
		{
			if (gameObject == null)
			{
				continue;
			}

			Renderable renderable = gameObject.getRenderable();
			if (renderable instanceof Model)
			{
				uploadSceneModel((Model) gameObject.getRenderable(), vertexBuffer, uvBuffer);
			}
		}
	}

	int upload(Scene scene, SceneTilePaint tile, int tileZ, int tileX, int tileY, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer,
		int lx, int lz, boolean stream)
	{
		tileX += GpuPlugin.SCENE_OFFSET;
		tileY += GpuPlugin.SCENE_OFFSET;

		final int[][][] tileHeights = scene.getTileHeights();
		final int swHeight = tileHeights[tileZ][tileX][tileY];
		final int seHeight = tileHeights[tileZ][tileX + 1][tileY];
		final int neHeight = tileHeights[tileZ][tileX + 1][tileY + 1];
		final int nwHeight = tileHeights[tileZ][tileX][tileY + 1];

		final int swColor = tile.getSwColor();
		final int seColor = tile.getSeColor();
		final int neColor = tile.getNeColor();
		final int nwColor = tile.getNwColor();

		if (neColor == 12345678)
		{
			return 0;
		}

		vertexBuffer.ensureCapacity(24);
		uvBuffer.ensureCapacity(24);

		// 0,0
		final int lx0 = lx;
		final int ly0 = swHeight;
		final int lz0 = lz;
		final int hsl0 = swColor;

		// 1,0
		final int lx1 = lx + Perspective.LOCAL_TILE_SIZE;
		final int ly1 = seHeight;
		final int lz1 = lz;
		final int hsl1 = seColor;

		// 1,1
		final int lx2 = lx + Perspective.LOCAL_TILE_SIZE;
		final int ly2 = neHeight;
		final int lz2 = lz + Perspective.LOCAL_TILE_SIZE;
		final int hsl2 = neColor;

		// 0,1
		final int lx3 = lx;
		final int ly3 = nwHeight;
		final int lz3 = lz + Perspective.LOCAL_TILE_SIZE;
		final int hsl3 = nwColor;

		vertexBuffer.put((float) lx2, ly2, lz2, hsl2);
		vertexBuffer.put((float) lx3, ly3, lz3, hsl3);
		vertexBuffer.put((float) lx1, ly1, lz1, hsl1);

		vertexBuffer.put((float) lx0, ly0, lz0, hsl0);
		vertexBuffer.put((float) lx1, ly1, lz1, hsl1);
		vertexBuffer.put((float) lx3, ly3, lz3, hsl3);

		if (stream || tile.getTexture() != -1)
		{
			int tex = tile.getTexture() + 1;
			if (tile.isFlat())
			{
				uvBuffer.put(tex, lx0, ly0, lz0);
				uvBuffer.put(tex, lx1, ly1, lz1);
				uvBuffer.put(tex, lx3, ly3, lz3);
			}
			else
			{
				uvBuffer.put(tex, lx2, ly2, lz2);
				uvBuffer.put(tex, lx3, ly3, lz3);
				uvBuffer.put(tex, lx1, ly1, lz1);
			}

			uvBuffer.put(tex, lx0, ly0, lz0);
			uvBuffer.put(tex, lx1, ly1, lz1);
			uvBuffer.put(tex, lx3, ly3, lz3);
		}

		return 6;
	}

	int upload(SceneTileModel sceneTileModel, int lx, int lz,
		GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer, boolean stream)
	{
		final int[] faceX = sceneTileModel.getFaceX();
		final int[] faceY = sceneTileModel.getFaceY();
		final int[] faceZ = sceneTileModel.getFaceZ();

		final int[] vertexX = sceneTileModel.getVertexX();
		final int[] vertexY = sceneTileModel.getVertexY();
		final int[] vertexZ = sceneTileModel.getVertexZ();

		final int[] triangleColorA = sceneTileModel.getTriangleColorA();
		final int[] triangleColorB = sceneTileModel.getTriangleColorB();
		final int[] triangleColorC = sceneTileModel.getTriangleColorC();

		final int[] triangleTextures = sceneTileModel.getTriangleTextureId();

		final int faceCount = faceX.length;

		vertexBuffer.ensureCapacity(faceCount * 12);
		uvBuffer.ensureCapacity(faceCount * 12);

		int cnt = 0;
		for (int i = 0; i < faceCount; ++i)
		{
			final int vertex0 = faceX[i];
			final int vertex1 = faceY[i];
			final int vertex2 = faceZ[i];

			final int hsl0 = triangleColorA[i];
			final int hsl1 = triangleColorB[i];
			final int hsl2 = triangleColorC[i];

			if (hsl0 == 12345678)
			{
				continue;
			}

			cnt += 3;

			// vertexes are stored in scene local, convert to tile local
			int lx0 = vertexX[vertex0] - lx;
			int ly0 = vertexY[vertex0];
			int lz0 = vertexZ[vertex0] - lz;

			int lx1 = vertexX[vertex1] - lx;
			int ly1 = vertexY[vertex1];
			int lz1 = vertexZ[vertex1] - lz;

			int lx2 = vertexX[vertex2] - lx;
			int ly2 = vertexY[vertex2];
			int lz2 = vertexZ[vertex2] - lz;

			vertexBuffer.put((float) lx0, ly0, lz0, hsl0);
			vertexBuffer.put((float) lx1, ly1, lz1, hsl1);
			vertexBuffer.put((float) lx2, ly2, lz2, hsl2);

			if (stream || triangleTextures != null)
			{
				if (triangleTextures != null && triangleTextures[i] != -1)
				{
					int tex = triangleTextures[i] + 1;
					if (sceneTileModel.isFlat())
					{
						uvBuffer.put(tex, vertexX[0] - lx, vertexY[0], vertexZ[0] - lz);
						uvBuffer.put(tex, vertexX[1] - lx, vertexY[1], vertexZ[1] - lz);
						uvBuffer.put(tex, vertexX[3] - lx, vertexY[3], vertexZ[3] - lz);
					}
					else
					{
						uvBuffer.put(tex, vertexX[vertex0] - lx, vertexY[vertex0], vertexZ[vertex0] - lz);
						uvBuffer.put(tex, vertexX[vertex1] - lx, vertexY[vertex1], vertexZ[vertex1] - lz);
						uvBuffer.put(tex, vertexX[vertex2] - lx, vertexY[vertex2], vertexZ[vertex2] - lz);
					}
				}
				else
				{
					uvBuffer.put(0, 0, 0, 0);
					uvBuffer.put(0, 0, 0, 0);
					uvBuffer.put(0, 0, 0, 0);
				}
			}
		}

		return cnt;
	}

	private void uploadSceneModel(Model model, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer)
	{
		// deduplicate hillskewed models
		if (model.getUnskewedModel() != null)
		{
			model = model.getUnskewedModel();
		}

		if (model.getSceneId() == sceneId)
		{
			return; // model has already been uploaded
		}

		model.setBufferOffset(offset);
		if (model.getFaceTextures() != null)
		{
			model.setUvBufferOffset(uvoffset);
		}
		else
		{
			model.setUvBufferOffset(-1);
		}
		model.setSceneId(sceneId);
		++uniqueModels;

		int len = pushModel(model, vertexBuffer, uvBuffer);

		offset += len;
		if (model.getFaceTextures() != null)
		{
			uvoffset += len;
		}
	}

	public int pushModel(Model model, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer)
	{
		final int triangleCount = Math.min(model.getFaceCount(), GpuPlugin.MAX_TRIANGLE);

		vertexBuffer.ensureCapacity(triangleCount * 12);
		uvBuffer.ensureCapacity(triangleCount * 12);

		final float[] vertexX = model.getVerticesX();
		final float[] vertexY = model.getVerticesY();
		final float[] vertexZ = model.getVerticesZ();

		final int[] indices1 = model.getFaceIndices1();
		final int[] indices2 = model.getFaceIndices2();
		final int[] indices3 = model.getFaceIndices3();

		final int[] color1s = model.getFaceColors1();
		final int[] color2s = model.getFaceColors2();
		final int[] color3s = model.getFaceColors3();

		final short[] faceTextures = model.getFaceTextures();
		final byte[] textureFaces = model.getTextureFaces();
		final int[] texIndices1 = model.getTexIndices1();
		final int[] texIndices2 = model.getTexIndices2();
		final int[] texIndices3 = model.getTexIndices3();

		final byte[] transparencies = model.getFaceTransparencies();
		final byte[] facePriorities = model.getFaceRenderPriorities();

		final byte overrideAmount = model.getOverrideAmount();
		final byte overrideHue = model.getOverrideHue();
		final byte overrideSat = model.getOverrideSaturation();
		final byte overrideLum = model.getOverrideLuminance();

		int len = 0;
		for (int face = 0; face < triangleCount; ++face)
		{
			int color1 = color1s[face];
			int color2 = color2s[face];
			int color3 = color3s[face];

			if (color3 == -1)
			{
				color2 = color3 = color1;
			}
			else if (color3 == -2)
			{
				vertexBuffer.put(0, 0, 0, 0);
				vertexBuffer.put(0, 0, 0, 0);
				vertexBuffer.put(0, 0, 0, 0);

				if (faceTextures != null)
				{
					uvBuffer.put(0, 0, 0, 0);
					uvBuffer.put(0, 0, 0, 0);
					uvBuffer.put(0, 0, 0, 0);
				}

				len += 3;
				continue;
			}

			// HSL override is not applied to textured faces
			if (faceTextures == null || faceTextures[face] == -1)
			{
				if (overrideAmount > 0)
				{
					color1 = interpolateHSL(color1, overrideHue, overrideSat, overrideLum, overrideAmount);
					color2 = interpolateHSL(color2, overrideHue, overrideSat, overrideLum, overrideAmount);
					color3 = interpolateHSL(color3, overrideHue, overrideSat, overrideLum, overrideAmount);
				}
			}

			int packAlphaPriority = packAlphaPriority(faceTextures, transparencies, facePriorities, face);

			int triangleA = indices1[face];
			int triangleB = indices2[face];
			int triangleC = indices3[face];

			vertexBuffer.put(vertexX[triangleA], vertexY[triangleA], vertexZ[triangleA], packAlphaPriority | color1);
			vertexBuffer.put(vertexX[triangleB], vertexY[triangleB], vertexZ[triangleB], packAlphaPriority | color2);
			vertexBuffer.put(vertexX[triangleC], vertexY[triangleC], vertexZ[triangleC], packAlphaPriority | color3);

			if (faceTextures != null)
			{
				if (faceTextures[face] != -1)
				{
					int texA, texB, texC;

					if (textureFaces != null && textureFaces[face] != -1)
					{
						int tface = textureFaces[face] & 0xff;
						texA = texIndices1[tface];
						texB = texIndices2[tface];
						texC = texIndices3[tface];
					}
					else
					{
						texA = triangleA;
						texB = triangleB;
						texC = triangleC;
					}

					int texture = faceTextures[face] + 1;
					uvBuffer.put(texture, vertexX[texA], vertexY[texA], vertexZ[texA]);
					uvBuffer.put(texture, vertexX[texB], vertexY[texB], vertexZ[texB]);
					uvBuffer.put(texture, vertexX[texC], vertexY[texC], vertexZ[texC]);
				}
				else
				{
					uvBuffer.put(0, 0, 0, 0);
					uvBuffer.put(0, 0, 0, 0);
					uvBuffer.put(0, 0, 0, 0);
				}
			}

			len += 3;
		}

		return len;
	}

	private static int[] distances;
	private static char[] distanceFaceCount;
	private static char[][] distanceToFaces;

	private static float[] modelCanvasX;
	private static float[] modelCanvasY;

	private static float[] modelLocalX;
	private static float[] modelLocalY;
	private static float[] modelLocalZ;

	private static int[] numOfPriority;
	private static int[] eq10;
	private static int[] eq11;
	private static int[] lt10;
	private static int[][] orderedFaces;

	void initSortingBuffers()
	{
		int MAX_VERTEX_COUNT = 6500;
		int MAX_DIAMETER = 6000;
		int ZSORT_GROUP_SIZE = 1024; // was 512
		int MAX_FACES_PER_PRIORITY = 4000; // was 2000

		distances = new int[MAX_VERTEX_COUNT];
		distanceFaceCount = new char[MAX_DIAMETER];
		distanceToFaces = new char[MAX_DIAMETER][ZSORT_GROUP_SIZE];

		modelCanvasX = new float[MAX_VERTEX_COUNT];
		modelCanvasY = new float[MAX_VERTEX_COUNT];

		modelLocalX = new float[MAX_VERTEX_COUNT];
		modelLocalY = new float[MAX_VERTEX_COUNT];
		modelLocalZ = new float[MAX_VERTEX_COUNT];

		numOfPriority = new int[12];
		eq10 = new int[MAX_FACES_PER_PRIORITY];
		eq11 = new int[MAX_FACES_PER_PRIORITY];
		lt10 = new int[12];
		orderedFaces = new int[12][MAX_FACES_PER_PRIORITY];
	}

	void releaseSortingBuffers()
	{
		distances = null;
		distanceFaceCount = null;
		distanceToFaces = null;

		modelCanvasX = null;
		modelCanvasY = null;

		modelLocalX = null;
		modelLocalY = null;
		modelLocalZ = null;

		numOfPriority = null;
		eq10 = null;
		eq11 = null;
		lt10 = null;
		orderedFaces = null;
	}

	int pushSortedModel(Projection proj, Model model, int orientation, int x, int y, int z, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer)
	{
		final int vertexCount = model.getVerticesCount();
		final float[] verticesX = model.getVerticesX();
		final float[] verticesY = model.getVerticesY();
		final float[] verticesZ = model.getVerticesZ();

		final int faceCount = model.getFaceCount();
		final int[] indices1 = model.getFaceIndices1();
		final int[] indices2 = model.getFaceIndices2();
		final int[] indices3 = model.getFaceIndices3();

		final int[] faceColors3 = model.getFaceColors3();
		final byte[] faceRenderPriorities = model.getFaceRenderPriorities();

		final int centerX = client.getCenterX();
		final int centerY = client.getCenterY();
		final int zoom = client.get3dZoom();

		float orientSine = 0;
		float orientCosine = 0;
		if (orientation != 0)
		{
			orientSine = Perspective.SINE[orientation] / 65536f;
			orientCosine = Perspective.COSINE[orientation] / 65536f;
		}

		float[] p = proj.project(x, y, z);
		int zero = (int) p[2];

		for (int v = 0; v < vertexCount; ++v)
		{
			float vertexX = verticesX[v];
			float vertexY = verticesY[v];
			float vertexZ = verticesZ[v];

			if (orientation != 0)
			{
				float x0 = vertexX;
				vertexX = vertexZ * orientSine + x0 * orientCosine;
				vertexZ = vertexZ * orientCosine - x0 * orientSine;
			}

			// move to local position
			vertexX += x;
			vertexY += y;
			vertexZ += z;

			modelLocalX[v] = vertexX;
			modelLocalY[v] = vertexY;
			modelLocalZ[v] = vertexZ;

			p = proj.project(vertexX, vertexY, vertexZ);
			modelCanvasX[v] = centerX + p[0] * zoom / p[2];
			modelCanvasY[v] = centerY + p[1] * zoom / p[2];
			distances[v] = (int) p[2] - zero;
		}

		final int diameter = model.getDiameter();
		final int radius = model.getRadius();
		if (diameter >= 6000)
		{
			return 0;
		}

		Arrays.fill(distanceFaceCount, 0, diameter, (char) 0);

		for (char i = 0; i < faceCount; ++i)
		{
			if (faceColors3[i] != -2)
			{
				final int v1 = indices1[i];
				final int v2 = indices2[i];
				final int v3 = indices3[i];

				final float
					aX = modelCanvasX[v1],
					aY = modelCanvasY[v1],
					bX = modelCanvasX[v2],
					bY = modelCanvasY[v2],
					cX = modelCanvasX[v3],
					cY = modelCanvasY[v3];

				if ((aX - bX) * (cY - bY) - (cX - bX) * (aY - bY) > 0)
				{
					int distance = radius + (distances[v1] + distances[v2] + distances[v3]) / 3;
					assert distance >= 0 && distance < diameter;
					distanceToFaces[distance][distanceFaceCount[distance]++] = i;
				}
			}
		}

		vertexBuffer.ensureCapacity(12 * faceCount);
		uvBuffer.ensureCapacity(12 * faceCount);

		int len = 0;
		if (faceRenderPriorities == null)
		{
			for (int i = diameter - 1; i >= 0; --i)
			{
				final int cnt = distanceFaceCount[i];
				if (cnt > 0)
				{
					final char[] faces = distanceToFaces[i];

					for (int faceIdx = 0; faceIdx < cnt; ++faceIdx)
					{
						final int face = faces[faceIdx];
						len += pushFace(model, face, vertexBuffer, uvBuffer);
					}
				}
			}
		}
		else
		{
			Arrays.fill(numOfPriority, 0);
			Arrays.fill(lt10, 0);

			for (int i = diameter - 1; i >= 0; --i)
			{
				final int cnt = distanceFaceCount[i];
				if (cnt > 0)
				{
					final char[] faces = distanceToFaces[i];

					for (int faceIdx = 0; faceIdx < cnt; ++faceIdx)
					{
						final int face = faces[faceIdx];
						final byte pri = faceRenderPriorities[face];
						final int distIdx = numOfPriority[pri]++;

						orderedFaces[pri][distIdx] = face;
						if (pri < 10)
						{
							lt10[pri] += i;
						}
						else if (pri == 10)
						{
							eq10[distIdx] = i;
						}
						else
						{
							eq11[distIdx] = i;
						}
					}
				}
			}

			int avg12 = 0;
			if (numOfPriority[1] > 0 || numOfPriority[2] > 0)
			{
				avg12 = (lt10[1] + lt10[2]) / (numOfPriority[1] + numOfPriority[2]);
			}

			int avg34 = 0;
			if (numOfPriority[3] > 0 || numOfPriority[4] > 0)
			{
				avg34 = (lt10[3] + lt10[4]) / (numOfPriority[3] + numOfPriority[4]);
			}

			int avg68 = 0;
			if (numOfPriority[6] > 0 || numOfPriority[8] > 0)
			{
				avg68 = (lt10[8] + lt10[6]) / (numOfPriority[8] + numOfPriority[6]);
			}

			int drawnFaces = 0;
			int numDynFaces = numOfPriority[10];
			int[] dynFaces = orderedFaces[10];
			int[] dynFaceDistances = eq10;
			if (drawnFaces == numDynFaces)
			{
				drawnFaces = 0;
				numDynFaces = numOfPriority[11];
				dynFaces = orderedFaces[11];
				dynFaceDistances = eq11;
			}

			int currFaceDistance;
			if (drawnFaces < numDynFaces)
			{
				currFaceDistance = dynFaceDistances[drawnFaces];
			}
			else
			{
				currFaceDistance = -1000;
			}

			for (int pri = 0; pri < 10; ++pri)
			{
				while (pri == 0 && currFaceDistance > avg12)
				{
					final int face = dynFaces[drawnFaces++];
					len += pushFace(model, face, vertexBuffer, uvBuffer);

					if (drawnFaces == numDynFaces && dynFaces != orderedFaces[11])
					{
						drawnFaces = 0;
						numDynFaces = numOfPriority[11];
						dynFaces = orderedFaces[11];
						dynFaceDistances = eq11;
					}

					if (drawnFaces < numDynFaces)
					{
						currFaceDistance = dynFaceDistances[drawnFaces];
					}
					else
					{
						currFaceDistance = -1000;
					}
				}

				while (pri == 3 && currFaceDistance > avg34)
				{
					final int face = dynFaces[drawnFaces++];
					len += pushFace(model, face, vertexBuffer, uvBuffer);

					if (drawnFaces == numDynFaces && dynFaces != orderedFaces[11])
					{
						drawnFaces = 0;
						numDynFaces = numOfPriority[11];
						dynFaces = orderedFaces[11];
						dynFaceDistances = eq11;
					}

					if (drawnFaces < numDynFaces)
					{
						currFaceDistance = dynFaceDistances[drawnFaces];
					}
					else
					{
						currFaceDistance = -1000;
					}
				}

				while (pri == 5 && currFaceDistance > avg68)
				{
					final int face = dynFaces[drawnFaces++];
					len += pushFace(model, face, vertexBuffer, uvBuffer);

					if (drawnFaces == numDynFaces && dynFaces != orderedFaces[11])
					{
						drawnFaces = 0;
						numDynFaces = numOfPriority[11];
						dynFaces = orderedFaces[11];
						dynFaceDistances = eq11;
					}

					if (drawnFaces < numDynFaces)
					{
						currFaceDistance = dynFaceDistances[drawnFaces];
					}
					else
					{
						currFaceDistance = -1000;
					}
				}

				final int priNum = numOfPriority[pri];
				final int[] priFaces = orderedFaces[pri];

				for (int faceIdx = 0; faceIdx < priNum; ++faceIdx)
				{
					final int face = priFaces[faceIdx];
					len += pushFace(model, face, vertexBuffer, uvBuffer);
				}
			}

			while (currFaceDistance != -1000)
			{
				final int face = dynFaces[drawnFaces++];
				len += pushFace(model, face, vertexBuffer, uvBuffer);

				if (drawnFaces == numDynFaces && dynFaces != orderedFaces[11])
				{
					drawnFaces = 0;
					dynFaces = orderedFaces[11];
					numDynFaces = numOfPriority[11];
					dynFaceDistances = eq11;
				}

				if (drawnFaces < numDynFaces)
				{
					currFaceDistance = dynFaceDistances[drawnFaces];
				}
				else
				{
					currFaceDistance = -1000;
				}
			}
		}

		return len;
	}

	private int pushFace(Model model, int face, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer)
	{
		final int[] indices1 = model.getFaceIndices1();
		final int[] indices2 = model.getFaceIndices2();
		final int[] indices3 = model.getFaceIndices3();

		final int[] faceColors1 = model.getFaceColors1();
		final int[] faceColors2 = model.getFaceColors2();
		final int[] faceColors3 = model.getFaceColors3();

		final byte overrideAmount = model.getOverrideAmount();
		final byte overrideHue = model.getOverrideHue();
		final byte overrideSat = model.getOverrideSaturation();
		final byte overrideLum = model.getOverrideLuminance();

		final short[] faceTextures = model.getFaceTextures();
		final byte[] textureFaces = model.getTextureFaces();
		final int[] texIndices1 = model.getTexIndices1();
		final int[] texIndices2 = model.getTexIndices2();
		final int[] texIndices3 = model.getTexIndices3();

		final byte[] faceRenderPriorities = model.getFaceRenderPriorities();
		final byte[] transparencies = model.getFaceTransparencies();

		final int packAlphaPriority = packAlphaPriority(faceTextures, transparencies, faceRenderPriorities, face);

		final int triangleA = indices1[face];
		final int triangleB = indices2[face];
		final int triangleC = indices3[face];

		int color1 = faceColors1[face];
		int color2 = faceColors2[face];
		int color3 = faceColors3[face];

		if (color3 == -1)
		{
			color2 = color3 = color1;
		}

		// HSL override is not applied to textured faces
		if (faceTextures == null || faceTextures[face] == -1)
		{
			if (overrideAmount > 0)
			{
				color1 = interpolateHSL(color1, overrideHue, overrideSat, overrideLum, overrideAmount);
				color2 = interpolateHSL(color2, overrideHue, overrideSat, overrideLum, overrideAmount);
				color3 = interpolateHSL(color3, overrideHue, overrideSat, overrideLum, overrideAmount);
			}
		}

		vertexBuffer.put(modelLocalX[triangleA], modelLocalY[triangleA], modelLocalZ[triangleA], packAlphaPriority | color1);
		vertexBuffer.put(modelLocalX[triangleB], modelLocalY[triangleB], modelLocalZ[triangleB], packAlphaPriority | color2);
		vertexBuffer.put(modelLocalX[triangleC], modelLocalY[triangleC], modelLocalZ[triangleC], packAlphaPriority | color3);

		if (faceTextures != null && faceTextures[face] != -1)
		{
			int texA, texB, texC;

			if (textureFaces != null && textureFaces[face] != -1)
			{
				int tfaceIdx = textureFaces[face] & 0xff;
				texA = texIndices1[tfaceIdx];
				texB = texIndices2[tfaceIdx];
				texC = texIndices3[tfaceIdx];
			}
			else
			{
				texA = triangleA;
				texB = triangleB;
				texC = triangleC;
			}

			int texture = faceTextures[face] + 1;
			uvBuffer.put(texture, modelLocalX[texA], modelLocalY[texA], modelLocalZ[texA]);
			uvBuffer.put(texture, modelLocalX[texB], modelLocalY[texB], modelLocalZ[texB]);
			uvBuffer.put(texture, modelLocalX[texC], modelLocalY[texC], modelLocalZ[texC]);
		}
		else
		{
			uvBuffer.put(0, 0, 0, 0);
			uvBuffer.put(0, 0, 0, 0);
			uvBuffer.put(0, 0, 0, 0);
		}

		return 3;
	}

	private static int packAlphaPriority(short[] faceTextures, byte[] faceTransparencies, byte[] facePriorities, int face)
	{
		int alpha = 0;
		if (faceTransparencies != null && (faceTextures == null || faceTextures[face] == -1))
		{
			alpha = (faceTransparencies[face] & 0xFF) << 24;
		}
		int priority = 0;
		if (facePriorities != null)
		{
			priority = (facePriorities[face] & 0xff) << 16;
		}
		return alpha | priority;
	}

	private static int interpolateHSL(int hsl, byte hue2, byte sat2, byte lum2, byte lerp)
	{
		int hue = hsl >> 10 & 63;
		int sat = hsl >> 7 & 7;
		int lum = hsl & 127;
		int var9 = lerp & 255;
		if (hue2 != -1)
		{
			hue += var9 * (hue2 - hue) >> 7;
		}

		if (sat2 != -1)
		{
			sat += var9 * (sat2 - sat) >> 7;
		}

		if (lum2 != -1)
		{
			lum += var9 * (lum2 - lum) >> 7;
		}

		return (hue << 10 | sat << 7 | lum) & 65535;
	}

	// remove tiles from the scene that are outside the current region
	private void prepare(Scene scene)
	{
		if (scene.isInstance() || !gpuConfig.hideUnrelatedMaps())
		{
			return;
		}

		int baseX = scene.getBaseX() / 8;
		int baseY = scene.getBaseY() / 8;
		int centerX = baseX + 6;
		int centerY = baseY + 6;
		int centerId = regions.getRegionId(centerX, centerY);

		int r = Constants.EXTENDED_SCENE_SIZE / 16;
		for (int offx = -r; offx <= r; ++offx)
		{
			for (int offy = -r; offy <= r; ++offy)
			{
				int cx = centerX + offx;
				int cy = centerY + offy;
				int id = regions.getRegionId(cx, cy);
				if (id != centerId)
				{
					removeChunk(scene, cx, cy);
				}
			}
		}
	}

	private static void removeChunk(Scene scene, int cx, int cy)
	{
		int wx = cx * 8;
		int wy = cy * 8;
		int sx = wx - scene.getBaseX();
		int sy = wy - scene.getBaseY();
		int cmsx = sx + GpuPlugin.SCENE_OFFSET;
		int cmsy = sy + GpuPlugin.SCENE_OFFSET;
		Tile[][][] tiles = scene.getExtendedTiles();
		for (int x = 0; x < 8; ++x)
		{
			for (int y = 0; y < 8; ++y)
			{
				int msx = cmsx + x;
				int msy = cmsy + y;
				if (msx >= 0 && msx < Constants.EXTENDED_SCENE_SIZE && msy >= 0 && msy < Constants.EXTENDED_SCENE_SIZE)
				{
					for (int z = 0; z < Constants.MAX_Z; ++z)
					{
						Tile tile = tiles[z][msx][msy];
						if (tile != null)
						{
							scene.removeTile(tile);
						}
					}
				}
			}
		}
	}
}
