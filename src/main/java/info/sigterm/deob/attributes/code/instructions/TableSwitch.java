package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;

import java.io.DataInputStream;
import java.io.IOException;

public class TableSwitch extends Instruction
{
	private int def;
	private int[] jumps;

	public TableSwitch(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();

		int tableSkip = 4 - (pc + 1) % 4;
		if (tableSkip == 4) tableSkip = 0;
		if (tableSkip > 0) is.skip(tableSkip);

		def = is.readInt();

		int low = is.readInt();
		int high = is.readInt();

		int count = high - low + 1;
		jumps = new int[count];

		for (int i = 0; i < count; ++i)
			jumps[i] = is.readInt();

		length += tableSkip + 12 + (count * 4);
	}
}
