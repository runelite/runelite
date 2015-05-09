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
import java.io.DataOutputStream;
import java.io.IOException;

public class PutStatic extends Instruction
{
	private Field field;

	public PutStatic(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		field = this.getPool().getField(is.readUnsignedShort());
		length += 2;
	}
	
	@Override
	public void write(DataOutputStream out, int pc) throws IOException
	{
		super.write(out, pc);
		out.writeShort(this.getPool().make(field));
	}

	@Override
	public void execute(Frame e)
	{
		ClassFile thisClass = this.getInstructions().getCode().getAttributes().getClassFile();

		Class clazz = field.getClassEntry();
		NameAndType nat = field.getNameAndType();
		
		Object value = e.getStack().pop();

		ClassFile cf = thisClass.getGroup().findClass(clazz.getName());
		if (cf == null)
			return;

		ClassInstance ci = e.getPath().getClassInstance(cf);
		StaticFieldInstance fi = ci.findStaticField(nat);
		fi.setField(value);
	}

}
