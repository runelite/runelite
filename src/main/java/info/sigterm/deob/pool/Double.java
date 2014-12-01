package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;

import java.io.DataInputStream;
import java.io.IOException;

public class Double extends PoolEntry
{
	private double value;

	public Double(ConstantPool pool) throws IOException
	{
		super(pool, ConstantType.DOUBLE);

		DataInputStream is = pool.getClassFile().getStream();

		value = is.readDouble();
	}

	@Override
	public int getSlots()
	{
		return 2;
	}
}
