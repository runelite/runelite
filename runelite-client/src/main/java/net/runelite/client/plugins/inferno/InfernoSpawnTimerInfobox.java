/*
 * Copyright (c) 2020, Dutta64 <https://github.com/dutta64>
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
package net.runelite.client.plugins.inferno;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.ui.overlay.infobox.InfoBoxPriority;

class InfernoSpawnTimerInfobox extends InfoBox
{
	private static final long SPAWN_DURATION = 210; // 3 minutes 30 seconds
	private static final long SPAWN_DURATION_INCREMENT = 105; // 1 minute 45 seconds
	private static final long SPAWN_DURATION_WARNING = 120; // 2 minutes before next respawn
	private static final long SPAWN_DURATION_DANGER = 30; // 30 seconds before next respawn

	private long timeRemaining;
	private long startTime;

	@Getter(AccessLevel.PACKAGE)
	private boolean running;

	InfernoSpawnTimerInfobox(final BufferedImage image, final InfernoPlugin plugin)
	{
		super(image, plugin);
		setPriority(InfoBoxPriority.HIGH);
		running = false;
		timeRemaining = SPAWN_DURATION;
	}

	void run()
	{
		startTime = Instant.now().getEpochSecond();
		running = true;
	}

	void reset()
	{
		running = false;
		timeRemaining = SPAWN_DURATION;
	}

	void pause()
	{
		if (!running)
		{
			return;
		}

		running = false;

		long timeElapsed = Instant.now().getEpochSecond() - startTime;

		timeRemaining = Math.max(0, timeRemaining - timeElapsed);

		timeRemaining += SPAWN_DURATION_INCREMENT;
	}

	@Override
	public String getText()
	{
		final long seconds = running
			? Math.max(0, timeRemaining - (Instant.now().getEpochSecond() - startTime))
			: timeRemaining;

		final long minutes = seconds % 3600 / 60;
		final long secs = seconds % 60;

		return String.format("%02d:%02d", minutes, secs);
	}

	@Override
	public Color getTextColor()
	{
		final long seconds = running
			? Math.max(0, timeRemaining - (Instant.now().getEpochSecond() - startTime))
			: timeRemaining;

		return seconds <= SPAWN_DURATION_DANGER ?
			Color.RED : seconds <= SPAWN_DURATION_WARNING ?
			Color.ORANGE : Color.GREEN;
	}

	@Override
	public boolean render()
	{
		return true;
	}

	@Override
	public boolean cull()
	{
		return false;
	}
}
