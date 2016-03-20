package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.LVTInstruction;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.execution.VariableContext;
import net.runelite.deob.execution.Variables;


public class ILoad_3 extends Instruction implements LVTInstruction
{
	public ILoad_3(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	public ILoad_3(Instructions instructions)
	{
		super(instructions, InstructionType.ILOAD_3, -1);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		Variables variables = frame.getVariables();
		
		VariableContext vctx = variables.get(3);
		assert vctx.getType().isInt();
		ins.read(vctx);
		
		StackContext ctx = new StackContext(ins, vctx);
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public int getVariableIndex()
	{
		return 3;
	}
	
	@Override
	public Instruction setVariableIndex(int idx)
	{
		return new ILoad(this.getInstructions(), idx);
	}

	@Override
	public boolean store()
	{
		return false;
	}
	
	@Override
	public Instruction makeGeneric()
	{
		return new ILoad(this.getInstructions(), 3);
	}
}
