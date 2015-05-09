package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.FieldInstance;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.ObjectInstance;
import info.sigterm.deob.pool.Field;
import info.sigterm.deob.pool.NameAndType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class GetField extends Instruction
{
	private Field field;

	public GetField(Instructions instructions, InstructionType type, int pc) throws IOException
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
		ObjectInstance object = (ObjectInstance) frame.getStack().pop();
		
		ClassFile thisClass = this.getInstructions().getCode().getAttributes().getClassFile();

		ConstantPool pool = thisClass.getPool();

		NameAndType nat = field.getNameAndType();
		
		if (object == null)
		{
			frame.getStack().push(this, null);
			return;
		}
		
		FieldInstance field = object.getField(nat);
		frame.getStack().push(this, field.getValue());
	}
}
