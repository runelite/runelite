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
 * Represents a customizable GraphicsObject
 */
public interface RuneLiteObject extends GraphicsObject
{
	/**
	 * Sets the model of the RuneliteObject
	 *
	 * @param model the model
	 */
	void setModel(Model model);

	/**
	 * Sets the animation of the RuneliteObject
	 * If animation is null model will be static
	 *
	 * @param animation the animation
	 */
	void setAnimation(Sequence animation);

	/**
	 * Sets whether the animation of the RuneliteObject should loop when the animation ends.
	 * If this is false the object will despawn when the animation ends.
	 * Does nothing if the animation is null.
	 *
	 * @param shouldLoop
	 */
	void setShouldLoop(boolean shouldLoop);

	/**
	 * Sets the location in the scene for the RuneliteObject
	 *
	 * @param point the local point in the scene
	 * @param plane the plane in the scene
	 */
	void setLocation(LocalPoint point, int plane);

	/**
	 * Sets the state of the RuneliteObject
	 * Set to true to spawn the object
	 * Set to false to despawn the object
	 *
	 * @param active the state of the RuneliteObject
	 */
	void setActive(boolean active);

	/**
	 * Gets the state of the RuneliteObject
	 *
	 * @return the state of the RuneliteObject
	 */
	boolean isActive();
}
