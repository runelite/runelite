package info.sigterm.deob.attributes.code;

import java.io.DataInputStream;
import java.io.IOException;

public class SiPush extends Instruction
{
	short s;

	SiPush(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		s = is.readShort();
		length += 2;
	}

}
