package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.Stack;
import info.sigterm.deob.execution.StackContext;

import java.io.IOException;

public class AThrow extends Instruction
{
	public AThrow(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		// XXX this actually clears the stack and puts only the value on, after jumping to the handler
		//StackContext value = stack.pop();
		//ins.pop(value);
		
		frame.addInstructionContext(ins);
		
		frame.throwException(null);//value.getType());
	}
	
	@Override
	public boolean isTerminal()
	{
		return true;
	}
}
