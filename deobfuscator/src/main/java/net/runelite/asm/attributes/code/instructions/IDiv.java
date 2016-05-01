package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.Field;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.MappableInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Value;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;

public class IDiv extends Instruction implements MappableInstruction
{
	public IDiv(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	public IDiv(Instructions instructions)
	{
		super(instructions, InstructionType.IDIV, -1);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext two = stack.pop();
		StackContext one = stack.pop();
		
		ins.pop(two, one);
		
		Value result = Value.UNKNOWN;
		if (!two.getValue().isUnknownOrNull() && !one.getValue().isUnknownOrNull())
		{
			int i2 = (int) two.getValue().getValue(),
				i1 = (int) one.getValue().getValue();
			
			if (i2 != 0)
				result = new Value(i1 / i2);
		}
		
		StackContext ctx = new StackContext(ins, int.class, result);
		stack.push(ctx);
		
		ins.push(ctx);

		return ins;
	}

	@Override
	public void map(ParallelExecutorMapping mappings, InstructionContext ctx, InstructionContext other)
	{
		StackContext s1 = ctx.getPops().get(0),
			s2 = ctx.getPops().get(1);

		StackContext o1 = other.getPops().get(0),
			o2 = other.getPops().get(1);

		InstructionContext i1 = MappingExecutorUtil.resolve(s1.getPushed(), s1);
		InstructionContext i2 = MappingExecutorUtil.resolve(s2.getPushed(), s2);

		InstructionContext io1 = MappingExecutorUtil.resolve(o1.getPushed(), o1);
		InstructionContext io2 = MappingExecutorUtil.resolve(o2.getPushed(), o2);

		if (i1.getInstruction() instanceof GetFieldInstruction && io1.getInstruction() instanceof GetFieldInstruction)
		{
			GetFieldInstruction f1 = (GetFieldInstruction) i1.getInstruction();
			GetFieldInstruction f2 = (GetFieldInstruction) io1.getInstruction();

			Field fi1 = f1.getMyField(), fi2 = f2.getMyField();

			if (fi1 != null && fi2 != null)
				mappings.map(fi1, fi2);
		}

		if (i2.getInstruction() instanceof GetFieldInstruction && io2.getInstruction() instanceof GetFieldInstruction)
		{
			GetFieldInstruction f1 = (GetFieldInstruction) i2.getInstruction();
			GetFieldInstruction f2 = (GetFieldInstruction) io2.getInstruction();

			Field fi1 = f1.getMyField(), fi2 = f2.getMyField();

			if (fi1 != null && fi2 != null)
				mappings.map(fi1, fi2);
		}
	}

	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		return this.getClass() == otherIc.getInstruction().getClass();
	}

	@Override
	public boolean canMap(InstructionContext thisIc)
	{
		return true;
	}
}
