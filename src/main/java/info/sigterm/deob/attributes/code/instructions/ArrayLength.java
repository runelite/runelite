package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.ArrayInstance;
import info.sigterm.deob.execution.Frame;

import java.io.IOException;

public class ArrayLength extends Instruction
{
	public ArrayLength(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		ArrayInstance array = (ArrayInstance) frame.getStack().pop();
		frame.getStack().push(this, array.getLength());
	}
}
