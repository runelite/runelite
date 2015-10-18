package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.ClassFile;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.pool.Class;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.util.NameMappings;

public class InstanceOf extends Instruction
{
	private Class clazz;
	private ClassFile myClass;

	public InstanceOf(Instructions instructions, InstructionType type, int pc)
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
		
		StackContext obj = stack.pop();
		ins.pop(obj);
		
		StackContext ctx = new StackContext(ins, int.class);
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public void lookup2()
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
