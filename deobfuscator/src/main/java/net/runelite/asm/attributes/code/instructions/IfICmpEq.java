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
import net.runelite.asm.attributes.code.instruction.types.ComparisonInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;

public class IfICmpEq extends If
{
	public IfICmpEq(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}

	public IfICmpEq(Instructions instructions, Label to)
	{
		super(instructions, InstructionType.IF_ICMPEQ, to);
	}

	static boolean is(StackContext s, int val)
	{
		if (s.getPushed().getInstruction() instanceof PushConstantInstruction)
		{
			PushConstantInstruction pc = (PushConstantInstruction) s.getPushed().getInstruction();
			Object o = pc.getConstant();

			if (o instanceof Integer && (int) o == val)
			{
				return true;
			}
		}

		return false;
	}

	static boolean isZero(StackContext s)
	{
		return is(s, 0);
	}

	static boolean isOne(StackContext s)
	{
		return is(s, 1);
	}

	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (!(otherIc.getInstruction() instanceof ComparisonInstruction))
		{
			return false;
		}

		if (!this.isSameField(thisIc, otherIc))
		{
			return false;
		}

		if (thisIc.getInstruction().getClass() == otherIc.getInstruction().getClass())
		{
			//XXX commented due to packet handlers no longer doing icmps
//			Integer i1 = this.getConstantInstruction(thisIc);
//			Integer i2 = this.getConstantInstruction(otherIc);
//
//			// this is to help against the scrambling of the icmps. in every case
//			// except for the packet handler ids the constant is the same.
//			// XX it would be better to have the mapper step over ifs and proceed to
//			// the next one instead of halting
//			if (i1 != null && i2 != null && (int) i1 != (int) i2)
//			{
//				return false;
//			}
			return true;
		}

		// check for other being ifeq and this has a constant 0
		if (otherIc.getInstruction() instanceof IfEq || otherIc.getInstruction() instanceof IfNe)
		{
			StackContext s1 = thisIc.getPops().get(0),
				s2 = thisIc.getPops().get(1);

			if (isZero(s1) || isZero(s2) || isOne(s1) || isOne(s2))
			{
				return true;
			}
		}
		else if (otherIc.getInstruction() instanceof IfICmpNe)
		{
			return true;
		}

		return false;
	}

	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		if (other.getInstruction() instanceof IfNe || other.getInstruction() instanceof IfICmpNe)
		{
			super.mapOtherBranch(mapping, ctx, other);
		}
		else
		{
			super.map(mapping, ctx, other);
		}
	}
}
