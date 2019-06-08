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

import net.runelite.asm.Field;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.ArrayStoreInstruction;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;

public abstract class ArrayStore extends Instruction implements ArrayStoreInstruction
{
	public ArrayStore(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}

	public Field getMyField(InstructionContext thisIc)
	{
		StackContext sctx = thisIc.getPops().get(2);
		InstructionContext pushed = sctx.getPushed();

		InstructionContext r = pushed.resolve(sctx);

		if (r.getInstruction() instanceof GetFieldInstruction)
		{
			GetFieldInstruction gf = (GetFieldInstruction) r.getInstruction();
			Field f = gf.getMyField();
			return f;
		}

		return null;
	}

	@Override
	public boolean canMap(InstructionContext thisIc)
	{
		return getMyField(thisIc) != null;
	}

	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		assert ctx.getInstruction().getClass() == other.getInstruction().getClass();

		Field myField = this.getMyField(ctx),
			otherField = ((ArrayStore) other.getInstruction()).getMyField(other);

		mapping.map(this, myField, otherField);

		// map value
		StackContext object1 = ctx.getPops().get(0), // value set to.
			object2 = other.getPops().get(0);

		InstructionContext base1 = MappingExecutorUtil.resolve(object1.getPushed(), object1);
		InstructionContext base2 = MappingExecutorUtil.resolve(object2.getPushed(), object2);

		if (base1.getInstruction() instanceof GetFieldInstruction && base2.getInstruction() instanceof GetFieldInstruction)
		{
			GetFieldInstruction gf1 = (GetFieldInstruction) base1.getInstruction(),
				gf2 = (GetFieldInstruction) base2.getInstruction();

			Field f1 = gf1.getMyField(),
				f2 = gf2.getMyField();
			
			assert MappingExecutorUtil.isMaybeEqual(f1, f2);

			if (f1 != null && f2 != null)
			{
				mapping.map(this, f1, f2);
			}
		}
	}

	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (thisIc.getInstruction().getClass() != otherIc.getInstruction().getClass())
		{
			return false;
		}

		Field myField = this.getMyField(thisIc),
			otherField = ((ArrayStore) otherIc.getInstruction()).getMyField(otherIc);

		if (!MappingExecutorUtil.isMaybeEqual(myField, otherField))
		{
			return false;
		}

		StackContext object1 = thisIc.getPops().get(0), // value set to.
			object2 = otherIc.getPops().get(0);

		InstructionContext base1 = MappingExecutorUtil.resolve(object1.getPushed(), object1);
		InstructionContext base2 = MappingExecutorUtil.resolve(object2.getPushed(), object2);

		if (base1.getInstruction() instanceof GetFieldInstruction && base2.getInstruction() instanceof GetFieldInstruction)
		{
			GetFieldInstruction gf1 = (GetFieldInstruction) base1.getInstruction(),
				gf2 = (GetFieldInstruction) base2.getInstruction();

			Field f1 = gf1.getMyField(),
				f2 = gf2.getMyField();

			if (!MappingExecutorUtil.isMaybeEqual(f1, f2))
			{
				return false;
			}
		}

		return true;
	}
}
