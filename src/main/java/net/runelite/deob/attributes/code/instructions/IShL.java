package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.execution.Value;

public class IShL extends Instruction
{
	public IShL(Instructions instructions, InstructionType type, int pc)
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
			int i2 = (int) two.getValue().getValue(),
				i1 = (int) one.getValue().getValue();
			
			result = new Value(i1 << i2);
		}
		
		StackContext ctx = new StackContext(ins, int.class, result);
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
}
