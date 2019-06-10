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
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.DupInstruction;
import net.runelite.asm.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.asm.attributes.code.instructions.ArrayStore;
import net.runelite.asm.attributes.code.instructions.CheckCast;
import net.runelite.asm.attributes.code.instructions.Dup;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.LMul;
import net.runelite.asm.attributes.code.instructions.PutField;
import net.runelite.asm.attributes.code.instructions.Swap;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.signature.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class InjectHook
{
	private static final Logger logger = LoggerFactory.getLogger(InjectHook.class);
	private static final String HOOK_METHOD_SIGNATURE = "(I)V";
	private static final String CLINIT = "<clinit>";
	private final Inject inject;
	private final Map<Field, HookInfo> hooked = new HashMap<>();
	private int injectedHooks;

	InjectHook(Inject inject)
	{
		this.inject = inject;
	}

	void hook(Field field, HookInfo hookInfo)
	{
		hooked.put(field, hookInfo);
	}

	void run()
	{
		Execution e = new Execution(inject.getVanilla());
		e.populateInitialMethods();

		Set<Instruction> done = new HashSet<>();
		Set<Instruction> doneIh = new HashSet<>();

		e.addExecutionVisitor((InstructionContext ic) ->
		{
			Instruction i = ic.getInstruction();
			Instructions ins = i.getInstructions();
			Code code = ins.getCode();
			Method method = code.getMethod();

			if (method.getName().equals(CLINIT))
			{
				return;
			}

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

			if (fieldBeingSet == null)
			{
				return;
			}

			HookInfo hookInfo = hooked.get(fieldBeingSet);
			if (hookInfo == null)
			{
				return;
			}

			String hookName = hookInfo.fieldName;
			assert hookName != null;

			logger.trace("Found injection location for hook {} at instruction {}", hookName, sfi);
			++injectedHooks;

			StackContext value = ic.getPops().get(0);

			StackContext objectStackContext = null;
			if (sfi instanceof PutField)
			{
				objectStackContext = ic.getPops().get(1);
			}

			int idx = ins.getInstructions().indexOf(sfi);
			assert idx != -1;

			try
			{
				if (hookInfo.before)
				{
					injectCallbackBefore(ins, idx, hookInfo, null, objectStackContext, value);
				}
				else
				{
					// idx + 1 to insert after the set
					injectCallback(ins, idx + 1, hookInfo, null, objectStackContext);
				}
			}
			catch (InjectionException ex)
			{
				throw new RuntimeException(ex);
			}
		});

		// these look like:
		// getfield
		// iload_0
		// iconst_0
		// iastore
		e.addExecutionVisitor((InstructionContext ic) ->
		{
			Instruction i = ic.getInstruction();
			Instructions ins = i.getInstructions();
			Code code = ins.getCode();
			Method method = code.getMethod();

			if (method.getName().equals(CLINIT))
			{
				return;
			}

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

			HookInfo hookInfo = hooked.get(fieldBeingSet);
			if (hookInfo == null)
			{
				return;
			}

			String hookName = hookInfo.fieldName;

			StackContext value = ic.getPops().get(0);
			StackContext index = ic.getPops().get(1);

			StackContext arrayReference = ic.getPops().get(2);
			InstructionContext arrayReferencePushed = arrayReference.getPushed();

			StackContext objectStackContext = null;
			if (arrayReferencePushed.getInstruction().getType() == InstructionType.GETFIELD)
			{
				objectStackContext = arrayReferencePushed.getPops().get(0);
			}

			// inject hook after 'i'
			logger.info("Found array injection location for hook {} at instruction {}", hookName, i);
			++injectedHooks;

			int idx = ins.getInstructions().indexOf(i);
			assert idx != -1;

			try
			{
				if (hookInfo.before)
				{
					injectCallbackBefore(ins, idx, hookInfo, index, objectStackContext, value);
				}
				else
				{
					injectCallback(ins, idx + 1, hookInfo, index, objectStackContext);
				}
			}
			catch (InjectionException ex)
			{
				throw new RuntimeException(ex);
			}
		});

		e.run();
	}

	private void injectCallbackBefore(Instructions ins, int idx, HookInfo hookInfo, StackContext index, StackContext object, StackContext value) throws InjectionException
	{
		Signature signature = hookInfo.method.getDescriptor();
		Type methodArgumentType = signature.getTypeOfArg(0);

		if (!hookInfo.method.isStatic())
		{
			if (object == null)
			{
				throw new InjectionException("null object");
			}

			ins.getInstructions().add(idx++, new Dup(ins)); // dup value
			idx = recursivelyPush(ins, idx, object);
			ins.getInstructions().add(idx++, new Swap(ins));
			if (hookInfo.getter != null)
			{
				assert hookInfo.getter instanceof Integer || hookInfo.getter instanceof Long;

				if (hookInfo.getter instanceof Integer)
				{
					ins.getInstructions().add(idx++, new LDC(ins, (int) hookInfo.getter));
					ins.getInstructions().add(idx++, new IMul(ins));
				}
				else
				{
					ins.getInstructions().add(idx++, new LDC(ins, (long) hookInfo.getter));
					ins.getInstructions().add(idx++, new LMul(ins));
				}
			}
			if (!value.type.equals(methodArgumentType))
			{
				CheckCast checkCast = new CheckCast(ins);
				checkCast.setType(methodArgumentType);
				ins.getInstructions().add(idx++, checkCast);
			}
			if (index != null)
			{
				idx = recursivelyPush(ins, idx, index);
			}

			InvokeVirtual invoke = new InvokeVirtual(ins,
				new net.runelite.asm.pool.Method(
					new net.runelite.asm.pool.Class(hookInfo.clazz),
					hookInfo.method.getName(),
					signature
				)
			);
			ins.getInstructions().add(idx++, invoke);
		}
		else
		{
			ins.getInstructions().add(idx++, new Dup(ins)); // dup value
			if (!value.type.equals(methodArgumentType))
			{
				CheckCast checkCast = new CheckCast(ins);
				checkCast.setType(methodArgumentType);
				ins.getInstructions().add(idx++, checkCast);
			}
			if (index != null)
			{
				idx = recursivelyPush(ins, idx, index);
			}

			InvokeStatic invoke = new InvokeStatic(ins,
				new net.runelite.asm.pool.Method(
					new net.runelite.asm.pool.Class(hookInfo.clazz),
					hookInfo.method.getName(),
					signature
				)
			);
			ins.getInstructions().add(idx++, invoke);
		}
	}

	private int recursivelyPush(Instructions ins, int idx, StackContext sctx)
	{
		InstructionContext ctx = sctx.getPushed();
		if (ctx.getInstruction() instanceof DupInstruction)
		{
			DupInstruction dupInstruction = (DupInstruction) ctx.getInstruction();
			sctx = dupInstruction.getOriginal(sctx);
			ctx = sctx.getPushed();
		}

		for (StackContext s : Lists.reverse(ctx.getPops()))
		{
			idx = recursivelyPush(ins, idx, s);
		}

		ins.getInstructions().add(idx++, ctx.getInstruction().clone());
		return idx;
	}

	private void injectCallback(Instructions ins, int idx, HookInfo hookInfo, StackContext index, StackContext objectPusher) throws InjectionException
	{
		if (!hookInfo.method.isStatic())
		{
			if (objectPusher == null)
			{
				throw new InjectionException("Null object pusher");
			}

			idx = recursivelyPush(ins, idx, objectPusher);
			if (index != null)
			{
				idx = recursivelyPush(ins, idx, index);
			}
			else
			{
				ins.getInstructions().add(idx++, new LDC(ins, -1));
			}

			InvokeVirtual invoke = new InvokeVirtual(ins,
				new net.runelite.asm.pool.Method(
					new net.runelite.asm.pool.Class(hookInfo.clazz),
					hookInfo.method.getName(),
					new Signature(HOOK_METHOD_SIGNATURE)
				)
			);
			ins.getInstructions().add(idx++, invoke);

		}
		else
		{
			if (index != null)
			{
				idx = recursivelyPush(ins, idx, index);
			}
			else
			{
				ins.getInstructions().add(idx++, new LDC(ins, -1));
			}

			InvokeStatic invoke = new InvokeStatic(ins,
				new net.runelite.asm.pool.Method(
					new net.runelite.asm.pool.Class(hookInfo.clazz),
					hookInfo.method.getName(),
					new Signature(HOOK_METHOD_SIGNATURE)
				)
			);
			ins.getInstructions().add(idx++, invoke);
		}
	}

	int getInjectedHooks()
	{
		return injectedHooks;
	}

	static class HookInfo
	{
		String fieldName;
		String clazz;
		Method method;
		boolean before;
		Number getter;
	}
}
