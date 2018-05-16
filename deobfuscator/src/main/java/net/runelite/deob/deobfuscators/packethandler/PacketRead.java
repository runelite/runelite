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
package net.runelite.deob.deobfuscators.packethandler;

import java.util.Objects;

import net.runelite.asm.Type;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.execution.InstructionContext;

public class PacketRead
{
	private final Type type; // type of read, from return of function
	private final Instruction getBuffer; // getstatic
	private final InstructionContext invokeCtx;
	private final Instruction invoke; // invoke instruction to read data
	private Instruction store; // lvt store for reorderable reads

	public PacketRead(Type type, Instruction getBuffer, InstructionContext invokeCtx)
	{
		this.type = type;
		this.getBuffer = getBuffer;
		this.invokeCtx = invokeCtx;
		this.invoke = invokeCtx.getInstruction();
	}

	public Type getType()
	{
		return type;
	}

	public Instruction getGetBuffer()
	{
		return getBuffer;
	}

	public InstructionContext getInvokeCtx()
	{
		return invokeCtx;
	}

	public Instruction getInvoke()
	{
		return invoke;
	}

	public Instruction getStore()
	{
		return store;
	}

	public void setStore(Instruction store)
	{
		this.store = store;
	}

	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 37 * hash + Objects.hashCode(this.type);
		hash = 37 * hash + Objects.hashCode(this.invoke);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final PacketRead other = (PacketRead) obj;
		if (!Objects.equals(this.type, other.type))
		{
			return false;
		}
		if (!Objects.equals(this.invoke, other.invoke))
		{
			return false;
		}
		return true;
	}
}
