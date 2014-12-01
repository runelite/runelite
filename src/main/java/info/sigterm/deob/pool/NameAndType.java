package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;

import java.io.DataInputStream;
import java.io.IOException;

public class NameAndType extends PoolEntry
{
	private int nameIndex;
	private int descriptorIndex;

	public NameAndType(ConstantPool pool) throws IOException
	{
		super(pool, ConstantType.NAME_AND_TYPE);

		DataInputStream is = pool.getClassFile().getStream();

		nameIndex = is.readUnsignedShort();
		descriptorIndex = is.readUnsignedShort();
	}
}
