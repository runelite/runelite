/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui.overlay.infobox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Point;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

public class InfoBoxOverlay extends Overlay
{
	private static final int BOXSIZE = 35;
	private static final int SEPARATOR = 2;
	private static final Color BACKGROUND = new Color(Color.gray.getRed(), Color.gray.getGreen(), Color.gray.getBlue(), 127);

	private final RuneLite runelite = RuneLite.getRunelite();
	private final Client client = RuneLite.getClient();

	public InfoBoxOverlay()
	{
		super(OverlayPosition.TOP_LEFT, OverlayPriority.LOW);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return null;
		}

		List<InfoBox> infoBoxes = runelite.getInfoBoxManager().getInfoBoxes();

		if (infoBoxes.isEmpty())
		{
			return null;
		}

		FontMetrics metrics = graphics.getFontMetrics();

		int width = infoBoxes.size() * (BOXSIZE + SEPARATOR);

		Point mouse = client.getMouseCanvasPosition();
		int mouseX = mouse.getX();
		int mouseY = mouse.getY();
		int x = 0;

		Rectangle overlayBounds = this.getBounds();
		for (InfoBox box : infoBoxes)
		{
			if (!box.render())
			{
				continue;
			}

			graphics.setColor(BACKGROUND);
			graphics.fillRect(x, 0, BOXSIZE, BOXSIZE);

			graphics.setColor(Color.darkGray);
			graphics.drawRect(x, 0, BOXSIZE, BOXSIZE);

			String str = box.getText();
			Color color = box.getTextColor();

			BufferedImage image = box.getImage();
			if (image != null)
			{
				graphics.drawImage(image, x + (BOXSIZE - image.getWidth()) / 2, SEPARATOR, null);
			}

			// text shaddow
			graphics.setColor(Color.black);
			graphics.drawString(str, x + ((BOXSIZE - metrics.stringWidth(str)) / 2) + 1, BOXSIZE - SEPARATOR + 1);

			graphics.setColor(color);
			graphics.drawString(str, x + ((BOXSIZE - metrics.stringWidth(str)) / 2), BOXSIZE - SEPARATOR);

			x += BOXSIZE + SEPARATOR;

			if (overlayBounds == null)
			{
				continue;
			}

			String tooltip = box.getTooltip();
			if (tooltip == null || tooltip.isEmpty())
			{
				continue;
			}

			Rectangle bounds = new Rectangle((int) overlayBounds.getX() + x, (int) overlayBounds.getY(), BOXSIZE, BOXSIZE);
			if (bounds.contains(mouse.getX(), mouse.getY()))
			{
				int tooltipWidth = metrics.stringWidth(tooltip);
				int height = metrics.getHeight();

				int tooltipX = mouseX - (int) bounds.getX();
				int tooltipY = mouseY - (int) bounds.getY();
				if (tooltipY - height < 0)
					tooltipY = height;

				Color gray = new Color(Color.darkGray.getRed(), Color.darkGray.getGreen(), Color.darkGray.getBlue(), 190);
				graphics.setColor(gray);

				// Draws the background rect
				graphics.fillRect(tooltipX, tooltipY - height, tooltipWidth + 6, height);

				// Draws the outline of the rect
				graphics.setColor(Color.yellow);
				graphics.drawRect(tooltipX, tooltipY - height, tooltipWidth + 6, height);

				// Tooltip text
				graphics.setColor(Color.WHITE);
				graphics.drawString(tooltip, tooltipX + 3, tooltipY - height / 2 + 5);
			}
		}

		return new Dimension(width, BOXSIZE);
	}

}
