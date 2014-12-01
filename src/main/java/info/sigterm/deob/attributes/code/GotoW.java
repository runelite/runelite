package info.sigterm.deob.attributes.code;

import java.io.DataInputStream;
import java.io.IOException;

public class GotoW extends Instruction
{
	private int offset;

	GotoW(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		offset = is.readInt();
		length += 4;
	}

}
