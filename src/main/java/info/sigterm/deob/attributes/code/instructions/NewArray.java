package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;

import java.io.DataInputStream;
import java.io.IOException;

public class NewArray extends Instruction
{
	private int type;

	public NewArray(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		this.type = is.readUnsignedByte();
		length += 1;
	}

	@Override
	public void execute(Frame e)
	{
		int count = (int) e.getStack().pop();
		
		switch (type)
		{
			case 4:
				e.getStack().push(new boolean[count]);
				break;
			case 5:
				e.getStack().push(new char[count]);
				break;
			case 6:
				e.getStack().push(new float[count]);
				break;
			case 7:
				e.getStack().push(new double[count]);
				break;
			case 8:
				e.getStack().push(new byte[count]);
				break;
			case 9:
				e.getStack().push(new short[count]);
				break;
			case 10:
				e.getStack().push(new int[count]);
				break;
			case 11:
				e.getStack().push(new long[count]);
				break;
		}
	}

}
