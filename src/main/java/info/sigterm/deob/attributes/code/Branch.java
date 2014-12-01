package info.sigterm.deob.attributes.code;

import java.io.DataInputStream;
import java.io.IOException;

public class Branch extends Instruction
{
	short offset;

	Branch(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		offset = is.readShort();
		length += 2;
	}

}
