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

import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Constants;
import net.runelite.api.DecorativeObject;
import net.runelite.api.DynamicObject;
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
import net.runelite.api.WorldView;
import net.runelite.client.callback.RenderCallbackManager;

@Slf4j
class SceneUploader
{
	private final int[] modelLocalXI;
	private final int[] modelLocalYI;
	private final int[] modelLocalZI;

	private final float[] u, v;

	private final RenderCallbackManager renderCallbackManager;
	private int basex, basez, rid, level;

	SceneUploader(RenderCallbackManager renderCallbackManager)
	{
		this.renderCallbackManager = renderCallbackManager;
		modelLocalXI = new int[ModelUploader.MAX_VERTEX_COUNT];
		modelLocalYI = new int[ModelUploader.MAX_VERTEX_COUNT];
		modelLocalZI = new int[ModelUploader.MAX_VERTEX_COUNT];
		u = new float[3];
		v = new float[3];
	}

	void zoneSize(Scene scene, Zone zone, int mzx, int mzz)
	{
		Tile[][][] tiles = scene.getExtendedTiles();

		for (int z = 3; z >= 0; --z)
		{
			for (int xoff = 0; xoff < 8; ++xoff)
			{
				for (int zoff = 0; zoff < 8; ++zoff)
				{
					Tile t = tiles[z][(mzx << 3) + xoff][(mzz << 3) + zoff];
					if (t != null)
					{
						zoneSize(zone, t);
					}
				}
			}
		}
	}

	void uploadZone(Scene scene, Zone zone, int mzx, int mzz)
	{
		int[][][] roofs = scene.getRoofs();
		Set<Integer> roofIds = new HashSet<>();

		var vb = zone.vboO != null ? new GpuIntBuffer(zone.vboO.vb) : null;
		var ab = zone.vboA != null ? new GpuIntBuffer(zone.vboA.vb) : null;

		for (int level = 0; level <= 3; ++level)
		{
			for (int xoff = 0; xoff < 8; ++xoff)
			{
				for (int zoff = 0; zoff < 8; ++zoff)
				{
					int rid = roofs[level][(mzx << 3) + xoff][(mzz << 3) + zoff];
					if (rid > 0)
					{
						roofIds.add(rid);
					}
				}
			}
		}

		zone.rids = new int[4][roofIds.size()];
		zone.roofStart = new int[4][roofIds.size()];
		zone.roofEnd = new int[4][roofIds.size()];

		for (int level = 0; level <= 3; ++level)
		{
			this.level = level;

			if (level == 0)
			{
				uploadZoneLevel(scene, zone, mzx, mzz, level, false, roofIds, vb, ab);
				uploadZoneLevel(scene, zone, mzx, mzz, level, true, roofIds, vb, ab);
				uploadZoneLevel(scene, zone, mzx, mzz, 1, true, roofIds, vb, ab);
				uploadZoneLevel(scene, zone, mzx, mzz, 2, true, roofIds, vb, ab);
				uploadZoneLevel(scene, zone, mzx, mzz, 3, true, roofIds, vb, ab);
			}
			else
			{
				uploadZoneLevel(scene, zone, mzx, mzz, level, false, roofIds, vb, ab);
			}

			if (zone.vboO != null)
			{
				int pos = zone.vboO.vb.position();
				zone.levelOffsets[level] = pos;
			}
		}
	}

	private void uploadZoneLevel(Scene scene, Zone zone, int mzx, int mzz, int level, boolean visbelow, Set<Integer> roofIds, GpuIntBuffer vb, GpuIntBuffer ab)
	{
		int ridx = 0;

		// upload the roofs and save their positions
		for (int id : roofIds)
		{
			int pos = zone.vboO != null ? zone.vboO.vb.position() : 0;

			uploadZoneLevelRoof(scene, zone, mzx, mzz, level, id, visbelow, vb, ab);

			int endpos = zone.vboO != null ? zone.vboO.vb.position() : 0;

			if (endpos > pos)
			{
				zone.rids[level][ridx] = id;
				zone.roofStart[level][ridx] = pos;
				zone.roofEnd[level][ridx] = endpos;
				++ridx;
			}
		}

		// upload everything else
		uploadZoneLevelRoof(scene, zone, mzx, mzz, level, 0, visbelow, vb, ab);
	}

	private void uploadZoneLevelRoof(Scene scene, Zone zone, int mzx, int mzz, int level, int roofId, boolean visbelow, GpuIntBuffer vb, GpuIntBuffer ab)
	{
		byte[][][] settings = scene.getExtendedTileSettings();
		int[][][] roofs = scene.getRoofs();
		Tile[][][] tiles = scene.getExtendedTiles();

		int offset = scene.getWorldViewId() == WorldView.TOPLEVEL ? GpuPlugin.SCENE_OFFSET >> 3 : 0;
		this.basex = (mzx - offset) << 10;
		this.basez = (mzz - offset) << 10;

		for (int xoff = 0; xoff < 8; ++xoff)
		{
			for (int zoff = 0; zoff < 8; ++zoff)
			{
				int msx = (mzx << 3) + xoff;
				int msz = (mzz << 3) + zoff;

				boolean isbridge = (settings[1][msx][msz] & Constants.TILE_FLAG_BRIDGE) != 0;
				int maplevel = level;
				if (isbridge)
				{
					++maplevel;
				}

				boolean isvisbelow = maplevel <= 3 && (settings[maplevel][msx][msz] & Constants.TILE_FLAG_VIS_BELOW) != 0;
				if (isvisbelow != visbelow)
				{
					continue;
				}

				int rid;
				if (isvisbelow || maplevel == 0)
				{
					rid = 0;
				}
				else
				{
					rid = roofs[maplevel - 1][msx][msz];
				}

				if (rid == roofId)
				{
					Tile t = tiles[level][msx][msz];
					if (t != null)
					{
						this.rid = rid;
						uploadZoneTile(scene, zone, t, vb, ab);
					}
				}
			}
		}
	}

	private void zoneSize(Zone z, Tile t)
	{
		SceneTilePaint paint = t.getSceneTilePaint();
		if (paint != null)
		{
			z.sizeO += 2;
		}

		SceneTileModel model = t.getSceneTileModel();
		if (model != null)
		{
			z.sizeO += model.getFaceX().length;
		}

		WallObject wallObject = t.getWallObject();
		if (wallObject != null)
		{
			zoneRenderableSize(z, wallObject.getRenderable1());
			zoneRenderableSize(z, wallObject.getRenderable2());
		}

		DecorativeObject decorativeObject = t.getDecorativeObject();
		if (decorativeObject != null)
		{
			zoneRenderableSize(z, decorativeObject.getRenderable());
			zoneRenderableSize(z, decorativeObject.getRenderable2());
		}

		GroundObject groundObject = t.getGroundObject();
		if (groundObject != null)
		{
			zoneRenderableSize(z, groundObject.getRenderable());
		}

		GameObject[] gameObjects = t.getGameObjects();
		for (GameObject gameObject : gameObjects)
		{
			if (gameObject == null)
			{
				continue;
			}

			if (!gameObject.getSceneMinLocation().equals(t.getSceneLocation()))
			{
				continue;
			}

			Renderable renderable = gameObject.getRenderable();
			zoneRenderableSize(z, renderable);
		}

		Tile bridge = t.getBridge();
		if (bridge != null)
		{
			zoneSize(z, bridge);
		}
	}

	private int uploadZoneTile(Scene scene, Zone zone, Tile t, GpuIntBuffer vertexBuffer, GpuIntBuffer ab)
	{
		int len = 0;
		boolean drawTile = renderCallbackManager.drawTile(scene, t);

		SceneTilePaint paint = t.getSceneTilePaint();
		if (paint != null && drawTile)
		{
			Point tilePoint = t.getSceneLocation();
			len = upload(scene, paint,
				t.getRenderLevel(), tilePoint.getX(), tilePoint.getY(),
				vertexBuffer,
				tilePoint.getX() * 128 - basex, tilePoint.getY() * 128 - basez
			);
		}

		SceneTileModel model = t.getSceneTileModel();
		if (model != null && drawTile)
		{
			Point tilePoint = t.getSceneLocation();
			len += upload(model, tilePoint.getX() << 7, tilePoint.getY() << 7, vertexBuffer);
		}

		WallObject wallObject = t.getWallObject();
		if (wallObject != null && renderCallbackManager.drawObject(scene, wallObject))
		{
			Renderable renderable1 = wallObject.getRenderable1();
			uploadZoneRenderable(renderable1, zone, 0, wallObject.getX(), wallObject.getZ(), wallObject.getY(), -1, -1, -1, -1, wallObject.getId(), vertexBuffer, ab);

			Renderable renderable2 = wallObject.getRenderable2();
			uploadZoneRenderable(renderable2, zone, 0, wallObject.getX(), wallObject.getZ(), wallObject.getY(), -1, -1, -1, -1, wallObject.getId(), vertexBuffer, ab);
		}

		DecorativeObject decorativeObject = t.getDecorativeObject();
		if (decorativeObject != null && renderCallbackManager.drawObject(scene, decorativeObject))
		{
			Renderable renderable = decorativeObject.getRenderable();
			uploadZoneRenderable(renderable, zone, 0, decorativeObject.getX() + decorativeObject.getXOffset(), decorativeObject.getZ(), decorativeObject.getY() + decorativeObject.getYOffset(), -1, -1, -1, -1, decorativeObject.getId(), vertexBuffer, ab);

			Renderable renderable2 = decorativeObject.getRenderable2();
			uploadZoneRenderable(renderable2, zone, 0, decorativeObject.getX() + decorativeObject.getXOffset2(), decorativeObject.getZ(), decorativeObject.getY() + decorativeObject.getYOffset2(), -1, -1, -1, -1, decorativeObject.getId(), vertexBuffer, ab);
		}

		GroundObject groundObject = t.getGroundObject();
		if (groundObject != null && renderCallbackManager.drawObject(scene, groundObject))
		{
			Renderable renderable = groundObject.getRenderable();
			uploadZoneRenderable(renderable, zone, 0, groundObject.getX(), groundObject.getZ(), groundObject.getY(),
				-1, -1, -1, -1,
				groundObject.getId(),
				vertexBuffer, ab);
		}

		GameObject[] gameObjects = t.getGameObjects();
		for (GameObject gameObject : gameObjects)
		{
			if (gameObject == null)
			{
				continue;
			}

			Point min = gameObject.getSceneMinLocation(), max = gameObject.getSceneMaxLocation();

			if (!min.equals(t.getSceneLocation()))
			{
				continue;
			}

			if (!renderCallbackManager.drawObject(scene, gameObject))
			{
				continue;
			}

			Renderable renderable = gameObject.getRenderable();
			uploadZoneRenderable(renderable, zone, gameObject.getModelOrientation(), gameObject.getX(), gameObject.getZ(), gameObject.getY(),
				min.getX(), min.getY(), max.getX(), max.getY(),
				gameObject.getId(),
				vertexBuffer, ab);
		}

		Tile bridge = t.getBridge();
		if (bridge != null)
		{
			len += uploadZoneTile(scene, zone, bridge, vertexBuffer, ab);
		}

		return len;
	}

	private void zoneRenderableSize(Zone z, Renderable r)
	{
		Model m = null;
		if (r instanceof Model)
		{
			m = (Model) r;
		}
		else if (r instanceof DynamicObject)
		{
			m = ((DynamicObject) r).getModelZbuf();
		}
		if (m == null)
		{
			return;
		}

		byte[] transparencies = m.getFaceTransparencies();
		int faceCount = m.getFaceCount();
		if (transparencies != null)
		{
			for (int face = 0; face < faceCount; ++face)
			{
				boolean alpha = transparencies[face] != 0;
				if (alpha)
				{
					z.sizeA++;
				}
				else
				{
					z.sizeO++;
				}
			}
			return;
		}
		z.sizeO += faceCount;
	}

	private void uploadZoneRenderable(Renderable r, Zone zone, int orient, int x, int y, int z, int lx, int lz, int ux, int uz, int id, GpuIntBuffer vb, GpuIntBuffer ab)
	{
		int pos = zone.vboA != null ? zone.vboA.vb.position() : 0;
		Model model = null;
		if (r instanceof Model)
		{
			model = (Model) r;
			uploadStaticModel(model, orient, x - basex, y, z - basez, vb, ab);
		}
		else if (r instanceof DynamicObject)
		{
			model = ((DynamicObject) r).getModelZbuf();
			if (model != null)
			{
				uploadStaticModel(model, orient, x - basex, y, z - basez, vb, ab);
			}
		}
		int endpos = zone.vboA != null ? zone.vboA.vb.position() : 0;
		if (endpos > pos)
		{
			assert model != null;
			if (lx > -1)
			{
				lx -= basex >> 7;
				lz -= basez >> 7;
				ux -= basex >> 7;
				uz -= basez >> 7;
				assert lx >= 0 : lx;
				assert lz >= 0 : lz;
				assert ux < 25 : ux; // largest object?
				assert uz < 25 : uz;
			}
			zone.addAlphaModel(zone.glVaoA, model, pos, endpos,
				x - basex, y, z - basez,
				lx, lz, ux, uz,
				rid, level, id);
		}
	}

	private int upload(Scene scene, SceneTilePaint tile, int tileZ, int tileX, int tileY, GpuIntBuffer vertexBuffer, int lx, int lz)
	{
		tileX += scene.getWorldViewId() == WorldView.TOPLEVEL ? GpuPlugin.SCENE_OFFSET : 0;
		tileY += scene.getWorldViewId() == WorldView.TOPLEVEL ? GpuPlugin.SCENE_OFFSET : 0;

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

		int tex = tile.getTexture() + 1;

		vertexBuffer.put22224(lx2, ly2, lz2, hsl2);
		vertexBuffer.put2222(tex, 256, 256, 0);

		vertexBuffer.put22224(lx3, ly3, lz3, hsl3);
		vertexBuffer.put2222(tex, 0, 256, 0);

		vertexBuffer.put22224(lx1, ly1, lz1, hsl1);
		vertexBuffer.put2222(tex, 256, 0, 0);

		vertexBuffer.put22224(lx0, ly0, lz0, hsl0);
		vertexBuffer.put2222(tex, 0, 0, 0);

		vertexBuffer.put22224(lx1, ly1, lz1, hsl1);
		vertexBuffer.put2222(tex, 256, 0, 0);

		vertexBuffer.put22224(lx3, ly3, lz3, hsl3);
		vertexBuffer.put2222(tex, 0, 256, 0);

		return 6;
	}

	private int upload(SceneTileModel sceneTileModel, int lx, int lz, GpuIntBuffer vertexBuffer)
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
			int lx0 = vertexX[vertex0] - basex;
			int ly0 = vertexY[vertex0];
			int lz0 = vertexZ[vertex0] - basez;

			int lx1 = vertexX[vertex1] - basex;
			int ly1 = vertexY[vertex1];
			int lz1 = vertexZ[vertex1] - basez;

			int lx2 = vertexX[vertex2] - basex;
			int ly2 = vertexY[vertex2];
			int lz2 = vertexZ[vertex2] - basez;

			int tex = triangleTextures != null ? triangleTextures[i] + 1 : 0;
			vertexBuffer.put22224(lx0, ly0, lz0, hsl0);
			vertexBuffer.put2222(tex, (int) ((vertexX[vertex0] - lx) * 2f), (int) ((vertexZ[vertex0] - lz) * 2f), 0);

			vertexBuffer.put22224(lx1, ly1, lz1, hsl1);
			vertexBuffer.put2222(tex, (int) ((vertexX[vertex1] - lx) * 2f), (int) ((vertexZ[vertex1] - lz) * 2f), 0);

			vertexBuffer.put22224(lx2, ly2, lz2, hsl2);
			vertexBuffer.put2222(tex, (int) ((vertexX[vertex2] - lx) * 2f), (int) ((vertexZ[vertex2] - lz) * 2f), 0);
		}

		return cnt;
	}

	// scene upload
	private int uploadStaticModel(Model model, int orient, int x, int y, int z, GpuIntBuffer vb, GpuIntBuffer ab)
	{
		final int vertexCount = model.getVerticesCount();
		final int triangleCount = model.getFaceCount();

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

		final byte[] transparencies = model.getFaceTransparencies();
		final byte[] bias = model.getFaceBias();

		int orientSin = 0;
		int orientCos = 0;
		if (orient != 0)
		{
			orientSin = Perspective.SINE[orient];
			orientCos = Perspective.COSINE[orient];
		}

		for (int v = 0; v < vertexCount; ++v)
		{
			int vx = (int) vertexX[v];
			int vy = (int) vertexY[v];
			int vz = (int) vertexZ[v];

			if (orient != 0)
			{
				int x0 = vx;
				vx = vz * orientSin + x0 * orientCos >> 16;
				vz = vz * orientCos - x0 * orientSin >> 16;
			}

			vx += x;
			vy += y;
			vz += z;

			modelLocalXI[v] = vx;
			modelLocalYI[v] = vy;
			modelLocalZI[v] = vz;
		}

		int len = 0;
		for (int face = 0; face < triangleCount; ++face)
		{
			int color1 = color1s[face];
			int color2 = color2s[face];
			int color3 = color3s[face];

			boolean alpha = (transparencies != null && transparencies[face] != 0);

			if (color3 == -1)
			{
				color2 = color3 = color1;
			}
			else if (color3 == -2)
			{
				continue;
			}

			int triangleA = indices1[face];
			int triangleB = indices2[face];
			int triangleC = indices3[face];

			int vx1 = modelLocalXI[triangleA];
			int vy1 = modelLocalYI[triangleA];
			int vz1 = modelLocalZI[triangleA];

			int vx2 = modelLocalXI[triangleB];
			int vy2 = modelLocalYI[triangleB];
			int vz2 = modelLocalZI[triangleB];

			int vx3 = modelLocalXI[triangleC];
			int vy3 = modelLocalYI[triangleC];
			int vz3 = modelLocalZI[triangleC];

			ModelUploader.computeFaceUvs(model, face, u, v);

			int su0 = (int) (u[0] * 256f);
			int sv0 = (int) (v[0] * 256f);

			int su1 = (int) (u[1] * 256f);
			int sv1 = (int) (v[1] * 256f);

			int su2 = (int) (u[2] * 256f);
			int sv2 = (int) (v[2] * 256f);

			int alphaBias = 0;
			alphaBias |= transparencies != null ? (transparencies[face] & 0xff) << 24 : 0;
			alphaBias |= bias != null ? (bias[face] & 0xff) << 16 : 0;
			int texture = faceTextures != null ? faceTextures[face] + 1 : 0;
			GpuIntBuffer buf = alpha ? ab : vb;

			buf.put22224(vx1, vy1, vz1, alphaBias | color1);
			buf.put2222(texture, su0, sv0, 0);

			buf.put22224(vx2, vy2, vz2, alphaBias | color2);
			buf.put2222(texture, su1, sv1, 0);

			buf.put22224(vx3, vy3, vz3, alphaBias | color3);
			buf.put2222(texture, su2, sv2, 0);

			len += 3;
		}

		return len;
	}
}
