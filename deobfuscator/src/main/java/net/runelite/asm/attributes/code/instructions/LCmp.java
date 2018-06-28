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

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.Field;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.MappableInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Value;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;

public class LCmp extends Instruction implements MappableInstruction
{
	public LCmp(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();

		StackContext two = stack.pop();
		StackContext one = stack.pop();

		ins.pop(two, one);

		Value result = Value.UNKNOWN;
		if (!two.getValue().isUnknownOrNull() && !one.getValue().isUnknownOrNull())
		{
			long l2 = (long) two.getValue().getValue(),
				l1 = (long) one.getValue().getValue();

			if (l1 > l2)
			{
				result = new Value(1);
			}
			else if (l1 == l2)
			{
				result = new Value(0);
			}
			else if (l1 < l2)
			{
				result = new Value(-1);
			}
		}

		StackContext ctx = new StackContext(ins, Type.INT, result);
		stack.push(ctx);

		ins.push(ctx);

		return ins;
	}

	@Override
	public void map(ParallelExecutorMapping mappings, InstructionContext ctx, InstructionContext other)
	{
		List<Field> f1s = getComparedFields(ctx), f2s = getComparedFields(other);

		if (f1s == null || f2s == null || f1s.size() != f2s.size())
		{
			return;
		}

		for (int i = 0; i < f1s.size(); ++i)
		{
			Field f1 = f1s.get(i), f2 = f2s.get(i);

			mappings.map(this, f1, f2);
		}
	}

	private List<Field> getComparedFields(InstructionContext ctx)
	{
		List<Field> fields = new ArrayList<>();

		for (StackContext sctx : ctx.getPops())
		{
			InstructionContext base = MappingExecutorUtil.resolve(sctx.getPushed(), sctx);

			if (base.getInstruction() instanceof GetFieldInstruction)
			{
				GetFieldInstruction gfi = (GetFieldInstruction) base.getInstruction();

				if (gfi.getMyField() != null)
				{
					fields.add(gfi.getMyField());
				}
			}
		}

		return fields.isEmpty() ? null : fields;
	}

	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (thisIc.getInstruction().getType() != otherIc.getInstruction().getType())
		{
			return false;
		}

		List<Field> f1s = getComparedFields(thisIc),
			f2s = getComparedFields(otherIc);

		if ((f1s == null) != (f2s == null))
		{
			return false;
		}

		if (f1s == null || f2s == null)
		{
			return true;
		}

		if (f1s.size() != f2s.size())
		{
			return false;
		}

		for (int i = 0; i < f1s.size(); ++i)
		{
			Field f1 = f1s.get(i), f2 = f2s.get(i);

			if (!MappingExecutorUtil.isMaybeEqual(f1.getClassFile(), f2.getClassFile())
				|| !MappingExecutorUtil.isMaybeEqual(f1.getType(), f2.getType())
				|| f1.isStatic() != f2.isStatic())
			{
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean canMap(InstructionContext thisIc)
	{
		return true;
	}
}
