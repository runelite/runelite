/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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
package net.runelite.client.plugins.fightcave;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

@Slf4j
public class FightCaveOverlay extends Overlay
{
	private static final int WIDTH = 70;
	private static final int SPACER = 6;
	private static final int BOTTOM_BORDER = 4;
	private static final Color GREEN_BACKGROUND = new Color(0, 255, 0, 100);
	private static final Color RED_BACKGROUND = new Color(255, 0, 0, 100);

	private final Client client;
	private final FightCavePlugin plugin;

	private Image protectFromMagicImg;
	private Image protectFromMissilesImg;

	@Inject
	FightCaveOverlay(@Nullable Client client, FightCavePlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		JadAttack attack = plugin.getAttack();
		Rectangle viewport = getViewportBounds();
		if (attack == null || viewport == null)
		{
			return null;
		}

		Image img = getPrayerImage(attack);
		if (img == null)
		{
			return null;
		}

		Color bgColor;
		Color outlineColor;
		Widget prayer = client.getWidget(attack.getPrayerWidgetInfo());
		FontMetrics fm = graphics.getFontMetrics();
		int height = fm.getHeight() + img.getHeight(null) + SPACER + BOTTOM_BORDER;

		if (client.isPrayerActive(attack.getPrayer()))
		{
			bgColor = GREEN_BACKGROUND;
			outlineColor = Color.GREEN.darker();
		}
		else
		{
			bgColor = RED_BACKGROUND;
			outlineColor = Color.RED.darker();
		}

		int bgX = (int) (viewport.getX() + viewport.getWidth() - WIDTH);
		int bgY = (int) (viewport.getY() + viewport.getHeight() - height);
		graphics.setColor(bgColor);
		graphics.fillRect(bgX, bgY, WIDTH, height);

		if (prayer != null)
		{
			graphics.setColor(outlineColor);
			graphics.draw(prayer.getBounds());
		}

		graphics.setColor(Color.WHITE);
		graphics.drawString("TzTok-Jad", bgX + (WIDTH - fm.stringWidth("TzTok-Jad")) / 2, bgY + fm.getHeight());
		graphics.drawImage(img, bgX + (WIDTH - img.getWidth(null)) / 2, bgY + fm.getHeight() + SPACER, null);

		return null;
	}

	private Rectangle getViewportBounds()
	{
		Widget viewport = client.getViewportWidget();
		return viewport != null ? viewport.getBounds() : null;
	}

	private Image getPrayerImage(JadAttack attack)
	{
		return attack == JadAttack.MAGIC ? getProtectFromMagicImage() : getProtectFromMissilesImage();
	}

	private Image getProtectFromMagicImage()
	{
		if (protectFromMagicImg == null)
		{
			String path = "/prayers/protect_from_magic.png";
			protectFromMagicImg = getImage(path);
		}
		return protectFromMagicImg;
	}

	private Image getProtectFromMissilesImage()
	{
		if (protectFromMissilesImg == null)
		{
			String path = "/prayers/protect_from_missiles.png";
			protectFromMissilesImg = getImage(path);
		}
		return protectFromMissilesImg;
	}

	private Image getImage(String path)
	{
		Image image = null;
		try
		{
			InputStream in = FightCaveOverlay.class.getResourceAsStream(path);
			image = ImageIO.read(in);
		}
		catch (IOException e)
		{
			log.warn("Error loading image", e);
		}
		return image;
	}
}
