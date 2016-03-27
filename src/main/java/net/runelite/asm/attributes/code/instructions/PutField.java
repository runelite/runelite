package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.ClassFile;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.pool.Class;
import net.runelite.asm.pool.Field;
import net.runelite.asm.pool.NameAndType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.deobfuscators.rename.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.rename.ParallelExecutorMapping;

public class PutField extends Instruction implements SetFieldInstruction
{
	private Field field;
	private net.runelite.asm.Field myField;

	public PutField(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public String toString()
	{
		Method m = this.getInstructions().getCode().getAttributes().getMethod();
		return "putfield " + myField + " in " + m;
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
		
		StackContext value = stack.pop();
		StackContext object = stack.pop();
		ins.pop(value, object);
		
		frame.addInstructionContext(ins);
	}

	@Override
	public Field getField()
	{
		return field;
	}
	
	@Override
	public net.runelite.asm.Field getMyField()
	{
		Class clazz = field.getClassEntry();
		NameAndType nat = field.getNameAndType();

		ClassFile cf = this.getInstructions().getCode().getAttributes().getClassFile().getGroup().findClass(clazz.getName());
		if (cf == null)
			return null;

		net.runelite.asm.Field f2 = cf.findFieldDeep(nat);
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
			if (getMyField() != myField)
				field = myField.getPoolField();
	}

	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		net.runelite.asm.Field myField = this.getMyField();
		net.runelite.asm.Field otherField = ((PutField) other.getInstruction()).getMyField();
		
		assert MappingExecutorUtil.isMaybeEqual(myField.getType(), otherField.getType());
		
		mapping.map(myField, otherField);
		
		// map assignment
		
		StackContext object1 = ctx.getPops().get(1),
			object2 = other.getPops().get(1);
		
		InstructionContext base1 = MappingExecutorUtil.resolve(object1.getPushed(), object1);
		InstructionContext base2 = MappingExecutorUtil.resolve(object2.getPushed(), object2);

		if (base1.getInstruction() instanceof GetFieldInstruction && base2.getInstruction() instanceof GetFieldInstruction)
		{
			GetFieldInstruction gf1 = (GetFieldInstruction) base1.getInstruction(),
				gf2 = (GetFieldInstruction) base2.getInstruction();

			net.runelite.asm.Field f1 = gf1.getMyField();
			net.runelite.asm.Field f2 = gf2.getMyField();

			if (f1 != null && f2 != null)
			{
				mapping.map(f1, f2);
			}
		}

		// XXX also map value here?
	}

	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (thisIc.getInstruction().getClass() != otherIc.getInstruction().getClass())
			return false;
		
		PutField thisPf = (PutField) thisIc.getInstruction(),
			otherPf = (PutField) otherIc.getInstruction();
		
		net.runelite.asm.Field f1 = thisPf.getMyField();
		net.runelite.asm.Field f2 = otherPf.getMyField();
		
		if ((f1 != null) != (f2 != null))
			return false;

		return MappingExecutorUtil.isMaybeEqual(f1.getFields().getClassFile(), f2.getFields().getClassFile())
			&& MappingExecutorUtil.isMaybeEqual(f1.getType(), f2.getType());
	}
	
	@Override
	public boolean canMap(InstructionContext thisIc)
	{
		StackContext value = thisIc.getPops().get(0);
		Instruction i = value.getPushed().getInstruction();
		if (thisIc.getFrame().getMethod().getName().equals("<init>"))
			if (i instanceof PushConstantInstruction || i instanceof AConstNull)
				return false;
		return true;
	}
}
