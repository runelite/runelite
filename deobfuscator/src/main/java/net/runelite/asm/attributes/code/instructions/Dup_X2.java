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

package net.runelite.asm.attributes.code.instructions;

import java.util.Arrays;
import java.util.List;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.DupInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;

public class Dup_X2 extends Instruction implements DupInstruction
{
	public Dup_X2(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext one = stack.pop();
		StackContext two = stack.pop();
		StackContext three = null;
		if (two.getType().getSize() == 1)
			three = stack.pop();
		
		ins.pop(one, two);
		if (three != null)
			ins.pop(three);
		
		StackContext ctx = new StackContext(ins, one.getType(), one.getValue());
		stack.push(ctx);
		
		ins.push(ctx);
		
		if (three != null)
		{
			ctx = new StackContext(ins, three.getType(), three.getValue());
			stack.push(ctx);
			
			ins.push(ctx);
		}
		
		ctx = new StackContext(ins, two.getType(), two.getValue());
		stack.push(ctx);
		
		ins.push(ctx);
		
		ctx = new StackContext(ins, one.getType(), one.getValue());
		stack.push(ctx);
		
		ins.push(ctx);
		
		return ins;
	}
	
	@Override
	public boolean removeStack()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public StackContext getOriginal(StackContext sctx)
	{
		// 3 2 1 -> 1 3 2 1
		InstructionContext ctx = sctx.getPushed();
		assert ctx.getInstruction() == this;
		
		assert ctx.getPushes().contains(sctx);
		int pushedIndex = ctx.getPushes().indexOf(sctx);
		int poppedIndex;
		
		switch (pushedIndex)
		{
			case 0:
			case 3:
				poppedIndex = 0;
				break;
			case 1:
				poppedIndex = 2;
				break;
			case 2:
				poppedIndex = 1;
				break;
			default:
				throw new IllegalStateException();
		}
		
		return ctx.getPops().get(poppedIndex);
	}

	@Override
	public StackContext getOtherBranch(StackContext sctx)
	{
		// sctx = stack pushed by this instruction, return the other branch
		InstructionContext ctx = sctx.getPushed();
		assert ctx.getInstruction() == this;
		
		assert ctx.getPushes().contains(sctx);
		int pushedIndex = ctx.getPushes().indexOf(sctx);
		
		// 3 2 1 -> 1 3 2 1
		
		if (pushedIndex == 0)
			return ctx.getPushes().get(3);
		else if (pushedIndex == 3)
			return ctx.getPushes().get(0);
		
		return null;
	}

	@Override
	public List<StackContext> getDuplicated(InstructionContext ictx)
	{
		return Arrays.asList(ictx.getPops().get(0));
	}

	@Override
	public List<StackContext> getCopies(InstructionContext ictx)
	{
		return Arrays.asList(ictx.getPushes().get(0));
	}
}
