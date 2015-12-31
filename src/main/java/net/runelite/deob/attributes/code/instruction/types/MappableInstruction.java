package net.runelite.deob.attributes.code.instruction.types;

import net.runelite.deob.deobfuscators.rename.ParallelExecutorMapping;
import net.runelite.deob.execution.InstructionContext;

public interface MappableInstruction
{
	void map(ParallelExecutorMapping mappings, InstructionContext ctx, InstructionContext other);
}
