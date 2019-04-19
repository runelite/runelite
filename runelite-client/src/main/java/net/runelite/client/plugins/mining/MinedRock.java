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

	private final long minRespawnTime, maxRespawnTime;

	public MinedRock(MiningRockType type, boolean halve)
	{
		this.type = type;
		this.minRespawnTime = System.currentTimeMillis() + (int)((halve ? type.getMinRespawnTime() / 2 : type.getMinRespawnTime()) * 1000);
		this.maxRespawnTime = type.getMaxRespawnTime() == -1 ? -1 : System.currentTimeMillis() + (int)((halve ? type.getMaxRespawnTime() / 2 : type.getMaxRespawnTime()) * 1000);
	}

	public int getMinSecondsUntilRespawn(boolean allowNegative)
	{
		long remaining = minRespawnTime - System.currentTimeMillis();
		if (remaining > 0 || allowNegative)
		{
			return (int) (remaining / 1000) + (remaining % 1000 > 0 ? 1 : 0);
		}
		else
		{
			return (maxRespawnTime > minRespawnTime) ? 0 : 1;
		}
	}

	public int getMaxSecondsUntilRespawn()
	{
		if (maxRespawnTime == -1)
		{
			return -1;
		}
		long remaining = maxRespawnTime - System.currentTimeMillis();
		if (remaining > 0 && maxRespawnTime > minRespawnTime)
		{
			return (int) (remaining / 1000) + (remaining % 1000 > 0 ? 1 : 0);
		}
		else
		{
			// Return -1 if the ore does not have a maximum respawn time (no range)
			return 1;
		}
	}

}
