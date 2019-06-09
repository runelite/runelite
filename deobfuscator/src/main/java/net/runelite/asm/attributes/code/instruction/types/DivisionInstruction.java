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

package net.runelite.asm.attributes.code.instruction.types;

import net.runelite.asm.Field;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;

public interface DivisionInstruction extends MappableInstruction
{
	@Override
	default void map(ParallelExecutorMapping mappings, InstructionContext ctx, InstructionContext other)
	{
		StackContext s1 = ctx.getPops().get(0),
			s2 = ctx.getPops().get(1);

		StackContext o1 = other.getPops().get(0),
			o2 = other.getPops().get(1);

		InstructionContext i1 = MappingExecutorUtil.resolve(s1.getPushed(), s1);
		InstructionContext i2 = MappingExecutorUtil.resolve(s2.getPushed(), s2);

		InstructionContext io1 = MappingExecutorUtil.resolve(o1.getPushed(), o1);
		InstructionContext io2 = MappingExecutorUtil.resolve(o2.getPushed(), o2);

		if (i1.getInstruction() instanceof GetFieldInstruction && io1.getInstruction() instanceof GetFieldInstruction)
		{
			GetFieldInstruction f1 = (GetFieldInstruction) i1.getInstruction();
			GetFieldInstruction f2 = (GetFieldInstruction) io1.getInstruction();

			Field fi1 = f1.getMyField(), fi2 = f2.getMyField();

			if (fi1 != null && fi2 != null)
				mappings.map((Instruction) this, fi1, fi2);
		}

		if (i2.getInstruction() instanceof GetFieldInstruction && io2.getInstruction() instanceof GetFieldInstruction)
		{
			GetFieldInstruction f1 = (GetFieldInstruction) i2.getInstruction();
			GetFieldInstruction f2 = (GetFieldInstruction) io2.getInstruction();

			Field fi1 = f1.getMyField(), fi2 = f2.getMyField();

			if (fi1 != null && fi2 != null)
				mappings.map((Instruction) this, fi1, fi2);
		}
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
