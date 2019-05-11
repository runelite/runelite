/*
 * Copyright (c) 2018, Unmoon <https://github.com/Unmoon>
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
package net.runelite.client.plugins.blastmine;

import java.time.Duration;
import java.time.Instant;
import lombok.Getter;
import net.runelite.api.GameObject;

class BlastMineRock
{
	private static final Duration PLANT_TIME = Duration.ofSeconds(30);
	private static final Duration FUSE_TIME = Duration.ofMillis(4200);

	@Getter
	private final GameObject gameObject;

	@Getter
	private final BlastMineRockType type;

	private final Instant creationTime = Instant.now();

	BlastMineRock(final GameObject gameObject, BlastMineRockType blastMineRockType)
	{
		this.gameObject = gameObject;
		this.type = blastMineRockType;
	}

	double getRemainingFuseTimeRelative()
	{
		Duration duration = Duration.between(creationTime, Instant.now());
		return duration.compareTo(FUSE_TIME) < 0 ? (double) duration.toMillis() / FUSE_TIME.toMillis() : 1;
	}

	double getRemainingTimeRelative()
	{
		Duration duration = Duration.between(creationTime, Instant.now());
		return duration.compareTo(PLANT_TIME) < 0 ? (double) duration.toMillis() / PLANT_TIME.toMillis() : 1;
	}
}
