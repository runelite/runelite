package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.ClassInstance;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.StaticFieldInstance;
import info.sigterm.deob.pool.Class;
import info.sigterm.deob.pool.Field;
import info.sigterm.deob.pool.NameAndType;

import java.io.DataInputStream;
import java.io.IOException;

public class PutStatic extends Instruction
{
	private int index;

	public PutStatic(Instructions instructions, InstructionType type, int pc) throws IOException
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

		ConstantPool pool = thisClass.getPool();
		Field entry = (Field) pool.getEntry(index);
		Class clazz = entry.getClassEntry();
		NameAndType nat = entry.getNameAndType();
		
		Object value = e.getStack().pop();

		ClassFile cf = thisClass.getGroup().findClass(clazz.getName());
		if (cf == null)
			return;

		ClassInstance ci = e.getPath().getClassInstance(cf);
		StaticFieldInstance fi = ci.findStaticField(nat);
		fi.setField(value);
	}

}
