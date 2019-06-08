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

import net.runelite.cache.definitions.TextureDefinition;
import net.runelite.cache.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextureLoader
{
	private static final Logger logger = LoggerFactory.getLogger(TextureLoader.class);

	public TextureDefinition load(int id, byte[] b)
	{
		TextureDefinition def = new TextureDefinition();
		InputStream is = new InputStream(b);

		def.field1777 = is.readUnsignedShort();
		def.field1778 = is.readByte() != 0;
		def.setId(id);

		int count = is.readUnsignedByte();
		int[] files = new int[count];

		for (int i = 0; i < count; ++i)
			files[i] = is.readUnsignedShort();

		def.setFileIds(files);

		if (count > 1)
		{
			def.field1780 = new int[count - 1];

			for (int var3 = 0; var3 < count - 1; ++var3)
			{
				def.field1780[var3] = is.readUnsignedByte();
			}
		}

		if (count > 1)
		{
			def.field1781 = new int[count - 1];

			for (int var3 = 0; var3 < count - 1; ++var3)
			{
				def.field1781[var3] = is.readUnsignedByte();
			}
		}

		def.field1786 = new int[count];

		for (int var3 = 0; var3 < count; ++var3)
		{
			def.field1786[var3] = is.readInt();
		}

		def.field1783 = is.readUnsignedByte();
		def.field1782 = is.readUnsignedByte();

		return def;
	}
}
