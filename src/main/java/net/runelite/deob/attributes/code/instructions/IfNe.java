package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.MappableInstruction;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.StackContext;

public class IfNe extends If0
{
	public IfNe(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (super.isSame(thisIc, otherIc))
			return true;
		
		if (otherIc.getInstruction() instanceof IfICmpNe)
		{
			// check for one side being 0
			StackContext s1 = otherIc.getPops().get(0),
				s2 = otherIc.getPops().get(1);
			
			if (s1.getPushed().getInstruction() instanceof PushConstantInstruction)
			{
				PushConstantInstruction pci = (PushConstantInstruction) s1.getPushed().getInstruction();
				Object o = pci.getConstant().getObject();
				
				if (o.equals(0))
				{
					return true;
				}
			}
			if (s2.getPushed().getInstruction() instanceof PushConstantInstruction)
			{
				PushConstantInstruction pci = (PushConstantInstruction) s2.getPushed().getInstruction();
				Object o = pci.getConstant().getObject();
				
				if (o.equals(0))
				{
					return true;
				}
			}
		}
		
		return false;
	}
}
