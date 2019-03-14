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
package net.runelite.cache.definitions.savers;

import java.util.Map;
import java.util.Map.Entry;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.io.OutputStream;
import static net.runelite.cache.script.Opcodes.SCONST;
import static net.runelite.cache.script.Opcodes.POP_INT;
import static net.runelite.cache.script.Opcodes.POP_STRING;
import static net.runelite.cache.script.Opcodes.RETURN;

public class ScriptSaver
{
	public byte[] save(ScriptDefinition script)
	{
		int[] instructions = script.getInstructions();
		int[] intOperands = script.getIntOperands();
		String[] stringOperands = script.getStringOperands();
		Map<Integer, Integer>[] switches = script.getSwitches();

		OutputStream out = new OutputStream();
		out.writeByte(0); // null string
		for (int i = 0; i < instructions.length; ++i)
		{
			int opcode = instructions[i];
			out.writeShort(opcode);
			if (opcode == SCONST)
			{
				out.writeString(stringOperands[i]);
			}
			else if (opcode < 100 && opcode != RETURN && opcode != POP_INT && opcode != POP_STRING)
			{
				out.writeInt(intOperands[i]);
			}
			else
			{
				out.writeByte(intOperands[i]);
			}
		}
		out.writeInt(instructions.length);
		out.writeShort(script.getLocalIntCount());
		out.writeShort(script.getLocalStringCount());
		out.writeShort(script.getIntStackCount());
		out.writeShort(script.getStringStackCount());
		int switchStart = out.getOffset();
		if (switches == null)
		{
			out.writeByte(0);
		}
		else
		{
			out.writeByte(switches.length);
			for (Map<Integer, Integer> s : switches)
			{
				out.writeShort(s.size());
				for (Entry<Integer, Integer> e : s.entrySet())
				{
					out.writeInt(e.getKey());
					out.writeInt(e.getValue());
				}
			}
		}
		int switchLength = out.getOffset() - switchStart;
		out.writeShort(switchLength);
		return out.flip();
	}
}
