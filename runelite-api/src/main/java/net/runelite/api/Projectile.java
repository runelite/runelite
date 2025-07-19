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

import javax.annotation.Nullable;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

/**
 * Represents a projectile entity. (ie. cannonball, arrow)
 */
public interface Projectile extends Renderable
{
	/**
	 * Gets the ID of the projectile.
	 *
	 * @return the projectile ID
	 * @see net.runelite.api.gameval.SpotanimID
	 */
	int getId();

	/**
	 * Get the level the projectile starts on.
	 *
	 * @return
	 */
	int getSourceLevel();

	/**
	 * Get the point the projectile starts at.
	 *
	 * @return
	 */
	WorldPoint getSourcePoint();

	/**
	 * Get the actor the projectile starts at.
	 *
	 * @return
	 */
	@Nullable
	Actor getSourceActor();

	/**
	 * Get the level the projectile ends on.
	 * @return
	 */
	int getTargetLevel();

	/**
	 * Get the point the projectile ends at.
	 *
	 * @return
	 */
	WorldPoint getTargetPoint();

	/**
	 * Get the actor the projectile ends at.
	 *
	 * @return
	 */
	@Nullable
	Actor getTargetActor();

	/**
	 * Gets the actor that is targeted by this projectile.
	 *
	 * @return the target actor, or null if this projectile is an AoE attack
	 */
	@Deprecated
	default Actor getInteracting()
	{
		return getTargetActor();
	}

	/**
	 * Get the target point of the projectile. For projectiles with an actor target,
	 * this is updated each frame to the actor position.
	 *
	 * @return
	 */
	@Deprecated
	LocalPoint getTarget();

	/**
	 * Gets the original x-axis coordinate that this projectile started from.
	 *
	 * @return the original coordinate
	 */
	@Deprecated
	int getX1();

	/**
	 * Gets the original y-axis coordinate that this projectile started from.
	 *
	 * @return the original coordinate
	 */
	@Deprecated
	int getY1();

	/**
	 * Gets the plane that the projectile is on.
	 *
	 * @return the plane
	 */
	@Deprecated
	int getFloor();

	/**
	 * Gets the height of the projectile.
	 *
	 * @return the height
	 */
	@Deprecated
	int getHeight();

	/**
	 * Gets the ending height of the projectile.
	 *
	 * @return the ending height
	 */
	int getEndHeight();

	/**
	 * Gets the game cycle that the projectile begun movement at.
	 *
	 * @return the start game cycle
	 */
	int getStartCycle();

	/**
	 * Gets the game cycle that the projectile will reach its target at.
	 *
	 * @return the end game cycle
	 */
	int getEndCycle();

	/**
	 * Sets the game cycle the projectile will reach its target at. The
	 * projectile automatically despawns after this time, and setting the
	 * end cycle to a time in the past is an effective way of removing the
	 * projectile.
	 * @param cycle
	 */
	void setEndCycle(int cycle);

	/**
	 * Gets the remaining game cycles until the projectile reaches its
	 * target and despawns.
	 *
	 * @return the remaining game cycles
	 */
	int getRemainingCycles();

	/**
	 * Gets the slope of the projectile.
	 * <p>
	 * This value indicates how much arc the projectile can have. Projectiles
	 * with larger slopes have a more noticeable arc when thrown.
	 *
	 * @return the slope of the projectile
	 */
	int getSlope();

	/**
	 * Get the offset position from the start position where the projectile starts
	 * @return
	 */
	int getStartPos();

	/**
	 * Gets the starting height of the projectile.
	 *
	 * @return the starting height
	 */
	int getStartHeight();

	/**
	 * Gets the current x-axis coordinate of the projectile.
	 *
	 * @return the x-axis coordinate
	 */
	double getX();

	/**
	 * Gets the current y-axis coordinate of the projectile.
	 *
	 * @return the y-axis coordinate
	 */
	double getY();

	/**
	 * Gets the current z-axis coordinate of the projectile.
	 *
	 * @return the z-axis coordinate
	 */
	double getZ();

	/**
	 * Get the projectile orientation in JAU
	 *
	 * @return
	 */
	int getOrientation();

	/**
	 * The animation of the projectile
	 * @return
	 */
	@Nullable
	Animation getAnimation();

	/**
	 * The frame of the current animation
	 * @return
	 */
	int getAnimationFrame();
}
