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

public class IConst_4 extends Instruction implements PushConstantInstruction
{
	public IConst_4(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	public IConst_4(Instructions instructions)
	{
		super(instructions, InstructionType.ICONST_4, 0);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext ctx = new StackContext(ins, int.class, new Value(4));
		stack.push(ctx);
		
		ins.push(ctx);
		
		return ins;
	}
	
	@Override
	public PoolEntry getConstant()
	{
		return new net.runelite.asm.pool.Integer(4);
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
