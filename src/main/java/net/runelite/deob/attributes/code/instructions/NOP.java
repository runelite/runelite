package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;

import java.io.IOException;

public class NOP extends Instruction
{
	public NOP(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}
	
	public NOP(Instructions instructions)
	{
		super(instructions, InstructionType.NOP, 0);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ctx = new InstructionContext(this, frame);
		frame.addInstructionContext(ctx);
	}
}
