package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
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

public class MultiANewArray extends Instruction
{
	private Class clazz;
	private int dimensions;

	public MultiANewArray(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		clazz = this.getPool().getClass(is.readUnsignedShort());
		dimensions = is.readUnsignedByte();
		length += 3;
	}
	
	@Override
	public void write(DataOutputStream out, int pc) throws IOException
	{
		super.write(out, pc);
		out.writeShort(this.getPool().make(clazz));
		out.writeByte(dimensions);
	}
	
	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		for (int i = 0; i < dimensions; ++i)
		{
			StackContext ctx = stack.pop();
			ins.pop(ctx);
		}
		
		Type t = new Type(new info.sigterm.deob.signature.Type(clazz.getName()));
		StackContext ctx = new StackContext(ins, t);
		stack.push(ctx);
		
		frame.addInstructionContext(ins);
	}
}
