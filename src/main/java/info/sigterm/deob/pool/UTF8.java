package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class UTF8 extends PoolEntry
{
	private StringBuilder sb = new StringBuilder();

	public UTF8(ConstantPool pool) throws IOException
	{
		super(pool, ConstantType.UTF8);

		DataInputStream ios = pool.getClassFile().getStream();

		short length = ios.readShort();
		for (int i = 0; i < length; i++)
		{
			int a = ios.read();
			if ((a & 0x80) == 0)
			{
				sb.append((char)a);
			}
			else if ((a & 0x20) == 0)
			{
				int b = ios.read();
				char c = (char)(((a & 0x1f) << 6) + (b & 0x3f));
				sb.append(c);
				i++;
			}
			else
			{
				int b = ios.read();
				int c = ios.read();
				char ch = (char)(((a & 0xf) << 12) + ((b & 0x3f) << 6) + (c & 0x3f));
				sb.append(ch);
				i += 2;
			}
		}
	}

	public java.lang.String getValue()
	{
		return (java.lang.String) getObject();
	}
	
	@Override
	public Object getObject()
	{
		return sb.toString();
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		java.lang.String s = getValue();
		byte[] bytes = s.getBytes("UTF-8");
		
		out.writeShort(bytes.length);
		out.write(bytes);
	}
}
