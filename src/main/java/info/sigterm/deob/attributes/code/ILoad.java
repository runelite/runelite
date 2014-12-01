package info.sigterm.deob.attributes.code;

import java.io.DataInputStream;
import java.io.IOException;

public class ILoad extends Instruction
{
	int index;

	ILoad(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readByte();
		length += 1;
	}

}
