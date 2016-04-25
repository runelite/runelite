package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.Field;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.ArrayStoreInstruction;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;

public abstract class ArrayStore extends Instruction implements ArrayStoreInstruction
{
	public ArrayStore(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	private Field getMyField(InstructionContext thisIc)
	{
		StackContext sctx = thisIc.getPops().get(2);
		InstructionContext pushed = sctx.getPushed();
		
		InstructionContext r = MappingExecutorUtil.resolve(pushed, sctx);
		
		if (r.getInstruction() instanceof GetFieldInstruction)
		{
			GetFieldInstruction gf = (GetFieldInstruction) r.getInstruction();
			Field f = gf.getMyField();
			return f;
		}
		
		return null;
	}

	@Override
	public boolean canMap(InstructionContext thisIc)
	{
		return getMyField(thisIc) != null;
	}
	
	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		Field myField = this.getMyField(ctx),
			otherField = ((ArrayStore) other.getInstruction()).getMyField(other);
		
		mapping.map(myField, otherField);
		
		// map value

		StackContext object1 = ctx.getPops().get(0), // value set to.
			object2 = other.getPops().get(0);

		InstructionContext base1 = MappingExecutorUtil.resolve(object1.getPushed(), object1);
		InstructionContext base2 = MappingExecutorUtil.resolve(object2.getPushed(), object2);

		if (base1.getInstruction() instanceof GetFieldInstruction && base2.getInstruction() instanceof GetFieldInstruction)
		{
			GetFieldInstruction gf1 = (GetFieldInstruction) base1.getInstruction(),
				gf2 = (GetFieldInstruction) base2.getInstruction();

			net.runelite.asm.Field f1 = gf1.getMyField(),
						f2 = gf2.getMyField();

			if (f1 != null && f2 != null)
			{
				mapping.map(f1, f2);
			}
		}
	}

	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		return thisIc.getInstruction().getClass() == otherIc.getInstruction().getClass();
	}
}
