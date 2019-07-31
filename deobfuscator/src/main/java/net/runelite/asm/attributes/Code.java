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

package net.runelite.asm.attributes;

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Exceptions;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.signature.Signature;

public class Code
{
	private Method method;
	private int maxStack;
	private Instructions instructions;
	private final Exceptions exceptions;
	
	public Code(Method method)
	{
		this.method = method;
		
		exceptions = new Exceptions(this);
		instructions = new Instructions(this);
	}

	public Method getMethod()
	{
		return method;
	}

	public int getMaxStack()
	{
		return maxStack;
	}
	
	public void setMaxStack(int maxStack)
	{
		this.maxStack = maxStack;
	}
	
	private int getMaxLocalsFromSig()
	{
		Method m = getMethod();
		int num = m.isStatic() ? 0 : 1;
		Signature sig = m.getDescriptor();
		for (int i = 0; i < sig.size(); ++i)
			num += sig.getTypeOfArg(i).getSize();
		return num;
	}

	/**
	 * calculates the size of the lvt required for this method
	 * @return
	 */
	public int getMaxLocals()
	{
		int max = -1;
		
		for (Instruction ins : instructions.getInstructions())
		{
			if (ins instanceof LVTInstruction)
			{
				LVTInstruction lvt = (LVTInstruction) ins;

				int sizeRequired = lvt.getVariableIndex() + lvt.type().getSlots();
				if (sizeRequired > max)
				{
					max = sizeRequired;
				}
			}
		}
		
		int fromSig = getMaxLocalsFromSig();
		if (fromSig > max)
			max = fromSig;
		
		return max;
	}
	
	public Exceptions getExceptions()
	{
		return exceptions;
	}
	
	public Instructions getInstructions()
	{
		return instructions;
	}

	public List<Integer> getLineNumbers()
	{
		final List<Integer> lineNumbers = new ArrayList<>();

		for (Instruction i : instructions.getInstructions())
		{
			if (!(i instanceof Label))
			{
				continue;
			}

			Integer lineNumber = ((Label) i).getLineNumber();
			if (lineNumber == null)
			{
				continue;
			}

			lineNumbers.add(lineNumber);
		}

		lineNumbers.sort(Integer::compareTo);
		return lineNumbers;
	}
}
