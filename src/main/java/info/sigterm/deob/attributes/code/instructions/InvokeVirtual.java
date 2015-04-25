package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.ClassInstance;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.ObjectInstance;
import info.sigterm.deob.pool.Method;
import info.sigterm.deob.pool.NameAndType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class InvokeVirtual extends Instruction
{
	private int index;

	public InvokeVirtual(Instructions instructions, InstructionType type, int pc) throws IOException
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
	public void buildCallGraph()
	{
		ClassFile thisClass = this.getInstructions().getCode().getAttributes().getClassFile();

		ConstantPool pool = thisClass.getPool();
		Method method = (Method) pool.getEntry(index);
		
		info.sigterm.deob.pool.Class clazz = method.getClassEntry();
		NameAndType nat = method.getNameAndType();
		
		info.sigterm.deob.Method thisMethod = this.getInstructions().getCode().getAttributes().getMethod();
		
		ClassFile otherClass = this.getInstructions().getCode().getAttributes().getClassFile().getGroup().findClass(clazz.getName());
		if (otherClass == null)
			return;
		info.sigterm.deob.Method other = otherClass.findMethod(nat);
		if (other == null)
			return;
		
		thisMethod.addCallTo(this, other);
	}

	@Override
	public void execute(Frame e)
	{
		ClassFile thisClass = this.getInstructions().getCode().getAttributes().getClassFile();

		ConstantPool pool = thisClass.getPool();
		Method method = (Method) pool.getEntry(index);
		int count = method.getNameAndType().getNumberOfArgs();
		
		Object[] args = new Object[count + 1];
		for (int i = count; i > 0; --i)
			args[i] = e.getStack().pop();
		
		ObjectInstance object = (ObjectInstance) e.getStack().pop();
		if (object == null)
		{
			//System.out.println("invokevirtual on null object for method " + method.getNameAndType().getName() + " " + method.getNameAndType().getDescriptor() + " on " + method.getClassEntry().getName());
			e.getStack().push(this, null);
			return;
		}
		
		ClassInstance objectType = object.getType();
		
		args[0] = object;
		
		info.sigterm.deob.Method meth = objectType.getClassFile().findMethod(method.getNameAndType());
		if (meth == null)
		{
			//System.out.println("Unknown method " + method.getNameAndType().getName() + " " + method.getNameAndType().getDescriptor() + " in " + objectType.getClassFile().getName());
			if (method.getNameAndType().isNonVoid())
				e.getStack().push(this, null);
			return;
		}
		e.getPath().invoke(meth, args);
	}

}
