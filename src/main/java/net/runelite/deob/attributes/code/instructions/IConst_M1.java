package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.pool.PoolEntry;

import java.io.IOException;
import net.runelite.deob.execution.Value;

public class IConst_M1 extends Instruction implements PushConstantInstruction
{
	public IConst_M1(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}
	
	public IConst_M1(Instructions instructions)
	{
		super(instructions, InstructionType.ICONST_M1, 0);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext ctx = new StackContext(ins, int.class, new Value(-1));
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public PoolEntry getConstant()
	{
		return new net.runelite.deob.pool.Integer(-1);
	}

	@Override
	public Instruction setConstant(PoolEntry entry)
	{
		return new LDC_W(this.getInstructions(), entry);
	}
	
	@Override
	public Instruction makeGeneric()
	{
		return new LDC_W(this.getInstructions(), getConstant());
	}
}
