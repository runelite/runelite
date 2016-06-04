/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.asm.attributes.code.instructions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstructionType;
import net.runelite.asm.attributes.code.instruction.types.WideInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.VariableContext;
import net.runelite.asm.execution.Variables;

public class IStore extends Instruction implements LVTInstruction, WideInstruction
{
	private int index;
	
	public IStore(Instructions instructions, int index)
	{
		super(instructions, InstructionType.ISTORE, -1);
		this.index = index;
		++length;
	}

	public IStore(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
		index = is.readByte();
		length += 1;
	}

	@Override
	public void loadWide(DataInputStream is) throws IOException
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeByte(index);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		Variables variables = frame.getVariables();
		
		StackContext value = stack.pop();
		assert value.getType().isInt();
		ins.pop(value);
		
		variables.set(index, new VariableContext(ins, value));
		
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
		return true;
	}

	@Override
	public void writeWide(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeShort(index);
	}

	@Override
	public Instruction setVariableIndex(int idx)
	{
		index = idx;
		return this;
	}

	@Override
	public Instruction makeSpecific()
	{
		switch (index)
		{
			case 0:
				return new IStore_0(this.getInstructions());
			case 1:
				return new IStore_1(this.getInstructions());
			case 2:
				return new IStore_2(this.getInstructions());
			case 3:
				return new IStore_3(this.getInstructions());
			default:
				if (index < Byte.MIN_VALUE || index > Byte.MAX_VALUE)
					return new Wide(this.getInstructions(), this);
				else
					return this;
		}
	}

	@Override
	public LVTInstructionType type()
	{
		return LVTInstructionType.INT;
	}
}
