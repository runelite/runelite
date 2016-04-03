package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.ReturnInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;


public class Return extends Instruction implements ReturnInstruction
{
	public Return(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	public Return(Instructions instructions, InstructionType type)
	{
		super(instructions, type, -1);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext object = stack.pop();
		ins.pop(object);
		
		frame.stop();

		return ins;
	}
	
	@Override
	public boolean isTerminal()
	{
		return true;
	}
}
