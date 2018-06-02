/*
 * Copyright (c) 2017, Levi <me@levischuck.com>
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
package net.runelite.client.plugins.fps;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.events.FocusChanged;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

/**
 * The built in FPS overlay has a few problems that this one does not have, most of all: it is distracting.
 * 1. The built in one also shows memory, which constantly fluctuates and garbage collects.
 * It is useful for devs profiling memory.
 * 2. The built in one shifts around constantly because it is not monospace.
 * This locks "FPS:" into one position (the far top right corner of the canvas),
 * along with a locked position for the FPS value.
 */
public class FpsOverlay extends Overlay
{
	private static final int MAX_FPS = 50;
	private static final int FPS_SIZE = MAX_FPS + 1;
	private static final int Y_OFFSET = 14;
	private static final int VALUE_X_OFFSET = 15;
	private static final String FPS_STRING = " FPS";

	// Cache of FPS number strings from 00-50
	private final String[] fpsNums;

	// Local dependencies
	private final FpsConfig config;
	private final Client client;

	// Often changing values
	private boolean isFocused = true;

	@Inject
	private FpsOverlay(FpsConfig config, Client client)
	{
		this.config = config;
		this.client = client;
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.DYNAMIC);

		// Populate pre-allocated strings of FPS, these are constant and there's no reason
		// to create additional garbage
		// FPS should never exceed 50, we have 0-50 (51 entries)
		String[] fpsNums = new String[FPS_SIZE];
		for (int i = 0; i < FPS_SIZE; i++)
		{
			fpsNums[i] = String.format("%02d", i);
		}
		this.fpsNums = fpsNums;

	}

	void onFocusChanged(FocusChanged event)
	{
		isFocused = event.isFocused();
	}

	private boolean isEnforced()
	{
		return FpsLimitMode.ALWAYS == config.limitMode()
			|| (FpsLimitMode.UNFOCUSED == config.limitMode() && !isFocused);
	}

	private Color getFpsValueColor()
	{
		return isEnforced() ? Color.red : Color.yellow;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.drawFps())
		{
			return null;
		}

		final int fps = client.getFPS();
		if (fps < FPS_SIZE)
		{
			final int width = client.getCanvas().getWidth();
			final Point point = new Point(width - VALUE_X_OFFSET - graphics.getFontMetrics().stringWidth(FPS_STRING), Y_OFFSET);
			OverlayUtil.renderTextLocation(graphics, point, fpsNums[fps] + FPS_STRING, getFpsValueColor());
		}

		return null;
	}
}
