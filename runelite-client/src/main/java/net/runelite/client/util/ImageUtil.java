/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.util.function.Predicate;

/**
 * Various Image/BufferedImage utilities.
 */
public class ImageUtil
{
	/**
	 * Offsets an image in the grayscale (darkens/brightens) by an offset
	 */
	public static BufferedImage grayscaleOffset(BufferedImage image, int offset)
	{
		int numComponents = image.getColorModel().getNumComponents();
		int index = numComponents - 1;

		LookupTable lookup = new LookupTable(0, numComponents)
		{
			@Override
			public int[] lookupPixel(int[] src, int[] dest)
			{
				if (dest[index] != 0)
				{
					dest[index] = dest[index] + offset;
					if (dest[index] < 0)
					{
						dest[index] = 0;
					}
					else if (dest[index] > 255)
					{
						dest[index] = 255;
					}
				}

				return dest;
			}
		};

		LookupOp op = new LookupOp(lookup, new RenderingHints(null));
		return op.filter(image, null);
	}

	/**
	 * Re-size a BufferedImage to the given dimensions.
	 *
	 * @param image the BufferedImage.
	 * @param newWidth The width to set the BufferedImage to.
	 * @param newHeight The height to set the BufferedImage to.
	 * @return The BufferedImage with the specified dimensions
	 */
	public static BufferedImage resizeImage(BufferedImage image, int newWidth, int newHeight)
	{
		final Image tmp = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		final BufferedImage dimg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

		final Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return dimg;
	}

	/**
	 * Re-size a BufferedImage's canvas to the given dimensions.
	 *
	 * @param image     The image whose canvas should be re-sized.
	 * @param newWidth  The width to set the BufferedImage to.
	 * @param newHeight The height to set the BufferedImage to.
	 * @return          The BufferedImage centered within canvas of given dimensions.
	 */
	public static BufferedImage resizeCanvas(final BufferedImage image, final int newWidth, final int newHeight)
	{
		final BufferedImage dimg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		final int centeredX = newWidth / 2 - image.getWidth() / 2;
		final int centeredY = newHeight / 2 - image.getHeight() / 2;

		final Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(image, centeredX, centeredY, null);
		g2d.dispose();
		return dimg;
	}

	/**
	 * Outlines non-transparent pixels of a BufferedImage with the given color.
	 *
	 * @param image The image to be outlined.
	 * @param color The color to use for the outline.
	 * @return      The BufferedImage with its edges outlined with the given color.
	 */
	public static BufferedImage outlineImage(final BufferedImage image, final Color color)
	{
		return outlineImage(image, color, ImageUtil::isNotFullyTransparent, false);
	}

	/**
	 * Outlines pixels of a BufferedImage with the given color, using a given predicate to colorize
	 * the given image for outlining.
	 *
	 * @param image         The image to be outlined.
	 * @param color         The color to use for the outline.
	 * @param fillCondition The predicate to be consumed by {@link #getFilledImage(BufferedImage, Color, Predicate) getFilledImage(BufferedImage, Color, Predicate)}
	 * @return              The BufferedImage with its edges outlined with the given color.
	 */
	public static BufferedImage outlineImage(final BufferedImage image, final Color color, final Predicate<Color> fillCondition)
	{
		return outlineImage(image, color, fillCondition, false);
	}

	/**
	 * Outlines non-transparent pixels of a BufferedImage with the given color. Optionally outlines
	 * corners in addition to edges.
	 *
	 * @param image          The image to be outlined.
	 * @param color          The color to use for the outline.
	 * @param outlineCorners Whether to draw an outline around corners, or only around edges.
	 * @return               The BufferedImage with its edges--and optionally, corners--outlined
	 *                       with the given color.
	 */
	public static BufferedImage outlineImage(final BufferedImage image, final Color color, final Boolean outlineCorners)
	{
		return outlineImage(image, color, ImageUtil::isNotFullyTransparent, outlineCorners);
	}

	/**
	 * Outlines pixels of a BufferedImage with the given color, using a given predicate to colorize
	 * the given image for outlining. Optionally outlines corners in addition to edges.
	 *
	 * @param image          The image to be outlined.
	 * @param color          The color to use for the outline.
	 * @param fillCondition  The predicate to be consumed by {@link #getFilledImage(BufferedImage, Color, Predicate) getFilledImage(BufferedImage, Color, Predicate)}
	 * @param outlineCorners Whether to draw an outline around corners, or only around edges.
	 * @return               The BufferedImage with its edges--and optionally, corners--outlined
	 * 	                     with the given color.
	 */
	public static BufferedImage outlineImage(final BufferedImage image, final Color color, final Predicate<Color> fillCondition, final Boolean outlineCorners)
	{
		final BufferedImage filledImage = getFilledImage(image, color, fillCondition);
		final BufferedImage outlinedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

		final Graphics2D g2d = outlinedImage.createGraphics();
		for (int x = -1; x <= 1; x++)
		{
			for (int y = -1; y <= 1; y++)
			{
				if ((x == 0 && y == 0)
					|| (!outlineCorners && Math.abs(x) + Math.abs(y) != 1))
				{
					continue;
				}

				g2d.drawImage(filledImage, x, y, null);
			}
		}
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();

		return outlinedImage;
	}

	/**
	 * Fills all non-transparent pixels of the given image with the given color.
	 *
	 * @param image The image which should have its non-transparent pixels filled.
	 * @param color The color with which to fill pixels.
	 * @return      The given image with all non-transparent pixels set to the given color.
	 */
	public static BufferedImage getFilledImage(final BufferedImage image, final Color color)
	{
		return getFilledImage(image, color, ImageUtil::isNotFullyTransparent);
	}

	/**
	 * 	Fills pixels of the given image with the given color based on a given fill condition
	 * 	predicate.
	 *
	 * @param image         The image which should have its non-transparent pixels filled.
	 * @param color         The color with which to fill pixels.
	 * @param fillCondition The condition on which to fill pixels with the given color.
	 * @return              The given image with all pixels fulfilling the fill condition predicate
	 *                      set to the given color.
	 */
	public static BufferedImage getFilledImage(final BufferedImage image, final Color color, final Predicate<Color> fillCondition)
	{
		final BufferedImage filledImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		for (int x = 0; x < filledImage.getWidth(); x++)
		{
			for (int y = 0; y < filledImage.getHeight(); y++)
			{
				final Color pixelColor = new Color(image.getRGB(x, y));
				if (!fillCondition.test(pixelColor))
				{
					continue;
				}

				filledImage.setRGB(x, y, color.getRGB());
			}
		}
		return filledImage;
	}

	private static boolean isFullyTransparent(final Color color)
	{
		return color.getAlpha() == 0;
	}

	private static boolean isNotFullyTransparent(final Color color)
	{
		return !isFullyTransparent(color);
	}
}
