package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.Stack;

import java.io.IOException;

public class FCmpL extends Instruction
{
	public FCmpL(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		Stack stack = frame.getStack();

		Float one = (Float) stack.pop();
		Float two = (Float) stack.pop();

		if (one.isNaN() || two.isNaN())
			stack.push(-1);
		else if (one > two)
			stack.push(1);
		else if (one < two)
			stack.push(-1);
		else
			stack.push(0);
	}
}
