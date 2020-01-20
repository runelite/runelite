/*
 * Copyright (c) 2020, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.dps;

import java.time.Duration;
import java.time.Instant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class DpsTracker
{
	private final String name;
	private Instant start = Instant.now();
	private Instant end;
	private int damage;

	/**
	 * Adds the damage and un-pauses the tracker
	 * @param amount
	 */
	public void addDamage(int amount)
	{
		damage += amount;
		unpause();
	}

	public float getDps()
	{
		Instant now = end == null ? Instant.now() : end;
		int diff = (int) (now.toEpochMilli() - start.toEpochMilli()) / 1000;
		if (diff == 0)
		{
			return 0;
		}

		return (float) damage / (float) diff;
	}

	public void pause()
	{
		end = Instant.now();
	}

	public boolean isPaused()
	{
		return end != null;
	}

	public void unpause()
	{
		if (end == null)
		{
			return;
		}

		start = start.plus(Duration.between(end, Instant.now()));
		end = null;
	}

	/**
	 * Resets and pauses and tracker
	 */
	public void reset()
	{
		damage = 0;
		start = end = Instant.now();
	}
}
