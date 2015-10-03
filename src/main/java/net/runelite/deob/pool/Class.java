package net.runelite.deob.pool;

import net.runelite.deob.ConstantPool;
import net.runelite.deob.execution.Type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Class extends PoolEntry
{
	private int index;
	private java.lang.String name;

	public Class(ConstantPool pool, DataInputStream is) throws IOException
	{
		super(ConstantType.CLASS);

		index = is.readUnsignedShort();
	}
	
	public Class(java.lang.String name)
	{
		super(ConstantType.CLASS);
		
		this.name = name;
	}
	
	public Class(java.lang.String name, int dimms)
	{
		super(ConstantType.CLASS);
		
		while (dimms-- > 0)
			name = "[" + name;
		
		this.name = name;
	}
	
	@Override
	public void resolve(ConstantPool pool)
	{
		name = pool.getUTF8(index);
	}
	
	@Override
	public void prime(ConstantPool pool)
	{
		index = pool.makeUTF8(name);
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Class))
			return false;
		
		Class c = (Class) other;
		return name.equals(c.name);
	}
	
	@Override
	public int hashCode()
	{
		return name.hashCode();
	}

	public java.lang.String getName()
	{
		return name;
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(index);
	}
	
	@Override
	public Type getTypeClass()
	{
		return new Type(name);
	}
}
