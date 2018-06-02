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

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Area;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

/**
 * Represents an object that a tile holds.
 */
public interface TileObject
{
	/**
	 * Gets the hashed value of this object.
	 *
	 * @return the object hash
	 */
	long getHash();

	/**
	 * Gets the x-axis coordinate of the object in local context.
	 *
	 * @return the x-axis coordinate
	 */
	int getX();

	/**
	 * Gets the y-axis coordinate of the object in local context.
	 *
	 * @return the y-axis coordinate
	 */
	int getY();

	/**
	 * Gets the plane of the tile that the object is on.
	 *
	 * @return the tile plane
	 */
	int getPlane();

	/**
	 * Gets the ID of the object.
	 *
	 * @return the object ID
	 */
	int getId();

	/**
	 * Gets the location coordinate of the object in the world.
	 *
	 * @return the world location
	 */
	WorldPoint getWorldLocation();

	/**
	 * Gets the local location of the object.
	 *
	 * @return the local location
	 */
	LocalPoint getLocalLocation();

	/**
	 * Gets the upper-left canvas point where this object is drawn.
	 *
	 * @return the canvas location
	 */
	Point getCanvasLocation();

	/**
	 * Gets the upper-left canvas point where this object is drawn,
	 * offset by the passed value.
	 *
	 * @param zOffset the z-axis offset
	 * @return the canvas location
	 */
	Point getCanvasLocation(int zOffset);

	/**
	 * Gets the polygon of the objects model as drawn on the canvas.
	 *
	 * @return the canvas polygon
	 */
	Polygon getCanvasTilePoly();

	/**
	 * Gets the text position on the canvas.
	 *
	 * @param graphics the client graphics
	 * @param text the text to draw
	 * @param zOffset the offset from ground plane
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
	 * Get the on-screen clickable area of the object.
	 *
	 * @return the clickable area
	 */
	Area getClickbox();
}
