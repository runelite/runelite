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
package net.runelite.deob.s2c;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.execution.Frame;

public class PacketHandler implements Cloneable
{
	private final Method method;
	private final Instruction jump; // jump for the packet handler
	private final Instruction start; // first instruction in the handler
	private final Instruction push; // instruction which pushes opcode constant
	private Instruction afterRead; // instruction after packet reads
	private final List<Instruction> instructions = new ArrayList<>();
	private final int opcode;

	public Frame frame; // after read
	public Frame jumpFrame;

	public int sizeMap; // number of mappable instructions in handler
	public List<Instruction> reads = new ArrayList<>(); // instructions which read packet data

	public Set<Field> fieldRead = new HashSet<>();
	public Set<Field> fieldWrite = new HashSet<>();
	public Set<Method> methodInvokes = new HashSet<>();

	public PacketHandler(Method method, Instruction jump, Instruction start, Instruction push, int opcode)
	{
		this.method = method;
		this.jump = jump;
		this.start = start;
		this.push = push;
		this.opcode = opcode;
	}

	@Override
	public String toString()
	{
		return "PacketHandler{" + "start=" + start + ", opcode=" + opcode + '}';
	}

	@Override
	public PacketHandler clone()
	{
		try
		{
			return (PacketHandler) super.clone();
		}
		catch (CloneNotSupportedException ex)
		{
			throw new RuntimeException(ex);
		}
	}

	public Method getMethod()
	{
		return method;
	}

	public Instruction getJump()
	{
		return jump;
	}

	public Instruction getStart()
	{
		return start;
	}

	public Instruction getPush()
	{
		return push;
	}

	public void addInstruction(Instruction i)
	{
		instructions.add(i);
	}

	public List<Instruction> getInstructions()
	{
		return instructions;
	}

	public Instruction getAfterRead()
	{
		return afterRead;
	}

	public void setAfterRead(Instruction afterRead)
	{
		this.afterRead = afterRead;
	}

	public int getOpcode()
	{
		return opcode;
	}
}
