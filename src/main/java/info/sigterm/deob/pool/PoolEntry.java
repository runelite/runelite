package info.sigterm.deob.pool;

import java.io.DataOutputStream;
import java.io.IOException;

import info.sigterm.deob.ConstantPool;

public abstract class PoolEntry
{
	public ConstantPool pool;
	private ConstantType type;
	public int id;

	protected PoolEntry(ConstantPool pool, ConstantType type)
	{
		this.pool = pool;
		this.type = type;
	}
	
	// read objects from indexes
	public void resolve()
	{
	}
	
	// make objects and prime indexes
	public void prime()
	{
	}
	
	public abstract boolean equals(Object other);
	
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
		return this;
	}
}
