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

import net.runelite.api.Renderable;
import net.runelite.api.SceneTilePaint;
import net.runelite.api.Tile;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSDecorativeObject;
import net.runelite.rs.api.RSGroundObject;
import net.runelite.rs.api.RSItemLayer;
import net.runelite.rs.api.RSRegion;
import net.runelite.rs.api.RSWallObject;

@Mixin(RSRegion.class)
public abstract class RSRegionMixin implements RSRegion
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	static boolean isDrawingRegion;

	@Copy("drawRegion")
	abstract void rs$drawRegion(int cameraX, int cameraY, int cameraZ, int cameraPitch, int cameraYaw, int plane);

	@Replace("drawRegion")
	void rl$drawRegion(int cameraX, int cameraY, int cameraZ, int cameraPitch, int cameraYaw, int plane)
	{
		try
		{
			isDrawingRegion = true;
			rs$drawRegion(cameraX, cameraY, cameraZ, cameraPitch, cameraYaw, plane);
			client.getCallbacks().drawRegion();
		}
		finally
		{
			isDrawingRegion = false;
		}
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
