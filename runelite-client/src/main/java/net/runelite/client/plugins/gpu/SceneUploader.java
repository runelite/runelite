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
import net.runelite.api.Renderable;
import net.runelite.api.Scene;
import net.runelite.api.SceneTileModel;
import net.runelite.api.SceneTilePaint;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;

@Singleton
@Slf4j
class SceneUploader
{
	@Inject
	private Client client;

	int sceneId = (int) System.nanoTime();
	private int offset;
	private int uvoffset;

	void upload(Scene scene, GpuIntBuffer vertexbuffer, GpuFloatBuffer uvBuffer)
	{
		Stopwatch stopwatch = Stopwatch.createStarted();

		++sceneId;
		offset = 0;
		uvoffset = 0;
		vertexbuffer.clear();
		uvBuffer.clear();

		for (int z = 0; z < Constants.MAX_Z; ++z)
		{
			for (int x = 0; x < Constants.SCENE_SIZE; ++x)
			{
				for (int y = 0; y < Constants.SCENE_SIZE; ++y)
				{
					Tile tile = scene.getTiles()[z][x][y];
					if (tile != null)
					{
						upload(tile, vertexbuffer, uvBuffer);
					}
				}
			}
		}

		stopwatch.stop();
		log.debug("Scene upload time: {}", stopwatch);
	}

	private void upload(Tile tile, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer)
	{
		Tile bridge = tile.getBridge();
		if (bridge != null)
		{
			upload(bridge, vertexBuffer, uvBuffer);
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
			int len = upload(sceneTilePaint,
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
				tilePoint.getX(), tilePoint.getY(),
				vertexBuffer, uvBuffer,
				0, 0, false);
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

	int upload(SceneTilePaint tile, int tileZ, int tileX, int tileY, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer,
		int offsetX, int offsetY, boolean padUvs)
	{
		final int[][][] tileHeights = client.getTileHeights();

		final int localX = offsetX;
		final int localY = offsetY;

		int swHeight = tileHeights[tileZ][tileX][tileY];
		int seHeight = tileHeights[tileZ][tileX + 1][tileY];
		int neHeight = tileHeights[tileZ][tileX + 1][tileY + 1];
		int nwHeight = tileHeights[tileZ][tileX][tileY + 1];

		final int neColor = tile.getNeColor();
		final int nwColor = tile.getNwColor();
		final int seColor = tile.getSeColor();
		final int swColor = tile.getSwColor();

		if (neColor == 12345678)
		{
			return 0;
		}

		vertexBuffer.ensureCapacity(24);
		uvBuffer.ensureCapacity(24);

		// 0,0
		int vertexDx = localX;
		int vertexDy = localY;
		int vertexDz = swHeight;
		final int c1 = swColor;

		// 1,0
		int vertexCx = localX + Perspective.LOCAL_TILE_SIZE;
		int vertexCy = localY;
		int vertexCz = seHeight;
		final int c2 = seColor;

		// 1,1
		int vertexAx = localX + Perspective.LOCAL_TILE_SIZE;
		int vertexAy = localY + Perspective.LOCAL_TILE_SIZE;
		int vertexAz = neHeight;
		final int c3 = neColor;

		// 0,1
		int vertexBx = localX;
		int vertexBy = localY + Perspective.LOCAL_TILE_SIZE;
		int vertexBz = nwHeight;
		final int c4 = nwColor;

		vertexBuffer.put(vertexAx, vertexAz, vertexAy, c3);
		vertexBuffer.put(vertexBx, vertexBz, vertexBy, c4);
		vertexBuffer.put(vertexCx, vertexCz, vertexCy, c2);

		vertexBuffer.put(vertexDx, vertexDz, vertexDy, c1);
		vertexBuffer.put(vertexCx, vertexCz, vertexCy, c2);
		vertexBuffer.put(vertexBx, vertexBz, vertexBy, c4);

		if (padUvs || tile.getTexture() != -1)
		{
			float tex = tile.getTexture() + 1f;
			uvBuffer.put(tex, 1.0f, 1.0f, 0f);
			uvBuffer.put(tex, 0.0f, 1.0f, 0f);
			uvBuffer.put(tex, 1.0f, 0.0f, 0f);

			uvBuffer.put(tex, 0.0f, 0.0f, 0f);
			uvBuffer.put(tex, 1.0f, 0.0f, 0f);
			uvBuffer.put(tex, 0.0f, 1.0f, 0f);
		}

		return 6;
	}

	int upload(SceneTileModel sceneTileModel, int tileX, int tileY, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer,
		int offsetX, int offsetY, boolean padUvs)
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

		int baseX = Perspective.LOCAL_TILE_SIZE * tileX;
		int baseY = Perspective.LOCAL_TILE_SIZE * tileY;

		int cnt = 0;
		for (int i = 0; i < faceCount; ++i)
		{
			final int triangleA = faceX[i];
			final int triangleB = faceY[i];
			final int triangleC = faceZ[i];

			final int colorA = triangleColorA[i];
			final int colorB = triangleColorB[i];
			final int colorC = triangleColorC[i];

			if (colorA == 12345678)
			{
				continue;
			}

			cnt += 3;

			// vertexes are stored in scene local, convert to tile local
			int vertexXA = vertexX[triangleA] - baseX;
			int vertexZA = vertexZ[triangleA] - baseY;

			int vertexXB = vertexX[triangleB] - baseX;
			int vertexZB = vertexZ[triangleB] - baseY;

			int vertexXC = vertexX[triangleC] - baseX;
			int vertexZC = vertexZ[triangleC] - baseY;

			vertexBuffer.put(vertexXA + offsetX, vertexY[triangleA], vertexZA + offsetY, colorA);
			vertexBuffer.put(vertexXB + offsetX, vertexY[triangleB], vertexZB + offsetY, colorB);
			vertexBuffer.put(vertexXC + offsetX, vertexY[triangleC], vertexZC + offsetY, colorC);

			if (padUvs || triangleTextures != null)
			{
				if (triangleTextures != null && triangleTextures[i] != -1)
				{
					float tex = triangleTextures[i] + 1f;
					uvBuffer.put(tex, vertexXA / 128f, vertexZA / 128f, 0f);
					uvBuffer.put(tex, vertexXB / 128f, vertexZB / 128f, 0f);
					uvBuffer.put(tex, vertexXC / 128f, vertexZC / 128f, 0f);
				}
				else
				{
					uvBuffer.put(0, 0, 0, 0f);
					uvBuffer.put(0, 0, 0, 0f);
					uvBuffer.put(0, 0, 0, 0f);
				}
			}
		}

		return cnt;
	}

	private void uploadSceneModel(Model model, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer)
	{
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

		final int[] vertexX = model.getVerticesX();
		final int[] vertexY = model.getVerticesY();
		final int[] vertexZ = model.getVerticesZ();

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

	private static int[] modelLocalX;
	private static int[] modelLocalY;
	private static int[] modelLocalZ;

	private static int[] numOfPriority;
	private static int[] eq10;
	private static int[] eq11;
	private static int[] lt10;
	private static int[][] orderedFaces;

	void initSortingBuffers()
	{
		int MAX_VERTEX_COUNT = 6500;
		int MAX_DIAMETER = 6000;

		distances = new int[MAX_VERTEX_COUNT];
		distanceFaceCount = new char[MAX_DIAMETER];
		distanceToFaces = new char[MAX_DIAMETER][512];

		modelCanvasX = new float[MAX_VERTEX_COUNT];
		modelCanvasY = new float[MAX_VERTEX_COUNT];

		modelLocalX = new int[MAX_VERTEX_COUNT];
		modelLocalY = new int[MAX_VERTEX_COUNT];
		modelLocalZ = new int[MAX_VERTEX_COUNT];

		numOfPriority = new int[12];
		eq10 = new int[2000];
		eq11 = new int[2000];
		lt10 = new int[12];
		orderedFaces = new int[12][2000];
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

	int pushSortedModel(Model model, int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y, int z, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer)
	{
		final int vertexCount = model.getVerticesCount();
		final int[] verticesX = model.getVerticesX();
		final int[] verticesY = model.getVerticesY();
		final int[] verticesZ = model.getVerticesZ();

		final int faceCount = model.getFaceCount();
		final int[] indices1 = model.getFaceIndices1();
		final int[] indices2 = model.getFaceIndices2();
		final int[] indices3 = model.getFaceIndices3();

		final int[] faceColors3 = model.getFaceColors3();
		final byte[] faceRenderPriorities = model.getFaceRenderPriorities();

		final int centerX = client.getCenterX();
		final int centerY = client.getCenterY();
		final int zoom = client.get3dZoom();

		final int cameraX = client.getCameraX2();
		final int cameraY = client.getCameraY2();
		final int cameraZ = client.getCameraZ2();

		// camera in model space
		int mCameraX = -x;
		int mCameraY = -y;
		int mCameraZ = -z;

		// remove camera offset from model
		x += cameraX;
		y += cameraY;
		z += cameraZ;

		int orientSine = 0;
		int orientCosine = 0;
		if (orientation != 0)
		{
			orientSine = Perspective.SINE[orientation];
			orientCosine = Perspective.COSINE[orientation];
		}

		// de-rotate model space camera because texture calculations work on the unrotated model
		{
			int iorientation = 2047 - orientation;
			int iorientSine = Perspective.SINE[iorientation];
			int iorientCosine = Perspective.COSINE[iorientation];
			int i = mCameraZ * iorientSine + mCameraX * iorientCosine >> 16;
			mCameraZ = mCameraZ * iorientCosine - mCameraX * iorientSine >> 16;
			mCameraX = i;
		}

		for (int v = 0; v < vertexCount; ++v)
		{
			int vertexX = verticesX[v];
			int vertexY = verticesY[v];
			int vertexZ = verticesZ[v];

			if (orientation != 0)
			{
				int i = vertexZ * orientSine + vertexX * orientCosine >> 16;
				vertexZ = vertexZ * orientCosine - vertexX * orientSine >> 16;
				vertexX = i;
			}

			int d = yawCos * vertexZ - vertexX * yawSin >> 16;
			d = pitchCos * d + vertexY * pitchSin >> 16;
			distances[v] = d;

			// move to local position
			vertexX += x;
			vertexY += y;
			vertexZ += z;

			modelLocalX[v] = vertexX;
			modelLocalY[v] = vertexY;
			modelLocalZ[v] = vertexZ;

			// adjust for camera
			vertexX -= cameraX;
			vertexY -= cameraY;
			vertexZ -= cameraZ;

			final float fpitchSin = pitchSin / 65536f;
			final float fpitchCos = pitchCos / 65536f;

			final float fyawSin = yawSin / 65536f;
			final float fyawCos = yawCos / 65536f;

			final float rotatedX = (vertexZ * fyawSin) + (vertexX * fyawCos);
			final float rotatedZ = (vertexZ * fyawCos) - (vertexX * fyawSin);

			final float var13 = (vertexY * fpitchCos) - (rotatedZ * fpitchSin);
			final float var12 = (vertexY * fpitchSin) + (rotatedZ * fpitchCos);

			modelCanvasX[v] = rotatedX * zoom / var12 + centerX;
			modelCanvasY[v] = var13 * zoom / var12 + centerY;
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
						len += pushFace(model, mCameraX, mCameraY, mCameraZ, face, vertexBuffer, uvBuffer);
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
					len += pushFace(model, mCameraX, mCameraY, mCameraZ, face, vertexBuffer, uvBuffer);

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
					len += pushFace(model, mCameraX, mCameraY, mCameraZ, face, vertexBuffer, uvBuffer);

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
					len += pushFace(model, mCameraX, mCameraY, mCameraZ, face, vertexBuffer, uvBuffer);

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
					len += pushFace(model, mCameraX, mCameraY, mCameraZ, face, vertexBuffer, uvBuffer);
				}
			}

			while (currFaceDistance != -1000)
			{
				final int face = dynFaces[drawnFaces++];
				len += pushFace(model, mCameraX, mCameraY, mCameraZ, face, vertexBuffer, uvBuffer);

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

	private int pushFace(Model model, int cameraX, int cameraY, int cameraZ, int face, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer)
	{
		final int[] verticesX = model.getVerticesX();
		final int[] verticesY = model.getVerticesY();
		final int[] verticesZ = model.getVerticesZ();

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
			float u0, u1, u2, v0, v1, v2;

			if (textureFaces != null && textureFaces[face] != -1)
			{
				int tfaceIdx = textureFaces[face] & 0xff;
				int texA = texIndices1[tfaceIdx];
				int texB = texIndices2[tfaceIdx];
				int texC = texIndices3[tfaceIdx];

				float f1x = verticesX[triangleA];
				float f1y = verticesY[triangleA];
				float f1z = verticesZ[triangleA];

				float f2x = verticesX[triangleB];
				float f2y = verticesY[triangleB];
				float f2z = verticesZ[triangleB];

				float f3x = verticesX[triangleC];
				float f3y = verticesY[triangleC];
				float f3z = verticesZ[triangleC];

				float t1x = verticesX[texA];
				float t1y = verticesY[texA];
				float t1z = verticesZ[texA];

				float t2x = verticesX[texB];
				float t2y = verticesY[texB];
				float t2z = verticesZ[texB];

				float t3x = verticesX[texC];
				float t3y = verticesY[texC];
				float t3z = verticesZ[texC];

				// v2 = t2 - t1
				float v2x = t2x - t1x;
				float v2y = t2y - t1y;
				float v2z = t2z - t1z;
				// v3 = t3 - t1
				float v3x = t3x - t1x;
				float v3y = t3y - t1y;
				float v3z = t3z - t1z;

				// texNormal = v2 x v3
				float texNormalx = v2y * v3z - v2z * v3y;
				float texNormaly = v2z * v3x - v2x * v3z;
				float texNormalz = v2x * v3y - v2y * v3x;

				float vertexToCamerax, vertexToCameray, vertexToCameraz;
				float f;

				// vertexToCamera = cameraPos - f1
				vertexToCamerax = cameraX - f1x;
				vertexToCameray = cameraY - f1y;
				vertexToCameraz = cameraZ - f1z;
				// f1 += vertexToCamera * ((t1 - f1) ⋅ texNormal) / (vertexToCamera ⋅ texNormal)
				f = ((t1x - f1x) * texNormalx + (t1y - f1y) * texNormaly + (t1z - f1z) * texNormalz) /
					(vertexToCamerax * texNormalx + vertexToCameray * texNormaly + vertexToCameraz * texNormalz);
				f1x += vertexToCamerax * f;
				f1y += vertexToCameray * f;
				f1z += vertexToCameraz * f;

				// vertexToCamera = cameraPos - f2
				vertexToCamerax = cameraX - f2x;
				vertexToCameray = cameraY - f2y;
				vertexToCameraz = cameraZ - f2z;
				// f2 += vertexToCamera * ((t2 - f2) ⋅ texNormal) / (vertexToCamera ⋅ texNormal)
				f = ((t2x - f2x) * texNormalx + (t2y - f2y) * texNormaly + (t2z - f2z) * texNormalz) /
					(vertexToCamerax * texNormalx + vertexToCameray * texNormaly + vertexToCameraz * texNormalz);
				f2x += vertexToCamerax * f;
				f2y += vertexToCameray * f;
				f2z += vertexToCameraz * f;

				// vertexToCamera = cameraPos - f3
				vertexToCamerax = cameraX - f3x;
				vertexToCameray = cameraY - f3y;
				vertexToCameraz = cameraZ - f3z;
				// f3 += vertexToCamera * ((t3 - f3) ⋅ texNormal) / (vertexToCamera ⋅ texNormal)
				f = ((t3x - f3x) * texNormalx + (t3y - f3y) * texNormaly + (t3z - f3z) * texNormalz) /
					(vertexToCamerax * texNormalx + vertexToCameray * texNormaly + vertexToCameraz * texNormalz);
				f3x += vertexToCamerax * f;
				f3y += vertexToCameray * f;
				f3z += vertexToCameraz * f;

				// v4 = f1 - t1
				float v4x = f1x - t1x;
				float v4y = f1y - t1y;
				float v4z = f1z - t1z;
				// v5 = f2 - t1
				float v5x = f2x - t1x;
				float v5y = f2y - t1y;
				float v5z = f2z - t1z;
				// v6 = f3 - t1
				float v6x = f3x - t1x;
				float v6y = f3y - t1y;
				float v6z = f3z - t1z;

				// v8 = v3 x texNormal
				float v8x = v3y * texNormalz - v3z * texNormaly;
				float v8y = v3z * texNormalx - v3x * texNormalz;
				float v8z = v3x * texNormaly - v3y * texNormalx;

				// f = 1 / (v8 ⋅ v2)
				f = 1.0F / (v8x * v2x + v8y * v2y + v8z * v2z);

				// u0 = (v8 ⋅ v4) * f
				u0 = (v8x * v4x + v8y * v4y + v8z * v4z) * f;
				// u1 = (v8 ⋅ v5) * f
				u1 = (v8x * v5x + v8y * v5y + v8z * v5z) * f;
				// u2 = (v8 ⋅ v6) * f
				u2 = (v8x * v6x + v8y * v6y + v8z * v6z) * f;

				// v8 = v2 x texNormal
				v8x = v2y * texNormalz - v2z * texNormaly;
				v8y = v2z * texNormalx - v2x * texNormalz;
				v8z = v2x * texNormaly - v2y * texNormalx;

				// f = 1 / (v8 ⋅ v3)
				f = 1.0F / (v8x * v3x + v8y * v3y + v8z * v3z);

				// v0 = (v8 ⋅ v4) * f
				v0 = (v8x * v4x + v8y * v4y + v8z * v4z) * f;
				// v1 = (v8 ⋅ v5) * f
				v1 = (v8x * v5x + v8y * v5y + v8z * v5z) * f;
				// v2 = (v8 ⋅ v6) * f
				v2 = (v8x * v6x + v8y * v6y + v8z * v6z) * f;
			}
			else
			{
				// Without a texture face, the client assigns tex = triangle, but the resulting
				// calculations can be reduced:
				//
				// v1 = vertex[texA]
				// v2 = vertex[texB] - v1
				// v3 = vertex[texC] - v1
				//
				// v4 = 0
				// v5 = v2
				// v6 = v3
				//
				// v7 = v2 x v3
				//
				// v8 = v3 x v7
				// u0 = (v8 . v4) / (v8 . v2) // 0 because v4 is 0
				// u1 = (v8 . v5) / (v8 . v2) // 1 because v5=v2
				// u2 = (v8 . v6) / (v8 . v2) // 0 because v8 is perpendicular to v3/v6
				//
				// v8 = v2 x v7
				// v0 = (v8 . v4) / (v8 ⋅ v3) // 0 because v4 is 0
				// v1 = (v8 . v5) / (v8 ⋅ v3) // 0 because v8 is perpendicular to v5/v2
				// v2 = (v8 . v6) / (v8 ⋅ v3) // 1 because v6=v3

				u0 = 0f;
				v0 = 0f;

				u1 = 1f;
				v1 = 0f;

				u2 = 0f;
				v2 = 1f;
			}

			int texture = faceTextures[face] + 1;
			uvBuffer.put(texture, u0, v0, 0f);
			uvBuffer.put(texture, u1, v1, 0f);
			uvBuffer.put(texture, u2, v2, 0f);
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
}
