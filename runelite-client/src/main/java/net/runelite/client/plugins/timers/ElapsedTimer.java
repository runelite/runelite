/*
 * Copyright (c) 2019, winterdaze
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

import lombok.Getter;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.time.Duration;
import java.time.Instant;
import org.apache.commons.lang3.time.DurationFormatUtils;

@Getter
class ElapsedTimer extends InfoBox
{
	private final Instant startTime;
	private final Instant lastTime;

	// Creates a timer that counts up if lastTime is null, or a paused timer if lastTime is defined
	ElapsedTimer(BufferedImage image, TimersPlugin plugin, Instant startTime, Instant lastTime)
	{
		super(image, plugin);
		this.startTime = startTime;
		this.lastTime = lastTime;
	}

	@Override
	public String getText()
	{
		if (startTime == null)
		{
			return null;
		}

		Duration time = Duration.between(startTime, lastTime == null ? Instant.now() : lastTime);
		final String formatString = "mm:ss";
		return DurationFormatUtils.formatDuration(time.toMillis(), formatString, true);
	}

	@Override
	public Color getTextColor()
	{
		return Color.WHITE;
	}

	@Override
	public String getTooltip()
	{
		if (startTime == null)
		{
			return null;
		}

		Duration time = Duration.between(startTime, lastTime == null ? Instant.now() : lastTime);
		return "Elapsed time: " +  DurationFormatUtils.formatDuration(time.toMillis(), "HH:mm:ss", true);
	}
}
