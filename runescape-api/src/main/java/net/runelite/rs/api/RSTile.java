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
package net.runelite.rs.api;

import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GroundObject;
import net.runelite.api.ItemLayer;
import net.runelite.api.SceneTileModel;
import net.runelite.api.SceneTilePaint;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.mapping.Import;

public interface RSTile extends Tile
{
	@Import("objects")
	@Override
	GameObject[] getGameObjects();

	@Import("itemLayer")
	@Override
	ItemLayer getItemLayer();

	@Import("decorativeObject")
	@Override
	DecorativeObject getDecorativeObject();

	@Import("groundObject")
	@Override
	GroundObject getGroundObject();

	@Import("wallObject")
	@Override
	WallObject getWallObject();

	@Import("paint")
	@Override
	SceneTilePaint getSceneTilePaint();

	@Import("overlay")
	@Override
	SceneTileModel getSceneTileModel();

	@Import("x")
	int getX();

	@Import("y")
	int getY();

	@Import("plane")
	@Override
	int getPlane();

	@Import("renderLevel")
	@Override
	int getRenderLevel();

	@Import("physicalLevel")
	int getPhysicalLevel();

	@Import("flags")
	int getFlags();

	@Import("bridge")
	@Override
	RSTile getBridge();

	@Import("draw")
	boolean isDraw();

	@Import("draw")
	void setDraw(boolean draw);

	@Import("visible")
	boolean isVisible();

	@Import("visible")
	void setVisible(boolean visible);

	@Import("drawEntities")
	void setDrawEntities(boolean drawEntities);

	@Import("wallCullDirection")
	void setWallCullDirection(int wallCullDirection);
}
