package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;

import java.io.IOException;

public class VReturn extends Instruction
{
	public VReturn(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame e)
	{
		// XXX exceptions?
		e.getPath().returnFrame();
	}
	
	@Override
	public boolean isTerminal()
	{
		return true;
	}
}
