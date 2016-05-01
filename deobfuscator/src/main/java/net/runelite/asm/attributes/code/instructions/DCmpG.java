package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;

import net.runelite.asm.execution.Value;

public class DCmpG extends Instruction
{
	public DCmpG(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext two = stack.pop();
		StackContext one = stack.pop();
		
		ins.pop(two, one);
		
		Value result = Value.UNKNOWN;
		if (!two.getValue().isUnknownOrNull() && !one.getValue().isUnknownOrNull())
		{
			double d2 = (double) two.getValue().getValue(),
				d1 = (double) one.getValue().getValue();
			
			if (d1 > d2)
				result = new Value(1);
			else if (d1 == d2)
				result = new Value(0);
			else if (d1 < d2)
				result = new Value(-1);
		}
		
		StackContext ctx = new StackContext(ins, int.class, result);
		stack.push(ctx);
		
		ins.push(ctx);
		
		return ins;
	}
}
