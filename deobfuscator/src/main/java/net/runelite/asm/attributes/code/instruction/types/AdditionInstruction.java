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
package net.runelite.asm.attributes.code.instruction.types;

import net.runelite.asm.Field;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;

public interface AdditionInstruction extends MappableInstruction
{
	default InstructionContext findArrayLoad(InstructionContext ic1, InstructionContext ic2)
	{
		Instruction i1 = ic1.getInstruction();
		Instruction i2 = ic2.getInstruction();

		if (i1 instanceof ArrayLoad && !(i2 instanceof ArrayLoad))
		{
			return ic1;
		}
		if (i2 instanceof ArrayLoad && !(i1 instanceof ArrayLoad))
		{
			return ic2;
		}

		return null;
	}

	@Override
	default void map(ParallelExecutorMapping mappings, InstructionContext ctx, InstructionContext other)
	{
		/* lhs/rhs of addition instructions are randomally swapped, but
		 * we still map if each side is recognizable
		 *
		 * N.B. since the lhs/rhs of nested iadds can be swapped, and
		 * the mapper maps the first that it encounters, this can certainly
		 * attempt to map the wrong instructions even when mapping the correct
		 * method, so be careful.
		 */
		StackContext ctx1 = ctx.getPops().get(0);
		StackContext ctx2 = ctx.getPops().get(1);

		StackContext other1 = other.getPops().get(0);
		StackContext other2 = other.getPops().get(1);

		InstructionContext rc1 = ctx1.getPushed().resolve(ctx1);
		InstructionContext rc2 = ctx2.getPushed().resolve(ctx2); //iaload

		InstructionContext ro1 = other1.getPushed().resolve(other1);
		InstructionContext ro2 = other2.getPushed().resolve(other2); //iaload

		// There are a couple static final arrays that are only ever read from 1 or 2 places.. and never written
		InstructionContext al1 = findArrayLoad(rc1, rc2);
		InstructionContext al2 = findArrayLoad(ro1, ro2);

		if (al1 == null || al2 == null)
		{
			return;
		}

		StackContext array1 = al1.getPops().get(1);
		StackContext array2 = al2.getPops().get(1);

		InstructionContext field1 = array1.getPushed().resolve(array1);
		InstructionContext field2 = array2.getPushed().resolve(array2);

		if (!(field1.getInstruction() instanceof GetFieldInstruction) || !(field2.getInstruction() instanceof GetFieldInstruction))
		{
			return;
		}

		GetFieldInstruction gf1 = (GetFieldInstruction) field1.getInstruction();
		GetFieldInstruction gf2 = (GetFieldInstruction) field2.getInstruction();

		Field f1 = gf1.getMyField();
		Field f2 = gf2.getMyField();

		if (f1 == null || f2 == null || !MappingExecutorUtil.isMaybeEqual(f1, f2))
		{
			return;
		}

		mappings.map((Instruction) this, f1, f2);
	}

	@Override
	default boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		return this.getClass() == otherIc.getInstruction().getClass();
	}

	@Override
	default boolean canMap(InstructionContext thisIc)
	{
		return true;
	}
}
