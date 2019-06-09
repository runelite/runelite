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

import java.util.ArrayList;
import java.util.List;

public class VariableContext
{
	private StackContext ctx; // the value stored
	private InstructionContext ic; // the instruction which stored it. also ctx.popped?
	private Type type;
	private List<InstructionContext> read = new ArrayList<>(); // instructions which reads this
	private Value value;
	private boolean isParameter; // if is a parameter. ctx will be the invoking method (in another frame)

	public VariableContext(InstructionContext i, StackContext ctx)
	{
		ic = i;
		this.ctx = ctx;
		type = ctx.getType();
		value = ctx.getValue();
	}
	
	public VariableContext(Type type) // for entrypoints
	{
		this.type = type;
		value = Value.UNKNOWN;
	}
	
	public VariableContext(InstructionContext i, VariableContext other)
	{
		ic = i;
		ctx = other.ctx;
		type = other.type;
		value = other.value;
	}
	
	public VariableContext(InstructionContext i, Type type, Value value)
	{
		ic = i;
		this.type = type;
		this.value = value;
	}
	
	public StackContext getStackContext()
	{
		return ctx;
	}
	
	public InstructionContext getInstructionWhichStored()
	{
		return ic;
	}
	
	public Type getType()
	{
		return type;
	}

	public Value getValue()
	{
		return value;
	}
	
	public void addRead(InstructionContext ctx)
	{
		if (!read.contains(ctx))
			read.add(ctx);
	}

	public List<InstructionContext> getRead()
	{
		return read;
	}

	public boolean isIsParameter()
	{
		return isParameter;
	}
	
	public VariableContext markParameter()
	{
		isParameter = true;
		return this;
	}
}
