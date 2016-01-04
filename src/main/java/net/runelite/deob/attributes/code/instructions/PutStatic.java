package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.ClassFile;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.pool.Class;
import net.runelite.deob.pool.Field;
import net.runelite.deob.pool.NameAndType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.instruction.types.MappableInstruction;
import net.runelite.deob.deobfuscators.rename.ParallelExecutorMapping;

public class PutStatic extends Instruction implements SetFieldInstruction
{
	private Field field;
	private net.runelite.deob.Field myField;

	public PutStatic(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}
	
	@Override
	public String toString()
	{
		Method m = this.getInstructions().getCode().getAttributes().getMethod();
		return "putstatic " + myField + " in " + m;
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
		field = this.getPool().getField(is.readUnsignedShort());
		length += 2;
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeShort(this.getPool().make(field));
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext object = stack.pop();
		ins.pop(object);
		
		frame.addInstructionContext(ins);
	}

	@Override
	public Field getField()
	{
		return field;
	}
	
	@Override
	public net.runelite.deob.Field getMyField()
	{
		Class clazz = field.getClassEntry();
		NameAndType nat = field.getNameAndType();

		ClassFile cf = this.getInstructions().getCode().getAttributes().getClassFile().getGroup().findClass(clazz.getName());
		if (cf == null)
			return null;

		net.runelite.deob.Field f2 = cf.findFieldDeep(nat);
		return f2;
	}
	
	@Override
	public void lookup()
	{
		myField = getMyField();
	}
	
	@Override
	public void regeneratePool()
	{
		if (myField != null)
			field = myField.getPoolField();
	}

	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		net.runelite.deob.Field myField = this.getMyField(),
			otherField = ((PutStatic) other.getInstruction()).getMyField();
		
		mapping.map(myField, otherField);
	}
	
	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		return thisIc.getInstruction().getClass() == otherIc.getInstruction().getClass();
	}
}
