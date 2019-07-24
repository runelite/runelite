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
import java.util.Collections;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.InvokeSpecial;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.PutStatic;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnumDeobfuscator implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(EnumDeobfuscator.class);

	private static final net.runelite.asm.pool.Method ENUM_INIT = new net.runelite.asm.pool.Method(
		new net.runelite.asm.pool.Class("java/lang/Enum"),
		"<init>",
		new Signature("(Ljava/lang/String;I)V")
	);

	@Override
	public void run(ClassGroup group)
	{
		for (ClassFile cf : group.getClasses())
		{
			if (!isEnum(cf) || cf.isEnum())
			{
				continue;
			}

			logger.info("Converting {} to an enum", cf.getName());
			makeEnum(cf);
		}
	}

	private boolean isEnum(ClassFile cf)
	{
		if (cf.getInterfaces().getMyInterfaces().size() != 1
			|| cf.getInterfaces().getInterfaces().size() != 1)
		{
			return false;
		}

		if (!interfaceIsEnum(cf.getInterfaces().getMyInterfaces().get(0)))
		{
			return false;
		}

		// number of non static methods should be 1
		long count = cf.getMethods()
			.stream()
			.filter(m -> !m.isStatic())
			.filter(m -> !m.getName().startsWith("<"))
			.count();
		if (count != 1)
		{
			return false;
		}

		return true;
	}

	private boolean interfaceIsEnum(ClassFile cf)
	{
		assert cf.isInterface();

		if (cf.getMethods().size() != 1)
		{
			return false;
		}

		Method method = cf.getMethods().get(0);
		return method.getDescriptor().toString().equals("()I"); // ordinal
	}

	private void makeEnum(ClassFile cf)
	{
		cf.setEnum(); // make class an enum

		// enums super class is java/lang/Enum
		assert cf.getParentClass().getName().equals("java/lang/Object");
		cf.setSuperName("java/lang/Enum");

		// all static fields of the type of the class become enum members
		for (Field field : cf.getFields())
		{
			if (field.isStatic() && field.getType().equals(new Type("L" + cf.getName() + ";")))
			{
				field.setEnum();
			}
		}

		for (Method method : cf.getMethods())
		{
			if (!method.getName().equals("<init>"))
			{
				continue;
			}

			// Add string as first argument, which is the field name,
			// and ordinal as second argument
			Signature signature = new Signature.Builder()
				.setReturnType(method.getDescriptor().getReturnValue())
				.addArgument(Type.STRING)
				.addArgument(Type.INT)
				.addArguments(method.getDescriptor().getArguments())
				.build();

			method.setDescriptor(signature);

			// Remove instructions up to invokespecial
			Instructions ins = method.getCode().getInstructions();
			Instruction i;
			do
			{
				i = ins.getInstructions().get(0);
				ins.remove(i);
			}
			while (i.getType() != InstructionType.INVOKESPECIAL);

			ins.addInstruction(0, new ALoad(ins, 0)); // load this
			ins.addInstruction(1, new ALoad(ins, 1)); // load constant name
			ins.addInstruction(2, new ILoad(ins, 2)); // ordinal
			ins.addInstruction(3, new InvokeSpecial(ins, ENUM_INIT)); // invoke enum constructor

			// Shift all indexes after this up +2 because of the new String and int argument
			for (int j = 4; j < ins.getInstructions().size(); ++j)
			{
				i = ins.getInstructions().get(j);

				if (i instanceof LVTInstruction)
				{
					LVTInstruction lvt = ((LVTInstruction) i);
					int idx = lvt.getVariableIndex();
					if (idx != 0)
					{
						lvt.setVariableIndex(idx + 2);
					}
				}
			}
		}

		// Order of fields being set in clinit, which is the order
		// the enum fields are actually in
		List<Field> order = new ArrayList<>();

		for (Method method : cf.getMethods())
		{
			if (!method.getName().equals("<clinit>"))
			{
				continue;
			}

			Instructions ins = method.getCode().getInstructions();

			int count = 0;
			// sometimes there is new new invokespecial invokespecial putfield
			// for eg enum member field30(1, 2, String.class, new class5());
			boolean seenDup = false;
			for (int j = 0; j < ins.getInstructions().size(); ++j)
			{
				Instruction i = ins.getInstructions().get(j);

				if (i.getType() == InstructionType.DUP && !seenDup)
				{
					// XXX this should actually be the field name, but it seems to have no effect on fernflower
					ins.addInstruction(j + 1, new LDC(ins, "runelite"));
					ins.addInstruction(j + 2, new LDC(ins, count++));
					seenDup = true;
				}
				else if (i.getType() == InstructionType.INVOKESPECIAL)
				{
					Instruction next = ins.getInstructions().get(j + 1);

					// check if this is the invokespecial on the enum, putstatic comes next
					if (next.getType() == InstructionType.PUTSTATIC)
					{
						InvokeSpecial is = (InvokeSpecial) i;
						PutStatic ps = (PutStatic) next;

						net.runelite.asm.pool.Method pmethod = new net.runelite.asm.pool.Method(
							is.getMethod().getClazz(),
							is.getMethod().getName(),
							new Signature.Builder()
								.setReturnType(is.getMethod().getType().getReturnValue())
								.addArgument(Type.STRING)
								.addArgument(Type.INT)
								.addArguments(is.getMethod().getType().getArguments())
								.build()
						);

						is.setMethod(pmethod);

						Field field = ps.getMyField();
						assert field != null;
						order.add(field);

						seenDup = false;
					}
				}
			}
		}

		// Enum fields must be first. Also they are in order in clinit.
		// Sort fields
		Collections.sort(cf.getFields(), (f1, f2) ->
		{
			int idx1 = order.indexOf(f1);
			int idx2 = order.indexOf(f2);

			if (idx1 == -1)
			{
				idx1 = Integer.MAX_VALUE;
			}
			if (idx2 == -1)
			{
				idx2 = Integer.MAX_VALUE;
			}

			return Integer.compare(idx1, idx2);
		});

	}
}
