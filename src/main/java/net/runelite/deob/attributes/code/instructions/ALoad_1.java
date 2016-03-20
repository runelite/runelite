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

import java.io.IOException;

public class ALoad_1 extends Instruction implements LVTInstruction
{
	public ALoad_1(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	public ALoad_1(Instructions instructions)
	{
		super(instructions, InstructionType.ALOAD_1, -1);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		Variables var = frame.getVariables();
		
		VariableContext vctx = var.get(1);
		ins.read(vctx);
		
		StackContext ctx = new StackContext(ins, vctx);
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public int getVariableIndex()
	{
		return 1;
	}

	@Override
	public boolean store()
	{
		return false;
	}

	@Override
	public Instruction setVariableIndex(int idx)
	{
		return new ALoad(this.getInstructions(), idx);
	}
	
	@Override
	public Instruction makeGeneric()
	{
		return new ALoad(this.getInstructions(), 1);
	}
}
