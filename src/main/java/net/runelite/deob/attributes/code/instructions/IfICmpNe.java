package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.deobfuscators.rename.ParallelExecutorMapping;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.StackContext;

public class IfICmpNe extends If
{
	public IfICmpNe(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	private static boolean isZero(StackContext s)
	{
		if (s.getPushed().getInstruction() instanceof PushConstantInstruction)
		{
			PushConstantInstruction pc = (PushConstantInstruction) s.getPushed().getInstruction();
			Object o = pc.getConstant().getObject();
			
			if (o instanceof Integer && (int) o == 0)
				return true;
		}
		else if (s.getPushed().getInstruction() instanceof IfICmpEq)
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (super.isSame(thisIc, otherIc))
			return true;
		
		// check for other being ifne and this has a constant 0
		if (otherIc.getInstruction() instanceof IfNe || otherIc.getInstruction() instanceof IfEq)
		{
			StackContext s1 = thisIc.getPops().get(0),
				s2 = thisIc.getPops().get(1);
			
			if (isZero(s1) || isZero(s2))
				return true;
		}
		else if (otherIc.getInstruction() instanceof IfICmpEq)
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		if (other.getInstruction() instanceof IfEq)
		{
			super.mapOtherBranch(mapping, ctx, other);
		}
		else
		{
			super.map(mapping, ctx, other);
		}
	}
}
