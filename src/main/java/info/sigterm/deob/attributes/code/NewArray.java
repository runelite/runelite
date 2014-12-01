package info.sigterm.deob.attributes.code;

import java.io.DataInputStream;
import java.io.IOException;

public class NewArray extends Instruction
{
	private int type;

	NewArray(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		this.type = is.readUnsignedByte();
		length += 1;
	}

}
