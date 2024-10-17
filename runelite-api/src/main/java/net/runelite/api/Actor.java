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
import java.awt.Shape;
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
	 * Get the {@link WorldView} this actor belongs to
	 * @return
	 */
	WorldView getWorldView();

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
	@Nullable
	String getName();

	/**
	 * Gets if the actor is interacting with another actor.
	 * {@link #getInteracting()} will return the interacting actor,
	 * unless they are outside of the visibility range.
	 * @return
	 */
	boolean isInteracting();

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
	 * Gets the health of the actor in {@link #getHealthScale()} units.
	 *
	 * The server does not transmit actors' real health, only this value
	 * between zero and {@link #getHealthScale()}. Some actors may be
	 * missing this info, in which case -1 is returned.
	 */
	int getHealthRatio();

	/**
	 * Gets the maximum value {@link #getHealthRatio()} can return
	 *
	 * For actors with the default size health bar this is 30, but
	 * for bosses with a larger health bar this can be a larger number.
	 * Some actors may be missing this info, in which case -1 is returned.
	 */
	int getHealthScale();

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

	/**
	 * Gets the target orientation of the actor.
	 *
	 * @return the orientation
	 * @see net.runelite.api.coords.Angle
	 */
	int getOrientation();

	/**
	 * Gets the current orientation of the actor.
	 *
	 * @return the orientation
	 * @see net.runelite.api.coords.Angle
	 */
	int getCurrentOrientation();

	/**
	 * Gets the current animation the actor is performing.
	 *
	 * @return the animation ID
	 * @see AnimationID
	 */
	int getAnimation();

	/**
	 * Gets the secondary animation the actor is performing. Usually an idle animation, or one of the walking ones.
	 *
	 * @return the animation ID
	 * @see AnimationID
	 */
	int getPoseAnimation();

	/**
	 * Set the idle pose animation.
	 * @param animation
	 * @see AnimationID
	 */
	void setPoseAnimation(int animation);

	/**
	 * Get the frame of the idle animation the actor is performing
	 * @return
	 */
	int getPoseAnimationFrame();

	/**
	 * Set the frame of the idle animation the actor is performing
	 * @param frame
	 */
	void setPoseAnimationFrame(int frame);

	/**
	 * The idle pose animation. If the actor is not walking or otherwise animating, this will be used
	 * for their pose animation.
	 *
	 * @return the animation ID
	 * @see AnimationID
	 */
	int getIdlePoseAnimation();

	@VisibleForDevtools
	void setIdlePoseAnimation(int animation);

	/**
	 * Animation used for rotating left if the actor is also not walking
	 *
	 * @return the animation ID
	 * @see AnimationID
	 */
	int getIdleRotateLeft();

	void setIdleRotateLeft(int animationID);

	/**
	 * Animation used for rotating right if the actor is also not walking
	 *
	 * @return the animation ID
	 * @see AnimationID
	 */
	int getIdleRotateRight();

	void setIdleRotateRight(int animationID);

	/**
	 * Animation used for walking
	 *
	 * @return the animation ID
	 * @see AnimationID
	 */
	int getWalkAnimation();

	void setWalkAnimation(int animationID);

	/**
	 * Animation used for rotating left while walking
	 *
	 * @return the animation ID
	 * @see AnimationID
	 */
	int getWalkRotateLeft();

	void setWalkRotateLeft(int animationID);

	/**
	 * Animation used for rotating right while walking
	 *
	 * @return the animation ID
	 * @see AnimationID
	 */
	int getWalkRotateRight();

	void setWalkRotateRight(int animationID);

	/**
	 * Animation used for an about-face while walking
	 *
	 * @return the animation ID
	 * @see AnimationID
	 */
	int getWalkRotate180();

	void setWalkRotate180(int animationID);

	/**
	 * Animation used for running
	 *
	 * @return the animation ID
	 * @see AnimationID
	 */
	int getRunAnimation();

	void setRunAnimation(int animationID);

	/**
	 * Sets an animation for the actor to perform.
	 *
	 * @param animation the animation ID
	 * @see AnimationID
	 */
	@VisibleForDevtools
	void setAnimation(int animation);

	/**
	 * Get the frame of the animation the actor is performing
	 *
	 * @return the frame
	 */
	int getAnimationFrame();

	/**
	 * Sets the frame of the animation the actor is performing.
	 *
	 * @param frame the animation frame
	 * @deprecated use setAnimationFrame
	 */
	@Deprecated
	void setActionFrame(int frame);

	/**
	 * Sets the frame of the animation the actor is performing.
	 *
	 * @param frame the animation frame
	 */
	void setAnimationFrame(int frame);

	/**
	 * Get the spotanims on the actor.
	 * It is important to not modify the table directly or indirectly via
	 * eg. iterator remove().
	 * @see #createSpotAnim(int, int, int, int)
	 * @see #removeSpotAnim(int)
	 * @see #clearSpotAnims()
	 * @return
	 */
	IterableHashTable<ActorSpotAnim> getSpotAnims();

	/**
	 * Check if the actor has a spotanim
	 * @param spotAnimId the spot anim id
	 * @see GraphicID
	 * @return
	 */
	boolean hasSpotAnim(int spotAnimId);

	/**
	 * Create an actor spotanim
	 * @param id key for the {@link #getSpotAnims()} table
	 * @param spotAnimId spotanim id {@link GraphicID}
	 * @param height height offspot for spot anim
	 * @param delay initial delay, in client ticks, before spotanim is active
	 */
	void createSpotAnim(int id, int spotAnimId, int height, int delay);

	/**
	 * Remove an actor spotanim
	 * @param id key for the {@link #getSpotAnims()} table
	 */
	void removeSpotAnim(int id);

	/**
	 * Remove all actor spotanims
	 */
	void clearSpotAnims();

	/**
	 * Get the graphic/spotanim that is currently on the actor.
	 * Actors can have multiple spotanims, this gets only one of them. Use {@link #hasSpotAnim(int)} instead.
	 *
	 * @return the spotanim of the actor
	 * @see GraphicID
	 * @deprecated see {@link #hasSpotAnim(int)}
	 */
	@Deprecated
	int getGraphic();

	/**
	 * Set the graphic/spotanim that is currently on the actor.
	 *
	 * @param graphic The spotanim id
	 * @see GraphicID
	 * @deprecated see {@link #createSpotAnim(int, int, int, int)}
	 */
	@Deprecated
	void setGraphic(int graphic);

	/**
	 * Get the height of the graphic/spotanim on the actor
	 * @return
	 * @deprecated see {@link ActorSpotAnim#getHeight()}
	 */
	@Deprecated
	int getGraphicHeight();

	/**
	 * Set the height of the graphic/spotanim on the actor
	 * @param height
	 * @deprecated see {@link ActorSpotAnim#setHeight(int)}
	 */
	@Deprecated
	void setGraphicHeight(int height);

	/**
	 * Get the frame of the currently playing spotanim
	 *
	 * @return
	 * @deprecated see {@link ActorSpotAnim#getFrame()}
	 */
	@Deprecated
	int getSpotAnimFrame();

	/**
	 * Set the frame of the currently playing spotanim
	 *
	 * @param spotAnimFrame
	 * @deprecated see {@link ActorSpotAnim#setFrame(int)}
	 */
	@Deprecated
	void setSpotAnimFrame(int spotAnimFrame);

	/**
	 * Gets the canvas area of the current tiles the actor is standing on.
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
	Shape getConvexHull();

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
	String getOverheadText();

	/**
	 * Sets the overhead text that is displayed above the actor
	 *
	 * @param overheadText the overhead text
	 */
	void setOverheadText(String overheadText);

	/**
	 * Get the number of cycles/client ticks remaining before the overhead text is timed out
	 *
	 * @return
	 */
	int getOverheadCycle();

	/**
	 * Set the number of cycles/client ticks before the overhead text is timed out
	 *
	 * @param cycles
	 */
	void setOverheadCycle(int cycles);

	/**
	 * Returns true if this actor has died
	 *
	 * @return
	 */
	boolean isDead();

	/**
	 * Sets the dead status of this actor
	 *
	 * @param dead
	 * @see #isDead()
	 */
	void setDead(boolean dead);
}
