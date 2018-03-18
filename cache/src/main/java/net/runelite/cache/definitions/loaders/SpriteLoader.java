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

package net.runelite.cache.definitions.loaders;

import net.runelite.cache.definitions.SpriteDefinition;
import net.runelite.cache.io.InputStream;

public class SpriteLoader
{
	public static final int FLAG_VERTICAL = 0b01;
	public static final int FLAG_ALPHA    = 0b10;

	public SpriteDefinition[] load(int id, byte[] b)
	{
		InputStream is = new InputStream(b);

		is.setOffset(is.getLength() - 2);
		int spriteCount = is.readUnsignedShort();

		SpriteDefinition[] sprites = new SpriteDefinition[spriteCount];

		// 2 for size
		// 5 for width, height, palette length
		// + 8 bytes per sprite for offset x/y, width, and height
		is.setOffset(is.getLength() - 7 - spriteCount * 8);

		// max width and height
		int width = is.readUnsignedShort();
		int height = is.readUnsignedShort();
		int paletteLength = is.readUnsignedByte() + 1;

		for (int i = 0; i < spriteCount; ++i)
		{
			sprites[i] = new SpriteDefinition();
			sprites[i].setId(id);
			sprites[i].setFrame(i);
			sprites[i].setMaxWidth(width);
			sprites[i].setMaxHeight(height);
		}

		for (int i = 0; i < spriteCount; ++i)
		{
			sprites[i].setOffsetX(is.readUnsignedShort());
		}

		for (int i = 0; i < spriteCount; ++i)
		{
			sprites[i].setOffsetY(is.readUnsignedShort());
		}

		for (int i = 0; i < spriteCount; ++i)
		{
			sprites[i].setWidth(is.readUnsignedShort());
		}

		for (int i = 0; i < spriteCount; ++i)
		{
			sprites[i].setHeight(is.readUnsignedShort());
		}

		// same as above + 3 bytes for each palette entry, except for the first one (which is transparent)
		is.setOffset(is.getLength() - 7 - spriteCount * 8 - (paletteLength - 1) * 3);
		int[] palette = new int[paletteLength];

		for (int i = 1; i < paletteLength; ++i)
		{
			palette[i] = is.read24BitInt();

			if (palette[i] == 0)
			{
				palette[i] = 1;
			}
		}

		is.setOffset(0);

		for (int i = 0; i < spriteCount; ++i)
		{
			SpriteDefinition def = sprites[i];
			int spriteWidth = def.getWidth();
			int spriteHeight = def.getHeight();
			int dimension = spriteWidth * spriteHeight;
			byte[] pixelPaletteIndicies = new byte[dimension];
			byte[] pixelAlphas = new byte[dimension];
			def.pixelIdx = pixelPaletteIndicies;
			def.palette = palette;

			int flags = is.readUnsignedByte();

			if ((flags & FLAG_VERTICAL) == 0)
			{
				// read horizontally
				for (int j = 0; j < dimension; ++j)
				{
					pixelPaletteIndicies[j] = is.readByte();
				}
			}
			else
			{
				// read vertically
				for (int j = 0; j < spriteWidth; ++j)
				{
					for (int k = 0; k < spriteHeight; ++k)
					{
						pixelPaletteIndicies[spriteWidth * k + j] = is.readByte();
					}
				}
			}

			// read alphas
			if ((flags & FLAG_ALPHA) != 0)
			{
				if ((flags & FLAG_VERTICAL) == 0)
				{
					// read horizontally
					for (int j = 0; j < dimension; ++j)
					{
						pixelAlphas[j] = is.readByte();
					}
				}
				else
				{
					// read vertically
					for (int j = 0; j < spriteWidth; ++j)
					{
						for (int k = 0; k < spriteHeight; ++k)
						{
							pixelAlphas[spriteWidth * k + j] = is.readByte();
						}
					}
				}
			}
			else
			{
				// everything non-zero is opaque
				for (int j = 0; j < dimension; ++j)
				{
					int index = pixelPaletteIndicies[j];

					if (index != 0)
						pixelAlphas[j] = (byte) 0xFF;
				}
			}

			int[] pixels = new int[dimension];

			// build argb pixels from palette/alphas
			for (int j = 0; j < dimension; ++j)
			{
				int index = pixelPaletteIndicies[j] & 0xFF;

				pixels[j] = palette[index] | (pixelAlphas[j] << 24);
			}

			def.setPixels(pixels);
		}

		return sprites;
	}
}
