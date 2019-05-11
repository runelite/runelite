/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.puzzlesolver.lightbox;

import lombok.EqualsAndHashCode;

<<<<<<< HEAD:runelite-api/src/main/java/net/runelite/api/events/ActorSpawned.java
<<<<<<< HEAD
public interface ActorSpawned
{
=======
/**
 * Represents the base event where an {@link Actor} has spawned.
 * <p>
 * To hook into a more focused actor type, see the {@link PlayerSpawned}
 * or {@link NpcSpawned} events.
 * <p>
 * Examples of when this event may trigger include:
 * <ul>
 *     <li>Entering a new region or area with actors inside</li>
 *     <li>A player logging in nearby</li>
 *     <li>An actor moving into render distance</li>
 * </ul>
 */
public interface ActorSpawned
{
	/**
	 * Gets the spawned player or NPC.
	 *
	 * @return spawned entity
	 */
>>>>>>> upstream/master
	Actor getActor();
=======
@EqualsAndHashCode
public class LightboxState
{
	private final boolean[][] state = new boolean[LightBox.WIDTH][LightBox.HEIGHT];

	public void setState(int x, int y, boolean s)
	{
		state[x][y] = s;
	}

	public boolean getState(int x, int y)
	{
		return state[x][y];
	}

	public LightboxState diff(LightboxState other)
	{
		LightboxState newState = new LightboxState();

		for (int i = 0; i < LightBox.WIDTH; ++i)
		{
			for (int j = 0; j < LightBox.HEIGHT; ++j)
			{
				newState.state[i][j] = state[i][j] ^ other.state[i][j];
			}
		}

		return newState;
	}
>>>>>>> upstream/master:runelite-client/src/main/java/net/runelite/client/plugins/puzzlesolver/lightbox/LightboxState.java
}
