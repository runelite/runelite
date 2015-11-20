package net.runelite.deob.pool;

import net.runelite.deob.ConstantPool;
import net.runelite.deob.execution.Type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Double extends PoolEntry
{
	private double value;

	public Double(ConstantPool pool, DataInputStream is) throws IOException
	{
		super(ConstantType.DOUBLE);

		value = is.readDouble();
	}
	
	public Double(double d)
	{
		super(ConstantType.DOUBLE);
		
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
	public int hashCode()
	{
		int hash = 5;
		hash = 79 * hash + (int) (java.lang.Double.doubleToLongBits(this.value) ^ (java.lang.Double.doubleToLongBits(this.value) >>> 32));
		return hash;
	}

	@Override
	public int getSlots()
	{
		return 2;
	}

	@Override
	public Type getTypeClass()
	{
		return new Type(double.class.getCanonicalName());
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeDouble(value);
	}
	
	@Override
	public Object getObject()
	{
		return value;
	}
}
