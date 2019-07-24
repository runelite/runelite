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

package net.runelite.deob.deobfuscators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.ComparisonInstruction;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.attributes.code.instructions.AThrow;
import net.runelite.asm.attributes.code.instructions.Goto;
import net.runelite.asm.attributes.code.instructions.If;
import net.runelite.asm.attributes.code.instructions.New;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.MethodContext;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IllegalStateExceptions implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(IllegalStateExceptions.class);

	private int count;
	private Set<Instruction> interesting = new HashSet<>();
	private List<InstructionContext> toRemove = new ArrayList<>();

	/* find if, new, ..., athrow, replace with goto */
	private void findInteresting(ClassGroup group)
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				Code c = m.getCode();
				if (c == null)
					continue;
				
				Instructions instructions = c.getInstructions();
				
				List<Instruction> ilist = instructions.getInstructions();
				for (int i = 0; i < ilist.size(); ++i)
				{
					Instruction ins = ilist.get(i);
					
					if (!(ins instanceof ComparisonInstruction)) // the if
						continue;
					
					Instruction ins2 = ilist.get(i + 1);
					if (!(ins2 instanceof New))
						continue;
					
					New new2 = (New) ins2;
					net.runelite.asm.pool.Class clazz = new2.getNewClass();
					if (!clazz.getName().contains("java/lang/IllegalStateException"))
						continue;

					interesting.add(ins);
				}
			}
		}
	}

	private void visit(InstructionContext ic)
	{
		if (interesting.contains(ic.getInstruction()))
		{
			toRemove.add(ic);
		}
	}

	private void visit(MethodContext ctx)
	{
		for (InstructionContext ictx : toRemove)
			processOne(ictx);
		toRemove.clear();
	}

	private void processOne(InstructionContext ic)
	{
		Instruction ins = ic.getInstruction();
		Instructions instructions = ins.getInstructions();

		if (instructions == null)
			return;
		
		List<Instruction> ilist = instructions.getInstructions();

		JumpingInstruction jumpIns = (JumpingInstruction) ins;
		assert jumpIns.getJumps().size() == 1;
		Instruction to = jumpIns.getJumps().get(0);

		// remove stack of if.
		if (ins instanceof If)
		{
			ic.removeStack(1);
		}
		ic.removeStack(0);

		int i = ilist.indexOf(ins);
		assert i != -1;

		// remove up to athrow
		while (!(ins instanceof AThrow))
		{
			instructions.remove(ins);
			ins = ilist.get(i); // don't need to ++i because
		}

		// remove athrow
		instructions.remove(ins);

		// insert goto
		assert ilist.contains(to);
		Goto g = new Goto(instructions, instructions.createLabelFor(to));
		ilist.add(i, g);

		++count;
	}
	
	@Override
	public void run(ClassGroup group)
	{	
		findInteresting(group);
		
		Execution execution = new Execution(group);
		execution.addExecutionVisitor(i -> visit(i));
		execution.addMethodContextVisitor(i -> visit(i));
		execution.populateInitialMethods();
		execution.run();
		
		logger.info("Removed " + count + " illegal state exceptions");
	}
}
