package info.sigterm.deob.attributes.code;

import java.io.DataInputStream;
import java.io.IOException;

public class LookupSwitch extends Instruction
{
	private int def;
	private int[] match;
	private int[] branch;

	LookupSwitch(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();

		int tableSkip = 4 - (pc + 1) % 4;
		if (tableSkip == 4) tableSkip = 0;
		if (tableSkip > 0) is.skip(tableSkip);

		def = is.readInt();

		int count = is.readInt();
		match = new int[count];
		branch = new int[count];

		for (int i = 0; i < count; ++i)
		{
			match[i] = is.readInt();
			branch[i] = is.readInt();
		}

		length += tableSkip + 8 + (count * 8);
	}
}
