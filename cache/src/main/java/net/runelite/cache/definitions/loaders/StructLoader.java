/*
 * Copyright (c) 2018, Joshua Filby <joshua@filby.me>
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

import java.util.HashMap;
import net.runelite.cache.definitions.StructDefinition;
import net.runelite.cache.io.InputStream;

public class StructLoader
{
	public StructDefinition load(int id, byte[] b)
	{
		StructDefinition def = new StructDefinition(id);
		InputStream is = new InputStream(b);

		while (true)
		{
			int opcode = is.readUnsignedByte();
			if (opcode == 0)
			{
				break;
			}

			this.decodeValues(opcode, def, is);
		}

		return def;
	}

	private void decodeValues(int opcode, StructDefinition def, InputStream stream)
	{
		if (opcode == 249)
		{
			int length = stream.readUnsignedByte();

			def.params = new HashMap<>(length);

			for (int i = 0; i < length; i++)
			{
				boolean isString = stream.readUnsignedByte() == 1;
				int key = stream.read24BitInt();
				Object value;

				if (isString)
				{
					value = stream.readString();
				}
				else
				{
					value = stream.readInt();
				}

				def.params.put(key, value);
			}
		}
	}

}
