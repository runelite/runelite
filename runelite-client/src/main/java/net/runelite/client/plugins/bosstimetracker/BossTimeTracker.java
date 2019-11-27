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
package net.runelite.client.plugins.bosstimetracker;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import net.runelite.client.ui.overlay.infobox.InfoBox;

public class BossTimeTracker extends InfoBox
{
	private final Instant startTime;
	private LocalTime time;
	private final Instant lastTime;

	public BossTimeTracker(BufferedImage image, BossTimeTrackerPlugin plugin, Instant startTime, Instant lastTime)
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
			return "";
		}

		if (lastTime == null)
		{
			Duration elapsed = Duration.between(startTime, Instant.now());
			time = LocalTime.ofSecondOfDay(elapsed.getSeconds());
		}
		else
		{
			Duration elapsed = Duration.between(startTime, lastTime);
			time = LocalTime.ofSecondOfDay(elapsed.getSeconds());
		}

		if (time.getHour() > 0)
		{
			return time.format(DateTimeFormatter.ofPattern("HH:mm"));
		}
		return time.format(DateTimeFormatter.ofPattern("mm:ss"));
	}

	@Override
	public Color getTextColor()
	{
		return Color.WHITE;
	}

	@Override
	public String getTooltip()
	{
		return "Elapsed time: " +
			time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
}
