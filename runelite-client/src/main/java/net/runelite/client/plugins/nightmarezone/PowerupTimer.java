/*
 * Copyright (c) 2019, Adam Witkowski <https://github.com/adwitkow>
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
package net.runelite.client.plugins.nightmarezone;

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.infobox.InfoBoxPriority;
import net.runelite.client.ui.overlay.infobox.Timer;
import java.awt.Color;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Getter
class PowerupTimer extends Timer
{
	private static final int POWERUP_DESPAWN = 60;
	private static final int RED_THRESHOLD = 5;

	private final WorldPoint worldLocation;
	private final Powerup powerup;
	@Setter
	private boolean active;
	@Setter
	private boolean visible;

	PowerupTimer(Plugin plugin, WorldPoint worldLocation, Powerup powerup, boolean active)
	{
		super(active ? powerup.getActivityTime() : POWERUP_DESPAWN, ChronoUnit.SECONDS, null, plugin);
		this.worldLocation = worldLocation;
		this.powerup = powerup;
		this.active = active;

		setTooltip(powerup.getName());
		setPriority(InfoBoxPriority.LOW);
	}

	@Override
	public Color getTextColor()
	{
		Duration timeLeft = Duration.between(Instant.now(), getEndTime());

		if (timeLeft.getSeconds() <= RED_THRESHOLD)
		{
			return Color.RED.brighter();
		}

		return active ? Color.GREEN.brighter() : Color.WHITE;
	}

	@Override
	public boolean render()
	{
		return visible && super.render();
	}
}