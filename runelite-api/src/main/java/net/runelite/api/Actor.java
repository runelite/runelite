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
package net.runelite.api;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import net.runelite.api.annotations.VisibleForDevtools;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;

public interface Actor extends Renderable
{
	int getCombatLevel();

	String getName();

	Actor getInteracting();

	int getHealthRatio();

	int getHealth();

	/**
	 * Retrieve the server location of the actor. Note that this is typically
	 * a couple steps ahead of where the client renders the actor.
	 * @return Returns the server location of the actor.
	 */
	WorldPoint getWorldLocation();

	LocalPoint getLocalLocation();

	int getOrientation();

	int getAnimation();

	@VisibleForDevtools
	void setAnimation(int animation);

	@VisibleForDevtools
	void setActionFrame(int actionFrame);

	int getGraphic();

	@VisibleForDevtools
	void setGraphic(int graphic);

	@VisibleForDevtools
	void setSpotAnimFrame(int spotAnimFrame);

	int getModelHeight();

	Polygon getCanvasTilePoly();

	Point getCanvasTextLocation(Graphics2D graphics, String text, int zOffset);

	Point getCanvasImageLocation(Graphics2D graphics, BufferedImage image, int zOffset);

	Point getCanvasSpriteLocation(Graphics2D graphics, SpritePixels sprite, int zOffset);

	Point getMinimapLocation();

	/**
	 * Returns the logical height of the actor's model. This is roughly where the health bar is drawn.
	 */
	int getLogicalHeight();

	Polygon getConvexHull();

	WorldArea getWorldArea();
}
