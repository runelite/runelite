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
package net.runelite.client.plugins.timers;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import lombok.Getter;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.infobox.InfoBoxPriority;
import net.runelite.client.ui.overlay.infobox.Timer;

class TimerTimer extends Timer
{
	@Getter
	private final GameTimer timer;
	int ticks;
	private final Duration buffDuration;
	private final TimersDisplayMode displayMode;
	private final Instant startTime;

	TimerTimer(GameTimer timer, Duration duration, Plugin plugin, TimersDisplayMode displayMode)
	{
		super(duration.toMillis(), ChronoUnit.MILLIS, null, plugin);
		this.timer = timer;
		this.buffDuration = duration;
		this.startTime = Instant.now();
		this.displayMode = displayMode;
		setPriority(InfoBoxPriority.MED);
	}

	@Override
	public String getText()
	{
		Duration timeLeft = Duration.between(Instant.now(), startTime.plus(buffDuration));
		int durationInTicks = (int) (timeLeft.toMillis() / 600L);
		int durationInSeconds = (int) (timeLeft.toMillis() / 1000L);
		int minutes = (durationInSeconds % 3600) / 60;
		int secs = durationInSeconds % 60;

		if (displayMode == TimersDisplayMode.TICKS)
		{
			return durationInTicks + "";
		}
		else if (displayMode == TimersDisplayMode.DECIMALS)
		{
			int min = durationInTicks / 100;
			int tmp = (durationInTicks - min * 100) * 6;
			int sec = tmp / 10;
			int sec_tenth = tmp - sec * 10;
			return min + (sec < 10 ? ":0" : ":") + sec + "." + sec_tenth;
		}
		else
		{
			return minutes + (secs < 10 ? ":0" : ":") + secs;
		}
	}

	@Override
	public String getName()
	{
		return timer.name();
	}
}
