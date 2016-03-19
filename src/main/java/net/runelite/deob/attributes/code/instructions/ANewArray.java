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
import net.runelite.deob.ClassGroup;
import net.runelite.deob.execution.Value;

public class ANewArray extends Instruction
{
	private Class clazz;
	private ClassFile myClass;
	private int dimensions;

	public ANewArray(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
		clazz = this.getPool().getClass(is.readUnsignedShort());
		length += 2;
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		
		out.writeShort(this.getPool().make(clazz));
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext count = stack.pop();
		
		ins.pop(count);
		
		Type t = new Type(new net.runelite.deob.signature.Type("[" + clazz.getName()));
		StackContext ctx = new StackContext(ins, t, Value.newArray(count.getValue()));
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public void lookup()
	{
		net.runelite.deob.signature.Type t = new net.runelite.deob.signature.Type(clazz.getName());
		String name = t.getType();
		if (name.startsWith("L") && name.endsWith(";"))
			name = name.substring(1, name.length() - 1);
		ClassGroup group = this.getInstructions().getCode().getAttributes().getClassFile().getGroup();
		myClass = group.findClass(name);
		dimensions = t.getArrayDims();
	}
	
	@Override
	public void regeneratePool()
	{
		if (myClass != null)
		{
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < this.dimensions; ++i)
				sb.append('[');
			if (this.dimensions > 0)
				sb.append("L" + myClass.getName() + ";");
			else
				sb.append(myClass.getName());
			clazz = new Class(sb.toString());
		}
	}
}
