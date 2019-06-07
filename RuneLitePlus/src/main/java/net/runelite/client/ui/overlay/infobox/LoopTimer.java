/*
 * Copyright (c) 2019, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.ui.overlay.infobox;

import com.google.common.base.Preconditions;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import lombok.Getter;
import lombok.ToString;
import net.runelite.client.plugins.Plugin;

@Getter
@ToString
public class LoopTimer extends InfoBox
{
	private final Instant startTime;
	private final Duration duration;
	private final boolean reverse;

	public LoopTimer(long period, ChronoUnit unit, BufferedImage image, Plugin plugin, boolean reverse)
	{
		super(image, plugin);

		Preconditions.checkArgument(period > 0, "negative period!");

		startTime = Instant.now();
		duration = Duration.of(period, unit);
		this.reverse = reverse;
	}

	public LoopTimer(long period, ChronoUnit unit, BufferedImage image, Plugin plugin)
	{
		this(period, unit, image, plugin, false);
	}

	@Override
	public String getText()
	{
		final Duration progress = getProgress();
		final int seconds = (int) (progress.toMillis() / 1000L);
		final int minutes = (seconds % 3600) / 60;
		final int secs = seconds % 60;
		return String.format("%d:%02d", minutes, secs);
	}

	@Override
	public Color getTextColor()
	{
		final Duration progress = getProgress();

		// check if timer has 10% of time left
		if (progress.getSeconds() < (duration.getSeconds() * .10))
		{
			return Color.RED.brighter();
		}

		return Color.WHITE;
	}

	private Duration getProgress()
	{
		final Duration passed = Duration.between(startTime, Instant.now());
		final long passedMillis = passed.toMillis();
		final long durationMillis = duration.toMillis();
		final long progress = passedMillis % durationMillis;

		return Duration.ofMillis(reverse
			? durationMillis - progress
			: progress);
	}
}