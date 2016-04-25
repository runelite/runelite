package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;


public class D2L extends Instruction
{
	public D2L(Instructions instructions, InstructionType type, int pc)
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
		
		StackContext ctx = new StackContext(ins, long.class, value.getValue().cast(long.class));
		stack.push(ctx);
		
		ins.push(ctx);
		
		return ins;
	}
}
