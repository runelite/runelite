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

import javax.annotation.Nullable;

/**
 * Represents a non-player character in the game.
 */
public interface NPC extends Actor
{
	/**
	 * Gets the ID of the NPC.
	 *
	 * @return the ID of the NPC
	 * @see NpcID
	 */
	int getId();

	@Override
	String getName();

	@Override
	int getCombatLevel();

	/**
	 * Gets the index position of this NPC in the clients cached
	 * NPC array.
	 *
	 * @return the NPC index
	 * @see Client#getCachedNPCs()
	 */
	int getIndex();

	/**
	 * Gets the composition of this NPC.
	 *
	 * @return the composition
	 */
	NPCComposition getComposition();

	/**
	 * Get the composition for this NPC and transform it if required
	 *
	 * @return the transformed NPC
	 */
	@Nullable
	NPCComposition getTransformedComposition();

	/**
	 * Returns true if this NPC has died
	 *
	 * @return
	 */
	boolean isDead();
}
