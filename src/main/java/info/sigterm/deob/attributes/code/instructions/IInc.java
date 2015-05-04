package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.execution.Frame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class IInc extends Instruction implements LVTInstruction
{
	private byte index;
	private byte inc;

	public IInc(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readByte();
		inc = is.readByte();
		length += 2;
	}
	
	@Override
	public void write(DataOutputStream out, int pc) throws IOException
	{
		super.write(out, pc);
		out.writeByte(index);
		out.writeByte(inc);
	}

	@Override
	public void execute(Frame frame)
	{
		int i = (int) frame.getVariables().get(index);
		i += inc;
		frame.getVariables().set(index, i);
	}

	@Override
	public int getVariableIndex()
	{
		return index;
	}

	@Override
	public boolean store()
	{
		return false; // This is a get first
	}
}
