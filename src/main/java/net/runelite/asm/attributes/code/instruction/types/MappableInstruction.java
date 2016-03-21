package net.runelite.asm.attributes.code.instruction.types;

import net.runelite.deob.deobfuscators.rename.ParallelExecutorMapping;
import net.runelite.asm.execution.InstructionContext;

public interface MappableInstruction
{
	void map(ParallelExecutorMapping mappings, InstructionContext ctx, InstructionContext other);
	
	boolean isSame(InstructionContext thisIc, InstructionContext otherIc);
	
	boolean canMap(InstructionContext thisIc);
}
