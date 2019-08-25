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
package net.runelite.injector;

import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.GetField;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.LMul;
import net.runelite.asm.attributes.code.instructions.Return;
import net.runelite.asm.signature.Signature;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class InjectGetter
{
	private static final Logger logger = LoggerFactory.getLogger(InjectGetter.class);

	private final Inject inject;

	private int injectedGetters;

	InjectGetter(Inject inject)
	{
		this.inject = inject;
	}

	void injectGetter(ClassFile clazz, java.lang.reflect.Method method, Field field, Number getter)
	{
		// clazz = class file we're injecting the method into.
		// method = api method (java reflect) that we're overriding
		// field = field we're getting. might not be in this class if static.
		// getter = encryption getter

		assert clazz.findMethod(method.getName()) == null;
		assert field.isStatic() || field.getClassFile() == clazz;

		Signature sig = new Signature.Builder()
			.setReturnType(Inject.classToType(method.getReturnType()))
			.build();
		Method getterMethod = new Method(clazz, method.getName(), sig);
		getterMethod.setAccessFlags(ACC_PUBLIC);

		// create code
		Code code = new Code(getterMethod);
		getterMethod.setCode(code);

		Instructions instructions = code.getInstructions();
		List<Instruction> ins = instructions.getInstructions();

		if (field.isStatic())
		{
			code.setMaxStack(1);

			ins.add(new GetStatic(instructions, field.getPoolField()));
		}
		else
		{
			code.setMaxStack(2);

			ins.add(new ALoad(instructions, 0));
			ins.add(new GetField(instructions, field.getPoolField()));
		}

		if (getter != null)
		{
			code.setMaxStack(2);

			assert getter instanceof Integer || getter instanceof Long;

			if (getter instanceof Integer)
			{
				ins.add(new LDC(instructions, (int) getter));
				ins.add(new IMul(instructions));
			}
			else
			{
				ins.add(new LDC(instructions, (long) getter));
				ins.add(new LMul(instructions));
			}
		}

		InstructionType returnType;
		if (field.getType().isPrimitive() && field.getType().getDimensions() == 0)
		{
			switch (field.getType().toString())
			{
				case "B":
				case "C":
				case "I":
				case "S":
				case "Z":
					returnType = InstructionType.IRETURN;
					break;
				case "D":
					returnType = InstructionType.DRETURN;
					break;
				case "F":
					returnType = InstructionType.FRETURN;
					break;
				case "J":
					returnType = InstructionType.LRETURN;
					break;
				default:
					throw new RuntimeException("Unknown type");
			}
		}
		else
		{
			returnType = InstructionType.ARETURN;
		}

		ins.add(new Return(instructions, returnType));

		clazz.addMethod(getterMethod);
		++injectedGetters;
	}

	int getInjectedGetters()
	{
		return injectedGetters;
	}
}
