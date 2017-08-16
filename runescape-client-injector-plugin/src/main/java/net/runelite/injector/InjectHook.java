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

import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.asm.attributes.code.instructions.AConstNull;
import net.runelite.asm.attributes.code.instructions.ArrayStore;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.PutField;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;
import net.runelite.deob.DeobAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InjectHook
{
	private static final Logger logger = LoggerFactory.getLogger(InjectHook.class);

	public static final String HOOKS = "net/runelite/client/callback/Hooks";

	private static final String HOOK_METHOD = "callHook";
	private static final String HOOK_METHOD_SIGNATURE = "(Ljava/lang/String;ILjava/lang/Object;)V";

	private static final String CLINIT = "<clinit>";

	private final Inject inject;
	private final Map<Field, Field> hooked = new HashMap<>();

	public InjectHook(Inject inject)
	{
		this.inject = inject;
	}

	private void index()
	{
		for (ClassFile cf : inject.getDeobfuscated().getClasses())
		{
			for (Field f : cf.getFields())
			{
				if (DeobAnnotations.getHookName(f.getAnnotations()) != null)
				{
					Field ob = toObField(f);
					hooked.put(ob, f);
				}
			}
		}
	}

	public void run()
	{
		index();

		for (ClassFile cf : inject.getVanilla().getClasses())
		{
			for (Method method : cf.getMethods())
			{
				Code code = method.getCode();

				if (code == null || method.getName().equals(CLINIT))
				{
					continue;
				}

				injectSetField(method);
			}
		}
	}

	private Field toObField(Field field)
	{
		String obfuscatedClassName = DeobAnnotations.getObfuscatedName(field.getClassFile().getAnnotations());
		String obfuscatedFieldName = DeobAnnotations.getObfuscatedName(field.getAnnotations()); // obfuscated name of field
		Type type = inject.getFieldType(field);

		ClassGroup vanilla = inject.getVanilla();

		ClassFile obfuscatedClass = vanilla.findClass(obfuscatedClassName);
		assert obfuscatedClass != null;

		Field obfuscatedField = obfuscatedClass.findFieldDeep(obfuscatedFieldName, type);
		assert obfuscatedField != null;

		return obfuscatedField;
	}

	private void injectSetField(Method method)
	{
		Code code = method.getCode();
		Instructions ins = code.getInstructions();

		Execution e = new Execution(inject.getVanilla());
		e.noInvoke = true;
		e.addMethod(method);

		Set<Instruction> done = new HashSet<>();
		Set<Instruction> doneIh = new HashSet<>();

		e.addExecutionVisitor((InstructionContext ic) ->
		{
			Instruction i = ic.getInstruction();

			if (!(i instanceof SetFieldInstruction))
			{
				return;
			}

			if (!done.add(i))
			{
				return;
			}

			SetFieldInstruction sfi = (SetFieldInstruction) i;
			Field fieldBeingSet = sfi.getMyField();

			if (fieldBeingSet == null)// || !hooked.contains(fieldBeingSet))
			{
				return;
			}

			Field deobField = hooked.get(fieldBeingSet);
			if (deobField == null)
			{
				return;
			}

			String hookName = DeobAnnotations.getHookName(deobField.getAnnotations()); // hook name
			assert hookName != null;

			logger.info("Found injection location for hook {} at instruction {}", hookName, sfi);

			Instruction objectInstruction = new AConstNull(ins);
			if (sfi instanceof PutField)
			{
				StackContext objectStack = ic.getPops().get(1); // Object being set on

				// Intsruction to load object
				Instruction obji = objectStack.getPushed().getInstruction();

				if (obji instanceof LVTInstruction)
				{
					assert objectStack.getPushed().getPops().isEmpty();
					objectInstruction = obji.clone();
				}
				else
				{
					// This happens now mostly with array loads: array[index].field = value;
					logger.debug("Unable to pass object to injected hook for {}, pushing instruction: {}", hookName, obji);
				}
			}

			int idx = ins.getInstructions().indexOf(sfi);
			assert idx != -1;

			// idx + 1 to insert after the set
			injectCallback(method, ins, idx + 1, hookName, null, objectInstruction);
		});

		// these look like:
		// getfield
		// iload_0
		// iconst_0
		// iastore
		e.addExecutionVisitor((InstructionContext ic) ->
		{
			Instruction i = ic.getInstruction();

			if (!(i instanceof ArrayStore))
			{
				return;
			}

			if (!doneIh.add(i))
			{
				return;
			}

			ArrayStore as = (ArrayStore) i;

			Field fieldBeingSet = as.getMyField(ic);
			if (fieldBeingSet == null)
			{
				return;
			}

			Field deobField = hooked.get(fieldBeingSet);
			if (deobField == null)
			{
				return;
			}

			String hookName = DeobAnnotations.getHookName(deobField.getAnnotations()); // hook name
			//if (hookName == null)return;

			// assume this is always at index 1
			StackContext index = ic.getPops().get(1);
			InstructionContext indexIc = index.getPushed(); // what pushed the index

			// inject hook after 'i'
			logger.info("Found array injection location for hook {} at instruction {}", hookName, i);

			int idx = ins.getInstructions().indexOf(i);
			assert idx != -1;

			// it's annoying to get the object of the field of this array, so passing null for now
			injectCallback(method, ins, idx + 1, hookName, indexIc, new AConstNull(ins));
		});

		e.run();
	}

	private int recursivelyPush(Instructions ins, int idx, InstructionContext ctx)
	{
		for (StackContext sctx : Lists.reverse(ctx.getPops()))
		{
			idx = recursivelyPush(ins, idx, sctx.getPushed());
		}

		ins.getInstructions().add(idx++, ctx.getInstruction().clone());
		return idx;
	}

	private void injectCallback(Method method, Instructions ins, int idx, String hookName, InstructionContext indexPusher, Instruction objectPusher)
	{
		// Insert:
		// ldc hookName
		// <indexPusher>
		// aload 0 (or aconst_null)
		// invokestatic net/runelite/inject/callbacks/Hooks/callHook(Ljava/lang/String;ILjava/lang/Object;)V

		// hook name
		LDC ldc = new LDC(ins, hookName);

		InvokeStatic invoke = new InvokeStatic(ins,
			new net.runelite.asm.pool.Method(
				new net.runelite.asm.pool.Class(HOOKS),
				HOOK_METHOD,
				new Signature(HOOK_METHOD_SIGNATURE)
			)
		);

		ins.getInstructions().add(idx++, ldc);
		if (indexPusher != null)
		{
			idx = recursivelyPush(ins, idx, indexPusher);
		}
		else
		{
			ins.getInstructions().add(idx++, new LDC(ins, -1));
		}
		ins.getInstructions().add(idx++, objectPusher);
		ins.getInstructions().add(idx++, invoke);
	}
}
