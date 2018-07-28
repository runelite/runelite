/*
 * Copyright (c) 2018, Daniel Teo <https://github.com/takuyakanbr>
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
package net.runelite.client.plugins.timetracking.clocks;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Stopwatch extends Clock
{
	// the number of seconds elapsed, as of last updated time
	private long elapsed = 0;

	// a list of lap times (recorded as seconds since epoch)
	private List<Long> laps = new ArrayList<>();

	Stopwatch(String name)
	{
		super(name);
	}

	@Override
	long getDisplayTime()
	{
		if (!active)
		{
			return elapsed;
		}

		return Math.max(0, elapsed + (Instant.now().getEpochSecond() - lastUpdate));
	}

	@Override
	void setDuration(long duration)
	{
		elapsed = duration;
	}

	@Override
	boolean start()
	{
		if (!active)
		{
			lastUpdate = Instant.now().getEpochSecond();
			active = true;
			return true;
		}

		return false;
	}

	@Override
	boolean pause()
	{
		if (active)
		{
			active = false;
			elapsed = Math.max(0, elapsed + (Instant.now().getEpochSecond() - lastUpdate));
			lastUpdate = Instant.now().getEpochSecond();
			return true;
		}

		return false;
	}

	void lap()
	{
		laps.add(getDisplayTime());
	}

	@Override
	void reset()
	{
		active = false;
		elapsed = 0;
		laps.clear();
		lastUpdate = Instant.now().getEpochSecond();
	}
}
