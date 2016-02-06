package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.Field;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.ArrayStoreInstruction;
import net.runelite.deob.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.deob.deobfuscators.rename.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.rename.ParallelExecutorMapping;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.StackContext;

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
	}

	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		return thisIc.getInstruction().getClass() == otherIc.getInstruction().getClass();
	}
}
