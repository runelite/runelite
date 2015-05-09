package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.ArrayInstance;
import info.sigterm.deob.execution.ClassInstance;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.pool.Class;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ANewArray extends Instruction
{
	private Class clazz;

	public ANewArray(Instructions instructions, InstructionType type, int pc) throws IOException
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
	public void execute(Frame frame)
	{
		ClassFile thisClass = this.getInstructions().getCode().getAttributes().getClassFile();
		
		int count = (int) frame.getStack().pop();
		
		ClassFile cf = thisClass.getGroup().findClass(clazz.getName());
		if (cf == null)
		{
			frame.getStack().push(this, null);
			return;
		}
		
		ClassInstance type = frame.getPath().getClassInstance(cf);
		ArrayInstance array = frame.getPath().createArray(type, count);
		
		frame.getStack().push(this, array);
	}
}
