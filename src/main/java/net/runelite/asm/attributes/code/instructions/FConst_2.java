package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Value;
import net.runelite.asm.pool.PoolEntry;

public class FConst_2 extends Instruction implements PushConstantInstruction
{
	public FConst_2(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext ctx = new StackContext(ins, float.class, new Value(2f));
		stack.push(ctx);
		
		ins.push(ctx);
		
		return ins;
	}

	@Override
	public PoolEntry getConstant()
	{
		return new net.runelite.asm.pool.Float(2.0f);
	}

	@Override
	public Instruction setConstant(PoolEntry entry)
	{
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
