package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.ArrayInstance;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.Stack;

public class AAStore extends Instruction
{
	public AAStore(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		Stack stack = frame.getStack();
		
		Object value = stack.pop();
		int index = (int) stack.pop();
		ArrayInstance array = (ArrayInstance) stack.pop();
		
		if (array == null)
			return;
		
		array.put(value, index);
	}
}
