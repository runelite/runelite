/*
 * Copyright (c) 2018, NotFoxtrot <http://github.com/NotFoxtrot>
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

import com.google.common.base.Preconditions;
import java.awt.Color;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

class PyramidTimer
{
	private final Instant endTime;

	PyramidTimer(long period)
	{
		Preconditions.checkArgument(period > 0, "negative period!");

		endTime = Instant.now().plus(period, ChronoUnit.SECONDS);
	}

	public String getText()
	{
		if (isFinished())
		{
			return "0:00";
		}

		Duration timeLeft = Duration.between(Instant.now(), endTime);

		int totalSeconds = (int) timeLeft.get(ChronoUnit.SECONDS);

		int minutes = (totalSeconds % 3600) / 60;
		int seconds = totalSeconds % 60;

		return String.format("%d:%02d", minutes, seconds);
	}

	public Color getTextColor()
	{
		Duration timeLeft = Duration.between(Instant.now(), endTime);

		if (timeLeft.getSeconds() < 30)
		{
			return Color.RED.brighter();
		}

		return Color.WHITE;
	}

	private boolean isFinished()
	{
		return Instant.now().isAfter(endTime);
	}
}
