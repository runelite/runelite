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

import com.google.common.base.Strings;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.TileObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.util.ColorUtil;

public class OverlayUtil
{
	private static final int MINIMAP_DOT_RADIUS = 4;

	/**
	 * Whether the overlay currently being rendered draws into the native overlay buffer.
	 * Used by shared helpers (e.g. {@code ModelOutlineRenderer}) that draw outside the
	 * overlay's {@link Graphics2D}.
	 */
	private static final ThreadLocal<Boolean> CURRENT_OVERLAY_NATIVE = ThreadLocal.withInitial(() -> false);

	/**
	 * Canvas-space scale for decorations (images, text) drawn into the native overlay buffer.
	 * Defaults to 1.0, meaning sprites grow with stretch like the scene they are anchored to.
	 */
	public static final RenderingHints.Key KEY_NATIVE_VISUAL_SIZE_FACTOR = new RenderingHints.Key(0x4e4f5649)
	{
		@Override
		public boolean isCompatibleValue(Object val)
		{
			return val instanceof Number;
		}
	};

	public static final RenderingHints.Key KEY_NATIVE_VISUAL_SIZE_FACTOR_Y = new RenderingHints.Key(0x4e4f5659)
	{
		@Override
		public boolean isCompatibleValue(Object val)
		{
			return val instanceof Number;
		}
	};

	/**
	 * When true, {@link #renderTextLocation} and {@link net.runelite.client.ui.overlay.components.TextComponent}
	 * apply {@link #KEY_NATIVE_VISUAL_SIZE_FACTOR} locally around each glyph draw, so world-anchored
	 * text can use panel size/aspect scales without shifting canvas positions.
	 */
	public static final RenderingHints.Key KEY_NATIVE_LOCAL_TEXT_SCALE = new RenderingHints.Key(0x4e4f4c54)
	{
		@Override
		public boolean isCompatibleValue(Object val)
		{
			return val instanceof Boolean;
		}
	};

	public static void renderPolygon(Graphics2D graphics, Shape poly, Color color)
	{
		renderPolygon(graphics, poly, color, new BasicStroke(2));
	}

	public static void renderPolygon(Graphics2D graphics, Shape poly, Color color, Stroke borderStroke)
	{
		renderPolygon(graphics, poly, color, new Color(0, 0, 0, 50), borderStroke);
	}

	public static void renderPolygon(Graphics2D graphics, Shape poly, Color color, Color fillColor, Stroke borderStroke)
	{
		graphics.setColor(color);
		final Stroke originalStroke = graphics.getStroke();
		graphics.setStroke(borderStroke);
		graphics.draw(poly);
		graphics.setColor(fillColor);
		graphics.fill(poly);
		graphics.setStroke(originalStroke);
	}

	public static void renderMinimapLocation(Graphics2D graphics, Point mini, Color color)
	{
		graphics.setColor(Color.BLACK);
		graphics.fillOval(mini.getX() - MINIMAP_DOT_RADIUS / 2, mini.getY() - MINIMAP_DOT_RADIUS / 2 + 1, MINIMAP_DOT_RADIUS, MINIMAP_DOT_RADIUS);
		graphics.setColor(ColorUtil.colorWithAlpha(color, 0xFF));
		graphics.fillOval(mini.getX() - MINIMAP_DOT_RADIUS / 2, mini.getY() - MINIMAP_DOT_RADIUS / 2, MINIMAP_DOT_RADIUS, MINIMAP_DOT_RADIUS);
	}

	@Deprecated
	public static void renderMinimapRect(Client client, Graphics2D graphics, Point center, int width, int height, Color color)
	{
		double angle = client.getCameraYawTarget() * Perspective.UNIT;

		graphics.setColor(color);
		graphics.rotate(angle, center.getX(), center.getY());
		graphics.drawRect(center.getX() - width / 2, center.getY() - height / 2, width - 1, height - 1);
		graphics.rotate(-angle, center.getX(), center.getY());
	}

	public static void renderTextLocation(Graphics2D graphics, Point txtLoc, String text, Color color)
	{
		if (Strings.isNullOrEmpty(text))
		{
			return;
		}

		int x = txtLoc.getX();
		int y = txtLoc.getY();
		final Color textColor = ColorUtil.colorWithAlpha(color, 0xFF);

		double fx = getNativeVisualSizeFactor(graphics);
		double fy = getNativeVisualSizeFactorY(graphics);

		if (isNativeLocalTextScale(graphics) && (fx != 1.0 || fy != 1.0))
		{
			AffineTransform transform = graphics.getTransform();
			graphics.translate(x, y);
			graphics.scale(fx, fy);
			graphics.setColor(Color.BLACK);
			graphics.drawString(text, screenPixelOffsetX(graphics), screenPixelOffsetY(graphics));
			graphics.setColor(textColor);
			graphics.drawString(text, 0, 0);
			graphics.setTransform(transform);
			return;
		}

		// Keep the shadow one display pixel off the glyphs when they are scaled down
		float shadow = (float) fx;

		graphics.setColor(Color.BLACK);
		graphics.drawString(text, x + shadow, y + shadow);

		graphics.setColor(textColor);
		graphics.drawString(text, x, y);
	}

	public static void renderImageLocation(Client client, Graphics2D graphics, LocalPoint localPoint, BufferedImage image, int zOffset)
	{
		Point imageLocation = Perspective.getCanvasImageLocation(client, localPoint, image, zOffset);
		if (imageLocation != null)
		{
			renderImageLocation(graphics, imageLocation, image);
		}
	}

	/**
	 * Canvas-space width/height the image occupies after native overlay size scaling.
	 * Use this for layout next to text instead of {@link BufferedImage#getWidth()}/{@link BufferedImage#getHeight()}.
	 */
	public static Dimension getImageLayoutSize(Graphics2D graphics, BufferedImage image)
	{
		double fx = getNativeVisualSizeFactor(graphics);
		double fy = getNativeVisualSizeFactorY(graphics);
		if (fx == 1.0 && fy == 1.0)
		{
			return new Dimension(image.getWidth(), image.getHeight());
		}
		return new Dimension(
			Math.max(1, (int) Math.round(image.getWidth() * fx)),
			Math.max(1, (int) Math.round(image.getHeight() * fy)));
	}

	/**
	 * Renders an image at a canvas location. {@code imgLoc} is the top-left of the full bitmap
	 * footprint (as returned by {@link Perspective#getCanvasImageLocation} / actor canvas image
	 * helpers), so a scaled-down sprite stays centered in that footprint.
	 */
	public static void renderImageLocation(Graphics2D graphics, Point imgLoc, BufferedImage image)
	{
		Dimension layout = getImageLayoutSize(graphics, image);
		int x = imgLoc.getX() + (image.getWidth() - layout.width) / 2;
		int y = imgLoc.getY() + (image.getHeight() - layout.height) / 2;
		renderImageLocationExact(graphics, x, y, image);
	}

	/**
	 * Renders an image with {@code (x, y)} as the top-left of the drawn (layout-sized) sprite.
	 * Use with {@link #getImageLayoutSize} when packing icons next to text.
	 */
	public static void renderImageLocationExact(Graphics2D graphics, Point imgLoc, BufferedImage image)
	{
		renderImageLocationExact(graphics, imgLoc.getX(), imgLoc.getY(), image);
	}

	private static void renderImageLocationExact(Graphics2D graphics, int x, int y, BufferedImage image)
	{
		double fx = getNativeVisualSizeFactor(graphics);
		double fy = getNativeVisualSizeFactorY(graphics);
		if (fx == 1.0 && fy == 1.0)
		{
			graphics.drawImage(image, x, y, null);
			return;
		}

		AffineTransform transform = graphics.getTransform();
		graphics.translate(x, y);
		graphics.scale(fx, fy);
		graphics.drawImage(image, 0, 0, null);
		graphics.setTransform(transform);
	}

	public static double getNativeVisualSizeFactor(Graphics2D graphics)
	{
		Object value = graphics.getRenderingHint(KEY_NATIVE_VISUAL_SIZE_FACTOR);
		return value instanceof Number ? ((Number) value).doubleValue() : 1.0;
	}

	public static double getNativeVisualSizeFactorY(Graphics2D graphics)
	{
		Object value = graphics.getRenderingHint(KEY_NATIVE_VISUAL_SIZE_FACTOR_Y);
		return value instanceof Number ? ((Number) value).doubleValue() : getNativeVisualSizeFactor(graphics);
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

	public static void renderActorOverlayImage(Graphics2D graphics, Actor actor, BufferedImage image, Color color, int zOffset)
	{
		Polygon poly = actor.getCanvasTilePoly();
		if (poly != null)
		{
			renderPolygon(graphics, poly, color);
		}

		Point imageLocation = actor.getCanvasImageLocation(image, zOffset);
		if (imageLocation != null)
		{
			renderImageLocation(graphics, imageLocation, image);
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

	public static void renderTileOverlay(Client client, Graphics2D graphics, LocalPoint localLocation, BufferedImage image, Color color)
	{
		Polygon poly = Perspective.getCanvasTilePoly(client, localLocation);
		if (poly != null)
		{
			renderPolygon(graphics, poly, color);
		}

		renderImageLocation(client, graphics, localLocation, image, 0);
	}

	public static void renderHoverableArea(Graphics2D graphics, Shape area, Point mousePosition, Color fillColor, Color borderColor, Color borderHoverColor)
	{
		if (area != null)
		{
			if (area.contains(mousePosition.getX(), mousePosition.getY()))
			{
				graphics.setColor(borderHoverColor);
			}
			else
			{
				graphics.setColor(borderColor);
			}

			graphics.draw(area);
			graphics.setColor(fillColor);
			graphics.fill(area);
		}
	}

	public static void setGraphicProperties(Graphics2D graphics)
	{
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	/**
	 * Sets the canvas-space size factors decorations drawn into the native overlay buffer
	 * should use, so they can shrink to their unstretched size without moving.
	 */
	public static void setNativeOverlayProperties(Graphics2D graphics, double visualSizeFactorX, double visualSizeFactorY)
	{
		setNativeOverlayProperties(graphics, visualSizeFactorX, visualSizeFactorY, false);
	}

	/**
	 * @param localTextScale see {@link #KEY_NATIVE_LOCAL_TEXT_SCALE}
	 */
	public static void setNativeOverlayProperties(Graphics2D graphics, double visualSizeFactorX, double visualSizeFactorY,
		boolean localTextScale)
	{
		setGraphicProperties(graphics);
		graphics.setRenderingHint(KEY_NATIVE_VISUAL_SIZE_FACTOR, visualSizeFactorX);
		graphics.setRenderingHint(KEY_NATIVE_VISUAL_SIZE_FACTOR_Y, visualSizeFactorY);
		graphics.setRenderingHint(KEY_NATIVE_LOCAL_TEXT_SCALE, localTextScale);
	}

	public static boolean isNativeLocalTextScale(Graphics2D graphics)
	{
		return Boolean.TRUE.equals(graphics.getRenderingHint(KEY_NATIVE_LOCAL_TEXT_SCALE));
	}

	/**
	 * User-space offset that maps to approximately one device pixel on X after the current
	 * transform (outer stretch × local content scale).
	 */
	public static float screenPixelOffsetX(Graphics2D graphics)
	{
		double scale = Math.abs(graphics.getTransform().getScaleX());
		return scale == 0.0 ? 1f : (float) (1.0 / scale);
	}

	/**
	 * User-space offset that maps to approximately one device pixel on Y after the current
	 * transform (outer stretch × local content scale).
	 */
	public static float screenPixelOffsetY(Graphics2D graphics)
	{
		double scale = Math.abs(graphics.getTransform().getScaleY());
		return scale == 0.0 ? 1f : (float) (1.0 / scale);
	}

	/**
	 * Shifts a canvas text location so a left-aligned {@code drawString} stays centered when
	 * {@link #isNativeLocalTextScale} shrinks the glyph width by the X size factor.
	 */
	public static Point adjustLocalTextScaleLocation(Graphics2D graphics, Point textLocation, String text)
	{
		if (textLocation == null || Strings.isNullOrEmpty(text) || !isNativeLocalTextScale(graphics))
		{
			return textLocation;
		}

		double fx = getNativeVisualSizeFactor(graphics);
		if (fx == 1.0)
		{
			return textLocation;
		}

		int fullWidth = graphics.getFontMetrics().stringWidth(text);
		int layoutWidth = Math.max(0, (int) Math.round(fullWidth * fx));
		return new Point(textLocation.getX() + (fullWidth - layoutWidth) / 2, textLocation.getY());
	}

	/**
	 * Width of the drawable area in the current native content-scale user space. Right-aligned HUD
	 * (FPS/ping) must use this after panel content scale so the right edge stays flush.
	 */
	public static int getContentSpaceWidth(Graphics2D graphics, int canvasWidth)
	{
		double cx = getNativeVisualSizeFactor(graphics);
		if (cx == 0.0 || cx == 1.0)
		{
			return canvasWidth;
		}
		return Math.max(1, (int) Math.round(canvasWidth / cx));
	}

	/**
	 * @return previous value
	 */
	public static boolean setCurrentOverlayNative(boolean nativePass)
	{
		boolean previous = CURRENT_OVERLAY_NATIVE.get();
		CURRENT_OVERLAY_NATIVE.set(nativePass);
		return previous;
	}

	public static boolean isCurrentOverlayNative()
	{
		return CURRENT_OVERLAY_NATIVE.get();
	}
}
