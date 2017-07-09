/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.fishing;

import java.time.Duration;
import java.time.Instant;

public class FishingSession
{
	private static final Duration HOUR = Duration.ofHours(1);

	private int perHour;

	private Instant lastFishCaught;
	private int totalFished;

	private Instant recentFishCaught;
	private int recentFished;

	public void incrementFishCaught()
	{
		Instant now = Instant.now();

		lastFishCaught = now;
		++totalFished;

		if (recentFished == 0)
		{
			recentFishCaught = now;
		}
		++recentFished;

		Duration timeSinceStart = Duration.between(recentFishCaught, now);
		if (!timeSinceStart.isZero())
		{
			perHour = (int) ((double) recentFished * (double) HOUR.toMillis() / (double) timeSinceStart.toMillis());
		}
	}

	public void resetRecent()
	{
		recentFishCaught = null;
		recentFished = 0;
	}

	public int getPerHour()
	{
		return perHour;
	}

	public Instant getLastFishCaught()
	{
		return lastFishCaught;
	}

	public int getTotalFished()
	{
		return totalFished;
	}

	public Instant getRecentFishCaught()
	{
		return recentFishCaught;
	}

	public int getRecentFished()
	{
		return recentFished;
	}

}
