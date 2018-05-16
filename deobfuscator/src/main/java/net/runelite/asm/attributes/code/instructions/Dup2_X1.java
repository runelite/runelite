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

public class Dup2_X1 extends Instruction implements DupInstruction
{
	public Dup2_X1(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}
	
	public Dup2_X1(Instructions instructions)
	{
		super(instructions, InstructionType.DUP2_X1);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext one = stack.pop();
		StackContext two = null;
		if (one.getType().getSize() == 1)
			two = stack.pop();
		StackContext three = stack.pop();
		
		ins.pop(one);
		if (two != null)
			ins.pop(two);
		ins.pop(three);
		
		if (two != null)
		{
			StackContext ctx = new StackContext(ins, two.getType(), two.getValue());
			stack.push(ctx);
			
			ins.push(ctx);
		}
		
		StackContext ctx = new StackContext(ins, one.getType(), one.getValue());
		stack.push(ctx);
		
		ins.push(ctx);
		
		ctx = new StackContext(ins, three.getType(), three.getValue());
		stack.push(ctx);
		
		ins.push(ctx);
		
		if (two != null)
		{
			ctx = new StackContext(ins, two.getType(), two.getValue());
			stack.push(ctx);
			
			ins.push(ctx);
		}
		
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
		InstructionContext ctx = sctx.getPushed();
		
		assert ctx.getInstruction() == this;
		assert ctx.getPushes().contains(sctx);
		int idx = ctx.getPushes().indexOf(sctx);
		
		// 2 1 0 -> 1 0 2 1 0 OR 1 0 -> 0 1 0
		
		assert ctx.getPushes().size() == 5 || ctx.getPushes().size() == 3;
		
		int orig;
		
		if (ctx.getPushes().size() == 5)
		{
			switch (idx)
			{
				case 0:
					orig = 1;
					break;
				case 1:
					orig = 0;
					break;
				case 2:
					orig = 2;
					break;
				case 3:
					orig = 1;
					break;
				case 4:
					orig = 0;
					break;
				default:
					throw new IllegalStateException();
			}
		}
		else if (ctx.getPushes().size() == 3)
		{
			switch (idx)
			{
				case 0:
					orig = 0;
					break;
				case 1:
					orig = 1;
					break;
				case 2:
					orig = 0;
					break;
				default:
					throw new IllegalStateException();
			}
		}
		else
		{
			throw new IllegalStateException();
		}
				
		return ctx.getPops().get(orig);
	}

	@Override
	public StackContext getOtherBranch(StackContext sctx)
	{
		InstructionContext ctx = sctx.getPushed();
		assert ctx.getInstruction() == this;
		
		assert ctx.getPushes().contains(sctx);
		int idx = ctx.getPushes().indexOf(sctx);
		
		// 2 1 0 -> 1 0 2 1 0 OR 1 0 -> 0 1 0
		
		int other;
		
		if (ctx.getPushes().size() == 5)
		{
			switch (idx)
			{
				case 0:
					other = 3;
					break;
				case 1:
					other = 4;
					break;
				case 3:
					other = 0;
					break;
				case 4:
					other = 1;
					break;
				default:
					return null;
			}
		}
		else if (ctx.getPushes().size() == 3)
		{
			switch (idx)
			{
				case 0:
					other = 2;
					break;
				case 2:
					other = 0;
					break;
				default:
					return null;
			}
		}
		else
		{
			throw new IllegalStateException();
		}
				
		return ctx.getPushes().get(other);
	}

	@Override
	public List<StackContext> getDuplicated(InstructionContext ictx)
	{
		if (ictx.getPushes().size() == 5)
		{
			// 0, 1
			return Arrays.asList(ictx.getPops().get(0), ictx.getPops().get(1));
		}
		else if (ictx.getPushes().size() == 3)
		{
			// 0
			return Arrays.asList(ictx.getPops().get(0));
		}
		else
		{
			throw new IllegalStateException();
		}
	}

	@Override
	public List<StackContext> getCopies(InstructionContext ictx)
	{
		if (ictx.getPushes().size() == 5)
		{
			return Arrays.asList(ictx.getPushes().get(0), ictx.getPushes().get(1));
		}
		else if (ictx.getPushes().size() == 3)
		{
			// 0
			return Arrays.asList(ictx.getPushes().get(0));
		}
		else
		{
			throw new IllegalStateException();
		}
	}
}
