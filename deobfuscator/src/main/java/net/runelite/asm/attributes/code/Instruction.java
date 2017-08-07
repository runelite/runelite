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
package net.runelite.asm.attributes.code;

import net.runelite.asm.Method;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import org.objectweb.asm.MethodVisitor;

public abstract class Instruction implements Cloneable
{
	private Instructions instructions;
	private InstructionType type;

	public Instruction(Instructions instructions, InstructionType type)
	{
		this.instructions = instructions;
		this.type = type;
	}

	@Override
	public String toString()
	{
		if (this.getInstructions() != null)
		{
			Method m = this.getInstructions().getCode().getMethod();
			return super.toString() + " in " + m;// + " at pc 0x" + Integer.toHexString(this.getPc());
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
			throw new RuntimeException(ex);
		}

		return i;
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
	}

	public boolean removeStack()
	{
		assert instructions != null;

		this.getInstructions().remove(this); // calls remove()

		return true;
	}

	// resolve jumps
	public void resolve()
	{
	}

	public void accept(MethodVisitor visitor)
	{
		visitor.visitInsn(this.getType().getCode());
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

	public abstract InstructionContext execute(Frame e);

	/* does this terminate a block? */
	public boolean isTerminal()
	{
		return false;
	}

	// look up symbols from pool
	public void lookup()
	{
	}

	// instructions keep resolved method/field/class names, this updates the pool value (if the underlying resolved object changes)
	public void regeneratePool()
	{
	}

	public void renameClass(String oldName, String newName)
	{
	}
}
