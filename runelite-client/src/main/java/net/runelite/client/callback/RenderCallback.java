/*
 * Copyright (c) 2025, Adam <Adam@sigterm.info>
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
package net.runelite.client.callback;

import net.runelite.api.Renderable;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;

public interface RenderCallback
{
	/**
	 * Tests if an entity should be added to the scene.
	 * This is called multiple times per frame from the client thread.
	 * Entities are temporary entities (players, npcs, projectiles, spotanims, etc).
	 * Preventing an entity from being added removes their clickbox and also allows other entities
	 * which would have been hidden to be added.
	 * @param renderable the entity
	 * @param ui true if this test is for drawing the ui (hitbars etc)
	 * @return
	 */
	default boolean addEntity(Renderable renderable, boolean ui)
	{
		return true;
	}

	/**
	 * Test if a tile should be drawn.
	 * This is called on scene upload, by the maploader thread.
	 * @param scene
	 * @param tile
	 * @return
	 */
	default boolean drawTile(Scene scene, Tile tile)
	{
		return true;
	}

	/**
	 * Test if a {@link TileObject} should be drawn.
	 * This is called on scene upload, by the maploader thread, as well as
	 * each frame by the client thread for dynamic objects (animated objects),
	 * as well as temporary entities (players, npcs, projectiles, spotanims, etc).
	 * @param scene
	 * @param object
	 * @return
	 */
	default boolean drawObject(Scene scene, TileObject object)
	{
		return true;
	}
}
