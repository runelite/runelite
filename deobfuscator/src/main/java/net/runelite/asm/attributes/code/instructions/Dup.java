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

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.DupInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;

public class Dup extends Instruction implements DupInstruction
{
	public Dup(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}

	public Dup(Instructions instructions)
	{
		super(instructions, InstructionType.DUP);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext obj = stack.pop();
		ins.pop(obj);
		
		StackContext ctx = new StackContext(ins, obj.getType(), obj.getValue());
		stack.push(ctx);
		
		ins.push(ctx);
		
		ctx = new StackContext(ins, obj.getType(), obj.getValue());
		stack.push(ctx);
		
		ins.push(ctx);
		
		return ins;
	}
	
	@Override
	public boolean removeStack()
	{
		// removing something from the stack this pushed at index 'idx'
		// idx = 0 is top of the stack, goes up.
		//
		// the stack is relative to post-execute of this instruction
		
		// for dup, to remove one of the things pushed by it you simply
		// remove the dup instruction
		super.removeStack();
		// do not continue as the other branch still uses what we left
		// usually this is for new dup invokespecial and we end up with
		// an unused new/invokesepcial
		return false;
	}

	@Override
	public StackContext getOriginal(StackContext sctx)
	{
		// ctx = stack pushed by this instruction, return stack popped by this instruction
		InstructionContext ctx = sctx.getPushed();
		assert ctx.getInstruction() == this;
		assert ctx.getPushes().contains(sctx);
		return ctx.getPops().get(0);
	}

	@Override
	public StackContext getOtherBranch(StackContext sctx)
	{
		InstructionContext ctx = sctx.getPushed();
		assert ctx.getInstruction() == this;
		
		List<StackContext> pushes = ctx.getPushes();
		assert pushes.contains(sctx);
		
		int idx = pushes.indexOf(sctx);
		assert idx == 0 || idx == 1;
		
		return pushes.get(~idx & 1);
	}

	@Override
	public List<StackContext> getDuplicated(InstructionContext ictx)
	{
		assert ictx.getInstruction() == this;
		return new ArrayList<>(ictx.getPops());
	}

	@Override
	public List<StackContext> getCopies(InstructionContext ictx)
	{
		return new ArrayList<>(ictx.getPushes());
	}
}
