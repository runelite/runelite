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
import java.lang.reflect.Constructor;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.WideInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;

public class Wide extends Instruction implements LVTInstruction
{
	private Instruction ins;

	public Wide(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	@Override
	public Instruction clone()
	{
		Wide wide = (Wide) super.clone();
		wide.ins = ins.clone();
		return wide;
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
		byte opcode = is.readByte(); // this byte is already in the length of the new instruction (length is initialized to 1)
		InstructionType op = InstructionType.findInstructionFromCode(opcode);
		
		try
		{
			Constructor<? extends Instruction> con = op.getInstructionClass().getConstructor(Instructions.class, InstructionType.class, Instruction.class, int.class);
			ins = con.newInstance(this.getInstructions(), op, this, this.getPc());
			ins.load(is);
			length += ins.getLength();
		}
		catch (Exception ex)
		{
			throw new IOException(ex);
		}
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		
		WideInstruction w = (WideInstruction) ins;
		w.writeWide(out);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		return ins.execute(frame);
	}

	@Override
	public void replace(Instruction oldi, Instruction newi)
	{
		assert oldi != ins;
	}

	@Override
	public int getVariableIndex()
	{
		return ((LVTInstruction) ins).getVariableIndex();
	}

	@Override
	public Instruction setVariableIndex(int idx)
	{
		ins = ((LVTInstruction) ins).setVariableIndex(idx);
		return this;
	}

	@Override
	public boolean store()
	{
		return ((LVTInstruction) ins).store();
	}
}
