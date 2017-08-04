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

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;
import net.runelite.deob.DeobAnnotations;
import static net.runelite.injector.InjectHook.HOOKS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InjectHookMethod
{
	private static final Logger logger = LoggerFactory.getLogger(InjectHookMethod.class);

	private final Inject inject;

	public InjectHookMethod(Inject inject)
	{
		this.inject = inject;
	}

	public void process(Method method)
	{
		Annotations an = method.getAnnotations();
		if (an == null || an.find(DeobAnnotations.HOOK) == null)
		{
			return;
		}

		// Method is hooked
		String hookName = DeobAnnotations.getHookName(an); // hook name

		// Find equivalent method in vanilla, and insert callback at the beginning
		ClassFile cf = method.getMethods().getClassFile();
		String obfuscatedMethodName = DeobAnnotations.getObfuscatedName(an),
			obfuscatedClassName = DeobAnnotations.getObfuscatedName(cf.getAnnotations());

		// might be a constructor
		if (obfuscatedMethodName == null && method.getName().equals("<init>"))
		{
			obfuscatedMethodName = "<init>";
		}

		assert obfuscatedMethodName != null : "hook on method with no obfuscated name";

		Signature obfuscatedSignature = inject.getMethodSignature(method);

		ClassGroup vanilla = inject.getVanilla();
		ClassFile vanillaClass = vanilla.findClass(obfuscatedClassName);
		Method vanillaMethod = vanillaClass.findMethod(obfuscatedMethodName, obfuscatedSignature);

		// Insert instructions at beginning of method
		injectHookMethod(hookName, method, vanillaMethod);
	}

	private void injectHookMethod(String hookName, Method deobMethod, Method vanillaMethod)
	{
		Instructions instructions = vanillaMethod.getCode().getInstructions();

		Signature.Builder builder = new Signature.Builder()
			.setReturnType(Type.VOID) // Hooks always return void
			.addArguments(deobMethod.getDescriptor().getArguments());

		int insertPos = findHookLocation(vanillaMethod);

		assert deobMethod.isStatic() == vanillaMethod.isStatic();

		if (!deobMethod.isStatic())
		{
			// Add variable to signature
			builder.addArgument(0, new Type("Ljava/lang/Object;")); // XXX this should be the API class..
			instructions.addInstruction(insertPos++, new ALoad(instructions, 0));
		}

		Signature signature = builder.build();
		int index = deobMethod.isStatic() ? 0 : 1; // current variable index

		for (int i = index; i < signature.size(); ++i)
		{
			Type type = signature.getTypeOfArg(i);

			Instruction load = inject.createLoadForTypeIndex(instructions, type, index);
			instructions.addInstruction(insertPos++, load);

			index += type.getSlots();
		}

		// Invoke callback
		InvokeStatic invoke = new InvokeStatic(instructions,
			new net.runelite.asm.pool.Method(
				new net.runelite.asm.pool.Class(HOOKS),
				hookName,
				signature
			)
		);

		instructions.addInstruction(insertPos++, invoke);

		logger.info("Injected method hook {} in {} with {} args: {}",
			hookName, vanillaMethod, signature.size(),
			signature.getArguments());
	}

	private int findHookLocation(Method vanillaMethod)
	{
		if (!vanillaMethod.getName().equals("<init>"))
		{
			return 0;
		}

		// Find index after invokespecial
		Instructions instructions = vanillaMethod.getCode().getInstructions();
		for (int i = 0; i < instructions.getInstructions().size(); ++i)
		{
			Instruction in = instructions.getInstructions().get(i);

			if (in.getType() == InstructionType.INVOKESPECIAL)
			{
				return i + 1; // one after
			}
		}

		throw new IllegalStateException("constructor with no invokespecial");
	}
}
