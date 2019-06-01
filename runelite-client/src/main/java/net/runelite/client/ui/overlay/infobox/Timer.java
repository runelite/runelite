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
public class Timer extends InfoBox
{
	private final Instant startTime;
	private final Instant endTime;
	private final Duration duration;

	private static final int SEC_PER_HOUR = 3600;
	private static final int SEC_PER_MINUTE = 60;

	public Timer(long period, ChronoUnit unit, BufferedImage image, Plugin plugin)
	{
		super(image, plugin);

		Preconditions.checkArgument(period > 0, "negative period!");

		startTime = Instant.now();
		duration = Duration.of(period, unit);
		endTime = startTime.plus(duration);
	}

	@Override
	public String getText()
	{
		Duration timeLeft = Duration.between(Instant.now(), endTime);

		float totalMillis = timeLeft.toMillis();
		int totalSeconds = (int) (totalMillis / 1000L);

		if (totalSeconds >= 10)
		{
			int minutes = (totalSeconds % SEC_PER_HOUR) / 60;
			int seconds = totalSeconds % SEC_PER_MINUTE;
			return String.format("%d:%02d", minutes, seconds);
		}
		else
		{
			float seconds = (totalMillis / 1000F) % SEC_PER_MINUTE;
			return String.format("%.1f", seconds);
		}
	}

	@Override
	public Color getTextColor()
	{
		Duration timeLeft = Duration.between(Instant.now(), endTime);

		//check if timer has 10% of time left
		if (timeLeft.getSeconds() < (duration.getSeconds() * .10))
		{
			return Color.RED.brighter();
		}

		return Color.WHITE;
	}

	@Override
	public boolean render()
	{
		return !isExpired();
	}

	@Override
	public boolean cull()
	{
		return isExpired();
	}

	public boolean isExpired()
	{
		Duration timeLeft = Duration.between(Instant.now(), endTime);
		return timeLeft.isZero() || timeLeft.isNegative();
	}

}
