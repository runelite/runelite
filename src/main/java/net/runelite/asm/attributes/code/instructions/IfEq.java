package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import static net.runelite.asm.attributes.code.instructions.IfICmpEq.isOne;
import static net.runelite.asm.attributes.code.instructions.IfICmpEq.isZero;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;

public class IfEq extends If0
{
	public IfEq(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	public IfEq(Instructions instructions, Instruction to)
	{
		super(instructions, InstructionType.IFEQ, to);
	}

	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (!this.isSameField(thisIc, otherIc))
			return false;
		
		if (thisIc.getInstruction().getClass() == otherIc.getInstruction().getClass())
			return true;
		
		if (otherIc.getInstruction() instanceof IfNe)
		{
			return true;
		}
		else if (otherIc.getInstruction() instanceof IfICmpEq || otherIc.getInstruction() instanceof IfICmpNe)
		{
			StackContext s1 = otherIc.getPops().get(0),
				s2 = otherIc.getPops().get(1);
			
			if (isZero(s1) || isZero(s2))
				return true;

			if (otherIc.getInstruction() instanceof IfICmpNe)
			{
				if ((isOne(s1) && s2.getType().isBoolean()) || (isOne(s2) && s1.getType().isBoolean()))
					return true;
			}
		}
	
		return false;
	}
	
	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		if (other.getInstruction() instanceof IfICmpNe)
		{
			StackContext s1 = other.getPops().get(0),
				s2 = other.getPops().get(1);
			
			if (isZero(s1) || isZero(s2))
				super.mapOtherBranch(mapping, ctx, other); // ifeq 0 vs ificmpne 0
			else if (isOne(s1) || isOne(s2))
				super.map(mapping, ctx, other); // iseq 0 vs ifne 1
			else
				assert false;
		}
		else if (other.getInstruction() instanceof IfNe)
		{
			super.mapOtherBranch(mapping, ctx, other);
		}
		else
		{
			super.map(mapping, ctx, other);
		}
	}
}
