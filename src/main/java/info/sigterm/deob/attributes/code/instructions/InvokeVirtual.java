package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;

import java.io.DataInputStream;
import java.io.IOException;

public class InvokeVirtual extends Instruction
{
	private int index;

	public InvokeVirtual(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readUnsignedShort();
		length += 2;
	}

}
