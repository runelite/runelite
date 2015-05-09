package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.pool.Method;
import info.sigterm.deob.pool.NameAndType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class InvokeStatic extends Instruction
{
	private Method method;

	public InvokeStatic(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		method = this.getPool().getMethod(is.readUnsignedShort());
		length += 2;
	}
	
	@Override
	public void write(DataOutputStream out, int pc) throws IOException
	{
		super.write(out, pc);
		out.writeShort(this.getPool().make(method));
	}
	
	@Override
	public void buildCallGraph()
	{	
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

		info.sigterm.deob.pool.Class clazz = method.getClassEntry();
		
		ClassFile otherClass = thisClass.getGroup().findClass(clazz.getName());
		int count = method.getNameAndType().getNumberOfArgs();
		
		Object[] args = new Object[count];
		for (int i = count - 1; i >= 0; --i)
			args[i] = e.getStack().pop();
		
		if (otherClass == null)
		{
			//System.out.println("invokestatic for nonexistant class " + clazz.getName());
			if (method.getNameAndType().isNonVoid())
				e.getStack().push(this, null);
			return;
		}
		
		info.sigterm.deob.Method meth = otherClass.findMethod(method.getNameAndType());
		e.getPath().invoke(meth, args);
	}
}
