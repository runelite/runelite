package net.runelite.cache.definitions.loaders;

import net.runelite.cache.definitions.SpriteDefinition;
import net.runelite.cache.io.InputStream;

public class SpriteLoader
{
	private SpriteDefinition[] sprites;

	private int[] loadedPalette;
	private int loadedSpriteMaxWidth;
	private int loadedSpriteMaxHeight;

	public void decode(InputStream stream)
	{
		stream.setOffset(stream.getLength() - 2);
		int paletteChildCount = stream.readUnsignedShort();
		sprites = new SpriteDefinition[paletteChildCount];
		for (int i = 0; i < paletteChildCount; ++i)
		{
			sprites[i] = new SpriteDefinition(this);
		}
		stream.setOffset(stream.getLength() - 7 - paletteChildCount * 8);
		loadedSpriteMaxWidth = stream.readUnsignedShort();
		loadedSpriteMaxHeight = stream.readUnsignedShort();
		int var3 = (stream.readUnsignedByte() & 255) + 1;

		int spriteIndex;
		for (spriteIndex = 0; spriteIndex < paletteChildCount; ++spriteIndex)
		{
			sprites[spriteIndex].setOffsetX(stream.readUnsignedShort());
		}

		for (spriteIndex = 0; spriteIndex < paletteChildCount; ++spriteIndex)
		{
			sprites[spriteIndex].setOffsetY(stream.readUnsignedShort());
		}

		for (spriteIndex = 0; spriteIndex < paletteChildCount; ++spriteIndex)
		{
			sprites[spriteIndex].setWidth(stream.readUnsignedShort());
		}

		for (spriteIndex = 0; spriteIndex < paletteChildCount; ++spriteIndex)
		{
			sprites[spriteIndex].setHeight(stream.readUnsignedShort());
		}

		stream.setOffset(stream.getLength() - 7 - paletteChildCount * 8 - (var3 - 1) * 3);
		loadedPalette = new int[var3];

		for (spriteIndex = 1; spriteIndex < var3; ++spriteIndex)
		{
			loadedPalette[spriteIndex] = stream.read24BitInt();
			if (0 == loadedPalette[spriteIndex])
			{
				loadedPalette[spriteIndex] = 1;
			}
		}

		stream.setOffset(0);

		for (spriteIndex = 0; spriteIndex < paletteChildCount; ++spriteIndex)
		{
			SpriteDefinition def = sprites[spriteIndex];
			int width = def.getWidth();
			int height = def.getHeight();
			int dimmension = width * height;
			byte[] loadPixels = new byte[dimmension];
			int var4 = stream.readUnsignedByte();
			int var5;
			if (var4 == 0)
			{
				for (var5 = 0; var5 < dimmension; ++var5)
				{
					loadPixels[var5] = (byte) stream.readByte();
				}
			}
			else if (1 == var4)
			{
				for (var5 = 0; var5 < width; ++var5)
				{
					for (int var8 = 0; var8 < height; ++var8)
					{
						loadPixels[width * var8 + var5] = (byte) stream.readByte();
					}
				}
			}
			def.setPixels(loadPixels);
		}
	}

	public SpriteDefinition[] getSprites()
	{
		return sprites;
	}

	public int[] getLoadedPalette()
	{
		return loadedPalette;
	}
}
