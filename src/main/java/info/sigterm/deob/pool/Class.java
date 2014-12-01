package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;

import java.io.DataInputStream;
import java.io.IOException;

public class Class extends PoolEntry
{
	private int index;

	public Class(ConstantPool pool) throws IOException
	{
		super(pool, ConstantType.CLASS);

		DataInputStream is = pool.getClassFile().getStream();
		index = is.readUnsignedShort();
	}

	public int getIndex()
	{
		return index;
	}
}
