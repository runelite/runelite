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
import info.sigterm.deob.pool.PoolEntry;

import java.io.DataInputStream;
import java.io.IOException;

public class InvokeSpecial extends Instruction
{
	private int index;

	public InvokeSpecial(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readUnsignedShort();
		length += 2;
	}

	@Override
	public void execute(Frame e)
	{
		ClassFile thisClass = this.getInstructions().getCode().getAttributes().getClassFile();

		ConstantPool pool = thisClass.getPool();
		Method method = (Method) pool.getEntry(index);
		int count = method.getNameAndType().getNumberOfArgs();
		
		ObjectInstance object = (ObjectInstance) e.getStack().pop();
		
		Object[] args = new Object[count + 1];
		args[0] = object;
		for (int i = 1; i < count + 1; ++i)
			args[i] = e.getStack().pop();
		
		if (object == null)
		{
			//System.out.println("invokespecial for nonexistant function " + method.getNameAndType().getName() + " " + method.getNameAndType().getDescriptor() + " on " + method.getClassEntry().getName() + " (void: " + !method.getNameAndType().isNonVoid() + ")");
			if (method.getNameAndType().isNonVoid())
				e.getStack().push(this, null);
			return;
		}
		
		ClassInstance objectType = object.getType();
		info.sigterm.deob.Method meth = objectType.getClassFile().findMethod(method.getNameAndType());
		e.getPath().invoke(meth, args);
	}

	@Override
	public String getDesc(Frame frame)
	{
		ClassFile thisClass = this.getInstructions().getCode().getAttributes().getClassFile();
		Method method = (Method) thisClass.getPool().getEntry(index);
		
		return "invokespecial " + method.getNameAndType().getDescriptor() + " on " + method.getClassEntry().getName();
	}
}
