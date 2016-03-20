package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.execution.Value;
import net.runelite.deob.pool.PoolEntry;

public class LConst_1 extends Instruction implements PushConstantInstruction
{
	public LConst_1(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	public LConst_1(Instructions instructions)
	{
		super(instructions, InstructionType.LCONST_1, -1);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext ctx = new StackContext(ins, long.class, new Value(1L));
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public PoolEntry getConstant()
	{
		return new net.runelite.deob.pool.Long(1);
	}

	@Override
	public Instruction setConstant(PoolEntry entry)
	{
		return new LDC2_W(this.getInstructions(), entry);
	}
	
	@Override
	public Instruction makeGeneric()
	{
		return new LDC2_W(this.getInstructions(), getConstant());
	}
}
