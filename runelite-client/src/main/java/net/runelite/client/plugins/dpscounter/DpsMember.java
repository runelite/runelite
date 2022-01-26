/*
 * Copyright (c) 2020 Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.dpscounter;

import java.time.Duration;
import java.time.Instant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
class DpsMember
{
	private final String name;
	private Instant start;
	private Instant end;
	private int damage;

	void addDamage(int amount)
	{
		if (start == null)
		{
			start = Instant.now();
		}

		damage += amount;
	}

	float getDps()
	{
		if (start == null)
		{
			return 0;
		}

		Instant now = end == null ? Instant.now() : end;
		int diff = (int) (now.toEpochMilli() - start.toEpochMilli()) / 1000;
		if (diff == 0)
		{
			return 0;
		}

		return (float) damage / (float) diff;
	}

	void pause()
	{
		end = Instant.now();
	}

	boolean isPaused()
	{
		return start == null || end != null;
	}

	void unpause()
	{
		if (end == null)
		{
			return;
		}

		start = start.plus(Duration.between(end, Instant.now()));
		end = null;
	}

	void reset()
	{
		damage = 0;
		start = end = Instant.now();
	}

	Duration elapsed()
	{
		return Duration.between(start, end == null ? Instant.now() : end);
	}
}
