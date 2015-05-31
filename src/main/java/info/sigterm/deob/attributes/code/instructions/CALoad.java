package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.Stack;
import info.sigterm.deob.execution.StackContext;

public class CALoad extends Instruction
{
	public CALoad(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext index = stack.pop();
		StackContext array = stack.pop();
		
		ins.pop(index, array);
		
		StackContext ctx = new StackContext(ins, int.class); // zero extended to int
		stack.push(ctx);
		
		frame.addInstructionContext(ins);
	}
}
