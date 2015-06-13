package info.sigterm.deob.attributes.code.instruction.types;

import info.sigterm.deob.attributes.code.Instruction;

public interface LVTInstruction
{
	public int getVariableIndex();
	
	public Instruction setVariableIndex(int idx);
	
	public boolean store();
}
