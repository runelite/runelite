package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;

import java.io.DataInputStream;
import java.io.IOException;

public class Field extends PoolEntry
{
	private int classIndex;
	private int nameAndTypeIndex;

	public Field(ConstantPool pool) throws IOException
	{
		super(pool, ConstantType.FIELDREF);

		DataInputStream is = pool.getClassFile().getStream();

		classIndex = is.readUnsignedShort();
		nameAndTypeIndex = is.readUnsignedShort();
	}
}
