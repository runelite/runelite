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
		
		StackContext ctx = new StackContext(ins, one.getType(), one.getValue());
		stack.push(ctx);
		
		ins.push(ctx);
		
		if (three != null)
		{
			ctx = new StackContext(ins, three.getType(), three.getValue());
			stack.push(ctx);
			
			ins.push(ctx);
		}
		
		ctx = new StackContext(ins, two.getType(), two.getValue());
		stack.push(ctx);
		
		ins.push(ctx);
		
		ctx = new StackContext(ins, one.getType(), one.getValue());
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public boolean removeStack()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public StackContext getOriginal(StackContext sctx)
	{
		// 3 2 1 -> 1 3 2 1
		InstructionContext ctx = sctx.getPushed();
		assert ctx.getInstruction() == this;
		
		assert ctx.getPushes().contains(sctx);
		int pushedIndex = ctx.getPushes().indexOf(sctx);
		int poppedIndex;
		
		switch (pushedIndex)
		{
			case 0:
			case 3:
				poppedIndex = 0;
				break;
			case 1:
				poppedIndex = 2;
				break;
			case 2:
				poppedIndex = 1;
			default:
				throw new IllegalStateException();
		}
		
		return ctx.getPops().get(poppedIndex);
	}

	@Override
	public StackContext getOtherBranch(StackContext sctx)
	{
		// sctx = stack pushed by this instruction, return the other branch
		InstructionContext ctx = sctx.getPushed();
		assert ctx.getInstruction() == this;
		
		assert ctx.getPushes().contains(sctx);
		int pushedIndex = ctx.getPushes().indexOf(sctx);
		
		// 3 2 1 -> 1 3 2 1
		
		if (pushedIndex == 0)
			return ctx.getPushes().get(3);
		else if (pushedIndex == 3)
			return ctx.getPushes().get(0);
		
		return null;
	}
}
