package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class String extends PoolEntry
{
	private int stringIndex;

	public String(ConstantPool pool) throws IOException
	{
		super(pool, ConstantType.STRING);

		DataInputStream is = pool.getClassFile().getStream();

		stringIndex = is.readUnsignedShort();
	}

	@Override
	public Object getObject()
	{
		return this.getPool().getEntry(stringIndex).getObject();
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(stringIndex);
	}
}
