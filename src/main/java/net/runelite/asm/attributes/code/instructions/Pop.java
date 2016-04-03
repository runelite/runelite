package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;


public class Pop extends Instruction
{
	public Pop(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	public Pop(Instructions instructions)
	{
		super(instructions, InstructionType.POP, -1);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		
		StackContext value = frame.getStack().pop();
		ins.pop(value);
		
		return ins;
	}
}
