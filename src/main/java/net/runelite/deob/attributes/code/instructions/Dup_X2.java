package net.runelite.deob.attributes.code.instructions;

import java.io.IOException;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.execution.Type;
import net.runelite.deob.attributes.code.instruction.types.DupInstruction;

public class Dup_X2 extends Instruction implements DupInstruction
{
	public Dup_X2(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext one = stack.pop();
		StackContext two = stack.pop();
		StackContext three = null;
		if (!two.getType().equals(new Type(double.class.getCanonicalName())) && !two.getType().equals(new Type(long.class.getCanonicalName())))
			three = stack.pop();
		
		ins.pop(one, two);
		if (three != null)
			ins.pop(three);
		
		StackContext ctx = new StackContext(ins, one.getType());
		ctx.encryption = one.encryption;
		stack.push(ctx);
		
		ins.push(ctx);
		
		if (three != null)
		{
			ctx = new StackContext(ins, three.getType());
			ctx.encryption = three.encryption;
			stack.push(ctx);
			
			ins.push(ctx);
		}
		
		ctx = new StackContext(ins, two.getType());
		ctx.encryption = two.encryption;
		stack.push(ctx);
		
		ins.push(ctx);
		
		ctx = new StackContext(ins, one.getType());
		ctx.encryption = one.encryption;
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public boolean removeStack()
	{
		throw new UnsupportedOperationException();
	}
}
