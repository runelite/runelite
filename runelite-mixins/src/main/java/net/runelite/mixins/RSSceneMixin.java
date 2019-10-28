/*
 * Copyright (c) 2018 Abex
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

import net.runelite.api.Entity;
import net.runelite.api.Perspective;
import net.runelite.api.TileModel;
import net.runelite.api.TilePaint;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.hooks.DrawCallbacks;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSBoundaryObject;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSFloorDecoration;
import net.runelite.rs.api.RSNodeDeque;
import net.runelite.rs.api.RSTileItem;
import net.runelite.rs.api.RSTileItemPile;
import net.runelite.rs.api.RSScene;
import net.runelite.rs.api.RSTile;
import net.runelite.rs.api.RSTileModel;
import net.runelite.rs.api.RSWallDecoration;

@Mixin(RSScene.class)
public abstract class RSSceneMixin implements RSScene
{
	private static final int DEFAULT_DISTANCE = 25;
	private static final int MAX_DISTANCE = 90;

	private static final int PITCH_LOWER_LIMIT = 128;
	private static final int PITCH_UPPER_LIMIT = 383;

	private static final int MAX_TARGET_DISTANCE = 45;

	@Shadow("client")
	static RSClient client;

	@Shadow("pitchRelaxEnabled")
	private static boolean pitchRelaxEnabled;

	@Inject
	private static int[] tmpX = new int[6];

	@Shadow("skyboxColor")
	static int skyboxColor;

	@Inject
	private static int[] tmpY = new int[6];

	@Inject
	private static int rl$drawDistance;

	@Replace("draw")
	void rl$drawScene(int cameraX, int cameraY, int cameraZ, int cameraPitch, int cameraYaw, int plane)
	{
		final DrawCallbacks drawCallbacks = client.getDrawCallbacks();
		if (drawCallbacks != null)
		{
			drawCallbacks.drawScene(cameraX, cameraY, cameraZ, cameraPitch, cameraYaw, plane);
		}

		final boolean isGpu = client.isGpu();
		final boolean checkClick = client.isCheckClick();
		if (!client.isMenuOpen())
		{
			// Force check click to update the selected tile
			client.setCheckClick(true);
			final int mouseX = client.getMouseX();
			final int mouseY = client.getMouseY();
			client.setMouseCanvasHoverPositionX(mouseX - client.getViewportXOffset());
			client.setMouseCanvasHoverPositionY(mouseY - client.getViewportYOffset());
		}

		if (!isGpu)
		{
			if (skyboxColor != 0)
			{
				client.rasterizerFillRectangle(
					client.getViewportXOffset(),
					client.getViewportYOffset(),
					client.getViewportWidth(),
					client.getViewportHeight(),
					skyboxColor
				);
			}
		}

		final int maxX = getMaxX();
		final int maxY = getMaxY();
		final int maxZ = getMaxZ();

		final int minLevel = getMinLevel();

		final RSTile[][][] tiles = getTiles();
		final int distance = isGpu ? rl$drawDistance : DEFAULT_DISTANCE;

		if (cameraX < 0)
		{
			cameraX = 0;
		}
		else if (cameraX >= maxX * Perspective.LOCAL_TILE_SIZE)
		{
			cameraX = maxX * Perspective.LOCAL_TILE_SIZE - 1;
		}

		if (cameraZ < 0)
		{
			cameraZ = 0;
		}
		else if (cameraZ >= maxZ * Perspective.LOCAL_TILE_SIZE)
		{
			cameraZ = maxZ * Perspective.LOCAL_TILE_SIZE - 1;
		}

		// we store the uncapped pitch for setting camera angle for the pitch relaxer
		// we still have to cap the pitch in order to access the visibility map, though
		int realPitch = cameraPitch;
		if (cameraPitch < PITCH_LOWER_LIMIT)
		{
			cameraPitch = PITCH_LOWER_LIMIT;
		}
		else if (cameraPitch > PITCH_UPPER_LIMIT)
		{
			cameraPitch = PITCH_UPPER_LIMIT;
		}
		if (!pitchRelaxEnabled)
		{
			realPitch = cameraPitch;
		}

		client.setCycle(client.getCycle() + 1);

		client.setPitchSin(Perspective.SINE[realPitch]);
		client.setPitchCos(Perspective.COSINE[realPitch]);
		client.setYawSin(Perspective.SINE[cameraYaw]);
		client.setYawCos(Perspective.COSINE[cameraYaw]);

		final int[][][] tileHeights = client.getTileHeights();
		boolean[][] renderArea = client.getVisibilityMaps()[(cameraPitch - 128) / 32][cameraYaw / 64];
		client.setRenderArea(renderArea);

		client.setCameraX2(cameraX);
		client.setCameraY2(cameraY);
		client.setCameraZ2(cameraZ);

		int screenCenterX = cameraX / Perspective.LOCAL_TILE_SIZE;
		int screenCenterZ = cameraZ / Perspective.LOCAL_TILE_SIZE;

		client.setScreenCenterX(screenCenterX);
		client.setScreenCenterZ(screenCenterZ);
		client.setScenePlane(plane);

		int minTileX = screenCenterX - distance;
		if (minTileX < 0)
		{
			minTileX = 0;
		}

		int minTileZ = screenCenterZ - distance;
		if (minTileZ < 0)
		{
			minTileZ = 0;
		}

		int maxTileX = screenCenterX + distance;
		if (maxTileX > maxX)
		{
			maxTileX = maxX;
		}

		int maxTileZ = screenCenterZ + distance;
		if (maxTileZ > maxZ)
		{
			maxTileZ = maxZ;
		}

		client.setMinTileX(minTileX);
		client.setMinTileZ(minTileZ);
		client.setMaxTileX(maxTileX);
		client.setMaxTileZ(maxTileZ);

		updateOccluders();

		client.setTileUpdateCount(0);

		for (int z = minLevel; z < maxY; ++z)
		{
			RSTile[][] planeTiles = tiles[z];

			for (int x = minTileX; x < maxTileX; ++x)
			{
				for (int y = minTileZ; y < maxTileZ; ++y)
				{
					RSTile tile = planeTiles[x][y];
					if (tile != null)
					{
						if (tile.getPhysicalLevel() <= plane
							&& (isGpu
							|| renderArea[x - screenCenterX + DEFAULT_DISTANCE][y - screenCenterZ + DEFAULT_DISTANCE]
							|| tileHeights[z][x][y] - cameraY >= 2000))
						{
							tile.setDraw(true);
							tile.setVisible(true);
							tile.setDrawEntities(true);
							client.setTileUpdateCount(client.getTileUpdateCount() + 1);
						}
						else
						{
							tile.setDraw(false);
							tile.setVisible(false);
							tile.setWallCullDirection(0);
						}
					}
				}
			}
		}

		for (int z = minLevel; z < maxY; ++z)
		{
			RSTile[][] planeTiles = tiles[z];

			for (int x = -distance; x <= 0; ++x)
			{
				int var10 = x + screenCenterX;
				int var16 = screenCenterX - x;
				if (var10 >= minTileX || var16 < maxTileX)
				{
					for (int y = -distance; y <= 0; ++y)
					{
						int var13 = y + screenCenterZ;
						int var14 = screenCenterZ - y;
						if (var10 >= minTileX)
						{
							if (var13 >= minTileZ)
							{
								RSTile tile = planeTiles[var10][var13];
								if (tile != null && tile.isDraw())
								{
									draw(tile, true);
								}
							}

							if (var14 < maxTileZ)
							{
								RSTile tile = planeTiles[var10][var14];
								if (tile != null && tile.isDraw())
								{
									draw(tile, true);
								}
							}
						}

						if (var16 < maxTileX)
						{
							if (var13 >= minTileZ)
							{
								RSTile tile = planeTiles[var16][var13];
								if (tile != null && tile.isDraw())
								{
									draw(tile, true);
								}
							}

							if (var14 < maxTileZ)
							{
								RSTile tile = planeTiles[var16][var14];
								if (tile != null && tile.isDraw())
								{
									draw(tile, true);
								}
							}
						}

						if (client.getTileUpdateCount() == 0)
						{
							client.setCheckClick(false);
							if (!checkClick)
							{
								client.setViewportWalking(false);
							}
							client.getCallbacks().drawScene();
							return;
						}
					}
				}
			}
		}

		for (int z = minLevel; z < maxY; ++z)
		{
			RSTile[][] planeTiles = tiles[z];

			for (int x = -distance; x <= 0; ++x)
			{
				int var10 = x + screenCenterX;
				int var16 = screenCenterX - x;
				if (var10 >= minTileX || var16 < maxTileX)
				{
					for (int y = -distance; y <= 0; ++y)
					{
						int var13 = y + screenCenterZ;
						int var14 = screenCenterZ - y;
						if (var10 >= minTileX)
						{
							if (var13 >= minTileZ)
							{
								RSTile tile = planeTiles[var10][var13];
								if (tile != null && tile.isDraw())
								{
									draw(tile, false);
								}
							}

							if (var14 < maxTileZ)
							{
								RSTile tile = planeTiles[var10][var14];
								if (tile != null && tile.isDraw())
								{
									draw(tile, false);
								}
							}
						}

						if (var16 < maxTileX)
						{
							if (var13 >= minTileZ)
							{
								RSTile tile = planeTiles[var16][var13];
								if (tile != null && tile.isDraw())
								{
									draw(tile, false);
								}
							}

							if (var14 < maxTileZ)
							{
								RSTile tile = planeTiles[var16][var14];
								if (tile != null && tile.isDraw())
								{
									draw(tile, false);
								}
							}
						}

						if (client.getTileUpdateCount() == 0)
						{
							client.setCheckClick(false);
							if (!checkClick)
							{
								client.setViewportWalking(false);
							}
							client.getCallbacks().drawScene();
							return;
						}
					}
				}
			}
		}

		client.setCheckClick(false);
		if (!checkClick)
		{
			// If checkClick was false, then the selected tile wouldn't have existed next tick,
			// so clear viewport walking in order to prevent it triggering a walk
			client.setViewportWalking(false);
		}
		client.getCallbacks().drawScene();
	}

	@Copy("newWallDecoration")
	abstract public void rs$addBoundaryDecoration(int plane, int x, int y, int floor, Entity var5, Entity var6, int var7, int var8, int var9, int var10, long hash, int var12);

	@Replace("newWallDecoration")
	public void rl$addBoundaryDecoration(int plane, int x, int y, int floor, Entity var5, Entity var6, int var7, int var8, int var9, int var10, long hash, int var12)
	{
		rs$addBoundaryDecoration(plane, x, y, floor, var5, var6, var7, var8, var9, var10, hash, var12);
		Tile tile = getTiles()[plane][x][y];
		if (tile != null)
		{
			RSWallDecoration object = (RSWallDecoration) tile.getDecorativeObject();
			if (object != null)
			{
				object.setPlane(plane);
			}
		}
	}

	@Copy("newGroundItemPile")
	abstract public void rs$addItemPile(int plane, int x, int y, int hash, Entity var5, long var6, Entity var7, Entity var8);

	@Replace("newGroundItemPile")
	public void rl$addItemPile(int plane, int x, int y, int hash, Entity var5, long var6, Entity var7, Entity var8)
	{
		rs$addItemPile(plane, x, y, hash, var5, var6, var7, var8);
		Tile tile = getTiles()[plane][x][y];
		if (tile != null)
		{
			RSTileItemPile itemLayer = (RSTileItemPile) tile.getItemLayer();
			if (itemLayer != null)
			{
				itemLayer.setPlane(plane);
			}
		}
	}

	@Copy("newFloorDecoration")
	abstract public void rs$groundObjectSpawned(int plane, int x, int y, int floor, Entity var5, long hash, int var7);

	@Replace("newFloorDecoration")
	public void rl$groundObjectSpawned(int plane, int x, int y, int floor, Entity var5, long hash, int var7)
	{
		rs$groundObjectSpawned(plane, x, y, floor, var5, hash, var7);
		Tile tile = getTiles()[plane][x][y];
		if (tile != null)
		{
			RSFloorDecoration groundObject = (RSFloorDecoration) tile.getGroundObject();
			if (groundObject != null)
			{
				groundObject.setPlane(plane);
			}
		}
	}

	@Copy("newBoundaryObject")
	abstract public void rs$addBoundary(int plane, int x, int y, int floor, Entity var5, Entity var6, int var7, int var8, long hash, int var10);

	@Replace("newBoundaryObject")
	public void rl$addBoundary(int plane, int x, int y, int floor, Entity var5, Entity var6, int var7, int var8, long hash, int var10)
	{
		rs$addBoundary(plane, x, y, floor, var5, var6, var7, var8, hash, var10);
		Tile tile = getTiles()[plane][x][y];
		if (tile != null)
		{
			RSBoundaryObject wallObject = (RSBoundaryObject) tile.getWallObject();
			if (wallObject != null)
			{
				wallObject.setPlane(plane);
			}
		}
	}

	@Copy("drawTileUnderlay")
	abstract public void rs$drawTileUnderlay(TilePaint tile, int z, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y);

	@Replace("drawTileUnderlay")
	public void rl$drawTileUnderlay(TilePaint tile, int z, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y)
	{
		if (!client.isGpu())
		{
			try
			{
				rs$drawTileUnderlay(tile, z, pitchSin, pitchCos, yawSin, yawCos, x, y);
			}
			catch (Exception ex)
			{
				client.getLogger().warn("error during tile underlay rendering", ex);
			}
			return;
		}

		final DrawCallbacks drawCallbacks = client.getDrawCallbacks();

		if (drawCallbacks == null)
		{
			return;
		}

		try
		{
			final int[][][] tileHeights = getTileHeights();

			final int cameraX2 = client.getCameraX2();
			final int cameraY2 = client.getCameraY2();
			final int cameraZ2 = client.getCameraZ2();

			final int zoom = client.get3dZoom();
			final int centerX = client.getCenterX();
			final int centerY = client.getCenterY();

			final int mouseX2 = client.getMouseX2();
			final int mouseY2 = client.getMouseY2();

			final boolean checkClick = client.isCheckClick();

			int var9;
			int var10 = var9 = (x << 7) - cameraX2;
			int var11;
			int var12 = var11 = (y << 7) - cameraZ2;
			int var13;
			int var14 = var13 = var10 + 128;
			int var15;
			int var16 = var15 = var12 + 128;
			int var17 = tileHeights[z][x][y] - cameraY2;
			int var18 = tileHeights[z][x + 1][y] - cameraY2;
			int var19 = tileHeights[z][x + 1][y + 1] - cameraY2;
			int var20 = tileHeights[z][x][y + 1] - cameraY2;
			int var21 = var10 * yawCos + yawSin * var12 >> 16;
			var12 = var12 * yawCos - yawSin * var10 >> 16;
			var10 = var21;
			var21 = var17 * pitchCos - pitchSin * var12 >> 16;
			var12 = pitchSin * var17 + var12 * pitchCos >> 16;
			var17 = var21;
			if (var12 >= 50)
			{
				var21 = var14 * yawCos + yawSin * var11 >> 16;
				var11 = var11 * yawCos - yawSin * var14 >> 16;
				var14 = var21;
				var21 = var18 * pitchCos - pitchSin * var11 >> 16;
				var11 = pitchSin * var18 + var11 * pitchCos >> 16;
				var18 = var21;
				if (var11 >= 50)
				{
					var21 = var13 * yawCos + yawSin * var16 >> 16;
					var16 = var16 * yawCos - yawSin * var13 >> 16;
					var13 = var21;
					var21 = var19 * pitchCos - pitchSin * var16 >> 16;
					var16 = pitchSin * var19 + var16 * pitchCos >> 16;
					var19 = var21;
					if (var16 >= 50)
					{
						var21 = var9 * yawCos + yawSin * var15 >> 16;
						var15 = var15 * yawCos - yawSin * var9 >> 16;
						var9 = var21;
						var21 = var20 * pitchCos - pitchSin * var15 >> 16;
						var15 = pitchSin * var20 + var15 * pitchCos >> 16;
						if (var15 >= 50)
						{
							int dy = var10 * zoom / var12 + centerX;
							int dx = var17 * zoom / var12 + centerY;
							int cy = var14 * zoom / var11 + centerX;
							int cx = var18 * zoom / var11 + centerY;
							int ay = var13 * zoom / var16 + centerX;
							int ax = var19 * zoom / var16 + centerY;
							int by = var9 * zoom / var15 + centerX;
							int bx = var21 * zoom / var15 + centerY;

							drawCallbacks.drawScenePaint(0, pitchSin, pitchCos, yawSin, yawCos,
								-cameraX2, -cameraY2, -cameraZ2,
								tile, z, x, y,
								zoom, centerX, centerY);

							if ((ay - by) * (cx - bx) - (ax - bx) * (cy - by) > 0)
							{
								if (checkClick && client.containsBounds(mouseX2, mouseY2, ax, bx, cx, ay, by, cy))
								{
									setTargetTile(x, y);
								}
							}

							if ((dy - cy) * (bx - cx) - (dx - cx) * (by - cy) > 0)
							{
								if (checkClick && client.containsBounds(mouseX2, mouseY2, dx, cx, bx, dy, cy, by))
								{
									setTargetTile(x, y);
								}
							}

						}
					}
				}
			}
		}
		catch (Exception ex)
		{
			client.getLogger().warn("error during underlay rendering", ex);
		}
	}

	@Copy("drawTileOverlay")
	abstract public void rs$drawTileOverlay(TileModel tile, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y);

	@Replace("drawTileOverlay")
	public void rl$drawTileOverlay(TileModel tile, int pitchSin, int pitchCos, int yawSin, int yawCos, int tileX, int tileY)
	{
		if (!client.isGpu())
		{
			rs$drawTileOverlay(tile, pitchSin, pitchCos, yawSin, yawCos, tileX, tileY);
			return;
		}

		final DrawCallbacks drawCallbacks = client.getDrawCallbacks();

		if (drawCallbacks == null)
		{
			return;
		}

		try
		{
			final int cameraX2 = client.getCameraX2();
			final int cameraY2 = client.getCameraY2();
			final int cameraZ2 = client.getCameraZ2();
			final int zoom = client.get3dZoom();
			final int centerX = client.getCenterX();
			final int centerY = client.getCenterY();

			drawCallbacks.drawSceneModel(0, pitchSin, pitchCos, yawSin, yawCos, -cameraX2, -cameraY2, -cameraZ2,
				tile, client.getPlane(), tileX, tileY,
				zoom, centerX, centerY);

			final boolean checkClick = client.isCheckClick();
			if (!checkClick)
			{
				return;
			}

			RSTileModel sceneTileModel = (RSTileModel) tile;

			final int[] faceX = sceneTileModel.getFaceX();
			final int[] faceY = sceneTileModel.getFaceY();
			final int[] faceZ = sceneTileModel.getFaceZ();

			final int[] vertexX = sceneTileModel.getVertexX();
			final int[] vertexY = sceneTileModel.getVertexY();
			final int[] vertexZ = sceneTileModel.getVertexZ();

			final int vertexCount = vertexX.length;
			final int faceCount = faceX.length;

			final int mouseX2 = client.getMouseX2();
			final int mouseY2 = client.getMouseY2();

			for (int i = 0; i < vertexCount; ++i)
			{
				int vx = vertexX[i] - cameraX2;
				int vy = vertexY[i] - cameraY2;
				int vz = vertexZ[i] - cameraZ2;

				int rotA = vz * yawSin + vx * yawCos >> 16;
				int rotB = vz * yawCos - vx * yawSin >> 16;

				int var13 = vy * pitchCos - rotB * pitchSin >> 16;
				int var12 = vy * pitchSin + rotB * pitchCos >> 16;
				if (var12 < 50)
				{
					return;
				}

				int ax = rotA * zoom / var12 + centerX;
				int ay = var13 * zoom / var12 + centerY;

				tmpX[i] = ax;
				tmpY[i] = ay;
			}

			for (int i = 0; i < faceCount; ++i)
			{
				int va = faceX[i];
				int vb = faceY[i];
				int vc = faceZ[i];

				int x1 = tmpX[va];
				int x2 = tmpX[vb];
				int x3 = tmpX[vc];

				int y1 = tmpY[va];
				int y2 = tmpY[vb];
				int y3 = tmpY[vc];

				if ((x1 - x2) * (y3 - y2) - (y1 - y2) * (x3 - x2) > 0)
				{
					if (client.containsBounds(mouseX2, mouseY2, y1, y2, y3, x1, x2, x3))
					{
						setTargetTile(tileX, tileY);
						break;
					}
				}
			}
		}
		catch (Exception ex)
		{
			client.getLogger().warn("error during overlay rendering", ex);
		}
	}

	@Inject
	@Override
	public int getDrawDistance()
	{
		return rl$drawDistance;
	}

	@Inject
	@Override
	public void setDrawDistance(int drawDistance)
	{
		rl$drawDistance = drawDistance;
	}

	@Inject
	static void setTargetTile(int targetX, int targetY)
	{
		client.setSelectedSceneTileX(targetX);
		client.setSelectedSceneTileY(targetY);
	}

	@Override
	@Inject
	public void addItem(int id, int quantity, WorldPoint point)
	{
		final int sceneX = point.getX() - client.getBaseX();
		final int sceneY = point.getY() - client.getBaseY();
		final int plane = point.getPlane();

		if (sceneX < 0 || sceneY < 0 || sceneX >= 104 || sceneY >= 104)
		{
			return;
		}

		RSTileItem item = client.newTileItem();
		item.setId(id);
		item.setQuantity(quantity);
		RSNodeDeque[][][] groundItems = client.getGroundItemDeque();

		if (groundItems[plane][sceneX][sceneY] == null)
		{
			groundItems[plane][sceneX][sceneY] = client.newNodeDeque();
		}

		groundItems[plane][sceneX][sceneY].addFirst(item);

		if (plane == client.getPlane())
		{
			client.updateItemPile(sceneX, sceneY);
		}
	}

	@Override
	@Inject
	public void removeItem(int id, int quantity, WorldPoint point)
	{
		final int sceneX = point.getX() - client.getBaseX();
		final int sceneY = point.getY() - client.getBaseY();
		final int plane = point.getPlane();

		if (sceneX < 0 || sceneY < 0 || sceneX >= 104 || sceneY >= 104)
		{
			return;
		}

		RSNodeDeque items = client.getGroundItemDeque()[plane][sceneX][sceneY];

		if (items == null)
		{
			return;
		}

		for (RSTileItem item = (RSTileItem) items.last(); item != null; item = (RSTileItem) items.previous())
		{
			if (item.getId() == id && quantity == 1)
			{
				item.unlink();
				break;
			}
		}

		if (items.last() == null)
		{
			client.getGroundItemDeque()[plane][sceneX][sceneY] = null;
		}

		client.updateItemPile(sceneX, sceneY);
	}
}
