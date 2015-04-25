package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;

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

	@Override
	public int getSlots()
	{
		return 2;
	}

	@Override
	public Object getObject()
	{
		return value;
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeLong(value);
	}
}
