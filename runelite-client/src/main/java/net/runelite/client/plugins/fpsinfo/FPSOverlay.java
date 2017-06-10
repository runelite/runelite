/*
 * Copyright (c) 2017, Cameron Moberg <moberg@tuta.io>
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
package net.runelite.client.plugins.fpsinfo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

public class FPSOverlay extends Overlay
{
	private static final Client client = RuneLite.getClient();
	private final FPS plugin;

	public FPSOverlay(FPS plugin)
	{
		super(OverlayPosition.DYNAMIC, OverlayPriority.HIGH);
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{

		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return null;
		}

		Font font = plugin.getFont();
		if (font != null)
		{
			graphics.setFont(font);
		}

		FontMetrics fm = graphics.getFontMetrics();
		String str = String.valueOf(client.getFPS());

		Widget xpOrb = client.getWidget(WidgetInfo.MINIMAP_XP_ORG);
		Rectangle2D bounds = xpOrb.getBounds().getBounds2D();

		int x = (int) (bounds.getX() + ((bounds.getWidth() / 2) - (fm.stringWidth(str) / 2)));
		int y = (int) (bounds.getY() - (fm.getHeight() / 2));

		//outline
		graphics.setColor(Color.BLACK);
		graphics.drawString(str, x - 1, y + 1);
		graphics.drawString(str, x - 1, y - 1);
		graphics.drawString(str, x + 1, y + 1);
		graphics.drawString(str, x + 1, y - 1);

		//actual text
		graphics.setColor(Color.WHITE);
		graphics.drawString(str, x, y);

		return new Dimension(fm.stringWidth(str), fm.getHeight());
	}
}