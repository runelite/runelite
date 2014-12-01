package info.sigterm.deob.attributes.code;

import java.io.DataInputStream;
import java.io.IOException;

public class New extends Instruction
{
	private int index;

	New(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readUnsignedShort();
		length += 2;
	}

}
