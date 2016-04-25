package net.runelite.asm.pool;

import net.runelite.asm.ConstantPool;
import net.runelite.asm.execution.Type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Long extends PoolEntry
{
	private long value;

	public Long(ConstantPool pool, DataInputStream is) throws IOException
	{
		super(ConstantType.LONG);

		value = is.readLong();
	}
	
	public Long(long l)
	{
		super(ConstantType.LONG);
		
		value = l;
	}

	@Override
	public Long copy()
	{
		return new Long(value);
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Long))
			return false;
		
		Long l = (Long) other;
		return value == l.value;
	}

	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 37 * hash + (int) (this.value ^ (this.value >>> 32));
		return hash;
	}

	@Override
	public int getSlots()
	{
		return 2;
	}

	@Override
	public Type getTypeClass()
	{
		return new Type(long.class.getCanonicalName());
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeLong(value);
	}
	
	@Override
	public Object getObject()
	{
		return value;
	}
}
