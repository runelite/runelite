package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.execution.Type;

import java.io.IOException;
import java.util.List;

public class AThrow extends Instruction
{
	public AThrow(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		// get exception
		StackContext exception = stack.pop();
		ins.pop(exception);
		
		frame.addInstructionContext(ins);
		
		frame.stop();
	}
	
	@Override
	public boolean isTerminal()
	{
		return true;
	}
}
