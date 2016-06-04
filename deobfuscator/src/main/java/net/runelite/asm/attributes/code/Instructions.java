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

package net.runelite.asm.attributes.code;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.attributes.Code;

public class Instructions
{
	private Code code;
	private List<Instruction> instructions = new ArrayList<>();

	public Instructions(Code code)
	{
		this.code = code;
	}
	
	public void load(DataInputStream is) throws IOException
	{
		int length = is.readInt();

		int pc;
		for (pc = 0; pc < length;)
		{
			byte opcode = is.readByte();

			InstructionType type = InstructionType.findInstructionFromCode(opcode);

			try
			{
				Constructor<? extends Instruction> con = type.getInstructionClass().getConstructor(Instructions.class, InstructionType.class, int.class);
				Instruction ins = con.newInstance(this, type, pc);
				ins.load(is);
				
				Instruction genericIns = ins.makeGeneric();
				if (genericIns != ins)
				{
					genericIns.setPc(ins.getPc());
				}

				instructions.add(genericIns);

				int len = ins.getLength();
				pc += len;
			}
			catch (java.lang.Exception ex)
			{
				throw new IOException(ex);
			}
		}

		assert pc == length;
		
		for (Instruction i : new ArrayList<>(instructions))
			i.resolve();
	}

	public Label createLabelFor(Instruction target)
	{
		assert target.getInstructions() == this;
		assert instructions.contains(target);

		if (target instanceof Label)
		{
			return (Label) target;
		}

		int i = instructions.indexOf(target);
		if (i > 0)
		{
			Instruction before = instructions.get(i - 1);

			if (before instanceof Label)
			{
				return (Label) before;
			}
		}

		Label label = new Label(this);
		instructions.add(i, label);
		return label;
	}

	public List<Instruction> getInstructions()
	{
		return instructions;
	}
	
	public void addInstruction(Instruction i)
	{
		instructions.add(i);
	}
	
	public void remove(Instruction ins)
	{
		assert ins.getInstructions() == this;
		ins.remove();
		instructions.remove(ins);
		ins.setInstructions(null);
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		this.regeneratePool();
		
		// translate instructions to specific
		for (Instruction i : new ArrayList<>(instructions))
		{
			Instruction specific = i.makeSpecific();
			if (i != specific)
			{
				replace(i, specific);
			}
		}
		
		// generate pool indexes
		for (Instruction i : new ArrayList<>(instructions))
			i.prime();
		
		// rebuild pc
		int pc = 0;
		for (Instruction i : instructions)
		{
			i.setPc(pc);
			pc += i.getLength();
		}
		
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream o = new DataOutputStream(b);
		for (Instruction i : instructions)
		{
			assert o.size() == i.getPc();
			i.write(o);
			assert o.size() == i.getPc() + i.getLength();
		}
		byte[] ba = b.toByteArray();
		out.writeInt(ba.length);
		out.write(ba);
	}
	
	public Code getCode()
	{
		return code;
	}
	
	public Instruction findInstruction(int pc)
	{
		for (Instruction i : instructions)
			if (i.getPc() == pc)
				return i;
		return null;
	}
	
	public void lookup()
	{
		for (Instruction i : instructions)
			i.lookup();
	}
	
	public void regeneratePool()
	{
		for (Instruction i : instructions)
			i.regeneratePool();
	}

	public void replace(Instruction oldi, Instruction newi)
	{
		assert oldi != newi;
		
		assert oldi.getInstructions() == this;
		assert newi.getInstructions() == this;
		
		assert instructions.contains(oldi);
		assert !instructions.contains(newi);
		
		int i = instructions.indexOf(oldi);
		instructions.remove(oldi);
		oldi.setInstructions(null);
		instructions.add(i, newi);
	}
}
