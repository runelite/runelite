/*
 * Copyright (c) 2018, Craftiii4 <Craftiii4@gmail.com>
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
package net.runelite.client.plugins.mining;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.TileObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Holds rocks mined in a certain world
 */
public class MiningWorld
{

	@Getter(AccessLevel.PACKAGE)
	private int world;

	@Getter(AccessLevel.PACKAGE)
	private final HashMap<TileObject, MinedRock> rocks = new HashMap<>();

	/**
	 * @param world		Worlds ID
	 */
	public MiningWorld(int world)
	{
		this.world = world;
	}

	/**
	 * Clears any negative respawn times on rocks stored in this world
	 */
	public void clearNegatives()
	{
		for (TileObject o : new ArrayList<>(rocks.keySet()))
		{
			MinedRock rock = rocks.get(o);
			if (rock.asSecondsNegative() < 0)
				rocks.remove(o);
		}
	}

	/**
	 * Gets the lowest time left on a rock respawn for this world
	 *
	 * @return		Seconds left on the rock that respawns first
	 */
	public int asSeconds()
	{
		int least = Integer.MAX_VALUE;
		for (MinedRock rock : new ArrayList<>(rocks.values()))
		{
			int seconds = rock.asSecondsNegative();
			if (seconds < least)
				least = seconds;
		}
		return least;
	}

}
