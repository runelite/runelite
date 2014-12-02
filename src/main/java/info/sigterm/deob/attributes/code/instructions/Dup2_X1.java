package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.Stack;

import java.io.IOException;

public class Dup2_X1 extends Instruction
{
	public Dup2_X1(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		Stack stack = frame.getStack();

		Object one = stack.pop();
		Object two = null;
		if (!(one instanceof Double) && !(one instanceof Long))
			two = stack.pop();
		Object three = stack.pop();

		if (!(one instanceof Double) && !(one instanceof Long))
			stack.push(two);
		stack.push(one);

		stack.push(three);

		if (!(one instanceof Double) && !(one instanceof Long))
			stack.push(two);
		stack.push(one);
	}
}
