package info.sigterm.deob.attributes.code;

import info.sigterm.deob.attributes.Code;

import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;

public class Instructions
{
	private Code code;

	public Instructions(Code code) throws IOException
	{
		DataInputStream is = code.getAttributes().getStream();

		int length = is.readInt();

		for (int pc = 0; pc < length;)
		{
			byte opcode = is.readByte();

			InstructionType type = InstructionType.findInstructionFromCode(opcode);

			try
			{
				Constructor<? extends Instruction> con = type.getInstructionClass().getConstructor(new Class[] { Instructions.class, InstructionType.class, Integer.class });
				Instruction ins = con.newInstance(this, type, pc);
			}
			catch (java.lang.Exception ex)
			{
				throw new IOException(ex);
			}
		}
	}

	public Code getCode()
	{
		return code;
	}
}
