/*
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
package net.runelite.client.ui.overlay;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.SpritePixels;
import net.runelite.api.TileObject;
import net.runelite.client.ui.FontManager;


/**
 * Created by Kyle Fricilone on Jun 09, 2017.
 */
public class OverlayUtil
{

	public static void renderPolygon(Graphics2D graphics, Polygon poly, Color color)
	{
		graphics.setColor(color);
		graphics.setStroke(new BasicStroke(2));
		graphics.drawPolygon(poly);
		graphics.setColor(new Color(0, 0, 0, 50));
		graphics.fillPolygon(poly);
	}

	/**
	 * Draws a minimap orb like the prayer/HP/run orbs. The background color can be set by graphics.setColor() before calling this
	 *
	 * @param graphics              graphics to draw to
	 * @param pos                   top left position of the orb
	 * @param percentFilled         how far filled the orb should be
	 * @param rechargeColor         color of the recharge meter of this orb. This can be used to track things like hp regen or special regen.
	 * @param rechargePercentFilled how far through the recharge this stat is
	 * @param minimapOrbBackground  background image of the minimap orb
	 * @param overlayImage
	 * @param amount                number to display on the orb
	 * @param enabled
	 */
	public static void drawMinimapOrb(Graphics2D graphics, Point pos, double percentFilled, Color rechargeColor, double rechargePercentFilled, Image minimapOrbBackground, Image overlayImage, int amount, boolean enabled)
	{
		Color startColor = graphics.getColor();

		Point orbPos = new Point(pos.getX() + 26, pos.getY() + 2);

		graphics.setColor(new Color(20, 20, 20));
		// draw black background for the orb when it's partially missing
		drawOrbPercent(graphics, orbPos, 1, 28, false, false);
		graphics.setColor(startColor);

		// draw orb with shading
		drawOrbPercent(graphics, orbPos, percentFilled, 28, true, enabled);

		graphics.setColor(rechargeColor);
		// draw recharge
		drawOrbPercent(graphics, orbPos, rechargePercentFilled, 28, false, false);
		graphics.setColor(startColor);

		// draw background
		graphics.drawImage(minimapOrbBackground, pos.getX(), pos.getY(), null);
		// draw overlay
		graphics.drawImage(overlayImage, pos.getX() + 33, pos.getY() + 10, null);

		drawOrbAmount(graphics, pos, amount);//draw number on orb

	}

	/**
	 * Draws the amount text on minimap orbs. For example HP number on the HP minimap orb
	 *
	 * @param graphics graphics to draw on
	 * @param pos      start position
	 * @param amount   number amount
	 */
	private static void drawOrbAmount(Graphics2D graphics, Point pos, int amount)
	{
		Color startColor = graphics.getColor();

		Font font = FontManager.getRunescapeSmallFont();
		graphics.setFont(font);

		FontMetrics fm = graphics.getFontMetrics();

		String numberString = Integer.toString(amount);
		Point numberPos = new Point(pos.getX() + 24 - fm.stringWidth(numberString), pos.getY() + 27);
		graphics.setColor(Color.black);
		graphics.drawString(numberString, numberPos.getX() + 1, numberPos.getY() + 1);//black shadow on text
		graphics.setColor(Color.green);
		graphics.drawString(numberString, numberPos.getX(), numberPos.getY());

		graphics.setColor(startColor);
	}

	/**
	 * Renders a orb similar to the health/prayer orbs already in the client.
	 * This has a slight shadow effect similar to the clients orbs if shadow = true
	 *
	 * @param graphics graphics to draw to
	 * @param pos      Top left position of the orb
	 * @param percent  0.0-1.0 percent of how filled the orb is
	 * @param diameter diameter of the orb
	 * @param shadow   draw shadow
	 */
	private static void drawOrbPercent(Graphics2D graphics, Point pos, double percent, int diameter, boolean shadow, boolean enabled)
	{
		BufferedImage bufferedImage = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
		Graphics2D bufferedImageGraphics = bufferedImage.createGraphics();
		float[] dist = {0.2f, 1f};

		Color setColor = graphics.getColor();

		int r = setColor.getRed();
		int g = setColor.getGreen();
		int b = setColor.getBlue();
		int a = setColor.getAlpha();

		Paint startPaint = bufferedImageGraphics.getPaint();

		if (shadow)
		{
			float darkenMultiplier = 0.4f;
			Point2D center = new Point2D.Float(diameter / 2.7f, diameter / 2.7f);

			if (enabled)
			{
				// Darken and move center to make it look like the orb is pressed down
				darkenMultiplier = 0.20f;
				center = new Point2D.Float((diameter / 1.8f), (diameter / 1.8f));
				dist = new float[]{0.7f, 1f};
			}

			// Darken the base color to create a shadow effect on the edges of the orb
			r *= darkenMultiplier;
			g *= darkenMultiplier;
			b *= darkenMultiplier;

			Color[] colors = {setColor, new Color(r, g, b, a)};

			// Divided by 2.7f for a gradient in the top left of the orb
			RadialGradientPaint p = new RadialGradientPaint(center,
				diameter / 2.0f, dist, colors);

			bufferedImageGraphics.setPaint(p);

		}
		else
		{
			bufferedImageGraphics.setColor(setColor);
		}

		bufferedImageGraphics.fillArc(0, 0, diameter, diameter, 0, 360);
		if (percent < 1)
		{
			// Clear the top part of the orb. if we input 90% we need to clear the top 10%
			bufferedImageGraphics.setBackground(new Color(255, 255, 255, 0));
			bufferedImageGraphics.clearRect(0, 0, diameter, (int) ((diameter) * (1 - percent)));
		}

		graphics.drawImage(bufferedImage, pos.getX(), pos.getY(), null);

		bufferedImageGraphics.setPaint(startPaint);
		bufferedImageGraphics.dispose();
	}

	public static void renderMinimapLocation(Graphics2D graphics, Point mini, Color color)
	{
		graphics.setColor(color);
		graphics.fillOval(mini.getX(), mini.getY(), 5, 5);
		graphics.setColor(Color.WHITE);
		graphics.setStroke(new BasicStroke(1));
		graphics.drawOval(mini.getX(), mini.getY(), 5, 5);
	}

	public static void renderTextLocation(Graphics2D graphics, Point txtLoc, String text, Color color)
	{
		int x = txtLoc.getX();
		int y = txtLoc.getY();

		graphics.setColor(Color.BLACK);
		graphics.drawString(text, x + 1, y + 1);

		graphics.setColor(color);
		graphics.drawString(text, x, y);
	}

	public static void renderImageLocation(Graphics2D graphics, Point imgLoc, BufferedImage image)
	{
		int x = imgLoc.getX();
		int y = imgLoc.getY();

		graphics.drawImage(image, x, y, null);
	}

	public static void renderSpriteLocation(Graphics2D graphics, Point imgLoc, SpritePixels sprite)
	{
		int x = imgLoc.getX();
		int y = imgLoc.getY();

		sprite.drawAt(x, y);
	}

	public static void renderActorOverlay(Graphics2D graphics, Actor actor, String text, Color color)
	{
		Polygon poly = actor.getCanvasTilePoly();
		if (poly != null)
		{
			renderPolygon(graphics, poly, color);
		}

		Point textLocation = actor.getCanvasTextLocation(graphics, text, actor.getLogicalHeight() + 40);
		if (textLocation != null)
		{
			renderTextLocation(graphics, textLocation, text, color);
		}
	}

	public static void renderActorOverlayImage(Graphics2D graphics, Actor actor, BufferedImage image, Color color)
	{
		Polygon poly = actor.getCanvasTilePoly();
		if (poly != null)
		{
			renderPolygon(graphics, poly, color);
		}

		Point imageLocation = actor.getCanvasImageLocation(graphics, image, actor.getLogicalHeight());
		if (imageLocation != null)
		{
			renderImageLocation(graphics, imageLocation, image);
		}
	}

	public static void renderActorOverlaySprite(Graphics2D graphics, Actor actor, SpritePixels sprite, Color color)
	{
		Polygon poly = actor.getCanvasTilePoly();
		if (poly != null)
		{
			renderPolygon(graphics, poly, color);
		}

		Point minimapLocation = actor.getMinimapLocation();
		if (minimapLocation != null)
		{
			renderMinimapLocation(graphics, minimapLocation, color);
		}

		Point imageLocation = actor.getCanvasSpriteLocation(graphics, sprite, actor.getLogicalHeight());
		if (imageLocation != null)
		{
			renderSpriteLocation(graphics, imageLocation, sprite);
		}
	}

	public static void renderTileOverlay(Graphics2D graphics, TileObject tileObject, String text, Color color)
	{
		Polygon poly = tileObject.getCanvasTilePoly();
		if (poly != null)
		{
			renderPolygon(graphics, poly, color);
		}

		Point minimapLocation = tileObject.getMinimapLocation();
		if (minimapLocation != null)
		{
			renderMinimapLocation(graphics, minimapLocation, color);
		}

		Point textLocation = tileObject.getCanvasTextLocation(graphics, text, 0);
		if (textLocation != null)
		{
			renderTextLocation(graphics, textLocation, text, color);
		}
	}

	public static void renderTilePointOverlay(Graphics2D graphics, Client client, Point point, String text, Color color)
	{
		Polygon poly = Perspective.getCanvasTilePoly(client, point);

		if (poly != null)
		{
			renderPolygon(graphics, poly, color);
		}

		Point minimapLocation = Perspective.worldToMiniMap(client, point.getX(), point.getY());
		if (minimapLocation != null)
		{
			renderMinimapLocation(graphics, minimapLocation, color);
		}

		Point textLocation = Perspective.getCanvasTextLocation(client, graphics, point, text, 0);
		if (textLocation != null)
		{
			renderTextLocation(graphics, textLocation, text, color);
		}
	}

	public static void setGraphicProperties(Graphics2D graphics)
	{
		graphics.setFont(FontManager.getRunescapeFont());
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	public static java.awt.Point transformPosition(OverlayPosition position, Dimension dimension)
	{
		final java.awt.Point result = new java.awt.Point();

		switch (position)
		{
			case DYNAMIC:
			case TOP_LEFT:
				break;
			case BOTTOM_LEFT:
				result.y = result.y - dimension.height;
				break;
			case BOTTOM_RIGHT:
			case ABOVE_CHATBOX_RIGHT:
				result.y = result.y - dimension.height;
			case TOP_RIGHT:
				result.x = result.x - dimension.width;
				break;
		}

		return result;
	}
}
