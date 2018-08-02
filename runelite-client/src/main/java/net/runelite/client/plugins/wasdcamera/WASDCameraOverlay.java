/*
 * Copyright (c) 2018, Abexlry <abexlry@gmail.com>
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
package net.runelite.client.plugins.wasdcamera;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TextComponent;

public class WASDCameraOverlay extends Overlay
{
	@Inject
	private Client client;

	private final TextComponent textComponent = new TextComponent();

	private WASDCameraPlugin plugin;

	private static final int X_OFFSET = 40;
	private static final int Y_OFFSET = 134;

	private int nameLength;

	private String lockedMessage;

	@Inject
	private WASDCameraOverlay(WASDCameraPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.plugin = plugin;
		this.lockedMessage = "Press Enter to Chat...";
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		return textComponent.render(graphics);
	}

	public void updateOverlay()
	{
		// Update text of component based on lock and typing in chat
		if (plugin.handleCam && plugin.canHandle())
		{
			Widget widget = client.getWidget(WidgetInfo.CHATBOX);
			Rectangle bounds = widget.getBounds();

			int temp = nameLength;
			nameLength = client.getLocalPlayer().getName().length();

			int offset = (nameLength * 5) + X_OFFSET;

			if (temp != nameLength)
			{
				// If player is an ironman, move over more
				if (client.getAccountType().isIronman())
				{
					offset = offset + 12;
				}
			}

			textComponent.setText(lockedMessage);
			textComponent.setColor(plugin.config.getOverlayColor());
			textComponent.setPosition(new Point(bounds.x + offset, bounds.y + Y_OFFSET));
		}
		else
		{
			textComponent.setText("");
		}
	}
}
