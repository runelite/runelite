package net.runelite.asm.attributes.code.instruction.types;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.pool.PoolEntry;

public interface PushConstantInstruction
{
	public PoolEntry getConstant();
	
	public Instruction setConstant(PoolEntry entry);
}
