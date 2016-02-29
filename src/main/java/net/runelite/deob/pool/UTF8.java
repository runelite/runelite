package net.runelite.deob.pool;

import net.runelite.deob.ConstantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

public class UTF8 extends PoolEntry
{
	private java.lang.String string;

	public UTF8(ConstantPool pool, DataInputStream is) throws IOException
	{
		super(ConstantType.UTF8);

		string = is.readUTF();
	}
	
	public UTF8(java.lang.String value)
	{
		super(ConstantType.UTF8);
		
		string = value;
	}

	@Override
	public UTF8 copy()
	{
		return new UTF8(string);
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof UTF8))
			return false;
		
		UTF8 u = (UTF8) other;
		return string.equals(u.string);
	}

	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 29 * hash + Objects.hashCode(this.string);
		return hash;
	}

	public java.lang.String getValue()
	{
		return string;
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		java.lang.String s = getValue();
		out.writeUTF(s);
	}
	
	@Override
	public Object getObject()
	{
		return string;
	}
}
