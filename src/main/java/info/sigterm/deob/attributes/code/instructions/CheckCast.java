package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.ObjectInstance;
import info.sigterm.deob.pool.Class;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CheckCast extends Instruction
{
	private Class clazz;

	public CheckCast(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		clazz = this.getPool().getClass(is.readUnsignedShort());
		length += 2;
	}
	
	@Override
	public void write(DataOutputStream out, int pc) throws IOException
	{
		super.write(out, pc);
		out.writeShort(this.getPool().make(clazz));
	}

	@Override
	public void execute(Frame e)
	{
		ClassFile thisClass = this.getInstructions().getCode().getAttributes().getClassFile();

		ConstantPool pool = thisClass.getPool();
		
		ObjectInstance obj = (ObjectInstance) e.getStack().pop();
		if (obj == null)
		{
			e.getStack().push(this, null);
			return;
		}
		
		ClassFile otherClass = thisClass.getGroup().findClass(clazz.getName());
		boolean instanceOf = obj.getType().getClassFile().instanceOf(otherClass);
		
		if (!instanceOf)
		{
			// XXX throw
		}
		
		e.getStack().push(this, obj);
	}

}
