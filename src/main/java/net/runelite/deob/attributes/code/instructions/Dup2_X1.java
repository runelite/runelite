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

public class Dup2_X1 extends Instruction implements DupInstruction
{
	public Dup2_X1(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	public Dup2_X1(Instructions instructions)
	{
		super(instructions, InstructionType.DUP2_X1, -1);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext one = stack.pop();
		StackContext two = null;
		if (!one.getType().equals(new Type(double.class.getCanonicalName())) && !one.getType().equals(new Type(long.class.getCanonicalName())))
			two = stack.pop();
		StackContext three = stack.pop();
		
		ins.pop(one);
		if (two != null)
			ins.pop(two);
		ins.pop(three);
		
		if (two != null)
		{
			StackContext ctx = new StackContext(ins, two.getType());
			stack.push(ctx);
			
			ins.push(ctx);
		}
		
		StackContext ctx = new StackContext(ins, one.getType());
		stack.push(ctx);
		
		ins.push(ctx);
		
		ctx = new StackContext(ins, three.getType());
		stack.push(ctx);
		
		ins.push(ctx);
		
		if (two != null)
		{
			ctx = new StackContext(ins, two.getType());
			stack.push(ctx);
			
			ins.push(ctx);
		}
		
		ctx = new StackContext(ins, one.getType());
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
		InstructionContext ctx = sctx.getPushed();
		
		assert ctx.getInstruction() == this;
		assert ctx.getPushes().contains(sctx);
		int idx = ctx.getPushes().indexOf(sctx);
		
		// 2 1 0 -> 1 0 2 1 0 OR 1 0 -> 0 1 0
		
		assert ctx.getPushes().size() == 5 || ctx.getPushes().size() == 3;
		
		int orig;
		
		if (ctx.getPushes().size() == 5)
		{
			switch (idx)
			{
				case 0:
					orig = 1;
					break;
				case 1:
					orig = 0;
					break;
				case 2:
					orig = 2;
					break;
				case 3:
					orig = 1;
					break;
				case 4:
					orig = 0;
					break;
				default:
					throw new IllegalStateException();
			}
		}
		else if (ctx.getPushes().size() == 3)
		{
			switch (idx)
			{
				case 0:
					orig = 0;
					break;
				case 1:
					orig = 1;
					break;
				case 2:
					orig = 0;
					break;
				default:
					throw new IllegalStateException();
			}
		}
		else
			throw new IllegalStateException();
				
		return ctx.getPushes().get(orig);
	}

	@Override
	public StackContext getOtherBranch(StackContext sctx)
	{
		InstructionContext ctx = sctx.getPushed();
		assert ctx.getInstruction() == this;
		
		assert ctx.getPushes().contains(sctx);
		int idx = ctx.getPushes().indexOf(sctx);
		
		// 2 1 0 -> 1 0 2 1 0 OR 1 0 -> 0 1 0
		
		int other;
		
		if (ctx.getPushes().size() == 5)
		{
			switch (idx)
			{
				case 0:
					other = 3;
					break;
				case 1:
					other = 4;
					break;
				case 3:
					other = 0;
					break;
				case 4:
					other = 1;
					break;
				default:
					return null;
			}
		}
		else if (ctx.getPushes().size() == 3)
		{
			switch (idx)
			{
				case 0:
					other = 2;
					break;
				case 2:
					other = 0;
					break;
				default:
					return null;
			}
		}
		else
			throw new IllegalStateException();
				
		return ctx.getPushes().get(other);
	}
}
