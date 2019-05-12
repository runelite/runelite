/*
 * Copyright (c) 2019, Ryan <progrs.site@gmail.com>
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
package net.runelite.client.plugins.barrows;

import java.awt.Color;
import java.time.Duration;
import java.time.Instant;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.ui.overlay.infobox.InfoBoxPriority;

class BarrowsPrayerDrainTimer extends InfoBox
{
	private static final long PRAYER_DRAIN_INTERVAL_MS = 18200;

	private final Instant startTime;

	BarrowsPrayerDrainTimer(BarrowsPlugin plugin, SpriteManager spriteManager)
	{
		super(spriteManager.getSprite(SpriteID.TAB_PRAYER, 0), plugin);
		setPriority(InfoBoxPriority.MED);
		setTooltip("Prayer Drain");
		startTime = Instant.now();
	}

	@Override
	public String getText()
	{
		Duration timeLeft = Duration.between(Instant.now(), getNextPrayerDrainTime());
		int seconds = (int) (timeLeft.toMillis() / 1000L);
		return String.format("0:%02d", seconds);
	}

	@Override
	public Color getTextColor()
	{
		Duration timeLeft = Duration.between(Instant.now(), getNextPrayerDrainTime());

		//check if timer has 10% of time left
		if (timeLeft.getSeconds() < (PRAYER_DRAIN_INTERVAL_MS / 1000 * .10))
		{
			return Color.RED.brighter();
		}

		return Color.WHITE;
	}

	private Instant getNextPrayerDrainTime()
	{
		Duration timePassed = Duration.between(startTime, Instant.now());
		// Get how many intervals have passed so far and add one more to find the next prayer drain time
		return startTime.plusMillis((timePassed.toMillis() / PRAYER_DRAIN_INTERVAL_MS + 1) * PRAYER_DRAIN_INTERVAL_MS);
	}
}
