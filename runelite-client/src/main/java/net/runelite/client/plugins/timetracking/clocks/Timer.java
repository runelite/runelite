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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Timer extends Clock
{
	// the total number of seconds that the timer should run for
	private long duration;

	// the number of seconds remaining on the timer, as of last updated time
	private long remaining;

	// whether this timer is in the 'warning' state or not
	@Getter(AccessLevel.NONE)
	private transient boolean warning;

	// whether this timer should loop or not
	private boolean loop;

	Timer(String name, long duration)
	{
		super(name);
		this.duration = duration;
		this.remaining = duration;
		this.warning = false;
	}

	@Override
	long getDisplayTime()
	{
		if (!active)
		{
			return remaining;
		}

		return Math.max(0, remaining - (Instant.now().getEpochSecond() - lastUpdate));
	}

	@Override
	boolean start()
	{
		if (!active && duration > 0)
		{
			if (remaining <= 0)
			{
				remaining = duration;
				warning = false;
			}
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
			remaining = Math.max(0, remaining - (Instant.now().getEpochSecond() - lastUpdate));
			lastUpdate = Instant.now().getEpochSecond();
			return true;
		}

		return false;
	}

	@Override
	void reset()
	{
		active = false;
		remaining = duration;
		lastUpdate = Instant.now().getEpochSecond();
	}

	boolean isWarning()
	{
		return warning && (remaining > 0);
	}
}
