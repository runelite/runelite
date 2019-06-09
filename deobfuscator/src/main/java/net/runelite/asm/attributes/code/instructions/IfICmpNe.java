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
import static net.runelite.asm.attributes.code.instructions.IfICmpEq.isOne;
import static net.runelite.asm.attributes.code.instructions.IfICmpEq.isZero;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;

public class IfICmpNe extends If
{
	public IfICmpNe(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}

	public IfICmpNe(Instructions instructions, Label to)
	{
		super(instructions, InstructionType.IF_ICMPNE, to);
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
			// see comment in ificmpeq
//			Integer i1 = this.getConstantInstruction(thisIc);
//			Integer i2 = this.getConstantInstruction(otherIc);
//
//			if (i1 != null && i2 != null && (int) i1 != (int) i2)
//			{
//				return false;
//			}

			return true;
		}

		// check for other being ifne and this has a constant 0
		if (otherIc.getInstruction() instanceof IfNe || otherIc.getInstruction() instanceof IfEq)
		{
			StackContext s1 = thisIc.getPops().get(0),
				s2 = thisIc.getPops().get(1);

			if (isZero(s1) || isZero(s2) || isOne(s1) || isOne(s2))
			{
				return true;
			}
		}
		else if (otherIc.getInstruction() instanceof IfICmpEq)
		{
			return true;
		}

		return false;
	}

	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		if (other.getInstruction() instanceof IfEq)
		{
			StackContext s1 = ctx.getPops().get(0),
				s2 = ctx.getPops().get(1);

			if (isZero(s1) || isZero(s2)) // ificmpne 0 vs ifeq
			{
				super.map(mapping, ctx, other);
			}
			else if (isOne(s1) || isOne(s2)) // ificmpne 1 vs ifeq
			{
				super.mapOtherBranch(mapping, ctx, other);
			}
			else
			{
				assert false;
			}
		}
		else if (other.getInstruction() instanceof IfNe)
		{
			StackContext s1 = ctx.getPops().get(0),
				s2 = ctx.getPops().get(1);

			if (isZero(s1) || isZero(s2)) // ificmpne 0 vs ifne
			{
				super.map(mapping, ctx, other);
			}
			else if (isOne(s1) || isOne(s2)) // ificmpne 1 vs ifne
			{
				super.mapOtherBranch(mapping, ctx, other);
			}
			else
			{
				assert false;
			}
		}
		else if (other.getInstruction() instanceof IfICmpEq)
		{
			super.mapOtherBranch(mapping, ctx, other);
		}
		else
		{
			super.map(mapping, ctx, other);
		}
	}
}
