package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class UTF8 extends PoolEntry
{
	private java.lang.String string;

	public UTF8(ConstantPool pool) throws IOException
	{
		super(ConstantType.UTF8);

		DataInputStream ios = pool.getClassFile().getStream();
		string = ios.readUTF();
	}
	
	public UTF8(java.lang.String value)
	{
		super(ConstantType.UTF8);
		
		string = value;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof UTF8))
			return false;
		
		UTF8 u = (UTF8) other;
		return string.equals(u.string);
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
}
