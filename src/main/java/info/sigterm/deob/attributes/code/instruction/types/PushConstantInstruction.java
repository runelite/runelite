package info.sigterm.deob.attributes.code.instruction.types;

import info.sigterm.deob.pool.PoolEntry;

public interface PushConstantInstruction
{
	public PoolEntry getConstant();
	
	public void setConstant(PoolEntry entry);
}
