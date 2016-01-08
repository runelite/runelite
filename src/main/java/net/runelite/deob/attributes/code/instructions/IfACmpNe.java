package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;

public class IfACmpNe extends If
{
	public IfACmpNe(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
}
