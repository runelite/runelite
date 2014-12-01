package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;

public abstract class PoolEntry
{
	private ConstantPool pool;
	private ConstantType type;

	protected PoolEntry(ConstantPool pool, ConstantType type)
	{
		this.pool = pool;
		this.type = type;
	}

	public int getSlots()
	{
		return 1;
	}
}
