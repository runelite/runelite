package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;

import java.io.DataInputStream;
import java.io.IOException;

public class Integer extends PoolEntry
{
	private int value;

	public Integer(ConstantPool pool) throws IOException
	{
		super(pool, ConstantType.INTEGER);

		DataInputStream is = pool.getClassFile().getStream();

		value = is.readInt();
	}

	@Override
	public Object getObject()
	{
		return value;
	}
}
