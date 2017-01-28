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
package net.runelite.deob.deobfuscators.arithmetic;

import com.google.common.collect.Lists;
import java.util.List;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.DupInstruction;
import net.runelite.asm.attributes.code.instructions.Dup;
import net.runelite.asm.attributes.code.instructions.Dup2_X1;
import net.runelite.asm.attributes.code.instructions.Dup_X1;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.LMul;
import net.runelite.asm.attributes.code.instructions.Pop;
import net.runelite.asm.attributes.code.instructions.Pop2;
import net.runelite.asm.attributes.code.instructions.Swap;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.MethodContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Removes the duplication of multiplication instructions to make
 * MultiplicationDeobfuscator easier
 *
 * @author Adam
 */
public class DupDeobfuscator implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(DupDeobfuscator.class);

	private int count;

	private void visit(InstructionContext i)
	{
		if (!(i.getInstruction() instanceof DupInstruction))
		{
			return;
		}

		DupInstruction di = (DupInstruction) i.getInstruction();

		List<StackContext> sctxs = di.getDuplicated(i); // stack values being duplicated

		for (StackContext sctx : sctxs)
		{
			InstructionContext ic = sctx.getPushed();

			if (ic.getInstruction() instanceof IMul)
			{
				if (i.getInstruction() instanceof Dup)
				{
					logger.debug("Dup instruction {} duplicates multiplication result {}", i, ic);

					undup(i);
					++count;
					return;
				}
				if (i.getInstruction() instanceof Dup_X1)
				{
					logger.debug("Dup_X1 instruction {} duplicates multiplication result {}", i, ic);

					undup_x1(i);
					++count;
					return;
				}

				logger.warn("Dup instruction {} pops imul", i);
			}
			else if (ic.getInstruction() instanceof LMul)
			{
				if (i.getInstruction() instanceof Dup2_X1)
				{
					logger.debug("Dup_X2 instruction {} duplicates multiplication result {}", i, ic);

					undup2_x1(i);
					++count;
					return;
				}
				
				logger.warn("Dup instruction {} pops lmul", i);
			}
		}

		// find if mul pops anything duplicated
		sctxs = di.getCopies(i);

		for (StackContext sctx : sctxs)
		{
			for (InstructionContext ic : sctx.getPopped())
			{
				if (ic.getInstruction() instanceof IMul)
				{
					if (i.getInstruction() instanceof Dup)
					{
						logger.debug("imul {} pops dup instruction {}", ic, i);

						undup(i);
						++count;
						return;
					}
					if (i.getInstruction() instanceof Dup_X1)
					{
						logger.debug("imul {} pops dup x1 instruction {}", ic, i);

						undup_x1(i);
						++count;
						return;
					}

					logger.warn("imul pops dup instruction {}", i);
				}
				else if (ic.getInstruction() instanceof LMul)
				{
					if (i.getInstruction() instanceof Dup2_X1)
					{
						logger.debug("imul {} pops dup2 x1 instruction {}", ic, i);

						undup2_x1(i);
						++count;
						return;
					}

					logger.warn("lmul pops dup instruction {}", i);
				}
			}
		}
	}

	private void undup(InstructionContext ictx)
	{
		assert ictx.getInstruction() instanceof Dup;

		Instructions instructions = ictx.getInstruction().getInstructions();

		StackContext duplicated = ictx.getPops().get(0);

		int idx = instructions.getInstructions().indexOf(ictx.getInstruction());
		assert idx != -1;

		// replace dup with duplicated instructions
		instructions.remove(ictx.getInstruction());

		// insert copy
		copy(duplicated, instructions, idx);
	}

	private void undup_x1(InstructionContext ictx)
	{
		assert ictx.getInstruction() instanceof Dup_X1;

		Instructions instructions = ictx.getInstruction().getInstructions();

		StackContext duplicated = ictx.getPops().get(0);

		// replace dup_x1 with swap
		int idx = instructions.replace(ictx.getInstruction(), new Swap(instructions));

		// copy imul and insert after idx
		copy(duplicated, instructions, idx + 1);
	}

	private void undup2_x1(InstructionContext ictx)
	{
		assert ictx.getInstruction() instanceof Dup2_X1;
		assert ictx.getPops().size() == 2; // only support this form

		// I L -> L I L

		Instructions instructions = ictx.getInstruction().getInstructions();

		// can't swap a long on the stack, so

		int idx = instructions.getInstructions().indexOf(ictx.getInstruction());
		assert idx != -1;

		instructions.remove(ictx.getInstruction()); // remove dup2_x1
		instructions.addInstruction(idx++, new Pop2(instructions)); // pop long
		instructions.addInstruction(idx++, new Pop(instructions)); // pop int

		// insert copy of long
		idx = copy(ictx.getPops().get(0), instructions, idx);
		// insert copy of int
		idx = copy(ictx.getPops().get(1), instructions, idx);
		// insert copy of long
		/* idx = */ copy(ictx.getPops().get(0), instructions, idx);
	}

	/**
	 * copy the instruction which pushed sctx and insert into instructions
	 * starting at index idx
	 */
	private int copy(StackContext sctx, Instructions instructions, int idx)
	{
		InstructionContext ictx = sctx.getPushed();

		if (ictx.getInstruction() instanceof DupInstruction)
		{
			// we only care about one path
			DupInstruction di = (DupInstruction) ictx.getInstruction();
			sctx = di.getOriginal(sctx);
			ictx = sctx.getPushed();
		}

		// copy required instructions
		// the first thing popped was pushed last, so reverse
		for (StackContext s : Lists.reverse(ictx.getPops()))
		{
			idx = copy(s, instructions, idx);
		}

		// copy instruction
		Instruction i = ictx.getInstruction();

		logger.debug("Duplicating instruction {} at index {}", i, idx);

		i = i.clone();

		instructions.addInstruction(idx, i);
		return idx + 1; // move on to next instruction
	}

	private void visit(MethodContext mctx)
	{
		for (InstructionContext ictx : mctx.getInstructionContexts())
		{
			if (ictx.getInstruction().getInstructions() == null)
			{
				// already removed?
				continue;
			}

			visit(ictx);
		}
	}

	@Override
	public void run(ClassGroup group)
	{
		Execution e = new Execution(group);
		e.addMethodContextVisitor(m -> visit(m));
		e.populateInitialMethods();
		e.run();

		logger.info("Replaced {} dup instructions", count);
	}

}
