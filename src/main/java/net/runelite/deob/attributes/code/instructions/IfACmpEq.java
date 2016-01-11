package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.StackContext;

public class IfACmpEq extends If
{
	public IfACmpEq(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (super.isSame(thisIc, otherIc))
			return true;
		
		if (otherIc.getInstruction() instanceof IfNull)
		{
			StackContext s1 = thisIc.getPops().get(0),
				s2 = thisIc.getPops().get(1);
			
			if (s1.getPushed().getInstruction() instanceof AConstNull)
			{
				return true;
			}
			if (s2.getPushed().getInstruction() instanceof AConstNull)
			{
				return true;
			}
		}
		
		return false;
	}
}
