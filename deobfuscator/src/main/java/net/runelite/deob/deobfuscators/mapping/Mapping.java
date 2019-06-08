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
package net.runelite.deob.deobfuscators.mapping;

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.attributes.code.Instruction;

public class Mapping
{
	private Object from;
	private Object object;
	private int count;
	private List<Instruction> ins = new ArrayList<>();
	public boolean wasExecuted;
	public int weight; // weight of mapping, based on same instruction count

	public Mapping(Object from, Object object)
	{
		this.from = from;
		this.object = object;
	}

	@Override
	public String toString()
	{
		return "Mapping{" + "from=" + from + ", object=" + object + ", count=" + count + '}';
	}

	public Object getFrom()
	{
		return from;
	}

	public Object getObject()
	{
		return object;
	}

	public int getCount()
	{
		return count;
	}

	public void inc()
	{
		++count;
	}

	public void merge(Mapping other)
	{
		assert object == other.object;
		count += other.count;
		for (Instruction i : other.ins)
		{
			addInstruction(i);
		}
		wasExecuted |= other.wasExecuted;
		weight = Math.max(weight, other.weight);
	}

	public void addInstruction(Instruction i)
	{
		if (!ins.contains(i))
		{
			ins.add(i);
		}
	}

	public void setWeight(int w)
	{
		if (w > weight)
		{
			weight = w;
		}
	}
}
