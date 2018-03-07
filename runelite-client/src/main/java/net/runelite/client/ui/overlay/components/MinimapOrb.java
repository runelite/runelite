/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui.overlay.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import lombok.Getter;
import lombok.Setter;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.RenderableEntity;

public class MinimapOrb implements RenderableEntity
{
	private static final int ORB_X = 26;
	private static final int ORB_Y = 2;
	private static final int ORB_W = 29;

	private static final Color BACKGROUND_COLOR = new Color(20, 20, 20);
	private static final Color HIGHLIGHT_COLOR = new Color(255, 255, 255, 50);

	// Frame
	private static final BufferedImage FRAME;

	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
				FRAME = ImageIO.read(MinimapOrb.class.getResourceAsStream("minimap_orb_background.png"));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	// black background
	private static final BufferedImage BACKGROUND = createOval(BACKGROUND_COLOR);

	// Highlight for recharge
	private static final BufferedImage HIGHLIGHT = createOval(HIGHLIGHT_COLOR);

	private static BufferedImage createOval(Color color)
	{
		BufferedImage img = new BufferedImage(ORB_W, ORB_W, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = img.createGraphics();

		g.setColor(color);
		g.fillOval(0, 0, ORB_W, ORB_W);

		// fillOval seems to be slightly different than the circle in the orb
		// so we just draw part of the frame ontop so it doesn't overdraw when we don't draw the
		// frame in the normal render (for hitpoints, etc.)
		g.drawImage(FRAME, -ORB_X, -ORB_Y, null);

		return img;
	}

	// Color and reflection highlight
	private final BufferedImage fill;
	// Shadow for when enabled
	private final BufferedImage fillEnabled;

	/**
	 * icon to draw ontop
	 */
	@Getter
	@Setter
	private BufferedImage overlay;

	/**
	 * how far filled the orb should be
	 */
	@Getter
	@Setter
	private double percentFilled;

	/**
	 * how far through the recharge this stat is
	 */
	@Getter
	@Setter
	private double rechargePercentFilled;

	/**
	 * number to display on the orb
	 */
	@Getter
	@Setter
	private int amount;

	/**
	 * should it look like it pressed down
	 */
	@Getter
	@Setter
	private boolean enabled;

	/**
	 * Creates a minimap orb like the prayer/HP/run orbs including a background and frame
	 */
	public MinimapOrb(Color color, Color enabledColor, BufferedImage overlay)
	{
		this.fill = createFill(color, false);
		this.fillEnabled = createFill(enabledColor, true);

		this.overlay = overlay;
	}


	/**
	 * Creates a minimap orb like the prayer/HP/run orbs without the background, frame, etc.
	 * The only part that is rendered is the icon and the recharge
	 */
	public MinimapOrb(BufferedImage overlay)
	{
		this.fill = null;
		this.fillEnabled = null;
		this.overlay = overlay;
	}

	private static BufferedImage createFill(Color color, boolean enabled)
	{
		BufferedImage bufferedImage = new BufferedImage(ORB_W, ORB_W, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics = bufferedImage.createGraphics();
		float[] dist = {0.2f, 1f};

		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		int a = color.getAlpha();

		float darkenMultiplier = 0.4f;
		Point2D center = new Point2D.Float(ORB_W / 2.7f, ORB_W / 2.7f);

		if (enabled)
		{
			// Darken and move center to make it look like the orb is pressed down
			darkenMultiplier = 0.20f;
			center = new Point2D.Float((ORB_W / 1.8f), (ORB_W / 1.8f));
			dist = new float[]{0.7f, 1f};
		}

		// Darken the base color to create a shadow effect on the edges of the orb
		r *= darkenMultiplier;
		g *= darkenMultiplier;
		b *= darkenMultiplier;

		Color[] colors = {color, new Color(r, g, b, a)};

		// Divided by 2.7f for a gradient in the top left of the orb
		graphics.setPaint(new RadialGradientPaint(center, ORB_W / 2.0f, dist, colors));

		graphics.fillOval(0, 0, ORB_W, ORB_W);

		return bufferedImage;
	}

	/**
	 * Draws a minimap orb like the prayer/HP/run orbs.
	 *
	 * @param graphics graphics to draw to
	 * @param pos      top left position of the orb
	 */
	@Override
	public Dimension render(Graphics2D graphics, Point pos)
	{
		int orbX = pos.x + ORB_X;
		int orbY = pos.y + ORB_Y;

		percentFilled = Math.max(Math.min(percentFilled, 1), 0);
		rechargePercentFilled = Math.max(Math.min(rechargePercentFilled, 1), 0);

		if (fill != null)
		{
			graphics.drawImage(BACKGROUND, orbX, orbY, null);
		}

		Shape clip = graphics.getClip();

		if (fill != null)
		{
			int height = (int) (percentFilled * ORB_W);
			graphics.setClip(orbX, orbY + (ORB_W - height), ORB_W, height);
			graphics.drawImage(enabled ? fillEnabled : fill, orbX, orbY, null);
		}

		{
			int height = (int) (rechargePercentFilled * ORB_W);
			graphics.setClip(orbX, orbY + (ORB_W - height), ORB_W, height);
			graphics.drawImage(HIGHLIGHT, orbX, orbY, null);
		}
		graphics.setClip(clip);

		if (fill != null)
		{
			graphics.drawImage(FRAME, pos.x, pos.y, null);
		}

		graphics.drawImage(
			overlay,
			orbX + (1 + ORB_W - overlay.getWidth()) / 2,
			orbY + (1 + ORB_W - overlay.getHeight()) / 2,
			null
		);

		if (fill != null)
		{
			Font font = FontManager.getRunescapeSmallFont();
			graphics.setFont(font);

			FontMetrics fm = graphics.getFontMetrics();

			String numberString = Integer.toString(amount);

			int textX = pos.x + (ORB_X - fm.stringWidth(numberString)) / 2;
			int textY = pos.y + 27;

			graphics.setColor(Color.black);
			graphics.drawString(numberString, textX + 1, textY + 1);

			Color textColor = Color.getHSBColor((float) percentFilled * (120.f / 360.f), 1, 1);
			graphics.setColor(textColor);
			graphics.drawString(numberString, textX, textY);
		}
		
		return new Dimension(BACKGROUND.getWidth(), BACKGROUND.getHeight());
	}
}
