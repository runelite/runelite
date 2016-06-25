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

package net.runelite.asm.attributes;

import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Exceptions;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
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
		int num = m.isStatic() ? -1 : 0;
		Signature sig = m.getDescriptor();
		for (int i = 0; i < sig.size(); ++i)
			num += sig.getTypeOfArg(i).getSlots();
		return num;
	}

	public int getMaxLocals()
	{
		int max = -1;
		
		for (Instruction ins : instructions.getInstructions())
		{
			if (ins instanceof LVTInstruction)
			{
				LVTInstruction lvt = (LVTInstruction) ins;
				
				if (lvt.getVariableIndex() > max)
					max = lvt.getVariableIndex(); // XXX if this is long or double and highest lvt, requires 2 slots
			}
		}
		
		int fromSig = getMaxLocalsFromSig();
		if (fromSig > max)
			max = fromSig;
		
		return max + 1;
	}
	
	public Exceptions getExceptions()
	{
		return exceptions;
	}
	
	public Instructions getInstructions()
	{
		return instructions;
	}
}
