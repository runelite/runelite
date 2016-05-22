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

import java.io.DataInputStream;
import net.runelite.asm.ConstantPool;
import net.runelite.asm.execution.Frame;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import net.runelite.asm.Method;
import net.runelite.asm.execution.InstructionContext;

public abstract class Instruction implements Cloneable
{
	private Instructions instructions;
	private InstructionType type;

	private int pc; // offset into method this instructions resides at
	protected int length = 1; // length of this instruction

	public Instruction(Instructions instructions, InstructionType type, int pc)
	{
		this.instructions = instructions;
		this.type = type;
		this.pc = pc;
	}
	
	@Override
	public String toString()
	{
		if (this.getInstructions() != null)
		{
			Method m = this.getInstructions().getCode().getAttributes().getMethod();
			return super.toString() + " in " + m + " at pc 0x" + Integer.toHexString(this.getPc());
		}
		else
		{
			return super.toString() + " <unattached>";
		}
	}
	
	@Override
	public Instruction clone()
	{
		Instruction i;
		try
		{
			i = (Instruction) super.clone();
		}
		catch (CloneNotSupportedException ex)
		{
			throw new RuntimeException();
		}
		
		return i;
	}
	
	public void load(DataInputStream is) throws IOException
	{
	}
	
	protected void remove()
	{
		Exceptions exceptions = instructions.getCode().getExceptions();
		for (Exception e : exceptions.getExceptions())
		{
			assert this != e.getStart();
			assert this != e.getEnd();
			assert this != e.getHandler();
		}

		// XXX unreached code deob relies on being able to remove instructions that other ins jump to,
		// if those other ins are also unreached.
		//for (Instruction i : instructions.getInstructions())
		//	if (i instanceof JumpingInstruction)
		//		assert ((JumpingInstruction) i).getJumps().contains(this) == false;
	}
	
	public void replace(Instruction other)
	{
		List<Instruction> ins = instructions.getInstructions();
		
		assert this != other;
		assert ins.contains(this);
		assert !ins.contains(other);

		// XXX now that there are labels, most of this can go away?
		
		// is this really the right place for this?
		for (Instruction i : ins)
		{
			i.replace(this, other);
		}
		
		Exceptions exceptions = instructions.getCode().getExceptions();
		for (Exception e : exceptions.getExceptions())
		{
			e.replace(this, other);
		}
		
		// replace ins
		int index = ins.indexOf(this);
		ins.remove(this);
		ins.add(index, other);
		
		assert other.getInstructions() == this.instructions;
		this.instructions = null;
	}
	
	public boolean removeStack()
	{
		assert instructions != null;
		
		// update instructions which jump here to jump to the next instruction
		List<Instruction> ins = instructions.getInstructions();
		Instruction next = ins.get(ins.indexOf(this) + 1);
		assert next != null;
		
		for (Instruction i : ins)
		{
			i.replace(this, next);
		}
		
		for (Exception e : instructions.getCode().getExceptions().getExceptions())
			e.replace(this, next);
		
		this.getInstructions().remove(this); // calls remove()
		
		return true;
	}
	
	// resolve jumps
	public void resolve()
	{
	}
	
	// initialize constant pool to see if instruction u/g is required 
	public void prime()
	{
	}

	public void write(DataOutputStream out) throws IOException
	{
		out.writeByte(type.getCode());
	}

	public Instructions getInstructions()
	{
		return instructions;
	}
	
	public void setInstructions(Instructions instructions)
	{
		this.instructions = instructions;
	}
	
	public InstructionType getType()
	{
		return type;
	}
	
	protected void setType(InstructionType type)
	{
		this.type = type;
	}
	
	public ConstantPool getPool()
	{
		return instructions.getCode().getAttributes().getClassFile().getPool();
	}

	public int getPc()
	{
		return pc;
	}
	
	public void setPc(int pc)
	{
		this.pc = pc;
	}

	public int getLength()
	{
		return length;
	}

	public abstract InstructionContext execute(Frame e);
	
	/* does this terminate a block? */
	public boolean isTerminal()
	{
		return false;
	}
	
	public void replace(Instruction oldi, Instruction newi)
	{
	}
	
	// look up symbols from pool
	public void lookup()
	{
	}
	
	// instructions keep resolved method/field/class names, this updates the pool value (if the underlying resolved object changes)
	public void regeneratePool()
	{
	}
	
	public Instruction makeGeneric()
	{
		return this;
	}
	
	public Instruction makeSpecific()
	{
		return this;
	}
}
