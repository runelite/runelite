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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.ReturnInstruction;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.DeobAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InjectHookMethod
{
	public static final String HOOKS = "net/runelite/client/callback/Hooks";
	private static final Logger logger = LoggerFactory.getLogger(InjectHookMethod.class);
	private final Inject inject;

	InjectHookMethod(Inject inject)
	{
		this.inject = inject;
	}

	void process(Method method) throws InjectionException
	{
		Annotations an = method.getAnnotations();
		if (an == null)
		{
			return;
		}

		Annotation a = an.find(DeobAnnotations.HOOK);
		if (a == null)
		{
			return;
		}

		String hookName = a.getElement().getString();
		boolean end = a.getElements().size() == 2 && a.getElements().get(1).getValue().equals(true);

		inject(null, method, hookName, end, true);
	}

	public void inject(Method hookMethod, Method method, String name, boolean end, boolean useHooks) throws InjectionException
	{
		Annotations an = method.getAnnotations();

		// Method is hooked
		// Find equivalent method in vanilla, and insert callback at the beginning
		ClassFile cf = method.getClassFile();
		String obfuscatedMethodName = DeobAnnotations.getObfuscatedName(an),
			obfuscatedClassName = DeobAnnotations.getObfuscatedName(cf.getAnnotations());

		// might be a constructor
		if (obfuscatedMethodName == null)
		{
			obfuscatedMethodName = method.getName();
		}

		assert obfuscatedClassName != null : "hook on method in class with no obfuscated name";
		assert obfuscatedMethodName != null : "hook on method with no obfuscated name";

		Signature obfuscatedSignature = inject.getMethodSignature(method);

		ClassGroup vanilla = inject.getVanilla();
		ClassFile vanillaClass = vanilla.findClass(obfuscatedClassName);
		Method vanillaMethod = vanillaClass.findMethod(obfuscatedMethodName, obfuscatedSignature);
		assert method.isStatic() == vanillaMethod.isStatic();

		// Insert instructions at beginning of method
		injectHookMethod(hookMethod, name, end, method, vanillaMethod, useHooks);
	}

	private void injectHookMethod(Method hookMethod, String hookName, boolean end, Method deobMethod, Method vanillaMethod, boolean useHooks) throws InjectionException
	{
		Code code = vanillaMethod.getCode();
		if (code == null)
		{
			logger.warn(vanillaMethod + " code is null");
		}
		Instructions instructions = code.getInstructions();

		Signature.Builder builder = new Signature.Builder()
			.setReturnType(Type.VOID); // Hooks always return void

		for (Type type : deobMethod.getDescriptor().getArguments())
		{
			builder.addArgument(inject.deobfuscatedTypeToApiType(type));
		}

		assert deobMethod.isStatic() == vanillaMethod.isStatic();

		boolean modifiedSignature = false;
		if (!deobMethod.isStatic() && useHooks)
		{
			// Add variable to signature
			builder.addArgument(0, inject.deobfuscatedTypeToApiType(new Type(deobMethod.getClassFile().getName())));
			modifiedSignature = true;
		}

		Signature signature = builder.build();

		List<Integer> insertIndexes = findHookLocations(hookName, end, vanillaMethod);
		insertIndexes.sort((a, b) -> Integer.compare(b, a));

		for (int insertPos : insertIndexes)
		{
			if (!deobMethod.isStatic())
			{
				instructions.addInstruction(insertPos++, new ALoad(instructions, 0));
			}

			int signatureStart = modifiedSignature ? 1 : 0;
			int index = deobMethod.isStatic() ? 0 : 1; // current variable index

			for (int i = signatureStart; i < signature.size(); ++i)
			{
				Type type = signature.getTypeOfArg(i);

				Instruction load = inject.createLoadForTypeIndex(instructions, type, index);
				instructions.addInstruction(insertPos++, load);

				index += type.getSize();
			}

			InvokeInstruction invoke;

			// use old Hooks callback
			if (useHooks)
			{
				// Invoke callback
				invoke = new InvokeStatic(instructions,
					new net.runelite.asm.pool.Method(
						new net.runelite.asm.pool.Class(HOOKS),
						hookName,
						signature
					)
				);
			}
			else
			{
				// Invoke methodhook
				assert hookMethod != null;

				if (vanillaMethod.isStatic())
				{
					invoke = new InvokeStatic(instructions,
						new net.runelite.asm.pool.Method(
							new net.runelite.asm.pool.Class("client"), // Static methods are in client
							hookMethod.getName(),
							signature
						)
					);
				}
				else
				{
					// otherwise invoke member function
					//instructions.addInstruction(insertPos++, new ALoad(instructions, 0));
					invoke = new InvokeVirtual(instructions,
						new net.runelite.asm.pool.Method(
							new net.runelite.asm.pool.Class(vanillaMethod.getClassFile().getName()),
							hookMethod.getName(),
							hookMethod.getDescriptor()
						)
					);
				}
			}

			instructions.addInstruction(insertPos++, (Instruction) invoke);
		}

		logger.info("Injected method hook {} in {} with {} args: {}",
			hookName, vanillaMethod, signature.size(),
			signature.getArguments());
	}

	private List<Integer> findHookLocations(String hookName, boolean end, Method vanillaMethod) throws InjectionException
	{
		Instructions instructions = vanillaMethod.getCode().getInstructions();

		if (end)
		{
			// find return
			List<Instruction> returns = instructions.getInstructions().stream()
				.filter(i -> i instanceof ReturnInstruction)
				.collect(Collectors.toList());
			List<Integer> indexes = new ArrayList<>();

			for (Instruction ret : returns)
			{
				int idx = instructions.getInstructions().indexOf(ret);
				assert idx != -1;
				indexes.add(idx);
			}

			return indexes;
		}

		if (!vanillaMethod.getName().equals("<init>"))
		{
			return Arrays.asList(0);
		}

		// Find index after invokespecial
		for (int i = 0; i < instructions.getInstructions().size(); ++i)
		{
			Instruction in = instructions.getInstructions().get(i);

			if (in.getType() == InstructionType.INVOKESPECIAL)
			{
				return Arrays.asList(i + 1); // one after
			}
		}

		throw new IllegalStateException("constructor with no invokespecial");
	}
}
