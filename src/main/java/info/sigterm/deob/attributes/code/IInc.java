package info.sigterm.deob.attributes.code;

import java.io.DataInputStream;
import java.io.IOException;

public class IInc extends Instruction
{
	byte index;
	byte inc;

	IInc(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readByte();
		inc = is.readByte();
		length += 2;
	}

}
