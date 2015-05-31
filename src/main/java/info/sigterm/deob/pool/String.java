package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.execution.Type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class String extends PoolEntry
{
	private int stringIndex;
	private java.lang.String string;

	public String(ConstantPool pool) throws IOException
	{
		super(pool, ConstantType.STRING);

		DataInputStream is = pool.getClassFile().getStream();

		stringIndex = is.readUnsignedShort();
	}
	
	public String(ConstantPool pool, java.lang.String str)
	{
		super(pool, ConstantType.STRING);
		
		string = str;
	}
	
	@Override
	public void resolve()
	{
		string = this.getPool().getUTF8(stringIndex);
	}
	
	@Override
	public void prime()
	{
		stringIndex = this.getPool().makeUTF8(string);
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
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(stringIndex);
	}
}
