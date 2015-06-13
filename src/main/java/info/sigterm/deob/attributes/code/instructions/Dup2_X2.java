package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.Stack;
import info.sigterm.deob.execution.StackContext;
import info.sigterm.deob.execution.Type;

import java.io.IOException;

public class Dup2_X2 extends Instruction
{
	public Dup2_X2(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
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
		StackContext four = null;
		if (!three.getType().equals(new Type(double.class.getCanonicalName())) && !three.getType().equals(new Type(long.class.getCanonicalName())))
			four = stack.pop();
		
		ins.pop(one);
		if (two != null)
			ins.pop(two);
		ins.pop(three);
		if (four != null)
			ins.pop(four);
		
		if (two != null)
		{
			StackContext ctx = new StackContext(ins, two.getType());
			stack.push(ctx);
		}
		
		StackContext ctx = new StackContext(ins, one.getType());
		stack.push(one);
		
		if (four != null)
		{
			ctx = new StackContext(ins, four.getType());
			stack.push(ctx);
		}
		
		ctx = new StackContext(ins, three.getType());
		stack.push(one);
		
		if (two != null)
		{
			ctx = new StackContext(ins, two.getType());
			stack.push(ctx);
		}
		
		ctx = new StackContext(ins, one.getType());
		stack.push(one);
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public boolean removeStack()
	{
		throw new UnsupportedOperationException();
	}
}
