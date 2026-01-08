/*
 * Copyright (c) 2019, gregg1494 <https://github.com/gregg1494>
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
package net.runelite.client.plugins.worldhopper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

class WorldHopperPingOverlay extends Overlay
{
	private static final int Y_OFFSET = 11;
	private static final int X_OFFSET = 1;

	private final Client client;
	private final WorldHopperPlugin worldHopperPlugin;
	private final WorldHopperConfig worldHopperConfig;

	@Inject
	private WorldHopperPingOverlay(Client client, WorldHopperPlugin worldHopperPlugin, WorldHopperConfig worldHopperConfig)
	{
		this.client = client;
		this.worldHopperPlugin = worldHopperPlugin;
		this.worldHopperConfig = worldHopperConfig;
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(PRIORITY_HIGH);
		setPosition(OverlayPosition.DYNAMIC);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!worldHopperConfig.displayPing())
		{
			return null;
		}

		final int ping = worldHopperPlugin.getCurrentPing();
		if (ping < 0)
		{
			return null;
		}

		final String text = ping + " ms";
		final int textWidth = graphics.getFontMetrics().stringWidth(text);
		final int textHeight = graphics.getFontMetrics().getAscent() - graphics.getFontMetrics().getDescent();

		// Adjust ping offset for logout button
		Widget logoutButton = client.getWidget(InterfaceID.ToplevelPreEoc.ICON10);
		int xOffset = X_OFFSET;
		if (logoutButton != null && !logoutButton.isHidden())
		{
			xOffset += logoutButton.getWidth();
		}

		final int width = (int) client.getRealDimensions().getWidth();
		final Point point = new Point(width - textWidth - xOffset, textHeight + Y_OFFSET);
		OverlayUtil.renderTextLocation(graphics, point, text, Color.YELLOW);

		return null;
	}
}