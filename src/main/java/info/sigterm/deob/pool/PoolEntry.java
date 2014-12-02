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

	public ConstantPool getPool()
	{
		return pool;
	}

	public int getSlots()
	{
		return 1;
	}

	public Object getObject()
	{
		throw new RuntimeException("No getObject implemented for " + this);
	}
}
