package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Type;


public class Pop2 extends Instruction
{
	public Pop2(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();

		StackContext value = stack.pop();
		ins.pop(value);

		if (value.getType().equals(new Type(double.class.getCanonicalName())) || value.getType().equals(new Type(long.class.getCanonicalName())))
			return ins;
		
		value = stack.pop();
		ins.pop(value);

		return ins;
	}
}
