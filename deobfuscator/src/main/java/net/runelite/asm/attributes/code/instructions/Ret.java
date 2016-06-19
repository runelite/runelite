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
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstructionType;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.VariableContext;
import net.runelite.asm.execution.Variables;

public class Ret extends Instruction implements LVTInstruction
{
	private int index;
	
	public Ret(Instructions instructions, int index)
	{
		super(instructions, InstructionType.RET, 0);
		this.index = index;
		++length;
	}

	public Ret(Instructions instructions, InstructionType type, int pc)
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
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeByte(index);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Variables var = frame.getVariables();
		
		VariableContext vctx = var.get(index);
		ins.read(vctx);

		/** Read offset from local */
		int offset = (int) vctx.getValue().as(Integer.class);
		
		System.out.println("RET: " + this.getPc() + ", Offset: " + offset);
		
		/** Get instruction follow the JSR */
		Instruction i = this.getInstructions().findInstruction(offset);
		
		/** Get the label before the instruction in the List */
		Label l = (Label) this.getInstructions().getInstructions().get(this.getInstructions().getInstructions().indexOf(i) - 1);
		
		frame.jump(ins, l);
		
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
		return false;
	}

	@Override
	public Instruction setVariableIndex(int idx)
	{
		index = idx;
		return this;
	}

	@Override
	public LVTInstructionType type()
	{
		return LVTInstructionType.OBJECT;
	}
}
