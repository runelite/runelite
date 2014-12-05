package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;

import java.io.DataInputStream;
import java.io.IOException;

public class ILoad extends Instruction
{
	private int index;

	public ILoad(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readByte();
		length += 1;
	}

	@Override
	public void execute(Frame frame)
	{
		int i = (int) frame.getVariables().get(index);
		frame.getStack().push(i);
	}
}
