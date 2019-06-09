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

package net.runelite.deob.deobfuscators.arithmetic;

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.Field;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.FieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.execution.InstructionContext;

public class MultiplicationExpression
{
	List<InstructionContext> instructions = new ArrayList<>(), // push constant instructions that are being multiplied
		dupedInstructions = new ArrayList<>(),
		fieldInstructions = new ArrayList<>();
	List<MultiplicationExpression> subexpressions = new ArrayList<>(); // for distributing, each subexpr is * by this
	InstructionContext dupmagic; // inverse of what is distributed to subexpressions gets set here
	
	int simplify(Number start)
	{
		int count = 0;
		Number result = start;

		// calculate result
		for (InstructionContext i : instructions)
		{
			PushConstantInstruction pci = (PushConstantInstruction) i.getInstruction();
			Number value = (Number) pci.getConstant();

			result = DMath.multiply(result, value);
		}
		
		if (dupmagic != null)
		{
			// mul dupmagic by result of dup ins?
			
			PushConstantInstruction pci = (PushConstantInstruction) dupmagic.getInstruction();
			Number value = (Number) pci.getConstant();
			
			for (InstructionContext ic : dupedInstructions)
			{
				PushConstantInstruction pci2 = (PushConstantInstruction) ic.getInstruction();
				Number value2 = (Number) pci2.getConstant();
				
				value = DMath.multiply(value, value2);
			}
			
			Instruction newIns = pci.setConstant(value);
			assert newIns == (Instruction) pci;
		}
		
		// multiply subexpressions by result
		if (!subexpressions.isEmpty())
		{
			for (MultiplicationExpression me : subexpressions)
			{
				count += me.simplify(result);
			}
			
			if (dupmagic != null)
			{
				PushConstantInstruction pci = (PushConstantInstruction) dupmagic.getInstruction();
				Number value = (Number) pci.getConstant();
				
				value = DMath.multiply(value, DMath.modInverse(result));
				
				pci.setConstant(value);
			}
			
			// constant has been distributed, outer numbers all go to 1
			if (result instanceof Long)
				result = 1L;
			else
				result = 1;
		}
		
		// set result on ins
		for (InstructionContext i : instructions)
		{
			PushConstantInstruction pci = (PushConstantInstruction) i.getInstruction();
			Instruction newIns = pci.setConstant(result);
			++count;
			assert newIns == pci;
			// rest of the results go to 1
			if (result instanceof Long)
				result = 1L;
			else
				result = 1;
		}
		
		return count;
	}
	
	public boolean hasFieldOtherThan(Field field)
	{
		for (InstructionContext i : this.fieldInstructions)
		{
			FieldInstruction fi = (FieldInstruction) i.getInstruction();
			if (fi.getMyField() != null && fi.getMyField() != field)
				return true;
		}
		
		for (MultiplicationExpression ex : this.subexpressions)
			if (ex.hasFieldOtherThan(field))
				return true;
		
		return false;
	}
}
