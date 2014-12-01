package info.sigterm.deob.attributes.code;

import java.io.DataInputStream;
import java.io.IOException;

public class BiPush extends Instruction
{
	byte b;

	BiPush(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		b = is.readByte();
		length += 1;
	}

}
