/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.dynamicmaxhit;

import com.google.common.base.Strings;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Point;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

@Singleton
@Slf4j
public class AttackerOverlay extends Overlay
{
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#");
	private final Font timerFont = FontManager.getRunescapeBoldFont().deriveFont(14.0f);
	private final DynamicMaxHit plugin;

	@Inject
	public AttackerOverlay(final DynamicMaxHit plugin)
	{
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGHEST);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Map<String, Victim> temp = new HashMap<>(plugin.getVictims());

		if (temp.isEmpty())
		{
			return null;
		}

		for (Victim player : temp.values())
		{
			final AttackStyle attackStyle = player.getAttackStyle();

			if (player.getMaxHit() < 1)
			{
				continue;
			}

			final String text = DECIMAL_FORMAT.format(player.getMaxHit());
			final String specText = DECIMAL_FORMAT.format(player.getSpecMaxHit());
			final Point textLocation;
			final Point specTextLocation;

			if (player.getPlayer().getSkullIcon() == null)
			{
				textLocation = player.getPlayer().getCanvasTextLocation(graphics, text, player.getPlayer().getLogicalHeight() + 40);
				specTextLocation = player.getPlayer().getCanvasTextLocation(graphics, specText, player.getPlayer().getLogicalHeight() + 80);
			}
			else
			{
				textLocation = player.getPlayer().getCanvasTextLocation(graphics, text, player.getPlayer().getLogicalHeight() - 40);
				specTextLocation = player.getPlayer().getCanvasTextLocation(graphics, specText, player.getPlayer().getLogicalHeight() - 80);
			}

			if (textLocation != null)
			{
				renderTextLocation(graphics, textLocation, text, attackStyle.getColor());
			}
			if (specTextLocation != null && !specText.equals(text))
			{
				renderTextLocation(graphics, specTextLocation, specText, Color.ORANGE);
			}
		}
		return null;
	}

	private void renderTextLocation(Graphics2D graphics, Point txtLoc, String text, Color color)
	{
		if (Strings.isNullOrEmpty(text))
		{
			return;
		}

		int x = txtLoc.getX();
		int y = txtLoc.getY();

		graphics.setColor(Color.BLACK);
		graphics.drawString(text, x + 1, y + 1);
		graphics.setFont(timerFont);
		graphics.setStroke(new BasicStroke(1));
		graphics.setColor(color);
		graphics.drawString(text, x, y);
	}
}
