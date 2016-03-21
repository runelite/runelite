package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.VariableContext;
import net.runelite.asm.execution.Variables;


public class FStore_0 extends Instruction implements LVTInstruction
{
	public FStore_0(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	public FStore_0(Instructions instructions)
	{
		super(instructions, InstructionType.FSTORE_0, -1);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		Variables variables = frame.getVariables();
		
		StackContext value = stack.pop();
		ins.pop(value);
		
		variables.set(0, new VariableContext(ins, value));
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public int getVariableIndex()
	{
		return 0;
	}
	
	@Override
	public Instruction setVariableIndex(int idx)
	{
		return new FStore(this.getInstructions(), idx);
	}

	@Override
	public boolean store()
	{
		return true;
	}
	
	@Override
	public Instruction makeGeneric()
	{
		return new FStore(this.getInstructions(), 0);
	}
}
