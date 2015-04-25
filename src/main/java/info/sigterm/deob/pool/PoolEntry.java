package info.sigterm.deob.pool;

import java.io.DataOutputStream;
import java.io.IOException;

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
	
	public abstract void write(DataOutputStream out) throws IOException;

	public ConstantPool getPool()
	{
		return pool;
	}
	
	public ConstantType getType()
	{
		return type;
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
