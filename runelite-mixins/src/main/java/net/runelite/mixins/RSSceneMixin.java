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

import net.runelite.api.Perspective;
import net.runelite.api.Renderable;
import net.runelite.api.SceneTilePaint;
import net.runelite.api.Tile;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSDecorativeObject;
import net.runelite.rs.api.RSGroundObject;
import net.runelite.rs.api.RSItemLayer;
import net.runelite.rs.api.RSScene;
import net.runelite.rs.api.RSTile;
import net.runelite.rs.api.RSWallObject;

@Mixin(RSScene.class)
public abstract class RSSceneMixin implements RSScene
{
	private static final int MAX_DISTANCE = 25;

	private static final int PITCH_LOWER_LIMIT = 128;
	private static final int PITCH_UPPER_LIMIT = 383;

	@Shadow("clientInstance")
	private static RSClient client;

	@Shadow("pitchRelaxEnabled")
	private static boolean pitchRelaxEnabled;

	@Replace("drawScene")
	void rl$drawScene(int cameraX, int cameraY, int cameraZ, int cameraPitch, int cameraYaw, int plane)
	{
		final int maxX = getMaxX();
		final int maxY = getMaxY();
		final int maxZ = getMaxZ();

		final int minLevel = getMinLevel();

		final RSTile[][][] tiles = getTiles();
		final int distance = MAX_DISTANCE;

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
							&& (renderArea[x - screenCenterX + MAX_DISTANCE][y - screenCenterZ + MAX_DISTANCE]
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
							client.getCallbacks().drawScene();
							return;
						}
					}
				}
			}
		}

		client.setCheckClick(false);
		client.getCallbacks().drawScene();
	}

	@Copy("addBoundaryDecoration")
	abstract public void rs$addBoundaryDecoration(int plane, int x, int y, int floor, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10, long hash, int var12);

	@Replace("addBoundaryDecoration")
	public void rl$addBoundaryDecoration(int plane, int x, int y, int floor, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10, long hash, int var12)
	{
		rs$addBoundaryDecoration(plane, x, y, floor, var5, var6, var7, var8, var9, var10, hash, var12);
		Tile tile = getTiles()[plane][x][y];
		if (tile != null)
		{
			RSDecorativeObject object = (RSDecorativeObject) tile.getDecorativeObject();
			if (object != null)
			{
				object.setPlane(plane);
			}
		}
	}

	@Copy("addItemPile")
	abstract public void rs$addItemPile(int plane, int x, int y, int hash, Renderable var5, long var6, Renderable var7, Renderable var8);

	@Replace("addItemPile")
	public void rl$addItemPile(int plane, int x, int y, int hash, Renderable var5, long var6, Renderable var7, Renderable var8)
	{
		rs$addItemPile(plane, x, y, hash, var5, var6, var7, var8);
		Tile tile = getTiles()[plane][x][y];
		if (tile != null)
		{
			RSItemLayer itemLayer = (RSItemLayer) tile.getItemLayer();
			if (itemLayer != null)
			{
				itemLayer.setPlane(plane);
			}
		}
	}

	@Copy("groundObjectSpawned")
	abstract public void rs$groundObjectSpawned(int plane, int x, int y, int floor, Renderable var5, long hash, int var7);

	@Replace("groundObjectSpawned")
	public void rl$groundObjectSpawned(int plane, int x, int y, int floor, Renderable var5, long hash, int var7)
	{
		rs$groundObjectSpawned(plane, x, y, floor, var5, hash, var7);
		Tile tile = getTiles()[plane][x][y];
		if (tile != null)
		{
			RSGroundObject groundObject = (RSGroundObject) tile.getGroundObject();
			if (groundObject != null)
			{
				groundObject.setPlane(plane);
			}
		}
	}

	@Copy("addBoundary")
	abstract public void rs$addBoundary(int plane, int x, int y, int floor, Renderable var5, Renderable var6, int var7, int var8, long hash, int var10);

	@Replace("addBoundary")
	public void rl$addBoundary(int plane, int x, int y, int floor, Renderable var5, Renderable var6, int var7, int var8, long hash, int var10)
	{
		rs$addBoundary(plane, x, y, floor, var5, var6, var7, var8, hash, var10);
		Tile tile = getTiles()[plane][x][y];
		if (tile != null)
		{
			RSWallObject wallObject = (RSWallObject) tile.getWallObject();
			if (wallObject != null)
			{
				wallObject.setPlane(plane);
			}
		}
	}

	@Copy("drawTileUnderlay")
	abstract public void rs$drawTileUnderlay(SceneTilePaint tile, int z, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y);

	@Replace("drawTileUnderlay")
	public void rl$drawTileUnderlay(SceneTilePaint tile, int z, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y)
	{
		try
		{
			rs$drawTileUnderlay(tile, z, pitchSin, pitchCos, yawSin, yawCos, x, y);
		}
		catch (Exception ex)
		{
			client.getLogger().warn("error during tile underlay rendering", ex);
		}
	}
}
