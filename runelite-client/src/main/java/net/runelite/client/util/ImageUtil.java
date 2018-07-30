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

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.util.Arrays;
import javax.swing.GrayFilter;

/**
 * Various Image/BufferedImage utilities.
 */
public class ImageUtil
{
	/**
	 * Creates a {@link BufferedImage} from an {@link Image}.
	 *
	 * @param image An Image to be converted to a BufferedImage.
	 * @return      A BufferedImage instance of the same given image.
	 */
	public static BufferedImage bufferedImageFromImage(final Image image)
	{
		if (image instanceof BufferedImage)
		{
			return (BufferedImage) image;
		}

		final BufferedImage out = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		final Graphics2D g2d = out.createGraphics();
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();
		return out;
	}

	/**
	 * Offsets an image in the grayscale (darkens/brightens) by a given offset.
	 *
	 * @param image  The image to be darkened or brightened.
	 * @param offset A signed 8-bit integer value to brighten or darken the image with.
	 *               Values above 0 will brighten, and values below 0 will darken.
	 * @return       The given image with its brightness adjusted by the given offset.
	 */
	public static BufferedImage grayscaleOffset(final BufferedImage image, final int offset)
	{
		final float offsetFloat = (float) offset;
		final int numComponents = image.getColorModel().getNumComponents();
		final float[] scales = new float[numComponents];
		final float[] offsets = new float[numComponents];

		Arrays.fill(scales, 1f);
		for (int i = 0; i < numComponents; i++)
		{
			offsets[i] = offsetFloat;
		}
		// Set alpha to not offset
		offsets[numComponents - 1] = 0f;

		return offset(image, scales, offsets);
	}

	/**
	 * Offsets an image in the grayscale (darkens/brightens) by a given percentage.
	 *
	 * @param image      The image to be darkened or brightened.
	 * @param percentage The ratio to darken or brighten the given image.
	 *                   Values above 1 will brighten, and values below 1 will darken.
	 * @return           The given image with its brightness scaled by the given percentage.
	 */
	public static BufferedImage grayscaleOffset(final BufferedImage image, final float percentage)
	{
		final int numComponents = image.getColorModel().getNumComponents();
		final float[] scales = new float[numComponents];
		final float[] offsets = new float[numComponents];

		Arrays.fill(offsets, 0f);
		for (int i = 0; i < numComponents; i++)
		{
			scales[i] = percentage;
		}
		// Set alpha to not scale
		scales[numComponents - 1] = 1f;

		return offset(image, scales, offsets);
	}

	/**
	 * Offsets an image's alpha component by a given offset.
	 *
	 * @param image  The image to be made more or less transparent.
	 * @param offset A signed 8-bit integer value to modify the image's alpha component with.
	 *               Values above 0 will increase transparency, and values below 0 will decrease
	 *               transparency.
	 * @return       The given image with its alpha component adjusted by the given offset.
	 */
	public static BufferedImage alphaOffset(final BufferedImage image, final int offset)
	{
		final float offsetFloat = (float) offset;
		final int numComponents = image.getColorModel().getNumComponents();
		final float[] scales = new float[numComponents];
		final float[] offsets = new float[numComponents];

		Arrays.fill(scales, 1f);
		Arrays.fill(offsets, 0f);
		offsets[numComponents - 1] = offsetFloat;
		return offset(image, scales, offsets);
	}

	/**
	 * Offsets an image's alpha component by a given percentage.
	 *
	 * @param image      The image to be made more or less transparent.
	 * @param percentage The ratio to modify the image's alpha component with.
	 *                   Values above 1 will increase transparency, and values below 1 will decrease
	 *                   transparency.
	 * @return           The given image with its alpha component scaled by the given percentage.
	 */
	public static BufferedImage alphaOffset(final BufferedImage image, final float percentage)
	{
		final int numComponents = image.getColorModel().getNumComponents();
		final float[] scales = new float[numComponents];
		final float[] offsets = new float[numComponents];

		Arrays.fill(scales, 1f);
		Arrays.fill(offsets, 0f);
		scales[numComponents - 1] = percentage;
		return offset(image, scales, offsets);
	}

	/**
	 * Creates a grayscale image from the given image.
	 *
	 * @param image The source image to be converted.
	 * @return      A copy of the given imnage, with colors converted to grayscale.
	 */
	public static BufferedImage grayscaleImage(final BufferedImage image)
	{
		final Image grayImage = GrayFilter.createDisabledImage(image);
		return ImageUtil.bufferedImageFromImage(grayImage);
	}

	/**
	 * Re-size a BufferedImage to the given dimensions.
	 *
	 * @param image the BufferedImage.
	 * @param newWidth The width to set the BufferedImage to.
	 * @param newHeight The height to set the BufferedImage to.
	 * @return The BufferedImage with the specified dimensions
	 */
	public static BufferedImage resizeImage(final BufferedImage image, final int newWidth, final int newHeight)
	{
		final Image resized = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		return ImageUtil.bufferedImageFromImage(resized);
	}

	/**
	 * Rotates an image around its center by a given number of radians.
	 *
	 * @param image The image to be rotated.
	 * @param theta The number of radians to rotate the image.
	 * @return      The given image, rotated by the given theta.
	 */
	public static BufferedImage rotateImage(final BufferedImage image, final double theta)
	{
		AffineTransform transform = new AffineTransform();
		transform.rotate(theta, image.getWidth() / 2.0, image.getHeight() / 2.0);
		AffineTransformOp transformOp = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
		return transformOp.filter(image, null);
	}

	/**
	 * Flips an image horizontally and/or vertically.
	 *
	 * @param image      The image to be flipped.
	 * @param horizontal Whether the image should be flipped horizontally.
	 * @param vertical   Whether the image should be flipped vertically.
	 * @return           The given image, flipped horizontally and/or vertically.
	 */
	public static BufferedImage flipImage(final BufferedImage image, final boolean horizontal, final boolean vertical)
	{
		int x = 0;
		int y = 0;
		int w = image.getWidth();
		int h = image.getHeight();

		final BufferedImage out = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		final Graphics2D g2d = out.createGraphics();

		if (horizontal)
		{
			x = w;
			w *= -1;
		}

		if (vertical)
		{
			y = h;
			h *= -1;
		}

		g2d.drawImage(image, x, y, w, h, null);
		g2d.dispose();

		return out;
	}

	/**
	 * Performs a rescale operation on the image's color components.
	 *
	 * @param image   The image to be adjusted.
	 * @param scales  An array of scale operations to be performed on the image's color components.
	 * @param offsets An array of offset operations to be performed on the image's color components.
	 * @return        The modified image after applying the given adjustments.
	 */
	private static BufferedImage offset(final BufferedImage image, final float[] scales, final float[] offsets)
	{
		return new RescaleOp(scales, offsets, null).filter(image, null);
	}
}
