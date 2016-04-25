package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;

public class AAStore extends ArrayStore
{
	public AAStore(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext value = stack.pop();
		StackContext index = stack.pop();
		StackContext array = stack.pop();
		
		ins.pop(value, index, array);
		
		array.getValue().arraySet(index.getValue(), value.getValue());
		
		return ins;
	}

}
