/*
 * Copyright (c) 2022, Joshua Filby <joshua@filby.me>
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

import lombok.extern.slf4j.Slf4j;
import net.runelite.cache.definitions.DBRowDefinition;
import net.runelite.cache.io.InputStream;
import net.runelite.cache.util.ScriptVarType;

@Slf4j
public class DBRowLoader
{
	public DBRowDefinition load(int id, byte[] b)
	{
		DBRowDefinition def = new DBRowDefinition(id);
		InputStream is = new InputStream(b);

		while (true)
		{
			int opcode = is.readUnsignedByte();
			if (opcode == 0)
			{
				break;
			}

			this.decode(opcode, def, is);
		}

		return def;
	}

	private void decode(int opcode, DBRowDefinition def, InputStream stream)
	{
		switch (opcode)
		{
			case 3:
				int numColumns = stream.readUnsignedByte();
				ScriptVarType[][] types = new ScriptVarType[numColumns][];
				Object[][] columnValues = new Object[numColumns][];

				for (int columnId = stream.readUnsignedByte(); columnId != 255; columnId = stream.readUnsignedByte())
				{
					ScriptVarType[] columnTypes = new ScriptVarType[stream.readUnsignedByte()];
					for (int i = 0; i < columnTypes.length; i++)
					{
						columnTypes[i] = ScriptVarType.forId(stream.readUnsignedShortSmart());
					}
					types[columnId] = columnTypes;
					columnValues[columnId] = DBTableLoader.decodeColumnFields(stream, columnTypes);
				}

				def.setColumnTypes(types);
				def.setColumnValues(columnValues);
				break;
			case 4:
				def.setTableId(stream.readVarInt2());
				break;
			default:
				log.warn("Unrecognized dbrow opcode {}", opcode);
				break;
		}
	}
}
