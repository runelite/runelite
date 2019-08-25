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

package net.runelite.asm.execution;

import net.runelite.asm.Type;

import java.util.Arrays;
import java.util.List;
import net.runelite.asm.Method;

public class Stack
{
	private int size;
	private final StackContext[] stack;

	public Stack(int sz)
	{
		stack = new StackContext[sz * 2]; // XXX FIXME
	}
	
	public Stack(Stack other)
	{
		this.size = other.size;
		this.stack = other.stack.clone();
	}
	
	private void printStack(StackContext ctx, int level)
	{
		for (int i = 0; i < level; ++i)
			System.err.print(" ");
		System.err.println(ctx.getType() + " pushed by " + ctx.getPushed().getInstruction().getType().getName());// + " at " + ctx.getPushed().getInstruction().getPc());
		for (StackContext c : ctx.getPushed().getPops())
			printStack(c, level + 2);
	}

	public void push(StackContext i)
	{
		if (size == stack.length)
		{
			Method m = i.getPushed().getInstruction().getInstructions().getCode().getMethod();
			System.err.println("stack overflow in " + m.getClassFile().getName() + " method " + m.getName());
			for (int c = 0; c < stack.length; ++c)
				printStack(stack[c], 0);
			throw new RuntimeException("Stack overflow");
		}
		
		assert !i.getType().equals(Type.VOID);

		stack[size] = i;
		++size;
	}

	public StackContext pop()
	{
		if (size <= 0)
			throw new RuntimeException("Stack underflow");

		return stack[--size];
	}
	
	public int getSize()
	{
		return size;
	}
	
	public List<StackContext> getStack()
	{
		return Arrays.asList(stack);
	}
}
