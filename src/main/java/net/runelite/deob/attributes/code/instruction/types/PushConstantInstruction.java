package net.runelite.deob.attributes.code.instruction.types;

import net.runelite.deob.pool.PoolEntry;

public interface PushConstantInstruction
{
	public PoolEntry getConstant();
	
	public void setConstant(PoolEntry entry);
}
