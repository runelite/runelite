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

import java.awt.Shape;

/**
 * Represents the wall of a tile, which is an un-passable boundary.
 */
public interface WallObject extends TileObject
{
	/**
	 * Gets the first orientation of the wall.
	 *
	 * @return the first orientation, 0-2048 where 0 is north
	 */
	int getOrientationA();

	/**
	 * Gets the second orientation value of the wall.
	 *
	 * @return the second orientation, 0-2048 where 0 is north
	 */
	int getOrientationB();

	/**
	 * Gets the boundary configuration of the wall.
	 *
	 * @return the boundary configuration
	 */
	int getConfig();

	Entity getEntity1();
	Entity getEntity2();

	Model getModelA();
	Model getModelB();

	/**
	 * Gets the convex hull of the objects model.
	 *
	 * @return the convex hull
	 * @see net.runelite.api.model.Jarvis
	 */
	Shape getConvexHull();
}
