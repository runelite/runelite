package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.SetFieldInstruction;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.Stack;
import info.sigterm.deob.execution.StackContext;
import info.sigterm.deob.pool.Class;
import info.sigterm.deob.pool.Field;
import info.sigterm.deob.pool.NameAndType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PutStatic extends Instruction implements SetFieldInstruction
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
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeShort(this.getPool().make(field));
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext object = stack.pop();
		ins.pop(object);
		
		frame.addInstructionContext(ins);
	}

	@Override
	public Field getField()
	{
		return field;
	}
	
	@Override
	public void renameClass(ClassFile cf, String name)
	{
		if (field.getClassEntry().getName().equals(cf.getName()))
			field = new Field(new Class(name), field.getNameAndType());
	}
	
	@Override
	public void renameField(info.sigterm.deob.Field f, String name)
	{
		if (field.getNameAndType().getName().equals(f.getName()) && field.getClassEntry().getName().equals(f.getFields().getClassFile().getName()))
		{
			Class clazz = field.getClassEntry();
			NameAndType nat = field.getNameAndType();
			
			NameAndType newNat = new NameAndType(name, nat.getDescriptorType());
			field = new Field(clazz, newNat);
		}
	}
}
