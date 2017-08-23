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

import net.runelite.asm.Type;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstructionType;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Value;
import net.runelite.asm.execution.VariableContext;
import net.runelite.asm.execution.Variables;
import org.objectweb.asm.MethodVisitor;

public class IInc extends Instruction implements LVTInstruction
{
	private short index;
	private short inc;

	public IInc(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}

	@Override
	public void accept(MethodVisitor visitor)
	{
		visitor.visitIincInsn(index, inc);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Variables var = frame.getVariables();
		
		VariableContext vctx = var.get(index);
		assert vctx.getType().isStackInt();
		ins.read(vctx);
		
		Value value = vctx.getValue();
		if (!vctx.getValue().isUnknownOrNull())
		{
			int i = (int) vctx.getValue().getValue();
			i += inc;
			value = new Value(i);
		}
		
		vctx = new VariableContext(ins, Type.INT, value);
		var.set(index, vctx);
		
		return ins;
	}

	@Override
	public int getVariableIndex()
	{
		return index;
	}

	@Override
	public boolean store()
	{
		return false; // This is a get first
	}

	@Override
	public Instruction setVariableIndex(int idx)
	{
		index = (short) idx;
		return this;
	}

	public void setIncrement(int inc)
	{
		this.inc = (short) inc;
	}

	@Override
	public LVTInstructionType type()
	{
		return LVTInstructionType.INT;
	}
}
