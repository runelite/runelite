package net.runelite.asm.attributes.code.instruction.types;

import net.runelite.asm.attributes.code.Instruction;

public interface LVTInstruction
{
	public int getVariableIndex();
	
	public Instruction setVariableIndex(int idx);
	
	public boolean store();
}
