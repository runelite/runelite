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

import net.runelite.cache.definitions.EnumDefinition;
import net.runelite.cache.io.InputStream;
import net.runelite.cache.util.ScriptVarType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnumLoader
{
	private static final Logger logger = LoggerFactory.getLogger(EnumLoader.class);

	public EnumDefinition load(int id, byte[] b)
	{
		if (b.length == 1 && b[0] == 0)
		{
			return null;
		}

		EnumDefinition def = new EnumDefinition();
		InputStream is = new InputStream(b);

		def.setId(id);

		for (;;)
		{
			int opcode = is.readUnsignedByte();
			if (opcode == 0)
			{
				break;
			}

			processOp(opcode, def, is);
		}

		return def;
	}

	private void processOp(int opcode, EnumDefinition def, InputStream is)
	{
		switch (opcode)
		{
			case 1:
				def.setKeyType(ScriptVarType.forCharKey((char) is.readUnsignedByte()));
				break;
			case 2:
				def.setValType(ScriptVarType.forCharKey((char) is.readUnsignedByte()));
				break;
			case 3:
				def.setDefaultString(is.readString());
				break;
			case 4:
				def.setDefaultInt(is.readInt());
				break;
			case 5:
			{
				int size = is.readUnsignedShort();
				int[] keys = new int[size];
				String[] stringVals = new String[size];
				for (int index = 0; index < size; ++index)
				{
					keys[index] = is.readInt();
					stringVals[index] = is.readString();
				}
				def.setSize(size);
				def.setKeys(keys);
				def.setStringVals(stringVals);
				break;
			}
			case 6:
			{
				int size = is.readUnsignedShort();
				int[] keys = new int[size];
				int[] intVals = new int[size];
				for (int index = 0; index < size; ++index)
				{
					keys[index] = is.readInt();
					intVals[index] = is.readInt();
				}
				def.setSize(size);
				def.setKeys(keys);
				def.setIntVals(intVals);
				break;
			}
			default:
				logger.warn("Unrecognized opcode {}", opcode);
				break;
		}
	}
}
