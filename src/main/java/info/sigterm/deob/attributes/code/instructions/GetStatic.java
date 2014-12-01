package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.pool.Class;
import info.sigterm.deob.pool.Field;
import info.sigterm.deob.pool.NameAndType;

import java.io.DataInputStream;
import java.io.IOException;

public class GetStatic extends Instruction
{
	private int index;

	public GetStatic(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readUnsignedShort();
		length += 2;
	}

	@Override
	public void buildInstructionGraph()
	{
		ConstantPool pool = this.getInstructions().getCode().getAttributes().getClassFile().getPool();
		Field entry = (Field) pool.getEntry(index);

		Class clazz = entry.getClassEntry();
		NameAndType nat = entry.getNameAndType();

		ClassFile cf = this.getInstructions().getCode().getAttributes().getClassFile().getGroup().findClass(clazz.getName());
		if (cf == null)
			return;

		info.sigterm.deob.Field f = cf.findField(nat);
		assert f != null;

		f.addReference(this);
	}

}
