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
package net.runelite.deob.deobfuscators.cfg;

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.attributes.code.Instruction;

public class Block
{
	private int id = -1;
	private boolean jumptarget; // block is unconditionally jumped to

	/**
	 * blocks which jump here
	 */
	private final List<Block> prev = new ArrayList<>();

	/**
	 * blocks which this jumps to
	 */
	private final List<Block> next = new ArrayList<>();

	/**
	 * block which flows directly into this block
	 */
	private Block flowsFrom;

	/**
	 * block which this directly flows into
	 */
	private Block flowsInto;

	/**
	 * instructions in this block
	 */
	private final List<Instruction> instructions = new ArrayList<>();

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public boolean isJumptarget()
	{
		return jumptarget;
	}

	public void setJumptarget(boolean jumptarget)
	{
		this.jumptarget = jumptarget;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Block ID ").append(id).append("\n");
		if (flowsFrom != null)
		{
			sb.append(" flows from ").append(flowsFrom.id).append("\n");
		}
		for (Instruction i : instructions)
		{
			sb.append("  ").append(i.toString()).append("\n");
		}
		if (flowsInto != null)
		{
			sb.append(" flows into ").append(flowsInto.id).append("\n");
		}
		sb.append("\n");
		return sb.toString();
	}

	public void addInstruction(int idx, Instruction i)
	{
		assert !instructions.contains(i);
		instructions.add(idx, i);
	}

	public void addInstruction(Instruction i)
	{
		assert !instructions.contains(i);
		instructions.add(i);
	}

	public List<Instruction> getInstructions()
	{
		return instructions;
	}

	public void addPrev(Block block)
	{
		if (!prev.contains(block))
		{
			prev.add(block);
		}
	}

	public List<Block> getPrev()
	{
		return prev;
	}

	public void addNext(Block block)
	{
		if (!next.contains(block))
		{
			next.add(block);
		}
	}

	public List<Block> getNext()
	{
		return next;
	}

	public Block getFlowsFrom()
	{
		return flowsFrom;
	}

	public void setFlowsFrom(Block flowsFrom)
	{
		this.flowsFrom = flowsFrom;
	}

	public Block getFlowsInto()
	{
		return flowsInto;
	}

	public void setFlowsInto(Block flowsInto)
	{
		this.flowsInto = flowsInto;
	}
}
