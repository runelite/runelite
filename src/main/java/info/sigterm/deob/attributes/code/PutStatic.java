package info.sigterm.deob.attributes.code;

import java.io.DataInputStream;
import java.io.IOException;

public class PutStatic extends Instruction
{
	private int index;

	PutStatic(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readUnsignedShort();
		length += 2;
	}

}
