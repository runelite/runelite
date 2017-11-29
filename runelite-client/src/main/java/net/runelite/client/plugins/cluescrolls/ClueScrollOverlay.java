/*
 * Copyright (c) 2016-2017, Seth <Sethtroll3@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package net.runelite.client.plugins.cluescrolls;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

public class ClueScrollOverlay extends Overlay
{
	private static final Color BACKGROUND = new Color(Color.gray.getRed(), Color.gray.getGreen(), Color.gray.getBlue(), 127);

	private static final int WIDTH = 140;

	private static final int TOP_BORDER = 2;
	private static final int BOTTOM_BORDER = 2;
	private static final int SEPERATOR = 2;

	private static final Duration WAIT_DURATION = Duration.ofMinutes(4);

	private final Client client;
	private final ClueScrollConfig config;

	ClueScroll clue;
	Instant clueTimeout;

	@Inject
	public ClueScrollOverlay(@Nullable Client client, ClueScrollConfig config)
	{
		super(OverlayPosition.TOP_LEFT, OverlayPriority.LOW);
		this.client = client;
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

		if (clue == null)
		{
			return null;
		}

		if (clueTimeout == null || Instant.now().compareTo(clueTimeout.plus(WAIT_DURATION)) >= 0)
		{
			return null;
		}

		FontMetrics fm = graphics.getFontMetrics();

		int height = TOP_BORDER + fm.getHeight() + SEPERATOR + (clue.getIds().length * (fm.getHeight() + SEPERATOR)) + BOTTOM_BORDER;

		graphics.setColor(BACKGROUND);
		graphics.fillRect(0, 0, WIDTH, height);

		int y = TOP_BORDER + fm.getHeight();

		String reqHeader = "Required Items";
		graphics.setColor(Color.BLACK);
		graphics.drawString(reqHeader, ((WIDTH - fm.stringWidth(reqHeader)) / 2) + 1, y + 1);

		graphics.setColor(Color.WHITE);
		graphics.drawString(reqHeader, ((WIDTH - fm.stringWidth(reqHeader)) / 2), y);

		y += fm.getHeight() + SEPERATOR;

		if (clue.getIds().length == 0)
		{
			graphics.setColor(Color.BLACK);
			graphics.drawString("None", ((WIDTH - fm.stringWidth("None")) / 2) + 1, y + 1);

			graphics.setColor(Color.WHITE);
			graphics.drawString("None", ((WIDTH - fm.stringWidth("None")) / 2), y);
		}
		else
		{
			for (int id : clue.getIds())
			{
				ItemComposition clueItem = client.getItemDefinition(id);

				if (clueItem == null)
				{
					continue;
				}

				String itemName = clueItem.getName();
				graphics.setColor(Color.BLACK);
				graphics.drawString(itemName, ((WIDTH - fm.stringWidth(itemName)) / 2) + 1, y + 1);

				graphics.setColor(Color.WHITE);
				graphics.drawString(itemName, ((WIDTH - fm.stringWidth(itemName)) / 2), y);

				//might eventually add a inventory/equipment check or item images here?
				y += fm.getHeight() + SEPERATOR;
			}
		}

		return new Dimension(WIDTH, height);
	}
}
