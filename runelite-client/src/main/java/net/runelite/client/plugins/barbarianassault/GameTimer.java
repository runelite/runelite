/*
 * Copyright (c) 2018, Jacob M <https://github.com/jacoblairm>
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
package net.runelite.client.plugins.barbarianassault;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class GameTimer
{
	final private Instant startTime = Instant.now();
	private Instant prevWave = startTime;

	String getTime(boolean waveTime)
	{
		final Instant now = Instant.now();
		final Duration elapsed;

		if (waveTime)
		{
			elapsed = Duration.between(prevWave, now);
		}
		else
		{
			elapsed = Duration.between(startTime, now).minusMillis(600);
		}

		return formatTime(LocalTime.ofSecondOfDay(elapsed.getSeconds()));
	}

	void setWaveStartTime()
	{
		prevWave = Instant.now();
	}

	private static String formatTime(LocalTime time)
	{
		if (time.getHour() > 0)
		{
			return time.format(DateTimeFormatter.ofPattern("HH:mm"));
		}
		else if (time.getMinute() > 9)
		{
			return time.format(DateTimeFormatter.ofPattern("mm:ss"));
		}
		else
		{
			return time.format(DateTimeFormatter.ofPattern("m:ss"));
		}
	}
}