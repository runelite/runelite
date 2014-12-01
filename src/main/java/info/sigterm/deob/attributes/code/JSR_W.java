package info.sigterm.deob.attributes.code;

import java.io.DataInputStream;
import java.io.IOException;

public class JSR_W extends Instruction
{
	private int offset;

	JSR_W(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		offset = is.readInt();
		length += 4;
	}

}
