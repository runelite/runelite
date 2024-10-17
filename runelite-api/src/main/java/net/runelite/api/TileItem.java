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

import org.intellij.lang.annotations.MagicConstant;

/**
 * Represents an item inside an {@link ItemLayer}.
 */
public interface TileItem extends Renderable
{
	int OWNERSHIP_NONE = 0;
	int OWNERSHIP_SELF = 1;
	int OWNERSHIP_OTHER = 2;
	int OWNERSHIP_GROUP = 3;

	/**
	 * @return the ID of the item
	 * @see ItemID
	 */
	int getId();

	int getQuantity();

	/**
	 * Get the time, in server ticks, when the item becomes visible to other players
	 * @see Client#getTickCount()
	 * @return
	 */
	int getVisibleTime();

	/**
	 * Get the time, in server ticks, when the item despawns
	 * @see Client#getTickCount()
	 * @return
	 */
	int getDespawnTime();

	/**
	 * Get the item ownership
	 * @return
	 */
	@MagicConstant(intValues = {OWNERSHIP_NONE, OWNERSHIP_SELF, OWNERSHIP_OTHER, OWNERSHIP_GROUP})
	int getOwnership();

	/**
	 * Test whether the item is private
	 * @return
	 */
	boolean isPrivate();
}
