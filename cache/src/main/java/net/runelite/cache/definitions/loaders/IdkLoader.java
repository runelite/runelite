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

import net.runelite.cache.definitions.IdkDefinition;
import net.runelite.cache.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IdkLoader
{
	private static final Logger logger = LoggerFactory.getLogger(IdkLoader.class);

	public IdkDefinition load(int id, byte[] b)
	{
		IdkDefinition def = new IdkDefinition(id);
		InputStream is = new InputStream(b);

		for (;;)
		{
			int opcode = is.readUnsignedByte();
			if (opcode == 0)
			{
				break;
			}

			if (opcode == 1)
			{
				def.type = is.readUnsignedByte();
			}
			else if (opcode == 2)
			{
				int length = is.readUnsignedByte();
				def.models = new int[length];

				for (int index = 0; index < length; ++index)
				{
					def.models[index] = is.readUnsignedShort();
				}
			}
			else if (opcode == 3)
			{
				def.disable = true;
			}
			else if (opcode == 40)
			{
				int length = is.readUnsignedByte();
				def.recol_s = new short[length];
				def.recol_d = new short[length];

				for (int index = 0; index < length; ++index)
				{
					def.recol_s[index] = is.readShort();
					def.recol_d[index] = is.readShort();
				}
			}
			else if (opcode == 41)
			{
				int length = is.readUnsignedByte();
				def.retex_s = new short[length];
				def.retex_d = new short[length];

				for (int index = 0; index < length; ++index)
				{
					def.retex_s[index] = is.readShort();
					def.retex_d[index] = is.readShort();
				}
			}
			else if (opcode >= 60 && opcode < 70)
			{
				def.heads[opcode - 60] = is.readUnsignedShort();
			}
		}

		return def;
	}
}
