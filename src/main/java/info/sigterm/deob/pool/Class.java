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

	public java.lang.String getName()
	{
		UTF8 u = (UTF8) this.getPool().getEntry(index);
		return u.getValue();
	}
}
