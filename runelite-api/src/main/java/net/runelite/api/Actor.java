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
import javax.annotation.Nullable;
import net.runelite.api.annotations.VisibleForDevtools;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;

/**
 * Represents a RuneScape actor/entity.
 */
public interface Actor extends Renderable
{
	/**
	 * Gets the combat level of the actor.
	 *
	 * @return the combat level
	 */
	int getCombatLevel();

	/**
	 * Gets the name of the actor.
	 *
	 * @return the name
	 */
	String getName();

	/**
	 * Gets the actor being interacted with.
	 * <p>
	 * Examples of interaction include:
	 * <ul>
	 *     <li>A monster focusing an Actor to attack</li>
	 *     <li>Targetting a player to trade</li>
	 *     <li>Following a player</li>
	 * </ul>
	 *
	 * @return the actor, null if no interaction is occurring
	 */
	Actor getInteracting();

	/**
	 * Gets the health ratio of the actor.
	 * <p>
	 * The ratio is the number of green bars in the overhead
	 * HP display.
	 *
	 * @return the health ratio
	 */
	int getHealthRatio();

	/**
	 * Gets the health of the actor.
	 *
	 * @return the health
	 */
	int getHealth();

	/**
	 * Gets the server-side location of the actor.
	 * <p>
	 * This value is typically ahead of where the client renders and is not
	 * affected by things such as animations.
	 *
	 * @return the server location
	 */
	WorldPoint getWorldLocation();

	/**
	 * Gets the client-side location of the actor.
	 *
	 * @return the client location
	 */
	LocalPoint getLocalLocation();

	@VisibleForDevtools
	void setIdlePoseAnimation(int animation);

	@VisibleForDevtools
	void setPoseAnimation(int animation);

	/**
	 * Gets the orientation of the actor.
	 *
	 * @return the orientation
	 * @see net.runelite.api.coords.Angle
	 */
	int getOrientation();

	/**
	 * Gets the current animation the actor is performing.
	 *
	 * @return the animation ID
	 * @see AnimationID
	 */
	int getAnimation();

	/**
	 * Sets an animation for the actor to perform.
	 *
	 * @param animation the animation ID
	 * @see AnimationID
	 */
	@VisibleForDevtools
	void setAnimation(int animation);

	/**
	 * Sets the frame of the animation the actor is performing.
	 *
	 * @param actionFrame the animation frame
	 */
	@VisibleForDevtools
	void setActionFrame(int actionFrame);

	/**
	 * Gets the graphic that is currently on the player.
	 *
	 * @return the graphic of the actor
	 * @see GraphicID
	 */
	int getGraphic();

	@VisibleForDevtools
	void setGraphic(int graphic);

	@VisibleForDevtools
	void setSpotAnimFrame(int spotAnimFrame);

	/**
	 * Gets the height of the actors model.
	 *
	 * @return the height
	 */
	int getModelHeight();

	/**
	 * Gets the canvas area of the current tile the actor is standing on.
	 *
	 * @return the current tile canvas area
	 */
	Polygon getCanvasTilePoly();

	/**
	 * Gets the point at which text should be drawn, relative to the
	 * current location with the given z-axis offset.
	 *
	 * @param graphics engine graphics
	 * @param text the text to draw
	 * @param zOffset the z-axis offset
	 * @return the text drawing location
	 */
	@Nullable
	Point getCanvasTextLocation(Graphics2D graphics, String text, int zOffset);

	/**
	 * Gets the point at which an image should be drawn, relative to the
	 * current location with the given z-axis offset.
	 *
	 * @param image the image to draw
	 * @param zOffset the z-axis offset
	 * @return the image drawing location
	 */
	Point getCanvasImageLocation(BufferedImage image, int zOffset);


	/**
	 * Gets the point at which a sprite should be drawn, relative to the
	 * current location with the given z-axis offset.
	 *
	 * @param sprite the sprite to draw
	 * @param zOffset the z-axis offset
	 * @return the sprite drawing location
	 */
	Point getCanvasSpriteLocation(SpritePixels sprite, int zOffset);

	/**
	 * Gets a point on the canvas of where this actors mini-map indicator
	 * should appear.
	 *
	 * @return mini-map location on canvas
	 */
	Point getMinimapLocation();

	/**
	 * Gets the logical height of the actors model.
	 * <p>
	 * This z-axis offset is roughly where the health bar of the actor
	 * is drawn.
	 *
	 * @return the logical height
	 */
	int getLogicalHeight();

	/**
	 * Gets the convex hull of the actors model.
	 *
	 * @return the convex hull
	 * @see net.runelite.api.model.Jarvis
	 */
	Polygon getConvexHull();

	/**
	 * Gets the world area that the actor occupies.
	 *
	 * @return the world area
	 */
	WorldArea getWorldArea();

	/**
	 * Gets the overhead text that is displayed above the actor
	 *
	 * @return the overhead text
	 */
	String getOverhead();
}
