package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.Stack;
import info.sigterm.deob.execution.StackContext;
import info.sigterm.deob.execution.Type;
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
	public void execute(Frame frame)
	{
		Frame other = frame.dup();
		Stack stack = other.getStack();
		
		InstructionContext ins = new InstructionContext(this, other);
		
		StackContext what = stack.pop();
		
		ins.pop(what);
		
		other.throwException(new Type("java.lang.ClassCastException"));
	}

}
