/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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
package net.runelite.client.plugins.zulrah;

import com.google.common.collect.Ordering;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPattern;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class StatusOverlay extends Overlay
{
	private static final Logger logger = LoggerFactory.getLogger(StatusOverlay.class);

	private final Zulrah plugin;
	private final Client client = RuneLite.getClient();

	StatusOverlay(Zulrah plugin)
	{
		super(OverlayPosition.TOP_RIGHT);
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		ZulrahInstance current, next;

		synchronized (plugin)
		{
			Fight fight = plugin.getFight();

			if (client.getGameState() != GameState.LOGGED_IN || fight == null)
			{
				return null;
			}

			//TODO: Add prayer checking and health warning
			graphics.setColor(Color.WHITE);

			ZulrahPattern pattern = fight.getPattern();
			if (pattern == null)
			{
				// can draw at least the starting place here?
				return null;
			}

			// Show current type, next type, and jad
			current = fight.getZulrah();
			next = pattern.get(fight.getStage() + 1);
		}

		String currentStr = "Current: " + current.getType();
		String nextStr = "Next: " + (next != null ? next.getType() : "Restart");
		String jadStr;

		if (current.isJad())
		{
			jadStr = "JAD: YES";
		}
		else if (next != null && next.isJad())
		{
			jadStr = "JAD: NEXT";
		}
		else
		{
			jadStr = "JAD: NO";
		}

		FontMetrics metrics = graphics.getFontMetrics();
		int height = metrics.getHeight();
		int width = Ordering.natural().max(
			metrics.stringWidth(currentStr),
			metrics.stringWidth(nextStr),
			metrics.stringWidth(jadStr)
		);

		graphics.drawString(currentStr, 0, height);
		height += metrics.getHeight();

		graphics.drawString(nextStr, 0, height);
		height += metrics.getHeight();

		graphics.drawString(jadStr, 0, height);
		height += metrics.getHeight();

		return new Dimension(width, height);
	}
}
