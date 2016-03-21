package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.ReturnInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;


public class VReturn extends Instruction implements ReturnInstruction
{
	public VReturn(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	public VReturn(Instructions instructions)
	{
		super(instructions, InstructionType.RETURN, -1);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		frame.addInstructionContext(ins);
		
		frame.stop();
	}
	
	@Override
	public boolean isTerminal()
	{
		return true;
	}
}
