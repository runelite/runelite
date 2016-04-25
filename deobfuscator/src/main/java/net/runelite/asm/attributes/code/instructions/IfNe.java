package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.MappableInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;

public class IfNe extends If0
{
	public IfNe(Instructions instructions, InstructionType type, int pc)
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
		
		if (otherIc.getInstruction() instanceof IfICmpNe || otherIc.getInstruction() instanceof IfICmpEq)
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
		else if (otherIc.getInstruction() instanceof IfEq)
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		if (other.getInstruction() instanceof IfEq || other.getInstruction() instanceof IfICmpEq)
		{
			super.mapOtherBranch(mapping, ctx, other);
		}
		else
		{
			super.map(mapping, ctx, other);
		}
	}
}
