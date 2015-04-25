package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Float extends PoolEntry
{
	private float value;

	public Float(ConstantPool pool) throws IOException
	{
		super(pool, ConstantType.FLOAT);

		DataInputStream is = pool.getClassFile().getStream();

		value = is.readFloat();
	}

	@Override
	public Object getObject()
	{
		return value;
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeFloat(value);
	}
}
