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

import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import static net.runelite.asm.attributes.code.instructions.IfICmpEq.isOne;
import static net.runelite.asm.attributes.code.instructions.IfICmpEq.isZero;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;

public class IfEq extends If0
{
	public IfEq(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}
	
	public IfEq(Instructions instructions, Label to)
	{
		super(instructions, InstructionType.IFEQ, to);
	}

	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (!this.isSameField(thisIc, otherIc))
			return false;
		
		if (thisIc.getInstruction().getClass() == otherIc.getInstruction().getClass())
			return true;
		
		if (otherIc.getInstruction() instanceof IfNe)
		{
			return true;
		}
		else if (otherIc.getInstruction() instanceof IfICmpEq || otherIc.getInstruction() instanceof IfICmpNe)
		{
			StackContext s1 = otherIc.getPops().get(0),
				s2 = otherIc.getPops().get(1);
			
			if (isZero(s1) || isZero(s2) || isOne(s1) || isOne(s2))
				return true;
		}
	
		return false;
	}
	
	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		if (other.getInstruction() instanceof IfICmpEq)
		{
			StackContext s1 = other.getPops().get(0),
				s2 = other.getPops().get(1);

			if (isZero(s1) || isZero(s2)) // iseq vs ificmpeq 0
				super.map(mapping, ctx, other);
			else if (isOne(s1) || isOne(s2)) // ifeq vs isicmpeq 1
				super.mapOtherBranch(mapping, ctx, other);
			else
				assert false;
		}
		else if (other.getInstruction() instanceof IfICmpNe)
		{
			StackContext s1 = other.getPops().get(0),
				s2 = other.getPops().get(1);
			
			if (isZero(s1) || isZero(s2))
				super.mapOtherBranch(mapping, ctx, other); // ifeq 0 vs ificmpne 0
			else if (isOne(s1) || isOne(s2))
				super.map(mapping, ctx, other); // ifeq 0 vs ificmpeq 1
			else
				assert false;
		}
		else if (other.getInstruction() instanceof IfNe)
		{
			super.mapOtherBranch(mapping, ctx, other);
		}
		else
		{
			super.map(mapping, ctx, other);
		}
	}
}
