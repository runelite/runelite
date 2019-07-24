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
package net.runelite.injector;

import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.CheckCast;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.LMul;
import net.runelite.asm.attributes.code.instructions.PutField;
import net.runelite.asm.attributes.code.instructions.PutStatic;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.asm.signature.Signature;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class InjectSetter
{
	private static final Logger logger = LoggerFactory.getLogger(InjectSetter.class);

	private final Inject inject;

	private int injectedSetters;

	InjectSetter(Inject inject)
	{
		this.inject = inject;
	}

	/**
	 * inject a setter into the vanilla classgroup
	 *
	 * @param targetClass    Class where to inject the setter (field's class,
	 *                       or client)
	 * @param targetApiClass API targetClass implements, which may have the
	 *                       setter declared
	 * @param field          Field of vanilla that will be set
	 * @param exportedName   exported name of field
	 */
	void injectSetter(ClassFile targetClass, Class<?> targetApiClass, Field field, String exportedName, Number setter)
	{
		java.lang.reflect.Method method = inject.findImportMethodOnApi(targetApiClass, exportedName, true);
		if (method == null)
		{
			logger.warn("Setter injection for field {} but an API method was not found on {}", exportedName, targetApiClass);
			return;
		}

		if (method.getParameterCount() != 1)
		{
			logger.warn("Setter {} with not parameter count != 1?", exportedName);
			return;
		}

		logger.info("Injecting setter for {} on {}", exportedName, targetApiClass);

		assert targetClass.findMethod(method.getName()) == null;
		assert field.isStatic() || field.getClassFile() == targetClass;

		Signature sig = new Signature.Builder()
			.setReturnType(Type.VOID)
			.addArgument(Inject.classToType(method.getParameterTypes()[0]))
			.build();

		Method setterMethod = new Method(targetClass, method.getName(), sig);
		setterMethod.setAccessFlags(ACC_PUBLIC);
		targetClass.addMethod(setterMethod);
		++injectedSetters;

		Code code = new Code(setterMethod);
		setterMethod.setCode(code);

		Instructions instructions = code.getInstructions();
		List<Instruction> ins = instructions.getInstructions();

		// load this
		if (!field.isStatic())
		{
			ins.add(new ALoad(instructions, 0));
		}

		// load argument
		Type argumentType = sig.getTypeOfArg(0);
		ins.add(inject.createLoadForTypeIndex(instructions, argumentType, 1));

		// cast argument to field type
		Type fieldType = field.getType();
		if (!argumentType.equals(fieldType))
		{
			CheckCast checkCast = new CheckCast(instructions);
			checkCast.setType(fieldType);
			ins.add(checkCast);
		}

		if (setter != null)
		{
			assert setter instanceof Integer || setter instanceof Long;

			if (setter instanceof Integer)
			{
				ins.add(new LDC(instructions, (int) setter));
				ins.add(new IMul(instructions));
			}
			else
			{
				ins.add(new LDC(instructions, (long) setter));
				ins.add(new LMul(instructions));
			}
		}

		if (field.isStatic())
		{
			ins.add(new PutStatic(instructions, field));
		}
		else
		{
			ins.add(new PutField(instructions, field));
		}

		ins.add(new VReturn(instructions));
	}

	int getInjectedSetters()
	{
		return injectedSetters;
	}
}
