package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;

import java.io.IOException;
import net.runelite.deob.execution.Value;

public class LCmp extends Instruction
{
	public LCmp(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext two = stack.pop();
		StackContext one = stack.pop();
		
		ins.pop(two, one);
		
		Value result = Value.NULL;
		if (!two.getValue().isNull() && !one.getValue().isNull())
		{
			long l2 = (long) two.getValue().getValue(),
				l1 = (long) one.getValue().getValue();
		
			if (l1 > l2)
				result = new Value(1);
			else if (l1 == l2)
				result = new Value(0);
			else if (l1 < l2)
				result = new Value(-1);
		}
		
		StackContext ctx = new StackContext(ins, int.class, result);
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
}
