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


public class IStore_3 extends Instruction implements LVTInstruction
{
	public IStore_3(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	public IStore_3(Instructions instructions)
	{
		super(instructions, InstructionType.ISTORE_3, -1);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		Variables variables = frame.getVariables();
		
		StackContext value = stack.pop();
		assert value.getType().isInt();
		ins.pop(value);
		
		variables.set(3, new VariableContext(ins, value));
		
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
		return new IStore(this.getInstructions(), idx);
	}

	@Override
	public boolean store()
	{
		return true;
	}
	
	@Override
	public Instruction makeGeneric()
	{
		return new IStore(this.getInstructions(), 3);
	}
}
