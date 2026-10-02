/*
 * Copyright (c) 2026
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
package net.runelite.client.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.JPanel;
import net.runelite.client.util.ImageUtil;


final class FolderButton extends JPanel
{
	private static final int SIZE = 16;

	private final Icon icon;

	FolderButton(Icon icon, String name)
	{
		this.icon = icon;
		setOpaque(false);
		setFocusable(false);
		setToolTipText(name);
		setPreferredSize(new Dimension(SIZE, SIZE));
		setMinimumSize(new Dimension(SIZE, SIZE));
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int x = (getWidth() - icon.getIconWidth()) / 2;
		int y = (getHeight() - icon.getIconHeight()) / 2;
		icon.paintIcon(this, g, Math.max(0, x), Math.max(0, y));
	}

	static BufferedImage defaultIcon(boolean expanded)
	{
		BufferedImage image = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();
		try
		{
			g.setColor(ColorScheme.BRAND_ORANGE);
			g.fillRoundRect(1, 4, 14, 10, 2, 2);
			g.fillRoundRect(1, 2, 7, 4, 2, 2);
			if (expanded)
			{
				g.setColor(ColorScheme.GRAND_EXCHANGE_ALCH);
				g.fillRect(2, 8, 12, 5);
			}
			g.setColor(ColorScheme.LIGHT_GRAY_COLOR);
			g.drawRoundRect(1, 4, 13, 9, 2, 2);
			paintArrow(g, expanded);
		}
		finally
		{
			g.dispose();
		}
		return image;
	}


	 // Grey border for plugin icon as folder

	static BufferedImage pluginIcon(BufferedImage icon, boolean expanded)
	{
		BufferedImage scaled = ImageUtil.resizeImage(icon, SIZE - 2, SIZE - 2);
		BufferedImage image = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();
		try
		{
			g.drawImage(scaled, 1, 1, null);
			g.setColor(ColorScheme.LIGHT_GRAY_COLOR);
			g.drawRect(0, 0, SIZE - 1, SIZE - 1);
			paintArrow(g, expanded);
		}
		finally
		{
			g.dispose();
		}
		return image;
	}

	private static void paintArrow(Graphics2D g, boolean expanded)
	{
		g.setColor(ColorScheme.DARKER_GRAY_COLOR);
		if (expanded)
		{
			g.fillPolygon(new int[]{9, 15, 12}, new int[]{10, 10, 15}, 3);
		}
		else
		{
			g.fillPolygon(new int[]{10, 10, 15}, new int[]{9, 15, 12}, 3);
		}
	}
}
