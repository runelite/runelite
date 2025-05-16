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
package net.runelite.cache.script.disassembler;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.script.Instruction;
import net.runelite.cache.script.Instructions;
import net.runelite.cache.script.Opcodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Disassembler
{
	private static final Logger logger = LoggerFactory.getLogger(Disassembler.class);
	private static final Escaper ESCAPER = Escapers.builder()
		.addEscape('"', "\\\"")
		.addEscape('\\', "\\\\")
		.build();

	private final Instructions instructions = new Instructions();
	private final Map<Object, String> symbols;

	public Disassembler()
	{
		instructions.init();
		this.symbols = Collections.emptyMap();
	}

	public Disassembler(Map<String, Object> symbols)
	{
		instructions.init();
		this.symbols = new HashMap<>();

		for (Entry<String, Object> e : symbols.entrySet())
		{
			this.symbols.put(e.getValue(), e.getKey());
		}
	}

	private boolean isJump(int opcode)
	{
		switch (opcode)
		{
			case Opcodes.JUMP:
			case Opcodes.IF_ICMPEQ:
			case Opcodes.IF_ICMPGE:
			case Opcodes.IF_ICMPGT:
			case Opcodes.IF_ICMPLE:
			case Opcodes.IF_ICMPLT:
			case Opcodes.IF_ICMPNE:
				return true;
			default:
				return false;
		}
	}

	private boolean[] needLabel(ScriptDefinition script)
	{
		int[] instructions = script.getInstructions();
		int[] iops = script.getIntOperands();
		Map<Integer, Integer>[] switches = script.getSwitches();

		boolean[] jumped = new boolean[instructions.length];

		for (int i = 0; i < instructions.length; ++i)
		{
			int opcode = instructions[i];
			int iop = iops[i];

			if (opcode == Opcodes.SWITCH)
			{
				Map<Integer, Integer> switchMap = switches[iop];

				for (Entry<Integer, Integer> entry : switchMap.entrySet())
				{
					int offset = entry.getValue();

					int to = i + offset + 1;
					assert to >= 0 && to < instructions.length;
					jumped[to] = true;
				}
			}

			if (!isJump(opcode))
			{
				continue;
			}

			// + 1 because the jumps go to the instructions prior to the
			// one you really want, because the pc is incremented on the
			// next loop
			int to = i + iop + 1;
			assert to >= 0 && to < instructions.length;

			jumped[to] = true;
		}

		return jumped;
	}

	public String disassemble(ScriptDefinition script) throws IOException
	{
		int[] instructions = script.getInstructions();
		int[] iops = script.getIntOperands();
		String[] sops = script.getStringOperands();
		Map<Integer, Integer>[] switches = script.getSwitches();

		assert iops.length == instructions.length;
		assert sops.length == instructions.length;

		boolean[] jumps = needLabel(script);

		StringBuilder writer = new StringBuilder();
		writerHeader(writer, script);

		for (int i = 0; i < instructions.length; ++i)
		{
			int opcode = instructions[i];
			int iop = iops[i];
			String sop = sops[i];

			Instruction ins = this.instructions.find(opcode);
			if (ins == null)
			{
				logger.debug("Unknown instruction {} in script {}", opcode, script.getId());
			}

			if (jumps[i])
			{
				// something jumps here
				writer.append("LABEL").append(i).append(":\n");
			}

			String name;
			if (ins != null && ins.getName() != null)
			{
				name = ins.getName();
			}
			else
			{
				name = String.format("%03d", opcode);
			}

			writer.append(String.format("   %-22s", name));

			if (shouldWriteIntOperand(opcode, iop))
			{
				if (isJump(opcode))
				{
					writer.append(" LABEL").append(i + iop + 1);
				}
				else if (symbols.containsKey(iop))
				{
					writer.append(" :").append(symbols.get(iop));
				}
				else
				{
					writer.append(" ").append(iop);
				}
			}

			if (sop != null)
			{
				writer.append(" \"").append(ESCAPER.escape(sop)).append("\"");
			}

			if (opcode == Opcodes.SWITCH)
			{
				Map<Integer, Integer> switchMap = switches[iop];

				for (Entry<Integer, Integer> entry : switchMap.entrySet())
				{
					int value = entry.getKey();
					int jump = entry.getValue();

					writer.append("\n");
					writer.append("      ").append(value).append(": LABEL").append(i + jump + 1);
				}
			}

			writer.append("\n");
		}

		return writer.toString();
	}

	private boolean shouldWriteIntOperand(int opcode, int operand)
	{
		if (opcode == Opcodes.SWITCH)
		{
			// table follows instruction
			return false;
		}

		if (operand != 0)
		{
			// always write non-zero operand
			return true;
		}

		switch (opcode)
		{
			case Opcodes.ICONST:
			case Opcodes.ILOAD:
			case Opcodes.SLOAD:
			case Opcodes.ISTORE:
			case Opcodes.SSTORE:
				return true;
		}

		// int operand is not used, don't write it
		return false;
	}

	private void writerHeader(StringBuilder writer, ScriptDefinition script)
	{
		int id = script.getId();
		int intStackCount = script.getIntArgCount();
		int stringStackCount = script.getObjArgCount();

		writer.append(".id                       ").append(id).append('\n');
		writer.append(".int_arg_count            ").append(intStackCount).append('\n');
		writer.append(".obj_arg_count            ").append(stringStackCount).append('\n');
	}
}
