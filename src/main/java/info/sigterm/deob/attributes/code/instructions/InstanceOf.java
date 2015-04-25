package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.ObjectInstanceBase;
import info.sigterm.deob.pool.Class;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class InstanceOf extends Instruction
{
	private int index;

	public InstanceOf(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readUnsignedShort();
		length += 2;
	}
	
	@Override
	public void write(DataOutputStream out, int pc) throws IOException
	{
		super.write(out, pc);
		out.writeShort(index);
	}

	@Override
	public void execute(Frame e)
	{
		ClassFile thisClass = this.getInstructions().getCode().getAttributes().getClassFile();

		ConstantPool pool = thisClass.getPool();
		Class clazz = (Class) pool.getEntry(index);
		
		ObjectInstanceBase obj = (ObjectInstanceBase) e.getStack().pop();
		if (obj == null)
		{
			e.getStack().push(this, 0);
			return;
			
		}
		
		ClassFile otherClass = thisClass.getGroup().findClass(clazz.getName());
		boolean instanceOf = obj.getType().getClassFile().instanceOf(otherClass);
		e.getStack().push(this, instanceOf ? 1 : 0);
	}
}
