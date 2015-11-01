package net.runelite.deob.deobfuscators.arithmetic;

import java.util.ArrayList;
import java.util.List;
import net.runelite.deob.Field;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.FieldInstruction;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.execution.InstructionContext;

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
			Number value = (Number) pci.getConstant().getObject();

			result = DMath.multiply(result, value);
		}
		
		if (dupmagic != null)
		{
			// mul dupmagic by result of dup ins?
			
			PushConstantInstruction pci = (PushConstantInstruction) dupmagic.getInstruction();
			Number value = (Number) pci.getConstant().getObject();
			
			for (InstructionContext ic : dupedInstructions)
			{
				PushConstantInstruction pci2 = (PushConstantInstruction) ic.getInstruction();
				Number value2 = (Number) pci2.getConstant().getObject();
				
				value = DMath.multiply(value, value2);
			}
			
			Instruction newIns = pci.setConstant(DMath.toPool(value));
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
				Number value = (Number) pci.getConstant().getObject();
				
				value = DMath.multiply(value, DMath.modInverse(result));
				
				pci.setConstant(DMath.toPool(value));
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
			Instruction newIns = pci.setConstant(DMath.toPool(result));
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
