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
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import javax.annotation.Nullable;

/**
 * Represents an object on a Tile
 */
public interface TileObject extends Locatable
{
	long getHash();

	/**
	 * Gets the x-axis coordinate of the object in local context.
	 *
	 * @see LocalPoint
	 */
	int getX();

	/**
	 * Gets the y-axis coordinate of the object in local context.
	 *
	 * @see LocalPoint
	 */
	int getY();

	/**
	 * Gets the plane of the tile that the object is on.
	 */
	int getPlane();

	/**
	 * Gets the ID of the object.
	 *
	 * @see ObjectID
	 * @see NullObjectID
	 */
	int getId();

	WorldPoint getWorldLocation();

	LocalPoint getLocalLocation();

	/**
	 * Calculates the position of the center of this tile on the canvas
	 */
	Point getCanvasLocation();

	/**
	 * Calculates the position of the center of this tile on the canvas
	 *
	 * @param zOffset Vertical offset to apply before projection
	 */
	Point getCanvasLocation(int zOffset);

	/**
	 * Creates a polygon outlining the tile this object is on
	 */
	Polygon getCanvasTilePoly();

	/**
	 * Calculates the canvas point to center {@code text} above the tile this object is on.
	 *
	 * @param graphics the graphics to use for font size calculation
	 * @param zOffset Vertical offset to apply before projection
	 * @return the canvas point to draw the text at
	 */
	Point getCanvasTextLocation(Graphics2D graphics, String text, int zOffset);

	/**
	 * Gets a point on the canvas of where this objects mini-map indicator
	 * should appear.
	 *
	 * @return mini-map location on canvas
	 */
	Point getMinimapLocation();

	/**
	 * Calculate the on-screen clickable area of the object.
	 */
	@Nullable
	Shape getClickbox();
}
