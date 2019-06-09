package net.runelite.mixins;

import java.awt.Color;
import java.awt.image.BufferedImage;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSSprite;

@Mixin(RSSprite.class)
public abstract class RSSpriteMixin implements RSSprite
{
	@Inject
	@Override
	public BufferedImage toBufferedImage()
	{
		BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

		toBufferedImage(img);

		return img;
	}

	@Inject
	@Override
	public void toBufferedImage(BufferedImage img)
	{
		int width = getWidth();
		int height = getHeight();

		if (img.getWidth() != width || img.getHeight() != height)
		{
			throw new IllegalArgumentException("Image bounds do not match Sprite");
		}

		int[] pixels = getPixels();
		int[] transPixels = new int[pixels.length];

		for (int i = 0; i < pixels.length; i++)
		{
			if (pixels[i] != 0)
			{
				transPixels[i] = pixels[i] | 0xff000000;
			}
		}

		img.setRGB(0, 0, width, height, transPixels, 0, width);
	}

	@Inject
	@Override
	public BufferedImage toBufferedOutline(Color color)
	{
		BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

		toBufferedOutline(img, color.getRGB());

		return img;
	}

	@Inject
	@Override
	public void toBufferedOutline(BufferedImage img, int color)
	{
		int width = getWidth();
		int height = getHeight();

		if (img.getWidth() != width || img.getHeight() != height)
		{
			throw new IllegalArgumentException("Image bounds do not match Sprite");
		}

		int[] pixels = getPixels();
		int[] newPixels = new int[width * height];
		int pixelIndex = 0;

		for (int y = 0; y < height; ++y)
		{
			for (int x = 0; x < width; ++x)
			{
				int pixel = pixels[pixelIndex];
				if (pixel == 16777215 || pixel == 0)
				{
					// W
					if (x > 0 && pixels[pixelIndex - 1] != 0)
					{
						pixel = color;
					}
					// N
					else if (y > 0 && pixels[pixelIndex - width] != 0)
					{
						pixel = color;
					}
					// E
					else if (x < width - 1 && pixels[pixelIndex + 1] != 0)
					{
						pixel = color;
					}
					// S
					else if (y < height - 1 && pixels[pixelIndex + width] != 0)
					{
						pixel = color;
					}
					newPixels[pixelIndex] = pixel;
				}

				pixelIndex++;
			}
		}

		img.setRGB(0, 0, width, height, newPixels, 0, width);
	}
}
