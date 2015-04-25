package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.ClassInstance;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.ObjectInstance;
import info.sigterm.deob.pool.InterfaceMethod;
import info.sigterm.deob.pool.NameAndType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class InvokeInterface extends Instruction
{
	private int index;
	private int count;

	public InvokeInterface(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readUnsignedShort();
		count = is.readUnsignedByte();
		is.skip(1);
		length += 4;
	}
	
	@Override
	public void write(DataOutputStream out, int pc) throws IOException
	{
		super.write(out, pc);
		out.writeShort(index);
		out.writeByte(count);
		out.writeByte(0);
	}
	
	@Override
	public void buildCallGraph()
	{
		ClassFile thisClass = this.getInstructions().getCode().getAttributes().getClassFile();

		ConstantPool pool = thisClass.getPool();
		InterfaceMethod method = (InterfaceMethod) pool.getEntry(index);
		
		info.sigterm.deob.pool.Class clazz = method.getClassEntry();
		NameAndType nat = method.getNameAndType();
		
		info.sigterm.deob.Method thisMethod = this.getInstructions().getCode().getAttributes().getMethod();
		
		ClassFile otherClass = this.getInstructions().getCode().getAttributes().getClassFile().getGroup().findClass(clazz.getName());
		if (otherClass == null)
			return;
		info.sigterm.deob.Method other = otherClass.findMethod(nat);
		
		thisMethod.addCallTo(this, other);
	}

	@Override
	public void execute(Frame e)
	{
		ClassFile thisClass = this.getInstructions().getCode().getAttributes().getClassFile();

		ConstantPool pool = thisClass.getPool();
		InterfaceMethod method = (InterfaceMethod) pool.getEntry(index);
		
		ObjectInstance object = (ObjectInstance) e.getStack().pop();
		ClassInstance objectType = object.getType();
		
		Object[] args = new Object[count + 1];
		args[0] = object;
		for (int i = 1; i < count + 1; ++i)
			args[i] = e.getStack().pop();
		
		Method meth = objectType.getClassFile().findMethod(method.getNameAndType());
		e.getPath().invoke(meth, args);
	}

}
