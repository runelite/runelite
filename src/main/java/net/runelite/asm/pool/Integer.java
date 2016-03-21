package net.runelite.asm.pool;

import net.runelite.asm.ConstantPool;
import net.runelite.asm.execution.Type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Integer extends PoolEntry
{
	private int value;

	public Integer(ConstantPool pool, DataInputStream is) throws IOException
	{
		super(ConstantType.INTEGER);

		value = is.readInt();
	}
	
	public Integer(int i)
	{
		super(ConstantType.INTEGER);
		
		value = i;
	}

	@Override
	public Integer copy()
	{
		return new Integer(value);
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Integer))
			return false;
		
		Integer i = (Integer) other;
		return value == i.value;
	}

	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 97 * hash + this.value;
		return hash;
	}
	
	@Override
	public java.lang.String toString()
	{
		return "" + value;
	}

	@Override
	public Type getTypeClass()
	{
		return new Type(int.class.getCanonicalName());
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeInt(value);
	}
	
	@Override
	public Object getObject()
	{
		return value;
	}
}
