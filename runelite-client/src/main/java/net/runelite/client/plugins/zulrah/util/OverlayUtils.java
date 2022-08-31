package net.runelite.client.plugins.zulrah.util;

import com.google.common.base.Strings;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.util.function.Supplier;
import net.runelite.api.Point;
import net.runelite.api.widgets.Widget;

public class OverlayUtils
{
	public static float getAlphaTime()
	{
		return (float) Math.abs(System.currentTimeMillis() % 2000L - 1000L) / 1000.0F;
	}

	public static void renderImageLocation(Graphics2D graphics, Point imgLoc, BufferedImage image)
	{
		if (imgLoc != null && image != null)
		{
			int x = imgLoc.getX();
			int y = imgLoc.getY();
			graphics.drawImage(image, x, y, null);
		}
	}

	public static void renderTextLocation(Graphics2D graphics, Point txtLoc, String text, Color color, Supplier outline)
	{
		if (txtLoc != null && !Strings.isNullOrEmpty(text))
		{
			int x = txtLoc.getX();
			int y = txtLoc.getY();
			graphics.setColor(Color.BLACK);
			if ((Boolean) outline.get())
			{
				graphics.drawString(text, x, y + 1);
				graphics.drawString(text, x, y - 1);
				graphics.drawString(text, x + 1, y);
				graphics.drawString(text, x - 1, y);
			}
			else
			{
				graphics.drawString(text, x + 1, y + 1);
			}

			graphics.setColor(color);
			graphics.drawString(text, x, y);
		}
	}

	public static void renderPolygon(Graphics2D graphics, Shape polygon, Color color, int outlineStroke, int fillAlpha)
	{
		if (polygon != null)
		{
			graphics.setColor(color);
			graphics.setStroke(new BasicStroke((float) outlineStroke));
			graphics.draw(polygon);
			graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), fillAlpha));
			graphics.fill(polygon);
		}
	}

	public static void renderWidgetPolygon(Graphics2D graphics, Widget widget, Color color, boolean outlineOnly, boolean flash)
	{
		if (widget != null)
		{
			Rectangle widgetBounds = widget.getBounds();
			if (widgetBounds != null)
			{
				if (flash)
				{
					graphics.setComposite(AlphaComposite.getInstance(3, getAlphaTime()));
					graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
				}

				if (outlineOnly)
				{
					graphics.setColor(color);
					graphics.setStroke(new BasicStroke(1.0F));
					graphics.draw(widgetBounds);
				}
				else
				{
					graphics.setColor(color);
					graphics.fill(widgetBounds);
				}

			}
		}
	}
}
