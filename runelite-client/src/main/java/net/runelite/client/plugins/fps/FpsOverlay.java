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
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.Varbits;
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
	private static final int Y_OFFSET = 14;

	// Local dependencies
	private final FpsConfig config;
	private final Client client;

	@Inject
	private FpsPlugin plugin;

	// Often changing values
	private boolean isFocused = true;

	@Inject
	private FpsOverlay(FpsConfig config, Client client)
	{
		this.config = config;
		this.client = client;
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.DYNAMIC);
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

	private Color getPingColor(int ping)
	{
		if (ping >= 100 || ping < 0)
		{
			return Color.red;
		}
		else if (ping >= 50)
		{
			return Color.yellow;
		}
		return Color.green;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Point point;

		final int offset = calculateOffset();
		final int width = (int) client.getRealDimensions().getWidth();
		final FontMetrics fontMetrics = graphics.getFontMetrics();
		final int ping = plugin.getPing();

		//FPS indicator
		if (config.drawFps())
		{
			final int fps = client.getFPS();
			final String fpsText = String.format("%d FPS", fps);
			final int textWidth = fontMetrics.stringWidth(fpsText);

			point = new Point(width - textWidth - offset, Y_OFFSET);
			OverlayUtil.renderTextLocation(graphics, point, fpsText, getFpsValueColor());
		}

		//Ping indicator
		if (config.drawPing() && ping >= 0)
		{
			//Shifts up when FPS is not being drawn
			final int pingYOffset = config.drawFps() ? 11 : 0;
			final String pingText = String.format("%dms", ping);
			final int textWidth = fontMetrics.stringWidth(pingText);

			point = new Point(width - textWidth - offset, Y_OFFSET + pingYOffset);
			OverlayUtil.renderTextLocation(graphics, point, pingText, getPingColor(ping));
		}

		return null;
	}

	private int calculateOffset()
	{
		if ((client.getVar(Varbits.SIDE_PANELS) == 1) && client.isResized())
		{
			return 27;
		}

		return 2;
	}
}
