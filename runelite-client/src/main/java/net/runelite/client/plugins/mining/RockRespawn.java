/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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

import java.time.Instant;
import lombok.Getter;
import net.runelite.api.coords.Direction;
import net.runelite.api.coords.WorldPoint;

@Getter
class RockRespawn
{
	private final Rock rock;
	private final WorldPoint worldPoint;
	private final Instant startTime;
	private final int respawnTime;
	private final int zOffset;
	private final Direction direction;

	boolean isExpired()
	{
		return Instant.now().isAfter(startTime.plusMillis(respawnTime));
	}
	RockRespawn (
			Rock rock, WorldPoint worldpoint, Instant startTime, int respawnTime, int zOffset)
	{
		this.rock = rock;
		this.worldPoint = worldpoint;
		this.startTime = startTime;
		this.respawnTime = respawnTime;
		this.zOffset = zOffset;
		this.direction = null;
	}
	RockRespawn (
			Rock rock, WorldPoint worldpoint, Instant startTime, int respawnTime, int zOffset, Direction direction)
	{
		this.rock = rock;
		this.worldPoint = worldpoint;
		this.startTime = startTime;
		this.respawnTime = respawnTime;
		this.zOffset = zOffset;
		this.direction = direction;
	}
}
