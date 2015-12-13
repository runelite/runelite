package net.runelite.deob.attributes.code.instruction.types;

import net.runelite.deob.execution.InstructionContext;

public interface MappableInstruction
{
	void map(InstructionContext ctx, InstructionContext other);
}
