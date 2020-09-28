/*
 * Copyright (c) 2018, Jacob M <https://github.com/jacoblairm>
 * Copyright (c) 2020, BegOsrs <https://github.com/begosrs>
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
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import static net.runelite.client.util.RSTimeUnit.GAME_TICKS;

@Slf4j
@Getter
class Timer
{
	private final Instant roundStartTime;
	private Instant waveStartTime;

	public Timer()
	{
		this.roundStartTime = Instant.now();
		this.waveStartTime = roundStartTime;
	}

	Duration getRoundTime(boolean delayed)
	{
		Duration duration = Duration.between(roundStartTime, Instant.now());
		if (delayed)
		{
			duration = duration.minus(Duration.of(1, GAME_TICKS));
		}

		return duration;
	}

	Duration getWaveTime()
	{
		return Duration.between(waveStartTime, Instant.now());
	}

	int getWaveTimeSecondsRounded()
	{
		final Duration elapsed = getWaveTime();
		final long millis = elapsed.toMillis();
		final int seconds = roundToNearestSecond(millis);
		log.debug("Wave duration millis: {}", millis);
		log.debug("Wave duration seconds: {}", seconds);
		return seconds;
	}

	int getRoundTimeSecondsRounded()
	{
		final Duration elapsed = getRoundTime(true);
		final long millis = elapsed.toMillis();
		final int seconds = roundToNearestSecond(millis);
		log.debug("Round duration millis: {}", millis);
		log.debug("Round duration seconds: {}", seconds);
		return seconds;
	}

	String getRoundTimeFormatted(boolean delayed)
	{
		final long seconds = getRoundTime(delayed).getSeconds();
		return formatTime(LocalTime.ofSecondOfDay(seconds));
	}

	String getWaveTimeFormatted()
	{
		final long seconds = getWaveTime().getSeconds();
		return formatTime(LocalTime.ofSecondOfDay(seconds));
	}

	void setWaveStartTime()
	{
		waveStartTime = Instant.now();
	}

	private int roundToNearestSecond(long millis)
	{
		return (int) (1000 * ((millis + 500) / 1000)) / 1000;
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