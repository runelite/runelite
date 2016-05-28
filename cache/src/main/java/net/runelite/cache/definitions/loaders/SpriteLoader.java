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
	private SpriteDefinition[] sprites;

	private int[] loadedPalette;
	private int loadedSpriteMaxWidth;
	private int loadedSpriteMaxHeight;

	public void load(InputStream stream)
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
