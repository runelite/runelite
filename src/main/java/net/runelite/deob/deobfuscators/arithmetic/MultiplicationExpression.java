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
	
	int simplify(int start)
	{
		int count = 0;
		int result = start;

		// calculate result
		for (InstructionContext i : instructions)
		{
			PushConstantInstruction pci = (PushConstantInstruction) i.getInstruction();
			int value = (int) pci.getConstant().getObject();

			result *= value;
		}
		
	//	assert (dupmagic != null) == !dupedInstructions.isEmpty();
		if (dupmagic != null)
		{
			// mul dupmagic by result of dup ins?
			
			PushConstantInstruction pci = (PushConstantInstruction) dupmagic.getInstruction();
			int value = (int) pci.getConstant().getObject();
			
			for (InstructionContext ic : dupedInstructions)
			{
				PushConstantInstruction pci2 = (PushConstantInstruction) ic.getInstruction();
				int value2 = (int) pci2.getConstant().getObject();
				
				value *= value2;
			}
			
			Instruction newIns = pci.setConstant(new net.runelite.deob.pool.Integer(value));
			System.out.println("dupmagic");
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
				int value = (int) pci.getConstant().getObject();
				
				value *= DMath.modInverse(result);
				
				pci.setConstant(new net.runelite.deob.pool.Integer(value));
			}
			
			result = 1; // constant has been distributed, outer numbers all go to 1
		}
		
		// set result on ins
		for (InstructionContext i : instructions)
		{
			PushConstantInstruction pci = (PushConstantInstruction) i.getInstruction();
			Instruction newIns = pci.setConstant(new net.runelite.deob.pool.Integer(result));
			++count;
			assert newIns == pci;
			result = 1; // rest of the results go to 1
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
