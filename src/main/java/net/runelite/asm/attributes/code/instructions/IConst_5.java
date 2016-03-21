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

import java.io.IOException;
import net.runelite.asm.execution.Value;

public class IConst_5 extends Instruction implements PushConstantInstruction
{
	public IConst_5(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}
	
	public IConst_5(Instructions instructions)
	{
		super(instructions, InstructionType.ICONST_5, 0);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext ctx = new StackContext(ins, int.class, new Value(5));
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public PoolEntry getConstant()
	{
		return new net.runelite.asm.pool.Integer(5);
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
