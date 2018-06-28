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

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.Type;

public class StackContext
{
	public InstructionContext pushed; // instruction which pushed this
	public List<InstructionContext> poppeds = new ArrayList<>(); // instructions which popped this
	public Type type; // type of this
	private Value value;
	public boolean removed;
	public StackContext returnSource; // if this is the return value of an invokestatic, returnSource is the stack popped by the Return instruction
	
	public StackContext(InstructionContext pushed, Type type, Value value)
	{
		this.pushed = pushed;
		this.type = type;
		this.value = value;
	}
	
	public StackContext(InstructionContext pushed, VariableContext vctx)
	{
		this.pushed = pushed;
		this.type = vctx.getType();
		this.value = vctx.getValue();
	}

	public InstructionContext getPushed()
	{
		return pushed;
	}

	public List<InstructionContext> getPopped()
	{
		return poppeds;
	}

	public void addPopped(InstructionContext popped)
	{
		if (!this.poppeds.contains(popped))
			this.poppeds.add(popped);
	}

	public Type getType()
	{
		return type;
	}

	public Value getValue()
	{
		return value;
	}
	
	// remove this object from the stack
	public List<StackContext> removeStack()
	{
		List<StackContext> list = new ArrayList<>();
		
		list.add(this);
		
		// remove the instruction which pushed this
		if (!pushed.getInstruction().removeStack())
			// dup will return false as the other objects on the stack below this are necessary
			// for the other branch.
			return list;
		
		// remove from the stack things this instruction read
		for (StackContext ctx : pushed.getPops()) 
			list.addAll(ctx.removeStack());
		
		return list;
	}
}
