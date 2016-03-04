package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.ReturnInstruction;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;


public class Return extends Instruction implements ReturnInstruction
{
	public Return(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	public Return(Instructions instructions)
	{
		super(instructions, InstructionType.RETURN, -1);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext object = stack.pop();
		ins.pop(object);
		
		frame.addInstructionContext(ins);
		
		frame.stop();
	}
	
	@Override
	public boolean isTerminal()
	{
		return true;
	}
}
