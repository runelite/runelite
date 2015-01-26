package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.ClassInstance;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.ObjectInstance;
import info.sigterm.deob.pool.Class;

import java.io.DataInputStream;
import java.io.IOException;

public class New extends Instruction
{
	private int index;

	public New(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readUnsignedShort();
		length += 2;
	}

	@Override
	public void execute(Frame e)
	{
		ClassFile thisClass = this.getInstructions().getCode().getAttributes().getClassFile();
		Class clazz = (Class) thisClass.getPool().getEntry(index);
		ClassFile cf = thisClass.getGroup().findClass(clazz.getName());
		if (cf == null)
		{
			e.getStack().push(this, null);
			return;
		}
		
		ClassInstance type = e.getPath().getClassInstance(cf);
		ObjectInstance obj = e.getPath().createObject(type);
		e.getStack().push(this, obj);
	}
}
