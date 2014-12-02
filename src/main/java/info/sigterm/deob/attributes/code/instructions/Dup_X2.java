package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.Stack;

import java.io.IOException;

public class Dup_X2 extends Instruction
{
	public Dup_X2(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		Stack stack = frame.getStack();

		Object one = stack.pop();
		Object two = stack.pop();
		Object three = null;
		if (!(two instanceof Double) && !(two instanceof Long))
			three = stack.pop();

		stack.push(one);
		if (!(two instanceof Double) && !(two instanceof Long))
			stack.push(three);
		stack.push(two);
		stack.push(one);
	}
}
