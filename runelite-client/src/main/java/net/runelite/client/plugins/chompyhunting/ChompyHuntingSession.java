/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
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
package net.runelite.client.plugins.chompyhunting;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;

@Slf4j
public class ChompyHuntingSession
{
	private static final Duration HOUR = Duration.ofHours(1);

	@Getter
	private int perHour;

	@Getter
	private Instant lastChompyKilled;

	@Setter
	@Getter
	private int lifetimeKilled;

	@Getter
	private Instant recentChompyKilled;

	@Getter
	private int recentKilled;

	public void incrementChompyKilled()
	{
		Instant now = Instant.now();

		lastChompyKilled = now;
		lifetimeKilled++;

		if (recentKilled == 0)
		{
			recentChompyKilled = now;
		}
		recentKilled++;

		Duration timeSinceStart = Duration.between(recentChompyKilled, now);
		if (!timeSinceStart.isZero())
		{
			perHour = (int) ((double) recentKilled * (double) HOUR.toMillis() / (double) timeSinceStart.toMillis());
		}
	}

	public void resetRecent()
	{
		recentChompyKilled = null;
		recentKilled = 0;
	}
}
