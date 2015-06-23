package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.execution.Type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Class extends PoolEntry
{
	private int index;
	private java.lang.String name;

	public Class(ConstantPool pool) throws IOException
	{
		super(pool, ConstantType.CLASS);

		DataInputStream is = pool.getClassFile().getStream();
		index = is.readUnsignedShort();
	}
	
	@Override
	public void resolve()
	{
		name = this.getPool().getUTF8(index);
	}
	
	@Override
	public void prime()
	{
		index = this.getPool().makeUTF8(name);
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
