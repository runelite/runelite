package info.sigterm.deob;

import info.sigterm.deob.attributes.code.instructions.Return;
import info.sigterm.deob.pool.ConstantType;
import info.sigterm.deob.pool.PoolEntry;
import info.sigterm.deob.pool.UTF8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;

public class ConstantPool
{
	private ClassFile classFile;

	private int count;
	private PoolEntry pool[];

	ConstantPool(ClassFile c) throws IOException
	{
		classFile = c;

		DataInputStream is = c.getStream();

		count = is.readUnsignedShort();
		pool = new PoolEntry[count];

		for (int i = 1; i < count; ++i)
		{
			byte typeCode = is.readByte();

			ConstantType type = ConstantType.findFromType(typeCode);

			try
			{
				Constructor<? extends PoolEntry> con = type.getPoolClass().getConstructor(new Class[] { ConstantPool.class });
				PoolEntry entry = con.newInstance(this);

				pool[i] = entry;
				i += entry.getSlots() - 1;
			}
			catch (Exception e)
			{
				throw new IOException(e);
			}
		}
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(count);
		for (int i = 1; i < count; ++i)
		{
			PoolEntry entry = pool[i];
			if (entry == null)
				continue;
			out.writeByte(entry.getType().getType());
			entry.write(out);
		}
	}

	public ClassFile getClassFile()
	{
		return classFile;
	}

	public PoolEntry getEntry(int index)
	{
		return pool[index];
	}
	
	public int findUTF8Index(String s)
	{
		for (int i = 1; i < count; ++i)
		{
			PoolEntry entry = pool[i];
			if (entry instanceof UTF8)
			{
				UTF8 u = (UTF8) entry;
				if (s.equals(u.getValue()))
				{
					return i;
				}
			}
		}
		
		return -1;
	}
}
