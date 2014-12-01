package info.sigterm.deob.attributes.code;

import java.io.DataInputStream;
import java.io.IOException;

public class ALoad extends Instruction
{
	int index;

	ALoad(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readByte();
		length += 1;
	}

}
