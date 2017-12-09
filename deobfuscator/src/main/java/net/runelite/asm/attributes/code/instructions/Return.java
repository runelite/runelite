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
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.MappableInstruction;
import net.runelite.asm.attributes.code.instruction.types.ReturnInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;

public class Return extends Instruction implements ReturnInstruction, MappableInstruction
{
	public Return(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}

	public Return(Instructions instructions)
	{
		super(instructions, InstructionType.ARETURN);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();

		StackContext object = stack.pop();
		ins.pop(object);

		frame.stop();

		return ins;
	}

	@Override
	public boolean isTerminal()
	{
		return true;
	}

	@Override
	public void map(ParallelExecutorMapping mappings, InstructionContext ctx, InstructionContext other)
	{
		StackContext s1 = ctx.getPops().get(0);
		StackContext s2 = other.getPops().get(0);

		InstructionContext i1 = MappingExecutorUtil.resolve(s1.getPushed(), s1);
		InstructionContext i2 = MappingExecutorUtil.resolve(s2.getPushed(), s2);

		if (i1.getInstruction() instanceof GetFieldInstruction && i2.getInstruction() instanceof GetFieldInstruction)
		{
			GetFieldInstruction f1 = (GetFieldInstruction) i1.getInstruction();
			GetFieldInstruction f2 = (GetFieldInstruction) i2.getInstruction();

			Field fi1 = f1.getMyField(), fi2 = f2.getMyField();

			if (fi1 != null && fi2 != null)
			{
				mappings.map(this, fi1, fi2);
			}
		}
	}

	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		// check field type etc?
		return this.getClass() == otherIc.getInstruction().getClass();
	}

	@Override
	public boolean canMap(InstructionContext thisIc)
	{
		// static methods can be inserted randomally and return things
		return thisIc.getFrame().getMethod().isStatic() == false;
	}
}
