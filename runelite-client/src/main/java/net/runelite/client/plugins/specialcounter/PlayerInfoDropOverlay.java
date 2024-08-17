/*
 * Copyright (c) 2022, Hexagon <hexagon@fking.work>
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
package net.runelite.client.plugins.specialcounter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;

@Singleton
class PlayerInfoDropOverlay extends Overlay
{
	private final SpecialCounterPlugin plugin;
	private final SpecialCounterConfig config;
	private final Client client;

	@Inject
	private PlayerInfoDropOverlay(SpecialCounterPlugin plugin, SpecialCounterConfig config, Client client)
	{
		this.plugin = plugin;
		this.config = config;
		this.client = client;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(PRIORITY_MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final List<PlayerInfoDrop> infoDrops = plugin.getPlayerInfoDrops();
		if (infoDrops.isEmpty())
		{
			return null;
		}

		final int cycle = client.getGameCycle();
		for (Iterator<PlayerInfoDrop> iterator = infoDrops.iterator(); iterator.hasNext(); )
		{
			PlayerInfoDrop infoDrop = iterator.next();

			if (cycle < infoDrop.getStartCycle())
			{
				continue;
			}

			if (cycle > infoDrop.getEndCycle())
			{
				iterator.remove();
				continue;
			}

			if (!config.specDrops())
			{
				continue;
			}

			Player player = client.getCachedPlayers()[infoDrop.getPlayerIdx()];
			if (player == null)
			{
				continue;
			}

			int elapsed = cycle - infoDrop.getStartCycle();
			int percent = elapsed * 100 / (infoDrop.getEndCycle() - infoDrop.getStartCycle());
			int currentHeight = infoDrop.getEndHeightOffset() * percent / 100;
			String text = infoDrop.getText();

			graphics.setFont(infoDrop.getFont());
			Point playerLocation = player.getCanvasTextLocation(graphics, text, player.getLogicalHeight() + infoDrop.getStartHeightOffset() + currentHeight);
			if (playerLocation == null)
			{
				continue;
			}

			FontMetrics fontMetrics = graphics.getFontMetrics();
			int alpha = 255 - (255 * percent / 100);

			BufferedImage sprite = infoDrop.getImage();
			int textHeight = fontMetrics.getHeight() - fontMetrics.getMaxDescent();
			int textWidth = fontMetrics.stringWidth(text);
			int textMargin = sprite.getWidth() / 2;

			Point imageLocation = new Point(
				playerLocation.getX() - textMargin - 1,
				playerLocation.getY() - textHeight / 2 - sprite.getHeight() / 2
			);
			Point textLocation = new Point(playerLocation.getX() + textMargin, playerLocation.getY());

			BufferedImage backgroundSprite = infoDrop.getTextBackground();
			if (backgroundSprite != null)
			{
				int x = textLocation.getX();
				int y = textLocation.getY();

				y -= textHeight / 2;
				y -= backgroundSprite.getHeight() / 2;

				x += (textWidth + 1) / 2;
				x -= backgroundSprite.getWidth() / 2;

				OverlayUtil.renderImageLocation(graphics, new Point(x, y), ImageUtil.alphaOffset(backgroundSprite, alpha - 255));
			}

			OverlayUtil.renderImageLocation(graphics, imageLocation, ImageUtil.alphaOffset(sprite, alpha - 255));

			drawText(graphics, textLocation, text, infoDrop.getColor(), alpha);
		}
		return null;
	}

	private static void drawText(Graphics2D g, Point point, String text, Color color, int colorAlpha)
	{
		g.setColor(ColorUtil.colorWithAlpha(Color.BLACK, colorAlpha));
		g.drawString(text, point.getX() + 1, point.getY() + 1);
		g.setColor(ColorUtil.colorWithAlpha(color, colorAlpha));
		g.drawString(text, point.getX(), point.getY());
	}
}