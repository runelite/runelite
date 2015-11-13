package net.runelite.cache.renderable;

import java.awt.*;
import java.awt.image.*;
import net.runelite.cache.definitions.SpriteDefinition;

public class RGBSprite
{
	private int offsetY;
	private int spriteWidth;
	private int spriteHeight;
	private int offsetX;
	private int maxHeight;
	private int maxWidth;
	private int[] pixels;

	RGBSprite()
	{
	}

	public int getOffsetY()
	{
		return offsetY;
	}

	public int getSpriteWidth()
	{
		return spriteWidth;
	}

	public int getSpriteHeight()
	{
		return spriteHeight;
	}

	public int getOffsetX()
	{
		return offsetX;
	}

	public int getMaxHeight()
	{
		return maxHeight;
	}

	public int getMaxWidth()
	{
		return maxWidth;
	}

	public int[] getPixels()
	{
		return pixels;
	}

	public static RGBSprite fromSpriteDefinition(SpriteDefinition def)
	{
		RGBSprite sprite = new RGBSprite();

		sprite.maxWidth = def.getMaxWidth();
		sprite.maxHeight = def.getMaxHeight();
		sprite.offsetX = def.getOffsetX();
		sprite.offsetY = def.getOffsetY();
		sprite.spriteWidth = def.getWidth();
		sprite.spriteHeight = def.getHeight();

		int dimmension = sprite.spriteWidth * sprite.spriteHeight;
		byte[] pixels = def.getPixels();
		int[] palette = def.getLoader().getLoadedPalette();

		sprite.pixels = new int[dimmension];

		for (int pos = 0; pos < dimmension; ++pos)
		{
			sprite.pixels[pos] = palette[pixels[pos] & 255];
		}

		return sprite;
	}

	public BufferedImage getBufferedImage()
	{
		BufferedImage bi = new BufferedImage(spriteWidth, spriteHeight, BufferedImage.TYPE_INT_RGB);
		bi.setRGB(0, 0, spriteWidth, spriteHeight, pixels, 0, spriteWidth);
		Image img = makeColorTransparent(bi, new Color(0, 0, 0));
		BufferedImage trans = imageToBufferedImage(img);
		return trans;
	}

	private static Image makeColorTransparent(BufferedImage im, final Color color)
	{
		int markerRGB = color.getRGB() | 0xFF000000;

		RGBImageFilter filter = new RGBImageFilter()
		{
			@Override
			public final int filterRGB(int x, int y, int rgb)
			{
				if ((rgb | 0xFF000000) == markerRGB)
				{
					return 0x00FFFFFF & rgb;
				}
				else
				{
					return rgb;
				}
			}
		};
		
		ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
		return Toolkit.getDefaultToolkit().createImage(ip);
	}

	private static BufferedImage imageToBufferedImage(Image image)
	{
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
		return bufferedImage;
	}
}
