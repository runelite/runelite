package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;


public class NOP extends Instruction
{
	public NOP(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	public NOP(Instructions instructions)
	{
		super(instructions, InstructionType.NOP, 0);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		return new InstructionContext(this, frame);
	}
}
