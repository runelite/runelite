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
package net.runelite.deob.deobfuscators;

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.PutStatic;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.c2s.RWOpcodeFinder;
import net.runelite.deob.c2s.WritePacket;
import static net.runelite.deob.deobfuscators.transformers.OpcodesTransformer.RUNELITE_OPCODES;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketWrite implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(PacketWrite.class);

	@Override
	public void run(ClassGroup group)
	{
		List<WritePacket> writes = findWrites(group);
		int count = 0;

		ClassFile runeliteOpcodes = group.findClass(RUNELITE_OPCODES);
		assert runeliteOpcodes != null : "Opcodes class must exist";

		for (WritePacket wp : writes)
		{
			Instructions ins = wp.getMethod().getCode().getInstructions();

			Instruction param = wp.getPushConstant();
			assert param instanceof PushConstantInstruction;

			final String fieldName = "PACKET_CLIENT_" + wp.getOpcode();

			net.runelite.asm.pool.Field field = new net.runelite.asm.pool.Field(
				new net.runelite.asm.pool.Class(RUNELITE_OPCODES),
				fieldName,
				Type.INT
			);
			ins.replace(param, new GetStatic(ins, field));

			if (runeliteOpcodes.findField(fieldName) == null)
			{
				Field opField = new Field(runeliteOpcodes, fieldName, Type.INT);
				// ACC_FINAL causes javac to inline the fields, which prevents
				// the mapper from doing field mapping
				opField.setAccessFlags(ACC_PUBLIC | ACC_STATIC);
				// setting a non-final static field value
				// doesn't work with fernflower
				opField.setValue(wp.getOpcode());
				runeliteOpcodes.addField(opField);

				// add initialization
				Method clinit = runeliteOpcodes.findMethod("<clinit>");
				assert clinit != null;
				Instructions instructions = clinit.getCode().getInstructions();
				instructions.addInstruction(0, new LDC(instructions, wp.getOpcode()));
				instructions.addInstruction(1, new PutStatic(instructions, opField));
			}

			++count;
		}

		logger.info("Injected {} packet writes", count);
	}

	private List<WritePacket> findWrites(ClassGroup group)
	{
		RWOpcodeFinder rw = new RWOpcodeFinder(group);
		rw.find();

		List<WritePacket> writes = new ArrayList<>();

		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				Code code = m.getCode();

				if (code == null)
				{
					continue;
				}

				writes.addAll(findPacketWrite(rw, m, code));
			}
		}

		return writes;
	}

	private List<WritePacket> findPacketWrite(RWOpcodeFinder rw, Method m, Code code)
	{
		List<WritePacket> writes = new ArrayList<>();

		List<Instruction> instructions = code.getInstructions().getInstructions();
		for (int j = 0; j < instructions.size(); ++j)
		{
			Instruction i = instructions.get(j);

			if (i instanceof InvokeInstruction)
			{
				InvokeInstruction ii = (InvokeInstruction) i;
				if (ii.getMethods().contains(rw.getWriteOpcode()))
				{
					Instruction cv = instructions.get(j - 1);

					if (!(cv instanceof PushConstantInstruction))
					{
						continue; // maybe already run?
					}

					WritePacket wp = new WritePacket(
						m,
						i,
						cv,
						((Number) ((PushConstantInstruction) cv).getConstant()).intValue()
					);

					Instruction gs = instructions.get(j - 2);
					assert gs instanceof GetStatic;

					writes.add(wp);
				}
			}
		}

		return writes;
	}

	private ClassFile findClient(ClassGroup group)
	{
		// "client" in vainlla but "Client" in deob..
		ClassFile cf = group.findClass("client");
		return cf != null ? cf : group.findClass("Client");
	}
}
