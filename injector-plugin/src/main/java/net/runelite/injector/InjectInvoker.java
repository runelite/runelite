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
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.BiPush;
import net.runelite.asm.attributes.code.instructions.CheckCast;
import net.runelite.asm.attributes.code.instructions.DLoad;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.LLoad;
import net.runelite.asm.attributes.code.instructions.Return;
import net.runelite.asm.attributes.code.instructions.SiPush;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.DeobAnnotations;
import static net.runelite.deob.DeobAnnotations.EXPORT;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class InjectInvoker
{
	private static final Logger logger = LoggerFactory.getLogger(InjectInvoker.class);

	private final Inject inject;

	private int injectedInvokers;

	InjectInvoker(Inject inject)
	{
		this.inject = inject;
	}

	/**
	 * Inject an invoker for a method
	 *
	 * @param m                 Method in the deobfuscated client to inject an invoker for
	 * @param other             Class in the vanilla client of the same class m is a
	 *                          member of
	 * @param implementingClass Java class for the API interface the class
	 *                          will implement
	 */
	void process(Method m, ClassFile other, java.lang.Class<?> implementingClass)
	{
		Annotations an = m.getAnnotations();

		if (an == null || an.find(EXPORT) == null)
		{
			return; // not an exported method
		}

		String exportedName = DeobAnnotations.getExportedName(an);
		String obfuscatedName = DeobAnnotations.getObfuscatedName(an);

		if (obfuscatedName == null)
		{
			obfuscatedName = m.getName();
		}

		String garbage = DeobAnnotations.getDecoder(m);
		Method otherm = other.findMethod(obfuscatedName, inject.getMethodSignature(m));

		assert otherm != null;
		assert m.isStatic() == otherm.isStatic();

		ClassGroup vanilla = inject.getVanilla();

		ClassFile targetClass = m.isStatic() ? vanilla.findClass("client") : other;

		// Place into implementing class, unless the method is static
		java.lang.Class<?> targetClassJava = m.isStatic() ? Inject.CLIENT_CLASS : implementingClass;

		if (targetClassJava == null)
		{
			assert !m.isStatic();

			// non static exported method on non exported interface, weird.
			//		logger.debug("Non static exported method {} on non exported interface", exportedName);
			return;
		}

		java.lang.reflect.Method apiMethod = inject.findImportMethodOnApi(targetClassJava, exportedName, null); // api method to invoke 'otherm'
		if (apiMethod == null)
		{
			//		logger.debug("Unable to find api method on {} with imported name {}, not injecting invoker", targetClassJava, exportedName);
			return;
		}

		injectInvoker(targetClass, apiMethod, m, otherm, garbage);
		++injectedInvokers;
	}

	private void injectInvoker(ClassFile clazz, java.lang.reflect.Method method, Method deobfuscatedMethod, Method invokeMethod, String garbage)
	{
		// clazz = clazz to add invoker to
		// method = api method to override
		// deobfuscatedMethod = deobfuscated method, used to get the deobfuscated signature
		// invokeMethod = method to invoke, obfuscated

		if (clazz.findMethod(method.getName(), deobfuscatedMethod.getDescriptor()) != null)
		{
			logger.warn("Not injecting method {} because it already exists!", method);
			return; // this can happen from exporting a field and method with the same name
		}

		assert invokeMethod.isStatic() == deobfuscatedMethod.isStatic();
		assert invokeMethod.isStatic() || invokeMethod.getClassFile() == clazz;

		Type lastGarbageArgumentType = null;

		if (deobfuscatedMethod.getDescriptor().getArguments().size() != invokeMethod.getDescriptor().getArguments().size())
		{
			// allow for obfuscated method to have a single bogus signature at the end
			assert deobfuscatedMethod.getDescriptor().size() + 1 == invokeMethod.getDescriptor().size();

			List<Type> arguments = invokeMethod.getDescriptor().getArguments();
			lastGarbageArgumentType = arguments.get(arguments.size() - 1);
		}

		// Injected method signature is always the same as the API
		Signature apiSignature = inject.javaMethodToSignature(method);
		Method invokerMethodSignature = new Method(clazz, method.getName(), apiSignature);
		invokerMethodSignature.setAccessFlags(ACC_PUBLIC);

		// create code attribute
		Code code = new Code(invokerMethodSignature);
		invokerMethodSignature.setCode(code);

		Instructions instructions = code.getInstructions();
		List<Instruction> ins = instructions.getInstructions();

		code.setMaxStack(1 + invokeMethod.getDescriptor().size()); // this + arguments

		// load function arguments onto the stack.
		int index = 0;
		if (!invokeMethod.isStatic())
		{
			ins.add(new ALoad(instructions, index++)); // this
		}
		else
		{
			++index; // this method is always non static
		}
		for (int i = 0; i < deobfuscatedMethod.getDescriptor().size(); ++i)
		{
			Type type = deobfuscatedMethod.getDescriptor().getTypeOfArg(i);

			Instruction loadInstruction = inject.createLoadForTypeIndex(instructions, type, index);
			ins.add(loadInstruction);

			Signature invokeDesc = invokeMethod.getDescriptor();
			Type obType = invokeDesc.getTypeOfArg(i);
			if (!type.equals(obType))
			{
				CheckCast checkCast = new CheckCast(instructions);
				checkCast.setType(obType);
				ins.add(checkCast);
			}

			if (loadInstruction instanceof DLoad || loadInstruction instanceof LLoad)
			{
				index += 2;
			}
			else
			{
				index += 1;
			}
		}

		if (lastGarbageArgumentType != null)
		{
			// function requires garbage value

			// if garbage is null here it might just be an unused parameter, not part of the obfuscation
			if (garbage == null)
			{
				garbage = "0";
			}

			switch (lastGarbageArgumentType.toString())
			{
				case "Z":
				case "B":
				case "C":
					ins.add(new BiPush(instructions, Byte.parseByte(garbage)));
					break;
				case "S":
					ins.add(new SiPush(instructions, Short.parseShort(garbage)));
					break;
				case "I":
					ins.add(new LDC(instructions, Integer.parseInt(garbage)));
					break;
				case "D":
					ins.add(new LDC(instructions, Double.parseDouble(garbage)));
					break;
				case "F":
					ins.add(new LDC(instructions, Float.parseFloat(garbage)));
					break;
				case "J":
					ins.add(new LDC(instructions, Long.parseLong(garbage)));
					break;
				default:
					throw new RuntimeException("Unknown type");
			}
		}

		if (invokeMethod.isStatic())
		{
			ins.add(new InvokeStatic(instructions, invokeMethod.getPoolMethod()));
		}
		else
		{
			ins.add(new InvokeVirtual(instructions, invokeMethod.getPoolMethod()));
		}

		Type returnValue = invokeMethod.getDescriptor().getReturnValue();
		InstructionType returnType;

		if (returnValue.isPrimitive() && returnValue.getDimensions() == 0)
		{
			switch (returnValue.toString())
			{
				case "Z":
				case "I":
					returnType = InstructionType.IRETURN;
					break;
				case "J":
					returnType = InstructionType.LRETURN;
					break;
				case "F":
					returnType = InstructionType.FRETURN;
					break;
				case "D":
					returnType = InstructionType.DRETURN;
					break;
				case "V":
					returnType = InstructionType.RETURN;
					break;
				default:
					assert false;
					return;
			}
		}
		else
		{
			returnType = InstructionType.ARETURN;
		}

		ins.add(new Return(instructions, returnType));

		clazz.addMethod(invokerMethodSignature);
	}

	int getInjectedInvokers()
	{
		return injectedInvokers;
	}
}
