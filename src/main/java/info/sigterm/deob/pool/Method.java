package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Method extends PoolEntry
{
	private int classIndex;
	private int nameAndTypeIndex;

	public Method(ConstantPool pool) throws IOException
	{
		super(pool, ConstantType.METHODREF);

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

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(classIndex);
		out.writeShort(nameAndTypeIndex);
	}
}
