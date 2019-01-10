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

public class MinedRock
{

	@Getter(AccessLevel.PACKAGE)
	private final MiningRockType type;

	private final long respawnTime;

	private final long maxRespawnTime;

	public MinedRock(MiningRockType type, boolean halve)
	{
		this.type = type;
		this.respawnTime = System.currentTimeMillis() + (int)((halve ? type.getRespawnTime() / 2 : type.getRespawnTime()) * 1000);
		this.maxRespawnTime = type.getMaxRespawnTime() == -1 ? -1 : System.currentTimeMillis() + (int)((halve ? type.getMaxRespawnTime() / 2 : type.getMaxRespawnTime()) * 1000);
	}

	/**
	 * Gets the time until a rock respawns in seconds
	 *
	 * @return 		Seconds until the rock respawns. Minimum return value is 1, unless the rock has a respawn range, in which case can return 0
	 */
	public int asSeconds()
	{
		long remaining = respawnTime - System.currentTimeMillis();
		if (remaining > 0)
		{
			return (int) (remaining / 1000) + (remaining % 1000 > 0 ? 1 : 0);
		}
		else
		{
			return hasMax() ? 0 : 1;
		}
	}

	/**
	 * Gets the maximum time a ore can take to respawn
	 *
	 * @return 		-1 if the ore does not have a respawn range, else the max of the respawn range
	 */
	public int asSecondsMax()
	{
		if (maxRespawnTime == -1)
		{
			return -1;
		}
		long remaining = maxRespawnTime - System.currentTimeMillis();
		if (remaining > 0)
		{
			return (int) (remaining / 1000) + (remaining % 1000 > 0 ? 1 : 0);
		}
		else
		{
			return 1;
		}
	}

	/**
	 * @return 		If the rock has a respawn range
	 */
	public boolean hasMax()
	{
		return maxRespawnTime != -1;
	}

	/**
	 * Gets the seconds left until a respawn based on the minumum respawn time. Can return negative if rock should have respawned by now
	 *
	 * @return 		Time in seconds until a rock respawns.
	 */
	public int asSecondsNegative()
	{
		long remaining = respawnTime - System.currentTimeMillis();
		return (int) (remaining / 1000) + (remaining % 1000 > 0 ? 1 : 0);
	}

}
