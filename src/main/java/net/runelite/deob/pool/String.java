package net.runelite.deob.pool;

import net.runelite.deob.ConstantPool;
import net.runelite.deob.execution.Type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

public class String extends PoolEntry
{
	private int stringIndex;
	private java.lang.String string;

	public String(ConstantPool pool, DataInputStream is) throws IOException
	{
		super(ConstantType.STRING);

		stringIndex = is.readUnsignedShort();
	}
	
	public String(java.lang.String str)
	{
		super(ConstantType.STRING);
		
		string = str;
	}

	@Override
	public String copy()
	{
		return new String(string);
	}
	
	@Override
	public void resolve(ConstantPool pool)
	{
		string = pool.getUTF8(stringIndex);
	}
	
	@Override
	public void prime(ConstantPool pool)
	{
		stringIndex = pool.makeUTF8(string);
	}
	
	@Override
	public Type getTypeClass()
	{
		return new Type(java.lang.String.class.getCanonicalName());
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof String))
			return false;
		
		String s = (String) other;
		return string.equals(s.string);
	}

	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 83 * hash + Objects.hashCode(this.string);
		return hash;
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(stringIndex);
	}

	@Override
	public Object getObject()
	{
		return string;
	}
}
