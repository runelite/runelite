package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Double extends PoolEntry
{
	private double value;

	public Double(ConstantPool pool) throws IOException
	{
		super(pool, ConstantType.DOUBLE);

		DataInputStream is = pool.getClassFile().getStream();

		value = is.readDouble();
	}
	
	public Double(ConstantPool pool, double d)
	{
		super(pool, ConstantType.DOUBLE);
		
		value = d;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Double))
			return false;
		
		Double d = (Double) other;
		return value == d.value;
	}

	@Override
	public int getSlots()
	{
		return 2;
	}

	@Override
	public Object getObject()
	{
		return value;
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeDouble(value);
	}
}
