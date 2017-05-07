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

import java.util.HashMap;
import java.util.Map;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.io.InputStream;

public class ScriptLoader
{
	public ScriptDefinition load(int id, byte[] b)
	{
		ScriptDefinition def = new ScriptDefinition();
		InputStream in = new InputStream(b);

		in.setOffset(in.getLength() - 2);
		int scriptEndOffset = in.readUnsignedShort();

		// 2 for scriptEndOffset + the k/v data + 12 for the param/vars/stack data
		int endIdx = in.getLength() - 2 - scriptEndOffset - 12;
		in.setOffset(endIdx);
		int paramCount = in.readInt();
		int localIntCount = in.readUnsignedShort();
		int localStringCount = in.readUnsignedShort();
		int intStackCount = in.readUnsignedShort();
		int stringStackCount = in.readUnsignedShort();

		int attributeCount = in.readUnsignedByte();
		if (attributeCount > 0)
		{
			Map<Integer, Integer>[] attributes = new Map[attributeCount];
			def.setAttributes(attributes);

			for (int i = 0; i < attributeCount; ++i)
			{
				attributes[i] = new HashMap<>();

				int count = in.readUnsignedShort();
				while (count-- > 0)
				{
					int key = in.readInt();
					int value = in.readInt();

					attributes[i].put(key, value);
				}
			}
		}

		def.setLocalIntCount(localIntCount);
		def.setLocalStringCount(localStringCount);
		def.setIntStackCount(intStackCount);
		def.setStringStackCount(stringStackCount);

		in.setOffset(0);
		in.readStringOrNull();

		int[] instructions = new int[paramCount];
		int[] intOperands = new int[paramCount];
		String[] stringOperands = new String[paramCount];

		def.setInstructions(instructions);
		def.setIntOperands(intOperands);
		def.setStringOperands(stringOperands);

		int var3;
		for (int var6 = 0; in.getOffset() < endIdx; instructions[var6++] = var3)
		{
			var3 = in.readUnsignedShort();
			if (var3 == 3)
			{
				stringOperands[var6] = in.readString();
			}
			else if (var3 < 100 && 21 != var3 && 38 != var3 && 39 != var3)
			{
				intOperands[var6] = in.readInt();
			}
			else
			{
				intOperands[var6] = in.readUnsignedByte();
			}
		}

		return def;
	}
}
