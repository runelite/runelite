package net.runelite.deob.attributes.code.instruction.types;

import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.pool.PoolEntry;

public interface PushConstantInstruction
{
	public PoolEntry getConstant();
	
	public Instruction setConstant(PoolEntry entry);
}
