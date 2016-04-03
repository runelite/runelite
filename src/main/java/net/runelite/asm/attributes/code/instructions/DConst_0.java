package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.pool.PoolEntry;

import net.runelite.asm.execution.Value;

public class DConst_0 extends Instruction implements PushConstantInstruction
{
	public DConst_0(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext ctx = new StackContext(ins, double.class, new Value(0d));
		stack.push(ctx);
		
		ins.push(ctx);
		
		return ins;
	}

	@Override
	public PoolEntry getConstant()
	{
		return new net.runelite.asm.pool.Double(0.0d);
	}

	@Override
	public Instruction setConstant(PoolEntry entry)
	{
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
