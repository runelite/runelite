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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.deob.deobfuscators.packethandler.PacketRead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketHandler implements Cloneable
{
	private static final Logger logger = LoggerFactory.getLogger(PacketHandler.class);

	private final Method method;
	private final Instruction jump; // jump for the packet handler
	private final Instruction start; // first instruction in the handler
	private final Instruction push; // instruction which pushes opcode constant
	private final int opcode;

	public Frame frame; // after read
	public Frame jumpFrame;

	public List<Instruction> mappable = new ArrayList<>(); // mappable instructions
	public List<PacketRead> reads = new ArrayList<>(); // instructions which read packet data
	public List<PacketRead> sortedReads;
	public Map<Integer, Integer> lvtOrder = new HashMap<>(); // access order of lvt, lvt index -> order

	public Set<Field> fieldRead = new HashSet<>();
	public Set<Field> fieldWrite = new HashSet<>();
	public Set<Method> methodInvokes = new HashSet<>();
	public List<Object> constants = new ArrayList<>();

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

	public Instruction getAfterRead()
	{
		if (reads.isEmpty())
		{
			return null;
		}

		PacketRead last = reads.get(reads.size() - 1);
		if (last.getStore() == null)
		{
			return null;
		}

		List<Instruction> ins = method.getCode().getInstructions().getInstructions();
		int idx = ins.indexOf(last.getStore());
		if (idx == -1)
		{
			return null; // can be a read in not this function
		}

		return ins.get(idx + 1);
	}

	public int getOpcode()
	{
		return opcode;
	}

	public boolean hasPacketRead(Instruction i)
	{
		for (PacketRead pr : reads)
		{
			if (pr.getInvoke() == i)
			{
				return true;
			}
		}
		return false;
	}

	public void findReorderableReads()
	{
		for (PacketRead pr : reads)
		{
			//InstructionContext invokeCtx = pr.getInvokeCtx();
			List<Instruction> instructions = pr.getInvoke().getInstructions().getInstructions();

			// look for an lvt store immediately after
			int invokeIdx = instructions.indexOf(pr.getInvoke());
			assert invokeIdx != -1;

			Instruction next = instructions.get(invokeIdx + 1);
			if (next instanceof LVTInstruction)
			{
				LVTInstruction lvt = (LVTInstruction) next;
				if (lvt.store())
				{
					logger.info("Found lvt store {} for {}", next, pr.getInvoke());
					pr.setStore(next);
				}
			}
		}
	}
}
