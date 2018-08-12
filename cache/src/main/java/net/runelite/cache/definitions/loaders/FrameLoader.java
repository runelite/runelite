/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

import net.runelite.cache.definitions.FrameDefinition;
import net.runelite.cache.definitions.FramemapDefinition;
import net.runelite.cache.io.InputStream;

public class FrameLoader
{
	public FrameDefinition load(FramemapDefinition framemap, int id, byte[] b)
	{
		FrameDefinition def = new FrameDefinition();
		InputStream in = new InputStream(b);
		InputStream data = new InputStream(b);

		def.id = id;
		def.framemap = framemap;

		int framemapArchiveIndex = in.readUnsignedShort();
		int length = in.readUnsignedByte();

		data.skip(3 + length); // framemapArchiveIndex + length + data

		int[] indexFrameIds = new int[500];
		int[] scratchTranslatorX = new int[500];
		int[] scratchTranslatorY = new int[500];
		int[] scratchTranslatorZ = new int[500];

		int lastI = -1;
		int index = 0;
		for (int i = 0; i < length; ++i)
		{
			int var9 = in.readUnsignedByte();

			if (var9 <= 0)
			{
				continue;
			}

			if (def.framemap.types[i] != 0)
			{
				for (int var10 = i - 1; var10 > lastI; --var10)
				{
					if (def.framemap.types[var10] == 0)
					{
						indexFrameIds[index] = var10;
						scratchTranslatorX[index] = 0;
						scratchTranslatorY[index] = 0;
						scratchTranslatorZ[index] = 0;
						++index;
						break;
					}
				}
			}

			indexFrameIds[index] = i;
			short var11 = 0;
			if (def.framemap.types[i] == 3)
			{
				var11 = 128;
			}

			if ((var9 & 1) != 0)
			{
				scratchTranslatorX[index] = data.readShortSmart();
			}
			else
			{
				scratchTranslatorX[index] = var11;
			}

			if ((var9 & 2) != 0)
			{
				scratchTranslatorY[index] = data.readShortSmart();
			}
			else
			{
				scratchTranslatorY[index] = var11;
			}

			if ((var9 & 4) != 0)
			{
				scratchTranslatorZ[index] = data.readShortSmart();
			}
			else
			{
				scratchTranslatorZ[index] = var11;
			}

			lastI = i;
			++index;
			if (def.framemap.types[i] == 5)
			{
				def.showing = true;
			}
		}

		if (data.getOffset() != b.length)
		{
			throw new RuntimeException();
		}

		def.translatorCount = index;
		def.indexFrameIds = new int[index];
		def.translator_x = new int[index];
		def.translator_y = new int[index];
		def.translator_z = new int[index];

		for (int i = 0; i < index; ++i)
		{
			def.indexFrameIds[i] = indexFrameIds[i];
			def.translator_x[i] = scratchTranslatorX[i];
			def.translator_y[i] = scratchTranslatorY[i];
			def.translator_z[i] = scratchTranslatorZ[i];
		}

		return def;
	}
}
