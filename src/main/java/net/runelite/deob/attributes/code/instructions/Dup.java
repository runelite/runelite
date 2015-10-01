package net.runelite.deob.attributes.code.instructions;

import java.io.IOException;
import java.util.List;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.attributes.code.instruction.types.DupInstruction;

public class Dup extends Instruction implements DupInstruction
{
	public Dup(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext obj = stack.pop();
		ins.pop(obj);
		
		StackContext ctx = new StackContext(ins, obj.getType());
		ctx.encryption = obj.encryption;
		stack.push(ctx);
		
		ins.push(ctx);
		
		ctx = new StackContext(ins, obj.getType());
		ctx.encryption = obj.encryption;
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public boolean removeStack()
	{
		// removing something from the stack this pushed at index 'idx'
		// idx = 0 is top of the stack, goes up.
		//
		// the stack is relative to post-execute of this instruction
		
		// for dup, to remove one of the things pushed by it you simply
		// remove the dup instruction
		super.removeStack();
		// do not continue as the other branch still uses what we left
		// usually this is for new dup invokespecial and we end up with
		// an unused new/invokesepcial
		return false;
	}

	@Override
	public StackContext getOriginal(StackContext sctx)
	{
		// ctx = stack pushed by this instruction, return stack popped by this instruction
		InstructionContext ctx = sctx.getPushed();
		assert ctx.getInstruction() == this;
		assert ctx.getPushes().contains(sctx);
		return ctx.getPops().get(0);
	}

	@Override
	public StackContext getOtherBranch(StackContext sctx)
	{
		InstructionContext ctx = sctx.getPushed();
		assert ctx.getInstruction() == this;
		
		List<StackContext> pushes = ctx.getPushes();
		assert pushes.contains(sctx);
		
		int idx = pushes.indexOf(sctx);
		assert idx == 0 || idx == 1;
		
		return pushes.get(~idx & 1);
	}
}
