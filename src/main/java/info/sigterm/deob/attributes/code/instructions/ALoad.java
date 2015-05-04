package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.execution.Frame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ALoad extends Instruction implements LVTInstruction
{
	private int index;

	public ALoad(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readByte();
		length += 1;
	}
	
	@Override
	public void write(DataOutputStream out, int pc) throws IOException
	{
		super.write(out, pc);
		out.writeByte(index);
	}

	@Override
	public void execute(Frame frame)
	{
		Object obj = frame.getVariables().get(index);
		frame.getStack().push(this, obj);
	}

	@Override
	public int getVariableIndex()
	{
		return index;
	}

	@Override
	public boolean store()
	{
		return false;
	}
}
