/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.api;

import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import java.util.List;

/**
 * Represents a tile in the game.
 */
public interface Tile
{
	/**
	 * Gets the decoration on the tile.
	 *
	 * @return the tile decoration
	 */
	DecorativeObject getDecorativeObject();

	/**
	 * Gets all game objects on the tile.
	 *
	 * @return the game objects
	 */
	GameObject[] getGameObjects();

	/**
	 * Gets the items held on this tile.
	 *
	 * @return the item
	 */
	TileItemPile getItemLayer();

	/**
	 * Gets the object on the ground layer of the tile.
	 *
	 * @return the ground object
	 */
	GroundObject getGroundObject();

	/**
	 * Gets the wall of the tile.
	 *
	 * @return the wall object
	 */
	WallObject getWallObject();

	/**
	 * Gets the scene paint of the tile.
	 *
	 * @return the paint
	 */
	TilePaint getTilePaint();

	/**
	 * Gets the model of the tile in the scene.
	 *
	 * @return the tile model
	 */
	TileModel getTileModel();

	/**
	 * Gets the location coordinate of the tile in the world.
	 *
	 * @return the world location
	 */
	WorldPoint getWorldLocation();

	/**
	 * Gets the location coordinate of the tile in scene coords
	 *
	 * @return the scene location
	 */
	Point getSceneLocation();

	/**
	 * Gets the local coordinate of the tile.
	 *
	 * @return the local location
	 */
	LocalPoint getLocalLocation();

	/**
	 * Gets the plane that this tile is on.
	 *
	 * @return the plane
	 */
	int getPlane();

	/**
	 * Get the plane this tile is rendered on, which is where the tile heights are from.
	 *
	 * @return
	 */
	int getRenderLevel();

	/**
	 * Computes and returns whether this tile has line of sight to another.
	 *
	 * @param other the other tile
	 * @return true if there is no sight obstruction, false otherwise
	 */
	boolean hasLineOfSightTo(Tile other);

	/**
	 * Get all the ground items for this tile
	 *
	 * @return the ground items
	 */
	List<TileItem> getGroundItems();

	/**
	 * Return the tile under this one, if this tile is a bridge
	 */
	Tile getBridge();
}
