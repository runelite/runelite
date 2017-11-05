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
package net.runelite.deob.deobfuscators.arithmetic;

import java.util.List;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.LMul;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.MethodContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiplyOneDeobfuscator implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(MultiplyOneDeobfuscator.class);

	private final boolean onlyConstants;
	private int count;

	public MultiplyOneDeobfuscator(boolean onlyConstants)
	{
		this.onlyConstants = onlyConstants;
	}

	private void visit(MethodContext mctx)
	{
		for (InstructionContext ictx : mctx.getInstructionContexts())
		{
			Instruction instruction = ictx.getInstruction();

			if (!(instruction instanceof IMul) && !(instruction instanceof LMul))
			{
				continue;
			}

			Instructions ins = ictx.getInstruction().getInstructions();
			if (ins == null)
			{
				continue;
			}

			List<Instruction> ilist = ins.getInstructions();

			if (!ilist.contains(ictx.getInstruction()))
			{
				continue; // already done
			}

			StackContext one = ictx.getPops().get(0);
			StackContext two = ictx.getPops().get(1);

			StackContext other = null;
			int removeIdx = -1;
			if (one.getPushed().getInstruction() instanceof PushConstantInstruction
				&& DMath.equals((Number) ((PushConstantInstruction) one.getPushed().getInstruction()).getConstant(), 1))
			{
				removeIdx = 0;
				other = two;
			}
			else if (two.getPushed().getInstruction() instanceof PushConstantInstruction
				&& DMath.equals((Number) ((PushConstantInstruction) two.getPushed().getInstruction()).getConstant(), 1))
			{
				removeIdx = 1;
				other = one;
			}

			if (removeIdx == -1)
			{
				continue;
			}

			if (onlyConstants && !(other.getPushed().getInstruction() instanceof PushConstantInstruction))
			{
				continue;
			}

			if (!MultiplicationDeobfuscator.isOnlyPath(ictx, removeIdx == 0 ? one : two))
			{
				continue;
			}

			ictx.removeStack(removeIdx); // remove 1
			ins.remove(instruction); // remove mul

			++count;
		}
	}

	@Override
	public void run(ClassGroup group)
	{
		Execution e = new Execution(group);
		e.addMethodContextVisitor(i -> visit(i));
		e.populateInitialMethods();
		e.run();

		logger.info("Removed " + count + " 1 multiplications");
	}

}
