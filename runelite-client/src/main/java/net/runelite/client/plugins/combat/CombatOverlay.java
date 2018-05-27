/*
 * Copyright (c) 2018, Raqes <j.raqes@gmail.com>
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
 */
package net.runelite.client.plugins.combat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

@Slf4j
public class CombatOverlay extends Overlay
{
	private static final Color TEXT_COLOR_BACKGROUND = new Color(0, 0, 0);
	private static final Color TEXT_COLOR_FRONT = new Color(255, 255, 0);
	private static final int TEXT_OFFSET = 10;
	private static final int FIXED_VIEWPORT_OFFSET_X = 4;
	private static final int FIXED_VIEWPORT_OFFSET_Y = 4;

	private Client client;

	private CombatConfig config;

	private CombatPlugin plugin;

	@Inject
	CombatOverlay(Client client, CombatConfig config, CombatPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!isWidgetVisible(client.getWidget(WidgetInfo.WILDERNESS_CONTAINER))
			|| plugin.isExcludedWorld()
			|| !config.showCombatRange())
		{
			return null;
		}

		Widget wildernessWidget = client.getWidget(WidgetInfo.WILDERNESS_CONTAINER);

		int centerX = wildernessWidget.getRelativeX() + wildernessWidget.getWidth() / 2;
		int centerY = wildernessWidget.getRelativeY() + wildernessWidget.getHeight() + TEXT_OFFSET;

		if (isWidgetVisible(client.getWidget(WidgetInfo.FIXED_VIEWPORT)))
		{
			centerX += FIXED_VIEWPORT_OFFSET_X;
			centerY += FIXED_VIEWPORT_OFFSET_Y;
		}

		Widget textWidget = client.getWidget(WidgetInfo.WILDERNESS_LEVEL);
		textWidget.setTextColor(getDecimalColor(TEXT_COLOR_FRONT));

		String bracketText = getCombatRange(client.getWidget(WidgetInfo.WILDERNESS_LEVEL).getText());
		int offsetX = graphics.getFontMetrics().stringWidth(bracketText) / 2;

		graphics.setColor(TEXT_COLOR_BACKGROUND);
		graphics.drawString(bracketText, centerX - offsetX + 1, centerY + 1);

		graphics.setColor(TEXT_COLOR_FRONT);
		graphics.drawString(bracketText, centerX - offsetX, centerY);

		return null;
	}

	private String getCombatRange(String text)
	{
		int wildernessLevel = Integer.valueOf(text.replace("Level: ", ""));
		int combat = client.getLocalPlayer().getCombatLevel();
		int minimum = (combat - wildernessLevel) <= 3 ? 3 : combat - wildernessLevel;
		int maximum = (combat + wildernessLevel) >= 126 ? 126 : combat + wildernessLevel;
		return minimum + "-" + maximum;
	}

	private int getDecimalColor(Color color)
	{
		return (color.getRed() << 16) + (color.getGreen() << 8) + color.getBlue();
	}

	private boolean isWidgetVisible(Widget widget)
	{
		return widget != null && !widget.isHidden();
	}
}
