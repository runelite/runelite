package net.runelite.deob.attributes.code.instruction.types;

import net.runelite.deob.attributes.code.Instruction;

public interface LVTInstruction
{
	public int getVariableIndex();
	
	public Instruction setVariableIndex(int idx);
	
	public boolean store();
}
