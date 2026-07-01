/*
 * Copyright (c) 2024, Adam <Adam@sigterm.info>
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
import org.intellij.lang.annotations.MagicConstant;

public interface WorldEntity extends CameraFocusableEntity
{
	WorldView getWorldView();

	/**
	 * Get the location of this world entity in the top level world.
	 *
	 * @return
	 */
	LocalPoint getLocalLocation();

	/**
	 * Get the orientation of this world entity in the top level world.
	 *
	 * @return
	 */
	int getOrientation();

	/**
	 * Get the destination that the WorldEntity is moving toward.
	 * After receiving a destination from the server, the client will
	 * interpolate movement along this route until the next game tick
	 * (with some added buffer for lag compensation).
	 *
	 * @return The target {@link LocalPoint} in the top-level {@link WorldView}.
	 */
	LocalPoint getTargetLocation();

	/**
	 * Get the target orientation of this world entity in the top level world.
	 *
	 * @return
	 * @see #getTargetLocation()
	 */
	int getTargetOrientation();

	/**
	 * Transform a point within the world entity to the overworld
	 *
	 * @param point
	 * @return
	 */
	LocalPoint transformToMainWorld(LocalPoint point);

	/**
	 * Return true if this worldentity is overlapped
	 *
	 * @return
	 */
	boolean isHiddenForOverlap();

	WorldEntityConfig getConfig();

	@MagicConstant(intValues = {OWNER_TYPE_NOT_PLAYER, OWNER_TYPE_OTHER_PLAYER, OWNER_TYPE_SELF_PLAYER})
	int getOwnerType();

	int OWNER_TYPE_NOT_PLAYER = 0;
	int OWNER_TYPE_OTHER_PLAYER = 1;
	int OWNER_TYPE_SELF_PLAYER = 2;
}
