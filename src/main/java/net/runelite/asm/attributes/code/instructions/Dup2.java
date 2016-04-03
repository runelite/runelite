package net.runelite.asm.attributes.code.instructions;

import java.io.IOException;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Type;
import net.runelite.asm.attributes.code.instruction.types.DupInstruction;

public class Dup2 extends Instruction implements DupInstruction
{
	public Dup2(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext one = stack.pop();
		StackContext two = null;
		if (!one.getType().equals(new Type(double.class.getCanonicalName())) && !one.getType().equals(new Type(long.class.getCanonicalName())))
			two = stack.pop();
		
		ins.pop(one);
		if (two != null)
			ins.pop(two);
		
		if (two != null)
		{
			StackContext ctx = new StackContext(ins, two.getType(), two.getValue());
			stack.push(ctx);
			
			ins.push(ctx);
		}
		
		StackContext ctx = new StackContext(ins, one.getType(), one.getValue());
		stack.push(one);
		
		ins.push(ctx);

		if (two != null)
		{
			ctx = new StackContext(ins, two.getType(), two.getValue());
			stack.push(ctx);
			
			ins.push(ctx);
		}
		
		ctx = new StackContext(ins, one.getType(), one.getValue());
		stack.push(one);
		
		ins.push(ctx);
		
		return ins;
	}
	
	@Override
	public boolean removeStack()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public StackContext getOriginal(StackContext sctx)
	{
		// 2 1 -> 2 1 2 1 OR 1 -> 1 1
		InstructionContext ctx = sctx.getPushed();
		assert ctx.getPops().size() == 2 || ctx.getPops().size() == 1;
		
		assert ctx.getInstruction() == this;
		assert ctx.getPushes().contains(sctx);
		int idx = ctx.getPushes().indexOf(sctx);
		
		if (ctx.getPops().size() == 1)
		{
			return ctx.getPops().get(0);
		}
		
		switch (idx)
		{
			case 0:
			case 2:
				return ctx.getPops().get(1);
			case 1:
			case 4:
				return ctx.getPops().get(0);
			default:
				throw new IllegalStateException();
		}
	}

	@Override
	public StackContext getOtherBranch(StackContext sctx)
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
