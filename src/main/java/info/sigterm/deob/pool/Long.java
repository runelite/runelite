package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.execution.Type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Long extends PoolEntry
{
	private long value;

	public Long(ConstantPool pool) throws IOException
	{
		super(pool, ConstantType.LONG);

		DataInputStream is = pool.getClassFile().getStream();

		value = is.readLong();
	}
	
	public Long(ConstantPool pool, long l)
	{
		super(pool, ConstantType.LONG);
		
		value = l;
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
}
