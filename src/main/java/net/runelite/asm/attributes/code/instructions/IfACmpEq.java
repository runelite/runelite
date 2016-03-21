package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.deob.deobfuscators.rename.ParallelExecutorMapping;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;

public class IfACmpEq extends If
{
	public IfACmpEq(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (!this.isSameField(thisIc, otherIc))
			return false;
		
		if (thisIc.getInstruction().getClass() == otherIc.getInstruction().getClass())
			return true;
		
		if (otherIc.getInstruction() instanceof IfNull || otherIc.getInstruction() instanceof IfNonNull)
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
		else if (otherIc.getInstruction() instanceof IfACmpNe)
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		if (other.getInstruction() instanceof IfACmpNe || other.getInstruction() instanceof IfNonNull)
		{
			super.mapOtherBranch(mapping, ctx, other);
		}
		else
		{
			super.map(mapping, ctx, other);
		}
	}
}
