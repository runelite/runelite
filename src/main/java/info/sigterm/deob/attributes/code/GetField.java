package info.sigterm.deob.attributes.code;

import java.io.DataInputStream;
import java.io.IOException;

public class GetField extends Instruction
{
	private int index;

	GetField(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readUnsignedShort();
		length += 2;
	}

}
