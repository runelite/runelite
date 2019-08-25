/*
 * Copyright (c) 2018 Abex
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
package net.runelite.injector.raw;

import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.AStore;
import net.runelite.asm.attributes.code.instructions.Dup;
import net.runelite.asm.attributes.code.instructions.GetField;
import net.runelite.asm.attributes.code.instructions.IALoad;
import net.runelite.asm.attributes.code.instructions.IInc;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.IStore;
import net.runelite.asm.attributes.code.instructions.IfNe;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.PutField;
import net.runelite.asm.attributes.code.instructions.PutStatic;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.MethodContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.deob.DeobAnnotations;
import net.runelite.injector.Inject;
import static net.runelite.injector.InjectUtil.findDeobField;
import static net.runelite.injector.InjectUtil.findObField;
import static net.runelite.injector.InjectUtil.findStaticMethod;
import net.runelite.injector.InjectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScriptVM
{
	private static final Logger log = LoggerFactory.getLogger(ScriptVM.class);

	private final Inject inject;

	public ScriptVM(Inject inject)
	{
		this.inject = inject;
	}

	public void inject() throws InjectionException
	{
		injectScriptVMHooks();
	}

	private void injectScriptVMHooks() throws InjectionException
	{
		final ClassGroup vanilla = inject.getVanilla();

		/*
			This hooks local variable assignments in the copied version of runScript:
			 - The currently executing script > client.currentScript
			 - The currently executing script's program counter > client.currentScriptPC
			 - The currently executing opcode > client.vmExecuteOpcode(I)Z

			The currently executing script variable is located as the outermost Script local

			The PC is located by its use in PutField ScriptFrame::invokedFromPC

			The currently executing opcode is found by searching for iaload with the script's instruction array

			The script's instruction array is identified by looking for the getfield from script.instructions

			bn.g @ rev 163 :
			// Jump back to here if vmExecuteOpcode returns true
			aload6 // Script.instructions
			iinc 5 1 // ++PC
			iload5 // PC
			iaload
			istore8
			// <- Inject here
			iload8
			bipush 100
			if_icmpge L52

		 */
		final String scriptObName = DeobAnnotations.getObfuscatedName(inject.getDeobfuscated().findClass("Script").getAnnotations());

		final Method runScript = findStaticMethod(vanilla, "copy$runScript");
		final Method vmExecuteOpcode = findStaticMethod(vanilla, "vmExecuteOpcode");

		final Field scriptInstructions = findDeobField(inject, "opcodes");
		final Field scriptStatePC = findDeobField(inject, "pc");

		final Field currentScriptField = findObField(inject, "currentScript");
		final Field currentScriptPCField = findObField(inject, "currentScriptPC");

		Execution e = new Execution(inject.getVanilla());
		e.addMethod(runScript);
		e.noInvoke = true;

		AtomicReference<MethodContext> pcontext = new AtomicReference<>(null);

		e.addMethodContextVisitor(pcontext::set);
		e.run();

		Instructions instrs = runScript.getCode().getInstructions();

		Set<AStore> scriptStores = new HashSet<>();
		Integer pcLocalVar = null;
		Integer instructionArrayLocalVar = null;
		IStore currentOpcodeStore = null;
		ALoad localInstructionLoad = null;

		MethodContext methodContext = pcontext.get();
		for (InstructionContext instrCtx : methodContext.getInstructionContexts())
		{
			Instruction instr = instrCtx.getInstruction();

			if (instr instanceof AStore)
			{
				AStore store = (AStore) instr;
				StackContext storedVarCtx = instrCtx.getPops().get(0);

				// Find AStores that store a Script
				if (storedVarCtx.getType().getInternalName().equals(scriptObName))
				{
					scriptStores.add(store);
				}

				// Find AStores that store the instructions
				InstructionContext pusherCtx = storedVarCtx.getPushed();
				if (pusherCtx.getInstruction() instanceof GetField)
				{
					GetField getField = (GetField) pusherCtx.getInstruction();
					if (getField.getMyField().equals(scriptInstructions))
					{
						instructionArrayLocalVar = store.getVariableIndex();
					}
				}
			}

			// Find the local that invokedFromPc is set from
			if (instr instanceof PutField)
			{
				PutField put = (PutField) instr;
				if (put.getMyField() == scriptStatePC)
				{
					StackContext pc = instrCtx.getPops().get(0);
					assert Type.INT.equals(pc.getType()) : pc.getType();

					InstructionContext mulctx = pc.pushed;
					assert mulctx.getInstruction() instanceof IMul;

					pcLocalVar = mulctx.getPops().stream()
						.map(StackContext::getPushed)
						.filter(i -> i.getInstruction() instanceof ILoad)
						.map(i -> ((ILoad) i.getInstruction()).getVariableIndex())
						.findFirst()
						.orElse(null);
				}
			}
		}

		// Find opcode load
		// This has to run after the first loop because it relies on instructionArrayLocalVar being set
		if (instructionArrayLocalVar == null)
		{
			throw new InjectionException("Unable to find local instruction array");
		}
		for (InstructionContext instrCtx : methodContext.getInstructionContexts())
		{
			Instruction instr = instrCtx.getInstruction();

			if (instr instanceof IALoad)
			{
				StackContext array = instrCtx.getPops().get(1);

				// Check where the array came from (looking for a getField scriptInstructions
				InstructionContext pushedCtx = array.getPushed();
				Instruction pushed = pushedCtx.getInstruction();
				if (pushed instanceof ALoad)
				{
					ALoad arrayLoad = (ALoad) pushed;
					if (arrayLoad.getVariableIndex() == instructionArrayLocalVar)
					{
						//Find the istore
						IStore istore = (IStore) instrCtx.getPushes().get(0).getPopped().stream()
							.map(InstructionContext::getInstruction)
							.filter(i -> i instanceof IStore)
							.findFirst()
							.orElse(null);
						if (istore != null)
						{
							currentOpcodeStore = istore;
							localInstructionLoad = arrayLoad;
						}
					}
				}
			}
		}

		// Add PutStatics to all Script AStores
		{
			int outerSciptIdx = scriptStores.stream()
				.mapToInt(AStore::getVariableIndex)
				.reduce(Math::min)
				.orElseThrow(() -> new InjectionException("Unable to find any Script AStores in runScript"));
			log.debug("Found script index {}", outerSciptIdx);

			ListIterator<Instruction> instrIter = instrs.getInstructions().listIterator();
			while (instrIter.hasNext())
			{
				Instruction instr = instrIter.next();

				if (instr instanceof AStore)
				{
					AStore il = (AStore) instr;
					if (il.getVariableIndex() == outerSciptIdx)
					{
						instrIter.previous();
						instrIter.add(new Dup(instrs));
						instrIter.add(new PutStatic(instrs, currentScriptField));
						instrIter.next();
					}
				}
			}
		}

		// Add PutStatics to all PC IStores and IIncs
		{
			if (pcLocalVar == null)
			{
				throw new InjectionException("Unable to find ILoad for invokedFromPc IStore");
			}
			log.debug("Found pc index {}", pcLocalVar);

			ListIterator<Instruction> instrIter = instrs.getInstructions().listIterator();
			while (instrIter.hasNext())
			{
				Instruction instr = instrIter.next();

				if (instr instanceof IStore)
				{
					IStore il = (IStore) instr;
					if (il.getVariableIndex() == pcLocalVar)
					{
						instrIter.previous();
						instrIter.add(new Dup(instrs));
						instrIter.add(new PutStatic(instrs, currentScriptPCField));
						instrIter.next();
					}
				}

				if (instr instanceof IInc)
				{
					IInc iinc = (IInc) instr;
					if (iinc.getVariableIndex() == pcLocalVar)
					{
						instrIter.add(new ILoad(instrs, pcLocalVar));
						instrIter.add(new PutStatic(instrs, currentScriptPCField));
					}
				}
			}
		}

		// Inject call to vmExecuteOpcode
		log.debug("Found instruction array index {}", instructionArrayLocalVar);
		if (currentOpcodeStore == null)
		{
			throw new InjectionException("Unable to find IStore for current opcode");
		}

		int istorepc = instrs.getInstructions().indexOf(currentOpcodeStore);
		assert istorepc >= 0;

		Label nextIteration = instrs.createLabelFor(localInstructionLoad);
		instrs.addInstruction(istorepc + 1, new ILoad(instrs, currentOpcodeStore.getVariableIndex()));
		instrs.addInstruction(istorepc + 2, new InvokeStatic(instrs, vmExecuteOpcode.getPoolMethod()));
		instrs.addInstruction(istorepc + 3, new IfNe(instrs, nextIteration));
	}
}
