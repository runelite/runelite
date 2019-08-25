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

public class Dup_X1 extends Instruction implements DupInstruction
{
	public Dup_X1(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}
	
	public Dup_X1(Instructions instructions)
	{
		super(instructions, InstructionType.DUP_X1);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext one = stack.pop();
		StackContext two = stack.pop();
		
		ins.pop(one, two);
		
		StackContext ctx = new StackContext(ins, one.getType(), one.getValue());
		stack.push(ctx);
		
		ins.push(ctx);
		
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
		// ctx = stack pushed by this instruction, return stack popped by this instruction
		InstructionContext ctx = sctx.getPushed();
		assert ctx.getInstruction() == this;
		
		assert ctx.getPushes().contains(sctx);
		int pushedIndex = ctx.getPushes().indexOf(sctx);
		int poppedIndex;
		
		// 2 1 -> 1 2 1
		// index 0 is 0, index 1 is 1, index 2 is 2
		
		switch (pushedIndex)
		{
			case 0:
			case 2:
				poppedIndex = 0;
				break;
			case 1:
				poppedIndex = 1;
				break;
			default:
				throw new IllegalStateException();
		}
		
		// get popped ctx
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
		
		// 2 1 -> 1 2 1
		
		// if pushed index is 0 or 2, return other, if 1 there is no other side
		assert pushedIndex >= 0 && pushedIndex <= 2;
		
		if (pushedIndex == 0)
			return ctx.getPushes().get(2);
		else if (pushedIndex == 2)
			return ctx.getPushes().get(0);
		
		return null;
	}

	@Override
	public List<StackContext> getDuplicated(InstructionContext ictx)
	{
		assert ictx.getInstruction() == this;
		return Arrays.asList(ictx.getPops().get(0));
	}

	@Override
	public List<StackContext> getCopies(InstructionContext ictx)
	{
		return Arrays.asList(ictx.getPushes().get(0), ictx.getPushes().get(2));
	}
}
