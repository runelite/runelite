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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.cache.definitions.DBTableIndex;
import net.runelite.cache.io.InputStream;
import net.runelite.cache.util.BaseVarType;

public class DBTableIndexLoader
{
	public DBTableIndex load(int tableId, int columnId, byte[] b)
	{
		DBTableIndex index = new DBTableIndex(tableId, columnId);
		InputStream is = new InputStream(b);
		decode(index, is);
		return index;
	}

	private void decode(DBTableIndex index, InputStream stream)
	{
		int tupleSize = stream.readVarInt2();
		BaseVarType[] tupleTypes = new BaseVarType[tupleSize];
		List<Map<Object, List<Integer>>> tupleIndexes = new ArrayList<>(tupleSize);

		for (int i = 0; i < tupleSize; i++)
		{
			tupleTypes[i] = BaseVarType.forId(stream.readUnsignedByte());

			int valueCount = stream.readVarInt2();
			Map<Object, List<Integer>> valueToRows = new HashMap<>(valueCount);

			while (valueCount-- > 0)
			{
				Object value = decodeValue(tupleTypes[i], stream);

				int rowCount = stream.readVarInt2();
				List<Integer> rowIds = new ArrayList<>(rowCount);

				while (rowCount-- > 0)
				{
					rowIds.add(stream.readVarInt2());
				}

				valueToRows.put(value, rowIds);
			}

			tupleIndexes.add(i, valueToRows);
		}

		index.setTupleTypes(tupleTypes);
		index.setTupleIndexes(tupleIndexes);
	}

	private static Object decodeValue(BaseVarType baseType, InputStream stream)
	{
		switch (baseType)
		{
			case INTEGER:
				return stream.readInt();
			case LONG:
				return stream.readLong();
			case STRING:
				return stream.readString();
		}
		return null;
	}
}
