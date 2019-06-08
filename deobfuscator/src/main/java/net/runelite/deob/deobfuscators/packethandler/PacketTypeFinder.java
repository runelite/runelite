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
package net.runelite.deob.deobfuscators.packethandler;

import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.Map;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instruction.types.SetFieldInstruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketTypeFinder
{
	private static final Logger logger = LoggerFactory.getLogger(PacketTypeFinder.class);

	private final ClassGroup group;

	private final Map<Field, Integer> sets = new HashMap<>();
	private Field packetType;

	public PacketTypeFinder(ClassGroup group)
	{
		this.group = group;
	}

	public Field getPacketType()
	{
		return packetType;
	}

	public void find()
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method method : cf.getMethods())
			{
				run(method.getCode());
			}
		}

		packetType = sets.entrySet().stream()
			.max((entry1, entry2) -> Integer.compare(entry1.getValue(), entry2.getValue()))
			.get()
			.getKey();

		logger.info("Identified {} as packetType", packetType);
	}

	private void run(Code code)
	{
		if (code == null)
		{
			return;
		}

		Instructions instructions = code.getInstructions();

		for (int i = 0; i < instructions.getInstructions().size() - 1; ++i)
		{
			Instruction i1 = instructions.getInstructions().get(i),
				i2 = instructions.getInstructions().get(i + 1);

			if (i1 instanceof PushConstantInstruction && i2.getType() == InstructionType.PUTSTATIC)
			{
				PushConstantInstruction pci = (PushConstantInstruction) i1;
				SetFieldInstruction sfi = (SetFieldInstruction) i2;
				Field field = sfi.getMyField();

				if (Objects.equal(-1, pci.getConstant()) && field != null)
				{
					Integer count = sets.get(field);
					if (count == null)
					{
						sets.put(field, 1);
					}
					else
					{
						sets.put(field, count + 1);
					}
				}
			}
		}
	}
}
