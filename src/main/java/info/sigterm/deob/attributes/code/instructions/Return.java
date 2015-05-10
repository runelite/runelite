package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;

import java.io.IOException;

public class Return extends Instruction
{
	public Return(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame e)
	{
		Object ret = e.getStack().pop();
		e.getPath().returnFrame(this, ret);
	}
	
	@Override
	public boolean isTerminal()
	{
		return true;
	}
}
