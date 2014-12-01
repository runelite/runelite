package info.sigterm.deob.attributes.code;

import java.io.DataInputStream;
import java.io.IOException;

public class Wide extends Instruction
{
	private byte opcode;
	private int index;
	private int value;

	Wide(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();

		opcode = is.readByte();
		index = is.readUnsignedShort();
		length += 3;

		// XXX
		InstructionType optype = InstructionType.findInstructionFromCode(opcode);
		assert optype != null;
		if (optype == InstructionType.IINC)
		{
			value = is.readUnsignedShort();
			length += 2;
		}
	}

}
