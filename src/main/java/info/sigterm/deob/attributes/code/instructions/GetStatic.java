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

public class GetStatic extends Instruction
{
	private Field field;

	public GetStatic(Instructions instructions, InstructionType type, int pc) throws IOException
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
	public void execute(Frame frame)
	{
		ClassFile thisClass = this.getInstructions().getCode().getAttributes().getClassFile();

		Class clazz = field.getClassEntry();
		NameAndType nat = field.getNameAndType();

		ClassFile cf = thisClass.getGroup().findClass(clazz.getName());
		if (cf == null)
		{
			Object ovalue = nat.getStackObject();
			frame.getStack().push(this, ovalue);
			return;
		}

		ClassInstance ci = frame.getPath().getClassInstance(cf);
		StaticFieldInstance fi = ci.findStaticField(nat);
		Object ovalue = fi.getValue();

		frame.getStack().push(this, ovalue);
	}

	@Override
	public void buildInstructionGraph()
	{
		Class clazz = field.getClassEntry();
		NameAndType nat = field.getNameAndType();

		ClassFile cf = this.getInstructions().getCode().getAttributes().getClassFile().getGroup().findClass(clazz.getName());
		if (cf == null)
			return;

		info.sigterm.deob.Field f = cf.findField(nat);
		assert f != null;

		f.addReference(this);
	}

}
