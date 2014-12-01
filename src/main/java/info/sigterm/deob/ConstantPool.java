package info.sigterm.deob;

import info.sigterm.deob.pool.ConstantType;
import info.sigterm.deob.pool.PoolEntry;

import java.io.DataInputStream;
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

				for (int j = 1; j < entry.getSlots(); ++j)
				{
					pool[i + 1] = entry;
					++i;
				}
			}
			catch (Exception e)
			{
				throw new IOException(e);
			}
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
}
