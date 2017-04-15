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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.FieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.asm.attributes.code.instructions.AConstNull;
import net.runelite.asm.attributes.code.instructions.ALoad_0;
import net.runelite.asm.attributes.code.instructions.ArrayStore;
import net.runelite.asm.attributes.code.instructions.IConst_M1;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.LDC_W;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;
import static net.runelite.deob.injection.Inject.HOOK;
import static net.runelite.deob.injection.Inject.OBFUSCATED_NAME;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InjectHook
{
	private static final Logger logger = LoggerFactory.getLogger(InjectHook.class);

	public static final String HOOKS = "net/runelite/inject/callbacks/Hooks";

	private static final String HOOK_METHOD = "callHook";
	private static final String HOOK_METHOD_SIGNATURE = "(Ljava/lang/String;ILjava/lang/Object;)V";

	private static final String CLINIT = "<clinit>";

	private final Inject inject;

	public InjectHook(Inject inject)
	{
		this.inject = inject;
	}

	public void process(Field field)
	{
		Annotations an = field.getAnnotations();
		if (an == null || an.find(HOOK) == null)
		{
			return;
		}

		// Field is hooked
		String hookname = an.find(HOOK).getElement().getString(); // hook name

		// Find where the field is set
		injectHook(field, hookname);
	}

	private void injectHook(Field field, String hookName)
	{
		for (ClassFile cf : inject.getVanilla().getClasses())
		{
			for (Method method : cf.getMethods().getMethods())
			{
				Code code = method.getCode();

				// Don't inject hooks into class initialization methods
				if (code == null || method.getName().equals(CLINIT))
				{
					continue;
				}

				injectHook(field, hookName, method);
			}
		}
	}

	private void injectHook(Field field, String hookName, Method method)
	{
		Code code = method.getCode();

		boolean get = false;

		for (Instruction i : new ArrayList<>(code.getInstructions().getInstructions()))
		{
			if (!(i instanceof FieldInstruction))
			{
				continue;
			}

			FieldInstruction fi = (FieldInstruction) i;

			Field fieldBeingSet = fi.getMyField();

			if (fieldBeingSet == null || !isField(field, fieldBeingSet))
			{
				continue;
			}

			if (i instanceof SetFieldInstruction)
			{
				SetFieldInstruction sfi = (SetFieldInstruction) i;
				injectSetField(field, hookName, method, sfi);
			}
			if (i instanceof GetFieldInstruction)
			{
				get = true;
			}
		}

		// getting an array places the array reference on the stack,
		// which can later be arraystored to, so check that
		if (get && field.getType().isArray())
		{
			injectArrayStore(field, hookName, method);
		}
	}

	private boolean isField(Field field, Field fieldBeingSet)
	{
		String obfuscatedClassName = field.getFields().getClassFile().getAnnotations().find(OBFUSCATED_NAME).getElement().getString();
		String obfuscatedFieldName = field.getAnnotations().find(OBFUSCATED_NAME).getElement().getString(); // obfuscated name of field
		Type type = inject.toObType(field.getType());

		ClassGroup vanilla = inject.getVanilla();

		ClassFile obfuscatedClass = vanilla.findClass(obfuscatedClassName);
		assert obfuscatedClass != null;

		Field obfuscatedField = obfuscatedClass.findFieldDeep(obfuscatedFieldName, type);
		assert obfuscatedField != null;

		return fieldBeingSet == obfuscatedField;
	}

	private void injectSetField(Field field, String hookName, Method method, SetFieldInstruction sfi)
	{
		logger.info("Found injection location for hook {} at instruction {}", hookName, sfi);

		Code code = method.getCode();
		Instructions ins = code.getInstructions();

		int idx = ins.getInstructions().indexOf(sfi);
		assert idx != -1;

		// idx + 1 to insert after the set
		injectCallback(method, ins, idx + 1, hookName, new IConst_M1(ins));
	}

	private void injectArrayStore(Field field, String hookName, Method method)
	{
		Code code = method.getCode();
		Instructions ins = code.getInstructions();

		// these look like:
		// getfield
		// iload_0
		// iconst_0
		// iastore
		// so we need to execute the method.
		Execution e = new Execution(inject.getVanilla());
		e.noInvoke = true;
		e.addMethod(method);
		
		Set<Instruction> done = new HashSet<>();

		e.addExecutionVisitor((InstructionContext ic) -> {
				Instruction i = ic.getInstruction();

				if (!(i instanceof ArrayStore))
				{
					return;
				}
				
				if (done.contains(i))
				{
					// already done?
					return;
				}
				
				done.add(i);

				ArrayStore as = (ArrayStore) i;

				Field f = as.getMyField(ic);
				if (f == null || !isField(field, f))
				{
					return; // not the correct field
				}
				
				// assume this is always at index 1
				StackContext index = ic.getPops().get(1);
				InstructionContext indexIc = index.getPushed(); // what pushed the index
				
				if (indexIc.getPops().isEmpty() == false)
				{
					logger.warn("Array index uses instruction {} which pops from the stack, unable to inject hook {}", indexIc, hookName);
					return;
				}

				// inject hook after 'i'
				logger.info("Found array injection location for hook {} at instruction {}", hookName, i);

				int idx = ins.getInstructions().indexOf(i);
				assert idx != -1;

				injectCallback(method, ins, idx + 1, hookName, indexIc.getInstruction().clone());
		});

		e.run();
	}

	private void injectCallback(Method method, Instructions ins, int idx, String hookName, Instruction indexPusher)
	{
		// Insert:
		// ldc hookName
		// <indexPusher>
		// aload 0 (or aconst_null)
		// invokestatic net/runelite/inject/callbacks/Hooks/callHook(Ljava/lang/String;ILjava/lang/Object;)V

		// hook name
		LDC_W ldc = new LDC_W(ins, hookName);

		// object the field is being set on
		Instruction loadThis;
		if (method.isStatic())
		{
			loadThis = new AConstNull(ins);
		}
		else
		{
			loadThis = new ALoad_0(ins);
		}

		InvokeStatic invoke = new InvokeStatic(ins,
			new net.runelite.asm.pool.Method(
				new net.runelite.asm.pool.Class(HOOKS),
				HOOK_METHOD,
				new Signature(HOOK_METHOD_SIGNATURE)
			)
		);

		ins.getInstructions().add(idx++, ldc);
		ins.getInstructions().add(idx++, indexPusher);
		ins.getInstructions().add(idx++, loadThis);
		ins.getInstructions().add(idx++, invoke);
	}
}
