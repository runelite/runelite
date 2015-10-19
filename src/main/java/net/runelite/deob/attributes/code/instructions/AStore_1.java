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

public class AStore_1 extends Instruction implements LVTInstruction
{
	public AStore_1(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		Variables variables = frame.getVariables();
		
		StackContext object = stack.pop();		
		ins.pop(object);
		
		variables.set(1, new VariableContext(ins, object));
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public int getVariableIndex()
	{
		return 1;
	}
	
	@Override
	public Instruction setVariableIndex(int idx)
	{
		return new AStore(this.getInstructions(), idx);
	}

	@Override
	public boolean store()
	{
		return true;
	}
	
	@Override
	public Instruction makeGeneric()
	{
		return new AStore(this.getInstructions(), 1);
	}
}
