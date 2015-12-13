package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.execution.InstructionContext;

public class IfCmpEq extends If
{
	public IfCmpEq(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
}
