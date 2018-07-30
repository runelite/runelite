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
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.GRAY;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.util.Arrays;
import javax.annotation.Nonnull;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ImageUtilTest
{
	private static final Color BLACK_HALF_TRANSPARENT = new Color(0, 0, 0, 128);
	private static final Color BLACK_TRANSPARENT = new Color(0, true);
	private static final int CORNER_SIZE = 2;
	private static final int CENTERED_SIZE = 3;

	private static final BufferedImage BLACK_PIXEL_TOP_LEFT;
	private static final BufferedImage BLACK_PIXEL_TOP_RIGHT;
	private static final BufferedImage BLACK_PIXEL_BOTTOM_LEFT;
	private static final BufferedImage BLACK_PIXEL_BOTTOM_RIGHT;

	static
	{
		BLACK_PIXEL_TOP_LEFT = new BufferedImage(CORNER_SIZE, CORNER_SIZE, BufferedImage.TYPE_INT_ARGB);
		BLACK_PIXEL_TOP_LEFT.setRGB(0, 0, BLACK.getRGB());

		BLACK_PIXEL_TOP_RIGHT = new BufferedImage(CORNER_SIZE, CORNER_SIZE, BufferedImage.TYPE_INT_ARGB);
		BLACK_PIXEL_TOP_RIGHT.setRGB(1, 0, BLACK.getRGB());

		BLACK_PIXEL_BOTTOM_LEFT = new BufferedImage(CORNER_SIZE, CORNER_SIZE, BufferedImage.TYPE_INT_ARGB);
		BLACK_PIXEL_BOTTOM_LEFT.setRGB(0, 1, BLACK.getRGB());

		BLACK_PIXEL_BOTTOM_RIGHT = new BufferedImage(CORNER_SIZE, CORNER_SIZE, BufferedImage.TYPE_INT_ARGB);
		BLACK_PIXEL_BOTTOM_RIGHT.setRGB(1, 1, BLACK.getRGB());
	}

	@Test
	public void grayscaleOffset()
	{
		assert(bufferedImagesEqual(oneByOne(BLACK), ImageUtil.grayscaleOffset(oneByOne(BLACK), -255)));
		assert(bufferedImagesEqual(oneByOne(new Color(50, 50, 50)), ImageUtil.grayscaleOffset(oneByOne(BLACK), 50)));
		assert(bufferedImagesEqual(oneByOne(GRAY), ImageUtil.grayscaleOffset(oneByOne(BLACK), 128)));
		assert(bufferedImagesEqual(oneByOne(BLACK), ImageUtil.grayscaleOffset(oneByOne(GRAY), -255)));
		assert(bufferedImagesEqual(oneByOne(WHITE), ImageUtil.grayscaleOffset(oneByOne(BLACK), 255)));
		assert(bufferedImagesEqual(oneByOne(new Color(200, 200, 200)), ImageUtil.grayscaleOffset(oneByOne(WHITE), -55)));
		assert(bufferedImagesEqual(oneByOne(WHITE), ImageUtil.grayscaleOffset(oneByOne(WHITE), 55)));
	}

	@Test
	public void resizeImage()
	{
		// TODO: test image contents after changing size

		final BufferedImage larger = ImageUtil.resizeImage(oneByOne(BLACK), 46, 46);
		final BufferedImage smaller = ImageUtil.resizeImage(centeredPixel(WHITE), 1, 1);
		final BufferedImage stretched = ImageUtil.resizeImage(solidColor(30, 30, RED), 12, 34);

		assertEquals(46, larger.getWidth());
		assertEquals(46, larger.getHeight());
		assertEquals(1, smaller.getWidth());
		assertEquals(1, smaller.getHeight());
		assertEquals(12, stretched.getWidth());
		assertEquals(34, stretched.getHeight());

		final BufferedImage[] assertSameAfterResize = new BufferedImage[] {
			oneByOne(WHITE),
			oneByOne(GRAY),
			oneByOne(BLACK),
			oneByOne(RED),
			oneByOne(GREEN),
			oneByOne(BLUE),
			oneByOne(BLACK_HALF_TRANSPARENT),
			oneByOne(BLACK_TRANSPARENT),
			centeredPixel(WHITE),
			centeredPixel(GRAY),
			centeredPixel(BLACK),
			BLACK_PIXEL_TOP_LEFT,
			BLACK_PIXEL_TOP_RIGHT,
			BLACK_PIXEL_BOTTOM_LEFT,
			BLACK_PIXEL_BOTTOM_RIGHT,
		};
		for (BufferedImage image : assertSameAfterResize)
		{
			assert(bufferedImagesEqual(image, ImageUtil.resizeImage(image, image.getWidth(), image.getHeight())));
		}
	}

	@Test
	public void rotateImage()
	{
		// TODO: Test more than 90° rotations

		// Evenly-sized images (2x2)
		assert(bufferedImagesEqual(BLACK_PIXEL_TOP_RIGHT, ImageUtil.rotateImage(BLACK_PIXEL_TOP_LEFT, Math.PI / 2)));
		assert(bufferedImagesEqual(BLACK_PIXEL_BOTTOM_RIGHT, ImageUtil.rotateImage(BLACK_PIXEL_TOP_LEFT, Math.PI)));
		assert(bufferedImagesEqual(BLACK_PIXEL_BOTTOM_LEFT, ImageUtil.rotateImage(BLACK_PIXEL_TOP_LEFT, Math.PI * 3 / 2)));
		assert(bufferedImagesEqual(BLACK_PIXEL_TOP_LEFT, ImageUtil.rotateImage(BLACK_PIXEL_TOP_LEFT, Math.PI * 2)));

		// Unevenly-sized images (2x1); when rotated 90° become (2x2) images
		final BufferedImage twoByOneLeft = new BufferedImage(2, 1, BufferedImage.TYPE_INT_ARGB);
		twoByOneLeft.setRGB(0, 0, BLACK.getRGB());
		final BufferedImage twoByTwoRight = new BufferedImage(2, 1, BufferedImage.TYPE_INT_ARGB);
		twoByTwoRight.setRGB(1, 0, BLACK.getRGB());
		final BufferedImage oneByTwoTop = new BufferedImage(2, 2, BufferedImage.TYPE_INT_ARGB);
		oneByTwoTop.setRGB(1, 0, new Color(0, 0, 0, 127).getRGB());
		final BufferedImage oneByTwoBottom = new BufferedImage(2, 2, BufferedImage.TYPE_INT_ARGB);
		oneByTwoBottom.setRGB(0, 0, new Color(0, 0, 0, 127).getRGB());
		oneByTwoBottom.setRGB(0, 1, BLACK.getRGB());

		assert(bufferedImagesEqual(oneByTwoTop, ImageUtil.rotateImage(twoByOneLeft, Math.PI / 2)));
		assert(bufferedImagesEqual(twoByTwoRight, ImageUtil.rotateImage(twoByOneLeft, Math.PI)));
		assert(bufferedImagesEqual(oneByTwoBottom, ImageUtil.rotateImage(twoByOneLeft, Math.PI * 3 / 2)));
		assert(bufferedImagesEqual(twoByOneLeft, ImageUtil.rotateImage(twoByOneLeft, Math.PI * 2)));
	}

	/**
	 * Compares whether two {@link BufferedImage}s are equal in data.
	 *
	 * @param expected The first {@link BufferedImage} to be compared.
	 * @param actual   The second {@link BufferedImage} to be compared.
	 * @return         A boolean indicating whether the given {@link BufferedImage}s are of the same image data.
	 */
	private boolean bufferedImagesEqual(final @Nonnull BufferedImage expected, final @Nonnull BufferedImage actual)
	{
		if (expected.getWidth() != actual.getWidth())
		{
			return false;
		}

		if (!expected.getColorModel().equals(actual.getColorModel()))
		{
			return false;
		}

		final DataBuffer aBuffer = expected.getRaster().getDataBuffer();
		final DataBuffer bBuffer = actual.getRaster().getDataBuffer();
		final DataBufferInt aBufferInt = (DataBufferInt) aBuffer;
		final DataBufferInt bBufferInt = (DataBufferInt) bBuffer;

		if (aBufferInt.getNumBanks() != bBufferInt.getNumBanks())
		{
			return false;
		}

		for (int i = 0; i < aBufferInt.getNumBanks(); i++)
		{
			final int[] aDataBank = aBufferInt.getData(i);
			final int[] bDataBank = bBufferInt.getData(i);
			if (!Arrays.equals(aDataBank, bDataBank))
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * Creates a {@link BufferedImage} of a 1-by-1px image of the given color.
	 *
	 * @param color The color to use for the image's single pixel.
	 * @return      A {@link BufferedImage} containing a single pixel of the given color.
	 */
	private BufferedImage oneByOne(final @Nonnull Color color)
	{
		return solidColor(1, 1, color);
	}

	/**
	 * Creates a {@link BufferedImage} of a single pixel of the given color centered in a 3-by-3px
	 * image.
	 *
	 * @param color The color to use for the centered pixel.
	 * @return      A {@link BufferedImage} with completely transparent pixels and one pixel of the
	 *              given color in the center.
	 */
	private BufferedImage centeredPixel(final @Nonnull Color color)
	{
		final BufferedImage out = new BufferedImage(CENTERED_SIZE, CENTERED_SIZE, BufferedImage.TYPE_INT_ARGB);
		out.setRGB(1, 1, color.getRGB());
		return out;
	}

	/**
	 * Creates a {@link BufferedImage} of a solid color of given width and height.
	 *
	 * @param width  The desired width of the color image.
	 * @param height The desired height of the color image.
	 * @param color  The desired color of the image.
	 * @return       A {@link BufferedImage} of given dimensions filled with the given color.
	 */
	private BufferedImage solidColor(final int width, final int height, final @Nonnull Color color)
	{
		final BufferedImage out = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				out.setRGB(x, y, color.getRGB());
			}
		}
		return out;
	}
}
