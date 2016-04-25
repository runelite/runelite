package net.runelite.asm.attributes.code.instructions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Type;
import net.runelite.asm.execution.Value;
import net.runelite.asm.pool.Class;

public class New extends Instruction
{
	private Class clazz;
	private ClassFile myClass;

	public New(Instructions instructions, InstructionType type, int pc)
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
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext ctx = new StackContext(ins, new Type(clazz.getName()), Value.NULL);
		stack.push(ctx);
		
		ins.push(ctx);
		
		return ins;
	}
	
	public Class getNewClass()
	{
		return clazz;
	}

	public void setNewClass(Class clazz)
	{
		this.clazz = clazz;
		lookup();
	}
	
	@Override
	public void lookup()
	{
		ClassGroup group = this.getInstructions().getCode().getAttributes().getClassFile().getGroup();
		myClass = group.findClass(clazz.getName());
	}
	
	@Override
	public void regeneratePool()
	{
		if (myClass != null)
			clazz = myClass.getPoolClass();
	}
}
