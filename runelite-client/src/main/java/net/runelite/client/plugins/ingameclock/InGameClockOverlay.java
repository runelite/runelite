/*
 * Copyright (c) 2018, Jos <Malevolentdev@gmail.com>
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
package net.runelite.client.plugins.ingameclock;

import com.google.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import net.runelite.api.Client;
import static net.runelite.api.SpriteID.CHATBOX_BUTTON;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class InGameClockOverlay extends Overlay
{
	private final Client client;
	private final SpriteManager spriteManger;
	private final InGameClockConfig config;
	private static final int resizableMode_X = 108;
	private static final int resizableMode_Y = 150;
	private static final int fixedMode_X = 690;
	private static final int fixedMode_Y = 147;
	private static final int clockOffset_X = 8;
	private static final int clockOffset_Y = 16;

	@Inject
	private InGameClockOverlay(Client client, SpriteManager spriteManger, InGameClockConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.spriteManger = spriteManger;
		this.config = config;
	}

	public Dimension render(Graphics2D graphics)
	{
		Widget clockWidget = client.getWidget(WidgetInfo.RESIZABLE_MINIMAP_WIDGET);
		String timeFormat;

		if (config.hourFormat())
		{
			timeFormat = "hh:mm:ss";
		}
		else
		{
			timeFormat = "HH:mm:ss";
		}

		String time = new SimpleDateFormat(timeFormat).format(
				Calendar.getInstance().getTime());

		int clock_x;
		int clock_y;

		if (client.isResized())
		{
			clock_x = clockWidget.getRelativeX() + resizableMode_X;
			clock_y = clockWidget.getRelativeY() + resizableMode_Y;
		}
		else
		{
			clock_x = clockWidget.getOriginalX() + fixedMode_X;
			clock_y = clockWidget.getOriginalY() + fixedMode_Y;
		}

		Image img = spriteManger.getSprite(CHATBOX_BUTTON, 0);
		graphics.drawImage(img, clock_x, clock_y, null);
		graphics.drawString(time, clock_x + clockOffset_X, clock_y + clockOffset_Y);

		return null;
	}
}
