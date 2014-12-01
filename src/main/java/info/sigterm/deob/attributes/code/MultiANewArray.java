package info.sigterm.deob.attributes.code;

import java.io.DataInputStream;
import java.io.IOException;

public class MultiANewArray extends Instruction
{
	private int index;
	private int dimensions;

	MultiANewArray(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readUnsignedShort();
		dimensions = is.readUnsignedByte();
		length += 3;
	}

}
