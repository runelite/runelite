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

import net.runelite.cache.definitions.FramemapDefinition;
import net.runelite.cache.io.InputStream;

public class FramemapLoader
{
	public FramemapDefinition load(int id, byte[] b)
	{
		FramemapDefinition def = new FramemapDefinition();
		InputStream in = new InputStream(b);

		def.id = id;

		def.length = in.readUnsignedByte();
		def.types = new int[def.length];
		def.frameMaps = new int[def.length][];

		for (int i = 0; i < def.length; ++i)
		{
			def.types[i] = in.readUnsignedByte();
		}

		for (int i = 0; i < def.length; ++i)
		{
			def.frameMaps[i] = new int[in.readUnsignedByte()];
		}

		for (int i = 0; i < def.length; ++i)
		{
			for (int j = 0; j < def.frameMaps[i].length; ++j)
			{
				def.frameMaps[i][j] = in.readUnsignedByte();
			}
		}

		return def;
	}
}
