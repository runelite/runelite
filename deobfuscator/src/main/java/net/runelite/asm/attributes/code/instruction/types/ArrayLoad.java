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

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;

public interface ArrayLoad extends MappableInstruction
{
	@Override
	default void map(ParallelExecutorMapping mappings, InstructionContext ctx, InstructionContext other)
	{
		StackContext index1 = ctx.getPops().get(0),
			index2 = other.getPops().get(0);

		InstructionContext ctx1 = MappingExecutorUtil.resolve(index1.getPushed(), index1),
			ctx2 = MappingExecutorUtil.resolve(index2.getPushed(), index2);

		assert ctx1.getInstruction() instanceof GetFieldInstruction;
		assert ctx2.getInstruction() instanceof GetFieldInstruction;

		GetFieldInstruction gf1 = (GetFieldInstruction) ctx1.getInstruction();
		GetFieldInstruction gf2 = (GetFieldInstruction) ctx2.getInstruction();
		mappings.map((Instruction) this, gf1.getMyField(), gf2.getMyField());
	}

	@Override
	default boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (thisIc.getInstruction().getType() != otherIc.getInstruction().getType())
		{
			return false;
		}

		StackContext index1 = thisIc.getPops().get(0),
			index2 = otherIc.getPops().get(0);

		InstructionContext ctx1 = MappingExecutorUtil.resolve(index1.getPushed(), index1),
			ctx2 = MappingExecutorUtil.resolve(index2.getPushed(), index2);

		assert ctx1.getInstruction() instanceof GetFieldInstruction;
		assert ctx2.getInstruction() instanceof GetFieldInstruction;

		GetFieldInstruction gf1 = (GetFieldInstruction) ctx1.getInstruction();
		GetFieldInstruction gf2 = (GetFieldInstruction) ctx2.getInstruction();

		return MappingExecutorUtil.isMaybeEqual(gf1.getMyField(), gf2.getMyField());
	}

	@Override
	default boolean canMap(InstructionContext thisIc)
	{
		// assume that obfuscation can't remove a load with a variable
		// index. map field access.
		StackContext index = thisIc.getPops().get(0);
		InstructionContext ctx = MappingExecutorUtil.resolve(index.getPushed(), index);
		return ctx.getInstruction() instanceof GetFieldInstruction;
	}
}
