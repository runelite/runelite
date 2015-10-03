package net.runelite.deob.attributes.code.instructions;

import java.io.IOException;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.attributes.code.instruction.types.DupInstruction;

public class Dup_X1 extends Instruction implements DupInstruction
{
	public Dup_X1(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	public Dup_X1(Instructions instructions)
	{
		super(instructions, InstructionType.DUP_X1, -1);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext one = stack.pop();
		StackContext two = stack.pop();
		
		ins.pop(one, two);
		
		StackContext ctx = new StackContext(ins, one.getType());
		ctx.encryption = one.encryption;
		stack.push(ctx);
		
		ins.push(ctx);
		
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

	@Override
	public StackContext getOriginal(StackContext sctx)
	{
		// ctx = stack pushed by this instruction, return stack popped by this instruction
		InstructionContext ctx = sctx.getPushed();
		assert ctx.getInstruction() == this;
		
		assert ctx.getPushes().contains(sctx);
		int pushedIndex = ctx.getPushes().indexOf(sctx);
		int poppedIndex;
		
		// 2 1 -> 1 2 1
		// index 0 is 0, index 1 is 1, index 2 is 2
		
		switch (pushedIndex)
		{
			case 0:
			case 2:
				poppedIndex = 0;
				break;
			case 1:
				poppedIndex = 1;
				break;
			default:
				throw new IllegalStateException();
		}
		
		// get popped ctx
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
		
		// 2 1 -> 1 2 1
		
		// if pushed index is 0 or 2, return other, if 1 there is no other side
		assert pushedIndex >= 0 && pushedIndex <= 2;
		
		if (pushedIndex == 0)
			return ctx.getPushes().get(2);
		else if (pushedIndex == 2)
			return ctx.getPushes().get(0);
		
		return null;
	}
}
