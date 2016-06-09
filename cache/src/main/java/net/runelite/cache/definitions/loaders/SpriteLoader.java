/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
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

	private SpriteDefinition[] sprites;

	private int[] loadedPalette;
	private int width;
	private int height;

	public void load(InputStream stream)
	{
		stream.setOffset(stream.getLength() - 2);
		int spriteCount = stream.readUnsignedShort();

		sprites = new SpriteDefinition[spriteCount];
		for (int i = 0; i < spriteCount; ++i)
		{
			sprites[i] = new SpriteDefinition(this);
		}

		// 2 for size
		// 5 for width, height, palette length
		// + 8 bytes per sprite for offset x/y, width, and height
		stream.setOffset(stream.getLength() - 7 - spriteCount * 8);

		width = stream.readUnsignedShort();
		height = stream.readUnsignedShort();
		int paletteLength = (stream.readUnsignedByte() & 255) + 1;

		for (int i = 0; i < spriteCount; ++i)
		{
			sprites[i].setOffsetX(stream.readUnsignedShort());
		}

		for (int i = 0; i < spriteCount; ++i)
		{
			sprites[i].setOffsetY(stream.readUnsignedShort());
		}

		for (int i = 0; i < spriteCount; ++i)
		{
			sprites[i].setWidth(stream.readUnsignedShort());
		}

		for (int i = 0; i < spriteCount; ++i)
		{
			sprites[i].setHeight(stream.readUnsignedShort());
		}

		// same as above + 3 bytes for each palette entry, except for the first one (which is transparent)
		stream.setOffset(stream.getLength() - 7 - spriteCount * 8 - (paletteLength - 1) * 3);
		loadedPalette = new int[paletteLength];

		for (int i = 1; i < paletteLength; ++i)
		{
			loadedPalette[i] = stream.read24BitInt();

			if (loadedPalette[i] == 0)
			{
				loadedPalette[i] = 1;
			}
		}

		stream.setOffset(0);

		for (int i = 0; i < spriteCount; ++i)
		{
			SpriteDefinition def = sprites[i];
			int width = def.getWidth();
			int height = def.getHeight();
			// XXX OFFSETS
			int dimension = width * height;
			byte[] pixelPaletteIndicies = new byte[dimension];
			byte[] pixelAlphas = new byte[dimension];

			int flags = stream.readUnsignedByte();

			if ((flags & FLAG_VERTICAL) == 0)
			{
				// read horizontally
				for (int j = 0; j < dimension; ++j)
				{
					pixelPaletteIndicies[j] = stream.readByte();
				}
			}
			else
			{
				// read vertically
				for (int j = 0; j < width; ++j)
				{
					for (int k = 0; k < height; ++k)
					{
						pixelPaletteIndicies[width * k + j] = stream.readByte();
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
						pixelAlphas[j] = stream.readByte();
					}
				}
				else
				{
					// read vertically
					for (int j = 0; j < width; ++j)
					{
						for (int k = 0; k < height; ++k)
						{
							pixelAlphas[width * k + j] = stream.readByte();
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

			def.setPixels(pixelPaletteIndicies);
			def.setAlphas(pixelAlphas);
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
