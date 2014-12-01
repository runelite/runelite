package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;

import java.io.DataInputStream;
import java.io.IOException;

public class JSR_W extends Instruction
{
	private int offset;

	public JSR_W(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		offset = is.readInt();
		length += 4;
	}

	@Override
	public void buildJumpGraph()
	{
		this.addJump(offset);
	}
}
