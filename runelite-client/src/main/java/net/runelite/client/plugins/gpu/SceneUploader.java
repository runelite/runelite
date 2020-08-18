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

import javax.inject.Inject;
import javax.inject.Singleton;
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

import java.util.ArrayList;

@Singleton
class SceneUploader
{
	@Inject
	private Client client;

	int sceneId = (int) (System.currentTimeMillis() / 1000L);

	private int offset;
	private int uvoffset;

	private int[] modelVertexArray;
	private float[] modelUvArray;
	private int modelVertexArrayOffset;
	private int modelUvArrayOffset;

	static int[] TWELVE_ZERO_INTS = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	static float[] TWELVE_ZERO_FLOATS = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	void upload(Scene scene, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer)
	{
		++sceneId;
		offset = 0;
		uvoffset = 0;
		vertexBuffer.clear();
		uvBuffer.clear();

		ArrayList<Model> models = new ArrayList<>();

		Tile[][][] tiles = scene.getTiles();

		for (int z = 0; z < Constants.MAX_Z; ++z)
		{
			Tile[][] tilesInLayer = tiles[z];
			for (int x = 0; x < Constants.SCENE_SIZE; ++x)
			{
				Tile[] tilesInRow = tilesInLayer[x];
				for (int y = 0; y < Constants.SCENE_SIZE; ++y)
				{
					Tile tile = tilesInRow[y];
					if (tile != null)
					{
						upload(tile, vertexBuffer, uvBuffer, models);
					}
				}
			}
		}

		int modelVertexArraySize = 0;
		int modelUvArraySize = 0;
		for (Model model : models)
		{
			final int modelSize = model.getTrianglesCount() * 12;
			modelVertexArraySize += modelSize;
			if (model.getFaceTextures() != null)
			{
				modelUvArraySize += modelSize;
			}
		}

		boolean vertexArrayHasBeenZeroed = false;
		if (modelVertexArray == null || modelVertexArray.length < modelVertexArraySize)
		{
			modelVertexArray = new int[modelVertexArraySize];
			vertexArrayHasBeenZeroed = true;
		}

		boolean uvArrayHasBeenZeroed = false;
		if (modelUvArray == null || modelUvArray.length < modelUvArraySize)
		{
			modelUvArray = new float[modelUvArraySize];
			uvArrayHasBeenZeroed = true;
		}

		modelVertexArrayOffset = 0;
		modelUvArrayOffset = 0;

		for (Model model : models)
		{
			uploadModel(model, vertexArrayHasBeenZeroed, uvArrayHasBeenZeroed);
		}

		vertexBuffer.ensureCapacity(modelVertexArrayOffset);
		uvBuffer.ensureCapacity(modelUvArrayOffset);

		vertexBuffer.getBuffer().put(modelVertexArray, 0, modelVertexArrayOffset);
		uvBuffer.getBuffer().put(modelUvArray, 0, modelUvArrayOffset);

		modelVertexArrayOffset = 0;
		modelUvArrayOffset = 0;
	}

	private void upload(Tile tile, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer, ArrayList<Model> models)
	{
		Tile bridge = tile.getBridge();
		if (bridge != null)
		{
			upload(bridge, vertexBuffer, uvBuffer, models);
		}

		SceneTilePaint sceneTilePaint = tile.getSceneTilePaint();
		if (sceneTilePaint != null)
		{
			sceneTilePaint.setBufferOffset(offset);
			sceneTilePaint.setUvBufferOffset(sceneTilePaint.getTexture() != -1 ? uvoffset : -1);

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
			sceneTileModel.setUvBufferOffset(sceneTileModel.getTriangleTextureId() != null ? uvoffset : -1);

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
			addModel(models, wallObject.getRenderable1());
			addModel(models, wallObject.getRenderable2());
		}

		GroundObject groundObject = tile.getGroundObject();
		if (groundObject != null)
		{
			addModel(models, groundObject.getRenderable());
		}

		DecorativeObject decorativeObject = tile.getDecorativeObject();
		if (decorativeObject != null)
		{
			addModel(models, decorativeObject.getRenderable());
			addModel(models, decorativeObject.getRenderable2());
		}

		GameObject[] gameObjects = tile.getGameObjects();
		for (GameObject gameObject : gameObjects)
		{
			if (gameObject != null)
			{
				addModel(models, gameObject.getRenderable());
			}
		}
	}

	private void addModel(ArrayList<Model> models, Renderable renderable)
	{
		if (renderable instanceof Model)
		{
			Model model = (Model) renderable;
			if (model.getSceneId() != sceneId)
			{
				models.add(model);
				model.setSceneId(sceneId);
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
					uvBuffer.put(TWELVE_ZERO_FLOATS);
				}
			}
		}

		return cnt;
	}

	private void uploadModel(Model model, boolean vertexArrayHasBeenZeroed, boolean uvArrayHasBeenZeroed)
	{
		model.setBufferOffset(offset);
		model.setUvBufferOffset(model.getFaceTextures() != null ? uvoffset : -1);

		final int triangleCount = model.getTrianglesCount();

		final int[] vertexX = model.getVerticesX();
		final int[] vertexY = model.getVerticesY();
		final int[] vertexZ = model.getVerticesZ();

		final int[] trianglesX = model.getTrianglesX();
		final int[] trianglesY = model.getTrianglesY();
		final int[] trianglesZ = model.getTrianglesZ();

		final int[] color1s = model.getFaceColors1();
		final int[] color2s = model.getFaceColors2();
		final int[] color3s = model.getFaceColors3();

		final short[] faceTextures = model.getFaceTextures();

		float[][] u = model.getFaceTextureUCoordinates();
		float[][] v = model.getFaceTextureVCoordinates();

		for (int i = 0; i < triangleCount; ++i)
		{
			int color1 = color1s[i];
			int color2 = color2s[i];
			int color3 = color3s[i];

			if (color3 == -1)
			{
				color2 = color3 = color1;
			}
			else if (color3 == -2)
			{
				if (!vertexArrayHasBeenZeroed)
				{
					System.arraycopy(TWELVE_ZERO_INTS, 0, modelVertexArray, modelVertexArrayOffset, 12);
				}
				modelVertexArrayOffset += 12;
				if (faceTextures != null)
				{
					if (!uvArrayHasBeenZeroed)
					{
						System.arraycopy(TWELVE_ZERO_FLOATS, 0, modelUvArray, modelUvArrayOffset, 12);
					}
					modelUvArrayOffset += 12;
				}
				continue;
			}

			int alphaAndPriority = this.joinAlphaAndPriorityForFace(model, i);

			int triangleA = trianglesX[i];
			int triangleB = trianglesY[i];
			int triangleC = trianglesZ[i];

			modelVertexArray[modelVertexArrayOffset + 0] = vertexX[triangleA];
			modelVertexArray[modelVertexArrayOffset + 1] = vertexY[triangleA];
			modelVertexArray[modelVertexArrayOffset + 2] = vertexZ[triangleA];
			modelVertexArray[modelVertexArrayOffset + 3] = alphaAndPriority | color1;
			modelVertexArray[modelVertexArrayOffset + 4] = vertexX[triangleB];
			modelVertexArray[modelVertexArrayOffset + 5] = vertexY[triangleB];
			modelVertexArray[modelVertexArrayOffset + 6] = vertexZ[triangleB];
			modelVertexArray[modelVertexArrayOffset + 7] = alphaAndPriority | color2;
			modelVertexArray[modelVertexArrayOffset + 8] = vertexX[triangleC];
			modelVertexArray[modelVertexArrayOffset + 9] = vertexY[triangleC];
			modelVertexArray[modelVertexArrayOffset + 10] = vertexZ[triangleC];
			modelVertexArray[modelVertexArrayOffset + 11] = alphaAndPriority | color3;

			modelVertexArrayOffset += 12;

			if (faceTextures != null)
			{
				float[] uf, vf;
				if (u != null && v != null && (uf = u[i]) != null && (vf = v[i]) != null)
				{
					float texture = faceTextures[i] + 1f;
					modelUvArray[modelUvArrayOffset + 0] = texture;
					modelUvArray[modelUvArrayOffset + 1] = uf[0];
					modelUvArray[modelUvArrayOffset + 2] = vf[0];
					modelUvArray[modelUvArrayOffset + 3] = 0.0f;
					modelUvArray[modelUvArrayOffset + 4] = texture;
					modelUvArray[modelUvArrayOffset + 5] = uf[1];
					modelUvArray[modelUvArrayOffset + 6] = vf[1];
					modelUvArray[modelUvArrayOffset + 7] = 0.0f;
					modelUvArray[modelUvArrayOffset + 8] = texture;
					modelUvArray[modelUvArrayOffset + 9] = uf[2];
					modelUvArray[modelUvArrayOffset + 10] = vf[2];
					modelUvArray[modelUvArrayOffset + 11] = 0.0f;
				}
				else if (!uvArrayHasBeenZeroed)
				{
					System.arraycopy(TWELVE_ZERO_FLOATS, 0, modelUvArray, modelUvArrayOffset, 12);
				}
				modelUvArrayOffset += 12;
			}

		}

		int len = triangleCount * 3;

		offset += len;
		if (model.getFaceTextures() != null)
		{
			uvoffset += len;
		}
	}

	static public int pushModel(Model model, int faceCount, boolean padUvs, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer)
	{
		final int[] vertexX = model.getVerticesX();
		final int[] vertexY = model.getVerticesY();
		final int[] vertexZ = model.getVerticesZ();

		final int[] trianglesX = model.getTrianglesX();
		final int[] trianglesY = model.getTrianglesY();
		final int[] trianglesZ = model.getTrianglesZ();

		final int[] color1s = model.getFaceColors1();
		final int[] color2s = model.getFaceColors2();
		final int[] color3s = model.getFaceColors3();

		final short[] faceTextures = model.getFaceTextures();

		float[][] u = model.getFaceTextureUCoordinates();
		float[][] v = model.getFaceTextureVCoordinates();

		for (int i = 0; i < faceCount; ++i)
		{
			int color1 = color1s[i];
			int color2 = color2s[i];
			int color3 = color3s[i];

			if (color3 == -1)
			{
				color2 = color3 = color1;
			}
			else if (color3 == -2)
			{
				vertexBuffer.put(TWELVE_ZERO_INTS);
				if (padUvs || faceTextures != null)
				{
					uvBuffer.put(TWELVE_ZERO_FLOATS);
				}
				continue;
			}

			int alphaAndPriority = joinAlphaAndPriorityForFace(model, i);

			int triangleA = trianglesX[i];
			int triangleB = trianglesY[i];
			int triangleC = trianglesZ[i];

			vertexBuffer.put(vertexX[triangleA], vertexY[triangleA], vertexZ[triangleA], alphaAndPriority | color1);
			vertexBuffer.put(vertexX[triangleB], vertexY[triangleB], vertexZ[triangleB], alphaAndPriority | color2);
			vertexBuffer.put(vertexX[triangleC], vertexY[triangleC], vertexZ[triangleC], alphaAndPriority | color3);

			if (padUvs || faceTextures != null)
			{
				float[] uf, vf;
				if (faceTextures != null && u != null && v != null && (uf = u[i]) != null && (vf = v[i]) != null)
				{
					float texture = faceTextures[i] + 1f;
					uvBuffer.put(texture, uf[0], vf[0], 0f);
					uvBuffer.put(texture, uf[1], vf[1], 0f);
					uvBuffer.put(texture, uf[2], vf[2], 0f);
				}
				else
				{
					uvBuffer.put(TWELVE_ZERO_FLOATS);
				}
			}

		}
		return faceCount * 3;
	}

	static int pushFace(Model model, int face, boolean padUvs, GpuIntBuffer vertexBuffer, GpuFloatBuffer uvBuffer,
		int xOffset, int yOffset, int zOffset, int orientation)
	{
		final int[] color1s = model.getFaceColors1();
		final int[] color2s = model.getFaceColors2();
		final int[] color3s = model.getFaceColors3();

		final short[] faceTextures = model.getFaceTextures();

		int color1 = color1s[face];
		int color2 = color2s[face];
		int color3 = color3s[face];

		if (color3 == -1)
		{
			color2 = color3 = color1;
		}
		else if (color3 == -2)
		{
			vertexBuffer.put(TWELVE_ZERO_INTS);
			if (padUvs || faceTextures != null)
			{
				uvBuffer.put(TWELVE_ZERO_FLOATS);
			}
			return 3;
		}

		final int[] vertexX = model.getVerticesX();
		final int[] vertexY = model.getVerticesY();
		final int[] vertexZ = model.getVerticesZ();

		final int[] trianglesX = model.getTrianglesX();
		final int[] trianglesY = model.getTrianglesY();
		final int[] trianglesZ = model.getTrianglesZ();

		int triangleA = trianglesX[face];
		int triangleB = trianglesY[face];
		int triangleC = trianglesZ[face];

		int alphaAndPriority = joinAlphaAndPriorityForFace(model, face);

		if (orientation == 0)
		{
			vertexBuffer.put(vertexX[triangleA] + xOffset, vertexY[triangleA] + yOffset, vertexZ[triangleA] + zOffset, alphaAndPriority | color1);
			vertexBuffer.put(vertexX[triangleB] + xOffset, vertexY[triangleB] + yOffset, vertexZ[triangleB] + zOffset, alphaAndPriority | color2);
			vertexBuffer.put(vertexX[triangleC] + xOffset, vertexY[triangleC] + yOffset, vertexZ[triangleC] + zOffset, alphaAndPriority | color3);
		}
		else
		{
			int sin = Perspective.SINE[orientation];
			int cos = Perspective.COSINE[orientation];
			{
				int x = vertexX[triangleA];
				int y = vertexY[triangleA];
				int z = vertexZ[triangleA];
				int rotatedX = z * sin + x * cos >> 16;
				int rotatedZ = z * cos - x * sin >> 16;
				vertexBuffer.put(rotatedX + xOffset, y + yOffset, rotatedZ + zOffset, alphaAndPriority | color1);
			}
			{
				int x = vertexX[triangleB];
				int y = vertexY[triangleB];
				int z = vertexZ[triangleB];
				int rotatedX = z * sin + x * cos >> 16;
				int rotatedZ = z * cos - x * sin >> 16;
				vertexBuffer.put(rotatedX + xOffset, y + yOffset, rotatedZ + zOffset, alphaAndPriority | color2);
			}
			{
				int x = vertexX[triangleC];
				int y = vertexY[triangleC];
				int z = vertexZ[triangleC];
				int rotatedX = z * sin + x * cos >> 16;
				int rotatedZ = z * cos - x * sin >> 16;
				vertexBuffer.put(rotatedX + xOffset, y + yOffset, rotatedZ + zOffset, alphaAndPriority | color3);
			}
		}

		if (padUvs || faceTextures != null)
		{
			float[][] u = model.getFaceTextureUCoordinates();
			float[][] v = model.getFaceTextureVCoordinates();
			float[] uf, vf;
			if (faceTextures != null && u != null && v != null && (uf = u[face]) != null && (vf = v[face]) != null)
			{
				float texture = faceTextures[face] + 1f;
				uvBuffer.put(texture, uf[0], vf[0], 0f);
				uvBuffer.put(texture, uf[1], vf[1], 0f);
				uvBuffer.put(texture, uf[2], vf[2], 0f);
			}
			else
			{
				uvBuffer.put(TWELVE_ZERO_FLOATS);
			}
		}

		return 3;
	}

	static private int joinAlphaAndPriorityForFace(Model model, int face)
	{
		final byte[] transparencies = model.getTriangleTransparencies();
		final short[] faceTextures = model.getFaceTextures();
		final byte[] facePriorities = model.getFaceRenderPriorities();

		int alpha = 0;
		if (transparencies != null && (faceTextures == null || faceTextures[face] == -1))
		{
			alpha = (transparencies[face] & 0xFF) << 24;
		}

		int priority = 0;
		if (facePriorities != null)
		{
			priority = (facePriorities[face] & 0xff) << 16;
		}

		return alpha | priority;
	}

}
