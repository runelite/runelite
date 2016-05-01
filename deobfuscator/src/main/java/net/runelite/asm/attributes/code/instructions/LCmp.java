package net.runelite.asm.attributes.code.instructions;

import java.util.ArrayList;
import java.util.List;
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

public class LCmp extends Instruction implements MappableInstruction
{
	public LCmp(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
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
			long l2 = (long) two.getValue().getValue(),
				l1 = (long) one.getValue().getValue();
		
			if (l1 > l2)
				result = new Value(1);
			else if (l1 == l2)
				result = new Value(0);
			else if (l1 < l2)
				result = new Value(-1);
		}
		
		StackContext ctx = new StackContext(ins, int.class, result);
		stack.push(ctx);
		
		ins.push(ctx);
		
		return ins;
	}

	@Override
	public void map(ParallelExecutorMapping mappings, InstructionContext ctx, InstructionContext other)
	{
		List<Field> f1s = getComparedFields(ctx), f2s = getComparedFields(other);

		if (f1s == null || f2s == null || f1s.size() != f2s.size())
			return;

		for (int i = 0; i < f1s.size(); ++i)
		{
			Field f1 = f1s.get(i), f2 = f2s.get(i);

			mappings.map(f1, f2);
		}
	}

	private List<Field> getComparedFields(InstructionContext ctx)
	{
		List<Field> fields = new ArrayList<>();

		for (StackContext sctx : ctx.getPops())
		{
			InstructionContext base = MappingExecutorUtil.resolve(sctx.getPushed(), sctx);

			if (base.getInstruction() instanceof GetFieldInstruction)
			{
				GetFieldInstruction gfi = (GetFieldInstruction) base.getInstruction();

				if (gfi.getMyField() != null)
					fields.add(gfi.getMyField());
			}
		}

		return fields.isEmpty() ? null : fields;
	}

	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		return true;
	}

	@Override
	public boolean canMap(InstructionContext thisIc)
	{
		return true;
	}
}
