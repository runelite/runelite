/*
 * Copyright (c) 2024, LlemonDuck <napkinorton@gmail.com>
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

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.coords.LocalPoint;

@Getter
@Setter
public abstract class RuneLiteObjectController
{

	private int x;
	private int y;
	private int z;

	private int worldView = -1;
	private int level;

	/**
	 * The radius is offset from the object position to form a 2d rectangle, and the tiles
	 * the corners are in are used to determine the min and max scene x/y the object is on. These tiles are then drawn
	 * first prior to the object being drawn, so that the object renders correctly over top of each tile.
	 * The default radius is 60, marginally less than 128/2, which works well for models the size of a single tile.
	 */
	private int radius = 60;

	/**
	 * If true, the rectangle computed from the radius has 1 or 2 of its sides expanded by a full tile based on the
	 * orientation the object is facing. This causes the tiles the object is facing to be drawn first, even if the
	 * radius of the object would not place the object on that tile.
	 * The default is false.
	 */
	private boolean drawFrontTilesFirst = false;

	/**
	 * The object orientation
	 * @see net.runelite.api.coords.Angle
	 */
	private int orientation = 0;

	/**
	 * Sets the location in the scene for the RuneLiteObjectController
	 */
	public void setLocation(LocalPoint point, int level)
	{
		setX(point.getX());
		setY(point.getY());
		setWorldView(point.getWorldView());
		setLevel(level);
	}

	public LocalPoint getLocation()
	{
		return new LocalPoint(x, y, worldView);
	}

	/**
	 * Called every frame the RuneLiteObject is registered and in the scene
	 *
	 * @param ticksSinceLastFrame The number of client ticks since the last frame
	 */
	public void tick(int ticksSinceLastFrame)
	{
	}

	/**
	 * Called every frame to get a model to render. The returned model is not modified and
	 * can be a shared model.
	 */
	public abstract Model getModel();

}
