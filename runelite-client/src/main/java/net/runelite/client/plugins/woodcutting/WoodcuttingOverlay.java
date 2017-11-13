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
package net.runelite.client.plugins.woodcutting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;
import javax.annotation.Nullable;
import javax.inject.Inject;
import static net.runelite.api.AnimationID.*;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

class WoodcuttingOverlay extends Overlay
{
	private static final int WIDTH = 140;

	private static final int TOP_BORDER = 2;
	private static final int LEFT_BORDER = 2;
	private static final int RIGHT_BORDER = 2;
	private static final int BOTTOM_BORDER = 2;
	private static final int SEPARATOR = 2;

	private static final Color BACKGROUND = new Color(Color.gray.getRed(), Color.gray.getGreen(), Color.gray.getBlue(), 127);

	private static final int[] animationIds =
	{
		WOODCUTTING_BRONZE, WOODCUTTING_IRON, WOODCUTTING_STEEL, WOODCUTTING_BLACK,
		WOODCUTTING_MITHRIL, WOODCUTTING_ADAMANT, WOODCUTTING_RUNE, WOODCUTTING_DRAGON,
		WOODCUTTING_INFERNAL
	};

	private final Client client;
	private final WoodcuttingPlugin plugin;
	private final WoodcuttingConfig config;

	@Inject
	public WoodcuttingOverlay(@Nullable Client client, WoodcuttingPlugin plugin, WoodcuttingConfig config)
	{
		super(OverlayPosition.TOP_LEFT, OverlayPriority.LOW);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getGameState() != GameState.LOGGED_IN || !config.enabled())
		{
			return null;
		}

		WoodcuttingSession session = plugin.getSession();

		if (session.getLastLogCut() == null)
		{
			return null;
		}

		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceCut = Duration.between(session.getLastLogCut(), Instant.now());

		if (sinceCut.compareTo(statTimeout) >= 0)
		{
			return null;
		}

		FontMetrics metrics = graphics.getFontMetrics();

		int height = TOP_BORDER + (metrics.getHeight() * 3) + SEPARATOR * 3 + BOTTOM_BORDER;
		int y = TOP_BORDER + metrics.getHeight();

		graphics.setColor(BACKGROUND);
		graphics.fillRect(0, 0, WIDTH, height);

		if (IntStream.of(animationIds).anyMatch(x -> x == client.getLocalPlayer().getAnimation()))
		{
			graphics.setColor(Color.green);
			String str = "You are woodcutting";
			graphics.drawString(str, (WIDTH - metrics.stringWidth(str)) / 2, y);
		}
		else
		{
			graphics.setColor(Color.red);
			String str = "You are NOT woodcutting";
			graphics.drawString(str, (WIDTH - metrics.stringWidth(str)) / 2, y);
		}

		y += metrics.getHeight() + SEPARATOR;

		graphics.setColor(Color.white);
		graphics.drawString("Logs cut:", LEFT_BORDER, y);

		String totalCutStr = Integer.toString(session.getTotalCut());
		graphics.drawString(totalCutStr, WIDTH - RIGHT_BORDER - metrics.stringWidth(totalCutStr), y);

		y += metrics.getHeight() + SEPARATOR;

		graphics.drawString("Logs/hr:", LEFT_BORDER, y);

		String perHourStr;
		if (session.getRecentCut() > 2)
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
