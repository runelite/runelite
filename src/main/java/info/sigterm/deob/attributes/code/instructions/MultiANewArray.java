package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.Stack;
import info.sigterm.deob.pool.Class;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MultiANewArray extends Instruction
{
	private int index;
	private int dimensions;

	public MultiANewArray(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readUnsignedShort();
		dimensions = is.readUnsignedByte();
		length += 3;
	}
	
	@Override
	public void write(DataOutputStream out, int pc) throws IOException
	{
		super.write(out, pc);
		out.writeShort(index);
		out.writeByte(dimensions);
	}
	
	@Override
	public void execute(Frame e)
	{
		Stack stack = e.getStack();
		
		ClassFile thisClass = this.getInstructions().getCode().getAttributes().getClassFile();
		Class clazz = (Class) thisClass.getPool().getEntry(index);
		
		// XXX primive type/array type ? [[I [[Lmyclass; etc
		ClassFile cf = thisClass.getGroup().findClass(clazz.getName());
		
		int[] dims = new int[dimensions];
		for (int i = 0; i < dimensions; ++i)
			dims[i] = (int) stack.pop();
	}
}
