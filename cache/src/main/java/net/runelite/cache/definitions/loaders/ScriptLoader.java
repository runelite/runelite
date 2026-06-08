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

import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.io.InputStream;
import static net.runelite.cache.script.Opcodes.LCONST;
import static net.runelite.cache.script.Opcodes.POP_INT;
import static net.runelite.cache.script.Opcodes.POP_OBJECT;
import static net.runelite.cache.script.Opcodes.PUSH_NULL;
import static net.runelite.cache.script.Opcodes.RETURN;
import static net.runelite.cache.script.Opcodes.SCONST;

@Accessors(chain = true)
@Data
public class ScriptLoader
{
	private boolean rev237 = true;

	public ScriptLoader configureForRevision(int rev)
	{
		this.rev237 = rev > 1773753883;
		return this;
	}

	public ScriptDefinition load(int id, byte[] b)
	{
		ScriptDefinition def = new ScriptDefinition();
		def.setId(id);
		InputStream in = new InputStream(b);

		in.setOffset(in.getLength() - 2);
		int switchLength = in.readUnsignedShort();

		// 2 for switchLength + the switch data + 12 or 16 for the param/vars/stack data
		int endIdx = in.getLength() - 2 - switchLength - (rev237 ? 16 : 12);
		in.setOffset(endIdx);
		int numOpcodes = in.readInt();
		int localIntCount = in.readUnsignedShort();
		int localObjCount = in.readUnsignedShort();
		int localLongCount = 0;
		if (rev237)
		{
			localLongCount = in.readUnsignedShort();
		}
		int intArgCount = in.readUnsignedShort();
		int objArgCount = in.readUnsignedShort();
		int longArgCount = 0;
		if (rev237)
		{
			longArgCount = in.readUnsignedShort();
		}

		int numSwitches = in.readUnsignedByte();
		if (numSwitches > 0)
		{
			Map<Integer, Integer>[] switches = new Map[numSwitches];
			def.setSwitches(switches);

			for (int i = 0; i < numSwitches; ++i)
			{
				switches[i] = new LinkedHashMap<>();

				int count = in.readUnsignedShort();
				while (count-- > 0)
				{
					int key = in.readInt(); // int from stack is compared to this
					int pcOffset = in.readInt(); // pc jumps by this

					switches[i].put(key, pcOffset);
				}
			}
		}

		def.setLocalIntCount(localIntCount);
		def.setLocalLongCount(localLongCount);
		def.setLocalObjCount(localObjCount);
		def.setIntArgCount(intArgCount);
		def.setLongArgCount(longArgCount);
		def.setObjArgCount(objArgCount);

		in.setOffset(0);
		in.readStringOrNull();

		int[] instructions = new int[numOpcodes];
		int[] intOperands = new int[numOpcodes];
		long[] longOperands = new long[numOpcodes];
		String[] stringOperands = new String[numOpcodes];

		def.setInstructions(instructions);
		def.setIntOperands(intOperands);
		def.setLongOperands(longOperands);
		def.setStringOperands(stringOperands);

		for (int i = 0; in.getOffset() < endIdx; ++i)
		{
			int opcode = in.readUnsignedShort();
			instructions[i] = opcode;
			switch (opcode)
			{
				case SCONST:
					stringOperands[i] = in.readString();
					break;
				case RETURN:
				case POP_INT:
				case POP_OBJECT:
				case PUSH_NULL:
					intOperands[i] = in.readUnsignedByte();
					break;
				case LCONST:
					longOperands[i] = in.readLong();
					break;
				default:
					if (opcode < 100)
					{
						intOperands[i] = in.readInt();
					}
					else
					{
						intOperands[i] = in.readUnsignedByte();
					}
					break;
			}
		}

		return def;
	}
}
