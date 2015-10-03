package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.ClassFile;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.execution.Type;
import net.runelite.deob.pool.Class;

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
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
		clazz = this.getPool().getClass(is.readUnsignedShort());
		dimensions = is.readUnsignedByte();
		length += 3;
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
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
		
		Type t = new Type(new net.runelite.deob.signature.Type(clazz.getName()));
		StackContext ctx = new StackContext(ins, t);
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public void renameClass(ClassFile cf, String name)
	{
		// class is an array type, ugh.
		net.runelite.deob.signature.Type t = new net.runelite.deob.signature.Type(clazz.getName());
		if (t.getType().equals("L" + cf.getName() + ";"))
			clazz = new Class("L" + name + ";", t.getArrayDims());
	}
}
