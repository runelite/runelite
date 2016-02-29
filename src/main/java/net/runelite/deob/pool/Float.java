package net.runelite.deob.pool;

import net.runelite.deob.ConstantPool;
import net.runelite.deob.execution.Type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Float extends PoolEntry
{
	private float value;

	public Float(ConstantPool pool, DataInputStream is) throws IOException
	{
		super(ConstantType.FLOAT);

		value = is.readFloat();
	}
	
	public Float(float f)
	{
		super(ConstantType.FLOAT);
		
		value = f;
	}

	@Override
	public Float copy()
	{
		return new Float(value);
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Float))
			return false;
		
		Float f = (Float) other;
		return value == f.value;
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 37 * hash + java.lang.Float.floatToIntBits(this.value);
		return hash;
	}

	@Override
	public Type getTypeClass()
	{
		return new Type(float.class.getCanonicalName());
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeFloat(value);
	}
	
	@Override
	public Object getObject()
	{
		return value;
	}
}
