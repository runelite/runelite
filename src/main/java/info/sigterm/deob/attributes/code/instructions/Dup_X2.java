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

public class Dup_X2 extends Instruction
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
		stack.push(ctx);
		
		ins.push(ctx);
		
		if (three != null)
		{
			ctx = new StackContext(ins, three.getType());
			stack.push(ctx);
			
			ins.push(ctx);
		}
		
		ctx = new StackContext(ins, two.getType());
		stack.push(ctx);
		
		ins.push(ctx);
		
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
}
