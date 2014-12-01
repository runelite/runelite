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

	public Class getClassEntry()
	{
		return (Class) this.getPool().getEntry(classIndex);
	}

	public NameAndType getNameAndType()
	{
		return (NameAndType) this.getPool().getEntry(nameAndTypeIndex);
	}
}
