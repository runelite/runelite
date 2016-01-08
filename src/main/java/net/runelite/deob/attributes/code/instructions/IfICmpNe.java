package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;

public class IfICmpNe extends If
{
	public IfICmpNe(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

}
