/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.fishing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

class FishingOverlay extends Overlay
{
	private static final int WIDTH = 140;

	private static final int TOP_BORDER = 2;
	private static final int LEFT_BORDER = 2;
	private static final int RIGHT_BORDER = 2;
	private static final int BOTTOM_BORDER = 2;
	private static final int SEPARATOR = 2;

	private static final Color BACKGROUND = new Color(Color.gray.getRed(), Color.gray.getGreen(), Color.gray.getBlue(), 127);
	private static final String FISHING_SPOT = "Fishing spot";

	private final Client client;
	private final FishingPlugin plugin;
	private final FishingConfig config;

	@Inject
	public FishingOverlay(@Nullable Client client, FishingPlugin plugin, FishingConfig config)
	{
		super(OverlayPosition.TOP_LEFT, OverlayPriority.LOW);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.setDrawOverLoginScreen(false);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.enabled())
		{
			return null;
		}

		FishingSession session = plugin.getSession();

		if (session.getLastFishCaught() == null)
		{
			return null;
		}

		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceCaught = Duration.between(session.getLastFishCaught(), Instant.now());

		if (sinceCaught.compareTo(statTimeout) >= 0)
		{
			return null;
		}

		FontMetrics metrics = graphics.getFontMetrics();

		int height = TOP_BORDER + (metrics.getHeight() * 3) + SEPARATOR * 3 + BOTTOM_BORDER;
		int y = TOP_BORDER + metrics.getHeight();

		graphics.setColor(BACKGROUND);
		graphics.fillRect(0, 0, WIDTH, height);

		if (client.getLocalPlayer().getInteracting() != null && client.getLocalPlayer().getInteracting().getName().equals(FISHING_SPOT))
		{
			graphics.setColor(Color.green);
			String str = "You are fishing";
			graphics.drawString(str, (WIDTH - metrics.stringWidth(str)) / 2, y);
		}
		else
		{
			graphics.setColor(Color.red);
			String str = "You are NOT fishing";
			graphics.drawString(str, (WIDTH - metrics.stringWidth(str)) / 2, y);
		}

		y += metrics.getHeight() + SEPARATOR;

		graphics.setColor(Color.white);
		graphics.drawString("Caught Fish:", LEFT_BORDER, y);

		String totalFishedStr = Integer.toString(session.getTotalFished());
		graphics.drawString(totalFishedStr, WIDTH - RIGHT_BORDER - metrics.stringWidth(totalFishedStr), y);

		y += metrics.getHeight() + SEPARATOR;

		graphics.drawString("Fish/hr:", LEFT_BORDER, y);

		String perHourStr;
		if (session.getRecentFished() > 2)
		{
			perHourStr = Integer.toString(session.getPerHour());
		}
		else
		{
			perHourStr = "~";
		}
		graphics.drawString(perHourStr, WIDTH - RIGHT_BORDER - metrics.stringWidth(perHourStr), y);

		return new Dimension(WIDTH, height);
	}
}
