package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;

import java.io.DataInputStream;
import java.io.IOException;

public class InterfaceMethod extends PoolEntry
{
	private int classIndex;
	private int nameAndTypeIndex;

	public InterfaceMethod(ConstantPool pool) throws IOException
	{
		super(pool, ConstantType.INTERFACE_METHOD_REF);

		DataInputStream is = pool.getClassFile().getStream();

		classIndex = is.readUnsignedShort();
		nameAndTypeIndex = is.readUnsignedShort();
	}
}
