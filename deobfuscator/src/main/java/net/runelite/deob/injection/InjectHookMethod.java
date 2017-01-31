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
package net.runelite.deob.injection;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.ALoad_0;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;
import static net.runelite.deob.injection.Inject.HOOK;
import static net.runelite.deob.injection.Inject.OBFUSCATED_NAME;
import static net.runelite.deob.injection.InjectHook.HOOKS;
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
		if (an == null || an.find(HOOK) == null)
		{
			return;
		}

		// Method is hooked
		String hookName = an.find(HOOK).getElement().getString(); // hook name

		// Find equivalent method in vanilla, and insert callback at the beginning
		ClassFile cf = method.getMethods().getClassFile();
		String obfuscatedMethodName = an.find(OBFUSCATED_NAME).getElement().getString(),
			obfuscatedClassName = cf.getAnnotations().find(OBFUSCATED_NAME).getElement().getString();

		Signature obfuscatedSignature = inject.getObfuscatedSignature(method);

		ClassGroup vanilla = inject.getVanilla();
		ClassFile vanillaClass = vanilla.findClass(obfuscatedClassName);
		Method vanillaMethod = vanillaClass.findMethod(obfuscatedMethodName, obfuscatedSignature);

		// Insert instructions at beginning of method
		injectHookMethod(hookName, method, vanillaMethod);
	}

	private void injectHookMethod(String hookName, Method deobMethod, Method vanillaMethod)
	{
		Instructions instructions = vanillaMethod.getCode().getInstructions();

		Signature signature = new Signature(deobMethod.getDescriptor()); // vanilla's signature might contain garbage
		signature.setTypeOfReturnValue(new Type("V")); // Hooks always return void

		int index = 0;

		assert deobMethod.isStatic() == vanillaMethod.isStatic();

		if (!deobMethod.isStatic())
		{
			// Add variable to signature
			signature.insertArg(0, new Type("Ljava/lang/Object;")); // XXX this should be the API class..
			instructions.addInstruction(index++, new ALoad_0(instructions));
		}

		for (int i = index; i < signature.size(); ++i)
		{
			Type type = signature.getTypeOfArg(i);

			Instruction load = inject.createLoadForTypeIndex(instructions, type, index);
			instructions.addInstruction(i, load);
			
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

		instructions.addInstruction(signature.size(), invoke);

		logger.info("Injected method hook {} in {} with {} args: {}",
			hookName, vanillaMethod, signature.size(),
			signature.getArguments());
	}
}
