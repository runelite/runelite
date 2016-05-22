/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.deob.deobfuscators;

import java.util.HashSet;
import java.util.Set;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instructions.IfICmpEq;
import net.runelite.asm.attributes.code.instructions.IfICmpNe;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.MethodContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExprArgOrder implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(ExprArgOrder.class);
	
	private Set<Instruction> swap = new HashSet<>();
	private int count;

	private void visit(InstructionContext ctx)
	{
		if (!(ctx.getInstruction() instanceof IfICmpEq) && !(ctx.getInstruction() instanceof IfICmpNe))
			return;

		StackContext one = ctx.getPops().get(0),
			two = ctx.getPops().get(1);

		if (!(one.getPushed().getInstruction() instanceof PushConstantInstruction) &&
			(two.getPushed().getInstruction() instanceof PushConstantInstruction))
		{
			swap.add(ctx.getInstruction());
		}
	}

	private void visit(MethodContext ctx)
	{
		for (Instruction i : swap)
		{
			InstructionContext ictx = ctx.getInstructonContexts(i).iterator().next();

			StackContext one = ictx.getPops().get(0),
				two = ictx.getPops().get(1);

			Instruction i1 = one.getPushed().getInstruction(),
				i2 = two.getPushed().getInstruction();

			Instructions ins = i.getInstructions();

			if (i1.getInstructions() == null || i2.getInstructions() == null)
				continue;

			assert i1.getInstructions() == ins;
			assert i2.getInstructions() == ins;

			assert ins.getInstructions().contains(i1);
			assert ins.getInstructions().contains(i2);

			ins.remove(i2);

			int idx = ins.getInstructions().indexOf(i1);
			assert idx != -1;

			ins.getInstructions().add(idx + 1, i2);
			i2.setInstructions(ins);

			++count;
		}
		swap.clear();
	}
	
	@Override
	public void run(ClassGroup group)
	{
		Execution execution = new Execution(group);
		execution.addExecutionVisitor(i -> visit(i));
		execution.addMethodContextVisitor(i -> visit(i));
		execution.populateInitialMethods();
		execution.run();

		logger.info("Reordered {} if arguments", count);
	}
}
