/*
 * Copyright (c) 2020 Mitchell <https://github.com/Mitchell-Kovacs>
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
package net.runelite.client.plugins.pyramidplunder;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.client.ui.overlay.infobox.Timer;

class PyramidPlunderTimer extends Timer
{
	private final PyramidPlunderConfig config;
	private final Client client;

	public PyramidPlunderTimer(
		Duration duration,
		BufferedImage image,
		PyramidPlunderPlugin plugin,
		PyramidPlunderConfig config,
		Client client
	)
	{
		super(duration.toMillis(), ChronoUnit.MILLIS, image, plugin);
		this.config = config;
		this.client = client;
	}

	@Override
	public Color getTextColor()
	{
		long secondsLeft = Duration.between(Instant.now(), getEndTime()).getSeconds();
		return secondsLeft < config.timerLowWarning() ? Color.RED.brighter() : Color.white;
	}

	@Override
	public String getTooltip()
	{
		int floor = client.getVar(Varbits.PYRAMID_PLUNDER_ROOM);
		int thievingLevel = client.getVar(Varbits.PYRAMID_PLUNDER_THIEVING_LEVEL);
		return String.format("Time remaining. Floor: %d. Thieving level: %d", floor, thievingLevel);
	}

	@Override
	public boolean render()
	{
		return config.showExactTimer();
	}
}
