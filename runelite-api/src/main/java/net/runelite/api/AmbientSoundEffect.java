/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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

/**
 * An ambient sound effect. These are loaded only at scene load and are used to play ambient
 * sound effects that are purely client side and not sent from the server.
 */
public interface AmbientSoundEffect
{
	/**
	 * The id of the sound effect
	 * @see SoundEffectID
	 * @return
	 */
	int getSoundEffectId();

	/**
	 * The background sound effect ids. One sound effect is picked from this at random.
	 * @see SoundEffectID
	 * @return
	 */
	@Nullable
	int[] getBackgroundSoundEffectIds();

	/**
	 * The plane the sound effect is on
	 * @return
	 */
	int getPlane();

	/**
	 * The min x/y position of the area this sound effect is at.
	 * @return
	 */
	LocalPoint getMinPosition();

	/**
	 * The max x/y position of the area this sound effect is at
	 * @return
	 */
	LocalPoint getMaxPosition();
}
