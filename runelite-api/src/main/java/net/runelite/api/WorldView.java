/*
 * Copyright (c) 2024 Abex
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

import javax.annotation.Nullable;

public interface WorldView
{
	int TOPLEVEL = -1;

	/**
	 * Get the world view id
	 * @return the id, or -1 if this is the top level worldview
	 */
	int getId();

	/**
	 * Test if this worldview is the top level world view.
	 * @return
	 */
	boolean isTopLevel();

	/**
	 * Gets the worldview's scene
	 */
	Scene getScene();

	/**
	 * Gets all of the Players in this view
	 */
	IndexedObjectSet<? extends Player> players();

	/**
	 * Gets all the Non Player Characters in this view
	 */
	IndexedObjectSet<? extends NPC> npcs();

	/**
	 * Gets all the WorldEntities in this view
	 */
	IndexedObjectSet<? extends WorldEntity> worldEntities();

	/**
	 * Gets an array of tile collision data.
	 * <p>
	 * The index into the array is the plane/z-axis coordinate.
	 *
	 * @return the collision data
	 */
	@Nullable
	CollisionData[] getCollisionMaps();

	/**
	 * Gets the current plane the player is on.
	 * <p>
	 * This value indicates the current map level above ground level, where
	 * ground level is 0. For example, going up a ladder in Lumbridge castle
	 * will put the player on plane 1.
	 * <p>
	 * Note: This value will never be below 0. Basements and caves below ground
	 * level use a tile offset and are still considered plane 0 by the game.
	 *
	 * @return the plane
	 */
	int getPlane();

	/**
	 * Gets a 3D array containing the heights of tiles in the
	 * current scene.
	 *
	 * @return the tile heights
	 */
	int[][][] getTileHeights();

	/**
	 * Gets a 3D array containing the settings of tiles in the
	 * current scene.
	 *
	 * @return the tile settings
	 */
	byte[][][] getTileSettings();

	/**
	 * Get the size of the world view, x-axis
	 * @return
	 */
	int getSizeX();

	/**
	 * Get the size of the world view, y-axis
	 * @return
	 */
	int getSizeY();

	/**
	 * Returns the x-axis base coordinate.
	 * <p>
	 * This value is the x-axis world coordinate of tile (0, 0) in
	 * the current scene (ie. the bottom-left most coordinates in the scene).
	 *
	 * @return the base x-axis coordinate
	 */
	int getBaseX();

	/**
	 * Returns the y-axis base coordinate.
	 * <p>
	 * This value is the y-axis world coordinate of tile (0, 0) in
	 * the current scene (ie. the bottom-left most coordinates in the scene).
	 *
	 * @return the base y-axis coordinate
	 */
	int getBaseY();

	/**
	 * Create a projectile.
	 * @param id projectile/spotanim id
	 * @param plane plane the projectile is on
	 * @param startX local x coordinate the projectile starts at
	 * @param startY local y coordinate the projectile starts at
	 * @param startZ local z coordinate the projectile starts at - includes tile height
	 * @param startCycle cycle the project starts
	 * @param endCycle cycle the projectile ends
	 * @param slope
	 * @param startHeight start height of projectile - excludes tile height
	 * @param endHeight end height of projectile - excludes tile height
	 * @param target optional actor target
	 * @param targetX target x - if an actor target is supplied should be the target x
	 * @param targetY target y - if an actor target is supplied should be the target y
	 * @return the new projectile
	 */
	@Deprecated
	Projectile createProjectile(int id, int plane, int startX, int startY, int startZ, int startCycle, int endCycle,
		int slope, int startHeight, int endHeight, @Nullable Actor target, int targetX, int targetY);

	/**
	 * Gets a list of all graphics objects currently drawn.
	 *
	 * @return all graphics objects
	 */
	Deque<GraphicsObject> getGraphicsObjects();

	/**
	 * Gets the currently selected tile. (ie. last right clicked tile)
	 *
	 * @return the selected tile
	 */
	@Nullable
	Tile getSelectedSceneTile();

	/**
	 * Check if this scene is an instance
	 * @see #getInstanceTemplateChunks()
	 * @return
	 */
	boolean isInstance();

	/**
	 * Contains a 3D array of template chunks for instanced areas.
	 * <p>
	 * The array returned is of format [z][x][y], where z is the
	 * plane, x and y the x-axis and y-axis coordinates of a tile
	 * divided by the size of a chunk.
	 * <p>
	 * The bits of the int value held by the coordinates are -1 if there is no data,
	 * structured in the following format:
	 * <pre>{@code
	 *  0                   1                   2                   3
	 *  0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
	 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
	 * | |rot|     y chunk coord     |    x chunk coord    |pln|       |
	 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
	 * }</pre>
	 * @return the array of instance template chunks
	 * @see Constants#CHUNK_SIZE
	 * @see InstanceTemplates
	 */
	int[][][] getInstanceTemplateChunks();

	/**
	 * Gets an array of map region IDs that are currently loaded.
	 *
	 * @return the map regions
	 */
	int[] getMapRegions();
}
