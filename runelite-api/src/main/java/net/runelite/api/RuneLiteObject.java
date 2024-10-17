/*
 * Copyright (c) 2021, Trevor <https://github.com/Trevor159>
 * Copyright (c) 2021 Abex
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

/**
 * Represents a modified {@link GraphicsObject}
 */
public interface RuneLiteObject extends GraphicsObject
{
	/**
	 * Sets the model of the RuneLiteObject
	 */
	void setModel(Model model);

	/**
	 * Sets the animation of the RuneLiteObject
	 * If animation is null model will be static
	 */
	void setAnimation(Animation animation);

	/**
	 * Sets whether the animation of the RuneLiteObject should loop when the animation ends.
	 * If this is false the object will despawn when the animation ends.
	 * Does nothing if the animation is null.
	 */
	void setShouldLoop(boolean shouldLoop);

	/**
	 * Sets the location in the scene for the RuneLiteObject
	 */
	void setLocation(LocalPoint point, int plane);

	/**
	 * Sets the state of the RuneLiteObject
	 * Set to true to spawn the object
	 * Set to false to despawn the object
	 */
	void setActive(boolean active);

	/**
	 * Gets the state of the RuneLiteObject
	 *
	 * @return true if the RuneLiteObject is added to the scene
	 */
	boolean isActive();

	/**
	 * Get the object orientation
	 * @see net.runelite.api.coords.Angle
	 * @return
	 */
	int getOrientation();

	/**
	 * Set the object orientation
	 * @see net.runelite.api.coords.Angle
	 * @param orientation
	 */
	void setOrientation(int orientation);

	/**
	 * Get the object radius. The radius is offset from the object position to form a 2d rectangle, and the tiles
	 * the corners are in are used to determine the min and max scene x/y the object is on. These tiles are then drawn
	 * first prior to the object being drawn, so that the object renders correctly over top of each tile.
	 * The default radius is 60, marginally less than 128/2, which works well for models the size of a single tile.
	 * @return
	 */
	int getRadius();

	/**
	 * Set the object radius
	 * @see #getRadius()
	 * @param radius
	 */
	void setRadius(int radius);

	/**
	 * If true, the rectangle computed from the radius has 1 or 2 of its sides expanded by a full tile based on the
	 * orientation the object is facing. This causes the tiles the object is facing to be drawn first, even if the
	 * radius of the object would not place the object on that tile.
	 * The default is false.
	 * @return
	 */
	boolean drawFrontTilesFirst();

	/**
	 * Sets whether the front tiles are drawn first.
	 * @see #drawFrontTilesFirst()
	 * @param drawFrontTilesFirst
	 */
	void setDrawFrontTilesFirst(boolean drawFrontTilesFirst);
}
