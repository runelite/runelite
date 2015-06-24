package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.Stack;
import info.sigterm.deob.execution.StackContext;

import java.io.IOException;

public class Dup extends Instruction
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
		stack.push(ctx);
		
		ins.push(ctx);
		
		ctx = new StackContext(ins, obj.getType());
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
}
