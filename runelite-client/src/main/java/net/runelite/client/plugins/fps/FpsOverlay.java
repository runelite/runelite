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
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
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
	private static final int Y_OFFSET = 1;
	private static final int X_OFFSET = 1;
	private static final String FPS_STRING = " FPS";

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
	}

	void onFocusChanged(FocusChanged event)
	{
		isFocused = event.isFocused();
	}

	private boolean isEnforced()
	{
		return config.limitFps()
			|| (config.limitFpsUnfocused() && !isFocused);
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

		// On resizable bottom line mode the logout button is at the top right, so offset the overlay
		// to account for it
		Widget logoutButton = client.getWidget(WidgetInfo.RESIZABLE_MINIMAP_LOGOUT_BUTTON);
		int xOffset = X_OFFSET;
		if (logoutButton != null && !logoutButton.isHidden())
		{
			xOffset += logoutButton.getWidth();
		}
		
		final String text = client.getFPS() + FPS_STRING;
		final int textWidth = graphics.getFontMetrics().stringWidth(text);
		final int textHeight = graphics.getFontMetrics().getAscent() - graphics.getFontMetrics().getDescent();

		final int width = (int) client.getRealDimensions().getWidth();
		final Point point = new Point(width - textWidth - xOffset, textHeight + Y_OFFSET);
		OverlayUtil.renderTextLocation(graphics, point, text, getFpsValueColor());

		return null;
	}
}
