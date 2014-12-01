package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;

import java.io.DataInputStream;
import java.io.IOException;

public class InvokeInterface extends Instruction
{
	private int index;
	private int count;

	public InvokeInterface(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readUnsignedShort();
		count = is.readUnsignedByte();
		is.skip(1);
		length += 4;
	}

}
