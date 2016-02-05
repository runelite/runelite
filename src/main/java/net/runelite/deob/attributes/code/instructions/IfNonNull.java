package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.deobfuscators.rename.ParallelExecutorMapping;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.StackContext;

public class IfNonNull extends If0
{
	public IfNonNull(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (super.isSame(thisIc, otherIc))
			return true;
		
		if (otherIc.getInstruction() instanceof IfACmpNe)
		{
			StackContext s1 = otherIc.getPops().get(0),
				s2 = otherIc.getPops().get(1);
			
			if (s1.getPushed().getInstruction() instanceof AConstNull)
			{
				return true;
			}
			if (s2.getPushed().getInstruction() instanceof AConstNull)
			{
				return true;
			}
		}
		else if (otherIc.getInstruction() instanceof IfNull)
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		if (other.getInstruction() instanceof IfNull)
		{
			super.mapOtherBranch(mapping, ctx, other);
		}
		else
		{
			super.map(mapping, ctx, other);
		}
	}
}
